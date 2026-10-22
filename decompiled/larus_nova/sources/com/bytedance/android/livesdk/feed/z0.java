package com.bytedance.android.livesdk.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class z0 extends BaseFeedMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f124605d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f124606e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f124607c;

    static {
        f124605d = BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_REFRESH.getType();
        f124606e = BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE.getType();
    }

    public z0() {
        this.f124607c = 0;
    }

    public final void o(Throwable r100, String r101) {
        if (this.f124607c <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.f124607c = 0;
        JSONObject r102 = new JSONObject();
        if ((r100 instanceof ApiException) == false) goto L8;
        int r103 = ((ApiException) r100).getErrorCode();
    L9:
        String r104 = r100.getMessage();
        BaseMonitor.add(r102, "error_code", r103);
        BaseMonitor.add(r102, "error_msg", r104);
        BaseMonitor.add(r102, "url", r101);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_image_load_all", 1, r102);
        LiveSlardarMonitor.monitorStatus("ttlive_feed_image_load_error", 1, r102);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    public static void p(boolean r100, String r101, BaseFeedMonitor.SubScene r102, Throwable r103) {
        if (BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_DRAWER_SJB != r102) goto L28;
        HashMap r104 = new HashMap();
        if (r100 == false) goto L7;
        String r105 = "1";
    L8:
        r104.put("status", r105);
        if (TextUtils.equals(r101, f124605d) == false) goto L11;
        String r106 = "refresh";
    L12:
        r104.put("api_type", r106);
        if (r103 != null) goto L15;
        String r107 = "";
    L25:
        String r108 = r107;
        int r109 = 0;
    L26:
        r104.put("error", r108);
        r104.put("code", String.valueOf(r109));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_vs_special_drawer_api", r104, new Object[]{Room.class});
        return;
    L15:
        if ((r103 instanceof ApiServerException) == false) goto L18;
        ApiServerException r110 = (ApiServerException) r103;
        r109 = r110.getErrorCode();
        r108 = r110.getErrorMsg();
        goto L26
    L18:
        if ((r103 instanceof NetworkErrorException) == false) goto L21;
        NetworkErrorException r111 = (NetworkErrorException) r103;
        r109 = r111.statusCode;
        r108 = r111.getMessage();
        goto L26
    L21:
        if ((r103 instanceof ApiException) == false) goto L23;
        ApiException r112 = (ApiException) r103;
        r109 = r112.getErrorCode();
        r108 = r112.getMessage();
        goto L26
    L23:
        r107 = r103.toString();
        goto L25
    L11:
        r106 = GYLFetchType.LOAD_MORE;
        goto L12
    L7:
        r105 = "2";
        goto L8
    }
}
