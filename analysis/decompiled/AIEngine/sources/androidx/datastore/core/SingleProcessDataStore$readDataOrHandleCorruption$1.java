package androidx.datastore.core;

import java.util.LinkedHashSet;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
/* loaded from: classes.dex */
final class SingleProcessDataStore$readDataOrHandleCorruption$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1653a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1654b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1655c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1656d;

    /* renamed from: e, reason: collision with root package name */
    public int f1657e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readDataOrHandleCorruption$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1656d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1655c = obj;
        this.f1657e |= Integer.MIN_VALUE;
        LinkedHashSet linkedHashSet = c.f1672j;
        return this.f1656d.h(this);
    }
}
