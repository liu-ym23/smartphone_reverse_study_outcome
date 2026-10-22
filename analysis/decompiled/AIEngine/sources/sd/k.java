package sd;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11952a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11953b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f11954c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f11955d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f11956e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f11957f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<ec.c<?>, Object> f11958g;

    public k(boolean z, boolean z3, Long l10, Long l11, Long l12, Long l13) {
        Map mapD0 = kotlin.collections.b.d0();
        this.f11952a = z;
        this.f11953b = z3;
        this.f11954c = l10;
        this.f11955d = l11;
        this.f11956e = l12;
        this.f11957f = l13;
        this.f11958g = kotlin.collections.b.n0(mapD0);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f11952a) {
            arrayList.add("isRegularFile");
        }
        if (this.f11953b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f11954c;
        if (l10 != null) {
            arrayList.add("byteCount=" + l10);
        }
        Long l11 = this.f11955d;
        if (l11 != null) {
            arrayList.add("createdAt=" + l11);
        }
        Long l12 = this.f11956e;
        if (l12 != null) {
            arrayList.add("lastModifiedAt=" + l12);
        }
        Long l13 = this.f11957f;
        if (l13 != null) {
            arrayList.add("lastAccessedAt=" + l13);
        }
        Map<ec.c<?>, Object> map = this.f11958g;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return kotlin.collections.a.z0(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }
}
