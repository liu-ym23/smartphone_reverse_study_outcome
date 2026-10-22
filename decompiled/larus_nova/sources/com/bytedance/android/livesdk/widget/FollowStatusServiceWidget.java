package com.bytedance.android.livesdk.widget;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.event.FollowStatusDataErrorEvent;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.ServiceAction;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/widget/FollowStatusServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/event/FollowStatusDataErrorEvent;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowStatusServiceWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f160868a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.FollowStatusServiceWidget$onLoad$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/event/FollowStatusDataErrorEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FollowStatusDataErrorEvent, Unit> {
        public AnonymousClass1(FollowStatusServiceWidget r100) {
            super(1, r100, FollowStatusServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/event/FollowStatusDataErrorEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FollowStatusDataErrorEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ((FollowStatusServiceWidget) this.receiver).onEvent(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FollowStatusDataErrorEvent r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f160868a.clear();
    }

    public FollowStatusServiceWidget() {
        this.f160868a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onEvent(FollowStatusDataErrorEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        String r100 = r110.f123307c;
        Boolean r101 = vt2.a.f557192a;
        com.bytedance.android.live.base.model.user.c0 r102 = r110.f123305a;
        if (r102 != null) goto L5;
        String r103 = "data is null";
    L12:
        String r104 = "0";
        if (TextUtils.isEmpty(r103) == false) goto L15;
        String r105 = "1";
    L16:
        FollowStatusDataErrorEvent.FollowDataSource r106 = r110.f123306b;
        String r107 = r110.f123308d;
        String r108 = r110.f123309e;
        com.bytedance.android.live.base.model.user.c0 r109 = r110.f123305a;
        Object r111 = r110.f123310f;
        Intrinsics.checkNotNullParameter(r106, "enterRoomFollow");
        HashMap r112 = new HashMap();     // Catch: Exception -> L48
        r112.put("data_status", r105);     // Catch: Exception -> L48
        r112.put("api", r106.getSource());     // Catch: Exception -> L48
        if (r103 != null) goto L21;
        String r113 = "";
    L22:
        r112.put("data", r113);     // Catch: Exception -> L48
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        r112.put("log_id", r107);     // Catch: Exception -> L48
        if (r111 != null) goto L28;
        r111 = 0L;     // Catch: Exception -> L48
    L28:
        r112.put("adopter_id", r111.toString());     // Catch: Exception -> L48
        if (r108 != null) goto L31;
        r108 = "0";
    L31:
        r112.put("anchor_id", r108);     // Catch: Exception -> L48
        IUserService r114 = (IUserService) jc1.k.f(IUserService.class);     // Catch: Exception -> L48
        if (r114 == null) goto L39;
        com.bytedance.android.livesdk.user.f r115 = r114.user();     // Catch: Exception -> L48
        if (r115 == null) goto L39;
        String r116 = r115.n();     // Catch: Exception -> L48
        if (r116 == null) goto L39;
        r104 = r116;
    L39:
        r112.put("uid", r104);     // Catch: Exception -> L48
        if (r109 == null) goto L43;
        String r117 = r109.toString();     // Catch: Exception -> L48
        if (r117 == null) goto L43;
    L44:
        r112.put("follow_info", r117);     // Catch: Exception -> L48
        vt2.a.c("ttlive_follow_data", 0, "", r112);     // Catch: Exception -> L48
        if (TextUtils.isEmpty(r103) == true) goto L53;
        vt2.a.d("ttlive_follow_data", 0, "", r112);     // Catch: Exception -> L48
        return;
    L53:
        return;
    L43:
        r117 = "";
        goto L44
    L21:
        r113 = r103;
    L48:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        r105 = "0";
        goto L16
    L5:
        StringBuilder r118 = new StringBuilder();
        if (TextUtils.isEmpty(r102.getFollowerCountStr()) == false) goto L9;
        r118.append("follower_count_str is null");
    L9:
        if (TextUtils.isEmpty(r102.getFollowingCountStr()) == false) goto L11;
        r118.append("following_count_str is null");
    L11:
        r103 = r118.toString();
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        RxUtilKt.c(xs2.b.a().b(FollowStatusDataErrorEvent.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(new AnonymousClass1(this))), this.f160868a);
        Room r111 = com.bytedance.android.live.core.utils.z.o(this.dataCenter);
        String r100 = null;
        if (r111 == null) goto L9;
        vt2.a r101 = vt2.a.f557193b;
        User r102 = r111.mo8271getOwner();
        if (r102 == null) goto L7;
        FollowInfo r103 = r102.getFollowInfo();
    L8:
        String r104 = r101.b(r103);
    L10:
        String r105 = r104;
        vt2.a r106 = vt2.a.f557193b;
        if (TextUtils.isEmpty(r105) == false) goto L13;
        String r107 = "1";
    L14:
        String r108 = r107;
        FollowStatusDataErrorEvent.FollowDataSource r109 = FollowStatusDataErrorEvent.FollowDataSource.ENTER_ROOM_FOLLOW;
        if (r111 == null) goto L17;
        String r112 = r111.getEnterLogId();
    L18:
        if (r111 == null) goto L22;
        User r113 = r111.mo8271getOwner();
        if (r113 == null) goto L22;
        String r114 = r113.getIdStr();
    L23:
        if (r111 == null) goto L27;
        User r115 = r111.mo8271getOwner();
        if (r115 == null) goto L27;
        FollowInfo r116 = r115.getFollowInfo();
    L28:
        vt2.b.a.a(r106, r108, r109, r105, r112, r114, r116);
        RoomContext r117 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        boolean r118 = false;
        if (r117 == null) goto L37;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r119 = r117.getExternalConfigJudger();
        if (r119 == null) goto L37;
        IExternalConfigJudger r120 = r119.getValue();
        if (r120 == null) goto L37;
        boolean r121 = true;
        if (r120.canUse(EXTERNAL_CONFIG_TYPE.Service, ServiceAction.followService, false) != true) goto L37;
    L38:
        if (r121 == false) goto L73;
        DataCenter r122 = this.dataCenter;
        if (r122 == null) goto L45;
        Boolean r123 = (Boolean) r122.get("data_is_anchor", Boolean.FALSE);
        if (r123 == null) goto L45;
        r118 = r123.booleanValue();
    L45:
        if (r118 == true) goto L66;
        DataCenter r124 = this.dataCenter;
        if (r124 == null) goto L49;
        Room r125 = (Room) r124.get("data_room", null);
    L50:
        if (r125 == null) goto L52;
        r100 = r125.getOwnerUserIdString();
    L52:
        IUserService r126 = (IUserService) jc1.k.f(IUserService.class);
        if (r126 == null) goto L67;
        com.bytedance.android.livesdk.user.f r127 = r126.user();
        if (r127 == null) goto L68;
        Observable<FollowPair> r128 = r127.u0(r100);
        if (r128 == null) goto L69;
        Observable<FollowPair> r129 = r128.subscribeOn(Schedulers.io());
        if (r129 == null) goto L70;
        Observable<FollowPair> r130 = r129.observeOn(AndroidSchedulers.mainThread());
        if (r130 == null) goto L71;
        Disposable r131 = r130.subscribe(new s(this, r125), t.f162146a);
        if (r131 == null) goto L72;
        this.f160868a.add(r131);
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L49:
        r125 = null;
        goto L50
    L66:
        return;
    L73:
        return;
    L37:
        r121 = false;
    L27:
        r116 = null;
    L22:
        r114 = null;
        goto L23
    L17:
        r112 = null;
        goto L18
    L13:
        r107 = "0";
        goto L14
    L7:
        r103 = null;
        goto L8
    L9:
        r104 = "room is null";
        goto L10
    }
}
