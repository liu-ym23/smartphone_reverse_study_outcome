package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$transformAndWrite$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13367a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13368b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13369c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f13370d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13371e;

    /* renamed from: f, reason: collision with root package name */
    public int f13372f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$transformAndWrite$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$transformAndWrite$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13371e = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13370d = obj;
        this.f13372f |= Integer.MIN_VALUE;
        return this.f13371e.y(null, null, this);
    }
}
