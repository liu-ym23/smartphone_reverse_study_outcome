package com.bytedance.applet.audio.background;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import aw3.h0;
import aw3.i0;
import aw3.j0;
import aw3.k0;
import aw3.l;
import aw3.o;
import aw3.p;
import aw3.q0;
import aw3.r;
import aw3.w;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0004MNOPB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u0014J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J\u0014\u00103\u001a\u000204*\u0002042\u0006\u00101\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002JZ\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u00192!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020!092%\b\u0002\u0010=\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020!\u0018\u000109H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020!H\u0002J\"\u0010@\u001a\u00020A2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0016J\f\u0010D\u001a\u00020\u0019*\u000202H\u0002J\f\u0010E\u001a\u00020\u0019*\u000202H\u0002J\f\u0010F\u001a\u00020A*\u000202H\u0002J\f\u0010G\u001a\u00020H*\u000202H\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService$BackgroundAudioServiceBinder;", "mediaSessionCallback", "Lcom/bytedance/applet/audio/background/AppletBackgroundAudioMediaSessionService$BackgroundAudioMediaSessionCallback;", "mainHandler", "Landroid/os/Handler;", "delayAutoUpdateTask", "Ljava/lang/Runnable;", "playPendingIntent", "Landroid/app/PendingIntent;", "pausePendingIntent", "previousPendingIntent", "nextPendingIntent", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "isStopped", "", "isForeground", "albumArt", "Landroid/graphics/Bitmap;", "albumArtUrl", "", "emptyAlbumArt", "downloadingAlbumArtUrl", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "dismissMediaNotification", "updateMediaMetadata", "updatePlaybackState", "isAuto", "generateActionPendingIntent", "action", "initMediaSession", "releaseMediaSession", "updateNotification", "buildNotification", "Landroid/app/Notification;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "state", "Lcom/bytedance/applet/audio/background/BackgroundAudioState;", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "updateAlbumArtIfNeeded", "downloadAlbumArt", "url", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "onFailure", "error", "createNotificationChannel", "onStartCommand", "", "flags", "startId", "notificationTitle", "notificationArtist", "toPlaybackStateCompat", "playbackSpeedForSystem", "", "secondsToMillis", "", "seconds", "", "Companion", "BackgroundAudioServiceBinder", "MediaSessionManageCallback", "BackgroundAudioMediaSessionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBackgroundAudioMediaSessionService extends Service {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f191424p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f191425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f191426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f191427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f191428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PendingIntent f191429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f191430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PendingIntent f191431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PendingIntent f191432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaSessionCompat f191433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f191434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f191435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f191436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f191437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f191438n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f191439o;

    public final class a extends MediaSessionCompat.Callback {
        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onPause() {
            super.onPause();
            w r100 = w.f16506a;
            String r101 = w.f16516k;
            if (r101 != null) goto L5;
            boolean r102 = false;
        L6:
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session pause callback. dispatched: " + r102);
            return;
        L5:
            w.z(new o(r101));
            r102 = true;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onPlay() {
            super.onPlay();
            w r100 = w.f16506a;
            String r101 = w.f16516k;
            if (r101 != null) goto L5;
            boolean r102 = false;
        L6:
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session play callback. dispatched: " + r102);
            return;
        L5:
            w.z(new p(r101));
            r102 = true;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSkipToNext() {
            super.onSkipToNext();
            w r100 = w.f16506a;
            final String r101 = w.f16516k;
            if (r101 != null) goto L5;
            boolean r102 = false;
        L6:
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session next callback. dispatched: " + r102);
            return;
        L5:
            w.z(new aw3.a(r101));
            r102 = true;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSkipToPrevious() {
            super.onSkipToPrevious();
            w r100 = w.f16506a;
            final String r101 = w.f16516k;
            if (r101 != null) goto L5;
            boolean r102 = false;
        L6:
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session previous callback. dispatched: " + r102);
            return;
        L5:
            w.z(new r(r101));
            r102 = true;
            goto L6
        }

        public a() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public final void onSeekTo(long r100) {
            super.onSeekTo(r100);
            w r101 = w.f16506a;
            final String r102 = w.f16516k;
            if (r102 != null) goto L5;
            boolean r103 = false;
        L6:
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session seek callback. dispatched: " + r103 + ", positionMs: " + r100);
            return;
        L5:
            final double r104 = RangesKt.coerceAtLeast(r100, 0) / 1000.0d;
            w.z(new l(r104, r102));
            r103 = true;
            goto L6
        }
    }

    public final class b extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppletBackgroundAudioMediaSessionService f191440a;

        public b(AppletBackgroundAudioMediaSessionService r100) {
            this.f191440a = r100;
        }
    }

    public static final class c {
    }

    public final class d implements pk9.a.InterfaceC7208a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppletBackgroundAudioMediaSessionService f191441a;

        @Override // pk9.a.InterfaceC7208a
        public final void a() {
            this.f191441a.c();
            this.f191441a.b();
            this.f191441a.f191426b.onPause();
            FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session deactivated by global manager");
        }

        public d(AppletBackgroundAudioMediaSessionService r100) {
            this.f191441a = r100;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191442a = null;

        static {
            int[] r100 = new int[BackgroundAudioPlaybackState.values().length];
            r100[BackgroundAudioPlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[BackgroundAudioPlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[BackgroundAudioPlaybackState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[BackgroundAudioPlaybackState.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f191442a = r100;
        }
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f191427c.removeCallbacks(this.f191428d);     // Catch: Throwable -> L10
        MediaSessionCompat r100 = this.f191433i;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        r100.setActive(false);     // Catch: Throwable -> L10
        r100.release();     // Catch: Throwable -> L10
        pk9.a r101 = pk9.a.f529679a;     // Catch: Throwable -> L10
        pk9.a.f529680b.remove(r100);     // Catch: Throwable -> L10
        this.f191433i = null;     // Catch: Throwable -> L10
        this.f191436l = null;     // Catch: Throwable -> L10
        this.f191437m = null;     // Catch: Throwable -> L10
        this.f191439o = null;     // Catch: Throwable -> L10
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session released");     // Catch: Throwable -> L10
    L7:
        this.f191438n = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f191434j == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f191435k == false) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        stopForeground(1);     // Catch: Throwable -> L17
    L12:
        this.f191435k = false;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        stopForeground(true);     // Catch: Throwable -> L17
        goto L12
    }

    public final synchronized boolean l() {
        monitor-enter(this);
        boolean r100 = m(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final void stopService() {
        this.f191434j = true;
        c();
        b();
        stopSelf();
    }

    public final boolean e() {
        if (this.f191434j == false) goto L5;
        return false;
    L5:
        w r100 = w.f16506a;
        if (w.o() != null) goto L8;
        return false;
    L8:
        MediaSessionCompat r101 = new MediaSessionCompat(AppHost.f326268a.getApplication(), "AppletBackgroundAudioMediaSessionService");
        r101.setCallback(this.f191426b);
        r101.setFlags(3);
        Bundle r102 = new Bundle();
        r102.putBoolean("HMOS_MEDIA_CONTROLLER", true);
        r101.setExtras(r102);
        this.f191433i = r101;
        if (k() == true) goto L13;
        this.f191433i = null;
        return false;
    L13:
        if (l() == true) goto L16;
        this.f191433i = null;
        return false;
    L16:
        pk9.a r103 = pk9.a.f529679a;
        pk9.a.b(r101, new d(this));
        r103.a(r101);
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media session initialized");
        return true;
    }

    public final synchronized void i() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.f191435k == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.f191434j == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        MediaSessionCompat r100 = this.f191433i;     // Catch: Throwable -> L36
        if (r100 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        w r101 = w.f16506a;     // Catch: Throwable -> L36
        q0 r102 = w.o();     // Catch: Throwable -> L36
        if (r102 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        boolean r104 = false;
        if (r103 < 26) goto L24;
        NotificationChannel r105 = new NotificationChannel("background_audio_channel", "background_audio", 2);     // Catch: Throwable -> L36
        r105.enableVibration(false);     // Catch: Throwable -> L36
        r105.setSound(null, null);     // Catch: Throwable -> L36
        NotificationManagerCompat.from(AppHost.f326268a.getApplication()).createNotificationChannel(r105);     // Catch: Throwable -> L36
    L24:
        Notification r106 = a(r100, r102);     // Catch: Throwable -> L36
        if (r103 < 34) goto L28;
        startForeground(109, r106, 2);     // Catch: Exception -> L31 Throwable -> L36
    L29:
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "foreground notification started. state: " + r102.b());     // Catch: Exception -> L31 Throwable -> L36
        r104 = true;
    L33:
        this.f191435k = r104;     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L28:
        startForeground(109, r106);     // Catch: Exception -> L31 Throwable -> L36
    L31:
        e = move-exception;
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionService", "foreground notification start failed", e);     // Catch: Throwable -> L36
        goto L33
    }

    public final synchronized boolean k() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        boolean r100 = false;
        if (this.f191434j == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        MediaSessionCompat r101 = this.f191433i;     // Catch: Throwable -> L32
        if (r101 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        w r102 = w.f16506a;     // Catch: Throwable -> L32
        q0 r103 = w.o();     // Catch: Throwable -> L32
        if (r103 != null) goto L17;
        monitor-exit(this);
        return false;
    L17:
        j(r103);     // Catch: Throwable -> L32
        MediaMetadataCompat.Builder r104 = new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_TITLE, g(r103)).putString(MediaMetadataCompat.METADATA_KEY_ARTIST, f(r103));     // Catch: Throwable -> L32
        String r105 = r103.f16481c;     // Catch: Throwable -> L32
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        MediaMetadataCompat.Builder r106 = r104.putString(MediaMetadataCompat.METADATA_KEY_ALBUM, r105).putLong(MediaMetadataCompat.METADATA_KEY_DURATION, h(r103.f16487i));     // Catch: Throwable -> L32
        Bitmap r107 = this.f191436l;     // Catch: Throwable -> L32
        if (r107 != null) goto L25;
        r107 = this.f191438n;     // Catch: Throwable -> L32
        if (r107 != null) goto L25;
        r107 = BitmapFactory.decodeResource(getResources(), R.drawable.larus_applet_background_audio_album_art_placeholder);     // Catch: Throwable -> L32
        this.f191438n = r107;     // Catch: Throwable -> L32
    L25:
        r106.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, r107);     // Catch: Throwable -> L32
        r101.setMetadata(r106.build());     // Catch: Exception -> L28 Throwable -> L32
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "media metadata updated. state: " + r103.b());     // Catch: Exception -> L28 Throwable -> L32
        r100 = true;
    L30:
        monitor-exit(this);
        return r100;
    L28:
        e = move-exception;
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionService", "media metadata update failed", e);     // Catch: Throwable -> L32
        goto L30
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [aw3.h0] */
    public AppletBackgroundAudioMediaSessionService() {
        this.f191425a = new b(this);
        this.f191426b = new a();
        this.f191427c = new Handler(Looper.getMainLooper());
        this.f191428d = new h0(this);
        this.f191429e = d("background_audio_play");
        this.f191430f = d("background_audio_pause");
        this.f191431g = d("background_audio_previous");
        this.f191432h = d("background_audio_next");
    }

    public static PendingIntent d(String r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        Intent r102 = new Intent(r101.getApplication(), AppletBackgroundAudioMediaSessionService.class);
        r102.setAction(r100);
        Application r103 = r101.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r104 = 201326592;
    L7:
        return PendingIntent.getService(r103, 109, r102, r104);
    L5:
        r104 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L7
    }

    public static String f(q0 r100) {
        String r101 = r100.f16482d;
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.f16481c;
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static String g(q0 r100) {
        String r101 = r100.f16480b;
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.f16481c;
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return "豆包音频";
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static long h(double r100) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == false) goto L12;
        r102 = RangesKt.coerceAtLeast(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    L12:
        return RangesKt.coerceAtLeast(MathKt.roundToLong(r102 * ((double) 1000)), 0);
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [aw3.j0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [aw3.i0] */
    public final void j(q0 r100) {
        String r101 = r100.f16483e;
        if (r101 != null) goto L5;
    L7:
        final String r102 = null;
    L9:
        if (Intrinsics.areEqual(r102, this.f191437m) == false) goto L14;
        if (this.f191436l == null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r102, this.f191437m) == true) goto L16;
        this.f191437m = r102;
        this.f191436l = null;
        this.f191439o = null;
    L16:
        if (r102 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(this.f191439o, r102) == true) goto L23;
        this.f191439o = r102;
        final ?? r103 = new i0(r102, this);
        final ?? r104 = new j0(this, r102);
        ImageLoaderKt.o(r102, "background_audio.album_art", AppHost.f326268a.getApplication(), new k0(r103, r102, r104), null, 112);
        return;
    L23:
        return;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        r102 = r101;
        goto L9
    }

    public final boolean m(boolean r110) {
        boolean r100 = false;
        if (this.f191434j == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r101 = this.f191433i;
        if (r101 != null) goto L8;
        return false;
    L8:
        w r102 = w.f16506a;
        q0 r103 = w.o();
        if (r103 != null) goto L11;
        return false;
    L11:
        PlaybackStateCompat.Builder r104 = new PlaybackStateCompat.Builder();
        Bundle r105 = new Bundle();
        r105.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r106 = r104.setExtras(r105).setActions(822);
        int r107 = e.f191442a[r103.f16491m.ordinal()];
        int r111 = 3;
        if (r107 != 1) goto L14;
    L23:
        long r112 = h(r103.f16486h);
        if (r103.f16491m != BackgroundAudioPlaybackState.PLAYING) goto L42;
        Double r108 = Double.valueOf(r103.f16490l);
        double r113 = r108.doubleValue();
        if (Double.isInfinite(r113) == false) goto L28;
    L30:
        boolean r114 = false;
    L31:
        if (r114 == true) goto L33;
    L35:
        boolean r115 = false;
    L36:
        if (r115 == true) goto L39;
        r108 = null;
    L39:
        if (r108 == null) goto L41;
        float r109 = (float) r108.doubleValue();
    L62:
        r101.setPlaybackState(r106.setState(r111, r112, r109).build());     // Catch: Exception -> L56
        if (this.f191435k == false) goto L54;
        MediaSessionCompat r116 = this.f191433i;     // Catch: Exception -> L56
        if (r116 == null) goto L54;
        q0 r117 = w.o();     // Catch: Exception -> L56
        if (r117 == null) goto L54;
        NotificationManagerCompat.from(AppHost.f326268a.getApplication()).notify(109, a(r116, r117));     // Catch: Exception -> L56
    L54:
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionService", "playback state updated. state: " + r103.b() + ", isAuto: " + r110);     // Catch: Exception -> L56
        r100 = true;
    L58:
        if (r100 == false) goto L61;
        if (r110 == true) goto L61;
        this.f191427c.removeCallbacks(this.f191428d);
        this.f191427c.postDelayed(this.f191428d, 500);
    L61:
        return r100;
    L56:
        e = move-exception;
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionService", "playback state update failed", e);
        goto L58
    L41:
        r109 = 1.0f;
        goto L62
    L33:
        if (r113 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L35;
        r115 = true;
        goto L36
    L28:
        if (Double.isNaN(r113) == true) goto L30;
        r114 = true;
        goto L31
    L42:
        r109 = 0.0f;
        goto L62
    L14:
        if (r107 == 2) goto L22;
        if (r107 != 3) goto L17;
        r111 = 1;
        goto L23
    L17:
        if (r107 != 4) goto L20;
        r111 = 7;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        r111 = 2;
        goto L23
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return this.f191425a;
    }

    public final Notification a(MediaSessionCompat r100, q0 r101) {
        NotificationCompat.MediaStyle r102 = new NotificationCompat.MediaStyle().setMediaSession(r100.getSessionToken()).setShowActionsInCompactView(new int[]{0, 1, 2});
        androidx.core.app.NotificationCompat.Builder r103 = new androidx.core.app.NotificationCompat.Builder(AppHost.f326268a.getApplication(), "background_audio_channel").setShowWhen(false).setSound(null).setContentTitle(g(r101)).setContentText(f(r101)).setSmallIcon(R.drawable.larus_applet_background_audio_notification_small).setAutoCancel(false).setOngoing(true).addAction(R.drawable.larus_applet_background_audio_action_previous, "background_audio_previous", this.f191431g);
        if (r101.f16491m != BackgroundAudioPlaybackState.PLAYING) goto L5;
        androidx.core.app.NotificationCompat.Builder r104 = r103.addAction(R.drawable.larus_music_pause, "background_audio_pause", this.f191430f);
        Intrinsics.checkNotNull(r104);
    L6:
        androidx.core.app.NotificationCompat.Builder r105 = r104.addAction(R.drawable.larus_applet_background_audio_action_next, "background_audio_next", this.f191432h).setStyle(r102);
        Bitmap r106 = this.f191436l;
        if (r106 != null) goto L11;
        r106 = this.f191438n;
        if (r106 != null) goto L11;
        r106 = BitmapFactory.decodeResource(getResources(), R.drawable.larus_applet_background_audio_album_art_placeholder);
        this.f191438n = r106;
    L11:
        r105.setLargeIcon(r106);
        return r105.build();
    L5:
        r104 = r103.addAction(R.drawable.larus_music_play, "background_audio_play", this.f191429e);
        Intrinsics.checkNotNull(r104);
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getAction();
    L5:
        if (r103 != null) goto L7;
        return 2;
    L7:
        switch(r103.hashCode()) {
            case -1423730575: goto L22;
            case -221263172: goto L18;
            case 2071016813: goto L14;
            case 2071082414: goto L10;
            default: goto L31;
        };
    L31:
        return 2;
    L10:
        if (r103.equals("background_audio_play") == false) goto L32;
        this.f191426b.onPlay();
        return 2;
    L32:
        return 2;
    L14:
        if (r103.equals("background_audio_next") == false) goto L33;
        this.f191426b.onSkipToNext();
        return 2;
    L33:
        return 2;
    L18:
        if (r103.equals("background_audio_pause") == false) goto L34;
        this.f191426b.onPause();
        return 2;
    L34:
        return 2;
    L22:
        if (r103.equals("background_audio_previous") == false) goto L35;
        this.f191426b.onSkipToPrevious();
        return 2;
    L35:
        return 2;
    L4:
        r103 = null;
        goto L5
    }
}
