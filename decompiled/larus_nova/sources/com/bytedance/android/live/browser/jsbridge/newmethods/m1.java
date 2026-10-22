package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63551a = 0;

    static {
        TokenCert.Companion.with("bpea-live_callPhoneMethod_jsb_read_phone_state");
    }

    public static void a(JSONObject r100, CallContext r101, Function1 r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "finishWithFailure");
        Intrinsics.checkNotNullParameter(r103, "finishWithResult");
        Activity r104 = ContextUtil.contextToActivity(r101.getContext());
        Object r105 = null;
        if (r104 != null) goto L6;
        r102.invoke(null);
        return;
    L6:
        Object r106 = r104.getSystemService("phone");
        if ((r106 instanceof TelephonyManager) == false) goto L10;
        r105 = r106;
    L10:
        TelephonyManager r107 = (TelephonyManager) r105;
        if (r107 != null) goto L13;
    L16:
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r108 = false;
        if (Settings.System.getInt(r104.getContentResolver(), "airplane_mode_on", 0) != 1) goto L19;
        r108 = true;
    L19:
        if (r108 == false) goto L22;
        r102.invoke(new Throwable("please turn off air mode"));
        return;
    L22:
        String r109 = r100.optString(IGoogleService.ResponseKey.PHONE_NUMBER);
        if (r109 != null) goto L25;
    L27:
        String r110 = r100.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
    L28:
        JSONObject r111 = new JSONObject();
        r111.put("code", 1);
        r111.put("msg", "SUCCESS");
        if (TextUtils.isEmpty(r110) == false) goto L37;
    L35:
        r103.invoke(r111);
        return;
    L37:
        r104.startActivity(new Intent("android.intent.action.DIAL", UriProtector.parse("tel:" + Uri.encode(r110))));     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L25:
        if ((!StringsKt.isBlank(r109)) != true) goto L27;
        r110 = r100.optString(IGoogleService.ResponseKey.PHONE_NUMBER);
        goto L28
    L13:
        if (1 != r107.getSimState()) goto L16;
        r102.invoke(new Throwable("no sim card"));
    }
}
