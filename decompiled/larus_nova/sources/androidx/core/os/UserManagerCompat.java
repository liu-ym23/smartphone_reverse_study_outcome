package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: loaded from: classes17.dex */
public class UserManagerCompat {

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isUserUnlocked(Context r100) {
            return ((UserManager) r100.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return Api24Impl.isUserUnlocked(r100);
    }
}
