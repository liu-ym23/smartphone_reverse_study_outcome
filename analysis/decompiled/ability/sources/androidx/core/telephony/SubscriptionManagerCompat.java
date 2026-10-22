package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(22)
/* loaded from: classes2.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static int getSlotIndex(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        return Api29Impl.getSlotIndex(i);
    }
}
