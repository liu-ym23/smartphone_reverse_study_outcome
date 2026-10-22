package bra;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a extends XCoreIDLBridgeMethod<InterfaceC0348a, b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f20159c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.fetch", params = {"path", "host", com.alipay.sdk.m.p.e.f25671s, "params", "data", "header"}, results = {"status", "response"})
    public final String f20160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f20161b;

    /* JADX INFO: renamed from: bra.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC0348a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "callbackSchema", required = false)
        String getCallbackSchema();

        @XBridgeParamField(isGetter = true, keyPath = "data", required = false)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = "host", required = false)
        String getHost();

        @XBridgeStringEnum(option = {"GET", "POST"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = false)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "logId", required = false)
        String getLogId();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        String getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "status", required = false)
        Number getStatus();

        @XBridgeParamField(isGetter = false, keyPath = "logId", required = false)
        void setLogId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "status", required = false)
        void setStatus(Number r100);
    }

    public static final class c {
    }

    static {
        f20159c = MapsKt.mapOf(TuplesKt.to("TicketID", "32880"));
    }

    public a() {
        this.f20160a = "account.fetch";
        this.f20161b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f20161b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f20160a;
    }
}
