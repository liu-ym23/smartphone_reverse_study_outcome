package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static boolean areUnusedAppRestrictionsEnabled(Context r100) {
            return !r100.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L5;
        boolean r102 = true;
    L7:
        if (r101 < 23) goto L10;
        if (r101 >= 30) goto L10;
        boolean r103 = true;
    L12:
        if (getPermissionRevocationVerifierApp(r100) == null) goto L14;
        boolean r104 = true;
    L15:
        if (r102 == true) goto L21;
        if (r103 == false) goto L19;
        if (r104 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L14:
        r104 = false;
    L10:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L7
    }

    public static String getPermissionRevocationVerifierApp(PackageManager r100) {
        String r101 = null;
        Iterator<ResolveInfo> r102 = r100.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next().activityInfo.packageName;
        if (r100.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r103) != 0) goto L4;
        if (r101 != null) goto L9;
        r101 = r103;
        goto L4
    L9:
        return r101;
    L11:
        return r101;
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context r100) {
        ResolvableFuture<Integer> r101 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r100) == true) goto L7;
        r101.set(0);
        return r101;
    L7:
        if (areUnusedAppRestrictionsAvailable(r100.getPackageManager()) == true) goto L10;
        r101.set(1);
        return r101;
    L10:
        int r102 = r100.getApplicationInfo().targetSdkVersion;
        if (r102 >= 30) goto L14;
        r101.set(0);
        return r101;
    L14:
        int r103 = Build.VERSION.SDK_INT;
        int r104 = 4;
        if (r103 >= 31) goto L17;
        if (r103 == 30) goto L25;
        final UnusedAppRestrictionsBackportServiceConnection r105 = new UnusedAppRestrictionsBackportServiceConnection(r100);
        r101.addListener(new v(r105), PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(LOG_TAG)));
        r105.connectAndFetchResult(r101);
        return r101;
    L25:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r100) == true) goto L28;
        r104 = 2;
    L28:
        r101.set(Integer.valueOf(r104));
        return r101;
    L17:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r100) == false) goto L21;
        if (r102 < 31) goto L20;
        r104 = 5;
    L20:
        r101.set(Integer.valueOf(r104));
    L22:
        return r101;
    L21:
        r101.set(2);
        goto L22
    }
}
