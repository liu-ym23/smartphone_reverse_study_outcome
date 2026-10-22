package af7;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class d extends XCoreIDLBridgeMethod<InterfaceC0063d, e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f3210c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.showActionSheet", params = {"title", "subtitle", SlcCommonAction.KEY_ACTIONS}, results = {"action", "detail"})
    public final String f3211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f3212b;

    public static final class a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "subtitle", required = false)
        String getSubtitle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeStringEnum(option = {"default", "warn"})
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "default", type = DefaultType.STRING), isEnum = true, isGetter = true, keyPath = "type", required = true)
        String getType();
    }

    public interface c extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "index", required = true)
        Number getIndex();

        @XBridgeParamField(isGetter = false, keyPath = "index", required = true)
        void setIndex(Number r100);
    }

    /* JADX INFO: renamed from: af7.d$d, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC0063d extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = SlcCommonAction.KEY_ACTIONS, nestedClassType = b.class, required = true)
        List<b> getActions();

        @XBridgeParamField(isGetter = true, keyPath = "subtitle", required = false)
        String getSubtitle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();
    }

    @XBridgeResultModel
    public interface e extends XBaseResultModel {
        @XBridgeStringEnum(option = {"dismiss", "select"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "action", required = true)
        String getAction();

        @XBridgeParamField(isGetter = true, keyPath = "detail", nestedClassType = c.class, required = false)
        c getDetail();

        @XBridgeStringEnum(option = {"dismiss", "select"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "action", required = true)
        void setAction(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "detail", nestedClassType = c.class, required = false)
        void setDetail(c r100);
    }

    static {
        f3210c = MapsKt.mapOf(TuplesKt.to("TicketID", "16545"));
    }

    public d() {
        this.f3211a = "x.showActionSheet";
        this.f3212b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f3212b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f3211a;
    }
}
