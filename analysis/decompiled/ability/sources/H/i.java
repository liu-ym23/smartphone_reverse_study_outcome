package H;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class i implements C.a, B.c, L0.e {

    /* renamed from: a, reason: collision with root package name */
    public volatile JSONObject f721a;

    public abstract void a(Context context);

    public abstract void b(h2.d dVar);

    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // L0.e
    public final void e(long j5) {
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // C.a
    public void onReady() {
    }

    @Override // C.a
    public void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optJSONObject("allow_log_type");
            jSONObjectOptJSONObject.optJSONObject("allow_metric_type");
            this.f721a = jSONObjectOptJSONObject.optJSONObject("allow_service_name");
        }
    }

    /* renamed from: c */
    public void mo0c() {
    }
}
