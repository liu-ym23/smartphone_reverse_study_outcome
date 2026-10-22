package dd;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8466a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8467b;

    /* renamed from: c, reason: collision with root package name */
    public d f8468c;

    /* renamed from: d, reason: collision with root package name */
    public long f8469d;

    public a(String name, boolean z) {
        g.f(name, "name");
        this.f8466a = name;
        this.f8467b = z;
        this.f8469d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f8466a;
    }
}
