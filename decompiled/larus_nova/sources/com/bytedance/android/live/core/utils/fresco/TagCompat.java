package com.bytedance.android.live.core.utils.fresco;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public class TagCompat {
    private static final boolean COVER_TAG = true;
    private static final String KEY_DRAWEE_HOLDER = "DraweeHolder";

    public static class TagMap extends HashMap<String, Object> {
        public TagMap(String r100, Object r101, a r102) {
            put(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public TagCompat() {
    }

    public static Object getTag(View r100) {
        return getTag(r100, KEY_DRAWEE_HOLDER);
    }

    public static Object getTag(View r100, String r101) {
        return getTag(r100, r101, null);
    }

    public static void setTag(View r100, Object r101) {
        setTag(r100, KEY_DRAWEE_HOLDER, r101);
    }

    public static Object getTag(View r100, String r101, Object r102) {
        if (r100 == null) goto L8;
        Object r103 = r100.getTag();
        if ((r103 instanceof TagMap) == false) goto L8;
        Object r104 = ((TagMap) r103).get(r101);
        if (r104 == null) goto L8;
        return r104;
    L8:
        return r102;
    }

    public static boolean setTag(View r100, String r101, Object r102) {
        return setTag(r100, r101, r102, true);
    }

    public static boolean setTag(View r100, String r101, Object r102, boolean r103) {
        if (r100 == null) goto L11;
        Object r104 = r100.getTag();
        if ((r104 instanceof TagMap) == false) goto L7;
        ((TagMap) r104).put(r101, r102);
        return true;
    L7:
        if (r104 == null) goto L9;
        if (r103 == true) goto L9;
        return false;
    L9:
        r100.setTag(new TagMap(r101, r102, null));
        return true;
    L11:
        return false;
    }
}
