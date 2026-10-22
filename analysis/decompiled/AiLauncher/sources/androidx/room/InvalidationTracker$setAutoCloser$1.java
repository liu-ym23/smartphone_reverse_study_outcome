package androidx.room;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class InvalidationTracker$setAutoCloser$1 extends FunctionReferenceImpl implements InterfaceC5063a<Y8.t> {
    public InvalidationTracker$setAutoCloser$1(Object obj) {
        super(0, obj, InvalidationTracker.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
    }

    @Override // p9.InterfaceC5063a
    public /* bridge */ /* synthetic */ Y8.t invoke() {
        l();
        return Y8.t.f7040a;
    }

    public final void l() {
        ((InvalidationTracker) this.receiver).r();
    }
}
