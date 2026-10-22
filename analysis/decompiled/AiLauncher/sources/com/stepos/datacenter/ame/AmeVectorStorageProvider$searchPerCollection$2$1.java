package com.stepos.datacenter.ame;

import Y8.t;
import com.stepos.ame.sdk.AMEngineSession;
import com.stepos.datacenter.vector.VectorSearchResult;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;", "session", "Lcom/stepos/ame/sdk/AMEngineSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$searchPerCollection$2$1", f = "AmeVectorStorageProvider.kt", l = {459, 461}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$searchPerCollection$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super List<? extends VectorSearchResult>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29767a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29768b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f29769c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f29770d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float[] f29771e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f29772f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29773g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$searchPerCollection$2$1(String str, String str2, float[] fArr, int i10, AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$searchPerCollection$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29769c = str;
        this.f29770d = str2;
        this.f29771e = fArr;
        this.f29772f = i10;
        this.f29773g = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$searchPerCollection$2$1 ameVectorStorageProvider$searchPerCollection$2$1 = new AmeVectorStorageProvider$searchPerCollection$2$1(this.f29769c, this.f29770d, this.f29771e, this.f29772f, this.f29773g, interfaceC4014c);
        ameVectorStorageProvider$searchPerCollection$2$1.f29768b = obj;
        return ameVectorStorageProvider$searchPerCollection$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c) {
        return ((AmeVectorStorageProvider$searchPerCollection$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r14 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        if (r14 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.ame.AmeVectorStorageProvider$searchPerCollection$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
