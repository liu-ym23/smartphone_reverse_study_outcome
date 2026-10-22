package com.bytedance.android.sdk.bdticketguard.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f164087a = null;

    static {
        f164087a = new e();
    }

    public e() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        StringBuilder r101 = new StringBuilder("bd-ticket-io-");
        KProperty[] r102 = TGThreadUtils.f164072a;
        r101.append(TGThreadUtils.f164073b.incrementAndGet());
        return new PthreadThreadV2(r100, r101.toString());
    }
}
