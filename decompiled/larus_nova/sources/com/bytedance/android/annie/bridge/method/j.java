package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "close")
public final class j extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f38665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f38666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38667c;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        DialogFragment r101 = (DialogFragment) r100.c(DialogFragment.class);
        if (r101 == null) goto L5;
        this.f38666b = r101;
    L5:
        Activity r102 = (Activity) r100.c(Activity.class);
        if (r102 == null) goto L9;
        this.f38665a = new WeakReference(r102);
        return;
    }

    public j(WeakReference r100) {
        Intrinsics.checkNotNullParameter(r100, "activityRef");
        this.f38665a = r100;
        this.f38667c = null;
    }

    public j(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f38666b = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r113 = r112.optString("containerID");
        if (r113 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        r113 = this.f38667c;
    L11:
        JSONArray r114 = r112.optJSONArray("containerIDs");
        if (r113 != null) goto L14;
    L17:
        boolean r101 = true;
    L19:
        if (r101 == false) goto L37;
        if (r114 != null) goto L22;
    L23:
        DialogFragment r102 = this.f38666b;
        if (r102 != null) goto L66;
        WeakReference<Activity> r103 = this.f38665a;
        if (r103 == null) goto L37;
        Activity r104 = r103.get();
        if (r104 == null) goto L37;
        r104.finish();
        CloseResModel r115 = new CloseResModel();
        r115.a(CloseResModel.Code.Success);
        r115.b("Success");
        finishWithResult(r115);
        return;
    L66:
        r102.dismissAllowingStateLoss();     // Catch: Exception -> L27
    L31:
        CloseResModel r116 = new CloseResModel();
        r116.a(CloseResModel.Code.Success);
        r116.b("Success");
        finishWithResult(r116);
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r117 = DialogFragmentLancet.sLastShowStack;
        if (r117 == null) goto L31;
        com.bytedance.crash.d.d(r117, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L31
    L22:
        if (r114.length() == 0) goto L23;
    L37:
        ArrayList r105 = new ArrayList();
        if (r114 == null) goto L62;
        if (r114.length() <= 0) goto L62;
        int r118 = r114.length();
        int r106 = 0;
    L42:
        if (r106 >= r118) goto L64;
        String r107 = JSONArrayProtectorUtils.getString(r114, r106);
        if (AnnieFragmentManager.a(r107, false, 6) == true) goto L46;
        r105.add(r107);
    L58:
        if ((!r105.isEmpty()) == true) goto L59;
        r106 = r106 + 1;
        goto L42
    L59:
        CloseResModel r119 = new CloseResModel();
        r119.a(CloseResModel.Code.Failed);
        r119.b("multi ContainerId " + r105 + " is not matched");
        finishWithResult(r119);
        return;
    L46:
        WeakReference<HybridFragment> r108 = AnnieFragmentManager.b(r107);
        if (r108 == null) goto L49;
        HybridFragment r109 = r108.get();
    L50:
        if (r109 == null) goto L54;
        FragmentActivity r120 = r109.getActivity();
        if (r120 == null) goto L54;
        r120.finish();
    L54:
        com.bytedance.android.anniex.assemble.a r121 = com.bytedance.android.anniex.assemble.a.f40251a;
        Intrinsics.checkNotNullParameter(r107, "containerId");
        ia.c r122 = AnnieXContainerManager.INSTANCE.getContainerById(r107);
        if (r122 == null) goto L58;
        r122.close();
        goto L58
    L49:
        r109 = null;
    L64:
        CloseResModel r123 = new CloseResModel();
        r123.a(CloseResModel.Code.Success);
        r123.b("Success");
        finishWithResult(r123);
        return;
    L62:
        if (AnnieFragmentManager.a(r113, false, 6) == true) goto L64;
        CloseResModel r124 = new CloseResModel();
        r124.a(CloseResModel.Code.Failed);
        r124.b("single ContainerId " + r113 + " is not matched");
        finishWithResult(r124);
        return;
    L14:
        if (StringsKt.isBlank(r113) == true) goto L17;
        r101 = false;
        goto L19
    L5:
        if (StringsKt.isBlank(r113) == true) goto L8;
        r100 = false;
        goto L9
    }
}
