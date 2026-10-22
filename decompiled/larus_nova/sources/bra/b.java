package bra;

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
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b extends XCoreIDLBridgeMethod<a, InterfaceC0349b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f20162c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.setVerifyPortraitFlag", params = {ForwardDependency$ForwardLocation.FLAG})
    public final String f20163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f20164b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = ForwardDependency$ForwardLocation.FLAG, required = true)
        String getFlag();
    }

    /* JADX INFO: renamed from: bra.b$b, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC0349b extends XBaseResultModel {
    }

    public static final class c {
    }

    static {
        f20162c = MapsKt.mapOf(TuplesKt.to("TicketID", "37083"));
    }

    public b() {
        this.f20163a = "account.setVerifyPortraitFlag";
        this.f20164b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f20164b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f20163a;
    }
}
