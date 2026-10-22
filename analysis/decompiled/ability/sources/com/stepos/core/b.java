package com.stepos.core;

import S7.k;
import S7.n;
import S7.o;

/* loaded from: classes3.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3824a;
    public final /* synthetic */ n b;
    public final /* synthetic */ o c;
    public final /* synthetic */ o d;
    public final /* synthetic */ n e;

    public /* synthetic */ b(n nVar, o oVar, o oVar2, n nVar2, k kVar, int i) {
        this.f3824a = i;
        this.b = nVar;
        this.c = oVar;
        this.d = oVar2;
        this.e = nVar2;
    }

    @Override // com.stepos.core.d
    public final void onNext(String inferId, com.stepos.core.callback.c cVar) {
        switch (this.f3824a) {
            case 0:
                kotlin.jvm.internal.k.f(inferId, "inferId");
                com.stepos.core.callback.b bVar = (com.stepos.core.callback.b) cVar;
                this.c.invoke(inferId, Integer.valueOf(bVar.f3827a), bVar.b);
                break;
            default:
                kotlin.jvm.internal.k.f(inferId, "inferId");
                com.stepos.core.callback.b bVar2 = (com.stepos.core.callback.b) cVar;
                this.c.invoke(inferId, Integer.valueOf(bVar2.f3827a), bVar2.b);
                break;
        }
    }
}
