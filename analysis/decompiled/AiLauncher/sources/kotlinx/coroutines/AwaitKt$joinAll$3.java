package kotlinx.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {58}, m = "joinAll", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AwaitKt$joinAll$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36217a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36218b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36219c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36220d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36221e;

    /* renamed from: f, reason: collision with root package name */
    public int f36222f;

    /* renamed from: g, reason: collision with root package name */
    public int f36223g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f36224h;

    /* renamed from: i, reason: collision with root package name */
    public int f36225i;

    public AwaitKt$joinAll$3(InterfaceC4014c<? super AwaitKt$joinAll$3> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36224h = obj;
        this.f36225i |= Integer.MIN_VALUE;
        return AwaitKt.b(null, this);
    }
}
