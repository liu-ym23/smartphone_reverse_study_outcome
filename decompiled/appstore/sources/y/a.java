package y;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b[] f25878a;

    public a(b... r10) {
        q.g(r10, "initializers");
        this.f25878a = r10;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public k0 create(Class r10, CreationExtras r11) {
        q.g(r10, "modelClass");
        q.g(r11, "extras");
        b[] r12 = this.f25878a;
        if (r12.length <= 0) goto L5;
        b r13 = r12[0];
        throw null;
    L5:
        throw new IllegalArgumentException("No initializer set for given class " + r10.getName());
    }
}
