package v4;

import b0.f2;
import i5.u;
import ia.d0;

/* loaded from: classes.dex */
public final /* synthetic */ class h extends q7.i implements p7.o {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f10411n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i2, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(i2, obj, cls, str, str2, i10);
        this.f10411n = i11;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        switch (this.f10411n) {
            case 0:
                u uVar = (u) this.f8801g;
                return d0.B(uVar.f4724d.f5619d, new f2((String) obj, uVar, (String) obj2, null, 5), (g7.d) obj3);
            default:
                u uVar2 = (u) this.f8801g;
                return d0.B(uVar2.f4724d.f5619d, new f2((String) obj, uVar2, (String) obj2, null, 5), (g7.d) obj3);
        }
    }
}
