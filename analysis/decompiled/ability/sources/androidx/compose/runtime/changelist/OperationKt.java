package androidx.compose.runtime.changelist;

import D7.v;
import H4.o;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a:\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0019\u001a\u00020\u0018*\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u0016\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u001b*\f\b\u0000\u0010\u001c\"\u00020\u00052\u00020\u0005¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/Applier;", "", "applier", "", "index", "LC7/r;", "positionToParentOf", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Applier;I)V", "currentNodeIndex", "(Landroidx/compose/runtime/SlotWriter;)I", "Landroidx/compose/runtime/Anchor;", "anchor", "positionToInsert", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/Applier;)I", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "writer", "location", "Lkotlin/Function0;", "block", "withCurrentStackTrace", "(Landroidx/compose/runtime/changelist/OperationErrorContext;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Anchor;LS7/a;)V", "", "attachComposeStackTrace", "(Ljava/lang/Throwable;Landroidx/compose/runtime/changelist/OperationErrorContext;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Anchor;)Ljava/lang/Throwable;", "(Landroidx/compose/runtime/changelist/OperationErrorContext;Landroidx/compose/runtime/SlotWriter;)Landroidx/compose/runtime/changelist/OperationErrorContext;", "IntParameter", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OperationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable attachComposeStackTrace(Throwable th, OperationErrorContext operationErrorContext, SlotWriter slotWriter, Anchor anchor) {
        return operationErrorContext == null ? th : ComposeStackTraceKt.attachComposeStackTrace(th, new b(anchor, slotWriter, operationErrorContext, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List attachComposeStackTrace$lambda$1(Anchor anchor, SlotWriter slotWriter, OperationErrorContext operationErrorContext) {
        if (anchor != null) {
            slotWriter.seek(anchor);
        }
        List listBuildTrace$default = ComposeStackTraceBuilderKt.buildTrace$default(slotWriter, null, 0, null, 7, null);
        ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) v.L0(listBuildTrace$default);
        Integer groupOffset = composeStackTraceFrame != null ? composeStackTraceFrame.getGroupOffset() : null;
        List<ComposeStackTraceFrame> listBuildStackTrace = operationErrorContext.buildStackTrace(groupOffset);
        if (groupOffset != null && !listBuildStackTrace.isEmpty()) {
            listBuildStackTrace = v.Q0(v.w0(listBuildStackTrace, 1), o.M(ComposeStackTraceFrame.copy$default((ComposeStackTraceFrame) v.A0(listBuildStackTrace), null, groupOffset, 1, null)));
        }
        return v.Q0(listBuildStackTrace, listBuildTrace$default);
    }

    private static final int currentNodeIndex(SlotWriter slotWriter) {
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int iGroupSize = parent + 1;
        int iNodeCount = 0;
        while (iGroupSize < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, iGroupSize)) {
                if (slotWriter.isNode(iGroupSize)) {
                    iNodeCount = 0;
                }
                iGroupSize++;
            } else {
                iNodeCount += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.nodeCount(iGroupSize);
                iGroupSize += slotWriter.groupSize(iGroupSize);
            }
        }
        return iNodeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier) {
        int iAnchorIndex = slotWriter.anchorIndex(anchor);
        if (!(slotWriter.getCurrentGroup() < iAnchorIndex)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        positionToParentOf(slotWriter, applier, iAnchorIndex);
        int iCurrentNodeIndex = currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < iAnchorIndex) {
            if (slotWriter.indexInCurrentGroup(iAnchorIndex)) {
                if (slotWriter.isNode()) {
                    applier.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    iCurrentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                iCurrentNodeIndex += slotWriter.skipGroup();
            }
        }
        if (!(slotWriter.getCurrentGroup() == iAnchorIndex)) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        return iCurrentNodeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void positionToParentOf(SlotWriter slotWriter, Applier<Object> applier, int i) {
        while (!slotWriter.indexInParent(i)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier.up();
            }
            slotWriter.endGroup();
        }
    }

    private static final void withCurrentStackTrace(OperationErrorContext operationErrorContext, SlotWriter slotWriter, Anchor anchor, S7.a aVar) throws Throwable {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            throw attachComposeStackTrace(th, operationErrorContext, slotWriter, anchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OperationErrorContext withCurrentStackTrace(final OperationErrorContext operationErrorContext, final SlotWriter slotWriter) {
        return new OperationErrorContext() { // from class: androidx.compose.runtime.changelist.OperationKt.withCurrentStackTrace.1
            @Override // androidx.compose.runtime.changelist.OperationErrorContext
            public List<ComposeStackTraceFrame> buildStackTrace(Integer currentOffset) {
                List<ComposeStackTraceFrame> listBuildStackTrace = operationErrorContext.buildStackTrace(null);
                int parent = slotWriter.getParent();
                if (parent < 0) {
                    return listBuildStackTrace;
                }
                SlotWriter slotWriter2 = slotWriter;
                return v.Q0(listBuildStackTrace, ComposeStackTraceBuilderKt.buildTrace(slotWriter2, currentOffset, parent, Integer.valueOf(slotWriter2.parent(parent))));
            }
        };
    }
}
