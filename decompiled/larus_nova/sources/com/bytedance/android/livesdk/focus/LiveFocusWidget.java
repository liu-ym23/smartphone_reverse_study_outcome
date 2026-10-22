package com.bytedance.android.livesdk.focus;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.broadcast.api.ICameraInfoService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.sb;
import com.bytedance.android.livesdk.config.va;
import com.bytedance.android.livesdk.j5;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.focus.IFocusWidget;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.LiveAddPictureConfig;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/focus/LiveFocusWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdkapi/focus/IFocusWidget;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFocusWidget extends LiveWidget implements IFocusWidget, ILiveRecordService.RecordStatusChangeListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f125303g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125304h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f125305i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.focus.b f125308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f125309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f125310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f125311f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFocusWidget f125312a;

        public b(LiveFocusWidget r100) {
            this.f125312a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            int r102 = nz.d.f521310a;
            va1.b r103 = va1.b.a.f553922a;
            if (((ICameraInfoService) r103.a(ICameraInfoService.class)).m3() == false) goto L9;
            Pair<Float, Float> r104 = ((ICameraInfoService) r103.a(ICameraInfoService.class)).C4();
            this.f125312a.getClass();
            nc1.a r105 = LiveFocusWidget.xq();
            if (r105 == null) goto L7;
            r105.c(this.f125312a.containerView.getWidth(), this.f125312a.containerView.getHeight(), (int) r104.getFirst().floatValue(), (int) r104.getSecond().floatValue());
        L7:
            ALogger.i("FocusWidget", "apply preview focus info to live: " + r104.getFirst().floatValue() + ", " + r104.getSecond().floatValue());
        L9:
            if (((ICameraInfoService) r103.a(ICameraInfoService.class)).h() == false) goto L27;
            ExposureCompensationInfo r106 = ((ICameraInfoService) r103.a(ICameraInfoService.class)).p1();
            if (r106 == null) goto L28;
            int r107 = com.bytedance.android.livesdk.focus.b.f125319o;
            int r108 = r106.getMin();
            int r109 = r106.getMax();
            int r110 = r106.getExposure();
            this.f125312a.getClass();
            nc1.a r111 = LiveFocusWidget.xq();
            if (r111 == null) goto L16;
            r111.a();
        L16:
            this.f125312a.getClass();
            nc1.a r112 = LiveFocusWidget.xq();
            if (r112 == null) goto L19;
            r112.a();
        L19:
            if (r109 != r108) goto L21;
            float r113 = 0.0f;
        L22:
            this.f125312a.getClass();
            nc1.a r114 = LiveFocusWidget.xq();
            if (r114 == null) goto L25;
            r114.b(r113);
        L25:
            ALogger.i("FocusWidget", "apply preview exposure info to live: " + r113);
            return;
        L21:
            r113 = (((r110 - r108) / (r109 - r108)) * 0) + 0;
            goto L22
        L28:
            return;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.focus.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFocusWidget f125313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IFocusContext f125314b;

        @Override // com.bytedance.android.livesdk.focus.b.a
        public final ExposureCompensationInfo getCameraECInfo() {
            ExposureCompensationInfo r100 = new ExposureCompensationInfo();
            this.f125313a.getClass();
            nc1.a r101 = LiveFocusWidget.xq();
            if (r101 == null) goto L5;
            r101.a();
        L5:
            r100.setMin(0);
            this.f125313a.getClass();
            nc1.a r102 = LiveFocusWidget.xq();
            if (r102 == null) goto L8;
            r102.a();
        L8:
            r100.setMax(0);
            return r100;
        }

        @Override // com.bytedance.android.livesdk.focus.b.a
        public final void setExposure(int r100) {
            this.f125313a.getClass();
            nc1.a r101 = LiveFocusWidget.xq();
            if (r101 == null) goto L5;
            r101.b(r100);
        L5:
            IFocusContext r102 = this.f125314b;
            if (r102 == null) goto L8;
            r102.setExposure(r100);
        L8:
            LiveFocusWidget r103 = this.f125313a;
            Disposable r104 = r103.f125309d;
            if (r104 != null) goto L11;
        L15:
            r103.f125309d = Observable.timer(sb.f121195a.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.focus.c(r100));
            return;
        L11:
            if (r104.isDisposed() == true) goto L15;
            Disposable r105 = r103.f125309d;
            if (r105 == null) goto L15;
            r105.dispose();
            goto L15
        }

        public c(LiveFocusWidget r100, IFocusContext r101) {
            this.f125313a = r100;
            this.f125314b = r101;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFocusWidget f125315a;

        public d(LiveFocusWidget r100) {
            this.f125315a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Throwable -> L17
            Float r101 = Float.valueOf(0.0f);     // Catch: Throwable -> L17
            if (r100 == null) goto L9;
            j<IFocusContext> r102 = r100.getFocusContext();     // Catch: Throwable -> L17
            if (r102 == null) goto L9;
            IFocusContext r103 = r102.getValue();     // Catch: Throwable -> L17
            if (r103 == null) goto L9;
            Number r104 = Integer.valueOf(r103.getExposure());     // Catch: Throwable -> L17
        L11:
            if (Intrinsics.areEqual(r104, r101) == true) goto L20;
            this.f125315a.getClass();     // Catch: Throwable -> L17
            nc1.a r105 = LiveFocusWidget.xq();     // Catch: Throwable -> L17
            if (r105 == null) goto L24;
            r105.b(r104.floatValue());     // Catch: Throwable -> L17
            return;
        L24:
            return;
        L20:
            return;
        L9:
            r104 = r101;
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L25;
            throw th;
        }
    }

    static {
        f125303g = UtilityKotlinExtentionsKt.i(134) + UtilityKotlinExtentionsKt.i(8);
        f125304h = UtilityKotlinExtentionsKt.i(340) + UtilityKotlinExtentionsKt.i(8);
        f125305i = UtilityKotlinExtentionsKt.i(12);
    }

    @Override // com.bytedance.android.livesdkapi.focus.IFocusWidget
    public final boolean canAdjustExposure() {
        com.bytedance.android.livesdk.focus.b r100 = this.f125308c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f125325f != true) goto L7;
        return true;
    }

    public final void wq() {
        this.f125310e = Observable.timer(va.f121431a.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    public LiveFocusWidget() {
        this.f125306a = LazyKt.lazy(new LiveFocusWidget$focusIcon$2(this));
        this.f125307b = LazyKt.lazy(new LiveFocusWidget$exposureSeekBar$2(this));
    }

    public static nc1.a xq() {
        j<com.bytedance.android.live.pushstream.d> r100 = m.i().getLiveStream();
        if (r100 == null) goto L7;
        com.bytedance.android.live.pushstream.d r101 = r100.getValue();
        if (r101 == null) goto L7;
        return r101.e();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
        if (r101 == null) goto L7;
        j<IFocusContext> r102 = r101.getFocusContext();
        if (r102 == null) goto L7;
        IFocusContext r103 = r102.getValue();
    L8:
        if (r103 == null) goto L11;
        r103.setFocusWidget(this);
    L11:
        if (j5.f142018a.getValue().booleanValue() == false) goto L19;
        j<com.bytedance.android.live.pushstream.d> r104 = m.i().getLiveStream();
        if (r104 == null) goto L15;
        com.bytedance.android.live.pushstream.d r105 = r104.getValue();
    L16:
        if (r105 == null) goto L19;
        if (r103 == null) goto L19;
        wq();
        goto L19
    L15:
        r105 = null;
    L19:
        this.f125308c = new com.bytedance.android.livesdk.focus.b(this.containerView, (ImageView) this.f125306a.getValue(), (ExposureSeekBarView) this.f125307b.getValue(), new c(this, r103));
        if (qc1.a.f532433a.getValue().booleanValue() == false) goto L22;
        NewBroadcastMonitor.a r106 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.ANCHOR_SET_EXPOSURE, null, null, 14);
        r106.l(0);
        r106.i("status_msg", "LiveFocusWidget set exposure listener");
        r106.m("success");
        r106.a().report();
    L22:
        int r107 = f125303g;
        int r108 = f125304h;
        if (a0.b(this.dataCenter) == null) goto L29;
        IAbilityCenter r109 = a0.b(this.dataCenter);
        if (r109 == null) goto L30;
        ISessionRecordService r110 = (ISessionRecordService) r109.getAbility(ISessionRecordService.class);
        if (r110 == null) goto L30;
        r110.addRecordStatsChangeListener(this);
    L30:
        RoomContext r111 = RoomContext.a.c(r100, this.dataCenter, 0, 2);
        if (r111 == null) goto L43;
        com.bytedance.live.datacontext.m<Room> r112 = r111.getRoom();
        if (r112 == null) goto L43;
        Room r113 = r112.getValue();
        if (r113 == null) goto L43;
        RoomSpecificSceneTypeInfo r114 = r113.getSceneTypeInfo();
        if (r114 == null) goto L43;
        if (r114.isLandscapeVertical() != true) goto L43;
        Rect r115 = l00.c.a();
        if (r115 == null) goto L43;
        r107 = r115.top;
        r108 = s1.w() - r115.bottom;
    L43:
        int r116 = f125305i;
        com.bytedance.android.livesdk.focus.b r117 = this.f125308c;
        if (r117 == null) goto L47;
        r117.f125322c = r116;
        r117.f125320a = r107;
        r117.f125323d = r116;
        r117.f125321b = r108;
        return;
    L47:
        return;
    L29:
        l.d().e().addRecordStatsChangeListener(this);
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        if (a0.b(this.dataCenter) == null) goto L9;
        IAbilityCenter r100 = a0.b(this.dataCenter);
        if (r100 == null) goto L10;
        ISessionRecordService r101 = (ISessionRecordService) r100.getAbility(ISessionRecordService.class);
        if (r101 == null) goto L10;
        r101.removeRecordStatsChangeListener(this);
    L10:
        Disposable r102 = this.f125309d;
        if (r102 == null) goto L13;
        r102.dispose();
    L13:
        Disposable r103 = this.f125310e;
        if (r103 == null) goto L17;
        r103.dispose();
        return;
    L17:
        return;
    L9:
        l.d().e().removeRecordStatsChangeListener(this);
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        LiveAddPictureConfig r100 = LiveInfraSettingKeys.LIVE_ANCHOR_ADD_PICTURE_CONFIG.getValue();
        if (Intrinsics.areEqual(r100.getCameraResetEnable(), Boolean.TRUE) == false) goto L6;
        new Handler(Looper.getMainLooper()).postDelayed(new d(this), r100.getResetDelay());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.focus.IFocusWidget
    public final boolean isTapValid(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.livesdk.focus.b r101 = this.f125308c;
        if (r101 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getX() >= (r101.f125330k.getX() + r101.f125322c)) goto L7;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        if (this.f125311f == true) goto L21;
        return true;
    L21:
        return false;
    L7:
        if (r100.getX() > ((r101.f125330k.getWidth() + r101.f125330k.getX()) - r101.f125323d)) goto L13;
        if (r100.getY() < (r101.f125330k.getY() + r101.f125320a)) goto L13;
        if (r100.getY() > ((r101.f125330k.getHeight() + r101.f125330k.getY()) - r101.f125321b)) goto L13;
        r102 = true;
        goto L14
    L19:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRecordService.RecordStatusChangeListener
    public final void onChange(ILiveRecordService.RecordStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (r100 != ILiveRecordService.RecordStatus.RECORDING) goto L5;
        boolean r101 = true;
    L6:
        this.f125311f = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.focus.IFocusWidget
    public final void onSingleTap(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        ILiveExternalCameraServiceForOther r100 = (ILiveExternalCameraServiceForOther) k.f(ILiveExternalCameraServiceForOther.class);
        if (r100 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.focus.b r101 = this.f125308c;
        if (r101 == null) goto L39;
        float r102 = r110.getX();
        float r103 = r110.getY();
        if (r101.f125324e == true) goto L12;
    L15:
        r101.f125330k.removeView(r101.f125331l);
        ImageView r104 = r101.f125331l;
        r104.setImageResource(R.drawable.ttlive_icon_focus);
        r104.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(62), UtilityKotlinExtentionsKt.i(62));
        r105.leftMargin = ((int) r102) - (UtilityKotlinExtentionsKt.i(62) / 2);
        r105.topMargin = ((int) r103) - (UtilityKotlinExtentionsKt.i(62) / 2);
        r104.setLayoutParams(r105);
        r104.setAlpha(1.0f);
        r101.f125330k.addView(r101.f125331l);
        ((AnimatorSet) r101.f125327h.getValue()).start();
        r101.f125324e = true;
        float r106 = r110.getX();
        float r107 = r110.getY();
        if (r101.f125325f == false) goto L18;
        ((AnimatorSet) r101.f125329j.getValue()).end();
    L18:
        r101.f125330k.removeView(r101.f125332m);
        if (r106 <= (r101.f125330k.getWidth() - ((int) UtilityKotlinExtentionsKt.h(64.0f)))) goto L21;
        float r108 = r106 - UtilityKotlinExtentionsKt.h(51.5f);
    L22:
        double r109 = ((double) r101.f125332m.getSeekBarTotalLength()) * 0.5d;
        double r111 = ((double) r101.f125330k.getHeight()) - (((double) r101.f125332m.getSeekBarTotalLength()) * 0.5d);
        double r112 = r107;
        if (r112 >= r109) goto L25;
    L27:
        char r113 = 1;
        float[] r114 = null;
    L28:
        if (r114 == null) goto L31;
        ExposureSeekBarView r115 = r101.f125332m;
        float r116 = r114[0];
        float r117 = r114[r113];
        r115.f125291f = r116;
        r115.f125292g = r117;
        r115.f125296k = false;
        r115.f125293h = 0.5f;
        r115.invalidate();
        r115.setAlpha(1.0f);
        r101.f125333n.setExposure(0);
        r101.f125330k.addView(r101.f125332m);
        r101.f125325f = true;
    L31:
        LinkedHashMap r118 = new LinkedHashMap();
        r118.put("scene", "living");
        Integer r119 = com.bytedance.android.livesdk.sharedpref.b.f158117a.a();
        if (r119 != null) goto L35;
    L37:
        String r120 = "back";
    L38:
        r118.put("camera_type", r120);
        u.l().sendLog("livesdk_manual_adjust_camera_exposure", r118, new Object[0]);
        goto L39
    L35:
        if (r119.intValue() != 1) goto L37;
        r120 = NewBroadcastMonitor.CAPTURE.FRONT;
        goto L38
    L25:
        if (r112 > r111) goto L27;
        r113 = 1;
        r114 = new float[]{r108, r107};
        goto L28
    L21:
        r108 = r106 + UtilityKotlinExtentionsKt.h(51.5f);
        goto L22
    L12:
        if (r101.f125326g == false) goto L14;
        ((AnimatorSet) r101.f125327h.getValue()).end();
        goto L15
    L14:
        ((AnimatorSet) r101.f125328i.getValue()).end();
    L39:
        nc1.a r121 = xq();
        if (r121 == null) goto L42;
        r121.c(this.containerView.getWidth(), this.containerView.getHeight(), (int) r110.getX(), (int) r110.getY());
    L42:
        ALogger.d("FocusWidget", "focus on " + r110.getX() + ", " + r110.getY());
        LinkedHashMap r122 = new LinkedHashMap();
        StringBuilder r123 = new StringBuilder();
        r123.append(r110.getX());
        r123.append('-');
        r123.append(r110.getY());
        r122.put("point", r123.toString());
        NewBroadcastMonitor.g(NewBroadcastMonitor.SERVICE.SERVICE_CAMERA_CLICK_EXPOSURE, r122);
        return;
    L5:
        if (r100.isConnected() != true) goto L7;
    }

    @Override // com.bytedance.android.livesdkapi.focus.IFocusWidget
    public final void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "e1");
        Intrinsics.checkNotNullParameter(r101, "e2");
        com.bytedance.android.livesdk.focus.b r104 = this.f125308c;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.f125326g == false) goto L7;
        ((AnimatorSet) r104.f125327h.getValue()).end();
    L8:
        r104.f125330k.removeView(r104.f125331l);
        r104.f125330k.removeView(r104.f125332m);
        r104.f125330k.addView(r104.f125332m);
        r104.f125330k.addView(r104.f125331l);
        r104.f125325f = true;
        r104.f125324e = true;
        r104.f125332m.setProgress(r103);
        float r105 = r104.f125332m.getProgress();
        ExposureCompensationInfo r106 = r104.f125333n.getCameraECInfo();
        if (r106 == null) goto L18;
        int r107 = r106.getMin();
        int r108 = r106.getMax();
        if (Math.abs(r107) >= Math.abs(r108)) goto L15;
        r108 = -r107;
    L17:
        r104.f125333n.setExposure((int) ((r105 * (r108 - r107)) + r107));
        goto L18
    L15:
        if (Math.abs(r108) >= Math.abs(r107)) goto L17;
        r107 = -r108;
    L18:
        ((AnimatorSet) r104.f125329j.getValue()).start();
        ((AnimatorSet) r104.f125328i.getValue()).start();
        return;
    L7:
        ((AnimatorSet) r104.f125328i.getValue()).end();
        ((AnimatorSet) r104.f125329j.getValue()).end();
        goto L8
    }
}
