package androidx.compose.ui.node;

import C7.c;
import C7.r;
import androidx.annotation.FloatRange;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u0007*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0016\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ9\u0010\"\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b \u0010!J^\u00105\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010.\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b3\u00104J^\u00105\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010.\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b8\u00109JL\u0010?\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b=\u0010>JL\u0010?\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b@\u0010AJD\u0010F\u001a\u00020\u00072\u0006\u0010C\u001a\u00020B2\u0006\u0010:\u001a\u00020%2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bD\u0010EJ\\\u0010F\u001a\u00020\u00072\u0006\u0010C\u001a\u00020B2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0097\u0001¢\u0006\u0004\bL\u0010MJd\u0010F\u001a\u00020\u00072\u0006\u0010C\u001a\u00020B2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u0002012\u0006\u0010O\u001a\u00020NH\u0096\u0001¢\u0006\u0004\bP\u0010QJT\u0010V\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010S\u001a\u00020R2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bT\u0010UJT\u0010V\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010S\u001a\u00020R2\u0006\u0010<\u001a\u00020;2\b\b\u0001\u0010.\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bW\u0010XJL\u0010]\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020%2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b[\u0010\\JL\u0010]\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020%2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b^\u0010_JL\u0010a\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\b`\u0010>JL\u0010a\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bb\u0010AJd\u0010i\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010c\u001a\u00020(2\u0006\u0010d\u001a\u00020(2\u0006\u0010f\u001a\u00020e2\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bg\u0010hJd\u0010i\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010c\u001a\u00020(2\u0006\u0010d\u001a\u00020(2\u0006\u0010f\u001a\u00020e2\u0006\u0010:\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bj\u0010kJD\u0010p\u001a\u00020\u00072\u0006\u0010m\u001a\u00020l2\u0006\u00107\u001a\u0002062\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bn\u0010oJD\u0010p\u001a\u00020\u00072\u0006\u0010m\u001a\u00020l2\u0006\u0010$\u001a\u00020#2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010<\u001a\u00020;2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bq\u0010rJd\u0010y\u001a\u00020\u00072\f\u0010t\u001a\b\u0012\u0004\u0012\u00020%0s2\u0006\u0010v\u001a\u00020u2\u0006\u00107\u001a\u0002062\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010.\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bw\u0010xJd\u0010y\u001a\u00020\u00072\f\u0010t\u001a\b\u0012\u0004\u0012\u00020%0s2\u0006\u0010v\u001a\u00020u2\u0006\u0010$\u001a\u00020#2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010.\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0096\u0001¢\u0006\u0004\bz\u0010{J\u0014\u0010\u007f\u001a\u00020(*\u00020|H\u0097\u0001¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020(*\u00030\u0080\u0001H\u0097\u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0018\u0010\u0086\u0001\u001a\u00030\u0083\u0001*\u00020|H\u0097\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00030\u0083\u0001*\u00030\u0080\u0001H\u0097\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0018\u0010\u008b\u0001\u001a\u00020|*\u00030\u0083\u0001H\u0097\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0016\u0010\u008b\u0001\u001a\u00020|*\u00020(H\u0097\u0001¢\u0006\u0005\b\u0089\u0001\u0010~J\u0018\u0010\u008b\u0001\u001a\u00020|*\u00030\u0080\u0001H\u0097\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u0082\u0001J\u0019\u0010\u008f\u0001\u001a\u00030\u0080\u0001*\u00030\u0083\u0001H\u0097\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0018\u0010\u008f\u0001\u001a\u00030\u0080\u0001*\u00020(H\u0097\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u0090\u0001J\u0018\u0010\u008f\u0001\u001a\u00030\u0080\u0001*\u00020|H\u0097\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0090\u0001J\u0019\u0010\u0094\u0001\u001a\u00030\u0093\u0001*\u00030\u0092\u0001H\u0097\u0001¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0018\u0010\u0099\u0001\u001a\u00020\u0018*\u00030\u0096\u0001H\u0097\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0018\u0010\u009b\u0001\u001a\u00030\u0096\u0001*\u00020\u0018H\u0097\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u0098\u0001R\u001a\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\u000f\n\u0005\b\u0004\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010\u009f\u0001R\u0018\u0010£\u0001\u001a\u00030 \u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0016\u0010Z\u001a\u00020%8VX\u0096\u0005¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0016\u0010\f\u001a\u00020\u00188VX\u0096\u0005¢\u0006\b\u001a\u0006\b¦\u0001\u0010¥\u0001R\u0018\u0010ª\u0001\u001a\u00030§\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010\u00ad\u0001\u001a\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010¯\u0001\u001a\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b®\u0001\u0010¬\u0001¨\u0006°\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "LC7/r;", "drawContent", "()V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/unit/IntSize;", "size", "Lkotlin/Function1;", "block", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLS7/k;)V", "record", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/Canvas;", "canvas", WindowStateInfo.KEY_LAYER, "performDraw", "(Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "Landroidx/compose/ui/Modifier$Node;", "drawNode", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawDirect", "Landroidx/compose/ui/graphics/Brush;", "brush", "Landroidx/compose/ui/geometry/Offset;", "start", "end", "", "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "srcSize", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-AsUm42w", "drawOval", "drawOval-n-J9OG0", CircularAnimatedDrawable.START_ANGLE_PROPERTY, CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, "", "useCenter", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "", "points", "Landroidx/compose/ui/graphics/PointMode;", "pointMode", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "toPx", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "", "roundToPx-0680j_4", "(F)I", "roundToPx", "roundToPx--R2X_6o", "(J)I", "toDp-u2uoSUM", "(I)F", "toDp", "toDp-GaN1DYA", "toSp-kPz2Gy4", "(I)J", "toSp", "(F)J", "toSp-0xMU5do", "Landroidx/compose/ui/unit/DpRect;", "Landroidx/compose/ui/geometry/Rect;", "toRect", "(Landroidx/compose/ui/unit/DpRect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toSize", "toDpSize-k-rfVVM", "toDpSize", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "getCenter-F1C5BW0", "()J", "getSize-NH-jbRc", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "()F", "density", "getFontScale", "fontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeDrawScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m5772draweZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode, GraphicsLayer layer) {
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(4);
        DelegatingNode delegatingNodePop = drawNode;
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (delegatingNodePop instanceof DrawModifierNode) {
                m5773drawDirecteZhPAX0$ui_release(canvas, size, coordinator, delegatingNodePop, layer);
            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodePop.getDelegate();
                int i = 0;
                delegatingNodePop = delegatingNodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodePop != 0) {
                                mutableVector.add(delegatingNodePop);
                                delegatingNodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodePop = delegatingNodePop;
                }
                if (i == 1) {
                }
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-illE91I */
    public void mo4604drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4604drawArcillE91I(brush, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public void mo4605drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4605drawArcyD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-V9BoPsw */
    public void mo4606drawCircleV9BoPsw(Brush brush, float radius, long center, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4606drawCircleV9BoPsw(brush, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo4607drawCircleVaOC9Bg(long color, float radius, long center, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4607drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        if (drawModifierNode == null) {
            throw b.x("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        DelegatingNode delegatingNodeNextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (delegatingNodeNextDrawNode == 0) {
            NodeCoordinator nodeCoordinatorM5702requireCoordinator64DMado = DelegatableNodeKt.m5702requireCoordinator64DMado(drawModifierNode, NodeKind.m5862constructorimpl(4));
            if (nodeCoordinatorM5702requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                nodeCoordinatorM5702requireCoordinator64DMado = nodeCoordinatorM5702requireCoordinator64DMado.getWrapped();
                k.c(nodeCoordinatorM5702requireCoordinator64DMado);
            }
            nodeCoordinatorM5702requireCoordinator64DMado.performDraw(canvas, getDrawContext().getGraphicsLayer());
            return;
        }
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(4);
        MutableVector mutableVector = null;
        while (delegatingNodeNextDrawNode != 0) {
            if (delegatingNodeNextDrawNode instanceof DrawModifierNode) {
                performDraw((DrawModifierNode) delegatingNodeNextDrawNode, canvas, getDrawContext().getGraphicsLayer());
            } else if ((delegatingNodeNextDrawNode.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodeNextDrawNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodeNextDrawNode.getDelegate();
                int i = 0;
                delegatingNodeNextDrawNode = delegatingNodeNextDrawNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodeNextDrawNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodeNextDrawNode != 0) {
                                mutableVector.add(delegatingNodeNextDrawNode);
                                delegatingNodeNextDrawNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodeNextDrawNode = delegatingNodeNextDrawNode;
                }
                if (i == 1) {
                }
            }
            delegatingNodeNextDrawNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    /* renamed from: drawDirect-eZhPAX0$ui_release, reason: not valid java name */
    public final void m5773drawDirecteZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode, GraphicsLayer layer) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        Density density = canvasDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
        long jMo4628getSizeNHjbRc = canvasDrawScope.getDrawContext().mo4628getSizeNHjbRc();
        GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = canvasDrawScope.getDrawContext();
        drawContext.setDensity(coordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo4629setSizeuvyYCjk(size);
        drawContext.setGraphicsLayer(layer);
        canvas.save();
        try {
            drawNode.draw(this);
            canvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            this.drawNode = drawModifierNode;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @c
    /* renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo4608drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4608drawImage9jGpkUE(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo4609drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo4609drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo4610drawImagegbVJVH8(ImageBitmap image, long topLeft, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4610drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo4611drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4611drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public void mo4612drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4612drawLineNGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-AsUm42w */
    public void mo4613drawOvalAsUm42w(Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4613drawOvalAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-n-J9OG0 */
    public void mo4614drawOvalnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4614drawOvalnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo4615drawPathGBMwjPU(Path path, Brush brush, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4615drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo4616drawPathLG529CI(Path path, long color, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4616drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8 */
    public void mo4617drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4617drawPointsF8ZwMP8(points, pointMode, color, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-Gsft0Ws */
    public void mo4618drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4618drawPointsGsft0Ws(points, pointMode, brush, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo4619drawRectAsUm42w(Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4619drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo4620drawRectnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4620drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo4621drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, @FloatRange(from = 0.0d, to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4621drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo4622drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, @FloatRange(from = 0.0d, to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4622drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo4706getCenterF1C5BW0() {
        return this.canvasDrawScope.mo4706getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo4707getSizeNHjbRc() {
        return this.canvasDrawScope.mo4707getSizeNHjbRc();
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinatorM5702requireCoordinator64DMado = DelegatableNodeKt.m5702requireCoordinator64DMado(drawModifierNode, NodeKind.m5862constructorimpl(4));
        nodeCoordinatorM5702requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m5773drawDirecteZhPAX0$ui_release(canvas, IntSizeKt.m7027toSizeozmzZPI(nodeCoordinatorM5702requireCoordinator64DMado.mo5557getSizeYbymL2g()), nodeCoordinatorM5702requireCoordinator64DMado, drawModifierNode, graphicsLayer);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: record-JVtK1S4 */
    public void mo4708recordJVtK1S4(GraphicsLayer graphicsLayer, long j5, final S7.k kVar) {
        final DrawModifierNode drawModifierNode = this.drawNode;
        graphicsLayer.m4801recordmLhObY(this, getLayoutDirection(), j5, new S7.k() { // from class: androidx.compose.ui.node.LayoutNodeDrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
                invoke((DrawScope) obj);
                return r.f317a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.node.DrawModifierNode] */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.node.DrawModifierNode] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.graphics.drawscope.DrawContext] */
            /* JADX WARN: Type inference failed for: r2v5 */
            public final void invoke(DrawScope drawScope) throws Throwable {
                LayoutNodeDrawScope layoutNodeDrawScope;
                Density density;
                LayoutDirection layoutDirection;
                Canvas canvas;
                long jMo4628getSizeNHjbRc;
                GraphicsLayer graphicsLayer2;
                S7.k kVar2;
                Density density2;
                LayoutDirection layoutDirection2;
                Canvas canvas2;
                long jMo4628getSizeNHjbRc2;
                GraphicsLayer graphicsLayer3;
                ?? drawContext = this.this$0.drawNode;
                this.this$0.drawNode = drawModifierNode;
                try {
                    layoutNodeDrawScope = this.this$0;
                    density = drawScope.getDrawContext().getDensity();
                    layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                    canvas = drawScope.getDrawContext().getCanvas();
                    jMo4628getSizeNHjbRc = drawScope.getDrawContext().mo4628getSizeNHjbRc();
                    graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                    kVar2 = kVar;
                    density2 = layoutNodeDrawScope.getDrawContext().getDensity();
                    layoutDirection2 = layoutNodeDrawScope.getDrawContext().getLayoutDirection();
                    canvas2 = layoutNodeDrawScope.getDrawContext().getCanvas();
                    jMo4628getSizeNHjbRc2 = layoutNodeDrawScope.getDrawContext().mo4628getSizeNHjbRc();
                    graphicsLayer3 = layoutNodeDrawScope.getDrawContext().getGraphicsLayer();
                } catch (Throwable th) {
                    th = th;
                    this.this$0.drawNode = drawContext;
                    throw th;
                }
                try {
                    drawContext = layoutNodeDrawScope.getDrawContext();
                    drawContext.setDensity(density);
                    drawContext.setLayoutDirection(layoutDirection);
                    drawContext.setCanvas(canvas);
                    drawContext.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                    drawContext.setGraphicsLayer(graphicsLayer2);
                    canvas.save();
                    try {
                        kVar2.invoke(layoutNodeDrawScope);
                        canvas.restore();
                        DrawContext drawContext2 = layoutNodeDrawScope.getDrawContext();
                        drawContext2.setDensity(density2);
                        drawContext2.setLayoutDirection(layoutDirection2);
                        drawContext2.setCanvas(canvas2);
                        drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc2);
                        drawContext2.setGraphicsLayer(graphicsLayer3);
                        this.this$0.drawNode = drawContext;
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    drawContext = drawContext;
                    this.this$0.drawNode = drawContext;
                    throw th;
                }
            }
        });
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: roundToPx--R2X_6o */
    public int mo374roundToPxR2X_6o(long j5) {
        return this.canvasDrawScope.mo374roundToPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: roundToPx-0680j_4 */
    public int mo375roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo375roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    @Stable
    /* renamed from: toDp-GaN1DYA */
    public float mo376toDpGaN1DYA(long j5) {
        return this.canvasDrawScope.mo376toDpGaN1DYA(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo377toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo377toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    public long mo379toDpSizekrfVVM(long j5) {
        return this.canvasDrawScope.mo379toDpSizekrfVVM(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toPx--R2X_6o */
    public float mo380toPxR2X_6o(long j5) {
        return this.canvasDrawScope.mo380toPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toPx-0680j_4 */
    public float mo381toPx0680j_4(float f) {
        return this.canvasDrawScope.mo381toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ */
    public long mo382toSizeXkaWNTQ(long j5) {
        return this.canvasDrawScope.mo382toSizeXkaWNTQ(j5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    @Stable
    /* renamed from: toSp-0xMU5do */
    public long mo383toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo383toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo384toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo384toSpkPz2Gy4(f);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo378toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo378toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo385toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.mo385toSpkPz2Gy4(i);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, e eVar) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
