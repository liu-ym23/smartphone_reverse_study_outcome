package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

/* JADX INFO: loaded from: classes.dex */
public class UserManagerCompat {

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isUserUnlocked(Context r1) {
            return ((UserManager) r1.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context r0) {
        return Api24Impl.isUserUnlocked(r0);
    }
}
