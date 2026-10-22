package coil;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.RealImageLoader", f = "RealImageLoader.kt", l = {171, 183, 187}, m = "executeMain")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealImageLoader$executeMain$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15532a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15533b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15534c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15535d;

    /* renamed from: e, reason: collision with root package name */
    public Object f15536e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f15537f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RealImageLoader f15538g;

    /* renamed from: h, reason: collision with root package name */
    public int f15539h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$1(RealImageLoader realImageLoader, InterfaceC4014c<? super RealImageLoader$executeMain$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15538g = realImageLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15537f = obj;
        this.f15539h |= Integer.MIN_VALUE;
        return this.f15538g.f(null, 0, this);
    }
}
