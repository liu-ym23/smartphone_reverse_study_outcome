package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text/input/internal/undo/UndoManager;)V", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "canUndo", "", "getCanUndo", "()Z", "canRedo", "getCanRedo", "undo", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "redo", "record", "op", "clearHistory", "flush", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextUndoManager {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final MutableState stagingUndo$delegate;
    private final UndoManager<TextUndoOperation> undoManager;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion;", "", "<init>", "()V", "Saver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextUndoManager;", "", "<init>", "()V", "undoManagerSaver", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", SVGRenderEngine.SAVE, "Landroidx/compose/runtime/saveable/SaverScope;", "value", SVGRenderEngine.RESTORE, "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextUndoManager, Object> {
            public static final int $stable = 0;
            public static final Saver INSTANCE = null;
            private static final androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> undoManagerSaver = null;

            private Saver() {
            }

            static {
                INSTANCE = new Saver();
                UndoManager.Companion r100 = UndoManager.Companion;
                final androidx.compose.runtime.saveable.Saver<TextUndoOperation, Object> r101 = TextUndoOperation.Companion.getSaver();
                undoManagerSaver = new TextUndoManager$Companion$Saver$special$$inlined$createSaver$1(r101);
                $stable = 8;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.runtime.saveable.Saver
            public TextUndoManager restore(Object r100) {
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List r101 = (List) r100;
                Object r102 = ListProtector.get(r101, 0);
                Object r103 = ListProtector.get(r101, 1);
                if (r102 == null) goto L5;
                TextUndoOperation r104 = TextUndoOperation.Companion.getSaver().restore(r102);
            L6:
                androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> r105 = undoManagerSaver;
                Intrinsics.checkNotNull(r103);
                UndoManager<TextUndoOperation> r106 = r105.restore(r103);
                Intrinsics.checkNotNull(r106);
                return new TextUndoManager(r104, r106);
            L5:
                r104 = null;
                goto L6
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public /* bridge */ /* synthetic */ TextUndoManager restore(Object r100) {
                return restore(r100);
            }

            /* JADX INFO: renamed from: save, reason: avoid collision after fix types in other method */
            public Object save2(SaverScope r100, TextUndoManager r101) {
                Object[] r102 = new Object[2];
                TextUndoOperation r103 = TextUndoManager.access$getStagingUndo(r101);
                if (r103 == null) goto L5;
                Object r104 = TextUndoOperation.Companion.getSaver().save(r100, r103);
            L6:
                r102[0] = r104;
                r102[1] = undoManagerSaver.save(r100, TextUndoManager.access$getUndoManager$p(r101));
                return CollectionsKt.listOf(r102);
            L5:
                r104 = null;
                goto L6
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public /* bridge */ /* synthetic */ Object save(SaverScope r100, TextUndoManager r101) {
                return save2(r100, r101);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextUndoManager() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final void clearHistory() {
        setStagingUndo(null);
        this.undoManager.clearHistory();
    }

    private final void flush() {
        Snapshot.Companion r100 = Snapshot.Companion;
        Snapshot r101 = r100.getCurrentThreadSnapshot();
        if (r101 == null) goto L5;
        Function1<Object, Unit> r102 = r101.getReadObserver();
    L6:
        Snapshot r103 = r100.makeCurrentNonObservable(r101);
        TextUndoOperation r104 = getStagingUndo();     // Catch: Throwable -> L13
        r100.restoreNonObservable(r101, r103, r102);
        if (r104 == null) goto L11;
        this.undoManager.record(r104);
    L11:
        setStagingUndo(null);
        return;
    L13:
        th = move-exception;
        r100.restoreNonObservable(r101, r103, r102);
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextUndoOperation getStagingUndo() {
        return (TextUndoOperation) this.stagingUndo$delegate.getValue();
    }

    public final boolean getCanRedo() {
        if (this.undoManager.getCanRedo$foundation_release() == true) goto L5;
    L7:
        return false;
    L5:
        if (getStagingUndo() != null) goto L7;
        return true;
    }

    public final boolean getCanUndo() {
        if (this.undoManager.getCanUndo$foundation_release() == false) goto L5;
    L8:
        return true;
    L5:
        if (getStagingUndo() != null) goto L8;
        return false;
    }

    public static final /* synthetic */ TextUndoOperation access$getStagingUndo(TextUndoManager r100) {
        return r100.getStagingUndo();
    }

    public static final /* synthetic */ UndoManager access$getUndoManager$p(TextUndoManager r100) {
        return r100.undoManager;
    }

    private final void setStagingUndo(TextUndoOperation r100) {
        this.stagingUndo$delegate.setValue(r100);
    }

    public final void record(TextUndoOperation r100) {
        Snapshot.Companion r101 = Snapshot.Companion;
        Snapshot r102 = r101.getCurrentThreadSnapshot();
        if (r102 == null) goto L5;
        Function1<Object, Unit> r103 = r102.getReadObserver();
    L6:
        Snapshot r104 = r101.makeCurrentNonObservable(r102);
        TextUndoOperation r105 = getStagingUndo();     // Catch: Throwable -> L18
        r101.restoreNonObservable(r102, r104, r103);
        if (r105 != null) goto L12;
        setStagingUndo(r100);
        return;
    L12:
        TextUndoOperation r106 = TextUndoManagerKt.merge(r105, r100);
        if (r106 == null) goto L16;
        setStagingUndo(r106);
        return;
    L16:
        flush();
        setStagingUndo(r100);
        return;
    L18:
        th = move-exception;
        r101.restoreNonObservable(r102, r104, r103);
        throw th;
    L5:
        r103 = null;
        goto L6
    }

    public final void redo(TextFieldState r100) {
        if (getCanRedo() == true) goto L5;
        return;
    L5:
        TextUndoOperationKt.redo(r100, this.undoManager.redo());
    }

    public final void undo(TextFieldState r100) {
        if (getCanUndo() == true) goto L5;
        return;
    L5:
        flush();
        TextUndoOperationKt.undo(r100, this.undoManager.undo());
    }

    public TextUndoManager(TextUndoOperation r100, UndoManager<TextUndoOperation> r101) {
        this.undoManager = r101;
        this.stagingUndo$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
    }

    public /* synthetic */ TextUndoManager(TextUndoOperation r100, UndoManager r101, int r102, DefaultConstructorMarker r110) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new UndoManager(null, null, 100, 3, null);
    L8:
        this(r100, r101);
    }
}
