package com.stepos.ailauncher.chat.view.ban;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$refreshBanStatusAsync$1", f = "InputBanController.kt", l = {216}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InputBanController$refreshBanStatusAsync$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ IAccountStatusService $service;
    final /* synthetic */ String $uid;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBanController$refreshBanStatusAsync$1(IAccountStatusService iAccountStatusService, String str, InterfaceC4014c<? super InputBanController$refreshBanStatusAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$service = iAccountStatusService;
        this.$uid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        InputBanController$refreshBanStatusAsync$1 inputBanController$refreshBanStatusAsync$1 = new InputBanController$refreshBanStatusAsync$1(this.$service, this.$uid, interfaceC4014c);
        inputBanController$refreshBanStatusAsync$1.L$0 = obj;
        return inputBanController$refreshBanStatusAsync$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InputBanController$refreshBanStatusAsync$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                IAccountStatusService iAccountStatusService = this.$service;
                String str = this.$uid;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = h.a(m10);
                this.L$1 = h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                if (iAccountStatusService.notifyAccountSignal(str, "post_send", "send", this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("BanGate", "background ban sync failed", thE, false, 8, null);
        }
        return t.f7040a;
    }
}
