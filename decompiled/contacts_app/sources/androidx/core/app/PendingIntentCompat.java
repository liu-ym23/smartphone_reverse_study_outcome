package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.vcard.VCardConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    private static class Api16Impl {
        private Api16Impl() {
        }

        public static PendingIntent getActivities(Context r0, int r1, Intent[] r2, int r3, Bundle r4) {
            return PendingIntent.getActivities(r0, r1, r2, r3, r4);
        }

        public static PendingIntent getActivity(Context r0, int r1, Intent r2, int r3, Bundle r4) {
            return PendingIntent.getActivity(r0, r1, r2, r3, r4);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context r0, int r1, Intent r2, int r3) {
            return PendingIntent.getForegroundService(r0, r1, r2, r3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static int addMutabilityFlags(boolean r0, int r1) {
        if (r0 == false) goto L4;
        int r2 = VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING;
    L6:
        return r2 | r1;
    L4:
        r2 = 67108864;
        goto L6
    }

    public static PendingIntent getActivities(Context r0, int r1, Intent[] r2, int r3, Bundle r4, boolean r5) {
        return Api16Impl.getActivities(r0, r1, r2, addMutabilityFlags(r5, r3), r4);
    }

    public static PendingIntent getActivities(Context r0, int r1, Intent[] r2, int r3, boolean r4) {
        return PendingIntent.getActivities(r0, r1, r2, addMutabilityFlags(r4, r3));
    }

    public static PendingIntent getActivity(Context r0, int r1, Intent r2, int r3, boolean r4) {
        return PendingIntent.getActivity(r0, r1, r2, addMutabilityFlags(r4, r3));
    }

    public static PendingIntent getActivity(Context r0, int r1, Intent r2, int r3, Bundle r4, boolean r5) {
        return Api16Impl.getActivity(r0, r1, r2, addMutabilityFlags(r5, r3), r4);
    }

    public static PendingIntent getBroadcast(Context r0, int r1, Intent r2, int r3, boolean r4) {
        return PendingIntent.getBroadcast(r0, r1, r2, addMutabilityFlags(r4, r3));
    }

    public static PendingIntent getForegroundService(Context r0, int r1, Intent r2, int r3, boolean r4) {
        return Api26Impl.getForegroundService(r0, r1, r2, addMutabilityFlags(r4, r3));
    }

    public static PendingIntent getService(Context r0, int r1, Intent r2, int r3, boolean r4) {
        return PendingIntent.getService(r0, r1, r2, addMutabilityFlags(r4, r3));
    }

    private PendingIntentCompat() {
    }
}
