package af7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
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

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC0062c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f3207c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.reloadView", params = {""}, results = {"code", "msg"})
    public final String f3208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f3209b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    /* JADX INFO: renamed from: af7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC0062c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "msg", required = false)
        String getMsg();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = false)
        void setMsg(String r100);
    }

    static {
        f3207c = MapsKt.mapOf(TuplesKt.to("TicketID", "25337"));
    }

    public c() {
        this.f3208a = "x.reloadView";
        this.f3209b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f3209b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f3208a;
    }
}
