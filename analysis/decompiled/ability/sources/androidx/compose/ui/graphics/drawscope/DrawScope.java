package androidx.compose.ui.graphics.drawscope;

import C7.c;
import C7.r;
import S7.k;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import java.util.List;
import kotlin.Metadata;

@DrawScopeMarker
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 t2\u00020\u0001:\u0001tJ\u001b\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006Jg\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019Jg\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001d\u0010\u001eJU\u0010%\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b#\u0010$JU\u0010%\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b&\u0010'JK\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b*\u0010+Ji\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b3\u00104Js\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J_\u0010=\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u0002092\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b;\u0010<J_\u0010=\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b>\u0010?JU\u0010D\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\f2\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bB\u0010CJU\u0010D\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010@\u001a\u00020\f2\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bE\u0010FJU\u0010H\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bG\u0010$JU\u0010H\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bI\u0010'Jm\u0010P\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010M\u001a\u00020L2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bN\u0010OJm\u0010P\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010M\u001a\u00020L2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bQ\u0010RJI\u0010W\u001a\u00020\u00172\u0006\u0010T\u001a\u00020S2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bU\u0010VJI\u0010W\u001a\u00020\u00172\u0006\u0010T\u001a\u00020S2\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\bX\u0010YJm\u0010`\u001a\u00020\u00172\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030Z2\u0006\u0010]\u001a\u00020\\2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b^\u0010_Jm\u0010`\u001a\u00020\u00172\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030Z2\u0006\u0010]\u001a\u00020\\2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\ba\u0010bJ1\u0010h\u001a\u00020\u0017*\u00020c2\b\b\u0002\u0010 \u001a\u00020/2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170dH\u0016¢\u0006\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8&X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0014\u0010A\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010 \u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010nR\u0014\u0010s\u001a\u00020p8&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006uÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "offsetSize-PENXr5M", "(JJ)J", "offsetSize", "Landroidx/compose/ui/graphics/Brush;", "brush", "start", "end", "", "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "LC7/r;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "size", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-AsUm42w", "drawOval", "drawOval-n-J9OG0", CircularAnimatedDrawable.START_ANGLE_PROPERTY, CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, "", "useCenter", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "", "points", "Landroidx/compose/ui/graphics/PointMode;", "pointMode", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Lkotlin/Function1;", "block", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLS7/k;)V", "record", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "getCenter-F1C5BW0", "()J", "getSize-NH-jbRc", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawScope extends Density {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", AppAgent.CONSTRUCT, "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.INSTANCE.m4239getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m4709getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m4710getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m4716drawImageAZ2fEMs(DrawScope drawScope, ImageBitmap imageBitmap, long j5, long j6, long j10, long j11, @FloatRange(from = 0.0d, to = 1.0d) float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6) {
            DrawScope.super.mo4609drawImageAZ2fEMs(imageBitmap, j5, j6, j10, j11, f, drawStyle, colorFilter, i, i6);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m4731getCenterF1C5BW0(DrawScope drawScope) {
            return DrawScope.super.mo4706getCenterF1C5BW0();
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4732getSizeNHjbRc(DrawScope drawScope) {
            return DrawScope.super.mo4707getSizeNHjbRc();
        }

        @Deprecated
        /* renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m4733recordJVtK1S4(DrawScope drawScope, GraphicsLayer graphicsLayer, long j5, k kVar) {
            DrawScope.super.mo4708recordJVtK1S4(graphicsLayer, j5, kVar);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4735roundToPxR2X_6o(DrawScope drawScope, long j5) {
            return DrawScope.super.mo374roundToPxR2X_6o(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4736roundToPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo375roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4737toDpGaN1DYA(DrawScope drawScope, long j5) {
            return DrawScope.super.mo376toDpGaN1DYA(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4738toDpu2uoSUM(DrawScope drawScope, float f) {
            return DrawScope.super.mo377toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4740toDpSizekrfVVM(DrawScope drawScope, long j5) {
            return DrawScope.super.mo379toDpSizekrfVVM(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4741toPxR2X_6o(DrawScope drawScope, long j5) {
            return DrawScope.super.mo380toPxR2X_6o(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4742toPx0680j_4(DrawScope drawScope, float f) {
            return DrawScope.super.mo381toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(DrawScope drawScope, DpRect dpRect) {
            return DrawScope.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4743toSizeXkaWNTQ(DrawScope drawScope, long j5) {
            return DrawScope.super.mo382toSizeXkaWNTQ(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4744toSp0xMU5do(DrawScope drawScope, float f) {
            return DrawScope.super.mo383toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4745toSpkPz2Gy4(DrawScope drawScope, float f) {
            return DrawScope.super.mo384toSpkPz2Gy4(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4739toDpu2uoSUM(DrawScope drawScope, int i) {
            return DrawScope.super.mo378toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4746toSpkPz2Gy4(DrawScope drawScope, int i) {
            return DrawScope.super.mo385toSpkPz2Gy4(i);
        }
    }

    /* renamed from: drawArc-illE91I$default, reason: not valid java name */
    static /* synthetic */ void m4685drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f7, boolean z10, long j5, long j6, float f9, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        DrawScope drawScope2;
        long jM4704offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 16) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j5;
        if ((i6 & 32) != 0) {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = drawScope2.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = j6;
        }
        drawScope2.mo4604drawArcillE91I(brush, f, f7, z10, jM3911getZeroF1C5BW0, jM4704offsetSizePENXr5M, (i6 & 64) != 0 ? 1.0f : f9, (i6 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 256) != 0 ? null : colorFilter, (i6 & 512) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
    static /* synthetic */ void m4686drawArcyD3GUKo$default(DrawScope drawScope, long j5, float f, float f7, boolean z10, long j6, long j10, float f9, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        DrawScope drawScope2;
        long jM4704offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 16) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j6;
        if ((i6 & 32) != 0) {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = drawScope2.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = j10;
        }
        drawScope2.mo4605drawArcyD3GUKo(j5, f, f7, z10, jM3911getZeroF1C5BW0, jM4704offsetSizePENXr5M, (i6 & 64) != 0 ? 1.0f : f9, (i6 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 256) != 0 ? null : colorFilter, (i6 & 512) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
    static /* synthetic */ void m4687drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j5, float f7, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo4606drawCircleV9BoPsw(brush, (i6 & 2) != 0 ? Size.m3963getMinDimensionimpl(drawScope.mo4707getSizeNHjbRc()) / 2.0f : f, (i6 & 4) != 0 ? drawScope.mo4706getCenterF1C5BW0() : j5, (i6 & 8) != 0 ? 1.0f : f7, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m4688drawCircleVaOC9Bg$default(DrawScope drawScope, long j5, float f, long j6, float f7, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        if ((i6 & 2) != 0) {
            f = Size.m3963getMinDimensionimpl(drawScope.mo4707getSizeNHjbRc()) / 2.0f;
        }
        drawScope.mo4607drawCircleVaOC9Bg(j5, f, (i6 & 4) != 0 ? drawScope.mo4706getCenterF1C5BW0() : j6, (i6 & 8) != 0 ? 1.0f : f7, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
    static /* synthetic */ void m4689drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j5, long j6, long j10, long j11, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM6983getZeronOccac = (i6 & 2) != 0 ? IntOffset.INSTANCE.m6983getZeronOccac() : j5;
        long jM7010constructorimpl = (i6 & 4) != 0 ? IntSize.m7010constructorimpl((imageBitmap.getHeight() & 4294967295L) | (imageBitmap.getWidth() << 32)) : j6;
        drawScope.mo4608drawImage9jGpkUE(imageBitmap, jM6983getZeronOccac, jM7010constructorimpl, (i6 & 8) != 0 ? IntOffset.INSTANCE.m6983getZeronOccac() : j10, (i6 & 16) != 0 ? jM7010constructorimpl : j11, (i6 & 32) != 0 ? 1.0f : f, (i6 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 128) != 0 ? null : colorFilter, (i6 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static /* synthetic */ void m4690drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j5, long j6, long j10, long j11, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM6983getZeronOccac = (i10 & 2) != 0 ? IntOffset.INSTANCE.m6983getZeronOccac() : j5;
        long jM7010constructorimpl = (i10 & 4) != 0 ? IntSize.m7010constructorimpl((imageBitmap.getHeight() & 4294967295L) | (imageBitmap.getWidth() << 32)) : j6;
        drawScope.mo4609drawImageAZ2fEMs(imageBitmap, jM6983getZeronOccac, jM7010constructorimpl, (i10 & 8) != 0 ? IntOffset.INSTANCE.m6983getZeronOccac() : j10, (i10 & 16) != 0 ? jM7010constructorimpl : j11, (i10 & 32) != 0 ? 1.0f : f, (i10 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i10 & 128) != 0 ? null : colorFilter, (i10 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i, (i10 & 512) != 0 ? INSTANCE.m4710getDefaultFilterQualityfv9h1I() : i6);
    }

    /* renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static /* synthetic */ void m4691drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j5, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo4610drawImagegbVJVH8(imageBitmap, (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j5, (i6 & 4) != 0 ? 1.0f : f, (i6 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 16) != 0 ? null : colorFilter, (i6 & 32) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m4692drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j5, long j6, float f, int i, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo4611drawLine1RTmtNc(brush, j5, j6, (i10 & 8) != 0 ? 0.0f : f, (i10 & 16) != 0 ? Stroke.INSTANCE.m4778getDefaultCapKaPHkGw() : i, (i10 & 32) != 0 ? null : pathEffect, (i10 & 64) != 0 ? 1.0f : f7, (i10 & 128) != 0 ? null : colorFilter, (i10 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i6);
    }

    /* renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m4693drawLineNGM6Ib0$default(DrawScope drawScope, long j5, long j6, long j10, float f, int i, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo4612drawLineNGM6Ib0(j5, j6, j10, (i10 & 8) != 0 ? 0.0f : f, (i10 & 16) != 0 ? Stroke.INSTANCE.m4778getDefaultCapKaPHkGw() : i, (i10 & 32) != 0 ? null : pathEffect, (i10 & 64) != 0 ? 1.0f : f7, (i10 & 128) != 0 ? null : colorFilter, (i10 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i6);
    }

    /* renamed from: drawOval-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m4694drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j5, long j6, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j5;
        drawScope.mo4613drawOvalAsUm42w(brush, jM3911getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0) : j6, (i6 & 8) != 0 ? 1.0f : f, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m4695drawOvalnJ9OG0$default(DrawScope drawScope, long j5, long j6, long j10, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j6;
        drawScope.mo4614drawOvalnJ9OG0(j5, jM3911getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0) : j10, (i6 & 8) != 0 ? 1.0f : f, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m4696drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i6 & 4) != 0) {
            f = 1.0f;
        }
        float f7 = f;
        if ((i6 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i6 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i6 & 32) != 0) {
            i = INSTANCE.m4709getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo4615drawPathGBMwjPU(path, brush, f7, drawStyle2, colorFilter2, i);
    }

    /* renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m4697drawPathLG529CI$default(DrawScope drawScope, Path path, long j5, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        if ((i6 & 4) != 0) {
            f = 1.0f;
        }
        float f7 = f;
        if ((i6 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i6 & 16) != 0) {
            colorFilter = null;
        }
        drawScope.mo4616drawPathLG529CI(path, j5, f7, drawStyle2, colorFilter, (i6 & 32) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
    static /* synthetic */ void m4698drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j5, float f, int i6, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo4617drawPointsF8ZwMP8(list, i, j5, (i11 & 8) != 0 ? 0.0f : f, (i11 & 16) != 0 ? StrokeCap.INSTANCE.m4508getButtKaPHkGw() : i6, (i11 & 32) != 0 ? null : pathEffect, (i11 & 64) != 0 ? 1.0f : f7, (i11 & 128) != 0 ? null : colorFilter, (i11 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i10);
    }

    /* renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
    static /* synthetic */ void m4699drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i6, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo4618drawPointsGsft0Ws(list, i, brush, (i11 & 8) != 0 ? 0.0f : f, (i11 & 16) != 0 ? StrokeCap.INSTANCE.m4508getButtKaPHkGw() : i6, (i11 & 32) != 0 ? null : pathEffect, (i11 & 64) != 0 ? 1.0f : f7, (i11 & 128) != 0 ? null : colorFilter, (i11 & 256) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i10);
    }

    /* renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m4700drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j5, long j6, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j5;
        drawScope.mo4619drawRectAsUm42w(brush, jM3911getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0) : j6, (i6 & 8) != 0 ? 1.0f : f, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m4701drawRectnJ9OG0$default(DrawScope drawScope, long j5, long j6, long j10, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j6;
        drawScope.mo4620drawRectnJ9OG0(j5, jM3911getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0) : j10, (i6 & 8) != 0 ? 1.0f : f, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static /* synthetic */ void m4702drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j5, long j6, long j10, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j5;
        drawScope.mo4621drawRoundRectZuiqVtQ(brush, jM3911getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0) : j6, (i6 & 8) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j10, (i6 & 16) != 0 ? 1.0f : f, (i6 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 64) != 0 ? null : colorFilter, (i6 & 128) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static /* synthetic */ void m4703drawRoundRectuAw5IA$default(DrawScope drawScope, long j5, long j6, long j10, long j11, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i6, Object obj) {
        DrawScope drawScope2;
        long jM4704offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM3911getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j6;
        if ((i6 & 4) != 0) {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = drawScope2.m4704offsetSizePENXr5M(drawScope.mo4707getSizeNHjbRc(), jM3911getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM4704offsetSizePENXr5M = j10;
        }
        drawScope2.mo4622drawRoundRectuAw5IA(j5, jM3911getZeroF1C5BW0, jM4704offsetSizePENXr5M, (i6 & 8) != 0 ? CornerRadius.INSTANCE.m3867getZerokKHJgLs() : j11, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? 1.0f : f, (i6 & 64) != 0 ? null : colorFilter, (i6 & 128) != 0 ? INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private default long m4704offsetSizePENXr5M(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - Float.intBitsToFloat((int) (j6 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: record-JVtK1S4$default, reason: not valid java name */
    static /* synthetic */ void m4705recordJVtK1S4$default(DrawScope drawScope, GraphicsLayer graphicsLayer, long j5, k kVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }
        if ((i & 1) != 0) {
            j5 = IntSizeKt.m7026toIntSizeuvyYCjk(drawScope.mo4707getSizeNHjbRc());
        }
        drawScope.mo4708recordJVtK1S4(graphicsLayer, j5, kVar);
    }

    /* renamed from: drawArc-illE91I */
    void mo4604drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawArc-yD3GUKo */
    void mo4605drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawCircle-V9BoPsw */
    void mo4606drawCircleV9BoPsw(Brush brush, float radius, long center, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawCircle-VaOC9Bg */
    void mo4607drawCircleVaOC9Bg(long color, float radius, long center, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    @c
    /* renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo4608drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawImage-AZ2fEMs */
    default void mo4609drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        m4690drawImageAZ2fEMs$default(this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, null);
    }

    /* renamed from: drawImage-gbVJVH8 */
    void mo4610drawImagegbVJVH8(ImageBitmap image, long topLeft, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawLine-1RTmtNc */
    void mo4611drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo4612drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawOval-AsUm42w */
    void mo4613drawOvalAsUm42w(Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawOval-n-J9OG0 */
    void mo4614drawOvalnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPath-GBMwjPU */
    void mo4615drawPathGBMwjPU(Path path, Brush brush, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPath-LG529CI */
    void mo4616drawPathLG529CI(Path path, long color, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPoints-F8ZwMP8 */
    void mo4617drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPoints-Gsft0Ws */
    void mo4618drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRect-AsUm42w */
    void mo4619drawRectAsUm42w(Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRect-n-J9OG0 */
    void mo4620drawRectnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo4621drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo4622drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo4706getCenterF1C5BW0() {
        return SizeKt.m3974getCenteruvyYCjk(getDrawContext().mo4628getSizeNHjbRc());
    }

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo4707getSizeNHjbRc() {
        return getDrawContext().mo4628getSizeNHjbRc();
    }

    /* renamed from: record-JVtK1S4, reason: not valid java name */
    default void mo4708recordJVtK1S4(GraphicsLayer graphicsLayer, long j5, final k kVar) {
        graphicsLayer.m4801recordmLhObY(this, getLayoutDirection(), j5, new k() { // from class: androidx.compose.ui.graphics.drawscope.DrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return r.f317a;
            }

            public final void invoke(DrawScope drawScope) {
                DrawScope drawScope2 = this.this$0;
                Density density = drawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                long jMo4628getSizeNHjbRc = drawScope.getDrawContext().mo4628getSizeNHjbRc();
                GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                k kVar2 = kVar;
                Density density2 = drawScope2.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
                Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
                long jMo4628getSizeNHjbRc2 = drawScope2.getDrawContext().mo4628getSizeNHjbRc();
                GraphicsLayer graphicsLayer3 = drawScope2.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = drawScope2.getDrawContext();
                drawContext.setDensity(density);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(canvas);
                drawContext.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                drawContext.setGraphicsLayer(graphicsLayer2);
                canvas.save();
                try {
                    kVar2.invoke(drawScope2);
                } finally {
                    canvas.restore();
                    DrawContext drawContext2 = drawScope2.getDrawContext();
                    drawContext2.setDensity(density2);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas2);
                    drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc2);
                    drawContext2.setGraphicsLayer(graphicsLayer3);
                }
            }
        });
    }
}
