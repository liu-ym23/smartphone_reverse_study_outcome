package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "closeAndOpen")
public final class i extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f38661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f38662b;

    public i(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        DialogFragment r101 = (DialogFragment) r100.c(DialogFragment.class);
        if (r101 == null) goto L5;
        this.f38662b = r101;
    L5:
        Activity r102 = (Activity) r100.c(Activity.class);
        if (r102 == null) goto L9;
        this.f38661a = r102;
        return;
    }

    public i(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f38662b = r100;
    }

    public i(Activity r100) {
        this.f38661a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("containerID");
        String r104 = r102.optString("schema");
        boolean r105 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        boolean r107 = false;
    L15:
        if (r107 == true) goto L28;
        DialogFragment r108 = this.f38662b;
        if (r108 != null) goto L39;
        Activity r109 = this.f38661a;
        if (r109 == null) goto L27;
        r109.finish();
        goto L28
    L27:
        terminate();
        goto L28
    L39:
        r108.dismissAllowingStateLoss();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r110 = DialogFragmentLancet.sLastShowStack;
        if (r110 == null) goto L28;
        com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L28:
        if (r104 != null) goto L30;
    L33:
        if (r105 == false) goto L36;
        terminate("schema is null");
    L36:
        if (r104 == null) goto L38;
        Boolean.valueOf(w9.a.f558719a.j0(r101.getContext(), UriProtector.parse(r104), null, null)).booleanValue();
    L38:
        return null;
    L30:
        if (r104.length() == 0) goto L33;
        r105 = false;
        goto L33
    L11:
        if (AnnieFragmentManager.a(r103, false, 6) == true) goto L13;
        terminate("containerID is invalid");
    L13:
        r107 = true;
        goto L15
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r106 = false;
        goto L9
    }
}
