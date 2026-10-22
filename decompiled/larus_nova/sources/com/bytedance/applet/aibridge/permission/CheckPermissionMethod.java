package com.bytedance.applet.aibridge.permission;

import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.applet.utils.t;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J(\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/CheckPermissionMethod;", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL$CheckPermissionMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL$CheckPermissionMethodResultModel;", "handleLocationPermission", "handleBackgroundLocationPermission", "handleCalendarPermission", "handleNotificationPermission", "callbackFailure", "permission", "", "errorMsg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPermissionMethod extends AbsCheckPermissionMethodIDL {

    public static final class a {
    }

    static {
    }

    public CheckPermissionMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r102) {
        AbsCheckPermissionMethodIDL.a r103 = (AbsCheckPermissionMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getPermission();
        switch(r104.hashCode()) {
            case -178324674: goto L18;
            case 595233003: goto L14;
            case 954101670: goto L10;
            case 1901043637: goto L6;
            default: goto L33;
        };
    L33:
        String r105 = r103.getPermission();
        String r106 = "unsupported permission: " + r103.getPermission();
        FLogger.f375446a.i("CheckPermissionMethod", "checkPermission " + r105 + " fails, errorMsg: " + r106);
        h.a.a(r102, r106, null, null, 14);
        return;
    L6:
        if (r104.equals("location") == false) goto L33;
        int r107 = uv3.c.f551810a;
        boolean r108 = uv3.c.b(AppHost.f326268a.getApplication());
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r109 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r109).setGranted(r108);
        r102.b((ResultModel) r109, "");
        FLogger.f375446a.i("CheckPermissionMethod", "checkPermission " + r103.getPermission() + " succeeds, result: " + r108);
        return;
    L10:
        if (r104.equals(PermissionEnum.BACKGROUND_LOCATION) == false) goto L33;
        int r110 = uv3.c.f551810a;
        boolean r111 = uv3.c.a(AppHost.f326268a.getApplication());
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r112 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r112).setGranted(r111);
        r102.b((ResultModel) r112, "");
        FLogger.f375446a.i("CheckPermissionMethod", "checkPermission " + r103.getPermission() + " succeeds, result: " + r111);
        return;
    L14:
        if (r104.equals("notification") == false) goto L33;
        boolean r113 = t.a();
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r114 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r114).setGranted(r113);
        r102.b((ResultModel) r114, "");
        FLogger.f375446a.i("CheckPermissionMethod", "checkPermission " + r103.getPermission() + " succeeds, result: " + r113);
        return;
    L18:
        if (r104.equals("calendar") == false) goto L33;
        AppHost.Companion r115 = AppHost.f326268a;
        boolean r116 = false;
        if (ContextCompat.checkSelfPermission(r115.getApplication(), "android.permission.READ_CALENDAR") != 0) goto L23;
        boolean r117 = true;
    L25:
        if (ContextCompat.checkSelfPermission(r115.getApplication(), "android.permission.WRITE_CALENDAR") != 0) goto L27;
        boolean r118 = true;
    L28:
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r119 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        AbsCheckPermissionMethodIDL.b r120 = (AbsCheckPermissionMethodIDL.b) r119;
        if (r118 == false) goto L32;
        if (r117 == false) goto L32;
        r116 = true;
    L32:
        r120.setGranted(r116);
        r102.b((ResultModel) r119, "");
        return;
    L27:
        r118 = false;
        goto L28
    L23:
        r117 = false;
        goto L25
    }
}
