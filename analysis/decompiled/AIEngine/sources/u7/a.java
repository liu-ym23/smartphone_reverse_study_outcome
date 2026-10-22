package u7;

import a8.b;
import a8.c;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f13176a;

    /* renamed from: b, reason: collision with root package name */
    public String f13177b;

    /* renamed from: c, reason: collision with root package name */
    public String f13178c;

    /* renamed from: d, reason: collision with root package name */
    public String f13179d;

    /* renamed from: e, reason: collision with root package name */
    public int f13180e;

    public static a a(a8.a aVar, boolean z) {
        b bVar = aVar.f62m;
        int i10 = bVar != null ? bVar.f66b : 0;
        a cVar = z ? new c() : new a();
        cVar.f13176a = aVar.f53c;
        cVar.f13177b = aVar.f54d;
        cVar.f13178c = aVar.f51a;
        cVar.f13180e = i10;
        String string = aVar.h;
        HashMap map = aVar.f60k;
        if (TextUtils.isEmpty(string)) {
            if (map != null) {
                string = (String) map.get("sk");
                if (TextUtils.isEmpty(string)) {
                    string = new JSONObject(map).toString();
                }
            } else {
                string = null;
            }
        }
        s7.a.b("PushMessage", "self json " + string);
        cVar.f13179d = string;
        return cVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PushMessage{title='");
        sb2.append(this.f13176a);
        sb2.append("', content='");
        sb2.append(this.f13177b);
        sb2.append("', pushType=0, taskId='");
        sb2.append(this.f13178c);
        sb2.append("', selfDefineContentString='");
        sb2.append(this.f13179d);
        sb2.append("', notifyId=");
        return a0.a.l(sb2, this.f13180e, '}');
    }
}
