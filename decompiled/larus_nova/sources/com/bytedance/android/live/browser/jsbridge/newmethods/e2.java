package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DialogFragment f63352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f63353b;

    public e2(Activity r100, DialogFragment r101) {
        this.f63352a = r101;
        this.f63353b = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("containerID");
        String r104 = r102.optString("schema");
        boolean r105 = true;
        if (TextUtils.isEmpty(r103) == true) goto L8;
        Lazy r106 = HybridContainerManager.f62592a;
        Intrinsics.checkNotNull(r103);
        if (HybridContainerManager.a(r103) == true) goto L7;
        terminate("containerID is invalid");
    L7:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L22;
        DialogFragment r108 = this.f63352a;
        if (r108 != null) goto L35;
        Activity r109 = this.f63353b;
        if (r109 == null) goto L21;
        r109.finish();
        goto L22
    L21:
        terminate();
        goto L22
    L35:
        r108.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r110 = DialogFragmentLancet.sLastShowStack;
        if (r110 == null) goto L22;
        com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L22:
        if (r104 != null) goto L24;
    L27:
        if (r105 == false) goto L29;
        terminate("schema is null");
    L29:
        if (r104 == null) goto L37;
        IMiddlewareLiveService r111 = TTLiveServiceMiddleware.getLiveService();
        if (r111 == null) goto L38;
        r111.handleSchema(r101.getContext(), UriProtector.parse(r104));
        return null;
    L38:
        return null;
    L37:
        return null;
    L24:
        if (r104.length() == 0) goto L27;
        r105 = false;
        goto L27
    L8:
        r107 = false;
        goto L9
    }
}
