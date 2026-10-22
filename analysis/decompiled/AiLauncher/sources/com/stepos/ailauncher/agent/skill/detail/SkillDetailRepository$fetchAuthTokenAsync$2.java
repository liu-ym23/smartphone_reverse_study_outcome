package com.stepos.ailauncher.agent.skill.detail;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailRepository$fetchAuthTokenAsync$2", f = "SkillDetailRepository.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailRepository$fetchAuthTokenAsync$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public SkillDetailRepository$fetchAuthTokenAsync$2(InterfaceC4014c<? super SkillDetailRepository$fetchAuthTokenAsync$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SkillDetailRepository$fetchAuthTokenAsync$2 skillDetailRepository$fetchAuthTokenAsync$2 = new SkillDetailRepository$fetchAuthTokenAsync$2(interfaceC4014c);
        skillDetailRepository$fetchAuthTokenAsync$2.L$0 = obj;
        return skillDetailRepository$fetchAuthTokenAsync$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((SkillDetailRepository$fetchAuthTokenAsync$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        if (!fVar.v()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.o(fVar, false, null, 3, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("SkillDetailRepo", "getAuthTokenSync failed", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }
}
