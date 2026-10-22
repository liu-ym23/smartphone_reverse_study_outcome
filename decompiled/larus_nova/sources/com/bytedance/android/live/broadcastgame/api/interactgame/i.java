package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.api.model.GameType;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59310a = 0;

    static {
    }

    public static void a(JSONObject r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r101.getMessage();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        BaseMonitor.add(r100, "error_msg", r101.toString());
    L17:
        if ((r101 instanceof CustomApiServerException) == false) goto L20;
        CustomApiServerException r104 = (CustomApiServerException) r101;
        BaseMonitor.add(r100, "error_code", r104.getErrorCode());
        BaseMonitor.add(r100, "log_id", r104.getXTtLogId());
        return;
    L20:
        if ((r101 instanceof HttpResponseException) == false) goto L23;
        BaseMonitor.add(r100, "error_code", ((HttpResponseException) r101).getStatusCode());
        return;
    L23:
        if ((r101 instanceof ApiException) == false) goto L26;
        BaseMonitor.add(r100, "error_code", ((ApiException) r101).getErrorCode());
        return;
    L26:
        if ((r101 instanceof NetworkErrorException) == false) goto L28;
        BaseMonitor.add(r100, "error_code", ((NetworkErrorException) r101).statusCode);
        return;
    L28:
        BaseMonitor.add(r100, "error_code", -1);
        return;
    L15:
        BaseMonitor.add(r100, "error_msg", r101.getMessage());
        goto L17
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L13
    }

    public static void b(JSONObject r100, r r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        if (r101 == null) goto L5;
        BaseMonitor.add(r100, "game_id", r101.p());
        if (r102 == true) goto L11;
        BaseMonitor.add(r100, EventConstants.ExtraJson.GAME_NAME, r101.q());
    L11:
        String r103 = r101.b();
        if ((!TextUtils.isEmpty(r103)) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L18;
        BaseMonitor.add(r100, "app_id", r103);
        BaseMonitor.add(r100, "app_name", r101.q());
    L18:
        if (r101.r() != GameType.WMiniGame.getValue()) goto L20;
        BaseMonitor.add(r100, "wtimor_game_mode", r101.o());
    L20:
        BaseMonitor.add(r100, BdpAppEventConstant.PARAMS_GAME_TYPE, r101.r());
        return;
    L5:
        if (v.a() == false) goto L22;
        BaseMonitor.add(r100, AppConstants.BUNDLE_TIP, "game_extra is null");
        return;
    }
}
