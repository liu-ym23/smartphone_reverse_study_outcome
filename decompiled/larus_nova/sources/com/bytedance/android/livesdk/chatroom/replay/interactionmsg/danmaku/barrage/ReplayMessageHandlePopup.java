package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.a0;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.b0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayMessageHandlePopup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f108960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f108961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f108962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f108963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f108964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f108965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f108966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f108967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f108968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f108969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f108970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f108971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f108972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f108973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.base.view.e.b f108974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.base.view.e.b f108975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f108976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f108977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.b f108978s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f108979t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/barrage/ReplayMessageHandlePopup$TrianglePosition;", "", "CENTER_TOP", "CENTER_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "LEFT_TOP", "LEFT_BOTTOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TrianglePosition extends Enum<TrianglePosition> {
        public static final TrianglePosition CENTER_BOTTOM = null;
        public static final TrianglePosition CENTER_TOP = null;
        public static final TrianglePosition LEFT_BOTTOM = null;
        public static final TrianglePosition LEFT_TOP = null;
        public static final TrianglePosition RIGHT_BOTTOM = null;
        public static final TrianglePosition RIGHT_TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TrianglePosition[] f108980a = null;

        static {
            TrianglePosition r100 = new TrianglePosition("CENTER_TOP", 0);
            CENTER_TOP = r100;
            TrianglePosition r101 = new TrianglePosition("CENTER_BOTTOM", 1);
            CENTER_BOTTOM = r101;
            TrianglePosition r102 = new TrianglePosition("RIGHT_TOP", 2);
            RIGHT_TOP = r102;
            TrianglePosition r103 = new TrianglePosition("RIGHT_BOTTOM", 3);
            RIGHT_BOTTOM = r103;
            TrianglePosition r104 = new TrianglePosition("LEFT_TOP", 4);
            LEFT_TOP = r104;
            TrianglePosition r105 = new TrianglePosition("LEFT_BOTTOM", 5);
            LEFT_BOTTOM = r105;
            f108980a = new TrianglePosition[]{r100, r101, r102, r103, r104, r105};
        }

        public static TrianglePosition valueOf(String r100) {
            return (TrianglePosition) r27.a.a(TrianglePosition.class, r100);
        }

        public static TrianglePosition[] values() {
            return (TrianglePosition[]) f108980a.clone();
        }

        public TrianglePosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public final class b extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f108981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f108982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f108983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Path f108984d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f108985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TrianglePosition f108986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ReplayMessageHandlePopup f108987g;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            this.f108982b.set(getBounds());
            this.f108984d.reset();
            float r101 = this.f108982b.height();
            float r102 = this.f108983c + this.f108987g.f108971l;
            switch(g.f109012a[this.f108986f.ordinal()]) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L11;
            };
        L5:
            RectF r103 = this.f108982b;
            float r104 = r103.bottom;
            float r105 = this.f108987g.f108969j;
            r103.bottom = r104 - r105;
            float r106 = (r103.right - r102) - r105;
            this.f108984d.moveTo(r106, r101);
            this.f108984d.lineTo(r106 - this.f108987g.f108969j, this.f108982b.bottom);
            this.f108984d.lineTo(this.f108987g.f108969j + r106, this.f108982b.bottom);
            this.f108984d.lineTo(r106, r101);
            goto L11
        L6:
            RectF r107 = this.f108982b;
            float r108 = this.f108987g.f108969j;
            r107.top = r108;
            float r109 = (r107.right - r102) - r108;
            this.f108984d.moveTo(r109, 0.0f);
            Path r110 = this.f108984d;
            float r111 = this.f108987g.f108969j;
            r110.lineTo(r109 - r111, r111);
            Path r112 = this.f108984d;
            float r113 = this.f108987g.f108969j;
            r112.lineTo(r109 + r113, r113);
            this.f108984d.lineTo(r109, 0.0f);
            goto L11
        L7:
            RectF r114 = this.f108982b;
            float r115 = r114.bottom;
            float r116 = this.f108987g.f108969j;
            r114.bottom = r115 - r116;
            float r117 = r102 + r116;
            this.f108984d.moveTo(r117, r101);
            this.f108984d.lineTo(r117 - this.f108987g.f108969j, this.f108982b.bottom);
            this.f108984d.lineTo(this.f108987g.f108969j + r117, this.f108982b.bottom);
            this.f108984d.lineTo(r117, r101);
            goto L11
        L8:
            RectF r118 = this.f108982b;
            float r119 = this.f108987g.f108969j;
            r118.top = r119;
            float r120 = r102 + r119;
            this.f108984d.moveTo(r120, 0.0f);
            Path r121 = this.f108984d;
            float r122 = this.f108987g.f108969j;
            r121.lineTo(r120 - r122, r122);
            Path r123 = this.f108984d;
            float r124 = this.f108987g.f108969j;
            r123.lineTo(r120 + r124, r124);
            this.f108984d.lineTo(r120, 0.0f);
            goto L11
        L9:
            RectF r125 = this.f108982b;
            r125.bottom -= this.f108987g.f108969j;
            this.f108984d.moveTo(r125.centerX(), r101);
            this.f108984d.lineTo(this.f108982b.centerX() - this.f108987g.f108969j, this.f108982b.bottom);
            this.f108984d.lineTo(this.f108982b.centerX() + this.f108987g.f108969j, this.f108982b.bottom);
            this.f108984d.lineTo(this.f108982b.centerX(), r101);
            goto L11
        L10:
            RectF r126 = this.f108982b;
            r126.top = this.f108987g.f108969j;
            this.f108984d.moveTo(r126.centerX(), 0.0f);
            Path r127 = this.f108984d;
            float r128 = this.f108982b.centerX();
            float r129 = this.f108987g.f108969j;
            r127.lineTo(r128 - r129, r129);
            Path r130 = this.f108984d;
            float r131 = this.f108982b.centerX();
            float r132 = this.f108987g.f108969j;
            r130.lineTo(r131 + r132, r132);
            this.f108984d.lineTo(this.f108982b.centerX(), 0.0f);
        L11:
            this.f108981a.setColor(this.f108985e);
            this.f108981a.setStyle(Paint.Style.FILL);
            r100.drawPath(this.f108984d, this.f108981a);
            RectF r133 = this.f108982b;
            float r134 = this.f108983c;
            r100.drawRoundRect(r133, r134, r134, this.f108981a);
        }

        public b(ReplayMessageHandlePopup r100, TrianglePosition r101) {
            Intrinsics.checkNotNullParameter(r101, "trianglePosition");
            this.f108987g = r100;
            this.f108986f = r101;
            this.f108981a = new Paint(1);
            this.f108982b = new RectF();
            this.f108983c = r100.f108972m;
            this.f108984d = new Path();
            this.f108985e = ColorProtector.parseColor("#1A1A1A");
        }
    }

    public final void a() {
        Disposable r100 = this.f108968i;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f108968i = null;
        if (this.f108975p.f117985a.f117981b.isRunning() == false) goto L8;
        return;
    L8:
        this.f108975p.a();
    }

    public final Context getContext() {
        return this.f108976q;
    }

    public ReplayMessageHandlePopup(Context r100, a0 r101, b0 r102, a r103, ReplayMessagePopupScene r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "onMessageHandleCallback");
        Intrinsics.checkNotNullParameter(r104, "popupScene");
        this.f108976q = r100;
        this.f108977r = r101;
        this.f108978s = r102;
        this.f108979t = r103;
        this.f108960a = "VSMessageHandlePopup";
        i r105 = new i(this, r100);
        this.f108961b = r105;
        this.f108971l = s1.e(8.0f);
        this.f108972m = s1.e(4.0f);
        if (h.f109013a[r104.ordinal()] == 1) goto L5;
        this.f108962c = (int) s1.e(100.0f);
        this.f108963d = (int) s1.e(37.0f);
        this.f108970k = s1.e(3.0f);
        this.f108969j = s1.e(7.0f);
    L6:
        r105.setContentView(LayoutInflater.from(r100).inflate(R.layout.ttlive_replay_message_handle_popup, null));
        r105.setWidth(this.f108962c);
        r105.setHeight(this.f108963d);
        r105.setOutsideTouchable(true);
        r105.setBackgroundDrawable(new ColorDrawable(0));
        r105.setAnimationStyle(0);
        r105.setOnDismissListener(new f(this));
        View r106 = r105.getContentView().findViewById(R.id.root_view);
        this.f108964e = r106;
        this.f108965f = r105.getContentView().findViewById(R.id.content_container);
        View r107 = r106.findViewById(R.id.tv_agree);
        this.f108966g = r107;
        View r108 = r106.findViewById(R.id.tv_report);
        this.f108967h = r108;
        TextView r109 = (TextView) r106.findViewById(R.id.tv_agree_plus);
        TextView r110 = (TextView) r106.findViewById(R.id.tv_agree_one);
        if (r108 == null) goto L15;
        TextView r111 = (TextView) r108;
        if (h.f109014b[r104.ordinal()] == 1) goto L11;
        r109.setTextSize(1, 16.0f);
        r110.setTextSize(1, 16.0f);
        r111.setTextSize(1, 12.0f);
    L12:
        r107.setOnClickListener(com.bytedance.android.livesdk.chatroom.vs_base.base.view.d.a(new AnonymousClass2(this)));
        r108.setOnClickListener(com.bytedance.android.livesdk.chatroom.vs_base.base.view.d.a(new AnonymousClass3(this)));
        this.f108973n = j.f109016a;
        ReplayMessageHandlePopup$showAnimController$1 r112 = new ReplayMessageHandlePopup$showAnimController$1(this);
        Intrinsics.checkNotNullParameter(r112, "init");
        com.bytedance.android.livesdk.chatroom.vs_base.base.view.e r113 = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.e();
        r112.invoke(r113);
        this.f108974o = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.e.b(r113);
        ReplayMessageHandlePopup$dismissAnimController$1 r114 = new ReplayMessageHandlePopup$dismissAnimController$1(this);
        Intrinsics.checkNotNullParameter(r114, "init");
        com.bytedance.android.livesdk.chatroom.vs_base.base.view.e r115 = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.e();
        r114.invoke(r115);
        this.f108975p = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.e.b(r115);
        return;
    L11:
        r109.setTextSize(1, 12.0f);
        r110.setTextSize(1, 12.0f);
        r111.setTextSize(1, 9.0f);
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L5:
        this.f108962c = (int) s1.e(75.0f);
        this.f108963d = (int) s1.e(30.0f);
        this.f108970k = s1.e(2.0f);
        this.f108969j = s1.e(6.0f);
        goto L6
    }
}
