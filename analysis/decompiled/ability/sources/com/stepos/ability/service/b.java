package com.stepos.ability.service;

import H7.g;
import H7.h;
import P3.c;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import m9.C1732y;
import m9.InterfaceC1731x;

/* loaded from: classes3.dex */
public final class b extends H7.a implements InterfaceC1731x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3268a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(g gVar, int i) {
        super(gVar);
        this.f3268a = i;
    }

    @Override // m9.InterfaceC1731x
    public final void handleException(h hVar, Throwable th) {
        switch (this.f3268a) {
            case 0:
                c.f1086a.invoke(6, "Ability_".concat("AgentService"), "serviceScope", th);
                break;
            default:
                PolicySdkLogUtils.INSTANCE.d("exceptionHandler", hVar.get(C1732y.b) + " 处理异常 ：" + th);
                break;
        }
    }
}
