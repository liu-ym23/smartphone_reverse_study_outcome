package com.stepos.ailauncher.task.detail.fragment;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.detail.render.ArtifactContentView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$loadFolderChildren$1", f = "ArtifactDetailFragment.kt", l = {532}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment$loadFolderChildren$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ArtifactContentView $content;
    final /* synthetic */ SessionArtifact $folder;
    final /* synthetic */ String $sid;
    int label;
    final /* synthetic */ ArtifactDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailFragment$loadFolderChildren$1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView, SessionArtifact sessionArtifact, String str, InterfaceC4014c<? super ArtifactDetailFragment$loadFolderChildren$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactDetailFragment;
        this.$content = artifactContentView;
        this.$folder = sessionArtifact;
        this.$sid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDetailFragment$loadFolderChildren$1(this.this$0, this.$content, this.$folder, this.$sid, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactDetailFragment$loadFolderChildren$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Y.b();
            ArtifactDetailFragment$loadFolderChildren$1$children$1 artifactDetailFragment$loadFolderChildren$1$children$1 = new ArtifactDetailFragment$loadFolderChildren$1$children$1(this.$folder, this.$sid, null);
            this.label = 1;
            obj = C1056g.j(iB, artifactDetailFragment$loadFolderChildren$1$children$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List<SessionArtifact> list = (List) obj;
        if (!this.this$0.isAdded()) {
            return Y8.t.f7040a;
        }
        if (list.isEmpty()) {
            this.$content.o1(this.$folder);
        } else {
            this.$content.u1(this.$folder, list);
        }
        return Y8.t.f7040a;
    }
}
