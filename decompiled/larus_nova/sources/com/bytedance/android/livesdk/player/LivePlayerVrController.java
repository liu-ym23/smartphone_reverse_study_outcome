package com.bytedance.android.livesdk.player;

import android.view.MotionEvent;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdk.player.model.LiveStreamData;
import com.bytedance.android.livesdk.player.setting.SettingKeyUtils;
import com.bytedance.android.livesdk.player.vr.BaseVrStateManager;
import com.bytedance.android.livesdkapi.model.VideoEffectSixDofLiteModeParams;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerVrController implements ILivePlayerVRController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f155000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f155001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f155002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f155003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f155004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f155005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePlayerClient f155006h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.player.LivePlayerVrController$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/LivePlayerVrController$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 implements Observer<Boolean> {
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == true) goto L6;
            return;
        L6:
            throw null;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void disableVrRenderForStrategy() {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final int getGyroStatusInitial() {
        return this.f155006h.getPlayerContext().B;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final int getVRFov() {
        if (((Boolean) SettingKeyUtils.f156051f.getValue()).booleanValue() == false) goto L8;
        LiveStreamData r100 = this.f155006h.getPlayerContext().f154943s;
        if (r100 != null) goto L72;
        return -1;
    L72:
        return r100.d();
    L8:
        if (this.f154999a == true) goto L73;
        LiveRequest r101 = this.f155006h.getPlayerContext().f154925a;
        JSONObject r102 = null;
        if (r101 == null) goto L13;
        String r103 = r101.getStreamData();
    L14:
        if (r103 == null) goto L74;
        boolean r104 = false;
        if (r103.length() <= 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L22;
        r103 = null;
    L22:
        if (r103 == null) goto L75;
        this.f154999a = true;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L61
        JSONObject r107 = new JSONObject(r103);     // Catch: Throwable -> L61
        JSONObject r108 = r107.optJSONObject("common");     // Catch: Throwable -> L61
        String r109 = "";
        if (r108 == null) goto L31;
        JSONObject r110 = r108.optJSONObject("common_sdk_params");     // Catch: Throwable -> L61
        if (r110 == null) goto L31;
        String r111 = r110.optString(PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Throwable -> L61
        if (r111 == null) goto L31;
    L33:
        if (r111.length() <= 0) goto L35;
        r104 = true;
    L35:
        if (r104 == false) goto L37;
        r102 = new JSONObject(r111);     // Catch: Throwable -> L61
    L37:
        JSONObject r112 = r107.optJSONObject("data");     // Catch: Throwable -> L61
        if (r112 == null) goto L47;
        JSONObject r113 = r112.optJSONObject(PlayerResolution.SDKKEY.ORIGIN);     // Catch: Throwable -> L61
        if (r113 == null) goto L47;
        JSONObject r114 = r113.optJSONObject(PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Throwable -> L61
        if (r114 == null) goto L47;
        String r115 = r114.optString(OrderParamsKey.KEY_SDK_PARAM);     // Catch: Throwable -> L61
        if (r115 == null) goto L47;
        r109 = r115;
    L47:
        JSONObject r116 = new JSONObject(r109);     // Catch: Throwable -> L61
        if (r102 != null) goto L51;
    L55:
        JSONObject r117 = r116.optJSONObject("VR");     // Catch: Throwable -> L61
        if (r117 == null) goto L58;
        int r118 = JSONObjectProtectorUtils.getInt(r117, "FOV");     // Catch: Throwable -> L61
    L59:
        Object r119 = Result.m9449constructorimpl(Integer.valueOf(r118));     // Catch: Throwable -> L61
    L64:
        if (Result.m9452exceptionOrNullimpl(r119) == null) goto L67;
        r119 = -1;
    L67:
        Number r120 = (Number) r119;
        this.f155000b = r120.intValue();
        return r120.intValue();
    L58:
        r118 = -1;
        goto L59
    L51:
        if (r102.has("VR") != true) goto L55;
        JSONObject r121 = r102.optJSONObject("VR");     // Catch: Throwable -> L61
        if (r121 == null) goto L58;
        r118 = JSONObjectProtectorUtils.getInt(r121, "FOV");     // Catch: Throwable -> L61
    L31:
        r111 = "";
    L61:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L75:
        return -1;
    L18:
        r105 = false;
        goto L19
    L74:
        return -1;
    L13:
        r103 = null;
        goto L14
    L73:
        return this.f155000b;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final VideoEffectSixDofLiteModeParams getVideoEffectSixDofLiteModeParams() {
        return this.f155006h.getVideoEffectSixDofLiteModeParams();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final String getVrEffectContextId() {
        return this.f155006h.getVrEffectContextId();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final LiveVrEffectInfo getVrEffectInfo() {
        return this.f155006h.getVrEffectInfo();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final LiveVrEffectInfo getVrEffectManagerVrEffectInfoCopy() {
        return this.f155006h.getVrEffectManagerVrEffectInfoCopy();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final boolean isVrEffectPlusVersion() {
        return this.f155006h.isVrEffectPlusVersion();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final boolean isVrLive() {
        LiveStreamData r100 = this.f155006h.getPlayerContext().f154943s;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.c() != true) goto L7;
        return true;
    }

    public LivePlayerVrController(LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155006h = r100;
        this.f155000b = -1;
        this.f155001c = true;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final boolean checkSeiRawForVrMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiRaw");
        com.bytedance.android.livesdk.player.vr.d r101 = this.f155006h.getVrStreamManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sei");
        if (r101.c(r100) == true) goto L6;
        return true;
    L6:
        return BaseVrStateManager.a(r101.b(r100));
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void gyroEnable(boolean r100) {
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L6;
        r101.gyroEnable(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L6;
        r101.onTouchEvent(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void recenter(boolean r100) {
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L6;
        r101.z0();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void setGyroStatusInitial(int r100) {
        this.f155006h.getPlayerContext().B = r100;
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L9;
        if (r100 != 0) goto L6;
        boolean r102 = true;
    L7:
        r101.gyroEnable(r102);
        return;
    L6:
        r102 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void setVrDirectMode(int r100) {
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L6;
        r101.setVrDirectMode(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void setVrEffectLiteMode(VideoEffectSixDofLiteModeParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f155006h.setVrEffectLiteMode(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void setVrFovParsed(boolean r100) {
        if (((Boolean) SettingKeyUtils.f156051f.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        this.f154999a = r100;
        if (r100 == true) goto L9;
        this.f155000b = -1;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void toggleVr(boolean r100) {
        ITTLivePlayer r101 = this.f155006h.getPlayerContext().f154929e;
        if (r101 == null) goto L6;
        r101.toggleVr(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void updateVrEffectContextId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        this.f155006h.updateVrEffectContextId(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void updateVrEffectInfo(LiveVrEffectInfo r100) {
        this.f155006h.updateVrEffectInfo(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void updateVrEffectLayerStatus(List<Integer> r100) {
        this.f155006h.updateVrEffectLayerStatus(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void vrWatchMode(int r100) {
        if (r100 != ILivePlayerVRController.Companion.getPANORAMA_WATCH_MODE_FULLSCREEN()) goto L6;
        this.f155005g = true;
        com.bytedance.android.livesdk.player.utils.g.e(0, false, false, new LivePlayerVrController$handleVrWatchMode$1(this), 7);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void applyVrEffect(LiveVrEffectInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f155006h.applyVrEffect(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController
    public final void onHeadPoseUpdate(float r110, float r111, float r112, float r113, float r114, float r210, float r211) {
        int r100 = com.bytedance.android.livesdk.player.vr.a.f156256a;
        float r101 = r110 * r110;
        float r102 = ((r113 * r110) + (r111 * r112)) * 2.0f;
        float r103 = (float) Math.atan2(((double) ((r113 * r112) + (r110 * r111))) * 2.0d, 1.0d - (((double) ((r112 * r112) + r101)) * 2.0d));
        float r104 = (float) Math.atan2(((double) ((r113 * r111) + (r110 * r112))) * 2.0d, 1.0d - (((double) (r101 + (r111 * r111))) * 2.0d));
        if (Math.abs(r102) < 1) goto L5;
        float r105 = Math.copySign(1.57075f, r102);
    L6:
        List<Float> r106 = CollectionsKt.listOf(new Float[]{Float.valueOf((float) Math.toDegrees(r103)), Float.valueOf((float) Math.toDegrees(r104)), Float.valueOf((float) Math.toDegrees(r105))});
        if (r106.size() >= 3) goto L9;
        return;
    L9:
        this.f155006h.getEventHub().getVrViewAngleChange().postValue(r106);
        float r107 = ((Number) ListProtector.get(r106, 0)).floatValue();
        float r108 = ((Number) ListProtector.get(r106, 1)).floatValue();
        float r109 = ((Number) ListProtector.get(r106, 2)).floatValue();
        if (this.f155005g == false) goto L13;
        return;
    L13:
        if (this.f155001c == false) goto L15;
        this.f155002d = r107;
        this.f155003e = r108;
        this.f155004f = r109;
        this.f155001c = false;
        return;
    L15:
        double r115 = 2;
        if (Math.abs(((double) r107) - ((double) this.f155002d)) <= r115) goto L18;
    L21:
        this.f155005g = true;
        com.bytedance.android.livesdk.player.utils.g.e(0, false, false, new LivePlayerVrController$handleVrAngleChange$1(this), 7);
        return;
    L18:
        if (Math.abs(((double) r108) - ((double) this.f155003e)) > r115) goto L21;
        if (Math.abs(((double) r109) - ((double) this.f155004f)) > r115) goto L21;
        return;
    L5:
        r105 = (float) Math.asin(r102);
        goto L6
    }
}
