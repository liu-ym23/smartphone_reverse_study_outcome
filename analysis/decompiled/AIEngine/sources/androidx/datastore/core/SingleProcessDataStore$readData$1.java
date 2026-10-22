package androidx.datastore.core;

import java.io.FileInputStream;
import java.util.LinkedHashSet;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
/* loaded from: classes.dex */
final class SingleProcessDataStore$readData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public c f1648a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f1649b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1650c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1651d;

    /* renamed from: e, reason: collision with root package name */
    public int f1652e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readData$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1651d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1650c = obj;
        this.f1652e |= Integer.MIN_VALUE;
        LinkedHashSet linkedHashSet = c.f1672j;
        return this.f1651d.g(this);
    }
}
