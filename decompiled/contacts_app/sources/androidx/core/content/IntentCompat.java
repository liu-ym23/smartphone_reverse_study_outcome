package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.core.os.BuildCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    static class Api15Impl {
        private Api15Impl() {
        }

        static Intent makeMainSelectorActivity(String r0, String r1) {
            return Intent.makeMainSelectorActivity(r0, r1);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelableExtra(Intent r0, String r1, Class<T> r2) {
            return (T) r0.getParcelableExtra(r1, r2);
        }

        static <T> T[] getParcelableArrayExtra(Intent r0, String r1, Class<T> r2) {
            return (T[]) r0.getParcelableArrayExtra(r1, r2);
        }

        static <T> ArrayList<T> getParcelableArrayListExtra(Intent r0, String r1, Class<? extends T> r2) {
            return r0.getParcelableArrayListExtra(r1, r2);
        }
    }

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String r0, String r1) {
        return Api15Impl.makeMainSelectorActivity(r0, r1);
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context r2, String r3) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r2.getPackageManager()) == false) goto L7;
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r3, null));
    L7:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static <T> T getParcelableExtra(Intent r1, String r2, Class<T> r3) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r4 = (T) r1.getParcelableExtra(r2);
        if (r3.isInstance(r4) == true) goto L11;
        return null;
    L11:
        return r4;
    L5:
        return (T) Api33Impl.getParcelableExtra(r1, r2, r3);
    }

    public static Parcelable[] getParcelableArrayExtra(Intent r1, String r2, Class<? extends Parcelable> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArrayExtra(r1, r2, r3);
    L7:
        return r1.getParcelableArrayExtra(r2);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent r1, String r2, Class<? extends T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getParcelableArrayListExtra(r1, r2, r3);
    L7:
        return r1.getParcelableArrayListExtra(r2);
    }
}
