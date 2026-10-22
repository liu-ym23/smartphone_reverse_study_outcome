package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void finishAfterTransition(Activity r100) {
            r100.finishAfterTransition();
        }

        public static void postponeEnterTransition(Activity r100) {
            r100.postponeEnterTransition();
        }

        public static void startPostponedEnterTransition(Activity r100) {
            r100.startPostponedEnterTransition();
        }

        public static void setEnterSharedElementCallback(Activity r100, android.app.SharedElementCallback r101) {
            r100.setEnterSharedElementCallback(r101);
        }

        public static void setExitSharedElementCallback(Activity r100, android.app.SharedElementCallback r101) {
            r100.setExitSharedElementCallback(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api22Impl {
        private Api22Impl() {
        }

        public static Uri getReferrer(Activity r100) {
            return r100.getReferrer();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void onSharedElementsReady(Object r100) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r100).onSharedElementsReady();
        }

        private static boolean androidx_core_app_ActivityCompat$Api23Impl_android_app_Activity_shouldShowRequestPermissionRationale(Activity r110, String r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b("auto_cert_androidx_core_app_ActivityCompat$Api23Impl_android_app_Activity_shouldShowRequestPermissionRationale");
            g06.a r102 = ApiHookConfig.f245611b.get(102609);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Boolean) r107.f474983b).booleanValue();
        L21:
            return r110.shouldShowRequestPermissionRationale(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
            return androidx_core_app_ActivityCompat$Api23Impl_android_app_Activity_shouldShowRequestPermissionRationale(r100, r101);
        }

        public static void requestPermissions(Activity r100, String[] r101, int r102) {
            r100.requestPermissions(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static <T> T requireViewById(Activity r100, int r101) {
            return (T) r100.requireViewById(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Display getDisplay(ContextWrapper r100) {
            return r100.getDisplay();
        }

        public static void setLocusContext(Activity r100, LocusIdCompat r101, Bundle r102) {
            if (r101 != null) goto L4;
            LocusId r103 = null;
        L5:
            r100.setLocusContext(r103, r102);
            return;
        L4:
            r103 = r101.toLocusId();
            goto L5
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static boolean isLaunchedFromBubble(Activity r100) {
            return r100.isLaunchedFromBubble();
        }

        private static boolean androidx_core_app_ActivityCompat$Api31Impl_android_app_Activity_shouldShowRequestPermissionRationale(Activity r110, String r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b("auto_cert_androidx_core_app_ActivityCompat$Api31Impl_android_app_Activity_shouldShowRequestPermissionRationale");
            g06.a r102 = ApiHookConfig.f245611b.get(102609);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Boolean) r107.f474983b).booleanValue();
        L21:
            return r110.shouldShowRequestPermissionRationale(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
            PackageManager r102 = r100.getApplication().getPackageManager();     // Catch: Throwable -> L4
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(r102, new Object[]{r101})).booleanValue();
        L5:
            return androidx_core_app_ActivityCompat$Api31Impl_android_app_Activity_shouldShowRequestPermissionRationale(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api32Impl {
        private Api32Impl() {
        }

        private static boolean androidx_core_app_ActivityCompat$Api32Impl_android_app_Activity_shouldShowRequestPermissionRationale(Activity r110, String r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b("auto_cert_androidx_core_app_ActivityCompat$Api32Impl_android_app_Activity_shouldShowRequestPermissionRationale");
            g06.a r102 = ApiHookConfig.f245611b.get(102609);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Boolean) r107.f474983b).booleanValue();
        L21:
            return r110.shouldShowRequestPermissionRationale(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
            return androidx_core_app_ActivityCompat$Api32Impl_android_app_Activity_shouldShowRequestPermissionRationale(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r100, String[] r101, int[] r102);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface PermissionCompatDelegate {
        boolean onActivityResult(Activity r100, int r101, int r102, Intent r103);

        boolean requestPermissions(Activity r100, String[] r101, int r102);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        public static /* synthetic */ void a(android.app.SharedElementCallback.OnSharedElementsReadyListener r100) {
            lambda$onSharedElementsArrived$0(r100);
        }

        public SharedElementCallback21Impl(SharedElementCallback r100) {
            this.mCallback = r100;
        }

        private static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r100) {
            Api23Impl.onSharedElementsReady(r100);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r100) {
            this.mCallback.onRejectSharedElements(r100);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r100, Parcelable r101) {
            return this.mCallback.onCreateSnapshotView(r100, r101);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r100, Map<String, View> r101) {
            this.mCallback.onMapSharedElements(r100, r101);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r100, Matrix r101, RectF r102) {
            return this.mCallback.onCaptureSharedElementSnapshot(r100, r101, r102);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r100, List<View> r101, List<View> r102) {
            this.mCallback.onSharedElementEnd(r100, r101, r102);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r100, List<View> r101, List<View> r102) {
            this.mCallback.onSharedElementStart(r100, r101, r102);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> r100, List<View> r101, final android.app.SharedElementCallback.OnSharedElementsReadyListener r102) {
            this.mCallback.onSharedElementsArrived(r100, r101, new b(r102));
        }
    }

    public static /* synthetic */ void a(Activity r100) {
        lambda$recreate$0(r100);
    }

    public ActivityCompat() {
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static void finishAffinity(Activity r100) {
        r100.finishAffinity();
    }

    public static void finishAfterTransition(Activity r100) {
        Api21Impl.finishAfterTransition(r100);
    }

    public static Uri getReferrer(Activity r100) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Intent r101 = r100.getIntent();
        Uri r102 = (Uri) r101.getParcelableExtra("android.intent.extra.REFERRER");
        if (r102 == null) goto L9;
        return r102;
    L9:
        String r103 = r101.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (r103 != null) goto L12;
        return null;
    L12:
        return UriProtector.parse(r103);
    L5:
        return Api22Impl.getReferrer(r100);
    }

    public static boolean invalidateOptionsMenu(Activity r100) {
        r100.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(Activity r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r100);
    L7:
        if (r101 != 30) goto L16;
        if (Api30Impl.getDisplay(r100) != null) goto L11;
    L13:
        return false;
    L11:
        if (Api30Impl.getDisplay(r100).getDisplayId() == 0) goto L13;
        return true;
    L16:
        if (r101 == 29) goto L18;
        return false;
    L18:
        if (r100.getWindowManager().getDefaultDisplay() != null) goto L20;
    L22:
        return false;
    L20:
        if (r100.getWindowManager().getDefaultDisplay().getDisplayId() == 0) goto L22;
        return true;
    }

    private static /* synthetic */ void lambda$recreate$0(Activity r100) {
        if (r100.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r100) == true) goto L9;
        r100.recreate();
        return;
    }

    public static void postponeEnterTransition(Activity r100) {
        Api21Impl.postponeEnterTransition(r100);
    }

    public static void recreate(final Activity r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r100.recreate();
        return;
    L5:
        new Handler(r100.getMainLooper()).post(new a(r100));
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate r100) {
        sDelegate = r100;
    }

    public static void startPostponedEnterTransition(Activity r100) {
        Api21Impl.startPostponedEnterTransition(r100);
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity r100, DragEvent r101) {
        return DragAndDropPermissionsCompat.request(r100, r101);
    }

    public static <T extends View> T requireViewById(Activity r100, int r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r102 = (T) r100.findViewById(r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    L5:
        return (T) Api28Impl.requireViewById(r100, r101);
    }

    public static void setEnterSharedElementCallback(Activity r100, SharedElementCallback r101) {
        if (r101 == null) goto L4;
        SharedElementCallback21Impl r102 = new SharedElementCallback21Impl(r101);
    L5:
        Api21Impl.setEnterSharedElementCallback(r100, r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static void setExitSharedElementCallback(Activity r100, SharedElementCallback r101) {
        if (r101 == null) goto L4;
        SharedElementCallback21Impl r102 = new SharedElementCallback21Impl(r101);
    L5:
        Api21Impl.setExitSharedElementCallback(r100, r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 33) goto L8;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r101) == false) goto L8;
        return false;
    L8:
        if (r102 < 32) goto L12;
        return Api32Impl.shouldShowRequestPermissionRationale(r100, r101);
    L12:
        if (r102 != 31) goto L16;
        return Api31Impl.shouldShowRequestPermissionRationale(r100, r101);
    L16:
        if (r102 >= 23) goto L18;
        return false;
    L18:
        return Api23Impl.shouldShowRequestPermissionRationale(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(final Activity r100, String[] r101, final int r102) {
        PermissionCompatDelegate r103 = sDelegate;
        if (r103 != null) goto L5;
    L7:
        HashSet r104 = new HashSet();
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r106 >= r101.length) goto L20;
        if (TextUtils.isEmpty(r101[r106]) == true) goto L19;
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        if (TextUtils.equals(r101[r106], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r104.add(Integer.valueOf(r106));
    L17:
        r106 = r106 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r101) + " must not contain null or empty values");
    L20:
        int r107 = r104.size();
        if (r107 <= 0) goto L23;
        final String[] r108 = new String[r101.length - r107];
    L24:
        if (r107 <= 0) goto L36;
        if (r107 != r101.length) goto L28;
        return;
    L28:
        int r109 = 0;
    L30:
        if (r105 >= r101.length) goto L36;
        if (r104.contains(Integer.valueOf(r105)) == true) goto L34;
        r108[r109] = r101[r105];
        r109 = r109 + 1;
    L34:
        r105 = r105 + 1;
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if ((r100 instanceof RequestPermissionsRequestCodeValidator) == false) goto L40;
        ((RequestPermissionsRequestCodeValidator) r100).validateRequestPermissionsRequestCode(r102);
    L40:
        Api23Impl.requestPermissions(r100, r101, r102);
        return;
    L42:
        if ((r100 instanceof OnRequestPermissionsResultCallback) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r108, r100, r102));
        return;
    L54:
        return;
    L23:
        r108 = r101;
        goto L24
    L5:
        if (r103.requestPermissions(r100, r101, r102) == false) goto L7;
    }

    public static void setLocusContext(Activity r100, LocusIdCompat r101, Bundle r102) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setLocusContext(r100, r101, r102);
        return;
    }

    public static void startActivityForResult(Activity r100, Intent r101, int r102, Bundle r103) {
        r100.startActivityForResult(r101, r102, r103);
    }

    public static void startIntentSenderForResult(Activity r100, IntentSender r101, int r102, Intent r103, int r104, int r105, int r106, Bundle r107) throws IntentSender.SendIntentException {
        r100.startIntentSenderForResult(r101, r102, r103, r104, r105, r106, r107);
    }
}
