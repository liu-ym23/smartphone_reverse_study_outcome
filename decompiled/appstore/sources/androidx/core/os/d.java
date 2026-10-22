package androidx.core.os;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {
        public static Handler a(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public static Handler a(Looper r10) {
        return a.a(r10);
    }
}
