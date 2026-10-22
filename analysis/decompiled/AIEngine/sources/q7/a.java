package q7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.b1;
import java.util.HashMap;
import n7.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends b8.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f11628b = a.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f11628b;
        s7.a.b(str, "getMessage start");
        try {
            a8.a aVar = new a8.a();
            aVar.f51a = intent.getStringExtra("extra_app_push_task_Id");
            aVar.f52b = intent.getStringExtra("extra_app_push_seq_Id");
            aVar.f61l = intent.getStringExtra("message");
            aVar.f59j = intent.getStringExtra("extra_app_push_task_timestamp");
            aVar.f64o = intent.getStringExtra("msg_es");
            aVar.f55e = context.getPackageName();
            s7.a.b(str, "getMessage success");
            return aVar;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "message";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, b bVar) {
        a8.a aVar = (a8.a) obj;
        if (aVar == null) {
            return;
        }
        b1.Q(context, "rpe", aVar.f55e, aVar.f51a, aVar.f52b, aVar.f59j);
        if (TextUtils.isEmpty(aVar.f61l)) {
            return;
        }
        String str = aVar.f51a;
        String str2 = aVar.f52b;
        String str3 = aVar.f59j;
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
        bVar.onMessage(context, aVar.f61l, new JSONObject(map).toString());
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((a8.a) obj).getClass();
        return true;
    }
}
