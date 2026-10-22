package X;

import W.a;
import androidx.lifecycle.InterfaceC0531k;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.X;
import p4.InterfaceC0929b;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f5773a = new j();

    public static final class a implements a.b<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5774a = new a();

        private a() {
        }
    }

    private j() {
    }

    public final W.a a(X x5) {
        j4.k.g(x5, "owner");
        return x5 instanceof InterfaceC0531k ? ((InterfaceC0531k) x5).getDefaultViewModelCreationExtras() : a.C0085a.f5713b;
    }

    public final U.c b(X x5) {
        j4.k.g(x5, "owner");
        return x5 instanceof InterfaceC0531k ? ((InterfaceC0531k) x5).getDefaultViewModelProviderFactory() : c.f5767b;
    }

    public final <T extends T> String c(InterfaceC0929b<T> interfaceC0929b) {
        j4.k.g(interfaceC0929b, "modelClass");
        String strA = k.a(interfaceC0929b);
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + strA;
    }

    public final <VM extends T> VM d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
