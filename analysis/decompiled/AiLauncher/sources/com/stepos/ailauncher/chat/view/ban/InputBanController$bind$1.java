package com.stepos.ailauncher.chat.view.ban;

import Ua.M;
import Xa.d;
import Y8.t;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import com.stepos.ailauncher.contract.model.AccountStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1", f = "InputBanController.kt", l = {157, 329}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InputBanController$bind$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InputBanController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$1", f = "InputBanController.kt", l = {328}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ IAccountStatusService $service;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus;", "status", "LY8/t;", "<anonymous>", "(Lcom/stepos/ailauncher/contract/model/AccountStatus;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$1$1", f = "InputBanController.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02991 extends SuspendLambda implements p<AccountStatus, InterfaceC4014c<? super t>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public C02991(InterfaceC4014c<? super C02991> interfaceC4014c) {
                super(2, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                C02991 c02991 = new C02991(interfaceC4014c);
                c02991.L$0 = obj;
                return c02991;
            }

            @Override // p9.p
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AccountStatus accountStatus, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C02991) create(accountStatus, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                AccountStatus accountStatus = (AccountStatus) this.L$0;
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                if (accountStatus instanceof AccountStatus.Available) {
                    InputBanController.Companion.c();
                }
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IAccountStatusService iAccountStatusService, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$service = iAccountStatusService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$service, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.t<AccountStatus> status = this.$service.getStatus();
                C02991 c02991 = new C02991(null);
                kotlin.jvm.internal.p.g(status, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
                this.L$0 = h.a(status);
                this.L$1 = h.a(c02991);
                this.I$0 = 0;
                this.label = 1;
                if (d.j(status, c02991, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new IllegalStateException("SharedFlow never completes, this call should never return.");
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "it", "LY8/t;", "<anonymous>", "(Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$2", f = "InputBanController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<AccountStatus.Banned, InterfaceC4014c<? super t>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InputBanController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InputBanController inputBanController, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = inputBanController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AccountStatus.Banned banned, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(banned, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AccountStatus.Banned banned = (AccountStatus.Banned) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.q(banned);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBanController$bind$1(InputBanController inputBanController, InterfaceC4014c<? super InputBanController$bind$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = inputBanController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        InputBanController$bind$1 inputBanController$bind$1 = new InputBanController$bind$1(this.this$0, interfaceC4014c);
        inputBanController$bind$1.L$0 = obj;
        return inputBanController$bind$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InputBanController$bind$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f4, code lost:
    
        if (Xa.d.j(r2, r3, r11) == r7) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ban.InputBanController$bind$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
