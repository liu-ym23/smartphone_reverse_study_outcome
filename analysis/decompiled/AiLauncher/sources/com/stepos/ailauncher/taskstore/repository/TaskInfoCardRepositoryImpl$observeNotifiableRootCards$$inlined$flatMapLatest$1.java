package com.stepos.ailauncher.taskstore.repository;

import Xa.c;
import Xa.d;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "it", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1", f = "TaskInfoCardRepositoryImpl.kt", l = {189}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1 extends SuspendLambda implements q<c<? super List<? extends TaskInfoCardEntity>>, String, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1(InterfaceC4014c interfaceC4014c, TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl) {
        super(3, interfaceC4014c);
        this.this$0 = taskInfoCardRepositoryImpl;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(c<? super List<? extends TaskInfoCardEntity>> cVar, String str, InterfaceC4014c<? super t> interfaceC4014c) {
        TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1 taskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1 = new TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1(interfaceC4014c, this.this$0);
        taskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1.L$0 = cVar;
        taskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1.L$1 = str;
        return taskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c cVar = (c) this.L$0;
        Object obj2 = this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b<List<TaskInfoCardEntity>> bVarG = this.this$0.dao.g((String) obj2, TaskInfoCardRepositoryImpl.TERMINAL_STATUS_NAMES, TaskInfoCardRepositoryImpl.TERMINAL_STATUS_NAMES, 200);
            this.L$0 = h.a(cVar);
            this.L$1 = h.a(obj2);
            this.label = 1;
            if (d.v(cVar, bVarG, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
