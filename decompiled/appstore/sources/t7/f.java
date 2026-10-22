package t7;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.viewmodels.DevAppsViewModel;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ViewModelProvider.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24750e;

    public f(String r10, String r11) {
        q.g(r10, ServerElements.DEVELOPER);
        q.g(r11, "developerId");
        this.f24749d = r10;
        this.f24750e = r11;
    }

    @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10) {
        q.g(r10, "modelClass");
        return new DevAppsViewModel(this.f24749d, this.f24750e);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        return new DevAppsViewModel(this.f24749d, this.f24750e);
    }
}
