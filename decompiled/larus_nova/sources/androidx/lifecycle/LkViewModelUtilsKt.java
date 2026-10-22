package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"putViewModel", "", "Landroidx/lifecycle/ViewModelStore;", "key", "", "vm", "Landroidx/lifecycle/ViewModel;", "todo_productionChinaRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LkViewModelUtilsKt {
    public static final void putViewModel(ViewModelStore r100, String r101, ViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "vm");
        r100.put(r101, r102);
    }
}
