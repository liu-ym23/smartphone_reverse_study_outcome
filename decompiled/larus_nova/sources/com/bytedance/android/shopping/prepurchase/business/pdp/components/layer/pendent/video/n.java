package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.a2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f181561e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f181562f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f181563g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f181564h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f181565i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f181566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f181567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f181568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f181569d;

    public static final class a {
    }

    static {
        int r100 = com.bytedance.android.shopping.extensions.b.a(144);
        int r101 = com.bytedance.android.shopping.extensions.b.a(80);
        f181561e = r100;
        f181562f = r101;
        f181563g = com.bytedance.android.shopping.extensions.b.a(12);
        int r102 = com.bytedance.android.shopping.extensions.b.a(8);
        f181564h = r102;
        f181565i = r100 + (r102 * 2);
    }

    public final void a() {
        if (this.f181569d.b() == false) goto L8;
        w r100 = this.f181568c;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L7:
        r100.setImageResource(R.drawable.anchor_v4_float_video_icon_audio_off);
        return;
    L8:
        w r101 = this.f181568c;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L11:
        r101.setImageResource(R.drawable.anchor_v4_float_video_icon_audio_on);
    }

    public final void b() {
        a0 r100 = this.f181566a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L5:
        gj.b r101 = this.f181569d.e();
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.isPlaying() != true) goto L10;
    L11:
        r100.f181524h = !r102;
        if (r102 == false) goto L17;
        View r103 = r100.f181521e;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L16:
        r103.setVisibility(8);
    L21:
        View r104 = r100.f181525i;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L24:
        r104.invalidate();
        return;
    L17:
        View r105 = r100.f181521e;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L20:
        r105.setVisibility(0);
    L10:
        r102 = false;
        goto L11
    }

    public final ViewGroup getVideoContainer() {
        a0 r100 = this.f181566a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L6:
        return r100.getVideoContainer();
    }

    public n(Context r100, c r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ability");
        super(r100);
        this.f181569d = r110;
        y r101 = r110.f181531d.f181516j.f181555d;
        a0 r102 = new a0(getContext(), r110);
        r102.setRadius(com.bytedance.android.shopping.extensions.b.a(12));
        this.f181566a = r102;
        Unit r103 = Unit.INSTANCE;
        Pair<Integer, Integer> r104 = r101.f181592g;
        if (r104 == null) goto L7;
        Integer r105 = r104.getFirst();
        if (r105 == null) goto L7;
        int r106 = com.bytedance.android.shopping.extensions.b.a(r105);
    L8:
        Pair<Integer, Integer> r107 = r101.f181592g;
        if (r107 == null) goto L13;
        Integer r108 = r107.getSecond();
        if (r108 == null) goto L13;
        int r109 = com.bytedance.android.shopping.extensions.b.a(r108);
    L14:
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r106, r109);
        int r112 = f181563g;
        r111.leftMargin = r112;
        r111.rightMargin = r112;
        int r113 = f181564h;
        r111.topMargin = r113;
        r111.bottomMargin = r113;
        addView(r102, r111);
        w r114 = new w(getContext());
        this.f181567b = r114;
        int r115 = com.bytedance.android.shopping.extensions.b.a(24);
        int r116 = com.bytedance.android.shopping.extensions.b.a(24);
        int r117 = com.bytedance.android.shopping.extensions.b.a(2);
        int r118 = com.bytedance.android.shopping.extensions.b.a(10);
        ViewGroup.LayoutParams r119 = r114.f181577a.getLayoutParams();
        ViewGroup.LayoutParams r120 = null;
        if ((r119 instanceof FrameLayout.LayoutParams) == true) goto L17;
        r119 = null;
    L17:
        FrameLayout.LayoutParams r121 = (FrameLayout.LayoutParams) r119;
        if (r121 == null) goto L20;
        r121.width = r115;
        r121.height = r116;
        r121.leftMargin = r117;
        r121.topMargin = r118;
    L20:
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(40), com.bytedance.android.shopping.extensions.b.a(40));
        r122.gravity = 53;
        addView(r114, r122);
        w r123 = new w(getContext());
        this.f181568c = r123;
        int r124 = com.bytedance.android.shopping.extensions.b.a(24);
        int r125 = com.bytedance.android.shopping.extensions.b.a(24);
        int r126 = com.bytedance.android.shopping.extensions.b.a(6);
        int r127 = com.bytedance.android.shopping.extensions.b.a(9);
        ViewGroup.LayoutParams r128 = r123.f181577a.getLayoutParams();
        if ((r128 instanceof FrameLayout.LayoutParams) == false) goto L24;
        r120 = r128;
    L24:
        FrameLayout.LayoutParams r129 = (FrameLayout.LayoutParams) r120;
        if (r129 == null) goto L27;
        r129.width = r124;
        r129.height = r125;
        r129.leftMargin = r126;
        r129.topMargin = r127;
    L27:
        FrameLayout.LayoutParams r130 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(44), com.bytedance.android.shopping.extensions.b.a(44));
        r130.gravity = 85;
        addView(r123, r130);
        setOnClickListener(new o(this));
        w r131 = this.f181568c;
        if (r131 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L30:
        r131.setOnClickListener(new p(this));
        w r132 = this.f181567b;
        if (r132 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L33:
        r132.setImageResource(R.drawable.anchor_v4_float_video_icon_close);
        w r133 = this.f181567b;
        if (r133 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L36:
        r133.setOnClickListener(new q(this));
        a();
        String r134 = a2.d(r110.f181531d.f181516j.f181555d.f181589d);
        if (r134 == null) goto L43;
        a0 r135 = this.f181566a;
        if (r135 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L41:
        r135.getTvBottomLeft().setText(r134);
        return;
    L43:
        return;
    L13:
        r109 = f181561e;
    L7:
        r106 = f181562f;
        goto L8
    }
}
