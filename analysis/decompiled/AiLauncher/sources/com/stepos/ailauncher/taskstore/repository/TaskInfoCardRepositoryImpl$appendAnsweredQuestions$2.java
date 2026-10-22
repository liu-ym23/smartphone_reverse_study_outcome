package com.stepos.ailauncher.taskstore.repository;

import La.H;
import Ua.M;
import Y8.t;
import Z8.F;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.ailauncher.taskstore.database.TaskInfoConverters;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2", f = "TaskInfoCardRepositoryImpl.kt", l = {180, 184}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ Collection<String> $questionTexts;
    final /* synthetic */ String $taskId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2(Collection<String> collection, TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, String str, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$questionTexts = collection;
        this.this$0 = taskInfoCardRepositoryImpl;
        this.$taskId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2(this.$questionTexts, this.this$0, this.$taskId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List arrayList;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Collection<String> collection = this.$questionTexts;
            arrayList = new ArrayList();
            for (Object obj2 : collection) {
                if (!H.x0((String) obj2)) {
                    arrayList.add(obj2);
                }
            }
            if (arrayList.isEmpty()) {
                return C4109a.f(0);
            }
            TaskInfoCardDao taskInfoCardDao = this.this$0.dao;
            String str = this.$taskId;
            this.L$0 = arrayList;
            this.label = 1;
            obj = taskInfoCardDao.l(str, this);
            if (obj != objG) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        arrayList = (List) this.L$0;
        C4849c.b(obj);
        TaskInfoCardEntity taskInfoCardEntity = (TaskInfoCardEntity) obj;
        if (taskInfoCardEntity == null) {
            return C4109a.f(0);
        }
        TaskInfoConverters taskInfoConverters = TaskInfoConverters.INSTANCE;
        LinkedHashSet linkedHashSet = new LinkedHashSet(taskInfoConverters.h(taskInfoCardEntity.getAnsweredQuestionTextsJson()));
        linkedHashSet.addAll(arrayList);
        List<String> listM1 = F.m1(linkedHashSet);
        TaskInfoCardDao taskInfoCardDao2 = this.this$0.dao;
        String str2 = this.$taskId;
        String strQ = taskInfoConverters.q(listM1);
        this.L$0 = h.a(arrayList);
        this.L$1 = h.a(taskInfoCardEntity);
        this.L$2 = h.a(listM1);
        this.label = 2;
        Object objJ = taskInfoCardDao2.j(str2, strQ, this);
        return objJ == objG ? objG : objJ;
    }
}
