package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f44152c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "ec.anniePrerender", params = {"expiredTime", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "schema"})
    public final String f44153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f44154b;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.a$a, reason: collision with other inner class name */
    public static final class C0798a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "expiredTime", required = false)
        Number getExpiredTime();

        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();

        @XBridgeParamField(isGetter = true, keyPath = BdpAppEventConstant.PARAMS_STRATEGY_NAME, required = true)
        String getStrategy();
    }

    static {
        f44152c = MapsKt.mapOf(TuplesKt.to("TicketID", "28252"));
    }

    public a() {
        this.f44153a = "ec.anniePrerender";
        this.f44154b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f44154b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f44153a;
    }
}
