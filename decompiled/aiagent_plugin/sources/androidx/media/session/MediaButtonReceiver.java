package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends PluginBroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        MediaButtonConnectionCallback(Context r3, Intent r4, BroadcastReceiver.PendingResult r5) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.mIntent = r4;
            this.mPendingResult = r5;
        }

        void setMediaBrowser(MediaBrowserCompat r1) {
            this.mMediaBrowser = r1;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            new MediaControllerCompat(this.mContext, this.mMediaBrowser.c()).a((KeyEvent) ZeusTransformUtils.preCheckCast(this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"), KeyEvent.class, "com.obric.aiagent.plugin"));     // Catch: RemoteException -> L4
        L6:
            finish();
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_androidx_media_session_MediaButtonReceiver$MediaButtonConnectionCallback_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            finish();
        }

        private void finish() {
            this.mMediaBrowser.b();
            this.mPendingResult.finish();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_media_session_MediaButtonReceiver$MediaButtonConnectionCallback_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public void onReceive(Context r4, Intent r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L19:
        a(TAG, "Ignore unsupported intent: " + r5);
        return;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r5.getAction()) == false) goto L19;
        if (r5.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L19;
        ComponentName r0 = a(r6, "android.intent.action.MEDIA_BUTTON");
        if (r0 == null) goto L13;
        r5.setComponent(r0);
        a(r6, r5);
        return;
    L13:
        ComponentName r1 = a(r6, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r1 == null) goto L18;
        BroadcastReceiver.PendingResult r3 = goAsync();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        MediaButtonConnectionCallback r2 = new MediaButtonConnectionCallback(r7, r5, r3);
        MediaBrowserCompat r8 = new MediaBrowserCompat(r7, r1, r2, null);
        r2.setMediaBrowser(r8);
        r8.a();
        return;
    L18:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    private static void a(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ZeusTransformUtils.startService(r5, r4, "com.obric.aiagent.plugin");
        return;
    L5:
        ZeusTransformUtils.startService(r5, r4, "com.obric.aiagent.plugin");
    }

    private static ComponentName a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        PackageManager r0 = r6.getPackageManager();
        Intent r2 = new Intent(r5);
        r2.setPackage(r6.getPackageName());
        List<ResolveInfo> r1 = r0.queryIntentServices(r2, 0);
        if (r1.size() != 1) goto L7;
        ResolveInfo r7 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r1.get(0), ResolveInfo.class, "com.obric.aiagent.plugin");
        return new ComponentName(r7.serviceInfo.packageName, r7.serviceInfo.name);
    L7:
        if (r1.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r5 + ", found " + r1.size());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
