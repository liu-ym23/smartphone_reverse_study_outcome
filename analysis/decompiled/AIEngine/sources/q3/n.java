package q3;

import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements b3.e {

    /* renamed from: a, reason: collision with root package name */
    public String f11573a;

    @Override // b3.e
    public final void a(JsonGenerator jsonGenerator, b3.h hVar) {
        CharSequence charSequence = this.f11573a;
        if (charSequence instanceof b3.e) {
            ((b3.e) charSequence).a(jsonGenerator, hVar);
        } else if (charSequence instanceof v2.e) {
            jsonGenerator.Y0((v2.e) charSequence);
        } else {
            jsonGenerator.X0(String.valueOf(charSequence));
        }
    }

    @Override // b3.e
    public final void b(JsonGenerator jsonGenerator, b3.h hVar, k3.e eVar) {
        CharSequence charSequence = this.f11573a;
        if (charSequence instanceof b3.e) {
            ((b3.e) charSequence).b(jsonGenerator, hVar, eVar);
        } else if (charSequence instanceof v2.e) {
            a(jsonGenerator, hVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        String str = this.f11573a;
        String str2 = ((n) obj).f11573a;
        if (str == str2) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public final int hashCode() {
        String str = this.f11573a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return a0.a.k("[RawValue of type ", com.fasterxml.jackson.databind.util.a.f(this.f11573a), "]");
    }
}
