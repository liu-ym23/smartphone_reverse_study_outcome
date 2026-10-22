package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.opengame.AudiencePluginManager;
import com.bytedance.android.live.broadcastgame.opengame.control.out_report.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.test.OpenGameTestHelper;
import com.bytedance.android.live.broadcastgame.openplatform.behavior.ToolbarOpenPlatformBehavior;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
public interface f0 {
    com.bytedance.android.live.broadcastgame.openplatform.behavior.a a(com.bytedance.android.live.broadcastgame.api.model.u r100, mh1.p r101);

    void addItemToDataCacheHelper(String r100);

    ToolbarOpenPlatformBehavior b(Context r100, DataCenter r101, Function2 r102, com.bytedance.android.live.broadcastgame.api.interactgame.g r103);

    com.bytedance.android.live.broadcastgame.opengame.a c(com.bytedance.android.live.pushstream.d r100, Context r101, DataCenter r102, long r103, ViewGroup r104);

    void closeOpenPlatformGame(String r100);

    XplayPerfPanelView d(ViewGroup r100);

    String decryptUserInfo(String r100);

    void deleteData(String r100);

    com.bytedance.android.live.broadcastgame.opengame.test.c e();

    void f(Context r100, String r101, InteractGameService.e r102);

    OpenGameTestHelper g();

    List<Class<?>> getAllOpenPlatformActivity();

    void getOpenGameClient();

    void getXplayGlobalService();

    com.bytedance.android.live.broadcastgame.opengame.behavior.b h();

    AudiencePluginManager i(Context r100, DataCenter r101, long r102, ViewGroup r103);

    com.bytedance.android.live.broadcastgame.opengame.behavior.c j();

    Disposable openCertificatePage(Context r100, Function0<Unit> r101);

    void openOpenPlatformGame(String r100, Map<String, ? extends Object> r101);

    InteractGameFeedbackDialog openOuterGameFeedback(Context r100, boolean r101);

    OpenGameReportDialog openOuterGameReport(Context r100, String r101, String r102, String r103, boolean r104);

    void preloadOpenPlatformGame(String r100);

    Single<Boolean> showOpenGameAuthDialog(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.api.model.u r102);
}
