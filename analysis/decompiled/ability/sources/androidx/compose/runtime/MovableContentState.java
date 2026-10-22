package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.ExtensionsKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@InternalComposeApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00000\t2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0000¢\u0006\u0002\b\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/MovableContentState;", "", "slotTable", "Landroidx/compose/runtime/SlotTable;", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/SlotTable;)V", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "extractNestedStates$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MovableContentState {
    public static final int $stable = 8;
    private final SlotTable slotTable;

    public MovableContentState(SlotTable slotTable) {
        this.slotTable = slotTable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer extractNestedStates$lambda$1(MovableContentState movableContentState, MovableContentStateReference movableContentStateReference) {
        return Integer.valueOf(movableContentState.slotTable.anchorIndex(movableContentStateReference.getAnchor()));
    }

    private static final void extractNestedStates$lambda$4$closeToGroupContaining(SlotWriter slotWriter, int i) {
        while (slotWriter.getParent() >= 0 && slotWriter.getCurrentGroupEnd() <= i) {
            slotWriter.skipToGroupEnd();
            slotWriter.endGroup();
        }
    }

    private static final void extractNestedStates$lambda$4$openParent(SlotWriter slotWriter, int i) {
        extractNestedStates$lambda$4$closeToGroupContaining(slotWriter, i);
        while (slotWriter.getCurrentGroup() != i && !slotWriter.isGroupEnd()) {
            if (i < ComposerKt.getNextGroup(slotWriter)) {
                slotWriter.startGroup();
            } else {
                slotWriter.skipGroup();
            }
        }
        if (!(slotWriter.getCurrentGroup() == i)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
        }
        slotWriter.startGroup();
    }

    public final ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates$runtime(Applier<?> applier, ObjectList<MovableContentStateReference> references) {
        Object[] objArr = references.content;
        int i = references._size;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            int i11 = 1;
            if (i10 >= i) {
                break;
            }
            if (this.slotTable.ownsAnchor(((MovableContentStateReference) objArr[i10]).getAnchor())) {
                i10++;
            } else {
                MutableObjectList mutableObjectList = new MutableObjectList(i6, i11, null);
                Object[] objArr2 = references.content;
                int i12 = references._size;
                for (int i13 = 0; i13 < i12; i13++) {
                    Object obj = objArr2[i13];
                    if (this.slotTable.ownsAnchor(((MovableContentStateReference) obj).getAnchor())) {
                        mutableObjectList.add(obj);
                    }
                }
                references = mutableObjectList;
            }
        }
        ObjectList objectListSortedBy = ExtensionsKt.sortedBy(references, new g(this, 3));
        if (objectListSortedBy.isEmpty()) {
            return ScatterMapKt.emptyScatterMap();
        }
        MutableScatterMap mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
        try {
            Object[] objArr3 = objectListSortedBy.content;
            int i14 = objectListSortedBy._size;
            for (int i15 = 0; i15 < i14; i15++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr3[i15];
                int iAnchorIndex = slotWriterOpenWriter.anchorIndex(movableContentStateReference.getAnchor());
                int iParent = slotWriterOpenWriter.parent(iAnchorIndex);
                extractNestedStates$lambda$4$closeToGroupContaining(slotWriterOpenWriter, iParent);
                extractNestedStates$lambda$4$openParent(slotWriterOpenWriter, iParent);
                slotWriterOpenWriter.advanceBy(iAnchorIndex - slotWriterOpenWriter.getCurrentGroup());
                mutableScatterMapMutableScatterMapOf.set(movableContentStateReference, ComposerKt.extractMovableContentAtCurrent(movableContentStateReference.getComposition(), movableContentStateReference, slotWriterOpenWriter, applier));
            }
            extractNestedStates$lambda$4$closeToGroupContaining(slotWriterOpenWriter, Integer.MAX_VALUE);
            slotWriterOpenWriter.close(true);
            return mutableScatterMapMutableScatterMapOf;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    /* renamed from: getSlotTable$runtime, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }
}
