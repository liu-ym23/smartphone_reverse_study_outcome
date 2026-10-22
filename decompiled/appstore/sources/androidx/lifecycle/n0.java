package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;

/* JADX INFO: loaded from: classes.dex */
public abstract class n0 {
    public static final CreationExtras a(ViewModelStoreOwner r10) {
        kotlin.jvm.internal.q.g(r10, "owner");
        if ((r10 instanceof HasDefaultViewModelProviderFactory) == false) goto L6;
        return ((HasDefaultViewModelProviderFactory) r10).getDefaultViewModelCreationExtras();
    L6:
        return CreationExtras.a.f3577b;
    }
}
