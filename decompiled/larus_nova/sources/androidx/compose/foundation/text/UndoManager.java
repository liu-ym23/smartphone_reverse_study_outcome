package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "<init>", "(I)V", "getMaxStoredCharacters", "()I", "undoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "redoStack", "storedCharacters", "lastSnapshot", "", "Ljava/lang/Long;", "forceNextSnapshot", "", "snapshotIfNeeded", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", TriggerTiming.NOW, "makeSnapshot", "removeLastUndo", "undo", "redo", "Entry", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UndoManager {
    public static final int $stable = 8;
    private boolean forceNextSnapshot;
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    private Entry redoStack;
    private int storedCharacters;
    private Entry undoStack;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/UndoManager$Entry;", "", TeaEventTrack.ACTION_DRAMA_NEXT, "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "<init>", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Entry {
        private Entry next;
        private TextFieldValue value;

        public final Entry getNext() {
            return this.next;
        }

        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(Entry r100) {
            this.next = r100;
        }

        public final void setValue(TextFieldValue r100) {
            this.value = r100;
        }

        public Entry(Entry r100, TextFieldValue r101) {
            this.next = r100;
            this.value = r101;
        }

        public /* synthetic */ Entry(Entry r100, TextFieldValue r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100, r101);
        }
    }

    public UndoManager() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    private final void removeLastUndo() {
        Entry r100 = this.undoStack;
        if (r100 == null) goto L5;
        Entry r101 = r100.getNext();
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r100 == null) goto L12;
        Entry r102 = r100.getNext();
        if (r102 == null) goto L12;
        Entry r103 = r102.getNext();
    L13:
        if (r103 == null) goto L15;
        r100 = r100.getNext();
        goto L8
    L15:
        if (r100 == null) goto L19;
        r100.setNext(null);
        return;
    L19:
        return;
    L12:
        r103 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final TextFieldValue redo() {
        Entry r100 = this.redoStack;
        if (r100 == null) goto L5;
        this.redoStack = r100.getNext();
        this.undoStack = new Entry(this.undoStack, r100.getValue());
        this.storedCharacters += r100.getValue().getText().length();
        return r100.getValue();
    L5:
        return null;
    }

    public final TextFieldValue undo() {
        Entry r100 = this.undoStack;
        if (r100 == null) goto L8;
        Entry r101 = r100.getNext();
        if (r101 == null) goto L9;
        this.undoStack = r101;
        this.storedCharacters -= r100.getValue().getText().length();
        this.redoStack = new Entry(this.redoStack, r100.getValue());
        return r101.getValue();
    L9:
        return null;
    L8:
        return null;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public UndoManager(int r100) {
        this.maxStoredCharacters = r100;
    }

    public final void makeSnapshot(TextFieldValue r100) {
        this.forceNextSnapshot = false;
        Entry r101 = this.undoStack;
        if (r101 == null) goto L5;
        TextFieldValue r102 = r101.getValue();
    L7:
        if (Intrinsics.areEqual(r100, r102) == false) goto L9;
        return;
    L9:
        String r103 = r100.getText();
        Entry r104 = this.undoStack;
        if (r104 == null) goto L14;
        TextFieldValue r105 = r104.getValue();
        if (r105 == null) goto L14;
        String r106 = r105.getText();
    L16:
        if (Intrinsics.areEqual(r103, r106) == false) goto L21;
        Entry r107 = this.undoStack;
        if (r107 == null) goto L25;
        r107.setValue(r100);
        return;
    L25:
        return;
    L21:
        this.undoStack = new Entry(this.undoStack, r100);
        this.redoStack = null;
        int r108 = this.storedCharacters + r100.getText().length();
        this.storedCharacters = r108;
        if (r108 <= this.maxStoredCharacters) goto L26;
        removeLastUndo();
        return;
    L26:
        return;
    L14:
        r106 = null;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public final void snapshotIfNeeded(TextFieldValue r100, long r101) {
        if (this.forceNextSnapshot == true) goto L10;
        Long r102 = this.lastSnapshot;
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L9:
        if (r101 > (r103 + ((long) UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()))) goto L10;
        return;
    L7:
        r103 = 0;
    L10:
        this.lastSnapshot = Long.valueOf(r101);
        makeSnapshot(r100);
    }

    public /* synthetic */ UndoManager(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 100000;
    L5:
        this(r100);
    }

    public static /* synthetic */ void snapshotIfNeeded$default(UndoManager r100, TextFieldValue r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = UndoManager_jvmKt.timeNowMillis();
    L5:
        r100.snapshotIfNeeded(r101, r102);
    }
}
