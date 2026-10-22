package az2;

import ny2.g;
import org.json.JSONObject;
import py2.k;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f16798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py2.a f16799b;

    @Override // ny2.g
    public final JSONObject b() {
        return null;
    }

    @Override // ny2.g
    public final JSONObject g() {
        return null;
    }

    @Override // ny2.g
    public final String getContainerType() {
        return "";
    }

    @Override // ny2.g
    public final String getEventType() {
        return "containerError";
    }

    @Override // ny2.g
    public final ny2.f a() {
        k r100 = new k();
        r100.f531017f = this.f16798a.f16796c;
        r100.f531014c = null;
        return r100;
    }

    @Override // ny2.g
    public final ny2.f d() {
        return this.f16798a.a();
    }

    @Override // ny2.g
    public final ny2.b f() {
        return new py2.c();
    }

    @Override // ny2.g
    public final String getBiz() {
        return this.f16798a.f16797d;
    }

    @Override // ny2.g
    public final py2.a c() {
        return this.f16799b;
    }

    public d(b r100, py2.a r101) {
        this.f16798a = r100;
        this.f16799b = r101;
    }
}
