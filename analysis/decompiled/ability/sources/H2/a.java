package H2;

import com.bytedance.apm.doctor.DoctorManager$ApmListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import z.c;

/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f730a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ArrayList c;

    public a(JSONObject jSONObject, String str, ArrayList arrayList) {
        this.f730a = jSONObject;
        this.b = str;
        this.c = arrayList;
    }

    @Override // z.c
    public final cc.dd.aa.cc.cc.b b() {
        return cc.dd.aa.cc.cc.b.c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.b;
        JSONObject jSONObject = this.f730a;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("DATA_DOCTOR");
            jSONObject2.put(str, System.currentTimeMillis());
            int iOptInt = jSONObject2.optInt("DATA_ID");
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((DoctorManager$ApmListener) it.next()).onDataEvent(iOptInt, str, jSONObject);
            }
        } catch (Exception unused) {
        }
    }
}
