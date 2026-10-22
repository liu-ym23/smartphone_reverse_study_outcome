package kotlinx.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {156}, m = "withTimeoutOrNull", v = 1)
/* loaded from: classes5.dex */
public final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f36262a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36263b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36264c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36265d;

    /* renamed from: e, reason: collision with root package name */
    public int f36266e;

    public TimeoutKt$withTimeoutOrNull$1(InterfaceC4014c<? super TimeoutKt$withTimeoutOrNull$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36265d = obj;
        this.f36266e |= Integer.MIN_VALUE;
        return TimeoutKt.e(0L, null, this);
    }
}
