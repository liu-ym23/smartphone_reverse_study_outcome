package com.bytedance.android.livesdk.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.livestate.ILiveStateChecker;
import com.bytedance.android.livesdkapi.message.IPreviewMessageManager;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.EnterFromMerge;
import com.bytedance.android.livesdkapi.roomplayer.EnterMethod;
import com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView;
import com.bytedance.android.livesdkapi.roomplayer.IPreviewStateListener;
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsParams;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.PreviewRoomData;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePurePreviewView extends FrameLayout implements ILivePurePreviewView, md0.a.InterfaceC6802a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f156399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f156400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f156401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f156402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LivePlayerView f156403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PreviewRoomData f156404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f156405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f156406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f156407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f156408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f156409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IPreviewStateListener f156410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveMetricsParams f156411m;

    public static final class a {
    }

    public static final class b implements ILiveStateChecker.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePurePreviewView f156412a;

        @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateChecker.Callback
        public final void onError() {
        }

        public b(LivePurePreviewView r100) {
            this.f156412a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateChecker.Callback
        public final void onSuccess(boolean r100) {
            LivePurePreviewView r101 = this.f156412a;
            if (r100 == r101.f156400b) goto L9;
            r101.f156400b = r100;
            if (r101.f156408j == false) goto L8;
            if (r100 == true) goto L8;
            r101.f156408j = false;
        L8:
            r101.a();
        L9:
            if (r100 == true) goto L23;
            LivePlayerView r102 = this.f156412a.f156403e;
            if (r102 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
        L13:
            r102.getClient().stopAndRelease(this.f156412a.getContext());
            LivePlayerView r103 = this.f156412a.f156403e;
            if (r103 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
        L16:
            r103.setVisibility(8);
            if (this.f156412a.getMPreviewData() == null) goto L19;
            this.f156412a.getClass();
        L19:
            IPreviewStateListener r104 = this.f156412a.f156410l;
            if (r104 == null) goto L24;
            r104.onStateChange(2);
            return;
        L24:
            return;
        }
    }

    static {
    }

    public LivePurePreviewView(Context r100) {
        this(r100, null, 14);
    }

    @Override // md0.a.InterfaceC6802a
    public final boolean isVersionSupported(int r100, int r101) {
        return false;
    }

    @Override // md0.a.InterfaceC6802a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100) {
    }

    @Override // md0.a.InterfaceC6802a
    public final void onSeiUpdated(SeiAppData r100) {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void release() {
        this.f156409k = false;
        if (this.f156404f != null) goto L5;
        return;
    L5:
        LivePlayerView r100 = this.f156403e;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L8:
        r100.getClient().stopAndRelease(getContext());
        PreviewRoomData r101 = this.f156404f;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.needLogDuration == false) goto L19;
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from_merge", this.f156411m.getEnterFromMerge().lowerName()), TuplesKt.to("enter_method", this.f156411m.getEnterMethod().lowerName()), TuplesKt.to("anchor_id", r101.ownerOpenId), TuplesKt.to("room_id", Long.valueOf(r101.f162654id)), TuplesKt.to(IPerformanceManager.Params.room_type, "normal"), TuplesKt.to("action_type", "draw"), TuplesKt.to("duration", String.valueOf(getDurationTime()))});
        HashMap<String, String> r103 = r101.eventExtra;
        if (r103 == null) goto L16;
        r102.putAll(r103);
    L16:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_live_window_duration_v2", new Object[]{r102, am2.u.class, new am2.x()});
        return;
    }

    public final void a() {
        if (this.f156404f != null) goto L5;
        return;
    L5:
        if (this.f156400b == true) goto L10;
        LivePlayerView r100 = this.f156403e;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L9:
        r100.setVisibility(8);
    L10:
        b();
    }

    public final void b() {
        PreviewRoomData r100 = this.f156404f;
        if (r100 == null) goto L10;
        ILiveService r101 = TTLiveService.getLiveService();
        if (r101 == null) goto L11;
        ILiveStateChecker r102 = r101.getLiveStateChecker();
        if (r102 == null) goto L12;
        r102.checkAlive(r100.f162654id, new b(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void onShow() {
        if (this.f156404f != null) goto L5;
        return;
    L5:
        this.f156409k = true;
        LivePlayerView r100 = this.f156403e;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L8:
        r100.setVisibility(0);
        LivePlayerView r101 = this.f156403e;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L11:
        r101.getClient().unmute();
        this.f156401c = System.currentTimeMillis();
        PreviewRoomData r102 = this.f156404f;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.needLogShow == false) goto L22;
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from_merge", this.f156411m.getEnterFromMerge().lowerName()), TuplesKt.to("enter_method", this.f156411m.getEnterMethod().lowerName()), TuplesKt.to("anchor_id", r102.ownerOpenId), TuplesKt.to("room_id", Long.valueOf(r102.f162654id)), TuplesKt.to(IPerformanceManager.Params.room_type, "normal"), TuplesKt.to("action_type", "click")});
        HashMap<String, String> r104 = r102.eventExtra;
        if (r104 == null) goto L19;
        r103.putAll(r104);
    L19:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_live_show", new Object[]{r103, am2.u.class, new am2.x(), Room.class});
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void stop() {
        LivePlayerView r100 = this.f156403e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L5:
        r100.getClient().stop();
    }

    private final long getDurationTime() {
        long r100 = System.currentTimeMillis() - this.f156401c;
        if (r100 < 0) goto L5;
        return r100;
    L5:
        return 0;
    }

    public final PreviewRoomData getMPreviewData() {
        return this.f156404f;
    }

    public final String getStreamData() {
        return this.f156405g;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void addStateListener(IPreviewStateListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f156410l = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void changeMuteState(boolean r100) {
        if (r100 == false) goto L8;
        LivePlayerView r101 = this.f156403e;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L7:
        r101.getClient().mute();
        return;
    L8:
        LivePlayerView r102 = this.f156403e;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L11:
        r102.getClient().unmute();
    }

    public final void setMPreviewData(PreviewRoomData r100) {
        this.f156404f = r100;
    }

    public final void setPresenting(boolean r100) {
        this.f156409k = r100;
    }

    public final void setStreamData(String r100) {
        this.f156405g = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView
    public final void stream(String r210) {
        Intrinsics.checkNotNullParameter(r210, "jsonData");
        PreviewRoomData r100 = (PreviewRoomData) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), r210, PreviewRoomData.class);
        this.f156404f = r100;
        if (r100 == null) goto L5;
        r100.init();
    L5:
        PreviewRoomData r101 = this.f156404f;
        if (r101 == null) goto L49;
        StreamUrl r102 = r101.streamUrl;
        if (r102 == null) goto L10;
        boolean r103 = r102.isEncryptStreamUrl();
    L11:
        LivePlayerConfig r110 = new LivePlayerConfig(LivePlayerScene.INSTANCE.getPREVIEW(), String.valueOf(r101.f162654id), null, false, null, false, false, null, false, 0, false, 2044, null);
        r110.setEncrypt(r103);
        this.f156403e = new LivePlayerView(getContext(), r110);
        this.f156402d.removeAllViews();
        ViewGroup r104 = this.f156402d;
        LivePlayerView r105 = this.f156403e;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L14:
        r104.addView(r105);
        a();
        b();
        if (this.f156400b == true) goto L17;
        return;
    L17:
        StreamUrl r106 = r101.streamUrl;
        if (r106 == null) goto L20;
        String r107 = r106.getMultiStreamData();
    L21:
        this.f156405g = r107;
        LiveRequest.Builder r108 = new LiveRequest.Builder().streamType(LiveStreamType.VIDEO).preview(true).mute(true);
        StreamUrl r109 = r101.streamUrl;
        String r111 = "";
        if (r109 == null) goto L25;
        String r112 = r109.getMultiStreamData();
        if (r112 == null) goto L25;
    L26:
        LiveRequest.Builder r113 = r108.streamData(r112);
        StreamUrl r114 = r101.streamUrl;
        if (r114 == null) goto L32;
        String r115 = r114.getMultiStreamDefaultQualitySdkKey();
        if (r115 == null) goto L32;
        r111 = r115;
    L32:
        LiveRequest r116 = r113.resolution(r111).build();
        LivePlayerView r117 = this.f156403e;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L35:
        r117.getClient().stream(r116, new LivePurePreviewView$stream$$inlined$let$lambda$1(this));
        LivePlayerView r118 = this.f156403e;
        if (r118 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerView");
    L38:
        r118.setScaleType(2);
        Context r119 = getContext();
        long r120 = r101.f162654id;
        StreamUrl r121 = r101.streamUrl;
        if (r121 == null) goto L41;
        long r122 = r121.getId();
    L42:
        ILiveService r123 = TTLiveService.getLiveService();
        if (r123 == null) goto L47;
        IPreviewMessageManager r124 = r123.createPreviewMessageManager(r119, r120, new HashMap());
        if (r124 == null) goto L47;
        r124.startMessage();
        r124.addMessageListener(MessageType.STREAM_CONTROL_MESSAGE.getIntType(), this.f156399a);
        ALogger.i("LivePurePreviewView", "initPreviewMessageManager >>> start listen STREAM_CONTROL_MESSAGE, roomId=" + r120 + ", streamId=" + r122);
        return;
    L47:
        ALogger.e("LivePurePreviewView", "initPreviewMessageManager >>> createPreviewMessageManager failed");
        return;
    L41:
        r122 = 0;
    L25:
        r112 = "";
        goto L26
    L20:
        r107 = null;
        goto L21
    L10:
        r103 = false;
        goto L11
    }

    public LivePurePreviewView(Context r100, LiveMetricsParams r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new LiveMetricsParams(EnterFromMerge.HOMEPAGE_HOT, EnterMethod.LIVE_CELL);
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, null, 0);
        this.f156411m = r101;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_pure_preview_live_cover, this);
        this.f156399a = new d1(this);
        this.f156400b = true;
        this.f156402d = (ViewGroup) getRootView().findViewById(R.id.player_view_container);
        this.f156407i = 5000;
    }
}
