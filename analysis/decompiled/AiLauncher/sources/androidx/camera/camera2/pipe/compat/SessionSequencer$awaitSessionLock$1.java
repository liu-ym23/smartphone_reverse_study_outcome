package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.SessionSequencer", f = "ConcurrentSessionSequencers.kt", l = {98}, m = "awaitSessionLock", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SessionSequencer$awaitSessionLock$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10601a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionSequencer f10602b;

    /* renamed from: c, reason: collision with root package name */
    public int f10603c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionSequencer$awaitSessionLock$1(SessionSequencer sessionSequencer, InterfaceC4014c<? super SessionSequencer$awaitSessionLock$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10602b = sessionSequencer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10601a = obj;
        this.f10603c |= Integer.MIN_VALUE;
        return this.f10602b.a(this);
    }
}
