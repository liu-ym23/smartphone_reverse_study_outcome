package i;

import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f3076e = new HashMap();

    @Override // i.f
    public final c f(Object obj) {
        return (c) this.f3076e.get(obj);
    }

    @Override // i.f
    public final Object g(Object obj) {
        Object objG = super.g(obj);
        this.f3076e.remove(obj);
        return objG;
    }
}
