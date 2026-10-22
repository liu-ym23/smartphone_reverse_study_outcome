package e8;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final z7.b f2402b = z7.d.b(g.class);

    /* renamed from: a, reason: collision with root package name */
    public f f2403a;

    @Override // e8.i
    public final void a() {
        this.f2403a.a();
    }

    @Override // e8.i
    public final List b() {
        return this.f2403a.b();
    }

    @Override // e8.i
    public final List c() {
        return Collections.unmodifiableList(this.f2403a.f2399c);
    }

    @Override // e8.i
    public final boolean isEnabled() {
        return this.f2403a != null;
    }
}
