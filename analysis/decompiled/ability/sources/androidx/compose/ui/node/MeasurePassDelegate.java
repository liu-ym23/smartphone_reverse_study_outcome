package androidx.compose.ui.node;

import C7.r;
import S7.a;
import S7.k;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J5\u0010*\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t\u0018\u00010%H\u0014¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010,\u001a\u00020+H\u0014¢\u0006\u0004\b(\u0010-J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0018H\u0016¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\t¢\u0006\u0004\b1\u0010\u000bJ\u0017\u00103\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001eH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001eH\u0016¢\u0006\u0004\b5\u00104J\u0017\u00107\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001eH\u0016¢\u0006\u0004\b7\u00104J\u0017\u00108\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001eH\u0016¢\u0006\u0004\b8\u00104J\r\u00109\u001a\u00020\t¢\u0006\u0004\b9\u0010\u000bJ\r\u0010:\u001a\u00020\u0018¢\u0006\u0004\b:\u0010;J\u001b\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e0<H\u0016¢\u0006\u0004\b=\u0010>J#\u0010@\u001a\u00020\t2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0%H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010\u000bJ\u000f\u0010C\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010\u000bJ\r\u0010D\u001a\u00020\t¢\u0006\u0004\bD\u0010\u000bJ\u0015\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0018¢\u0006\u0004\bF\u00100J\r\u0010G\u001a\u00020\t¢\u0006\u0004\bG\u0010\u000bJ\r\u0010H\u001a\u00020\t¢\u0006\u0004\bH\u0010\u000bJ\u000f\u0010J\u001a\u00020\tH\u0000¢\u0006\u0004\bI\u0010\u000bJ\u000f\u0010K\u001a\u00020\tH\u0002¢\u0006\u0004\bK\u0010\u000bJ\u000f\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bL\u0010\u000bJ\u000f\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010\u000bJ\u000f\u0010N\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010\u000bJ$\u0010O\u001a\u00020\t2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0%H\u0082\b¢\u0006\u0004\bO\u0010AJ\u0017\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ?\u0010V\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t\u0018\u00010%2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bT\u0010UJ?\u0010X\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t\u0018\u00010%2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bW\u0010UJ\u000f\u0010Y\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010\u000bJ\u000f\u0010Z\u001a\u00020\tH\u0002¢\u0006\u0004\bZ\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010[R\u0016\u0010\\\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010_\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR$\u0010c\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bc\u0010`\u001a\u0004\bd\u0010bR\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010]R$\u0010f\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bf\u0010]\u001a\u0004\bg\u0010;R\"\u0010i\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bo\u0010]\u001a\u0004\bp\u0010;\"\u0004\bq\u00100R$\u0010r\u001a\u00020!2\u0006\u0010^\u001a\u00020!8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR$\u0010v\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010]R*\u0010~\u001a\u0004\u0018\u00010}2\b\u0010^\u001a\u0004\u0018\u00010}8\u0016@RX\u0096\u000e¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R.\u0010\u0082\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0016@PX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010]\u001a\u0005\b\u0082\u0001\u0010;\"\u0005\b\u0083\u0001\u00100R.\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0006@@X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010]\u001a\u0005\b\u0084\u0001\u0010;\"\u0005\b\u0085\u0001\u00100R'\u0010\u0086\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010]\u001a\u0005\b\u0087\u0001\u0010;R'\u0010\u0088\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010]\u001a\u0005\b\u0089\u0001\u0010;R\u0018\u0010\u008a\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010]R \u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R&\u0010\u0093\u0001\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010]\u001a\u0005\b\u0094\u0001\u0010;\"\u0005\b\u0095\u0001\u00100R'\u0010\u0096\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010]\u001a\u0005\b\u0097\u0001\u0010;R\u0018\u0010\u0098\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010sR&\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0099\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009b\u0001R&\u0010$\u001a\u00020#2\u0006\u0010^\u001a\u00020#8\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0004\b$\u0010{\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010]R&\u0010¢\u0001\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010wR\u001a\u0010£\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b£\u0001\u0010yR\u0018\u0010¤\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010sR\u0018\u0010¥\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010{R\u001e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010\u009b\u0001R\u0018\u0010§\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010]R&\u0010¨\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010]\u001a\u0005\b¨\u0001\u0010;\"\u0005\b©\u0001\u00100R\u0016\u0010¬\u0001\u001a\u0004\u0018\u00010\u00108F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0014\u0010¯\u0001\u001a\u00020P8F¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001R+\u0010µ\u0001\u001a\u00030°\u00012\u0007\u0010^\u001a\u00030°\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u0015\u0010¹\u0001\u001a\u00030¶\u00018F¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010»\u0001\u001a\u00030¶\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010¸\u0001R\u001e\u0010¿\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000¼\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b½\u0001\u0010¾\u0001R\u0016\u0010Á\u0001\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010bR\u0016\u0010Ã\u0001\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010bR\u0019\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u0005\u0018\u00010Ç\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001¨\u0006Ë\u0001"}, d2 = {"Landroidx/compose/ui/node/MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "layoutNodeLayoutDelegate", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "LC7/r;", "markDetachedFromParentLookaheadPass$ui_release", "()V", "markDetachedFromParentLookaheadPass", "layoutChildren", "onNodePlaced$ui_release", "onNodePlaced", "Landroidx/compose/ui/unit/Constraints;", "constraints", "performMeasure-BRTryo0$ui_release", "(J)V", "performMeasure", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "remeasure-BRTryo0", "(J)Z", "remeasure", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLS7/k;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "newMFR", "updatePlacedUnderMotionFrameOfReference", "(Z)V", "replace", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "invalidateParentData", "updateParentData", "()Z", "", "calculateAlignmentLines", "()Ljava/util/Map;", "block", "forEachChildAlignmentLinesOwner", "(LS7/k;)V", "requestLayout", "requestMeasure", "notifyChildrenUsingCoordinatesWhilePlacing", "forceRequest", "invalidateIntrinsicsParent", "onNodeDetached", "markLayoutPending", "markMeasurePending$ui_release", "markMeasurePending", "checkChildrenPlaceOrderForUpdates", "markSubtreeAsNotPlaced", "markNodeAndSubtreeAsPlaced", "clearPlaceOrder", "forEachChildDelegate", "Landroidx/compose/ui/node/LayoutNode;", "node", "trackMeasurementByParent", "(Landroidx/compose/ui/node/LayoutNode;)V", "placeSelf-MLgxB_4", "(JFLS7/k;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeOuterCoordinator-MLgxB_4", "placeOuterCoordinator", "onIntrinsicsQueried", "onBeforeLayoutChildren", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "relayoutWithoutParentInProgress", "Z", "value", "previousPlaceOrder", "I", "getPreviousPlaceOrder$ui_release", "()I", "placeOrder", "getPlaceOrder$ui_release", "measuredOnce", "placedOnce", "getPlacedOnce", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "lastPosition", "J", "getLastPosition-nOcc-ac$ui_release", "()J", "lastLayerBlock", "LS7/k;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastZIndex", "F", "parentDataDirty", "", "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "isPlaced", "setPlaced$ui_release", "isPlacedByParent", "setPlacedByParent$ui_release", "measurePending", "getMeasurePending$ui_release", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui_release", "setChildDelegatesDirty$ui_release", "layingOutChildren", "getLayingOutChildren", "performMeasureConstraints", "Lkotlin/Function0;", "performMeasureBlock", "LS7/a;", "getPerformMeasureBlock$ui_release", "()LS7/a;", "layoutChildrenBlock", "getZIndex$ui_release", "()F", "onNodePlacedCalled", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placeOuterCoordinatorBlock", "needsCoordinatesUpdate", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "layoutState", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getInnerCoordinator", "innerCoordinator", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegates", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "lookaheadPassDelegate", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public static final int $stable = 8;
    private final MutableVector<MeasurePassDelegate> _childDelegates;
    private final AlignmentLines alignmentLines;
    private boolean childDelegatesDirty;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlaced;
    private boolean isPlacedByParent;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private k lastLayerBlock;
    private long lastPosition;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final a layoutChildrenBlock;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private boolean measurePending;
    private boolean measuredOnce;
    private boolean needsCoordinatesUpdate;
    private boolean onNodePlacedCalled;
    private Object parentData;
    private boolean parentDataDirty;
    private final a performMeasureBlock;
    private long performMeasureConstraints;
    private final a placeOuterCoordinatorBlock;
    private GraphicsLayer placeOuterCoordinatorLayer;
    private k placeOuterCoordinatorLayerBlock;
    private long placeOuterCoordinatorPosition;
    private float placeOuterCoordinatorZIndex;
    private boolean placedOnce;
    private boolean relayoutWithoutParentInProgress;
    private float zIndex;
    private int previousPlaceOrder = Integer.MAX_VALUE;
    private int placeOrder = Integer.MAX_VALUE;
    private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
        IntOffset.Companion companion = IntOffset.INSTANCE;
        this.lastPosition = companion.m6983getZeronOccac();
        this.parentDataDirty = true;
        this.alignmentLines = new LayoutNodeAlignmentLines(this);
        this._childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
        this.childDelegatesDirty = true;
        this.performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.performMeasureBlock = new a() { // from class: androidx.compose.ui.node.MeasurePassDelegate$performMeasureBlock$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5812invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5812invoke() {
                this.this$0.getOuterCoordinator().mo5549measureBRTryo0(this.this$0.performMeasureConstraints);
            }
        };
        this.layoutChildrenBlock = new a() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5811invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5811invoke() {
                this.this$0.clearPlaceOrder();
                this.this$0.forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.1
                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((AlignmentLinesOwner) obj);
                        return r.f317a;
                    }

                    public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
                        alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                    }
                });
                this.this$0.getInnerCoordinator().getMeasureResult$ui_release().placeChildren();
                this.this$0.checkChildrenPlaceOrderForUpdates();
                this.this$0.forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.2
                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((AlignmentLinesOwner) obj);
                        return r.f317a;
                    }

                    public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
                        alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
                    }
                });
            }
        };
        this.placeOuterCoordinatorPosition = companion.m6983getZeronOccac();
        this.placeOuterCoordinatorBlock = new a() { // from class: androidx.compose.ui.node.MeasurePassDelegate$placeOuterCoordinatorBlock$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5813invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5813invoke() {
                Placeable.PlacementScope placementScope;
                NodeCoordinator wrappedBy = this.this$0.getOuterCoordinator().getWrappedBy();
                if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                    placementScope = LayoutNodeKt.requireOwner(this.this$0.getLayoutNode()).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                MeasurePassDelegate measurePassDelegate = this.this$0;
                k kVar = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                GraphicsLayer graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
                if (graphicsLayer != null) {
                    placementScope2.m5632placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, graphicsLayer, measurePassDelegate.placeOuterCoordinatorZIndex);
                } else if (kVar == null) {
                    placementScope2.m5623place70tqf50(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex);
                } else {
                    placementScope2.m5631placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex, kVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildrenPlaceOrderForUpdates() {
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getMeasurePassDelegate$ui_release().previousPlaceOrder != layoutNode2.getPlaceOrder$ui_release()) {
                layoutNode.onZSortedChildrenInvalidated$ui_release();
                layoutNode.invalidateLayer$ui_release();
                if (layoutNode2.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                    if (layoutNode2.getLayoutDelegate().getDetachedFromParentLookaheadPlacement()) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode2.getLookaheadPassDelegate$ui_release();
                        kotlin.jvm.internal.k.c(lookaheadPassDelegate$ui_release);
                        lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsNotPlaced$ui_release(false);
                    }
                    layoutNode2.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildPlaceOrder$ui_release(0);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNodeArr[i].getMeasurePassDelegate$ui_release();
            measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
            measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
            measurePassDelegate$ui_release.isPlacedByParent = false;
            if (measurePassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                measurePassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
        }
    }

    private final void forEachChildDelegate(k block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(layoutNodeArr[i].getMeasurePassDelegate$ui_release());
        }
    }

    private final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutNodeLayoutDelegate.getLookaheadPassDelegate();
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean isPlaced = getIsPlaced();
        setPlaced$ui_release(true);
        LayoutNode layoutNode = getLayoutNode();
        if (!isPlaced) {
            layoutNode.getInnerCoordinator$ui_release().onPlaced();
            if (layoutNode.getMeasurePending$ui_release()) {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
            } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
            }
        }
        NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !kotlin.jvm.internal.k.b(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
            if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped()) {
                outerCoordinator$ui_release.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                layoutNode2.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode2);
            }
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (getIsPlaced()) {
            setPlaced$ui_release(false);
            LayoutNode layoutNode = getLayoutNode();
            NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui_release().getWrapped();
            for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !kotlin.jvm.internal.k.b(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                outerCoordinator$ui_release.onUnplaced();
                outerCoordinator$ui_release.releaseLayer();
            }
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                layoutNodeArr[i].getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.getMeasurePending$ui_release() && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m5753remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null)) {
                LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
            }
        }
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || getLayoutNode().getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = getLayoutNode();
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        layoutNode.setIntrinsicsUsageByParent$ui_release(i != 1 ? i != 2 ? parent$ui_release.getIntrinsicsUsageByParent() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
    }

    /* renamed from: placeOuterCoordinator-MLgxB_4, reason: not valid java name */
    private final void m5805placeOuterCoordinatorMLgxB_4(long position, float zIndex, k layerBlock, GraphicsLayer layer) {
        if (getLayoutNode().getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        setLayoutState(LayoutNode.LayoutState.LayingOut);
        this.lastPosition = position;
        this.lastZIndex = zIndex;
        this.lastLayerBlock = layerBlock;
        this.lastExplicitLayer = layer;
        this.onNodePlacedCalled = false;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        if (this.layoutPending || !getIsPlaced()) {
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = layerBlock;
            this.placeOuterCoordinatorPosition = position;
            this.placeOuterCoordinatorZIndex = zIndex;
            this.placeOuterCoordinatorLayer = layer;
            ownerRequireOwner.getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(getLayoutNode(), false, this.placeOuterCoordinatorBlock);
        } else {
            getOuterCoordinator().m5847placeSelfApparentToRealOffsetMLgxB_4(position, zIndex, layerBlock, layer);
            onNodePlaced$ui_release();
        }
        setLayoutState(LayoutNode.LayoutState.Idle);
        this.placedOnce = true;
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m5806placeSelfMLgxB_4(long position, float zIndex, k layerBlock, GraphicsLayer layer) throws Throwable {
        Placeable.PlacementScope placementScope;
        LayoutNode layoutNode = getLayoutNode();
        boolean z10 = true;
        try {
            this.isPlacedByParent = true;
            if (!IntOffset.m6971equalsimpl0(position, this.lastPosition) || this.needsCoordinatesUpdate) {
                if (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement() || this.needsCoordinatesUpdate) {
                    this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            if (lookaheadPassDelegate != null && lookaheadPassDelegate.getNeedsToBePlacedInApproach()) {
                NodeCoordinator wrappedBy = getOuterCoordinator().getWrappedBy();
                if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                    placementScope = LayoutNodeKt.requireOwner(getLayoutNode()).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                LookaheadPassDelegate lookaheadPassDelegate2 = getLookaheadPassDelegate();
                kotlin.jvm.internal.k.c(lookaheadPassDelegate2);
                LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.getLayoutDelegate().setNextChildLookaheadPlaceOrder$ui_release(0);
                }
                lookaheadPassDelegate2.setPlaceOrder$ui_release(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default(placementScope2, lookaheadPassDelegate2, IntOffset.m6972getXimpl(position), IntOffset.m6973getYimpl(position), 0.0f, 4, null);
            }
            LookaheadPassDelegate lookaheadPassDelegate3 = getLookaheadPassDelegate();
            if (lookaheadPassDelegate3 == null || lookaheadPassDelegate3.getPlacedOnce()) {
                z10 = false;
            }
            if (z10) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            m5805placeOuterCoordinatorMLgxB_4(position, zIndex, layerBlock, layer);
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    private final void trackMeasurementByParent(LayoutNode node) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = node.getParent$ui_release();
        if (parent$ui_release == null) {
            this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            return;
        }
        if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure())) {
            InlineClassHelperKt.throwIllegalStateException(LayoutNodeLayoutDelegateKt.MeasuredTwiceErrorMessage);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        if (i == 1) {
            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else {
            if (i != 2) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
            }
            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        }
        this.measuredByParent = usageByParent;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map<AlignmentLine, Integer> calculateAlignmentLines() {
        if (!this.duringAlignmentLinesQuery) {
            if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                if (getAlignmentLines().getDirty()) {
                    markLayoutPending();
                }
            } else {
                getAlignmentLines().setUsedByModifierLayout$ui_release(true);
            }
        }
        getInnerCoordinator().setPlacingForAlignment$ui_release(true);
        layoutChildren();
        getInnerCoordinator().setPlacingForAlignment$ui_release(false);
        return getAlignmentLines().getLastCalculation();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void forEachChildAlignmentLinesOwner(k block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(layoutNodeArr[i].getLayoutDelegate().getAlignmentLinesOwner$ui_release());
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
            getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = getLayoutNode().getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = getOuterCoordinator().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List<MeasurePassDelegate> getChildDelegates$ui_release() {
        getLayoutNode().updateChildrenIfDirty$ui_release();
        if (!this.childDelegatesDirty) {
            return this._childDelegates.asMutableList();
        }
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<MeasurePassDelegate> mutableVector = this._childDelegates;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (mutableVector.getSize() <= i) {
                mutableVector.add(layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
            } else {
                mutableVector.set(i, layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
            }
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
        this.childDelegatesDirty = false;
        return this._childDelegates.asMutableList();
    }

    /* renamed from: getChildDelegatesDirty$ui_release, reason: from getter */
    public final boolean getChildDelegatesDirty() {
        return this.childDelegatesDirty;
    }

    /* renamed from: getDuringAlignmentLinesQuery$ui_release, reason: from getter */
    public final boolean getDuringAlignmentLinesQuery() {
        return this.duringAlignmentLinesQuery;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator getInnerCoordinator() {
        return getLayoutNode().getInnerCoordinator$ui_release();
    }

    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m5807getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m6784boximpl(getMeasurementConstraints());
        }
        return null;
    }

    /* renamed from: getLastPosition-nOcc-ac$ui_release, reason: not valid java name and from getter */
    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode();
    }

    /* renamed from: getLayoutPending$ui_release, reason: from getter */
    public final boolean getLayoutPending() {
        return this.layoutPending;
    }

    public final LayoutNode.LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState();
    }

    /* renamed from: getMeasurePending$ui_release, reason: from getter */
    public final boolean getMeasurePending() {
        return this.measurePending;
    }

    /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
    public final LayoutNode.UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return getOuterCoordinator().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return getOuterCoordinator().getMeasuredWidth();
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutDelegate;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
            return null;
        }
        return layoutDelegate.getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    /* renamed from: getPerformMeasureBlock$ui_release, reason: from getter */
    public final a getPerformMeasureBlock() {
        return this.performMeasureBlock;
    }

    /* renamed from: getPlaceOrder$ui_release, reason: from getter */
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    public final boolean getPlacedOnce() {
        return this.placedOnce;
    }

    /* renamed from: getPreviousPlaceOrder$ui_release, reason: from getter */
    public final int getPreviousPlaceOrder() {
        return this.previousPlaceOrder;
    }

    /* renamed from: getZIndex$ui_release, reason: from getter */
    public final float getZIndex() {
        return this.zIndex;
    }

    public final void invalidateIntrinsicsParent(boolean forceRequest) {
        LayoutNode layoutNode;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        LayoutNode.UsageByParent intrinsicsUsageByParent = getLayoutNode().getIntrinsicsUsageByParent();
        if (parent$ui_release == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        do {
            layoutNode = parent$ui_release;
            if (layoutNode.getIntrinsicsUsageByParent() != intrinsicsUsageByParent) {
                break;
            } else {
                parent$ui_release = layoutNode.getParent$ui_release();
            }
        } while (parent$ui_release != null);
        int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
        if (i == 1) {
            LayoutNode.requestRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
        } else {
            if (i != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            layoutNode.requestRelayout$ui_release(forceRequest);
        }
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    /* renamed from: isPlaced, reason: from getter */
    public boolean getIsPlaced() {
        return this.isPlaced;
    }

    /* renamed from: isPlacedByParent, reason: from getter */
    public final boolean getIsPlacedByParent() {
        return this.isPlacedByParent;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void layoutChildren() {
        this.layingOutChildren = true;
        getAlignmentLines().recalculateQueryOwner();
        if (this.layoutPending) {
            onBeforeLayoutChildren();
        }
        if (this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().getIsPlacingForAlignment() && this.layoutPending)) {
            this.layoutPending = false;
            LayoutNode.LayoutState layoutState = getLayoutState();
            setLayoutState(LayoutNode.LayoutState.LayingOut);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode layoutNode = getLayoutNode();
            LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, false, this.layoutChildrenBlock);
            setLayoutState(layoutState);
            if (getInnerCoordinator().getIsPlacingForAlignment() && this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                requestLayout();
            }
            this.layoutPendingForAlignment = false;
        }
        if (getAlignmentLines().getUsedDuringParentLayout()) {
            getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui_release()) {
            getAlignmentLines().recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markDetachedFromParentLookaheadPass$ui_release() {
        this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPass$ui_release(true);
    }

    public final void markLayoutPending() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        if (!LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            onIntrinsicsQueried();
            return getOuterCoordinator().maxIntrinsicHeight(width);
        }
        LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        kotlin.jvm.internal.k.c(lookaheadPassDelegate);
        return lookaheadPassDelegate.maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        if (!LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            onIntrinsicsQueried();
            return getOuterCoordinator().maxIntrinsicWidth(height);
        }
        LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        kotlin.jvm.internal.k.c(lookaheadPassDelegate);
        return lookaheadPassDelegate.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public Placeable mo5549measureBRTryo0(long constraints) throws Throwable {
        LayoutNode.UsageByParent intrinsicsUsageByParent = getLayoutNode().getIntrinsicsUsageByParent();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        if (intrinsicsUsageByParent == usageByParent) {
            getLayoutNode().clearSubtreeIntrinsicsUsage$ui_release();
        }
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            kotlin.jvm.internal.k.c(lookaheadPassDelegate);
            lookaheadPassDelegate.setMeasuredByParent$ui_release(usageByParent);
            lookaheadPassDelegate.mo5549measureBRTryo0(constraints);
        }
        trackMeasurementByParent(getLayoutNode());
        m5810remeasureBRTryo0(constraints);
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        if (!LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            onIntrinsicsQueried();
            return getOuterCoordinator().minIntrinsicHeight(width);
        }
        LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        kotlin.jvm.internal.k.c(lookaheadPassDelegate);
        return lookaheadPassDelegate.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        if (!LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            onIntrinsicsQueried();
            return getOuterCoordinator().minIntrinsicWidth(height);
        }
        LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        kotlin.jvm.internal.k.c(lookaheadPassDelegate);
        return lookaheadPassDelegate.minIntrinsicWidth(height);
    }

    public final void notifyChildrenUsingCoordinatesWhilePlacing() {
        if (this.layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode = layoutNodeArr[i];
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if ((layoutDelegate.getCoordinatesAccessedDuringPlacement() || layoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLayoutPending$ui_release()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
    }

    public final void onNodeDetached() {
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        setPlaced$ui_release(false);
    }

    public final void onNodePlaced$ui_release() {
        this.onNodePlacedCalled = true;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        float zIndex = getInnerCoordinator().getZIndex();
        LayoutNode layoutNode = getLayoutNode();
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            kotlin.jvm.internal.k.d(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            zIndex += layoutModifierNodeCoordinator.getZIndex();
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped();
        }
        if (zIndex != this.zIndex) {
            this.zIndex = zIndex;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (getIsPlaced()) {
            getLayoutNode().getInnerCoordinator$ui_release().onPlaced();
        } else {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
            if (!(this.placeOrder == Integer.MAX_VALUE)) {
                InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
            }
            this.placeOrder = parent$ui_release.getLayoutDelegate().getNextChildPlaceOrder();
            LayoutNodeLayoutDelegate layoutDelegate = parent$ui_release.getLayoutDelegate();
            layoutDelegate.setNextChildPlaceOrder$ui_release(layoutDelegate.getNextChildPlaceOrder() + 1);
        }
        layoutChildren();
    }

    /* renamed from: performMeasure-BRTryo0$ui_release, reason: not valid java name */
    public final void m5809performMeasureBRTryo0$ui_release(long constraints) {
        LayoutNode.LayoutState layoutState = getLayoutState();
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
        if (!(layoutState == layoutState2)) {
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }
        this.performMeasureConstraints = constraints;
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
        setLayoutState(layoutState3);
        this.measurePending = false;
        LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(getLayoutNode(), false, this.performMeasureBlock);
        if (getLayoutState() == layoutState3) {
            markLayoutPending();
            setLayoutState(layoutState2);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5550placeAtf8xVGno(long position, float zIndex, k layerBlock) throws Throwable {
        m5806placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m5810remeasureBRTryo0(long constraints) throws Throwable {
        LayoutNode layoutNode = getLayoutNode();
        try {
            if (getLayoutNode().getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
            LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
            boolean z10 = true;
            getLayoutNode().setCanMultiMeasure$ui_release(getLayoutNode().getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
            if (!getLayoutNode().getMeasurePending$ui_release() && Constraints.m6790equalsimpl0(getMeasurementConstraints(), constraints)) {
                Owner.forceMeasureTheSubtree$default(ownerRequireOwner, getLayoutNode(), false, 2, null);
                getLayoutNode().resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.MeasurePassDelegate$remeasure$1$2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AlignmentLinesOwner) obj);
                    return r.f317a;
                }

                public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            long jMo5557getSizeYbymL2g = getOuterCoordinator().mo5557getSizeYbymL2g();
            m5616setMeasurementConstraintsBRTryo0(constraints);
            m5809performMeasureBRTryo0$ui_release(constraints);
            if (IntSize.m7013equalsimpl0(getOuterCoordinator().mo5557getSizeYbymL2g(), jMo5557getSizeYbymL2g) && getOuterCoordinator().getWidth() == getWidth() && getOuterCoordinator().getHeight() == getHeight()) {
                z10 = false;
            }
            m5615setMeasuredSizeozmzZPI(IntSize.m7010constructorimpl((getOuterCoordinator().getHeight() & 4294967295L) | (getOuterCoordinator().getWidth() << 32)));
            return z10;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    public final void replace() {
        MeasurePassDelegate measurePassDelegate;
        LayoutNode parent$ui_release;
        try {
            this.relayoutWithoutParentInProgress = true;
            if (!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            boolean isPlaced = getIsPlaced();
            measurePassDelegate = this;
            try {
                measurePassDelegate.m5805placeOuterCoordinatorMLgxB_4(this.lastPosition, this.lastZIndex, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !measurePassDelegate.onNodePlacedCalled && (parent$ui_release = measurePassDelegate.getLayoutNode().getParent$ui_release()) != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    measurePassDelegate.getLayoutNode().rethrowWithComposeStackTrace(th);
                    throw new KotlinNothingValueException();
                } finally {
                    measurePassDelegate.relayoutWithoutParentInProgress = false;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            measurePassDelegate = this;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestMeasure() {
        LayoutNode.requestRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
    }

    public final void setChildDelegatesDirty$ui_release(boolean z10) {
        this.childDelegatesDirty = z10;
    }

    public final void setDuringAlignmentLinesQuery$ui_release(boolean z10) {
        this.duringAlignmentLinesQuery = z10;
    }

    public final void setLayoutState(LayoutNode.LayoutState layoutState) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui_release(layoutState);
    }

    public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
        this.measuredByParent = usageByParent;
    }

    public void setPlaced$ui_release(boolean z10) {
        this.isPlaced = z10;
    }

    public final void setPlacedByParent$ui_release(boolean z10) {
        this.isPlacedByParent = z10;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z10) {
        this.isPlacedUnderMotionFrameOfReference = z10;
    }

    public final boolean updateParentData() {
        if ((getParentData() == null && getOuterCoordinator().getParentData() == null) || !this.parentDataDirty) {
            return false;
        }
        this.parentDataDirty = false;
        this.parentData = getOuterCoordinator().getParentData();
        return true;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        if (newMFR != getOuterCoordinator().getIsPlacedUnderMotionFrameOfReference()) {
            getOuterCoordinator().setPlacedUnderMotionFrameOfReference(newMFR);
            this.needsCoordinatesUpdate = true;
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5614placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) throws Throwable {
        m5806placeSelfMLgxB_4(position, zIndex, null, layer);
    }
}
