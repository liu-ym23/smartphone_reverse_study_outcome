package G1;

import com.stepos.alphame.utils.Consts;
import java.util.Map;

/* loaded from: classes.dex */
public final class n implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public n f611a;

    /* renamed from: b, reason: collision with root package name */
    public n f612b;

    /* renamed from: c, reason: collision with root package name */
    public n f613c;

    /* renamed from: d, reason: collision with root package name */
    public n f614d;

    /* renamed from: e, reason: collision with root package name */
    public n f615e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f616f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f617g;

    /* renamed from: h, reason: collision with root package name */
    public Object f618h;

    /* renamed from: i, reason: collision with root package name */
    public int f619i;

    public n(boolean z4) {
        this.f616f = null;
        this.f617g = z4;
        this.f615e = this;
        this.f614d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f616f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f618h;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f616f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f618h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f616f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f618h;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f617g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f618h;
        this.f618h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f616f + Consts.SPLITTER_EQUAL + this.f618h;
    }

    public n(boolean z4, n nVar, Object obj, n nVar2, n nVar3) {
        this.f611a = nVar;
        this.f616f = obj;
        this.f617g = z4;
        this.f619i = 1;
        this.f614d = nVar2;
        this.f615e = nVar3;
        nVar3.f614d = this;
        nVar2.f615e = this;
    }
}
