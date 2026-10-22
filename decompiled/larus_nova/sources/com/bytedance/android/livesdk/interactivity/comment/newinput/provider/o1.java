package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.livesdk.chatroom.ui.KeyboardShadowView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f135940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseCommentGiftGuideView f135941c;

    public final class a extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public KeyboardShadowView f135942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public FrameLayout f135943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o1 f135944e;

        public a(o1 r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "bridges");
            this.f135944e = r100;
            super(r101, r102);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    public o1() {
        this.f135939a = InputSectionType.SHADOW;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135939a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135940b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_input_view_shadow, null);
        a r103 = new a(this, r102, r100);
        r103.f135942c = (KeyboardShadowView) r103.f135512a.findViewById(R.id.input_view_shadow);
        r103.f135943d = (FrameLayout) r103.f135512a.findViewById(R.id.gift_guide_container);
        KeyboardShadowView r104 = r103.f135942c;
        if (r104 == null) goto L8;
        r104.setOnClickListener(new l1(r103));
    L8:
        KeyboardShadowView r105 = r103.f135942c;
        boolean r106 = false;
        if (r105 == null) goto L11;
        r105.enableDispatchTouchEventToActivity(false);
    L11:
        KeyboardShadowView r107 = r103.f135942c;
        if (r107 == null) goto L14;
        r107.setIsAnchor(r103.f135513b.k0());
    L14:
        KeyboardShadowView r108 = r103.f135942c;
        if (r108 == null) goto L17;
        r108.setIsPortrait(r103.f135513b.n0());
    L17:
        KeyboardShadowView r109 = r103.f135942c;
        if (r109 == null) goto L20;
        r109.setActivity(r103.f135513b.getActivity());
    L20:
        r3.c(r103.f135942c, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_exit), true);
        if (ec2.b.f472003a.getValue().a() == false) goto L40;
        Context r110 = r103.f135513b.getContext();
        if (r110 == null) goto L41;
        o1 r111 = r103.f135944e;
        boolean r112 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        r111.f135941c = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getCommentGiftGuideView(r110);
        BaseCommentGiftGuideView r113 = r103.f135944e.f135941c;
        if (r113 != null) goto L28;
    L39:
        r103.f135513b.k(new m1(r103));
        goto L40
    L28:
        if (r103.f135513b.m0() == true) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r114 = r103.f135513b.V();
        if (r114 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r115 = r114.f135419g;
        if (r115 == null) goto L36;
        if ((!TextUtils.isEmpty(r115.f135370f)) == true) goto L36;
        r106 = true;
    L36:
        r113.setGuideEnable(r106);
        FrameLayout r116 = r103.f135943d;
        if (r116 == null) goto L39;
        r116.addView(r113);
    L41:
        Unit r117 = Unit.INSTANCE;
        this.f135940b = r103;
        return r102;
    L40:
        r103.f135513b.w(new n1(r103));
        goto L41
    }
}
