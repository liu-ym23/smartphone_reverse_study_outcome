package com.android.ttcjpaysdk.base.paymentbasis.common;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayThreadIncubator implements Runnable {
    static final ExecutorService CACHED_EXECUTOR = null;
    static final ExecutorService FIXED_EXECUTOR = null;
    protected static final AtomicInteger sCount = null;
    private final boolean mBackground;
    private Runnable runnable;

    public CJPayThreadIncubator() {
        this(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_android_ttcjpaysdk_base_paymentbasis_common_CJPayThreadIncubator_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        CACHED_EXECUTOR = PThreadExecutorsUtils.newCachedThreadPool(new CJPaySimpleThreadFactory("CJThreadIncubator-cached", true));
        FIXED_EXECUTOR = PThreadExecutorsUtils.newFixedThreadPool(5, new CJPaySimpleThreadFactory("CJThreadIncubator-fixed", true));
        sCount = new AtomicInteger();
    }

    public void com_android_ttcjpaysdk_base_paymentbasis_common_CJPayThreadIncubator__run$___twin___() {
        Runnable r100 = this.runnable;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    public void start() {
        if (this.mBackground == false) goto L5;
        FIXED_EXECUTOR.submit(this);
        return;
    L5:
        CACHED_EXECUTOR.submit(this);
    }

    public CJPayThreadIncubator(boolean r100) {
        this.mBackground = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_android_ttcjpaysdk_base_paymentbasis_common_CJPayThreadIncubator_com_larus_apm_impl_protector_RunnableLancet_run(CJPayThreadIncubator r100) {
        r100.com_android_ttcjpaysdk_base_paymentbasis_common_CJPayThreadIncubator__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CJPayThreadIncubator(Runnable r100, String r101, boolean r102) {
        this.runnable = r100;
        this.mBackground = r102;
    }
}
