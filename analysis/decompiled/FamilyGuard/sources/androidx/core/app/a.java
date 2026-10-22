package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    static class C0114a {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class b {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i5) {
            activity.requestPermissions(strArr, i5);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i5);
    }

    public static void m(Activity activity) {
        activity.finishAffinity();
    }

    public static void n(Activity activity) {
        C0114a.a(activity);
    }

    public static void o(Activity activity) {
        C0114a.b(activity);
    }

    public static void p(Activity activity) {
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(Activity activity, String[] strArr, int i5) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < strArr.length; i7++) {
                if (!hashSet.contains(Integer.valueOf(i7))) {
                    strArr2[i6] = strArr[i7];
                    i6++;
                }
            }
        }
        if (activity instanceof c) {
            ((c) activity).validateRequestPermissionsRequestCode(i5);
        }
        b.b(activity, strArr, i5);
    }

    public static void r(Activity activity, s sVar) {
        C0114a.c(activity, null);
    }

    public static void s(Activity activity, s sVar) {
        C0114a.d(activity, null);
    }

    public static void t(Activity activity, Intent intent, int i5, Bundle bundle) {
        activity.startActivityForResult(intent, i5, bundle);
    }

    public static void u(Activity activity, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public static void v(Activity activity) {
        C0114a.e(activity);
    }
}
