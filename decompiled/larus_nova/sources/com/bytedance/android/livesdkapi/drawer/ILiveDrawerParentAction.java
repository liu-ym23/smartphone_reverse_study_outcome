package com.bytedance.android.livesdkapi.drawer;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&JK\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00030\u0011H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/drawer/ILiveDrawerParentAction;", "", "closeLoading", "", "createRefreshLayout", "Lcom/bytedance/android/livesdkapi/drawer/ILiveDoubleBallSwipeRefreshLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dislikeCard", "Lio/reactivex/disposables/Disposable;", "roomId", "", "ownerId", "", "requestId", "enterMethod", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isEnablePersonalRecommend", "enterRoom", "roomStruct", "enterExtra", "Landroid/os/Bundle;", "logEvent", "event", "logMap", "", DyPayConstant.KEY_SHOW_LOADING, "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveDrawerParentAction {
    public static final Companion Companion = null;
    public static final String ECOM_DRAWER_EXTRA = "ecom_drawer_extra";
    public static final String LIVESDK_CLICK_TRANS_LAYER = "livesdk_click_trans_layer";
    public static final String LIVESDK_DISLIKE = "livesdk_dislike";
    public static final String LIVESDK_DRAWER_TAB_STAY_DURATION = "livesdk_drawer_tab_stay_duration";
    public static final String LIVESDK_LIVE_COVER_INFO = "livesdk_live_cover_info";
    public static final String LIVESDK_LIVE_SHOW = "livesdk_live_show";
    public static final String LIVESDK_LIVE_WINDOW_DURATION_V2 = "livesdk_live_window_duration_v2";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/drawer/ILiveDrawerParentAction$Companion;", "", "()V", "ECOM_DRAWER_EXTRA", "", "LIVESDK_CLICK_TRANS_LAYER", "LIVESDK_DISLIKE", "LIVESDK_DRAWER_TAB_STAY_DURATION", "LIVESDK_LIVE_COVER_INFO", "LIVESDK_LIVE_SHOW", "LIVESDK_LIVE_WINDOW_DURATION_V2", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ECOM_DRAWER_EXTRA = "ecom_drawer_extra";
        public static final String LIVESDK_CLICK_TRANS_LAYER = "livesdk_click_trans_layer";
        public static final String LIVESDK_DISLIKE = "livesdk_dislike";
        public static final String LIVESDK_DRAWER_TAB_STAY_DURATION = "livesdk_drawer_tab_stay_duration";
        public static final String LIVESDK_LIVE_COVER_INFO = "livesdk_live_cover_info";
        public static final String LIVESDK_LIVE_SHOW = "livesdk_live_show";
        public static final String LIVESDK_LIVE_WINDOW_DURATION_V2 = "livesdk_live_window_duration_v2";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void closeLoading();

    ILiveDoubleBallSwipeRefreshLayout createRefreshLayout(Context r100);

    Disposable dislikeCard(long r100, String r101, String r102, String r103, Function1<? super Boolean, Unit> r104);

    void enterRoom(String r100, Bundle r101);

    void logEvent(String r100, String r101, Map<String, String> r102);

    void showLoading();
}
