package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001YB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\u000b¢\u0006\u0004\bW\u0010XR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R*\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR*\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR*\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR.\u00102\u001a\u0004\u0018\u00010+2\b\u0010\u0003\u001a\u0004\u0018\u00010+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u0010DR\u001b\u0010H\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00105\u001a\u0004\bG\u0010DR\u001b\u0010K\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00105\u001a\u0004\bJ\u00107R\u001b\u0010N\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00105\u001a\u0004\bM\u0010DR\u001b\u0010Q\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u00105\u001a\u0004\bP\u0010D¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/profile/customview/TrapezoidConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "value", "b", FaceService.girlLabel, "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "", "c", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeColor", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "d", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getGradientOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "setGradientOrientation", "(Landroid/graphics/drawable/GradientDrawable$Orientation;)V", "gradientOrientation", "e", "getAcuteAnglePosition", "setAcuteAnglePosition", "acuteAnglePosition", "f", "getAcuteAngleDegree", "setAcuteAngleDegree", "acuteAngleDegree", ce.f26391f, "getLeftCornerRadius", "setLeftCornerRadius", "leftCornerRadius", "h", "getRightCornerRadius", "setRightCornerRadius", "rightCornerRadius", "", RXScreenCaptureService.KEY_INDEX, "[I", "getColors", "()[I", "setColors", "([I)V", "colors", "Landroid/graphics/Paint;", ce.f26395j, "Lkotlin/Lazy;", "getFillPaint", "()Landroid/graphics/Paint;", "fillPaint", ce.f26396k, "getStrokePaint", "strokePaint", "Landroid/graphics/RectF;", "l", "getDrawRect", "()Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Path;", "m", "getRoundPath", "()Landroid/graphics/Path;", "roundPath", OfficeSDKRequestTag.KEY_NEW_USER, "getTempRoundRectPath", "tempRoundRectPath", "o", "getTempAnglePaint", "tempAnglePaint", "p", "getTempAcuteAnglePathRaw", "tempAcuteAnglePathRaw", "q", "getTempAcuteAnglePath", "tempAcuteAnglePath", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrapezoidConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f85996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f85997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f85998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientDrawable.Orientation f85999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f86000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f86001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f86002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f86003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f86004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f86005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f86006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f86007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f86008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f86009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f86010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f86011p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f86012q;

    public static final class a {
    }

    static {
    }

    public TrapezoidConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TrapezoidConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final RectF getDrawRect() {
        return (RectF) this.f86007l.getValue();
    }

    private final Paint getFillPaint() {
        return (Paint) this.f86005j.getValue();
    }

    private final Path getRoundPath() {
        return (Path) this.f86008m.getValue();
    }

    private final Paint getStrokePaint() {
        return (Paint) this.f86006k.getValue();
    }

    private final Path getTempAcuteAnglePath() {
        return (Path) this.f86012q.getValue();
    }

    private final Path getTempAcuteAnglePathRaw() {
        return (Path) this.f86011p.getValue();
    }

    private final Paint getTempAnglePaint() {
        return (Paint) this.f86010o.getValue();
    }

    private final Path getTempRoundRectPath() {
        return (Path) this.f86009n.getValue();
    }

    public final void R5() {
        this.f85996a = true;
        setWillNotDraw(false);
    }

    public final void reset() {
        setStrokeWidth(0.0f);
        setStrokeColor(0);
        setGradientOrientation(GradientDrawable.Orientation.TL_BR);
        setAcuteAnglePosition(1);
        setAcuteAngleDegree(90.0f);
        setLeftCornerRadius(0.0f);
        setRightCornerRadius(0.0f);
        setColors(null);
    }

    public final float getAcuteAngleDegree() {
        return this.f86001f;
    }

    public final int getAcuteAnglePosition() {
        return this.f86000e;
    }

    public final int[] getColors() {
        return this.f86004i;
    }

    public final GradientDrawable.Orientation getGradientOrientation() {
        return this.f85999d;
    }

    public final float getLeftCornerRadius() {
        return this.f86002g;
    }

    public final float getRightCornerRadius() {
        return this.f86003h;
    }

    public final int getStrokeColor() {
        return this.f85998c;
    }

    public final float getStrokeWidth() {
        return this.f85997b;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f85996a == false) goto L47;
        this.f85996a = false;
        getDrawRect().set(0.0f, 0.0f, getWidth(), getHeight());
        int[] r100 = this.f86004i;
        if (r100 != null) goto L8;
        r100 = new int[]{0, 0};
    L8:
        int[] r111 = r100;
        RectF r101 = getDrawRect();
        switch(com.bytedance.android.live.profile.customview.a.f86013a[this.f85999d.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        float r102 = r101.left;
        float r103 = r101.top;
        float r104 = r101.right;
        float r105 = r101.bottom;
    L20:
        float r112 = r103;
        float r106 = r105;
        float r107 = r104;
        float r108 = r112;
    L21:
        float r109 = r107;
        float r113 = r106;
        float r114 = r102;
    L22:
        getFillPaint().setShader(new LinearGradient(r114, r108, r109, r113, r111, null, Shader.TileMode.CLAMP));
        getStrokePaint().setStrokeWidth(this.f85997b * 2);
        getStrokePaint().setColor(this.f85998c);
        int r115 = this.f86000e;
        if (r115 == 0) goto L27;
        if (r115 == 3) goto L27;
        boolean r116 = false;
    L28:
        Path r117 = getTempRoundRectPath();
        r117.reset();
        float r118 = this.f86002g;
        float r119 = this.f86003h;
        float[] r120 = {r118, r118, r119, r119, r119, r119, r118, r118};
        if (r116 == false) goto L31;
        r117.addRoundRect(getDrawRect().right * 0.4f, getDrawRect().top, getDrawRect().right, getDrawRect().bottom, r120, Path.Direction.CW);
    L32:
        r117.close();
        Paint r121 = getTempAnglePaint();
        if (r116 == false) goto L35;
        CornerPathEffect r122 = new CornerPathEffect(this.f86002g);
    L36:
        r121.setPathEffect(r122);
        Path r123 = getTempAcuteAnglePathRaw();
        r123.reset();
        float r124 = (float) (((double) getDrawRect().height()) * Math.tan(Math.toRadians(((double) 90) - ((double) this.f86001f))));
        int r125 = this.f86000e;
        if (r125 == 0) goto L45;
        if (r125 == 1) goto L44;
        if (r125 == 2) goto L43;
        if (r125 != 3) goto L46;
        r123.moveTo(r124, getDrawRect().top);
        r123.lineTo(getDrawRect().right * 0.6f, getDrawRect().top);
        r123.lineTo(getDrawRect().right * 0.6f, getDrawRect().bottom);
        r123.lineTo(getDrawRect().left, getDrawRect().bottom);
        r123.close();
    L46:
        Path r126 = getTempAcuteAnglePath();
        r121.getFillPath(r123, r126);
        getRoundPath().op(r117, r126, Path.Op.UNION);
        goto L47
    L43:
        r123.moveTo(getDrawRect().right * 0.4f, getDrawRect().top);
        r123.lineTo(getDrawRect().right - r124, getDrawRect().top);
        r123.lineTo(getDrawRect().right, getDrawRect().bottom);
        r123.lineTo(getDrawRect().right * 0.4f, getDrawRect().bottom);
        r123.close();
        goto L46
    L44:
        r123.moveTo(getDrawRect().right * 0.4f, getDrawRect().top);
        r123.lineTo(getDrawRect().right, getDrawRect().top);
        r123.lineTo(getDrawRect().right - r124, getDrawRect().bottom);
        r123.lineTo(getDrawRect().right * 0.4f, getDrawRect().bottom);
        r123.close();
        goto L46
    L45:
        r123.moveTo(getDrawRect().left, getDrawRect().top);
        r123.lineTo(getDrawRect().right * 0.6f, getDrawRect().top);
        r123.lineTo(getDrawRect().right * 0.6f, getDrawRect().bottom);
        r123.lineTo(r124, getDrawRect().bottom);
        r123.close();
        goto L46
    L35:
        r122 = new CornerPathEffect(this.f86003h);
        goto L36
    L31:
        r117.addRoundRect(getDrawRect().left, getDrawRect().top, getDrawRect().right * 0.6f, getDrawRect().bottom, r120, Path.Direction.CW);
    L27:
        r116 = true;
        goto L28
    L11:
        r102 = r101.left;
        r106 = r101.top;
        r107 = r101.right;
    L16:
        r108 = r106;
        goto L21
    L12:
        r102 = r101.left;
        r103 = r101.bottom;
        r104 = r101.right;
        r105 = r101.top;
        goto L20
    L13:
        float r127 = r101.left;
        float r128 = r101.bottom;
        float r129 = r101.top;
    L19:
        r113 = r129;
        r109 = r127;
        r108 = r128;
        r114 = r109;
        goto L22
    L14:
        r102 = r101.right;
        r103 = r101.bottom;
        r104 = r101.left;
        r105 = r101.top;
        goto L20
    L15:
        r102 = r101.right;
        r106 = r101.top;
        r107 = r101.left;
        goto L16
    L17:
        r102 = r101.right;
        r103 = r101.top;
        r104 = r101.left;
        r105 = r101.bottom;
        goto L20
    L18:
        r127 = r101.left;
        r128 = r101.top;
        r129 = r101.bottom;
    L47:
        r110.save();
        r110.clipPath(getRoundPath());
        r110.drawPath(getRoundPath(), getFillPaint());
        super.draw(r110);
        if (getStrokePaint().getStrokeWidth() <= 0) goto L50;
        r110.drawPath(getRoundPath(), getStrokePaint());
    L50:
        r110.restore();
    }

    public final void setAcuteAngleDegree(float r100) {
        R5();
        if (r100 < 90.0f) goto L5;
        r100 = 90.0f;
    L5:
        this.f86001f = r100;
    }

    public final void setAcuteAnglePosition(int r100) {
        R5();
        this.f86000e = r100;
    }

    public final void setColors(int[] r100) {
        R5();
        this.f86004i = r100;
    }

    public final void setGradientOrientation(GradientDrawable.Orientation r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        R5();
        this.f85999d = r100;
    }

    public final void setLeftCornerRadius(float r100) {
        R5();
        this.f86002g = r100;
    }

    public final void setRightCornerRadius(float r100) {
        R5();
        this.f86003h = r100;
    }

    public final void setStrokeColor(int r100) {
        R5();
        this.f85998c = r100;
    }

    public final void setStrokeWidth(float r100) {
        R5();
        this.f85997b = r100;
    }

    public TrapezoidConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f85999d = GradientDrawable.Orientation.TL_BR;
        this.f86000e = 1;
        this.f86001f = 90.0f;
        this.f86005j = LazyKt.lazy(TrapezoidConstraintLayout$fillPaint$2.INSTANCE);
        this.f86006k = LazyKt.lazy(TrapezoidConstraintLayout$strokePaint$2.INSTANCE);
        this.f86007l = LazyKt.lazy(TrapezoidConstraintLayout$drawRect$2.INSTANCE);
        this.f86008m = LazyKt.lazy(TrapezoidConstraintLayout$roundPath$2.INSTANCE);
        this.f86009n = LazyKt.lazy(TrapezoidConstraintLayout$tempRoundRectPath$2.INSTANCE);
        this.f86010o = LazyKt.lazy(TrapezoidConstraintLayout$tempAnglePaint$2.INSTANCE);
        this.f86011p = LazyKt.lazy(TrapezoidConstraintLayout$tempAcuteAnglePathRaw$2.INSTANCE);
        this.f86012q = LazyKt.lazy(TrapezoidConstraintLayout$tempAcuteAnglePath$2.INSTANCE);
    }

    public /* synthetic */ TrapezoidConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
