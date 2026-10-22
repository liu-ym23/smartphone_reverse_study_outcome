package com.stepos.ailauncher.chat.controller;

import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1", f = "SessionCenterListController.kt", l = {875}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionCenterListController$observeDisplayedConversation$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ SessionCenterListController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1$1", f = "SessionCenterListController.kt", l = {881}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ SessionCenterListController this$0;

        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "", "body", "", "keys"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1$1$1", f = "SessionCenterListController.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02791 extends SuspendLambda implements p9.q<Boolean, Set<? extends String>, InterfaceC4014c<? super Set<? extends String>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ boolean Z$0;
            int label;

            public C02791(InterfaceC4014c<? super C02791> interfaceC4014c) {
                super(3, interfaceC4014c);
            }

            public final Object f(boolean z10, Set<String> set, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
                C02791 c02791 = new C02791(interfaceC4014c);
                c02791.Z$0 = z10;
                c02791.L$0 = set;
                return c02791.invokeSuspend(Y8.t.f7040a);
            }

            @Override // p9.q
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Set<? extends String> set, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
                return f(bool.booleanValue(), set, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z10 = this.Z$0;
                Set set = (Set) this.L$0;
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return z10 ? set : Z8.Y.e();
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.controller.SessionCenterListController$observeDisplayedConversation$1$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ SessionCenterListController this$0;

            public a(SessionCenterListController sessionCenterListController) {
                this.this$0 = sessionCenterListController;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(Set<String> set, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                this.this$0.q0(set);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionCenterListController sessionCenterListController, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = sessionCenterListController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
                Xa.b bVarQ = Xa.d.q(Xa.d.n(vVar.e(), vVar.g(), new C02791(null)));
                a aVar = new a(this.this$0);
                this.label = 1;
                if (bVarQ.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCenterListController$observeDisplayedConversation$1(LifecycleOwner lifecycleOwner, SessionCenterListController sessionCenterListController, InterfaceC4014c<? super SessionCenterListController$observeDisplayedConversation$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$owner = lifecycleOwner;
        this.this$0 = sessionCenterListController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionCenterListController$observeDisplayedConversation$1(this.$owner, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionCenterListController$observeDisplayedConversation$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            LifecycleOwner lifecycleOwner = this.$owner;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(lifecycleOwner, state, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
