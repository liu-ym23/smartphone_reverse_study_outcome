package g9;

import android.util.Log;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public String f4632c;

    /* renamed from: f, reason: collision with root package name */
    public String f4633f;

    /* renamed from: g, reason: collision with root package name */
    public int f4634g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f4635h;
    public final /* synthetic */ b0 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f4636j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(boolean z10, b0 b0Var, String str, nb.c cVar) {
        super(2, cVar);
        this.f4635h = z10;
        this.i = b0Var;
        this.f4636j = str;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new w(this.f4635h, this.i, this.f4636j, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((w) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objL;
        String str;
        String str2;
        ob.a aVar = ob.a.f9351c;
        int i = this.f4634g;
        String str3 = this.f4636j;
        if (i == 0) {
            id.c.I(obj);
            String str4 = this.f4635h ? "reset" : "list";
            String strConcat = "POST tool_security/device/permission ".concat(str4);
            b0 b0Var = this.i;
            Log.i("PermissionCloudApi", strConcat + " start url=" + b0Var.f4408a + " locale=" + str3);
            String string = new JSONObject().put("action", str4).put("version", 1).toString();
            string.getClass();
            this.f4632c = str4;
            this.f4633f = strConcat;
            this.f4634g = 1;
            Object objC = b0.c(b0Var, string, strConcat, this);
            if (objC == aVar) {
                return aVar;
            }
            String str5 = str4;
            objL = objC;
            str = str5;
            str2 = strConcat;
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = this.f4633f;
            str = this.f4632c;
            id.c.I(obj);
            objL = ((jb.i) obj).f6762c;
        }
        if (!(objL instanceof jb.h)) {
            try {
                objL = h5.t.I((String) objL, str3);
                if (objL == null) {
                    throw new IOException("parse " + str + " failed");
                }
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
        }
        jb.i iVarA = jb.i.a(objL);
        Object obj2 = iVarA.f6762c;
        if (!(obj2 instanceof jb.h)) {
            Log.i("PermissionCloudApi", str2 + " ok categories=" + ((p) obj2).f4572a.size());
        }
        Throwable thB = jb.i.b(obj2);
        if (thB != null) {
            Log.w("PermissionCloudApi", str2 + " failed: " + thB.getMessage(), thB);
        }
        return iVarA;
    }
}
