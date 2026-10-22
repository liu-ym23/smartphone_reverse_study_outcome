package androidx.room;

import C7.r;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class InvalidationTracker$setAutoCloser$1 extends FunctionReferenceImpl implements S7.a {
    public InvalidationTracker$setAutoCloser$1(Object obj) {
        super(0, obj, InvalidationTracker.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
    }

    @Override // S7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m7162invoke();
        return r.f317a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m7162invoke() {
        ((InvalidationTracker) this.receiver).onAutoCloseCallback();
    }
}
