package com.stepos.core.ota.downloader;

import androidx.appcompat.widget.z0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.DirectExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.b {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f7575g;
    public final /* synthetic */ Object h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f7576i;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3) {
        this.f7575g = obj;
        this.h = obj2;
        this.f7576i = obj3;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
    public Object c(CallbackToFutureAdapter.a aVar) {
        Executor executor = (Executor) this.f7575g;
        String str = (String) this.h;
        zb.a aVar2 = (zb.a) this.f7576i;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        z0 z0Var = new z0(atomicBoolean, 15);
        d0.a<Void> aVar3 = aVar.f1024c;
        if (aVar3 != null) {
            aVar3.a(z0Var, DirectExecutor.f2772a);
        }
        executor.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(atomicBoolean, aVar, aVar2, 2));
        return str;
    }
}
