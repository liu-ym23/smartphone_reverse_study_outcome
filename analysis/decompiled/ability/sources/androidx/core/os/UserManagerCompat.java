package androidx.core.os;

import android.content.Context;
import android.os.UserManager;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public class UserManagerCompat {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isUserUnlocked(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context context) {
        return Api24Impl.isUserUnlocked(context);
    }
}
