package com.stepos.ailauncher.task.search;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$install$2", f = "TaskStoreSearchProjectionBridge.kt", l = {109}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskStoreSearchProjectionBridge$install$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "uid", "LY8/t;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$install$2$1", f = "TaskStoreSearchProjectionBridge.kt", l = {61}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$install$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<String, InterfaceC4014c<? super t>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str = (String) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                TaskStoreSearchProjectionBridge.lastReplacedUid = null;
                if (str.length() > 0) {
                    TaskStoreSearchProjectionBridge taskStoreSearchProjectionBridge = TaskStoreSearchProjectionBridge.INSTANCE;
                    this.L$0 = h.a(str);
                    this.label = 1;
                    if (taskStoreSearchProjectionBridge.b(this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }

        @Override // p9.p
        public final Object invoke(String str, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(str, interfaceC4014c)).invokeSuspend(t.f7040a);
        }
    }

    public TaskStoreSearchProjectionBridge$install$2(InterfaceC4014c<? super TaskStoreSearchProjectionBridge$install$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskStoreSearchProjectionBridge$install$2(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskStoreSearchProjectionBridge$install$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<String> tVarM = TaskStoreModule.INSTANCE.m();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            kotlin.jvm.internal.p.g(tVarM, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
            this.L$0 = h.a(tVarM);
            this.L$1 = h.a(anonymousClass1);
            this.I$0 = 0;
            this.label = 1;
            if (Xa.d.j(tVarM, anonymousClass1, this) == objG) {
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
