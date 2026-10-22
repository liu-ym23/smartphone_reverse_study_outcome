package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.GiftViewModel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24752e;

    public g(int r10, int r11) {
        this.f24751d = r10;
        this.f24752e = r11;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new GiftViewModel(this.f24751d, this.f24752e);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new GiftViewModel(this.f24751d, this.f24752e);
    }
}
