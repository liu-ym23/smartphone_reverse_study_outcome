package v6;

import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f13383a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13384b;

    public b(String str, String str2) {
        this.f13383a = str;
        this.f13384b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g.b(this.f13383a, bVar.f13383a) && g.b(this.f13384b, bVar.f13384b);
    }

    public final int hashCode() {
        String str = this.f13383a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f13384b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return e.c("CloudUploadScene(bizCode=", this.f13383a, ", sourceType=", this.f13384b, ")");
    }
}
