package androidx.activity;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends FunctionReferenceImpl implements InterfaceC5063a<t> {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // p9.InterfaceC5063a
    public /* bridge */ /* synthetic */ t invoke() {
        l();
        return t.f7040a;
    }

    public final void l() {
        ((OnBackPressedDispatcher) this.receiver).v();
    }
}
