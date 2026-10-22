package com.stepos.datacenter.ame;

import Y8.t;
import android.util.Log;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import com.stepos.ame.sdk.InsertArgs;
import com.stepos.datacenter.ame.AmeVectorStorageProvider;
import com.stepos.datacenter.vector.VectorEntry;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "session", "Lcom/stepos/ame/sdk/AMEngineSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$storeDefault$2$1", f = "AmeVectorStorageProvider.kt", l = {153}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$storeDefault$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super Long>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29780a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29781b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VectorEntry f29782c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29783d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$storeDefault$2$1(VectorEntry vectorEntry, AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$storeDefault$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29782c = vectorEntry;
        this.f29783d = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$storeDefault$2$1 ameVectorStorageProvider$storeDefault$2$1 = new AmeVectorStorageProvider$storeDefault$2$1(this.f29782c, this.f29783d, interfaceC4014c);
        ameVectorStorageProvider$storeDefault$2$1.f29781b = obj;
        return ameVectorStorageProvider$storeDefault$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super Long> interfaceC4014c) {
        return ((AmeVectorStorageProvider$storeDefault$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long jLongValue;
        Object objG = C4063a.g();
        int i10 = this.f29780a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29781b;
            InsertArgs insertArgsBuild = InsertArgs.INSTANCE.builder(this.f29782c.getVector()).metadata(this.f29783d.w(this.f29782c)).build();
            this.f29780a = 1;
            obj = aMEngineSession.insert(insertArgsBuild, this);
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
            jLongValue = ((Number) ((AMEngineResult.Success) aMEngineResult).getValue()).longValue();
        } else {
            if (!(aMEngineResult instanceof AMEngineResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Failure failure = (AMEngineResult.Failure) aMEngineResult;
            Log.e("AmeVectorProvider", "AME insert failed: " + failure.getError() + " " + failure.getMessage());
            if (this.f29783d.C(failure.getError())) {
                throw new AmeVectorStorageProvider.SessionRecoverableException(failure.getError());
            }
            jLongValue = -1;
        }
        return C4109a.g(jLongValue);
    }
}
