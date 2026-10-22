package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB1\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u000b\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001d\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialUndoStack", "", "initialRedoStack", "capacity", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "undoStack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "redoStack", "canUndo", "", "getCanUndo$foundation_release", "()Z", "canRedo", "getCanRedo$foundation_release", "size", "getSize", "()I", "record", "", "undoableAction", "(Ljava/lang/Object;)V", "undo", "()Ljava/lang/Object;", "redo", "clearHistory", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UndoManager<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final int capacity;
    private SnapshotStateList<T> redoStack;
    private SnapshotStateList<T> undoStack;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u00020\u00010\u0005\"\u0006\b\u0001\u0010\u0007\u0018\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/UndoManager$Companion;", "", "<init>", "()V", "createSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", ExifInterface.GPS_DIRECTION_TRUE, "itemSaver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final /* synthetic */ <T> Saver<UndoManager<T>, Object> createSaver(final Saver<T, Object> r100) {
            Intrinsics.needClassReification();
            return new UndoManager$Companion$createSaver$1(r100);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public UndoManager() {
        this(null, null, 0, 7, null);
    }

    public final void clearHistory() {
        this.undoStack.clear();
        this.redoStack.clear();
    }

    public final boolean getCanRedo$foundation_release() {
        return !this.redoStack.isEmpty();
    }

    public final boolean getCanUndo$foundation_release() {
        return !this.undoStack.isEmpty();
    }

    public final int getSize() {
        return this.undoStack.size() + this.redoStack.size();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final T redo() {
        if (getCanRedo$foundation_release() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("It's an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.");
    L5:
        T r100 = (T) CollectionsKt.removeLast(this.redoStack);
        this.undoStack.add(r100);
        return r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final T undo() {
        if (getCanUndo$foundation_release() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("It's an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.");
    L5:
        T r100 = (T) CollectionsKt.removeLast(this.undoStack);
        this.redoStack.add(r100);
        return r100;
    }

    public static final /* synthetic */ int access$getCapacity$p(UndoManager r100) {
        return r100.capacity;
    }

    public static final /* synthetic */ SnapshotStateList access$getRedoStack$p(UndoManager r100) {
        return r100.redoStack;
    }

    public static final /* synthetic */ SnapshotStateList access$getUndoStack$p(UndoManager r100) {
        return r100.undoStack;
    }

    public final void record(T r100) {
        this.redoStack.clear();
    L4:
        if (getSize() <= (this.capacity - 1)) goto L6;
        CollectionsKt.removeFirst(this.undoStack);
        goto L4
    L6:
        this.undoStack.add(r100);
    }

    public UndoManager(List<? extends T> r100, List<? extends T> r101, int r102) {
        this.capacity = r102;
        boolean r103 = true;
        if (r102 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Capacity must be a positive integer");
    L9:
        if ((r101.size() + r100.size()) <= r102) goto L12;
        r103 = false;
    L12:
        if (r103 == true) goto L14;
        InlineClassHelperKt.throwIllegalArgumentException("Initial list of undo and redo operations have a size greater than the given capacity.");
    L14:
        SnapshotStateList<T> r105 = new SnapshotStateList();
        r105.addAll(r100);
        this.undoStack = r105;
        SnapshotStateList<T> r106 = new SnapshotStateList();
        r106.addAll(r101);
        this.redoStack = r106;
        return;
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ UndoManager(List r100, List r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 100;
    L11:
        this(r100, r101, r102);
    }
}
