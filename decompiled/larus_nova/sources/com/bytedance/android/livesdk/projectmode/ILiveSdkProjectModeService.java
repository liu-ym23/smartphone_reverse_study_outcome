package com.bytedance.android.livesdk.projectmode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.platformplayer.test.IPlayerTest;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.test.b;
import com.bytedance.android.livesdkapi.projectmode.IMiddlewareLiveSdkProjectModeService;
import com.bytedance.android.livesdkapi.test.ILiveTestService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.lark.utils.statistics.PerfLog;
import ip2.a;
import is2.g;
import j70.h;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceImpl")
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH&J\u0012\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&J\b\u0010$\u001a\u00020#H&J\u0012\u0010%\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010(\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010&H&J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*H&J(\u00102\u001a\u00020\u00102\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-H&J\u001a\u00105\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u00104\u001a\u000203H&¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/projectmode/ILiveSdkProjectModeService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdkapi/test/ILiveTestService;", "Lcom/bytedance/android/live/platformplayer/test/IPlayerTest;", "Lcom/bytedance/android/livesdkapi/projectmode/IMiddlewareLiveSdkProjectModeService;", "Landroidx/fragment/app/Fragment;", "createLiveSettingFragment", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getDebugTestInfoElementClass", "getSandBoxElementClass", "getGiftPreviewDebugWidget", "Lj70/h;", "Lh70/b;", "getDebugSocketCommunicationSwDesc", "getDebugDSLPreviewServiceDesc", "", "startApiCheckPrompt", "", "isPerfToolsDebug", "Landroid/app/Activity;", "activity", "initAndShowPerfTools", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/os/Bundle;", "bundle", "initUgDebugTools", "unRegisterUgDebugTools", "Lis2/g;", "getDebugRoomLifecycleObserver", "openDebugInfoDialog", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getInterceptors", "Lcom/bytedance/android/livesdk/test/b;", "getCommentMockTestData", "showOrDismissProfileMockPanel", "", "scope", "openPaidLiveDebugWindow", "openMockLinkDialog", "Lip2/a;", "info", "openDSLDialog", "", "logId", "path", "request", ContainerPosition.BODY, "consumeRevNetWork", "", "contentCategory", "configCurrentContentCategory", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceDummy")
public interface ILiveSdkProjectModeService extends IService, ILiveTestService, IPlayerTest, IMiddlewareLiveSdkProjectModeService {
    void configCurrentContentCategory(Activity r100, int r101);

    @Override // com.bytedance.android.livesdkapi.projectmode.IMiddlewareLiveSdkProjectModeService
    void consumeRevNetWork(String r100, String r101, String r102, String r103);

    Fragment createLiveSettingFragment();

    b getCommentMockTestData();

    h<? extends h70.b> getDebugDSLPreviewServiceDesc();

    g getDebugRoomLifecycleObserver();

    h<? extends h70.b> getDebugSocketCommunicationSwDesc();

    Class<? extends LiveRecyclableWidget> getDebugTestInfoElementClass();

    Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget();

    List<Interceptor> getInterceptors();

    Class<? extends LiveRecyclableWidget> getSandBoxElementClass();

    void initAndShowPerfTools(Activity r100);

    void initUgDebugTools(Context r100, Bundle r101);

    boolean isPerfToolsDebug();

    void openDSLDialog(Context r100, a r101);

    void openDebugInfoDialog(Activity r100);

    void openMockLinkDialog(Context r100);

    void openPaidLiveDebugWindow(Object r100);

    void showOrDismissProfileMockPanel(Activity r100);

    void startApiCheckPrompt();

    void unRegisterUgDebugTools(Context r100);
}
