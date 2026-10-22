package m;

import com.stepos.alphame.utils.Consts;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13509a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13510b;

    /* renamed from: c, reason: collision with root package name */
    public c f13511c;

    /* renamed from: d, reason: collision with root package name */
    public c f13512d;

    public c(Object obj, Object obj2) {
        this.f13509a = obj;
        this.f13510b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f13509a.equals(cVar.f13509a) && this.f13510b.equals(cVar.f13510b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f13509a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f13510b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f13510b.hashCode() ^ this.f13509a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f13509a + Consts.SPLITTER_EQUAL + this.f13510b;
    }
}
