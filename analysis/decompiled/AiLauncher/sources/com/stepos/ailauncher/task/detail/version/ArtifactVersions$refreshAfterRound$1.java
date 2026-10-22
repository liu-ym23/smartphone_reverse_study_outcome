package com.stepos.ailauncher.task.detail.version;

import Ua.M;
import Y8.t;
import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.version.ArtifactVersions$refreshAfterRound$1", f = "ArtifactVersions.kt", l = {69}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactVersions$refreshAfterRound$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $fileId;
    int label;
    final /* synthetic */ ArtifactVersions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactVersions$refreshAfterRound$1(ArtifactVersions artifactVersions, String str, InterfaceC4014c<? super ArtifactVersions$refreshAfterRound$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactVersions;
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactVersions$refreshAfterRound$1(this.this$0, this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactVersions$refreshAfterRound$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ArtifactVersions artifactVersions = this.this$0;
            String str = this.$fileId;
            this.label = 1;
            obj = artifactVersions.k(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List list = (List) obj;
        if (list != null && list.size() > this.this$0.i().size()) {
            C4148a.k("ArtifactVersions", "refreshAfterRound → versions=" + this.this$0.i().size() + "→" + list.size() + ", show latest", false, 4, null);
            this.this$0.versions = list;
            this.this$0.r(C1173v.o(list));
            return t.f7040a;
        }
        return t.f7040a;
    }
}
