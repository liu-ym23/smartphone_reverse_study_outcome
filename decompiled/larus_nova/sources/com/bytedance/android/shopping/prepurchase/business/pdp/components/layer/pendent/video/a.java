package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DragRelativeLayout f181507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f181508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f181509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f181510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f181511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f181512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f181513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f181514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f181515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f181516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f181517k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a$a, reason: collision with other inner class name */
    public static final class C2699a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void Q0() {
        if (this.f181517k.a() == false) goto L7;
        if (this.f181516j.a() == false) goto L7;
        return;
    L7:
        if (c() == false) goto L13;
        this.f181511e = true;
        e r100 = this.f181508b;
        if (r100 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L13;
        r101.a(r100);
    L13:
        pause();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void a() {
        c r100 = this.f181513g;
        r100.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L7;
        x73.c r101 = r100.f181531d.f181516j.f181554c.f181584g;
        if (r101 == null) goto L11;
        r101.g(r100.f181530c, Boolean.TRUE);
        return;
    L11:
        return;
    L7:
        x73.c r102 = r100.f181531d.f181516j.f181554c.f181584g;
        if (r102 == null) goto L13;
        x73.d r103 = r100.f181530c;
        boolean r104 = x73.c.f562815f;
        r102.h(r103, null);
        return;
    }

    public final boolean c() {
        if (this.f181516j.a() == false) goto L5;
    L9:
        gj.b r100 = this.f181513g.e();
        if (r100 != null) goto L12;
    L14:
        return false;
    L12:
        if (r100.isPlaying() != true) goto L14;
        return true;
    L5:
        if (this.f181516j.f181554c.f181583f == false) goto L9;
        if (this.f181512f == true) goto L9;
        return true;
    }

    public final void d() {
        gj.b r100 = this.f181513g.e();
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void onPageDestroy() {
        t.a.a(this.f181513g, false, true, false, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void pause() {
        gj.b r100 = this.f181513g.e();
        if (r100 == null) goto L5;
        r100.pause();
    L5:
        this.f181512f = true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void resume() {
        gj.b r100 = this.f181513g.e();
        if (r100 == null) goto L6;
        r100.resume();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void show() {
        DragRelativeLayout r100 = new DragRelativeLayout(this.f181516j.getContext());
        r100.setDockMode(2);
        boolean r101 = false;
        r100.f176420b = 0;
        r100.f176422d = 0;
        r100.f176421c = 0;
        r100.f176423e = 0;
        r100.setOnViewPositionChanged(new FloatVideo$initView$$inlined$apply$lambda$1(this));
        r100.setEnableKeepLayout(true);
        n r102 = this.f181514h;
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(-2, -2);
        y r104 = this.f181516j.f181555d;
        r103.topMargin = r104.f181586a;
        if (r104.f181587b == false) goto L5;
        r103.addRule(11, -1);
    L5:
        Unit r105 = Unit.INSTANCE;
        r100.addView(r102, r103);
        r100.b();
        this.f181516j.f181553b.addView(r100);
        this.f181507a = r100;
        if (this.f181516j.f181555d.f181591f == false) goto L18;
        this.f181514h.setVisibility(4);
        n r106 = this.f181514h;
        if (ViewCompat.isLaidOut(r106) == true) goto L10;
    L16:
        r106.addOnLayoutChangeListener(new f(this, r100));
        goto L18
    L10:
        if (r106.isLayoutRequested() == true) goto L16;
        r106.setVisibility(0);
        if (this.f181516j.f181555d.f181587b == false) goto L14;
        r106.setTranslationX(r100.getWidth() - r106.getLeft());
    L15:
        r106.animate().translationX(0.0f).setDuration(300).start();
        goto L18
    L14:
        r106.setTranslationX(-r106.getRight());
    L18:
        if (this.f181516j.f181554c.f181583f == true) goto L21;
        this.f181514h.b();
    L21:
        if (this.f181508b != null) goto L23;
        x r107 = this.f181516j.f181554c;
        e r108 = new e(this, r107.f181578a, r107.f181579b);
        this.f181516j.f181554c.f181578a.c(r108);
        this.f181508b = r108;
    L23:
        Boolean r109 = this.f181516j.f181554c.f181580c;
        if (r109 == null) goto L26;
        this.f181513g.f181529b = r109.booleanValue();
    L33:
        gj.b r110 = this.f181513g.e();
        if (r110 == null) goto L36;
        r110.a(this.f181513g.f181529b);
    L36:
        this.f181514h.a();
        d r111 = this.f181515i;
        boolean r112 = this.f181513g.f181529b;
        r111.getClass();
        if (r112 == true) goto L39;
        String r113 = "open";
    L40:
        r111.b("pd_sound_icon_show", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ICON_STATUS, r113)));
        if (this.f181516j.f181554c.f181583f == true) goto L43;
    L58:
        u r114 = this.f181516j.f181556e;
        if (r114 == null) goto L62;
        r114.onShow();
        return;
    L62:
        return;
    L43:
        if (this.f181513g.f181531d.f181516j.f181554c.f181584g == null) goto L45;
        r101 = true;
    L45:
        if (r101 == true) goto L47;
        d();
    L51:
        if (c() == false) goto L58;
        Float r115 = this.f181516j.f181554c.f181585h;
        if (r115 == null) goto L57;
        float r116 = r115.floatValue();
        gj.b r117 = this.f181513g.e();
        if (r117 == null) goto L57;
        r117.seek(r116);
    L57:
        this.f181509c = true;
        goto L58
    L47:
        if (c() == true) goto L51;
        d();
        goto L51
    L39:
        r113 = "close";
        goto L40
    L26:
        c r118 = this.f181513g;
        e r119 = this.f181508b;
        if (r119 == null) goto L31;
        com.bytedance.android.shopping.anchorv4.video.f r120 = r119.f167580d;
        if (r120 == null) goto L31;
        boolean r121 = r120.h(r119);
    L32:
        r118.f181529b = r121;
    L31:
        r121 = r118.f181529b;
        goto L32
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void b(x73.c r100) {
        Intrinsics.checkNotNullParameter(r100, "sharePlayer");
        c r101 = this.f181513g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sharePlayer");
        x73.c r102 = r101.f181531d.f181516j.f181554c.f181584g;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        if (r102 == null) goto L7;
        r102.g(r101.f181530c, Boolean.TRUE);
    L7:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L14;
        r101.f181531d.f181516j.f181554c.f181584g = r100;
    L14:
        r101.f();
        return;
    L9:
        if (r102 == null) goto L12;
        x73.d r103 = r101.f181530c;
        boolean r104 = x73.c.f562815f;
        r102.h(r103, null);
    L12:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L14;
        r101.f181531d.f181516j.f181554c.f181584g = r100;
        goto L14
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.s
    public final void close(boolean r100) {
        t.a.a(this.f181513g, false, false, false, r100, 6);
    }

    public a(l r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f181516j = r100;
        this.f181517k = r101;
        this.f181510d = -1;
        c r102 = new c(this);
        this.f181513g = r102;
        this.f181514h = new n(r100.getContext(), r102);
        this.f181515i = new d(this);
    }
}
