package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$handleUpdate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13321a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13322b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13323c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f13324d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13325e;

    /* renamed from: f, reason: collision with root package name */
    public int f13326f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$handleUpdate$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$handleUpdate$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13325e = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13324d = obj;
        this.f13326f |= Integer.MIN_VALUE;
        return this.f13325e.s(null, this);
    }
}
