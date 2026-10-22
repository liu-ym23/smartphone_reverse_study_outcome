package com.bytedance.android.livesdk.interactivity.api.enterroom;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import l32.b;
import l32.c;
import l32.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 B2\u00020\u0001:\u0001CJJ\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001e\u0010\"\u001a\u00020\u00102\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u0004\u0018\u00010\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\n002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\u001a\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016R$\u0010A\u001a\u00020.2\u0006\u0010<\u001a\u00020.8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/enterroom/IEnterGuideService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroidx/lifecycle/Lifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", "isScreenPortrait", "", "bottomGuideContainerId", "Lcom/bytedance/ies/sdk/widgets/Widget;", "saasCouponWidget", "", "prepareEnterRoomGuide", "ensureNewAuthGuideManagerInitialized", "Ll32/a;", "createAuthActionRoutine", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "isBottomGuideShowing", "closeBottomGuide", "firstEnterLiveRoom", "createCouponDialogWidget", "isCouponNeedShow", "(Lcom/bytedance/ies/sdk/widgets/Widget;)Ljava/lang/Boolean;", "Lcom/bytedance/android/live/room/l;", "mRoomLogger", "createUgCouponWidget", "Lkotlin/Function1;", "action", "initSlideTask", "hasShown", "setHasShownSlideUpGuideInSingleContainer", "getHasShownSlideUpGuideInSingleContainer", "", "getSlideTaskGuideDuration", "", "Lkf1/a;", "closeRoomInterceptorList", "createSlideTaskWidget", "taskManagerReset", "taskManagerReleaseAction", "", "userId", "Lio/reactivex/Observable;", "checkXTFollowSync", "Ll32/d;", "getRoomBizController", "Ll32/c;", "getKeyRoomInfoBizController", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/e;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "getAudienceToolbarMoreLoader", "Ll32/b;", "getGotoLiveTabHelper", "value", "getNewAuthReportOneClickLoginStatus", "()Ljava/lang/String;", "setNewAuthReportOneClickLoginStatus", "(Ljava/lang/String;)V", "newAuthReportOneClickLoginStatus", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IEnterGuideService extends IService {
    public static final String COUPON_LOGTAG = "query coupon error";
    public static final String COUPON_TAG = "CouponDialogWidget";
    public static final String COUPON_TO_SHOPPING_COUPON_BLOCK_KEY = "is_need_block_coupon";
    public static final String COUPON_TO_SHOPPING_COUPON_KEY = "enter_request";
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f133120a = null;

        public a() {
        }

        static {
            f133120a = new a();
        }
    }

    static {
        Companion = a.f133120a;
    }

    Observable<Boolean> checkXTFollowSync(Context r100, String r101);

    void closeBottomGuide(Fragment r100);

    l32.a createAuthActionRoutine();

    Widget createCouponDialogWidget(Context r100);

    Widget createSlideTaskWidget(List<kf1.a> r100);

    Widget createUgCouponWidget(l r100);

    void ensureNewAuthGuideManagerInitialized();

    void firstEnterLiveRoom();

    AbsMiddlewareDynamicLoader getAudienceToolbarMoreLoader(Context r100, e r101);

    b getGotoLiveTabHelper();

    boolean getHasShownSlideUpGuideInSingleContainer();

    c getKeyRoomInfoBizController();

    String getNewAuthReportOneClickLoginStatus();

    d getRoomBizController();

    long getSlideTaskGuideDuration();

    void initSlideTask(Function1<? super Boolean, Boolean> r100);

    boolean isBottomGuideShowing(Fragment r100);

    Boolean isCouponNeedShow(Widget r100);

    void prepareEnterRoomGuide(WidgetManager r100, Context r101, Lifecycle r102, Room r103, boolean r104, int r105, Widget r106);

    void setHasShownSlideUpGuideInSingleContainer(boolean r100);

    void setNewAuthReportOneClickLoginStatus(String r100);

    void taskManagerReleaseAction();

    void taskManagerReset();
}
