package com.stepos.core.common.atomic;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import h0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.collections.a;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtomicSdkClientFactory {
    public static final AtomicSdkClientFactory INSTANCE = new AtomicSdkClientFactory();
    private static final String TAG = "AtomicSdkClientFactory";
    private static volatile IAtomicSdkClient cached;

    private AtomicSdkClientFactory() {
    }

    private final IAtomicSdkClient resolve() {
        Object next;
        ClassLoader classLoader = IAtomicSdkClient.class.getClassLoader();
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(IAtomicSdkClient.class, classLoader);
        g.e(serviceLoaderLoad, "load(...)");
        List listO0 = a.O0(serviceLoaderLoad);
        if (listO0.isEmpty()) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "no IAtomicSdkClient via ServiceLoader (classLoader=" + classLoader + "), falling back to inline stub");
            return new AtomicSdkClientStub();
        }
        Iterator it = listO0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!g.b(((IAtomicSdkClient) next).getExecutorId(), AtomicSdkClientStub.EXECUTOR_ID)) {
                break;
            }
        }
        IAtomicSdkClient iAtomicSdkClient = (IAtomicSdkClient) next;
        if (iAtomicSdkClient == null) {
            iAtomicSdkClient = (IAtomicSdkClient) a.t0(listO0);
        }
        LogModule logModule = LogModule.ABILITY;
        String executorId = iAtomicSdkClient.getExecutorId();
        int size = listO0.size();
        ArrayList arrayList = new ArrayList(m.Z(listO0, 10));
        Iterator it2 = listO0.iterator();
        while (it2.hasNext()) {
            arrayList.add(((IAtomicSdkClient) it2.next()).getExecutorId());
        }
        StringBuilder sbF = e.f("resolved IAtomicSdkClient: ", executorId, " (candidates=", size, ", all=");
        sbF.append(arrayList);
        sbF.append(")");
        AIEngineLogger.i(logModule, TAG, sbF.toString());
        return iAtomicSdkClient;
    }

    public final IAtomicSdkClient get() {
        IAtomicSdkClient iAtomicSdkClient = cached;
        if (iAtomicSdkClient != null) {
            return iAtomicSdkClient;
        }
        synchronized (this) {
            IAtomicSdkClient iAtomicSdkClient2 = cached;
            if (iAtomicSdkClient2 != null) {
                return iAtomicSdkClient2;
            }
            IAtomicSdkClient iAtomicSdkClientResolve = INSTANCE.resolve();
            cached = iAtomicSdkClientResolve;
            return iAtomicSdkClientResolve;
        }
    }
}
