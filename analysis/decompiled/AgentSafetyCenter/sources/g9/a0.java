package g9;

import android.util.Log;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public String f4398c;

    /* renamed from: f, reason: collision with root package name */
    public int f4399f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f4400g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f4401h;
    public final /* synthetic */ long i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b0 f4402j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String str, String str2, long j10, b0 b0Var, nb.c cVar) {
        super(2, cVar);
        this.f4400g = str;
        this.f4401h = str2;
        this.i = j10;
        this.f4402j = b0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new a0(this.f4400g, this.f4401h, this.i, this.f4402j, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        String str;
        ob.a aVar = ob.a.f9351c;
        int i = this.f4399f;
        String str2 = this.f4401h;
        String str3 = this.f4400g;
        if (i == 0) {
            id.c.I(obj);
            b0 b0Var = this.f4402j;
            String str4 = b0Var.f4408a;
            StringBuilder sbP = androidx.activity.b.p("POST tool_security/device/permission update start groupId=", str3, " mode=", str2, " updateTimeMs=");
            long j10 = this.i;
            sbP.append(j10);
            sbP.append(" url=");
            sbP.append(str4);
            Log.i("PermissionCloudApi", sbP.toString());
            str3.getClass();
            str2.getClass();
            String string = new JSONObject().put("action", "update").put("version", 1).put("data", new JSONObject().put("items", new JSONArray().put(new JSONObject().put("group_id", str3).put("mode", str2))).put("update_time", j10)).toString();
            string.getClass();
            Set set = p9.a.f9925a;
            Log.i("PermissionCloudApi", "POST tool_security/device/permission update request ".concat(p9.a.a(string, "body")));
            this.f4398c = "POST tool_security/device/permission update";
            this.f4399f = 1;
            objC = b0.c(b0Var, string, "POST tool_security/device/permission update", this);
            if (objC == aVar) {
                return aVar;
            }
            str = "POST tool_security/device/permission update";
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = this.f4398c;
            id.c.I(obj);
            objC = ((jb.i) obj).f6762c;
        }
        if (!(objC instanceof jb.h)) {
            objC = jb.v.f6774a;
        }
        jb.i iVarA = jb.i.a(objC);
        Object obj2 = iVarA.f6762c;
        if (!(obj2 instanceof jb.h)) {
            Log.i("PermissionCloudApi", str + " ok groupId=" + str3 + " mode=" + str2);
        }
        Throwable thB = jb.i.b(obj2);
        if (thB != null) {
            Log.w("PermissionCloudApi", str + " failed groupId=" + str3 + " mode=" + str2 + ": " + thB.getMessage(), thB);
        }
        return iVarA;
    }
}
