package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LongPressPanelFollowWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressPanelFollowWidget extends MiddlewareRoomWidget {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f113155b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f113156a;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.user.h<FollowPair> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongPressPanelFollowWidget f113157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f113158b;

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onComplete() {
            LongPressPanelFollowWidget.xq(this.f113157a);
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            LongPressPanelFollowWidget.yq(this.f113157a, r100);
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onNext(Object r100) {
            FollowPair r101 = (FollowPair) r100;
            Intrinsics.checkNotNullParameter(r101, "followPair");
            if (this.f113158b.mo8271getOwner() != null) goto L5;
            return;
        L5:
            if (this.f113157a.dataCenter == null) goto L54;
            User r102 = this.f113158b.mo8271getOwner();
            if (r102 == null) goto L10;
            r102.setFollowStatus(r101.getFollowStatus());
        L10:
            DataCenter r103 = this.f113157a.dataCenter;
            if (r101.getFollowStatus() == 0) goto L13;
            boolean r104 = true;
        L14:
            r103.put("data_is_followed", Boolean.valueOf(r104));
            if (r101.getFollowStatus() == 0) goto L50;
            JSONObject r105 = new JSONObject();
            User r106 = this.f113158b.mo8271getOwner();     // Catch: JSONException -> L23
            if (r106 == null) goto L20;
            String r107 = r106.getIdStr();     // Catch: JSONException -> L23
        L21:
            r105.put("anchor_id", r107);     // Catch: JSONException -> L23
            r105.put("room_id", String.valueOf(this.f113158b.f162599id));     // Catch: JSONException -> L23
            r105.put("follow_status", r101.getFollowStatus());     // Catch: JSONException -> L23
        L25:
            g4.h(r105);
            if (com.bytedance.android.livesdk.utils.c1.b(this.f113157a.dataCenter) == false) goto L37;
            ILiveDouPlusService r108 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
            if (r108 == null) goto L51;
            HashMap r109 = new HashMap();
            r109.put("ad_extra_data", r105.toString());
            Map<String, String> r110 = com.bytedance.android.livesdk.utils.c1.e(this.f113157a.dataCenter);
            if (r110 != null) goto L32;
        L35:
            r108.logEvent(true, "live_ad", "follow_success", r109);
            return;
        L32:
            if (r110.isEmpty() == true) goto L35;
            r109.putAll(r110);
            goto L35
        L51:
            return;
        L37:
            if (com.bytedance.android.livesdk.utils.c1.c(this.f113157a.dataCenter) == false) goto L53;
            ILiveDouPlusService r111 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
            if (r111 == null) goto L45;
            HashMap r112 = new HashMap();
            r112.put("ad_extra_data", r105.toString());
            Map<String, String> r113 = com.bytedance.android.livesdk.utils.c1.f(this.f113157a.dataCenter);
            if (r113.isEmpty() == true) goto L44;
            r112.putAll(r113);
        L44:
            r111.logEvent(true, "live_ad", "follow_success", r112);
        L45:
            b3.a(this.f113157a.dataCenter, r105);
            return;
        L53:
            return;
        L20:
            r107 = null;
        L23:
            e = move-exception;
            e.printStackTrace();
            goto L25
        L50:
            return;
        L13:
            r104 = false;
            goto L14
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f113157a.f113156a.add(r100);
        }

        public b(LongPressPanelFollowWidget r100, Room r101) {
            this.f113157a = r100;
            this.f113158b = r101;
        }
    }

    public static final class c extends com.bytedance.android.livesdk.user.h<FollowPair> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongPressPanelFollowWidget f113159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f113160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ mt1.a f113161c;

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onNext(Object r100) {
            FollowPair r101 = (FollowPair) r100;
            Intrinsics.checkNotNullParameter(r101, "followPair");
            boolean r102 = true;
            if (com.bytedance.android.livesdk.utils.c1.c(this.f113159a.dataCenter) == false) goto L21;
            JSONObject r103 = new JSONObject();
            User r104 = this.f113160b.mo8271getOwner();     // Catch: JSONException -> L11
            if (r104 == null) goto L8;
            String r105 = r104.getIdStr();     // Catch: JSONException -> L11
        L9:
            r103.put("anchor_id", r105);     // Catch: JSONException -> L11
            r103.put("room_id", String.valueOf(this.f113160b.getId()));     // Catch: JSONException -> L11
        L13:
            ILiveDouPlusService r106 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
            if (r106 == null) goto L21;
            HashMap r107 = new HashMap();
            r107.put("ad_extra_data", r103.toString());
            Map<String, String> r108 = com.bytedance.android.livesdk.utils.c1.f(this.f113159a.dataCenter);
            if (r108.isEmpty() == true) goto L19;
            r107.putAll(r108);
        L19:
            r106.logEvent(true, "live_ad", "follow_cancel", r107);
            goto L21
        L8:
            r105 = null;
        L11:
            e = move-exception;
            e.printStackTrace();
        L21:
            if (CollectionsKt.contains(LongPressPanelFollowWidget.f113155b, this.f113161c.f515598d) == false) goto L24;
            xs2.b.a().post(new zg1.h1(38, this.f113161c.f515597c));
        L24:
            if (this.f113160b.mo8271getOwner() != null) goto L26;
            return;
        L26:
            if (this.f113159a.dataCenter == null) goto L40;
            User r109 = this.f113160b.mo8271getOwner();
            if (r109 == null) goto L31;
            r109.setFollowStatus(r101.getFollowStatus());
        L31:
            DataCenter r110 = this.f113159a.dataCenter;
            if (r101.getFollowStatus() != 0) goto L35;
            r102 = false;
        L35:
            r110.put("data_is_followed", Boolean.valueOf(r102));
            return;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f113159a.f113156a.add(r100);
        }

        public c(LongPressPanelFollowWidget r100, Room r101, mt1.a r102) {
            this.f113159a = r100;
            this.f113160b = r101;
            this.f113161c = r102;
        }
    }

    public final class d implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f113162a;

        public d(Function1 r100) {
            this.f113162a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f113162a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.LongPressPanelFollowWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmt1/a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lmt1/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<mt1.a, Unit> {
        public AnonymousClass1(LongPressPanelFollowWidget r100) {
            super(1, r100, LongPressPanelFollowWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/dislike/event/DislikeMenuEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(mt1.a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(mt1.a r100) {
            LongPressPanelFollowWidget.wq((LongPressPanelFollowWidget) this.receiver, r100);
        }
    }

    static {
        f113155b = CollectionsKt.mutableListOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    public final Room getRoom() {
        DataCenter r100 = this.dataCenter;
        if (r100 != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.live.core.utils.z.o(r100);
    }

    public LongPressPanelFollowWidget() {
        this.f113156a = new CompositeDisposable();
    }

    private final FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = ho1.a.d(getComponentContext());
        if (r100 == null) goto L7;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L7;
        return r101.getActivity();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        d r100 = new d(new AnonymousClass1(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(mt1.a.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r100);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f113156a.dispose();
    }

    public static final void xq(LongPressPanelFollowWidget r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        Room r102 = r100.getRoom();     // Catch: JSONException -> L16
        if (r102 == null) goto L9;
        User r103 = r102.mo8271getOwner();     // Catch: JSONException -> L16
        if (r103 == null) goto L9;
        String r104 = r103.getIdStr();     // Catch: JSONException -> L16
        if (r104 == null) goto L9;
    L10:
        r101.put("anchor_id", r104);     // Catch: JSONException -> L16
        Room r105 = r100.getRoom();     // Catch: JSONException -> L16
        if (r105 == null) goto L13;
        long r106 = r105.f162599id;     // Catch: JSONException -> L16
    L14:
        r101.put("room_id", String.valueOf(r106));     // Catch: JSONException -> L16
    L18:
        g4.h(r101);
        if (com.bytedance.android.livesdk.utils.c1.c(r100.dataCenter) == false) goto L29;
        ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        if (r107 == null) goto L27;
        HashMap r108 = new HashMap();
        r108.put("ad_extra_data", r101.toString());
        Map<String, String> r109 = com.bytedance.android.livesdk.utils.c1.f(r100.dataCenter);
        if (r109.isEmpty() == true) goto L26;
        r108.putAll(r109);
    L26:
        r107.logEvent(true, "live_ad", "follow", r108);
    L27:
        b3.a(r100.dataCenter, r101);
    L29:
        if (com.bytedance.android.livesdk.utils.c1.b(r100.dataCenter) == false) goto L39;
        ILiveDouPlusService r110 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        if (r110 == null) goto L39;
        HashMap r111 = new HashMap();
        r111.put("ad_extra_data", r101.toString());
        Map<String, String> r112 = com.bytedance.android.livesdk.utils.c1.e(r100.dataCenter);
        if (r112 != null) goto L35;
    L38:
        r110.logEvent(true, "live_ad", "follow", r111);
        goto L39
    L35:
        if (r112.isEmpty() == true) goto L38;
        r111.putAll(r112);
    L39:
        f2.b(R.string.ttlive_live_follow_success, 0);
        return;
    L13:
        r106 = 0;
    L9:
        r104 = "";
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static final void wq(LongPressPanelFollowWidget r100, mt1.a r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        Room r102 = r101.f515597c;
    L6:
        if (r102 == null) goto L38;
        int r103 = r101.getType();
        if (r103 == 0) goto L13;
        if (r103 == 1) goto L13;
        return;
    L13:
        if (r101.getType() != 0) goto L15;
        boolean r104 = true;
    L17:
        if (((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().isLogin() == true) goto L20;
        com.bytedance.android.livesdk.user.f r105 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h();
        Context r106 = r100.getContext();
        com.bytedance.android.livesdk.user.l.a r107 = new com.bytedance.android.livesdk.user.l.a();
        r107.f158685a = CoreSettingUtil.getLoginPromptForFollow();
        r107.f158686b = CoreSettingUtil.getLoginImageForFollow();
        r107.f158687c = 0;
        com.bytedance.android.livesdk.user.f0 r108 = (com.bytedance.android.livesdk.user.f0) r105;
        Disposable r109 = r108.login(r106, new com.bytedance.android.livesdk.user.l(r107)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e0(r100, r101, r104), f0.f113338a);
        r100.f113156a.add(r109);
        return;
    L20:
        if (r101.f515600f == true) goto L22;
    L32:
        r100.zq(r101, r104);
        return;
    L22:
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L32;
        if (r101.getType() != 0) goto L27;
        Lazy r110 = DispatchLogUtil.f122274a;
        DispatchLogUtil.d(1, DispatchLogUtil.InstanceType.FOLLOW);
        int r111 = tt1.e.f547522a;
        tt1.e.a(r100.getContext(), new c0(r100));
        return;
    L27:
        if (r101.getType() != 1) goto L36;
        FragmentActivity r112 = r100.getActivity();
        if (r112 == null) goto L40;
        com.bytedance.android.livesdk.dispatch.utils.d.a("LiveActivity", r112);
        Lazy r113 = DispatchLogUtil.f122274a;
        DispatchLogUtil.d(1, DispatchLogUtil.InstanceType.UNFOLLOW);
        int r114 = tt1.e.f547522a;
        tt1.e.b(r100.getContext(), new d0(r100, r101));
        return;
    L40:
        return;
    L36:
        return;
    L15:
        r104 = false;
        goto L17
    L38:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void yq(LongPressPanelFollowWidget r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof ApiServerException) == true) goto L5;
    L7:
        f2.b(R.string.ttlive_live_follow_failed, 0);
        return;
    L5:
        if (s1.getContext() == null) goto L7;
        IESUIUtils.displayToast(s1.getContext(), ((ApiServerException) r101).getPrompt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zq(mt1.a r110, boolean r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        Room r100 = r110.f515597c;
        if (r100 != null) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r101 = ho1.a.d(getComponentContext());
        if (r101 == null) goto L10;
        r101.p0();
    L10:
        if (r111 == false) goto L16;
        com.bytedance.android.livesdk.user.f r112 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h();
        com.bytedance.android.livesdk.user.b.a r113 = new com.bytedance.android.livesdk.user.d.c().c(r100.getOwnerUserIdString());
        r100.getRequestId();
        com.bytedance.android.livesdk.user.d.c r114 = (com.bytedance.android.livesdk.user.d.c) r113.e();
        r114.getClass();
        com.bytedance.android.livesdk.user.d.c r115 = (com.bytedance.android.livesdk.user.d.c) ((com.bytedance.android.livesdk.user.d.c) r114.g("live")).h(r100.f162599id);
        r100.getLabels();
        r115.getClass();
        com.bytedance.android.livesdk.user.d.c r116 = (com.bytedance.android.livesdk.user.d.c) r115.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        r116.getClass();
        String r102 = r116.f158637a;
        String r103 = r116.f158638b;
        long r104 = r116.f158645e;
        HashMap<String, String> r105 = r116.f158646f;
        boolean r106 = r116.f158647g;
        com.bytedance.android.livesdk.user.f0 r107 = (com.bytedance.android.livesdk.user.f0) r112;
        r107.getClass();
        r107.Q(1, r102, r104, r103, r105, r106).subscribe(new b(this, r100));
        com.bytedance.android.livesdk.log.d.b(this.dataCenter, "live_ad", "follow", r100.getAnchorId(), String.valueOf(r100.f162599id));
        com.bytedance.android.live.core.feed.a.C1064a r117 = com.bytedance.android.live.core.feed.a.f64795d;
        if (r117.a().c(Long.valueOf(r100.f162599id)) == false) goto L14;
    L15:
        com.bytedance.android.livesdk.log.d.b(this.dataCenter, "draw_ad", "click", r100.getAnchorId(), String.valueOf(r100.f162599id));
        return;
    L14:
        if (r117.a().b(Long.valueOf(r100.f162599id)) == true) goto L15;
        return;
    L16:
        com.bytedance.android.livesdk.user.f r118 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h();
        com.bytedance.android.livesdk.user.n.c r108 = (com.bytedance.android.livesdk.user.n.c) new com.bytedance.android.livesdk.user.n.c().c(r100.getOwnerUserIdString());
        r108.getClass();
        User r109 = r100.mo8271getOwner();
        if (r109 == null) goto L21;
        FollowInfo r119 = r109.getFollowInfo();
        if (r119 == null) goto L21;
        r119.getFollowStatus();
    L21:
        com.bytedance.android.livesdk.user.n.c r120 = (com.bytedance.android.livesdk.user.n.c) r108.f(r100.f162599id);
        r120.getClass();
        com.bytedance.android.livesdk.user.n.c r121 = (com.bytedance.android.livesdk.user.n.c) r120.e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        r121.getClass();
        String r122 = r121.f158637a;
        String r123 = r121.f158638b;
        HashMap<String, String> r124 = r121.f158639c;
        long r125 = r121.f158696d;
        boolean r126 = r121.f158697e;
        com.bytedance.android.livesdk.user.f0 r127 = (com.bytedance.android.livesdk.user.f0) r118;
        r127.getClass();
        r127.Q(0, r122, r125, r123, r124, r126).subscribe(new c(this, r100, r110));
    }
}
