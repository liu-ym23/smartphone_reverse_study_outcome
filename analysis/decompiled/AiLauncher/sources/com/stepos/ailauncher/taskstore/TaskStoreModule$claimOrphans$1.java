package com.stepos.ailauncher.taskstore;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.TaskStoreModule$claimOrphans$1", f = "TaskStoreModule.kt", l = {255}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskStoreModule$claimOrphans$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $uid;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskStoreModule$claimOrphans$1(String str, InterfaceC4014c<? super TaskStoreModule$claimOrphans$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$uid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskStoreModule$claimOrphans$1 taskStoreModule$claimOrphans$1 = new TaskStoreModule$claimOrphans$1(this.$uid, interfaceC4014c);
        taskStoreModule$claimOrphans$1.L$0 = obj;
        return taskStoreModule$claimOrphans$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskStoreModule$claimOrphans$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        String str;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                String str2 = this.$uid;
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                this.L$0 = g9.h.a(m10);
                this.L$1 = str2;
                this.L$2 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                Object objC = aVarN.c(str2, this);
                if (objC == objG) {
                    return objG;
                }
                str = str2;
                obj = objC;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$1;
                C4849c.b(obj);
            }
            objB = Result.b(C4109a.f(C4148a.k("TaskStoreModule", "claimOrphans uid='" + str + "' affected=" + ((Number) obj).intValue(), false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str3 = this.$uid;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("TaskStoreModule", "claimOrphans failed uid='" + str3 + "'", thE, false, 8, null);
        }
        return t.f7040a;
    }
}
