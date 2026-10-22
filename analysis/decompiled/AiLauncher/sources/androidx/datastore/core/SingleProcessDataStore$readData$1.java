package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13356a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13357b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13358c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f13359d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13360e;

    /* renamed from: f, reason: collision with root package name */
    public int f13361f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readData$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$readData$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13360e = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13359d = obj;
        this.f13361f |= Integer.MIN_VALUE;
        return this.f13360e.w(this);
    }
}
