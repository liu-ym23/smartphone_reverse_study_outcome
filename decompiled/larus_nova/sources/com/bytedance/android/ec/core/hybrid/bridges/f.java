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
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f44167c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "mall.deliveryRecord", params = {"sessionID", ReportConstant.COMMON_ACTION_TYPE, "isSuccess", "deliveryRecord", "timestamp", "deliveryStage"}, results = {"deliveryInfo"})
    public final String f44168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f44169b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = ReportConstant.COMMON_ACTION_TYPE, required = true)
        String getActionType();

        @XBridgeParamField(isGetter = true, keyPath = "deliveryRecord", required = false)
        Object getDeliveryRecord();

        @XBridgeParamField(isGetter = true, keyPath = "deliveryStage", required = false)
        String getDeliveryStage();

        @XBridgeParamField(isGetter = true, keyPath = "sessionID", required = true)
        String getSessionID();

        @XBridgeParamField(isGetter = true, keyPath = "timestamp", required = false)
        Long getTimestamp();

        @XBridgeParamField(isGetter = true, keyPath = "isSuccess", required = false)
        Boolean isSuccess();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "deliveryInfo", required = false)
        Object getDeliveryInfo();

        @XBridgeParamField(isGetter = false, keyPath = "deliveryInfo", required = false)
        void setDeliveryInfo(Object r100);
    }

    static {
        f44167c = MapsKt.mapOf(TuplesKt.to("TicketID", "35868"));
    }

    public f() {
        this.f44168a = "mall.deliveryRecord";
        this.f44169b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f44169b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f44168a;
    }
}
