package com.stepos.datacenter.ame;

import Y8.t;
import android.util.Log;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import com.stepos.datacenter.ame.AmeVectorStorageProvider;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineSession;", "session", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "LY8/t;", "<anonymous>", "(Lcom/stepos/ame/sdk/AMEngineSession;)Lcom/stepos/datacenter/core/result/DataCenterResult;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$flushCollections$2$1", f = "AmeVectorStorageProvider.kt", l = {894}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$flushCollections$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super DataCenterResult<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29700a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29701b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29702c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$flushCollections$2$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$flushCollections$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29702c = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$flushCollections$2$1 ameVectorStorageProvider$flushCollections$2$1 = new AmeVectorStorageProvider$flushCollections$2$1(this.f29702c, interfaceC4014c);
        ameVectorStorageProvider$flushCollections$2$1.f29701b = obj;
        return ameVectorStorageProvider$flushCollections$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c) {
        return ((AmeVectorStorageProvider$flushCollections$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29700a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29701b;
            this.f29700a = 1;
            obj = aMEngineSession.flushAllCollections(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AMEngineResult aMEngineResult = (AMEngineResult) obj;
        if (aMEngineResult instanceof AMEngineResult.Success) {
            if (!((Boolean) ((AMEngineResult.Success) aMEngineResult).getValue()).booleanValue()) {
                Log.w("AmeVectorProvider", "flushAllCollections: native reported partial failure");
            }
            this.f29702c.metadataStore.q();
            return DataCenterResult.INSTANCE.ok(t.f7040a);
        }
        if (!(aMEngineResult instanceof AMEngineResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        AMEngineResult.Failure failure = (AMEngineResult.Failure) aMEngineResult;
        if (this.f29702c.C(failure.getError())) {
            throw new AmeVectorStorageProvider.SessionRecoverableException(failure.getError());
        }
        return DataCenterResult.INSTANCE.failure(DataCenterError.INTERNAL_ERROR, "AME flushAllCollections failed: " + failure.getError() + " " + failure.getMessage(), failure.getCause());
    }
}
