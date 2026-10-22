package T8;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* loaded from: classes4.dex */
public final class r implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1231a;
    public final v b;
    public final ProtoBuf$Property c;
    public final V8.r d;

    public /* synthetic */ r(v vVar, ProtoBuf$Property protoBuf$Property, V8.r rVar, int i) {
        this.f1231a = i;
        this.b = vVar;
        this.c = protoBuf$Property;
        this.d = rVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1231a) {
            case 0:
                v vVar = this.b;
                W8.i iVar = vVar.f1235a.f1228a.f1222a;
                r rVar = new r(vVar, this.c, this.d, 2);
                iVar.getClass();
                return new kotlin.reflect.jvm.internal.impl.storage.a(iVar, rVar);
            case 1:
                v vVar2 = this.b;
                W8.i iVar2 = vVar2.f1235a.f1228a.f1222a;
                r rVar2 = new r(vVar2, this.c, this.d, 3);
                iVar2.getClass();
                return new kotlin.reflect.jvm.internal.impl.storage.a(iVar2, rVar2);
            case 2:
                v vVar3 = this.b;
                m mVar = vVar3.f1235a;
                J5.b bVarA = vVar3.a(mVar.c);
                kotlin.jvm.internal.k.c(bVarA);
                InterfaceC0249a interfaceC0249a = mVar.f1228a.e;
                X8.w returnType = this.d.getReturnType();
                kotlin.jvm.internal.k.e(returnType, "getReturnType(...)");
                return (L8.g) interfaceC0249a.n0(bVarA, this.c, returnType);
            default:
                v vVar4 = this.b;
                m mVar2 = vVar4.f1235a;
                J5.b bVarA2 = vVar4.a(mVar2.c);
                kotlin.jvm.internal.k.c(bVarA2);
                InterfaceC0249a interfaceC0249a2 = mVar2.f1228a.e;
                X8.w returnType2 = this.d.getReturnType();
                kotlin.jvm.internal.k.e(returnType2, "getReturnType(...)");
                return (L8.g) interfaceC0249a2.W(bVarA2, this.c, returnType2);
        }
    }
}
