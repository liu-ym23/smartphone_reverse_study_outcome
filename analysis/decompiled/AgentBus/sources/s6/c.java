package s6;

import a4.p;
import ab.x;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9504b = c.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9504b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            r6.a aVarA = r6.a.a(stringExtra);
            if (aVarA == null) {
                j6.a.c(str, "getMessage fail, messageData is null");
                return null;
            }
            j6.a.b(str, "getMessage success");
            return aVarA;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "private";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        Intent launchIntentForPackage;
        Intent intent;
        HashMap map;
        r6.a aVar = (r6.a) obj;
        if (aVar == null) {
            return;
        }
        n7.a.v(context, "cpm", aVar.f8991e, aVar.f8987a, aVar.f8988b, aVar.f8996j);
        String str = aVar.f8995i;
        if (TextUtils.isEmpty(str)) {
            str = aVar.f8991e;
        }
        String str2 = this.f9504b;
        j6.a.b(str2, "openClassName is " + str);
        int i2 = aVar.f8992f;
        if (i2 == 0) {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null && (map = aVar.f8997k) != null) {
                for (Map.Entry entry : map.entrySet()) {
                    j6.a.b(str2, " launcher activity key " + ((String) entry.getKey()) + " value " + ((String) entry.getValue()));
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        } else {
            if (1 == i2) {
                intent = new Intent();
                HashMap map2 = aVar.f8997k;
                if (map2 != null) {
                    for (Map.Entry entry2 : map2.entrySet()) {
                        j6.a.b(str2, " key " + ((String) entry2.getKey()) + " value " + ((String) entry2.getValue()));
                        if (!TextUtils.isEmpty((CharSequence) entry2.getKey()) && !TextUtils.isEmpty((CharSequence) entry2.getValue())) {
                            intent.putExtra((String) entry2.getKey(), (String) entry2.getValue());
                        }
                    }
                }
                intent.setClassName(str, aVar.f8993g);
                j6.a.b(str2, intent.toUri(1));
            } else if (2 == i2) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.f8994h));
                String str3 = aVar.f8995i;
                if (!TextUtils.isEmpty(str3)) {
                    intent.setPackage(str3);
                    j6.a.b(str2, "set uri package " + str3);
                }
            } else {
                if (3 == i2) {
                    j6.a.b(str2, "CLICK_TYPE_SELF_DEFINE_ACTION");
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            String str4 = aVar.f8987a;
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            String str5 = !TextUtils.isEmpty(null) ? null : "";
            String str6 = TextUtils.isEmpty(null) ? "" : null;
            HashMap map3 = new HashMap();
            map3.put("task_id", str4);
            map3.put("seq_id", str5);
            map3.put("push_timestamp", str6);
            launchIntentForPackage.putExtra("platform_extra", new JSONObject(map3).toString());
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            try {
                context.startActivity(launchIntentForPackage);
            } catch (Exception e10) {
                j6.a.c(str2, "Click message StartActivity error " + e10.getMessage());
            }
        }
        if (!TextUtils.isEmpty(aVar.f8989c) && !TextUtils.isEmpty(aVar.f8990d)) {
            g3.e eVarO = g3.e.o(aVar, false);
            String str7 = ((PushReceiver) cVar).f2691b;
            Set set = e5.b.f3054a;
            Log.d(str7, e5.b.c("onNotificationClicked: pushMessage=" + eVarO));
        }
        x xVar = aVar.f8999m;
        if (xVar == null) {
            return;
        }
        j6.a.c("MessageNotificationHelper", "clear notifyId " + xVar.f668b + " notifyKey " + ((String) xVar.f669c));
        if (TextUtils.isEmpty((String) xVar.f669c)) {
            p pVar = f6.a.f3454a;
            String str8 = aVar.f8991e;
            int[] iArr = {xVar.f668b};
            g6.b bVar = (g6.b) pVar.f197k;
            bVar.f3856f = 1;
            bVar.f3855e = iArr;
            bVar.f3857g = null;
            bVar.f3858h = str8;
            bVar.c(context);
            return;
        }
        p pVar2 = f6.a.f3454a;
        String str9 = aVar.f8991e;
        String str10 = (String) xVar.f669c;
        g6.b bVar2 = (g6.b) pVar2.f197k;
        bVar2.f3856f = 2;
        bVar2.f3855e = null;
        bVar2.f3857g = str10;
        bVar2.f3858h = str9;
        bVar2.c(context);
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((r6.a) obj).getClass();
        return true;
    }
}
