package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", l = {89, 91}, m = "usePrepared")
/* loaded from: classes.dex */
public final class PassthroughConnection$usePrepared$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14706a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14707b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14708c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PassthroughConnection f14709d;

    /* renamed from: e, reason: collision with root package name */
    public int f14710e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassthroughConnection$usePrepared$1(PassthroughConnection passthroughConnection, InterfaceC4014c<? super PassthroughConnection$usePrepared$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14709d = passthroughConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14708c = obj;
        this.f14710e |= Integer.MIN_VALUE;
        return this.f14709d.d(null, null, this);
    }
}
