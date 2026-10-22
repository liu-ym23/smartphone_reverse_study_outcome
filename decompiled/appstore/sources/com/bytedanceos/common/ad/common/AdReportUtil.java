package com.bytedanceos.common.ad.common;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import com.bytedanceos.common.ad.entity.req.ReqReportEntity;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.networkv2.entity.ReqSnsReportEntity;
import com.bytedanceos.common.networkv2.entity.req.ReportCommonParams;
import com.bytedanceos.common.networkv2.entity.req.ReportCustomParams;
import com.bytedanceos.common.networkv2.rest.ReportV15Rest;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.q;

/* JADX INFO: loaded from: classes2.dex */
public class AdReportUtil {

    /* JADX INFO: renamed from: com.bytedanceos.common.ad.common.AdReportUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type = null;

        static {
            int[] r10 = new int[DeviceUtil.Type.values().length];
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type = r10;
            r10[DeviceUtil.Type.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE4G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public AdReportUtil() {
    }

    public static ReqReportEntity buildRestReport(AdReportParam.Event r10, ReportCustomParams r11) {
        ReqReportEntity r12 = new ReqReportEntity();
        ReportCommonParams r13 = new ReportCommonParams();
        r13.setUser_id(AccountDataCache.b().k());
        r13.setDevice_id(BaseApplication.c().i().getClientId());
        r13.setImei(BaseApplication.c().i().getClientId());
        r13.setAndroid_id(BaseApplication.c().i().mAndroid_Id);
        r13.setTimestamp(String.valueOf(System.currentTimeMillis() / 1000));
        r13.setIp(DeviceUtil.h());
        String[] r14 = DeviceUtil.g(BaseApplication.c());
        r13.setLatitude(r14[0]);
        r13.setLongitude(r14[1]);
        r13.setCountry(BaseApplication.c().i().mMcc);
        r13.setNetwork(e.S());
        r13.setOs_version(e.U(false));
        r13.setApp_version(String.valueOf(e.f0()));
        r13.setResolution(q.e(BaseApplication.c()));
        r13.setHardware_version(d.f10009a);
        r13.setEvent_id(r10.getId());
        r13.setEvent_name(r10.getName());
        r13.setProduct_name(getProductName());
        r13.setDevice_type(DeviceUtil.j());
        r13.setIs_tnt_connected(String.valueOf(DeviceUtil.k(BaseApplication.c())));
        r13.setScreen_orientation(String.valueOf(AdUtil.getOrientation(BaseApplication.c())));
        r13.setIs_teenager_mode("false");
        r12.setCommon_params(r13);
        r12.setCustom_params(r11);
        return r12;
    }

    private static String getProductName() {
        if (BaseApplication.c().o() == false) goto L6;
        return "Bytedance_App_AppStore";
    L6:
        return "Bytedance_App_GameStore";
    }

    public static int getSnsNt() {
        DeviceUtil.Type r10 = DeviceUtil.d(BaseApplication.c());
        int r11 = AnonymousClass1.$SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 4;
    L5:
        if (r11 == 2) goto L15;
        if (r11 == 3) goto L15;
        if (r11 == 4) goto L19;
        if (r11 == 5) goto L18;
        return 0;
    L18:
        return 3;
    L19:
        return 2;
    L15:
        return 1;
    }

    public static void reportSnsEvent(int r10, String r11) {
        ReqSnsReportEntity r12 = new ReqSnsReportEntity();
        r12.setEvent_type(r10);
        r12.setExtra(r11);
        r12.setOs_version(e.U(false));
        r12.setApp_version(BaseApplication.c().i().mVersionName);
        r12.setMac(BaseApplication.c().i().mMacAdress);
        r12.setWidth(q.h(BaseApplication.c()));
        r12.setHeight(q.g(BaseApplication.c()));
        r12.setImei(BaseApplication.c().i().getClientId());
        r12.setOpenudid(BaseApplication.c().i().mAndroid_Id);
        r12.setNt(getSnsNt());
        r12.setDisplay_density(q.d(BaseApplication.c().i().mDpi));
    }

    public static void reportSplash(AdReportParam.Event r10, RepSplashMediaEntity r11) {
        if (r10 == null) goto L20;
        if (r11 == null) goto L21;
        ReportCustomParams r12 = new ReportCustomParams();
        int r13 = r11.getCreative_type();
        if (r13 != 2) goto L8;
        r12.setWeb_url(r11.getWeb_url());
    L16:
        if (r10 != AdReportParam.Event.SPLASH_CLICK) goto L18;
        r12.setClickposition_type(r10.getClickPosType());
    L18:
        ReportV15Rest.instance().reportLog(buildRestReport(r10, r12), null);
        return;
    L8:
        if (r13 != 3) goto L10;
        r12.setTopic_id(r11.getSubject());
        goto L16
    L10:
        if (r13 != 4) goto L16;
        r12.setPkg_name(r11.getPkg());
        goto L16
    L21:
        return;
    }
}
