package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f167631f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f167632g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f167633h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f167634i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f167635j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f167636k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f167637l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f167638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f167639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f167640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f167641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f167642e;

    public static final class a {
    }

    static {
        int r100 = b.a(144);
        f167631f = r100;
        int r101 = b.a(80);
        f167632g = r101;
        f167633h = r100;
        f167634i = r101;
        f167635j = b.a(12);
        int r102 = b.a(8);
        f167636k = r102;
        f167637l = r100 + (r102 * 2);
    }

    public final void a() {
        if (this.f167642e.b() == false) goto L8;
        v r100 = this.f167640c;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L7:
        r100.setImageResource(R.drawable.anchor_v4_float_video_icon_audio_off);
        return;
    L8:
        v r101 = this.f167640c;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L11:
        r101.setImageResource(R.drawable.anchor_v4_float_video_icon_audio_on);
    }

    public final void b() {
        z r100 = this.f167638a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L5:
        gj.b r101 = this.f167642e.e();
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.isPlaying() != true) goto L10;
    L11:
        r100.f167676h = !r102;
        if (r102 == false) goto L17;
        View r103 = r100.f167673e;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L16:
        r103.setVisibility(8);
    L21:
        View r104 = r100.f167677i;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L24:
        r104.invalidate();
        return;
    L17:
        View r105 = r100.f167673e;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L20:
        r105.setVisibility(0);
    L10:
        r102 = false;
        goto L11
    }

    public final ViewGroup getVideoContainer() {
        z r100 = this.f167638a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L6:
        return r100.getVideoContainer();
    }

    public final boolean getTouched() {
        return this.f167641d;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        this.f167641d = true;
        return super.onInterceptTouchEvent(r100);
    }

    public final void setTouched(boolean r100) {
        this.f167641d = r100;
    }

    public m(Context r100, com.bytedance.android.shopping.anchorv4.video.float.a.b r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ability");
        super(r100);
        this.f167642e = r110;
        x r101 = r110.f167598d.f167594j.f167621e;
        z r102 = new z(getContext(), r110);
        r102.setRadius(b.a(12));
        this.f167638a = r102;
        Unit r103 = Unit.INSTANCE;
        Pair<Integer, Integer> r104 = r101.f167665g;
        if (r104 == null) goto L7;
        Integer r105 = r104.getFirst();
        if (r105 == null) goto L7;
        int r106 = b.a(r105);
    L8:
        Pair<Integer, Integer> r107 = r101.f167665g;
        if (r107 == null) goto L13;
        Integer r108 = r107.getSecond();
        if (r108 == null) goto L13;
        int r109 = b.a(r108);
    L14:
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r106, r109);
        int r112 = f167635j;
        r111.leftMargin = r112;
        r111.rightMargin = r112;
        int r113 = f167636k;
        r111.topMargin = r113;
        r111.bottomMargin = r113;
        addView(r102, r111);
        v r114 = new v(getContext());
        this.f167639b = r114;
        int r115 = b.a(24);
        int r116 = b.a(24);
        int r117 = b.a(2);
        int r118 = b.a(10);
        ViewGroup.LayoutParams r119 = r114.f167650a.getLayoutParams();
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
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(b.a(40), b.a(40));
        r122.gravity = 53;
        addView(r114, r122);
        v r123 = new v(getContext());
        this.f167640c = r123;
        int r124 = b.a(24);
        int r125 = b.a(24);
        int r126 = b.a(6);
        int r127 = b.a(9);
        ViewGroup.LayoutParams r128 = r123.f167650a.getLayoutParams();
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
        FrameLayout.LayoutParams r130 = new FrameLayout.LayoutParams(b.a(44), b.a(44));
        r130.gravity = 85;
        addView(r123, r130);
        setOnClickListener(new n(this));
        v r131 = this.f167640c;
        if (r131 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L30:
        r131.setOnClickListener(new o(this));
        v r132 = this.f167639b;
        if (r132 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L33:
        r132.setImageResource(R.drawable.anchor_v4_float_video_icon_close);
        v r133 = this.f167639b;
        if (r133 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L36:
        r133.setOnClickListener(new p(this));
        a();
        String r134 = a2.d(r110.f167598d.f167594j.f167621e.f167662d);
        if (r134 == null) goto L43;
        z r135 = this.f167638a;
        if (r135 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L41:
        r135.getTvBottomLeft().setText(r134);
        return;
    L43:
        return;
    L13:
        r109 = f167633h;
    L7:
        r106 = f167634i;
        goto L8
    }
}
