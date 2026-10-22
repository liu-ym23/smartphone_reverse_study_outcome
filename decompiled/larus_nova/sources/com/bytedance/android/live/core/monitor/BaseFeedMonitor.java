package com.bytedance.android.live.core.monitor;

import android.os.SystemClock;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.config.q10;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.d;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseFeedMonitor extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f64892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f64893b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$RequestType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SERVICE_REQUEST_TYPE_REFRESH", "SERVICE_REQUEST_TYPE_LOADMORE", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestType extends Enum<RequestType> {
        public static final RequestType SERVICE_REQUEST_TYPE_LOADMORE = null;
        public static final RequestType SERVICE_REQUEST_TYPE_REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestType[] f64894a = null;
        private final String type;

        static {
            RequestType r100 = new RequestType("SERVICE_REQUEST_TYPE_REFRESH", 0, "refresh");
            SERVICE_REQUEST_TYPE_REFRESH = r100;
            RequestType r101 = new RequestType("SERVICE_REQUEST_TYPE_LOADMORE", 1, GYLFetchType.LOAD_MORE);
            SERVICE_REQUEST_TYPE_LOADMORE = r101;
            f64894a = new RequestType[]{r100, r101};
        }

        public static RequestType valueOf(String r100) {
            return (RequestType) r27.a.a(RequestType.class, r100);
        }

        public static RequestType[] values() {
            return (RequestType[]) f64894a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public RequestType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$Scene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "SERVICE_SCENE_INNER_DRAW", "SERVICE_SCENE_DRAWER", "SERVICE_SCENE_ROOM_DRAW_SCHEMA", "SERVICE_SCENE_SKYLIGHT", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        public static final Scene SERVICE_SCENE_DRAWER = null;
        public static final Scene SERVICE_SCENE_INNER_DRAW = null;
        public static final Scene SERVICE_SCENE_ROOM_DRAW_SCHEMA = null;
        public static final Scene SERVICE_SCENE_SKYLIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f64895a = null;
        private final String desc;
        private final String scene;

        static {
            Scene r100 = new Scene("SERVICE_SCENE_INNER_DRAW", 0, "inner_draw", "内流");
            SERVICE_SCENE_INNER_DRAW = r100;
            Scene r101 = new Scene("SERVICE_SCENE_DRAWER", 1, "drawer", "抽屉");
            SERVICE_SCENE_DRAWER = r101;
            Scene r102 = new Scene("SERVICE_SCENE_ROOM_DRAW_SCHEMA", 2, "live_merge", "直播广场");
            SERVICE_SCENE_ROOM_DRAW_SCHEMA = r102;
            Scene r103 = new Scene("SERVICE_SCENE_SKYLIGHT", 3, "skylight", "天窗");
            SERVICE_SCENE_SKYLIGHT = r103;
            f64895a = new Scene[]{r100, r101, r102, r103};
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) f64895a.clone();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getScene() {
            return this.scene;
        }

        public Scene(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.scene = r102;
            this.desc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/monitor/BaseFeedMonitor$SubScene;", "", "", "subScene", "Ljava/lang/String;", "getSubScene", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "SERVICE_SUB_SCENE_NONE", "SERVICE_SUB_SCENE_DRAWER_SJB", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SubScene extends Enum<SubScene> {
        public static final SubScene SERVICE_SUB_SCENE_DRAWER_SJB = null;
        public static final SubScene SERVICE_SUB_SCENE_NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SubScene[] f64896a = null;
        private final String desc;
        private final String subScene;

        static {
            SubScene r100 = new SubScene("SERVICE_SUB_SCENE_NONE", 0, "none", "无");
            SERVICE_SUB_SCENE_NONE = r100;
            SubScene r101 = new SubScene("SERVICE_SUB_SCENE_DRAWER_SJB", 1, "drawer_sjb", "赛事抽屉");
            SERVICE_SUB_SCENE_DRAWER_SJB = r101;
            f64896a = new SubScene[]{r100, r101};
        }

        public static SubScene valueOf(String r100) {
            return (SubScene) r27.a.a(SubScene.class, r100);
        }

        public static SubScene[] values() {
            return (SubScene[]) f64896a.clone();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getSubScene() {
            return this.subScene;
        }

        public SubScene(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.subScene = r102;
            this.desc = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public BaseFeedMonitor() {
        this.f64892a = q10.f121023a.getValue();
    }

    public final void l() {
        this.f64893b = SystemClock.uptimeMillis();
    }

    public final void n(String r110, Scene r111, SubScene r112) {
        Intrinsics.checkNotNullParameter(r110, "requestType");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "subScene");
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        if (this.f64893b <= 0) goto L5;
        long r103 = SystemClock.uptimeMillis() - this.f64893b;
    L6:
        this.f64893b = 0;
        BaseMonitor.add(r100, "status_code", 0);
        BaseMonitor.add(r100, "status", 0);
        BaseMonitor.add(r100, "scene", r111.getScene());
        BaseMonitor.add(r100, BdpAppEventConstant.PARAMS_SUB_SCENE, r112.getSubScene());
        if (r103 <= 0) goto L9;
        BaseMonitor.add(r101, "latency", r103);
    L9:
        BaseMonitor.add(r102, "request_type", r110);
        LiveTracingMonitor.e("ttlive_request_feed_api_all", LiveTracingMonitor.EventModule.FEED, LiveTracingMonitor.EventType.SERVER_API_CALL, r100, r101, r102);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void m(Throwable r110, String r111, Scene r210, SubScene r211) {
        Intrinsics.checkNotNullParameter(r111, "requestType");
        Intrinsics.checkNotNullParameter(r210, "scene");
        Intrinsics.checkNotNullParameter(r211, "subScene");
        if (this.f64893b <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.f64893b = 0;
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        String r112 = null;
        if ((r110 instanceof CustomApiServerException) == false) goto L9;
        String r103 = ((CustomApiServerException) r110).getXTtLogId();
    L14:
        boolean r113 = r110 instanceof ApiServerException;
        boolean r114 = false;
        if (r113 == false) goto L18;
        int r115 = ((ApiServerException) r110).getErrorCode();
    L24:
        if (r113 == false) goto L27;
        r112 = ((ApiServerException) r110).getErrorMsg();
    L32:
        BaseMonitor.add(r100, "status_code", r115);
        BaseMonitor.add(r100, "status", 1);
        BaseMonitor.add(r100, "scene", r210.getScene());
        BaseMonitor.add(r100, BdpAppEventConstant.PARAMS_SUB_SCENE, r211.getSubScene());
        if (r103 != null) goto L35;
    L38:
        boolean r104 = true;
    L39:
        if (r104 == true) goto L41;
        BaseMonitor.add(r102, "logId", r103);
    L41:
        if (r112 != null) goto L43;
    L44:
        r114 = true;
    L45:
        if (r114 == true) goto L47;
        BaseMonitor.add(r102, "error_msg", r112);
    L47:
        BaseMonitor.add(r102, "error_code", r115);
        BaseMonitor.add(r102, "request_type", r111);
        if (this.f64892a.booleanValue() == false) goto L52;
        if (r110 == null) goto L52;
        d.d(new RuntimeException(r110), "feed request loadMore error");
    L52:
        LiveTracingMonitor.EventModule r105 = LiveTracingMonitor.EventModule.FEED;
        LiveTracingMonitor.EventType r106 = LiveTracingMonitor.EventType.SERVER_API_CALL;
        LiveTracingMonitor.e("ttlive_request_feed_api_error", r105, r106, r100, r101, r102);
        LiveTracingMonitor.e("ttlive_request_feed_api_all", r105, r106, r100, r101, r102);
        return;
    L43:
        if (r112.length() != 0) goto L45;
    L35:
        if (r103.length() == 0) goto L38;
        r104 = false;
        goto L39
    L27:
        if ((r110 instanceof NetworkErrorException) == false) goto L30;
        r112 = r110.getMessage();
        goto L32
    L30:
        if ((r110 instanceof Exception) == false) goto L32;
        r112 = r110.getMessage();
        goto L32
    L18:
        if ((r110 instanceof NetworkErrorException) == false) goto L21;
        r115 = ((NetworkErrorException) r110).statusCode;
        goto L24
    L21:
        if ((r110 instanceof ApiException) == false) goto L23;
        r115 = ((ApiException) r110).getErrorCode();
        goto L24
    L23:
        r115 = 0;
        goto L24
    L9:
        if ((r110 instanceof ResponseNoDataException) == false) goto L13;
        BaseResponse r107 = ((ResponseNoDataException) r110).getResponse();
        if (r107 == null) goto L13;
        r103 = r107.logId;
    L13:
        r103 = null;
        goto L14
    }
}
