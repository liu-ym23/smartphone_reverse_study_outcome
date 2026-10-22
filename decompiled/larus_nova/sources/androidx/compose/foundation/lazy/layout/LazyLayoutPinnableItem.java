package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020$R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001b¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnableItem;", "Landroidx/compose/ui/layout/PinnableContainer;", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "key", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "<init>", "(Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;)V", "getKey", "()Ljava/lang/Object;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "pinsCount", "parentHandle", "isDisposed", "", "<set-?>", "_parentPinnableContainer", "get_parentPinnableContainer", "()Landroidx/compose/ui/layout/PinnableContainer;", "set_parentPinnableContainer", "(Landroidx/compose/ui/layout/PinnableContainer;)V", "_parentPinnableContainer$delegate", "Landroidx/compose/runtime/MutableState;", "value", "parentPinnableContainer", "getParentPinnableContainer", "setParentPinnableContainer", "pin", "release", "", "onDisposed", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyLayoutPinnableItem implements PinnableContainer, PinnableContainer.PinnedHandle, LazyLayoutPinnedItemList.PinnedItem {
    private final MutableState _parentPinnableContainer$delegate;
    private int index;
    private boolean isDisposed;
    private final Object key;
    private PinnableContainer.PinnedHandle parentHandle;
    private final LazyLayoutPinnedItemList pinnedItemList;
    private int pinsCount;

    public final void onDisposed() {
        this.isDisposed = true;
    }

    private final PinnableContainer get_parentPinnableContainer() {
        return (PinnableContainer) this._parentPinnableContainer$delegate.getValue();
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public PinnableContainer.PinnedHandle pin() {
        if ((!this.isDisposed) == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("Pin should not be called on an already disposed item ");
    L6:
        if (this.pinsCount != 0) goto L12;
        this.pinnedItemList.pin$foundation_release(this);
        PinnableContainer r100 = getParentPinnableContainer();
        if (r100 == null) goto L10;
        PinnableContainer.PinnedHandle r101 = r100.pin();
    L11:
        this.parentHandle = r101;
        goto L12
    L10:
        r101 = null;
    L12:
        this.pinsCount++;
        return this;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer.PinnedHandle
    public void release() {
        if (this.isDisposed == false) goto L6;
        return;
    L6:
        if (this.pinsCount <= 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("Release should only be called once");
    L11:
        int r101 = this.pinsCount - 1;
        this.pinsCount = r101;
        if (r101 != 0) goto L18;
        this.pinnedItemList.release$foundation_release(this);
        PinnableContainer.PinnedHandle r102 = this.parentHandle;
        if (r102 == null) goto L16;
        r102.release();
    L16:
        this.parentHandle = null;
        return;
    L18:
        return;
    L8:
        r100 = false;
        goto L9
    }

    public final PinnableContainer getParentPinnableContainer() {
        return get_parentPinnableContainer();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public Object getKey() {
        return this.key;
    }

    private final void set_parentPinnableContainer(PinnableContainer r100) {
        this._parentPinnableContainer$delegate.setValue(r100);
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    public final void setParentPinnableContainer(PinnableContainer r100) {
        Snapshot.Companion r101 = Snapshot.Companion;
        Snapshot r102 = r101.getCurrentThreadSnapshot();
        PinnableContainer.PinnedHandle r103 = null;
        if (r102 == null) goto L5;
        Function1<Object, Unit> r104 = r102.getReadObserver();
    L6:
        Snapshot r105 = r101.makeCurrentNonObservable(r102);
    L20:
        th = move-exception;
        r101.restoreNonObservable(r102, r105, r104);
        throw th;
    L8:
        if (r100 == get_parentPinnableContainer()) goto L17;
        set_parentPinnableContainer(r100);     // Catch: Throwable -> L20
        if (this.pinsCount <= 0) goto L17;
        PinnableContainer.PinnedHandle r106 = this.parentHandle;     // Catch: Throwable -> L20
        if (r106 == null) goto L14;
        r106.release();     // Catch: Throwable -> L20
    L14:
        if (r100 == null) goto L16;
        r103 = r100.pin();     // Catch: Throwable -> L20
    L16:
        this.parentHandle = r103;     // Catch: Throwable -> L20
    L17:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r101.restoreNonObservable(r102, r105, r104);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public LazyLayoutPinnableItem(Object r100, LazyLayoutPinnedItemList r101) {
        this.key = r100;
        this.pinnedItemList = r101;
        this.index = -1;
        this._parentPinnableContainer$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }
}
