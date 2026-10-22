package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.AppPermissionViewModel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24746d;

    public d(String r10) {
        q.g(r10, "appPackageName");
        this.f24746d = r10;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new AppPermissionViewModel(this.f24746d);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new AppPermissionViewModel(this.f24746d);
    }
}
