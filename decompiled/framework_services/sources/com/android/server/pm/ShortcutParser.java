package com.android.server.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutParser {
    private static final boolean DEBUG = false;
    static final String METADATA_KEY = "android.app.shortcuts";
    private static final String TAG = "ShortcutService";
    private static final String TAG_CATEGORIES = "categories";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_DATA = "data";
    private static final String TAG_INTENT = "intent";
    private static final String TAG_SHARE_TARGET = "share-target";
    private static final String TAG_SHORTCUT = "shortcut";
    private static final String TAG_SHORTCUTS = "shortcuts";

    public ShortcutParser() {
    }

    public static List<ShortcutInfo> parseShortcuts(ShortcutService service, String packageName, int userId, List<ShareTargetInfo> outShareTargets) throws IOException, XmlPullParserException {
        List<ResolveInfo> activities = service.injectGetMainActivities(packageName, userId);
        if (activities == null) goto L32;
        if (activities.size() == 0) goto L32;
        outShareTargets.clear();
        int size = activities.size();     // Catch: RuntimeException -> L27
        int i = 0;
        List<ShortcutInfo> result = null;
    L10:
        if (i >= size) goto L26;
        ActivityInfo activityInfoNoMetadata = activities.get(i).activityInfo;     // Catch: RuntimeException -> L23
        if (activityInfoNoMetadata != null) goto L14;
        ShortcutService service2 = service;
        String packageName2 = packageName;
        int userId2 = userId;
        List<ShareTargetInfo> outShareTargets2 = outShareTargets;
    L22:
        i = i + 1;
        service = service2;
        packageName = packageName2;
        userId = userId2;
        outShareTargets = outShareTargets2;
        goto L10
    L14:
        ActivityInfo activityInfoWithMetadata = service.getActivityInfoWithMetadata(activityInfoNoMetadata.getComponentName(), userId);     // Catch: RuntimeException -> L23
        if (activityInfoWithMetadata == null) goto L21;
        service2 = service;
        packageName2 = packageName;
        userId2 = userId;
        outShareTargets2 = outShareTargets;
        result = parseShortcutsOneFile(service2, activityInfoWithMetadata, packageName2, userId2, result, outShareTargets2);     // Catch: RuntimeException -> L19
    L19:
        e = move-exception;
        RuntimeException e = e;
    L29:
        service2.wtf("Exception caught while parsing shortcut XML for package=" + packageName2, e);
        return null;
    L21:
        service2 = service;
        packageName2 = packageName;
        userId2 = userId;
        outShareTargets2 = outShareTargets;
    L23:
        e = move-exception;
        service2 = service;
        packageName2 = packageName;
        e = e;
        goto L29
    L26:
        return result;
    L27:
        e = move-exception;
        service2 = service;
        packageName2 = packageName;
        e = e;
    L32:
        return null;
    }

    private static List<ShortcutInfo> parseShortcutsOneFile(ShortcutService service, ActivityInfo activityInfo, String packageName, int userId, List<ShortcutInfo> result, List<ShareTargetInfo> outShareTargets) throws IOException, XmlPullParserException {
        XmlResourceParser parser = null;
        XmlResourceParser parser2 = service.injectXmlMetaData(activityInfo, METADATA_KEY);     // Catch: Throwable -> L177
        if (parser2 != null) goto L190;
        if (parser2 == null) goto L8;
        parser2.close();
    L8:
        return result;
    L190:
        ComponentName activity = new ComponentName(packageName, activityInfo.name);     // Catch: Throwable -> L175
        AttributeSet attrs = Xml.asAttributeSet(parser2);     // Catch: Throwable -> L175
        int maxShortcuts = service.getMaxActivityShortcuts();     // Catch: Throwable -> L175
        ArrayList<Intent> intents = new ArrayList();     // Catch: Throwable -> L175
        ArrayList<ShareTargetInfo.TargetData> dataList = new ArrayList();     // Catch: Throwable -> L175
        int rank = 0;
        ShortcutInfo si = null;
        Set<String> categories = null;
        int numShortcuts = 0;
        ShareTargetInfo currentShareTarget = null;
        List<ShortcutInfo> result2 = result;
    L186:
        int type = parser2.next();     // Catch: Throwable -> L18
        ShortcutInfo currentShortcut = si;
        if (type == 1) goto L173;
        if (type == 3) goto L16;
    L20:
        int depth = parser2.getDepth();     // Catch: Throwable -> L18
        String tag = parser2.getName();     // Catch: Throwable -> L18
        if (type != 3) goto L60;
        int depth2 = depth;
        AttributeSet attrs2 = attrs;
        if (depth2 != 2) goto L59;
        String tag2 = tag;
    L35:
        th = th;
        parser = parser2;
    L179:
        if (parser == null) goto L181;
        parser.close();
    L181:
        throw th;
    L27:
        if (TAG_SHORTCUT.equals(tag2) == true) goto L28;
    L62:
        if (type != 3) goto L85;
        if (depth2 != 2) goto L85;
    L79:
        th = th;
        parser = parser2;
        goto L179
    L66:
        if (TAG_SHARE_TARGET.equals(tag2) == false) goto L85;
        if (currentShareTarget == null) goto L58;
        ShareTargetInfo sti = currentShareTarget;
        if (categories == null) goto L82;
        if (categories.isEmpty() == true) goto L82;
        if (dataList.isEmpty() == true) goto L82;
        activity = activity;
        ShareTargetInfo currentShareTarget2 = null;
        rank = rank;
        ShareTargetInfo newShareTarget = new ShareTargetInfo((ShareTargetInfo.TargetData[]) dataList.toArray(new ShareTargetInfo.TargetData[dataList.size()]), sti.mTargetClass, (String[]) categories.toArray(new String[categories.size()]));     // Catch: Throwable -> L79
        outShareTargets.add(newShareTarget);     // Catch: Throwable -> L35
        dataList.clear();     // Catch: Throwable -> L35
        categories = null;
    L87:
        if (type != 2) goto L88;
        if (depth2 != 1) goto L95;
        if (TAG_SHORTCUTS.equals(tag2) == false) goto L95;
        activity = activity;
        attrs = attrs2;
        rank = rank;
        int maxShortcuts2 = maxShortcuts;
    L171:
        si = currentShortcut;
        maxShortcuts = maxShortcuts2;
        currentShareTarget = currentShareTarget2;
    L95:
        if (depth2 != 2) goto L112;
        if (TAG_SHORTCUT.equals(tag2) == false) goto L112;
        activity = activity;
        rank = rank;
        attrs = attrs2;
        maxShortcuts2 = maxShortcuts;
        ShortcutInfo si2 = parseShortcutAttributes(service, attrs, packageName, activity, userId, rank);     // Catch: Throwable -> L18
        if (si2 == null) goto L171;
        if (result2 == null) goto L110;
        int i = result2.size() - 1;     // Catch: Throwable -> L18
    L104:
        if (i < 0) goto L109;
        ShortcutInfo si3 = si2;
        if (si2.getId().equals(result2.get(i).getId()) == true) goto L107;
        i = i - 1;     // Catch: Throwable -> L18
        si2 = si3;
        goto L104
    L107:
        Log.e(TAG, "Duplicate shortcut ID detected. Skipping it.");     // Catch: Throwable -> L18
        goto L171
    L109:
        ShortcutInfo si4 = si2;
    L111:
        si = si4;
        categories = null;
        maxShortcuts = maxShortcuts2;
        currentShareTarget = currentShareTarget2;
        goto L186
    L110:
        si4 = si2;
    L112:
        activity = activity;
        rank = rank;
        String tag3 = tag2;
        attrs = attrs2;
        maxShortcuts2 = maxShortcuts;
        if (depth2 != 2) goto L121;
        if (TAG_SHARE_TARGET.equals(tag3) == false) goto L121;
        ShareTargetInfo sti2 = parseShareTargetAttributes(service, attrs);     // Catch: Throwable -> L18
        if (sti2 == null) goto L171;
        currentShareTarget = sti2;
        categories = null;
        dataList.clear();     // Catch: Throwable -> L18
        si = currentShortcut;
        maxShortcuts = maxShortcuts2;
    L121:
        if (depth2 != 3) goto L135;
        if (TAG_INTENT.equals(tag3) == false) goto L135;
        if (currentShortcut == null) goto L132;
        if (currentShortcut.isEnabled() == false) goto L132;
        Intent intent = Intent.parseIntent(service.mContext.getResources(), parser2, attrs);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(intent.getAction()) == false) goto L131;
        Log.e(TAG, "Shortcut intent action must be provided. activity=" + activity);     // Catch: Throwable -> L18
        si = null;
        maxShortcuts = maxShortcuts2;
        currentShareTarget = currentShareTarget2;
        goto L186
    L131:
        intents.add(intent);     // Catch: Throwable -> L18
    L132:
        Log.e(TAG, "Ignoring excessive intent tag.");     // Catch: Throwable -> L18
    L135:
        if (depth2 != 3) goto L149;
        if (TAG_CATEGORIES.equals(tag3) == false) goto L149;
        if (currentShortcut == null) goto L171;
        if (currentShortcut.getCategories() != null) goto L171;
        String name = parseCategories(service, attrs);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(name) == true) goto L144;
        if (categories != null) goto L147;
        categories = new ArraySet();     // Catch: Throwable -> L18
    L147:
        categories.add(name);     // Catch: Throwable -> L18
        si = currentShortcut;
        maxShortcuts = maxShortcuts2;
        currentShareTarget = currentShareTarget2;
        goto L186
    L144:
        Log.e(TAG, "Empty category found. activity=" + activity);     // Catch: Throwable -> L18
    L149:
        if (depth2 != 3) goto L161;
        if (TAG_CATEGORY.equals(tag3) == false) goto L161;
        if (currentShareTarget2 == null) goto L171;
        String name2 = parseCategory(service, attrs);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(name2) == true) goto L156;
        if (categories != null) goto L159;
        categories = new ArraySet();     // Catch: Throwable -> L18
    L159:
        categories.add(name2);     // Catch: Throwable -> L18
        si = currentShortcut;
        maxShortcuts = maxShortcuts2;
        currentShareTarget = currentShareTarget2;
        goto L186
    L156:
        Log.e(TAG, "Empty category found. activity=" + activity);     // Catch: Throwable -> L18
    L161:
        if (depth2 == 3) goto L163;
    L170:
        Log.w(TAG, String.format("Invalid tag '%s' found at depth %d", new Object[]{tag3, Integer.valueOf(depth2)}));     // Catch: Throwable -> L18
        goto L171
    L163:
        if ("data".equals(tag3) == false) goto L170;
        if (currentShareTarget2 == null) goto L171;
        ShareTargetInfo.TargetData data = parseShareTargetData(service, attrs);     // Catch: Throwable -> L18
        if (data != null) goto L169;
        Log.e(TAG, "Invalid data tag found. activity=" + activity);     // Catch: Throwable -> L18
        goto L171
    L169:
        dataList.add(data);     // Catch: Throwable -> L18
        goto L171
    L88:
        activity = activity;
        attrs = attrs2;
        rank = rank;
        maxShortcuts2 = maxShortcuts;
    L82:
        si = currentShortcut;
        activity = activity;
        attrs = attrs2;
        currentShareTarget = null;
        rank = rank;
    L58:
        si = currentShortcut;
        attrs = attrs2;
    L85:
        currentShareTarget2 = currentShareTarget;
        goto L87
    L28:
        if (currentShortcut == null) goto L58;
        currentShortcut = null;
        if (currentShortcut.isEnabled() == true) goto L33;
        intents.clear();     // Catch: Throwable -> L35
        intents.add(new Intent("android.intent.action.VIEW"));     // Catch: Throwable -> L35
    L38:
        if (numShortcuts >= maxShortcuts) goto L39;
        intents.get(0).addFlags(268484608);     // Catch: Throwable -> L35
        currentShortcut.setIntents((Intent[]) intents.toArray(new Intent[intents.size()]));     // Catch: Throwable -> L35 RuntimeException -> L53
        intents.clear();     // Catch: Throwable -> L35
        if (categories == null) goto L50;
        currentShortcut.setCategories(categories);     // Catch: Throwable -> L35
        categories = null;
    L50:
        if (result2 != null) goto L52;
        result2 = new ArrayList();     // Catch: Throwable -> L35
    L52:
        result2.add(currentShortcut);     // Catch: Throwable -> L35
        numShortcuts = numShortcuts + 1;     // Catch: Throwable -> L35
        rank = rank + 1;     // Catch: Throwable -> L35
        si = null;
        attrs = attrs2;
    L53:
        e = e;
    L57:
        Log.e(TAG, "Shortcut's extras contain un-persistable values. Skipping it.");     // Catch: Throwable -> L35
    L55:
        e = e;
        goto L57
    L39:
        Log.e(TAG, "More than " + maxShortcuts + " shortcuts found for " + activityInfo.getComponentName() + ". Skipping the rest.");     // Catch: Throwable -> L35
        parser2.close();
        return result2;
    L33:
        if (intents.size() != 0) goto L38;
        Log.e(TAG, "Shortcut " + currentShortcut.getId() + " has no intent. Skipping it.");     // Catch: Throwable -> L35
        goto L58
    L59:
        tag2 = tag;
        goto L62
    L60:
        depth2 = depth;
        attrs2 = attrs;
        tag2 = tag;
        goto L62
    L16:
        if (parser2.getDepth() > 0) goto L20;
    L173:
        parser2.close();
        return result2;
    L18:
        th = th;
        parser = parser2;
    L175:
        th = th;
        parser = parser2;
    L177:
        th = th;
        goto L179
    }

    private static String parseCategories(ShortcutService service, AttributeSet attrs) {
        TypedArray sa = service.mContext.getResources().obtainAttributes(attrs, R.styleable.ShortcutCategories);
    L8:
        th = move-exception;
        sa.recycle();
        throw th;
    L4:
        if (sa.getType(0) != 3) goto L10;
        String r1 = sa.getNonResourceString(0);     // Catch: Throwable -> L8
        sa.recycle();
        return r1;
    L10:
        Log.w(TAG, "android:name for shortcut category must be string literal.");     // Catch: Throwable -> L8
        sa.recycle();
        return null;
    }

    private static ShortcutInfo parseShortcutAttributes(ShortcutService service, AttributeSet attrs, String packageName, ComponentName activity, int userId, int rank) {
        TypedArray sa = service.mContext.getResources().obtainAttributes(attrs, R.styleable.Shortcut);
    L9:
        th = move-exception;
        sa.recycle();
        throw th;
    L5:
        if (sa.getType(2) == 3) goto L11;
        Log.w(TAG, "android:shortcutId must be string literal. activity=" + activity);     // Catch: Throwable -> L9
        sa.recycle();
        return null;
    L11:
        String id = sa.getNonResourceString(2);     // Catch: Throwable -> L9
        boolean enabled = sa.getBoolean(1, true);     // Catch: Throwable -> L9
        int iconResId = sa.getResourceId(0, 0);     // Catch: Throwable -> L9
        int titleResId = sa.getResourceId(3, 0);     // Catch: Throwable -> L9
        int textResId = sa.getResourceId(4, 0);     // Catch: Throwable -> L9
        int disabledMessageResId = sa.getResourceId(5, 0);     // Catch: Throwable -> L9
        int splashScreenThemeResId = sa.getResourceId(6, 0);     // Catch: Throwable -> L9
        if (splashScreenThemeResId == 0) goto L14;
        String splashScreenThemeResName = service.mContext.getResources().getResourceName(splashScreenThemeResId);     // Catch: Throwable -> L9
    L16:
        if (TextUtils.isEmpty(id) == false) goto L20;
        Log.w(TAG, "android:shortcutId must be provided. activity=" + activity);     // Catch: Throwable -> L9
        sa.recycle();
        return null;
    L20:
        if (titleResId != 0) goto L25;
        Log.w(TAG, "android:shortcutShortLabel must be provided. activity=" + activity);     // Catch: Throwable -> L9
        sa.recycle();
        return null;
    L25:
        ShortcutInfo r0 = createShortcutFromManifest(service, userId, id, packageName, activity, titleResId, textResId, disabledMessageResId, rank, iconResId, enabled, splashScreenThemeResName);     // Catch: Throwable -> L9
        sa.recycle();
        return r0;
    L14:
        splashScreenThemeResName = null;
        goto L16
    }

    private static ShortcutInfo createShortcutFromManifest(ShortcutService service, int userId, String id, String packageName, ComponentName activityComponent, int titleResId, int textResId, int disabledMessageResId, int rank, int iconResId, boolean enabled, String splashScreenThemeResName) {
        if (enabled == false) goto L4;
        int r0 = 32;
    L5:
        int r1 = r0 | 256;
        if (iconResId == 0) goto L8;
        int r2 = 4;
    L9:
        int flags = r1 | r2;
        if (enabled == false) goto L12;
        int disabledReason = 0;
    L14:
        return new ShortcutInfo(userId, id, packageName, activityComponent, null, null, titleResId, null, null, textResId, null, null, disabledMessageResId, null, null, null, rank, null, service.injectCurrentTimeMillis(), flags, iconResId, null, null, null, disabledReason, null, null, splashScreenThemeResName, null);
    L12:
        disabledReason = 1;
        goto L14
    L8:
        r2 = 0;
        goto L9
    L4:
        r0 = 64;
        goto L5
    }

    private static String parseCategory(ShortcutService service, AttributeSet attrs) {
        TypedArray sa = service.mContext.getResources().obtainAttributes(attrs, R.styleable.IntentCategory);
    L8:
        th = move-exception;
        sa.recycle();
        throw th;
    L4:
        if (sa.getType(0) == 3) goto L10;
        Log.w(TAG, "android:name must be string literal.");     // Catch: Throwable -> L8
        sa.recycle();
        return null;
    L10:
        String r1 = sa.getString(0);     // Catch: Throwable -> L8
        sa.recycle();
        return r1;
    }

    private static ShareTargetInfo parseShareTargetAttributes(ShortcutService service, AttributeSet attrs) {
        TypedArray sa = service.mContext.getResources().obtainAttributes(attrs, R.styleable.Intent);
        String targetClass = sa.getString(4);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(targetClass) == false) goto L10;
        Log.w(TAG, "android:targetClass must be provided.");     // Catch: Throwable -> L8
        sa.recycle();
        return null;
    L10:
        ShareTargetInfo r2 = new ShareTargetInfo(null, targetClass, null);     // Catch: Throwable -> L8
        sa.recycle();
        return r2;
    L8:
        th = move-exception;
        sa.recycle();
        throw th;
    }

    private static ShareTargetInfo.TargetData parseShareTargetData(ShortcutService service, AttributeSet attrs) {
        TypedArray sa = service.mContext.getResources().obtainAttributes(attrs, R.styleable.AndroidManifestData);
    L8:
        th = move-exception;
        sa.recycle();
        throw th;
    L4:
        if (sa.getType(0) == 3) goto L11;
        Log.w(TAG, "android:mimeType must be string literal.");     // Catch: Throwable -> L8
        sa.recycle();
        return null;
    L11:
        String scheme = sa.getString(1);     // Catch: Throwable -> L8
        String host = sa.getString(2);     // Catch: Throwable -> L8
        String port = sa.getString(3);     // Catch: Throwable -> L8
        String path = sa.getString(4);     // Catch: Throwable -> L8
        String pathPattern = sa.getString(6);     // Catch: Throwable -> L8
        String pathPrefix = sa.getString(5);     // Catch: Throwable -> L8
        String mimeType = sa.getString(0);     // Catch: Throwable -> L8
        ShareTargetInfo.TargetData r4 = new ShareTargetInfo.TargetData(scheme, host, port, path, pathPattern, pathPrefix, mimeType);     // Catch: Throwable -> L8
        sa.recycle();
        return r4;
    }
}
