package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "fetchClipBoard")
public final class r0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenCert f142181a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r0() {
        this.f142181a = TokenCert.Companion.with("bpea-bpea-live_fetchClipBoard_jsb_fetch_clip_board");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        String r103 = "";
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r104 = r102.optString("token", "");     // Catch: Exception -> L28
        if (r104 != null) goto L6;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        TokenCert r106 = this.f142181a;     // Catch: Exception -> L28
    L13:
        Context r107 = r101.getContext();     // Catch: Exception -> L28
        Object r108 = r107.getSystemService(DataType.CLIPBOARD);     // Catch: Exception -> L28
        if (r108 == null) goto L27;
        ClipboardManager r109 = (ClipboardManager) r108;     // Catch: Exception -> L28
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L28
        ClipData r111 = g80.d.b(r106);     // Catch: Exception -> L28
        if (r111 == null) goto L25;
        ClipData.Item r112 = r111.getItemAt(0);     // Catch: Exception -> L28
        if (r112 == null) goto L25;
        CharSequence r113 = r112.coerceToText(r107);     // Catch: Exception -> L28
        if (r113 == null) goto L25;
        String r114 = r113.toString();     // Catch: Exception -> L28
        if (r114 == null) goto L25;
        r103 = r114;
    L25:
        r110.put("content", r103);     // Catch: Exception -> L28
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L28
        finishWithResult(r110);     // Catch: Exception -> L28
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Exception -> L28
    L12:
        r106 = TokenCert.Companion.with(r104);     // Catch: Exception -> L28
        goto L13
    L6:
        if (StringsKt.isBlank(r104) == true) goto L9;
        r105 = false;
    L28:
        e = move-exception;
        e.printStackTrace();
        finishWithFailure(e);
    }
}
