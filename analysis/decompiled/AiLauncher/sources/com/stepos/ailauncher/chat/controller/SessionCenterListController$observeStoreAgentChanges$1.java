package com.stepos.ailauncher.chat.controller;

import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$observeStoreAgentChanges$1", f = "SessionCenterListController.kt", l = {582}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionCenterListController$observeStoreAgentChanges$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Xa.t<StoreInstallActivity> $installActivity;
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ SessionCenterListController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$observeStoreAgentChanges$1$1", f = "SessionCenterListController.kt", l = {MinusOneTransitionSpec.MESH_MASK_TOTAL_DURATION_MS}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.controller.SessionCenterListController$observeStoreAgentChanges$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Xa.t<StoreInstallActivity> $installActivity;
        int label;
        final /* synthetic */ SessionCenterListController this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.controller.SessionCenterListController$observeStoreAgentChanges$1$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ SessionCenterListController this$0;

            public a(SessionCenterListController sessionCenterListController) {
                this.this$0 = sessionCenterListController;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(StoreInstallActivity storeInstallActivity, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (storeInstallActivity.getAgentListRevision() == this.this$0.seenAgentListRevision) {
                    return Y8.t.f7040a;
                }
                this.this$0.seenAgentListRevision = storeInstallActivity.getAgentListRevision();
                C4148a.k(SessionCenterListController.TAG, "Store agent list changed, reload sidebar agents", false, 4, null);
                this.this$0.h0();
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Xa.t<StoreInstallActivity> tVar, SessionCenterListController sessionCenterListController, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$installActivity = tVar;
            this.this$0 = sessionCenterListController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$installActivity, this.this$0, interfaceC4014c);
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
                Xa.t<StoreInstallActivity> tVar = this.$installActivity;
                a aVar = new a(this.this$0);
                this.label = 1;
                if (tVar.collect(aVar, this) == objG) {
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
    public SessionCenterListController$observeStoreAgentChanges$1(LifecycleOwner lifecycleOwner, Xa.t<StoreInstallActivity> tVar, SessionCenterListController sessionCenterListController, InterfaceC4014c<? super SessionCenterListController$observeStoreAgentChanges$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$owner = lifecycleOwner;
        this.$installActivity = tVar;
        this.this$0 = sessionCenterListController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionCenterListController$observeStoreAgentChanges$1(this.$owner, this.$installActivity, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionCenterListController$observeStoreAgentChanges$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            LifecycleOwner lifecycleOwner = this.$owner;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$installActivity, this.this$0, null);
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
