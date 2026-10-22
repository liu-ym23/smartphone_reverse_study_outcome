package xd;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends n<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f13817a;

    public m(n nVar) {
        this.f13817a = nVar;
    }

    @Override // xd.n
    public final void a(p pVar, Object obj) {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f13817a.a(pVar, Array.get(obj, i10));
        }
    }
}
