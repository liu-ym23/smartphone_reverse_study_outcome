package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends FrameLayout implements o<HeaderSliceModel>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BgDecorLayer f169593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s f169594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b f169595c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r100, ImageInfo r101, boolean r102, int r103) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r100, Boolean r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r100) {
    }

    private final int getFooterHeight() {
        return this.f169595c.e(false, -1);
    }

    public final void b() {
        int r100 = 0;
        if (this.f169594b.isExpanded() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r101 == false) goto L11;
        int r103 = -2;
    L12:
        r102.width = r103;
        if (r101 == false) goto L15;
        r100 = getFooterHeight();
    L15:
        r102.height = r100;
        Unit r104 = Unit.INSTANCE;
        setLayoutParams(r102);
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        if (this.f169594b.eI() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
        AnchorV4HeadV2VO r100 = this.f169594b.K10();
        if (r100 == null) goto L10;
        ScrollContainerFooter r101 = r100.getFooter();
        if (r101 == null) goto L11;
        IAction r102 = r101.getScrollAction();
        if (r102 == null) goto L12;
        this.f169594b.yd().d(r102, this, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r100) {
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        BgDecorLayer r101 = this.f169593a;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r100) {
        Intrinsics.checkNotNullParameter(r100, "headVo");
        Intrinsics.checkNotNullParameter(r100, "headVo");
    }

    public a(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r101, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        Intrinsics.checkNotNullParameter(r102, "sizeHelper");
        super(r100);
        this.f169594b = r101;
        this.f169595c = r102;
        r101.eh().x(this);
        setLayoutParams(new ViewGroup.LayoutParams(-2, getFooterHeight()));
        b();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169210d == false) goto L6;
        this.f169593a = new BgDecorLayer(r101, this, false, true, 4);
        setWillNotDraw(false);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderSliceModel r100, int r101, Integer r102) {
    }
}
