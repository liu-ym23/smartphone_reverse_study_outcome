package com.stepos.statsapp.v3.lib.plugin.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.emitter.Emitter;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.thread.GlobalExecutor;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f30974g = "Tracker";

    /* renamed from: a, reason: collision with root package name */
    private Emitter f30975a;

    /* renamed from: b, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.tracker.subject.c f30976b;

    /* renamed from: c, reason: collision with root package name */
    private Context f30977c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30978d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, com.stepos.statsapp.v3.lib.plugin.tracker.a> f30979e;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferencesHelper f30980f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Emitter f30981a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f30982b;

        /* renamed from: c, reason: collision with root package name */
        private com.stepos.statsapp.v3.lib.plugin.tracker.subject.c f30983c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f30984d;

        public a(Context context, Emitter emitter) {
            this.f30982b = context;
            this.f30981a = emitter;
        }

        public a a(com.stepos.statsapp.v3.lib.plugin.tracker.subject.c cVar) {
            this.f30983c = cVar;
            return this;
        }

        public a a(boolean z10) {
            this.f30984d = z10;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.stepos.statsapp.v3.lib.plugin.tracker.b$b, reason: collision with other inner class name */
    public static class C0370b {

        /* renamed from: a, reason: collision with root package name */
        com.stepos.statsapp.v3.lib.plugin.events.b f30985a;

        /* renamed from: b, reason: collision with root package name */
        int f30986b;

        /* renamed from: c, reason: collision with root package name */
        Map<String, Object> f30987c;

        public C0370b(com.stepos.statsapp.v3.lib.plugin.events.b bVar, int i10, Map<String, Object> map) {
            this.f30985a = bVar;
            this.f30986b = i10;
            this.f30987c = map;
        }
    }

    public b(a aVar) {
        this.f30975a = aVar.f30981a;
        this.f30976b = aVar.f30983c;
        this.f30977c = aVar.f30982b;
        this.f30978d = aVar.f30984d;
        this.f30976b.a(aVar.f30984d);
        this.f30979e = new HashMap();
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(aVar.f30982b, "com.stepos.statsapp.v3.event_filter");
        this.f30980f = sharedPreferencesHelper;
        Iterator<? extends Map.Entry<String, ?>> it = sharedPreferencesHelper.getAllEntries().iterator();
        while (it.hasNext()) {
            com.stepos.statsapp.v3.lib.plugin.tracker.a aVarA = com.stepos.statsapp.v3.lib.plugin.tracker.a.a(it.next().getValue().toString());
            if (aVarA != null) {
                this.f30979e.put(aVarA.a(), aVarA);
            }
        }
        Logger.v(f30974g, "Tracker created successfully.");
    }

    public com.stepos.statsapp.v3.lib.plugin.tracker.subject.c b() {
        return this.f30976b;
    }

    public void a(Map<String, com.stepos.statsapp.v3.lib.plugin.tracker.a> map) {
        this.f30979e = map;
        SharedPreferences.Editor editorEdit = this.f30980f.edit();
        editorEdit.clear();
        for (Map.Entry<String, com.stepos.statsapp.v3.lib.plugin.tracker.a> entry : this.f30979e.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue().toString());
        }
        editorEdit.commit();
    }

    public void b(final C0370b c0370b) {
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.tracker.c
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f30988a.a(c0370b);
            }
        });
    }

    private void b(TrackerPayload trackerPayload, int i10) throws JSONException {
        int iA = a(trackerPayload, i10);
        if (iA == -1) {
            return;
        }
        int iMax = this.f30978d ? 2 : Math.max(i10, iA);
        if (iMax == 2) {
            this.f30975a.addRealtime(trackerPayload);
        } else if (iMax == 3) {
            this.f30975a.addNeartime(trackerPayload);
        } else {
            this.f30975a.add(trackerPayload);
        }
    }

    public Emitter a() {
        return this.f30975a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C0370b c0370b) throws JSONException {
        if (!StepOSUtils.isSystemDataCollectionEnable(this.f30977c)) {
            Logger.w(f30974g, "send event fail, system data collection is closed");
            return;
        }
        TrackerPayload trackerPayloadA = c0370b.f30985a.a();
        a(trackerPayloadA);
        a(c0370b.f30987c, trackerPayloadA);
        b(trackerPayloadA, c0370b.f30986b);
    }

    private void a(TrackerPayload trackerPayload) {
        com.stepos.statsapp.v3.lib.plugin.session.c cVarD = com.stepos.statsapp.v3.lib.plugin.sdk.a.c().d();
        if (cVarD != null) {
            trackerPayload.addHeader(Parameters.SESSION_ID, cVarD.b());
            trackerPayload.addHeader("source", cVarD.d());
        }
        com.stepos.statsapp.v3.lib.plugin.tracker.subject.c cVar = this.f30976b;
        if (cVar != null) {
            trackerPayload.addHeaderMap(cVar.b());
            trackerPayload.addHeaderMap(this.f30976b.a());
            trackerPayload.addHeaderMap(this.f30976b.d());
            trackerPayload.addHeaderMap(this.f30976b.a(this.f30977c));
            trackerPayload.addHeader(Parameters.EVENT_ATTRIB, this.f30976b.c());
        }
    }

    private void a(Map<String, Object> map, TrackerPayload trackerPayload) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            trackerPayload.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private int a(TrackerPayload trackerPayload, int i10) throws JSONException {
        com.stepos.statsapp.v3.lib.plugin.tracker.a aVar;
        if (i10 == 0) {
            return 0;
        }
        if (!com.stepos.statsapp.v3.lib.plugin.sdk.a.c().a().isComplete()) {
            Logger.w(f30974g, "getConfigSendType, config is no complete, request again");
            com.stepos.statsapp.v3.lib.plugin.sdk.a.c().a().loadConfig(this.f30977c);
            if (!com.stepos.statsapp.v3.lib.plugin.sdk.a.c().a().isComplete()) {
                Logger.w(f30974g, "getConfigSendType, config is no complete");
            }
        }
        Map<String, com.stepos.statsapp.v3.lib.plugin.tracker.a> map = this.f30979e;
        if (map == null || map.isEmpty() || (aVar = this.f30979e.get(trackerPayload.getHeaderMap().get("name"))) == null) {
            return 1;
        }
        if (!aVar.b()) {
            Logger.w(f30974g, "getConfigSendType, Not Tracking for false active");
            return -1;
        }
        if (aVar.d()) {
            return 2;
        }
        return aVar.c() ? 3 : 1;
    }

    public void a(String str, String str2) {
        this.f30975a.updateEventSource(str, str2);
    }
}
