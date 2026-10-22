package cf7;

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
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f23528c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "pia.internal.trigger", params = {"name", "data", "ext"}, results = {"code", "data", "msg", "type"})
    public final String f23529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f23530b;

    /* JADX INFO: renamed from: cf7.a$a, reason: collision with other inner class name */
    public static final class C0441a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = false)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "ext", required = false)
        Map<String, Object> getExt();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = true)
        String getName();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "data", required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "msg", required = false)
        String getMsg();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = false)
        String getType();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "data", required = true)
        void setData(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = false)
        void setMsg(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "type", required = false)
        void setType(String r100);
    }

    static {
        f23528c = MapsKt.mapOf(TuplesKt.to("TicketID", "36115"));
    }

    public a() {
        this.f23529a = "pia.internal.trigger";
        this.f23530b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f23530b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f23529a;
    }
}
