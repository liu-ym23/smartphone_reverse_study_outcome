package com.stepos.ailauncher.taskstore.repository;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/taskstore/repository/b;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/taskstore/repository/b;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$saveOrUpdate$2", f = "TaskInfoCardRepositoryImpl.kt", l = {58, 60, 65, 69}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$saveOrUpdate$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super TaskInfoCardSaveResult>, Object> {
    final /* synthetic */ TaskInfoCard $card;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$saveOrUpdate$2(TaskInfoCard taskInfoCard, TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$saveOrUpdate$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$card = taskInfoCard;
        this.this$0 = taskInfoCardRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$saveOrUpdate$2(this.$card, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TaskInfoCardSaveResult> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$saveOrUpdate$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0174  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r52) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$saveOrUpdate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
