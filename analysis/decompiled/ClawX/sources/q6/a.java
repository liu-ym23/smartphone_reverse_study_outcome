package q6;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4868a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4869b;

    /* renamed from: c, reason: collision with root package name */
    public c f4870c;
    public long d;

    public a(String name, boolean z) {
        p.e(name, "name");
        this.f4868a = name;
        this.f4869b = z;
        this.d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f4868a;
    }
}
