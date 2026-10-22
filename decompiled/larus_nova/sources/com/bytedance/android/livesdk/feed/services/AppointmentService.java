package com.bytedance.android.livesdk.feed.services;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livesdk.chatroom.api.AppointmentApi;
import com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService;
import com.bytedance.android.livesdk.feed.fragment.AppointmentListFragment;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJD\u0010\u0013\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016JU\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010 \u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!JA\u0010$\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010%J7\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010+\u001a\u00020*H\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/feed/services/AppointmentService;", "Lcom/bytedance/android/livesdk/chatroom/reserve/IAppointmentService;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "", "enterMethod", "", "appointmentId", "", "logOpenVideo", "(Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/Long;)V", "logClickLive", "", "Lcom/bytedance/android/live/base/model/Appointment$LiveFragments;", "extracts", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/base/model/Appointment;", ActivityVO.APPOINTMENT, "openVideo", "roomId", "innerUrl", "", "scene", "openLive", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Landroid/content/Context;Ljava/lang/String;)V", "", PromotionDepositPresaleActivity.RESERVED, "Landroid/widget/TextView;", "reserveButton", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "reserve", "(Ljava/lang/Boolean;Landroid/content/Context;Ljava/lang/Integer;Landroid/widget/TextView;Lcom/bytedance/android/live/base/model/feed/FeedItem;Lcom/bytedance/android/live/base/model/Appointment;Ljava/lang/String;Lio/reactivex/disposables/CompositeDisposable;)V", "clickType", "jumpType", "logClickReserve", "(Ljava/lang/String;Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "programType", "logAppointmentShow", "(Lcom/bytedance/android/live/base/model/feed/FeedItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "logAppointmentPageShow", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "createAppointmentListFragment", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AppointmentService implements IAppointmentService {
    public static final a Companion = null;
    public static final long SOURCE_DRAWER = 10010;
    public static final long SOURCE_LIVE_END = 10009;
    public static final long SOURCE_SECONDARY = 10011;
    public static final long SOURCE_UNDEFINED = 10000;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ILoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentService f124348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Boolean f124349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f124350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f124351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TextView f124352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FeedItem f124353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Appointment f124354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f124355h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CompositeDisposable f124356i;

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onCancel(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        }

        @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
        public final void onSuccess(IBaseUser r110) {
            Intrinsics.checkNotNullParameter(r110, "user");
            this.f124348a.reserve(this.f124349b, this.f124350c, this.f124351d, this.f124352e, this.f124353f, this.f124354g, this.f124355h, this.f124356i);
        }

        public b(AppointmentService r100, Boolean r101, Context r102, Integer r103, TextView r104, FeedItem r105, Appointment r106, String r107, CompositeDisposable r108) {
            this.f124348a = r100;
            this.f124349b = r101;
            this.f124350c = r102;
            this.f124351d = r103;
            this.f124352e = r104;
            this.f124353f = r105;
            this.f124354g = r106;
            this.f124355h = r107;
            this.f124356i = r108;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentService f124357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Appointment f124358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f124359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FeedItem f124360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f124361e;

        public c(AppointmentService r100, Appointment r101, TextView r102, FeedItem r103, String r104) {
            this.f124357a = r100;
            this.f124358b = r101;
            this.f124359c = r102;
            this.f124360d = r103;
            this.f124361e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            Appointment r102 = this.f124358b;
            r102.isReserved = Boolean.FALSE;
            f2.b(R.string.ttlive_cancel_reserve_success, 0);
            this.f124359c.setText(s1.B(R.string.ttlive_reserve));
            Drawable r103 = this.f124359c.getBackground();
            if ((r103 instanceof GradientDrawable) == true) goto L5;
            r103 = null;
        L5:
            GradientDrawable r104 = (GradientDrawable) r103;
            if (r104 == null) goto L8;
            r104.setColor(s1.h(R.color.ttlive_normal_btn_red_bg));
        L8:
            this.f124357a.logClickReserve("cancel_reserve", this.f124360d, this.f124361e, Long.valueOf(this.f124358b.appointmentId), null);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentService f124362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FeedItem f124363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Appointment f124365d;

        public d(AppointmentService r100, FeedItem r101, String r102, Appointment r103) {
            this.f124362a = r100;
            this.f124363b = r101;
            this.f124364c = r102;
            this.f124365d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L5;
        L7:
            f2.b(R.string.ttlive_reserve_fail, 0);
        L8:
            this.f124362a.logClickReserve("reserve_fail", this.f124363b, this.f124364c, Long.valueOf(this.f124365d.appointmentId), null);
            Logger.e(r101.getMessage());
            return;
        L5:
            if (StringsKt.contains$default(r102, "network not available", false, 2, null) != true) goto L7;
            f2.b(R.string.ttlive_network_not_available, 0);
            goto L8
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentService f124366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Appointment f124367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f124368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FeedItem f124369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f124370e;

        public e(AppointmentService r100, Appointment r101, TextView r102, FeedItem r103, String r104) {
            this.f124366a = r100;
            this.f124367b = r101;
            this.f124368c = r102;
            this.f124369d = r103;
            this.f124370e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            Appointment r102 = this.f124367b;
            r102.isReserved = Boolean.TRUE;
            f2.b(R.string.ttlive_reserve_success, 0);
            this.f124368c.setText(s1.B(R.string.ttlive_has_reserved));
            Drawable r103 = this.f124368c.getBackground();
            if ((r103 instanceof GradientDrawable) == true) goto L5;
            r103 = null;
        L5:
            GradientDrawable r104 = (GradientDrawable) r103;
            if (r104 == null) goto L8;
            r104.setColor(s1.h(R.color.ttlive_std_bg_1));
        L8:
            this.f124366a.logClickReserve("reserve", this.f124369d, this.f124370e, Long.valueOf(this.f124367b.appointmentId), null);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentService f124371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FeedItem f124372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Appointment f124374d;

        public f(AppointmentService r100, FeedItem r101, String r102, Appointment r103) {
            this.f124371a = r100;
            this.f124372b = r101;
            this.f124373c = r102;
            this.f124374d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L5;
        L7:
            f2.b(R.string.ttlive_reserve_fail, 0);
        L8:
            this.f124371a.logClickReserve("reserve_fail", this.f124372b, this.f124373c, Long.valueOf(this.f124374d.appointmentId), null);
            Logger.e(r101.getMessage());
            return;
        L5:
            if (StringsKt.contains$default(r102, "network not available", false, 2, null) != true) goto L7;
            f2.b(R.string.ttlive_network_not_available, 0);
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public AppointmentService() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public BaseFragment createAppointmentListFragment() {
        return new AppointmentListFragment();
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void logAppointmentPageShow(FeedItem r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("enter_method", r101);
        if (r100 == null) goto L5;
        r102.put("log_pb", r100.logPb);
    L5:
        kw1.c.d("livesdk_live_program_page_show", r102);
    }

    private final void logClickLive(FeedItem r100, String r101, Long r102) {
        HashMap r103 = new HashMap();
        r103.put("enter_method", r101);
        if (r100 == null) goto L5;
        r103.put("log_pb", r100.logPb);
    L5:
        if (r102 == null) goto L7;
        String r104 = String.valueOf(r102.longValue());
    L8:
        r103.put(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r104);
        kw1.c.d("livesdk_live_program_play", r103);
        return;
    L7:
        r104 = null;
        goto L8
    }

    private final void logOpenVideo(FeedItem r100, String r101, Long r102) {
        HashMap r103 = new HashMap();
        r103.put("enter_method", r101);
        if (r102 == null) goto L5;
        String r104 = String.valueOf(r102.longValue());
    L6:
        r103.put(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r104);
        if (r100 == null) goto L9;
        r103.put("log_pb", r100.logPb);
    L9:
        kw1.c.d("livesdk_live_program_history_play", r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void logAppointmentShow(FeedItem r100, String r101, String r102, Long r103) {
        HashMap r104 = new HashMap();
        r104.put("enter_method", r101);
        r104.put("program_type", r102);
        r104.put(ILiveRoomPlayFragmentConstant.PROGRAM_ID, String.valueOf(r103));
        if (r100 == null) goto L5;
        r104.put("log_pb", r100.logPb);
    L5:
        kw1.c.d("livesdk_live_program_list_show", r104);
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void logClickReserve(String r100, FeedItem r101, String r102, Long r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("enter_method", r102);
        r105.put("click_type", r100);
        if (r103 == null) goto L5;
        String r106 = String.valueOf(r103.longValue());
    L6:
        r105.put(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r106);
        if (r101 == null) goto L9;
        r105.put("log_pb", r101.logPb);
    L9:
        if (r104 == null) goto L11;
        r105.put("jump_type", r104);
    L11:
        kw1.c.d("livesdk_live_program_reserve", r105);
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void openVideo(Map<Long, ? extends Appointment.LiveFragments> r210, Context r211, FeedItem r212, String r213, Appointment r214) {
        Intrinsics.checkNotNullParameter(r210, "extracts");
        Appointment.LiveFragments r100 = r210.get(1L);
        Long r101 = null;
        String r102 = "";
        if (r100 == null) goto L19;
        List<Long> r103 = r100.extractItemIds;
        if (r103 == null) goto L19;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        Object[] r105 = new Object[3];
        r105[0] = ListProtector.get(r103, 0);
        r105[1] = CollectionsKt.joinToString$default(r103, null, null, null, 0, null, AppointmentService$openVideo$1$schema$1.INSTANCE, 31, null);
        if (r214 == null) goto L12;
        String r106 = String.valueOf(r214.appointmentId);
        if (r106 == null) goto L12;
        r102 = r106;
    L12:
        r105[2] = r102;
        String r107 = String.format("snssdk1128://aweme/detail_list/%d?refer=program_list_page&gids=%s&label=program_list_page&program_id=%s&content_type=live_replay", Arrays.copyOf(r105, 3));
        ILiveActionHandler r108 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r108 == null) goto L15;
        r108.handle(r211, r107);
    L15:
        if (r214 == null) goto L17;
        r101 = Long.valueOf(r214.appointmentId);
    L17:
        logOpenVideo(r212, r213, r101);
        return;
    L19:
        Appointment.LiveFragments r109 = r210.get(3L);
        if (r109 == null) goto L34;
        List<Long> r110 = r109.extractItemIds;
        if (r110 == null) goto L35;
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        Object[] r112 = new Object[3];
        r112[0] = ListProtector.get(r110, 0);
        r112[1] = CollectionsKt.joinToString$default(r110, null, null, null, 0, null, AppointmentService$openVideo$2$schema$1.INSTANCE, 31, null);
        if (r214 == null) goto L29;
        String r113 = String.valueOf(r214.appointmentId);
        if (r113 == null) goto L29;
        r102 = r113;
    L29:
        r112[2] = r102;
        String r114 = String.format("snssdk1128://aweme/detail_list/%d?refer=program_list_page&gids=%s&label=program_list_page&program_id=%s&content_type=live_replay", Arrays.copyOf(r112, 3));
        ((ILiveActionHandler) k.n(ILiveActionHandler.class)).handle(r211, r114);
        if (r214 == null) goto L32;
        r101 = Long.valueOf(r214.appointmentId);
    L32:
        logOpenVideo(r212, r213, r101);
        return;
    L35:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void openLive(Long r110, String r111, Integer r112, FeedItem r113, Appointment r114, Context r210, String r211) {
        long r100 = 0;
        Long r115 = null;
        if (r112 != null) goto L6;
    L53:
        ILiveActionHandler r101 = ((IRoomService) k.n(IRoomService.class)).actionHandler();
        IRoomActionHandler.Params r102 = new IRoomActionHandler.Params();
        if (r110 == null) goto L56;
        r100 = r110.longValue();
    L56:
        IRoomActionHandler.Params r103 = r102.setRoomId(r100);
        if (r114 == null) goto L59;
        Long r104 = Long.valueOf(r114.appointmentId);
    L60:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r101, r210, r103.setAppointmentId(r104).setEnterFromMerge(r211).setEnterMethod("live_program_list"), null, 4, null);
        if (r112 != null) goto L64;
    L66:
        if (r114 == null) goto L68;
        r115 = Long.valueOf(r114.appointmentId);
    L68:
        logClickLive(r113, r211, r115);
        return;
    L64:
        if (r112.intValue() != 1) goto L66;
        xs2.b.a().post(40);
        goto L66
    L59:
        r104 = null;
        goto L60
    L6:
        if (r112.intValue() != 2) goto L53;
        Room r105 = new Room();
        if (r110 == null) goto L10;
        r100 = r110.longValue();
    L10:
        r105.f162599id = r100;
        if (r110 == null) goto L14;
        String r106 = String.valueOf(r110.longValue());
        if (r106 == null) goto L14;
    L15:
        r105.setIdStr(r106);
        if (r113 == null) goto L18;
        String r107 = r113.requestId();
    L19:
        r105.setRequestId(r107);
        if (r113 == null) goto L22;
        String r108 = r113.logPb;
    L23:
        r105.setLog_pb(r108);
        if (r114 == null) goto L27;
        String r109 = r114.getAnchorIdStr();
        if (r109 == null) goto L27;
    L28:
        r105.setOwnerUserIdString(r109);
        Bundle r116 = new Bundle();
        if (r113 == null) goto L31;
        String r117 = r113.logPb;
    L32:
        r116.putString("log_pb", r117);
        if (r113 == null) goto L35;
        String r118 = r113.resId;
    L36:
        r116.putString("request_id", r118);
        r116.putString("enter_from_merge", "drawer_chosen");
        r116.putString("enter_method", "live_program_list");
        if (r114 == null) goto L39;
        String r119 = String.valueOf(r114.appointmentId);
    L40:
        r116.putString(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r119);
        Bundle r120 = LiveRoomIntentBuilder.buildBundle(r210, r105, "", r116);
        if (r120 != null) goto L43;
        return;
    L43:
        if (TTLiveSDK.hostService() != null) goto L45;
        return;
    L45:
        if (TTLiveSDK.hostService().action() == null) goto L72;
        r120.putAll(ArgumentsBuilder.buildRoomArgs(r105));
        if (r120.get(ILiveRoomPlayFragmentConstant.EXTRA_USER_ID) != null) goto L49;
        r120.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ID, r105.getOwnerUserIdString());
    L49:
        r120.putString("live.intent.extra.FEED_URL", r111);
        r120.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FROM_NEW_STYLE_EXTRA, true);
        r120.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_USER_ID, r105.getOwnerUserIdString());
        r120.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NEW_ROOM_BACK_SOURCE, IBackRoomStackKt.JUMP_SOURCE_SQUARE_DRAWER);
        kw1.c.b(r210, r116);
        TTLiveSDK.hostService().action().startLive(r210, r105.f162599id, r120);
        if (r114 == null) goto L52;
        r115 = Long.valueOf(r114.appointmentId);
    L52:
        logClickLive(r113, r211, r115);
        xs2.b.a().post(new uv1.e(0));
        return;
    L72:
        return;
    L39:
        r119 = null;
        goto L40
    L35:
        r118 = null;
        goto L36
    L31:
        r117 = null;
    L27:
        r109 = "0";
        goto L28
    L22:
        r108 = null;
        goto L23
    L18:
        r107 = null;
    L14:
        r106 = "";
        goto L15
    }

    @Override // com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService
    public void reserve(Boolean r110, Context r210, Integer r211, TextView r212, FeedItem r213, Appointment r214, String r215, CompositeDisposable r216) {
        Intrinsics.checkNotNullParameter(r212, "reserveButton");
        Intrinsics.checkNotNullParameter(r216, "subscriptions");
        Context r100 = null;
        if (r214 == null) goto L5;
        Long r101 = Long.valueOf(r214.appointmentId);
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r211 != null) goto L11;
    L14:
        if (r211 != null) goto L17;
    L19:
        if (r211 != null) goto L22;
    L24:
        long r102 = 10000;
    L13:
        long r111 = r102;
        if (((IUserService) k.n(IUserService.class)).user().isLogin() == true) goto L36;
        if ((r210 instanceof FragmentActivity) == false) goto L31;
        r100 = r210;
    L31:
        FragmentActivity r112 = (FragmentActivity) r100;
        if (r112 == null) goto L40;
        TTLiveSDK.hostService().user().login(r112, new b(this, r110, r210, r211, r212, r213, r214, r215, r216), "", "", 0, "", "", "");
        return;
    L40:
        return;
    L36:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L38;
        r216.add(((AppointmentApi) com.bytedance.android.live.network.c.b().e(AppointmentApi.class)).cancelOneAppointment(r214.appointmentId, r214.appointmentType, r111, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r214, r212, r213, r215), new d(this, r213, r215, r214)));
        return;
    L38:
        r216.add(((AppointmentApi) com.bytedance.android.live.network.c.b().e(AppointmentApi.class)).makeOneAppointment(r214.appointmentId, r214.appointmentType, r111, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r214, r212, r213, r215), new f(this, r213, r215, r214)));
        return;
    L22:
        if (r211.intValue() != 3) goto L24;
        r102 = SOURCE_SECONDARY;
        goto L13
    L17:
        if (r211.intValue() != 2) goto L19;
        r102 = SOURCE_DRAWER;
        goto L13
    L11:
        if (r211.intValue() != 1) goto L14;
        r102 = SOURCE_LIVE_END;
        goto L13
    L5:
        r101 = null;
        goto L6
    }
}
