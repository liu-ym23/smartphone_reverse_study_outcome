package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0093\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J]\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b/\u00100JK\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b7\u00108JK\u00101\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b9\u0010:JC\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=2\u0006\u00102\u001a\u00020\u001f2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b>\u0010?J[\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020C2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0017¢\u0006\u0004\bF\u0010GJc\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020C2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJS\u0010L\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\u0006\u0010M\u001a\u00020N2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bO\u0010PJS\u0010L\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\u0006\u0010M\u001a\u00020N2\u0006\u00105\u001a\u0002062\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bQ\u0010RJK\u0010S\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u001f2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bV\u0010WJK\u0010S\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u001f2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bX\u0010YJK\u0010Z\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b[\u00108JK\u0010Z\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\b\\\u0010:Jc\u0010]\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020a2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bb\u0010cJc\u0010]\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020a2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bd\u0010eJC\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020h2\u0006\u0010-\u001a\u00020.2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bi\u0010jJC\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020h2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010&\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bk\u0010lJc\u0010m\u001a\u00020\u001b2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001f0o2\u0006\u0010p\u001a\u00020q2\u0006\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\br\u0010sJc\u0010m\u001a\u00020\u001b2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001f0o2\u0006\u0010p\u001a\u00020q2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0004\bt\u0010uJI\u0010v\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020w2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010x\u001a\u00020y2\u0006\u00103\u001a\u0002042\u0017\u0010z\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0{¢\u0006\u0002\b|H\u0086\b¢\u0006\u0004\b}\u0010~J\b\u0010\u007f\u001a\u00020\u0018H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00182\u0007\u0010\u0082\u0001\u001a\u000206H\u0002JJ\u0010\u0083\u0001\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00105\u001a\u0002062\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010H\u001a\u00020IH\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JH\u0010\u0083\u0001\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.2\u0006\u00105\u001a\u0002062\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010H\u001a\u00020IH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001Jm\u0010\u0088\u0001\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010H\u001a\u00020IH\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001Jo\u0010\u0088\u0001\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010H\u001a\u00020IH\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001e\u0010\u0090\u0001\u001a\u00020.*\u00020.2\u0006\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "<init>", "()V", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "strokePaint", "drawLine", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "topLeft", "size", "Landroidx/compose/ui/geometry/Size;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "drawOval-n-J9OG0", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "draw", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "configurePaint", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "miter", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CanvasDrawScope implements DrawScope {
    private final DrawContext drawContext;
    private final DrawParams drawParams;
    private Paint fillPaint;
    private Paint strokePaint;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u00020\tHÆ\u0003¢\u0006\u0004\b!\u0010\u0019J8\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density r100, LayoutDirection r101, Canvas r102, long r103, DefaultConstructorMarker r104) {
            this(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m5324copyUg5Nnss$default(DrawParams r100, Density r101, LayoutDirection r102, Canvas r103, long r104, int r105, Object r110) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.density;
        L6:
            if ((r105 & 2) == 0) goto L8;
            r102 = r100.layoutDirection;
        L8:
            LayoutDirection r111 = r102;
            if ((r105 & 4) == 0) goto L11;
            r103 = r100.canvas;
        L11:
            Canvas r106 = r103;
            if ((r105 & 8) == 0) goto L14;
            r104 = r100.size;
        L14:
            Density r107 = r101;
            return r100.m5326copyUg5Nnss(r107, r111, r106, r104);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m5325component4NHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m5326copyUg5Nnss(Density r100, LayoutDirection r110, Canvas r111, long r112) {
            return new DrawParams(r100, r110, r111, r112, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof DrawParams) == true) goto L8;
            return false;
        L8:
            DrawParams r101 = (DrawParams) r100;
            if (Intrinsics.areEqual(this.density, r101.density) == true) goto L12;
            return false;
        L12:
            if (this.layoutDirection == r101.layoutDirection) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.canvas, r101.canvas) == true) goto L18;
            return false;
        L18:
            if (Size.m4647equalsimpl0(this.size, r101.size) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m4652hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.m4655toStringimpl(this.size) + ')';
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m5327getSizeNHjbRc() {
            return this.size;
        }

        public final void setCanvas(Canvas r100) {
            this.canvas = r100;
        }

        public final void setDensity(Density r100) {
            this.density = r100;
        }

        public final void setLayoutDirection(LayoutDirection r100) {
            this.layoutDirection = r100;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m5328setSizeuvyYCjk(long r100) {
            this.size = r100;
        }

        private DrawParams(Density r100, LayoutDirection r101, Canvas r102, long r103) {
            this.density = r100;
            this.layoutDirection = r101;
            this.canvas = r102;
            this.size = r103;
        }

        public /* synthetic */ DrawParams(Density r100, LayoutDirection r101, Canvas r110, long r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            r100 = DrawContextKt.getDefaultDensity();
        L5:
            Density r102 = r100;
            if ((r112 & 2) == 0) goto L8;
            r101 = LayoutDirection.Ltr;
        L8:
            LayoutDirection r103 = r101;
            if ((r112 & 4) == 0) goto L11;
            r110 = EmptyCanvas.INSTANCE;
        L11:
            Canvas r104 = r110;
            if ((r112 & 8) == 0) goto L14;
            r111 = Size.Companion.m4660getZeroNHjbRc();
        L14:
            this(r102, r103, r104, r111, null);
        }
    }

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final /* synthetic */ long mo5321getCenterF1C5BW0() {
        return DrawScope.CC.m5371$default$getCenterF1C5BW0(this);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final /* synthetic */ long mo5322getSizeNHjbRc() {
        return DrawScope.CC.m5372$default$getSizeNHjbRc(this);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    public final /* synthetic */ void mo5323recordJVtK1S4(GraphicsLayer r100, long r101, Function1 r102) {
        DrawScope.CC.m5373$default$recordJVtK1S4(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
        return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
        return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
        return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
        return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
        return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
        return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
        return Density.CC.m7513$default$toPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final /* synthetic */ float mo371toPx0680j_4(float r100) {
        return Density.CC.m7514$default$toPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    public final /* synthetic */ Rect toRect(DpRect r100) {
        return Density.CC.$default$toRect(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
        return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
        return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
        return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
        return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
    }

    private final Paint obtainFillPaint() {
        Paint r100 = this.fillPaint;
        if (r100 != null) goto L6;
        Paint r101 = AndroidPaint_androidKt.Paint();
        r101.mo4708setStylek9PVt8s(PaintingStyle.Companion.m5114getFillTiuSbCo());
        this.fillPaint = r101;
        return r101;
    L6:
        return r100;
    }

    private final Paint obtainStrokePaint() {
        Paint r100 = this.strokePaint;
        if (r100 != null) goto L6;
        Paint r101 = AndroidPaint_androidKt.Paint();
        r101.mo4708setStylek9PVt8s(PaintingStyle.Companion.m5115getStrokeTiuSbCo());
        this.strokePaint = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    public CanvasDrawScope() {
        this.drawParams = new DrawParams(null, null, null, 0, 15, null);
        this.drawContext = new CanvasDrawScope$drawContext$1(this);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    private final Paint selectPaint(DrawStyle r100) {
        if (Intrinsics.areEqual(r100, Fill.INSTANCE) == false) goto L6;
        return obtainFillPaint();
    L6:
        if ((r100 instanceof Stroke) == false) goto L31;
        Paint r101 = obtainStrokePaint();
        Stroke r102 = (Stroke) r100;
        boolean r103 = true;
        if (r101.getStrokeWidth() != r102.getWidth()) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L14;
        r101.setStrokeWidth(r102.getWidth());
    L14:
        if (StrokeCap.m5202equalsimpl0(r101.mo4700getStrokeCapKaPHkGw(), r102.m5479getCapKaPHkGw()) == true) goto L17;
        r101.mo4706setStrokeCapBeK7IIE(r102.m5479getCapKaPHkGw());
    L17:
        if (r101.getStrokeMiterLimit() == r102.getMiter()) goto L20;
        r103 = false;
    L20:
        if (r103 == true) goto L23;
        r101.setStrokeMiterLimit(r102.getMiter());
    L23:
        if (StrokeJoin.m5212equalsimpl0(r101.mo4701getStrokeJoinLxFBmk8(), r102.m5480getJoinLxFBmk8()) == true) goto L26;
        r101.mo4707setStrokeJoinWw9F2mQ(r102.m5480getJoinLxFBmk8());
    L26:
        if (Intrinsics.areEqual(r101.getPathEffect(), r102.getPathEffect()) == true) goto L29;
        r101.setPathEffect(r102.getPathEffect());
    L29:
        return r101;
    L10:
        r104 = false;
        goto L11
    L31:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m5300modulate5vOe2sY(long r110, float r111) {
        if (r111 != 1.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return r110;
    L8:
        return Color.m4826copywmQWz5c$default(r110, Color.m4829getAlphaimpl(r110) * r111, 0.0f, 0.0f, 0.0f, 14, null);
    L5:
        r100 = false;
        goto L6
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m5301drawyzxVdVo(Density r100, LayoutDirection r101, Canvas r102, long r110, Function1<? super DrawScope, Unit> r111) {
        DrawParams r103 = getDrawParams();
        Density r104 = r103.component1();
        LayoutDirection r105 = r103.component2();
        Canvas r106 = r103.component3();
        long r107 = r103.m5325component4NHjbRc();
        DrawParams r108 = getDrawParams();
        r108.setDensity(r100);
        r108.setLayoutDirection(r101);
        r108.setCanvas(r102);
        r108.m5328setSizeuvyYCjk(r110);
        r102.save();
        r111.invoke(this);
        r102.restore();
        DrawParams r109 = getDrawParams();
        r109.setDensity(r104);
        r109.setLayoutDirection(r105);
        r109.setCanvas(r106);
        r109.m5328setSizeuvyYCjk(r107);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m5292configurePaint2qPWKa0(long r100, DrawStyle r101, float r102, ColorFilter r103, int r104, int r105) {
        Paint r106 = selectPaint(r101);
        long r107 = m5300modulate5vOe2sY(r100, r102);
        if (Color.m4828equalsimpl0(r106.mo4698getColor0d7_KjU(), r107) == true) goto L6;
        r106.mo4704setColor8_81llA(r107);
    L6:
        if (r106.getShader() == null) goto L9;
        r106.setShader(null);
    L9:
        if (Intrinsics.areEqual(r106.getColorFilter(), r103) == true) goto L12;
        r106.setColorFilter(r103);
    L12:
        if (BlendMode.m4737equalsimpl0(r106.mo4697getBlendMode0nO6VwU(), r104) == true) goto L15;
        r106.mo4703setBlendModes9anfk8(r104);
    L15:
        if (FilterQuality.m4922equalsimpl0(r106.mo4699getFilterQualityfv9h1I(), r105) == true) goto L17;
        r106.mo4705setFilterQualityvDHp3xo(r105);
    L17:
        return r106;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m5294configurePaintswdJneE(Brush r100, DrawStyle r101, float r102, ColorFilter r103, int r104, int r110) {
        Paint r105 = selectPaint(r101);
        if (r100 == null) goto L6;
        r100.mo4773applyToPq9zytI(DrawScope.CC.m5372$default$getSizeNHjbRc(this), r105, r102);
    L18:
        if (Intrinsics.areEqual(r105.getColorFilter(), r103) == true) goto L21;
        r105.setColorFilter(r103);
    L21:
        if (BlendMode.m4737equalsimpl0(r105.mo4697getBlendMode0nO6VwU(), r104) == true) goto L24;
        r105.mo4703setBlendModes9anfk8(r104);
    L24:
        if (FilterQuality.m4922equalsimpl0(r105.mo4699getFilterQualityfv9h1I(), r110) == true) goto L26;
        r105.mo4705setFilterQualityvDHp3xo(r110);
    L26:
        return r105;
    L6:
        if (r105.getShader() == null) goto L8;
        r105.setShader(null);
    L8:
        long r106 = r105.mo4698getColor0d7_KjU();
        Color.Companion r107 = Color.Companion;
        if (Color.m4828equalsimpl0(r106, r107.m4853getBlack0d7_KjU()) == true) goto L12;
        r105.mo4704setColor8_81llA(r107.m4853getBlack0d7_KjU());
    L12:
        if (r105.getAlpha() != r102) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == true) goto L18;
        r105.setAlpha(r102);
        goto L18
    L14:
        r108 = false;
        goto L15
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo5308drawImagegbVJVH8(ImageBitmap r110, long r111, float r112, DrawStyle r113, ColorFilter r114, int r115) {
        this.drawParams.getCanvas().mo4681drawImaged4ec7I(r110, r111, m5295configurePaintswdJneE$default(this, null, r113, r112, r114, r115, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo5313drawPathGBMwjPU(Path r110, Brush r111, float r112, DrawStyle r113, ColorFilter r114, int r115) {
        this.drawParams.getCanvas().drawPath(r110, m5295configurePaintswdJneE$default(this, r111, r113, r112, r114, r115, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo5314drawPathLG529CI(Path r110, long r111, float r112, DrawStyle r113, ColorFilter r114, int r115) {
        this.drawParams.getCanvas().drawPath(r110, m5293configurePaint2qPWKa0$default(this, r111, r113, r112, r114, r115, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo5304drawCircleV9BoPsw(Brush r110, float r111, long r112, float r113, DrawStyle r114, ColorFilter r115, int r116) {
        this.drawParams.getCanvas().mo4680drawCircle9KIMszo(r112, r111, m5295configurePaintswdJneE$default(this, r110, r114, r113, r115, r116, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo5305drawCircleVaOC9Bg(long r110, float r111, long r112, float r113, DrawStyle r114, ColorFilter r210, int r211) {
        this.drawParams.getCanvas().mo4680drawCircle9KIMszo(r112, r111, m5293configurePaint2qPWKa0$default(this, r110, r114, r113, r210, r211, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo5311drawOvalAsUm42w(Brush r110, long r111, long r112, float r210, DrawStyle r211, ColorFilter r212, int r213) {
        Canvas r113 = this.drawParams.getCanvas();
        int r100 = (int) (r111 >> 32);
        float r114 = Float.intBitsToFloat(r100);
        int r101 = (int) (r111 & BodyPartID.bodyIdMax);
        r113.drawOval(r114, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r112 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r112 & BodyPartID.bodyIdMax)), m5295configurePaintswdJneE$default(this, r110, r211, r210, r212, r213, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo5312drawOvalnJ9OG0(long r110, long r111, long r210, float r211, DrawStyle r212, ColorFilter r213, int r214) {
        Canvas r112 = this.drawParams.getCanvas();
        int r100 = (int) (r111 >> 32);
        float r113 = Float.intBitsToFloat(r100);
        int r101 = (int) (r111 & BodyPartID.bodyIdMax);
        r112.drawOval(r113, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r210 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r210 & BodyPartID.bodyIdMax)), m5293configurePaint2qPWKa0$default(this, r110, r212, r211, r213, r214, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo5317drawRectAsUm42w(Brush r110, long r111, long r112, float r210, DrawStyle r211, ColorFilter r212, int r213) {
        Canvas r113 = this.drawParams.getCanvas();
        int r100 = (int) (r111 >> 32);
        float r114 = Float.intBitsToFloat(r100);
        int r101 = (int) (r111 & BodyPartID.bodyIdMax);
        r113.drawRect(r114, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r112 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r112 & BodyPartID.bodyIdMax)), m5295configurePaintswdJneE$default(this, r110, r211, r210, r212, r213, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo5318drawRectnJ9OG0(long r110, long r111, long r210, float r211, DrawStyle r212, ColorFilter r213, int r214) {
        Canvas r112 = this.drawParams.getCanvas();
        int r100 = (int) (r111 >> 32);
        float r113 = Float.intBitsToFloat(r100);
        int r101 = (int) (r111 & BodyPartID.bodyIdMax);
        r112.drawRect(r113, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r210 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r210 & BodyPartID.bodyIdMax)), m5293configurePaint2qPWKa0$default(this, r110, r212, r211, r213, r214, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo5319drawRoundRectZuiqVtQ(Brush r110, long r111, long r210, long r211, float r212, DrawStyle r213, ColorFilter r214, int r215) {
        Canvas r112 = this.drawParams.getCanvas();
        int r100 = (int) (r111 >> 32);
        float r113 = Float.intBitsToFloat(r100);
        int r101 = (int) (r111 & BodyPartID.bodyIdMax);
        r112.drawRoundRect(r113, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r210 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r210 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r211 >> 32)), Float.intBitsToFloat((int) (r211 & BodyPartID.bodyIdMax)), m5295configurePaintswdJneE$default(this, r110, r213, r212, r214, r215, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo5320drawRoundRectuAw5IA(long r110, long r210, long r211, long r212, DrawStyle r213, float r214, ColorFilter r215, int r310) {
        Canvas r111 = this.drawParams.getCanvas();
        int r100 = (int) (r210 >> 32);
        float r112 = Float.intBitsToFloat(r100);
        int r101 = (int) (r210 & BodyPartID.bodyIdMax);
        r111.drawRoundRect(r112, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r211 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r211 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r212 >> 32)), Float.intBitsToFloat((int) (r212 & BodyPartID.bodyIdMax)), m5293configurePaint2qPWKa0$default(this, r110, r213, r214, r215, r310, 0, 32, null));
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static /* synthetic */ Paint m5293configurePaint2qPWKa0$default(CanvasDrawScope r100, long r110, DrawStyle r111, float r112, ColorFilter r113, int r114, int r115, int r116, Object r117) {
        if ((r116 & 32) == 0) goto L5;
        int r101 = DrawScope.Companion.m5412getDefaultFilterQualityfv9h1I();
    L7:
        return r100.m5292configurePaint2qPWKa0(r110, r111, r112, r113, r114, r101);
    L5:
        r101 = r115;
        goto L7
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    public static /* synthetic */ Paint m5295configurePaintswdJneE$default(CanvasDrawScope r100, Brush r101, DrawStyle r102, float r110, ColorFilter r111, int r112, int r113, int r114, Object r115) {
        if ((r114 & 32) == 0) goto L6;
        r113 = DrawScope.Companion.m5412getDefaultFilterQualityfv9h1I();
    L6:
        return r100.m5294configurePaintswdJneE(r101, r102, r110, r111, r112, r113);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo5306drawImage9jGpkUE(ImageBitmap r210, long r211, long r212, long r213, long r214, float r310, DrawStyle r311, ColorFilter r312, int r313) {
        this.drawParams.getCanvas().mo4682drawImageRectHPBpro0(r210, r211, r212, r213, r214, m5295configurePaintswdJneE$default(this, null, r311, r310, r312, r313, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo5309drawLine1RTmtNc(Brush r110, long r111, long r112, float r210, int r211, PathEffect r212, float r213, ColorFilter r214, int r215) {
        this.drawParams.getCanvas().mo4683drawLineWko1d7g(r111, r112, m5299configureStrokePaintho4zsrM$default(this, r110, r210, 4.0f, r211, StrokeJoin.Companion.m5217getMiterLxFBmk8(), r212, r213, r214, r215, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo5310drawLineNGM6Ib0(long r110, long r111, long r210, float r211, int r212, PathEffect r213, float r214, ColorFilter r215, int r216) {
        this.drawParams.getCanvas().mo4683drawLineWko1d7g(r111, r210, m5297configureStrokePaintQ_0CZUI$default(this, r110, r211, 4.0f, r212, StrokeJoin.Companion.m5217getMiterLxFBmk8(), r213, r214, r215, r216, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo5315drawPointsF8ZwMP8(List<Offset> r110, int r111, long r112, float r210, int r211, PathEffect r212, float r213, ColorFilter r214, int r215) {
        this.drawParams.getCanvas().mo4684drawPointsO7TthRY(r111, r110, m5297configureStrokePaintQ_0CZUI$default(this, r112, r210, 4.0f, r211, StrokeJoin.Companion.m5217getMiterLxFBmk8(), r212, r213, r214, r215, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo5316drawPointsGsft0Ws(List<Offset> r110, int r111, Brush r112, float r113, int r210, PathEffect r211, float r212, ColorFilter r213, int r214) {
        this.drawParams.getCanvas().mo4684drawPointsO7TthRY(r111, r110, m5299configureStrokePaintho4zsrM$default(this, r112, r113, 4.0f, r210, StrokeJoin.Companion.m5217getMiterLxFBmk8(), r211, r212, r213, r214, 0, 512, null));
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m5296configureStrokePaintQ_0CZUI(long r100, float r101, float r102, int r103, int r104, PathEffect r110, float r111, ColorFilter r112, int r113, int r114) {
        Paint r105 = obtainStrokePaint();
        long r106 = m5300modulate5vOe2sY(r100, r111);
        if (Color.m4828equalsimpl0(r105.mo4698getColor0d7_KjU(), r106) == true) goto L6;
        r105.mo4704setColor8_81llA(r106);
    L6:
        if (r105.getShader() == null) goto L9;
        r105.setShader(null);
    L9:
        if (Intrinsics.areEqual(r105.getColorFilter(), r112) == true) goto L12;
        r105.setColorFilter(r112);
    L12:
        if (BlendMode.m4737equalsimpl0(r105.mo4697getBlendMode0nO6VwU(), r113) == true) goto L14;
        r105.mo4703setBlendModes9anfk8(r113);
    L14:
        boolean r107 = true;
        if (r105.getStrokeWidth() != r101) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L21;
        r105.setStrokeWidth(r101);
    L21:
        if (r105.getStrokeMiterLimit() == r102) goto L24;
        r107 = false;
    L24:
        if (r107 == true) goto L27;
        r105.setStrokeMiterLimit(r102);
    L27:
        if (StrokeCap.m5202equalsimpl0(r105.mo4700getStrokeCapKaPHkGw(), r103) == true) goto L30;
        r105.mo4706setStrokeCapBeK7IIE(r103);
    L30:
        if (StrokeJoin.m5212equalsimpl0(r105.mo4701getStrokeJoinLxFBmk8(), r104) == true) goto L33;
        r105.mo4707setStrokeJoinWw9F2mQ(r104);
    L33:
        if (Intrinsics.areEqual(r105.getPathEffect(), r110) == true) goto L36;
        r105.setPathEffect(r110);
    L36:
        if (FilterQuality.m4922equalsimpl0(r105.mo4699getFilterQualityfv9h1I(), r114) == true) goto L38;
        r105.mo4705setFilterQualityvDHp3xo(r114);
    L38:
        return r105;
    L17:
        r108 = false;
        goto L18
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m5298configureStrokePaintho4zsrM(Brush r100, float r101, float r102, int r103, int r110, PathEffect r111, float r112, ColorFilter r113, int r114, int r115) {
        Paint r104 = obtainStrokePaint();
        boolean r105 = true;
        if (r100 == null) goto L6;
        r100.mo4773applyToPq9zytI(DrawScope.CC.m5372$default$getSizeNHjbRc(this), r104, r112);
    L12:
        if (Intrinsics.areEqual(r104.getColorFilter(), r113) == true) goto L15;
        r104.setColorFilter(r113);
    L15:
        if (BlendMode.m4737equalsimpl0(r104.mo4697getBlendMode0nO6VwU(), r114) == true) goto L18;
        r104.mo4703setBlendModes9anfk8(r114);
    L18:
        if (r104.getStrokeWidth() != r101) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L24;
        r104.setStrokeWidth(r101);
    L24:
        if (r104.getStrokeMiterLimit() == r102) goto L27;
        r105 = false;
    L27:
        if (r105 == true) goto L30;
        r104.setStrokeMiterLimit(r102);
    L30:
        if (StrokeCap.m5202equalsimpl0(r104.mo4700getStrokeCapKaPHkGw(), r103) == true) goto L33;
        r104.mo4706setStrokeCapBeK7IIE(r103);
    L33:
        if (StrokeJoin.m5212equalsimpl0(r104.mo4701getStrokeJoinLxFBmk8(), r110) == true) goto L36;
        r104.mo4707setStrokeJoinWw9F2mQ(r110);
    L36:
        if (Intrinsics.areEqual(r104.getPathEffect(), r111) == true) goto L39;
        r104.setPathEffect(r111);
    L39:
        if (FilterQuality.m4922equalsimpl0(r104.mo4699getFilterQualityfv9h1I(), r115) == true) goto L41;
        r104.mo4705setFilterQualityvDHp3xo(r115);
    L41:
        return r104;
    L20:
        r106 = false;
        goto L21
    L6:
        if (r104.getAlpha() != r112) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L12;
        r104.setAlpha(r112);
        goto L12
    L8:
        r107 = false;
        goto L9
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo5302drawArcillE91I(Brush r210, float r211, float r212, boolean r213, long r214, long r215, float r216, DrawStyle r217, ColorFilter r310, int r311) {
        Canvas r110 = this.drawParams.getCanvas();
        int r100 = (int) (r214 >> 32);
        float r111 = Float.intBitsToFloat(r100);
        int r101 = (int) (r214 & BodyPartID.bodyIdMax);
        r110.drawArc(r111, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r215 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r215 & BodyPartID.bodyIdMax)), r211, r212, r213, m5295configurePaintswdJneE$default(this, r210, r217, r216, r310, r311, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo5303drawArcyD3GUKo(long r110, float r111, float r210, boolean r211, long r212, long r213, float r214, DrawStyle r215, ColorFilter r216, int r217) {
        Canvas r112 = this.drawParams.getCanvas();
        int r100 = (int) (r212 >> 32);
        float r113 = Float.intBitsToFloat(r100);
        int r101 = (int) (r212 & BodyPartID.bodyIdMax);
        r112.drawArc(r113, Float.intBitsToFloat(r101), Float.intBitsToFloat(r100) + Float.intBitsToFloat((int) (r213 >> 32)), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r213 & BodyPartID.bodyIdMax)), r111, r210, r211, m5293configurePaint2qPWKa0$default(this, r110, r215, r214, r216, r217, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo5307drawImageAZ2fEMs(ImageBitmap r210, long r211, long r212, long r213, long r214, float r215, DrawStyle r310, ColorFilter r311, int r312, int r313) {
        this.drawParams.getCanvas().mo4682drawImageRectHPBpro0(r210, r211, r212, r213, r214, m5294configurePaintswdJneE(null, r310, r215, r311, r312, r313));
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    public static /* synthetic */ Paint m5297configureStrokePaintQ_0CZUI$default(CanvasDrawScope r110, long r111, float r112, float r113, int r114, int r115, PathEffect r210, float r211, ColorFilter r212, int r213, int r214, int r215, Object r216) {
        if ((r215 & 512) == 0) goto L5;
        int r116 = DrawScope.Companion.m5412getDefaultFilterQualityfv9h1I();
    L7:
        return r110.m5296configureStrokePaintQ_0CZUI(r111, r112, r113, r114, r115, r210, r211, r212, r213, r116);
    L5:
        r116 = r214;
        goto L7
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    public static /* synthetic */ Paint m5299configureStrokePaintho4zsrM$default(CanvasDrawScope r110, Brush r111, float r112, float r113, int r114, int r115, PathEffect r116, float r117, ColorFilter r210, int r211, int r212, int r213, Object r214) {
        if ((r213 & 512) == 0) goto L5;
        int r118 = DrawScope.Companion.m5412getDefaultFilterQualityfv9h1I();
    L7:
        return r110.m5298configureStrokePaintho4zsrM(r111, r112, r113, r114, r115, r116, r117, r210, r211, r118);
    L5:
        r118 = r212;
        goto L7
    }
}
