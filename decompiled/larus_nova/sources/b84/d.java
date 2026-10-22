package b84;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18022d;

    public abstract boolean a(JSONObject r100) throws JSONException, SecurityException;

    public void b(JSONObject r100) {
    }

    public d() {
        this.f18020b = true;
        this.f18021c = false;
        this.f18022d = false;
    }

    public d(boolean r100, boolean r101) {
        this.f18020b = r100;
        this.f18021c = r101;
        this.f18022d = false;
    }
}
