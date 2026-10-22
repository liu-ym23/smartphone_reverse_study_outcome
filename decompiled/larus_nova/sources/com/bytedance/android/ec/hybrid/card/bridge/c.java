package com.bytedance.android.ec.hybrid.card.bridge;

import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.locallife.bridge.common.method.i;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g66.c f46410d;

    public static final class a {
    }

    public static class b implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ies.xbridge.IDLXBridgeMethod f46411a;

        public static final class a implements com.bytedance.ies.xbridge.IDLXBridgeMethod.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IDLXBridgeMethod.a f46412a;

            public a(IDLXBridgeMethod.a r100) {
                this.f46412a = r100;
            }

            @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.a
            public final void invoke(Map<String, ? extends Object> r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f46412a.invoke(r100);
            }
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final boolean canRunInBackground() {
            com.bytedance.ies.xbridge.IDLXBridgeMethod r100 = this.f46411a;
            if ((r100 instanceof v56.c) == false) goto L5;
            v56.c r101 = (v56.c) r100;
            r101.getClass();
            return r101 instanceof i;
        L5:
            return false;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Access getAccess() {
            com.bytedance.ies.xbridge.IDLXBridgeMethod.Access r100 = this.f46411a.getAccess();
            int r101 = d.f46413a[r100.ordinal()];
            if (r101 != 1) goto L5;
            IDLXBridgeMethod.Access r102 = IDLXBridgeMethod.Access.PUBLIC;
        L15:
            if (r102 == null) goto L17;
            return r102;
        L17:
            return IDLXBridgeMethod.Access.PRIVATE;
        L5:
            if (r101 != 2) goto L7;
            r102 = IDLXBridgeMethod.Access.PRIVATE;
            goto L15
        L7:
            if (r101 != 3) goto L9;
            r102 = IDLXBridgeMethod.Access.PROTECT;
            goto L15
        L9:
            if (r101 == 4) goto L11;
            r102 = null;
            goto L15
        L11:
            r102 = IDLXBridgeMethod.Access.SECURE;
            goto L15
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final String getName() {
            return this.f46411a.getName();
        }

        @Override // com.bytedance.sdk.xbridge.cn.protocol.h
        public final void release() {
            this.f46411a.release();
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Compatibility getCompatibility() {
            return IDLXBridgeMethod.Compatibility.Compatible;
        }

        public b(com.bytedance.ies.xbridge.IDLXBridgeMethod r100) {
            Intrinsics.checkNotNullParameter(r100, "methodImpl");
            this.f46411a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
            Intrinsics.checkNotNullParameter(r100, "bridgeContext");
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.f46411a.d(r101, new a(r102), XBridgePlatformType.ALL);     // Catch: Throwable -> L5
            return;
        L5:
            getName();
        }
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge2";
    }

    public c() {
        this.f46410d = new g66.c();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final void j() {
        super.j();
        if (((Boolean) ECHybridSettings.f46246b.getValue()).booleanValue() == false) goto L6;
        this.f46410d.g();
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L10
        r102.setAccessible(true);     // Catch: Throwable -> L10
        com.bytedance.ies.xbridge.IDLXBridgeMethod r103 = (com.bytedance.ies.xbridge.IDLXBridgeMethod) r102.invoke(null, new Object[0]);     // Catch: Throwable -> L10
        if (r103 == null) goto L11;
        r103.setProviderFactory(this.f46410d);     // Catch: Throwable -> L10
        return new b(r103);
    L11:
        return null;
    }
}
