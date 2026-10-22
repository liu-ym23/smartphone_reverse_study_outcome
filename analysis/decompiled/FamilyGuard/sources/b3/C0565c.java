package b3;

import Y2.f;
import a3.C0426d;
import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.minor.Minor;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d3.C0671g;
import e3.C0688b;
import f3.C0720b;
import g3.C0742e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* renamed from: b3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0565c {

    /* renamed from: a, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.emitter.a f11819a;

    /* renamed from: b, reason: collision with root package name */
    private c3.c f11820b;

    /* renamed from: c, reason: collision with root package name */
    private Context f11821c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11822d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, C0563a> f11823e;

    /* renamed from: f, reason: collision with root package name */
    private C0720b f11824f;

    /* renamed from: b3.c$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final com.stepos.statsapp.v3.lib.plugin.emitter.a f11825a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f11826b;

        /* renamed from: c, reason: collision with root package name */
        private c3.c f11827c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f11828d;

        public a(Context context, com.stepos.statsapp.v3.lib.plugin.emitter.a aVar) {
            this.f11826b = context;
            this.f11825a = aVar;
        }

        public a a(c3.c cVar) {
            this.f11827c = cVar;
            return this;
        }

        public a b(boolean z5) {
            this.f11828d = z5;
            return this;
        }

        public C0565c c() {
            return new C0565c(this);
        }
    }

    /* renamed from: b3.c$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        U2.b f11829a;

        /* renamed from: b, reason: collision with root package name */
        int f11830b;

        /* renamed from: c, reason: collision with root package name */
        Map<String, Object> f11831c;

        public b(U2.b bVar, int i5, Map<String, Object> map) {
            this.f11829a = bVar;
            this.f11830b = i5;
            this.f11831c = map;
        }
    }

    public C0565c(a aVar) {
        this.f11819a = aVar.f11825a;
        this.f11820b = aVar.f11827c;
        this.f11821c = aVar.f11826b;
        this.f11822d = aVar.f11828d;
        this.f11820b.k(aVar.f11828d);
        this.f11823e = new HashMap();
        C0720b c0720b = new C0720b(aVar.f11826b, "com.stepos.statsapp.v3.event_filter");
        this.f11824f = c0720b;
        Iterator<? extends Map.Entry<String, ?>> it = c0720b.i().iterator();
        while (it.hasNext()) {
            C0563a c0563aA = C0563a.a(it.next().getValue().toString());
            if (c0563aA != null) {
                this.f11823e.put(c0563aA.b(), c0563aA);
            }
        }
        C0742e.k("Tracker", "Tracker created successfully.");
    }

    private int b(TrackerPayload trackerPayload, int i5) throws JSONException {
        C0563a c0563a;
        if (i5 == 0) {
            return 0;
        }
        if (!f.m().d().b()) {
            C0742e.l("Tracker", "getConfigSendType, config is no complete, request again");
            f.m().d().d(this.f11821c);
            if (!f.m().d().b()) {
                C0742e.l("Tracker", "getConfigSendType, config is no complete");
            }
        }
        Map<String, C0563a> map = this.f11823e;
        if (map == null || map.isEmpty() || (c0563a = this.f11823e.get(trackerPayload.D().get(Minor.COLUMN_NAME))) == null) {
            return 1;
        }
        if (!c0563a.c()) {
            C0742e.l("Tracker", "getConfigSendType, Not Tracking for false active");
            return -1;
        }
        if (c0563a.e()) {
            return 2;
        }
        return c0563a.d() ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(b bVar) throws JSONException {
        if (!C0671g.l(this.f11821c)) {
            C0742e.l("Tracker", "send event fail, system data collection is closed");
            return;
        }
        TrackerPayload trackerPayloadA = bVar.f11829a.a();
        e(trackerPayloadA);
        h(bVar.f11831c, trackerPayloadA);
        k(trackerPayloadA, bVar.f11830b);
    }

    private void e(TrackerPayload trackerPayload) {
        C0426d c0426dN = f.m().n();
        if (c0426dN != null) {
            trackerPayload.a("sid", c0426dN.f());
            trackerPayload.a("source", c0426dN.h());
        }
        c3.c cVar = this.f11820b;
        if (cVar != null) {
            trackerPayload.c(cVar.l());
            trackerPayload.c(this.f11820b.b());
            trackerPayload.c(this.f11820b.p());
            trackerPayload.c(this.f11820b.c(this.f11821c));
            trackerPayload.a("event_attrib", this.f11820b.n());
        }
    }

    private void h(Map<String, Object> map, TrackerPayload trackerPayload) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            trackerPayload.a(entry.getKey(), entry.getValue());
        }
    }

    private void k(TrackerPayload trackerPayload, int i5) throws JSONException {
        int iB = b(trackerPayload, i5);
        if (iB == -1) {
            return;
        }
        int iMax = this.f11822d ? 2 : Math.max(i5, iB);
        if (iMax == 2) {
            this.f11819a.e(trackerPayload);
        } else if (iMax == 3) {
            this.f11819a.d(trackerPayload);
        } else {
            this.f11819a.c(trackerPayload);
        }
    }

    public com.stepos.statsapp.v3.lib.plugin.emitter.a c() {
        return this.f11819a;
    }

    public void f(String str, String str2) {
        this.f11819a.j(str, str2);
    }

    public void g(Map<String, C0563a> map) {
        this.f11823e = map;
        SharedPreferences.Editor editorH = this.f11824f.h();
        editorH.clear();
        for (Map.Entry<String, C0563a> entry : this.f11823e.entrySet()) {
            editorH.putString(entry.getKey(), entry.getValue().toString());
        }
        editorH.commit();
    }

    public c3.c i() {
        return this.f11820b;
    }

    public void j(final b bVar) {
        C0688b.b(new Runnable() { // from class: b3.b
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f11817a.d(bVar);
            }
        });
    }
}
