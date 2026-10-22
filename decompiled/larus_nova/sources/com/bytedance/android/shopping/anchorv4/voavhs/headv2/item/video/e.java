package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f169782j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f169783k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f169784l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f169785m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f169786n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f169787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f169788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f169789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f169790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f169791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f169792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f169793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f169794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a f169795i;

    public static final class a {
    }

    static {
        f169782j = com.bytedance.android.shopping.extensions.b.a(44);
        f169783k = com.bytedance.android.shopping.extensions.b.a(12);
        f169784l = com.bytedance.android.shopping.extensions.b.a(22);
        f169785m = com.bytedance.android.shopping.extensions.b.a(24);
        f169786n = com.bytedance.android.shopping.extensions.b.a(64);
    }

    public final ViewGroup a(boolean r100) {
        FrameLayout r101 = new FrameLayout(getContext());
        ImageView r102 = new ImageView(r101.getContext());
        int r103 = f169783k;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r103, r103);
        if (r100 == false) goto L5;
        int r105 = VideoPlayDataContext.PLAYING_GRAVITY;
    L6:
        r104.gravity = r105;
        if (r100 == false) goto L9;
        r104.rightMargin = com.bytedance.android.shopping.extensions.b.a(8);
    L10:
        r104.bottomMargin = (this.f169794h - r103) / 2;
        Unit r106 = Unit.INSTANCE;
        r101.addView(r102, r104);
        int r107 = f169782j;
        r101.setLayoutParams(new LinearLayout.LayoutParams(r107, r107));
        return r101;
    L9:
        r104.leftMargin = com.bytedance.android.shopping.extensions.b.a(8);
        goto L10
    L5:
        r105 = 80;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f169787a.setColor(this.f169791e);
        float r100 = this.f169794h / 2.0f;
        float r101 = f169786n / 2.0f;
        boolean r102 = this.f169793g;
        Double r103 = Double.valueOf(0.5d);
        if (r102 == false) goto L5;
        float r104 = 0.0f;
    L7:
        if (this.f169793g == false) goto L9;
        int r105 = 6;
    L10:
        float r106 = q.a(Integer.valueOf(r105));
        this.f169787a.setStyle(Paint.Style.FILL);
        this.f169788b.set((getWidth() / 2.0f) - r101, getHeight() - this.f169794h, (getWidth() / 2.0f) + r101, getHeight());
        this.f169788b.inset(r104, r104);
        r110.drawRoundRect(this.f169788b, r100, r100, this.f169787a);
        float r107 = (-r104) / 2;
        this.f169788b.inset(r107, r107);
        this.f169787a.setStrokeWidth(r104);
        this.f169787a.setStyle(Paint.Style.STROKE);
        this.f169787a.setColor(this.f169792f);
        r110.drawRoundRect(this.f169788b, r100, r100, this.f169787a);
        this.f169787a.setStyle(Paint.Style.FILL);
        this.f169787a.setColor(872415231);
        this.f169787a.setStrokeWidth(q.a(r103));
        float r108 = (this.f169794h - r106) / 2.0f;
        r110.drawLine(getWidth() / 2.0f, getHeight() - r108, getWidth() / 2.0f, (getHeight() - r108) - r106, this.f169787a);
        super.dispatchDraw(r110);
        return;
    L9:
        r105 = 9;
        goto L10
    L5:
        r104 = q.a(r103);
        goto L7
    }

    public final void setAudioState(boolean r100) {
        ImageView r101 = this.f169789c;
        if (r100 == false) goto L9;
        if (this.f169793g == false) goto L7;
        int r102 = R.drawable.anchor_v4_head_video_audio_disable_lego;
    L12:
        r101.setImageResource(r102);
        return;
    L7:
        r102 = R.drawable.anchor_v4_head_video_audio_disable;
        goto L12
    L9:
        if (this.f169793g == false) goto L11;
        r102 = R.drawable.anchor_v4_head_video_audio_enable_lego;
        goto L12
    L11:
        r102 = R.drawable.anchor_v4_head_video_audio_enable;
        goto L12
    }

    public final void setPlayState(boolean r100) {
        ImageView r101 = this.f169790d;
        if (r100 == false) goto L9;
        if (this.f169793g == false) goto L7;
        int r102 = R.drawable.anchor_v4_head_video_state_pause_lego;
    L12:
        r101.setImageResource(r102);
        return;
    L7:
        r102 = R.drawable.anchor_v4_head_video_state_pause;
        goto L12
    L9:
        if (this.f169793g == false) goto L11;
        r102 = R.drawable.anchor_v4_head_video_state_play_lego;
        goto L12
    L11:
        r102 = R.drawable.anchor_v4_head_video_state_play;
        goto L12
    }

    public e(Context r100, VideoCoverLayout.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100, null);
        this.f169795i = r101;
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        r102.setStrokeWidth(q.a(1));
        r102.setStrokeCap(Paint.Cap.ROUND);
        Unit r103 = Unit.INSTANCE;
        this.f169787a = r102;
        this.f169788b = new RectF();
        this.f169791e = CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR;
        this.f169792f = 536870911;
        boolean r104 = r101.c();
        this.f169793g = r104;
        if (r104 == false) goto L5;
        int r105 = f169785m;
    L6:
        this.f169794h = r105;
        ViewGroup r106 = a(true);
        r106.setOnClickListener(new c(this));
        View r107 = r106.getChildAt(0);
        if (r107 == null) goto L15;
        this.f169789c = (ImageView) r107;
        addView(r106);
        ViewGroup r108 = a(false);
        r108.setOnClickListener(new d(this));
        View r109 = r108.getChildAt(0);
        if (r109 == null) goto L13;
        this.f169790d = (ImageView) r109;
        addView(r108);
        setOrientation(0);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L5:
        r105 = f169784l;
        goto L6
    }
}
