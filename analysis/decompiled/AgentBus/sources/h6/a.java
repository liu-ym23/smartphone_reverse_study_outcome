package h6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import b7.d;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentbus.push.PushReceiver;
import e5.b;
import java.util.HashMap;
import java.util.Set;
import nb.i;
import org.json.JSONObject;
import q6.c;
import q7.k;

/* loaded from: classes.dex */
public final class a extends s6.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f4211b = a.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f4211b;
        j6.a.b(str, "getMessage start");
        try {
            r6.a aVar = new r6.a();
            aVar.f8987a = intent.getStringExtra("extra_app_push_task_Id");
            aVar.f8988b = intent.getStringExtra("extra_app_push_seq_Id");
            aVar.f8998l = intent.getStringExtra(OAuthConstants.FACTOR_RESULT_MESSAGE);
            aVar.f8996j = intent.getStringExtra("extra_app_push_task_timestamp");
            aVar.f9001o = intent.getStringExtra("msg_es");
            aVar.f8991e = context.getPackageName();
            j6.a.b(str, "getMessage success");
            return aVar;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return OAuthConstants.FACTOR_RESULT_MESSAGE;
    }

    @Override // s6.a
    public final void c(Context context, Object obj, c cVar) {
        r6.a aVar = (r6.a) obj;
        if (aVar == null) {
            return;
        }
        n7.a.v(context, "rpe", aVar.f8991e, aVar.f8987a, aVar.f8988b, aVar.f8996j);
        if (TextUtils.isEmpty(aVar.f8998l)) {
            return;
        }
        String str = aVar.f8987a;
        String str2 = aVar.f8988b;
        String str3 = aVar.f8996j;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        HashMap map = new HashMap();
        map.put("task_id", str);
        map.put("seq_id", str2);
        map.put("push_timestamp", str3);
        String string = new JSONObject(map).toString();
        String str4 = aVar.f8998l;
        PushReceiver pushReceiver = (PushReceiver) cVar;
        k.e(context, "context");
        k.e(str4, OAuthConstants.FACTOR_RESULT_MESSAGE);
        String str5 = pushReceiver.f2691b;
        Set set = b.f3054a;
        Log.d(str5, b.c("onMessage: messageLen=" + str4.length() + ", platformExtra=" + string));
        try {
            d dVarP = d.p(Base64.decode(str4, 0));
            Log.d(pushReceiver.f2691b, b.c("onMessage: StreamMsg parsed, command=" + dVarP.getHead().getCommand() + ", meta=" + dVarP.getHead().getMeta()));
            String command = dVarP.getHead().getCommand();
            if (command != null) {
                int iHashCode = command.hashCode();
                if (iHashCode != -107979466) {
                    if (iHashCode != 1462761798) {
                        if (iHashCode == 1577902425 && command.equals("CloudWake")) {
                            String str6 = (String) dVarP.getHead().getMeta().get("Zyql_TraceId");
                            if (str6 == null || ga.k.t0(str6)) {
                                str6 = null;
                            }
                            y5.c cVar2 = new y5.c(str6);
                            a5.a aVar2 = i.f6980c;
                            if (aVar2 != null) {
                                aVar2.invoke(cVar2);
                                return;
                            }
                            return;
                        }
                    } else if (command.equals("BffWake")) {
                        PushReceiver.a(dVarP);
                        return;
                    }
                } else if (command.equals("CallTool")) {
                    pushReceiver.b(dVarP);
                    return;
                }
            }
            Log.d(pushReceiver.f2691b, "onMessage: unknown command=" + dVarP.getHead().getCommand() + ", drop");
        } catch (Exception e10) {
            Log.e(pushReceiver.f2691b, "onMessage parse failed: " + e10.getMessage(), e10);
        }
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((r6.a) obj).getClass();
        return true;
    }
}
