package com.stepos.agentframework.chatcore.safehint;

import La.H;
import Ua.M;
import Y8.t;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import yc.v;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.safehint.SafeHintClient$isRisky$2", f = "SafeHintClient.kt", l = {32}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SafeHintClient$isRisky$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $modelOutput;
    final /* synthetic */ String $userInput;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeHintClient$isRisky$2(String str, String str2, InterfaceC4014c<? super SafeHintClient$isRisky$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$modelOutput = str;
        this.$userInput = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SafeHintClient$isRisky$2(this.$modelOutput, this.$userInput, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SafeHintClient$isRisky$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        v vVar;
        SafeHintResponse safeHintResponse;
        Object objG = C4063a.g();
        int i10 = this.label;
        boolean z10 = false;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                a aVar = a.INSTANCE;
                if (aVar.a() && !H.x0(this.$modelOutput)) {
                    aVar.c();
                    SafeHintRequest safeHintRequest = new SafeHintRequest(this.$userInput, this.$modelOutput);
                    d dVar = (d) HttpManager.INSTANCE.create(d.class, "__default__");
                    this.L$0 = h.a(safeHintRequest);
                    this.L$1 = h.a(dVar);
                    this.label = 1;
                    obj = dVar.a(safeHintRequest, this);
                    if (obj == objG) {
                        return objG;
                    }
                }
                return C4109a.a(false);
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            vVar = (v) obj;
            safeHintResponse = (SafeHintResponse) vVar.a();
        } catch (Exception e10) {
            C4148a.g(SafeHintClient.TAG, "safety hint exception: " + e10.getMessage(), e10, false, 8, null);
        }
        if (!vVar.f() || safeHintResponse == null) {
            C4148a.u(SafeHintClient.TAG, "safety hint http failed code=" + vVar.b(), false, 4, null);
            return C4109a.a(false);
        }
        boolean zD = kotlin.jvm.internal.p.d(safeHintResponse.getIs_risky(), C4109a.a(true));
        C4148a.k(SafeHintClient.TAG, "safety hint result is_risky=" + zD, false, 4, null);
        z10 = zD;
        return C4109a.a(z10);
    }
}
