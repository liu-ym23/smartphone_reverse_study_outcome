package W9;

import p9.InterfaceC5074l;

/* renamed from: W9.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1092a implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final C1093b f6719a;

    public C1092a(C1093b c1093b) {
        this.f6719a = c1093b;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return Boolean.valueOf(C1093b.h(this.f6719a, (Z9.r) obj));
    }
}
