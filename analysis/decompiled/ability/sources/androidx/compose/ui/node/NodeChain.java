package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.data.InpaintImageAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0001g\b\u0001\u0018\u00002\u00020\u0001:\u0004\u0084\u0001\u0085\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0012J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001e\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001d\u0010\u0012J<\u0010'\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0\"H\u0080\b¢\u0006\u0004\b%\u0010&J:\u0010*\u001a\u00020\b\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b(\u0010)J,\u0010*\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b.\u0010)J$\u0010*\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b.\u0010/J$\u00101\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b0\u0010/J:\u00103\u001a\u00020\b\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b2\u0010)J,\u00103\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b4\u0010)J$\u00103\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\"H\u0080\b¢\u0006\u0004\b4\u0010/J(\u00107\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0080\b¢\u0006\u0004\b5\u00106J(\u00109\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0080\b¢\u0006\u0004\b8\u00106J\u001b\u0010<\u001a\u00020#2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 H\u0000¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020#2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b=\u0010;J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020-H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020-2\u0006\u0010C\u001a\u00020-H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010\u0012JG\u0010N\u001a\u00060MR\u00020\u00002\u0006\u00109\u001a\u00020-2\u0006\u0010G\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0H2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010L\u001a\u00020#H\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010S\u001a\u00020\b2\u0006\u0010P\u001a\u00020-2\u0006\u0010R\u001a\u00020QH\u0002¢\u0006\u0004\bS\u0010TJC\u0010U\u001a\u00020\b2\u0006\u0010G\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0H2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u00107\u001a\u00020-2\u0006\u0010L\u001a\u00020#H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020-2\u0006\u0010W\u001a\u00020-H\u0002¢\u0006\u0004\bX\u0010EJ\u0017\u0010Y\u001a\u00020-2\u0006\u0010W\u001a\u00020-H\u0002¢\u0006\u0004\bY\u0010EJ\u001f\u0010\\\u001a\u00020-2\u0006\u0010Z\u001a\u00020I2\u0006\u0010[\u001a\u00020-H\u0002¢\u0006\u0004\b\\\u0010]J\u001f\u0010^\u001a\u00020-2\u0006\u0010W\u001a\u00020-2\u0006\u0010[\u001a\u00020-H\u0002¢\u0006\u0004\b^\u0010_J'\u0010b\u001a\u00020\b2\u0006\u0010`\u001a\u00020I2\u0006\u0010a\u001a\u00020I2\u0006\u0010W\u001a\u00020-H\u0002¢\u0006\u0004\bb\u0010cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010d\u001a\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001a\u0010k\u001a\u00020j8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR$\u0010p\u001a\u00020Q2\u0006\u0010o\u001a\u00020Q8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001a\u00107\u001a\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u0010t\u001a\u0004\bu\u0010BR$\u00109\u001a\u00020-2\u0006\u0010o\u001a\u00020-8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b9\u0010t\u001a\u0004\bv\u0010BR\u001e\u0010w\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001e\u0010y\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\f0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010xR\u001c\u0010{\u001a\b\u0018\u00010MR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010}R\u0015\u0010\u0080\u0001\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00020+8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0086\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/node/NodeChain$Logger;", "logger", "LC7/r;", "useLogger$ui_release", "(Landroidx/compose/ui/node/NodeChain$Logger;)V", "useLogger", "Landroidx/compose/ui/Modifier;", "m", "updateFrom$ui_release", "(Landroidx/compose/ui/Modifier;)V", "updateFrom", "resetState$ui_release", "()V", "resetState", "syncCoordinators", "markAsAttached", "runAttachLifecycle", "", "Landroidx/compose/ui/layout/ModifierInfo;", "getModifierInfo", "()Ljava/util/List;", "markAsDetached$ui_release", "markAsDetached", "runDetachLifecycle$ui_release", "runDetachLifecycle", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/NodeKind;", "type", "Lkotlin/Function1;", "", "block", "firstFromHead-aLcG6gQ$ui_release", "(ILS7/k;)Ljava/lang/Object;", "firstFromHead", "headToTail-aLcG6gQ$ui_release", "(ILS7/k;)V", "headToTail", "", InpaintImageAction.IMAGES_KEY_MASK, "Landroidx/compose/ui/Modifier$Node;", "headToTail$ui_release", "(LS7/k;)V", "headToTailExclusive$ui_release", "headToTailExclusive", "tailToHead-aLcG6gQ$ui_release", "tailToHead", "tailToHead$ui_release", "tail-H91voCI$ui_release", "(I)Ljava/lang/Object;", "tail", "head-H91voCI$ui_release", "head", "has-H91voCI$ui_release", "(I)Z", "has", "has$ui_release", "", "toString", "()Ljava/lang/String;", "padChain", "()Landroidx/compose/ui/Modifier$Node;", "paddedHead", "trimChain", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "syncAggregateChildKindSet", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "before", "after", "shouldAttachOnInsert", "Landroidx/compose/ui/node/NodeChain$Differ;", "getDiffer", "(Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)Landroidx/compose/ui/node/NodeChain$Differ;", "start", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "propagateCoordinator", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator;)V", "structuralUpdate", "(ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/Modifier$Node;Z)V", "node", "detachAndRemoveNode", "removeNode", "element", "parent", "createAndInsertNodeAsChild", "(Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "insertChild", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "prev", "next", "updateNode", "(Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "androidx/compose/ui/node/NodeChain$sentinelHead$1", "sentinelHead", "Landroidx/compose/ui/node/NodeChain$sentinelHead$1;", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "value", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "getTail$ui_release", "getHead$ui_release", "current", "Landroidx/compose/runtime/collection/MutableVector;", "buffer", "stack", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/NodeChain$Logger;", "isUpdating$ui_release", "()Z", "isUpdating", "getAggregateChildKindSet", "()I", "aggregateChildKindSet", "Differ", "Logger", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NodeChain {
    public static final int $stable = 8;
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final NodeChain$sentinelHead$1 sentinelHead;
    private final MutableVector<Modifier> stack;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0014R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "Landroidx/compose/ui/Modifier$Node;", "node", "", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "before", "after", "", "shouldAttachOnInsert", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "oldIndex", "newIndex", "areItemsTheSame", "(II)Z", "LC7/r;", "insert", "(I)V", "atIndex", "remove", "(II)V", "same", "Landroidx/compose/ui/Modifier$Node;", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "I", "getOffset", "()I", "setOffset", "Landroidx/compose/runtime/collection/MutableVector;", "getBefore", "()Landroidx/compose/runtime/collection/MutableVector;", "setBefore", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "setAfter", "Z", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z10) {
            this.node = node;
            this.offset = i;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z10;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            MutableVector<Modifier.Element> mutableVector = this.before;
            int i = this.offset;
            return NodeChainKt.actionForModifiers(mutableVector.content[oldIndex + i], this.after.content[i + newIndex]) != 0;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int newIndex) {
            int i = this.offset + newIndex;
            Modifier.Node node = this.node;
            this.node = NodeChain.this.createAndInsertNodeAsChild(this.after.content[i], node);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                logger.nodeInserted(i, i, this.after.content[i], node, this.node);
            }
            if (!this.shouldAttachOnInsert) {
                this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
            Modifier.Node child$ui_release = this.node.getChild();
            k.c(child$ui_release);
            NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator();
            k.c(coordinator$ui_release);
            LayoutModifierNode layoutModifierNodeAsLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
            if (layoutModifierNodeAsLayoutModifierNode != null) {
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), layoutModifierNodeAsLayoutModifierNode);
                this.node.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                NodeChain.this.propagateCoordinator(this.node, layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrappedBy$ui_release(coordinator$ui_release.getWrappedBy());
                layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator$ui_release);
                coordinator$ui_release.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
            } else {
                this.node.updateCoordinator$ui_release(coordinator$ui_release);
            }
            this.node.markAsAttached$ui_release();
            this.node.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(this.node);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int atIndex, int oldIndex) {
            Modifier.Node child$ui_release = this.node.getChild();
            k.c(child$ui_release);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                MutableVector<Modifier.Element> mutableVector = this.before;
                logger.nodeRemoved(oldIndex, mutableVector.content[this.offset + oldIndex], child$ui_release);
            }
            if ((NodeKind.m5862constructorimpl(2) & child$ui_release.getKindSet()) != 0) {
                NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator();
                k.c(coordinator$ui_release);
                NodeCoordinator wrappedBy$ui_release = coordinator$ui_release.getWrappedBy();
                NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped();
                k.c(wrapped$ui_release);
                if (wrappedBy$ui_release != null) {
                    wrappedBy$ui_release.setWrapped$ui_release(wrapped$ui_release);
                }
                wrapped$ui_release.setWrappedBy$ui_release(wrappedBy$ui_release);
                NodeChain.this.propagateCoordinator(this.node, wrapped$ui_release);
            }
            this.node = NodeChain.this.detachAndRemoveNode(child$ui_release);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            Modifier.Node child$ui_release = this.node.getChild();
            k.c(child$ui_release);
            this.node = child$ui_release;
            MutableVector<Modifier.Element> mutableVector = this.before;
            int i = this.offset;
            Modifier.Element element = mutableVector.content[i + oldIndex];
            Modifier.Element element2 = this.after.content[i + newIndex];
            if (k.b(element, element2)) {
                Logger logger = NodeChain.this.logger;
                if (logger != null) {
                    int i6 = this.offset;
                    logger.nodeReused(i6 + oldIndex, i6 + newIndex, element, element2, this.node);
                    return;
                }
                return;
            }
            NodeChain.this.updateNode(element, element2, this.node);
            Logger logger2 = NodeChain.this.logger;
            if (logger2 != null) {
                int i10 = this.offset;
                logger2.nodeUpdated(i10 + oldIndex, i10 + newIndex, element, element2, this.node);
            }
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            this.after = mutableVector;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            this.before = mutableVector;
        }

        public final void setNode(Modifier.Node node) {
            this.node = node;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final void setShouldAttachOnInsert(boolean z10) {
            this.shouldAttachOnInsert = z10;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b`\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000fJ7\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "", "index", "Landroidx/compose/ui/Modifier$Element;", "prev", "next", "Landroidx/compose/ui/Modifier$Node;", "node", "LC7/r;", "linearDiffAborted", "(ILandroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)V", "oldIndex", "newIndex", "nodeUpdated", "(IILandroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)V", "nodeReused", "atIndex", "element", "child", "inserted", "nodeInserted", "(IILandroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/Modifier$Node;)V", "nodeRemoved", "(ILandroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Logger {
        void linearDiffAborted(int index, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeInserted(int atIndex, int newIndex, Modifier.Element element, Modifier.Node child, Modifier.Node inserted);

        void nodeRemoved(int oldIndex, Modifier.Element element, Modifier.Node node);

        void nodeReused(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeUpdated(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node, androidx.compose.ui.node.NodeChain$sentinelHead$1] */
    public NodeChain(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        ?? r02 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChain$sentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r02.setAggregateChildKindSet$ui_release(-1);
        this.sentinelHead = r02;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
        this.stack = new MutableVector<>(new Modifier[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        Modifier.Node backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).getNode();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (backwardsCompatNode.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return insertChild(backwardsCompatNode, parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet();
    }

    private final Differ getDiffer(Modifier.Node head, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(head, offset, before, after, shouldAttachOnInsert);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(head);
        differ.setOffset(offset);
        differ.setBefore(before);
        differ.setAfter(after);
        differ.setShouldAttachOnInsert(shouldAttachOnInsert);
        return differ;
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        Modifier.Node child$ui_release = parent.getChild();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(node);
            node.setChild$ui_release(child$ui_release);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    private final Modifier.Node padChain() {
        if (!(this.head != this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }
        Modifier.Node node = this.head;
        node.setParent$ui_release(this.sentinelHead);
        setChild$ui_release(node);
        return this.sentinelHead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void propagateCoordinator(Modifier.Node start, NodeCoordinator coordinator) {
        for (Modifier.Node parent$ui_release = start.getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            if (parent$ui_release == this.sentinelHead) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                coordinator.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = coordinator;
                return;
            } else {
                if ((NodeKind.m5862constructorimpl(2) & parent$ui_release.getKindSet()) != 0) {
                    return;
                }
                parent$ui_release.updateCoordinator$ui_release(coordinator);
            }
        }
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child$ui_release = node.getChild();
        Modifier.Node parent$ui_release = node.getParent();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release(null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release(null);
        }
        k.c(parent$ui_release);
        return parent$ui_release;
    }

    private final void structuralUpdate(int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail, boolean shouldAttachOnInsert) {
        MyersDiffKt.executeDiff(before.getSize() - offset, after.getSize() - offset, getDiffer(tail, offset, before, after, shouldAttachOnInsert));
        syncAggregateChildKindSet();
    }

    private final void syncAggregateChildKindSet() {
        int kindSet$ui_release = 0;
        for (Modifier.Node parent$ui_release = this.tail.getParent(); parent$ui_release != null && parent$ui_release != this.sentinelHead; parent$ui_release = parent$ui_release.getParent()) {
            kindSet$ui_release |= parent$ui_release.getKindSet();
            parent$ui_release.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        if (!(paddedHead == this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }
        Modifier.Node child$ui_release = getChild();
        if (child$ui_release == null) {
            child$ui_release = this.tail;
        }
        child$ui_release.setParent$ui_release(null);
        setChild$ui_release(null);
        setAggregateChildKindSet$ui_release(-1);
        updateCoordinator$ui_release(null);
        if (!(child$ui_release != this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }
        return child$ui_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (!(node instanceof BackwardsCompatNode)) {
            InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
            return;
        }
        ((BackwardsCompatNode) node).setElement(next);
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateUpdatedNode(node);
        } else {
            node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final <T> T m5817firstFromHeadaLcG6gQ$ui_release(int type, S7.k block) {
        if ((getAggregateChildKindSet() & type) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & type) != 0) {
                    k.m();
                    throw null;
                }
                if ((head.getAggregateChildKindSet() & type) == 0) {
                    break;
                }
            }
        }
        return null;
    }

    /* renamed from: getHead$ui_release, reason: from getter */
    public final Modifier.Node getHead() {
        return this.head;
    }

    /* renamed from: getInnerCoordinator$ui_release, reason: from getter */
    public final InnerNodeCoordinator getInnerCoordinator() {
        return this.innerCoordinator;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return EmptyList.f4893a;
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head = getHead();
        while (head != null && head != getTail()) {
            NodeCoordinator coordinator$ui_release = head.getCoordinator();
            if (coordinator$ui_release == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator");
            }
            OwnedLayer layer = coordinator$ui_release.getLayer();
            OwnedLayer layer2 = this.innerCoordinator.getLayer();
            Modifier.Node child$ui_release = head.getChild();
            if (child$ui_release != this.tail || head.getCoordinator() == child$ui_release.getCoordinator()) {
                layer2 = null;
            }
            if (layer == null) {
                layer = layer2;
            }
            mutableVector2.add(new ModifierInfo(mutableVector.content[i], coordinator$ui_release, layer));
            head = head.getChild();
            i++;
        }
        return mutableVector2.asMutableList();
    }

    /* renamed from: getOuterCoordinator$ui_release, reason: from getter */
    public final NodeCoordinator getOuterCoordinator() {
        return this.outerCoordinator;
    }

    /* renamed from: getTail$ui_release, reason: from getter */
    public final Modifier.Node getTail() {
        return this.tail;
    }

    public final boolean has$ui_release(int mask) {
        return (getAggregateChildKindSet() & mask) != 0;
    }

    /* renamed from: has-H91voCI$ui_release, reason: not valid java name */
    public final boolean m5818hasH91voCI$ui_release(int type) {
        return (getAggregateChildKindSet() & type) != 0;
    }

    /* renamed from: head-H91voCI$ui_release, reason: not valid java name */
    public final <T> T m5819headH91voCI$ui_release(int type) {
        if ((getAggregateChildKindSet() & type) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & type) != 0) {
                    k.m();
                    throw null;
                }
                if ((head.getAggregateChildKindSet() & type) == 0) {
                    break;
                }
            }
        }
        return null;
    }

    public final void headToTail$ui_release(int mask, S7.k block) {
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            if ((head.getKindSet() & mask) != 0) {
                block.invoke(head);
            }
            if ((head.getAggregateChildKindSet() & mask) == 0) {
                return;
            }
        }
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release, reason: not valid java name */
    public final <T> void m5820headToTailaLcG6gQ$ui_release(int type, S7.k block) {
        if ((getAggregateChildKindSet() & type) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & type) != 0) {
                    k.m();
                    throw null;
                }
                if ((head.getAggregateChildKindSet() & type) == 0) {
                    return;
                }
            }
        }
    }

    public final void headToTailExclusive$ui_release(S7.k block) {
        for (Modifier.Node head = getHead(); head != null && head != getTail(); head = head.getChild()) {
            block.invoke(head);
        }
    }

    public final boolean isUpdating$ui_release() {
        return getChild() != null;
    }

    public final void markAsAttached() {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.markAsAttached$ui_release();
        }
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.markAsDetached$ui_release();
            }
        }
    }

    public final void resetState$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.reset$ui_release();
            }
        }
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.runAttachLifecycle$ui_release();
            if (head.getInsertedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateInsertedNode(head);
            }
            if (head.getUpdatedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateUpdatedNode(head);
            }
            head.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            head.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.runDetachLifecycle$ui_release();
            }
        }
    }

    public final void syncCoordinators() {
        NodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent$ui_release = this.tail.getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            LayoutModifierNode layoutModifierNodeAsLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(parent$ui_release);
            if (layoutModifierNodeAsLayoutModifierNode != null) {
                if (parent$ui_release.getCoordinator() != null) {
                    NodeCoordinator coordinator$ui_release = parent$ui_release.getCoordinator();
                    k.d(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(layoutModifierNodeAsLayoutModifierNode);
                    if (layoutModifierNode != parent$ui_release) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, layoutModifierNodeAsLayoutModifierNode);
                    parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrapped$ui_release(nodeCoordinator);
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        nodeCoordinator.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = nodeCoordinator;
    }

    /* renamed from: tail-H91voCI$ui_release, reason: not valid java name */
    public final <T> T m5821tailH91voCI$ui_release(int type) {
        if ((getAggregateChildKindSet() & type) != 0) {
            for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
                if ((tail.getKindSet() & type) != 0) {
                    k.m();
                    throw null;
                }
            }
        }
        return null;
    }

    public final void tailToHead$ui_release(int mask, S7.k block) {
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if ((tail.getKindSet() & mask) != 0) {
                block.invoke(tail);
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final <T> void m5822tailToHeadaLcG6gQ$ui_release(int type, S7.k block) {
        if ((getAggregateChildKindSet() & type) != 0) {
            for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
                if ((tail.getKindSet() & type) != 0) {
                    k.m();
                    throw null;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (this.head == this.tail) {
            sb.append("]");
        } else {
            Modifier.Node head = getHead();
            while (true) {
                if (head == null || head == getTail()) {
                    break;
                }
                sb.append(String.valueOf(head));
                if (head.getChild() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head = head.getChild();
            }
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r18) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void useLogger$ui_release(Logger logger) {
        this.logger = logger;
    }

    public final void tailToHead$ui_release(S7.k block) {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            block.invoke(tail);
        }
    }

    public final void headToTail$ui_release(S7.k block) {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            block.invoke(head);
        }
    }
}
