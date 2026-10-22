package n0;

import B.e;
import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5343a;
    public final HashMap b = new HashMap();

    public d(String str) {
        this.f5343a = str;
    }

    @Override // B.e
    public final void a(String str, String str2) {
        this.b.put(str, new TypedString(str2));
    }

    @Override // B.e
    public final void b(String str, File file, String str2, String str3, HashMap map) {
        new TypedFile((String) null, file);
        this.b.put(str, new C1736b(map));
    }

    @Override // B.e
    public final void c(String str, HashMap map, String str2, String str3) {
        C1735a c1735a = new C1735a();
        if (TextUtils.isEmpty(str3)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("defaultData", "none commonParams");
            } catch (JSONException unused) {
            }
            jSONObject.toString();
        }
        this.b.put(str, c1735a);
    }

    @Override // B.e
    public final void d(HashMap map, File file) {
        new TypedFile((String) null, file);
        this.b.put(BffConstant.Type.File, new C1736b(map));
    }

    @Override // B.e
    public final B.b a() {
        if (RetrofitUtils.createSsService(this.f5343a, InterfaceC1737c.class) != null) {
            throw new ClassCastException();
        }
        HashMap map = new HashMap();
        try {
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            return new B.b(0, map, null);
        }
    }
}
