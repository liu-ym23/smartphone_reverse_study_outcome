package h2;

import T2.d;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.s;
import com.stepos.alphame.BuildConfig;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: h2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0589a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12691a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12692b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12693c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12694d = null;

    public C0589a(Application application, e eVar) {
        this.f12693c = application;
        this.f12692b = eVar;
    }

    public final s a() {
        O2.a aVar;
        s sVar = new s();
        sVar.f9680b = (e) this.f12692b;
        P2.c cVar = (P2.c) this.f12694d;
        sVar.f9681c = cVar;
        sVar.f9682d = (Context) this.f12693c;
        boolean z4 = this.f12691a;
        sVar.f9679a = z4;
        cVar.f1584d.put(BuildConfig.BUILD_TYPE, Boolean.valueOf(z4));
        sVar.f9683e = new HashMap();
        S2.a aVar2 = new S2.a((Context) this.f12693c, "com.stepos.statsapp.v3.event_filter");
        sVar.f9684f = aVar2;
        Iterator<Map.Entry<String, ?>> it = aVar2.f1791a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject(it.next().getValue().toString());
                aVar = new O2.a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
            } catch (JSONException e4) {
                e4.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                ((Map) sVar.f9683e).put(aVar.f1538a, aVar);
            }
        }
        d.e("Tracker", "Tracker created successfully.");
        return sVar;
    }

    public final String toString() {
        return super.toString();
    }
}
