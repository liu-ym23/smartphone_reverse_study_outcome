package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
/* loaded from: classes.dex */
final class SingleProcessDataStore$handleUpdate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1620a;

    /* renamed from: b, reason: collision with root package name */
    public c f1621b;

    /* renamed from: c, reason: collision with root package name */
    public CompletableDeferred f1622c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1623d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1624e;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$handleUpdate$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1624e = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1623d = obj;
        this.h |= Integer.MIN_VALUE;
        return c.b(this.f1624e, null, this);
    }
}
