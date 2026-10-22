package androidx.datastore.core;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public c f1625a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1626b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f1627c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1628d;

    /* renamed from: e, reason: collision with root package name */
    public d f1629e;
    public Iterator h;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1630j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1631k;

    /* renamed from: l, reason: collision with root package name */
    public int f1632l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f1631k = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1630j = obj;
        this.f1632l |= Integer.MIN_VALUE;
        LinkedHashSet linkedHashSet = c.f1672j;
        return this.f1631k.d(this);
    }
}
