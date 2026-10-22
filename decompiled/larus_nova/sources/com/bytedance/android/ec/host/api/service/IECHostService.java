package com.bytedance.android.ec.host.api.service;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.download.IECDownloadAppService;
import com.bytedance.android.ec.host.api.hybrid.IECForestHostService;
import com.bytedance.android.ec.host.api.info.IECHostDeviceInfoService;
import com.bytedance.android.ec.host.api.search.IECHostSearchService;
import com.bytedance.android.ec.host.api.ttwebview.ITTWebWarmUpService;
import com.bytedance.android.ec.host.api.ug.IECUGHostService;
import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import com.ss.android.lark.utils.statistics.PerfLog;
import ej.c;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import ti.g;
import ti.m;
import ti.n;
import zi.b;
import zi.d;
import zi.e;
import zi.f;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0006H'J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J\b\u0010\u000b\u001a\u00020\nH'J\b\u0010\r\u001a\u00020\fH'J\b\u0010\u000f\u001a\u00020\u000eH'J\b\u0010\u0011\u001a\u00020\u0010H'J\b\u0010\u0013\u001a\u00020\u0012H'J\b\u0010\u0015\u001a\u00020\u0014H'J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017J\b\u0010\u001b\u001a\u00020\u001aH'J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH'J\n\u0010 \u001a\u0004\u0018\u00010\u001fH'J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0017J\n\u0010$\u001a\u0004\u0018\u00010#H\u0017J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%H\u0017J\n\u0010*\u001a\u0004\u0018\u00010)H'J\n\u0010,\u001a\u0004\u0018\u00010+H\u0017J\u0012\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020%H\u0017J\u0012\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010&\u001a\u00020%H\u0017J\u0012\u00102\u001a\u0004\u0018\u0001012\u0006\u0010&\u001a\u00020%H\u0017J\n\u00104\u001a\u0004\u0018\u000103H\u0017J\b\u00105\u001a\u00020\u0004H&J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H&J\n\u0010<\u001a\u0004\u0018\u00010;H\u0016J\n\u0010>\u001a\u0004\u0018\u00010=H\u0016J\n\u0010@\u001a\u0004\u0018\u00010?H\u0016J\n\u0010B\u001a\u0004\u0018\u00010AH\u0016J\n\u0010D\u001a\u0004\u0018\u00010CH\u0016J\n\u0010F\u001a\u0004\u0018\u00010EH\u0017J\n\u0010H\u001a\u0004\u0018\u00010GH&J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J\n\u0010L\u001a\u0004\u0018\u00010KH'J\n\u0010N\u001a\u0004\u0018\u00010MH\u0017J\n\u0010P\u001a\u0004\u0018\u00010OH\u0017J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016J\n\u0010T\u001a\u0004\u0018\u00010SH\u0016J\n\u0010V\u001a\u0004\u0018\u00010UH\u0017J\u001e\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010W\u001a\u000208H\u0016J\u0010\u0010\\\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020ZH\u0016J\n\u0010^\u001a\u0004\u0018\u00010]H\u0017J\b\u0010_\u001a\u00020\u001aH\u0016J\n\u0010a\u001a\u0004\u0018\u00010`H\u0016J\n\u0010c\u001a\u0004\u0018\u00010bH\u0016J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016J\n\u0010g\u001a\u0004\u0018\u00010fH\u0016J\n\u0010i\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010k\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u001aH&J\u0018\u0010n\u001a\u00020\u00042\u000e\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010lH&J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00010oH\u0016J\n\u0010r\u001a\u0004\u0018\u00010qH\u0016J\n\u0010t\u001a\u0004\u0018\u00010sH&¨\u0006u"}, d2 = {"Lcom/bytedance/android/ec/host/api/service/IECHostService;", "", "Landroid/app/Application;", "getApplication", "", "initBullet", "Lvi/a;", "getIECHostAppInfo", "Lri/b;", "getIECHostFrescoService", "Lxi/a;", "getIECHostLogService", "Lmj/a;", "getIECSPService", "Loj/a;", "getIECHostUIService", "Lbj/a;", "getIECHostNetService", "Lpj/a;", "getIECHostUserService", "Ljj/a;", "getIECHostRouterManager", "Laj/a;", "getIECHostMiniAppService", "Ldj/a;", "getIOrderShowOffService", "", "getRecommendStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "openSystemSettingPage", "Lwi/c;", "getLocationService", "Lzi/b;", "getChooseMediaAbility", "Lzi/a;", "getAfterSaleEvidenceMediaAbility", "Lti/n;", "callback", "Lzi/c;", "getUploadFileAbility", "Lji/a;", "getIECHostALogService", "Loi/a;", "getIECContactService", "Lzi/e;", "getIECUploadMultiFileAbility", "Lzi/f;", "getIECUploadMultiFileWithProgressAbility", "Lzi/d;", "getIECUploadMediaFileAbility", "Lki/a;", "getECBTMService", "registerServices", "Lhj/a;", "getIECLivePluginService", "", "orderId", "postCommentEvent", "Lti/m;", "getECLynxHostService", "Lti/g;", "getECAnnieXHostService", "Lui/b;", "getIECShareImageService", "Llj/a;", "getIECSaveQrCodeService", "Lui/a;", "getIECIMService", "Lcom/bytedance/android/ec/host/api/download/IECDownloadAppService;", "getIECDownloadAppService", "Lt07/a;", "geIlynxKitService", "Lni/a;", "getIECHostCustomControllerService", "Lhj/b;", "getIECPluginService", "Lcom/bytedance/android/ec/host/api/ttwebview/ITTWebWarmUpService;", "getITTWebWarmUpService", "Lfj/a;", "getAudioMuteService", "Lsi/a;", "getHunterPopupService", "Lli/a;", "getClientAiService", "Lii/a;", "getAccountService", "fontName", "Landroid/graphics/Typeface;", "getDouyinTextFont", "Landroid/app/Activity;", "activity", "getHandleBackToOtherAppIfNeed", "Lnj/d;", "getPadSplitService", "enableBoe", "Lcom/bytedance/android/ec/host/api/hybrid/IECForestHostService;", "getECForestHostService", "Lcom/bytedance/android/ec/host/api/ug/IECUGHostService;", "getECUGHostService", "Lcom/bytedance/android/ec/host/api/info/IECHostDeviceInfoService;", "getECHostDeviceInfoService", "Lcom/bytedance/android/ec/host/api/search/IECHostSearchService;", "getECHostSearchService", "Lej/c;", "getCalendarService", "customOpt", "initECLightLeakTool", "", "mutableList", "getMallInjectBehavior", "", "mallGylBehavior", "Lcom/bytedance/android/ec/base/api/ai/IECAIHostService;", "getECHostAIService", "Lyi/a;", "getMapServiceProvider", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECHostService {

    public static final class a {
        public static /* synthetic */ Typeface a(IECHostService r100, Context r101) {
            return r100.getDouyinTextFont(r101, CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT);
        }
    }

    boolean enableBoe();

    t07.a geIlynxKitService();

    @ReturnSubService
    ii.a getAccountService();

    @ReturnSubService
    zi.a getAfterSaleEvidenceMediaAbility();

    Application getApplication();

    @ReturnSubService
    fj.a getAudioMuteService();

    c getCalendarService();

    @ReturnSubService
    b getChooseMediaAbility();

    li.a getClientAiService();

    Typeface getDouyinTextFont(Context r100, String r101);

    g getECAnnieXHostService();

    @ReturnSubService
    ki.a getECBTMService();

    IECForestHostService getECForestHostService();

    IECAIHostService getECHostAIService();

    IECHostDeviceInfoService getECHostDeviceInfoService();

    IECHostSearchService getECHostSearchService();

    m getECLynxHostService();

    IECUGHostService getECUGHostService();

    boolean getHandleBackToOtherAppIfNeed(Activity r100);

    si.a getHunterPopupService();

    @ReturnSubService
    oi.a getIECContactService();

    @ReturnSubService
    IECDownloadAppService getIECDownloadAppService();

    @ReturnSubService
    ji.a getIECHostALogService();

    @ReturnSubService
    vi.a getIECHostAppInfo();

    ni.a getIECHostCustomControllerService();

    @ReturnSubService
    ri.b getIECHostFrescoService();

    @ReturnSubService
    xi.a getIECHostLogService();

    @ReturnSubService
    aj.a getIECHostMiniAppService();

    @ReturnSubService
    bj.a getIECHostNetService();

    @ReturnSubService
    jj.a getIECHostRouterManager();

    @ReturnSubService
    oj.a getIECHostUIService();

    @ReturnSubService
    pj.a getIECHostUserService();

    ui.a getIECIMService();

    hj.a getIECLivePluginService();

    @ReturnSubService
    hj.b getIECPluginService();

    @ReturnSubService
    mj.a getIECSPService();

    lj.a getIECSaveQrCodeService();

    ui.b getIECShareImageService();

    @ReturnSubService
    d getIECUploadMediaFileAbility(n r100);

    @ReturnSubService
    e getIECUploadMultiFileAbility(n r100);

    @ReturnSubService
    f getIECUploadMultiFileWithProgressAbility(n r100);

    @ReturnSubService
    dj.a getIOrderShowOffService();

    @ReturnSubService
    ITTWebWarmUpService getITTWebWarmUpService();

    @ReturnSubService
    wi.c getLocationService();

    void getMallInjectBehavior(List<Object> r100);

    yi.a getMapServiceProvider();

    @ReturnSubService
    nj.d getPadSplitService();

    @ReturnSubService
    boolean getRecommendStatus();

    @ReturnSubService
    zi.c getUploadFileAbility(n r100);

    @Deprecated(message = "Do not use on xigua or toutiao")
    void initBullet();

    void initECLightLeakTool(boolean r100);

    List<Object> mallGylBehavior();

    @ReturnSubService
    void openSystemSettingPage(Context r100);

    void postCommentEvent(String r100);

    void registerServices();
}
