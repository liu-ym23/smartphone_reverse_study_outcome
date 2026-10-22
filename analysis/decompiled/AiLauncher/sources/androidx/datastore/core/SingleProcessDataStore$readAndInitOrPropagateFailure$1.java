package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13352a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13353b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13354c;

    /* renamed from: d, reason: collision with root package name */
    public int f13355d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateFailure$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$readAndInitOrPropagateFailure$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13354c = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13353b = obj;
        this.f13355d |= Integer.MIN_VALUE;
        return this.f13354c.v(this);
    }
}
