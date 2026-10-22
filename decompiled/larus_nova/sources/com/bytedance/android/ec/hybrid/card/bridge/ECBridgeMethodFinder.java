package com.bytedance.android.ec.hybrid.card.bridge;

import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECBridgeMethodFinder extends MethodFinder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f46398g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f46399h = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f46400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, IDLXBridgeMethod> f46401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f46402f;

    public static final class a {
        public a() {
        }

        public static void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r101, "name");
            HashMap r102 = (HashMap) ((HashMap) ECBridgeMethodFinder.f46398g.getValue()).get(r100);
            if (r102 == null) goto L6;
            IDLXBridgeMethod r103 = (IDLXBridgeMethod) r102.remove(r101);
            return;
        }

        public static void a(String r100, String r101, IDLXBridgeMethod r102) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "lynxBridge");
            Lazy r103 = ECBridgeMethodFinder.f46398g;
            HashMap r104 = (HashMap) ((HashMap) r103.getValue()).get(r100);
            if (r104 != null) goto L5;
            r104 = new HashMap();
            ECBridgeMethodFinder.f46399h.getClass();
            ((HashMap) r103.getValue()).put(r100, r104);
        L5:
            r104.put(r101, r102);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge3";
    }

    static {
        f46399h = new a();
        f46398g = LazyKt.lazy(ECBridgeMethodFinder$Companion$sceneToLynxBridges$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final void j() {
        super.j();
        if (((Boolean) ECHybridSettings.f46246b.getValue()).booleanValue() == false) goto L22;
        Map<String, IDLXBridgeMethod> r100 = this.f46401e;
        if (r100 == null) goto L15;
        Iterator<Map.Entry<String, IDLXBridgeMethod>> r101 = r100.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L15;
        IDLXBridgeMethod r102 = r101.next().getValue();
        if ((r102 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == true) goto L12;
        r102 = null;
    L12:
        com.bytedance.sdk.xbridge.cn.protocol.h r103 = (com.bytedance.sdk.xbridge.cn.protocol.h) r102;
        if (r103 == null) goto L8;
        r103.release();
    L15:
        this.f46401e = null;
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Map<String, IDLXBridgeMethod> r101 = this.f46401e;     // Catch: Throwable -> L25
        if (r101 != null) goto L6;
    L11:
        f46399h.getClass();     // Catch: Throwable -> L25
        HashMap r102 = (HashMap) ((HashMap) f46398g.getValue()).get(this.f46400d);     // Catch: Throwable -> L25
        if (r102 == null) goto L18;
        if (r102.containsKey(r100) != true) goto L18;
        return (IDLXBridgeMethod) r102.get(r100);
    L18:
        if (this.f46402f == false) goto L20;
        return null;
    L20:
        Class<?> r103 = c(r100);     // Catch: Throwable -> L25
        if (r103 != null) goto L23;
        return null;
    L23:
        Method r104 = r103.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L25
        r104.setAccessible(true);     // Catch: Throwable -> L25
        return (IDLXBridgeMethod) r104.invoke(null, new Object[0]);
    L6:
        if (r101.containsKey(r100) != true) goto L11;
        Map<String, IDLXBridgeMethod> r105 = this.f46401e;     // Catch: Throwable -> L25
        if (r105 != null) goto L10;
        return null;
    L10:
        return r105.get(r100);
    L26:
        return null;
    }

    public ECBridgeMethodFinder(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        this.f46400d = r100;
        this.f46401e = r101;
        this.f46402f = false;
    }
}
