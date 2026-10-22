package androidx.compose.ui.layout;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import X6.h;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.SubcompositionKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u0006\u0088\u0001\u0089\u0001\u008a\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ'\u0010!\u001a\u00020 2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001b¢\u0006\u0004\b!\u0010\"J*\u0010$\u001a\u00020#2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0004\b$\u0010%J*\u0010'\u001a\u00020&2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\b¢\u0006\u0004\b)\u0010\nJ<\u0010\u0014\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020+2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0004\b\u0014\u0010-J'\u0010\u0014\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b\u0014\u00100J'\u00103\u001a\u0004\u0018\u00010\r2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u00102\u001a\u00020\u0016H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\b*\u00020.2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020+H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\nJ\u0013\u0010=\u001a\u00020\b*\u00020\u0002H\u0002¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\nJ(\u0010D\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u001e2\u000e\b\u0004\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0082\b¢\u0006\u0004\bD\u0010EJ4\u0010$\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b$\u0010FJ\u001b\u0010H\u001a\u00020\b*\u00020.2\u0006\u0010G\u001a\u00020+H\u0002¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00020\b*\u00020.H\u0002¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\bL\u0010MJ\u0019\u0010N\u001a\u00020#2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0016H\u0002¢\u0006\u0004\bP\u0010QJ)\u0010U\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00162\b\b\u0002\u0010T\u001a\u00020\u0016H\u0002¢\u0006\u0004\bU\u0010VJ$\u0010X\u001a\u00028\u0000\"\u0004\b\u0000\u0010W2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0082\b¢\u0006\u0004\bX\u0010YJ\u001b\u0010[\u001a\u00020\b*\u00020.2\u0006\u0010Z\u001a\u00020+H\u0002¢\u0006\u0004\b[\u0010IJ2\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0004\b\\\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR*\u0010\u0005\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010lR \u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\"\u0010q\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010pR\u0018\u0010s\u001a\u00060rR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u00060uR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\"\u0010x\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010pR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\"\u0010|\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020#0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010pR\u001c\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010lR\u0018\u0010\u0081\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010lR\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082D¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0087\u0001\u001a\u0004\u0018\u0001058BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008b\u0001"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/LayoutNode;", "root", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "slotReusePolicy", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "LC7/r;", "onReuse", "()V", "onDeactivate", "onRelease", "", "slotId", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose", "(Ljava/lang/Object;LS7/n;)Ljava/util/List;", "", "startIndex", "disposeOrReuseStartingFromIndex", "(I)V", "makeSureStateIsConsistent", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "block", "Landroidx/compose/ui/layout/MeasurePolicy;", "createMeasurePolicy", "(LS7/n;)Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "precompose", "(Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "precomposePaused", "(Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "node", "", "pausable", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;ZLS7/n;)V", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;Z)V", "foldedChildren", "index", "getSlotIdAtIndex", "(Ljava/util/List;I)Ljava/lang/Object;", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "executor", "deactivateOutOfFrame", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;Landroidx/compose/ui/node/OutOfFrameExecutor;)V", "deactivate", "markActiveNodesAsReused", "(Z)V", "disposeCurrentNodes", "resetLayoutState", "(Landroidx/compose/ui/node/LayoutNode;)V", "takeNodeFromReusables", "(Ljava/lang/Object;)Landroidx/compose/ui/node/LayoutNode;", "disposeUnusedSlotsInApproach", "result", "placeChildrenBlock", "createMeasureResult", "(Landroidx/compose/ui/layout/MeasureResult;LS7/a;)Landroidx/compose/ui/layout/MeasureResult;", "(Ljava/lang/Object;LS7/n;Z)V", "forceDeactivate", "reuseComposition", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;Z)V", "cancelPausedPrecomposition", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;)V", "disposePrecomposedSlot", "(Ljava/lang/Object;)V", "createPrecomposedSlotHandle", "(Ljava/lang/Object;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "createNodeAt", "(I)Landroidx/compose/ui/node/LayoutNode;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "count", "move", "(III)V", ExifInterface.GPS_DIRECTION_TRUE, "ignoreRemeasureRequests", "(LS7/a;)Ljava/lang/Object;", "shouldComplete", "applyPausedPrecomposition", "approachSubcompose", "Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "value", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "currentIndex", "I", "currentApproachIndex", "Landroidx/collection/MutableScatterMap;", "nodeToNodeState", "Landroidx/collection/MutableScatterMap;", "slotIdToNode", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "approachMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "precomposeMap", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "approachPrecomposeSlotHandleMap", "Landroidx/compose/runtime/collection/MutableVector;", "approachComposedSlotIds", "Landroidx/compose/runtime/collection/MutableVector;", "reusableCount", "precomposedCount", "", "NoIntrinsicsMessage", "Ljava/lang/String;", "getOutOfFrameExecutor", "()Landroidx/compose/ui/node/OutOfFrameExecutor;", "outOfFrameExecutor", "NodeState", "Scope", "ApproachMeasureScopeImpl", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    public static final int $stable = 8;
    private CompositionContext compositionContext;
    private int currentApproachIndex;
    private int currentIndex;
    private int precomposedCount;
    private int reusableCount;
    private final LayoutNode root;
    private SubcomposeSlotReusePolicy slotReusePolicy;
    private final MutableScatterMap<LayoutNode, NodeState> nodeToNodeState = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterMap<Object, LayoutNode> slotIdToNode = ScatterMapKt.mutableScatterMapOf();
    private final Scope scope = new Scope();
    private final ApproachMeasureScopeImpl approachMeasureScope = new ApproachMeasureScopeImpl();
    private final MutableScatterMap<Object, LayoutNode> precomposeMap = ScatterMapKt.mutableScatterMapOf();
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, 0 == true ? 1 : 0);
    private final MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> approachPrecomposeSlotHandleMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector<Object> approachComposedSlotIds = new MutableVector<>(new Object[16], 0);
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ^\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u00122\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001dJ\u0014\u0010\"\u001a\u00020\u001f*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b \u0010!J\u0014\u0010\"\u001a\u00020\u001f*\u00020#H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0014\u0010(\u001a\u00020\u000f*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u00020\u000f*\u00020#H\u0097\u0001¢\u0006\u0004\b)\u0010*J\u0014\u0010-\u001a\u00020\u001e*\u00020\u000fH\u0097\u0001¢\u0006\u0004\b+\u0010,J\u0014\u0010-\u001a\u00020\u001e*\u00020\u001fH\u0097\u0001¢\u0006\u0004\b+\u0010!J\u0014\u0010-\u001a\u00020\u001e*\u00020#H\u0097\u0001¢\u0006\u0004\b.\u0010%J\u0014\u00101\u001a\u00020#*\u00020\u000fH\u0097\u0001¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020#*\u00020\u001fH\u0097\u0001¢\u0006\u0004\b/\u00102J\u0014\u00101\u001a\u00020#*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b3\u00102J\u0014\u00106\u001a\u000205*\u000204H\u0097\u0001¢\u0006\u0004\b6\u00107J\u0014\u0010<\u001a\u000209*\u000208H\u0097\u0001¢\u0006\u0004\b:\u0010;J\u0014\u0010>\u001a\u000208*\u000209H\u0097\u0001¢\u0006\u0004\b=\u0010;R\u0014\u0010B\u001a\u00020?8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020C8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u001f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u001f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bI\u0010G¨\u0006K"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "", "slotId", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose", "(Ljava/lang/Object;LS7/n;)Ljava/util/List;", "", "width", "height", "", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;LS7/k;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "(IILjava/util/Map;LS7/k;LS7/k;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/Dp;", "", "toPx-0680j_4", "(F)F", "toPx", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx-0680j_4", "(F)I", "roundToPx", "roundToPx--R2X_6o", "(J)I", "toDp-u2uoSUM", "(I)F", "toDp", "toDp-GaN1DYA", "toSp-kPz2Gy4", "(I)J", "toSp", "(F)J", "toSp-0xMU5do", "Landroidx/compose/ui/unit/DpRect;", "Landroidx/compose/ui/geometry/Rect;", "toRect", "(Landroidx/compose/ui/unit/DpRect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toSize-XkaWNTQ", "(J)J", "toSize", "toDpSize-k-rfVVM", "toDpSize", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "isLookingAhead", "()Z", "getDensity", "()F", "density", "getFontScale", "fontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ApproachMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;

        public ApproachMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, k placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: roundToPx--R2X_6o */
        public int mo374roundToPxR2X_6o(long j5) {
            return this.$$delegate_0.mo374roundToPxR2X_6o(j5);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: roundToPx-0680j_4 */
        public int mo375roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo375roundToPx0680j_4(f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, n content) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(slotId);
            return (layoutNode == null || LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().indexOf(layoutNode) >= LayoutNodeSubcompositionsState.this.currentIndex) ? LayoutNodeSubcompositionsState.this.approachSubcompose(slotId, content) : layoutNode.getChildMeasurables$ui_release();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        @Stable
        /* renamed from: toDp-GaN1DYA */
        public float mo376toDpGaN1DYA(long j5) {
            return this.$$delegate_0.mo376toDpGaN1DYA(j5);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDp-u2uoSUM */
        public float mo377toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo377toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDpSize-k-rfVVM */
        public long mo379toDpSizekrfVVM(long j5) {
            return this.$$delegate_0.mo379toDpSizekrfVVM(j5);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toPx--R2X_6o */
        public float mo380toPxR2X_6o(long j5) {
            return this.$$delegate_0.mo380toPxR2X_6o(j5);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toPx-0680j_4 */
        public float mo381toPx0680j_4(float f) {
            return this.$$delegate_0.mo381toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSize-XkaWNTQ */
        public long mo382toSizeXkaWNTQ(long j5) {
            return this.$$delegate_0.mo382toSizeXkaWNTQ(j5);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        @Stable
        /* renamed from: toSp-0xMU5do */
        public long mo383toSp0xMU5do(float f) {
            return this.$$delegate_0.mo383toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSp-kPz2Gy4 */
        public long mo384toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo384toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, k rulers, k placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, rulers, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDp-u2uoSUM */
        public float mo378toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo378toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSp-kPz2Gy4 */
        public long mo385toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo385toSpkPz2Gy4(i);
        }
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\f\u0010\rJ]\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0014\u0010.\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "", "slotId", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose", "(Ljava/lang/Object;LS7/n;)Ljava/util/List;", "", "width", "height", "", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;LS7/k;LS7/k;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "", "density", "F", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "", "isLookingAhead", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final k rulers, final k placementBlock) {
            if (!((width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0)) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getHeight, reason: from getter */
                public int get$height() {
                    return height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getRulers, reason: from getter */
                public k get$rulers() {
                    return rulers;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getWidth, reason: from getter */
                public int get$width() {
                    return width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    LookaheadDelegate lookaheadDelegate;
                    if (!this.isLookingAhead() || (lookaheadDelegate = layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getLookaheadDelegate()) == null) {
                        placementBlock.invoke(layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getPlacementScope());
                    } else {
                        placementBlock.invoke(lookaheadDelegate.getPlacementScope());
                    }
                }
            };
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, n content) {
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPausedPrecomposition(NodeState nodeState, boolean z10) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                LayoutNode layoutNode = this.root;
                layoutNode.ignoreRemeasureRequests = true;
                if (z10) {
                    while (!pausedComposition.isComplete()) {
                        pausedComposition.resume(new h(18));
                    }
                }
                pausedComposition.apply();
                nodeState.setPausedComposition(null);
                layoutNode.ignoreRemeasureRequests = false;
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            } catch (Throwable th) {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyPausedPrecomposition$lambda$28$lambda$27$lambda$26() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Measurable> approachSubcompose(Object slotId, n content) {
        if (!(this.approachComposedSlotIds.getSize() >= this.currentApproachIndex)) {
            InlineClassHelperKt.throwIllegalArgumentException("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        int size = this.approachComposedSlotIds.getSize();
        int i = this.currentApproachIndex;
        if (size == i) {
            this.approachComposedSlotIds.add(slotId);
        } else {
            this.approachComposedSlotIds.set(i, slotId);
        }
        this.currentApproachIndex++;
        if (this.precomposeMap.contains(slotId)) {
            LayoutNode layoutNode = this.precomposeMap.get(slotId);
            NodeState nodeState = layoutNode != null ? this.nodeToNodeState.get(layoutNode) : null;
            if (nodeState != null && nodeState.getForceRecompose()) {
                subcompose(layoutNode, slotId, false, content);
            }
        } else {
            this.approachPrecomposeSlotHandleMap.set(slotId, precompose(slotId, content));
            if (this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                this.root.requestLookaheadRelayout$ui_release(true);
            } else {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(this.root, true, false, false, 6, null);
            }
        }
        LayoutNode layoutNode2 = this.precomposeMap.get(slotId);
        if (layoutNode2 != null) {
            List<MeasurePassDelegate> childDelegates$ui_release = layoutNode2.getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
            int size2 = childDelegates$ui_release.size();
            for (int i6 = 0; i6 < size2; i6++) {
                childDelegates$ui_release.get(i6).markDetachedFromParentLookaheadPass$ui_release();
            }
            if (childDelegates$ui_release != null) {
                return childDelegates$ui_release;
            }
        }
        return EmptyList.f4893a;
    }

    private final void cancelPausedPrecomposition(NodeState nodeState) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            pausedComposition.cancel();
            nodeState.setPausedComposition(null);
            ReusableComposition composition = nodeState.getComposition();
            if (composition != null) {
                composition.dispose();
            }
            nodeState.setComposition(null);
        }
    }

    private final MeasureResult createMeasureResult(final MeasureResult result, final a placeChildrenBlock) {
        return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createMeasureResult.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return result.getAlignmentLines();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getHeight */
            public int get$height() {
                return result.get$height();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getRulers */
            public k get$rulers() {
                return result.get$rulers();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getWidth */
            public int get$width() {
                return result.get$width();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placeChildrenBlock.invoke();
            }
        };
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, layoutNode);
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle(final Object slotId) {
        return !this.root.isAttached() ? new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createPrecomposedSlotHandle.1
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
            }
        } : new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createPrecomposedSlotHandle.2
            private final MutableIntSet hasPremeasured = IntSetKt.mutableIntSetOf();

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(slotId);
            }

            public final MutableIntSet getHasPremeasured() {
                return this.hasPremeasured;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                List<LayoutNode> children$ui_release;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
                    return 0;
                }
                return children$ui_release.size();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: getSize-YEO4UFw, reason: not valid java name */
            public long mo5575getSizeYEO4UFw(int index) {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode != null && layoutNode.isAttached()) {
                    int size = layoutNode.getChildren$ui_release().size();
                    if (index < 0 || index >= size) {
                        InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                    }
                    if (this.hasPremeasured.contains(index)) {
                        int width = layoutNode.getChildren$ui_release().get(index).getWidth();
                        return IntSize.m7010constructorimpl((layoutNode.getChildren$ui_release().get(index).getHeight() & 4294967295L) | (width << 32));
                    }
                }
                return IntSize.INSTANCE.m7020getZeroYbymL2g();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
            public void mo5576premeasure0kLqBqw(int index, long constraints) {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || !layoutNode.isAttached()) {
                    return;
                }
                int size = layoutNode.getChildren$ui_release().size();
                if (index < 0 || index >= size) {
                    InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                }
                if (layoutNode.isPlaced()) {
                    InlineClassHelperKt.throwIllegalArgumentException("Pre-measure called on node that is not placed");
                }
                LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.root;
                layoutNode2.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(layoutNode).mo5925measureAndLayout0kLqBqw(layoutNode.getChildren$ui_release().get(index), constraints);
                layoutNode2.ignoreRemeasureRequests = false;
                this.hasPremeasured.add(index);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void traverseDescendants(Object key, k block) {
                NodeChain nodes;
                Modifier.Node head;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (nodes = layoutNode.getNodes()) == null || (head = nodes.getHead()) == null) {
                    return;
                }
                TraversableNodeKt.traverseDescendants(head, key, block);
            }
        };
    }

    private final void deactivateOutOfFrame(final NodeState nodeState, OutOfFrameExecutor outOfFrameExecutor) {
        outOfFrameExecutor.schedule(new a() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.deactivateOutOfFrame.1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m5577invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5577invoke() {
                ReusableComposition composition;
                if (nodeState.getActive() || (composition = nodeState.getComposition()) == null) {
                    return;
                }
                composition.deactivate();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void disposeCurrentNodes() {
        /*
            r15 = this;
            androidx.compose.ui.node.LayoutNode r0 = r15.root
            r1 = 1
            androidx.compose.ui.node.LayoutNode.access$setIgnoreRemeasureRequests$p(r0, r1)
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r1 = r15.nodeToNodeState
            java.lang.Object[] r2 = r1.values
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L53
            r5 = r4
        L13:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L4e
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2d:
            if (r10 >= r8) goto L4c
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L48
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r11 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r11
            androidx.compose.runtime.ReusableComposition r11 = r11.getComposition()
            if (r11 == 0) goto L48
            r11.dispose()
        L48:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2d
        L4c:
            if (r8 != r9) goto L53
        L4e:
            if (r5 == r3) goto L53
            int r5 = r5 + 1
            goto L13
        L53:
            androidx.compose.ui.node.LayoutNode r1 = r15.root
            r1.removeAll$ui_release()
            androidx.compose.ui.node.LayoutNode.access$setIgnoreRemeasureRequests$p(r0, r4)
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r0 = r15.nodeToNodeState
            r0.clear()
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r0 = r15.slotIdToNode
            r0.clear()
            r15.precomposedCount = r4
            r15.reusableCount = r4
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r0 = r15.precomposeMap
            r0.clear()
            r15.makeSureStateIsConsistent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.disposeCurrentNodes():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposePrecomposedSlot(Object slotId) {
        makeSureStateIsConsistent();
        LayoutNode layoutNodeRemove = this.precomposeMap.remove(slotId);
        if (layoutNodeRemove != null) {
            if (!(this.precomposedCount > 0)) {
                InlineClassHelperKt.throwIllegalStateException("No pre-composed items to dispose");
            }
            int iIndexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNodeRemove);
            if (!(iIndexOf >= this.root.getFoldedChildren$ui_release().size() - this.precomposedCount)) {
                InlineClassHelperKt.throwIllegalStateException("Item is not in pre-composed item range");
            }
            this.reusableCount++;
            this.precomposedCount--;
            NodeState nodeState = this.nodeToNodeState.get(layoutNodeRemove);
            if (nodeState != null) {
                cancelPausedPrecomposition(nodeState);
            }
            int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - this.reusableCount;
            move(iIndexOf, size, 1);
            disposeOrReuseStartingFromIndex(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeUnusedSlotsInApproach() {
        MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> mutableScatterMap = this.approachPrecomposeSlotHandleMap;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = mutableScatterMap.keys[i11];
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i11];
                        int iIndexOf = this.approachComposedSlotIds.indexOf(obj);
                        if (iIndexOf < 0 || iIndexOf >= this.currentApproachIndex) {
                            precomposedSlotHandle.dispose();
                            mutableScatterMap.removeValueAt(i11);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final OutOfFrameExecutor getOutOfFrameExecutor() {
        if (ComposeUiFlags.isOutOfFrameDeactivationEnabled) {
            return LayoutNodeKt.requireOwner(this.root).getOutOfFrameExecutor();
        }
        return null;
    }

    private final Object getSlotIdAtIndex(List<LayoutNode> foldedChildren, int index) {
        NodeState nodeState = this.nodeToNodeState.get(foldedChildren.get(index));
        kotlin.jvm.internal.k.c(nodeState);
        return nodeState.getSlotId();
    }

    private final <T> T ignoreRemeasureRequests(a block) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        T t9 = (T) block.invoke();
        layoutNode.ignoreRemeasureRequests = false;
        return t9;
    }

    private final void markActiveNodesAsReused(boolean deactivate) {
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = foldedChildren$ui_release.size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            for (int i = 0; i < size; i++) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui_release.get(i);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && nodeState.getActive()) {
                        resetLayoutState(layoutNode);
                        reuseComposition(nodeState, deactivate);
                        nodeState.setSlotId(SubcomposeLayoutKt.ReusedSlotId);
                    }
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    private final void move(int from, int to, int count) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        layoutNode.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i6, i10);
    }

    private final void resetLayoutState(LayoutNode layoutNode) {
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        measurePassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
        }
    }

    private final void reuseComposition(NodeState nodeState, boolean z10) {
        ReusableComposition composition;
        if (z10 || !nodeState.getComposedWithReusableContentHost()) {
            nodeState.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null));
        } else {
            nodeState.setActive(false);
        }
        if (nodeState.getPausedComposition() != null) {
            cancelPausedPrecomposition(nodeState);
            return;
        }
        if (z10) {
            ReusableComposition composition2 = nodeState.getComposition();
            if (composition2 != null) {
                composition2.deactivate();
                return;
            }
            return;
        }
        OutOfFrameExecutor outOfFrameExecutor = getOutOfFrameExecutor();
        if (outOfFrameExecutor != null) {
            deactivateOutOfFrame(nodeState, outOfFrameExecutor);
        } else {
            if (nodeState.getComposedWithReusableContentHost() || (composition = nodeState.getComposition()) == null) {
                return;
            }
            composition.deactivate();
        }
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = foldedChildren$ui_release.size() - this.precomposedCount;
        int i6 = size - this.reusableCount;
        int i10 = size - 1;
        int i11 = i10;
        while (true) {
            if (i11 < i6) {
                i = -1;
                break;
            }
            if (kotlin.jvm.internal.k.b(getSlotIdAtIndex(foldedChildren$ui_release, i11), slotId)) {
                i = i11;
                break;
            }
            i11--;
        }
        if (i == -1) {
            while (i10 >= i6) {
                NodeState nodeState = this.nodeToNodeState.get(foldedChildren$ui_release.get(i10));
                kotlin.jvm.internal.k.c(nodeState);
                NodeState nodeState2 = nodeState;
                if (nodeState2.getSlotId() == SubcomposeLayoutKt.ReusedSlotId || this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    i11 = i10;
                    i = i11;
                    break;
                }
                i10--;
            }
            i11 = i10;
        }
        if (i == -1) {
            return null;
        }
        if (i11 != i6) {
            move(i11, i6, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = foldedChildren$ui_release.get(i6);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        kotlin.jvm.internal.k.c(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null));
        nodeState4.setForceReuse(true);
        nodeState4.setForceRecompose(true);
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(final n block) {
        return new LayoutNode.NoIntrinsicsMeasurePolicy(this.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                LayoutNodeSubcompositionsState.this.scope.setLayoutDirection(measureScope.getLayoutDirection());
                LayoutNodeSubcompositionsState.this.scope.setDensity(measureScope.getDensity());
                LayoutNodeSubcompositionsState.this.scope.setFontScale(measureScope.getFontScale());
                if (measureScope.isLookingAhead() || LayoutNodeSubcompositionsState.this.root.getLookaheadRoot() == null) {
                    LayoutNodeSubcompositionsState.this.currentIndex = 0;
                    final MeasureResult measureResult = (MeasureResult) block.invoke(LayoutNodeSubcompositionsState.this.scope, Constraints.m6784boximpl(j5));
                    final int i = LayoutNodeSubcompositionsState.this.currentIndex;
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return measureResult.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getHeight */
                        public int get$height() {
                            return measureResult.get$height();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getRulers */
                        public k get$rulers() {
                            return measureResult.get$rulers();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getWidth */
                        public int get$width() {
                            return measureResult.get$width();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            layoutNodeSubcompositionsState.currentIndex = i;
                            measureResult.placeChildren();
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                            layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState2.currentIndex);
                        }
                    };
                }
                LayoutNodeSubcompositionsState.this.currentApproachIndex = 0;
                final MeasureResult measureResult2 = (MeasureResult) block.invoke(LayoutNodeSubcompositionsState.this.approachMeasureScope, Constraints.m6784boximpl(j5));
                final int i6 = LayoutNodeSubcompositionsState.this.currentApproachIndex;
                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Map<AlignmentLine, Integer> getAlignmentLines() {
                        return measureResult2.getAlignmentLines();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getHeight */
                    public int get$height() {
                        return measureResult2.get$height();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getRulers */
                    public k get$rulers() {
                        return measureResult2.get$rulers();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getWidth */
                    public int get$width() {
                        return measureResult2.get$width();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public void placeChildren() {
                        layoutNodeSubcompositionsState2.currentApproachIndex = i6;
                        measureResult2.placeChildren();
                        layoutNodeSubcompositionsState2.disposeUnusedSlotsInApproach();
                    }
                };
            }
        };
    }

    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        boolean z10 = false;
        this.reusableCount = 0;
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = (foldedChildren$ui_release.size() - this.precomposedCount) - 1;
        if (startIndex <= size) {
            this.reusableSlotIdsSet.clear();
            if (startIndex <= size) {
                int i = startIndex;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(foldedChildren$ui_release, i));
                    if (i == size) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            boolean z11 = false;
            while (size >= startIndex) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui_release.get(size);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    kotlin.jvm.internal.k.c(nodeState);
                    NodeState nodeState2 = nodeState;
                    Object slotId = nodeState2.getSlotId();
                    if (this.reusableSlotIdsSet.contains(slotId)) {
                        this.reusableCount++;
                        if (nodeState2.getActive()) {
                            resetLayoutState(layoutNode);
                            reuseComposition(nodeState2, false);
                            if (nodeState2.getComposedWithReusableContentHost()) {
                                z11 = true;
                            }
                        }
                    } else {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        ReusableComposition composition = nodeState2.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui_release(size, 1);
                        layoutNode2.ignoreRemeasureRequests = false;
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            z10 = z11;
        }
        if (z10) {
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forceRecomposeChildren() {
        /*
            r14 = this;
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            java.util.List r0 = r0.getFoldedChildren$ui_release()
            int r0 = r0.size()
            int r1 = r14.reusableCount
            if (r1 == r0) goto L83
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r0 = r14.nodeToNodeState
            java.lang.Object[] r1 = r0.values
            long[] r0 = r0.metadata
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L56
            r3 = 0
            r4 = r3
        L1b:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L51
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L35:
            if (r9 >= r7) goto L4f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r10 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r10
            r11 = 1
            r10.setForceRecompose(r11)
        L4b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L4f:
            if (r7 != r8) goto L56
        L51:
            if (r4 == r2) goto L56
            int r4 = r4 + 1
            goto L1b
        L56:
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            androidx.compose.ui.node.LayoutNode r0 = r0.getLookaheadRoot()
            if (r0 == 0) goto L71
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            boolean r0 = r0.getLookaheadMeasurePending$ui_release()
            if (r0 != 0) goto L83
            androidx.compose.ui.node.LayoutNode r1 = r14.root
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.node.LayoutNode.requestLookaheadRemeasure$ui_release$default(r1, r2, r3, r4, r5, r6)
            return
        L71:
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            boolean r0 = r0.getMeasurePending$ui_release()
            if (r0 != 0) goto L83
            androidx.compose.ui.node.LayoutNode r1 = r14.root
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r1, r2, r3, r4, r5, r6)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.forceRecomposeChildren():void");
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void makeSureStateIsConsistent() {
        int size = this.root.getFoldedChildren$ui_release().size();
        if (!(this.nodeToNodeState.get_size() == size)) {
            InlineClassHelperKt.throwIllegalArgumentException("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.get_size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if (!((size - this.reusableCount) - this.precomposedCount >= 0)) {
            StringBuilder sbU = B7.a.u(size, "Incorrect state. Total children ", ". Reusable children ");
            sbU.append(this.reusableCount);
            sbU.append(". Precomposed children ");
            sbU.append(this.precomposedCount);
            InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
        }
        if (this.precomposeMap.get_size() == this.precomposedCount) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.get_size());
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        disposeCurrentNodes();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, n content) {
        precompose(slotId, content, false);
        return createPrecomposedSlotHandle(slotId);
    }

    public final SubcomposeLayoutState.PausedPrecomposition precomposePaused(final Object slotId, n content) {
        if (!this.root.isAttached()) {
            return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precomposePaused.1
                private final boolean isComplete = true;

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                    return LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(slotId);
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public void cancel() {
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                /* renamed from: isComplete, reason: from getter */
                public boolean getIsComplete() {
                    return this.isComplete;
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public boolean resume(ShouldPauseCallback shouldPause) {
                    return true;
                }
            };
        }
        precompose(slotId, content, true);
        return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precomposePaused.2
            /* JADX WARN: Multi-variable type inference failed */
            private final NodeState getNodeState() {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode != null) {
                    return (NodeState) LayoutNodeSubcompositionsState.this.nodeToNodeState.get(layoutNode);
                }
                return null;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                NodeState nodeState = getNodeState();
                if (nodeState != null) {
                    LayoutNodeSubcompositionsState.this.applyPausedPrecomposition(nodeState, false);
                }
                return LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(slotId);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public void cancel() {
                NodeState nodeState = getNodeState();
                if ((nodeState != null ? nodeState.getPausedComposition() : null) != null) {
                    LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(slotId);
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            /* renamed from: isComplete */
            public boolean getIsComplete() {
                PausedComposition pausedComposition;
                NodeState nodeState = getNodeState();
                if (nodeState == null || (pausedComposition = nodeState.getPausedComposition()) == null) {
                    return true;
                }
                return pausedComposition.isComplete();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public boolean resume(ShouldPauseCallback shouldPause) {
                NodeState nodeState = getNodeState();
                PausedComposition pausedComposition = nodeState != null ? nodeState.getPausedComposition() : null;
                if (pausedComposition == null || pausedComposition.isComplete()) {
                    return true;
                }
                Snapshot.Companion companion = Snapshot.INSTANCE;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
                    layoutNode.ignoreRemeasureRequests = true;
                    boolean zResume = pausedComposition.resume(shouldPause);
                    layoutNode.ignoreRemeasureRequests = false;
                    return zResume;
                } finally {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                }
            }
        };
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.ui.layout.Measurable> subcompose(java.lang.Object r13, S7.n r14) {
        /*
            r12 = this;
            r12.makeSureStateIsConsistent()
            androidx.compose.ui.node.LayoutNode r0 = r12.root
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.getLayoutState$ui_release()
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r0 == r4) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r0 == r4) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r0 != r4) goto L1c
            goto L1e
        L1c:
            r4 = r3
            goto L1f
        L1e:
            r4 = r2
        L1f:
            if (r4 != 0) goto L27
            java.lang.String r4 = "subcompose can only be used inside the measure or layout blocks"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r4)
        L27:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r4 = r12.slotIdToNode
            java.lang.Object r5 = r4.get(r13)
            if (r5 != 0) goto L5d
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r5 = r12.precomposeMap
            java.lang.Object r5 = r5.remove(r13)
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            if (r5 == 0) goto L4e
            int r6 = r12.precomposedCount
            if (r6 <= 0) goto L3f
            r6 = r2
            goto L40
        L3f:
            r6 = r3
        L40:
            if (r6 != 0) goto L47
            java.lang.String r6 = "Check failed."
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r6)
        L47:
            int r6 = r12.precomposedCount
            int r6 = r6 + (-1)
            r12.precomposedCount = r6
            goto L5a
        L4e:
            androidx.compose.ui.node.LayoutNode r5 = r12.takeNodeFromReusables(r13)
            if (r5 != 0) goto L5a
            int r5 = r12.currentIndex
            androidx.compose.ui.node.LayoutNode r5 = r12.createNodeAt(r5)
        L5a:
            r4.set(r13, r5)
        L5d:
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            androidx.compose.ui.node.LayoutNode r4 = r12.root
            java.util.List r4 = r4.getFoldedChildren$ui_release()
            int r6 = r12.currentIndex
            java.lang.Object r4 = D7.v.D0(r6, r4)
            if (r4 == r5) goto La2
            androidx.compose.ui.node.LayoutNode r4 = r12.root
            java.util.List r4 = r4.getFoldedChildren$ui_release()
            int r7 = r4.indexOf(r5)
            int r4 = r12.currentIndex
            if (r7 < r4) goto L7d
            r4 = r2
            goto L7e
        L7d:
            r4 = r3
        L7e:
            if (r4 != 0) goto L96
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Key \""
            r4.<init>(r6)
            r4.append(r13)
            java.lang.String r6 = "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item."
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalArgumentException(r4)
        L96:
            int r8 = r12.currentIndex
            if (r8 == r7) goto La2
            r10 = 4
            r11 = 0
            r9 = 0
            r6 = r12
            move$default(r6, r7, r8, r9, r10, r11)
            goto La3
        La2:
            r6 = r12
        La3:
            int r12 = r6.currentIndex
            int r12 = r12 + r2
            r6.currentIndex = r12
            r6.subcompose(r5, r13, r3, r14)
            if (r0 == r1) goto Lb7
            androidx.compose.ui.node.LayoutNode$LayoutState r12 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r0 != r12) goto Lb2
            goto Lb7
        Lb2:
            java.util.List r12 = r5.getChildLookaheadMeasurables$ui_release()
            return r12
        Lb7:
            java.util.List r12 = r5.getChildMeasurables$ui_release()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(java.lang.Object, S7.n):java.util.List");
    }

    private final void precompose(Object slotId, n content, boolean pausable) {
        if (this.root.isAttached()) {
            makeSureStateIsConsistent();
            if (this.slotIdToNode.containsKey(slotId)) {
                return;
            }
            this.approachPrecomposeSlotHandleMap.remove(slotId);
            MutableScatterMap<Object, LayoutNode> mutableScatterMap = this.precomposeMap;
            LayoutNode layoutNodeTakeNodeFromReusables = mutableScatterMap.get(slotId);
            if (layoutNodeTakeNodeFromReusables == null) {
                layoutNodeTakeNodeFromReusables = takeNodeFromReusables(slotId);
                if (layoutNodeTakeNodeFromReusables != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(layoutNodeTakeNodeFromReusables), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNodeTakeNodeFromReusables = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                mutableScatterMap.set(slotId, layoutNodeTakeNodeFromReusables);
            }
            subcompose(layoutNodeTakeNodeFromReusables, slotId, pausable, content);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B0\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR-\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001c\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R$\u00108\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u001e\"\u0004\b7\u0010 ¨\u00069"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "Landroidx/compose/runtime/ReusableComposition;", "composition", AppAgent.CONSTRUCT, "(Ljava/lang/Object;LS7/n;Landroidx/compose/runtime/ReusableComposition;)V", "Ljava/lang/Object;", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "LS7/n;", "getContent", "()LS7/n;", "setContent", "(LS7/n;)V", "Landroidx/compose/runtime/ReusableComposition;", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "", "forceRecompose", "Z", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "forceReuse", "getForceReuse", "setForceReuse", "Landroidx/compose/runtime/PausedComposition;", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "getPausedComposition", "()Landroidx/compose/runtime/PausedComposition;", "setPausedComposition", "(Landroidx/compose/runtime/PausedComposition;)V", "Landroidx/compose/runtime/MutableState;", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "composedWithReusableContentHost", "getComposedWithReusableContentHost", "setComposedWithReusableContentHost", "value", "getActive", "setActive", "active", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NodeState {
        private MutableState<Boolean> activeState;
        private boolean composedWithReusableContentHost;
        private ReusableComposition composition;
        private n content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private PausedComposition pausedComposition;
        private Object slotId;

        public NodeState(Object obj, n nVar, ReusableComposition reusableComposition) {
            this.slotId = obj;
            this.content = nVar;
            this.composition = reusableComposition;
            this.activeState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final MutableState<Boolean> getActiveState() {
            return this.activeState;
        }

        public final boolean getComposedWithReusableContentHost() {
            return this.composedWithReusableContentHost;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final n getContent() {
            return this.content;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final PausedComposition getPausedComposition() {
            return this.pausedComposition;
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setActive(boolean z10) {
            this.activeState.setValue(Boolean.valueOf(z10));
        }

        public final void setActiveState(MutableState<Boolean> mutableState) {
            this.activeState = mutableState;
        }

        public final void setComposedWithReusableContentHost(boolean z10) {
            this.composedWithReusableContentHost = z10;
        }

        public final void setComposition(ReusableComposition reusableComposition) {
            this.composition = reusableComposition;
        }

        public final void setContent(n nVar) {
            this.content = nVar;
        }

        public final void setForceRecompose(boolean z10) {
            this.forceRecompose = z10;
        }

        public final void setForceReuse(boolean z10) {
            this.forceReuse = z10;
        }

        public final void setPausedComposition(PausedComposition pausedComposition) {
            this.pausedComposition = pausedComposition;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public /* synthetic */ NodeState(Object obj, n nVar, ReusableComposition reusableComposition, int i, e eVar) {
            this(obj, nVar, (i & 4) != 0 ? null : reusableComposition);
        }
    }

    private final void subcompose(LayoutNode node, Object slotId, boolean pausable, n content) {
        MutableScatterMap<LayoutNode, NodeState> mutableScatterMap = this.nodeToNodeState;
        NodeState nodeState = mutableScatterMap.get(node);
        if (nodeState == null) {
            NodeState nodeState2 = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.getLambda$641200809$ui_release(), null, 4, null);
            mutableScatterMap.set(node, nodeState2);
            nodeState = nodeState2;
        }
        NodeState nodeState3 = nodeState;
        boolean z10 = nodeState3.getContent() != content;
        if (nodeState3.getPausedComposition() != null) {
            if (z10) {
                cancelPausedPrecomposition(nodeState3);
            } else if (pausable) {
                return;
            } else {
                applyPausedPrecomposition(nodeState3, true);
            }
        }
        ReusableComposition composition = nodeState3.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (z10 || hasInvalidations || nodeState3.getForceRecompose()) {
            nodeState3.setContent(content);
            subcompose(node, nodeState3, pausable);
            nodeState3.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode node, final NodeState nodeState, boolean pausable) {
        if (!(nodeState.getPausedComposition() == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("new subcompose call while paused composition is still active");
        }
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LayoutNode layoutNode = this.root;
            layoutNode.ignoreRemeasureRequests = true;
            ReusableComposition composition = nodeState.getComposition();
            CompositionContext compositionContext = this.compositionContext;
            if (compositionContext != null) {
                if (composition == null || composition.isDisposed()) {
                    if (pausable) {
                        composition = SubcompositionKt.createPausableSubcomposition(node, compositionContext);
                    } else {
                        composition = SubcompositionKt.createSubcomposition(node, compositionContext);
                    }
                }
                nodeState.setComposition(composition);
                final n content = nodeState.getContent();
                if (getOutOfFrameExecutor() != null) {
                    nodeState.setComposedWithReusableContentHost(false);
                } else {
                    nodeState.setComposedWithReusableContentHost(true);
                    content = ComposableLambdaKt.composableLambdaInstance(1524156494, true, new n() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$4$1$composable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @Composable
                        public final void invoke(Composer composer, int i) {
                            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1524156494, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:683)");
                            }
                            boolean active = nodeState.getActive();
                            n nVar = content;
                            composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(active));
                            boolean zChanged = composer.changed(active);
                            if (active) {
                                nVar.invoke(composer, 0);
                            } else {
                                composer.deactivateToEndGroup(zChanged);
                            }
                            composer.endReusableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
                if (pausable) {
                    kotlin.jvm.internal.k.d(composition, "null cannot be cast to non-null type androidx.compose.runtime.PausableComposition");
                    if (nodeState.getForceReuse()) {
                        nodeState.setPausedComposition(((PausableComposition) composition).setPausableContentWithReuse(content));
                    } else {
                        nodeState.setPausedComposition(((PausableComposition) composition).setPausableContent(content));
                    }
                } else if (nodeState.getForceReuse()) {
                    composition.setContentWithReuse(content);
                } else {
                    composition.setContent(content);
                }
                nodeState.setForceReuse(false);
                layoutNode.ignoreRemeasureRequests = false;
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                return;
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("parent composition reference not set");
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
