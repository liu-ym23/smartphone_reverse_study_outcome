package androidx.loader.a;

import android.os.Bundle;
import android.util.Log;
import androidx.b.h;
import androidx.lifecycle.aj;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.loader.content.Loader;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LoaderManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b extends androidx.loader.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f2086a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f2087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f2088c;

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class a<D> extends v<D> implements Loader.a<D> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2089e;
        private final Bundle f;
        private final Loader<D> g;
        private p h;
        private C0065b<D> i;
        private Loader<D> j;

        Loader<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        public void b() {
            if (b.f2086a == false) goto L5;
            a("LoaderManager", "  Starting: " + this);
        L5:
            this.g.a();
        }

        @Override // androidx.lifecycle.LiveData
        public void c() {
            if (b.f2086a == false) goto L5;
            a("LoaderManager", "  Stopping: " + this);
        L5:
            this.g.g();
        }

        void f() {
            p r0 = this.h;
            C0065b<D> r1 = this.i;
            if (r0 == null) goto L7;
            if (r1 == null) goto L8;
            super.b(r1);
            a(r0, r1);
            return;
        L8:
            return;
        }

        @Override // androidx.lifecycle.LiveData
        public void b(w<? super D> r3) {
            super.b((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin"));
            this.h = null;
            this.i = null;
        }

        Loader<D> a(boolean r3) {
            if (b.f2086a == false) goto L5;
            a("LoaderManager", "  Destroying: " + this);
        L5:
            this.g.c();
            this.g.i();
            C0065b<D> r0 = this.i;
            if (r0 == null) goto L10;
            b(r0);
            if (r3 == false) goto L10;
            r0.b();
        L10:
            this.g.a(this);
            if (r0 != null) goto L13;
        L14:
            if (r3 == false) goto L18;
        L15:
            this.g.k();
            return this.j;
        L18:
            return this.g;
        L13:
            if (r0.a() == false) goto L15;
            goto L14
        }

        @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
        public void b(D r1) {
            super.b(r1);
            Loader<D> r2 = this.j;
            if (r2 == null) goto L6;
            r2.k();
            this.j = null;
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(64);
            r0.append("LoaderInfo{");
            r0.append(Integer.toHexString(System.identityHashCode(this)));
            r0.append(" #");
            r0.append(this.f2089e);
            r0.append(" : ");
            androidx.core.util.b.a(this.g, r0);
            r0.append("}}");
            return r0.toString();
        }

        public void a(String r4, FileDescriptor r5, PrintWriter r6, String[] r7) {
            r6.print(r4);
            r6.print("mId=");
            r6.print(this.f2089e);
            r6.print(" mArgs=");
            r6.println(this.f);
            r6.print(r4);
            r6.print("mLoader=");
            r6.println(this.g);
            this.g.a(r4 + "  ", r5, r6, r7);
            if (this.i == null) goto L5;
            r6.print(r4);
            r6.print("mCallbacks=");
            r6.println(this.i);
            this.i.a(r4 + "  ", r6);
        L5:
            r6.print(r4);
            r6.print("mData=");
            r6.println(e().a(a()));
            r6.print(r4);
            r6.print("mStarted=");
            r6.println(d());
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    /* JADX INFO: renamed from: androidx.loader.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    static class C0065b<D> implements w<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Loader<D> f2090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.loader.a.a.InterfaceC0064a<D> f2091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2092c;

        @Override // androidx.lifecycle.w
        public void onChanged(D r3) {
            if (b.f2086a == false) goto L5;
            a("LoaderManager", "  onLoadFinished in " + this.f2090a + ": " + this.f2090a.a(r3));
        L5:
            this.f2091b.a(this.f2090a, r3);
            this.f2092c = true;
        }

        boolean a() {
            return this.f2092c;
        }

        void b() {
            if (this.f2092c == true) goto L5;
            return;
        L5:
            if (b.f2086a == false) goto L7;
            a("LoaderManager", "  Resetting: " + this.f2090a);
        L7:
            this.f2091b.a(this.f2090a);
        }

        public String toString() {
            return this.f2091b.toString();
        }

        public void a(String r1, PrintWriter r2) {
            r2.print(r1);
            r2.print("mDeliveredData=");
            r2.println(this.f2092c);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    static class c extends aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final am.b f2093a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h<a> f2094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2095c;

        c() {
            this.f2094b = new h();
            this.f2095c = false;
        }

        static {
            f2093a = new AnonymousClass1();
        }

        static c a(ao r3) {
            return (c) ZeusTransformUtils.preCheckCast(new am(r3, f2093a).a(c.class), c.class, "com.obric.aiagent.plugin");
        }

        void b() {
            int r0 = this.f2094b.b();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((a) ZeusTransformUtils.preCheckCast(this.f2094b.d(r1), a.class, "com.obric.aiagent.plugin")).f();
            r1 = r1 + 1;
            goto L3
        }

        @Override // androidx.lifecycle.aj
        public void a() {
            super.a();
            int r0 = this.f2094b.b();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((a) ZeusTransformUtils.preCheckCast(this.f2094b.d(r1), a.class, "com.obric.aiagent.plugin")).a(true);
            r1 = r1 + 1;
            goto L3
        L5:
            this.f2094b.c();
        }

        public void a(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
            if (this.f2094b.b() <= 0) goto L8;
            r8.print(r6);
            r8.println("Loaders:");
            String r0 = r6 + "    ";
            int r1 = 0;
        L6:
            if (r1 >= this.f2094b.b()) goto L10;
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f2094b.d(r1), a.class, "com.obric.aiagent.plugin");
            r8.print(r6);
            r8.print("  #");
            r8.print(this.f2094b.c(r1));
            r8.print(": ");
            r8.println(r2.toString());
            r2.a(r0, r7, r8, r9);
            r1 = r1 + 1;
            goto L6
        L10:
            return;
        }
    }

    static {
    }

    b(p r3, ao r4) {
        this.f2087b = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        this.f2088c = c.a(r4);
    }

    @Override // androidx.loader.a.a
    public void a() {
        this.f2088c.b();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("LoaderManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        androidx.core.util.b.a(this.f2087b, r0);
        r0.append("}}");
        return r0.toString();
    }

    @Override // androidx.loader.a.a
    @Deprecated
    public void a(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        this.f2088c.a(r1, r2, r3, r4);
    }
}
