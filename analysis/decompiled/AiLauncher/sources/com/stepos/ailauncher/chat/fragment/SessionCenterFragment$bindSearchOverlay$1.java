package com.stepos.ailauncher.chat.fragment;

import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.SessionCenterFragment$bindSearchOverlay$1", f = "SessionCenterFragment.kt", l = {231}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionCenterFragment$bindSearchOverlay$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ SessionCenterFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.SessionCenterFragment$bindSearchOverlay$1$1", f = "SessionCenterFragment.kt", l = {232}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$bindSearchOverlay$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ SessionCenterFragment this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$bindSearchOverlay$1$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ SessionCenterFragment this$0;

            public a(SessionCenterFragment sessionCenterFragment) {
                this.this$0 = sessionCenterFragment;
            }

            public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                SessionCenterFragment sessionCenterFragment = this.this$0;
                if (z10) {
                    sessionCenterFragment.R();
                } else {
                    sessionCenterFragment.M();
                }
                return Y8.t.f7040a;
            }

            @Override // Xa.c
            public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                return b(((Boolean) obj).booleanValue(), interfaceC4014c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionCenterFragment sessionCenterFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = sessionCenterFragment;
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
                Xa.t<Boolean> tVarQ = this.this$0.J().q();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (tVarQ.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCenterFragment$bindSearchOverlay$1(SessionCenterFragment sessionCenterFragment, InterfaceC4014c<? super SessionCenterFragment$bindSearchOverlay$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionCenterFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionCenterFragment$bindSearchOverlay$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionCenterFragment$bindSearchOverlay$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
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
