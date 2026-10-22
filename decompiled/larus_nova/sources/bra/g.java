package bra;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;

/* JADX INFO: loaded from: classes34.dex */
public abstract class g extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.getSdkVersion", params = {}, results = {"versionName", RuleConditionBean.VERSION_CODE_KEY})
    public final String f20177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f20178b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = RuleConditionBean.VERSION_CODE_KEY, required = false)
        Integer getVersionCode();

        @XBridgeParamField(isGetter = true, keyPath = "versionName", required = false)
        String getVersionName();

        @XBridgeParamField(isGetter = false, keyPath = RuleConditionBean.VERSION_CODE_KEY, required = false)
        void setVersionCode(Integer r100);

        @XBridgeParamField(isGetter = false, keyPath = "versionName", required = false)
        void setVersionName(String r100);
    }

    public g() {
        this.f20177a = "account.getSdkVersion";
        this.f20178b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f20178b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f20177a;
    }
}
