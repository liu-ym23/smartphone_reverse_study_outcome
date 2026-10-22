package b8;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.b1;
import java.util.HashMap;
import java.util.Map;
import o7.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3130b = c.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3130b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            a8.a aVarA = a8.a.a(stringExtra);
            if (aVarA == null) {
                s7.a.c(str, "getMessage fail, messageData is null");
                return null;
            }
            s7.a.b(str, "getMessage success");
            return aVarA;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "private";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        Intent launchIntentForPackage;
        Intent intent;
        HashMap map;
        a8.a aVar = (a8.a) obj;
        if (aVar == null) {
            return;
        }
        b1.Q(context, "cpm", aVar.f55e, aVar.f51a, aVar.f52b, aVar.f59j);
        String str = aVar.f58i;
        if (TextUtils.isEmpty(str)) {
            str = aVar.f55e;
        }
        String str2 = this.f3130b;
        s7.a.b(str2, "openClassName is " + str);
        int i10 = aVar.f56f;
        if (i10 == 0) {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null && (map = aVar.f60k) != null) {
                for (Map.Entry entry : map.entrySet()) {
                    s7.a.b(str2, " launcher activity key " + ((String) entry.getKey()) + " value " + ((String) entry.getValue()));
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        } else {
            if (1 == i10) {
                intent = new Intent();
                HashMap map2 = aVar.f60k;
                if (map2 != null) {
                    for (Map.Entry entry2 : map2.entrySet()) {
                        s7.a.b(str2, " key " + ((String) entry2.getKey()) + " value " + ((String) entry2.getValue()));
                        if (!TextUtils.isEmpty((CharSequence) entry2.getKey()) && !TextUtils.isEmpty((CharSequence) entry2.getValue())) {
                            intent.putExtra((String) entry2.getKey(), (String) entry2.getValue());
                        }
                    }
                }
                intent.setClassName(str, aVar.f57g);
                s7.a.b(str2, intent.toUri(1));
            } else if (2 == i10) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.h));
                String str3 = aVar.f58i;
                if (!TextUtils.isEmpty(str3)) {
                    intent.setPackage(str3);
                    s7.a.b(str2, "set uri package " + str3);
                }
            } else {
                if (3 == i10) {
                    s7.a.b(str2, "CLICK_TYPE_SELF_DEFINE_ACTION");
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            String str4 = aVar.f51a;
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
                s7.a.c(str2, "Click message StartActivity error " + e10.getMessage());
            }
        }
        if (!TextUtils.isEmpty(aVar.f53c) && !TextUtils.isEmpty(aVar.f54d)) {
            bVar.onNotificationClicked(context, u7.a.a(aVar, false));
        }
        a8.b bVar2 = aVar.f62m;
        if (bVar2 == null) {
            return;
        }
        s7.a.c("MessageNotificationHelper", "clear notifyId " + bVar2.f66b + " notifyKey " + ((String) bVar2.f67c));
        if (TextUtils.isEmpty((String) bVar2.f67c)) {
            o7.a aVar2 = a.C0117a.f10777a;
            String str7 = aVar.f55e;
            int[] iArr = {bVar2.f66b};
            p7.b bVar3 = aVar2.f10776f;
            bVar3.f11461e = 1;
            bVar3.f11460d = iArr;
            bVar3.f11462f = null;
            bVar3.f11463g = str7;
            bVar3.c(context);
            return;
        }
        o7.a aVar3 = a.C0117a.f10777a;
        String str8 = aVar.f55e;
        String str9 = (String) bVar2.f67c;
        p7.b bVar4 = aVar3.f10776f;
        bVar4.f11461e = 2;
        bVar4.f11460d = null;
        bVar4.f11462f = str9;
        bVar4.f11463g = str8;
        bVar4.c(context);
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((a8.a) obj).getClass();
        return true;
    }
}
