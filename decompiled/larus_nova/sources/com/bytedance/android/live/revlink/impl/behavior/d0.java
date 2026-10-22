package com.bytedance.android.live.revlink.impl.behavior;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f92142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f92143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f92144c;

    public final a a() {
        LottieAnimationView r100 = this.f92142a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new a(r100);
    }

    public final void b() {
        a r100 = a();
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public final void c(float r100) {
        a r101 = a();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    public final void d(float r100) {
        this.f92143b.j(r100);
    }

    public d0(d r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "mainButton");
        Intrinsics.checkNotNullParameter(r101, "helper");
        this.f92143b = r100;
        this.f92144c = r101;
    }

    public final Disposable e(e r100, IvPkId r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "iconRes");
        Intrinsics.checkNotNullParameter(r101, "ivPkId");
        if (r102 == false) goto L34;
        if (r101 != IvPkId.BAK) goto L21;
        a0 r103 = new a0(this);
        IconResMode r104 = r100.f92146a;
        if (r104 != IconResMode.IMAGE_MODEL) goto L14;
        py.k r105 = r100.f92147b;
        if (r105 == null) goto L14;
        a r106 = a();
        if (r106 != null) goto L63;
        return null;
    L63:
        return r106.o(r105, r103);
    L14:
        if (r104 != IconResMode.DRAWABLE) goto L64;
        Integer r107 = r100.f92148c;
        if (r107 == null) goto L20;
        int r108 = r107.intValue();
        a r109 = a();
        if (r109 == null) goto L20;
        r109.s(r108);
    L20:
        r103.a();
        r103.c();
        return null;
    L64:
        return null;
    L21:
        b0 r110 = new b0(this);
        IconResMode r111 = r100.f92146a;
        if (r111 != IconResMode.IMAGE_MODEL) goto L27;
        py.k r112 = r100.f92147b;
        if (r112 == null) goto L27;
        return this.f92143b.o(r112, r110);
    L27:
        if (r111 != IconResMode.DRAWABLE) goto L67;
        Integer r113 = r100.f92148c;
        if (r113 == null) goto L31;
        int r114 = r113.intValue();
        this.f92143b.s(r114);
    L31:
        r110.a();
        r110.c();
        return null;
    L67:
        return null;
    L34:
        if (r101 != IvPkId.BAK) goto L50;
        IconResMode r115 = r100.f92146a;
        if (r115 != IconResMode.IMAGE_MODEL) goto L43;
        py.k r116 = r100.f92147b;
        if (r116 == null) goto L43;
        a r117 = a();
        if (r117 == null) goto L43;
        r117.f(r116);
    L43:
        if (r115 != IconResMode.DRAWABLE) goto L49;
        Integer r118 = r100.f92148c;
        if (r118 == null) goto L49;
        int r119 = r118.intValue();
        a r120 = a();
        if (r120 == null) goto L49;
        r120.s(r119);
    L49:
        c(1.0f);
        this.f92143b.h();
    L61:
        return null;
    L50:
        IconResMode r121 = r100.f92146a;
        if (r121 != IconResMode.IMAGE_MODEL) goto L56;
        py.k r122 = r100.f92147b;
        if (r122 == null) goto L56;
        this.f92143b.f(r122);
    L56:
        if (r121 != IconResMode.DRAWABLE) goto L60;
        Integer r123 = r100.f92148c;
        if (r123 == null) goto L60;
        int r124 = r123.intValue();
        this.f92143b.s(r124);
    L60:
        d(1.0f);
        b();
        goto L61
    }
}
