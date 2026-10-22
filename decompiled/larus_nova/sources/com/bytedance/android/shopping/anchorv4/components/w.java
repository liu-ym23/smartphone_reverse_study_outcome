package com.bytedance.android.shopping.anchorv4.components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w extends FrameLayout implements com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f166162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f166163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x73.a f166164c;

    public static final class a {
    }

    static {
    }

    @Override // fj.e
    public final void B0() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void P1(boolean r100) {
    }

    @Override // fj.e
    public final void Q(float r100) {
    }

    @Override // fj.e
    public final void R2() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void b(float r100) {
    }

    @Override // fj.e
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e
    public final void y(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void y3(String r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void E3() {
        this.f166163b.setVisibility(0);
    }

    @Override // fj.e
    public final void H() {
        this.f166163b.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void S() {
        this.f166163b.setVisibility(8);
    }

    @Override // fj.e
    public final void Z2() {
        this.f166163b.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.anchorv4.components.w] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.view.View, x73.a] */
    public w(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        int r100 = com.bytedance.android.shopping.extensions.b.a(2);
        setPadding(r100, r100, r100, 0);
        BackgroundDrawable r101 = new BackgroundDrawable(r110, null, false, 4, null);
        r101.setCornerRadius(com.bytedance.android.shopping.extensions.b.a(Float.valueOf(12.0f)));
        r101.setBgColor((int) 3238002687L);
        r101.setStrokeColor(-1);
        r101.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(1));
        r101.invalidate();
        Unit r102 = Unit.INSTANCE;
        setBackground(r101);
        int r103 = com.bytedance.android.shopping.extensions.b.a(66);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
        BasePdpVideoView r104 = new BasePdpVideoView(r110, null, 6, 0);
        ViewExtensionsKt.g(r104, 10.0f, 10.0f, 10.0f, 10.0f);
        ?? r105 = r104;
    L6:
        this.f166164c = r105;
        addView(r105, new FrameLayout.LayoutParams(r103, r103));
        ECDraweeView r106 = new ECDraweeView(r110, null, 0, 6, null);
        this.f166163b = r106;
        ViewExtensionsKt.g(r106, 10.0f, 10.0f, 10.0f, 10.0f);
        addView(r106, new FrameLayout.LayoutParams(r103, r103));
        TextView r107 = new TextView(r110);
        this.f166162a = r107;
        r107.setGravity(17);
        int r108 = g1.f45599a;
        r107.setCompoundDrawablesWithIntrinsicBounds(null, null, g1.a.b(r110, R.drawable.anchor_v4_more_video_arrow), null);
        r107.setTextColor(g1.a.a(r110, R.color.shopping_color_161823));
        ViewExtensionsKt.h(r107, 10);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(24));
        r111.topMargin = r103;
        r111.gravity = 1;
        addView(r107, r111);
        return;
    L5:
        BasePdVideoView r109 = new BasePdVideoView(r110, null);
        ViewExtensionsKt.g(r109, 10.0f, 10.0f, 10.0f, 10.0f);
        r105 = r109;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void i2(boolean r100) {
        if (r100 == false) goto L5;
        this.f166163b.setVisibility(8);
        return;
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        if (r100 == true) goto L5;
        this.f166163b.setVisibility(0);
        return;
    }
}
