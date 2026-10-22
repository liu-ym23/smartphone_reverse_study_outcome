package w9;

import q7.w;
import v9.v;

/* loaded from: classes.dex */
public final /* synthetic */ class t extends q7.h implements p7.n {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f10958n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(int i2, int i10, Object obj) {
        super(i2, obj);
        this.f10958n = i10;
    }

    @Override // q7.c
    public final String A() {
        switch (this.f10958n) {
            case 0:
                return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            default:
                return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }
    }

    @Override // q7.c, w7.c
    public final String getName() {
        switch (this.f10958n) {
            case 0:
                return "isStrictSupertype";
            default:
                return "equalTypes";
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f10958n) {
            case 0:
                v vVar = (v) obj;
                v vVar2 = (v) obj2;
                q7.k.e(vVar, "p0");
                q7.k.e(vVar2, "p1");
                ((u) this.f8801g).getClass();
                l.f10948b.getClass();
                m mVar = k.f10947b;
                return Boolean.valueOf(mVar.b(vVar, vVar2) && !mVar.b(vVar2, vVar));
            default:
                v vVar3 = (v) obj;
                v vVar4 = (v) obj2;
                q7.k.e(vVar3, "p0");
                q7.k.e(vVar4, "p1");
                return Boolean.valueOf(((m) this.f8801g).a(vVar3, vVar4));
        }
    }

    @Override // q7.c
    public final w7.f y() {
        switch (this.f10958n) {
            case 0:
                return w.f8821a.b(u.class);
            default:
                return w.f8821a.b(m.class);
        }
    }
}
