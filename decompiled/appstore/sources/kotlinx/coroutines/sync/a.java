package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f21756e;

    public a(long r10, a r11, int r12) {
        super(r10, r11, r12);
        this.f21756e = new AtomicReferenceArray(SemaphoreKt.f());
    }

    @Override // kotlinx.coroutines.internal.y
    public int n() {
        return SemaphoreKt.f();
    }

    @Override // kotlinx.coroutines.internal.y
    public void o(int r10, Throwable r11, CoroutineContext r12) {
        b0 r13 = SemaphoreKt.c();
        r().set(r10, r13);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f21756e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f21630c + ", hashCode=" + hashCode() + ']';
    }
}
