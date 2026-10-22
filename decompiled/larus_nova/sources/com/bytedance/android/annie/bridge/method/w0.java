package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.LoginResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "login")
public final class w0 extends e7.k<e7.l0, LoginResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f38846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f38847b;

    public w0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Activity r101 = (Activity) r100.c(Activity.class);
        if (r101 == null) goto L5;
        this.f38846a = new WeakReference(r101);
    L5:
        DialogFragment r102 = (DialogFragment) r100.c(DialogFragment.class);
        if (r102 == null) goto L9;
        this.f38847b = r102;
        return;
    }

    public w0(WeakReference<Activity> r100, DialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "activityRef");
        this.f38846a = r100;
        this.f38847b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.l0 r102 = (e7.l0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r103 = r102.a();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        IUserInfoService r105 = (IUserInfoService) Annie.getService(IUserInfoService.class, r101.a());
        r105.hasLogin();
        LinkedHashMap r106 = new LinkedHashMap();
        JsonObject r107 = r102.getContext();
        if (r107 == null) goto L12;
        Iterator<String> r108 = r107.keySet().iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        String r109 = r108.next();
        r106.put(r109, r107.get(r109).getAsString().toString());
    L12:
        v0 r110 = new v0(r105, this);
        WeakReference<Activity> r111 = this.f38846a;
        Unit r112 = null;
        if (r111 == null) goto L30;
        Activity r113 = r111.get();
        if (r113 == null) goto L30;
        if (r104 == false) goto L18;
        r105.z1(r113, r110);
    L29:
        r112 = Unit.INSTANCE;
        goto L30
    L18:
        IUserInfoService.LoginParamsExt r114 = new IUserInfoService.LoginParamsExt();
        r114.setKeepOpen(r104);
        Unit r115 = Unit.INSTANCE;
        r105.U(r113, r110, r114);
        DialogFragment r116 = this.f38847b;
        if (r116 != null) goto L33;
    L27:
        if (r112 != null) goto L29;
        r113.finish();
        goto L29
    L33:
        r116.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L26:
        r112 = Unit.INSTANCE;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r117 = DialogFragmentLancet.sLastShowStack;
        if (r117 == null) goto L26;
        com.bytedance.crash.d.d(r117, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L30:
        if (r112 != null) goto L36;
        LoginResultModel r118 = new LoginResultModel();
        r118.b(LoginResultModel.Code.Failed);
        r118.a(Boolean.FALSE);
        r118.c("Activity is Null");
        finishWithResult(r118);
        return;
    L36:
        return;
    L5:
        r104 = true;
        goto L6
    }
}
