package kotlinx.coroutines.channels;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {361}, m = "awaitClose", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36344a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36345b;

    /* renamed from: c, reason: collision with root package name */
    public int f36346c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36347d;

    /* renamed from: e, reason: collision with root package name */
    public int f36348e;

    public ProduceKt$awaitClose$1(InterfaceC4014c<? super ProduceKt$awaitClose$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36347d = obj;
        this.f36348e |= Integer.MIN_VALUE;
        return ProduceKt.a(null, null, this);
    }
}
