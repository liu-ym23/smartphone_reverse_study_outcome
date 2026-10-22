package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextUtil {

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static String getAttributionTag(Context r100) {
            return r100.getAttributionTag();
        }

        public static Context createAttributionContext(Context r100, String r101) {
            return r100.createAttributionContext(r101);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getDeviceId(Context r100) {
            return r100.getDeviceId();
        }

        public static Context createDeviceContext(Context r100, int r101) {
            return r100.createDeviceContext(r101);
        }
    }

    private ContextUtil() {
    }

    public static Context getApplicationContext(Context r100) {
        Context r101 = r100.getApplicationContext();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 34) goto L8;
        int r103 = Api34Impl.getDeviceId(r100);
        if (r103 == Api34Impl.getDeviceId(r101)) goto L8;
        r101 = Api34Impl.createDeviceContext(r101, r103);
    L8:
        if (r102 < 30) goto L13;
        String r104 = Api30Impl.getAttributionTag(r100);
        if (Objects.equals(r104, Api30Impl.getAttributionTag(r101)) == false) goto L12;
        return r101;
    L12:
        return Api30Impl.createAttributionContext(r101, r104);
    L13:
        return r101;
    }

    public static Application getApplicationFromContext(Context r100) {
        Context r101 = getApplicationContext(r100);
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L9;
        if ((r101 instanceof Application) == true) goto L13;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L13:
        return (Application) r101;
    L9:
        return null;
    }
}
