package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import ec2.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tc2.d;
import vk6.g;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020\n¢\u0006\u0004\bf\u0010gJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001a\u00104\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u00107\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u001a\u0010:\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u001a\u0010=\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u00103R\u001a\u0010@\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\b>\u00101\u001a\u0004\b?\u00103R\u001a\u0010C\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u00103R\u001a\u0010F\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bD\u00101\u001a\u0004\bE\u00103R\u001a\u0010I\u001a\u00020/8\u0006X\u0086D¢\u0006\f\n\u0004\bG\u00101\u001a\u0004\bH\u00103R'\u0010O\u001a\u0012\u0012\u0004\u0012\u00020/0Jj\b\u0012\u0004\u0012\u00020/`K8\u0006¢\u0006\f\n\u0004\b\u0018\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010R\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bP\u0010\u0018\u001a\u0004\bQ\u0010\u001aR\u0017\u0010U\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bS\u0010\u0018\u001a\u0004\bT\u0010\u001aR\u0017\u0010W\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\bV\u0010\u001aR\u0017\u0010Z\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bX\u0010\u0018\u001a\u0004\bY\u0010\u001aR'\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00160Jj\b\u0012\u0004\u0012\u00020\u0016`K8\u0006¢\u0006\f\n\u0004\b[\u0010L\u001a\u0004\b\\\u0010NR\u001b\u0010`\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010(\u001a\u0004\b_\u0010*¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/view/CarnivalRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", "", "support", "", "setSupportRotate", "enable", "setEnableEdgeBlur", "setEnableMask", "setCanDrawDanmakuEdge", "", RXScreenCaptureService.KEY_INDEX, "I", "getRealWidth", "()I", "setRealWidth", "(I)V", "realWidth", ce.f26395j, "getRealHeight", "setRealHeight", "realHeight", "", ce.f26396k, FaceService.girlLabel, "getAngle", "()F", "setAngle", "(F)V", "angle", "kotlin.jvm.PlatformType", "q", "Ljava/lang/Boolean;", "getDebug", "()Ljava/lang/Boolean;", "setDebug", "(Ljava/lang/Boolean;)V", "debug", "Landroid/graphics/Paint;", "r", "Lkotlin/Lazy;", "getDanmakuLinePaint", "()Landroid/graphics/Paint;", "danmakuLinePaint", "u", "getEdgePaint", "edgePaint", "", "x", "Ljava/lang/String;", "getColor0", "()Ljava/lang/String;", "color0", "y", "getColor1", "color1", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getColor2", "color2", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getColor3", "color3", "B", "getColor4", "color4", "C", "getColor5", "color5", "D", "getColor6", "color6", ExifInterface.LONGITUDE_EAST, "getColor7", "color7", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getColorArr", "()Ljava/util/ArrayList;", "colorArr", "G", "getWidth0", "width0", FaceService.neutralLabel, "getWidth2", "width2", "getWidth4", "width4", "J", "getWidth6", "width6", "K", "getWidthArr", "widthArr", "L", "getMaskEdgePaint", "maskEdgePaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarnivalRenderEngineView extends RenderEngineView {
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final ArrayList<String> F;
    public final float G;
    public final float H;
    public final float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final float f134032J;
    public final ArrayList<Float> K;
    public final Lazy L;
    public int M;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.live.artist.utils.b f134033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f134034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f134035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f134036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RenderRequest f134037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, a> f134038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f134039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f134040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f134041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f134042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f134043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinearGradient f134044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Matrix f134045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f134046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f134047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f134048w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f134049x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f134050y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f134051z;

    public CarnivalRenderEngineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CarnivalRenderEngineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getDanmakuLinePaint() {
        return (Paint) this.f134043r.getValue();
    }

    private final Paint getEdgePaint() {
        return (Paint) this.f134046u.getValue();
    }

    private final Paint getMaskEdgePaint() {
        return (Paint) this.L.getValue();
    }

    public final void setEnableEdgeBlur(boolean r100) {
    }

    public final float getAngle() {
        return this.f134036k;
    }

    public final String getColor0() {
        return this.f134049x;
    }

    public final String getColor1() {
        return this.f134050y;
    }

    public final String getColor2() {
        return this.f134051z;
    }

    public final String getColor3() {
        return this.A;
    }

    public final String getColor4() {
        return this.B;
    }

    public final String getColor5() {
        return this.C;
    }

    public final String getColor6() {
        return this.D;
    }

    public final String getColor7() {
        return this.E;
    }

    public final ArrayList<String> getColorArr() {
        return this.F;
    }

    public final Boolean getDebug() {
        return this.f134042q;
    }

    public final int getRealHeight() {
        return this.f134035j;
    }

    public final int getRealWidth() {
        return this.f134034i;
    }

    public final float getWidth0() {
        return this.G;
    }

    public final float getWidth2() {
        return this.H;
    }

    public final float getWidth4() {
        return this.I;
    }

    public final float getWidth6() {
        return this.f134032J;
    }

    public final ArrayList<Float> getWidthArr() {
        return this.K;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void e(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = r100.getWidth();
        float r102 = r100.getHeight();
        if (this.f134041p == false) goto L6;
        r100.restore();
    L6:
        if (this.f134040o == false) goto L16;
        Iterator r103 = ((LinkedHashMap) this.f134038m).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        a r104 = (a) ((Map.Entry) r103.next()).getValue();
        long r105 = System.currentTimeMillis();
        r104.getClass();
        if ((r105 - 0) >= this.f134039n) goto L9;
        throw null;
    L16:
        if (this.f134047v == false) goto L18;
        RectF r106 = this.f134048w;
        r106.left = 0.0f;
        r106.top = 0.0f;
        r106.right = r101;
        r106.bottom = r102;
        this.f134045t.reset();
        this.f134045t.setTranslate(0.0f, 0.0f);
        this.f134045t.postScale(r102, r102, 0.0f, 0.0f);
        float r107 = r102 * 0.5f;
        this.f134045t.postRotate(90.0f, r107, r107);
        this.f134044s.setLocalMatrix(this.f134045t);
        getEdgePaint().setShader(this.f134044s);
        r100.drawRect(this.f134048w, getEdgePaint());
    L18:
        r100.restoreToCount(this.M);
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void f(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = r110.getWidth();
        float r101 = r110.getHeight();
        if (this.f134041p == false) goto L5;
        this.M = r110.saveLayer(0.0f, 0.0f, this.f134034i, this.f134035j, null, 31);
        r110.save();
        r110.translate((-(this.f134034i - r100)) * 0.5f, (-(this.f134035j - r101)) * 0.5f);
        r110.rotate(this.f134036k, this.f134034i / 2.0f, this.f134035j / 2.0f);
        return;
    L5:
        this.M = r110.saveLayer(0.0f, 0.0f, r100, r101, null, 31);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f134036k != 0.0f) goto L15;
        RenderRequest r101 = this.f134037l;
        if (r100.getAction() != 0) goto L15;
        if (r101 == null) goto L15;
        final float r102 = r100.getX();
        final float r103 = r100.getY();
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = null;
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        r105.element = false;
        r101.a(new AnonymousClass1(r105, r102, r103, r104));
        d r106 = (d) r104.element;
        if (r106 == null) goto L11;
        r106.onClick(this);
    L11:
        if (r105.element == false) goto L15;
        return true;
    L15:
        return super.onTouchEvent(r100);
    }

    public final void setAngle(float r100) {
        this.f134036k = r100;
    }

    public final void setCanDrawDanmakuEdge(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.f134047v = r101;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r101 = true;
        goto L7
    }

    public final void setDebug(Boolean r100) {
        this.f134042q = r100;
    }

    public final void setEnableMask(boolean r100) {
        this.f134040o = r100;
    }

    public final void setRealHeight(int r100) {
        this.f134035j = r100;
    }

    public final void setRealWidth(int r100) {
        this.f134034i = r100;
    }

    public final void setSupportRotate(boolean r100) {
        this.f134041p = r100;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void g(Canvas r100, RenderRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "request");
        com.bytedance.live.artist.utils.b r102 = this.f134033h;
        CarnivalRenderEngineView$render$1 r103 = new CarnivalRenderEngineView$render$1(this, r101, r100);
        r102.f254856a.put("renderAllUnits", Long.valueOf(System.nanoTime()));
        r103.invoke();
        r102.a("renderAllUnits");
        this.f134037l = r101;
    }

    public CarnivalRenderEngineView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        g r113 = g.f555528a;
        this.f134033h = new com.bytedance.live.artist.utils.b();
        this.f134038m = new LinkedHashMap();
        this.f134039n = 500;
        this.f134040o = true;
        this.f134041p = true;
        this.f134042q = v.f472063a.getValue();
        LazyThreadSafetyMode r114 = LazyThreadSafetyMode.NONE;
        this.f134043r = LazyKt.lazy(r114, CarnivalRenderEngineView$danmakuLinePaint$2.INSTANCE);
        PorterDuffXfermode r115 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r100 = new Paint();
        r100.setColor(-1);
        r100.setAntiAlias(true);
        r100.setDither(true);
        r100.setXfermode(r115);
        Unit r116 = Unit.INSTANCE;
        this.f134044s = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, new int[]{0, -1, -1, 0}, new float[]{0.0f, 0.05f, 0.95f, 1.0f}, Shader.TileMode.CLAMP);
        this.f134045t = new Matrix();
        this.f134046u = LazyKt.lazy(r114, CarnivalRenderEngineView$edgePaint$2.INSTANCE);
        this.f134047v = true;
        this.f134048w = new RectF();
        this.f134049x = "#D9FFFFFF";
        this.f134050y = "#B3FFFFFF";
        this.f134051z = "#8CFFFFFF";
        this.A = "#66FFFFFF";
        this.B = "#52FFFFFF";
        this.C = "#40FFFFFF";
        this.D = "#26FFFFFF";
        this.E = "#19FFFFFF";
        this.F = CollectionsKt.arrayListOf(new String[]{"#D9FFFFFF", "#B3FFFFFF", "#8CFFFFFF", "#66FFFFFF"});
        float r101 = (int) UtilityKotlinExtentionsKt.h(6.0f);
        this.G = r101;
        float r102 = (int) UtilityKotlinExtentionsKt.h(4.0f);
        this.H = r102;
        float r103 = (int) UtilityKotlinExtentionsKt.h(2.0f);
        this.I = r103;
        float r104 = (int) UtilityKotlinExtentionsKt.h(1.0f);
        this.f134032J = r104;
        this.K = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r101), Float.valueOf(r102), Float.valueOf(r103), Float.valueOf(r104)});
        this.L = LazyKt.lazy(r114, new CarnivalRenderEngineView$maskEdgePaint$2(this));
    }

    public /* synthetic */ CarnivalRenderEngineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
