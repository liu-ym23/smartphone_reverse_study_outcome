package e8;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final z7.b f2405b = z7.d.b(k.class);

    /* renamed from: a, reason: collision with root package name */
    public j f2406a;

    @Override // e8.i
    public final void a() {
        this.f2406a.a();
        throw null;
    }

    @Override // e8.i
    public final List b() {
        return this.f2406a.b();
    }

    @Override // e8.i
    public final List c() {
        return Collections.unmodifiableList(this.f2406a.f2399c);
    }

    @Override // e8.i
    public final boolean isEnabled() {
        return this.f2406a != null;
    }
}
