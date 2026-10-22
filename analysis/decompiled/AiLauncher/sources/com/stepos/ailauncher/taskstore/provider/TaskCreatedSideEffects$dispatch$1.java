package com.stepos.ailauncher.taskstore.provider;

import Ua.M;
import Y8.t;
import android.os.Bundle;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.provider.TaskCreatedSideEffects$dispatch$1", f = "TaskCreatedSideEffects.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskCreatedSideEffects$dispatch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Bundle $snapshot;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $type;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskCreatedSideEffects$dispatch$1(String str, String str2, Bundle bundle, InterfaceC4014c<? super TaskCreatedSideEffects$dispatch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$type = str2;
        this.$snapshot = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskCreatedSideEffects$dispatch$1 taskCreatedSideEffects$dispatch$1 = new TaskCreatedSideEffects$dispatch$1(this.$taskId, this.$type, this.$snapshot, interfaceC4014c);
        taskCreatedSideEffects$dispatch$1.L$0 = obj;
        return taskCreatedSideEffects$dispatch$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskCreatedSideEffects$dispatch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Iterator it = TaskCreatedSideEffects.handlers.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            b bVar = (b) it.next();
            String str = this.$taskId;
            String str2 = this.$type;
            Bundle bundle = this.$snapshot;
            try {
                Result.Companion companion = Result.INSTANCE;
                bVar.a(str, str2, bundle);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        return t.f7040a;
    }
}
