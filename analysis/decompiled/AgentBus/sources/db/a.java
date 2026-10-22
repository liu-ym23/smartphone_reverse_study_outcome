package db;

import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3016a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3017b;

    /* renamed from: c, reason: collision with root package name */
    public c f3018c;

    /* renamed from: d, reason: collision with root package name */
    public long f3019d;

    public a(String str, boolean z4) {
        k.e(str, "name");
        this.f3016a = str;
        this.f3017b = z4;
        this.f3019d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f3016a;
    }
}
