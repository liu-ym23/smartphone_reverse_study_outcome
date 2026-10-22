package com.bytedance.android.live.core.widget.bubble;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\u0015\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001B!\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0088\u0001B*\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001\u0012\u0007\u0010\u0089\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u008a\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010<\u001a\u0004\bS\u0010>\"\u0004\bT\u0010@R\"\u0010\\\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010W\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010W\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010W\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[R\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010W\u001a\u0004\bn\u0010Y\"\u0004\bo\u0010[R\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010<\u001a\u0004\br\u0010>\"\u0004\bs\u0010@R\"\u0010x\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\r\u001a\u0004\bv\u0010\u000f\"\u0004\bw\u0010\u0011R\"\u0010|\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010<\u001a\u0004\bz\u0010>\"\u0004\b{\u0010@R,\u0010\u0081\u0001\u001a\u00020\u00022\u0006\u0010}\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010<\u001a\u0004\b\u007f\u0010>\"\u0005\b\u0080\u0001\u0010@¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/android/live/core/widget/bubble/LiveBubbleLayout;", "Landroid/widget/LinearLayout;", "", "bubbleOrientation", "", "setBubbleOrientation", "", "getBubbleOffset", "getPADDING", "", "need", "setNeedAddColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mFillPaint", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "d", "getMBubbleArrowPath", "setMBubbleArrowPath", "mBubbleArrowPath", "f", "getMWidth", "setMWidth", "mWidth", ce.f26391f, "getMHeight", "setMHeight", "mHeight", "h", "getMBorderBubbleArrowPath", "setMBorderBubbleArrowPath", "mBorderBubbleArrowPath", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "Landroid/graphics/RectF;", "getMBorderRoundRect", "()Landroid/graphics/RectF;", "setMBorderRoundRect", "(Landroid/graphics/RectF;)V", "mBorderRoundRect", ce.f26395j, "I", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mBorderWidth", "Landroid/graphics/Matrix;", ce.f26396k, "Landroid/graphics/Matrix;", "getMBorderMatrix", "()Landroid/graphics/Matrix;", "setMBorderMatrix", "(Landroid/graphics/Matrix;)V", "mBorderMatrix", OfficeSDKRequestTag.KEY_NEW_USER, "getMBgColor", "setMBgColor", "mBgColor", "o", "getMBorderColor", "setMBorderColor", "mBorderColor", "p", "getMShadowColor", "setMShadowColor", "mShadowColor", "q", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "t", "getMNeedPath", "setMNeedPath", "mNeedPath", "u", "getMNeedPressFade", "setMNeedPressFade", "mNeedPressFade", BaseSwitches.V, "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "w", "getMNeedAddColor", "setMNeedAddColor", "mNeedAddColor", "x", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "y", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getCornerRadius", "setCornerRadius", "cornerRadius", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getDefaultHeight", "setDefaultHeight", "defaultHeight", "value", "B", "getArrowHeight", "setArrowHeight", "arrowHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBubbleLayout extends LinearLayout {
    public static int C;
    public static int D;
    public static float E;
    public static float F;
    public static int G;
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f66570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f66571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f66572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f66573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f66574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f66575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f66576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f66577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f66578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f66579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Matrix f66580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f66581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Canvas f66582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f66583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f66584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f66585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f66586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f66587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f66588s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f66589t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f66590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f66591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f66592w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f66593x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f66594y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f66595z;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Path r100 = this.f66573d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        r100.reset();
        Path r101 = this.f66573d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L8:
        r101.moveTo(0.0f, 0.0f);
        Path r102 = this.f66573d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L11:
        int r103 = C;
        r102.lineTo(r103, -r103);
        Path r104 = this.f66573d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L14:
        int r105 = C;
        r104.lineTo(r105, r105);
        Path r106 = this.f66573d;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L17:
        r106.close();
        Path r107 = this.f66577h;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L20:
        r107.moveTo(0.0f, 0.0f);
        Path r108 = this.f66577h;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L23:
        r108.lineTo((float) (((double) C) + (((double) this.f66579j) * Math.sqrt(2.0d))), (float) (((double) (-C)) - (((double) this.f66579j) * Math.sqrt(2.0d))));
        Path r109 = this.f66577h;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L26:
        r109.lineTo((float) (((double) C) + (((double) this.f66579j) * Math.sqrt(2.0d))), (float) (((double) C) + (((double) this.f66579j) * Math.sqrt(2.0d))));
        Path r110 = this.f66577h;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L29:
        r110.close();
    }

    public final float getBubbleOffset() {
        float r100 = Math.max(this.f66587r, F);
        int r101 = this.f66588s;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, this.f66575f - F);
    L18:
        return Math.min(r100, this.f66576g - F);
    L19:
        return Math.min(r100, this.f66576g - F);
    L15:
        return Math.min(r100, this.f66575f - F);
    }

    public final Path getMBorderBubbleArrowPath() {
        Path r100 = this.f66577h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L5:
        return r100;
    }

    public final Matrix getMBorderMatrix() {
        Matrix r100 = this.f66580k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L5:
        return r100;
    }

    public final RectF getMBorderRoundRect() {
        RectF r100 = this.f66578i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L5:
        return r100;
    }

    public final Path getMBubbleArrowPath() {
        Path r100 = this.f66573d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        return r100;
    }

    public final Paint getMFillPaint() {
        Paint r100 = this.f66571b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        return r100;
    }

    public final Path getMPath() {
        Path r100 = this.f66572c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r100;
    }

    public final int getPADDING() {
        return C / 2;
    }

    public final int getArrowHeight() {
        return this.B;
    }

    public final float getCornerRadius() {
        return this.f66595z;
    }

    public final int getDefaultHeight() {
        return this.A;
    }

    public final int getMAdjustHeight() {
        return this.f66594y;
    }

    public final int getMBgColor() {
        return this.f66583n;
    }

    public final int getMBorderColor() {
        return this.f66584o;
    }

    public final int getMBorderWidth() {
        return this.f66579j;
    }

    public final float getMHeight() {
        return this.f66576g;
    }

    public final boolean getMNeedAddColor() {
        return this.f66592w;
    }

    public final boolean getMNeedArrow() {
        return this.f66591v;
    }

    public final boolean getMNeedPath() {
        return this.f66589t;
    }

    public final boolean getMNeedPressFade() {
        return this.f66590u;
    }

    public final boolean getMNeedShadow() {
        return this.f66586q;
    }

    public final float getMPadding() {
        return this.f66570a;
    }

    public final int getMShadowColor() {
        return this.f66585p;
    }

    public final float getMWidth() {
        return this.f66575f;
    }

    public final boolean getUseDefaultView() {
        return this.f66593x;
    }

    public LiveBubbleLayout(Context r100) {
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
        if (this.f66581l != null) goto L5;
        Resources r100 = getContext().getResources();
        Bitmap r101 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f66581l = r101;
        this.f66582m = new Canvas(r101);
    L5:
        float r102 = this.f66575f;
        float r103 = this.f66576g;
        float r104 = Math.max(this.f66587r, F);
        Matrix r105 = new Matrix();
        this.f66580k = new Matrix();
        int r106 = this.f66588s;
        if (r106 != 0) goto L8;
        float r107 = Math.min(r104, r102 - F);
        r105.postRotate(90.0f);
        Matrix r108 = this.f66580k;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L33:
        r108.postRotate(90.0f);
        Matrix r109 = this.f66580k;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L36:
        int r111 = this.f66579j;
        r109.postTranslate((((r111 * 3) / 2) + r107) - ((C * 3) / 2), r111 + 0.0f);
        setPadding(0, C, 0, 0);
        setGravity(17);
        this.f66574e = new RectF(0.0f, C, this.f66575f, this.f66576g);
        float r112 = (this.f66579j * 3) / 2;
        r105.postTranslate((r107 + r112) - ((C * 3) / 2), 0.0f + r112);
    L37:
        RectF r113 = this.f66574e;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L40:
        r113.left += (this.f66579j * 3) / 2;
        RectF r114 = this.f66574e;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L43:
        r114.top += (this.f66579j * 3) / 2;
        RectF r115 = this.f66574e;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L46:
        r115.right += (this.f66579j * 3) / 2;
        RectF r116 = this.f66574e;
        if (r116 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L49:
        r116.bottom += (this.f66579j * 3) / 2;
        RectF r117 = new RectF();
        this.f66578i = r117;
        RectF r118 = this.f66574e;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L52:
        r117.left = r118.left - (this.f66579j / 2);
        RectF r119 = this.f66578i;
        if (r119 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L55:
        RectF r120 = this.f66574e;
        if (r120 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L58:
        r119.top = r120.top - (this.f66579j / 2);
        RectF r121 = this.f66578i;
        if (r121 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L61:
        RectF r122 = this.f66574e;
        if (r122 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L64:
        r121.right = r122.right + (this.f66579j / 2);
        RectF r123 = this.f66578i;
        if (r123 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L67:
        RectF r124 = this.f66574e;
        if (r124 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L70:
        r123.bottom = r124.bottom + (this.f66579j / 2);
        if (this.f66586q == false) goto L77;
        Paint r125 = this.f66571b;
        if (r125 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L75:
        r125.setShadowLayer(2.0f, 2.0f, 5.0f, this.f66585p);
    L77:
        if (this.f66589t == false) goto L156;
        Paint r126 = this.f66571b;
        if (r126 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L81:
        r126.setColor(this.f66584o);
        Paint r127 = this.f66571b;
        if (r127 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L84:
        r127.setStyle(Paint.Style.STROKE);
        Paint r128 = this.f66571b;
        if (r128 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L87:
        r128.setStrokeWidth(this.f66579j);
        Path r129 = this.f66572c;
        if (r129 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L90:
        r129.reset();
        Path r130 = this.f66572c;
        if (r130 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L93:
        RectF r131 = this.f66578i;
        if (r131 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L96:
        float r132 = this.f66595z;
        int r133 = this.f66579j;
        r130.addRoundRect(r131, (r133 / 2) + r132, r132 + (r133 / 2), Path.Direction.CW);
        if (this.f66591v == false) goto L108;
        Path r134 = this.f66572c;
        if (r134 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L101:
        Path r135 = this.f66577h;
        if (r135 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L104:
        Matrix r136 = this.f66580k;
        if (r136 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L107:
        r134.addPath(r135, r136);
    L108:
        Canvas r137 = this.f66582m;
        if (r137 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L111:
        Path r138 = this.f66572c;
        if (r138 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L114:
        Paint r139 = this.f66571b;
        if (r139 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L117:
        r137.drawPath(r138, r139);
        if (this.f66592w == false) goto L156;
        Paint r140 = this.f66571b;
        if (r140 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L122:
        r140.setColor(getResources().getColor(R.color.ttlive_uikit_const_tPrimary));
        Paint r141 = this.f66571b;
        if (r141 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L125:
        r141.setStyle(Paint.Style.STROKE);
        Path r142 = this.f66572c;
        if (r142 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L128:
        r142.reset();
        if (this.f66591v == false) goto L140;
        Path r143 = this.f66572c;
        if (r143 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L133:
        Path r144 = this.f66577h;
        if (r144 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L136:
        Matrix r145 = this.f66580k;
        if (r145 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L139:
        r143.addPath(r144, r145);
    L140:
        Path r146 = this.f66572c;
        if (r146 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L143:
        RectF r147 = this.f66578i;
        if (r147 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L146:
        float r148 = this.f66595z;
        int r149 = this.f66579j;
        r146.addRoundRect(r147, (r149 / 2) + r148, r148 + (r149 / 2), Path.Direction.CW);
        Canvas r150 = this.f66582m;
        if (r150 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L149:
        Path r151 = this.f66572c;
        if (r151 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L152:
        Paint r152 = this.f66571b;
        if (r152 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L155:
        r150.drawPath(r151, r152);
    L156:
        Paint r153 = this.f66571b;
        if (r153 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L159:
        r153.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r154 = this.f66571b;
        if (r154 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L162:
        r154.setColor(this.f66583n);
        Paint r155 = this.f66571b;
        if (r155 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L165:
        r155.setStyle(Paint.Style.FILL);
        Path r156 = this.f66572c;
        if (r156 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L168:
        r156.reset();
        Path r157 = this.f66572c;
        if (r157 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L171:
        RectF r158 = this.f66574e;
        if (r158 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L174:
        float r159 = this.f66595z;
        r157.addRoundRect(r158, r159, r159, Path.Direction.CW);
        if (this.f66591v == false) goto L183;
        Path r160 = this.f66572c;
        if (r160 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L179:
        Path r161 = this.f66573d;
        if (r161 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L182:
        r160.addPath(r161, r105);
    L183:
        Canvas r162 = this.f66582m;
        if (r162 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L186:
        Path r163 = this.f66572c;
        if (r163 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L189:
        Paint r164 = this.f66571b;
        if (r164 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L192:
        r162.drawPath(r163, r164);
        Paint r165 = this.f66571b;
        if (r165 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L195:
        r165.setXfermode(null);
        Bitmap r166 = this.f66581l;
        if (r166 == null) goto L199;
        r110.drawBitmap(r166, C - UIUtils.dip2Px(getContext(), 1.4f), C - UIUtils.dip2Px(getContext(), 1.3f), null);
        return;
    L199:
        return;
    L8:
        if (r106 == 1) goto L26;
        if (r106 == 2) goto L19;
        if (r106 != 3) goto L37;
        float r167 = Math.min(r104, r102 - F);
        r105.postRotate(270.0f);
        Matrix r168 = this.f66580k;
        if (r168 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L15:
        r168.postRotate(270.0f);
        Matrix r169 = this.f66580k;
        if (r169 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L18:
        int r170 = this.f66579j;
        r169.postTranslate((((r170 * 3) / 2) + r167) - ((C * 3) / 2), (r170 * 2) + r103);
        setPadding(0, 0, 0, C);
        setGravity(17);
        this.f66574e = new RectF(0.0f, 0.0f, this.f66575f, this.f66576g - C);
        float r171 = (this.f66579j * 3) / 2;
        r105.postTranslate((r167 + r171) - ((C * 3) / 2), r103 + r171);
        goto L37
    L19:
        float r172 = Math.min(r104, r103 - F);
        r105.postRotate(180.0f);
        Matrix r173 = this.f66580k;
        if (r173 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L22:
        r173.postRotate(180.0f);
        Matrix r174 = this.f66580k;
        if (r174 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L25:
        float r175 = this.f66579j * 2;
        r174.postTranslate(r175 + r102, (r175 + r172) - ((C * 3) / 2));
        setPadding(0, 0, C, 0);
        setGravity(17);
        this.f66574e = new RectF(0.0f, 0.0f, this.f66575f - C, this.f66576g);
        int r176 = this.f66579j;
        r105.postTranslate(r102 + ((r176 * 3) / 2), (r172 + (r176 * 2)) - ((C * 3) / 2));
        goto L37
    L26:
        float r177 = Math.min(r104, r103 - F);
        setPadding(C, 0, 0, 0);
        setGravity(17);
        Matrix r178 = this.f66580k;
        if (r178 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L29:
        int r179 = this.f66579j;
        r178.postTranslate(r179 + 0.0f, ((r179 * 2) + r177) - ((C * 3) / 2));
        this.f66574e = new RectF(C, 0.0f, this.f66575f, this.f66576g);
        int r180 = this.f66579j;
        r105.postTranslate(0.0f + ((r180 * 3) / 2), (r177 + (r180 * 2)) - ((C * 3) / 2));
        goto L37
    }

    public final void setArrowHeight(int r100) {
        this.B = r100;
        C = r100;
        a();
    }

    public final void setBubbleOrientation(int r100) {
        this.f66588s = r100;
    }

    public final void setCornerRadius(float r100) {
        this.f66595z = r100;
    }

    public final void setDefaultHeight(int r100) {
        this.A = r100;
    }

    public final void setMAdjustHeight(int r100) {
        this.f66594y = r100;
    }

    public final void setMBgColor(int r100) {
        this.f66583n = r100;
    }

    public final void setMBorderBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66577h = r100;
    }

    public final void setMBorderColor(int r100) {
        this.f66584o = r100;
    }

    public final void setMBorderMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66580k = r100;
    }

    public final void setMBorderRoundRect(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66578i = r100;
    }

    public final void setMBorderWidth(int r100) {
        this.f66579j = r100;
    }

    public final void setMBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66573d = r100;
    }

    public final void setMFillPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66571b = r100;
    }

    public final void setMHeight(float r100) {
        this.f66576g = r100;
    }

    public final void setMNeedAddColor(boolean r100) {
        this.f66592w = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f66591v = r100;
    }

    public final void setMNeedPath(boolean r100) {
        this.f66589t = r100;
    }

    public final void setMNeedPressFade(boolean r100) {
        this.f66590u = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f66586q = r100;
    }

    public final void setMPadding(float r100) {
        this.f66570a = r100;
    }

    public final void setMPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66572c = r100;
    }

    public final void setMShadowColor(int r100) {
        this.f66585p = r100;
    }

    public final void setMWidth(float r100) {
        this.f66575f = r100;
    }

    public final void setNeedAddColor(boolean r100) {
        this.f66592w = r100;
    }

    public final void setUseDefaultView(boolean r100) {
        this.f66593x = r100;
    }

    public LiveBubbleLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        D = (int) UIUtils.dip2Px(getContext(), this.f66570a + 5.0f);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r100 = getChildAt(0);
        if (r100 == null) goto L8;
        TextView r101 = (TextView) r100;
    L10:
        int r102 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r103 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        if (r101 != null) goto L13;
        int r104 = getMeasuredWidth();
        char r105 = 0;
    L19:
        if (this.f66593x == false) goto L34;
        int r106 = this.f66588s;
        if (r106 == 2) goto L27;
        if (r106 == 1) goto L27;
        int r107 = G;
        if (r104 <= r107) goto L31;
        r107 = (D * 2) + r104;
    L31:
        if (r105 != 1) goto L33;
        int r108 = this.A;
    L35:
        int r109 = this.f66579j;
        int r114 = r107 + (r109 * 3);
        int r115 = r108 + ((r109 * 3) + this.f66594y);
        if (r102 != Integer.MIN_VALUE) goto L39;
        if (r103 != Integer.MIN_VALUE) goto L39;
        setMeasuredDimension(r114, r115);
    L43:
        this.f66575f = getMeasuredWidth() - (C * 2);
        this.f66576g = getMeasuredHeight() - (C * 2);
        return;
    L39:
        if (r102 != Integer.MIN_VALUE) goto L41;
        setMeasuredDimension(r114, r113);
        goto L43
    L41:
        if (r103 != Integer.MIN_VALUE) goto L43;
        setMeasuredDimension(r112, r115);
        goto L43
    L33:
        r108 = this.A + 19;
    L27:
        int r116 = G;
        if (r104 <= r116) goto L30;
        r116 = (D * 2) + r104;
    L30:
        r107 = r116 + C;
        goto L31
    L34:
        PopupWindow r117 = new PopupWindow(getChildAt(0), -2, -2, true);
        r117.getContentView().measure(0, 0);
        r107 = (r117.getContentView().getMeasuredWidth() + (C * 3)) + D;
        r108 = (r117.getContentView().getMeasuredHeight() + (C * 3)) + D;
        goto L35
    L13:
        if (((int) r101.getPaint().measureText(r101.getText().toString())) <= UIUtils.dip2Px(getContext(), 197.0f)) goto L15;
        int r118 = (int) UIUtils.dip2Px(getContext(), 197.0f);
        r105 = 2;
    L16:
        r104 = (r118 + r101.getPaddingLeft()) + r101.getPaddingRight();
        goto L19
    L15:
        r118 = (int) r101.getPaint().measureText(r101.getText().toString());
        r105 = 1;
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r101 = null;
        goto L10
    }

    public LiveBubbleLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f66570a = 12.0f;
        this.f66585p = -16777216;
        this.f66587r = 0.75f;
        this.f66588s = 1;
        this.f66589t = true;
        this.f66591v = true;
        this.f66592w = true;
        this.f66593x = true;
        this.f66595z = UIUtils.dip2Px(getContext(), 8.0f);
        this.A = (int) UIUtils.dip2Px(getContext(), 56.0f);
        this.B = (int) UIUtils.dip2Px(getContext(), 7.0f);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f66579j = (int) UIUtils.dip2Px(r100, 0.7f);
        C = this.B;
        E = 2.0f;
        F = UIUtils.dip2Px(r100, 3.0f);
        G = (int) UIUtils.dip2Px(r100, 40.0f);
        this.f66571b = new Paint();
        this.f66572c = new Path();
        this.f66577h = new Path();
        this.f66573d = new Path();
        Paint r103 = this.f66571b;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r103.setStyle(Paint.Style.FILL);
        Paint r104 = this.f66571b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r104.setStrokeCap(Paint.Cap.BUTT);
        Paint r105 = this.f66571b;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r105.setAntiAlias(true);
        Paint r106 = this.f66571b;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r106.setStrokeWidth(E);
        Paint r107 = this.f66571b;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L17:
        r107.setStrokeJoin(Paint.Join.MITER);
        this.f66583n = getResources().getColor(R.color.ttlive_uikit_const_sdPrimary);
        this.f66584o = getResources().getColor(R.color.ttlive_reverse_lPrimary2);
        Paint r108 = this.f66571b;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r108.setColor(this.f66583n);
        Paint r109 = this.f66571b;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        setLayerType(1, r109);
        if (this.f66586q == false) goto L29;
        Paint r110 = this.f66571b;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L28:
        r110.setShadowLayer(2.0f, 2.0f, 5.0f, this.f66585p);
    L29:
        a();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
