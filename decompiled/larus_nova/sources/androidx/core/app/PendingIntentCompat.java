package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes17.dex */
public final class PendingIntentCompat {

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void send(PendingIntent r100, Context r101, int r102, Intent r103, PendingIntent.OnFinished r104, Handler r105, String r106, Bundle r107) throws PendingIntent.CanceledException {
            r100.send(r101, r102, r103, r104, r105, r106, r107);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context r100, int r101, Intent r102, int r103) {
            return PendingIntent.getForegroundService(r100, r101, r102, r103);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable {
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete;
        private boolean mSuccess;

        public static /* synthetic */ void a(GatedCallback r100, PendingIntent r101, Intent r102, int r103, String r104, Bundle r105) {
            r100.onSendFinished(r101, r102, r103, r104, r105);
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.mSuccess == true) goto L5;
            this.mCallback = null;
        L5:
            this.mComplete.countDown();
        }

        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback != null) goto L7;
            return null;
        L7:
            return new c(this);
        }

        public GatedCallback(PendingIntent.OnFinished r100) {
            this.mComplete = new CountDownLatch(1);
            this.mCallback = r100;
            this.mSuccess = false;
        }

        private void onSendFinished(PendingIntent r100, Intent r101, int r110, String r111, Bundle r112) {
            boolean r102 = false;
        L15:
            this.mComplete.await();     // Catch: Throwable -> L10 InterruptedException -> L14
        L4:
            if (r102 == false) goto L6;
            ThreadMethodProxy.currentThread().interrupt();
        L6:
            PendingIntent.OnFinished r103 = this.mCallback;
            if (r103 == null) goto L18;
            r103.onSendFinished(r100, r101, r110, r111, r112);
            this.mCallback = null;
            return;
        L18:
            return;
        L14:
            r102 = true;
        L10:
            th = move-exception;
            if (r102 == false) goto L13;
            ThreadMethodProxy.currentThread().interrupt();
        L13:
            throw th;
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean r100, int r101) {
        if (r100 == false) goto L7;
        if (Build.VERSION.SDK_INT < 31) goto L11;
        int r102 = 33554432;
    L10:
        return r101 | r102;
    L11:
        return r101;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r102 = 67108864;
        goto L10
    L12:
        return r101;
    }

    public static void send(PendingIntent r100, int r101, PendingIntent.OnFinished r102, Handler r103) throws PendingIntent.CanceledException {
        GatedCallback r104 = new GatedCallback(r102);
        r100.send(r101, r104.getCallback(), r103);     // Catch: Throwable -> L6
        r104.complete();     // Catch: Throwable -> L6
        r104.close();
        return;
    L6:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static PendingIntent getActivities(Context r100, int r101, Intent[] r102, int r103, boolean r104) {
        return PendingIntent.getActivities(r100, r101, r102, addMutabilityFlags(r104, r103));
    }

    public static PendingIntent getActivity(Context r100, int r101, Intent r102, int r103, boolean r104) {
        return PendingIntent.getActivity(r100, r101, r102, addMutabilityFlags(r104, r103));
    }

    public static PendingIntent getBroadcast(Context r100, int r101, Intent r102, int r103, boolean r104) {
        return PendingIntent.getBroadcast(r100, r101, r102, addMutabilityFlags(r104, r103));
    }

    public static PendingIntent getForegroundService(Context r100, int r101, Intent r102, int r103, boolean r104) {
        return Api26Impl.getForegroundService(r100, r101, r102, addMutabilityFlags(r104, r103));
    }

    public static PendingIntent getService(Context r100, int r101, Intent r102, int r103, boolean r104) {
        return PendingIntent.getService(r100, r101, r102, addMutabilityFlags(r104, r103));
    }

    public static PendingIntent getActivities(Context r100, int r101, Intent[] r102, int r103, Bundle r104, boolean r105) {
        return PendingIntent.getActivities(r100, r101, r102, addMutabilityFlags(r105, r103), r104);
    }

    public static PendingIntent getActivity(Context r100, int r101, Intent r102, int r103, Bundle r104, boolean r105) {
        return PendingIntent.getActivity(r100, r101, r102, addMutabilityFlags(r105, r103), r104);
    }

    public static void send(PendingIntent r100, Context r101, int r110, Intent r111, PendingIntent.OnFinished r112, Handler r113) throws PendingIntent.CanceledException {
        send(r100, r101, r110, r111, r112, r113, null, null);
    }

    public static void send(PendingIntent r100, Context r101, int r110, Intent r111, PendingIntent.OnFinished r112, Handler r113, String r114, Bundle r115) throws PendingIntent.CanceledException {
        GatedCallback r102 = new GatedCallback(r112);
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.send(r100, r101, r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L10
    L7:
        r102.complete();     // Catch: Throwable -> L10
        r102.close();
        return;
    L6:
        r100.send(r101, r110, r111, r102.getCallback(), r113, r114);     // Catch: Throwable -> L10
        goto L7
    }
}
