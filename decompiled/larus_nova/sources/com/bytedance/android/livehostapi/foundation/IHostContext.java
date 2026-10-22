package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.retrofit2.intercept.Interceptor;
import io.reactivex.Observable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostContext extends IMiddleWareHostContext, IHostContextForSaas {
    public static final String ENTERPRISE_VERIFY_SETTING = "douyin_enterprise_verify_setting";
    public static final String PAD_UI_OPT_SETTING = "douyin_pad_ui_opt_setting";
    public static final String POI_LOCAL_LIVING_ROOM_CLOSE_RIGHTS = "poi_local_living_room_close_rights";

    public @interface HostSettingKeys {
    }

    void formatEnterDetail(Context r100, HashMap<String, String> r101);

    @Override // com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    LocationResult getCurrentLocation();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    HostBoeParams getHostBoeParams();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    HostLargeFontParam getHostLargeFontModeParams();

    LocationResult getNearByLocation();

    String getNearbyCityCode();

    Interceptor getSandboxInterceptor();

    boolean hasSandboxRecord();

    boolean isMpInSandboxMode(String r100);

    boolean isOpSandboxDevMode();

    boolean isPpe();

    Observable<LocationResult> locationChangedForHS();

    void refreshLocationForHS(Context r100);

    void refreshLocationForHS(Context r100, boolean r101, boolean r102);

    boolean userFirstLaunch();
}
