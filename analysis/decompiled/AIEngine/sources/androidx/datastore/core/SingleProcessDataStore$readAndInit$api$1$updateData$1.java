package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1633a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1634b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1635c;

    /* renamed from: d, reason: collision with root package name */
    public Ref$ObjectRef f1636d;

    /* renamed from: e, reason: collision with root package name */
    public c f1637e;
    public /* synthetic */ Object h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d f1638j;

    /* renamed from: k, reason: collision with root package name */
    public int f1639k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$api$1$updateData$1(d dVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1638j = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.f1639k |= Integer.MIN_VALUE;
        return this.f1638j.a(null, this);
    }
}
