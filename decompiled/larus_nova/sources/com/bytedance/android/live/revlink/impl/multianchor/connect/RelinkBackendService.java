package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.android.livesdk.link.model.p6;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "Ld11/o;", "params", "switchChannelInvite", "Ld11/p;", "switchChannelReply", "Ld11/n;", "switchChannelCancel", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lyz0/l;", "messageService", "Lyz0/l;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;", "apiListener", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "dataContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RelinkBackendService extends DataContext {
    private final b apiListener;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f93112cd;
    private final RelinkDataContext dataContext;
    private final yz0.l messageService;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93113a;

        public a(RelinkBackendService r100) {
            this.f93113a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            RelinkBackendService.access$getCd$p(this.f93113a).clear();
        }
    }

    public interface b {
        void a(d11.p r100);

        void c(d11.o r100, n9 r101);

        void d(d11.n r100);

        void f(d11.n r100, Throwable r101);

        void g(d11.o r100, Throwable r101);

        void h(d11.p r100, Throwable r101);
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.n f93116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93117c;

        public d(RelinkBackendService r100, d11.n r101, long r102) {
            this.f93115a = r100;
            this.f93116b = r101;
            this.f93117c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            ExtraResponse r100 = (ExtraResponse) r210;
            e0 r101 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r101 == null) goto L5;
            d11.n r102 = this.f93116b;
            long r103 = t.a(this.f93117c);
            Intrinsics.checkNotNullParameter(r102, "params");
            JSONObject r104 = new JSONObject();
            int r105 = y50.b.f566204a;
            y50.b.a.d(r104, "params", r102.toString());
            r101.c(r104);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r101).E("switch_channel_cancel_success", r103, r104);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r101).e("/webcast/linkmic/switch_channel_cancel/", new d31.a(0, 0, 0, 0, r102.f466343f, 0, 0, null, null, null, null, 4079), r103);
        L5:
            RelinkBackendService.access$getApiListener$p(this.f93115a).d(this.f93116b);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.n f93119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93120c;

        public e(RelinkBackendService r100, d11.n r101, long r102) {
            this.f93118a = r100;
            this.f93119b = r101;
            this.f93120c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Throwable r100 = (Throwable) r210;
            e0 r101 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r101 == null) goto L5;
            d11.n r102 = this.f93119b;
            long r103 = t.a(this.f93120c);
            Intrinsics.checkNotNullParameter(r102, "params");
            JSONObject r104 = new JSONObject();
            int r105 = y50.b.f566204a;
            y50.b.a.d(r104, "params", r102.toString());
            r101.c(r104);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r101).G("switch_channel_cancel_failed", r100, r104, Long.valueOf(r103));
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r101).c("/webcast/linkmic/switch_channel_cancel/", new d31.a(0, 0, 0, 0, r102.f466343f, 0, 0, null, null, null, null, 4079), r100, r103);
        L5:
            RelinkBackendService.access$getApiListener$p(this.f93118a).f(this.f93119b, r100);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.o f93122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93123c;

        public f(RelinkBackendService r100, d11.o r101, long r102) {
            this.f93121a = r100;
            this.f93122b = r101;
            this.f93123c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            ExtraResponse r100 = (ExtraResponse) r210;
            if (r100 == null) goto L15;
            n9 r101 = (n9) r100.data;
            if (r101 == null) goto L15;
            if (r101.isFailure() == true) goto L15;
            e0 r102 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r102 == null) goto L18;
            d11.o r103 = this.f93122b;
            n9 r104 = (n9) r100.data;
            long r105 = t.a(this.f93123c);
            Intrinsics.checkNotNullParameter(r103, "params");
            JSONObject r106 = new JSONObject();
            int r107 = y50.b.f566204a;
            y50.b.a.d(r106, "invite_params", r103.toString());
            if (r104 == null) goto L13;
            Long r108 = Long.valueOf(r104.getWaitSec());
        L14:
            y50.b.a.d(r106, "wait_sec", String.valueOf(r108));
            r102.c(r106);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r102).E("switch_channel_invite_success", r105, r106);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r102).e("/webcast/linkmic/switch_channel_invite/", new d31.a(r103.f466345b, 0, 0, 0, null, 0, 0, null, null, null, null, 4094), r105);
            goto L18
        L13:
            r108 = null;
        L18:
            RelinkBackendService.access$getDataContext$p(this.f93121a).getRelinkInviteSuccess().post(r100.data);
            RelinkBackendService.access$getApiListener$p(this.f93121a).c(this.f93122b, (n9) r100.data);
            return;
        L15:
            e0 r109 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r109 == null) goto L18;
            r109.m(this.f93122b, (n9) r100.data, new Exception("inviter not support"), t.a(this.f93123c));
            goto L18
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.o f93125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93126c;

        public g(RelinkBackendService r100, d11.o r101, long r102) {
            this.f93124a = r100;
            this.f93125b = r101;
            this.f93126c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            e0 r102 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r102 == null) goto L5;
            r102.m(this.f93125b, null, r101, t.a(this.f93126c));
        L5:
            RelinkBackendService.access$getApiListener$p(this.f93124a).g(this.f93125b, r101);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.p f93128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93129c;

        public h(RelinkBackendService r100, d11.p r101, long r102) {
            this.f93127a = r100;
            this.f93128b = r101;
            this.f93129c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            ExtraResponse r100 = (ExtraResponse) r210;
            e0 r101 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r101 == null) goto L5;
            d11.p r102 = this.f93128b;
            long r103 = t.a(this.f93129c);
            Intrinsics.checkNotNullParameter(r102, "params");
            JSONObject r104 = new JSONObject();
            int r105 = y50.b.f566204a;
            y50.b.a.d(r104, "reply_params", r102.toString());
            r101.c(r104);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r101).E("switch_channel_reply_success", r103, r104);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r101).e("/webcast/linkmic/switch_channel_reply/", new d31.a(r102.f466356g, 0, 0, 0, null, r102.f466350a, 0, null, null, null, null, SpeechEngineDefines.CODE_PLAYER_STOP_FAILED), r103);
        L5:
            RelinkBackendService.access$getApiListener$p(this.f93127a).a(this.f93128b);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelinkBackendService f93130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.p f93131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f93132c;

        public i(RelinkBackendService r100, d11.p r101, long r102) {
            this.f93130a = r100;
            this.f93131b = r101;
            this.f93132c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Throwable r100 = (Throwable) r210;
            e0 r101 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r101 == null) goto L5;
            d11.p r102 = this.f93131b;
            long r103 = t.a(this.f93132c);
            Intrinsics.checkNotNullParameter(r102, "params");
            JSONObject r104 = new JSONObject();
            int r105 = y50.b.f566204a;
            y50.b.a.d(r104, "reply_params", r102.toString());
            r101.c(r104);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r101).G("switch_channel_reply_failed", r100, r104, Long.valueOf(r103));
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r101).c("/webcast/linkmic/switch_channel_reply/", new d31.a(r102.f466356g, 0, 0, 0, null, r102.f466350a, 0, null, null, null, null, SpeechEngineDefines.CODE_PLAYER_STOP_FAILED), r100, r103);
        L5:
            RelinkBackendService.access$getApiListener$p(this.f93130a).h(this.f93131b, r100);
        }
    }

    public static final /* synthetic */ b access$getApiListener$p(RelinkBackendService r100) {
        return r100.apiListener;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(RelinkBackendService r100) {
        return r100.f93112cd;
    }

    public static final /* synthetic */ RelinkDataContext access$getDataContext$p(RelinkBackendService r100) {
        return r100.dataContext;
    }

    private final void onMessage(yh6.c r110) {
        if ((r110 instanceof h1) == false) goto L42;
        i6 r111 = (i6) ((h1) r110).castTo(i6.class);
        switch(((int) r111.getType2())) {
            case 60: goto L31;
            case 61: goto L11;
            case 62: goto L7;
            default: goto L45;
        };
    L7:
        e0 r100 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r100 == null) goto L10;
        Intrinsics.checkNotNullParameter(r111, "msg");
        JSONObject r101 = new JSONObject();
        com.bytedance.android.live.revlink.link.biz.service.i.H(r100).getClass();
        v.m(r111, r101);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r100).I("receive_switch_channel_cancel_msg", r101, false);
    L10:
        this.dataContext.getReceiveSwitchChannelCancel().post(r111);
        return;
    L11:
        e0 r102 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r102 == null) goto L30;
        Intrinsics.checkNotNullParameter(r111, "msg");
        JSONObject r103 = new JSONObject();
        p6 r104 = r111.getSwitchChannelReplyContent();
        if (r104 == null) goto L29;
        k6 r105 = r104.getReplyContent();
        if (r105 == null) goto L29;
        int r106 = y50.b.f566204a;
        y50.b.a.d(r103, "reply_status", String.valueOf(r105.getReplyStatus()));
        String r107 = r105.getFromUid();
        String r108 = "";
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        y50.b.a.d(r103, "from_user", r107);
        y50.b.a.c(r103, "from_room", r105.getFromRoomId());
        y50.b.a.d(r103, ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, String.valueOf(r105.getMatchType()));
        String r109 = r105.getToUid();
        if (r109 == null) goto L24;
        r108 = r109;
    L24:
        y50.b.a.d(r103, "to_user", r108);
        b7 r112 = r105.getMultiChannelInfo();
        if (r112 == null) goto L27;
        String r113 = c7.a(r112);
    L28:
        y50.b.a.d(r103, "multi_channel_info", r113);
        y50.b.a.d(r103, "multi_channel_version", String.valueOf(r105.getVersion()));
        goto L29
    L27:
        r113 = null;
    L29:
        com.bytedance.android.live.revlink.link.biz.service.i.H(r102).getClass();
        v.m(r111, r103);
        r102.c(r103);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r102).I("receive_switch_channel_reply_msg", r103, false);
    L30:
        this.dataContext.getReceiveSwitchChannelReply().post(r111);
        return;
    L31:
        e0 r114 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r114 == null) goto L40;
        Intrinsics.checkNotNullParameter(r111, "msg");
        JSONObject r115 = new JSONObject();
        o6 r116 = r111.getSwitchChannelInviteContent();
        if (r116 == null) goto L36;
        r116.getInviteContent();
    L36:
        IBattleLinkerInviteMessageExtra r117 = j6.a(r111);
        if (r117 == null) goto L39;
        int r118 = y50.b.f566204a;
        y50.b.a.d(r115, ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, String.valueOf(r117.getMatchType()));
        y50.b.a.d(r115, "invite_type", String.valueOf(r117.getInviteType()));
    L39:
        com.bytedance.android.live.revlink.link.biz.service.i.H(r114).getClass();
        v.m(r111, r115);
        r114.c(r115);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r114).I("receive_switch_channel_invite_msg", r115, false);
    L40:
        this.dataContext.getReceiveSwitchChannelInvite().post(r111);
        return;
    L45:
        return;
    }

    public final void switchChannelCancel(d11.n r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelCancel " + r110);
        long r100 = System.currentTimeMillis();
        Observable<ExtraResponse<Object, Extra>> r101 = r31.b.a(r31.a.f535859a).d(r110.f466338a, r110.f466339b, r110.f466340c, r110.f466341d, r110.f466342e);
        if (r101 == null) goto L10;
        Observable<R> r102 = r101.compose(RxUtil.rxSchedulerHelper());
        if (r102 == 0) goto L11;
        Disposable r111 = r102.subscribe(new d(this, r110, r100), new e(this, r110, r100));
        if (r111 == null) goto L12;
        this.f93112cd.add(r111);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void switchChannelInvite(d11.o r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelInvite " + r110);
        long r100 = System.currentTimeMillis();
        Observable<ExtraResponse<n9, Extra>> r101 = r31.b.a(r31.a.f535859a).E(r110.f466344a, r110.f466345b, r110.f466346c, r110.f466347d, r110.f466348e, r110.f466349f);
        if (r101 == null) goto L10;
        Observable<R> r102 = r101.compose(RxUtil.rxSchedulerHelper());
        if (r102 == 0) goto L11;
        Disposable r111 = r102.subscribe(new f(this, r110, r100), new g(this, r110, r100));
        if (r111 == null) goto L12;
        this.f93112cd.add(r111);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void switchChannelReply(d11.p r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelReply " + r110);
        long r100 = System.currentTimeMillis();
        Observable<ExtraResponse<Object, Extra>> r101 = r31.b.a(r31.a.f535859a).L(r110.f466350a, r110.f466351b, r110.f466352c, r110.f466353d, r110.f466354e, r110.f466355f, r110.f466356g, r110.f466357h);
        if (r101 == null) goto L10;
        Observable<R> r102 = r101.compose(RxUtil.rxSchedulerHelper());
        if (r102 == 0) goto L10;
        Disposable r103 = r102.subscribe(new h(this, r110, r100), new i(this, r110, r100));
        if (r103 == null) goto L11;
        this.f93112cd.add(r103);
        return;
    L11:
        return;
    }

    public RelinkBackendService(b r100, RelinkDataContext r101) {
        Intrinsics.checkNotNullParameter(r100, "apiListener");
        Intrinsics.checkNotNullParameter(r101, "dataContext");
        this.apiListener = r100;
        this.dataContext = r101;
        CompositeDisposable r102 = new CompositeDisposable();
        this.f93112cd = r102;
        yz0.l r103 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.messageService = r103;
        if (r103 == null) goto L7;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r104 = yz0.h.a.a(r103, com.bytedance.android.live.revenue.common.message.b.f90885b, false, 6);
        final RelinkBackendService$1$1 r105 = new RelinkBackendService$1$1(this);
        Disposable r106 = r104.subscribe(new c(r105));
        if (r106 == null) goto L7;
        RxUtilKt.c(r106, r102);
    L7:
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r102);
    }

    public static final /* synthetic */ void access$onMessage(RelinkBackendService r100, yh6.c r101) {
        r100.onMessage(r101);
    }
}
