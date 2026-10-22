package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

/* JADX INFO: loaded from: classes.dex */
public class i extends NavController {
    public i(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10);
    }

    @Override // androidx.navigation.NavController
    public final void d0(LifecycleOwner r10) {
        kotlin.jvm.internal.q.g(r10, "owner");
        super.d0(r10);
    }

    @Override // androidx.navigation.NavController
    public final void e0(OnBackPressedDispatcher r10) {
        kotlin.jvm.internal.q.g(r10, "dispatcher");
        super.e0(r10);
    }

    @Override // androidx.navigation.NavController
    public final void f0(ViewModelStore r10) {
        kotlin.jvm.internal.q.g(r10, "viewModelStore");
        super.f0(r10);
    }

    @Override // androidx.navigation.NavController
    public final void r(boolean r10) {
        super.r(r10);
    }
}
