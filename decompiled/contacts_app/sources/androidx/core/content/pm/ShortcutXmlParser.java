package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutXmlParser {
    private static final String ATTR_SHORTCUT_ID = "shortcutId";
    private static final Object GET_INSTANCE_LOCK = null;
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    private static final String TAG = "ShortcutXmlParser";
    private static final String TAG_SHORTCUT = "shortcut";
    private static volatile ArrayList<String> sShortcutIds;

    static {
        GET_INSTANCE_LOCK = new Object();
    }

    public static List<String> getShortcutIds(Context r2) {
        if (sShortcutIds != null) goto L15;
        Object r0 = GET_INSTANCE_LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sShortcutIds != null) goto L9;
        sShortcutIds = new ArrayList();     // Catch: Throwable -> L11
        sShortcutIds.addAll(parseShortcutIds(r2));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sShortcutIds;
    }

    private ShortcutXmlParser() {
    }

    private static Set<String> parseShortcutIds(Context r5) {
        HashSet r0 = new HashSet();
        Intent r1 = new Intent("android.intent.action.MAIN");
        r1.addCategory("android.intent.category.LAUNCHER");
        r1.setPackage(r5.getPackageName());
        List<ResolveInfo> r2 = r5.getPackageManager().queryIntentActivities(r1, 128);
        if (r2 != null) goto L5;
    L28:
        return r0;
    L5:
        if (r2.size() == 0) goto L28;
        Iterator<ResolveInfo> r3 = r2.iterator();     // Catch: Exception -> L26
    L9:
        if (r3.hasNext() == false) goto L28;
        ActivityInfo r4 = r3.next().activityInfo;     // Catch: Exception -> L26
        Bundle r6 = r4.metaData;     // Catch: Exception -> L26
        if (r6 == null) goto L9;
        if (r6.containsKey(META_DATA_APP_SHORTCUTS) == false) goto L9;
        XmlResourceParser r7 = getXmlResourceParser(r5, r4);     // Catch: Exception -> L26
        r0.addAll(parseShortcutIds(r7));     // Catch: Throwable -> L19
        if (r7 == null) goto L9;
        r7.close();     // Catch: Exception -> L26
        goto L9
    L19:
        th = move-exception;
        if (r7 != null) goto L29;
    L25:
        throw th;     // Catch: Exception -> L26
    L29:
        r7.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Failed to parse the Xml resource: ", e);
        goto L28
    }

    private static XmlResourceParser getXmlResourceParser(Context r2, ActivityInfo r3) {
        XmlResourceParser r4 = r3.loadXmlMetaData(r2.getPackageManager(), META_DATA_APP_SHORTCUTS);
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + r3.name);
    }

    public static List<String> parseShortcutIds(XmlPullParser r6) throws IOException, XmlPullParserException {
        ArrayList r0 = new ArrayList(1);
    L3:
        int r2 = r6.next();
        if (r2 == 1) goto L18;
        if (r2 == 3) goto L8;
    L9:
        int r3 = r6.getDepth();
        String r4 = r6.getName();
        if (r2 != 2) goto L3;
        if (r3 != 2) goto L3;
        if (TAG_SHORTCUT.equals(r4) == false) goto L3;
        String r5 = getAttributeValue(r6, ATTR_SHORTCUT_ID);
        if (r5 == null) goto L3;
        r0.add(r5);
        goto L3
    L8:
        if (r6.getDepth() > 0) goto L9;
    L18:
        return r0;
    }

    private static String getAttributeValue(XmlPullParser r1, String r2) {
        String r0 = r1.getAttributeValue("http://schemas.android.com/apk/res/android", r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.getAttributeValue(null, r2);
    }
}
