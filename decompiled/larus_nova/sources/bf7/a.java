package bf7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
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
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<f, g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f18837c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.setContainer", params = {"pageUI", "commonInteraction", "pageInteraction", "popupInteraction"})
    public final String f18838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f18839b;

    /* JADX INFO: renamed from: bf7.a$a, reason: collision with other inner class name */
    public static final class C0297a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableBackPress", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableBackPress();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableBounce", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableBounce();
    }

    public interface c extends XBaseModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableSwipe", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableSwipe();

        @XBridgeStringEnum(option = {ShareChannel.COLLECT, "report", "share"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "navBtnType", required = false)
        String getNavBtnType();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "shouldFullScreen", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getShouldFullScreen();
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "navBarColor", required = false)
        String getNavBarColor();

        @XBridgeParamField(isGetter = true, keyPath = "statusBarBgColor", required = false)
        String getStatusBarBgColor();

        @XBridgeStringEnum(option = {"dark", "light"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "statusFontMode", required = false)
        String getStatusFontMode();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = "titleColor", required = false)
        String getTitleColor();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableMaskClickClose", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableMaskClickClose();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "enableInterceptTouchEvent", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getEnableInterceptTouchEvent();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "enablePullDownClose", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getEnablePullDownClose();
    }

    @XBridgeParamModel
    public interface f extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "commonInteraction", nestedClassType = b.class, required = false)
        b getCommonInteraction();

        @XBridgeParamField(isGetter = true, keyPath = "pageInteraction", nestedClassType = c.class, required = false)
        c getPageInteraction();

        @XBridgeParamField(isGetter = true, keyPath = "pageUI", nestedClassType = d.class, required = false)
        d getPageUI();

        @XBridgeParamField(isGetter = true, keyPath = "popupInteraction", nestedClassType = e.class, required = false)
        e getPopupInteraction();
    }

    @XBridgeResultModel
    public interface g extends XBaseResultModel {
    }

    static {
        f18837c = MapsKt.mapOf(TuplesKt.to("TicketID", "38360"));
    }

    public a() {
        this.f18838a = "x.setContainer";
        this.f18839b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f18839b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f18838a;
    }
}
