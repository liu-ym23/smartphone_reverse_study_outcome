package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC0800c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f44158c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "ec.readPerfSession", params = {"session_id", "stage"}, results = {"common", "stages"})
    public final String f44159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f44160b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "session_id", required = true)
        String getSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "stage", required = false)
        String getStage();
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC0800c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "common", required = false)
        Map<String, Object> getCommon();

        @XBridgeParamField(isGetter = true, keyPath = "stages", required = false)
        List<Object> getStages();

        @XBridgeParamField(isGetter = false, keyPath = "common", required = false)
        void setCommon(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "stages", required = false)
        void setStages(List<? extends Object> r100);
    }

    static {
        f44158c = MapsKt.mapOf(TuplesKt.to("TicketID", "36946"));
    }

    public c() {
        this.f44159a = "ec.readPerfSession";
        this.f44160b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f44160b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f44159a;
    }
}
