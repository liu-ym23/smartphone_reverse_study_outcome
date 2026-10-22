package com.obric.oui.shadow;

import android.text.TextUtils;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.q;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f16774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b[] f16775b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b[] f16776c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b[] f16777d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b[] f16778e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b[] f16779f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b[] f16780g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b[] f16781h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b[] f16782i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b[] f16783j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b[] f16784k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b[] f16785l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b[] f16786m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b[] f16787n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ConcurrentHashMap f16788o = null;

    static {
        f16774a = new b[]{new b(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        b[] r10 = {new b(0.0f, 8.0f, 20.0f, 335544320, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 134217728, 0.0f, -1)};
        f16775b = r10;
        b[] r11 = {new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        f16776c = r11;
        if (OMaterialHelper.p() >= 4) goto L6;
        r10 = r11;
    L6:
        f16777d = r10;
        b[] r12 = {new b(0.0f, 12.0f, 24.0f, 603979776, 0.0f, -1)};
        f16778e = r12;
        b[] r13 = {new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        f16779f = r13;
        if (OMaterialHelper.p() >= 4) goto L10;
        r12 = r13;
    L10:
        f16780g = r12;
        f16781h = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        f16782i = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        f16783j = new b[]{new b(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        f16784k = new b[]{new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        f16785l = new b[]{new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        f16786m = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        f16787n = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        f16788o = q.a(d.class, b[].class);
    }

    public static b[] a(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return (b[]) q.d(r10, f16788o);
    }
}
