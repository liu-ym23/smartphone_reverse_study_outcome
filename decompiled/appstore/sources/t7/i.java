package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.TopicViewModel;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f24757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24758g;

    public i(String r10, int r11, int r12, int r13) {
        q.g(r10, "id");
        this.f24755d = r10;
        this.f24756e = r11;
        this.f24757f = r12;
        this.f24758g = r13;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new TopicViewModel(this.f24755d, this.f24756e, this.f24757f, this.f24758g);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new TopicViewModel(this.f24755d, this.f24756e, this.f24757f, this.f24758g);
    }
}
