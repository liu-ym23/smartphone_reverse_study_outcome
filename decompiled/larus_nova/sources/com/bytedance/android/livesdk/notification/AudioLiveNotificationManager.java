package com.bytedance.android.livesdk.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.r;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.config.y30;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.floatview.q;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import zg1.h1;

/* JADX INFO: loaded from: classes11.dex */
public final class AudioLiveNotificationManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f154040f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f154042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f154043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f154044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f154045e;

    public static final class a {
        public static AudioLiveNotificationManager a() {
            return (AudioLiveNotificationManager) AudioLiveNotificationManager.f154040f.getValue();
        }
    }

    public static final class b extends IHostAppMonitorListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioLiveNotificationManager f154046a;

        public b(AudioLiveNotificationManager r100) {
            this.f154046a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            this.f154046a.f154041a = r100;
            ALogger.i("AudioLiveService#NotifyManager", "appEnterBackground; background: " + r100 + ", isRegister: " + r101);
            if (r101 == false) goto L5;
            return;
        L5:
            this.f154046a.getClass();
            if (AudioLiveNotificationManager.d() == false) goto L8;
        L10:
            boolean r102 = AudioLiveNotificationManager.e(this.f154046a.f154043c);
            this.f154046a.getClass();
            boolean r103 = NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled();
            if (((IRoomService) k.n(IRoomService.class)).getCurrentRoom() != null) goto L16;
            if (r100 == true) goto L29;
            if (r102 == true) goto L30;
            ALogger.i("AudioLiveService#NotifyManager", "stop service since room doesn't exist.");
            this.f154046a.g(r103, "live_end");
            AudioLiveService.f154052n.stopService();
            return;
        L30:
            return;
        L29:
            return;
        L16:
            this.f154046a.f(r100, r102, r103);
            this.f154046a.getClass();
            if (AudioLiveNotificationManager.d() == true) goto L25;
            if (r100 == false) goto L21;
            if (r102 == false) goto L21;
            boolean r104 = true;
        L22:
            ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getControlServiceExternal().f(r104);
            if (this.f154046a.f154041a == false) goto L25;
            df1.c.a();
        L21:
            r104 = false;
        L25:
            if (r103 == false) goto L27;
            ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification lifecycle call isBackground=" + this.f154046a.f154041a);
            this.f154046a.k(r100, r102, false, false);
            return;
        L27:
            ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed; notification is disabled");
            return;
        L8:
            if (df1.b.f468196a == false) goto L10;
        }
    }

    static {
        f154040f = LazyKt.lazy(AudioLiveNotificationManager$Companion$instance$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.notification.AudioLiveService");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.notification.AudioLiveService");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.notification.AudioLiveService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("com.bytedance.android.livesdk.notification.AudioLiveService");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static boolean d() {
        Room r100 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoom();
        if (r100 == null) goto L6;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L6;
    L7:
        String r102 = ((IUserService) k.n(IUserService.class)).user().n();
        o0.f58946a.getClass();
        return o0.a.a(r101, r102);
    L6:
        r101 = "0";
        goto L7
    }

    public AudioLiveNotificationManager() {
        this.f154043c = jc1.a.b();
        b r100 = new b(this);
        IHostApp r101 = (IHostApp) k.f(IHostApp.class);
        if (r101 == null) goto L6;
        r101.registerLiveLifeCycleListener(r100);
    L6:
        if (df1.b.f468196a == false) goto L9;
        boolean r102 = df1.e.f468200a;
        return;
    }

    public static void c() {
        boolean r100 = true;
        if (d() == true) goto L15;
        if (df1.b.f468196a == false) goto L15;
        int r101 = df1.d.f468199a;
        if (Build.VERSION.SDK_INT >= 34) goto L10;
        r100 = false;
    L10:
        ALogger.i("LiveMediaSession", "LiveMultiRoomServiceHelper### hideForegroundNotification, versionLimit:" + r100);
        if (r100 == false) goto L27;
        df1.e.f468206g.stopService();
        return;
    L27:
        return;
    L15:
        if (Build.VERSION.SDK_INT >= 34) goto L18;
        r100 = false;
    L18:
        ILiveService r102 = TTLiveService.getLiveService();
        if (r102 == null) goto L21;
        Boolean r103 = Boolean.valueOf(r102.isLiveTalkRoomFloatWindowShowing());
    L22:
        AudioLiveService.a r104 = AudioLiveService.f154052n;
        r104.getClass();
        boolean r105 = AudioLiveService.f154049k;
        ALogger.i("AudioLiveService#NotifyManager", "hideForegroundNotification call versionLinkMicBgLimit=" + r100 + " windowShowing=" + r103 + " isServiceStarted=" + r105);
        if (r100 == false) goto L28;
        if (r105 == false) goto L29;
        ALogger.i("AudioLiveService#NotifyManager", "hideForegroundNotification and stopService");
        r104.stopService();
        return;
    L29:
        return;
    L28:
        return;
    L21:
        r103 = null;
        goto L22
    }

    public final void b() {
        if (d() == false) goto L5;
    L8:
        ALogger.i("AudioLiveService#NotifyManager", "hideBackgroundNotification call");
        Intent r100 = new Intent(this.f154043c, AudioLiveService.class);
        r100.setAction("com.bytedance.android.livesdk.audio_action.CANCEL");
        j(this.f154043c, r100);
        return;
    L5:
        if (df1.b.f468196a == false) goto L8;
        int r101 = df1.d.f468199a;
        ALogger.i("LiveMediaSession", "LiveMultiRoomServiceHelper### hideBackgroundNotification");
        df1.e.f468206g.stopService();
    }

    public final void h() {
        if (d() == true) goto L9;
        if (df1.b.f468196a == false) goto L9;
        int r100 = df1.d.f468199a;
        ALogger.i("LiveMediaSession", "LiveMultiRoomServiceHelper### showBackgroundNotification");
        df1.e.f468206g.e(true, false, false);
        return;
    L9:
        if (((IRoomService) k.n(IRoomService.class)).getCurrentRoom() != null) goto L11;
        return;
    L11:
        ALogger.i("AudioLiveService#NotifyManager", "showBackgroundNotification call");
        boolean r101 = e(this.f154043c);
        boolean r102 = NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled();
        f(this.f154041a, r101, r102);
        if (r102 == false) goto L15;
        k(this.f154041a, r101, false, false);
        return;
    }

    public final void i() {
        Boolean r100 = null;
        if (d() == true) goto L20;
        if (df1.b.f468196a == false) goto L20;
        int r101 = df1.d.f468199a;
        if (Build.VERSION.SDK_INT < 34) goto L9;
        boolean r102 = true;
    L10:
        ILiveService r103 = TTLiveService.getLiveService();
        if (r103 == null) goto L13;
        r100 = Boolean.valueOf(r103.isLiveTalkRoomFloatWindowShowing());
    L13:
        ALogger.i("LiveMediaSession", "LiveMultiRoomServiceHelper### showForegroundNotification, versionLimit:" + r102 + ", isFloatWindowShowing: " + r100);
        if (r102 == true) goto L16;
        return;
    L16:
        if ((!Intrinsics.areEqual(r100, Boolean.TRUE)) == false) goto L44;
        df1.e.f468206g.e(false, true, true);
        return;
    L44:
        return;
    L9:
        r102 = false;
    L20:
        if (Build.VERSION.SDK_INT < 34) goto L22;
        boolean r104 = true;
    L23:
        ILiveService r105 = TTLiveService.getLiveService();
        if (r105 == null) goto L26;
        r100 = Boolean.valueOf(r105.isLiveTalkRoomFloatWindowShowing());
    L26:
        AudioLiveService.a r106 = AudioLiveService.f154052n;
        r106.getClass();
        boolean r107 = AudioLiveService.f154049k;
        ALogger.i("AudioLiveService#NotifyManager", "showForegroundNotification call versionLinkMicBgLimit=" + r104 + " windowShowing=" + r100 + " isServiceStarted=" + r107);
        if (r104 == true) goto L29;
    L37:
        if (r104 == true) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L48;
        if (r107 == false) goto L49;
        ALogger.i("AudioLiveService#NotifyManager", "showForegroundNotification but stopService");
        r106.stopService();
        return;
    L49:
        return;
    L48:
        return;
    L29:
        if ((!Intrinsics.areEqual(r100, Boolean.TRUE)) == false) goto L37;
        if (r107 == true) goto L37;
        if (((IRoomService) k.n(IRoomService.class)).getCurrentRoom() != null) goto L34;
        return;
    L34:
        boolean r108 = e(this.f154043c);
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == false) goto L45;
        ALogger.i("AudioLiveService#NotifyManager", "showForegroundNotification try call");
        k(false, r108, false, true);
        return;
    L45:
        return;
    L22:
        r104 = false;
        goto L23
    }

    public static boolean e(Context r100) {
        List<Class> r101 = ((IHostApp) k.n(IHostApp.class)).getAllLiveActivity();
        List<Class> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return false;
    L12:
        if ((r100 instanceof Activity) == false) goto L14;
        Activity r104 = (Activity) r100;
    L15:
        Iterator<T> r105 = r101.iterator();
    L17:
        if (r105.hasNext() == false) goto L25;
        Class r106 = (Class) r105.next();
        if (r104 == null) goto L21;
        Class<?> r107 = r104.getClass();
    L23:
        if (Intrinsics.areEqual(r107, r106) == false) goto L17;
        return true;
    L21:
        r107 = null;
        goto L23
    L25:
        return false;
    L14:
        r104 = ((IHostApp) k.n(IHostApp.class)).getTopActivity();
        goto L15
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void j(Context r100, Intent r101) {
        if (r100 != null) goto L15;
        return;
    L15:
    L12:
        th = move-exception;
        ALogger.e("AudioLiveService#NotifyManager", "startServiceSafely error: " + th.getMessage());
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r100.startForegroundService(r101);     // Catch: Throwable -> L12
    L9:
        if (d() == true) goto L17;
        df1.c.f468197a = true;     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L7:
        r100.startService(r101);     // Catch: Throwable -> L12
        goto L9
    }

    public final void g(boolean r100, String r101) {
        if (this.f154042b <= 0) goto L8;
        long r102 = SystemClock.elapsedRealtime() - this.f154042b;
        if (d() == true) goto L7;
        AudienceVideoResolutionManager.b(false);
        com.bytedance.android.livesdk.notification.a.c(r102, r100, r101);
    L7:
        this.f154042b = 0;
    L8:
        ALogger.i("AudioLiveService#NotifyManager", "onBackgroundObEnd call");
        Disposable r103 = this.f154044d;
        if (r103 != null) goto L11;
    L16:
        Disposable r104 = this.f154045e;
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.isDisposed() == true) goto L26;
        Disposable r105 = this.f154045e;
        if (r105 == null) goto L23;
        r105.dispose();
    L23:
        this.f154045e = null;
        return;
    L26:
        return;
    L11:
        if (r103.isDisposed() == true) goto L16;
        Disposable r106 = this.f154044d;
        if (r106 == null) goto L15;
        r106.dispose();
    L15:
        this.f154044d = null;
        goto L16
    }

    public final void f(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L24;
        if (r101 == false) goto L24;
        this.f154042b = SystemClock.elapsedRealtime();
        if (d() == true) goto L7;
        AudienceVideoResolutionManager.b(true);
        com.bytedance.android.livesdk.notification.a.d(r102);
    L7:
        ALogger.i("AudioLiveService#NotifyManager", "onBackgroundObStart call");
        Disposable r103 = this.f154044d;
        if (r103 != null) goto L10;
    L15:
        this.f154044d = du2.a.d(30, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.notification.b(this, r102));
        Disposable r104 = this.f154045e;
        if (r104 != null) goto L18;
    L23:
        this.f154045e = xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r102));
        return;
    L18:
        if (r104.isDisposed() == true) goto L23;
        Disposable r105 = this.f154045e;
        if (r105 == null) goto L22;
        r105.dispose();
    L22:
        this.f154045e = null;
        goto L23
    L10:
        if (r103.isDisposed() == true) goto L15;
        Disposable r106 = this.f154044d;
        if (r106 == null) goto L14;
        r106.dispose();
    L14:
        this.f154044d = null;
    L24:
        if (r100 == true) goto L30;
        g(r102, "back_app");
        if (d() == true) goto L31;
        df1.c.b();
        return;
    L31:
        return;
    }

    public final void k(boolean r100, boolean r101, boolean r102, boolean r110) {
        if (r.f65395a.getValue().booleanValue() == true) goto L6;
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed;  LIVE_AUDIO_BACKGROUND_NOTIFICATION_ENABLE is false");
        return;
    L6:
        boolean r103 = true;
        if (d() == false) goto L9;
        boolean r104 = ((IInteractService) k.n(IInteractService.class)).enableCaptureAudioOnBackground(r102);
    L10:
        if (r104 == true) goto L13;
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed;  anchorTalkRoomShowNotificationEnabled is false");
        return;
    L13:
        IRoomService r105 = (IRoomService) k.f(IRoomService.class);
        if (r105 == null) goto L92;
        Room r106 = r105.getCurrentRoom();
        if (r106 != null) goto L19;
        return;
    L19:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r106), PaidSceneEnum.PAID_ROOM, 2) == true) goto L23;
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed; paidManagerService returned");
        return;
    L23:
        if (r106.getStreamType() != LiveMode.AUDIO) goto L25;
    L28:
        ILiveService r107 = TTLiveService.getLiveService();
        if (r107 == null) goto L37;
        if (r107.isLiveTalkRoomFloatWindowShowing() != true) goto L37;
        StringBuilder r108 = new StringBuilder("isStarted=");
        AudioLiveService.a r109 = AudioLiveService.f154052n;
        r109.getClass();
        r108.append(AudioLiveService.f154049k);
        r108.append(" isBackground=");
        r108.append(r100);
        r108.append(" tryShowBackgroundNotification failed; isLiveTalkRoomFloatWindowShowing = true");
        ALogger.i("AudioLiveService#NotifyManager", r108.toString());
        if (AudioLiveService.f154049k == false) goto L91;
        r109.stopService();
        return;
    L91:
        return;
    L37:
        if (((IInteractService) k.n(IInteractService.class)).enableCaptureAudioOnBackground(r102) == true) goto L46;
        boolean r111 = p.f125259a;
        if (p.d(this.f154043c) == false) goto L57;
        AudioLiveService.a r112 = AudioLiveService.f154052n;
        r112.getClass();
        if (AudioLiveService.f154049k == false) goto L43;
        r112.stopService();
    L43:
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed; isFloatWindowOpen=true");
        return;
    L57:
        if (r110 == false) goto L59;
    L72:
        if (r100 == true) goto L74;
        if (r103 == true) goto L74;
    L84:
        if (r100 == true) goto L94;
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification try stop");
        if (r103 == true) goto L95;
        AudioLiveService.f154052n.stopService();
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification stop call");
        return;
    L95:
        return;
    L94:
        return;
    L74:
        if (r101 == false) goto L84;
        if (r100 == false) goto L89;
        if (r103 == false) goto L89;
        ALogger.i("AudioLiveService#NotifyManager", "background start but version 34+");
        return;
    L89:
        a();     // Catch: Exception -> L81
        Intent r113 = new Intent(this.f154043c, AudioLiveService.class);
        r113.setAction("com.bytedance.android.livesdk.audio_action.SHOW");
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification call show isBackground=" + r100 + " versionLinkMicBgLimit=" + r103);
        j(this.f154043c, r113);
        return;
    L81:
        e = move-exception;
        u.l().sendLog("livesdk_not_find_AudioLiveService", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e.toString())), new Object[0]);
        return;
    L59:
        if (Build.VERSION.SDK_INT < 34) goto L61;
        boolean r114 = true;
    L62:
        if (r114 == true) goto L64;
    L68:
        boolean r115 = false;
    L69:
        if (r115 == true) goto L72;
        r103 = false;
        goto L72
    L64:
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUser(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L68;
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUserUnSilence(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L68;
        r115 = true;
        goto L69
    L61:
        r114 = false;
        goto L62
    L46:
        if (d() == true) goto L57;
        q r116 = VideoFloatWindowManager.f125075f;
        rx1.g r117 = VideoFloatWindowManager.b.a().c();
        if (r117 == null) goto L57;
        if (r117.f539762l != true) goto L57;
        AudioLiveService.a r118 = AudioLiveService.f154052n;
        r118.getClass();
        if (AudioLiveService.f154049k == false) goto L54;
        r118.stopService();
    L54:
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed; VideoFloatWindowManager isShowing");
        return;
    L25:
        if (y30.f121652a.getValue().booleanValue() == false) goto L28;
        ALogger.i("AudioLiveService#NotifyManager", "tryShowBackgroundNotification failed; room.streamType != LiveMode.AUDIO && LIVE_JUST_AUDIO_NOTIFICATION_ENABLE.value");
        return;
    L92:
        return;
    L9:
        r104 = true;
        goto L10
    }
}
