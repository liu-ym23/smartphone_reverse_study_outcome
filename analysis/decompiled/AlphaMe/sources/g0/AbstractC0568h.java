package g0;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;

/* renamed from: g0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0568h {
    @DoNotInline
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
