package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@DrawScopeMarker
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 u2\u00020\u0001:\u0001uJg\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b\"\u0010#Jg\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b&\u0010'JU\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b,\u0010-JU\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b.\u0010/JK\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b3\u00104Ji\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u0002082\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'¢\u0006\u0004\b;\u0010<Js\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u0002082\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010=\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J_\u0010A\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bD\u0010EJ_\u0010A\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bF\u0010GJU\u0010H\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010I\u001a\u00020\u00182\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bJ\u0010KJU\u0010H\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010I\u001a\u00020\u00182\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bL\u0010MJU\u0010N\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bO\u0010-JU\u0010N\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bP\u0010/Jm\u0010Q\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bV\u0010WJm\u0010Q\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bX\u0010YJI\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\\2\u0006\u0010$\u001a\u00020%2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b]\u0010^JI\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\\2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\b_\u0010`Jm\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00070c2\u0006\u0010d\u001a\u00020e2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bf\u0010gJm\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00070c2\u0006\u0010d\u001a\u00020e2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&¢\u0006\u0004\bh\u0010iJ6\u0010j\u001a\u00020\u0012*\u00020k2\b\b\u0002\u0010\n\u001a\u0002082\u0017\u0010l\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120m¢\u0006\u0002\bnH\u0016¢\u0006\u0004\bo\u0010pJ\u001b\u0010q\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010r\u001a\u00020\u0007H\u0002¢\u0006\u0004\bs\u0010tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006vÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "drawLine", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "start", "end", "strokeWidth", "", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "topLeft", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "drawOval-n-J9OG0", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "offsetSize", "offset", "offsetSize-PENXr5M", "(JJ)J", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DrawScope extends Density {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.DrawScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = DrawScope.Companion;
        }

        /* JADX INFO: renamed from: $default$getCenter-F1C5BW0, reason: not valid java name */
        public static long m5371$default$getCenterF1C5BW0(DrawScope r100) {
            return SizeKt.m4661getCenteruvyYCjk(r100.getDrawContext().mo5329getSizeNHjbRc());
        }

        /* JADX INFO: renamed from: $default$getSize-NH-jbRc, reason: not valid java name */
        public static long m5372$default$getSizeNHjbRc(DrawScope r100) {
            return r100.getDrawContext().mo5329getSizeNHjbRc();
        }

        /* JADX INFO: renamed from: access$getCenter-F1C5BW0$jd, reason: not valid java name */
        public static /* synthetic */ long m5376access$getCenterF1C5BW0$jd(DrawScope r100) {
            return m5371$default$getCenterF1C5BW0(r100);
        }

        /* JADX INFO: renamed from: access$getSize-NH-jbRc$jd, reason: not valid java name */
        public static /* synthetic */ long m5377access$getSizeNHjbRc$jd(DrawScope r100) {
            return m5372$default$getSizeNHjbRc(r100);
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m5379access$roundToPxR2X_6o$jd(DrawScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m5380access$roundToPx0680j_4$jd(DrawScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m5381access$toDpGaN1DYA$jd(DrawScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m5382access$toDpu2uoSUM$jd(DrawScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m5384access$toDpSizekrfVVM$jd(DrawScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m5385access$toPxR2X_6o$jd(DrawScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m5386access$toPx0680j_4$jd(DrawScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(DrawScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m5387access$toSizeXkaWNTQ$jd(DrawScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m5388access$toSp0xMU5do$jd(DrawScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m5389access$toSpkPz2Gy4$jd(DrawScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m5383access$toDpu2uoSUM$jd(DrawScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m5390access$toSpkPz2Gy4$jd(DrawScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: $private$offsetSize-PENXr5M, reason: not valid java name */
        public static long m5374$private$offsetSizePENXr5M(DrawScope r100, long r101, long r102) {
            float r103 = Float.intBitsToFloat((int) (r101 >> 32)) - Float.intBitsToFloat((int) (r102 >> 32));
            float r104 = Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)) - Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax));
            return Size.m4642constructorimpl((Float.floatToRawIntBits(r103) << 32) | (((long) Float.floatToRawIntBits(r104)) & BodyPartID.bodyIdMax));
        }

        /* JADX INFO: renamed from: $default$record-JVtK1S4, reason: not valid java name */
        public static void m5373$default$recordJVtK1S4(final DrawScope r100, GraphicsLayer r101, long r102, final Function1 r110) {
            r101.m5504recordmLhObY(r100, r100.getLayoutDirection(), r102, new DrawScope$record$1(r100, r110));
        }

        /* JADX INFO: renamed from: access$record-JVtK1S4$jd, reason: not valid java name */
        public static /* synthetic */ void m5378access$recordJVtK1S4$jd(DrawScope r100, GraphicsLayer r101, long r102, Function1 r103) {
            m5373$default$recordJVtK1S4(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: record-JVtK1S4$default, reason: not valid java name */
        public static /* synthetic */ void m5410recordJVtK1S4$default(DrawScope r100, GraphicsLayer r101, long r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 1) == 0) goto L6;
            r102 = IntSizeKt.m7730toIntSizeuvyYCjk(r100.mo5322getSizeNHjbRc());
        L6:
            r100.mo5323recordJVtK1S4(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }

        /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
        public static /* synthetic */ void m5397drawImagegbVJVH8$default(DrawScope r100, ImageBitmap r101, long r102, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114, Object r115) {
            if (r115 != null) goto L26;
            if ((r114 & 2) == 0) goto L6;
            long r103 = Offset.Companion.m4598getZeroF1C5BW0();
        L8:
            if ((r114 & 4) == 0) goto L10;
            float r104 = 1.0f;
        L12:
            if ((r114 & 8) == 0) goto L14;
            DrawStyle r105 = Fill.INSTANCE;
        L16:
            if ((r114 & 16) == 0) goto L18;
            ColorFilter r106 = null;
        L20:
            if ((r114 & 32) == 0) goto L22;
            int r107 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L23:
            r100.mo5308drawImagegbVJVH8(r101, r103, r104, r105, r106, r107);
            return;
        L22:
            r107 = r113;
            goto L23
        L18:
            r106 = r112;
            goto L20
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L26:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }

        /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
        public static /* synthetic */ void m5402drawPathGBMwjPU$default(DrawScope r100, Path r101, Brush r102, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114, Object r115) {
            if (r115 != null) goto L19;
            if ((r114 & 4) == 0) goto L6;
            float r103 = 1.0f;
        L8:
            if ((r114 & 8) == 0) goto L10;
            r111 = Fill.INSTANCE;
        L10:
            DrawStyle r104 = r111;
            if ((r114 & 16) == 0) goto L13;
            r112 = null;
        L13:
            ColorFilter r105 = r112;
            if ((r114 & 32) == 0) goto L16;
            r113 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L16:
            r100.mo5313drawPathGBMwjPU(r101, r102, r103, r104, r105, r113);
            return;
        L6:
            r103 = r110;
            goto L8
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }

        /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
        public static /* synthetic */ void m5403drawPathLG529CI$default(DrawScope r100, Path r110, long r111, float r112, DrawStyle r113, ColorFilter r114, int r115, int r116, Object r117) {
            if (r117 != null) goto L22;
            if ((r116 & 4) == 0) goto L6;
            float r101 = 1.0f;
        L8:
            if ((r116 & 8) == 0) goto L10;
            DrawStyle r102 = Fill.INSTANCE;
        L12:
            if ((r116 & 16) == 0) goto L14;
            ColorFilter r103 = null;
        L16:
            if ((r116 & 32) == 0) goto L18;
            int r104 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L19:
            r100.mo5314drawPathLG529CI(r110, r111, r101, r102, r103, r104);
            return;
        L18:
            r104 = r115;
            goto L19
        L14:
            r103 = r114;
            goto L16
        L10:
            r102 = r113;
            goto L12
        L6:
            r101 = r112;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }

        /* JADX INFO: renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
        public static /* synthetic */ void m5393drawCircleV9BoPsw$default(DrawScope r100, Brush r101, float r102, long r110, float r111, DrawStyle r112, ColorFilter r113, int r114, int r115, Object r116) {
            if (r116 != null) goto L30;
            if ((r115 & 2) == 0) goto L6;
            float r103 = Size.m4650getMinDimensionimpl(r100.mo5322getSizeNHjbRc()) / 2.0f;
        L8:
            if ((r115 & 4) == 0) goto L10;
            long r104 = r100.mo5321getCenterF1C5BW0();
        L12:
            if ((r115 & 8) == 0) goto L14;
            float r105 = 1.0f;
        L16:
            if ((r115 & 16) == 0) goto L18;
            DrawStyle r106 = Fill.INSTANCE;
        L20:
            if ((r115 & 32) == 0) goto L22;
            ColorFilter r107 = null;
        L24:
            if ((r115 & 64) == 0) goto L26;
            int r108 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r100.mo5304drawCircleV9BoPsw(r101, r103, r104, r105, r106, r107, r108);
            return;
        L26:
            r108 = r114;
            goto L27
        L22:
            r107 = r113;
            goto L24
        L18:
            r106 = r112;
            goto L20
        L14:
            r105 = r111;
            goto L16
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }

        /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
        public static /* synthetic */ void m5394drawCircleVaOC9Bg$default(DrawScope r110, long r111, float r112, long r113, float r114, DrawStyle r115, ColorFilter r116, int r210, int r211, Object r212) {
            if (r212 != null) goto L30;
            if ((r211 & 2) == 0) goto L6;
            float r100 = Size.m4650getMinDimensionimpl(r110.mo5322getSizeNHjbRc()) / 2.0f;
        L8:
            if ((r211 & 4) == 0) goto L10;
            long r101 = r110.mo5321getCenterF1C5BW0();
        L12:
            if ((r211 & 8) == 0) goto L14;
            float r102 = 1.0f;
        L16:
            if ((r211 & 16) == 0) goto L18;
            DrawStyle r103 = Fill.INSTANCE;
        L20:
            if ((r211 & 32) == 0) goto L22;
            ColorFilter r104 = null;
        L24:
            if ((r211 & 64) == 0) goto L26;
            int r117 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r110.mo5305drawCircleVaOC9Bg(r111, r100, r101, r102, r103, r104, r117);
            return;
        L26:
            r117 = r210;
            goto L27
        L22:
            r104 = r116;
            goto L24
        L18:
            r103 = r115;
            goto L20
        L14:
            r102 = r114;
            goto L16
        L10:
            r101 = r113;
            goto L12
        L6:
            r100 = r112;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }

        /* JADX INFO: renamed from: drawOval-AsUm42w$default, reason: not valid java name */
        public static /* synthetic */ void m5400drawOvalAsUm42w$default(DrawScope r100, Brush r110, long r111, long r112, float r113, DrawStyle r114, ColorFilter r115, int r116, int r117, Object r210) {
            if (r210 != null) goto L30;
            if ((r117 & 2) == 0) goto L6;
            long r101 = Offset.Companion.m4598getZeroF1C5BW0();
        L8:
            if ((r117 & 4) == 0) goto L10;
            long r102 = m5374$private$offsetSizePENXr5M(r100, r100.mo5322getSizeNHjbRc(), r101);
        L12:
            if ((r117 & 8) == 0) goto L14;
            float r103 = 1.0f;
        L16:
            if ((r117 & 16) == 0) goto L18;
            DrawStyle r104 = Fill.INSTANCE;
        L20:
            if ((r117 & 32) == 0) goto L22;
            ColorFilter r105 = null;
        L24:
            if ((r117 & 64) == 0) goto L26;
            int r106 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r100.mo5311drawOvalAsUm42w(r110, r101, r102, r103, r104, r105, r106);
            return;
        L26:
            r106 = r116;
            goto L27
        L22:
            r105 = r115;
            goto L24
        L18:
            r104 = r114;
            goto L20
        L14:
            r103 = r113;
            goto L16
        L10:
            r102 = r112;
            goto L12
        L6:
            r101 = r111;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }

        /* JADX INFO: renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
        public static /* synthetic */ void m5401drawOvalnJ9OG0$default(DrawScope r110, long r111, long r112, long r113, float r210, DrawStyle r211, ColorFilter r212, int r213, int r214, Object r215) {
            if (r215 != null) goto L30;
            if ((r214 & 2) == 0) goto L6;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L8:
            if ((r214 & 4) == 0) goto L10;
            long r101 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L12:
            if ((r214 & 8) == 0) goto L14;
            float r102 = 1.0f;
        L16:
            if ((r214 & 16) == 0) goto L18;
            DrawStyle r114 = Fill.INSTANCE;
        L20:
            if ((r214 & 32) == 0) goto L22;
            ColorFilter r115 = null;
        L24:
            if ((r214 & 64) == 0) goto L26;
            int r116 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r110.mo5312drawOvalnJ9OG0(r111, r100, r101, r102, r114, r115, r116);
            return;
        L26:
            r116 = r213;
            goto L27
        L22:
            r115 = r212;
            goto L24
        L18:
            r114 = r211;
            goto L20
        L14:
            r102 = r210;
            goto L16
        L10:
            r101 = r113;
            goto L12
        L6:
            r100 = r112;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }

        /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
        public static /* synthetic */ void m5406drawRectAsUm42w$default(DrawScope r100, Brush r110, long r111, long r112, float r113, DrawStyle r114, ColorFilter r115, int r116, int r117, Object r210) {
            if (r210 != null) goto L30;
            if ((r117 & 2) == 0) goto L6;
            long r101 = Offset.Companion.m4598getZeroF1C5BW0();
        L8:
            if ((r117 & 4) == 0) goto L10;
            long r102 = m5374$private$offsetSizePENXr5M(r100, r100.mo5322getSizeNHjbRc(), r101);
        L12:
            if ((r117 & 8) == 0) goto L14;
            float r103 = 1.0f;
        L16:
            if ((r117 & 16) == 0) goto L18;
            DrawStyle r104 = Fill.INSTANCE;
        L20:
            if ((r117 & 32) == 0) goto L22;
            ColorFilter r105 = null;
        L24:
            if ((r117 & 64) == 0) goto L26;
            int r106 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r100.mo5317drawRectAsUm42w(r110, r101, r102, r103, r104, r105, r106);
            return;
        L26:
            r106 = r116;
            goto L27
        L22:
            r105 = r115;
            goto L24
        L18:
            r104 = r114;
            goto L20
        L14:
            r103 = r113;
            goto L16
        L10:
            r102 = r112;
            goto L12
        L6:
            r101 = r111;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }

        /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
        public static /* synthetic */ void m5407drawRectnJ9OG0$default(DrawScope r110, long r111, long r112, long r113, float r210, DrawStyle r211, ColorFilter r212, int r213, int r214, Object r215) {
            if (r215 != null) goto L30;
            if ((r214 & 2) == 0) goto L6;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L8:
            if ((r214 & 4) == 0) goto L10;
            long r101 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L12:
            if ((r214 & 8) == 0) goto L14;
            float r102 = 1.0f;
        L16:
            if ((r214 & 16) == 0) goto L18;
            DrawStyle r114 = Fill.INSTANCE;
        L20:
            if ((r214 & 32) == 0) goto L22;
            ColorFilter r115 = null;
        L24:
            if ((r214 & 64) == 0) goto L26;
            int r116 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L27:
            r110.mo5318drawRectnJ9OG0(r111, r100, r101, r102, r114, r115, r116);
            return;
        L26:
            r116 = r213;
            goto L27
        L22:
            r115 = r212;
            goto L24
        L18:
            r114 = r211;
            goto L20
        L14:
            r102 = r210;
            goto L16
        L10:
            r101 = r113;
            goto L12
        L6:
            r100 = r112;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }

        /* JADX INFO: renamed from: $default$drawImage-AZ2fEMs, reason: not valid java name */
        public static void m5370$default$drawImageAZ2fEMs(DrawScope r110, ImageBitmap r111, long r112, long r210, long r211, long r212, float r213, DrawStyle r214, ColorFilter r215, int r310, int r311) {
            m5396drawImageAZ2fEMs$default(r110, r111, r112, r210, r211, r212, r213, r214, r215, r310, 0, 512, null);
        }

        /* JADX INFO: renamed from: access$drawImage-AZ2fEMs$jd, reason: not valid java name */
        public static /* synthetic */ void m5375access$drawImageAZ2fEMs$jd(DrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114) {
            m5370$default$drawImageAZ2fEMs(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
        }

        /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
        public static /* synthetic */ void m5408drawRoundRectZuiqVtQ$default(DrawScope r110, Brush r111, long r112, long r113, long r114, float r115, DrawStyle r210, ColorFilter r211, int r212, int r213, Object r214) {
            if (r214 != null) goto L35;
            if ((r213 & 2) == 0) goto L7;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L9:
            if ((r213 & 4) == 0) goto L11;
            long r101 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L13:
            if ((r213 & 8) == 0) goto L15;
            long r102 = CornerRadius.Companion.m4554getZerokKHJgLs();
        L17:
            if ((r213 & 16) == 0) goto L19;
            float r103 = 1.0f;
        L21:
            if ((r213 & 32) == 0) goto L23;
            DrawStyle r104 = Fill.INSTANCE;
        L25:
            if ((r213 & 64) == 0) goto L27;
            ColorFilter r116 = null;
        L29:
            if ((r213 & 128) == 0) goto L31;
            int r105 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L32:
            r110.mo5319drawRoundRectZuiqVtQ(r111, r100, r101, r102, r103, r104, r116, r105);
            return;
        L31:
            r105 = r212;
            goto L32
        L27:
            r116 = r211;
            goto L29
        L23:
            r104 = r210;
            goto L25
        L19:
            r103 = r115;
            goto L21
        L15:
            r102 = r114;
            goto L17
        L11:
            r101 = r113;
            goto L13
        L7:
            r100 = r112;
            goto L9
        L35:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }

        /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
        public static /* synthetic */ void m5409drawRoundRectuAw5IA$default(DrawScope r110, long r111, long r112, long r210, long r211, DrawStyle r212, float r213, ColorFilter r214, int r215, int r216, Object r310) {
            if (r310 != null) goto L35;
            if ((r216 & 2) == 0) goto L7;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L9:
            if ((r216 & 4) == 0) goto L11;
            long r101 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L13:
            if ((r216 & 8) == 0) goto L15;
            long r113 = CornerRadius.Companion.m4554getZerokKHJgLs();
        L17:
            if ((r216 & 16) == 0) goto L19;
            DrawStyle r114 = Fill.INSTANCE;
        L21:
            if ((r216 & 32) == 0) goto L23;
            float r115 = 1.0f;
        L25:
            if ((r216 & 64) == 0) goto L27;
            ColorFilter r116 = null;
        L29:
            if ((r216 & 128) == 0) goto L31;
            int r117 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L32:
            r110.mo5320drawRoundRectuAw5IA(r111, r100, r101, r113, r114, r115, r116, r117);
            return;
        L31:
            r117 = r215;
            goto L32
        L27:
            r116 = r214;
            goto L29
        L23:
            r115 = r213;
            goto L25
        L19:
            r114 = r212;
            goto L21
        L15:
            r113 = r211;
            goto L17
        L11:
            r101 = r210;
            goto L13
        L7:
            r100 = r112;
            goto L9
        L35:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }

        /* JADX INFO: renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
        public static /* synthetic */ void m5395drawImage9jGpkUE$default(DrawScope r110, ImageBitmap r111, long r112, long r113, long r114, long r210, float r211, DrawStyle r212, ColorFilter r213, int r214, int r215, Object r216) {
            if (r216 != null) goto L39;
            if ((r215 & 2) == 0) goto L7;
            long r100 = IntOffset.Companion.m7687getZeronOccac();
        L9:
            if ((r215 & 4) == 0) goto L11;
            int r101 = r111.getWidth();
            long r102 = ((long) r101) << 32;
            long r103 = IntSize.m7714constructorimpl((((long) r111.getHeight()) & BodyPartID.bodyIdMax) | r102);
        L13:
            if ((r215 & 8) == 0) goto L15;
            long r104 = IntOffset.Companion.m7687getZeronOccac();
        L17:
            if ((r215 & 16) == 0) goto L19;
            long r105 = r103;
        L21:
            if ((r215 & 32) == 0) goto L23;
            float r106 = 1.0f;
        L25:
            if ((r215 & 64) == 0) goto L27;
            DrawStyle r115 = Fill.INSTANCE;
        L29:
            if ((r215 & 128) == 0) goto L31;
            ColorFilter r116 = null;
        L33:
            if ((r215 & 256) == 0) goto L35;
            int r107 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L36:
            r110.mo5306drawImage9jGpkUE(r111, r100, r103, r104, r105, r106, r115, r116, r107);
            return;
        L35:
            r107 = r214;
            goto L36
        L31:
            r116 = r213;
            goto L33
        L27:
            r115 = r212;
            goto L29
        L23:
            r106 = r211;
            goto L25
        L19:
            r105 = r210;
            goto L21
        L15:
            r104 = r114;
            goto L17
        L11:
            r103 = r113;
            goto L13
        L7:
            r100 = r112;
            goto L9
        L39:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }

        /* JADX INFO: renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
        public static /* synthetic */ void m5398drawLine1RTmtNc$default(DrawScope r110, Brush r111, long r112, long r113, float r210, int r211, PathEffect r212, float r213, ColorFilter r214, int r215, int r216, Object r217) {
            if (r217 != null) goto L31;
            if ((r216 & 8) == 0) goto L7;
            float r100 = 0.0f;
        L9:
            if ((r216 & 16) == 0) goto L11;
            int r101 = Stroke.Companion.m5481getDefaultCapKaPHkGw();
        L13:
            if ((r216 & 32) == 0) goto L15;
            PathEffect r114 = null;
        L17:
            if ((r216 & 64) == 0) goto L19;
            float r115 = 1.0f;
        L21:
            if ((r216 & 128) == 0) goto L23;
            ColorFilter r116 = null;
        L25:
            if ((r216 & 256) == 0) goto L27;
            int r117 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5309drawLine1RTmtNc(r111, r112, r113, r100, r101, r114, r115, r116, r117);
            return;
        L27:
            r117 = r215;
            goto L28
        L23:
            r116 = r214;
            goto L25
        L19:
            r115 = r213;
            goto L21
        L15:
            r114 = r212;
            goto L17
        L11:
            r101 = r211;
            goto L13
        L7:
            r100 = r210;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }

        /* JADX INFO: renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
        public static /* synthetic */ void m5399drawLineNGM6Ib0$default(DrawScope r110, long r111, long r112, long r210, float r211, int r212, PathEffect r213, float r214, ColorFilter r215, int r216, int r217, Object r218) {
            if (r218 != null) goto L31;
            if ((r217 & 8) == 0) goto L7;
            float r100 = 0.0f;
        L9:
            if ((r217 & 16) == 0) goto L11;
            int r113 = Stroke.Companion.m5481getDefaultCapKaPHkGw();
        L13:
            if ((r217 & 32) == 0) goto L15;
            PathEffect r114 = null;
        L17:
            if ((r217 & 64) == 0) goto L19;
            float r115 = 1.0f;
        L21:
            if ((r217 & 128) == 0) goto L23;
            ColorFilter r116 = null;
        L25:
            if ((r217 & 256) == 0) goto L27;
            int r117 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5310drawLineNGM6Ib0(r111, r112, r210, r100, r113, r114, r115, r116, r117);
            return;
        L27:
            r117 = r216;
            goto L28
        L23:
            r116 = r215;
            goto L25
        L19:
            r115 = r214;
            goto L21
        L15:
            r114 = r213;
            goto L17
        L11:
            r113 = r212;
            goto L13
        L7:
            r100 = r211;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }

        /* JADX INFO: renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
        public static /* synthetic */ void m5404drawPointsF8ZwMP8$default(DrawScope r110, List r111, int r112, long r113, float r114, int r115, PathEffect r210, float r211, ColorFilter r212, int r213, int r214, Object r215) {
            if (r215 != null) goto L31;
            if ((r214 & 8) == 0) goto L7;
            float r100 = 0.0f;
        L9:
            if ((r214 & 16) == 0) goto L11;
            int r101 = StrokeCap.Companion.m5206getButtKaPHkGw();
        L13:
            if ((r214 & 32) == 0) goto L15;
            PathEffect r102 = null;
        L17:
            if ((r214 & 64) == 0) goto L19;
            float r116 = 1.0f;
        L21:
            if ((r214 & 128) == 0) goto L23;
            ColorFilter r117 = null;
        L25:
            if ((r214 & 256) == 0) goto L27;
            int r118 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5315drawPointsF8ZwMP8(r111, r112, r113, r100, r101, r102, r116, r117, r118);
            return;
        L27:
            r118 = r213;
            goto L28
        L23:
            r117 = r212;
            goto L25
        L19:
            r116 = r211;
            goto L21
        L15:
            r102 = r210;
            goto L17
        L11:
            r101 = r115;
            goto L13
        L7:
            r100 = r114;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }

        /* JADX INFO: renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
        public static /* synthetic */ void m5405drawPointsGsft0Ws$default(DrawScope r110, List r111, int r112, Brush r113, float r114, int r115, PathEffect r116, float r117, ColorFilter r210, int r211, int r212, Object r213) {
            if (r213 != null) goto L31;
            if ((r212 & 8) == 0) goto L7;
            float r100 = 0.0f;
        L9:
            if ((r212 & 16) == 0) goto L11;
            int r101 = StrokeCap.Companion.m5206getButtKaPHkGw();
        L13:
            if ((r212 & 32) == 0) goto L15;
            PathEffect r102 = null;
        L17:
            if ((r212 & 64) == 0) goto L19;
            float r103 = 1.0f;
        L21:
            if ((r212 & 128) == 0) goto L23;
            ColorFilter r118 = null;
        L25:
            if ((r212 & 256) == 0) goto L27;
            int r119 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5316drawPointsGsft0Ws(r111, r112, r113, r100, r101, r102, r103, r118, r119);
            return;
        L27:
            r119 = r211;
            goto L28
        L23:
            r118 = r210;
            goto L25
        L19:
            r103 = r117;
            goto L21
        L15:
            r102 = r116;
            goto L17
        L11:
            r101 = r115;
            goto L13
        L7:
            r100 = r114;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }

        /* JADX INFO: renamed from: drawArc-illE91I$default, reason: not valid java name */
        public static /* synthetic */ void m5391drawArcillE91I$default(DrawScope r110, Brush r111, float r112, float r113, boolean r210, long r211, long r212, float r213, DrawStyle r214, ColorFilter r215, int r216, int r217, Object r310) {
            if (r310 != null) goto L31;
            if ((r217 & 16) == 0) goto L7;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L9:
            if ((r217 & 32) == 0) goto L11;
            long r114 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L13:
            if ((r217 & 64) == 0) goto L15;
            float r115 = 1.0f;
        L17:
            if ((r217 & 128) == 0) goto L19;
            DrawStyle r116 = Fill.INSTANCE;
        L21:
            if ((r217 & 256) == 0) goto L23;
            ColorFilter r117 = null;
        L25:
            if ((r217 & 512) == 0) goto L27;
            int r118 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5302drawArcillE91I(r111, r112, r113, r210, r100, r114, r115, r116, r117, r118);
            return;
        L27:
            r118 = r216;
            goto L28
        L23:
            r117 = r215;
            goto L25
        L19:
            r116 = r214;
            goto L21
        L15:
            r115 = r213;
            goto L17
        L11:
            r114 = r212;
            goto L13
        L7:
            r100 = r211;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }

        /* JADX INFO: renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
        public static /* synthetic */ void m5392drawArcyD3GUKo$default(DrawScope r110, long r111, float r210, float r211, boolean r212, long r213, long r214, float r215, DrawStyle r216, ColorFilter r217, int r310, int r311, Object r312) {
            if (r312 != null) goto L31;
            if ((r311 & 16) == 0) goto L7;
            long r100 = Offset.Companion.m4598getZeroF1C5BW0();
        L9:
            if ((r311 & 32) == 0) goto L11;
            long r112 = m5374$private$offsetSizePENXr5M(r110, r110.mo5322getSizeNHjbRc(), r100);
        L13:
            if ((r311 & 64) == 0) goto L15;
            float r113 = 1.0f;
        L17:
            if ((r311 & 128) == 0) goto L19;
            DrawStyle r114 = Fill.INSTANCE;
        L21:
            if ((r311 & 256) == 0) goto L23;
            ColorFilter r115 = null;
        L25:
            if ((r311 & 512) == 0) goto L27;
            int r116 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L28:
            r110.mo5303drawArcyD3GUKo(r111, r210, r211, r212, r100, r112, r113, r114, r115, r116);
            return;
        L27:
            r116 = r310;
            goto L28
        L23:
            r115 = r217;
            goto L25
        L19:
            r114 = r216;
            goto L21
        L15:
            r113 = r215;
            goto L17
        L11:
            r112 = r214;
            goto L13
        L7:
            r100 = r213;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }

        /* JADX INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
        public static /* synthetic */ void m5396drawImageAZ2fEMs$default(DrawScope r110, ImageBitmap r111, long r112, long r113, long r114, long r210, float r211, DrawStyle r212, ColorFilter r213, int r214, int r215, int r216, Object r217) {
            if (r217 != null) goto L43;
            if ((r216 & 2) == 0) goto L7;
            long r100 = IntOffset.Companion.m7687getZeronOccac();
        L9:
            if ((r216 & 4) == 0) goto L11;
            int r101 = r111.getWidth();
            long r102 = ((long) r101) << 32;
            long r103 = IntSize.m7714constructorimpl((((long) r111.getHeight()) & BodyPartID.bodyIdMax) | r102);
        L13:
            if ((r216 & 8) == 0) goto L15;
            long r104 = IntOffset.Companion.m7687getZeronOccac();
        L17:
            if ((r216 & 16) == 0) goto L19;
            long r105 = r103;
        L21:
            if ((r216 & 32) == 0) goto L23;
            float r106 = 1.0f;
        L25:
            if ((r216 & 64) == 0) goto L27;
            DrawStyle r115 = Fill.INSTANCE;
        L29:
            if ((r216 & 128) == 0) goto L31;
            ColorFilter r116 = null;
        L33:
            if ((r216 & 256) == 0) goto L35;
            int r117 = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        L37:
            if ((r216 & 512) == 0) goto L39;
            int r107 = DrawScope.Companion.m5412getDefaultFilterQualityfv9h1I();
        L40:
            r110.mo5307drawImageAZ2fEMs(r111, r100, r103, r104, r105, r106, r115, r116, r117, r107);
            return;
        L39:
            r107 = r215;
            goto L40
        L35:
            r117 = r214;
            goto L37
        L31:
            r116 = r213;
            goto L33
        L27:
            r115 = r212;
            goto L29
        L23:
            r106 = r211;
            goto L25
        L19:
            r105 = r210;
            goto L21
        L15:
            r104 = r114;
            goto L17
        L11:
            r103 = r113;
            goto L13
        L7:
            r100 = r112;
            goto L9
        L43:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "<init>", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final int DefaultBlendMode = 0;
        private static final int DefaultFilterQuality = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            DefaultBlendMode = BlendMode.Companion.m4768getSrcOver0nO6VwU();
            DefaultFilterQuality = FilterQuality.Companion.m4927getLowfv9h1I();
        }

        /* JADX INFO: renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m5411getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* JADX INFO: renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m5412getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m5433getCenterF1C5BW0(DrawScope r100) {
            return CC.m5376access$getCenterF1C5BW0$jd(r100);
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m5434getSizeNHjbRc(DrawScope r100) {
            return CC.m5377access$getSizeNHjbRc$jd(r100);
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5437roundToPxR2X_6o(DrawScope r100, long r101) {
            return CC.m5379access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5438roundToPx0680j_4(DrawScope r100, float r101) {
            return CC.m5380access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5439toDpGaN1DYA(DrawScope r100, long r101) {
            return CC.m5381access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5440toDpu2uoSUM(DrawScope r100, float r101) {
            return CC.m5382access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5442toDpSizekrfVVM(DrawScope r100, long r101) {
            return CC.m5384access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5443toPxR2X_6o(DrawScope r100, long r101) {
            return CC.m5385access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5444toPx0680j_4(DrawScope r100, float r101) {
            return CC.m5386access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(DrawScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5445toSizeXkaWNTQ(DrawScope r100, long r101) {
            return CC.m5387access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5446toSp0xMU5do(DrawScope r100, float r101) {
            return CC.m5388access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5447toSpkPz2Gy4(DrawScope r100, float r101) {
            return CC.m5389access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5441toDpu2uoSUM(DrawScope r100, int r101) {
            return CC.m5383access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5448toSpkPz2Gy4(DrawScope r100, int r101) {
            return CC.m5390access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m5435recordJVtK1S4(DrawScope r100, GraphicsLayer r101, long r102, Function1<? super DrawScope, Unit> r103) {
            CC.m5378access$recordJVtK1S4$jd(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: record-JVtK1S4$default, reason: not valid java name */
        public static /* synthetic */ void m5436recordJVtK1S4$default(DrawScope r100, GraphicsLayer r101, long r102, Function1 r103, int r104, Object r105) {
            CC.m5410recordJVtK1S4$default(r100, r101, r102, r103, r104, r105);
        }

        /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
        public static /* synthetic */ void m5420drawImagegbVJVH8$default(DrawScope r100, ImageBitmap r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106, int r107, Object r108) {
            CC.m5397drawImagegbVJVH8$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }

        /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
        public static /* synthetic */ void m5425drawPathGBMwjPU$default(DrawScope r100, Path r101, Brush r102, float r103, DrawStyle r104, ColorFilter r105, int r106, int r107, Object r108) {
            CC.m5402drawPathGBMwjPU$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }

        /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
        public static /* synthetic */ void m5426drawPathLG529CI$default(DrawScope r100, Path r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106, int r107, Object r108) {
            CC.m5403drawPathLG529CI$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }

        /* JADX INFO: renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
        public static /* synthetic */ void m5415drawCircleV9BoPsw$default(DrawScope r100, Brush r101, float r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r107, int r108, Object r110) {
            CC.m5393drawCircleV9BoPsw$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
        }

        /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
        public static /* synthetic */ void m5416drawCircleVaOC9Bg$default(DrawScope r100, long r101, float r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r107, int r110, Object r111) {
            CC.m5394drawCircleVaOC9Bg$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
        }

        /* JADX INFO: renamed from: drawOval-AsUm42w$default, reason: not valid java name */
        public static /* synthetic */ void m5423drawOvalAsUm42w$default(DrawScope r100, Brush r101, long r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r107, int r110, Object r111) {
            CC.m5400drawOvalAsUm42w$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
        }

        /* JADX INFO: renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
        public static /* synthetic */ void m5424drawOvalnJ9OG0$default(DrawScope r100, long r101, long r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r110, int r111, Object r112) {
            CC.m5401drawOvalnJ9OG0$default(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112);
        }

        /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
        public static /* synthetic */ void m5429drawRectAsUm42w$default(DrawScope r100, Brush r101, long r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r107, int r110, Object r111) {
            CC.m5406drawRectAsUm42w$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
        }

        /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
        public static /* synthetic */ void m5430drawRectnJ9OG0$default(DrawScope r100, long r101, long r102, long r103, float r104, DrawStyle r105, ColorFilter r106, int r110, int r111, Object r112) {
            CC.m5407drawRectnJ9OG0$default(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112);
        }

        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m5418drawImageAZ2fEMs(DrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114) {
            CC.m5375access$drawImageAZ2fEMs$jd(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
        }

        /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
        public static /* synthetic */ void m5431drawRoundRectZuiqVtQ$default(DrawScope r100, Brush r101, long r102, long r103, long r104, float r105, DrawStyle r106, ColorFilter r110, int r111, int r112, Object r113) {
            CC.m5408drawRoundRectZuiqVtQ$default(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113);
        }

        /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
        public static /* synthetic */ void m5432drawRoundRectuAw5IA$default(DrawScope r100, long r101, long r102, long r103, long r104, DrawStyle r105, float r110, ColorFilter r111, int r112, int r113, Object r114) {
            CC.m5409drawRoundRectuAw5IA$default(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
        }

        /* JADX INFO: renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
        public static /* synthetic */ void m5417drawImage9jGpkUE$default(DrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114, Object r115) {
            CC.m5395drawImage9jGpkUE$default(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115);
        }

        /* JADX INFO: renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
        public static /* synthetic */ void m5421drawLine1RTmtNc$default(DrawScope r100, Brush r101, long r102, long r103, float r104, int r105, PathEffect r106, float r107, ColorFilter r110, int r111, int r112, Object r113) {
            CC.m5398drawLine1RTmtNc$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113);
        }

        /* JADX INFO: renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
        public static /* synthetic */ void m5422drawLineNGM6Ib0$default(DrawScope r100, long r101, long r102, long r103, float r104, int r105, PathEffect r106, float r110, ColorFilter r111, int r112, int r113, Object r114) {
            CC.m5399drawLineNGM6Ib0$default(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114);
        }

        /* JADX INFO: renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
        public static /* synthetic */ void m5427drawPointsF8ZwMP8$default(DrawScope r100, List r101, int r102, long r103, float r104, int r105, PathEffect r106, float r107, ColorFilter r108, int r110, int r111, Object r112) {
            CC.m5404drawPointsF8ZwMP8$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
        }

        /* JADX INFO: renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
        public static /* synthetic */ void m5428drawPointsGsft0Ws$default(DrawScope r100, List r101, int r102, Brush r103, float r104, int r105, PathEffect r106, float r107, ColorFilter r108, int r109, int r110, Object r111) {
            CC.m5405drawPointsGsft0Ws$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111);
        }

        /* JADX INFO: renamed from: drawArc-illE91I$default, reason: not valid java name */
        public static /* synthetic */ void m5413drawArcillE91I$default(DrawScope r100, Brush r101, float r102, float r103, boolean r104, long r105, long r106, float r107, DrawStyle r110, ColorFilter r111, int r112, int r113, Object r114) {
            CC.m5391drawArcillE91I$default(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114);
        }

        /* JADX INFO: renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
        public static /* synthetic */ void m5414drawArcyD3GUKo$default(DrawScope r100, long r101, float r102, float r103, boolean r104, long r105, long r106, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114, Object r115) {
            CC.m5392drawArcyD3GUKo$default(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115);
        }

        /* JADX INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
        public static /* synthetic */ void m5419drawImageAZ2fEMs$default(DrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114, int r115, Object r116) {
            CC.m5396drawImageAZ2fEMs$default(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: drawArc-illE91I */
    void mo5302drawArcillE91I(Brush r100, float r101, float r102, boolean r103, long r104, long r105, float r106, DrawStyle r110, ColorFilter r111, int r112);

    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo5303drawArcyD3GUKo(long r100, float r101, float r102, boolean r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113);

    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    void mo5304drawCircleV9BoPsw(Brush r100, float r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo5305drawCircleVaOC9Bg(long r100, float r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo5306drawImage9jGpkUE(ImageBitmap r100, long r101, long r102, long r103, long r104, float r110, DrawStyle r111, ColorFilter r112, int r113);

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    void mo5307drawImageAZ2fEMs(ImageBitmap r100, long r101, long r102, long r103, long r104, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114);

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo5308drawImagegbVJVH8(ImageBitmap r100, long r101, float r102, DrawStyle r103, ColorFilter r104, int r105);

    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    void mo5309drawLine1RTmtNc(Brush r100, long r101, long r102, float r103, int r104, PathEffect r105, float r106, ColorFilter r110, int r111);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo5310drawLineNGM6Ib0(long r100, long r101, long r102, float r103, int r104, PathEffect r105, float r110, ColorFilter r111, int r112);

    /* JADX INFO: renamed from: drawOval-AsUm42w */
    void mo5311drawOvalAsUm42w(Brush r100, long r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106);

    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    void mo5312drawOvalnJ9OG0(long r100, long r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r110);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo5313drawPathGBMwjPU(Path r100, Brush r101, float r102, DrawStyle r103, ColorFilter r104, int r105);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo5314drawPathLG529CI(Path r100, long r101, float r102, DrawStyle r103, ColorFilter r104, int r105);

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    void mo5315drawPointsF8ZwMP8(List<Offset> r100, int r101, long r102, float r103, int r104, PathEffect r105, float r106, ColorFilter r107, int r110);

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    void mo5316drawPointsGsft0Ws(List<Offset> r100, int r101, Brush r102, float r103, int r104, PathEffect r105, float r106, ColorFilter r107, int r108);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo5317drawRectAsUm42w(Brush r100, long r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r106);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo5318drawRectnJ9OG0(long r100, long r101, long r102, float r103, DrawStyle r104, ColorFilter r105, int r110);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo5319drawRoundRectZuiqVtQ(Brush r100, long r101, long r102, long r103, float r104, DrawStyle r105, ColorFilter r110, int r111);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo5320drawRoundRectuAw5IA(long r100, long r101, long r102, long r103, DrawStyle r104, float r110, ColorFilter r111, int r112);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo5321getCenterF1C5BW0();

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo5322getSizeNHjbRc();

    /* JADX INFO: renamed from: record-JVtK1S4 */
    void mo5323recordJVtK1S4(GraphicsLayer r100, long r101, Function1<? super DrawScope, Unit> r102);
}
