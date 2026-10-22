package androidx.datastore.core;

import java.util.LinkedHashSet;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public c f1644a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1645b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1646c;

    /* renamed from: d, reason: collision with root package name */
    public int f1647d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateFailure$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1646c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1645b = obj;
        this.f1647d |= Integer.MIN_VALUE;
        LinkedHashSet linkedHashSet = c.f1672j;
        return this.f1646c.f(this);
    }
}
