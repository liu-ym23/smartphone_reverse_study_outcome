package coil.intercept;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {203}, m = "decode")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor$decode$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15700a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15701b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15702c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15703d;

    /* renamed from: e, reason: collision with root package name */
    public Object f15704e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15705f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15706g;

    /* renamed from: h, reason: collision with root package name */
    public Object f15707h;

    /* renamed from: i, reason: collision with root package name */
    public int f15708i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f15709j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15710k;

    /* renamed from: l, reason: collision with root package name */
    public int f15711l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$decode$1(EngineInterceptor engineInterceptor, InterfaceC4014c<? super EngineInterceptor$decode$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15710k = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15709j = obj;
        this.f15711l |= Integer.MIN_VALUE;
        return this.f15710k.i(null, null, null, null, null, null, this);
    }
}
