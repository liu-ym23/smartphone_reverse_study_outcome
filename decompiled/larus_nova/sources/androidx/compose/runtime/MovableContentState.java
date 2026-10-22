package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00000\t2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0000¢\u0006\u0002\b\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/MovableContentState;", "", "slotTable", "Landroidx/compose/runtime/SlotTable;", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "extractNestedStates$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MovableContentState {
    public static final int $stable = 8;
    private final SlotTable slotTable;

    public static /* synthetic */ Integer a(MovableContentState r100, MovableContentStateReference r101) {
        return extractNestedStates$lambda$1(r100, r101);
    }

    public final SlotTable getSlotTable$runtime() {
        return this.slotTable;
    }

    public MovableContentState(SlotTable r100) {
        this.slotTable = r100;
    }

    private static final Integer extractNestedStates$lambda$1(MovableContentState r100, MovableContentStateReference r101) {
        return Integer.valueOf(r100.slotTable.anchorIndex(r101.getAnchor$runtime()));
    }

    private static final void extractNestedStates$lambda$4$closeToGroupContaining(SlotWriter r100, int r101) {
    L3:
        if (r100.getParent() < 0) goto L7;
        if (r100.getCurrentGroupEnd() > r101) goto L10;
        r100.skipToGroupEnd();
        r100.endGroup();
        goto L3
    L10:
        return;
    }

    private static final void extractNestedStates$lambda$4$openParent(SlotWriter r100, int r101) {
        extractNestedStates$lambda$4$closeToGroupContaining(r100, r101);
    L4:
        if (r100.getCurrentGroup() == r101) goto L12;
        if (r100.isGroupEnd() == true) goto L12;
        if (r101 < ComposerKt.access$getNextGroup(r100)) goto L9;
        r100.skipGroup();
        goto L4
    L9:
        r100.startGroup();
    L12:
        if (r100.getCurrentGroup() != r101) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
        ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
    L17:
        r100.startGroup();
        return;
    L14:
        r102 = false;
        goto L15
    }

    public final ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates$runtime(Applier<?> r110, ObjectList<MovableContentStateReference> r111) {
        Object[] r100 = r111.content;
        int r101 = r111._size;
        int r102 = 0;
        int r103 = 0;
    L3:
        int r104 = 1;
        if (r103 >= r101) goto L9;
        MovableContentStateReference r105 = (MovableContentStateReference) r100[r103];
        if (this.slotTable.ownsAnchor(r105.getAnchor$runtime()) == false) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        boolean r106 = false;
    L10:
        if (r106 == true) goto L19;
        MutableObjectList r107 = new MutableObjectList(r102, r104, null);
        Object[] r108 = r111.content;
        int r112 = r111._size;
        int r109 = 0;
    L13:
        if (r109 >= r112) goto L18;
        Object r113 = r108[r109];
        if (this.slotTable.ownsAnchor(((MovableContentStateReference) r113).getAnchor$runtime()) == false) goto L17;
        r107.add(r113);
    L17:
        r109 = r109 + 1;
        goto L13
    L18:
        r111 = r107;
    L19:
        ObjectList r114 = ExtensionsKt.sortedBy(r111, new p(this));
        if (r114.isEmpty() == true) goto L22;
        MutableScatterMap r115 = ScatterMapKt.mutableScatterMapOf();
        SlotWriter r116 = this.slotTable.openWriter();
        Object[] r117 = r114.content;     // Catch: Throwable -> L30
        int r118 = r114._size;     // Catch: Throwable -> L30
        int r119 = 0;
    L25:
        if (r119 >= r118) goto L27;
        MovableContentStateReference r120 = (MovableContentStateReference) r117[r119];     // Catch: Throwable -> L30
        int r121 = r116.anchorIndex(r120.getAnchor$runtime());     // Catch: Throwable -> L30
        int r122 = r116.parent(r121);     // Catch: Throwable -> L30
        extractNestedStates$lambda$4$closeToGroupContaining(r116, r122);     // Catch: Throwable -> L30
        extractNestedStates$lambda$4$openParent(r116, r122);     // Catch: Throwable -> L30
        r116.advanceBy(r121 - r116.getCurrentGroup());     // Catch: Throwable -> L30
        r115.set(r120, ComposerKt.extractMovableContentAtCurrent(r120.getComposition$runtime(), r120, r116, r110));     // Catch: Throwable -> L30
        r119 = r119 + 1;     // Catch: Throwable -> L30
        goto L25
    L27:
        extractNestedStates$lambda$4$closeToGroupContaining(r116, Integer.MAX_VALUE);     // Catch: Throwable -> L30
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r116.close(true);
        return r115;
    L30:
        th = move-exception;
        r116.close(false);
        throw th;
    L22:
        return ScatterMapKt.emptyScatterMap();
    L9:
        r106 = true;
        goto L10
    }
}
