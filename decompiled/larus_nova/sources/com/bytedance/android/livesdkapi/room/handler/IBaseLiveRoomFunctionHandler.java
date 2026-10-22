package com.bytedance.android.livesdkapi.room.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.PreviewReportBuilder;
import com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver;
import com.bytedance.android.livesdkapi.room.logger.IExternalRoomLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH&J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H&J2\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH&J2\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH&J \u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH&J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H&J.\u0010&\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\tH&J2\u0010-\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\rH&J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0010H&J\u0010\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020'H&J\u0018\u0010!\u001a\u00020\u000b2\u0006\u00103\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0010H&J\b\u00104\u001a\u00020\u000bH&J\u0010\u00108\u001a\u0002072\u0006\u00106\u001a\u000205H&JB\u0010?\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\t2\b\u0010<\u001a\u0004\u0018\u00010;2\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b\u0018\u00010=H&J&\u0010@\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\t2\b\u0010<\u001a\u0004\u0018\u00010;H&J&\u0010A\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\t2\b\u0010<\u001a\u0004\u0018\u00010;H&J&\u0010B\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\t2\b\u0010<\u001a\u0004\u0018\u00010;H&J\b\u0010C\u001a\u00020\u0010H&J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020DH&JF\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\t2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\t2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010H2\u0018\b\u0002\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010LH&J$\u0010P\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\t2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0LH&J)\u0010P\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\t2\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u000b0Q¢\u0006\u0002\bSH&J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H&J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H&¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "", "Lcom/bytedance/android/livesdkapi/room/logger/IExternalRoomLogger;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "loggerClass", "getLogger", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdkapi/room/logger/IExternalRoomLogger;", "Lcom/bytedance/android/livesdkapi/room/handler/observe/ConfigObserver;", "", "bitmapObserver", "", "takeLiveRoomScreenshot", "", "roomId", "content", "", "skipWait", "insertLegalMessage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "userId", "secUserId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/follow/IFollowPair;", "follow", "unFollow", "Lcom/bytedance/android/livesdk/user/l;", "params", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "loginIn", "hovering", "translucent", "fullDialogHoverStateChange", "nickName", "purchaseCnt", "icon", "text", "jetDanmaku", "", "msgType", "serverTime", "activity", "couponType", "metaId", "onCouponMessage", "permission", "revoke", "onPermissionChange", "type", "startVBoost", "state", "onPurchasingIntentionAction", "Landroid/view/View;", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "getLiveContentViewGroup", "Landroid/app/Activity;", "businessName", "Landroid/view/Window;", "dialogWindow", "Lkotlin/Function2;", "listener", "attachWindow", "detachWindow", "toFullScreen", "toHalfScreen", "isLinkmic", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomCallback;", "callback", "enterRoom", "businesskey", "Landroid/os/Bundle;", "businessBundle", "clickMethod", "firstRoomLogParams", "", "commonLogParams", "eventName", "logExtra", "sendLogger", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "previewCompShowEvent", "previewCompResumeEvent", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseLiveRoomFunctionHandler {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void enterRoom$default(IBaseLiveRoomFunctionHandler r100, String r101, Bundle r102, String r103, Bundle r110, Map r111, int r112, Object r113) {
            if (r113 != null) goto L12;
            if ((r112 & 8) == 0) goto L6;
            r110 = null;
        L6:
            Bundle r104 = r110;
            if ((r112 & 16) == 0) goto L9;
            r111 = new HashMap();
        L9:
            r100.enterRoom(r101, r102, r103, r104, r111);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoom");
        }
    }

    void attachWindow(Activity r100, String r101, Window r102, Function2<? super Boolean, ? super Integer, Unit> r103);

    void detachWindow(Activity r100, String r101, Window r102);

    void enterRoom(ILiveEnterRoomCallback r100);

    void enterRoom(String r100, Bundle r101, String r102, Bundle r103, Map<String, String> r104);

    Observable<? extends IFollowPair> follow(Context r100, String r101, String r102, long r103);

    void fullDialogHoverStateChange(int r100, boolean r101);

    void fullDialogHoverStateChange(boolean r100, boolean r101);

    ViewGroup getLiveContentViewGroup(View r100);

    /* JADX INFO: renamed from: getLogger */
    <T extends IExternalRoomLogger> T mo8269getLogger(Class<T> r100);

    boolean insertLegalMessage(long r100, String r101);

    boolean insertLegalMessage(long r100, String r101, boolean r102);

    boolean isLinkmic();

    void jetDanmaku(String r100, long r101, String r102, String r103);

    Observable<? extends IBaseUser> loginIn(Context r100, l r101);

    void onCouponMessage(int r100, long r101, String r102, int r103, long r104);

    void onPermissionChange(int r100, boolean r101);

    void onPurchasingIntentionAction();

    Observable<Boolean> previewCompResumeEvent();

    Observable<Boolean> previewCompShowEvent();

    void sendLogger(String r100, Map<String, String> r101);

    void sendLogger(String r100, Function1<? super PreviewReportBuilder, Unit> r101);

    void startVBoost(int r100);

    void takeLiveRoomScreenshot(ConfigObserver<String, String> r100);

    void toFullScreen(Activity r100, String r101, Window r102);

    void toHalfScreen(Activity r100, String r101, Window r102);

    Observable<? extends IFollowPair> unFollow(Context r100, String r101, String r102, long r103);
}
