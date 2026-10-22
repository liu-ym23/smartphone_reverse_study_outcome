package bra;

import com.bytedance.badger.collect.impl.constants.Constants;
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
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes34.dex */
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f20174c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.getCarrierToken", params = {}, results = {"token", Constants.OperatorKey.KEY_CARRIER, "appId"})
    public final String f20175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f20176b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "appId", required = false)
        String getAppId();

        @XBridgeParamField(isGetter = true, keyPath = Constants.OperatorKey.KEY_CARRIER, required = false)
        String getCarrier();

        @XBridgeParamField(isGetter = true, keyPath = "token", required = false)
        String getToken();

        @XBridgeParamField(isGetter = false, keyPath = "appId", required = false)
        void setAppId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = Constants.OperatorKey.KEY_CARRIER, required = false)
        void setCarrier(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "token", required = false)
        void setToken(String r100);
    }

    static {
        f20174c = MapsKt.mapOf(TuplesKt.to("TicketID", "21907"));
    }

    public f() {
        this.f20175a = "account.getCarrierToken";
        this.f20176b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f20176b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f20175a;
    }
}
