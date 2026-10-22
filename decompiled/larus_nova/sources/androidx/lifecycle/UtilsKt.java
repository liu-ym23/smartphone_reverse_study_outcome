package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\u0007"}, d2 = {"set", "", "Landroidx/lifecycle/ViewModelStore;", "key", "", "value", "Landroidx/lifecycle/ViewModel;", "lib-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class UtilsKt {
    public static final void set(ViewModelStore r100, String r101, ViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "key");
        r100.put(r101, r102);
    }
}
