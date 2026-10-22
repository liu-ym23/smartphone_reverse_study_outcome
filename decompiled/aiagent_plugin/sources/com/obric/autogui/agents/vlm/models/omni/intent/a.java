package com.obric.autogui.agents.vlm.models.omni.intent;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: MuteWhitelistExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "MuteWhitelistInjector";

    public static final void a(ObricProductSdk r13) {
        o.e(r13, "<this>");
        List<String> r2 = com.obric.autogui.common.a.d.f28974a.L();     // Catch: Throwable -> L9
        if (r2.isEmpty() == false) goto L7;
        Loog.INSTANCE.w(TAG, "skip inject mute whitelist: empty");     // Catch: Throwable -> L9
        return;
    L7:
        r13.platformService().activityManager().setMuteWhitelist(r2);     // Catch: Throwable -> L9
        Loog.INSTANCE.i(TAG, "attempted mute whitelist: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "inject mute whitelist failed: " + th.getMessage(), th);
    }
}
