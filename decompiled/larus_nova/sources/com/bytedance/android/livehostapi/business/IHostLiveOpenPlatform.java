package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.openplatform.IAppStatusListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.ILiveMethodExecutor;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.ILiveDuxPopupNotice;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostLiveOpenPlatform;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livehostapi/business/base/IBaseHostOpenPlatform;", "dispatchHostEvent", "", "appId", "", "eventName", "params", "Lorg/json/JSONObject;", "dispatchMiniGameEvent", "dispatchStaticCommand", "Landroid/os/Bundle;", "getDuxFontSync", "Landroid/graphics/Typeface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openMiniApp", "schema", "listener", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/IAppStatusListener;", "openMiniGame", "preloadMiniApp", "preloadMiniGame", "registerLiveMethod", "executor", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor;", "showDuxPopupNotice", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/ILiveDuxPopupNotice;", "activity", "Landroid/app/Activity;", "config", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig;", "unregisterLiveMethod", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostLiveOpenPlatform extends IService, IBaseHostOpenPlatform {
    void dispatchHostEvent(String r100, String r101, JSONObject r102);

    void dispatchMiniGameEvent(String r100, JSONObject r101);

    void dispatchStaticCommand(String r100, String r101, Bundle r102);

    Typeface getDuxFontSync(Context r100);

    void openMiniApp(String r100, IAppStatusListener r101);

    void openMiniGame(String r100, IAppStatusListener r101);

    void preloadMiniApp(String r100);

    void preloadMiniGame(String r100);

    void registerLiveMethod(String r100, ILiveMethodExecutor r101);

    ILiveDuxPopupNotice showDuxPopupNotice(Activity r100, DuxPopupNoticeConfig r101);

    void unregisterLiveMethod(String r100);
}
