package ob;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8011a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8012b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f8013c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f8014d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f8015e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f8016f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f8017g = d7.e0.a0(d7.a0.f2944f);

    public n(boolean z4, boolean z10, Long l6, Long l10, Long l11, Long l12) {
        this.f8011a = z4;
        this.f8012b = z10;
        this.f8013c = l6;
        this.f8014d = l10;
        this.f8015e = l11;
        this.f8016f = l12;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f8011a) {
            arrayList.add("isRegularFile");
        }
        if (this.f8012b) {
            arrayList.add("isDirectory");
        }
        Long l6 = this.f8013c;
        if (l6 != null) {
            arrayList.add("byteCount=" + l6);
        }
        Long l10 = this.f8014d;
        if (l10 != null) {
            arrayList.add("createdAt=" + l10);
        }
        Long l11 = this.f8015e;
        if (l11 != null) {
            arrayList.add("lastModifiedAt=" + l11);
        }
        Long l12 = this.f8016f;
        if (l12 != null) {
            arrayList.add("lastAccessedAt=" + l12);
        }
        Map map = this.f8017g;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return d7.r.U0(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }
}
