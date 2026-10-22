package androidx.compose.runtime;

import D7.v;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@InternalComposeApi
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0000\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R6\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f0\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b/\u0010)¨\u00060"}, d2 = {"Landroidx/compose/runtime/MovableContentStateReference;", "", "Landroidx/compose/runtime/MovableContent;", "content", "parameter", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Landroidx/compose/runtime/SlotTable;", "slotTable", "Landroidx/compose/runtime/Anchor;", "anchor", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidations", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "locals", "nestedReferences", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/MovableContent;Ljava/lang/Object;Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;Ljava/util/List;Landroidx/compose/runtime/PersistentCompositionLocalMap;Ljava/util/List;)V", "LC7/r;", "transferPendingInvalidations$runtime", "()V", "transferPendingInvalidations", "Landroidx/compose/runtime/MovableContent;", "getContent$runtime", "()Landroidx/compose/runtime/MovableContent;", "Ljava/lang/Object;", "getParameter$runtime", "()Ljava/lang/Object;", "Landroidx/compose/runtime/ControlledComposition;", "getComposition$runtime", "()Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/Anchor;", "getAnchor$runtime", "()Landroidx/compose/runtime/Anchor;", "Ljava/util/List;", "getInvalidations$runtime", "()Ljava/util/List;", "setInvalidations$runtime", "(Ljava/util/List;)V", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getLocals$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getNestedReferences$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MovableContentStateReference {
    public static final int $stable = 8;
    private final Anchor anchor;
    private final ControlledComposition composition;
    private final MovableContent<Object> content;
    private List<? extends Pair<RecomposeScopeImpl, ? extends Object>> invalidations;
    private final PersistentCompositionLocalMap locals;
    private final List<MovableContentStateReference> nestedReferences;
    private final Object parameter;
    private final SlotTable slotTable;

    public MovableContentStateReference(MovableContent<Object> movableContent, Object obj, ControlledComposition controlledComposition, SlotTable slotTable, Anchor anchor, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list, PersistentCompositionLocalMap persistentCompositionLocalMap, List<MovableContentStateReference> list2) {
        this.content = movableContent;
        this.parameter = obj;
        this.composition = controlledComposition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = list;
        this.locals = persistentCompositionLocalMap;
        this.nestedReferences = list2;
    }

    /* renamed from: getAnchor$runtime, reason: from getter */
    public final Anchor getAnchor() {
        return this.anchor;
    }

    /* renamed from: getComposition$runtime, reason: from getter */
    public final ControlledComposition getComposition() {
        return this.composition;
    }

    public final MovableContent<Object> getContent$runtime() {
        return this.content;
    }

    public final List<Pair<RecomposeScopeImpl, Object>> getInvalidations$runtime() {
        return this.invalidations;
    }

    /* renamed from: getLocals$runtime, reason: from getter */
    public final PersistentCompositionLocalMap getLocals() {
        return this.locals;
    }

    public final List<MovableContentStateReference> getNestedReferences$runtime() {
        return this.nestedReferences;
    }

    /* renamed from: getParameter$runtime, reason: from getter */
    public final Object getParameter() {
        return this.parameter;
    }

    /* renamed from: getSlotTable$runtime, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final void setInvalidations$runtime(List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list) {
        this.invalidations = list;
    }

    public final void transferPendingInvalidations$runtime() {
        List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list = this.invalidations;
        ControlledComposition controlledComposition = this.composition;
        kotlin.jvm.internal.k.d(controlledComposition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        this.invalidations = v.Q0(((CompositionImpl) controlledComposition).extractInvalidationsOf$runtime(this.anchor), list);
    }
}
