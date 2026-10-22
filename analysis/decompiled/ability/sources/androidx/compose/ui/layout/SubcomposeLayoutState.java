package androidx.compose.ui.layout;

import C7.c;
import C7.r;
import S7.k;
import S7.n;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002,-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ*\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R,\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\f0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R>\u0010'\u001a&\u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\u001b\u0012\u0004\u0012\u00020\f0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 R\u0014\u0010+\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "slotReusePolicy", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "()V", "", "maxSlotsToRetainForReuse", "(I)V", "slotId", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "precompose", "(Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "createPausedPrecomposition", "(Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren$ui_release", "forceRecomposeChildren", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "_state", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Lkotlin/Function2;", "Landroidx/compose/ui/node/LayoutNode;", "setRoot", "LS7/n;", "getSetRoot$ui_release", "()LS7/n;", "Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "getSetCompositionContext$ui_release", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "setMeasurePolicy", "getSetMeasurePolicy$ui_release", "getState", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "state", "PausedPrecomposition", "PrecomposedSlotHandle", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubcomposeLayoutState {
    public static final int $stable = 8;
    private LayoutNodeSubcompositionsState _state;
    private final n setCompositionContext;
    private final n setMeasurePolicy;
    private final n setRoot;
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0001\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "", "resume", "(Landroidx/compose/runtime/ShouldPauseCallback;)Z", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "apply", "()Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "LC7/r;", "cancel", "()V", "isComplete", "()Z", "Landroidx/compose/ui/layout/PausedPrecompositionImpl;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PausedPrecomposition {
        PrecomposedSlotHandle apply();

        void cancel();

        /* renamed from: isComplete */
        boolean getIsComplete();

        boolean resume(ShouldPauseCallback shouldPause);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "LC7/r;", "dispose", "()V", "", "index", "Landroidx/compose/ui/unit/Constraints;", "constraints", "premeasure-0kLqBqw", "(IJ)V", "premeasure", "key", "Lkotlin/Function1;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "block", "traverseDescendants", "(Ljava/lang/Object;LS7/k;)V", "Landroidx/compose/ui/unit/IntSize;", "getSize-YEO4UFw", "(I)J", "getSize", "getPlaceablesCount", "()I", "placeablesCount", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PrecomposedSlotHandle {
        void dispose();

        default int getPlaceablesCount() {
            return 0;
        }

        /* renamed from: getSize-YEO4UFw */
        default long mo5575getSizeYEO4UFw(int index) {
            return IntSize.INSTANCE.m7020getZeroYbymL2g();
        }

        /* renamed from: premeasure-0kLqBqw */
        default void mo5576premeasure0kLqBqw(int index, long constraints) {
        }

        default void traverseDescendants(Object key, k block) {
        }
    }

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        this.setRoot = new n() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (SubcomposeLayoutState) obj2);
                return r.f317a;
            }

            public final void invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                SubcomposeLayoutState subcomposeLayoutState2 = this.this$0;
                LayoutNodeSubcompositionsState subcompositionsState = layoutNode.getSubcompositionsState();
                if (subcompositionsState == null) {
                    subcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, this.this$0.slotReusePolicy);
                    layoutNode.setSubcompositionsState$ui_release(subcompositionsState);
                }
                subcomposeLayoutState2._state = subcompositionsState;
                this.this$0.getState().makeSureStateIsConsistent();
                this.this$0.getState().setSlotReusePolicy(this.this$0.slotReusePolicy);
            }
        };
        this.setCompositionContext = new n() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (CompositionContext) obj2);
                return r.f317a;
            }

            public final void invoke(LayoutNode layoutNode, CompositionContext compositionContext) {
                this.this$0.getState().setCompositionContext(compositionContext);
            }
        };
        this.setMeasurePolicy = new n() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (n) obj2);
                return r.f317a;
            }

            public final void invoke(LayoutNode layoutNode, n nVar) {
                layoutNode.setMeasurePolicy(this.this$0.getState().createMeasurePolicy(nVar));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
    }

    public final PausedPrecomposition createPausedPrecomposition(Object slotId, n content) {
        return getState().precomposePaused(slotId, content);
    }

    public final void forceRecomposeChildren$ui_release() {
        getState().forceRecomposeChildren();
    }

    /* renamed from: getSetCompositionContext$ui_release, reason: from getter */
    public final n getSetCompositionContext() {
        return this.setCompositionContext;
    }

    /* renamed from: getSetMeasurePolicy$ui_release, reason: from getter */
    public final n getSetMeasurePolicy() {
        return this.setMeasurePolicy;
    }

    /* renamed from: getSetRoot$ui_release, reason: from getter */
    public final n getSetRoot() {
        return this.setRoot;
    }

    public final PrecomposedSlotHandle precompose(Object slotId, n content) {
        return getState().precompose(slotId, content);
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    @c
    public SubcomposeLayoutState(int i) {
        this(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(i));
    }
}
