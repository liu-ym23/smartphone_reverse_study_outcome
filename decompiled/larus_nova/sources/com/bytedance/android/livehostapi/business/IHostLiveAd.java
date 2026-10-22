package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdLandingPageDialogFragment;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveFeedbackManager;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveFeedbackParams;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostLiveAd extends IService, IBaseHostLiveAd, IMiddlewareHostAd, IHostLiveAdForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostLiveAd$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$callInjectAdController(IHostLiveAd r100) {
        }

        public static void $default$callInjectMessage(IHostLiveAd r100) {
        }

        public static void $default$callInjectWindmillController(IHostLiveAd r100) {
        }

        public static ILiveFeedbackManager $default$createFeedbackManager(IHostLiveAd r100, LiveFeedbackParams r101) {
            return null;
        }

        public static void $default$livePlayerReceivedBroadcastFinishMsg(IHostLiveAd r100) {
        }

        public static void $default$putWebcastFeedRawAdStr(IHostLiveAd r100, long r101, String r102) {
        }

        public static Boolean $default$openMiniApp(IHostLiveAd r100, Context r101, String r102, boolean r103, Map r104) {
            return Boolean.FALSE;
        }
    }

    void callInjectAdController();

    void callInjectMessage();

    void callInjectWindmillController();

    ILiveFeedbackManager createFeedbackManager(LiveFeedbackParams r100);

    String getHostDomain();

    ILiveAdLandingPageDialogFragment getLiveAdLandingPageDialogFragment(Context r100, Bundle r101, FragmentManager r102);

    Pair<Boolean, String> handleOpenUrl(String r100, boolean r101, Context r102);

    void livePlayerReceivedBroadcastFinishMsg();

    Boolean openMiniApp(Context r100, String r101, boolean r102, Map<String, String> r103);

    void putWebcastFeedRawAdStr(long r100, String r101);
}
