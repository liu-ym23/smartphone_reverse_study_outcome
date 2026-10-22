package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.adapter.C2507m;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ArtifactsView$bindList$1", f = "ArtifactsView.kt", l = {144, 153}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactsView$bindList$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<SessionArtifact> $artifacts;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ArtifactsView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsView$bindList$1(List<SessionArtifact> list, ArtifactsView artifactsView, InterfaceC4014c<? super ArtifactsView$bindList$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$artifacts = list;
        this.this$0 = artifactsView;
    }

    public static final Y8.t i(ArtifactsView artifactsView, SessionArtifact sessionArtifact) {
        ChatTracker chatTracker = ChatTracker.INSTANCE;
        chatTracker.b(artifactsView.sessionId, sessionArtifact.getTaskId(), chatTracker.f(sessionArtifact.getFileName(), sessionArtifact.getMimeType()));
        M5.c cVar = M5.c.INSTANCE;
        M5.c.b(cVar, sessionArtifact, artifactsView.sessionId, M5.c.SOURCE_ARTIFACT_SHEET, null, cVar.e(sessionArtifact.getFileName(), sessionArtifact.getMimeType()), 8, null);
        InterfaceC5074l<SessionArtifact, Y8.t> onArtifactClick = artifactsView.getOnArtifactClick();
        if (onArtifactClick != null) {
            onArtifactClick.invoke(sessionArtifact);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t n(ArtifactsView artifactsView, Map map, SessionArtifact sessionArtifact, int i10) {
        M5.c cVar = M5.c.INSTANCE;
        String str = artifactsView.sessionId;
        String str2 = (String) map.get(sessionArtifact.getTaskId());
        if (str2 == null) {
            str2 = "completed";
        }
        M5.c.d(cVar, sessionArtifact, str, M5.c.SOURCE_ARTIFACT_SHEET, null, str2, cVar.e(sessionArtifact.getFileName(), sessionArtifact.getMimeType()), String.valueOf(i10), 8, null);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactsView$bindList$1(this.$artifacts, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactsView$bindList$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listG0;
        Map map;
        List list;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            List<SessionArtifact> list2 = this.$artifacts;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                String fileId = ((SessionArtifact) it.next()).getFileId();
                if (fileId == null || La.H.x0(fileId)) {
                    fileId = null;
                }
                if (fileId != null) {
                    arrayList.add(fileId);
                }
            }
            listG0 = Z8.F.g0(arrayList);
            Ua.I iB = Ua.Y.b();
            ArtifactsView$bindList$1$availability$1 artifactsView$bindList$1$availability$1 = new ArtifactsView$bindList$1$availability$1(listG0, null);
            this.L$0 = g9.h.a(listG0);
            this.label = 1;
            obj = C1056g.j(iB, artifactsView$bindList$1$availability$1, this);
            if (obj != objG) {
            }
            return objG;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.L$2;
            map = (Map) this.L$1;
            C4849c.b(obj);
            final Map map2 = (Map) obj;
            RecyclerView recyclerView = this.this$0.rv;
            final ArtifactsView artifactsView = this.this$0;
            InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.P
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ArtifactsView$bindList$1.i(artifactsView, (SessionArtifact) obj2);
                }
            };
            final ArtifactsView artifactsView2 = this.this$0;
            recyclerView.setAdapter(new C2507m(list, map, interfaceC5074l, new p9.p() { // from class: com.stepos.ailauncher.chat.view.Q
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return ArtifactsView$bindList$1.n(artifactsView2, map2, (SessionArtifact) obj2, ((Integer) obj3).intValue());
                }
            }));
            return Y8.t.f7040a;
        }
        listG0 = (List) this.L$0;
        C4849c.b(obj);
        Map map3 = (Map) obj;
        List<SessionArtifact> list3 = this.$artifacts;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list3) {
            if (map3.get(((SessionArtifact) obj2).getFileId()) != ArtifactAvailability.BLOCKED) {
                arrayList2.add(obj2);
            }
        }
        C4148a.k("ArtifactsView", "bindList after block-filter size=" + arrayList2.size(), false, 4, null);
        ChatTracker.INSTANCE.e(this.this$0.sessionId, C4109a.f(arrayList2.size()));
        Ua.I iB2 = Ua.Y.b();
        ArtifactsView$bindList$1$statusByTask$1 artifactsView$bindList$1$statusByTask$1 = new ArtifactsView$bindList$1$statusByTask$1(arrayList2, null);
        this.L$0 = g9.h.a(listG0);
        this.L$1 = map3;
        this.L$2 = arrayList2;
        this.label = 2;
        Object objJ = C1056g.j(iB2, artifactsView$bindList$1$statusByTask$1, this);
        if (objJ != objG) {
            map = map3;
            obj = objJ;
            list = arrayList2;
            final Map map22 = (Map) obj;
            RecyclerView recyclerView2 = this.this$0.rv;
            final ArtifactsView artifactsView3 = this.this$0;
            InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.P
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj22) {
                    return ArtifactsView$bindList$1.i(artifactsView3, (SessionArtifact) obj22);
                }
            };
            final ArtifactsView artifactsView22 = this.this$0;
            recyclerView2.setAdapter(new C2507m(list, map, interfaceC5074l2, new p9.p() { // from class: com.stepos.ailauncher.chat.view.Q
                @Override // p9.p
                public final Object invoke(Object obj22, Object obj3) {
                    return ArtifactsView$bindList$1.n(artifactsView22, map22, (SessionArtifact) obj22, ((Integer) obj3).intValue());
                }
            }));
            return Y8.t.f7040a;
        }
        return objG;
    }
}
