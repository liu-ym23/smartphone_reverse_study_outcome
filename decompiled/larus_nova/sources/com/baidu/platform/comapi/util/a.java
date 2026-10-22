package com.baidu.platform.comapi.util;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArraySet<b>> f33402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f33403c;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.util.a$a, reason: collision with other inner class name */
    public class RunnableC0668a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f33405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f33406c;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_util_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_util_a$a__run$___twin___() {
            a.a(this.f33406c, this.f33404a, this.f33405b);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_util_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0668a r100) {
            r100.com_baidu_platform_comapi_util_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0668a(a r100, b r101, Object r102) {
            this.f33406c = r100;
            this.f33404a = r101;
            this.f33405b = r102;
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f33407a;

        @Override // com.baidu.platform.comapi.util.a.c
        public void a(Object r100) {
            this.f33407a.a(r100);
        }

        public boolean equals(Object r100) {
            return this.f33407a.equals(r100);
        }
    }

    public interface c {
        void a(Object r100);
    }

    static {
        f33401a = new a();
    }

    private a() {
        this.f33402b = new HashMap();
        this.f33403c = new HashMap();
    }

    public static a a() {
        return f33401a;
    }

    public void a(Object r100) {
        if (this.f33402b.containsKey(r100.getClass()) == false) goto L14;
        monitor-enter(this);
        CopyOnWriteArraySet<b> r101 = this.f33402b.get(r100.getClass());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        Iterator<b> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        MapTaskManager.postToMainThread(new RunnableC0668a(this, r102.next(), r100), 0);
        goto L9
    L18:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void a(c r100, Object r101) {
        r100.a(r101);
    }

    public static /* synthetic */ void a(a r100, c r101, Object r102) {
        r100.a(r101, r102);
    }
}
