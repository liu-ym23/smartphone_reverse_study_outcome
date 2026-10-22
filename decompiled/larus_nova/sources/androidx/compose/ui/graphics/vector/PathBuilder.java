package androidx.compose.ui.graphics.vector;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0000J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fJ6\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fJ6\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fJ&\u0010(\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fJ&\u0010)\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fJ&\u0010*\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fJ&\u0010+\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fJ\u0016\u0010,\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u0016\u0010-\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fJ>\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ>\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u00068"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "<init>", "()V", "_nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodes", "", "getNodes", "()Ljava/util/List;", "close", "moveTo", "x", "", "y", "moveToRelative", "dx", "dy", "lineTo", "lineToRelative", "horizontalLineTo", "horizontalLineToRelative", "verticalLineTo", "verticalLineToRelative", "curveTo", "x1", "y1", "x2", "y2", "x3", "y3", "curveToRelative", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "reflectiveCurveTo", "reflectiveCurveToRelative", "quadTo", "quadToRelative", "reflectiveQuadTo", "reflectiveQuadToRelative", "arcTo", "horizontalEllipseRadius", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToRelative", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PathBuilder {
    private final ArrayList<PathNode> _nodes;

    public final PathBuilder close() {
        this._nodes.add(PathNode.Close.INSTANCE);
        return this;
    }

    public PathBuilder() {
        this._nodes = new ArrayList(32);
    }

    public final List<PathNode> getNodes() {
        return this._nodes;
    }

    public final PathBuilder horizontalLineTo(float r100) {
        this._nodes.add(new PathNode.HorizontalTo(r100));
        return this;
    }

    public final PathBuilder horizontalLineToRelative(float r100) {
        this._nodes.add(new PathNode.RelativeHorizontalTo(r100));
        return this;
    }

    public final PathBuilder verticalLineTo(float r100) {
        this._nodes.add(new PathNode.VerticalTo(r100));
        return this;
    }

    public final PathBuilder verticalLineToRelative(float r100) {
        this._nodes.add(new PathNode.RelativeVerticalTo(r100));
        return this;
    }

    public final PathBuilder lineTo(float r100, float r101) {
        this._nodes.add(new PathNode.LineTo(r100, r101));
        return this;
    }

    public final PathBuilder lineToRelative(float r100, float r101) {
        this._nodes.add(new PathNode.RelativeLineTo(r100, r101));
        return this;
    }

    public final PathBuilder moveTo(float r100, float r101) {
        this._nodes.add(new PathNode.MoveTo(r100, r101));
        return this;
    }

    public final PathBuilder moveToRelative(float r100, float r101) {
        this._nodes.add(new PathNode.RelativeMoveTo(r100, r101));
        return this;
    }

    public final PathBuilder reflectiveQuadTo(float r100, float r101) {
        this._nodes.add(new PathNode.ReflectiveQuadTo(r100, r101));
        return this;
    }

    public final PathBuilder reflectiveQuadToRelative(float r100, float r101) {
        this._nodes.add(new PathNode.RelativeReflectiveQuadTo(r100, r101));
        return this;
    }

    public final PathBuilder quadTo(float r100, float r101, float r102, float r103) {
        this._nodes.add(new PathNode.QuadTo(r100, r101, r102, r103));
        return this;
    }

    public final PathBuilder quadToRelative(float r100, float r101, float r102, float r103) {
        this._nodes.add(new PathNode.RelativeQuadTo(r100, r101, r102, r103));
        return this;
    }

    public final PathBuilder reflectiveCurveTo(float r100, float r101, float r102, float r103) {
        this._nodes.add(new PathNode.ReflectiveCurveTo(r100, r101, r102, r103));
        return this;
    }

    public final PathBuilder reflectiveCurveToRelative(float r100, float r101, float r102, float r103) {
        this._nodes.add(new PathNode.RelativeReflectiveCurveTo(r100, r101, r102, r103));
        return this;
    }

    public final PathBuilder curveTo(float r110, float r111, float r112, float r113, float r114, float r115) {
        this._nodes.add(new PathNode.CurveTo(r110, r111, r112, r113, r114, r115));
        return this;
    }

    public final PathBuilder curveToRelative(float r110, float r111, float r112, float r113, float r114, float r115) {
        this._nodes.add(new PathNode.RelativeCurveTo(r110, r111, r112, r113, r114, r115));
        return this;
    }

    public final PathBuilder arcTo(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r116) {
        this._nodes.add(new PathNode.ArcTo(r110, r111, r112, r113, r114, r115, r116));
        return this;
    }

    public final PathBuilder arcToRelative(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r116) {
        this._nodes.add(new PathNode.RelativeArcTo(r110, r111, r112, r113, r114, r115, r116));
        return this;
    }
}
