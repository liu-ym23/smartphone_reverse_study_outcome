package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.kmp.ec.yata.chain.event.EventState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements com.bytedance.kmp.ec.yata.chain.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eq.a f49990a;

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final Map<String, Object> a() {
        return this.f49990a.b();
    }

    public final Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> d() {
        Map<String, List<eq.a>> r100 = this.f49990a.c();
        if (r100 == null) goto L26;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L20;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        List r105 = (List) r103.getValue();
        if (r105 == null) goto L17;
        List r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L18;
        eq.a r109 = (eq.a) r108.next();
        if (r109 == null) goto L15;
        Intrinsics.checkNotNullParameter(r109, "$this$toChainBaseEvent");
        g r110 = new g(r109);
    L16:
        r107.add(r110);
        goto L11
    L15:
        r110 = null;
    L18:
        r101.put(r104, r107);
        goto L6
    L17:
        r107 = null;
        goto L18
    L20:
        return r101;
    L26:
        return null;
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final String e() {
        return this.f49990a.a();
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final String getEventName() {
        return this.f49990a.getType();
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final List<com.bytedance.kmp.ec.yata.chain.event.a> b() {
        Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> r100 = d();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(EventState.FAILED.getKey());
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final List<com.bytedance.kmp.ec.yata.chain.event.a> c() {
        Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> r100 = d();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(EventState.SUCCESS.getKey());
    }

    public g(eq.a r100) {
        this.f49990a = r100;
    }
}
