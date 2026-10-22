package com.android.server.usage;

import android.app.usage.ConfigurationStats;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.res.Configuration;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import com.android.server.am.AssistDataRequester;
import com.android.server.pm.Settings;
import java.io.IOException;
import java.net.ProtocolException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
final class UsageStatsXmlV1 {
    private static final String ACTIVE_ATTR = "active";
    private static final String APP_LAUNCH_COUNT_ATTR = "appLaunchCount";
    private static final String CATEGORY_TAG = "category";
    private static final String CHOOSER_COUNT_TAG = "chosen_action";
    private static final String CLASS_ATTR = "class";
    private static final String CONFIGURATIONS_TAG = "configurations";
    private static final String CONFIG_TAG = "config";
    private static final String COUNT = "count";
    private static final String COUNT_ATTR = "count";
    private static final String END_TIME_ATTR = "endTime";
    private static final String EVENT_LOG_TAG = "event-log";
    private static final String EVENT_TAG = "event";
    private static final String FLAGS_ATTR = "flags";
    private static final String INSTANCE_ID_ATTR = "instanceId";
    private static final String INTERACTIVE_TAG = "interactive";
    private static final String KEYGUARD_HIDDEN_TAG = "keyguard-hidden";
    private static final String KEYGUARD_SHOWN_TAG = "keyguard-shown";
    private static final String LAST_EVENT_ATTR = "lastEvent";
    private static final String LAST_TIME_ACTIVE_ATTR = "lastTimeActive";
    private static final String LAST_TIME_SERVICE_USED_ATTR = "lastTimeServiceUsed";
    private static final String LAST_TIME_VISIBLE_ATTR = "lastTimeVisible";
    private static final String MAJOR_VERSION_ATTR = "majorVersion";
    private static final String MINOR_VERSION_ATTR = "minorVersion";
    private static final String NAME = "name";
    private static final String NON_INTERACTIVE_TAG = "non-interactive";
    private static final String NOTIFICATION_CHANNEL_ATTR = "notificationChannel";
    private static final String PACKAGES_TAG = "packages";
    private static final String PACKAGE_ATTR = "package";
    private static final String PACKAGE_TAG = "package";
    private static final String SHORTCUT_ID_ATTR = "shortcutId";
    private static final String STANDBY_BUCKET_ATTR = "standbyBucket";
    private static final String TAG = "UsageStatsXmlV1";
    private static final String TIME_ATTR = "time";
    private static final String TOTAL_TIME_ACTIVE_ATTR = "timeActive";
    private static final String TOTAL_TIME_SERVICE_USED_ATTR = "timeServiceUsed";
    private static final String TOTAL_TIME_VISIBLE_ATTR = "timeVisible";
    private static final String TYPE_ATTR = "type";

    private static void loadUsageStats(XmlPullParser parser, IntervalStats statsOut) throws XmlPullParserException, IOException {
        String pkg = parser.getAttributeValue(null, Settings.ATTR_PACKAGE);
        if (pkg == null) goto L39;
        UsageStats stats = statsOut.getOrCreateUsageStats(pkg);
        stats.mLastTimeUsed = statsOut.beginTime + XmlUtils.readLongAttribute(parser, LAST_TIME_ACTIVE_ATTR);
        stats.mLastTimeVisible = statsOut.beginTime + XmlUtils.readLongAttribute(parser, LAST_TIME_VISIBLE_ATTR);     // Catch: IOException -> L7
    L46:
        stats.mLastTimeForegroundServiceUsed = statsOut.beginTime + XmlUtils.readLongAttribute(parser, LAST_TIME_SERVICE_USED_ATTR);     // Catch: IOException -> L11
    L13:
        stats.mTotalTimeInForeground = XmlUtils.readLongAttribute(parser, TOTAL_TIME_ACTIVE_ATTR);
        stats.mTotalTimeVisible = XmlUtils.readLongAttribute(parser, TOTAL_TIME_VISIBLE_ATTR);     // Catch: IOException -> L16
    L42:
        stats.mTotalTimeForegroundServiceUsed = XmlUtils.readLongAttribute(parser, TOTAL_TIME_SERVICE_USED_ATTR);     // Catch: IOException -> L20
    L22:
        stats.mLastEvent = XmlUtils.readIntAttribute(parser, LAST_EVENT_ATTR);
        stats.mAppLaunchCount = XmlUtils.readIntAttribute(parser, APP_LAUNCH_COUNT_ATTR, 0);
    L23:
        int eventCode = parser.next();
        if (eventCode == 1) goto L37;
        String tag = parser.getName();
        if (eventCode != 3) goto L31;
        if (tag.equals(Settings.ATTR_PACKAGE) == false) goto L31;
        return;
    L31:
        if (eventCode != 2) goto L23;
        if (tag.equals(CHOOSER_COUNT_TAG) == false) goto L23;
        String action = XmlUtils.readStringAttribute(parser, "name");
        loadChooserCounts(parser, stats, action);
        goto L23
    L37:
        return;
    L21:
        Log.i(TAG, "Failed to parse mTotalTimeForegroundServiceUsed");
    L17:
        Log.i(TAG, "Failed to parse mTotalTimeVisible");
    L12:
        Log.i(TAG, "Failed to parse mLastTimeForegroundServiceUsed");
    L8:
        Log.i(TAG, "Failed to parse mLastTimeVisible");
        goto L46
    L39:
        throw new ProtocolException("no package attribute present");
    }

    private static void loadCountAndTime(XmlPullParser parser, IntervalStats.EventTracker tracker) throws IOException, XmlPullParserException {
        tracker.count = XmlUtils.readIntAttribute(parser, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, 0);
        tracker.duration = XmlUtils.readLongAttribute(parser, TIME_ATTR, 0);
        XmlUtils.skipCurrentTag(parser);
    }

    private static void loadChooserCounts(XmlPullParser parser, UsageStats usageStats, String action) throws XmlPullParserException, IOException {
        if (action != null) goto L5;
        return;
    L5:
        if (usageStats.mChooserCounts != null) goto L8;
        usageStats.mChooserCounts = new ArrayMap();
    L8:
        if (usageStats.mChooserCounts.containsKey(action) == true) goto L10;
        ArrayMap<String, Integer> counts = new ArrayMap();
        usageStats.mChooserCounts.put(action, counts);
    L10:
        int eventCode = parser.next();
        if (eventCode == 1) goto L24;
        String tag = parser.getName();
        if (eventCode != 3) goto L18;
        if (tag.equals(CHOOSER_COUNT_TAG) == false) goto L18;
        return;
    L18:
        if (eventCode != 2) goto L10;
        if (tag.equals(CATEGORY_TAG) == false) goto L10;
        String category = XmlUtils.readStringAttribute(parser, "name");
        int count = XmlUtils.readIntAttribute(parser, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT);
        ((ArrayMap) usageStats.mChooserCounts.get(action)).put(category, Integer.valueOf(count));
        goto L10
    }

    private static void loadConfigStats(XmlPullParser parser, IntervalStats statsOut) throws XmlPullParserException, IOException {
        Configuration config = new Configuration();
        Configuration.readXmlAttrs(parser, config);
        ConfigurationStats configStats = statsOut.getOrCreateConfigurationStats(config);
        configStats.mLastTimeActive = statsOut.beginTime + XmlUtils.readLongAttribute(parser, LAST_TIME_ACTIVE_ATTR);
        configStats.mTotalTimeActive = XmlUtils.readLongAttribute(parser, TOTAL_TIME_ACTIVE_ATTR);
        configStats.mActivationCount = XmlUtils.readIntAttribute(parser, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT);
        if (XmlUtils.readBooleanAttribute(parser, "active") == false) goto L6;
        statsOut.activeConfiguration = configStats.mConfiguration;
        return;
    }

    private static void loadEvent(XmlPullParser parser, IntervalStats statsOut) throws XmlPullParserException, IOException {
        String packageName = XmlUtils.readStringAttribute(parser, Settings.ATTR_PACKAGE);
        if (packageName == null) goto L25;
        String className = XmlUtils.readStringAttribute(parser, CLASS_ATTR);
        UsageEvents.Event event = statsOut.buildEvent(packageName, className);
        event.mFlags = XmlUtils.readIntAttribute(parser, FLAGS_ATTR, 0);
        event.mTimeStamp = statsOut.beginTime + XmlUtils.readLongAttribute(parser, TIME_ATTR);
        event.mEventType = XmlUtils.readIntAttribute(parser, "type");
        event.mInstanceId = XmlUtils.readIntAttribute(parser, INSTANCE_ID_ATTR);     // Catch: IOException -> L7
    L9:
        String r5 = null;
        switch(event.mEventType) {
            case 5: goto L21;
            case 8: goto L17;
            case 11: goto L16;
            case 12: goto L12;
            default: goto L22;
        };
    L12:
        String channelId = XmlUtils.readStringAttribute(parser, NOTIFICATION_CHANNEL_ATTR);
        if (channelId == null) goto L15;
        r5 = channelId.intern();
    L15:
        event.mNotificationChannelId = r5;
        goto L22
    L16:
        event.mBucketAndReason = XmlUtils.readIntAttribute(parser, STANDBY_BUCKET_ATTR, 0);
        goto L22
    L17:
        String id = XmlUtils.readStringAttribute(parser, SHORTCUT_ID_ATTR);
        if (id == null) goto L20;
        r5 = id.intern();
    L20:
        event.mShortcutId = r5;
        goto L22
    L21:
        event.mConfiguration = new Configuration();
        Configuration.readXmlAttrs(parser, event.mConfiguration);
    L22:
        statsOut.addEvent(event);
        return;
    L8:
        Log.i(TAG, "Failed to parse mInstanceId");
        goto L9
    L25:
        throw new ProtocolException("no package attribute present");
    }

    public static void read(XmlPullParser parser, IntervalStats statsOut) throws XmlPullParserException, IOException {
        statsOut.packageStats.clear();
        statsOut.configurations.clear();
        statsOut.activeConfiguration = null;
        statsOut.events.clear();
        statsOut.endTime = statsOut.beginTime + XmlUtils.readLongAttribute(parser, END_TIME_ATTR);
        statsOut.majorVersion = XmlUtils.readIntAttribute(parser, MAJOR_VERSION_ATTR);     // Catch: IOException -> L5
    L57:
        statsOut.minorVersion = XmlUtils.readIntAttribute(parser, MINOR_VERSION_ATTR);     // Catch: IOException -> L9
    L11:
        int outerDepth = parser.getDepth();
    L12:
        int eventCode = parser.next();
        byte r3 = 1;
        if (eventCode == 1) goto L81;
        if (eventCode != 3) goto L19;
        if (parser.getDepth() > outerDepth) goto L19;
        return;
    L19:
        if (eventCode != 2) goto L12;
        String tag = parser.getName();
        switch(tag.hashCode()) {
            case -1354792126: goto L43;
            case -1169351247: goto L40;
            case -807157790: goto L37;
            case -807062458: goto L34;
            case 96891546: goto L31;
            case 526608426: goto L28;
            case 1844104930: goto L25;
            default: goto L45;
        };
    L45:
        r3 = -1;
    L46:
        switch(r3) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            default: goto L12;
        };
    L48:
        loadEvent(parser, statsOut);
        goto L12
    L49:
        loadConfigStats(parser, statsOut);
        goto L12
    L50:
        loadUsageStats(parser, statsOut);
        goto L12
    L51:
        loadCountAndTime(parser, statsOut.keyguardHiddenTracker);
        goto L12
    L52:
        loadCountAndTime(parser, statsOut.keyguardShownTracker);
        goto L12
    L53:
        loadCountAndTime(parser, statsOut.nonInteractiveTracker);
        goto L12
    L54:
        loadCountAndTime(parser, statsOut.interactiveTracker);
        goto L12
    L25:
        if (tag.equals(INTERACTIVE_TAG) == false) goto L45;
        r3 = 0;
        goto L46
    L28:
        if (tag.equals(KEYGUARD_SHOWN_TAG) == false) goto L45;
        r3 = 2;
        goto L46
    L31:
        if (tag.equals(EVENT_TAG) == false) goto L45;
        r3 = 6;
        goto L46
    L34:
        if (tag.equals(Settings.ATTR_PACKAGE) == false) goto L45;
        r3 = 4;
        goto L46
    L37:
        if (tag.equals(NON_INTERACTIVE_TAG) == false) goto L45;
    L40:
        if (tag.equals(KEYGUARD_HIDDEN_TAG) == false) goto L45;
        r3 = 3;
        goto L46
    L43:
        if (tag.equals(CONFIG_TAG) == false) goto L45;
        r3 = 5;
        goto L46
    L81:
        return;
    L10:
        Log.i(TAG, "Failed to parse minorVersion");
    L6:
        Log.i(TAG, "Failed to parse majorVersion");
        goto L57
    }

    private UsageStatsXmlV1() {
    }
}
