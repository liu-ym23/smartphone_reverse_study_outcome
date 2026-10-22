package s6;

import c7.p;
import k4.v;
import n6.o;
import n6.w;
import x5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends w {

    /* renamed from: b, reason: collision with root package name */
    public final String f5253b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5254c;
    public final p d;

    public i(String str, long j4, p pVar) {
        this.f5253b = str;
        this.f5254c = j4;
        this.d = pVar;
    }

    @Override // n6.w
    public final long a() {
        return this.f5254c;
    }

    @Override // n6.w
    public final o b() {
        String str = this.f5253b;
        if (str != null) {
            l lVar = o.f4070b;
            try {
                return v.z(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // n6.w
    public final c7.h e() {
        return this.d;
    }
}
