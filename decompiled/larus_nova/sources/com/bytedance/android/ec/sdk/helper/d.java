package com.bytedance.android.ec.sdk.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.download.IECDownloadAppService;
import com.bytedance.android.ec.host.api.hybrid.IECForestHostService;
import com.bytedance.android.ec.host.api.info.IECHostDeviceInfoService;
import com.bytedance.android.ec.host.api.search.IECHostSearchService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.host.api.ttwebview.ITTWebWarmUpService;
import com.bytedance.android.ec.host.api.ug.IECUGHostService;
import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXCompat;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements IECHostService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IECHostService f48118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f48119b = null;

    public d() {
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final Application getApplication() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ej.c getCalendarService() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ti.g getECAnnieXHostService() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECHostDeviceInfoService getECHostDeviceInfoService() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECHostSearchService getECHostSearchService() {
        return null;
    }

    static {
        f48119b = new d();
    }

    public static IECHostService a() {
        IECHostService r100 = f48118a;
        if (r100 != null) goto L43;
        boolean r101 = ECServiceManager.f42805a;
        r100 = (IECHostService) ECServiceManager.c(IECHostService.class);
        if (r100 != null) goto L41;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L46;
        Class<?> r104 = Class.forName("lr.v");     // Catch: Throwable -> L12
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L34;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom_service.generated.DefaultImpl_IECHostService");     // Catch: Throwable -> L12
    L34:
        Object r105 = r104.newInstance();
        if (r105 == null) goto L38;
        r100 = (IECHostService) r105;
        goto L41
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.host.api.service.IECHostService");
    L12:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom_service.generated.DefaultImpl_IECHostService");
    L16:
        throw th;
    L46:
        r104 = Class.forName("lr.v");     // Catch: Throwable -> L21
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L34;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom_service.generated.DefaultImpl_IECHostService");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L26;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom_service.generated.DefaultImpl_IECHostService");
    L26:
        if ((th instanceof PluginClassNotFoundException) == false) goto L28;
        throw th;
    L28:
        if ((th instanceof ClassNotFoundException) == false) goto L30;
    L33:
        r104 = MiraPluginFix.forName("com.bytedance.android.ecom_service.generated.DefaultImpl_IECHostService");
        goto L34
    L30:
        if ((th instanceof NoClassDefFoundError) == true) goto L33;
        throw th;
    L41:
        if (((ServiceDefaultImpl) r100.getClass().getAnnotation(ServiceDefaultImpl.class)) != null) goto L43;
        f48118a = r100;
    L43:
        return r100;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final t07.a geIlynxKitService() {
        Lazy r100 = ECLynxAnnieXService.f46553a;
        Lazy r101 = ECLynxAnnieXCompat.f46251a;
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final boolean enableBoe() {
        return a().enableBoe();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ii.a getAccountService() {
        return a().getAccountService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.a getAfterSaleEvidenceMediaAbility() {
        return a().getAfterSaleEvidenceMediaAbility();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final fj.a getAudioMuteService() {
        return a().getAudioMuteService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.b getChooseMediaAbility() {
        return a().getChooseMediaAbility();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final li.a getClientAiService() {
        a().getClientAiService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ki.a getECBTMService() {
        return a().getECBTMService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECForestHostService getECForestHostService() {
        return a().getECForestHostService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECAIHostService getECHostAIService() {
        return a().getECHostAIService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ti.m getECLynxHostService() {
        a().getECLynxHostService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECUGHostService getECUGHostService() {
        return a().getECUGHostService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final si.a getHunterPopupService() {
        a().getHunterPopupService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final oi.a getIECContactService() {
        a().getIECContactService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final IECDownloadAppService getIECDownloadAppService() {
        return a().getIECDownloadAppService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ji.a getIECHostALogService() {
        return a().getIECHostALogService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final vi.a getIECHostAppInfo() {
        return a().getIECHostAppInfo();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ni.a getIECHostCustomControllerService() {
        return a().getIECHostCustomControllerService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ri.b getIECHostFrescoService() {
        return a().getIECHostFrescoService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final xi.a getIECHostLogService() {
        return a().getIECHostLogService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final aj.a getIECHostMiniAppService() {
        return a().getIECHostMiniAppService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final bj.a getIECHostNetService() {
        return a().getIECHostNetService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final jj.a getIECHostRouterManager() {
        return a().getIECHostRouterManager();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final oj.a getIECHostUIService() {
        return a().getIECHostUIService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final pj.a getIECHostUserService() {
        return a().getIECHostUserService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ui.a getIECIMService() {
        a().getIECIMService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final hj.a getIECLivePluginService() {
        a().getIECLivePluginService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final hj.b getIECPluginService() {
        a().getIECPluginService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final mj.a getIECSPService() {
        return a().getIECSPService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final lj.a getIECSaveQrCodeService() {
        a().getIECSaveQrCodeService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ui.b getIECShareImageService() {
        a().getIECShareImageService();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final dj.a getIOrderShowOffService() {
        return a().getIOrderShowOffService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final ITTWebWarmUpService getITTWebWarmUpService() {
        return a().getITTWebWarmUpService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final wi.c getLocationService() {
        return a().getLocationService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final yi.a getMapServiceProvider() {
        a().getMapServiceProvider();
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final nj.d getPadSplitService() {
        return a().getPadSplitService();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final boolean getRecommendStatus() {
        return a().getRecommendStatus();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void initBullet() {
        a().initBullet();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final List<Object> mallGylBehavior() {
        return a().mallGylBehavior();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void registerServices() {
        a().registerServices();
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final boolean getHandleBackToOtherAppIfNeed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return a().getHandleBackToOtherAppIfNeed(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.d getIECUploadMediaFileAbility(ti.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        a().getIECUploadMediaFileAbility(r100);
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.e getIECUploadMultiFileAbility(ti.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        a().getIECUploadMultiFileAbility(r100);
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.f getIECUploadMultiFileWithProgressAbility(ti.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        a().getIECUploadMultiFileWithProgressAbility(r100);
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void getMallInjectBehavior(List<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "mutableList");
        a().getMallInjectBehavior(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final zi.c getUploadFileAbility(ti.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return a().getUploadFileAbility(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void initECLightLeakTool(boolean r100) {
        a().initECLightLeakTool(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void openSystemSettingPage(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        a().openSystemSettingPage(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final void postCommentEvent(String r100) {
        a().postCommentEvent(r100);
    }

    @Override // com.bytedance.android.ec.host.api.service.IECHostService
    public final Typeface getDouyinTextFont(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fontName");
        return a().getDouyinTextFont(r100, r101);
    }
}
