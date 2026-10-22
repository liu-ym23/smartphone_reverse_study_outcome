package N1;

import com.stepos.alphame.utils.Consts;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1469a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1470b;

    /* renamed from: c, reason: collision with root package name */
    public d f1471c;

    /* renamed from: d, reason: collision with root package name */
    public d f1472d;

    public d(Object obj, a aVar) {
        this.f1469a = obj;
        this.f1470b = aVar;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1469a.equals(dVar.f1469a) && this.f1470b.equals(dVar.f1470b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1469a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1470b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f1470b.hashCode() ^ this.f1469a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f1469a + Consts.SPLITTER_EQUAL + this.f1470b;
    }
}
