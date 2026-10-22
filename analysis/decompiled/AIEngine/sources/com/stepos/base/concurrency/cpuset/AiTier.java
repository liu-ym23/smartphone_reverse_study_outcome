package com.stepos.base.concurrency.cpuset;

import android.os.SystemClock;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.base.concurrency.data.PoolType;
import kotlin.Result;
import kotlin.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiTier {

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f6205b;

    /* renamed from: a, reason: collision with root package name */
    public static final AiTier f6204a = new AiTier();

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f6206c = true;

    public static PoolType a(PoolType poolType) {
        Object objA;
        if (poolType != PoolType.f6215c) {
            return poolType;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f6205b > 1000) {
            try {
                objA = Boolean.valueOf(AiDispatchers.INSTANCE.canUseRealTime());
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Object obj = Boolean.TRUE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            f6206c = ((Boolean) objA).booleanValue();
            f6205b = jElapsedRealtime;
        }
        return f6206c ? PoolType.f6215c : PoolType.f6216d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object b(zb.a<? extends T> r10, qb.b<? super T> r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.concurrency.cpuset.AiTier.b(zb.a, qb.b):java.lang.Object");
    }
}
