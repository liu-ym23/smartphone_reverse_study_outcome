package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.by0;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class VideoFloatWindowManager implements IFloatWindowManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f125075f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f125076g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f125077h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f125078i = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f125079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Room f125080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f125081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<IVideoFloatManager.VideoFloatManagerListener> f125082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.floatview.mob.b f125083e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowManager$ActionType;", "", "SHOW", "CLICK", "MUTECLICK", "CLOSE", "RETURNCLICK", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType CLOSE = null;
        public static final ActionType MUTECLICK = null;
        public static final ActionType RETURNCLICK = null;
        public static final ActionType SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f125084a = null;

        static {
            ActionType r100 = new ActionType("SHOW", 0);
            SHOW = r100;
            ActionType r101 = new ActionType("CLICK", 1);
            CLICK = r101;
            ActionType r102 = new ActionType("MUTECLICK", 2);
            MUTECLICK = r102;
            ActionType r103 = new ActionType("CLOSE", 3);
            CLOSE = r103;
            ActionType r104 = new ActionType("RETURNCLICK", 4);
            RETURNCLICK = r104;
            f125084a = new ActionType[]{r100, r101, r102, r103, r104};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) f125084a.clone();
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements nz.s {
        public a() {
        }

        @Override // nz.s
        public final void b() {
        }

        @Override // nz.s
        public final void onCreate(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // nz.s
        public final void onPause(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // nz.s
        public final void onStart(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // nz.s
        public final void onStop(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // nz.s
        public final void a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Iterator<Class> r101 = ((IHostApp) jc1.k.n(IHostApp.class)).getAllLiveActivity().iterator();
        L4:
            if (r101.hasNext() == false) goto L17;
            Class r102 = r101.next();
            if (r102 == null) goto L4;
            if (r102.isAssignableFrom(r100.getClass()) != true) goto L4;
            ALogger.i("VideoFloatWindowManager", "hide because of liveActivity destroyed activity is " + r100.getClass());
            q r103 = VideoFloatWindowManager.f125075f;
            IFloatWindowManager.a.a(b.a(), true, 1);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nz.s
        public final void c(Context r110) {
            q r100 = VideoFloatWindowManager.f125075f;
            Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            if (r101 == null) goto L6;
            Object r102 = r101.getOwnerUserIdString();
            if (r102 == null) goto L6;
        L8:
            if (Intrinsics.areEqual(r102, ((IUserService) jc1.k.n(IUserService.class)).user().n()) == false) goto L11;
            ALogger.i("VideoFloatWindowManager", "cant show: isAnchor");
            return;
        L11:
            Room r103 = b.a().f125080b;
            if (r103 == null) goto L14;
            long r104 = r103.getRoomId();
        L15:
            IBaseEpisodeMod r105 = null;
            if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r104, null), PaidSceneEnum.PAID_ROOM, 2) == true) goto L20;
            ALogger.i("VideoFloatWindowManager", "cant show: PaidLiveUtils.hasFullWatchRight is false");
            return;
        L20:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r104, null).F0(PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L23;
            ALogger.i("VideoFloatWindowManager", "cant show: paidManagerService check is false");
            return;
        L23:
            Integer r106 = (Integer) hd0.c.f().f481009b;
            if (r106 != null) goto L27;
        L28:
            ALogger.i("VideoFloatWindowManager", "cant show: LinkPlayerState != statle_idle");
            return;
        L27:
            if (r106.intValue() != 0) goto L28;
            ILivePlayerClient r107 = LivePlatformPlayerManager.f();
            if (r107 != null) goto L33;
        L160:
            ALogger.i("VideoFloatWindowManager", "cant show: player is released or in background");
            return;
        L33:
            if (r107.isPlaying() != true) goto L160;
            ILivePlayerClient r108 = LivePlatformPlayerManager.f();
            if (r108 != null) goto L37;
        L45:
            IHostGameCP r109 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
            if (r109 != null) goto L48;
        L51:
            if (r110 != null) goto L53;
            r110 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
        L53:
            RoomContext r111 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            boolean r112 = false;
            if (r111 == null) goto L60;
            com.bytedance.live.datacontext.i<Boolean> r113 = r111.isEnterFromPreviewLiveMix();
            if (r113 == null) goto L60;
            Boolean r114 = r113.getValue();
            if (r114 == null) goto L60;
            boolean r115 = r114.booleanValue();
        L62:
            if ((r110 instanceof Activity) == false) goto L109;
            Iterator<T> r116 = ((IHostApp) jc1.k.n(IHostApp.class)).getAllWatchLiveActivity(r115).iterator();
            boolean r117 = false;
        L65:
            if (r116.hasNext() == false) goto L69;
            if (Intrinsics.areEqual(((Activity) r110).getClass(), (Class) r116.next()) == false) goto L65;
            r117 = true;
            goto L65
        L69:
            ALogger.d("VideoFloatWindowManager", "can show: " + r117);
            if (p.e() == false) goto L78;
            if (r117 == true) goto L73;
            return;
        L73:
            if (((Activity) r110).isInPictureInPictureMode() == true) goto L181;
            p.f125259a = true;
            if (p.f125264f == true) goto L77;
            Lazy r118 = VideoFloatWindowLogger.f125239a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            return;
        L77:
            p.f125264f = false;
            return;
        L181:
            return;
        L78:
            q r119 = NewVideoInnerFloatManager.f125055p;
            if (NewVideoInnerFloatManager.b.a().i() == false) goto L81;
            r117 = false;
        L81:
            if (r117 == false) goto L184;
            p.f125259a = true;
            if (p.f125263e == true) goto L85;
            Lazy r120 = VideoFloatWindowLogger.f125239a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
        L87:
            if (p.d(r110) == false) goto L185;
            q r121 = VideoFloatWindowManager.f125075f;
            b.a().getClass();
            if (VideoFloatWindowManager.d() == true) goto L91;
            return;
        L91:
            if (b.a().e() == true) goto L187;
            b.a().f125080b = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            Room r122 = b.a().f125080b;
            if (r122 != null) goto L95;
            ALogger.i("VideoFloatWindowManager", "room is null");
            return;
        L95:
            if (r122.getEpisodeExtra2() == null) goto L100;
            EpisodeExtraInfo r123 = r122.getEpisodeExtra2();
            if (r123 == null) goto L99;
            r105 = r123.getEpisodeMod();
        L99:
            if (r105 == null) goto L100;
            return;
        L100:
            b.a().getClass();
        L106:
            th = move-exception;
            ALogger.e("VideoFloatWindowManager", th.toString());
            return;
        L102:
            if (Build.VERSION.SDK_INT < 26) goto L104;
            r110.startForegroundService(new Intent(r110, VideoFloatWindowService.class));     // Catch: Throwable -> L106
        L165:
            return;
        L104:
            r110.startService(new Intent(r110, VideoFloatWindowService.class));     // Catch: Throwable -> L106
            goto L165
        L187:
            return;
        L185:
            return;
        L85:
            p.f125263e = false;
            goto L87
        L184:
            return;
        L109:
            List<Class> r124 = ((IHostApp) jc1.k.n(IHostApp.class)).getAllWatchLiveActivity(r115);
            Activity r125 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
            Iterator<T> r126 = r124.iterator();
            boolean r127 = false;
        L111:
            if (r126.hasNext() == false) goto L119;
            Class r128 = (Class) r126.next();
            if (r125 == null) goto L115;
            Class<?> r129 = r125.getClass();
        L117:
            if (Intrinsics.areEqual(r129, r128) == false) goto L111;
            r127 = true;
            goto L111
        L115:
            r129 = null;
            goto L117
        L119:
            ALogger.d("VideoFloatWindowManager", "can show: " + r127);
            if (p.e() == false) goto L129;
            if (r127 == false) goto L191;
            if (r125 != null) goto L124;
            return;
        L124:
            if (r125.isInPictureInPictureMode() == true) goto L193;
            p.f125259a = true;
            if (p.f125264f == true) goto L128;
            Lazy r130 = VideoFloatWindowLogger.f125239a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            return;
        L128:
            p.f125264f = false;
            return;
        L193:
            return;
        L191:
            return;
        L129:
            q r131 = NewVideoInnerFloatManager.f125055p;
            if (NewVideoInnerFloatManager.b.a().i() == true) goto L133;
            r112 = r127;
        L133:
            if (r112 == false) goto L196;
            Lazy r132 = VideoFloatWindowLogger.f125239a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            p.f125259a = true;
            if (p.d(r110) == false) goto L197;
            q r133 = VideoFloatWindowManager.f125075f;
            b.a().getClass();
            if (VideoFloatWindowManager.d() == true) goto L139;
            return;
        L139:
            if (b.a().e() == true) goto L199;
            b.a().f125080b = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            Room r134 = b.a().f125080b;
            if (r134 != null) goto L143;
            ALogger.i("VideoFloatWindowManager", "room is null");
            return;
        L143:
            if (r134.getEpisodeExtra2() == null) goto L148;
            EpisodeExtraInfo r135 = r134.getEpisodeExtra2();
            if (r135 == null) goto L147;
            r105 = r135.getEpisodeMod();
        L147:
            if (r105 == null) goto L148;
            return;
        L148:
            b.a().getClass();
        L156:
            th = move-exception;
            ALogger.e("VideoFloatWindowManager", th.toString());
            return;
        L150:
            if (Build.VERSION.SDK_INT < 26) goto L153;
            if (r110 == null) goto L162;
            r110.startForegroundService(new Intent(r110, VideoFloatWindowService.class));     // Catch: Throwable -> L156
        L162:
            return;
        L153:
            if (r110 == null) goto L162;
            r110.startService(new Intent(r110, VideoFloatWindowService.class));     // Catch: Throwable -> L156
            goto L162
        L199:
            return;
        L197:
            return;
        L196:
            return;
        L60:
            r115 = false;
            goto L62
        L48:
            if (r109.interceptLiveFloatWindow() != true) goto L51;
            ALogger.i("VideoFloatWindowManager", "gamecp intercept float window");
            return;
        L37:
            if (r108.isMute() != true) goto L45;
            ILivePlayerClient r136 = LivePlatformPlayerManager.f();
            if (r136 == null) goto L41;
            State r137 = r136.getCurrentState();
        L43:
            if ((r137 instanceof State.Background) == false) goto L45;
        L41:
            r137 = null;
            goto L43
        L14:
            r104 = 0;
        L6:
            r102 = 0L;
            goto L8
        }

        @Override // nz.s
        public final void onResume(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            q r101 = VideoFloatWindowManager.f125075f;
            boolean r102 = false;
            IFloatWindowManager.a.a(b.a(), false, 3);
            if (p.e() == false) goto L37;
            RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r103 == null) goto L11;
            com.bytedance.live.datacontext.i<Boolean> r104 = r103.isEnterFromPreviewLiveMix();
            if (r104 == null) goto L11;
            Boolean r105 = r104.getValue();
            if (r105 == null) goto L11;
            r102 = r105.booleanValue();
        L11:
            List<Class> r106 = ((IHostApp) jc1.k.n(IHostApp.class)).getAllWatchLiveActivity(r102);
            Activity r107 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
            Iterator<T> r108 = r106.iterator();
        L13:
            if (r108.hasNext() == false) goto L53;
            Class r109 = (Class) r108.next();
            if (r107 == null) goto L17;
            Class<?> r110 = r107.getClass();
        L19:
            if (Intrinsics.areEqual(r110, r109) == false) goto L13;
            if ((!Intrinsics.areEqual(r107, r100)) == false) goto L13;
            if (r107.isFinishing() == true) goto L13;
            int r111 = l.f125236a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Object r112 = r100.getSystemService("activity");
            if ((r112 instanceof ActivityManager) == true) goto L27;
            r112 = null;
        L27:
            ActivityManager r113 = (ActivityManager) r112;
            if (r113 == null) goto L30;
            List<ActivityManager.AppTask> r114 = r113.getAppTasks();
        L31:
            if (r114 == null) goto L13;
            if (r114.size() <= 0) goto L13;
            ActivityManager.AppTask r115 = (ActivityManager.AppTask) ListProtector.get(r114, r114.size() - 1);
            if (r115 == null) goto L13;
            r115.moveToFront();
            goto L13
        L30:
            r114 = null;
            goto L31
        L17:
            r110 = null;
            goto L19
        L53:
            return;
        }
    }

    public static final class b {
        public static VideoFloatWindowManager a() {
            return (VideoFloatWindowManager) VideoFloatWindowManager.f125076g.getValue();
        }
    }

    public final boolean e() {
        Object r100 = jc1.a.b().getSystemService("keyguard");     // Catch: Exception -> L10
        if (r100 == null) goto L9;
        if (((KeyguardManager) r100).inKeyguardRestrictedInputMode() == true) goto L15;
        return false;
    L15:
        return true;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void reset() {
        this.f125080b = null;
    }

    static {
        f125075f = new q(jc1.a.b(), new a());
        f125076g = LazyKt.lazy(VideoFloatWindowManager$Companion$instance$2.INSTANCE);
        f125077h = 12.0f;
        f125078i = 162.0f;
    }

    public final rx1.g c() {
        return (rx1.g) rx1.l.a(this.f125079a);
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void showFloatWindow() {
        if (f125075f.f125265a == true) goto L5;
        return;
    L5:
        boolean r100 = p.f125259a;
        if (p.d(jc1.a.b()) == true) goto L8;
        return;
    L8:
        if (this.f125081c == true) goto L24;
        this.f125081c = true;
        rx1.g r101 = c();
        if (r101 != null) goto L13;
    L17:
        VideoFloatWindowView r102 = new VideoFloatWindowView(jc1.a.b(), 0);
        this.f125083e = r102.getFloatWindowLogger();
        r102.setFloatViewListener(new s(this));
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(b.a().f125080b).l1(PaidSceneEnum.ALL) == true) goto L20;
    L22:
        boolean r103 = false;
    L23:
        Context r104 = s1.getContext();
        Map<String, rx1.b> r105 = rx1.l.f539781a;
        rx1.l.a r106 = new rx1.l.a(r104);
        r106.f539784b = r102;
        r106.f539785c = 0;
        r106.f539786d = 0;
        r106.f539799q = this.f125079a;
        r106.f539787e = 2;
        int r107 = (int) UIUtils.dip2Px(jc1.a.b(), 12.0f);
        int r108 = (int) UIUtils.dip2Px(jc1.a.b(), 12.0f);
        r106.f539788f = r107;
        r106.f539789g = r108;
        AccelerateDecelerateInterpolator r109 = new AccelerateDecelerateInterpolator();
        r106.f539797o = 300;
        r106.f539798p = r109;
        r106.f539800r = true;
        r106.f539802t = true;
        r106.f539803u = r103;
        r106.f539801s = new t(this);
        r106.a();
        goto L24
    L20:
        if (by0.f119907a.getValue().booleanValue() == false) goto L22;
        r103 = true;
        goto L23
    L13:
        if (r101.f539762l != true) goto L17;
        rx1.g r110 = c();
        if (r110 == null) goto L17;
        r110.a();
    L24:
        Room r111 = b.a().f125080b;
        if (r111 == null) goto L27;
        long r112 = r111.getRoomId();
    L29:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r112, null), PaidSceneEnum.PAID_ROOM, 2) == true) goto L33;
        ALogger.i("VideoFloatWindowManager", "showFloatWindow cant show: PaidLiveUtils.hasFullWatchRight is false");
        return;
    L33:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r112, null).F0(PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L37;
        ALogger.i("VideoFloatWindowManager", "showFloatWindow cant show: paidManagerService check is false");
        return;
    L37:
        if (this.f125080b == null) goto L50;
        rx1.g r113 = c();
        if (r113 != null) goto L41;
    L43:
        rx1.g r114 = c();
        if (r114 == null) goto L51;
        r114.e();
        r114.c();
        KeyEvent.Callback r115 = r114.f539751a.f539747c;
        if ((r115 instanceof f) == false) goto L52;
        ((f) r115).h(this.f125080b, true);
        return;
    L52:
        return;
    L51:
        return;
    L41:
        if (r113.f539762l != true) goto L43;
        return;
    L50:
        return;
    L27:
        r112 = 0;
        goto L29
    }

    public VideoFloatWindowManager() {
        this.f125079a = "video_float_view";
        this.f125082d = new ArrayList();
    }

    public static boolean d() {
        Object r100 = jc1.a.b().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L11
        if (r100 == null) goto L10;
        PowerManager r101 = (PowerManager) r100;     // Catch: Throwable -> L11
        if (r101.isInteractive() == true) goto L16;
        if (r101.isScreenOn() == true) goto L16;
    L13:
        return false;
    L16:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final Room getCurRoom() {
        return this.f125080b;
    }

    public static final DataCenter b(VideoFloatWindowManager r100) {
        r100.getClass();
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.j<DataCenter> r102 = r101.getDataCenter2();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getValue();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.f125082d).contains(r100) == true) goto L8;
        ((ArrayList) this.f125082d).add(r100);
        r100.toString();
        ((ArrayList) this.f125082d).size();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.f125082d).contains(r100) == false) goto L8;
        ((ArrayList) this.f125082d).remove(r100);
        r100.toString();
        ((ArrayList) this.f125082d).size();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void setRoom(Room r100) {
        this.f125080b = r100;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void hideFloatWindow(boolean r100, boolean r101) {
        VideoFloatWindowService.Companion.stopService();
        com.bytedance.android.livesdk.floatview.mob.b r102 = this.f125083e;
        Object r103 = null;
        if (r102 == null) goto L5;
        int r104 = com.bytedance.android.livesdk.floatview.mob.b.f125241o;
        r102.l(r100, r101, null, null);
    L5:
        rx1.g r105 = c();
        if (r105 == null) goto L32;
        rx1.f r106 = r105.f539751a;
        if (r106 == null) goto L10;
        KeyEvent.Callback r107 = r106.f539747c;
    L12:
        if ((r107 instanceof f) == true) goto L14;
        r107 = null;
    L14:
        f r108 = (f) r107;
        if (r108 == null) goto L18;
        r108.stop();
    L18:
        if (r105.f539762l == false) goto L20;
        r105.c();
    L20:
        rx1.f r109 = r105.f539751a;
        if (r109 == null) goto L23;
        View r110 = r109.f539747c;
    L25:
        if ((r110 instanceof f) == false) goto L28;
        r103 = r110;
    L28:
        f r111 = (f) r103;
        if (r111 == null) goto L33;
        r111.reset();
        return;
    L33:
        return;
    L23:
        r110 = null;
        goto L25
    L10:
        r107 = null;
        goto L12
    }

    public static void g(List r100, ActionType r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r103 = new ArrayList(r100);
        int r104 = r.f125268a[r101.ordinal()];
        if (r104 != 1) goto L7;
        Iterator r105 = r103.iterator();
    L41:
        if (r105.hasNext() == false) goto L75;
        IVideoFloatManager.VideoFloatManagerListener r106 = (IVideoFloatManager.VideoFloatManagerListener) r105.next();
        if (r106 == null) goto L41;
        r106.onShow();
        goto L41
    L75:
        return;
    L7:
        if (r104 != 2) goto L9;
        Iterator r107 = r103.iterator();
    L35:
        if (r107.hasNext() == false) goto L74;
        IVideoFloatManager.VideoFloatManagerListener r108 = (IVideoFloatManager.VideoFloatManagerListener) r107.next();
        if (r108 == null) goto L35;
        r108.onClick();
        goto L35
    L74:
        return;
    L9:
        if (r104 != 3) goto L11;
        Iterator r109 = r103.iterator();
    L29:
        if (r109.hasNext() == false) goto L73;
        IVideoFloatManager.VideoFloatManagerListener r110 = (IVideoFloatManager.VideoFloatManagerListener) r109.next();
        if (r110 == null) goto L29;
        r110.onMuteButtonClick(r102);
        goto L29
    L73:
        return;
    L11:
        if (r104 != 4) goto L13;
        Iterator r111 = r103.iterator();
    L23:
        if (r111.hasNext() == false) goto L72;
        IVideoFloatManager.VideoFloatManagerListener r112 = (IVideoFloatManager.VideoFloatManagerListener) r111.next();
        if (r112 == null) goto L23;
        r112.onClose(r102);
        goto L23
    L72:
        return;
    L13:
        if (r104 != 5) goto L45;
        Iterator r113 = r103.iterator();
    L17:
        if (r113.hasNext() == false) goto L71;
        IVideoFloatManager.VideoFloatManagerListener r114 = (IVideoFloatManager.VideoFloatManagerListener) r113.next();
        if (r114 == null) goto L17;
        r114.onReturnClick();
        goto L17
    L71:
        return;
    }
}
