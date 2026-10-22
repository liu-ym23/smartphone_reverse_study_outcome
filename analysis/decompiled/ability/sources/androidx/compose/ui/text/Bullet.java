package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b%\u0010#R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/unit/TextUnit;", "width", "height", "padding", "Landroidx/compose/ui/graphics/Brush;", "brush", "", "alpha", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/e;)V", "copy-w_4Rhrw", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/Bullet;", "copy", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "J", "getWidth-XSAIIZE", "()J", "getHeight-XSAIIZE", "getPadding-XSAIIZE", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "F", "getAlpha", "()F", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Bullet implements AnnotatedString.Annotation {
    private static final Bullet Default;
    private static final long DefaultPadding;
    private static final long DefaultSize;
    private final float alpha;
    private final Brush brush;
    private final DrawStyle drawStyle;
    private final long height;
    private final long padding;
    private final Shape shape;
    private final long width;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long DefaultIndentation = TextUnitKt.getEm(1);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/Bullet$Companion;", "", AppAgent.CONSTRUCT, "()V", "DefaultIndentation", "Landroidx/compose/ui/unit/TextUnit;", "getDefaultIndentation-XSAIIZE", "()J", "J", "DefaultSize", "getDefaultSize-XSAIIZE", "DefaultPadding", "getDefaultPadding-XSAIIZE", "Default", "Landroidx/compose/ui/text/Bullet;", "getDefault", "()Landroidx/compose/ui/text/Bullet;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Bullet getDefault() {
            return Bullet.Default;
        }

        /* renamed from: getDefaultIndentation-XSAIIZE, reason: not valid java name */
        public final long m6155getDefaultIndentationXSAIIZE() {
            return Bullet.DefaultIndentation;
        }

        /* renamed from: getDefaultPadding-XSAIIZE, reason: not valid java name */
        public final long m6156getDefaultPaddingXSAIIZE() {
            return Bullet.DefaultPadding;
        }

        /* renamed from: getDefaultSize-XSAIIZE, reason: not valid java name */
        public final long m6157getDefaultSizeXSAIIZE() {
            return Bullet.DefaultSize;
        }

        private Companion() {
        }
    }

    static {
        long em = TextUnitKt.getEm(0.25d);
        DefaultSize = em;
        long em2 = TextUnitKt.getEm(0.25d);
        DefaultPadding = em2;
        Default = new Bullet(CircleShape.INSTANCE, em, em, em2, null, 0.0f, null, 112, null);
    }

    public /* synthetic */ Bullet(Shape shape, long j5, long j6, long j10, Brush brush, float f, DrawStyle drawStyle, e eVar) {
        this(shape, j5, j6, j10, brush, f, drawStyle);
    }

    /* renamed from: copy-w_4Rhrw$default, reason: not valid java name */
    public static /* synthetic */ Bullet m6150copyw_4Rhrw$default(Bullet bullet, Shape shape, long j5, long j6, long j10, Brush brush, float f, DrawStyle drawStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bullet.shape;
        }
        if ((i & 2) != 0) {
            j5 = bullet.width;
        }
        if ((i & 4) != 0) {
            j6 = bullet.height;
        }
        if ((i & 8) != 0) {
            j10 = bullet.padding;
        }
        if ((i & 16) != 0) {
            brush = bullet.brush;
        }
        if ((i & 32) != 0) {
            f = bullet.alpha;
        }
        if ((i & 64) != 0) {
            drawStyle = bullet.drawStyle;
        }
        DrawStyle drawStyle2 = drawStyle;
        Brush brush2 = brush;
        long j11 = j10;
        long j12 = j6;
        return bullet.m6151copyw_4Rhrw(shape, j5, j12, j11, brush2, f, drawStyle2);
    }

    /* renamed from: copy-w_4Rhrw, reason: not valid java name */
    public final Bullet m6151copyw_4Rhrw(Shape shape, long width, long height, long padding, Brush brush, float alpha, DrawStyle drawStyle) {
        return new Bullet(shape, width, height, padding, brush, alpha, drawStyle, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof Bullet)) {
            Bullet bullet = (Bullet) other;
            return k.b(this.shape, bullet.shape) && TextUnit.m7035equalsimpl0(this.width, bullet.width) && TextUnit.m7035equalsimpl0(this.height, bullet.height) && TextUnit.m7035equalsimpl0(this.padding, bullet.padding) && k.b(this.brush, bullet.brush) && this.alpha == bullet.alpha && k.b(this.drawStyle, bullet.drawStyle);
        }
        return false;
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

    /* renamed from: getHeight-XSAIIZE, reason: not valid java name and from getter */
    public final long getHeight() {
        return this.height;
    }

    /* renamed from: getPadding-XSAIIZE, reason: not valid java name and from getter */
    public final long getPadding() {
        return this.padding;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-XSAIIZE, reason: not valid java name and from getter */
    public final long getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iM7039hashCodeimpl = (TextUnit.m7039hashCodeimpl(this.padding) + ((TextUnit.m7039hashCodeimpl(this.height) + ((TextUnit.m7039hashCodeimpl(this.width) + (this.shape.hashCode() * 31)) * 31)) * 31)) * 31;
        Brush brush = this.brush;
        return this.drawStyle.hashCode() + androidx.appfunctions.metadata.a.b(this.alpha, (iM7039hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        return "Bullet(shape=" + this.shape + ", size=(" + ((Object) TextUnit.m7045toStringimpl(this.width)) + ", " + ((Object) TextUnit.m7045toStringimpl(this.height)) + "), padding=" + ((Object) TextUnit.m7045toStringimpl(this.padding)) + ", brush=" + this.brush + ", alpha=" + this.alpha + ", drawStyle=" + this.drawStyle + ')';
    }

    private Bullet(Shape shape, long j5, long j6, long j10, Brush brush, float f, DrawStyle drawStyle) {
        this.shape = shape;
        this.width = j5;
        this.height = j6;
        this.padding = j10;
        this.brush = brush;
        this.alpha = f;
        this.drawStyle = drawStyle;
    }

    public /* synthetic */ Bullet(Shape shape, long j5, long j6, long j10, Brush brush, float f, DrawStyle drawStyle, int i, e eVar) {
        this(shape, j5, j6, j10, (i & 16) != 0 ? null : brush, (i & 32) != 0 ? Float.NaN : f, (i & 64) != 0 ? Fill.INSTANCE : drawStyle, null);
    }
}
