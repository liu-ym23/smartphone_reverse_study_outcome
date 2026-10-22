package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b'\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u000f\rB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u0016J\r\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0015¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0015¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\t¢\u0006\u0004\b+\u0010*J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\r\u00100\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\b4\u00105R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00106R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00108R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00106R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010A\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010D\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00108\u001a\u0004\b)\u0010 \"\u0004\bC\u0010\u0013R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010JR\"\u0010Q\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00108\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\u0013R\"\u0010U\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00108\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\u0013R\u0016\u0010W\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u00108R\u0016\u0010Y\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00106R\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010h\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u00106\u001a\u0004\bf\u0010*\"\u0004\bg\u0010\u0016R\"\u0010n\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010\u001cR\"\u0010r\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010j\u001a\u0004\bp\u0010l\"\u0004\bq\u0010\u001cR\"\u0010v\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010j\u001a\u0004\bt\u0010l\"\u0004\bu\u0010\u001cR\"\u0010z\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u00106\u001a\u0004\bx\u0010*\"\u0004\by\u0010\u0016R\u0016\u0010|\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u00106R\u0016\u0010~\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u00106R\u0017\u0010\u0080\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u00106R\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010GR\u0016\u0010\u0084\u0001\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010JR\u0016\u0010\u0086\u0001\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010J¨\u0006\u0088\u0001"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "()V", "a", "", "cornerRadius", "setCornerRadius", "(F)V", "color", "setBorderColor", "(I)V", Style.KEY_WIDTH, "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "()F", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "getPadding", "()I", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "()Landroid/graphics/Path;", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$b;", "getShadowConfig", "()Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$b;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "I", "arrowPadding", "F", "minArrowDistance", "c", "defaultWidth", "d", "defaultHeight", "e", "f", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$b;", "shadowConfig", "g", "setPadding", Style.KEY_PADDING, "Landroid/graphics/Paint;", "h", "Landroid/graphics/Paint;", "mFillPaint", "i", "Landroid/graphics/Path;", "mPath", "j", "mBubbleArrowPath", "k", "getMWidth", "setMWidth", "mWidth", "l", "getMHeight", "setMHeight", "mHeight", "m", "mBubbleArrowOffset", "n", "mBubbleOrientation", "Landroid/graphics/Bitmap;", "o", "Landroid/graphics/Bitmap;", "mBitmap", "p", "Landroid/graphics/Canvas;", "mCanvas", "Landroid/graphics/drawable/Drawable;", "q", "Landroid/graphics/drawable/Drawable;", "mPopoverGg", "r", "getMBgColor", "setMBgColor", "mBgColor", "s", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "mNeedShadow", "t", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "u", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "v", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "w", "pressStateColor", FixCard.FixStyle.KEY_X, "borderWidth", FixCard.FixStyle.KEY_Y, "borderColor", "z", "strokePaint", "A", "tempRectPath", "B", "tempArrowPath", "C", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    public static final a C = null;
    public static int D;
    public static float E;
    public static int F;
    public static int G;
    public static float H;
    public static int I;
    public final Path A;
    public final Path B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f15991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f15992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f15993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f15994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f15995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Path f15996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f15997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f15998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f15999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f16001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Canvas f16002p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f16003q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16004r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16005s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16006t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16007u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16008v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16009w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16010x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16011y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f16012z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f16015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16016d;

        public b(float r10, float r11, float r12, int r13) {
            this.f16013a = r10;
            this.f16014b = r11;
            this.f16015c = r12;
            this.f16016d = r13;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(Float.valueOf(this.f16013a), Float.valueOf(r11.f16013a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f16014b), Float.valueOf(r11.f16014b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f16015c), Float.valueOf(r11.f16015c)) == true) goto L18;
            return false;
        L18:
            if (this.f16016d == r11.f16016d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f16013a) * 31) + Float.hashCode(this.f16014b)) * 31) + Float.hashCode(this.f16015c)) * 31) + Integer.hashCode(this.f16016d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f16013a + ", dx=" + this.f16014b + ", dy=" + this.f16015c + ", color=" + this.f16016d + ')';
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
        C = new a(null);
        D = 9;
        E = 18.0f;
        F = 42;
        G = 42;
        H = Integer.min(42, 42) / 2.0f;
        I = 12;
    }

    public OMiddleArrowPopoverLayout(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }

    public final void a(Context r10, AttributeSet r11) {
        q.g(r10, "context");
        this.f15987a = tc.f.b(r10, D);
        this.f15988b = tc.f.d(r10, E);
        this.f15989c = tc.f.b(r10, F);
        this.f15990d = tc.f.b(r10, G);
        this.f15991e = tc.f.d(r10, H);
        this.f15993g = tc.f.e(r10, I);
        this.f15994h = new Paint();
        this.f15995i = new Path();
        this.f15996j = new Path();
        Paint r12 = this.f15994h;
        if (r12 != null) goto L5;
        q.y("mFillPaint");
        r12 = null;
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r13 = this.f15994h;
        if (r13 != null) goto L8;
        q.y("mFillPaint");
        r13 = null;
    L8:
        r13.setStrokeCap(Paint.Cap.BUTT);
        Paint r14 = this.f15994h;
        if (r14 != null) goto L11;
        q.y("mFillPaint");
        r14 = null;
    L11:
        r14.setAntiAlias(true);
        Paint r15 = this.f15994h;
        if (r15 != null) goto L14;
        q.y("mFillPaint");
        r15 = null;
    L14:
        r15.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f16004r = ContextCompat.b(r10, R$color.SDPrimary);
    L17:
        Paint r16 = this.f15994h;
        if (r16 != null) goto L20;
        q.y("mFillPaint");
        r16 = null;
    L20:
        r16.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f16003q = r10.getDrawable(R$drawable.o_bg_middle_arrow_popover);
    }

    public final void b() {
        float r10 = this.f15987a;
        float r11 = this.f15998l;
        float r12 = (r10 + (r11 / 2.0f)) - ((r11 / 2.0f) / 1.63f);
        float r13 = (r11 / 2.0f) / 1.56f;
        Path r14 = this.f15996j;
        Path r15 = null;
        if (r14 != null) goto L5;
        q.y("mBubbleArrowPath");
        r14 = null;
    L5:
        r14.reset();
        Path r16 = this.f15996j;
        if (r16 != null) goto L8;
        q.y("mBubbleArrowPath");
        r16 = null;
    L8:
        r16.moveTo(0.0f, 0.0f);
        Path r17 = this.f15996j;
        if (r17 != null) goto L11;
        q.y("mBubbleArrowPath");
        r17 = null;
    L11:
        r17.lineTo(r12, -r13);
        Path r18 = this.f15996j;
        if (r18 != null) goto L14;
        q.y("mBubbleArrowPath");
        r18 = null;
    L14:
        r18.lineTo(r12, r13);
        Path r19 = this.f15996j;
        if (r19 != null) goto L17;
        q.y("mBubbleArrowPath");
        r19 = null;
    L17:
        r19.lineTo(0.0f, 0.0f);
        Path r20 = this.f15996j;
        if (r20 != null) goto L20;
        q.y("mBubbleArrowPath");
    L21:
        r15.close();
        return;
    L20:
        r15 = r20;
        goto L21
    }

    public final int getArrowHeight() {
        return this.f15987a;
    }

    public final float getBubbleOffset() {
        float r10 = Math.max(this.f15999m, this.f15988b);
        int r11 = this.f16000n;
        if (r11 == 0) goto L15;
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L18;
        if (r11 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r10, (this.f15997k - this.f15987a) - this.f15988b);
    L18:
        return Math.min(r10, (this.f15998l - this.f15987a) - this.f15988b);
    L19:
        return Math.min(r10, (this.f15998l - this.f15987a) - this.f15988b);
    L15:
        return Math.min(r10, (this.f15997k - this.f15987a) - this.f15988b);
    }

    @NotNull
    public final Path getFullPath() {
        Path r10 = this.f15995i;
        if (r10 != null) goto L6;
        q.y("mPath");
        return null;
    L6:
        return r10;
    }

    public final int getMAdjustHeight() {
        return this.f16008v;
    }

    public final int getMBgColor() {
        int r10 = this.f16009w;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f16004r;
    }

    public final float getMHeight() {
        return this.f15998l;
    }

    public final boolean getMNeedArrow() {
        return this.f16006t;
    }

    public final boolean getMNeedShadow() {
        return this.f16005s;
    }

    public final float getMWidth() {
        return this.f15997k;
    }

    public final float getPadding() {
        return this.f15993g;
    }

    @NotNull
    public final b getShadowConfig() {
        return this.f15992f;
    }

    public final boolean getUseDefaultView() {
        return this.f16007u;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        Context r11 = getContext();
        q.f(r11, "context");
        this.f15987a = tc.f.b(r11, D);
        Context r12 = getContext();
        q.f(r12, "context");
        this.f15988b = tc.f.d(r12, E);
        Context r13 = getContext();
        q.f(r13, "context");
        this.f15989c = tc.f.b(r13, F);
        Context r14 = getContext();
        q.f(r14, "context");
        this.f15990d = tc.f.b(r14, G);
        Context r15 = getContext();
        q.f(r15, "context");
        this.f15991e = tc.f.d(r15, H);
        Context r16 = getContext();
        q.f(r16, "context");
        this.f15993g = tc.f.e(r16, I);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f16001o != null) goto L5;
        this.f16001o = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r11 = this.f16001o;
        q.d(r11);
        this.f16002p = new Canvas(r11);
    L5:
        Paint r12 = this.f15994h;
        if (r12 != null) goto L8;
        q.y("mFillPaint");
        r12 = null;
    L8:
        r12.setColor(getMBgColor());
        Drawable r13 = this.f16003q;
        if (r13 == null) goto L34;
        int r14 = this.f16000n;
        if (r14 != 0) goto L14;
        float r15 = 270.0f;
    L21:
        int r16 = this.f15987a + ((int) getPadding());
        int r17 = this.f15987a;
        int r18 = (getHeight() - ((int) ((((getWidth() - r16) - r17) * r13.getIntrinsicHeight()) / r13.getIntrinsicWidth()))) / 2;
        r13.setBounds(r16, r18, getWidth() - r17, getHeight() - r18);
        Canvas r19 = this.f16002p;
        if (r19 != null) goto L24;
        q.y("mCanvas");
        r19 = null;
    L24:
        r19.save();
        Canvas r20 = this.f16002p;
        if (r20 != null) goto L27;
        q.y("mCanvas");
        r20 = null;
    L27:
        r20.rotate(r15, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r21 = this.f16002p;
        if (r21 != null) goto L30;
        q.y("mCanvas");
        r21 = null;
    L30:
        r13.draw(r21);
        Canvas r22 = this.f16002p;
        if (r22 != null) goto L33;
        q.y("mCanvas");
        r22 = null;
    L33:
        r22.restore();
        goto L34
    L14:
        if (r14 != 1) goto L16;
        r15 = 180.0f;
        goto L21
    L16:
        if (r14 == 3) goto L18;
        r15 = 0.0f;
        goto L21
    L18:
        r15 = 90.0f;
    L34:
        Bitmap r23 = this.f16001o;
        q.d(r23);
        r10.drawBitmap(r23, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r12 = getChildAt(0);
        if (r12 == null) goto L8;
        TextView r13 = (TextView) r12;
    L10:
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = View.MeasureSpec.getMode(r11);
        int r17 = View.MeasureSpec.getSize(r11);
        if (r13 == null) goto L17;
        Context r18 = getContext();
        q.f(r18, "context");
        int r19 = tc.f.b(r18, 276);
        if (((int) r13.getPaint().measureText(r13.getText().toString())) > r19) goto L16;
        r19 = (int) r13.getPaint().measureText(r13.getText().toString());
    L16:
        int r20 = (r19 + r13.getPaddingLeft()) + r13.getPaddingRight();
    L19:
        if (this.f16007u == false) goto L24;
        int r21 = this.f15989c;
        if (r20 <= r21) goto L23;
        r21 = (((int) this.f15993g) * 2) + r20;
    L23:
        int r22 = this.f15987a;
        int r23 = this.f16010x;
        int r24 = (r21 + (r22 * 2)) + (r23 * 2);
        int r25 = (this.f15990d + (r22 * 2)) + (r23 * 2);
    L26:
        if (r14 != Integer.MIN_VALUE) goto L29;
        if (r16 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r24, r25);
    L33:
        this.f15997k = getMeasuredWidth();
        this.f15998l = getMeasuredHeight();
        b();
        return;
    L29:
        if (r14 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r24, r17);
        goto L33
    L31:
        if (r16 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r15, r25);
        goto L33
    L24:
        PopupWindow r26 = new PopupWindow(getChildAt(0), -2, -2, true);
        r26.getContentView().measure(0, 0);
        r24 = r26.getContentView().getMeasuredWidth() + (D * 2);
        r25 = r26.getContentView().getMeasuredHeight() + (D * 2);
        goto L26
    L17:
        r20 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r13 = null;
        goto L10
    }

    public final void setBorderColor(int r10) {
        this.f16011y = r10;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f16010x = r10;
        if (this.f16012z != null) goto L7;
        this.f16012z = new Paint();
    L7:
        Paint r11 = this.f16012z;
        if (r11 == null) goto L11;
        r11.setStyle(Paint.Style.STROKE);
    L11:
        Paint r12 = this.f16012z;
        if (r12 == null) goto L15;
        r12.setStrokeWidth(this.f16010x);
    L15:
        Paint r13 = this.f16012z;
        if (r13 == null) goto L19;
        r13.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r14 = this.f16012z;
        if (r14 == null) goto L23;
        r14.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r15 = this.f16012z;
        if (r15 == null) goto L27;
        r15.setAntiAlias(true);
    L27:
        Paint r16 = this.f16012z;
        if (r16 == null) goto L31;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r17 = this.f16012z;
        if (r17 == null) goto L35;
        r17.setColor(this.f16011y);
    L35:
        Paint r18 = this.f15994h;
        Paint r19 = null;
        if (r18 != null) goto L38;
        q.y("mFillPaint");
        r18 = null;
    L38:
        r18.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r20 = this.f15994h;
        if (r20 != null) goto L41;
        q.y("mFillPaint");
    L42:
        r19.setStrokeWidth(this.f16010x);
        return;
    L41:
        r19 = r20;
        goto L42
    }

    public final void setBubbleOrientation(int r10) {
        this.f16000n = r10;
    }

    public final void setCornerRadius(@Px float r10) {
        this.f15991e = r10;
    }

    public final void setMAdjustHeight(int r10) {
        this.f16008v = r10;
    }

    public final void setMBgColor(int r10) {
        this.f16004r = r10;
    }

    public final void setMHeight(float r10) {
        this.f15998l = r10;
    }

    public final void setMNeedArrow(boolean r10) {
        this.f16006t = r10;
    }

    public final void setMNeedShadow(boolean r10) {
        this.f16005s = r10;
    }

    public final void setMWidth(float r10) {
        this.f15997k = r10;
    }

    public final void setPadding(float r10) {
        this.f15993g = r10;
    }

    public final void setTransparentBg(boolean r10) {
        if (r10 == false) goto L5;
        this.f16004r = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r10) {
        this.f16007u = r10;
    }

    public OMiddleArrowPopoverLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        this(r10, r11, 0);
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m24getPadding() {
        return this.f15987a / 2;
    }

    public OMiddleArrowPopoverLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        int r16 = 0;
        this.f15992f = new b(r13, r14, r15, r16, 15, null);
        this.f15999m = 0.75f;
        this.f16000n = 1;
        this.f16006t = true;
        this.f16007u = true;
        this.A = new Path();
        this.B = new Path();
        a(r10, r11);
    }
}
