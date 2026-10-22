package com.bytedance.android.livesdk.model;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\bg\u0010hR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR(\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\"\u0010.\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\"\u00102\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR*\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\"\u0010T\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR\"\u0010W\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bW\u0010\u000b\u001a\u0004\bX\u0010\r\"\u0004\bY\u0010\u000fR\"\u0010Z\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u000b\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000fR\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010c¨\u0006i"}, d2 = {"Lcom/bytedance/android/livesdk/model/p0;", "Lpc0/a;", "", Constants.OperatorKey.KEY_VENDOR, "Ljava/lang/String;", "getVendor", "()Ljava/lang/String;", "C", "(Ljava/lang/String;)V", "", "version", "I", "getVersion", "()I", "D", "(I)V", "uiLayout", RXScreenCaptureService.KEY_INDEX, "B", "layoutKey", "c", "u", "style", "getStyle", "y", "", "timestamp", "J", "getTimestamp", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "l", "", "Lcom/bytedance/android/livesdk/model/RevSeiRegion;", "grids", "Ljava/util/List;", "e", "()Ljava/util/List;", "s", "(Ljava/util/List;)V", "mixGrids", "h", BaseSwitches.V, "count", "getCount", "m", "Lcom/bytedance/android/livesdk/model/q0;", "canvas", "Lcom/bytedance/android/livesdk/model/q0;", "getCanvas", "()Lcom/bytedance/android/livesdk/model/q0;", ce.f26396k, "(Lcom/bytedance/android/livesdk/model/q0;)V", "subScene", "getSubScene", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "eventParams", "Lorg/json/JSONObject;", "getEventParams", "()Lorg/json/JSONObject;", OfficeSDKRequestTag.KEY_NEW_USER, "(Lorg/json/JSONObject;)V", "Lcom/bytedance/android/livesdk/model/m0;", "anchorInteractInfo", "Lcom/bytedance/android/livesdk/model/m0;", "f", "()Lcom/bytedance/android/livesdk/model/m0;", ce.f26395j, "(Lcom/bytedance/android/livesdk/model/m0;)V", "Lcom/bytedance/android/livesdk/model/RevStreamSize;", "streamSize", "Lcom/bytedance/android/livesdk/model/RevStreamSize;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/model/RevStreamSize;", "x", "(Lcom/bytedance/android/livesdk/model/RevStreamSize;)V", "gameType", "getGameType", "r", "gameFull", "getGameFull", "o", "gameFullV2", "d", "p", "gameMixStreamType", "b", "q", "", "landscapeRadio", FaceService.girlLabel, ce.f26391f, "()F", "t", "(F)V", "portraitRadio", "getPortraitRadio", "w", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p0 implements pc0.a {

    @SerializedName("anchor_interact_info")
    private m0 anchorInteractInfo;

    @SerializedName("canvas")
    private q0 canvas;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("count")
    private long count;

    @SerializedName("event_params")
    private JSONObject eventParams;

    @SerializedName("game_full")
    private int gameFull;

    @SerializedName("game_full_v2")
    private int gameFullV2;

    @SerializedName("mix_stream_type")
    private int gameMixStreamType;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    private int gameType;

    @SerializedName("grids")
    private List<RevSeiRegion> grids;

    @SerializedName("landscape_ratio")
    private float landscapeRadio;

    @SerializedName("layout_key")
    private String layoutKey;

    @SerializedName("mix_grids")
    private List<RevSeiRegion> mixGrids;

    @SerializedName("portrait_ratio")
    private float portraitRadio;

    @SerializedName("stream_size")
    private RevStreamSize streamSize;

    @SerializedName("style")
    private int style;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private int subScene;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("ui_layout")
    private int uiLayout;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    private String f153943vendor;

    @SerializedName("ver")
    private int version;

    public static final class a {
    }

    static {
    }

    public p0() {
        this.layoutKey = "";
        this.channelId = "";
        this.grids = new ArrayList();
        this.mixGrids = new ArrayList();
        this.canvas = new q0();
    }

    @Override // pc0.a
    public final RevStreamSize a() {
        return this.streamSize;
    }

    @Override // pc0.a
    public final int b() {
        return this.gameMixStreamType;
    }

    @Override // pc0.a
    public final String c() {
        return this.layoutKey;
    }

    @Override // pc0.a
    public final int d() {
        return this.gameFullV2;
    }

    @Override // pc0.a
    public final List<RevSeiRegion> e() {
        return this.grids;
    }

    public final m0 f() {
        return this.anchorInteractInfo;
    }

    public final float g() {
        return this.landscapeRadio;
    }

    @Override // pc0.a
    public final q0 getCanvas() {
        return this.canvas;
    }

    @Override // pc0.a
    public final String getChannelId() {
        return this.channelId;
    }

    @Override // pc0.a
    public final int getGameType() {
        return this.gameType;
    }

    @Override // pc0.a
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // pc0.a
    public final int getVersion() {
        return this.version;
    }

    public final List<RevSeiRegion> h() {
        return this.mixGrids;
    }

    public final int i() {
        return this.uiLayout;
    }

    public final void A(long r100) {
        this.timestamp = r100;
    }

    public final void B(int r100) {
        this.uiLayout = r100;
    }

    public final void C(String r100) {
        this.f153943vendor = r100;
    }

    public final void D(int r100) {
        this.version = r100;
    }

    public final void j(m0 r100) {
        this.anchorInteractInfo = r100;
    }

    public final void k(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.canvas = r100;
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channelId = r100;
    }

    public final void m(long r100) {
        this.count = r100;
    }

    public final void n(JSONObject r100) {
        this.eventParams = r100;
    }

    public final void o(int r100) {
        this.gameFull = r100;
    }

    public final void p(int r100) {
        this.gameFullV2 = r100;
    }

    public final void q(int r100) {
        this.gameMixStreamType = r100;
    }

    public final void r(int r100) {
        this.gameType = r100;
    }

    public final void s(List<RevSeiRegion> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.grids = r100;
    }

    public final void t(float r100) {
        this.landscapeRadio = r100;
    }

    public final void u(String r100) {
        this.layoutKey = r100;
    }

    public final void v(List<RevSeiRegion> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mixGrids = r100;
    }

    public final void w(float r100) {
        this.portraitRadio = r100;
    }

    public final void x(RevStreamSize r100) {
        this.streamSize = r100;
    }

    public final void y(int r100) {
        this.style = r100;
    }

    public final void z(int r100) {
        this.subScene = r100;
    }
}
