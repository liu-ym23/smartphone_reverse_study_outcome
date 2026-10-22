package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f131528a;

    public f(d r100) {
        this.f131528a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        HashMap<String, d.a> r111 = this.f131528a.f131491a;
        monitor-enter(r111);
        this.f131528a.f131491a.clear();     // Catch: Throwable -> L25
        HashMap r100 = (HashMap) ay1.b.f16714t0.getValue(null, ay1.b.f16675a[86]);     // Catch: Throwable -> L25
        if ((!r100.isEmpty()) == false) goto L22;
        Iterator r101 = r100.entrySet().iterator();     // Catch: Throwable -> L25
        boolean r102 = false;
    L8:
        if (r101.hasNext() == false) goto L19;
        Map.Entry r103 = (Map.Entry) r101.next();     // Catch: Throwable -> L25
        String r104 = (String) r103.getKey();     // Catch: Throwable -> L25
        com.bytedance.android.livesdk.gift.configmodel.g1 r105 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r104);     // Catch: Throwable -> L25
        if (r105 == null) goto L8;
        d.a r106 = new d.a(r105.b());     // Catch: Throwable -> L25
        r106.f131493a = r105.a();     // Catch: Throwable -> L25
        Iterator r107 = ((LinkedHashMap) r103.getValue()).entrySet().iterator();     // Catch: Throwable -> L25
    L13:
        if (r107.hasNext() == false) goto L18;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Throwable -> L25
        if (new PolarisFileWrapper((String) ((Pair) r108.getValue()).getSecond()).exists() == true) goto L16;
        r102 = true;
        goto L13
    L16:
        r106.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L25
        goto L13
    L18:
        this.f131528a.f131491a.put(r104, r106);     // Catch: Throwable -> L25
        goto L8
    L19:
        this.f131528a.c("readFromDisk");     // Catch: Throwable -> L25
        if (r102 == false) goto L22;
        d.a(this.f131528a);     // Catch: Throwable -> L25
    L22:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r111);
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
