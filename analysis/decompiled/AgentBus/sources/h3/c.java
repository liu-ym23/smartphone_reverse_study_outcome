package h3;

import q7.k;

/* loaded from: classes.dex */
public final class c implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final int f4087f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4088g;

    /* renamed from: h, reason: collision with root package name */
    public final String f4089h;

    /* renamed from: i, reason: collision with root package name */
    public final String f4090i;

    public c(String str, int i2, int i10, String str2) {
        this.f4087f = i2;
        this.f4088g = i10;
        this.f4089h = str;
        this.f4090i = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        k.e(cVar, "other");
        int i2 = this.f4087f - cVar.f4087f;
        return i2 == 0 ? this.f4088g - cVar.f4088g : i2;
    }
}
