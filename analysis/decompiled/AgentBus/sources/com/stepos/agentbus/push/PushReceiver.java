package com.stepos.agentbus.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import b7.d;
import b7.g;
import com.stepos.account.oauth.OAuthConstants;
import e5.b;
import ga.k;
import java.util.Set;
import kotlin.Metadata;
import nb.i;
import q6.c;
import y5.a;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/agentbus/push/PushReceiver;", "<init>", "()V", "push_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PushReceiver extends BroadcastReceiver implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f2690a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final String f2691b = "PushReceiver";

    public static void a(d dVar) {
        String str = (String) dVar.getHead().getMeta().get(OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME);
        String str2 = null;
        if (str == null || k.t0(str)) {
            str = null;
        }
        String str3 = (String) dVar.getHead().getMeta().get("Zyql_TraceId");
        if (str3 != null && !k.t0(str3)) {
            str2 = str3;
        }
        a aVar = new a(str, str2);
        a5.a aVar2 = i.f6979b;
        if (aVar2 != null) {
            aVar2.invoke(aVar);
        }
    }

    public final void b(d dVar) {
        String str = (String) dVar.getHead().getMeta().get("Zyql_SessionId");
        String str2 = (String) dVar.getHead().getMeta().get("Zyql_TraceId");
        String str3 = (String) dVar.getHead().getMeta().get("Zyql_ToolCallId");
        g gVarP = g.p(dVar.getBody());
        String str4 = this.f2691b;
        Set set = b.f3054a;
        Log.i(str4, b.d("onMessage: bffToolCall=" + gVarP + " "));
        String callId = gVarP.getCallId();
        q7.k.d(callId, "getCallId(...)");
        String str5 = str3 == null ? "" : str3;
        String id = gVarP.getTool().getId();
        q7.k.d(id, "getId(...)");
        String name = gVarP.getTool().getName();
        q7.k.d(name, "getName(...)");
        String strMo8getParams = gVarP.getParams().mo8getParams();
        q7.k.d(strMo8getParams, "getParams(...)");
        y5.b bVar = new y5.b(callId, str5, id, name, strMo8getParams, str2, str);
        String str6 = this.f2691b;
        StringBuilder sbP = a1.a.p("onMessage: dispatch toolCall callId=", str3, ", tool=", name, ", params=");
        sbP.append(strMo8getParams);
        sbP.append(", sessionId = ");
        sbP.append(str);
        sbP.append(" ");
        Log.i(str6, b.d(sbP.toString()));
        a5.a aVar = i.f6978a;
        if (aVar != null) {
            aVar.invoke(bVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        j6.a.b(this.f2690a, "onReceive intent: " + intent);
        o6.b.f7769a.execute(new com.stepos.probe.a(this, context, intent, 1));
    }
}
