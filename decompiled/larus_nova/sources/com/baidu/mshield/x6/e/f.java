package com.baidu.mshield.x6.e;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f32591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f32592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f32593c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f32594a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mshield_x6_e_f$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_x6_e_f$a__run$___twin___() {
            f r100 = this.f32594a;     // Catch: Throwable -> L4
            f.a(r100, f.a(r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            com.baidu.mshield.x6.f.f.b(th);
        }

        public a(f r100) {
            this.f32594a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_x6_e_f$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mshield_x6_e_f$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(Context r100) {
        this.f32593c = new a(this);
        this.f32592b = r100;
    }

    public static f b(Context r100) {
        if (f32591a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f32591a != null) goto L9;
        f32591a = new f(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f32591a;
    }

    public final void a(Context r100) {
    L13:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
        return;
    L3:
        if (com.baidu.mshield.b.a.d.b(r100) == false) goto L18;
        com.baidu.mshield.b.c.a.a(" doDelayWork ");     // Catch: Throwable -> L13
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L13
        if (com.baidu.mshield.x6.f.f.c().equals(r101.c()) == true) goto L8;
        h.a(r100).a(1, true);     // Catch: Throwable -> L13
    L8:
        if (r101.n() == false) goto L10;
        return;
    L10:
        if (h.f32597b == true) goto L20;
        h.a(r100).a(4);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    }

    public synchronized void a(long r100) {
        monitor-enter(this);
        com.baidu.mshield.b.c.a.a("startCheckDelayTime=" + r100);     // Catch: Throwable -> L6
        com.baidu.mshield.x6.f.c.b().postDelayed(this.f32593c, r100);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Context a(f r100) {
        return r100.f32592b;
    }

    public static /* synthetic */ void a(f r100, Context r101) {
        r100.a(r101);
    }
}
