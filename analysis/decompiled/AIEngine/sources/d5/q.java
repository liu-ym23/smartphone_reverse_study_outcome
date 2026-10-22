package d5;

import com.google.gson.internal.LinkedTreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends o {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedTreeMap<String, o> f8383a = new LinkedTreeMap<>(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof q) && ((q) obj).f8383a.equals(this.f8383a);
        }
        return true;
    }

    public final void g(String str, String str2) {
        o rVar = str2 == null ? p.f8382a : new r(str2);
        if (rVar == null) {
            rVar = p.f8382a;
        }
        this.f8383a.put(str, rVar);
    }

    public final o h(String str) {
        return this.f8383a.get(str);
    }

    public final int hashCode() {
        return this.f8383a.hashCode();
    }
}
