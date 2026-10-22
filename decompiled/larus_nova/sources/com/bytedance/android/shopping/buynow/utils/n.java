package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171222a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Map, java.util.Map<java.lang.String, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    @JvmStatic
    public static final Object a(Map<String, ? extends Object> r100, List<String> r101, int r102) {
        List<String> r103 = r101;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        return r100;
    L12:
        if (r102 < r101.size()) goto L14;
        return null;
    L14:
        String r106 = (String) ListProtector.get(r101, r102);
        if (r106.length() != 0) goto L17;
        r104 = true;
    L17:
        if (r104 == true) goto L23;
        if (r100 == 0) goto L21;
        r100 = r100.get(r106);
        goto L23
    L21:
        r100 = 0;
    L23:
        if (r102 == (r101.size() - 1)) goto L25;
        if (r100 != 0) goto L35;
        return null;
    L35:
        if ((r100 instanceof Map) == true) goto L37;
        return null;
    L37:
        return a((Map) r100, r101, r102 + 1);
    L25:
        if ((r100 instanceof Map) == true) goto L27;
        return r100;
    L27:
        if (((Map) r100).isEmpty() == false) goto L30;
        return null;
    L30:
        return r100;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
