package com.stepos.agentframework.adapter.coze;

import S7.o;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3452a;
    public final /* synthetic */ o b;

    public /* synthetic */ a(o oVar, int i) {
        this.f3452a = i;
        this.b = oVar;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f3452a;
        long jLongValue = ((Long) obj).longValue();
        long jLongValue2 = ((Long) obj2).longValue();
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        switch (i) {
            case 0:
                return CozeClient.uploadFile$lambda$0(this.b, jLongValue, jLongValue2, zBooleanValue);
            default:
                return CozeClient.uploadFile$lambda$1(this.b, jLongValue, jLongValue2, zBooleanValue);
        }
    }
}
