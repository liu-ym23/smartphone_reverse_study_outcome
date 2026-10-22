package com.bytedance.android.livesdk.dslservice.lynxair;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.livesdk.dsl.recyclerview.i;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.q1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends com.bytedance.android.livesdk.dslservice.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f122860i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f122861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.dslservice.lynxair.jsb.c f122862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q1 f122863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f122864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AnnieXLynxView f122865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f122866h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.lynxair.a$a, reason: collision with other inner class name */
    public static final class C1957a {
    }

    static {
    }

    @Override // yt1.k
    public final void release() {
        com.bytedance.android.livesdk.dslservice.util.r.a(this.f122865g);
        this.f122865g.destroy();
        Function2<? super q, ? super k, Unit> r100 = this.f122817a;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(this.f122866h, this);
    L5:
        this.f122861c = null;
        this.f122862d = null;
    }

    @Override // yt1.k
    public final View getView() {
        return this.f122865g;
    }

    @Override // yt1.k
    public final void a(i r100) {
        com.bytedance.android.livesdk.dslservice.lynxair.jsb.c r101 = this.f122862d;
        if (r101 == null) goto L6;
        r101.f122885a = r100;
        return;
    }

    public a(AnnieXLynxView r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f122865g = r100;
        this.f122866h = r101;
    }

    @Override // yt1.k
    public final void b(au1.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lifeType");
        r r102 = this.f122861c;
        if (r102 != null) goto L5;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r100, au1.a.b.f16300b) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100, au1.a.c.f16301b) == false) goto L14;
        this.f122865g.H();
        return;
    L14:
        if (Intrinsics.areEqual(r100, au1.a.C0232a.f16299b) == false) goto L19;
        this.f122865g.F();
        return;
    L19:
        return;
    L5:
        if (r102.f569041b == true) goto L8;
        goto L6
    }

    @Override // yt1.k
    public final void c(String r100, Map<String, ? extends Object> r101, int r102) {
        long r103 = System.currentTimeMillis();
        LynxViewUtilKt.a(this.f122865g, r100, r101, r102);
        long r104 = System.currentTimeMillis() - r103;
        m.f123003h.i(r104, this.f122866h.f569037a, "bindData");
    }
}
