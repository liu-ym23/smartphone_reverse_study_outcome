package androidx.datastore.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13340a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13341b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13342c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13343d;

    /* renamed from: e, reason: collision with root package name */
    public Object f13344e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13345f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 f13346g;

    /* renamed from: h, reason: collision with root package name */
    public int f13347h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, InterfaceC4014c<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13346g = singleProcessDataStore$readAndInit$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13345f = obj;
        this.f13347h |= Integer.MIN_VALUE;
        return this.f13346g.a(null, this);
    }
}
