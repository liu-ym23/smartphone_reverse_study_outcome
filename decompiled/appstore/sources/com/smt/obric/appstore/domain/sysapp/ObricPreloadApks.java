package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.ServiceManager;
import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.oapplet.OAppletUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricPreloadApks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricPreloadApks f18094a = null;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0219a f18095d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f18096e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f18098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f18099c;

        /* JADX INFO: renamed from: com.smt.obric.appstore.domain.sysapp.ObricPreloadApks$a$a, reason: collision with other inner class name */
        public static final class C0219a {
            public /* synthetic */ C0219a(DefaultConstructorMarker r10) {
                this();
            }

            public final a a(Integer r10, Throwable r11) {
                return new a(true, r10, r11);
            }

            public final a b() {
                return a.a();
            }

            public C0219a() {
            }
        }

        static {
            f18095d = new C0219a(null);
            boolean r10 = false;
            Integer r11 = null;
            Throwable r12 = null;
            f18096e = new a(r10, r11, r12, 6, null);
        }

        public a(boolean r10, Integer r11, Throwable r12) {
            this.f18097a = r10;
            this.f18098b = r11;
            this.f18099c = r12;
        }

        public static final /* synthetic */ a a() {
            return f18096e;
        }

        public final Throwable b() {
            return this.f18099c;
        }

        public final boolean c() {
            return this.f18097a;
        }

        public final Integer d() {
            return this.f18098b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f18097a == r11.f18097a) goto L12;
            return false;
        L12:
            if (q.b(this.f18098b, r11.f18098b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f18099c, r11.f18099c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r10 = Boolean.hashCode(this.f18097a) * 31;
            Integer r11 = this.f18098b;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            Throwable r15 = this.f18099c;
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            return r14 + r12;
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "HandlePreloadApkInstallResult(handled=" + this.f18097a + ", packageManagerInstallCode=" + this.f18098b + ", err=" + this.f18099c + ')';
        }

        public /* synthetic */ a(boolean r10, Integer r11, Throwable r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = null;
        L8:
            this(r10, r11, r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18100a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f18101a = null;

            static {
                f18101a = new a();
            }

            public a() {
            }

            public final Object a() {
                Object r10 = c();
                if (r10 != null) goto L7;
                return null;
            L7:
                return e(r10, "getDeletedSystemApp");
            }

            public final List b() {
                Object r10 = a();
                if (r10 != null) goto L6;
                j.n("[ZTE] getDeletedSystemAppSlice() return null " + r10);
                return t.i();
            L6:
                ArrayList r11 = null;
                Result.a r12 = Result.Companion;     // Catch: Throwable -> L9
                Object r13 = Result.m35constructorimpl(r10.getClass().getMethod("getList", null).invoke(r10, null));     // Catch: Throwable -> L9
            L12:
                if (Result.m41isFailureimpl(r13) == false) goto L15;
                r13 = null;
            L15:
                if ((r13 instanceof List) == false) goto L17;
                List r14 = (List) r13;
            L18:
                if (r14 == null) goto L29;
                ArrayList r15 = new ArrayList();
                Iterator r16 = r14.iterator();
            L21:
                if (r16.hasNext() == false) goto L28;
                Object r17 = r16.next();
                if ((r17 instanceof PackageInfo) == false) goto L25;
                PackageInfo r18 = (PackageInfo) r17;
            L26:
                if (r18 == null) goto L21;
                r15.add(r18);
                goto L21
            L25:
                r18 = null;
                goto L26
            L28:
                r11 = r15;
            L29:
                if (r11 == null) goto L31;
                return r11;
            L31:
                return t.i();
            L17:
                r14 = null;
            L9:
                th = move-exception;
                Result.a r19 = Result.Companion;
                r13 = Result.m35constructorimpl(kotlin.c.a(th));
                goto L12
            }

            public final Object c() {
                Result.a r10 = Result.Companion;     // Catch: Throwable -> L4
                Object r11 = Result.m35constructorimpl(ServiceManager.getService("package"));     // Catch: Throwable -> L4
            L7:
                if (Result.m41isFailureimpl(r11) == false) goto L9;
                r11 = null;
            L9:
                IBinder r12 = (IBinder) r11;
                if (r12 != null) goto L23;
                return null;
            L23:
                Object r13 = Result.m35constructorimpl(IPackageManager.Stub.asInterface(r12));     // Catch: Throwable -> L14
            L17:
                if (Result.m41isFailureimpl(r13) == false) goto L20;
                return null;
            L20:
                return r13;
            L14:
                th = move-exception;
                Result.a r14 = Result.Companion;
                r13 = Result.m35constructorimpl(kotlin.c.a(th));
            L4:
                th = move-exception;
                Result.a r15 = Result.Companion;
                r11 = Result.m35constructorimpl(kotlin.c.a(th));
                goto L7
            }

            public final Object d(Object r10, String r11, Object... r12) {
                ArrayList r13 = new ArrayList(r12.length);
                int r14 = r12.length;
                int r15 = 0;
            L3:
                if (r15 >= r14) goto L5;
                r13.add(r12[r15].getClass());
                r15 = r15 + 1;
                goto L3
            L5:
                Class[] r16 = (Class[]) r13.toArray(new Class[0]);
                return r10.getClass().getMethod(r11, (Class[]) Arrays.copyOf(r16, r16.length)).invoke(r10, Arrays.copyOf(r12, r12.length));
            }

            public final Object e(Object r10, String r11) {
                return r10.getClass().getMethod(r11, null).invoke(r10, null);
            }

            public final Boolean f(String r10) {
                q.g(r10, "packageName");
                Object r11 = c();
                if (r11 != null) goto L5;
                return null;
            L5:
                Object r12 = d(r11, "isRemovableSysApp", new Object[]{r10});
                if (r12 != null) goto L9;
                return null;
            L9:
                if ((r12 instanceof Boolean) == true) goto L11;
                return null;
            L11:
                return (Boolean) r12;
            }

            public final Boolean g(String r10, String r11) {
                q.g(r10, "scanPath");
                q.g(r11, "packageName");
                Object r12 = c();
                if (r12 != null) goto L5;
                return null;
            L5:
                Object r13 = d(r12, "recoveryRemovableSystemApp", new Object[]{r10, r11});
                if (r13 != null) goto L8;
                return null;
            L8:
                j.n("[ZTE] recoveryRemovableSystemApp res=" + r13 + ", scanPath=" + r10 + ", packageName=" + r11);
                if ((r13 instanceof Boolean) == true) goto L11;
                return null;
            L11:
                return (Boolean) r13;
            }
        }

        static {
            f18100a = new b();
        }

        public b() {
        }

        public final String a(String r10) {
            q.g(r10, "sourcePath");
            return "apkfile://com.obric.appstore.zte/" + r10;
        }

        public final String b(String r10) {
            q.g(r10, "path");
            if (c(r10) == true) goto L7;
            return null;
        L7:
            return StringsKt__StringsKt.f0(r10, "apkfile://com.obric.appstore.zte/");
        }

        public final boolean c(String r10) {
            q.g(r10, "path");
            return o.B(r10, "apkfile://com.obric.appstore.zte/", false, 2, null);
        }
    }

    static {
        f18094a = new ObricPreloadApks();
    }

    public ObricPreloadApks() {
    }

    public final a a(Context r10, com.smt.obric.appstore.domain.app.entity.a r11) {
        q.g(r10, "context");
        q.g(r11, "appInstallTask");
        String r12 = r11.e();
        if (r12 == null) goto L28;
        b r13 = b.f18100a;
        if (r13.c(r12) != true) goto L28;
        String r14 = r13.b(r12);
        if (r14 == null) goto L9;
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L12
        Object r16 = Result.m35constructorimpl(b.a.f18101a.g(r14, r11.E()));     // Catch: Throwable -> L12
    L14:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L18;
        j.q("[ZTE] recoveryRemovableSystemApp fail,", r17);
    L18:
        if (Result.m41isFailureimpl(r16) == false) goto L20;
        Object r18 = null;
    L21:
        Boolean r19 = (Boolean) r18;
        j.n("[ZTE] handlePreloadApkInstall succ=" + r19 + ", err=" + Result.m38exceptionOrNullimpl(r16));
        if (q.b(r19, Boolean.FALSE) == false) goto L24;
        Throwable r20 = new IllegalStateException("[ZTE] gerecoveryRemovableSystemApp return false, pkg=" + r11.E() + ", name=" + r11.f() + ",path=" + r14);
    L26:
        return a.f18095d.a(null, r20);
    L24:
        r20 = Result.m38exceptionOrNullimpl(r16);
        goto L26
    L20:
        r18 = r16;
    L12:
        th = move-exception;
        Result.a r21 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L14
    L9:
        return a.f18095d.a(null, new IllegalStateException("ZTE.getDeletedSysAppSourcePath null"));
    L28:
        if (OAppletUtil.f18065a.g(r11.E()) == false) goto L32;
        h.f(null, new ObricPreloadApks$handlePreloadApkInstall$2(r10, r11, null), 1, null);
        return a.f18095d.a(null, null);
    L32:
        return a.f18095d.b();
    }
}
