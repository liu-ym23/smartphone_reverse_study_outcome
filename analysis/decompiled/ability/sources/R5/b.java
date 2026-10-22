package R5;

import android.content.Context;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o3.C1760c;
import o3.C1761d;
import o3.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1153a;
    public Object b;
    public Object c;
    public Object d;

    public b(f fVar, C1761d c1761d) {
        this.d = fVar;
        this.b = c1761d;
        this.c = c1761d.c ? null : new boolean[fVar.g];
    }

    public d a() {
        a aVar;
        d dVar = new d();
        dVar.c = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.d) this.b;
        S5.a aVar2 = (S5.a) this.d;
        dVar.d = aVar2;
        Context context = (Context) this.c;
        dVar.f1155a = context;
        boolean z10 = this.f1153a;
        dVar.b = z10;
        aVar2.d.put(BuildConfig.BUILD_TYPE, Boolean.valueOf(z10));
        dVar.e = new HashMap();
        V5.a aVar3 = new V5.a(context, "com.stepos.statsapp.v3.event_filter");
        dVar.f = aVar3;
        Iterator<Map.Entry<String, ?>> it = aVar3.f1385a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject(it.next().getValue().toString());
                aVar = new a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
            } catch (JSONException e) {
                e.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                ((HashMap) dVar.e).put(aVar.f1152a, aVar);
            }
        }
        W5.c.e("Tracker", "Tracker created successfully.");
        return dVar;
    }

    public void b() {
        f.b((f) this.d, this, false);
    }

    public OutputStream c() {
        FileOutputStream fileOutputStream;
        C1760c c1760c;
        synchronized (((f) this.d)) {
            try {
                C1761d c1761d = (C1761d) this.b;
                if (c1761d.d != this) {
                    throw new IllegalStateException();
                }
                if (!c1761d.c) {
                    ((boolean[]) this.c)[0] = true;
                }
                File fileB = c1761d.b(0);
                try {
                    fileOutputStream = new FileOutputStream(fileB);
                } catch (FileNotFoundException unused) {
                    ((f) this.d).f5422a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileB);
                    } catch (FileNotFoundException unused2) {
                        return f.p;
                    }
                }
                c1760c = new C1760c(this, fileOutputStream);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1760c;
    }
}
