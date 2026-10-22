package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", GXTemplateKey.FLEXBOX_PADDING, "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getWidth-XSAIIZE", "()J", "J", "getHeight-XSAIIZE", "getPadding-XSAIIZE", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "()F", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "copy", "copy-w_4Rhrw", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/Bullet;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Bullet implements AnnotatedString.Annotation {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Bullet Default = null;
    private static final long DefaultIndentation = 0;
    private static final long DefaultPadding = 0;
    private static final long DefaultSize = 0;
    private final float alpha;
    private final Brush brush;
    private final DrawStyle drawStyle;
    private final long height;
    private final long padding;
    private final Shape shape;
    private final long width;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/Bullet$Companion;", "", "<init>", "()V", "DefaultIndentation", "Landroidx/compose/ui/unit/TextUnit;", "getDefaultIndentation-XSAIIZE", "()J", "J", "DefaultSize", "getDefaultSize-XSAIIZE", "DefaultPadding", "getDefaultPadding-XSAIIZE", "Default", "Landroidx/compose/ui/text/Bullet;", "getDefault", "()Landroidx/compose/ui/text/Bullet;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Bullet getDefault() {
            return Bullet.access$getDefault$cp();
        }

        /* JADX INFO: renamed from: getDefaultIndentation-XSAIIZE, reason: not valid java name */
        public final long m6842getDefaultIndentationXSAIIZE() {
            return Bullet.access$getDefaultIndentation$cp();
        }

        /* JADX INFO: renamed from: getDefaultPadding-XSAIIZE, reason: not valid java name */
        public final long m6843getDefaultPaddingXSAIIZE() {
            return Bullet.access$getDefaultPadding$cp();
        }

        /* JADX INFO: renamed from: getDefaultSize-XSAIIZE, reason: not valid java name */
        public final long m6844getDefaultSizeXSAIIZE() {
            return Bullet.access$getDefaultSize$cp();
        }
    }

    public /* synthetic */ Bullet(Shape r100, long r101, long r102, long r103, Brush r104, float r105, DrawStyle r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r110);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        DefaultIndentation = TextUnitKt.getEm(1);
        long r100 = TextUnitKt.getEm(0.25d);
        DefaultSize = r100;
        long r101 = TextUnitKt.getEm(0.25d);
        DefaultPadding = r101;
        Default = new Bullet(CircleShape.INSTANCE, r100, r100, r101, null, 0.0f, null, 112, null);
    }

    public int hashCode() {
        int r100 = ((((((this.shape.hashCode() * 31) + TextUnit.m7743hashCodeimpl(this.width)) * 31) + TextUnit.m7743hashCodeimpl(this.height)) * 31) + TextUnit.m7743hashCodeimpl(this.padding)) * 31;
        Brush r101 = this.brush;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((r100 + r102) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.drawStyle.hashCode();
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "Bullet(shape=" + this.shape + ", size=(" + TextUnit.m7749toStringimpl(this.width) + ", " + TextUnit.m7749toStringimpl(this.height) + "), padding=" + TextUnit.m7749toStringimpl(this.padding) + ", brush=" + this.brush + ", alpha=" + this.alpha + ", drawStyle=" + this.drawStyle + ')';
    }

    public static final /* synthetic */ Bullet access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ long access$getDefaultIndentation$cp() {
        return DefaultIndentation;
    }

    public static final /* synthetic */ long access$getDefaultPadding$cp() {
        return DefaultPadding;
    }

    public static final /* synthetic */ long access$getDefaultSize$cp() {
        return DefaultSize;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    /* JADX INFO: renamed from: getHeight-XSAIIZE, reason: not valid java name */
    public final long m6839getHeightXSAIIZE() {
        return this.height;
    }

    /* JADX INFO: renamed from: getPadding-XSAIIZE, reason: not valid java name */
    public final long m6840getPaddingXSAIIZE() {
        return this.padding;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: getWidth-XSAIIZE, reason: not valid java name */
    public final long m6841getWidthXSAIIZE() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L35:
        return false;
    L8:
        if ((r100 instanceof Bullet) == false) goto L35;
        Bullet r101 = (Bullet) r100;
        if (Intrinsics.areEqual(this.shape, r101.shape) == true) goto L14;
        return false;
    L14:
        if (TextUnit.m7739equalsimpl0(this.width, r101.width) == true) goto L17;
        return false;
    L17:
        if (TextUnit.m7739equalsimpl0(this.height, r101.height) == true) goto L20;
        return false;
    L20:
        if (TextUnit.m7739equalsimpl0(this.padding, r101.padding) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.brush, r101.brush) == true) goto L26;
        return false;
    L26:
        if (this.alpha != r101.alpha) goto L28;
        boolean r102 = true;
    L29:
        if (r102 == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.drawStyle, r101.drawStyle) == true) goto L34;
        return false;
    L34:
        return true;
    L28:
        r102 = false;
        goto L29
    }

    private Bullet(Shape r100, long r101, long r102, long r103, Brush r104, float r105, DrawStyle r110) {
        this.shape = r100;
        this.width = r101;
        this.height = r102;
        this.padding = r103;
        this.brush = r104;
        this.alpha = r105;
        this.drawStyle = r110;
    }

    /* JADX INFO: renamed from: copy-w_4Rhrw, reason: not valid java name */
    public final Bullet m6838copyw_4Rhrw(Shape r110, long r111, long r112, long r113, Brush r210, float r211, DrawStyle r212) {
        return new Bullet(r110, r111, r112, r113, r210, r211, r212, null);
    }

    public /* synthetic */ Bullet(Shape r110, long r111, long r112, long r113, Brush r210, float r211, DrawStyle r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 16) == 0) goto L5;
        Brush r100 = null;
    L7:
        if ((r213 & 32) == 0) goto L9;
        float r114 = Float.NaN;
    L11:
        if ((r213 & 64) == 0) goto L13;
        DrawStyle r115 = Fill.INSTANCE;
    L14:
        this(r110, r111, r112, r113, r100, r114, r115, null);
        return;
    L13:
        r115 = r212;
        goto L14
    L9:
        r114 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: copy-w_4Rhrw$default, reason: not valid java name */
    public static /* synthetic */ Bullet m6837copyw_4Rhrw$default(Bullet r110, Shape r111, long r112, long r113, long r114, Brush r115, float r210, DrawStyle r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Shape r100 = r110.shape;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.width;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.height;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.padding;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Brush r104 = r110.brush;
    L23:
        if ((r212 & 32) == 0) goto L25;
        float r105 = r110.alpha;
    L27:
        if ((r212 & 64) == 0) goto L29;
        DrawStyle r116 = r110.drawStyle;
    L31:
        return r110.m6838copyw_4Rhrw(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
