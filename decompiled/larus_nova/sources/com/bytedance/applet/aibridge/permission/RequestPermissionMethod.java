package com.bytedance.applet.aibridge.permission;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.applet.utils.LocationUtils$resendQuestion$1;
import com.bytedance.applet.utils.i;
import com.bytedance.applet.utils.t;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.l1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import f3.h;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv3.f;
import uv3.g;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J0\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J8\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J&\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J(\u0010\"\u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006%"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/RequestPermissionMethod;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodResultModel;", "handleLocationPermission", "forceBackground", "", "doRequestPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "permissionList", "", "", "permissionCallback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "onLocationPermissionResult", "isGranted", "handleCalendarPermission", "handleNotificationPermission", "runRemindAppletRuntime", "onAppletRunSuccess", "Lkotlin/Function0;", "sendResultEvent", "requestId", "permission", "callbackFailure", "errorMsg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestPermissionMethod extends AbsRequestPermissionMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f191397b = 0;

    public static final class a {
    }

    public static final class b implements Function1<AppletRuntime, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f191398a;

        public b(Function0<Unit> r100) {
            this.f191398a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AppletRuntime r100) {
            if (r100 == null) goto L6;
            this.f191398a.invoke();
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public RequestPermissionMethod() {
    }

    public static void d(Function0 r100) {
        AppletRuntimeManager.o(AppletRuntimeManager.INSTANCE, "com.flow.remind", "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new b(r100), 56);
    }

    public static void c(AbsRequestPermissionMethodIDL.b r100, boolean r101) {
        e(r100.getRequestId(), r100.getPermission(), r101);
        if (r101 == false) goto L11;
        int r102 = i.f192291a;
        Intrinsics.checkNotNullParameter(r100, "params");
        JSONObject r103 = r100.getExtra();
        if (r103 == null) goto L13;
        final String r104 = r103.optString("resendQuestionId", "");
        if (o0.d(r104) == false) goto L12;
        Intrinsics.checkNotNull(r104);
        l1.f365760a.a(LocateScene.MSG_NEED_LOC, new LocationUtils$resendQuestion$1(r104));
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void e(String r100, @PermissionEnum String r101, boolean r102) {
        Lazy r103 = l3.d.f507201a;
        JsonObject r104 = new JsonObject();
        r104.addProperty("requestId", r100);
        r104.addProperty("permission", r101);
        r104.addProperty("isGranted", Boolean.valueOf(r102));
        Unit r105 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.onPermissionRequestResult", r104, 4));
    }

    public final void b(final AbsRequestPermissionMethodIDL.b r110, h r111, final boolean r112) {
        AppHost.Companion r100 = AppHost.f326268a;
        Activity r101 = r100.a().getCurrentActivity();
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r101;
    L6:
        final FragmentActivity r103 = r102;
        l1 r104 = l1.f365760a;
        if (r104.c() == true) goto L10;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r113 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r113).setRequestId(r110.getRequestId());
        r111.b((ResultModel) r113, "");
        e(r110.getRequestId(), r110.getPermission(), false);
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r110.getPermission() + " disable location service");
        r104.d(r103);
        return;
    L10:
        if (r112 == false) goto L12;
        int r105 = uv3.c.f551810a;
        boolean r106 = uv3.c.a(r100.getApplication());
    L13:
        if (r106 == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r114 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r114).setRequestId(r110.getRequestId());
        r111.b((ResultModel) r114, "");
        c(r110, true);
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r110.getPermission() + " granted");
        return;
    L16:
        final d r107 = new d(r110, this, r112);
        t0.e(new uv3.d(r112, this, r103, r107, r110));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r115 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r115).setRequestId(r110.getRequestId());
        r111.b((ResultModel) r115, "");
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r110.getPermission() + " starts");
        return;
    L12:
        int r108 = uv3.c.f551810a;
        r106 = uv3.c.b(r100.getApplication());
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v9, types: [uv3.e] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, h r110) {
        final AbsRequestPermissionMethodIDL.b r102 = (AbsRequestPermissionMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getPermission();
        switch(r103.hashCode()) {
            case -178324674: goto L21;
            case 595233003: goto L14;
            case 954101670: goto L10;
            case 1901043637: goto L6;
            default: goto L27;
        };
    L27:
        String r104 = r102.getPermission();
        String r105 = "unsupported permission: " + r102.getPermission();
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r104 + " fails, errorMsg: " + r105);
        h.a.a(r110, r105, null, null, 14);
        return;
    L6:
        if (r103.equals("location") == false) goto L27;
        b(r102, r110, false);
        return;
    L10:
        if (r103.equals(PermissionEnum.BACKGROUND_LOCATION) == false) goto L27;
        b(r102, r110, true);
        return;
    L14:
        if (r103.equals("notification") == false) goto L27;
        if (t.a() == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r106 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r106).setRequestId(r102.getRequestId());
        r110.b((ResultModel) r106, "");
        e(r102.getRequestId(), r102.getPermission(), true);
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r102.getPermission() + " already granted");
        return;
    L19:
        final e r107 = new e(r102, this);
        t0.e(new uv3.h(r102, r107));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r108 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r108).setRequestId(r102.getRequestId());
        r110.b((ResultModel) r108, "");
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r102.getPermission() + " starts");
        return;
    L21:
        if (r103.equals("calendar") == false) goto L27;
        ?? r109 = new uv3.e();
        if (((Boolean) r109.invoke()).booleanValue() == false) goto L26;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r111 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r111).setRequestId(r102.getRequestId());
        r110.b((ResultModel) r111, "");
        d(new f(this, r102));
        return;
    L26:
        final c r112 = new c(r102, this, r109);
        t0.e(new g(r102, this, r112));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        BaseModel r113 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        ((AbsRequestPermissionMethodIDL.c) r113).setRequestId(r102.getRequestId());
        r110.b((ResultModel) r113, "");
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + r102.getPermission() + " starts");
    }
}
