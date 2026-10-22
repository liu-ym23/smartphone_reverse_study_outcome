package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public class UserHandleCompat {
    private static Method sGetUserIdMethod;
    private static Constructor<UserHandle> sUserHandleConstructor;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static UserHandle getUserHandleForUid(int r100) {
            return UserHandle.getUserHandleForUid(r100);
        }
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if (sGetUserIdMethod != null) goto L6;
        Method r100 = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
        sGetUserIdMethod = r100;
        r100.setAccessible(true);
    L6:
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor != null) goto L6;
        Constructor<UserHandle> r100 = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
        sUserHandleConstructor = r100;
        r100.setAccessible(true);
    L6:
        return sUserHandleConstructor;
    }

    private UserHandleCompat() {
    }

    public static UserHandle getUserHandleForUid(int r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        Integer r101 = (Integer) getGetUserIdMethod().invoke(null, new Object[]{Integer.valueOf(r100)});     // Catch: InvocationTargetException -> L8 InstantiationException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        return getUserHandleConstructor().newInstance(new Object[]{r101});
    L14:
        e = move-exception;
        IllegalAccessError r102 = new IllegalAccessError();
        r102.initCause(e);
        throw r102;
    L11:
        e = move-exception;
        InstantiationError r103 = new InstantiationError();
        r103.initCause(e);
        throw r103;
    L17:
        e = move-exception;
        NoSuchMethodError r104 = new NoSuchMethodError();
        r104.initCause(e);
        throw r104;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return Api24Impl.getUserHandleForUid(r100);
    }
}
