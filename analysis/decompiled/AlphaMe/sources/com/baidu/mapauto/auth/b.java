package com.baidu.mapauto.auth;

import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.constant.ErrorCode;
import com.baidu.mapauto.auth.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7653a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ILicenseAuthListener f7654b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AuthCore.AuthParam f7655c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AuthCore f7656d;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f7657a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseLicenseAuthDataStandardProcess f7658b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7659c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f7660d;

        public a(HashMap map, BaseLicenseAuthDataStandardProcess baseLicenseAuthDataStandardProcess, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.f7657a = map;
            this.f7658b = baseLicenseAuthDataStandardProcess;
            this.f7659c = atomicReference;
            this.f7660d = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    this.f7657a.putAll(this.f7658b.a(b.this.f7655c.a()));
                } catch (BaseLicenseAuthDataStandardProcess.ProcessException e4) {
                    this.f7659c.set(e4);
                }
            } finally {
                this.f7660d.countDown();
            }
        }
    }

    public b(AuthCore authCore, int i4, AuthCore.b bVar, AuthCore.AuthParam authParam) {
        this.f7656d = authCore;
        this.f7653a = i4;
        this.f7654b = bVar;
        this.f7655c = authParam;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (AuthCore.class) {
            try {
                ArrayList arrayList = new ArrayList(2);
                if ((this.f7653a & 1) == 1) {
                    arrayList.add(this.f7656d.f7639e);
                    LogUtil.getInstance().i(AuthCore.TAG, "添加 license file 授权流程");
                }
                if ((this.f7653a & 2) == 2) {
                    arrayList.add(this.f7656d.f7640f);
                    LogUtil.getInstance().i(AuthCore.TAG, "添加 license function 授权流程");
                }
                if (arrayList.isEmpty()) {
                    this.f7654b.onSuccess(new HashMap(0));
                    return;
                }
                HashMap map = new HashMap();
                CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
                AtomicReference atomicReference = new AtomicReference();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f7656d.f7638d.submit(new a(map, (BaseLicenseAuthDataStandardProcess) it.next(), atomicReference, countDownLatch));
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    atomicReference.set(new BaseLicenseAuthDataStandardProcess.ProcessException(ErrorCode.CODE_INNER_ERROR, "获取数据取消异常"));
                }
                BaseLicenseAuthDataStandardProcess.ProcessException processException = (BaseLicenseAuthDataStandardProcess.ProcessException) atomicReference.get();
                if (processException != null) {
                    this.f7654b.onError(processException.getCode(), processException.getMessage());
                } else {
                    this.f7654b.onSuccess(map);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
