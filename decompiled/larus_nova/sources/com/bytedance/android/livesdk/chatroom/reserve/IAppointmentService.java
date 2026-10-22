package com.bytedance.android.livesdk.chatroom.reserve;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.feed.services.AppointmentService")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 )2\u00020\u0001:\u0001*JD\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&JU\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0014\u0010\u0015J[\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010 \u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JA\u0010%\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b%\u0010&J\b\u0010(\u001a\u00020'H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/reserve/IAppointmentService;", "Lcom/bytedance/android/live/base/IService;", "", "", "Lcom/bytedance/android/live/base/model/Appointment$LiveFragments;", "extracts", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "", "enterMethod", "Lcom/bytedance/android/live/base/model/Appointment;", ActivityVO.APPOINTMENT, "", "openVideo", "roomId", "innerUrl", "", "scene", "openLive", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Landroid/content/Context;Ljava/lang/String;)V", "", PromotionDepositPresaleActivity.RESERVED, "Landroid/widget/TextView;", "reserveButton", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "reserve", "(Ljava/lang/Boolean;Landroid/content/Context;Ljava/lang/Integer;Landroid/widget/TextView;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Ljava/lang/String;Lio/reactivex/disposables/CompositeDisposable;)V", "programType", "appointmentId", "logAppointmentShow", "(Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "logAppointmentPageShow", "clickType", "jumpType", "logClickReserve", "(Ljava/lang/String;Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "createAppointmentListFragment", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAppointmentService extends IService {
    public static final a Companion = null;
    public static final int SCENE_DRAWER = 2;
    public static final int SCENE_LIVE_END = 1;
    public static final int SCENE_SECONDARY = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f110410a = null;

        public a() {
        }

        static {
            f110410a = new a();
        }
    }

    static {
        Companion = a.f110410a;
    }

    BaseFragment createAppointmentListFragment();

    void logAppointmentPageShow(FeedItem r100, String r101);

    void logAppointmentShow(FeedItem r100, String r101, String r102, Long r103);

    void logClickReserve(String r100, FeedItem r101, String r102, Long r103, String r104);

    void openLive(Long r100, String r101, Integer r102, FeedItem r103, Appointment r104, Context r105, String r106);

    void openVideo(Map<Long, ? extends Appointment.LiveFragments> r100, Context r101, FeedItem r102, String r103, Appointment r104);

    void reserve(Boolean r100, Context r101, Integer r102, TextView r103, FeedItem r104, Appointment r105, String r106, CompositeDisposable r107);
}
