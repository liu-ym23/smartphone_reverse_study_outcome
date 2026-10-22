package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static <T> T[] getParcelableArrayExtra(Intent r100, String r101, Class<T> r102) {
            return (T[]) r100.getParcelableArrayExtra(r101, r102);
        }

        public static <T> ArrayList<T> getParcelableArrayListExtra(Intent r100, String r101, Class<? extends T> r102) {
            return r100.getParcelableArrayListExtra(r101, r102);
        }

        public static <T> T getParcelableExtra(Intent r100, String r101, Class<T> r102) {
            return (T) r100.getParcelableExtra(r101, r102);
        }

        public static <T extends Serializable> T getSerializableExtra(Intent r100, String r101, Class<T> r102) {
            return (T) r100.getSerializableExtra(r101, r102);
        }
    }

    private IntentCompat() {
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context r100, String r101) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r100.getPackageManager()) == false) goto L14;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 31) goto L7;
        Intent r103 = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", r101, null));
        if (r102 < 30) goto L12;
        return r103;
    L12:
        return r103.setPackage((String) Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(r100.getPackageManager())));
    L7:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r101, null));
    L14:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static Intent makeMainSelectorActivity(String r100, String r101) {
        return Intent.makeMainSelectorActivity(r100, r101);
    }

    public static Parcelable[] getParcelableArrayExtra(Intent r100, String r101, Class<? extends Parcelable> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArrayExtra(r100, r101, r102);
    L7:
        return r100.getParcelableArrayExtra(r101);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent r100, String r101, Class<? extends T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayListExtra(r100, r101, r102);
    L7:
        return r100.getParcelableArrayListExtra(r101);
    }

    public static <T> T getParcelableExtra(Intent r100, String r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r103 = (T) r100.getParcelableExtra(r101);
        if (r102.isInstance(r103) == true) goto L11;
        return null;
    L11:
        return r103;
    L5:
        return (T) Api33Impl.getParcelableExtra(r100, r101, r102);
    }

    public static <T extends Serializable> T getSerializableExtra(Intent r100, String r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r103 = (T) r100.getSerializableExtra(r101);
        if (r102.isInstance(r103) == true) goto L11;
        return null;
    L11:
        return r103;
    L5:
        return (T) Api33Impl.getSerializableExtra(r100, r101, r102);
    }
}
