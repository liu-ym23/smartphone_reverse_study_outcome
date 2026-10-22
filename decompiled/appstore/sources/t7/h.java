package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.SubDetailViewModel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24754e;

    public h(int r10, String r11) {
        q.g(r11, "id");
        this.f24753d = r10;
        this.f24754e = r11;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new SubDetailViewModel(this.f24753d, this.f24754e);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new SubDetailViewModel(this.f24753d, this.f24754e);
    }
}
