package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u009b\u0001\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$¨\u00064"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPath;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "name", "", "pathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", LynxVideoManagerLite.FILL, "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "<init>", "(Ljava/lang/String;Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getPathData", "()Ljava/util/List;", "getPathFillType-Rg-k1Os", "()I", "I", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "getFillAlpha", "()F", "getStroke", "getStrokeAlpha", "getStrokeLineWidth", "getStrokeLineCap-KaPHkGw", "getStrokeLineJoin-LxFBmk8", "getStrokeLineMiter", "getTrimPathStart", "getTrimPathEnd", "getTrimPathOffset", "equals", "", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorPath extends VectorNode {
    public static final int $stable = 0;
    private final Brush fill;
    private final float fillAlpha;
    private final String name;
    private final List<PathNode> pathData;
    private final int pathFillType;
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;

    public /* synthetic */ VectorPath(String r100, List r101, int r102, Brush r103, float r104, Brush r105, float r106, float r107, int r108, int r110, float r111, float r112, float r113, float r114, DefaultConstructorMarker r115) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114);
    }

    public int hashCode() {
        int r100 = ((this.name.hashCode() * 31) + this.pathData.hashCode()) * 31;
        Brush r101 = this.fill;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + Float.floatToIntBits(this.fillAlpha)) * 31;
        Brush r105 = this.stroke;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((((((((((((((((((r104 + r102) * 31) + Float.floatToIntBits(this.strokeAlpha)) * 31) + Float.floatToIntBits(this.strokeLineWidth)) * 31) + StrokeCap.m5203hashCodeimpl(this.strokeLineCap)) * 31) + StrokeJoin.m5213hashCodeimpl(this.strokeLineJoin)) * 31) + Float.floatToIntBits(this.strokeLineMiter)) * 31) + Float.floatToIntBits(this.trimPathStart)) * 31) + Float.floatToIntBits(this.trimPathEnd)) * 31) + Float.floatToIntBits(this.trimPathOffset)) * 31) + PathFillType.m5127hashCodeimpl(this.pathFillType);
    L5:
        r103 = 0;
        goto L6
    }

    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* JADX INFO: renamed from: getPathFillType-Rg-k1Os, reason: not valid java name */
    public final int m5598getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    /* JADX INFO: renamed from: getStrokeLineCap-KaPHkGw, reason: not valid java name */
    public final int m5599getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name */
    public final int m5600getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L74:
        return false;
    L8:
        if (VectorPath.class != r100.getClass()) goto L74;
        VectorPath r101 = (VectorPath) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fill, r101.fill) == true) goto L17;
        return false;
    L17:
        if (this.fillAlpha != r101.fillAlpha) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.stroke, r101.stroke) == true) goto L26;
        return false;
    L26:
        if (this.strokeAlpha != r101.strokeAlpha) goto L28;
        boolean r103 = true;
    L29:
        if (r103 == true) goto L32;
        return false;
    L32:
        if (this.strokeLineWidth != r101.strokeLineWidth) goto L34;
        boolean r104 = true;
    L35:
        if (r104 == true) goto L38;
        return false;
    L38:
        if (StrokeCap.m5202equalsimpl0(this.strokeLineCap, r101.strokeLineCap) == true) goto L41;
        return false;
    L41:
        if (StrokeJoin.m5212equalsimpl0(this.strokeLineJoin, r101.strokeLineJoin) == true) goto L44;
        return false;
    L44:
        if (this.strokeLineMiter != r101.strokeLineMiter) goto L46;
        boolean r105 = true;
    L47:
        if (r105 == true) goto L50;
        return false;
    L50:
        if (this.trimPathStart != r101.trimPathStart) goto L52;
        boolean r106 = true;
    L53:
        if (r106 == true) goto L56;
        return false;
    L56:
        if (this.trimPathEnd != r101.trimPathEnd) goto L58;
        boolean r107 = true;
    L59:
        if (r107 == true) goto L62;
        return false;
    L62:
        if (this.trimPathOffset != r101.trimPathOffset) goto L64;
        boolean r108 = true;
    L65:
        if (r108 == true) goto L68;
        return false;
    L68:
        if (PathFillType.m5126equalsimpl0(this.pathFillType, r101.pathFillType) == true) goto L71;
        return false;
    L71:
        if (Intrinsics.areEqual(this.pathData, r101.pathData) == true) goto L73;
        return false;
    L73:
        return true;
    L64:
        r108 = false;
        goto L65
    L58:
        r107 = false;
        goto L59
    L52:
        r106 = false;
        goto L53
    L46:
        r105 = false;
        goto L47
    L34:
        r104 = false;
        goto L35
    L28:
        r103 = false;
        goto L29
    L19:
        r102 = false;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VectorPath(String r100, List<? extends PathNode> r101, int r102, Brush r103, float r104, Brush r105, float r106, float r107, int r110, int r111, float r112, float r113, float r114, float r115) {
        super(null);
        this.name = r100;
        this.pathData = r101;
        this.pathFillType = r102;
        this.fill = r103;
        this.fillAlpha = r104;
        this.stroke = r105;
        this.strokeAlpha = r106;
        this.strokeLineWidth = r107;
        this.strokeLineCap = r110;
        this.strokeLineJoin = r111;
        this.strokeLineMiter = r112;
        this.trimPathStart = r113;
        this.trimPathEnd = r114;
        this.trimPathOffset = r115;
    }

    public /* synthetic */ VectorPath(String r110, List r210, int r211, Brush r212, float r213, Brush r214, float r215, float r216, int r217, int r218, float r219, float r310, float r311, float r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r313 & 8) == 0) goto L9;
        Brush r101 = null;
    L11:
        if ((r313 & 16) == 0) goto L13;
        float r102 = 1.0f;
    L15:
        if ((r313 & 32) == 0) goto L17;
        Brush r103 = null;
    L19:
        if ((r313 & 64) == 0) goto L21;
        float r104 = 1.0f;
    L23:
        if ((r313 & 128) == 0) goto L25;
        float r111 = 0.0f;
    L27:
        if ((r313 & 256) == 0) goto L29;
        int r112 = VectorKt.getDefaultStrokeLineCap();
    L31:
        if ((r313 & 512) == 0) goto L33;
        int r113 = VectorKt.getDefaultStrokeLineJoin();
    L35:
        if ((r313 & 1024) == 0) goto L37;
        float r114 = 4.0f;
    L39:
        if ((r313 & 2048) == 0) goto L41;
        float r115 = 0.0f;
    L43:
        if ((r313 & 4096) == 0) goto L45;
        float r116 = 1.0f;
    L47:
        if ((r313 & 8192) == 0) goto L49;
        float r117 = 0.0f;
    L50:
        this(r100, r210, r211, r101, r102, r103, r104, r111, r112, r113, r114, r115, r116, r117, null);
        return;
    L49:
        r117 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L47
    L41:
        r115 = r310;
        goto L43
    L37:
        r114 = r219;
        goto L39
    L33:
        r113 = r218;
        goto L35
    L29:
        r112 = r217;
        goto L31
    L25:
        r111 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
