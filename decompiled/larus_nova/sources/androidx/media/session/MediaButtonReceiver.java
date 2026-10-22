package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            new MediaControllerCompat(this.mContext, this.mMediaBrowser.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));     // Catch: RemoteException -> L5
        L3:
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(MediaBrowserCompat r100) {
            this.mMediaBrowser = r100;
        }

        public MediaButtonConnectionCallback(Context r100, Intent r101, BroadcastReceiver.PendingResult r102) {
            this.mContext = r100;
            this.mIntent = r101;
            this.mPendingResult = r102;
        }
    }

    public MediaButtonReceiver() {
    }

    public static ComponentName getMediaButtonReceiverComponent(Context r100) {
        Intent r101 = new Intent("android.intent.action.MEDIA_BUTTON");
        r101.setPackage(r100.getPackageName());
        List<ResolveInfo> r102 = r100.getPackageManager().queryBroadcastReceivers(r101, 0);
        if (r102.size() != 1) goto L6;
        ActivityInfo r103 = ((ResolveInfo) ListProtector.get(r102, 0)).activityInfo;
        return new ComponentName(r103.packageName, r103.name);
    L6:
        r102.size();
        return null;
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r100, long r101) {
        ComponentName r102 = getMediaButtonReceiverComponent(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return buildMediaButtonPendingIntent(r100, r102, r101);
    }

    private static ComponentName getServiceComponentByAction(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();
        Intent r103 = new Intent(r101);
        r103.setPackage(r100.getPackageName());
        List<ResolveInfo> r104 = r102.queryIntentServices(r103, 0);
        if (r104.size() != 1) goto L7;
        ServiceInfo r105 = ((ResolveInfo) ListProtector.get(r104, 0)).serviceInfo;
        return new ComponentName(r105.packageName, r105.name);
    L7:
        if (r104.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r101 + ", found " + r104.size());
    }

    public static KeyEvent handleIntent(MediaSessionCompat r100, Intent r101) {
        if (r100 == null) goto L11;
        if (r101 != null) goto L5;
        return null;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r101.getAction()) == true) goto L7;
        return null;
    L7:
        if (r101.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L15;
        KeyEvent r102 = (KeyEvent) r101.getParcelableExtra("android.intent.extra.KEY_EVENT");
        r100.getController().dispatchMediaButtonEvent(r102);
        return r102;
    L15:
        return null;
    L11:
        return null;
    }

    private static void startForegroundService(Context r100, Intent r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r100.startForegroundService(r101);
        return;
    L5:
        r100.startService(r101);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
    L18:
        Objects.toString(r101);
        return;
    L4:
        if ("android.intent.action.MEDIA_BUTTON".equals(r101.getAction()) == false) goto L18;
        if (r101.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L18;
        ComponentName r102 = getServiceComponentByAction(r100, "android.intent.action.MEDIA_BUTTON");
        if (r102 == null) goto L12;
        r101.setComponent(r102);
        startForegroundService(r100, r101);
        return;
    L12:
        ComponentName r103 = getServiceComponentByAction(r100, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r103 == null) goto L17;
        BroadcastReceiver.PendingResult r104 = goAsync();
        Context r105 = r100.getApplicationContext();
        MediaButtonConnectionCallback r106 = new MediaButtonConnectionCallback(r105, r101, r104);
        MediaBrowserCompat r107 = new MediaBrowserCompat(r105, r103, r106, null);
        r106.setMediaBrowser(r107);
        r107.connect();
        return;
    L17:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r100, ComponentName r101, long r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        int r103 = PlaybackStateCompat.toKeyCode(r102);
        if (r103 == 0) goto L8;
        Intent r104 = new Intent("android.intent.action.MEDIA_BUTTON");
        r104.setComponent(r101);
        r104.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, r103));
        return PendingIntent.getBroadcast(r100, r103, r104, 0);
    L8:
        return null;
    }
}
