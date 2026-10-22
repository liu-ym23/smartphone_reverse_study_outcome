package androidx.loader.app;

import androidx.appcompat.widget.p;
import androidx.collection.e;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.k0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class a extends LoaderManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f3594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0035a f3595b;

    /* JADX INFO: renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    public static class C0035a extends k0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ViewModelProvider.Factory f3596f = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f3597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3598e;

        /* JADX INFO: renamed from: androidx.loader.app.a$a$a, reason: collision with other inner class name */
        public static class C0036a implements ViewModelProvider.Factory {
            public C0036a() {
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public k0 create(Class r10) {
                return new C0035a();
            }
        }

        static {
            f3596f = new C0036a();
        }

        public C0035a() {
            this.f3597d = new e();
            this.f3598e = false;
        }

        public static C0035a g(ViewModelStore r10) {
            return (C0035a) new ViewModelProvider(r10, f3596f).a(C0035a.class);
        }

        @Override // androidx.lifecycle.k0
        public void d() {
            super.d();
            if (this.f3597d.n() > 0) goto L6;
            this.f3597d.b();
            return;
        L6:
            p.a(this.f3597d.o(0));
            throw null;
        }

        public void f(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
            if (this.f3597d.n() <= 0) goto L9;
            r12.print(r10);
            r12.println("Loaders:");
            StringBuilder r14 = new StringBuilder();
            r14.append(r10);
            r14.append("    ");
            if (this.f3597d.n() <= 0) goto L10;
            p.a(this.f3597d.o(0));
            r12.print(r10);
            r12.print("  #");
            r12.print(this.f3597d.j(0));
            r12.print(": ");
            throw null;
        L10:
            return;
        }

        public void h() {
            if (this.f3597d.n() > 0) goto L5;
            return;
        L5:
            p.a(this.f3597d.o(0));
            throw null;
        }
    }

    static {
    }

    public a(LifecycleOwner r10, ViewModelStore r11) {
        this.f3594a = r10;
        this.f3595b = C0035a.g(r11);
    }

    @Override // androidx.loader.app.LoaderManager
    public void a(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        this.f3595b.f(r10, r11, r12, r13);
    }

    @Override // androidx.loader.app.LoaderManager
    public void c() {
        this.f3595b.h();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("LoaderManager{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append(" in ");
        androidx.core.util.a.a(this.f3594a, r10);
        r10.append("}}");
        return r10.toString();
    }
}
