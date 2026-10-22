package P1;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b extends R1.a<Object> {

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f5363c;

    /* renamed from: d, reason: collision with root package name */
    public String f5364d;

    /* renamed from: e, reason: collision with root package name */
    public ReentrantReadWriteLock f5365e = new ReentrantReadWriteLock();

    public b(String str) {
        this.f5364d = str;
    }

    public JSONObject a() {
        if (this.f5363c == null) {
            try {
                this.f5363c = new JSONObject(O1.a.b(this.f5364d, "{}"));
            } catch (JSONException e10) {
                S1.a.b(e10);
            }
        }
        JSONObject jSONObject = this.f5363c;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    public int b(String str, int i10) {
        this.f5365e.readLock().lock();
        try {
            return a().optInt(str, i10);
        } catch (Exception e10) {
            S1.a.d("" + str, e10);
            return i10;
        } finally {
            this.f5365e.readLock().unlock();
        }
    }

    public String toString() {
        return a().toString();
    }
}
