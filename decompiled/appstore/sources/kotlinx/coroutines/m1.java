package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final class m1 extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f21646d;

    public m1(CoroutineContext r10, Function2 r11) {
        super(r10, false);
        this.f21646d = IntrinsicsKt__IntrinsicsJvmKt.b(r11, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void X() {
        cg.a.b(this.f21646d, this);
    }
}
