package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13327a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13328b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13329c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13330d;

    /* renamed from: e, reason: collision with root package name */
    public Object f13331e;

    /* renamed from: f, reason: collision with root package name */
    public Object f13332f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13333g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f13334h;

    /* renamed from: i, reason: collision with root package name */
    public int f13335i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$1(SingleProcessDataStore<T> singleProcessDataStore, InterfaceC4014c<? super SingleProcessDataStore$readAndInit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13334h = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13333g = obj;
        this.f13335i |= Integer.MIN_VALUE;
        return this.f13334h.t(this);
    }
}
