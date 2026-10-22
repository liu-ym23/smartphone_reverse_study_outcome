package com.stepos.datacenter.ame;

import Y8.t;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import com.stepos.ame.sdk.CollectionPersistConfig;
import com.stepos.datacenter.ame.AmeVectorStorageProvider;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.vector.CollectionDescriptor;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineSession;", "session", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "LY8/t;", "<anonymous>", "(Lcom/stepos/ame/sdk/AMEngineSession;)Lcom/stepos/datacenter/core/result/DataCenterResult;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$onCollectionCreated$2$1", f = "AmeVectorStorageProvider.kt", l = {687}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$onCollectionCreated$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super DataCenterResult<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29723a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29724b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29725c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CollectionDescriptor f29726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$onCollectionCreated$2$1(AmeVectorStorageProvider ameVectorStorageProvider, CollectionDescriptor collectionDescriptor, InterfaceC4014c<? super AmeVectorStorageProvider$onCollectionCreated$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29725c = ameVectorStorageProvider;
        this.f29726d = collectionDescriptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$onCollectionCreated$2$1 ameVectorStorageProvider$onCollectionCreated$2$1 = new AmeVectorStorageProvider$onCollectionCreated$2$1(this.f29725c, this.f29726d, interfaceC4014c);
        ameVectorStorageProvider$onCollectionCreated$2$1.f29724b = obj;
        return ameVectorStorageProvider$onCollectionCreated$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super DataCenterResult<t>> interfaceC4014c) {
        return ((AmeVectorStorageProvider$onCollectionCreated$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objCreateCollection;
        Object objG = C4063a.g();
        int i10 = this.f29723a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29724b;
            CollectionPersistConfig collectionPersistConfigY = this.f29725c.y(this.f29726d);
            String id = this.f29726d.getId();
            int rawDim = this.f29726d.getRawDim();
            int storageDim = this.f29726d.getStorageDim();
            int vectorMetricInt = this.f29726d.getMetric().toVectorMetricInt();
            int iOrdinal = this.f29726d.getDtype().ordinal();
            String embeddingModel = this.f29726d.getEmbeddingModel();
            boolean inputNormalized = this.f29726d.getInputNormalized();
            Long lG = C4109a.g(this.f29726d.getCapacityPolicy().g());
            Long lG2 = C4109a.g(this.f29726d.getCapacityPolicy().i());
            Long lG3 = C4109a.g(this.f29726d.getCapacityPolicy().h());
            this.f29723a = 1;
            objCreateCollection = aMEngineSession.createCollection(id, rawDim, storageDim, vectorMetricInt, iOrdinal, embeddingModel, inputNormalized, collectionPersistConfigY, lG, lG2, lG3, this);
            if (objCreateCollection == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objCreateCollection = obj;
        }
        AMEngineResult aMEngineResult = (AMEngineResult) objCreateCollection;
        if (aMEngineResult instanceof AMEngineResult.Success) {
            return DataCenterResult.INSTANCE.ok(t.f7040a);
        }
        if (!(aMEngineResult instanceof AMEngineResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        AMEngineResult.Failure failure = (AMEngineResult.Failure) aMEngineResult;
        if (this.f29725c.C(failure.getError())) {
            throw new AmeVectorStorageProvider.SessionRecoverableException(failure.getError());
        }
        return DataCenterResult.INSTANCE.failure(DataCenterError.INTERNAL_ERROR, "AME createCollection '" + this.f29726d.getId() + "' failed: " + failure.getError() + " " + failure.getMessage(), failure.getCause());
    }
}
