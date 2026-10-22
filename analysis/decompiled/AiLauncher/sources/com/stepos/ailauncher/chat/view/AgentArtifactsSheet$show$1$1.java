package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.adapter.C2507m;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.AgentArtifactsSheet$show$1$1", f = "AgentArtifactsSheet.kt", l = {109}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentArtifactsSheet$show$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<SessionArtifact> $artifacts;
    final /* synthetic */ InterfaceC5074l<SessionArtifact, Y8.t> $clickHandler;
    final /* synthetic */ List<String> $fileIds;
    final /* synthetic */ p9.p<SessionArtifact, Integer, Y8.t> $onArtifactExpose;
    final /* synthetic */ RecyclerView $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentArtifactsSheet$show$1$1(RecyclerView recyclerView, List<SessionArtifact> list, InterfaceC5074l<? super SessionArtifact, Y8.t> interfaceC5074l, p9.p<? super SessionArtifact, ? super Integer, Y8.t> pVar, List<String> list2, InterfaceC4014c<? super AgentArtifactsSheet$show$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_apply = recyclerView;
        this.$artifacts = list;
        this.$clickHandler = interfaceC5074l;
        this.$onArtifactExpose = pVar;
        this.$fileIds = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentArtifactsSheet$show$1$1(this.$this_apply, this.$artifacts, this.$clickHandler, this.$onArtifactExpose, this.$fileIds, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentArtifactsSheet$show$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            AgentArtifactsSheet$show$1$1$availability$1 agentArtifactsSheet$show$1$1$availability$1 = new AgentArtifactsSheet$show$1$1$availability$1(this.$fileIds, null);
            this.label = 1;
            obj = C1056g.j(iB, agentArtifactsSheet$show$1$1$availability$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Map map = (Map) obj;
        RecyclerView recyclerView = this.$this_apply;
        List<SessionArtifact> list = this.$artifacts;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (map.get(((SessionArtifact) obj2).getFileId()) != ArtifactAvailability.BLOCKED) {
                arrayList.add(obj2);
            }
        }
        recyclerView.setAdapter(new C2507m(arrayList, map, this.$clickHandler, this.$onArtifactExpose));
        return Y8.t.f7040a;
    }
}
