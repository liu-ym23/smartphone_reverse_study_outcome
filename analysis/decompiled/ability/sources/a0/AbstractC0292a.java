package a0;

import H.h;
import L0.f;
import android.app.Activity;
import android.app.Application;
import org.json.JSONObject;
import w0.AbstractC2080a;

/* renamed from: a0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0292a extends AbstractC2080a {
    public boolean g;
    public boolean h;
    public int i = 5;

    public AbstractC0292a() {
        this.e = "battery";
        L0.d.f925a.a(this);
    }

    @Override // w0.AbstractC2080a
    public void b(JSONObject jSONObject) {
        this.g = jSONObject.optInt("enable_upload", 0) == 1;
        this.h = jSONObject.optInt("background_enable", 0) == 1;
        this.i = jSONObject.optInt("sample_interval", 5);
    }

    @Override // w0.AbstractC2080a, B.c
    /* renamed from: c */
    public final void mo0c() {
        this.b = false;
        Application application = h.f711a;
        L0.d.f925a.a(this);
    }

    @Override // w0.AbstractC2080a, B.c
    public final void f(Activity activity) {
        this.b = true;
        Application application = h.f711a;
        if (this.h) {
            return;
        }
        f fVar = L0.d.f925a;
        fVar.getClass();
        try {
            fVar.f.remove(this);
        } catch (Throwable unused) {
        }
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return this.g;
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return this.i * 60000;
    }
}
