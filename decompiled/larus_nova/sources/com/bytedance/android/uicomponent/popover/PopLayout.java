package com.bytedance.android.uicomponent.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010v\u001a\u00020u¢\u0006\u0004\bw\u0010xB\u001b\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y¢\u0006\u0004\bw\u0010{B#\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y\u0012\u0006\u0010|\u001a\u00020\u0002¢\u0006\u0004\bw\u0010}J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R\"\u0010U\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010<\u001a\u0004\bW\u0010>\"\u0004\bX\u0010@R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010[\u001a\u0004\bb\u0010]\"\u0004\bc\u0010_R\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010[\u001a\u0004\bf\u0010]\"\u0004\bg\u0010_R\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010[\u001a\u0004\bj\u0010]\"\u0004\bk\u0010_R\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010[\u001a\u0004\bn\u0010]\"\u0004\bo\u0010_R\"\u0010t\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010[\u001a\u0004\br\u0010]\"\u0004\bs\u0010_¨\u0006~"}, d2 = {"Lcom/bytedance/android/uicomponent/popover/PopLayout;", "Landroid/widget/LinearLayout;", "", "bubbleOrientation", "", "setBubbleOrientation", "", "getBubbleOffset", "getPADDING", "", "need", "setNeedAddColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mFillPaint", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "d", "getMBubbleArrowPath", "setMBubbleArrowPath", "mBubbleArrowPath", "f", "getMWidth", "setMWidth", "mWidth", ce.f26391f, "getMHeight", "setMHeight", "mHeight", "h", "getMBorderBubbleArrowPath", "setMBorderBubbleArrowPath", "mBorderBubbleArrowPath", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "Landroid/graphics/RectF;", "getMBorderRoundRect", "()Landroid/graphics/RectF;", "setMBorderRoundRect", "(Landroid/graphics/RectF;)V", "mBorderRoundRect", ce.f26395j, "I", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mBorderWidth", "Landroid/graphics/Matrix;", ce.f26396k, "Landroid/graphics/Matrix;", "getMBorderMatrix", "()Landroid/graphics/Matrix;", "setMBorderMatrix", "(Landroid/graphics/Matrix;)V", "mBorderMatrix", OfficeSDKRequestTag.KEY_NEW_USER, "getMBgColor", "setMBgColor", "mBgColor", "o", "getMBorderColor", "setMBorderColor", "mBorderColor", "p", "getMCornerRadius", "setMCornerRadius", "mCornerRadius", "q", "getMShadowColor", "setMShadowColor", "mShadowColor", "r", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "u", "getMNeedPath", "setMNeedPath", "mNeedPath", BaseSwitches.V, "getMNeedPressFade", "setMNeedPressFade", "mNeedPressFade", "w", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "x", "getMNeedAddColor", "setMNeedAddColor", "mNeedAddColor", "y", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopLayout extends LinearLayout {
    public static int A;
    public static float B;
    public static float C;
    public static int D;
    public static int E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f187712z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f187713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f187714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f187715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f187716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f187717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f187718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f187719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f187720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f187721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f187722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Matrix f187723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f187724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Canvas f187725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f187726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f187727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f187728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f187729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f187730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f187731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f187732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f187733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f187734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f187735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f187736x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f187737y;

    public static final class a {
    }

    static {
    }

    public final float getBubbleOffset() {
        float r100 = Math.max(this.f187731s, C);
        int r101 = this.f187732t;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, this.f187718f - C);
    L18:
        return Math.min(r100, this.f187719g - C);
    L19:
        return Math.min(r100, this.f187719g - C);
    L15:
        return Math.min(r100, this.f187718f - C);
    }

    public final Path getMBorderBubbleArrowPath() {
        Path r100 = this.f187720h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L5:
        return r100;
    }

    public final Matrix getMBorderMatrix() {
        Matrix r100 = this.f187723k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L5:
        return r100;
    }

    public final RectF getMBorderRoundRect() {
        RectF r100 = this.f187721i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L5:
        return r100;
    }

    public final Path getMBubbleArrowPath() {
        Path r100 = this.f187716d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        return r100;
    }

    public final Paint getMFillPaint() {
        Paint r100 = this.f187714b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        return r100;
    }

    public final Path getMPath() {
        Path r100 = this.f187715c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r100;
    }

    public final int getPADDING() {
        return f187712z / 2;
    }

    public final int getMBgColor() {
        return this.f187726n;
    }

    public final int getMBorderColor() {
        return this.f187727o;
    }

    public final int getMBorderWidth() {
        return this.f187722j;
    }

    public final float getMCornerRadius() {
        return this.f187728p;
    }

    public final float getMHeight() {
        return this.f187719g;
    }

    public final boolean getMNeedAddColor() {
        return this.f187736x;
    }

    public final boolean getMNeedArrow() {
        return this.f187735w;
    }

    public final boolean getMNeedPath() {
        return this.f187733u;
    }

    public final boolean getMNeedPressFade() {
        return this.f187734v;
    }

    public final boolean getMNeedShadow() {
        return this.f187730r;
    }

    public final float getMPadding() {
        return this.f187713a;
    }

    public final int getMShadowColor() {
        return this.f187729q;
    }

    public final float getMWidth() {
        return this.f187718f;
    }

    public final boolean getUseDefaultView() {
        return this.f187737y;
    }

    public PopLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f187724l != null) goto L5;
        Bitmap r100 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f187724l = r100;
        this.f187725m = new Canvas(r100);
    L5:
        float r101 = this.f187718f;
        float r102 = this.f187719g;
        float r103 = Math.max(this.f187731s, C);
        Matrix r104 = new Matrix();
        this.f187723k = new Matrix();
        int r105 = this.f187732t;
        if (r105 != 0) goto L8;
        float r106 = Math.min(r103, r101 - C);
        r104.postRotate(90.0f);
        Matrix r107 = this.f187723k;
        if (r107 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L33:
        r107.postRotate(90.0f);
        Matrix r108 = this.f187723k;
        if (r108 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L36:
        int r109 = this.f187722j;
        r108.postTranslate((((r109 * 3) / 2) + r106) - ((f187712z * 3) / 2), r109 + 0.0f);
        setPadding(0, f187712z, 0, 0);
        setGravity(17);
        this.f187717e = new RectF(0.0f, f187712z, this.f187718f, this.f187719g);
        float r111 = (this.f187722j * 3) / 2;
        r104.postTranslate((r106 + r111) - ((f187712z * 3) / 2), r111 + 0.0f);
    L37:
        RectF r112 = this.f187717e;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L40:
        r112.left += (this.f187722j * 3) / 2;
        RectF r113 = this.f187717e;
        if (r113 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L43:
        r113.top += (this.f187722j * 3) / 2;
        RectF r114 = this.f187717e;
        if (r114 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L46:
        r114.right += (this.f187722j * 3) / 2;
        RectF r115 = this.f187717e;
        if (r115 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L49:
        r115.bottom += (this.f187722j * 3) / 2;
        float r116 = f187712z - e.a(getContext(), 1.4f);
        float r117 = f187712z - e.a(getContext(), 1.3f);
        RectF r118 = this.f187717e;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L52:
        r118.left += r116;
        RectF r119 = this.f187717e;
        if (r119 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L55:
        r119.top += r117;
        RectF r120 = this.f187717e;
        if (r120 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L58:
        r120.right += r116;
        RectF r121 = this.f187717e;
        if (r121 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L61:
        r121.bottom += r117;
        r104.postTranslate(r116, r117);
        Matrix r122 = this.f187723k;
        if (r122 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L64:
        r122.postTranslate(r116, r117);
        RectF r123 = new RectF();
        this.f187721i = r123;
        RectF r124 = this.f187717e;
        if (r124 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L67:
        r123.left = r124.left - (this.f187722j / 2);
        RectF r125 = this.f187721i;
        if (r125 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L70:
        RectF r126 = this.f187717e;
        if (r126 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L73:
        r125.top = r126.top - (this.f187722j / 2);
        RectF r127 = this.f187721i;
        if (r127 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L76:
        RectF r128 = this.f187717e;
        if (r128 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L79:
        r127.right = r128.right + (this.f187722j / 2);
        RectF r129 = this.f187721i;
        if (r129 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L82:
        RectF r130 = this.f187717e;
        if (r130 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L85:
        r129.bottom = r130.bottom + (this.f187722j / 2);
        if (this.f187730r == false) goto L92;
        Paint r131 = this.f187714b;
        if (r131 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L90:
        r131.setShadowLayer(16.0f, 0.0f, 0.0f, this.f187729q);
    L92:
        if (this.f187733u == false) goto L171;
        Paint r132 = this.f187714b;
        if (r132 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L96:
        r132.setColor(this.f187727o);
        Paint r133 = this.f187714b;
        if (r133 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L99:
        r133.setStyle(Paint.Style.STROKE);
        Paint r134 = this.f187714b;
        if (r134 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L102:
        r134.setStrokeWidth(this.f187722j);
        Path r135 = this.f187715c;
        if (r135 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L105:
        r135.reset();
        Path r136 = this.f187715c;
        if (r136 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L108:
        RectF r137 = this.f187721i;
        if (r137 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L111:
        float r138 = this.f187728p;
        int r139 = this.f187722j;
        r136.addRoundRect(r137, (r139 / 2) + r138, r138 + (r139 / 2), Path.Direction.CW);
        if (this.f187735w == false) goto L123;
        Path r140 = this.f187715c;
        if (r140 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L116:
        Path r141 = this.f187720h;
        if (r141 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L119:
        Matrix r142 = this.f187723k;
        if (r142 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L122:
        r140.addPath(r141, r142);
    L123:
        Canvas r143 = this.f187725m;
        if (r143 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L126:
        Path r144 = this.f187715c;
        if (r144 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L129:
        Paint r145 = this.f187714b;
        if (r145 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L132:
        r143.drawPath(r144, r145);
        if (this.f187736x == false) goto L171;
        Paint r146 = this.f187714b;
        if (r146 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L137:
        r146.setColor(getResources().getColor(R.color.ttlive_std_brand));
        Paint r147 = this.f187714b;
        if (r147 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L140:
        r147.setStyle(Paint.Style.STROKE);
        Path r148 = this.f187715c;
        if (r148 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L143:
        r148.reset();
        if (this.f187735w == false) goto L155;
        Path r149 = this.f187715c;
        if (r149 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L148:
        Path r150 = this.f187720h;
        if (r150 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L151:
        Matrix r151 = this.f187723k;
        if (r151 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L154:
        r149.addPath(r150, r151);
    L155:
        Path r152 = this.f187715c;
        if (r152 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L158:
        RectF r153 = this.f187721i;
        if (r153 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L161:
        float r154 = this.f187728p;
        int r155 = this.f187722j;
        r152.addRoundRect(r153, (r155 / 2) + r154, r154 + (r155 / 2), Path.Direction.CW);
        Canvas r156 = this.f187725m;
        if (r156 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L164:
        Path r157 = this.f187715c;
        if (r157 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L167:
        Paint r158 = this.f187714b;
        if (r158 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L170:
        r156.drawPath(r157, r158);
    L171:
        Paint r159 = this.f187714b;
        if (r159 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L174:
        r159.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r160 = this.f187714b;
        if (r160 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L177:
        r160.setColor(this.f187726n);
        Paint r161 = this.f187714b;
        if (r161 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L180:
        r161.setStyle(Paint.Style.FILL);
        Path r162 = this.f187715c;
        if (r162 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L183:
        r162.reset();
        Path r163 = this.f187715c;
        if (r163 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L186:
        RectF r164 = this.f187717e;
        if (r164 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L189:
        float r165 = this.f187728p;
        r163.addRoundRect(r164, r165, r165, Path.Direction.CW);
        if (this.f187735w == false) goto L198;
        Path r166 = this.f187715c;
        if (r166 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L194:
        Path r167 = this.f187716d;
        if (r167 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L197:
        r166.addPath(r167, r104);
    L198:
        Canvas r168 = this.f187725m;
        if (r168 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L201:
        Path r169 = this.f187715c;
        if (r169 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L204:
        Paint r170 = this.f187714b;
        if (r170 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L207:
        r168.drawPath(r169, r170);
        Paint r171 = this.f187714b;
        if (r171 != null) goto L210;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L210:
        r171.setXfermode(null);
        Bitmap r172 = this.f187724l;
        if (r172 == null) goto L214;
        r110.drawBitmap(r172, 0.0f, 0.0f, null);
        return;
    L214:
        return;
    L8:
        if (r105 == 1) goto L26;
        if (r105 == 2) goto L19;
        if (r105 != 3) goto L37;
        float r173 = Math.min(r103, r101 - C);
        r104.postRotate(270.0f);
        Matrix r174 = this.f187723k;
        if (r174 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L15:
        r174.postRotate(270.0f);
        Matrix r175 = this.f187723k;
        if (r175 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L18:
        int r176 = this.f187722j;
        r175.postTranslate((((r176 * 3) / 2) + r173) - ((f187712z * 3) / 2), (r176 * 2) + r102);
        setPadding(0, 0, 0, f187712z);
        setGravity(17);
        this.f187717e = new RectF(0.0f, 0.0f, this.f187718f, this.f187719g - f187712z);
        float r177 = (this.f187722j * 3) / 2;
        r104.postTranslate((r173 + r177) - ((f187712z * 3) / 2), r102 + r177);
        goto L37
    L19:
        float r178 = Math.min(r103, r102 - C);
        r104.postRotate(180.0f);
        Matrix r179 = this.f187723k;
        if (r179 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L22:
        r179.postRotate(180.0f);
        Matrix r180 = this.f187723k;
        if (r180 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L25:
        float r181 = this.f187722j * 2;
        r180.postTranslate(r181 + r101, (r181 + r178) - ((f187712z * 3) / 2));
        setPadding(0, 0, f187712z, 0);
        setGravity(17);
        this.f187717e = new RectF(0.0f, 0.0f, this.f187718f - f187712z, this.f187719g);
        int r182 = this.f187722j;
        r104.postTranslate(r101 + ((r182 * 3) / 2), (r178 + (r182 * 2)) - ((f187712z * 3) / 2));
        goto L37
    L26:
        float r183 = Math.min(r103, r102 - C);
        setPadding(f187712z, 0, 0, 0);
        setGravity(17);
        Matrix r184 = this.f187723k;
        if (r184 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L29:
        int r185 = this.f187722j;
        r184.postTranslate(r185 + 0.0f, ((r185 * 2) + r183) - ((f187712z * 3) / 2));
        this.f187717e = new RectF(f187712z, 0.0f, this.f187718f, this.f187719g);
        int r186 = this.f187722j;
        r104.postTranslate(((r186 * 3) / 2) + 0.0f, (r183 + (r186 * 2)) - ((f187712z * 3) / 2));
        goto L37
    }

    public final void setBubbleOrientation(int r100) {
        this.f187732t = r100;
    }

    public final void setMBgColor(int r100) {
        this.f187726n = r100;
    }

    public final void setMBorderBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187720h = r100;
    }

    public final void setMBorderColor(int r100) {
        this.f187727o = r100;
    }

    public final void setMBorderMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187723k = r100;
    }

    public final void setMBorderRoundRect(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187721i = r100;
    }

    public final void setMBorderWidth(int r100) {
        this.f187722j = r100;
    }

    public final void setMBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187716d = r100;
    }

    public final void setMCornerRadius(float r100) {
        this.f187728p = r100;
    }

    public final void setMFillPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187714b = r100;
    }

    public final void setMHeight(float r100) {
        this.f187719g = r100;
    }

    public final void setMNeedAddColor(boolean r100) {
        this.f187736x = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f187735w = r100;
    }

    public final void setMNeedPath(boolean r100) {
        this.f187733u = r100;
    }

    public final void setMNeedPressFade(boolean r100) {
        this.f187734v = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f187730r = r100;
    }

    public final void setMPadding(float r100) {
        this.f187713a = r100;
    }

    public final void setMPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187715c = r100;
    }

    public final void setMShadowColor(int r100) {
        this.f187729q = r100;
    }

    public final void setMWidth(float r100) {
        this.f187718f = r100;
    }

    public final void setNeedAddColor(boolean r100) {
        this.f187736x = r100;
    }

    public final void setUseDefaultView(boolean r100) {
        this.f187737y = r100;
    }

    public PopLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r210) {
        super.onMeasure(r110, r210);
        A = (int) (e.a(getContext(), 5.0f) + this.f187713a);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r100 = getChildAt(0);
        if (r100 == null) goto L8;
        TextView r101 = (TextView) r100;
    L10:
        int r102 = View.MeasureSpec.getMode(r110);
        int r103 = View.MeasureSpec.getSize(r110);
        int r104 = View.MeasureSpec.getMode(r210);
        int r105 = View.MeasureSpec.getSize(r210);
        if (r101 != null) goto L13;
        int r111 = getMeasuredWidth();
        char r106 = 0;
    L28:
        if (this.f187737y == false) goto L49;
        int r107 = this.f187732t;
        if (r107 == 2) goto L36;
        if (r107 == 1) goto L36;
        int r108 = D;
        if (r111 <= r108) goto L40;
        r108 = (A * 2) + r111;
    L40:
        if (r101 == null) goto L42;
        int r112 = ((int) e.a(getContext(), r101.getTextSize() - (this.f187722j * 2))) + (getContext().getResources().getDimensionPixelSize(R.dimen.uicomponent_popover_vertical_padding) * 2);
    L43:
        if (r106 != 2) goto L50;
        Context r109 = getContext();
        if (r101 == null) goto L47;
        float r113 = r101.getTextSize();
    L48:
        r112 = r112 + ((int) e.a(r109, r113));
        goto L50
    L47:
        r113 = 0.0f;
    L50:
        int r114 = this.f187722j;
        int r115 = r108 + (r114 * 3);
        int r116 = r112 + (r114 * 3);
        if (r102 != Integer.MIN_VALUE) goto L54;
        if (r104 != Integer.MIN_VALUE) goto L54;
        setMeasuredDimension(r115, r116);
    L58:
        this.f187718f = getMeasuredWidth() - (f187712z * 2);
        this.f187719g = getMeasuredHeight() - (f187712z * 2);
        return;
    L54:
        if (r102 != Integer.MIN_VALUE) goto L56;
        setMeasuredDimension(r115, r105);
        goto L58
    L56:
        if (r104 != Integer.MIN_VALUE) goto L58;
        setMeasuredDimension(r103, r116);
        goto L58
    L42:
        r112 = E;
    L36:
        int r117 = D;
        if (r111 <= r117) goto L39;
        r117 = (A * 2) + r111;
    L39:
        r108 = r117 + f187712z;
        goto L40
    L49:
        PopupWindow r118 = new PopupWindow(getChildAt(0), -2, -2, true);
        r118.getContentView().measure(0, 0);
        r108 = (r118.getContentView().getMeasuredWidth() + (f187712z * 3)) + A;
        r112 = (r118.getContentView().getMeasuredHeight() + (f187712z * 3)) + A;
        goto L50
    L13:
        if (((int) r101.getPaint().measureText(r101.getText().toString())) <= e.a(getContext(), 220.0f)) goto L24;
        int r119 = (int) e.a(getContext(), 220.0f);
        String r120 = r101.getText().toString();
        if (StringsKt.contains$default(r120, "\n", false, 2, null) == false) goto L23;
        TextPaint r121 = r101.getPaint();
        int r122 = StringsKt.indexOf$default(r120, "\n", 0, false, 6, null);
        if (r120 == null) goto L22;
        int r123 = (int) r121.measureText(r120.substring(0, r122));
        if (r123 >= r119) goto L23;
        r119 = r123;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L23:
        r106 = 2;
    L25:
        r111 = (r119 + r101.getPaddingLeft()) + r101.getPaddingRight();
        goto L28
    L24:
        r119 = (int) r101.getPaint().measureText(r101.getText().toString());
        r106 = 1;
        goto L25
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r101 = null;
        goto L10
    }

    public PopLayout(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        this.f187713a = 12.0f;
        this.f187729q = -16777216;
        this.f187731s = 0.75f;
        this.f187732t = 1;
        this.f187733u = true;
        this.f187735w = true;
        this.f187737y = true;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f187722j = (int) e.a(r110, 1.0f);
        f187712z = (int) e.a(r110, 7.0f);
        B = 2.0f;
        this.f187728p = e.a(r110, 8.0f);
        C = e.a(r110, 3.0f);
        D = (int) e.a(r110, 40.0f);
        E = (int) e.a(r110, 56.0f);
        this.f187714b = new Paint();
        this.f187715c = new Path();
        this.f187720h = new Path();
        this.f187716d = new Path();
        Paint r100 = this.f187714b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r100.setStyle(Paint.Style.FILL);
        Paint r101 = this.f187714b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r101.setStrokeCap(Paint.Cap.BUTT);
        Paint r102 = this.f187714b;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r102.setAntiAlias(true);
        Paint r103 = this.f187714b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r103.setStrokeWidth(B);
        Paint r104 = this.f187714b;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L17:
        r104.setStrokeJoin(Paint.Join.MITER);
        this.f187726n = getResources().getColor(R.color.ttlive_std_bg_tooltip);
        this.f187727o = getResources().getColor(R.color.ttlive_std_bg_tooltip);
        Paint r105 = this.f187714b;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r105.setColor(this.f187726n);
        Paint r106 = this.f187714b;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        setLayerType(1, r106);
        if (this.f187730r == false) goto L29;
        Paint r107 = this.f187714b;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L28:
        r107.setShadowLayer(16.0f, 0.0f, 0.0f, this.f187729q);
    L29:
        float r108 = e.a(getContext(), 2.0f);
        double r109 = 2.0f;
        float r112 = r108 / ((float) Math.sqrt(r109));
        Path r113 = this.f187716d;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L32:
        r113.moveTo(r112, -r112);
        Path r114 = this.f187716d;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L35:
        int r115 = f187712z;
        r114.lineTo(r115, -r115);
        Path r116 = this.f187716d;
        if (r116 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        float r117 = f187712z;
        r116.lineTo(r117, r117);
        Path r118 = this.f187716d;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L41:
        r118.lineTo(r112, r112);
        Path r119 = this.f187716d;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L44:
        float r120 = 2;
        float r121 = r112 * r120;
        r119.arcTo(new RectF(r121 - r108, -r108, r121 + r108, r108), 135.0f, 90.0f, true);
        Path r122 = this.f187716d;
        if (r122 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L47:
        r122.close();
        float r123 = e.a(getContext(), 2.0f) + this.f187722j;
        float r124 = r123 / ((float) Math.sqrt(r109));
        Path r125 = this.f187720h;
        if (r125 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L50:
        r125.moveTo(r124, -r124);
        Path r126 = this.f187720h;
        if (r126 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L53:
        r126.lineTo((float) (((double) f187712z) + (((double) this.f187722j) * Math.sqrt(2.0d))), (float) (((double) (-f187712z)) - (((double) this.f187722j) * Math.sqrt(2.0d))));
        Path r127 = this.f187720h;
        if (r127 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L56:
        r127.lineTo((float) (((double) f187712z) + (((double) this.f187722j) * Math.sqrt(2.0d))), (float) (((double) f187712z) + (((double) this.f187722j) * Math.sqrt(2.0d))));
        Path r128 = this.f187720h;
        if (r128 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L59:
        r128.lineTo(r124, r124);
        Path r129 = this.f187720h;
        if (r129 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L62:
        float r130 = r120 * r124;
        r129.arcTo(new RectF(r130 - r123, -r123, r130 + r123, r123), 135.0f, 90.0f, true);
        Path r131 = this.f187720h;
        if (r131 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L65:
        r131.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
