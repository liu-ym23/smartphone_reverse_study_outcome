package com.bytedance.android.live.openplatform.api;

import android.view.Surface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017J\b\u0010\u0004\u001a\u00020\u0003H&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService;", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformService;", "Lcom/bytedance/android/live/base/IService;", "", "openLiveCastingMiniApp", "", "success", "Landroid/view/Surface;", "surface", "", "fps", "notifyMiniAppStartLinkCastResult", "Lorg/json/JSONObject;", "param", "clearSwitchingLock", "notifyMiniAppStopLinkCastResult", "newScene", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService$a;", "callback", "pauseLinkCastWhenSceneSwitched", "resumeLinkCastWhenSceneSwitched", "Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "getMemoryStatus", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openplatform.api.OpenPlatformAnchorServiceDummy")
public interface IMiddlewareOpenPlatformAnchorService extends IMiddlewareOpenPlatformService, IService {

    public interface a {
    }

    MemoryStatus getMemoryStatus();

    void notifyMiniAppStartLinkCastResult(boolean r100, Surface r101, int r102);

    void notifyMiniAppStopLinkCastResult(boolean r100, JSONObject r101, boolean r102);

    void openLiveCastingMiniApp();

    void pauseLinkCastWhenSceneSwitched(int r100, a r101);

    void resumeLinkCastWhenSceneSwitched(a r100);
}
