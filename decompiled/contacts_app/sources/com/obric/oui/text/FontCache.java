package com.obric.oui.text;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import com.GlobalProxyLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FontCache {
    private static final String TAG = "FontCache";
    private static volatile Map<String, Integer> sFontNameValueMap;
    private static volatile SparseArray<String> sFontType;
    private static volatile FontCache sInstance;
    private Context mContext;
    private Map<String, String> mFontPathMap;
    private SparseArray<Typeface> mFrontMap;

    static {
        sFontType = new SparseArray();
        sFontType.put(1, FontName.REGULAR);
        sFontType.put(2, FontName.BOLD);
        sFontType.put(3, FontName.BOLD_ITALIC);
        sFontType.put(4, FontName.ITALIC);
        sFontType.put(5, FontName.LIGHT);
        sFontType.put(6, FontName.LIGHT_ITALIC);
        sFontType.put(7, FontName.MEDIUM);
        sFontType.put(8, FontName.MEDIUM_ITALIC);
        sFontNameValueMap = new HashMap();
        sFontNameValueMap.put(FontName.REGULAR, 1);
        sFontNameValueMap.put(FontName.BOLD, 2);
        sFontNameValueMap.put(FontName.BOLD_ITALIC, 3);
        sFontNameValueMap.put(FontName.ITALIC, 4);
        sFontNameValueMap.put(FontName.LIGHT, 5);
        sFontNameValueMap.put(FontName.LIGHT_ITALIC, 6);
        sFontNameValueMap.put(FontName.MEDIUM, 7);
        sFontNameValueMap.put(FontName.MEDIUM_ITALIC, 8);
    }

    private FontCache() {
        this.mFontPathMap = null;
        this.mFrontMap = new SparseArray();
        this.mFontPathMap = new HashMap();
    }

    public void init(Context r1, Map<String, String> r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        this.mContext = r1.getApplicationContext();
        this.mFontPathMap = r2;
        cacheTypeface();
        return;
    L7:
        return;
    }

    private void cacheTypeface() {
        Map<String, String> r0 = this.mFontPathMap;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() < 0) goto L16;
        Iterator<String> r1 = this.mFontPathMap.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        String r2 = r1.next();
        if (TextUtils.isEmpty(r2) == true) goto L11;
        getTypeface(sFontNameValueMap.get(r2).intValue());
        goto L8
    L11:
        return;
    L17:
        return;
    }

    public static FontCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(FontCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new FontCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FontCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void clear() {
        if (sInstance == null) goto L12;
        sInstance.mContext = null;
        if (sInstance.mFontPathMap == null) goto L8;
        sInstance.mFontPathMap.clear();
        sInstance.mFontPathMap = null;
    L8:
        if (sInstance.mFrontMap == null) goto L10;
        sInstance.mFrontMap.clear();
        sInstance.mFrontMap = null;
    L10:
        sInstance = null;
        return;
    }

    private Typeface createTypeface(int r2) {
        String r3 = this.mFontPathMap.get(sFontType.get(r2));
        Context r1 = this.mContext;
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        return Typeface.createFromAsset(r1.getAssets(), r3);
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "createTypeface exception. message is " + e.getMessage());
        goto L8
    }

    public Typeface getTypeface(int r3) {
        Typeface r0 = this.mFrontMap.get(r3, null);
        if (r0 != null) goto L6;
        Typeface r1 = createTypeface(r3);
        this.mFrontMap.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public Typeface getTypeface(String r2) {
        if (this.mFontPathMap.containsKey(r2) == true) goto L7;
        return null;
    L7:
        return getTypeface(sFontNameValueMap.get(r2).intValue());
    }

    public String getTypefacePath(Typeface r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mFrontMap.size()) goto L10;
        int r1 = this.mFrontMap.keyAt(r0);
        if (this.mFrontMap.get(r1) == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        String r5 = sFontType.get(r1);
        return this.mFontPathMap.get(r5) + "(" + r5 + ")";
    L10:
        return "";
    }
}
