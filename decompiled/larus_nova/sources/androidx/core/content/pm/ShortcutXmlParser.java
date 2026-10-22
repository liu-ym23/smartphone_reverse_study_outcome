package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
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

    private ShortcutXmlParser() {
    }

    public static List<String> getShortcutIds(Context r100) {
        if (sShortcutIds != null) goto L15;
        Object r101 = GET_INSTANCE_LOCK;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sShortcutIds != null) goto L9;
        sShortcutIds = new ArrayList();     // Catch: Throwable -> L11
        sShortcutIds.addAll(parseShortcutIds(r100));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sShortcutIds;
    }

    private static Set<String> parseShortcutIds(Context r100) {
        HashSet r101 = new HashSet();
        Intent r102 = new Intent("android.intent.action.MAIN");
        r102.addCategory("android.intent.category.LAUNCHER");
        r102.setPackage(r100.getPackageName());
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentActivities(r102, 128);
        if (r103 != null) goto L5;
    L26:
        return r101;
    L5:
        if (r103.size() == 0) goto L26;
        Iterator<ResolveInfo> r104 = r103.iterator();     // Catch: Exception -> L27
    L9:
        if (r104.hasNext() == false) goto L26;
        ActivityInfo r105 = r104.next().activityInfo;     // Catch: Exception -> L27
        Bundle r106 = r105.metaData;     // Catch: Exception -> L27
        if (r106 == null) goto L9;
        if (r106.containsKey(META_DATA_APP_SHORTCUTS) == false) goto L9;
        XmlResourceParser r107 = getXmlResourceParser(r100, r105);     // Catch: Exception -> L27
        r101.addAll(parseShortcutIds(r107));     // Catch: Throwable -> L19
        if (r107 == null) goto L9;
        r107.close();     // Catch: Exception -> L27
        goto L9
    L19:
        th = move-exception;
        if (r107 != null) goto L28;
    L25:
        throw th;     // Catch: Exception -> L27
    L28:
        r107.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
        goto L25
    }

    public static List<String> parseShortcutIds(XmlPullParser r100) throws IOException, XmlPullParserException {
        ArrayList r101 = new ArrayList(1);
    L3:
        int r102 = r100.next();
        if (r102 == 1) goto L18;
        if (r102 == 3) goto L8;
    L9:
        int r103 = r100.getDepth();
        String r104 = r100.getName();
        if (r102 != 2) goto L3;
        if (r103 != 2) goto L3;
        if (TAG_SHORTCUT.equals(r104) == false) goto L3;
        String r105 = getAttributeValue(r100, ATTR_SHORTCUT_ID);
        if (r105 == null) goto L3;
        r101.add(r105);
        goto L3
    L8:
        if (r100.getDepth() > 0) goto L9;
    L18:
        return r101;
    }

    private static String getAttributeValue(XmlPullParser r100, String r101) {
        String r102 = r100.getAttributeValue("http://schemas.android.com/apk/res/android", r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r100.getAttributeValue(null, r101);
    }

    private static XmlResourceParser getXmlResourceParser(Context r100, ActivityInfo r101) {
        XmlResourceParser r102 = r101.loadXmlMetaData(r100.getPackageManager(), META_DATA_APP_SHORTCUTS);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + r101.name);
    }
}
