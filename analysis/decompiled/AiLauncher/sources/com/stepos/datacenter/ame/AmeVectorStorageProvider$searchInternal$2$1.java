package com.stepos.datacenter.ame;

import F6.b;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import android.util.Log;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import com.stepos.ame.sdk.SearchArgs;
import com.stepos.ame.sdk.SearchResult;
import com.stepos.datacenter.ame.AmeVectorStorageProvider;
import com.stepos.datacenter.vector.VectorSearchResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;", "session", "Lcom/stepos/ame/sdk/AMEngineSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$searchInternal$2$1", f = "AmeVectorStorageProvider.kt", l = {536}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$searchInternal$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super List<? extends VectorSearchResult>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29752a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29753b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float[] f29754c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f29755d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f29756e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29757f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$searchInternal$2$1(float[] fArr, int i10, Integer num, AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$searchInternal$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29754c = fArr;
        this.f29755d = i10;
        this.f29756e = num;
        this.f29757f = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$searchInternal$2$1 ameVectorStorageProvider$searchInternal$2$1 = new AmeVectorStorageProvider$searchInternal$2$1(this.f29754c, this.f29755d, this.f29756e, this.f29757f, interfaceC4014c);
        ameVectorStorageProvider$searchInternal$2$1.f29753b = obj;
        return ameVectorStorageProvider$searchInternal$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c) {
        return ((AmeVectorStorageProvider$searchInternal$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29752a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29753b;
            SearchArgs.Builder builderWithMetadata = SearchArgs.INSTANCE.builder(this.f29754c, this.f29755d).withMetadata(true);
            if (this.f29756e != null) {
                builderWithMetadata.filterCondition(F6.a.INSTANCE.b(QueryAlgorithmBundle.KEY_CATEGORY, new b.Int64Value(this.f29756e.intValue())));
            }
            SearchArgs searchArgsBuild = builderWithMetadata.build();
            this.f29752a = 1;
            obj = aMEngineSession.search(searchArgsBuild, this);
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
        if (!(aMEngineResult instanceof AMEngineResult.Success)) {
            if (!(aMEngineResult instanceof AMEngineResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Failure failure = (AMEngineResult.Failure) aMEngineResult;
            Log.e("AmeVectorProvider", "AME search failed: " + failure.getError() + " " + failure.getMessage());
            if (this.f29757f.C(failure.getError())) {
                throw new AmeVectorStorageProvider.SessionRecoverableException(failure.getError());
            }
            return C1173v.m();
        }
        Iterable<SearchResult> iterable = (Iterable) ((AMEngineResult.Success) aMEngineResult).getValue();
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        for (SearchResult searchResult : iterable) {
            Map<String, Object> metadata = searchResult.getMetadata();
            if (metadata == null) {
                metadata = kotlin.collections.a.i();
            }
            long id = searchResult.getId();
            Object obj2 = metadata.get("entityId");
            Number number = obj2 instanceof Number ? (Number) obj2 : null;
            long jLongValue = number != null ? number.longValue() : 0L;
            Object obj3 = metadata.get("entityClassName");
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (str == null) {
                str = "";
            }
            float score = searchResult.getScore();
            Object obj4 = metadata.get("label");
            String str2 = obj4 instanceof String ? (String) obj4 : null;
            arrayList.add(new VectorSearchResult(id, jLongValue, str, score, str2 != null ? str2 : ""));
        }
        return arrayList;
    }
}
