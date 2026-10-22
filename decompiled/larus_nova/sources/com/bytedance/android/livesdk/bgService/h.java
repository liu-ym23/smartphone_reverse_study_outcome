package com.bytedance.android.livesdk.bgService;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostResProvider;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.ye1;
import com.bytedance.android.livesdk.floatview.l;
import com.bytedance.android.livesdk.utils.u5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f104319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Notification f104320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f104321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f104322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f104323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f104324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f104325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f104326h;

    public h(Context r100, b r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "controller");
        Intrinsics.checkNotNullParameter("live_bg_channel", RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r102, "compositeDisposable");
        this.f104322d = r100;
        this.f104323e = r101;
        this.f104324f = "live_bg_channel";
        this.f104325g = 41246;
        this.f104326h = r102;
        this.f104319a = "LiveMediaSession";
    }

    public static void a(h r110, boolean r111, Bitmap r112, int r113) {
        Notification r100 = null;
        if ((r113 & 4) == 0) goto L5;
        r112 = null;
    L5:
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### updateNotification start, this.playing:" + r110.f104321c + ", isPlaying:" + r111 + ", ignoreCheck:false,bitmap:" + r112);
        Boolean r114 = r110.f104321c;
        if (r114 != null) goto L8;
    L10:
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### updateNotification success");
        r110.f104321c = Boolean.valueOf(r111);
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### createNotification start");
        IRoomService r115 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r115 == null) goto L116;
        Room r116 = r115.getCurrentRoom();
        if (r116 == null) goto L116;
        int r101 = l.f125236a;
        Context r102 = r110.f104322d;
        Intent r103 = l.a(r102, r102.getPackageName());
        if (r103 == null) goto L116;
        Context r104 = r110.f104322d;
        if (Build.VERSION.SDK_INT < 31) goto L21;
        int r105 = 201326592;
    L22:
        PendingIntent r106 = PendingIntent.getActivity(r104, 0, r103, r105);
        int r107 = df1.a.f468195a;
        String r108 = df1.a.c(r110.f104322d, r116);
        NotificationCompat.Builder r109 = new NotificationCompat.Builder(r110.f104322d, r110.f104324f);
        IHostBusiness r117 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r117 == null) goto L114;
        r117.isDouyinPreInstall();
    L114:
        IHostContext r118 = (IHostContext) jc1.k.f(IHostContext.class);     // Catch: Throwable -> L29
        if (r118 == null) goto L30;
        int r119 = r118.appIcon();     // Catch: Throwable -> L29
    L31:
        int r120 = R.drawable.ttlive_float_icon;
        if (r119 != 0) goto L49;
        String r121 = Build.MANUFACTURER;
        if (Intrinsics.areEqual(r121, "OnePlus") == false) goto L37;
    L40:
        boolean r122 = true;
    L41:
        if (r122 == false) goto L44;
        r119 = R.drawable.ttlive_status_icon_light;
        goto L49
    L44:
        if (tb1.c.f545233e == false) goto L48;
        IHostContext r123 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r123 == null) goto L48;
        r119 = r123.appIcon();
    L48:
        r119 = R.drawable.ttlive_float_icon;
        goto L49
    L37:
        if (Intrinsics.areEqual(r121, LocationInfoConst.GOOGLE) == true) goto L40;
        r122 = false;
    L49:
        NotificationCompat.Builder r124 = r109.setSmallIcon(r119).setPriority(1).setOngoing(true).setAutoCancel(true).setWhen(System.currentTimeMillis()).setVisibility(1).setCategory(NotificationCompat.CATEGORY_TRANSPORT).setSound(null);
        int r125 = df1.a.f468195a;
        if (tb1.c.f545233e == false) goto L54;
        IHostContext r126 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r126 == null) goto L54;
        r120 = r126.appIcon();
    L54:
        if (r112 != null) goto L56;
    L58:
        r112 = BitmapFactory.decodeResource(r110.f104322d.getResources(), r120);
    L59:
        NotificationCompat.Builder r127 = r124.setContentTitle(r108).setLargeIcon(r112).setColor(r110.f104322d.getResources().getColor(R.color.ttlive_notification_control_icon_color));
        User r128 = r116.mo8271getOwner();
        if (r128 == null) goto L63;
        String r129 = r128.getNickName();
        if (r129 == null) goto L63;
    L64:
        r127.setContentText(r129).setContentIntent(r106).setSound(null);
        if (df1.a.d() == true) goto L90;
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### createNotification，isTalkRoomOnline = false");
        int r130 = u5.f159182a;
        androidx.media.app.NotificationCompat.MediaStyle r131 = new androidx.media.app.NotificationCompat.MediaStyle();
        r131.setMediaSession(r110.f104323e.f104309a.getSessionToken());
        r131.setShowActionsInCompactView(new int[]{0});
        IHostBusiness r132 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r132 == null) goto L69;
        r132.isDouyinPreInstall();
    L69:
        if (r111 == false) goto L73;
        IHostResProvider r133 = (IHostResProvider) jc1.k.f(IHostResProvider.class);
        if (r133 == null) goto L76;
        int r134 = r133.getPlayIconResIdForNotify();
    L77:
        if (r134 != 0) goto L82;
        if (r111 == false) goto L81;
        r134 = R.drawable.ttlive_ic_small_notification_pause;
        goto L82
    L81:
        r134 = R.drawable.ttlive_ic_small_notification_play;
    L82:
        NotificationCompat.Builder r135 = r124.setStyle(r131);
        Intent r136 = new Intent("com.bytedance.livesdk.action.media_session.PLAY_OR_PAUSE");
        r136.setComponent(new ComponentName(r110.f104322d, LiveMediaSessionService.class));
        if (Build.VERSION.SDK_INT >= 23) goto L85;
    L87:
        PendingIntent r137 = PendingIntent.getService(r110.f104322d, 0, r136, 0);
    L88:
        r135.addAction(r134, "", r137);
    L92:
        int r138 = u5.f159182a;
        r124.setShowWhen(false);
        r100 = r124.build();     // Catch: Exception -> L95
    L97:
        r110.f104320b = r100;
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### createNotification success");
    L95:
        e = move-exception;
        ALogger.e(r110.f104319a, "LiveMediaSessionNotification###    builder.build(), error: " + e.getMessage());
        goto L97
    L85:
        if (r110.f104322d.getApplicationInfo().targetSdkVersion < 23) goto L87;
        r137 = PendingIntent.getService(r110.f104322d, 0, r136, 67108864);
    L76:
        r134 = 0;
        goto L77
    L73:
        IHostResProvider r139 = (IHostResProvider) jc1.k.f(IHostResProvider.class);
        if (r139 == null) goto L76;
        r134 = r139.getPauseIconResIdForNotify();
        goto L77
    L90:
        if (df1.a.b() == false) goto L92;
        r124.setContentTitle(s1.B(R.string.ttlive_background_service_title)).setContentText(s1.B(R.string.ttlive_background_service_content)).setLargeIcon(BitmapFactory.decodeResource(r110.f104322d.getResources(), r120));
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### createNotification，isTalkRoomOnline = true, enableCaptureAudioOnBackground = true");
    L63:
        r129 = "";
        goto L64
    L56:
        if (r112.isRecycled() == true) goto L58;
    L30:
        r119 = 0;
        goto L31
    L21:
        r105 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L116:
        Notification r140 = r110.f104320b;     // Catch: Exception -> L102
        if (r140 == null) goto L105;
        ALogger.i(r110.f104319a, "LiveMediaSessionNotification### notify");     // Catch: Exception -> L102
        NotificationManagerCompat.from(r110.f104322d.getApplicationContext()).notify(r110.f104325g, r140);     // Catch: Exception -> L102
    L105:
        if (ye1.f121680a.getValue().booleanValue() == true) goto L107;
        return;
    L107:
        if (df1.a.d() == true) goto L109;
        return;
    L109:
        if (df1.a.b() == false) goto L121;
        r110.f104326h.clear();
        RxUtilKt.c(Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).filter(c.f104314a).map(d.f104315a).distinctUntilChanged().filter(e.f104316a).take(1).subscribe(new f(r110), new g(r110)), r110.f104326h);
        return;
    L121:
        return;
    L102:
        e = move-exception;
        ALogger.e(r110.f104319a, "LiveMediaSessionNotification### notify error : " + e.getMessage());
        goto L105
    L8:
        if ((!Intrinsics.areEqual(r114, Boolean.valueOf(r111))) == true) goto L10;
        if (r112 != null) goto L10;
    }
}
