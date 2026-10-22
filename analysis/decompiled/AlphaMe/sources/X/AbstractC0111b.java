package X;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;

/* renamed from: X.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0111b {
    @DoNotInline
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
