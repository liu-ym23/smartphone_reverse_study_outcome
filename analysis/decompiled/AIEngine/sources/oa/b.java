package oa;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import pa.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public V3OfflineEmitter f10839a;

    /* renamed from: b, reason: collision with root package name */
    public c f10840b;

    /* renamed from: c, reason: collision with root package name */
    public Context f10841c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10842d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f10843e;

    /* renamed from: f, reason: collision with root package name */
    public sa.a f10844f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final V3OfflineEmitter f10845a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f10846b;

        /* renamed from: c, reason: collision with root package name */
        public c f10847c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10848d;

        public a(Context context, V3OfflineEmitter v3OfflineEmitter) {
            this.f10846b = context;
            this.f10845a = v3OfflineEmitter;
        }

        public final b a() {
            oa.a aVar;
            b bVar = new b();
            bVar.f10839a = this.f10845a;
            c cVar = this.f10847c;
            bVar.f10840b = cVar;
            Context context = this.f10846b;
            bVar.f10841c = context;
            boolean z = this.f10848d;
            bVar.f10842d = z;
            cVar.f11475d.put("debug", Boolean.valueOf(z));
            bVar.f10843e = new HashMap();
            sa.a aVar2 = new sa.a(context, "com.stepos.statsapp.v3.event_filter");
            bVar.f10844f = aVar2;
            Iterator<Map.Entry<String, ?>> it = aVar2.f11898a.getAll().entrySet().iterator();
            while (it.hasNext()) {
                try {
                    JSONObject jSONObject = new JSONObject(it.next().getValue().toString());
                    aVar = new oa.a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    bVar.f10843e.put(aVar.f10835a, aVar);
                }
            }
            ta.c.e("Tracker", "Tracker created successfully.");
            return bVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: oa.b$b, reason: collision with other inner class name */
    public static class C0119b {

        /* renamed from: a, reason: collision with root package name */
        public ha.a f10849a;

        /* renamed from: b, reason: collision with root package name */
        public int f10850b;

        public C0119b() {
            throw null;
        }
    }

    public final void a(HashMap map) {
        this.f10843e = map;
        SharedPreferences.Editor editorEdit = this.f10844f.f11898a.edit();
        editorEdit.clear();
        for (Map.Entry entry : this.f10843e.entrySet()) {
            editorEdit.putString((String) entry.getKey(), ((oa.a) entry.getValue()).toString());
        }
        editorEdit.commit();
    }
}
