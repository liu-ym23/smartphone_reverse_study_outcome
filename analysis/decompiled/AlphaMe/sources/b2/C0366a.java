package b2;

import B0.g;
import a2.AbstractC0155a;
import android.text.TextUtils;
import f2.b;
import f2.c;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0366a {

    /* renamed from: a, reason: collision with root package name */
    public String f4367a;

    /* renamed from: b, reason: collision with root package name */
    public String f4368b;

    /* renamed from: c, reason: collision with root package name */
    public int f4369c;

    /* renamed from: d, reason: collision with root package name */
    public String f4370d;

    /* renamed from: e, reason: collision with root package name */
    public String f4371e;

    /* renamed from: f, reason: collision with root package name */
    public int f4372f;

    public static C0366a a(f2.a aVar, boolean z4) {
        b bVar = aVar.f12539m;
        int i4 = bVar != null ? bVar.f12542a : 0;
        C0366a cVar = z4 ? new c() : new C0366a();
        cVar.f4367a = aVar.f12529c;
        cVar.f4368b = aVar.f12530d;
        cVar.f4370d = aVar.f12527a;
        cVar.f4369c = 0;
        cVar.f4372f = i4;
        String string = aVar.f12534h;
        Map map = aVar.f12537k;
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
        AbstractC0155a.b("PushMessage", "self json " + string);
        cVar.f4371e = string;
        return cVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PushMessage{title='");
        sb.append(this.f4367a);
        sb.append("', content='");
        sb.append(this.f4368b);
        sb.append("', pushType=");
        sb.append(this.f4369c);
        sb.append(", taskId='");
        sb.append(this.f4370d);
        sb.append("', selfDefineContentString='");
        sb.append(this.f4371e);
        sb.append("', notifyId=");
        return g.o(sb, this.f4372f, '}');
    }
}
