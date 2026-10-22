package com.obric.oui.popover;

import android.content.Context;
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
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.l;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b6\u0018\u0000 ¦\u00012\u00020\u0001:\u0002NTB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u0010J\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u0010J\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\f2\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b'\u0010\u0010J\u001d\u0010*\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0011¢\u0006\u0004\b,\u0010\u0016J\u001f\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0015¢\u0006\u0004\b/\u00100J/\u00105\u001a\u00020\f2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\f2\u0006\u00108\u001a\u000207H\u0015¢\u0006\u0004\b9\u0010:J\u001d\u00102\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\t¢\u0006\u0004\b2\u0010=J\r\u0010>\u001a\u00020\t¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\t¢\u0006\u0004\b@\u0010?J\r\u0010A\u001a\u00020\t¢\u0006\u0004\bA\u0010?J\r\u0010C\u001a\u00020B¢\u0006\u0004\bC\u0010DJ\r\u0010F\u001a\u00020E¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MR\"\u0010S\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u001aR\u0016\u0010V\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010[\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010?\"\u0004\bZ\u0010\u0010R\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010]R\u0016\u0010`\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010_R\u0016\u0010a\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010_R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010]R\"\u0010i\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010f\u001a\u0004\bg\u0010\u0016\"\u0004\bh\u0010\u0014R\"\u0010l\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010f\u001a\u0004\bj\u0010\u0016\"\u0004\bk\u0010\u0014R\u0016\u0010n\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010fR\u0016\u0010p\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010XR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010w\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bu\u0010vR\"\u0010{\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010X\u001a\u0004\by\u0010?\"\u0004\bz\u0010\u0010R$\u0010\u0081\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0005\b\u0080\u0001\u0010\"R&\u0010\u0085\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010}\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0005\b\u0084\u0001\u0010\"R&\u0010\u0089\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010}\u001a\u0005\b\u0087\u0001\u0010\u007f\"\u0005\b\u0088\u0001\u0010\"R&\u0010\u008d\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010X\u001a\u0005\b\u008b\u0001\u0010?\"\u0005\b\u008c\u0001\u0010\u0010R\u0018\u0010\u008f\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010XR\u0018\u0010\u0091\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010fR\u0018\u0010\u0093\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010XR\u0017\u0010\u0094\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010XR\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010]R\u0016\u0010\u0098\u0001\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010_R\u0016\u0010\u009a\u0001\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010_R\u0018\u0010\u009c\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010XR\u0018\u0010\u009e\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010fR\u0018\u0010 \u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010XR\u0018\u0010¢\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010XR\u0018\u0010¤\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b£\u0001\u0010XR\u0017\u0010¥\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010X¨\u0006§\u0001"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "f", "cornerRadiusDp", "setCornerRadiusDp", "(I)V", "", "cornerRadius", "setCornerRadius", "(F)V", "getCornerRadius", "()F", "", "str", "setSubText", "(Ljava/lang/String;)V", "color", "setBorderColor", Style.KEY_WIDTH, "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "bubbleOrientation", "bubbleArrowOffset", "j", "(IF)V", "setBubbleOrientation", Style.KEY_HEIGHT, "Landroid/graphics/Matrix;", "e", "(FF)Landroid/graphics/Matrix;", "getBubbleOffset", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "pressed", "pressedColor", "(ZI)V", "d", "()I", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "()Landroid/graphics/Path;", "Lcom/obric/oui/popover/OPopoverLayout$b;", "getShadowConfig", "()Lcom/obric/oui/popover/OPopoverLayout$b;", "i", "()V", "Landroid/widget/TextView;", "textView", "g", "(Landroid/widget/TextView;)I", "a", "Ljava/lang/String;", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "mSubTitle", "b", "Lcom/obric/oui/popover/OPopoverLayout$b;", "shadowConfig", "c", "I", "getMPadding", "setMPadding", "mPadding", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mFillPaint", "Landroid/graphics/Path;", "mPath", "mBubbleArrowPath", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRoundRect", "mArrowPressedPaint", "F", "getMWidth", "setMWidth", "mWidth", "getMHeight", "setMHeight", "mHeight", "k", "mBubbleArrowOffset", "l", "mBubbleOrientation", "Landroid/graphics/Bitmap;", "m", "Landroid/graphics/Bitmap;", "mBitmap", "n", "Landroid/graphics/Canvas;", "mCanvas", "o", "getMBgColor", "setMBgColor", "mBgColor", "p", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "mNeedShadow", "q", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "r", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "s", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "t", "pressStateColor", "u", "mCornerRadius", "v", "borderWidth", "borderColor", FixCard.FixStyle.KEY_X, "strokePaint", FixCard.FixStyle.KEY_Y, "tempRectPath", "z", "tempArrowPath", "A", "arrowPadding", "B", "minArrowDistance", "C", "defaultWidth", "D", "defaultHeight", "E", "additionalHeight", "maxWidth", "G", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {
    public static final a G = null;
    public static int H;
    public static int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static int f16090J;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q;
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f16092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f16094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f16095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f16096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f16097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f16098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f16100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f16103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Canvas f16104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16108r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16109s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16110t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f16111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f16114x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f16115y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Path f16116z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a() {
            return OPopoverLayout.a();
        }

        public final int b() {
            return OPopoverLayout.b();
        }

        public final int c() {
            return OPopoverLayout.c();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f16119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16120d;

        public b(float r10, float r11, float r12, int r13) {
            this.f16117a = r10;
            this.f16118b = r11;
            this.f16119c = r12;
            this.f16120d = r13;
        }

        public final int a() {
            return this.f16120d;
        }

        public final float b() {
            return this.f16118b;
        }

        public final float c() {
            return this.f16119c;
        }

        public final float d() {
            return this.f16117a;
        }

        public final void e(int r10) {
            this.f16120d = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(Float.valueOf(this.f16117a), Float.valueOf(r11.f16117a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f16118b), Float.valueOf(r11.f16118b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f16119c), Float.valueOf(r11.f16119c)) == true) goto L18;
            return false;
        L18:
            if (this.f16120d == r11.f16120d) goto L20;
            return false;
        L20:
            return true;
        }

        public final void f(float r10) {
            this.f16118b = r10;
        }

        public final void g(float r10) {
            this.f16119c = r10;
        }

        public final void h(float r10) {
            this.f16117a = r10;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f16117a) * 31) + Float.hashCode(this.f16118b)) * 31) + Float.hashCode(this.f16119c)) * 31) + Integer.hashCode(this.f16120d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f16117a + ", dx=" + this.f16118b + ", dy=" + this.f16119c + ", color=" + this.f16120d + ')';
        }

        public /* synthetic */ b(float r10, float r11, float r12, int r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = 2.0f;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = 2.0f;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = 5.0f;
        L12:
            if ((r14 & 8) == 0) goto L14;
            r13 = -16777216;
        L14:
            this(r10, r11, r12, r13);
        }
    }

    static {
        G = new a(null);
        H = 7;
        I = 28;
        f16090J = 99;
        K = 12;
        L = 18;
        M = 40;
        N = 36;
        O = 20;
        P = 12;
        Q = 276;
    }

    public OPopoverLayout(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }

    public static final /* synthetic */ int a() {
        return K;
    }

    public static final /* synthetic */ int b() {
        return I;
    }

    public static final /* synthetic */ int c() {
        return f16090J;
    }

    public final int d() {
        return this.f16102l;
    }

    public final Matrix e(float r10, float r11) {
        float r12 = Math.max(this.f16101k, this.B + this.A);
        Matrix r13 = new Matrix();
        int r14 = this.f16112v;
        int r15 = r14 / 2;
        int r16 = this.f16102l;
        if (r16 != 0) goto L5;
        float r17 = Math.min(r12, (r10 - this.A) - this.B);
        float r18 = this.f16112v;
        r13.postRotate(90.0f);
        setPadding(0, r15, 0, 0);
    L15:
        setGravity(17);
        int r19 = this.A;
        int r20 = this.f16112v;
        this.f16097g = new RectF(r19 + (r20 / 2), r19 + (r20 / 2), (this.f16099i - r19) - r20, (this.f16100j - r19) - r20);
        r13.postTranslate(r17, r18);
        Path r21 = this.f16095e;
        Path r22 = null;
        if (r21 != null) goto L18;
        q.y("mPath");
        r21 = null;
    L18:
        r21.reset();
        this.f16115y.reset();
        l r23 = l.f13087a;
        Path r24 = this.f16115y;
        RectF r25 = this.f16097g;
        if (r25 != null) goto L21;
        q.y("mRoundRect");
        r25 = null;
    L21:
        r23.a(r24, r25, this.f16111u);
        if (this.f16107q == false) goto L27;
        this.f16116z.reset();
        Path r26 = this.f16116z;
        Path r27 = this.f16096f;
        if (r27 != null) goto L26;
        q.y("mBubbleArrowPath");
        r27 = null;
    L26:
        r26.addPath(r27, r13);
        this.f16115y.op(this.f16116z, Path.Op.UNION);
    L27:
        Path r28 = this.f16095e;
        if (r28 != null) goto L30;
        q.y("mPath");
    L31:
        r22.addPath(this.f16115y);
        return r13;
    L30:
        r22 = r28;
        goto L31
    L5:
        if (r16 != 1) goto L7;
        r17 = r14;
        r18 = Math.min(r12, (r11 - this.A) - this.B);
        setPadding(r15, 0, 0, 0);
        goto L15
    L7:
        if (r16 != 2) goto L9;
        r17 = r10 - r14;
        r18 = Math.min(r12, (r11 - this.A) - this.B);
        r13.postRotate(180.0f);
        setPadding(0, 0, r15, 0);
        goto L15
    L9:
        if (r16 == 3) goto L11;
        r17 = 0.0f;
        r18 = 0.0f;
        goto L15
    L11:
        r17 = Math.min(r12, (r10 - this.A) - this.B);
        r18 = r11 - this.f16112v;
        r13.postRotate(270.0f);
        setPadding(0, 0, 0, r15);
        goto L15
    }

    public final void f(Context r10, AttributeSet r11) {
        q.g(r10, "context");
        this.A = tc.f.r(this, H);
        this.B = tc.f.u(this, L);
        this.C = tc.f.r(this, M);
        this.D = tc.f.r(this, N);
        this.E = tc.f.r(this, O);
        this.f16093c = tc.f.r(this, P);
        this.F = tc.f.r(this, Q);
        this.f16094d = new Paint();
        this.f16095e = new Path();
        this.f16096f = new Path();
        Paint r12 = this.f16094d;
        Paint r13 = null;
        if (r12 != null) goto L5;
        q.y("mFillPaint");
        r12 = null;
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r14 = this.f16094d;
        if (r14 != null) goto L8;
        q.y("mFillPaint");
        r14 = null;
    L8:
        r14.setStrokeCap(Paint.Cap.BUTT);
        Paint r15 = this.f16094d;
        if (r15 != null) goto L11;
        q.y("mFillPaint");
        r15 = null;
    L11:
        r15.setAntiAlias(true);
        Paint r16 = this.f16094d;
        if (r16 != null) goto L14;
        q.y("mFillPaint");
        r16 = null;
    L14:
        r16.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f16105o = ContextCompat.b(r10, R$color.SDPrimary);
    L17:
        Paint r17 = this.f16094d;
        if (r17 != null) goto L20;
        q.y("mFillPaint");
    L21:
        r13.setColor(getMBgColor());
        i();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L20:
        r13 = r17;
        goto L21
    }

    public final int g(TextView r10) {
        String r11 = r10.getText().toString();
        TextPaint r12 = r10.getPaint();
        if (r12 == null) goto L16;
        int r13 = 0;
        if (StringsKt__StringsKt.E(r11, "\n", false, 2, null) == false) goto L7;
        Iterator r14 = StringsKt__StringsKt.l0(r11, new String[]{"\n"}, false, 0, 6, null).iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        int r15 = (int) r12.measureText((String) r14.next());
        if (r15 <= r13) goto L10;
        r13 = r15;
        goto L10
    L14:
        return r13;
    L7:
        return (int) r12.measureText(r11);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.text.TextPaint");
    }

    public final int getArrowHeight() {
        return this.A;
    }

    public final float getBubbleOffset() {
        float r10 = Math.max(this.f16101k, this.B);
        int r11 = this.f16102l;
        if (r11 == 0) goto L15;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L18;
        if (r11 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r10, (this.f16099i - this.A) - this.B);
    L18:
        return Math.min(r10, (this.f16100j - this.A) - this.B);
    L19:
        return Math.min(r10, (this.f16100j - this.A) - this.B);
    L15:
        return Math.min(r10, (this.f16099i - this.A) - this.B);
    }

    public final float getCornerRadius() {
        return this.f16111u;
    }

    @NotNull
    public final Path getFullPath() {
        Path r10 = this.f16095e;
        if (r10 != null) goto L6;
        q.y("mPath");
        return null;
    L6:
        return r10;
    }

    public final int getMAdjustHeight() {
        return this.f16109s;
    }

    public final int getMBgColor() {
        int r10 = this.f16110t;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f16105o;
    }

    public final float getMHeight() {
        return this.f16100j;
    }

    public final boolean getMNeedArrow() {
        return this.f16107q;
    }

    public final boolean getMNeedShadow() {
        return this.f16106p;
    }

    public final int getMPadding() {
        return this.f16093c;
    }

    @NotNull
    public final String getMSubTitle() {
        return this.f16091a;
    }

    public final float getMWidth() {
        return this.f16099i;
    }

    public final int getPadding() {
        return this.A / 2;
    }

    @NotNull
    public final b getShadowConfig() {
        return this.f16092b;
    }

    public final boolean getUseDefaultView() {
        return this.f16108r;
    }

    public final void h(boolean r10, int r11) {
        if (r10 == true) goto L4;
        Paint r12 = this.f16098h;
        if (r12 == null) goto L28;
        r12.setColor(0);
        return;
    L28:
        return;
    L4:
        if (this.f16098h != null) goto L17;
        Paint r13 = new Paint();
        this.f16098h = r13;
        r13.setStyle(Paint.Style.FILL);
        Paint r14 = this.f16098h;
        if (r14 == null) goto L9;
        r14.setStrokeCap(Paint.Cap.BUTT);
    L9:
        Paint r15 = this.f16098h;
        if (r15 == null) goto L13;
        r15.setStrokeJoin(Paint.Join.MITER);
    L13:
        Paint r16 = this.f16098h;
        if (r16 == null) goto L17;
        r16.setAntiAlias(true);
    L17:
        Paint r17 = this.f16098h;
        if (r17 == null) goto L27;
        r17.setColor(r11);
        return;
    }

    public final void i() {
        Path r10 = this.f16096f;
        Path r11 = null;
        if (r10 != null) goto L5;
        q.y("mBubbleArrowPath");
        r10 = null;
    L5:
        r10.moveTo(0.0f, 0.0f);
        float r12 = this.A / 7.0f;
        Path r13 = this.f16096f;
        if (r13 != null) goto L8;
        q.y("mBubbleArrowPath");
        Path r14 = null;
    L9:
        float r15 = r12 * 0.0f;
        float r16 = r12 * 7.0f;
        r14.cubicTo(r15, r12 * (-2.5f), r16, r12 * (-4.0f), r16, r12 * (-10.0f));
        Path r17 = this.f16096f;
        if (r17 != null) goto L12;
        q.y("mBubbleArrowPath");
        r17 = null;
    L12:
        r17.lineTo(r16, 10.0f * r12);
        Path r18 = this.f16096f;
        if (r18 != null) goto L15;
        q.y("mBubbleArrowPath");
        Path r19 = null;
    L16:
        r19.cubicTo(r16, r12 * 4.0f, r15, r12 * 2.5f, r15, r15);
        Path r110 = this.f16096f;
        if (r110 != null) goto L19;
        q.y("mBubbleArrowPath");
    L20:
        r11.close();
        return;
    L19:
        r11 = r110;
        goto L20
    L15:
        r19 = r18;
        goto L16
    L8:
        r14 = r13;
        goto L9
    }

    public final void j(int r10, float r11) {
        this.f16101k = r11;
        this.f16102l = r10;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f16103m != null) goto L5;
        this.f16103m = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r11 = this.f16103m;
        q.d(r11);
        this.f16104n = new Canvas(r11);
    L5:
        Paint r12 = this.f16094d;
        if (r12 != null) goto L8;
        q.y("mFillPaint");
        r12 = null;
    L8:
        r12.setColor(getMBgColor());
        e(this.f16099i, this.f16100j);
        if (this.f16106p == false) goto L14;
        Paint r13 = this.f16094d;
        if (r13 != null) goto L13;
        q.y("mFillPaint");
        r13 = null;
    L13:
        r13.setShadowLayer(this.f16092b.d(), this.f16092b.b(), this.f16092b.c(), this.f16092b.a());
    L14:
        Canvas r14 = this.f16104n;
        if (r14 != null) goto L17;
        q.y("mCanvas");
        r14 = null;
    L17:
        Path r15 = this.f16095e;
        if (r15 != null) goto L20;
        q.y("mPath");
        r15 = null;
    L20:
        Paint r16 = this.f16094d;
        if (r16 != null) goto L23;
        q.y("mFillPaint");
        r16 = null;
    L23:
        r14.drawPath(r15, r16);
        if (this.f16114x == null) goto L35;
        if (this.f16112v <= 0) goto L35;
        Canvas r17 = this.f16104n;
        if (r17 != null) goto L30;
        q.y("mCanvas");
        r17 = null;
    L30:
        Path r18 = this.f16095e;
        if (r18 != null) goto L33;
        q.y("mPath");
        r18 = null;
    L33:
        Paint r19 = this.f16114x;
        q.d(r19);
        r17.drawPath(r18, r19);
    L35:
        if (this.f16098h == null) goto L40;
        Canvas r20 = this.f16104n;
        if (r20 != null) goto L39;
        q.y("mCanvas");
        r20 = null;
    L39:
        Path r21 = this.f16116z;
        Paint r22 = this.f16098h;
        q.d(r22);
        r20.drawPath(r21, r22);
    L40:
        Bitmap r23 = this.f16103m;
        q.d(r23);
        r10.drawBitmap(r23, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = 0;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r13 = getChildAt(0);
        if (r13 == null) goto L8;
        TextView r14 = (TextView) r13;
    L10:
        int r15 = View.MeasureSpec.getMode(r10);
        int r16 = View.MeasureSpec.getSize(r10);
        int r17 = View.MeasureSpec.getMode(r11);
        int r18 = View.MeasureSpec.getSize(r11);
        if (r14 == null) goto L17;
        int r19 = g(r14);
        int r20 = this.F;
        if (r19 > r20) goto L16;
        r20 = g(r14);
    L16:
        int r21 = (r20 + r14.getPaddingLeft()) + r14.getPaddingRight();
    L19:
        if (this.f16108r == false) goto L28;
        int r22 = this.C;
        if (r21 <= r22) goto L23;
        r22 = (this.f16093c * 2) + r21;
    L23:
        int r23 = this.A;
        int r24 = this.f16112v;
        int r25 = (r22 + (r23 * 2)) + (r24 * 2);
        int r26 = (this.D + (r23 * 2)) + (r24 * 2);
        if (q.b(this.f16091a, "") == true) goto L27;
        r12 = this.E;
    L27:
        int r27 = r26 + r12;
    L30:
        if (r15 != Integer.MIN_VALUE) goto L33;
        if (r17 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r25, r27);
    L38:
        this.f16099i = getMeasuredWidth();
        this.f16100j = getMeasuredHeight();
        return;
    L33:
        if (r15 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r25, r18);
        goto L38
    L35:
        if (r17 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r16, r27);
        goto L38
    L37:
        setMeasuredDimension(r16, r18);
        goto L38
    L28:
        PopupWindow r28 = new PopupWindow(getChildAt(0), -2, -2, true);
        r28.getContentView().measure(0, 0);
        r25 = (this.A * 2) + r28.getContentView().getMeasuredWidth();
        r27 = r28.getContentView().getMeasuredHeight() + (this.A * 2);
        goto L30
    L17:
        r21 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r14 = null;
        goto L10
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 <= 0) goto L17;
        if (r11 <= 0) goto L18;
        Bitmap r14 = this.f16103m;
        if (r14 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r14.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Bitmap r15 = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f16104n = new Canvas(r15);
        this.f16103m = r15;
        L.j("OPopoverLayout", "onSizeChanged, init new bg, w: " + r10 + ", h: " + r11 + ", oldw: " + r12 + ", oldh: " + r13);
        return;
    L14:
        if (r14.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r10) {
        this.f16113w = r10;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f16112v = r10;
        if (this.f16114x != null) goto L7;
        this.f16114x = new Paint();
    L7:
        Paint r11 = this.f16114x;
        if (r11 == null) goto L11;
        r11.setStyle(Paint.Style.STROKE);
    L11:
        Paint r12 = this.f16114x;
        if (r12 == null) goto L15;
        r12.setStrokeWidth(this.f16112v);
    L15:
        Paint r13 = this.f16114x;
        if (r13 == null) goto L19;
        r13.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r14 = this.f16114x;
        if (r14 == null) goto L23;
        r14.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r15 = this.f16114x;
        if (r15 == null) goto L27;
        r15.setAntiAlias(true);
    L27:
        Paint r16 = this.f16114x;
        if (r16 == null) goto L31;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r17 = this.f16114x;
        if (r17 == null) goto L35;
        r17.setColor(this.f16113w);
    L35:
        Paint r18 = this.f16094d;
        Paint r19 = null;
        if (r18 != null) goto L38;
        q.y("mFillPaint");
        r18 = null;
    L38:
        r18.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r20 = this.f16094d;
        if (r20 != null) goto L41;
        q.y("mFillPaint");
    L42:
        r19.setStrokeWidth(this.f16112v);
        return;
    L41:
        r19 = r20;
        goto L42
    }

    public final void setBubbleOrientation(int r10) {
        this.f16102l = r10;
    }

    public final void setCornerRadius(@Px float r10) {
        this.f16111u = r10;
    }

    public final void setCornerRadiusDp(int r10) {
        this.f16111u = tc.f.u(this, r10);
    }

    public final void setMAdjustHeight(int r10) {
        this.f16109s = r10;
    }

    public final void setMBgColor(int r10) {
        this.f16105o = r10;
    }

    public final void setMHeight(float r10) {
        this.f16100j = r10;
    }

    public final void setMNeedArrow(boolean r10) {
        this.f16107q = r10;
    }

    public final void setMNeedShadow(boolean r10) {
        this.f16106p = r10;
    }

    public final void setMPadding(int r10) {
        this.f16093c = r10;
    }

    public final void setMSubTitle(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.f16091a = r10;
    }

    public final void setMWidth(float r10) {
        this.f16099i = r10;
    }

    public final void setSubText(@NotNull String r10) {
        q.g(r10, "str");
        this.f16091a = r10;
    }

    public final void setTransparentBg(boolean r10) {
        if (r10 == false) goto L5;
        this.f16105o = 0;
        return;
    }

    public final void setUseDefaultView(boolean r10) {
        this.f16108r = r10;
    }

    public OPopoverLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        this(r10, r11, 0);
    }

    public OPopoverLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16091a = "";
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        int r16 = 0;
        this.f16092b = new b(r13, r14, r15, r16, 15, null);
        this.f16101k = 0.75f;
        this.f16102l = 1;
        this.f16107q = true;
        this.f16108r = true;
        this.f16115y = new Path();
        this.f16116z = new Path();
        f(r10, r11);
    }
}
