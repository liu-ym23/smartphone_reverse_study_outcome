package com.bytedance.android.livesdk.bgService;

import am2.x;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/bgService/LiveMediaSessionService;", "Landroidx/media/MediaBrowserServiceCompat;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMediaSessionService extends MediaBrowserServiceCompat {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f104291k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f104292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f104293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.bgService.b f104294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f104295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediatorLiveData<b> f104296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Observer<b> f104297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f104298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f104299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f104300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f104301j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f104302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f104303b;

        public b() {
            this(false, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f104302a == r101.f104302a) goto L8;
            return false;
        L8:
            if (this.f104303b == r101.f104303b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r100 = this.f104302a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f104303b;
            if (r104 == true) goto L10;
            r101 = r104;
        L10:
            return r103 + r101;
        }

        public final String toString() {
            return "PlayerState(isPlaying=" + this.f104302a + ", isMuted=" + this.f104303b + ")";
        }

        public b(boolean r100, boolean r101) {
            this.f104302a = r100;
            this.f104303b = r101;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.bgService.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMediaSessionService f104304a;

        @Override // com.bytedance.android.livesdk.bgService.b.a
        public final void onPause() {
            LiveMediaSessionService r100 = this.f104304a;
            ALogger.i(r100.f104292a, "LiveMediaSessionService### pausePlayback，isPlaying: " + r100.f104298g);
            if (r100.f104298g == false) goto L6;
            r100.b();
            return;
        }

        @Override // com.bytedance.android.livesdk.bgService.b.a
        public final void onPlay() {
            LiveMediaSessionService r100 = this.f104304a;
            ALogger.i(r100.f104292a, "LiveMediaSessionService### startPlayback，isPlaying: " + r100.f104298g);
            if (r100.f104298g == true) goto L6;
            r100.b();
            return;
        }

        public c(LiveMediaSessionService r100) {
            this.f104304a = r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMediaSessionService f104305a;

        public d(LiveMediaSessionService r100) {
            this.f104305a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = ((h1) r100).f571836a;
            if (r101 != 7) goto L5;
        L10:
            UtilityKotlinExtentionsKt.s(0, false, false, new LiveMediaSessionService$onCreate$4$1(this), 7);
            return;
        L5:
            if (r101 == 11) goto L10;
            if (r101 == 20) goto L10;
            if (r101 == 45) goto L10;
        }
    }

    public static final class e extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMediaSessionService f104306a;

        public e(LiveMediaSessionService r100) {
            this.f104306a = r100;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            ALogger.i(this.f104306a.f104292a, "LiveMediaSessionService### updateNotification, fetch bitmap fail");
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            ALogger.i(this.f104306a.f104292a, "LiveMediaSessionService### updateNotification, fetch bitmap success");
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isRecycled() == true) goto L14;
            LiveMediaSessionService r101 = this.f104306a;
            com.bytedance.android.livesdk.bgService.b r102 = r101.f104294c;
            if (r102 == null) goto L9;
            r102.update(r101.f104298g, false, r100);
        L9:
            LiveMediaSessionService r103 = this.f104306a;
            h r104 = r103.f104295d;
            if (r104 == null) goto L15;
            h.a(r104, r103.f104298g, r100, 2);
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public final MediaBrowserServiceCompat.BrowserRoot onGetRoot(String r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "clientPackageName");
        return null;
    }

    public static ILivePlayerClient a() {
        IRoomService r100 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r100 == null) goto L7;
        Room r101 = r100.getCurrentRoom();
        if (r101 == null) goto L7;
        return LivePlatformPlayerManager.a(r101.f162599id, false);
    L7:
        return null;
    }

    public final void b() {
        ALogger.i(this.f104292a, "LiveMediaSessionService### startOrPause，isPlaying: " + this.f104298g);
        boolean r100 = this.f104298g ^ true;
        this.f104298g = r100;
        if (r100 == false) goto L5;
        String r101 = "livesdk_play_backstage";
    L6:
        IRoomService r102 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r102 == null) goto L9;
        Room r103 = r102.getCurrentRoom();
    L11:
        if (r103 == null) goto L13;
        u.l().d(r101, new Object[]{r103});
    L13:
        j0 r104 = j0.l();
        Pair[] r105 = new Pair[2];
        if (r100 == false) goto L16;
        String r106 = "play";
    L17:
        r105[0] = TuplesKt.to("click_type", r106);
        KeyguardManager r107 = (KeyguardManager) this.f104293b.getValue();
        if (r107 != null) goto L20;
    L22:
        String r108 = "0";
    L23:
        r105[1] = TuplesKt.to("lock_screen_status", r108);
        r104.sendLog("livesdk_background_live_play", MapsKt.mutableMapOf(r105), new Object[]{IRoom.class, x.class});
        c();
        xs2.b.a().post(new com.bytedance.android.livesdk.notification.h());
        return;
    L20:
        if (r107.isKeyguardLocked() != true) goto L22;
        r108 = "1";
        goto L23
    L16:
        r106 = "pause";
        goto L17
    L9:
        r103 = null;
        goto L11
    L5:
        r101 = "livesdk_pause_backstage";
        goto L6
    }

    public final void c() {
        ALogger.i(this.f104292a, "LiveMediaSessionService### updateNotification, isPlaying: " + this.f104298g);
        IRoomService r100 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r100 == null) goto L5;
        Room r101 = r100.getCurrentRoom();
    L6:
        if (r101 != null) goto L10;
        ALogger.i(this.f104292a, "LiveMediaSessionService### updateNotification, return, room is null");
        return;
    L10:
        if (f104291k == true) goto L13;
        ALogger.i(this.f104292a, "LiveMediaSessionService### updateNotification return service is stop");
        return;
    L13:
        com.bytedance.android.livesdk.bgService.b r102 = this.f104294c;
        if (r102 == null) goto L16;
        r102.update(this.f104298g, false, null);
    L16:
        h r103 = this.f104295d;
        if (r103 == null) goto L19;
        h.a(r103, this.f104298g, null, 6);
    L19:
        ALogger.i(this.f104292a, "LiveMediaSessionService### updateNotification, fetch bitmap");
        IRoomService r104 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r104 == null) goto L41;
        Room r105 = r104.getCurrentRoom();
        if (r105 == null) goto L47;
        py.k r106 = r105.getCover();
        if (r106 == null) goto L48;
        List<String> r107 = r106.getUrls();
        if (r107 == null) goto L49;
        Iterator<T> r108 = r107.iterator();
    L29:
        if (r108.hasNext() == false) goto L40;
        String r109 = (String) r108.next();
        if ((!StringsKt.isBlank(r109)) == false) goto L29;
        if (r109 == null) goto L50;
        Uri r110 = UriProtector.parse(r109);     // Catch: Exception -> L35
    L37:
        if (r110 == null) goto L51;
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(r110).setResizeOptions(new ResizeOptions(UtilityKotlinExtentionsKt.i(120), UtilityKotlinExtentionsKt.i(120))).setProgressiveRenderingEnabled(true).build(), null).subscribe(new e(this), CallerThreadExecutor.getInstance());
        return;
    L51:
        return;
    L35:
        e = move-exception;
        ALogger.i(this.f104292a, "LiveMediaSessionService### updateNotification, fetch bitmap,  Uri.parse : " + e.getMessage());
        r110 = null;
        goto L37
    L50:
        return;
    L40:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L41:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.app.Service
    public final void onDestroy() {
        ALogger.i(this.f104292a, "LiveMediaSessionService### onDestroy");
        super.onDestroy();
        ILivePlayerClient r100 = a();
        if (r100 == null) goto L9;
        IRoomEventHub r101 = r100.getEventHub();
        if (r101 == null) goto L9;
        final MutableLiveData<Boolean> r102 = r101.getStartPullStream();
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.s(0, false, false, new LiveMediaSessionService$onDestroy$$inlined$also$lambda$1(r102, this), 7);
    L9:
        this.f104299h.clear();
        Disposable r103 = this.f104300i;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        f104291k = false;
        UtilityKotlinExtentionsKt.s(0, false, false, new LiveMediaSessionService$stopPlayerStateMediator$1(this), 7);
        com.bytedance.android.livesdk.bgService.b r104 = this.f104294c;
        if (r104 == null) goto L15;
        ALogger.i(r104.f104310b, "LiveMediaSessionController### release success");
        ALogger.i(r104.f104310b, "LiveMediaSessionController### clearData success");
        r104.f104309a.setActive(false);
        r104.f104309a.setMetadata(null);
        r104.f104309a.release();
    L15:
        h r105 = this.f104295d;
        if (r105 == null) goto L19;
        ALogger.i(r105.f104319a, "LiveMediaSessionNotification### hideNotification start");
        NotificationManagerCompat.from(r105.f104322d.getApplicationContext()).cancel(r105.f104325g);
        return;
    }

    public LiveMediaSessionService() {
        this.f104292a = "LiveMediaSession";
        this.f104293b = LazyKt.lazy(new LiveMediaSessionService$km$2(this));
        this.f104298g = true;
        this.f104299h = new CompositeDisposable();
        this.f104301j = LazyKt.lazy(new LiveMediaSessionService$microStartPullStreamOb$2(this));
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public final void onCreate() {
        super.onCreate();
        ALogger.i(this.f104292a, "LiveMediaSessionService### onCreate");
        f104291k = true;
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 26) goto L8;
        ALogger.i(this.f104292a, "LiveMediaSessionNotification### createNotificationChannel");
        NotificationChannel r101 = new NotificationChannel("live_bg_channel", "直播后台播放", 3);
        r101.setDescription("直播后台播放状态");
        NotificationManager r102 = (NotificationManager) getSystemService(NotificationManager.class);
        if (r102 == null) goto L8;
        r102.createNotificationChannel(r101);
    L8:
        if (df1.a.d() == false) goto L10;
        boolean r103 = df1.a.a();
    L12:
        if (r100 < 30) goto L19;
        if (r103 == true) goto L42;
        ALogger.i(this.f104292a, "LiveMediaSessionService### startForeground, type = playback");
        startForeground(41246, new NotificationCompat.Builder(this, "live_bg_channel").build(), 2);
    L20:
        IRoomService r104 = (IRoomService) jc1.k.f(IRoomService.class);
        h r105 = null;
        if (r104 == null) goto L23;
        Room r106 = r104.getCurrentRoom();
    L24:
        if (r106 == null) goto L40;
        com.bytedance.android.livesdk.bgService.b r107 = new com.bytedance.android.livesdk.bgService.b(this, new c(this));
        this.f104294c = r107;
        setSessionToken(r107.f104309a.getSessionToken());     // Catch: Exception -> L30
    L32:
        com.bytedance.android.livesdk.bgService.b r108 = this.f104294c;
        if (r108 == null) goto L35;
        r105 = new h(this, r108, this.f104299h);
    L35:
        this.f104295d = r105;
        this.f104300i = xs2.b.a().b(h1.class).subscribe(new d(this));
        return;
    L30:
        e = move-exception;
        ALogger.i(this.f104292a, "LiveMediaSessionService### sessionToken error, " + e.getMessage());
        goto L32
    L40:
        stopSelf();     // Catch: Exception -> L37
        return;
    L44:
        return;
    L23:
        r106 = null;
        goto L24
    L42:
        ALogger.i(this.f104292a, "LiveMediaSessionService### startForeground, type = micro");     // Catch: Exception -> L16
        startForeground(41246, new NotificationCompat.Builder(this, "live_bg_channel").build(), 128);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ALogger.e(this.f104292a, "LiveMediaSessionService### startForeground error, type = micro, error: " + e.getMessage());
        goto L20
    L19:
        ALogger.i(this.f104292a, "LiveMediaSessionService### startForeground, type = null");
        startForeground(41246, new NotificationCompat.Builder(this, "live_bg_channel").build());
        goto L20
    L10:
        r103 = false;
        goto L12
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public final void onLoadChildren(String r100, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> r101) {
        Intrinsics.checkNotNullParameter(r100, "parentId");
        Intrinsics.checkNotNullParameter(r101, "result");
        r101.sendResult(null);
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent r100, int r101, int r102) {
        String r103 = this.f104292a;
        if (r100 == null) goto L6;
        String r104 = r100.getAction();
        if (r104 == null) goto L6;
    L7:
        ALogger.i(r103, "LiveMediaSessionService### onStartCommand, action: ".concat(r104));
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this, r100), 7);
        return 2;
    L6:
        r104 = "";
        goto L7
    }
}
