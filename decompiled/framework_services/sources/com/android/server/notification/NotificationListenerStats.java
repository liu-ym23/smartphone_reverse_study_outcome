package com.android.server.notification;

import android.util.SparseIntArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.PrintWriter;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class NotificationListenerStats {
    private static final String ATT_OWNED_CHANNEL_COUNT = "channelCount";
    private static final String ATT_UID = "uid";
    private static final int MAX_CHANNELS = 5000;
    private static final String TAG_NLS = "nls";
    private static final String TAG_STATS = "nlsStats";
    private final SparseIntArray mChannelsCreated;
    private final Object mLock;
    private final int mMaxChannelsAllowed;

    NotificationListenerStats() {
        this(5000);
    }

    NotificationListenerStats(int maxChannelsAllowed) {
        this.mLock = new Object();
        this.mChannelsCreated = new SparseIntArray();
        this.mMaxChannelsAllowed = maxChannelsAllowed;
    }

    boolean isAllowedToCreateChannel(ManagedServices.ManagedServiceInfo nls) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int numCreated = this.mChannelsCreated.get(nls.uid);     // Catch: Throwable -> L10
        if (numCreated >= this.mMaxChannelsAllowed) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    void logCreatedChannels(ManagedServices.ManagedServiceInfo nls, int increase) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int prevCreated = this.mChannelsCreated.get(nls.uid);     // Catch: Throwable -> L7
        this.mChannelsCreated.put(nls.uid, prevCreated + increase);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onPackageRemoved(int uid, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mChannelsCreated.delete(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static boolean isXmlTag(String tag) {
        return TAG_STATS.equals(tag);
    }

    void writeXml(TypedXmlSerializer out) throws IOException {
        out.startTag(null, TAG_STATS);
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L16:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mChannelsCreated.size()) goto L11;
        out.startTag(null, TAG_NLS);     // Catch: Throwable -> L8
        out.attributeInt(null, "uid", this.mChannelsCreated.keyAt(i));     // Catch: Throwable -> L8
        out.attributeInt(null, ATT_OWNED_CHANNEL_COUNT, this.mChannelsCreated.valueAt(i));     // Catch: Throwable -> L8
        out.endTag(null, TAG_NLS);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        out.endTag(null, TAG_STATS);
    }

    void readXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() == 2) goto L6;
        return;
    L6:
        if (TAG_STATS.equals(parser.getName()) == true) goto L8;
        return;
    L8:
        Object r3 = this.mLock;
        monitor-enter(r3);
    L27:
        int type = parser.next();     // Catch: Throwable -> L17
        if (type == 1) goto L23;
        String tag = parser.getName();     // Catch: Throwable -> L17
        if (type == 3) goto L15;
    L19:
        if (type != 2) goto L27;
        if (TAG_NLS.equals(tag) == false) goto L27;
        int uid = parser.getAttributeInt(null, "uid", 0);     // Catch: Throwable -> L17
        int channelCount = parser.getAttributeInt(null, ATT_OWNED_CHANNEL_COUNT, 0);     // Catch: Throwable -> L17
        this.mChannelsCreated.put(uid, channelCount);     // Catch: Throwable -> L17
        goto L27
    L15:
        if (TAG_STATS.equals(tag) == false) goto L19;
    L23:
        monitor-exit(r3);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mChannelsCreated.size()) goto L11;
        pw.println(prefix + "NLS with uid " + this.mChannelsCreated.keyAt(i));     // Catch: Throwable -> L8
        pw.println(prefix + "  created channel count: " + this.mChannelsCreated.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
