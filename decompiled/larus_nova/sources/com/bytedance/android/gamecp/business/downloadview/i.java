package com.bytedance.android.gamecp.business.downloadview;

import android.graphics.Color;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f53062y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f53063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f53070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f53071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f53072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f53073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f53074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f53075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f53076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Integer> f53077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f53078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f53079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f53080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f53081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f53082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f53083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f53084v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f53085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f53086x;

    public static final class a {
        public a() {
        }

        public static int a(String r100, int r101) {
            if (r100.length() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L15;
            return r101;
        L15:
            if (r100.length() != 9) goto L11;
            int r103 = Color.parseColor("#" + r100.subSequence(7, 9) + r100.subSequence(1, 7));     // Catch: Exception -> L14
        L13:
            return r103;
        L11:
            r103 = Color.parseColor(r100);     // Catch: Exception -> L14
            goto L13
        L16:
            return r101;
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
        f53062y = new a();
    }

    public i(int r100, int r101, int r102, int r103, int r104, int r110, int r111, int r112, int r113, int r114, int r115, String r116, int r117, int r118, List<Integer> r119, int r210, float r211, int r212, int r213, float r214, int r215, int r216, int r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r116, "prefixIcon");
        Intrinsics.checkNotNullParameter(r119, "iconShowStatus");
        this.f53063a = r100;
        this.f53064b = r101;
        this.f53065c = r102;
        this.f53066d = r103;
        this.f53067e = r104;
        this.f53068f = r110;
        this.f53069g = r111;
        this.f53070h = r112;
        this.f53071i = r113;
        this.f53072j = r114;
        this.f53073k = r115;
        this.f53074l = r116;
        this.f53075m = r117;
        this.f53076n = r118;
        this.f53077o = r119;
        this.f53078p = r210;
        this.f53079q = r211;
        this.f53080r = r212;
        this.f53081s = r213;
        this.f53082t = r214;
        this.f53083u = r215;
        this.f53084v = r216;
        this.f53085w = r217;
        this.f53086x = r218;
    }
}
