package androidx.compose.foundation.text.input.internal.undo;

import H4.o;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/input/internal/undo/UndoManager$Companion$createSaver$1", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
/* loaded from: classes.dex */
public final class UndoManager$Companion$createSaver$1<T> implements Saver<UndoManager<T>, Object> {
    final /* synthetic */ Saver<T, Object> $itemSaver;

    public UndoManager$Companion$createSaver$1(Saver<T, Object> saver) {
        this.$itemSaver = saver;
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public UndoManager<T> restore(Object value) {
        k.d(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) value;
        int iIntValue = ((Number) list.get(0)).intValue();
        int iIntValue2 = ((Number) list.get(1)).intValue();
        int iIntValue3 = ((Number) list.get(2)).intValue();
        Saver<T, Object> saver = this.$itemSaver;
        ListBuilder listBuilderY = o.y();
        int i = 3;
        while (i < iIntValue2 + 3) {
            T tRestore = saver.restore(list.get(i));
            k.c(tRestore);
            listBuilderY.add(tRestore);
            i++;
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        Saver<T, Object> saver2 = this.$itemSaver;
        ListBuilder listBuilderY2 = o.y();
        while (i < iIntValue2 + iIntValue3 + 3) {
            T tRestore2 = saver2.restore(list.get(i));
            k.c(tRestore2);
            listBuilderY2.add(tRestore2);
            i++;
        }
        return new UndoManager<>(listBuilderQ, o.q(listBuilderY2), iIntValue);
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object save(SaverScope saverScope, UndoManager<T> undoManager) {
        Saver<T, Object> saver = this.$itemSaver;
        ListBuilder listBuilderY = o.y();
        listBuilderY.add(Integer.valueOf(((UndoManager) undoManager).capacity));
        listBuilderY.add(Integer.valueOf(((UndoManager) undoManager).undoStack.size()));
        listBuilderY.add(Integer.valueOf(((UndoManager) undoManager).redoStack.size()));
        SnapshotStateList snapshotStateList = ((UndoManager) undoManager).undoStack;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            listBuilderY.add(saver.save(saverScope, snapshotStateList.get(i)));
        }
        SnapshotStateList snapshotStateList2 = ((UndoManager) undoManager).redoStack;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            listBuilderY.add(saver.save(saverScope, snapshotStateList2.get(i6)));
        }
        return o.q(listBuilderY);
    }
}
