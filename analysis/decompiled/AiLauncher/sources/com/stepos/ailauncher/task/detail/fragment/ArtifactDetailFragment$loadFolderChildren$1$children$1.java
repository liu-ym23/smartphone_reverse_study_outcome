package com.stepos.ailauncher.task.detail.fragment;

import Ua.M;
import Z8.C1172u;
import Z8.C1173v;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import com.stepos.ailauncher.foundation.task.TaskModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$loadFolderChildren$1$children$1", f = "ArtifactDetailFragment.kt", l = {533}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment$loadFolderChildren$1$children$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super List<? extends SessionArtifact>>, Object> {
    final /* synthetic */ SessionArtifact $folder;
    final /* synthetic */ String $sid;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailFragment$loadFolderChildren$1$children$1(SessionArtifact sessionArtifact, String str, InterfaceC4014c<? super ArtifactDetailFragment$loadFolderChildren$1$children$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$folder = sessionArtifact;
        this.$sid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ArtifactDetailFragment$loadFolderChildren$1$children$1 artifactDetailFragment$loadFolderChildren$1$children$1 = new ArtifactDetailFragment$loadFolderChildren$1$children$1(this.$folder, this.$sid, interfaceC4014c);
        artifactDetailFragment$loadFolderChildren$1$children$1.L$0 = obj;
        return artifactDetailFragment$loadFolderChildren$1$children$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<SessionArtifact>> interfaceC4014c) {
        return ((ArtifactDetailFragment$loadFolderChildren$1$children$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                String str = this.$sid;
                Result.Companion companion = Result.INSTANCE;
                TaskModule taskModule = TaskModule.INSTANCE;
                List<String> listE = C1172u.e(str);
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = taskModule.e(listE, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("ArtifactDetailFragment", "folder children query failed", thE, false, 8, null);
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        List<SessionArtifact> listLatestProducts = SessionArtifactKt.latestProducts((List) objB);
        String cloudPath = this.$folder.getCloudPath();
        if (cloudPath == null) {
            cloudPath = this.$folder.getFileName();
        }
        if (cloudPath == null) {
            cloudPath = "";
        }
        String strG1 = La.H.G1(cloudPath, JsonPointer.SEPARATOR, '\\');
        if (strG1.length() == 0) {
            return C1173v.m();
        }
        SessionArtifact sessionArtifact = this.$folder;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listLatestProducts) {
            SessionArtifact sessionArtifact2 = (SessionArtifact) obj2;
            if (!kotlin.jvm.internal.p.d(sessionArtifact2.getFileId(), sessionArtifact.getFileId())) {
                String cloudPath2 = sessionArtifact2.getCloudPath();
                if (cloudPath2 == null) {
                    cloudPath2 = sessionArtifact2.getFileName();
                }
                if (cloudPath2 == null) {
                    cloudPath2 = "";
                }
                if (!La.D.X(cloudPath2, strG1 + "/", false, 2, null)) {
                    if (La.D.X(cloudPath2, strG1 + "\\", false, 2, null)) {
                    }
                }
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends SessionArtifact>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<SessionArtifact>>) interfaceC4014c);
    }
}
