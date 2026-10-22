package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidesAndIndicatorV4Component f168863a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f168864a;

        public a(t r100) {
            this.f168864a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorV4VM r100 = this.f168864a.f168863a.E.invoke();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            com.bytedance.android.shopping.anchorv4.containers.g r101 = r100.containerAbility();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.a();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void b() {
        l r100 = this.f168863a.f168450d;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final AnchorV4PlayerStateManager e() {
        AnchorV4VM r100 = this.f168863a.E.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayerStateManager();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final Object f() {
        return this.f168863a.F.invoke();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final Integer getDefaultIndex() {
        Integer r100 = this.f168863a.f168464r;
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (r100.intValue() < 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L14;
        r100.intValue();
        return this.f168863a.f168464r;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean l() {
        return this.f168863a.f168456j;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean m() {
        if (this.f168863a.f168463q == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean n() {
        return this.f168863a.f168472z.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void o() {
        this.f168863a.f168471y.z();
        com.bytedance.android.shopping.anchorv4.containers.i r100 = this.f168863a.f168448b;
        if (r100 == null) goto L6;
        r100.t();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final g83.a q() {
        return this.f168863a.f168449c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final c63.d t() {
        return this.f168863a.f168471y;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void u() {
        this.f168863a.f168471y.i();
        com.bytedance.android.shopping.anchorv4.containers.e r100 = this.f168863a.f168447a;
        if (r100 == null) goto L6;
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r100, new StatTagItem(1, 0, null, null, 0, false, null, 0, 254, null), 2, null, null, 12);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final c63.b u1() {
        return this.f168863a.C;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void v() {
        this.f168863a.f168468v.post(new a(this));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final boolean i() {
        if (s73.b.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f168863a.f168456j == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final SlidesAndIndicatorV4Component r() {
        return this.f168863a;
    }

    public t(SlidesAndIndicatorV4Component r100) {
        this.f168863a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        ViewExtensionsKt.c(this.f168863a.f168469w, false, 3);
        return;
    L4:
        ViewExtensionsKt.i(this.f168863a.f168469w);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void c(float r100) {
        if (this.f168863a.f168472z.a() == false) goto L8;
        l r101 = this.f168863a.f168450d;
        if (r101 == null) goto L9;
        r101.c(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void h(boolean r100) {
        f83.k r101 = this.f168863a.f168452f;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void p(boolean r100) {
        f83.k r101 = this.f168863a.f168452f;
        if (r101 == null) goto L12;
        AnchorV4HeadIndicator r102 = r101.f475855a;
        if (r102.f168759d == true) goto L13;
        TextView r103 = r102.f168763h;
        if (r100 == false) goto L9;
        int r104 = 0;
    L10:
        r103.setVisibility(r104);
        return;
    L9:
        r104 = 8;
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void j(AnchorV4HeadViewPager.a r100, FindSameSource r101) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f168863a.B.j(r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void s(Integer r100, int r110) {
        int r101 = this.f168863a.f168468v.getId();
        if (z53.b.f570100a == r101) goto L5;
        z53.b.f570100a = r101;
        z53.b.f570101b = 0;
    L5:
        long r102 = System.currentTimeMillis();
        if ((r102 - z53.b.f570101b) >= 500) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        z53.b.f570101b = r102;
    L11:
        if (r103 == true) goto L14;
        this.f168863a.l(r100, r110, false);
        SlidesAndIndicatorV4Component r104 = this.f168863a;
        System.currentTimeMillis();
        r104.getClass();
        return;
    L14:
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void g(String r100, com.bytedance.android.shopping.anchorv4.dto.business.d r101, Integer r102) {
        this.f168863a.B.g(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.d
    public final void k(boolean r110, String r111, String r112) {
        f83.k r100 = this.f168863a.f168452f;
        if (r100 == null) goto L57;
        AnchorV4HeadIndicator r101 = r100.f475855a;
        if (r101.f168764i != null) goto L15;
        Context r102 = r101.getContext();
        if (r101.f168758c == false) goto L9;
        int r103 = R.layout.ec_commerce_anchor_v4_sku_image_layout_tab_ab;
    L10:
        View r104 = View.inflate(r102, r103, null);
        r101.f168764i = r104;
        if (r101.f168758c == false) goto L13;
        int r105 = 20;
    L14:
        r101.addView(r104, new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105))));
        goto L15
    L13:
        r105 = 24;
        goto L14
    L9:
        r103 = R.layout.ec_commerce_anchor_v4_sku_image_layout;
    L15:
        View r106 = r101.f168764i;
        int r107 = 0;
        if (r106 == null) goto L29;
        if (r110 == false) goto L19;
        int r113 = 0;
    L20:
        r106.setVisibility(r113);
        TextView r114 = (TextView) r106.findViewById(R.id.sku_title);
        if (r114 == null) goto L23;
        r114.setText(r111);
        r114.setVisibility(0);
    L23:
        TextView r115 = (TextView) r106.findViewById(R.id.sku_index);
        if (r115 == null) goto L26;
        r115.setText(r112);
    L26:
        TextView r108 = (TextView) r106.findViewById(R.id.sku_stub);
        if (r108 == null) goto L29;
        r108.setText(r112);
        goto L29
    L19:
        r113 = 8;
    L29:
        r101.h(false);
        if (r101.f168759d == true) goto L32;
        r101.f168763h.setVisibility(8);
    L32:
        AnchorV4DownTabIndicator r116 = r100.f475856b;
        if (r116 != null) goto L35;
        return;
    L35:
        if (r116.f168722b != null) goto L37;
        View r109 = View.inflate(r116.getContext(), R.layout.ec_commerce_anchor_v4_sku_image_layout_tab_ab, null);
        r116.f168722b = r109;
        r116.addView(r109, new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(20)));
    L37:
        View r117 = r116.f168722b;
        if (r117 == null) goto L48;
        if (r110 == true) goto L42;
        r107 = 8;
    L42:
        r117.setVisibility(r107);
        TextView r118 = (TextView) r117.findViewById(R.id.sku_title);
        if (r118 == null) goto L45;
        r118.setText(r111);
    L45:
        TextView r119 = (TextView) r117.findViewById(R.id.sku_index);
        if (r119 == null) goto L48;
        r119.setVisibility(8);
    L48:
        Integer r120 = r116.f168725e;
        if (r120 != null) goto L52;
    L53:
        FrameLayout r121 = r116.f168730j;
        if (r121 == null) goto L60;
        wg.a.h(r121, r110);
        return;
    L60:
        return;
    L52:
        if (r120.intValue() != 0) goto L53;
        return;
    }
}
