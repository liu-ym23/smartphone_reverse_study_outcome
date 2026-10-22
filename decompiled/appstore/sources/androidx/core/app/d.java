package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {
        @DoNotInline
        public static IBinder a(Bundle r10, String r11) {
            return r10.getBinder(r11);
        }

        @DoNotInline
        public static void b(Bundle r10, String r11, IBinder r12) {
            r10.putBinder(r11, r12);
        }
    }

    public static IBinder a(Bundle r10, String r11) {
        return a.a(r10, r11);
    }

    public static void b(Bundle r10, String r11, IBinder r12) {
        a.b(r10, r11, r12);
    }
}
