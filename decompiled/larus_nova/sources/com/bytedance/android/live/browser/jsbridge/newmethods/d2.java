package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DialogFragment f63344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f63345b;

    public d2(Activity r100) {
        this.f63345b = r100;
    }

    public d2(DialogFragment r100) {
        this.f63344a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        String r102 = r100.optString("containerID");
        if (TextUtils.isEmpty(r102) == false) goto L5;
        DialogFragment r103 = this.f63344a;
        if (r103 != null) goto L21;
        Activity r104 = this.f63345b;
        if (r104 == null) goto L18;
        r104.finish();
        return null;
    L18:
        terminate();
        return null;
    L21:
        r103.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L25;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return null;
    L25:
        return null;
    L5:
        if (HybridContainerManager.a(r102) == true) goto L23;
        terminate("containerID is invalid");
        return null;
    L23:
        return null;
    }
}
