package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.LogoutResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "logout")
public final class y0 extends e7.l<JsonObject, LogoutResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f38852a;

    public y0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Activity r101 = (Activity) r100.c(Activity.class);
        if (r101 == null) goto L6;
        this.f38852a = new WeakReference(r101);
        return;
    }

    public y0(WeakReference<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "activityRef");
        this.f38852a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IUserInfoService r103 = (IUserInfoService) Annie.getService(IUserInfoService.class, r101.a());
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<String> r105 = r102.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = r105.next();
        r104.put(r106, r102.get(r106).getAsString().toString());
        goto L4
    L6:
        WeakReference<Activity> r107 = this.f38852a;
        if (r107 == null) goto L11;
        Activity r108 = r107.get();
        if (r108 == null) goto L11;
        r103.z(r108, new x0(this));
        Unit r109 = Unit.INSTANCE;
    L12:
        if (r109 != null) goto L16;
        LogoutResultModel r110 = new LogoutResultModel();
        r110.a(LogoutResultModel.Code.Failed);
        r110.b("Activity is Null");
        finishWithResult(r110);
        return;
    L16:
        return;
    L11:
        r109 = null;
        goto L12
    }
}
