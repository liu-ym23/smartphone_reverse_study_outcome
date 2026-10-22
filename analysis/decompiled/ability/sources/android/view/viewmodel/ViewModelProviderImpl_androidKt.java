package android.view.viewmodel;

import M.a;
import Z7.d;
import android.view.ViewModel;
import android.view.ViewModelProvider;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "LZ7/d;", "modelClass", "Landroidx/lifecycle/viewmodel/CreationExtras;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "createViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;LZ7/d;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelProviderImpl_androidKt {
    public static final <VM extends ViewModel> VM createViewModel(ViewModelProvider.Factory factory, d modelClass, CreationExtras extras) {
        k.f(factory, "factory");
        k.f(modelClass, "modelClass");
        k.f(extras, "extras");
        try {
            try {
                return (VM) factory.create(modelClass, extras);
            } catch (AbstractMethodError unused) {
                return (VM) factory.create(a.Z(modelClass));
            }
        } catch (AbstractMethodError unused2) {
            return (VM) factory.create(a.Z(modelClass), extras);
        }
    }
}
