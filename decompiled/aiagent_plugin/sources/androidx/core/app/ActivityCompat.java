package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends androidx.core.content.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f1027a;

    static class SharedElementCallback21Impl extends SharedElementCallback {
        private final q mCallback;

        SharedElementCallback21Impl(q r1) {
            this.mCallback = r1;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r3, List<View> r4, List<View> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.mCallback.a(r6, r7, r8);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r3, List<View> r4, List<View> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.mCallback.b(r6, r7, r8);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r3) {
            List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.mCallback.a(r4);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r3, Map<String, View> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            Map<String, View> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.mCallback.a(r5, r6);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r1, Matrix r2, RectF r3) {
            return this.mCallback.a(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r3, Parcelable r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
            return this.mCallback.a(r5, r6);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> r3, List<View> r4, SharedElementCallback.OnSharedElementsReadyListener r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            final SharedElementCallback.OnSharedElementsReadyListener r8 = (SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.wrapperContextForParams(r5, SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.aiagent.plugin");
            this.mCallback.a(r6, r7, new $$Lambda$ActivityCompat$SharedElementCallback21Impl$XeJWsqWJ29Zf39M5biMUAaMDlMw(r8));
        }

        static /* synthetic */ void lambda$onSharedElementsArrived$0(SharedElementCallback.OnSharedElementsReadyListener r2) {
            c.a((SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.aiagent.plugin"));
        }
    }

    static class a {
        static void startActivityForResult(Activity r2, Intent r3, int r4, Bundle r5) {
            ZeusTransformUtils.startActivityForResult((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), r3, r4, r5, "com.obric.aiagent.plugin");
        }

        static void a(Activity r8, IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin")).startIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
        }

        static void a(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).finishAffinity();
        }
    }

    static class b {
        static void a(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).finishAfterTransition();
        }

        static void a(Activity r2, SharedElementCallback r3) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).setEnterSharedElementCallback(r3);
        }

        static void b(Activity r2, SharedElementCallback r3) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).setExitSharedElementCallback(r3);
        }

        static void b(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).postponeEnterTransition();
        }

        static void c(Activity r2) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).startPostponedEnterTransition();
        }
    }

    static class c {
        static void requestPermissions(Activity r2, String[] r3, int r4) {
            ZeusTransformUtils.requestPermissions((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), r3, r4, "com.obric.aiagent.plugin");
        }

        static boolean a(Activity r2, String r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).shouldShowRequestPermissionRationale(r3);
        }

        static void a(Object r2) {
            ((SharedElementCallback.OnSharedElementsReadyListener) ZeusTransformUtils.preCheckCast(r2, SharedElementCallback.OnSharedElementsReadyListener.class, "com.obric.aiagent.plugin")).onSharedElementsReady();
        }
    }

    static class d {
        static boolean a(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).isLaunchedFromBubble();
        }

        static boolean a(Activity r8, String r9) {
            Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
            PackageManager r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();     // Catch: Throwable -> L5
            return ((Boolean) ZeusTransformUtils.preCheckCast(PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(r0, new Object[]{r9}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L6:
            return r10.shouldShowRequestPermissionRationale(r9);
        }
    }

    static class e {
        static boolean a(Activity r2, String r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).shouldShowRequestPermissionRationale(r3);
        }
    }

    public interface f {
        void onRequestPermissionsResult(int r1, String[] r2, int[] r3);
    }

    public interface g {
        boolean requestPermissions(Activity r1, String[] r2, int r3);
    }

    public interface h {
        void validateRequestPermissionsRequestCode(int r1);
    }

    public static /* synthetic */ void lambda$lgzYFglmR9SCN4Vnj95IIRcGowA(Activity r0) {
        f(r0);
    }

    public static void startActivityForResult(Activity r3, Intent r4, int r5, Bundle r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        a.startActivityForResult(r7, r4, r5, r6);
        return;
    L5:
        ZeusTransformUtils.startActivityForResult(r7, r4, r5, "com.obric.aiagent.plugin");
    }

    public static void a(Activity r8, IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        a.a(r0, r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        r0.startIntentSenderForResult(r9, r10, r11, r12, r13, r14);
    }

    public static void a(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        a.a(r3);
        return;
    L5:
        r3.finish();
    }

    public static void b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        b.a(r3);
        return;
    L5:
        r3.finish();
    }

    public static void a(Activity r2, q r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        b.a(r4, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void b(Activity r2, q r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        b.b(r4, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void c(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.b(r3);
        return;
    }

    public static void d(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.c(r3);
        return;
    }

    public static void requestPermissions(Activity r7, String[] r8, final int r9) {
        final Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.aiagent.plugin");
        g r0 = f1027a;
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r8.length) goto L20;
        if (TextUtils.isEmpty(r8[r3]) == true) goto L19;
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        if (TextUtils.equals(r8[r3], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r1.add(Integer.valueOf(r3));
    L17:
        r3 = r3 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r8) + " must not contain null or empty values");
    L20:
        int r4 = r1.size();
        if (r4 <= 0) goto L23;
        final String[] r5 = new String[r8.length - r4];
    L24:
        if (r4 <= 0) goto L36;
        if (r4 != r8.length) goto L28;
        return;
    L28:
        int r6 = 0;
    L30:
        if (r2 >= r8.length) goto L36;
        if (r1.contains(Integer.valueOf(r2)) == true) goto L34;
        r5[r6] = r8[r2];
        r6 = r6 + 1;
    L34:
        r2 = r2 + 1;
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if (ZeusTransformUtils.instanceOf(r10, h.class) == false) goto L40;
        ((h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin")).validateRequestPermissionsRequestCode(r9);
    L40:
        c.requestPermissions(r10, r8, r9);
        return;
    L42:
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r5, r10, r9));
        return;
    L54:
        return;
    L23:
        r5 = r8;
        goto L24
    L5:
        if (r0.requestPermissions(r10, r8, r9) == false) goto L7;
    }

    public static boolean a(Activity r3, String r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r4) == false) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 32) goto L12;
        return e.a(r5, r4);
    L12:
        if (Build.VERSION.SDK_INT != 31) goto L16;
        return d.a(r5, r4);
    L16:
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        return false;
    L18:
        return c.a(r5, r4);
    }

    public static void e(Activity r2) {
        final Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r3.recreate();
        return;
    L5:
        new Handler(r3.getMainLooper()).post(new $$Lambda$ActivityCompat$lgzYFglmR9SCN4Vnj95IIRcGowA(r3));
    }

    private static /* synthetic */ void f(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (r3.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.a(r3) == true) goto L9;
        r3.recreate();
        return;
    }
}
