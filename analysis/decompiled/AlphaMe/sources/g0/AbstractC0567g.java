package g0;

import android.view.Choreographer;
import androidx.annotation.DoNotInline;

/* renamed from: g0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0567g {
    @DoNotInline
    public static void a(Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new W.d(1, runnable));
    }
}
