package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.B;
import androidx.lifecycle.C;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import q.j;

/* loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f10929c = false;

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0539t f10930a;

    /* renamed from: b, reason: collision with root package name */
    private final C0139b f10931b;

    public static class a<D> extends B<D> {

        /* renamed from: l, reason: collision with root package name */
        private final int f10932l;

        /* renamed from: m, reason: collision with root package name */
        private final Bundle f10933m;

        /* renamed from: n, reason: collision with root package name */
        private InterfaceC0539t f10934n;

        @Override // androidx.lifecycle.AbstractC0545z
        protected void i() {
            if (b.f10929c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.AbstractC0545z
        protected void j() {
            if (b.f10929c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.AbstractC0545z
        public void l(C<? super D> c6) {
            super.l(c6);
            this.f10934n = null;
        }

        @Override // androidx.lifecycle.B, androidx.lifecycle.AbstractC0545z
        public void n(D d6) {
            super.n(d6);
        }

        Y.a<D> o(boolean z5) {
            if (b.f10929c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f10932l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f10933m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void q() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f10932l);
            sb.append(" : ");
            D.b.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0139b extends T {

        /* renamed from: d, reason: collision with root package name */
        private static final U.c f10935d = new a();

        /* renamed from: b, reason: collision with root package name */
        private j<a> f10936b = new j<>();

        /* renamed from: c, reason: collision with root package name */
        private boolean f10937c = false;

        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements U.c {
            a() {
            }

            @Override // androidx.lifecycle.U.c
            public <T extends T> T a(Class<T> cls) {
                return new C0139b();
            }
        }

        C0139b() {
        }

        static C0139b L(W w5) {
            return (C0139b) new U(w5, f10935d).a(C0139b.class);
        }

        @Override // androidx.lifecycle.T
        protected void J() {
            super.J();
            int iK = this.f10936b.k();
            for (int i5 = 0; i5 < iK; i5++) {
                this.f10936b.l(i5).o(true);
            }
            this.f10936b.d();
        }

        public void K(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f10936b.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i5 = 0; i5 < this.f10936b.k(); i5++) {
                    a aVarL = this.f10936b.l(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f10936b.i(i5));
                    printWriter.print(": ");
                    printWriter.println(aVarL.toString());
                    aVarL.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void M() {
            int iK = this.f10936b.k();
            for (int i5 = 0; i5 < iK; i5++) {
                this.f10936b.l(i5).q();
            }
        }
    }

    b(InterfaceC0539t interfaceC0539t, W w5) {
        this.f10930a = interfaceC0539t;
        this.f10931b = C0139b.L(w5);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f10931b.K(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f10931b.M();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        D.b.a(this.f10930a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
