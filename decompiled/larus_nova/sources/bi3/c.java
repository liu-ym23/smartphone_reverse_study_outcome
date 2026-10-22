package bi3;

import android.view.View;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformErrorView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements n43.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlatformErrorView f19095a;

    @Override // n43.c
    public final View getView() {
        return this.f19095a;
    }

    public c(PlatformErrorView r100) {
        Intrinsics.checkNotNullParameter(r100, "errorView");
        this.f19095a = r100;
    }

    @Override // n43.a
    public final void a(x43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f19095a.setState(r100);
    }

    @Override // n43.a
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f19095a.setOnCloseClickCallback(r100);
    }

    @Override // n43.a
    public final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f19095a.setOnRetryClickedCallback(r100);
    }
}
