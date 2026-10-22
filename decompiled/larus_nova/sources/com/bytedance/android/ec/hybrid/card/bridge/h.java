package com.bytedance.android.ec.hybrid.card.bridge;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<View> f46430d;

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
        return this.f46428b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46429c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46427a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function0<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "obtainViewHandler");
        this.f46430d = r100;
        this.f46427a = "setBcmParams";
        this.f46428b = IDLXBridgeMethod.Access.PUBLIC;
        this.f46429c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        jc.b r103 = com.bytedance.android.bcm.api.b.f41761a;
        PageFinder r104 = PageFinder.via(this.f46430d.invoke());
        if (com.bytedance.android.bcm.api.b.f41761a.setBcmParams(r104, r101) == false) goto L5;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("code", 1);
    L6:
        r102.invoke(r105);
        return;
    L5:
        r105 = new LinkedHashMap();
        r105.put("code", 0);
        goto L6
    }
}
