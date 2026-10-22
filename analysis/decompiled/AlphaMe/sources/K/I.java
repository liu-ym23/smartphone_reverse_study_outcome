package K;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class I implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f937a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0088u f938b;

    public I(View view, InterfaceC0088u interfaceC0088u) {
        this.f937a = view;
        this.f938b = interfaceC0088u;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return this.f938b.e(view, z0.f(view, windowInsets)).e();
    }
}
