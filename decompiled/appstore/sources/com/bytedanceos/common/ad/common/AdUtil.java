package com.bytedanceos.common.ad.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.ad.entity.req.ReqAdEntity;
import com.bytedanceos.common.ad.entity.req.ReqAdPlaceEntity;
import com.bytedanceos.common.ad.entity.req.ReqAppEntity;
import com.bytedanceos.common.ad.entity.req.ReqDeviceEntity;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.k;
import com.bytedanceos.common.toolbox.q;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class AdUtil {

    /* JADX INFO: renamed from: com.bytedanceos.common.ad.common.AdUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Operator = null;
        static final /* synthetic */ int[] $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type = null;

        static {
            int[] r10 = new int[DeviceUtil.Operator.values().length];
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Operator = r10;
            r10[DeviceUtil.Operator.CHINA_TELECOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Operator[DeviceUtil.Operator.CHINA_MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Operator[DeviceUtil.Operator.CHINA_UNICOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            int[] r11 = new int[DeviceUtil.Type.values().length];
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type = r11;
            r11[DeviceUtil.Type.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L23:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L27:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[DeviceUtil.Type.MOBILE4G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    public AdUtil() {
    }

    public static ReqAdEntity buildRestAd(Context r10, int r11, boolean r12, String r13) {
        ReqAdEntity r14 = new ReqAdEntity();
        r14.setRequest_id(String.valueOf(System.currentTimeMillis()));
        ReqAdPlaceEntity r15 = new ReqAdPlaceEntity();
        r15.setAid(getAid(r11, r12));
        r15.setType(r11);
        r15.setSize(r13);
        r14.setAdplace(r15);
        ReqAppEntity r16 = new ReqAppEntity();
        r16.setName(BaseApplication.c().getAppName());
        r16.setPackage_name(BaseApplication.c().getPackageName());
        r16.setVersion(String.valueOf(e.f0()));
        r14.setApp(r16);
        ReqDeviceEntity r17 = new ReqDeviceEntity();
        if (e.G0() == false) goto L5;
        int r18 = 2;
    L6:
        r17.setType(r18);
        r17.setConn_type(getConnectType());
        r17.setMobile_network_code(getOperatorCode());
        r17.setOrientation(getOrientation(r10));
        r17.setResolution(q.e(r10));
        r17.setMac(BaseApplication.c().i().mMacAdress);
        r17.setImei(BaseApplication.c().i().getClientId());
        r17.setImei_enc(k.f(BaseApplication.c().i().getClientId()));
        r17.setAndroid_id(BaseApplication.c().i().mAndroid_Id);
        r17.setUuid(UUID.randomUUID().toString());
        r17.setVendor(AdConstant.Vendor.BYTEDANCE);
        r17.setModel(d.f10009a);
        r17.setOs(1);
        r17.setOs_version(Build.VERSION.RELEASE);
        r17.setMobile_country_code(BaseApplication.c().i().mMcc);
        String[] r19 = DeviceUtil.g(r10);
        r17.setGeo(r19[1] + "," + r19[0]);
        r17.setLanguage(getLanguage());
        r14.setDevice(r17);
        r14.setApi_sskey(getApiSskey(r14.getRequest_id()));
        r14.setApi_version(AdConstant.ApiVersion.API_1_2_4);
        return r14;
    L5:
        r18 = 1;
        goto L6
    }

    public static ReqAdEntity buildSplashRestAd(Context r10) {
        return buildSplashRestAd(r10, false);
    }

    public static String getAid(int r10, boolean r11) {
        if (r10 == 1) goto L7;
        return "";
    L7:
        if (BaseApplication.c().o() == false) goto L12;
        if (r11 == false) goto L10;
        return AdConstant.Aid.TNT_APP_STORE_OPEN_SCREEN;
    L10:
        return AdConstant.Aid.APP_STORE_OPEN_SCREEN;
    L12:
        if (r11 == false) goto L14;
        return AdConstant.Aid.TNT_GAME_STORE_OPEN_SCREEN;
    L14:
        return AdConstant.Aid.GAME_STORE_OPEN_SCREEN;
    }

    public static String getApiSskey(String r10) {
        return k.f(AdConstant.TOKEN + r10).toLowerCase();
    }

    public static int getConnectType() {
        DeviceUtil.Type r10 = DeviceUtil.d(BaseApplication.c());
        int r11 = AnonymousClass1.$SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Type[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 1;
    L5:
        if (r11 != 2) goto L7;
        return 2;
    L7:
        if (r11 != 3) goto L9;
        return 2;
    L9:
        if (r11 == 4) goto L14;
        if (r11 == 5) goto L18;
        return 0;
    L18:
        return 4;
    L14:
        return 3;
    }

    public static String getLanguage() {
        String r10 = Locale.getDefault().getLanguage().toLowerCase();
        r10.hashCode();
        if (r10.equals("en") == false) goto L5;
        return AdConstant.Language.EN;
    L5:
        if (r10.equals("zh") == true) goto L7;
        return AdConstant.Language.OTHER;
    L7:
        return AdConstant.Language.ZH;
    }

    public static String getOperatorCode() {
        DeviceUtil.Operator r10 = DeviceUtil.i(BaseApplication.c());
        int r11 = AnonymousClass1.$SwitchMap$com$bytedanceos$common$toolbox$DeviceUtil$Operator[r10.ordinal()];
        if (r11 != 1) goto L5;
        return AdConstant.OperatorCode.CHINA_TELECOM;
    L5:
        if (r11 != 2) goto L7;
        return AdConstant.OperatorCode.CHINA_MOBILE;
    L7:
        if (r11 == 3) goto L9;
        return "";
    L9:
        return AdConstant.OperatorCode.CHINA_UNICOM;
    }

    public static int getOrientation(Context r10) {
        if (r10.getResources().getConfiguration().orientation == 1) goto L7;
        return 2;
    L7:
        return 1;
    }

    public static String getSplashSpaceSize(Context r10) {
        DisplayMetrics r11 = q.c(r10);
        return r11.widthPixels + FixCard.FixStyle.KEY_X + (r11.heightPixels - r10.getResources().getDimensionPixelOffset(R$dimen.splash_ad_logo_layout_height));
    }

    public static ReqAdEntity buildSplashRestAd(Context r10, boolean r11) {
        return buildRestAd(r10, 1, r11, getSplashSpaceSize(r10));
    }
}
