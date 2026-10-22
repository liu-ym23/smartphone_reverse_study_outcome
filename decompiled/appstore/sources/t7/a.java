package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.AppCategorySingleViewModel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24743d;

    public a(int r10) {
        this.f24743d = r10;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new AppCategorySingleViewModel(this.f24743d);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new AppCategorySingleViewModel(this.f24743d);
    }
}
