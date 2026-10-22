package w8;

/* loaded from: classes.dex */
public final class j extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10904g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f10905h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f10906i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, String str2, int i2) {
        super(1);
        this.f10904g = i2;
        this.f10905h = str;
        this.f10906i = str2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f10904g) {
            case 0:
                n nVar = (n) obj;
                q7.k.e(nVar, "$this$function");
                e eVar = k.f10908b;
                String str = this.f10905h;
                nVar.a(str, eVar);
                e eVar2 = k.f10907a;
                nVar.a(this.f10906i, eVar, eVar, eVar2, eVar2);
                nVar.b(str, eVar2);
                break;
            case 1:
                n nVar2 = (n) obj;
                q7.k.e(nVar2, "$this$function");
                e eVar3 = k.f10908b;
                String str2 = this.f10905h;
                nVar2.a(str2, eVar3);
                nVar2.a(this.f10906i, eVar3, eVar3, eVar3);
                nVar2.b(str2, eVar3);
                break;
            case 2:
                n nVar3 = (n) obj;
                q7.k.e(nVar3, "$this$function");
                e eVar4 = k.f10908b;
                String str3 = this.f10905h;
                nVar3.a(str3, eVar4);
                e eVar5 = k.f10909c;
                e eVar6 = k.f10907a;
                nVar3.a(this.f10906i, eVar4, eVar4, eVar5, eVar6);
                nVar3.b(str3, eVar6);
                break;
            case 3:
                n nVar4 = (n) obj;
                q7.k.e(nVar4, "$this$function");
                e eVar7 = k.f10908b;
                String str4 = this.f10905h;
                nVar4.a(str4, eVar7);
                e eVar8 = k.f10909c;
                nVar4.a(str4, eVar8);
                e eVar9 = k.f10907a;
                nVar4.a(this.f10906i, eVar7, eVar8, eVar8, eVar9);
                nVar4.b(str4, eVar9);
                break;
            case 4:
                n nVar5 = (n) obj;
                q7.k.e(nVar5, "$this$function");
                e eVar10 = k.f10909c;
                nVar5.a(this.f10905h, eVar10);
                nVar5.b(this.f10906i, k.f10908b, eVar10);
                break;
            default:
                n nVar6 = (n) obj;
                q7.k.e(nVar6, "$this$function");
                nVar6.a(this.f10905h, k.f10907a);
                nVar6.b(this.f10906i, k.f10908b, k.f10909c);
                break;
        }
        return c7.r.f1986a;
    }
}
