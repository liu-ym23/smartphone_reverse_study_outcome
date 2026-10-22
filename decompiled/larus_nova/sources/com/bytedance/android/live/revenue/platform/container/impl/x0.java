package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x0 implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, y> f91360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, u> f91361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f91362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class<? extends com.bytedance.android.scope.j> f91363d;

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final Map<String, u> a() {
        return this.f91361b;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final Class<? extends com.bytedance.android.scope.j> b() {
        return this.f91363d;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final y c(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        if (this.f91360a.isEmpty() == false) goto L18;
        Iterator<Map.Entry<String, u>> r100 = this.f91361b.entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L18;
        Map.Entry<String, u> r101 = r100.next();
        u r102 = r101.getValue();
        ArrayList r103 = new ArrayList();
        Method[] r104 = r102.f91349b.getDeclaredMethods();
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        Method r107 = r104[r106];
        BindsRpc r108 = (BindsRpc) r107.getAnnotation(BindsRpc.class);
        if (r108 == null) goto L12;
        r103.add(new y(r108.rpcName(), r107));
    L12:
        r106 = r106 + 1;
        goto L8
    L13:
        Iterator r109 = r103.iterator();
    L15:
        if (r109.hasNext() == false) goto L6;
        y r112 = (y) r109.next();
        this.f91360a.put(r101.getValue().f91348a + '.' + r112.f91364a, r112);
    L18:
        return this.f91360a.get(r110 + '.' + r111);
    }

    public x0(Map<String, u> r100, Class<?> r101, Class<? extends com.bytedance.android.scope.j> r102) {
        Intrinsics.checkNotNullParameter(r100, "interfaceInfos");
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        Intrinsics.checkNotNullParameter(r102, "scopeCls");
        this.f91361b = r100;
        this.f91362c = r101;
        this.f91363d = r102;
        this.f91360a = new LinkedHashMap();
    }
}
