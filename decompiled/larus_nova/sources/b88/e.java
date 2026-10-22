package b88;

import com.larus.platform.api.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18199a = null;

    static {
        f18199a = new e();
    }

    public e() {
    }

    @Override // b88.b
    public final void c(float r100) {
    }

    @Override // b88.b
    public final void d(float r100) {
    }

    @Override // b88.b
    public final float e() {
        return 1.0f;
    }

    @Override // b88.b
    public final int f() {
        return 0;
    }

    @Override // b88.b
    public final int getAudioDuration() {
        return 0;
    }

    @Override // b88.b
    public final void h(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pausedReason");
    }

    @Override // b88.b
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // b88.b
    public final boolean isWorking() {
        return false;
    }

    @Override // b88.b
    public final boolean j(int r100, l0 r101) {
        return false;
    }

    @Override // b88.b
    public final int k() {
        return 0;
    }

    @Override // b88.b
    public final void release() {
    }

    @Override // b88.b
    public final void setLooping(boolean r100) {
    }

    @Override // b88.b
    public final void g(Function0<Unit> r100) {
        if (r100 == null) goto L5;
        r100.invoke();
        return;
    }
}
