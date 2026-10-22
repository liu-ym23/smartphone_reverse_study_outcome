package com.bytedance.android.ec.hybrid.card.bridge;

import android.view.View;
import com.bytedance.android.btm.bridge.BtmBridgeProvider;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class CreateBtmChainBridge implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<View> f46397d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46395b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46396c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46394a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreateBtmChainBridge(Function0<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "obtainViewHandler");
        this.f46397d = r100;
        this.f46394a = "createBtmChain";
        this.f46395b = IDLXBridgeMethod.Access.PUBLIC;
        this.f46396c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, final IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        BtmBridgeProvider r103 = BtmBridgeProvider.f42078c;
        JSONObject r104 = cd.a.c(r101);
        View r105 = this.f46397d.invoke();
        Function3<Boolean, Map<String, Object>, String, Unit> r106 = new AnonymousClass1(r102);
        r103.getClass();
        BtmBridgeProvider.c(r104, r105, r106);
    }
}
