package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityCompat extends ContextCompat {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PermissionCompatDelegate f2432c;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity r10, @IntRange(from = 0) int r11, int r12, @Nullable Intent r13);

        boolean requestPermissions(@NonNull Activity r10, @NonNull String[] r11, @IntRange(from = 0) int r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r10);
    }

    public static class a {
        @DoNotInline
        public static void a(Activity r10) {
            r10.finishAffinity();
        }

        @DoNotInline
        public static void b(Activity r10, Intent r11, int r12, Bundle r13) {
            r10.startActivityForResult(r11, r12, r13);
        }

        @DoNotInline
        public static void c(Activity r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) throws IntentSender.SendIntentException {
            r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(Activity r10) {
            r10.finishAfterTransition();
        }

        @DoNotInline
        public static void b(Activity r10) {
            r10.postponeEnterTransition();
        }

        @DoNotInline
        public static void c(Activity r10, android.app.SharedElementCallback r11) {
            r10.setEnterSharedElementCallback(r11);
        }

        @DoNotInline
        public static void d(Activity r10, android.app.SharedElementCallback r11) {
            r10.setExitSharedElementCallback(r11);
        }

        @DoNotInline
        public static void e(Activity r10) {
            r10.startPostponedEnterTransition();
        }
    }

    public static class c {
        @DoNotInline
        public static void a(Object r10) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r10).onSharedElementsReady();
        }

        @DoNotInline
        public static void b(Activity r10, String[] r11, int r12) {
            r10.requestPermissions(r11, r12);
        }

        @DoNotInline
        public static boolean c(Activity r10, String r11) {
            return r10.shouldShowRequestPermissionRationale(r11);
        }
    }

    public static class d extends android.app.SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedElementCallback f2433a;

        public d(SharedElementCallback r10) {
            this.f2433a = r10;
        }

        public static /* synthetic */ void a(android.app.SharedElementCallback.OnSharedElementsReadyListener r10) {
            lambda$onSharedElementsArrived$0(r10);
        }

        private static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r10) {
            c.a(r10);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r10, Matrix r11, RectF r12) {
            return this.f2433a.b(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r10, Parcelable r11) {
            return this.f2433a.c(r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List r10, Map r11) {
            this.f2433a.d(r10, r11);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List r10) {
            this.f2433a.e(r10);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List r10, List r11, List r12) {
            this.f2433a.f(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List r10, List r11, List r12) {
            this.f2433a.g(r10, r11, r12);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List r10, List r11, final android.app.SharedElementCallback.OnSharedElementsReadyListener r12) {
            this.f2433a.h(r10, r11, new androidx.core.app.a(r12));
        }
    }

    public static void m(Activity r10) {
        a.a(r10);
    }

    public static void n(Activity r10) {
        b.a(r10);
    }

    public static void o(Activity r10) {
        b.b(r10);
    }

    public static void p(Activity r10) {
        r10.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(Activity r10, String[] r11, int r12) {
        PermissionCompatDelegate r13 = f2432c;
        if (r13 != null) goto L5;
    L7:
        HashSet r14 = new HashSet();
        int r15 = 0;
        int r16 = 0;
    L9:
        if (r16 >= r11.length) goto L20;
        if (TextUtils.isEmpty(r11[r16]) == true) goto L19;
        if (BuildCompat.c() == true) goto L17;
        if (TextUtils.equals(r11[r16], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r14.add(Integer.valueOf(r16));
    L17:
        r16 = r16 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r11) + " must not contain null or empty values");
    L20:
        int r17 = r14.size();
        if (r17 <= 0) goto L23;
        String[] r18 = new String[r11.length - r17];
    L24:
        if (r17 <= 0) goto L36;
        if (r17 != r11.length) goto L28;
        return;
    L28:
        int r19 = 0;
    L30:
        if (r15 >= r11.length) goto L36;
        if (r14.contains(Integer.valueOf(r15)) == true) goto L34;
        r18[r19] = r11[r15];
        r19 = r19 + 1;
    L34:
        r15 = r15 + 1;
    L36:
        if ((r10 instanceof RequestPermissionsRequestCodeValidator) == false) goto L38;
        ((RequestPermissionsRequestCodeValidator) r10).validateRequestPermissionsRequestCode(r12);
    L38:
        c.b(r10, r11, r12);
        return;
    L23:
        r18 = r11;
        goto L24
    L5:
        if (r13.requestPermissions(r10, r11, r12) == false) goto L7;
    }

    public static void r(Activity r10, SharedElementCallback r11) {
        if (r11 == null) goto L4;
        d r12 = new d(r11);
    L5:
        b.c(r10, r12);
        return;
    L4:
        r12 = null;
        goto L5
    }

    public static void s(Activity r10, SharedElementCallback r11) {
        if (r11 == null) goto L4;
        d r12 = new d(r11);
    L5:
        b.d(r10, r12);
        return;
    L4:
        r12 = null;
        goto L5
    }

    public static boolean t(Activity r10, String r11) {
        if (BuildCompat.c() == true) goto L9;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r11) == false) goto L9;
        return false;
    L9:
        return c.c(r10, r11);
    }

    public static void u(Activity r10, Intent r11, int r12, Bundle r13) {
        a.b(r10, r11, r12, r13);
    }

    public static void v(Activity r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        a.c(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static void w(Activity r10) {
        b.e(r10);
    }
}
