package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¨\u0006\b"}, d2 = {"ensureViewModel", "", "Landroidx/fragment/app/Fragment;", "value", "Landroidx/lifecycle/ViewModel;", "keyFactory", "Lkotlin/Function0;", "", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewModelEnsuranceKt {
    public static final void ensureViewModel(Fragment r100, ViewModel r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        ViewModelStore r103 = ViewModelStores.of(r100);
        String r104 = r102.invoke();
        if (r103.get(r104) != null) goto L6;
        r103.put(r104, r101);
        return;
    }
}
