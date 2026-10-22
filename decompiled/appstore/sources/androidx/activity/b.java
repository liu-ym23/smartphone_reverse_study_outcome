package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f164a = null;

    static {
        f164a = new b();
    }

    public b() {
    }

    @DoNotInline
    @NotNull
    public final BackEvent a(float r10, float r11, float r12, int r13) {
        return new BackEvent(r10, r11, r12, r13);
    }

    @DoNotInline
    public final float b(@NotNull BackEvent r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        return r10.getProgress();
    }

    @DoNotInline
    public final int c(@NotNull BackEvent r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        return r10.getSwipeEdge();
    }

    @DoNotInline
    public final float d(@NotNull BackEvent r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        return r10.getTouchX();
    }

    @DoNotInline
    public final float e(@NotNull BackEvent r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        return r10.getTouchY();
    }
}
