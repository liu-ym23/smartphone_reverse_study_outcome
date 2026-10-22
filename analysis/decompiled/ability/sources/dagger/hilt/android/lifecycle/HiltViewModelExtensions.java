package dagger.hilt.android.lifecycle;

import S7.k;
import android.view.ViewModel;
import android.view.viewmodel.CreationExtras;
import android.view.viewmodel.MutableCreationExtras;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"VMF", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/Function1;", "Landroidx/lifecycle/ViewModel;", "callback", "withCreationCallback", "(Landroidx/lifecycle/viewmodel/CreationExtras;LS7/k;)Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "addCreationCallback", "(Landroidx/lifecycle/viewmodel/MutableCreationExtras;LS7/k;)Landroidx/lifecycle/viewmodel/CreationExtras;", "hilt-android_main_java_dagger_hilt_android_lifecycle-hilt_view_model_extensions_internal_kt"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HiltViewModelExtensions {
    public static final <VMF> CreationExtras addCreationCallback(MutableCreationExtras mutableCreationExtras, final k callback) {
        kotlin.jvm.internal.k.f(mutableCreationExtras, "<this>");
        kotlin.jvm.internal.k.f(callback, "callback");
        CreationExtras.Key<k> CREATION_CALLBACK_KEY = HiltViewModelFactory.CREATION_CALLBACK_KEY;
        kotlin.jvm.internal.k.e(CREATION_CALLBACK_KEY, "CREATION_CALLBACK_KEY");
        mutableCreationExtras.set(CREATION_CALLBACK_KEY, new k() { // from class: dagger.hilt.android.lifecycle.HiltViewModelExtensions$addCreationCallback$1$1
            {
                super(1);
            }

            @Override // S7.k
            public final ViewModel invoke(Object obj) {
                return (ViewModel) callback.invoke(obj);
            }
        });
        return mutableCreationExtras;
    }

    public static final <VMF> CreationExtras withCreationCallback(CreationExtras creationExtras, k callback) {
        kotlin.jvm.internal.k.f(creationExtras, "<this>");
        kotlin.jvm.internal.k.f(callback, "callback");
        return addCreationCallback(new MutableCreationExtras(creationExtras), callback);
    }
}
