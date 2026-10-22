package com.stepos.ailauncher.chat.view;

import Z8.C1174w;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.foundation.task.TaskModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ArtifactsView$bindList$1$statusByTask$1", f = "ArtifactsView.kt", l = {154}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactsView$bindList$1$statusByTask$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ List<SessionArtifact> $visible;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsView$bindList$1$statusByTask$1(List<SessionArtifact> list, InterfaceC4014c<? super ArtifactsView$bindList$1$statusByTask$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$visible = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactsView$bindList$1$statusByTask$1(this.$visible, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
        return ((ArtifactsView$bindList$1$statusByTask$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskModule taskModule = TaskModule.INSTANCE;
        List<SessionArtifact> list = this.$visible;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SessionArtifact) it.next()).getTaskId());
        }
        this.label = 1;
        Object objJ = taskModule.j(arrayList, this);
        return objJ == objG ? objG : objJ;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Map<String, ? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Map<String, String>>) interfaceC4014c);
    }
}
