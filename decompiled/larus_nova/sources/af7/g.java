package af7;

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

/* JADX INFO: loaded from: classes22.dex */
public abstract class g extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f3219c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.showToast", params = {"message", "type", "duration", "icon", "customIcon", "ext"}, results = {""})
    public final String f3220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f3221b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "customIcon", required = false)
        String getCustomIcon();

        @XBridgeParamField(isGetter = true, keyPath = "duration", required = false)
        Number getDuration();

        @XBridgeParamField(isGetter = true, keyPath = "ext", required = false)
        Map<String, Object> getExt();

        @XBridgeStringEnum(option = {"error", "success", "warn"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "icon", required = false)
        String getIcon();

        @XBridgeParamField(isGetter = true, keyPath = "message", required = true)
        String getMessage();

        @XBridgeStringEnum(option = {"error", "success"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "type", required = false)
        String getType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f3219c = MapsKt.mapOf(TuplesKt.to("TicketID", "15577"));
    }

    public g() {
        this.f3220a = "x.showToast";
        this.f3221b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f3221b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f3220a;
    }
}
