package com.bytedance.android.marketing.sdk.impl.hybrid.bridge;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a extends v56.c<b, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f162806d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "requestECMarketingBridge", params = {"action", "params"})
    public final String f162807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f162808c;

    /* JADX INFO: renamed from: com.bytedance.android.marketing.sdk.impl.hybrid.bridge.a$a, reason: collision with other inner class name */
    public static final class C2487a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "action", required = true)
        String getAction();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = true)
        Object getParams();
    }

    static {
        f162806d = MapsKt.mapOf(TuplesKt.to("TicketID", "27451"));
    }

    public a() {
        this.f162807b = "requestECMarketingBridge";
        this.f162808c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f162808c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f162807b;
    }
}
