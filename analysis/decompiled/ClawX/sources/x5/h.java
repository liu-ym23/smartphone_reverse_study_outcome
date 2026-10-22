package x5;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends c5.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f6295a;

    public h(j jVar) {
        this.f6295a = jVar;
    }

    @Override // c5.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // c5.b
    public final int f() {
        return this.f6295a.f6297a.groupCount() + 1;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        String strGroup = this.f6295a.f6297a.group(i8);
        return strGroup == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : strGroup;
    }

    @Override // c5.f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // c5.f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
