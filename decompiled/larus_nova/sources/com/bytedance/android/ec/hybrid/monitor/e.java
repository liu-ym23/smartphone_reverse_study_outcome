package com.bytedance.android.ec.hybrid.monitor;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;
import yj.k;

/* JADX INFO: loaded from: classes44.dex */
public final class e<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f47555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f47556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f47557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f47558d;

    public e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        this.f47555a = r100;
        this.f47556b = r101;
        this.f47557c = r102;
        this.f47558d = r103;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        IHybridHostService r100 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L26
        if (r100 == null) goto L41;
        k r101 = r100.getIHybridHostEventService();     // Catch: Throwable -> L26
        if (r101 == null) goto L42;
        String r102 = this.f47555a;     // Catch: Throwable -> L26
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L26
        boolean r104 = f.f47559a;     // Catch: Throwable -> L26
        Iterator r105 = CollectionsKt.listOf(new JSONObject[]{this.f47556b, this.f47557c, this.f47558d}).iterator();     // Catch: Throwable -> L26
    L8:
        if (r105.hasNext() == false) goto L24;
        JSONObject r106 = (JSONObject) r105.next();     // Catch: Throwable -> L26
        if (r106 == null) goto L8;
        Iterator<String> r107 = r106.keys();     // Catch: Throwable -> L26
        if (r107 == null) goto L8;
    L14:
        if (r107.hasNext() == false) goto L8;
        String r108 = r107.next();     // Catch: Throwable -> L26
        String r110 = r106.optString(r108);     // Catch: Throwable -> L26
        if (r110.length() <= 0) goto L18;
        boolean r111 = true;
    L19:
        if (r111 == true) goto L22;
        r110 = null;
    L22:
        if (r110 == null) goto L14;
        r103.put(r108, r110);     // Catch: Throwable -> L26
        goto L14
    L18:
        r111 = false;
        goto L19
    L24:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L26
        r103.put("EVENT_FUNCTION_FEATURE", "TEMAI_MONITOR");     // Catch: Throwable -> L26
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r101.logV3(r102, r103);     // Catch: Throwable -> L26
        return Unit.INSTANCE;
    L42:
        return null;
    L41:
        return null;
    L27:
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
