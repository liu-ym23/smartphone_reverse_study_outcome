package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static int getSlotIndex(int r100) {
            return SubscriptionManager.getSlotIndex(r100);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int r100) {
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 29) goto L8;
        if (sGetSlotIndexMethod == null) goto L12;
    L16:
        Integer r102 = (Integer) sGetSlotIndexMethod.invoke(null, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L21
        if (r102 == null) goto L20;
        return r102.intValue();
    L12:
        if (r101 < 26) goto L14;
        sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
    L15:
        sGetSlotIndexMethod.setAccessible(true);     // Catch: Throwable -> L21
        goto L16
    L14:
        sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
    L20:
        return -1;
    L8:
        return Api29Impl.getSlotIndex(r100);
    }
}
