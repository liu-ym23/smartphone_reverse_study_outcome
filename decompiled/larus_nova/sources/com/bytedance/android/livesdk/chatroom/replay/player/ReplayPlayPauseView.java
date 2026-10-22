package com.bytedance.android.livesdk.chatroom.replay.player;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\"\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010)\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R*\u0010.\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/ReplayPlayPauseView;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "", "setBgBitmap", "", ce.f26391f, "Z", "getEnableBitmapBg", "()Z", "setEnableBitmapBg", "(Z)V", "enableBitmapBg", "", ce.f26395j, FaceService.girlLabel, "getMSizeRatio", "()F", "setMSizeRatio", "(F)V", "mSizeRatio", ce.f26396k, "getHeightOffset", "setHeightOffset", "heightOffset", "l", "getWidthOffset", "setWidthOffset", "widthOffset", "m", "getPlayStatus", "setPlayStatus", "playStatus", OfficeSDKRequestTag.KEY_NEW_USER, "getMPauseWidth", "setMPauseWidth", "mPauseWidth", "u", "getMPlayWidth", "setMPlayWidth", "mPlayWidth", "value", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getProgress", "setProgress", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayPauseView extends View {
    public float A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PaintFlagsDrawFilter f109515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f109516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f109517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f109518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f109519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f109520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f109521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f109522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f109523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f109524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f109525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f109526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f109527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f109528n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PointF f109529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f109530p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f109531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f109532r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f109533s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f109534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f109535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PointF f109536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f109537w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f109538x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f109539y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f109540z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayPauseView f109541a;

        public b(ReplayPlayPauseView r100) {
            this.f109541a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ReplayPlayPauseView r101 = this.f109541a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setProgress(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayPauseView f109542a;

        public c(ReplayPlayPauseView r100) {
            this.f109542a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ReplayPlayPauseView r101 = this.f109542a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setProgress(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void b() {
        this.f109527m = false;
        a();
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 50.0f});
        r100.setDuration(350);
        r100.setInterpolator(new AccelerateInterpolator());
        r100.addUpdateListener(new b(this));
        Unit r101 = Unit.INSTANCE;
        this.f109520f = r100;
        r100.start();
    }

    public final void c() {
        this.f109527m = true;
        a();
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{50.0f, 100.0f});
        r100.setDuration(350);
        r100.setInterpolator(new DecelerateInterpolator());
        r100.setStartDelay(70);
        r100.addUpdateListener(new c(this));
        Unit r101 = Unit.INSTANCE;
        this.f109519e = r100;
        r100.start();
    }

    public final void a() {
        this.f109520f.removeAllListeners();
        this.f109519e.removeAllListeners();
        this.f109519e.cancel();
        this.f109520f.cancel();
    }

    public final boolean getEnableBitmapBg() {
        return this.f109521g;
    }

    public final float getHeightOffset() {
        return this.f109525k;
    }

    public final float getMPauseWidth() {
        return this.f109528n;
    }

    public final float getMPlayWidth() {
        return this.f109535u;
    }

    public final float getMSizeRatio() {
        return this.f109524j;
    }

    public final boolean getPlayStatus() {
        return this.f109527m;
    }

    public final float getProgress() {
        return this.A;
    }

    public final float getWidthOffset() {
        return this.f109526l;
    }

    public ReplayPlayPauseView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        if (this.f109521g == false) goto L5;
        setLayerType(2, null);
        r210.drawARGB(0, 0, 0, 0);
    L5:
        r210.setDrawFilter(this.f109515a);
        r210.save();
        r210.translate(this.f109526l, this.f109525k);
        float r100 = this.f109524j;
        r210.scale(r100, r100);
        float r101 = this.A;
        float r110 = 25;
        if (r101 > r110) goto L8;
    L10:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
    L23:
        float r103 = this.A;
        if (r103 > r110) goto L26;
    L29:
        boolean r104 = true;
    L31:
        if (r104 == false) goto L34;
    L38:
        r210.restore();
        if (this.f109521g == false) goto L56;
        float r105 = this.A;
        float r106 = 50;
        if (r105 > r106) goto L43;
        float r107 = (r105 / r106) * 90.0f;
    L44:
        Bitmap r108 = this.f109522h;
        if (r108 == null) goto L47;
        int r109 = r108.getWidth();
    L48:
        Bitmap r111 = this.f109522h;
        if (r111 == null) goto L51;
        int r112 = r111.getHeight();
    L52:
        float r113 = r109;
        float r114 = r112;
        this.f109523i.setRotate(r107, r113 / 2.0f, r114 / 2.0f);
        float r115 = RangesKt.coerceAtMost((r210.getWidth() * 1.0f) / r113, (r210.getHeight() * 1.0f) / r114);
        this.f109523i.postScale(r115, r115);
        Bitmap r116 = this.f109522h;
        if (r116 == null) goto L57;
        r210.drawBitmap(r116, this.f109523i, this.f109518d);
        return;
    L57:
        return;
    L51:
        r112 = 0;
        goto L52
    L47:
        r109 = 0;
        goto L48
    L43:
        r107 = (1 - ((r105 - r106) / r106)) * 90.0f;
        goto L44
    L56:
        return;
    L34:
        if (r103 >= 50) goto L36;
        float r117 = (r103 - r110) / r110;
    L37:
        this.f109516b.setStrokeWidth(this.f109535u);
        PointF r118 = this.f109536v;
        float r119 = r118.x;
        float r120 = r119 - this.f109537w;
        float r121 = r118.y;
        float r122 = (this.f109538x * r117) / 2.0f;
        float r123 = r121 - r122;
        float r124 = r122 + r121;
        float r125 = 2;
        float r126 = this.f109539y;
        float r127 = ((r119 + r120) / r125) + r126;
        float r128 = ((r121 + r123) / r125) - r126;
        float r129 = ((r121 + r124) / r125) + r126;
        float r130 = r120 - this.f109540z;
        this.f109534t.reset();
        Path r131 = this.f109534t;
        PointF r132 = this.f109536v;
        r131.moveTo(r132.x, r132.y);
        this.f109534t.quadTo(r127, r128, r120, r123);
        this.f109534t.quadTo(r130, r121, r120, r124);
        Path r133 = this.f109534t;
        PointF r134 = this.f109536v;
        r133.quadTo(r127, r129, r134.x, r134.y);
        this.f109534t.close();
        r210.drawPath(this.f109534t, this.f109516b);
        goto L38
    L36:
        r117 = 1 - ((r103 - 50.0f) / r110);
        goto L37
    L26:
        if (r103 >= 75) goto L29;
        r104 = false;
        goto L31
    L15:
        if (r101 > r110) goto L17;
        float r135 = r101 / r110;
    L18:
        float r136 = r135 * 90.0f;
        double r137 = ((double) r136) * 0.017453292519943295d;
        float r138 = (float) Math.cos(r137);
        float r139 = (float) Math.sin(r137);
        float r140 = 90;
        float r141 = this.f109530p;
        float r142 = (-1.0f) / (r140 / r141);
        if (r136 > r140) goto L21;
        float r143 = UtilityKotlinExtentionsKt.b((r142 * r136) + r141);
    L22:
        PointF r144 = this.f109529o;
        float r145 = r144.x + (this.f109533s * r135);
        float r146 = r144.y;
        float r147 = r143 * r138;
        float r148 = r145 - r147;
        float r149 = r143 * r139;
        float r150 = r146 - r149;
        float r151 = r145 + r147;
        float r152 = r146 + r149;
        float r153 = this.f109531q;
        float r154 = r153 * r139;
        float r155 = r148 + r154;
        float r156 = r153 * r138;
        float r157 = r150 - r156;
        float r158 = r148 - r154;
        float r159 = r150 + r156;
        float r160 = this.f109532r;
        float r161 = r139 * r160;
        float r162 = r160 * r138;
        this.f109517c.setStrokeWidth(this.f109528n);
        r210.drawLine(r155, r157, r158, r159, this.f109517c);
        r210.drawLine(r151 + r161, r152 - r162, r151 - r161, r152 + r162, this.f109517c);
        goto L23
    L21:
        r143 = UtilityKotlinExtentionsKt.b((r142 * Math.abs(r136 - 180.0f)) + this.f109530p);
        goto L22
    L17:
        r135 = 1 - ((r101 - 75) / r110);
        goto L18
    L8:
        if (r101 >= 75) goto L10;
        r102 = true;
        goto L12
    }

    public final void setBgBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L6;
        Bitmap r101 = r100;
    L7:
        if (r101 == null) goto L11;
        this.f109522h = r100;
        invalidate();
        return;
    L11:
        return;
    L6:
        r101 = null;
        goto L7
    }

    public final void setEnableBitmapBg(boolean r100) {
        this.f109521g = r100;
    }

    public final void setHeightOffset(float r100) {
        this.f109525k = r100;
    }

    public final void setMPauseWidth(float r100) {
        this.f109528n = r100;
    }

    public final void setMPlayWidth(float r100) {
        this.f109535u = r100;
    }

    public final void setMSizeRatio(float r100) {
        this.f109524j = r100;
    }

    public final void setPlayStatus(boolean r100) {
        this.f109527m = r100;
    }

    public final void setProgress(float r100) {
        if (r100 >= 0) goto L6;
        r100 = 0.0f;
    L8:
        this.A = r100;
        invalidate();
        return;
    L6:
        if (r100 <= 100.0f) goto L8;
        r100 = 100.0f;
        goto L8
    }

    public final void setWidthOffset(float r100) {
        this.f109526l = r100;
    }

    public ReplayPlayPauseView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f109515a = new PaintFlagsDrawFilter(0, 3);
        this.f109516b = new Paint();
        this.f109517c = new Paint();
        Paint r102 = new Paint();
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Unit r103 = Unit.INSTANCE;
        this.f109518d = r102;
        this.f109519e = new ValueAnimator();
        this.f109520f = new ValueAnimator();
        Bitmap r104 = s1.g(R.drawable.ttlive_play_pause_bg);     // Catch: Exception -> L5
    L6:
        this.f109522h = r104;
        this.f109523i = new Matrix();
        this.f109524j = 1.0f;
        this.f109527m = true;
        this.f109528n = UtilityKotlinExtentionsKt.b(3.25f);
        this.f109529o = new PointF(UtilityKotlinExtentionsKt.b(20.0f), UtilityKotlinExtentionsKt.b(20.0f));
        this.f109530p = 5.8f;
        this.f109531q = UtilityKotlinExtentionsKt.b(7.25f);
        this.f109532r = UtilityKotlinExtentionsKt.b(7.25f);
        this.f109533s = UtilityKotlinExtentionsKt.b(1.5f);
        this.f109534t = new Path();
        this.f109535u = UtilityKotlinExtentionsKt.b(2.5f);
        this.f109536v = new PointF(UtilityKotlinExtentionsKt.b(28.75f), UtilityKotlinExtentionsKt.b(20.0f));
        this.f109537w = UtilityKotlinExtentionsKt.b(14.5f);
        this.f109538x = UtilityKotlinExtentionsKt.b(15.2f);
        this.f109539y = UtilityKotlinExtentionsKt.b(0.5f);
        this.f109540z = UtilityKotlinExtentionsKt.b(0.45f);
        this.f109517c.setAntiAlias(true);
        this.f109517c.setDither(true);
        this.f109517c.setFilterBitmap(true);
        this.f109517c.setStyle(Paint.Style.FILL);
        this.f109517c.setColor(-1);
        this.f109517c.setStrokeCap(Paint.Cap.ROUND);
        this.f109516b.setAntiAlias(true);
        this.f109516b.setDither(true);
        this.f109516b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f109516b.setColor(-1);
        this.f109516b.setStrokeCap(Paint.Cap.ROUND);
        this.f109516b.setStrokeJoin(Paint.Join.ROUND);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.resolveSize(getSuggestedMinimumHeight(), r101);
        int r103 = View.resolveSize(getSuggestedMinimumWidth(), r100);
        int r104 = Math.min(r102, r103);
        this.f109524j = r104 / ((int) UtilityKotlinExtentionsKt.b(40.0f));
        this.f109525k = (r102 - r104) / 2.0f;
        this.f109526l = (r103 - r104) / 2.0f;
    }
}
