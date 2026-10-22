package aa;

import aa.m0;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class K implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final String f8092a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8093b;

    public K(String str, String str2) {
        this.f8092a = str;
        this.f8093b = str2;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return e0.N(this.f8092a, this.f8093b, (m0.a.C0125a) obj);
    }
}
