package com.stepos.core.ota.downloader;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.fragment.app.j;
import androidx.work.DirectExecutor;
import com.stepos.core.model.manager.i;
import com.tonyodev.fetch2.Error;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Lambda;
import lb.n;
import r0.c;
import t5.a;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements c.a, CallbackToFutureAdapter.b, a.InterfaceC0147a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f7577g;
    public final /* synthetic */ Object h;

    public /* synthetic */ b(Object obj, Object obj2) {
        this.f7577g = obj;
        this.h = obj2;
    }

    @Override // t5.a.InterfaceC0147a
    public boolean a(int i10, String str) {
        Map mapA;
        r5.d dVar = (r5.d) this.f7577g;
        boolean[] zArr = (boolean[]) this.h;
        if (Thread.currentThread().isInterrupted()) {
            return true;
        }
        try {
            dVar.f11735a.getClass();
            com.stepos.core.ability.text.c cVar = r5.b.f11731b;
            mapA = cVar == null ? Collections.EMPTY_MAP : cVar.a(str);
            if (mapA == null) {
                mapA = Collections.EMPTY_MAP;
            }
        } catch (RuntimeException unused) {
            mapA = Collections.EMPTY_MAP;
        }
        for (Map.Entry entry : mapA.entrySet()) {
            String str2 = (String) entry.getKey();
            Float f8 = dVar.f11736b.get(str2);
            if (f8 != null) {
                r5.a aVar = (r5.a) entry.getValue();
                float f9 = aVar.f11728a;
                if (f9 >= 0.0f && f9 <= 1.0f) {
                    float f10 = aVar.f11729b;
                    if (f10 >= 0.0f && f10 <= 1.0f) {
                        if (f10 > f8.floatValue()) {
                            zArr[0] = true;
                            return true;
                        }
                    }
                }
                throw new IllegalArgumentException(ai.onnxruntime.a.k("model score must be in [0, 1]: head=", str2));
            }
        }
        return false;
    }

    public void b(Object obj) {
        Fetch2DownloadEngine.enqueue$lambda$2((Fetch2DownloadEngine) this.f7577g, (l) this.h, (Error) obj);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.Lambda, zb.a] */
    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
    public Object c(CallbackToFutureAdapter.a aVar) {
        Executor executor = (Executor) this.f7577g;
        ?? r52 = (Lambda) this.h;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.stepos.ability.sdk.client.c cVar = new com.stepos.ability.sdk.client.c(atomicBoolean, 1);
        d0.a<Void> aVar2 = aVar.f1024c;
        if (aVar2 != null) {
            aVar2.a(cVar, DirectExecutor.f2772a);
        }
        executor.execute(new i(atomicBoolean, aVar, r52));
        return n.f10413a;
    }

    @Override // r0.c.a
    public void onCancel() {
        d2.i iVar = (d2.i) this.f7577g;
        j jVar = (j) this.h;
        iVar.cancel();
        jVar.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ b(Executor executor, zb.a aVar) {
        this.f7577g = executor;
        this.h = (Lambda) aVar;
    }
}
