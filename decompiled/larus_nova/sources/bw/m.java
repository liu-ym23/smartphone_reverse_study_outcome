package bw;

import com.bytedance.android.gamecp.host_api.cloudgame.IFeatureService;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;

/* JADX INFO: loaded from: classes44.dex */
public interface m extends IBaseHostService {
    r getActionHandleService();

    nv.b getAiService();

    fw.c getBrowserService();

    tv.a getCloudGameService();

    IFeatureService getFeatureServiceApi();

    yv.a getHostAction();

    cw.d getHostAirCompressService();

    b getHostAppService();

    ov.a getHostBusiness();

    d getHostContext();

    e getHostDownloadService();

    f getHostFmpCalculatorService();

    g getHostFoldPadService();

    k getHostMonitorService();

    yv.b getHostNetwork();

    aw.b getHostPlayCardService();

    l getHostRouteOutCertDataService();

    n getHostSettingService();

    ov.b getHostVerifyService();

    q getHostVideoPlayerService();

    i getLiveService();

    j getLogService();

    p getUserService();

    Class<?> reflectInPlugin(String r100);
}
