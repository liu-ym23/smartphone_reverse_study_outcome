package androidx.core.graphics;

import android.graphics.Paint;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2560a = null;

    public static class a {
        @DoNotInline
        public static boolean a(Paint r10, String r11) {
            return r10.hasGlyph(r11);
        }
    }

    static {
        f2560a = new ThreadLocal();
    }

    public static boolean a(Paint r10, String r11) {
        return a.a(r10, r11);
    }
}
