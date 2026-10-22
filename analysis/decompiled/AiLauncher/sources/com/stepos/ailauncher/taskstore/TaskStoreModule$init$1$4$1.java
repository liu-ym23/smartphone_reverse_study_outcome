package com.stepos.ailauncher.taskstore;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.TaskStoreModule$init$1$4$1", f = "TaskStoreModule.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskStoreModule$init$1$4$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $to;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskStoreModule$init$1$4$1(String str, String str2, InterfaceC4014c<? super TaskStoreModule$init$1$4$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$from = str;
        this.$to = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskStoreModule$init$1$4$1(this.$from, this.$to, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskStoreModule$init$1$4$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                String str = this.$from;
                String str2 = this.$to;
                this.label = 1;
                obj = aVarN.m(str, str2, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            int iIntValue = ((Number) obj).intValue();
            C4148a.k("TaskStoreModule", "rebind session keys " + this.$from + " → " + this.$to + " rows=" + iIntValue, false, 4, null);
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            C4148a.t("TaskStoreModule", "rebind session keys failed " + this.$from + " → " + this.$to, e11, false, 8, null);
        }
        return t.f7040a;
    }
}
