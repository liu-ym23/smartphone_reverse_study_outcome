package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", l = {127}, m = "transaction")
/* loaded from: classes.dex */
public final class PassthroughConnection$transaction$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f14702a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14703b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PassthroughConnection f14704c;

    /* renamed from: d, reason: collision with root package name */
    public int f14705d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassthroughConnection$transaction$1(PassthroughConnection passthroughConnection, InterfaceC4014c<? super PassthroughConnection$transaction$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14704c = passthroughConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14703b = obj;
        this.f14705d |= Integer.MIN_VALUE;
        return this.f14704c.g(null, null, this);
    }
}
