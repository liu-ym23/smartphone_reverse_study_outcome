package com.stepos.ailauncher.task.detail.fragment;

import Ua.M;
import Z8.C1172u;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.task.common.ArtifactAvailabilityStore;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$renderArtifact$1$cached$1", f = "ArtifactDetailFragment.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment$renderArtifact$1$cached$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super ArtifactAvailability>, Object> {
    final /* synthetic */ String $fileId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailFragment$renderArtifact$1$cached$1(String str, InterfaceC4014c<? super ArtifactDetailFragment$renderArtifact$1$cached$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDetailFragment$renderArtifact$1$cached$1(this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super ArtifactAvailability> interfaceC4014c) {
        return ((ArtifactDetailFragment$renderArtifact$1$cached$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return ArtifactAvailabilityStore.INSTANCE.v(C1172u.e(this.$fileId)).get(this.$fileId);
    }
}
