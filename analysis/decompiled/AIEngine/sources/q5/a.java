package q5;

import com.stepos.core.ota.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11616a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11617b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11618c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11619d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11620e;

    /* renamed from: f, reason: collision with root package name */
    public final long f11621f;

    public a(String str, int i10, int i11, String str2, String str3, long j10) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("hit keyword must not be blank");
        }
        if (i10 < 0 || i11 <= i10) {
            throw new IllegalArgumentException(d.e(i10, "invalid hit span [", i11, ", ", ")"));
        }
        if (str2 == null || str2.trim().isEmpty()) {
            throw new IllegalArgumentException("hit tagId must not be blank");
        }
        if (str3 == null || str3.trim().isEmpty()) {
            throw new IllegalArgumentException("hit wordId must not be blank");
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException("hit tableId must be greater than zero");
        }
        this.f11616a = str;
        this.f11617b = i10;
        this.f11618c = i11;
        this.f11619d = str2;
        this.f11620e = str3;
        this.f11621f = j10;
    }

    public static ArrayList a(b bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList(bVar.f11624c.size());
        Iterator<String> it = bVar.f11624c.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(bVar.f11622a, i10, i11, it.next(), bVar.f11625d, bVar.f11626e));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11617b == aVar.f11617b && this.f11618c == aVar.f11618c && this.f11621f == aVar.f11621f && this.f11616a.equals(aVar.f11616a) && this.f11619d.equals(aVar.f11619d) && this.f11620e.equals(aVar.f11620e);
    }

    public final int hashCode() {
        return Objects.hash(this.f11616a, Integer.valueOf(this.f11617b), Integer.valueOf(this.f11618c), this.f11619d, this.f11620e, Long.valueOf(this.f11621f));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("KeywordHit(keyword=");
        sb2.append(this.f11616a);
        sb2.append(", startPos=");
        sb2.append(this.f11617b);
        sb2.append(", endPos=");
        sb2.append(this.f11618c);
        sb2.append(", tagId=");
        sb2.append(this.f11619d);
        sb2.append(", wordId=");
        sb2.append(this.f11620e);
        sb2.append(", tableId=");
        return ai.onnxruntime.a.m(sb2, this.f11621f, ")");
    }
}
