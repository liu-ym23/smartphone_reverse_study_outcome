package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13376a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13377b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13378c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13379d;

    /* renamed from: e, reason: collision with root package name */
    public Object f13380e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13381f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13382g;

    /* renamed from: h, reason: collision with root package name */
    public int f13383h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$writeData$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$writeData$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13382g = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13381f = obj;
        this.f13383h |= Integer.MIN_VALUE;
        return this.f13382g.z(null, this);
    }
}
