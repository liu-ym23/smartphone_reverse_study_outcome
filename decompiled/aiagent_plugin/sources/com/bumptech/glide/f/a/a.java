package com.bumptech.glide.f.a;

import android.util.Log;
import androidx.core.util.f;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "FactoryPools";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d<Object> f3315a = null;

    /* JADX INFO: renamed from: com.bumptech.glide.f.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    public interface InterfaceC0086a<T> {
        T b();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class b<T> implements f.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0086a<T> f3316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<T> f3317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f.a<T> f3318c;

        b(f.a<T> r3, InterfaceC0086a<T> r4, d<T> r5) {
            f.a<T> r6 = (f.a) ZeusTransformUtils.wrapperContextForParams(r3, f.a.class, "com.obric.aiagent.plugin");
            InterfaceC0086a<T> r7 = (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0086a.class, "com.obric.aiagent.plugin");
            d<T> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f3318c = r6;
            this.f3316a = r7;
            this.f3317b = r8;
        }

        @Override // androidx.core.util.f.a
        public T a() {
            T r0 = this.f3318c.a();
            if (r0 != null) goto L8;
            r0 = this.f3316a.b();
            if (a(a.TAG, 2) == false) goto L8;
            a(a.TAG, "Created new " + r0.getClass());
        L8:
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L10;
            ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).b_().a(false);
        L10:
            return r0;
        }

        @Override // androidx.core.util.f.a
        public boolean a(T r3) {
            if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L5;
            ((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).b_().a(true);
        L5:
            this.f3317b.a(r3);
            return this.f3318c.a(r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean a(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface c {
        com.bumptech.glide.f.a.c b_();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d<T> {
        void a(T r1);
    }

    static {
        f3315a = new AnonymousClass1();
    }

    public static <T extends c> f.a<T> a(int r2, InterfaceC0086a<T> r3) {
        InterfaceC0086a r4 = (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0086a.class, "com.obric.aiagent.plugin");
        return a(new f.c(r2), r4);
    }

    public static <T> f.a<List<T>> a() {
        return a(20);
    }

    public static <T> f.a<List<T>> a(int r2) {
        return a(new f.c(r2), new AnonymousClass2(), new AnonymousClass3());
    }

    private static <T extends c> f.a<T> a(f.a<T> r2, InterfaceC0086a<T> r3) {
        return a((f.a) ZeusTransformUtils.wrapperContextForParams(r2, f.a.class, "com.obric.aiagent.plugin"), (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0086a.class, "com.obric.aiagent.plugin"), b());
    }

    private static <T> f.a<T> a(f.a<T> r2, InterfaceC0086a<T> r3, d<T> r4) {
        return new b((f.a) ZeusTransformUtils.wrapperContextForParams(r2, f.a.class, "com.obric.aiagent.plugin"), (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0086a.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    private static <T> d<T> b() {
        return (d<T>) f3315a;
    }
}
