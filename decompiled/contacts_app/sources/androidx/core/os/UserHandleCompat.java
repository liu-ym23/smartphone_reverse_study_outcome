package androidx.core.os;

import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UserHandleCompat {
    private static Method sGetUserIdMethod;
    private static Constructor<UserHandle> sUserHandleConstructor;

    private static class Api24Impl {
        private Api24Impl() {
        }

        static UserHandle getUserHandleForUid(int r0) {
            return UserHandle.getUserHandleForUid(r0);
        }
    }

    private UserHandleCompat() {
    }

    public static UserHandle getUserHandleForUid(int r0) {
        return Api24Impl.getUserHandleForUid(r0);
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if (sGetUserIdMethod != null) goto L6;
        Method r0 = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
        sGetUserIdMethod = r0;
        r0.setAccessible(true);
    L6:
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor != null) goto L6;
        Constructor<UserHandle> r0 = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
        sUserHandleConstructor = r0;
        r0.setAccessible(true);
    L6:
        return sUserHandleConstructor;
    }
}
