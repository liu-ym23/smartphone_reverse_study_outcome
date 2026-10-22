package com.baidu.mapauto.auth;

import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.util.LogUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f31773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ILicenseAuthListener f31774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AuthCore.AuthParam f31775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AuthCore f31776d;

    /* JADX INFO: renamed from: com.baidu.mapauto.auth.a$a, reason: collision with other inner class name */
    public class RunnableC0634a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f31777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseLicenseAuthDataStandardProcess f31778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f31779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f31780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f31781e;

        public RunnableC0634a(a r100, HashMap r101, BaseLicenseAuthDataStandardProcess r102, AtomicReference r103, CountDownLatch r104) {
            this.f31781e = r100;
            this.f31777a = r101;
            this.f31778b = r102;
            this.f31779c = r103;
            this.f31780d = r104;
        }

        public final void com_baidu_mapauto_auth_a$a__run$___twin___() {
            this.f31777a.putAll(this.f31778b.a(this.f31781e.f31775c.a()));     // Catch: Throwable -> L4 BaseLicenseAuthDataStandardProcess.ProcessException -> L6
        L8:
            this.f31780d.countDown();
            return;
        L4:
            th = move-exception;
            this.f31780d.countDown();
            throw th;
        L6:
            e = move-exception;
            this.f31779c.set(e);     // Catch: Throwable -> L4
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            com_baidu_mapauto_auth_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapauto_auth_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0634a r100) {
            r100.com_baidu_mapauto_auth_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(AuthCore r100, int r101, AuthCore.b r102, AuthCore.AuthParam r103) {
        this.f31776d = r100;
        this.f31773a = r101;
        this.f31774b = r102;
        this.f31775c = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_baidu_mapauto_auth_a_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_baidu_mapauto_auth_a__run$___twin___() {
        monitor-enter(AuthCore.class);
        ArrayList r100 = new ArrayList(2);     // Catch: Throwable -> L31
        if ((this.f31773a & 1) != 1) goto L8;
        r100.add(this.f31776d.f31758e);     // Catch: Throwable -> L31
        LogUtil.getInstance().i(AuthCore.TAG, "添加 license file 授权流程");     // Catch: Throwable -> L31
    L8:
        if ((this.f31773a & 2) != 2) goto L11;
        r100.add(this.f31776d.f31759f);     // Catch: Throwable -> L31
        LogUtil.getInstance().i(AuthCore.TAG, "添加 license function 授权流程");     // Catch: Throwable -> L31
    L11:
        if (r100.isEmpty() == false) goto L15;
        this.f31774b.onSuccess(new HashMap(0));     // Catch: Throwable -> L31
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L31
        return;
    L15:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L31
        CountDownLatch r102 = new CountDownLatch(r100.size());     // Catch: Throwable -> L31
        AtomicReference r110 = new AtomicReference();     // Catch: Throwable -> L31
        Iterator r103 = r100.iterator();     // Catch: Throwable -> L31
    L17:
        if (r103.hasNext() == false) goto L35;
        BaseLicenseAuthDataStandardProcess r104 = (BaseLicenseAuthDataStandardProcess) r103.next();     // Catch: Throwable -> L31
        this.f31776d.f31757d.submit(new RunnableC0634a(this, r101, r104, r110, r102));     // Catch: Throwable -> L31
        goto L17
    L35:
        r102.await();     // Catch: InterruptedException -> L22 Throwable -> L31
    L23:
        BaseLicenseAuthDataStandardProcess.ProcessException r105 = (BaseLicenseAuthDataStandardProcess.ProcessException) r110.get();     // Catch: Throwable -> L31
        if (r105 == null) goto L28;
        this.f31774b.onError(r105.getCode(), r105.getMessage(), r105);     // Catch: Throwable -> L31
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L31
        return;
    L28:
        this.f31774b.onSuccess(r101);     // Catch: Throwable -> L31
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L31
        return;
    L22:
        r110.set(new BaseLicenseAuthDataStandardProcess.ProcessException(-1001, "获取数据取消异常"));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_baidu_mapauto_auth_a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
        r100.com_baidu_mapauto_auth_a__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
