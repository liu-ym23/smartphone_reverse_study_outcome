package N5;

import C7.r;
import H.h;
import I4.l;
import I9.d;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import w0.C2093n;

/* loaded from: classes3.dex */
public final class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1010a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1010a = i;
        this.b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i = this.f1010a;
        int i6 = 1;
        Object obj = this.b;
        switch (i) {
            case 0:
                c cVar = (c) obj;
                if (!"android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                    if (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            d.a(new l(i6, this, context));
                            break;
                        }
                    } else {
                        W5.c.a("EnvironmentReceiver", "ACTION_POWER_DISCONNECTED, charging = false");
                        cVar.b.a();
                        break;
                    }
                } else {
                    W5.c.a("EnvironmentReceiver", "ACTION_POWER_CONNECTED, charging = true");
                    cVar.b.c();
                    break;
                }
                break;
            case 1:
                Log.i("AbilityReportProcessor", "Receive trigger upload broadcast.");
                ((com.stepos.ability.manager.reporter.a) obj).f.a(r.f317a);
                break;
            case 2:
                if (intent != null) {
                    try {
                        String stringExtra = intent.getStringExtra("PROCESS_NAME");
                        Application application = h.f711a;
                        String strA = D2.b.a();
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(strA) && !stringExtra.equals(strA)) {
                            ((i0.d) obj).g();
                            break;
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                break;
            default:
                C2093n c2093n = (C2093n) obj;
                if (intent != null) {
                    c2093n.d = intent.getIntExtra(LlmRuntimeArgsBundle.KEY_TEMPERATURE, 0) / 10.0f;
                    c2093n.e = intent.getIntExtra("status", 1);
                    intent.getIntExtra("plugged", -1);
                    c2093n.getClass();
                    int intExtra = intent.getIntExtra("level", -1);
                    int intExtra2 = intent.getIntExtra("scale", -1);
                    c2093n.f = (intExtra * 100) / intExtra2;
                    Log.d("steven_battery", U7.a.e(new String[]{"percent:" + c2093n.f + " level:" + intExtra + " scale:" + intExtra2}));
                    break;
                }
                break;
        }
    }
}
