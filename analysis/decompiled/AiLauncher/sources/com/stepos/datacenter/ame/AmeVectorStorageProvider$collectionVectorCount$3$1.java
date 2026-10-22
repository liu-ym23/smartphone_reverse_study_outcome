package com.stepos.datacenter.ame;

import Y8.t;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "session", "Lcom/stepos/ame/sdk/AMEngineSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$collectionVectorCount$3$1", f = "AmeVectorStorageProvider.kt", l = {944}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$collectionVectorCount$3$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super Integer>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29680a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29681b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f29682c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$collectionVectorCount$3$1(String str, InterfaceC4014c<? super AmeVectorStorageProvider$collectionVectorCount$3$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29682c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$collectionVectorCount$3$1 ameVectorStorageProvider$collectionVectorCount$3$1 = new AmeVectorStorageProvider$collectionVectorCount$3$1(this.f29682c, interfaceC4014c);
        ameVectorStorageProvider$collectionVectorCount$3$1.f29681b = obj;
        return ameVectorStorageProvider$collectionVectorCount$3$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((AmeVectorStorageProvider$collectionVectorCount$3$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29680a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29681b;
            String str = this.f29682c;
            this.f29680a = 1;
            obj = aMEngineSession.collectionVectorCount(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AMEngineResult.Success success = obj instanceof AMEngineResult.Success ? (AMEngineResult.Success) obj : null;
        return C4109a.f(success != null ? ((Number) success.getValue()).intValue() : -1);
    }
}
