package X0;

import android.os.Bundle;
import android.util.Log;
import android.view.LifecycleOwner;
import android.view.Q;
import android.view.U;
import android.view.V;
import android.view.y;
import android.view.z;
import androidx.collection.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b extends X0.a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f6819c = false;

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f6820a;

    /* renamed from: b, reason: collision with root package name */
    public final C0118b f6821b;

    public static class a<D> extends y<D> {

        /* renamed from: l, reason: collision with root package name */
        public final int f6822l;

        /* renamed from: m, reason: collision with root package name */
        public final Bundle f6823m;

        /* renamed from: n, reason: collision with root package name */
        public LifecycleOwner f6824n;

        @Override // android.view.AbstractC1404w
        public void g() {
            if (b.f6819c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // android.view.AbstractC1404w
        public void h() {
            if (b.f6819c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.AbstractC1404w
        public void j(z<? super D> zVar) {
            super.j(zVar);
            this.f6824n = null;
        }

        @Override // android.view.y, android.view.AbstractC1404w
        public void k(D d10) {
            super.k(d10);
        }

        public Y0.a<D> l(boolean z10) {
            if (b.f6819c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f6822l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f6823m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            throw null;
        }

        public void n() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f6822l);
            sb2.append(" : ");
            B0.b.a(null, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* renamed from: X0.b$b, reason: collision with other inner class name */
    public static class C0118b extends Q {

        /* renamed from: c, reason: collision with root package name */
        public static final U.c f6825c = new a();

        /* renamed from: a, reason: collision with root package name */
        public u<a> f6826a = new u<>();

        /* renamed from: b, reason: collision with root package name */
        public boolean f6827b = false;

        /* renamed from: X0.b$b$a */
        public static class a implements U.c {
            @Override // androidx.lifecycle.U.c
            public <T extends Q> T c(Class<T> cls) {
                return new C0118b();
            }
        }

        public static C0118b f(V v10) {
            return (C0118b) new U(v10, f6825c).a(C0118b.class);
        }

        @Override // android.view.Q
        public void d() {
            super.d();
            int iK = this.f6826a.k();
            for (int i10 = 0; i10 < iK; i10++) {
                this.f6826a.n(i10).l(true);
            }
            this.f6826a.d();
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f6826a.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f6826a.k(); i10++) {
                    a aVarN = this.f6826a.n(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f6826a.i(i10));
                    printWriter.print(": ");
                    printWriter.println(aVarN.toString());
                    aVarN.m(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            int iK = this.f6826a.k();
            for (int i10 = 0; i10 < iK; i10++) {
                this.f6826a.n(i10).n();
            }
        }
    }

    public b(LifecycleOwner lifecycleOwner, V v10) {
        this.f6820a = lifecycleOwner;
        this.f6821b = C0118b.f(v10);
    }

    @Override // X0.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6821b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // X0.a
    public void c() {
        this.f6821b.g();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        B0.b.a(this.f6820a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
