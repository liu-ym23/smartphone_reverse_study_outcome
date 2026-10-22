package com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.bean.ILiveCastSourceUIDevice;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastLiveInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastOptionResolutionStrategyInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayState;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastResolutionInfo;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastService;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.config.n91;
import com.bytedance.android.livesdk.config.vi;
import com.bytedance.android.livesdk.config.zz0;
import com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService;
import com.bytedance.android.livesdkapi.depend.model.live.CastScreenData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveByteCastUIManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f104549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<a> f104550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f104551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LiveCastSourceUIDepend f104552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> f104553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f104554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CastStreamTimeShiftContext f104555g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static LiveCastOptionResolutionStrategyInfo f104556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f104557i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f104558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final GlobalPlayListener f104559k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final LiveByteCastUIManager f104560l = null;

    public static final class GlobalPlayListener implements ILiveCastSourceUIPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f104561a;

        public GlobalPlayListener() {
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final /* synthetic */ void onPlayerDeviceChanged(ILiveCastSourceUIDevice r100) {
            ILiveCastSourceUIPlayerListener.CC.$default$onPlayerDeviceChanged(this, r100);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final /* synthetic */ void onSwitchDecodeTypeResult(int r100) {
            ILiveCastSourceUIPlayerListener.CC.$default$onSwitchDecodeTypeResult(this, r100);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final /* synthetic */ void onVideoSwitched(String r100, String r101, boolean r102, int r103) {
            ILiveCastSourceUIPlayerListener.CC.$default$onVideoSwitched(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onComplete() {
            String r100 = LiveByteCastUIManager.f104549a;
            LiveByteCastUIManager.g(LiveByteCastUIManager$GlobalPlayListener$onComplete$1.INSTANCE);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onLoading() {
            String r100 = LiveByteCastUIManager.f104549a;
            LiveByteCastUIManager.g(LiveByteCastUIManager$GlobalPlayListener$onLoading$1.INSTANCE);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onPaused() {
            String r100 = LiveByteCastUIManager.f104549a;
            CastStreamTimeShiftContext r101 = LiveByteCastUIManager.f104555g;
            if (r101 == null) goto L7;
            m<Boolean> r102 = r101.isCastPlaying();
            if (r102 == null) goto L7;
            r102.setValue(Boolean.FALSE);
        L7:
            LiveByteCastUIManager.g(LiveByteCastUIManager$GlobalPlayListener$onPaused$1.INSTANCE);
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onPlay() {
            String r100 = LiveByteCastUIManager.f104549a;
            LiveByteCastUIManager.f104555g.isCastPlaying().setValue(Boolean.TRUE);
            LiveByteCastUIManager.g(new LiveByteCastUIManager$GlobalPlayListener$onPlay$1(this));
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onStopPlay() {
            String r100 = LiveByteCastUIManager.f104549a;
            LiveCastSourceUIDepend r101 = LiveByteCastUIManager.f104552d;
            String r102 = null;
            if (r101 == null) goto L5;
            Boolean r103 = r101.isSysExtendedCastMode();
        L7:
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L10;
            LiveByteCastUIManager.f104554f = false;
            return;
        L10:
            CastStreamTimeShiftContext r104 = LiveByteCastUIManager.f104555g;
            if (r104 == null) goto L15;
            m<Boolean> r105 = r104.isCastPlaying();
            if (r105 == null) goto L15;
            r105.setValue(Boolean.FALSE);
        L15:
            IHostLiveByteCast r106 = LiveByteCastUIManager.k();
            if (r106 != null) goto L18;
            return;
        L18:
            if (r106.enablePlayStatusAllOpt() == true) goto L30;
            IHostLiveByteCast r107 = LiveByteCastUIManager.k();
            if (r107 == null) goto L23;
            r102 = r107.getCastFlowFrom();
        L23:
            if (Intrinsics.areEqual(r102, "live") == false) goto L27;
            IHostLiveByteCast r108 = LiveByteCastUIManager.k();
            if (r108 == null) goto L27;
            IMiddlewareHostLiveByteCast.CC.showOrHideCastFlow$default(r108, false, "live", null, 0, 0, null, 56, null);
        L27:
            LiveByteCastUIManager.g(LiveByteCastUIManager$GlobalPlayListener$onStopPlay$1.INSTANCE);
            return;
        L30:
            return;
        L5:
            r103 = null;
            goto L7
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onPlayCommandSuccess(LiveCastPlayInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "playInfo");
            String r101 = LiveByteCastUIManager.f104549a;
            LiveCastSourceUIDepend r102 = LiveByteCastUIManager.f104552d;
            if (r102 == null) goto L5;
            Room r103 = r102.getCurRoom();
        L6:
            Room r104 = r103;
            LiveCastSourceUIDepend r105 = LiveByteCastUIManager.f104552d;
            if (r105 == null) goto L9;
            long r106 = r105.getCameraId();
        L10:
            LiveCastSourceUIDepend r107 = LiveByteCastUIManager.f104552d;
            if (r107 == null) goto L13;
            String r108 = r107.getTitle();
        L14:
            String r109 = r108;
            if (r104 == null) goto L20;
            IHostLiveByteCast r110 = LiveByteCastUIManager.k();
            if (r110 == null) goto L21;
            r110.savePlayInfo(true, r104, Long.valueOf(r106), r109, r100);
            return;
        L21:
            return;
        L20:
            return;
        L13:
            r108 = "";
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onResolutionChanged(LiveCastResolutionInfo r100) {
            String r101 = LiveByteCastUIManager.f104549a;
            LiveByteCastUIManager.f104554f = false;
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onPositionUpdate(long r100, long r101) {
            String r102 = LiveByteCastUIManager.f104549a;
            CastStreamTimeShiftContext r103 = LiveByteCastUIManager.f104555g;
            if (r103 == null) goto L8;
            m<Boolean> r104 = r103.isSupportStreamTimeShift();
            if (r104 == null) goto L8;
            if (r104.getValue().booleanValue() == true) goto L8;
        L15:
            return;
        L8:
            IHostLiveByteCast r105 = LiveByteCastUIManager.k();
            if (r105 == null) goto L11;
            LiveCastPlayState r106 = r105.getPlayState();
        L13:
            if (r106 != LiveCastPlayState.PLAYING) goto L15;
            r103.getTotalTime().setValue(Long.valueOf(r100));
            r103.getCurrentTime().setValue(Long.valueOf(r101));
            return;
        L11:
            r106 = null;
            goto L13
        }

        @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener
        public final void onPlayError(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            String r103 = LiveByteCastUIManager.f104549a;
            CastStreamTimeShiftContext r104 = LiveByteCastUIManager.f104555g;
            if (r104 == null) goto L7;
            m<Boolean> r105 = r104.isCastPlaying();
            if (r105 == null) goto L7;
            r105.setValue(Boolean.FALSE);
        L7:
            LiveByteCastUIManager.g(LiveByteCastUIManager$GlobalPlayListener$onPlayError$1.INSTANCE);
        }
    }

    public interface a {
        void x7();
    }

    public LiveByteCastUIManager() {
    }

    public static IHostLiveByteCast k() {
        return (IHostLiveByteCast) f104557i.getValue();
    }

    static {
        f104560l = new LiveByteCastUIManager();
        f104549a = "not_in_casting";
        f104550b = new LinkedHashSet();
        f104551c = new AtomicBoolean(false);
        f104555g = new CastStreamTimeShiftContext();
        f104557i = LazyKt.lazy(LiveByteCastUIManager$hostAdapter$2.INSTANCE);
        f104559k = new GlobalPlayListener();
    }

    public static void i() {
        LiveCastSourceUIDepend r100 = f104552d;
        if (r100 == null) goto L8;
        IHostLiveByteCast r101 = k();
        if (r101 == null) goto L9;
        r101.forceReplay(r100);
        return;
    L9:
        return;
    }

    public static com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a l() {
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r100 = f104553e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public static void m() {
        if (f104551c.compareAndSet(false, true) == false) goto L17;
        IHostLiveByteCast r100 = k();
        if (r100 == null) goto L7;
        r100.initCastUI();
    L7:
        IHostLiveByteCast r101 = k();
        if (r101 == null) goto L10;
        r101.removeGlobalPlayListener(f104559k);
    L10:
        IHostLiveByteCast r102 = k();
        if (r102 == null) goto L14;
        r102.addGlobalPlayListener(f104559k);
    L14:
        if (((ILiveByteCastService) k.f(ILiveByteCastService.class)) != null) goto L18;
        k.l(ILiveByteCastService.class, new LiveByteCastService());
        Unit r103 = Unit.INSTANCE;
        return;
    L18:
        return;
    }

    public static LiveCastOptionResolutionStrategyInfo p() {
        LiveCastOptionResolutionStrategyInfo r100 = f104556h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IHostLiveByteCast r101 = k();
        if (r101 == null) goto L9;
        String r102 = r101.liveClarityStrategy();
        if (r102 == null) goto L9;
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L28;
        return null;
    L28:
        JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L27
        boolean r104 = JSONObjectProtectorUtils.getBoolean(r103, "enable");     // Catch: Throwable -> L27
        String r105 = JSONObjectProtectorUtils.getString(r103, "recommend_solution_title");     // Catch: Throwable -> L27
        String r106 = JSONObjectProtectorUtils.getString(r103, "other_solution_title");     // Catch: Throwable -> L27
        String r107 = JSONObjectProtectorUtils.getString(r103, "recommend_tag_text");     // Catch: Throwable -> L27
        String r108 = JSONObjectProtectorUtils.getString(r103, "clarity_tag_text");     // Catch: Throwable -> L27
        int r109 = JSONObjectProtectorUtils.getInt(r103, "resolution_limit");     // Catch: Throwable -> L27
        if (r108 != null) goto L16;
        r108 = "";
    L16:
        if (r107 != null) goto L18;
        String r110 = "";
    L19:
        if (r105 != null) goto L21;
        String r111 = "";
    L22:
        if (r106 != null) goto L24;
        String r112 = "";
    L25:
        LiveCastOptionResolutionStrategyInfo r113 = new LiveCastOptionResolutionStrategyInfo(r104, r109, r108, r110, r111, r112);     // Catch: Throwable -> L27
        f104556h = r113;     // Catch: Throwable -> L27
        return r113;
    L24:
        r112 = r106;
        goto L25
    L21:
        r111 = r105;
        goto L22
    L18:
        r110 = r107;
    L27:
        return null;
    L9:
        r102 = "";
        goto L11
    }

    public static void d() {
        IHostLiveByteCast r100 = k();
        if (r100 == null) goto L6;
        r100.closeAllCastActivity();
        return;
    }

    public static void e() {
        IHostLiveByteCast r100 = k();
        if (r100 == null) goto L6;
        r100.closeAllCastActivity();
        return;
    }

    public static boolean o() {
        IHostLiveByteCast r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.liveCastUseStreamData();
    }

    public static boolean r() {
        IHostLiveByteCast r100 = k();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isValid() != true) goto L7;
        return true;
    }

    public static boolean t() {
        IHostLiveByteCast r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.useNewPortraitUi();
    }

    public static boolean u() {
        IHostLiveByteCast r100 = k();
        if (r100 == null) goto L9;
        JSONObject r101 = r100.getCastUISettings();
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r101.optInt("should_weaken", 0) != 0) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }

    public static boolean a(DataCenter r100) {
        IHostLiveByteCast r101 = k();
        if (r101 == null) goto L5;
        boolean r102 = r101.isCasting();
    L6:
        if (r102 == false) goto L33;
        Room r103 = null;
        if (u() == false) goto L16;
        IHostLiveByteCast r104 = k();
        if (r104 == null) goto L25;
        IHostLiveByteCast r105 = k();
        if (r105 == null) goto L14;
        ILiveCastSourceUIDevice r106 = r105.getCastingDevice();
    L15:
        boolean r107 = r104.isOfficalDevice(r106);
    L26:
        if (r107 == true) goto L31;
        if (r100 == null) goto L30;
        r103 = z.o(r100);
    L30:
        if (q(r103) == false) goto L31;
        return false;
    L31:
        return true;
    L14:
        r106 = null;
    L25:
        r107 = false;
        goto L26
    L16:
        IHostLiveByteCast r108 = k();
        if (r108 == null) goto L25;
        ILiveCastSourceUIDevice r109 = r108.getCastingDevice();
        if (r109 == null) goto L25;
        String r110 = r109.deviceName();
        if (r110 == null) goto L25;
        if (StringsKt.contains$default(r110, "鲜时光", false, 2, null) != true) goto L25;
        r107 = true;
        goto L26
    L33:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static boolean b(Room r100) {
        if (r100 == null) goto L10;
        CastScreenData r101 = r100.castScreen;
        if (r101 == null) goto L10;
        List<Long> r102 = r101.getAllowDeviceList();
        if (r102 == null) goto L10;
        if (r102.contains(1L) != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static void f(DataCenter r100) {
        Room r101 = null;
        if (r100 == null) goto L5;
        Room r102 = z.o(r100);
    L7:
        if (b(r102) == false) goto L17;
        if (r100 == null) goto L11;
        r101 = z.o(r100);
    L11:
        if (h(r101) == true) goto L19;
        IHostLiveByteCast r103 = k();
        if (r103 == null) goto L18;
        r103.liveOnlySupportXsg();
        return;
    L18:
        return;
    L19:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public static void g(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        IHostLiveByteCast r101 = k();
        String r102 = null;
        if (r101 == null) goto L7;
        LiveCastPlayInfo r103 = r101.getCastingPlayInfo();
        if (r103 == null) goto L7;
        String r104 = r103.getVideoId();
    L8:
        LiveCastSourceUIDepend r105 = f104552d;
        if (r105 == null) goto L12;
        r102 = r105.getVideoId();
    L12:
        if (Intrinsics.areEqual(r104, r102) == false) goto L15;
        r100.invoke();
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public static boolean h(Room r100) {
        if (r100 == null) goto L6;
        CastScreenData r101 = r100.castScreen;
        if (r101 == null) goto L6;
        Integer r102 = r101.getForceCastOnly();
    L7:
        if (r102 != null) goto L10;
    L12:
        return false;
    L10:
        if (r102.intValue() != 1) goto L12;
        return true;
    L6:
        r102 = null;
        goto L7
    }

    public static void n(DataCenter r100) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r101 = CastScreenViewModel.a.a();
        if (r101 == null) goto L23;
        m<Boolean> r102 = r101.getCastOrMirrorScreenMode();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getValue().booleanValue() != true) goto L25;
        IHostLiveByteCast r103 = k();
        String r104 = null;
        if (r103 == null) goto L15;
        LiveCastPlayInfo r105 = r103.getCastingPlayInfo();
        if (r105 == null) goto L15;
        LiveCastLiveInfo r106 = r105.getLiveInfo();
        if (r106 == null) goto L15;
        Long r107 = Long.valueOf(r106.getRoomId());
    L16:
        String r108 = String.valueOf(r107);
        if (r100 == null) goto L21;
        Room r109 = z.o(r100);
        if (r109 == null) goto L21;
        r104 = r109.getIdStr();
    L21:
        Intrinsics.areEqual(r108, r104);
        return;
    L15:
        r107 = null;
        goto L16
    L25:
        return;
    }

    public static boolean q(Room r100) {
        if (u() == false) goto L6;
        return false;
    L6:
        if (h(r100) == false) goto L9;
        return true;
    L9:
        if (b(r100) == true) goto L11;
        return false;
    L11:
        ArrayList<String> r101 = com.bytedance.android.livesdk.castscreen.utils.d.f104735a;
        Integer r102 = null;
        if (r100 == null) goto L16;
        CastScreenData r103 = r100.castScreen;
        if (r103 == null) goto L16;
        Integer r104 = r103.getForceCastOnly();
    L17:
        if (r104 != null) goto L20;
    L21:
        if (r100 == null) goto L41;
        CastScreenData r105 = r100.castScreen;
        if (r105 == null) goto L42;
        List<Long> r106 = r105.getAllowDeviceList();
        if (r106 != null) goto L27;
        return false;
    L27:
        if (r106.contains(1L) != true) goto L44;
        n91 r107 = zz0.f121803a.getValue();
        if (r107 == null) goto L31;
        r102 = r107.a();
    L31:
        if (r102 != null) goto L34;
    L39:
        return true;
    L34:
        if (r102.intValue() != 0) goto L39;
        IHostLiveByteCast r108 = LiveByteCastManager.d();
        if (r108 != null) goto L38;
        return false;
    L38:
        if (r108.liveOnlySupportXsg() == true) goto L39;
        return false;
    L44:
        return false;
    L42:
        return false;
    L41:
        return false;
    L20:
        if (r104.intValue() == 1) goto L39;
    L16:
        r104 = null;
        goto L17
    }

    public static void x(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        IHostLiveByteCast r101 = k();
        if (r101 == null) goto L5;
        final ILiveCastSourceUIDevice r102 = r101.getCastingDevice();
    L6:
        Lazy r103 = LiveByteCastUIHelper.f104523a;
        Function0<Unit> r104 = new LiveByteCastUIManager$toastForTv$1(r102, r100);
        Intrinsics.checkNotNullParameter(r104, "block");
        LiveByteCastUIHelper.f104529g.postDelayed(new b(r104), 1000);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static View j(Context r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == false) goto L9;
        IHostLiveByteCast r102 = k();
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.getCastHalfControlView(r100, f104552d);
    L9:
        IHostLiveByteCast r103 = k();
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.getCastLandscapeControlView(r100, f104552d);
    }

    public static void s(DataCenter r100, com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r101) {
        f104552d = new LiveCastSourceUIDepend(new WeakReference(r100), new WeakReference(r101));
        f104553e = new WeakReference(r101);
        Room r102 = d.f104591a;
        d.f104593c = new WeakReference(r101);
        f104554f = false;
    }

    public static void w(View r100, boolean r101) {
        LiveCastSourceUIDepend r102 = f104552d;
        if (r102 == null) goto L8;
        IHostLiveByteCast r103 = k();
        if (r103 == null) goto L9;
        r103.startCastSendPlay(r100, r102, null, r101);
        return;
    L9:
        return;
    }

    public final void c(Context r100, DataCenter r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "from");
        v(r100, r101, r102, r103, null);
    }

    public static void v(Context r100, final DataCenter r101, boolean r110, String r111, View r112) {
        Intrinsics.checkNotNullParameter(r111, "from");
        m();
        if (r100 != null) goto L5;
        return;
    L5:
        Lazy r102 = LiveByteCastUIHelper.f104523a;
        if (r101 == null) goto L8;
        Room r103 = z.o(r101);
    L9:
        Room r104 = r103;
        LiveByteCastUIManager$startCast$1 r105 = LiveByteCastUIManager$startCast$1.INSTANCE;
        Boolean r106 = Boolean.FALSE;
        LiveByteCastUIHelper.c(r104, "cast_stream_new", "cast_stream_origin", r111, false, r106, r105);
        CastStreamTimeShiftContext r107 = f104555g;
        r107.initRoomData(r101);
        if (Intrinsics.areEqual(vi.f121452a.getValue(), Boolean.TRUE) == false) goto L12;
        r107.isSupportStreamTimeShift().setValue(r106);
    L12:
        LiveCastSourceUIDepend r108 = f104552d;
        if (r108 == null) goto L89;
        f104558j = r111;
        IHostLiveByteCast r113 = k();
        boolean r109 = false;
        if (r113 == null) goto L17;
        boolean r114 = r113.isCasting();
    L18:
        if (r114 == true) goto L23;
        IHostLiveByteCast r115 = (IHostLiveByteCast) LiveByteCastUIEventHelper.f104521a.getValue();
        if (r115 == null) goto L23;
        r115.logScreenCastEnter(new LiveByteCastUIEventHelper$logScreenCastEnter$1(r101));
    L23:
        if (r110 == false) goto L54;
        if (a(r101) == false) goto L50;
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r116 = CastScreenViewModel.a.a();
        if (r116 == null) goto L45;
        m<Boolean> r117 = r116.getCastOrMirrorScreenMode();
        if (r117 == null) goto L45;
        if (r117.getValue().booleanValue() != true) goto L45;
        IHostLiveByteCast r118 = k();
        if (r118 != null) goto L36;
    L42:
        IHostLiveByteCast r119 = k();
        if (r119 == null) goto L93;
        r119.startCastControlActivity(r100, f104552d);
        return;
    L93:
        return;
    L36:
        if (r118.useNewPortraitUi() != true) goto L42;
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r120 = f104553e;
        if (r120 == null) goto L90;
        com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r121 = r120.get();
        if (r121 == null) goto L91;
        r121.b();
        return;
    L91:
        return;
    L90:
        return;
    L45:
        i();
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r122 = f104553e;
        if (r122 == null) goto L95;
        com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r123 = r122.get();
        if (r123 == null) goto L96;
        r123.b();
        return;
    L96:
        return;
    L95:
        return;
    L50:
        IHostLiveByteCast r124 = k();
        if (r124 == null) goto L98;
        r124.startCast(r100, f104552d, false);
        return;
    L98:
        return;
    L54:
        if (a(r101) == false) goto L79;
        IHostLiveByteCast r125 = k();
        if (r125 != null) goto L58;
    L69:
        IHostLiveByteCast r126 = k();
        if (r126 == null) goto L72;
        r126.forceReplay(r108);
    L72:
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r127 = f104553e;
        if (r127 == null) goto L87;
        com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r128 = r127.get();
        if (r128 == null) goto L88;
        r128.b();
        return;
    L88:
        return;
    L87:
        return;
    L58:
        if (r125.enablePlayStatusAllOpt() != true) goto L69;
        if (r112 == null) goto L61;
        w(r112, true);
        goto L72
    L61:
        Resources r129 = r100.getResources();
        if (r129 == null) goto L68;
        Configuration r130 = r129.getConfiguration();
        if (r130 == null) goto L68;
        if (r130.orientation != 1) goto L68;
        r109 = true;
    L68:
        w(j(r100, r109), true);
        goto L72
    L79:
        if (LiveByteCastUIHelper.k(r101) == false) goto L83;
        IHostLiveByteCast r131 = k();
        if (r131 == null) goto L100;
        r131.startCast(r100, r108, false);
        return;
    L100:
        return;
    L83:
        IHostLiveByteCast r132 = k();
        if (r132 == null) goto L102;
        r132.startCast(r100, r108, true);
        return;
    L102:
        return;
    L17:
        r114 = false;
        goto L18
    L89:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
