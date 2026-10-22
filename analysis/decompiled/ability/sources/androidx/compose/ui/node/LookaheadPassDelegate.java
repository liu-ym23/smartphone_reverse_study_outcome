package androidx.compose.ui.node;

import C7.r;
import K7.a;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ä\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010%\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b&\u0010'J\u0015\u0010+\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b)\u0010*J5\u00104\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t\u0018\u00010\u001aH\u0014¢\u0006\u0004\b2\u00103J'\u00104\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00106\u001a\u000205H\u0014¢\u0006\u0004\b2\u00107J\u0017\u00109\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0010H\u0016¢\u0006\u0004\b9\u0010\u0013J\u0018\u0010;\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u0016H\u0096\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0017H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0017H\u0016¢\u0006\u0004\b@\u0010?J\u0017\u0010B\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H\u0016¢\u0006\u0004\bB\u0010?J\u0017\u0010C\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H\u0016¢\u0006\u0004\bC\u0010?J\u0015\u0010E\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0010¢\u0006\u0004\bE\u0010\u0013J\r\u0010F\u001a\u00020\t¢\u0006\u0004\bF\u0010\u000bJ\r\u0010G\u001a\u00020\u0010¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020\tH\u0000¢\u0006\u0004\bI\u0010\u000bJ\r\u0010K\u001a\u00020\t¢\u0006\u0004\bK\u0010\u000bJ\r\u0010L\u001a\u00020\t¢\u0006\u0004\bL\u0010\u000bJ\r\u0010M\u001a\u00020\t¢\u0006\u0004\bM\u0010\u000bJ$\u0010N\u001a\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u001aH\u0082\b¢\u0006\u0004\bN\u0010\u001dJ\u000f\u0010O\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010\u000bJ\u0017\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ?\u0010V\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t\u0018\u00010\u001a2\b\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010W\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010\u000bJ\u000f\u0010X\u001a\u00020\tH\u0002¢\u0006\u0004\bX\u0010\u000bJ\u000f\u0010Y\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010\u000bJ\u000f\u0010Z\u001a\u00020\tH\u0002¢\u0006\u0004\bZ\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010[R\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\"\u0010`\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010_\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010]R\"\u0010m\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bm\u0010]\u001a\u0004\bn\u0010H\"\u0004\bo\u0010\u0013R\u0016\u0010p\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010]R\u0018\u0010q\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010w\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001d\u0010\u007f\u001a\u00020~8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u0086\u0001\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010]\u001a\u0005\b\u0087\u0001\u0010H\"\u0005\b\u0088\u0001\u0010\u0013R(\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010]\u001a\u0005\b\u008b\u0001\u0010HR\u0018\u0010\u008c\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010]R0\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0016@RX\u0096\u000e¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R&\u0010\u0092\u0001\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010]\u001a\u0005\b\u0092\u0001\u0010H\"\u0005\b\u0093\u0001\u0010\u0013R\u0018\u0010\u0094\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010]R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010\u009b\u0001\u001a\u0004\u0018\u00010!8F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010HR\u0018\u0010 \u0001\u001a\u00030\u009d\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0013\u0010¢\u0001\u001a\u00020\u00108F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010HR\u001e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000£\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010©\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u0016\u0010«\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010bR\u0016\u0010\u00ad\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010bR(\u0010°\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b®\u0001\u0010H\"\u0005\b¯\u0001\u0010\u0013R(\u0010³\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b±\u0001\u0010H\"\u0005\b²\u0001\u0010\u0013R(\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b´\u0001\u0010H\"\u0005\bµ\u0001\u0010\u0013R\u0017\u0010¹\u0001\u001a\u00020P8BX\u0082\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010»\u0001\u001a\u00030\u009d\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010\u009f\u0001R,\u0010Á\u0001\u001a\u00030¼\u00012\b\u0010\u0089\u0001\u001a\u00030¼\u00018B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u0016\u0010Ã\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010H¨\u0006Å\u0001"}, d2 = {"Landroidx/compose/ui/node/LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "layoutNodeLayoutDelegate", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "LC7/r;", "markLayoutPending$ui_release", "()V", "markLayoutPending", "markMeasurePending$ui_release", "markMeasurePending", "layoutChildren", "", "inLookahead", "markNodeAndSubtreeAsNotPlaced$ui_release", "(Z)V", "markNodeAndSubtreeAsNotPlaced", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "calculateAlignmentLines", "()Ljava/util/Map;", "Lkotlin/Function1;", "block", "forEachChildAlignmentLinesOwner", "(LS7/k;)V", "requestLayout", "requestMeasure", "notifyChildrenUsingLookaheadCoordinatesWhilePlacing", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "performMeasure-BRTryo0$ui_release", "(J)V", "performMeasure", "remeasure-BRTryo0", "(J)Z", "remeasure", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLS7/k;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "newMFR", "updatePlacedUnderMotionFrameOfReference", "alignmentLine", "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "forceRequest", "invalidateIntrinsicsParent", "invalidateParentData", "updateParentData", "()Z", "onNodePlaced$ui_release", "onNodePlaced", "replace", "onNodeDetached", "onAttachedToNullParent", "forEachChildDelegate", "checkChildrenPlaceOrderForUpdates", "Landroidx/compose/ui/node/LayoutNode;", "node", "trackLookaheadMeasurementByParent", "(Landroidx/compose/ui/node/LayoutNode;)V", "placeSelf-MLgxB_4", "(JFLS7/k;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "onIntrinsicsQueried", "clearPlaceOrder", "markNodeAndSubtreeAsPlaced", "onBeforeLayoutChildren", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "relayoutWithoutParentInProgress", "Z", "previousPlaceOrder", "I", "placeOrder", "getPlaceOrder$ui_release", "()I", "setPlaceOrder$ui_release", "(I)V", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "placedOnce", "getPlacedOnce$ui_release", "setPlacedOnce$ui_release", "measuredOnce", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lastPosition", "J", "lastZIndex", "F", "lastLayerBlock", "LS7/k;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "_placedState", "Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui_release", "setChildDelegatesDirty$ui_release", "value", "layingOutChildren", "getLayingOutChildren", "parentDataDirty", "", "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "onNodePlacedCalled", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "measurePassDelegate", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "isPlaced", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", "getNeedsToBePlacedInApproach", "needsToBePlacedInApproach", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegates", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "getMeasurePending", "setMeasurePending", "measurePending", "getLayoutPending", "setLayoutPending", "layoutPending", "getLayoutPendingForAlignment", "setLayoutPendingForAlignment", "layoutPendingForAlignment", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "getOuterCoordinator", "outerCoordinator", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "layoutState", "getDetachedFromParentLookaheadPlacement", "detachedFromParentLookaheadPlacement", "PlacedState", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public static final int $stable = 8;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private k lastLayerBlock;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private Constraints lookaheadConstraints;
    private boolean measuredOnce;
    private boolean onNodePlacedCalled;
    private boolean placedOnce;
    private boolean relayoutWithoutParentInProgress;
    private int previousPlaceOrder = Integer.MAX_VALUE;
    private int placeOrder = Integer.MAX_VALUE;
    private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    private long lastPosition = IntOffset.INSTANCE.m6983getZeronOccac();
    private PlacedState _placedState = PlacedState.IsNotPlaced;
    private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
    private final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16], 0);
    private boolean childDelegatesDirty = true;
    private boolean parentDataDirty = true;
    private Object parentData = getMeasurePassDelegate$ui_release().getParentData();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "IsPlacedInLookahead", "IsPlacedInApproach", "IsNotPlaced", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PlacedState {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ PlacedState[] $VALUES;
        public static final PlacedState IsPlacedInLookahead = new PlacedState("IsPlacedInLookahead", 0);
        public static final PlacedState IsPlacedInApproach = new PlacedState("IsPlacedInApproach", 1);
        public static final PlacedState IsNotPlaced = new PlacedState("IsNotPlaced", 2);

        private static final /* synthetic */ PlacedState[] $values() {
            return new PlacedState[]{IsPlacedInLookahead, IsPlacedInApproach, IsNotPlaced};
        }

        static {
            PlacedState[] placedStateArr$values = $values();
            $VALUES = placedStateArr$values;
            $ENTRIES = kotlin.enums.a.a(placedStateArr$values);
        }

        private PlacedState(String str, int i) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static PlacedState valueOf(String str) {
            return (PlacedState) Enum.valueOf(PlacedState.class, str);
        }

        public static PlacedState[] values() {
            return (PlacedState[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public LookaheadPassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildrenPlaceOrderForUpdates() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            kotlin.jvm.internal.k.c(lookaheadPassDelegate);
            int i6 = lookaheadPassDelegate.previousPlaceOrder;
            int i10 = lookaheadPassDelegate.placeOrder;
            if (i6 != i10 && i10 == Integer.MAX_VALUE) {
                lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui_release(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildLookaheadPlaceOrder$ui_release(0);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            kotlin.jvm.internal.k.c(lookaheadPassDelegate);
            lookaheadPassDelegate.previousPlaceOrder = lookaheadPassDelegate.placeOrder;
            lookaheadPassDelegate.placeOrder = Integer.MAX_VALUE;
            if (lookaheadPassDelegate.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                lookaheadPassDelegate.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
        }
    }

    private final void forEachChildDelegate(k block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
            kotlin.jvm.internal.k.c(lookaheadPassDelegate);
            block.invoke(lookaheadPassDelegate);
        }
    }

    private final boolean getDetachedFromParentLookaheadPlacement() {
        return this.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPlacement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode();
    }

    private final boolean getLayoutPending() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPending();
    }

    private final boolean getLayoutPendingForAlignment() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPendingForAlignment();
    }

    private final LayoutNode.LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState();
    }

    private final boolean getMeasurePending() {
        return this.layoutNodeLayoutDelegate.getLookaheadMeasurePending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    private final void markNodeAndSubtreeAsPlaced() {
        PlacedState placedState = this._placedState;
        if (getDetachedFromParentLookaheadPlacement()) {
            this._placedState = PlacedState.IsPlacedInApproach;
        } else {
            this._placedState = PlacedState.IsPlacedInLookahead;
        }
        if (placedState != PlacedState.IsPlacedInLookahead && this.layoutNodeLayoutDelegate.getLookaheadMeasurePending()) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), true, false, false, 6, null);
        }
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
            }
            if (lookaheadPassDelegate$ui_release.placeOrder != Integer.MAX_VALUE) {
                lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsPlaced();
                layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.getLookaheadMeasurePending$ui_release() && layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNode.getLayoutDelegate().getLookaheadPassDelegate();
                kotlin.jvm.internal.k.c(lookaheadPassDelegate);
                Constraints constraintsM5775getLastLookaheadConstraintsDWUhwKw = layoutNode.getLayoutDelegate().m5775getLastLookaheadConstraintsDWUhwKw();
                kotlin.jvm.internal.k.c(constraintsM5775getLastLookaheadConstraintsDWUhwKw);
                if (lookaheadPassDelegate.m5796remeasureBRTryo0(constraintsM5775getLastLookaheadConstraintsDWUhwKw.getValue())) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
                }
            }
        }
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || getLayoutNode().getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = getLayoutNode();
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
        layoutNode.setIntrinsicsUsageByParent$ui_release(i != 2 ? i != 3 ? parent$ui_release.getIntrinsicsUsageByParent() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m5793placeSelfMLgxB_4(final long position, float zIndex, k layerBlock, GraphicsLayer layer) throws Throwable {
        LayoutNode layoutNode = getLayoutNode();
        try {
            LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
            LayoutNode.LayoutState layoutState$ui_release = parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null;
            LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            if (layoutState$ui_release == layoutState) {
                this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui_release(false);
            }
            if (getLayoutNode().getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            setLayoutState(layoutState);
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            if (!IntOffset.m6971equalsimpl0(position, this.lastPosition)) {
                if (this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement()) {
                    setLayoutPending(true);
                }
                notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            final Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
            if (getLayoutPending() || !getIsPlaced()) {
                this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(ownerRequireOwner.getSnapshotObserver(), getLayoutNode(), false, new S7.a() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$placeSelf$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m5799invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m5799invoke() {
                        LookaheadDelegate lookaheadDelegate;
                        Placeable.PlacementScope placementScope = null;
                        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.this$0.getLayoutNode()) || this.this$0.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPlacement()) {
                            NodeCoordinator wrappedBy = this.this$0.getOuterCoordinator().getWrappedBy();
                            if (wrappedBy != null) {
                                placementScope = wrappedBy.getPlacementScope();
                            }
                        } else {
                            NodeCoordinator wrappedBy2 = this.this$0.getOuterCoordinator().getWrappedBy();
                            if (wrappedBy2 != null && (lookaheadDelegate = wrappedBy2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.getPlacementScope();
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ownerRequireOwner.getPlacementScope();
                        }
                        LookaheadPassDelegate lookaheadPassDelegate = this.this$0;
                        long j5 = position;
                        LookaheadDelegate lookaheadDelegate2 = lookaheadPassDelegate.getOuterCoordinator().getLookaheadDelegate();
                        kotlin.jvm.internal.k.c(lookaheadDelegate2);
                        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, lookaheadDelegate2, j5, 0.0f, 2, null);
                    }
                }, 2, null);
            } else {
                LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
                kotlin.jvm.internal.k.c(lookaheadDelegate);
                lookaheadDelegate.m5790placeSelfApparentToRealOffsetgyyYBs$ui_release(position);
                onNodePlaced$ui_release();
            }
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            this.lastExplicitLayer = layer;
            setLayoutState(LayoutNode.LayoutState.Idle);
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    private final void setLayoutPending(boolean z10) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPending$ui_release(z10);
    }

    private final void setLayoutPendingForAlignment(boolean z10) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPendingForAlignment$ui_release(z10);
    }

    private final void setLayoutState(LayoutNode.LayoutState layoutState) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui_release(layoutState);
    }

    private final void setMeasurePending(boolean z10) {
        this.layoutNodeLayoutDelegate.setLookaheadMeasurePending$ui_release(z10);
    }

    private final void trackLookaheadMeasurementByParent(LayoutNode node) {
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
        if (i == 1 || i == 2) {
            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else {
            if (i != 3 && i != 4) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
            }
            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        }
        this.measuredByParent = usageByParent;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map<AlignmentLine, Integer> calculateAlignmentLines() {
        if (!this.duringAlignmentLinesQuery) {
            if (getLayoutState() == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                if (getAlignmentLines().getDirty()) {
                    this.layoutNodeLayoutDelegate.markLookaheadLayoutPending$ui_release();
                }
            } else {
                getAlignmentLines().setUsedByModifierLayout$ui_release(true);
            }
        }
        LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            lookaheadDelegate.setPlacingForAlignment$ui_release(true);
        }
        layoutChildren();
        LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
        }
        return getAlignmentLines().getLastCalculation();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void forEachChildAlignmentLinesOwner(k block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeArr[i].getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
            kotlin.jvm.internal.k.c(lookaheadAlignmentLinesOwner$ui_release);
            block.invoke(lookaheadAlignmentLinesOwner$ui_release);
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
            getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = getLayoutNode().getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        int i = lookaheadDelegate.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List<LookaheadPassDelegate> getChildDelegates$ui_release() {
        getLayoutNode().getChildren$ui_release();
        if (!this.childDelegatesDirty) {
            return this._childDelegates.asMutableList();
        }
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<LookaheadPassDelegate> mutableVector = this._childDelegates;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (mutableVector.getSize() <= i) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                kotlin.jvm.internal.k.c(lookaheadPassDelegate);
                mutableVector.add(lookaheadPassDelegate);
            } else {
                LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                kotlin.jvm.internal.k.c(lookaheadPassDelegate2);
                mutableVector.set(i, lookaheadPassDelegate2);
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

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator getInnerCoordinator() {
        return getLayoutNode().getInnerCoordinator$ui_release();
    }

    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutNodeLayoutDelegate.getMeasurePassDelegate();
    }

    /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
    public final LayoutNode.UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.getMeasuredWidth();
    }

    public final boolean getNeedsToBePlacedInApproach() {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            return true;
        }
        if (this._placedState == PlacedState.IsNotPlaced && !this.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPass()) {
            this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui_release(true);
        }
        return getDetachedFromParentLookaheadPlacement();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutDelegate;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
            return null;
        }
        return layoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    /* renamed from: getPlaceOrder$ui_release, reason: from getter */
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    /* renamed from: getPlacedOnce$ui_release, reason: from getter */
    public final boolean getPlacedOnce() {
        return this.placedOnce;
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
            if (layoutNode.getLookaheadRoot() != null) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                return;
            } else {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                return;
            }
        }
        if (i != 2) {
            throw new IllegalStateException("Intrinsics isn't used by the parent");
        }
        if (layoutNode.getLookaheadRoot() != null) {
            layoutNode.requestLookaheadRelayout$ui_release(forceRequest);
        } else {
            layoutNode.requestRelayout$ui_release(forceRequest);
        }
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    /* renamed from: isPlaced */
    public boolean getIsPlaced() {
        return this._placedState != PlacedState.IsNotPlaced;
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
        if (getLayoutPending()) {
            onBeforeLayoutChildren();
        }
        final LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        if (getLayoutPendingForAlignment() || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.getIsPlacingForAlignment() && getLayoutPending())) {
            setLayoutPending(false);
            LayoutNode.LayoutState layoutState = getLayoutState();
            setLayoutState(LayoutNode.LayoutState.LookaheadLayingOut);
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
            this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(ownerRequireOwner.getSnapshotObserver(), getLayoutNode(), false, new S7.a() { // from class: androidx.compose.ui.node.LookaheadPassDelegate.layoutChildren.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5797invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5797invoke() {
                    LookaheadPassDelegate.this.clearPlaceOrder();
                    LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.LookaheadPassDelegate.layoutChildren.1.1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((AlignmentLinesOwner) obj);
                            return r.f317a;
                        }

                        public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                        }
                    });
                    LookaheadDelegate lookaheadDelegate2 = LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                    if (lookaheadDelegate2 != null) {
                        boolean isPlacingForAlignment = lookaheadDelegate2.getIsPlacingForAlignment();
                        List<LayoutNode> children$ui_release = LookaheadPassDelegate.this.getLayoutNode().getChildren$ui_release();
                        int size = children$ui_release.size();
                        for (int i = 0; i < size; i++) {
                            LookaheadDelegate lookaheadDelegate3 = children$ui_release.get(i).getOuterCoordinator$ui_release().getLookaheadDelegate();
                            if (lookaheadDelegate3 != null) {
                                lookaheadDelegate3.setPlacingForAlignment$ui_release(isPlacingForAlignment);
                            }
                        }
                    }
                    lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
                    LookaheadDelegate lookaheadDelegate4 = LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                    if (lookaheadDelegate4 != null) {
                        lookaheadDelegate4.getIsPlacingForAlignment();
                        List<LayoutNode> children$ui_release2 = LookaheadPassDelegate.this.getLayoutNode().getChildren$ui_release();
                        int size2 = children$ui_release2.size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            LookaheadDelegate lookaheadDelegate5 = children$ui_release2.get(i6).getOuterCoordinator$ui_release().getLookaheadDelegate();
                            if (lookaheadDelegate5 != null) {
                                lookaheadDelegate5.setPlacingForAlignment$ui_release(false);
                            }
                        }
                    }
                    LookaheadPassDelegate.this.checkChildrenPlaceOrderForUpdates();
                    LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.LookaheadPassDelegate.layoutChildren.1.4
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
            }, 2, null);
            setLayoutState(layoutState);
            if (this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement() && lookaheadDelegate.getIsPlacingForAlignment()) {
                requestLayout();
            }
            setLayoutPendingForAlignment(false);
        }
        if (getAlignmentLines().getUsedDuringParentLayout()) {
            getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui_release()) {
            getAlignmentLines().recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markLayoutPending$ui_release() {
        setLayoutPending(true);
        setLayoutPendingForAlignment(true);
    }

    public final void markMeasurePending$ui_release() {
        setMeasurePending(true);
    }

    public final void markNodeAndSubtreeAsNotPlaced$ui_release(boolean inLookahead) {
        if (inLookahead && getDetachedFromParentLookaheadPlacement()) {
            return;
        }
        if (inLookahead || getDetachedFromParentLookaheadPlacement()) {
            this._placedState = PlacedState.IsNotPlaced;
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[i].getLayoutDelegate().getLookaheadPassDelegate();
                kotlin.jvm.internal.k.c(lookaheadPassDelegate);
                lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui_release(true);
            }
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicWidth(height);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.Placeable mo5549measureBRTryo0(long r4) {
        /*
            r3 = this;
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            r1 = 0
            if (r0 == 0) goto L10
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.getLayoutState$ui_release()
            goto L11
        L10:
            r0 = r1
        L11:
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r0 == r2) goto L27
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L23
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.getLayoutState$ui_release()
        L23:
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r1 != r0) goto L2d
        L27:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r3.layoutNodeLayoutDelegate
            r1 = 0
            r0.setDetachedFromParentLookaheadPass$ui_release(r1)
        L2d:
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r3.trackLookaheadMeasurementByParent(r0)
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.getIntrinsicsUsageByParent()
            androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
            if (r0 != r1) goto L47
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r0.clearSubtreeIntrinsicsUsage$ui_release()
        L47:
            r3.m5796remeasureBRTryo0(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadPassDelegate.mo5549measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicWidth(height);
    }

    public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
        if (this.layoutNodeLayoutDelegate.getChildrenAccessingLookaheadCoordinatesDuringPlacement() > 0) {
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode = layoutNodeArr[i];
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if ((layoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement() || layoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLookaheadLayoutPending()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate lookaheadPassDelegate = layoutDelegate.getLookaheadPassDelegate();
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
            }
        }
    }

    public final void onAttachedToNullParent() {
        this._placedState = PlacedState.IsPlacedInLookahead;
    }

    public final void onNodeDetached() {
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this._placedState = PlacedState.IsNotPlaced;
    }

    public final void onNodePlaced$ui_release() {
        this.onNodePlacedCalled = true;
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if ((this._placedState != PlacedState.IsPlacedInLookahead && !getDetachedFromParentLookaheadPlacement()) || (this._placedState != PlacedState.IsPlacedInApproach && getDetachedFromParentLookaheadPlacement())) {
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
            }
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut || parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut)) {
            if (!(this.placeOrder == Integer.MAX_VALUE)) {
                InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
            }
            this.placeOrder = parent$ui_release.getLayoutDelegate().getNextChildLookaheadPlaceOrder();
            LayoutNodeLayoutDelegate layoutDelegate = parent$ui_release.getLayoutDelegate();
            layoutDelegate.setNextChildLookaheadPlaceOrder$ui_release(layoutDelegate.getNextChildLookaheadPlaceOrder() + 1);
        }
        layoutChildren();
    }

    /* renamed from: performMeasure-BRTryo0$ui_release, reason: not valid java name */
    public final void m5795performMeasureBRTryo0$ui_release(final long constraints) {
        setLayoutState(LayoutNode.LayoutState.LookaheadMeasuring);
        setMeasurePending(false);
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver(), getLayoutNode(), false, new S7.a() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$performMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5798invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5798invoke() {
                LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
                kotlin.jvm.internal.k.c(lookaheadDelegate);
                lookaheadDelegate.mo5549measureBRTryo0(constraints);
            }
        }, 2, null);
        markLayoutPending$ui_release();
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            getMeasurePassDelegate$ui_release().markLayoutPending();
        } else {
            getMeasurePassDelegate$ui_release().markMeasurePending$ui_release();
        }
        setLayoutState(LayoutNode.LayoutState.Idle);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5550placeAtf8xVGno(long position, float zIndex, k layerBlock) throws Throwable {
        m5793placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m5796remeasureBRTryo0(long constraints) throws Throwable {
        long jM7010constructorimpl;
        LayoutNode layoutNode = getLayoutNode();
        try {
            if (getLayoutNode().getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
            getLayoutNode().setCanMultiMeasure$ui_release(getLayoutNode().getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
            if (!getLayoutNode().getLookaheadMeasurePending$ui_release()) {
                Constraints constraints2 = this.lookaheadConstraints;
                if (constraints2 == null ? false : Constraints.m6790equalsimpl0(constraints2.getValue(), constraints)) {
                    Owner owner = getLayoutNode().getOwner();
                    if (owner != null) {
                        owner.forceMeasureTheSubtree(getLayoutNode(), true);
                    }
                    getLayoutNode().resetSubtreeIntrinsicsUsage$ui_release();
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m6784boximpl(constraints);
            m5616setMeasurementConstraintsBRTryo0(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new k() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$remeasure$1$2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AlignmentLinesOwner) obj);
                    return r.f317a;
                }

                public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            if (this.measuredOnce) {
                jM7010constructorimpl = getMeasuredSize();
            } else {
                long j5 = Integer.MIN_VALUE;
                jM7010constructorimpl = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
            }
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
            if (!(lookaheadDelegate != null)) {
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }
            this.layoutNodeLayoutDelegate.m5776performLookaheadMeasureBRTryo0$ui_release(constraints);
            m5615setMeasuredSizeozmzZPI(IntSize.m7010constructorimpl((lookaheadDelegate.getHeight() & 4294967295L) | (lookaheadDelegate.getWidth() << 32)));
            return (((int) (jM7010constructorimpl >> 32)) == lookaheadDelegate.getWidth() && ((int) (jM7010constructorimpl & 4294967295L)) == lookaheadDelegate.getHeight()) ? false : true;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    public final void replace() {
        LookaheadPassDelegate lookaheadPassDelegate;
        LayoutNode parent$ui_release;
        try {
            this.relayoutWithoutParentInProgress = true;
            if (!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }
            this.onNodePlacedCalled = false;
            boolean isPlaced = getIsPlaced();
            lookaheadPassDelegate = this;
            try {
                lookaheadPassDelegate.m5793placeSelfMLgxB_4(this.lastPosition, 0.0f, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !lookaheadPassDelegate.onNodePlacedCalled && (parent$ui_release = lookaheadPassDelegate.getLayoutNode().getParent$ui_release()) != null) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
                lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
            } catch (Throwable th) {
                th = th;
                lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lookaheadPassDelegate = this;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.requestLookaheadRelayout$ui_release$default(getLayoutNode(), false, 1, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestMeasure() {
        LayoutNode.requestLookaheadRemeasure$ui_release$default(getLayoutNode(), false, false, false, 7, null);
    }

    public final void setChildDelegatesDirty$ui_release(boolean z10) {
        this.childDelegatesDirty = z10;
    }

    public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
        this.measuredByParent = usageByParent;
    }

    public final void setPlaceOrder$ui_release(int i) {
        this.placeOrder = i;
    }

    public final void setPlacedOnce$ui_release(boolean z10) {
        this.placedOnce = z10;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z10) {
        this.isPlacedUnderMotionFrameOfReference = z10;
    }

    public final boolean updateParentData() {
        if (getParentData() == null) {
            LookaheadDelegate lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate();
            kotlin.jvm.internal.k.c(lookaheadDelegate);
            if (lookaheadDelegate.getParentData() == null) {
                return false;
            }
        }
        if (!this.parentDataDirty) {
            return false;
        }
        this.parentDataDirty = false;
        LookaheadDelegate lookaheadDelegate2 = getOuterCoordinator().getLookaheadDelegate();
        kotlin.jvm.internal.k.c(lookaheadDelegate2);
        this.parentData = lookaheadDelegate2.getParentData();
        return true;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        LookaheadDelegate lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate2 = getOuterCoordinator().getLookaheadDelegate();
        if (!Boolean.valueOf(newMFR).equals(lookaheadDelegate2 != null ? Boolean.valueOf(lookaheadDelegate2.getIsPlacedUnderMotionFrameOfReference()) : null) && (lookaheadDelegate = getOuterCoordinator().getLookaheadDelegate()) != null) {
            lookaheadDelegate.setPlacedUnderMotionFrameOfReference(newMFR);
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5614placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) throws Throwable {
        m5793placeSelfMLgxB_4(position, zIndex, null, layer);
    }
}
