package com.stepos.core.common.atomic;

import android.os.SystemClock;
import com.stepos.core.common.atomic.AtomicDispatchResult;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import f.a;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.random.Random;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class AtomicSdkClientStub implements IAtomicSdkClient {
    public static final Companion Companion = new Companion(null);
    public static final String EXECUTOR_ID = "atomic-sdk-stub";
    private final String tag = "AtomicSdkClientStub";
    private final String executorId = EXECUTOR_ID;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.stepos.core.common.atomic.IAtomicSdkClient
    public AtomicDispatchResult dispatch(AtomicDispatchRequest request) throws InterruptedException {
        g.f(request, "request");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        dc.g gVar = new dc.g(30L, 80L);
        Random.Default random = Random.f10088a;
        g.f(random, "random");
        try {
            try {
                Thread.sleep(a4.a.p(random, gVar));
                AIEngineLogger.d(LogModule.ABILITY, this.tag, "dispatched function=" + request.getFunction() + " params=" + request.getParams().keySet());
                return new AtomicDispatchResult(getExecutorId(), AtomicDispatchResult.Status.SUCCESS, 0, null, null, SystemClock.elapsedRealtime() - jElapsedRealtime, 28, null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new AtomicDispatchResult(getExecutorId(), AtomicDispatchResult.Status.FAILED, -100, "interrupted", null, SystemClock.elapsedRealtime() - jElapsedRealtime, 16, null);
            }
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // com.stepos.core.common.atomic.IAtomicSdkClient
    public String getExecutorId() {
        return this.executorId;
    }
}
