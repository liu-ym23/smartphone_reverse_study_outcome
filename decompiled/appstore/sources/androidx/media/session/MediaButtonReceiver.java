package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    public static class a extends MediaBrowserCompat.ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Intent f3721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f3722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MediaBrowserCompat f3723d;

        public a(Context r10, Intent r11, BroadcastReceiver.PendingResult r12) {
            this.f3720a = r10;
            this.f3721b = r11;
            this.f3722c = r12;
        }

        public final void a() {
            this.f3723d.disconnect();
            this.f3722c.finish();
        }

        public void b(MediaBrowserCompat r10) {
            this.f3723d = r10;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            new MediaControllerCompat(this.f3720a, this.f3723d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f3721b.getParcelableExtra("android.intent.extra.KEY_EVENT"));     // Catch: RemoteException -> L4
        L6:
            a();
            return;
        L4:
            e = move-exception;
            Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            a();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            a();
        }
    }

    public MediaButtonReceiver() {
    }

    public static ComponentName a(Context r10) {
        Intent r11 = new Intent("android.intent.action.MEDIA_BUTTON");
        r11.setPackage(r10.getPackageName());
        List<ResolveInfo> r12 = r10.getPackageManager().queryBroadcastReceivers(r11, 0);
        if (r12.size() != 1) goto L7;
        ActivityInfo r13 = r12.get(0).activityInfo;
        return new ComponentName(r13.packageName, r13.name);
    L7:
        if (r12.size() <= 1) goto L11;
        Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    public static ComponentName b(Context r10, String r11) {
        PackageManager r12 = r10.getPackageManager();
        Intent r13 = new Intent(r11);
        r13.setPackage(r10.getPackageName());
        List<ResolveInfo> r14 = r12.queryIntentServices(r13, 0);
        if (r14.size() != 1) goto L7;
        ServiceInfo r15 = r14.get(0).serviceInfo;
        return new ComponentName(r15.packageName, r15.name);
    L7:
        if (r14.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r11 + ", found " + r14.size());
    }

    public static void c(Context r10, Intent r11) {
        r10.startForegroundService(r11);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 != null) goto L4;
    L18:
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + r11);
        return;
    L4:
        if ("android.intent.action.MEDIA_BUTTON".equals(r11.getAction()) == false) goto L18;
        if (r11.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L18;
        ComponentName r12 = b(r10, "android.intent.action.MEDIA_BUTTON");
        if (r12 == null) goto L12;
        r11.setComponent(r12);
        c(r10, r11);
        return;
    L12:
        ComponentName r13 = b(r10, "android.media.browse.MediaBrowserService");
        if (r13 == null) goto L17;
        BroadcastReceiver.PendingResult r14 = goAsync();
        Context r15 = r10.getApplicationContext();
        a r16 = new a(r15, r11, r14);
        MediaBrowserCompat r17 = new MediaBrowserCompat(r15, r13, r16, null);
        r16.b(r17);
        r17.connect();
        return;
    L17:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
