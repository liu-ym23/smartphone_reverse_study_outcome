package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f110038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f110039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f110040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f110041d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f110042a;

        public a(m r100) {
            this.f110042a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ALogger.e(this.f110042a.f110038a, String.valueOf(r101.booleanValue()));
            this.f110042a.a(r101.booleanValue());
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f110043a;

        public b(m r100) {
            this.f110043a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = this.f110043a.f110038a;
            ALogger.e(r101, (Throwable) r100);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.f110040c;
    }

    public final void a(boolean r100) {
        ALogger.e(this.f110038a, "showDialog hasOnlineTicket:" + r100);
        if (r100 == false) goto L5;
        lm3.d.a r101 = new lm3.d.a(this.f110040c);
        r101.f509871b = s1.B(R.string.ttlive_replay_delete_ticket_dialog_content);
        lm3.c r102 = new lm3.c();
        r102.f509864b = s1.B(R.string.ttlive_replay_cancel);
        r102.f509865c = lm3.c.a.f509867a;
        Unit r103 = Unit.INSTANCE;
        lm3.c r104 = new lm3.c();
        r104.f509864b = s1.B(R.string.ttlive_replay_delete_ticket_dialog_confirm);
        r104.f509865c = new o(this);
        r101.f509874e = CollectionsKt.listOf(new lm3.c[]{r102, r104});
        r101.a();
        return;
    L5:
        lm3.d.a r105 = new lm3.d.a(this.f110040c);
        r105.f509871b = s1.B(R.string.ttlive_replay_delete_replay_dialog_content);
        lm3.c r106 = new lm3.c();
        r106.f509864b = s1.B(R.string.ttlive_replay_cancel);
        r106.f509865c = lm3.c.a.f509867a;
        Unit r107 = Unit.INSTANCE;
        lm3.c r108 = new lm3.c();
        r108.f509864b = s1.B(R.string.ttlive_replay_delete_replay_dialog_confirm);
        r108.f509865c = new n(this);
        r105.f509874e = CollectionsKt.listOf(new lm3.c[]{r106, r108});
        r105.a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ALogger.e(this.f110038a, SendEventContainerMethodParamModel.EventKinds.onClick);
        Object r101 = null;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f110041d).d("livesdk_replay_video_delete_click", null, new Object[0]);
        fq1.a r102 = fq1.b.a();
        if (r102 == null) goto L42;
        IMainEpisode r103 = r102.a();
        if (r103 == null) goto L42;
        if (r103.isPaidReplay() != true) goto L42;
        fq1.a r104 = fq1.b.a();
        if (r104 == null) goto L13;
        IMainEpisode r105 = r104.a();
        if (r105 == null) goto L13;
        PrivilegeInfo r106 = r105.subscribeReplayInfo();
    L14:
        if (r106 != null) goto L42;
        fq1.a r107 = fq1.b.a();
        if (r107 == null) goto L24;
        IMainEpisode r108 = r107.a();
        if (r108 == null) goto L24;
        ReplayPaidInfo r109 = r108.getReplayPaidInfo();
        if (r109 == null) goto L24;
        TicketData r110 = r109.getTicketData();
        if (r110 == null) goto L24;
        String.valueOf(r110.getTicketId());
    L24:
        com.bytedance.android.livesdk.chatroom.vs_base.base.e r111 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.f.f117931a;
        if (r111 == null) goto L27;
        mq1.n r112 = (mq1.n) com.bytedance.android.scope.m.f163449e.d(r111, mq1.n.class);
    L28:
        if (r112 == null) goto L30;
        AsyncSubject r113 = r112.a();
    L31:
        if (r113 != null) goto L33;
    L38:
        if (r113 == null) goto L45;
        Observable<T> r114 = r113.observeOn(AndroidSchedulers.mainThread());
        if (r114 == 0) goto L46;
        r114.subscribe(new a(this), new b(this));
        return;
    L46:
        return;
    L45:
        return;
    L33:
        if (r113.hasComplete() != true) goto L38;
        if (r113.f495102a.get() != AsyncSubject.f495101e) goto L37;
        r101 = r113.f495104c;
    L37:
        a(Intrinsics.areEqual((Boolean) r101, Boolean.TRUE));
        return;
    L30:
        r113 = null;
        goto L31
    L27:
        r112 = null;
    L13:
        r106 = null;
    L42:
        a(false);
    }

    public m(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f110040c = r100;
        this.f110041d = r101;
        this.f110038a = "ReplayToolbarDeleteBehavior";
        this.f110039b = "sslocal://webcast_redirect?entry=paid_ticket_anchor_detail";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        fq1.a r102 = fq1.b.a();
        if (r102 == null) goto L31;
        IMainEpisode r103 = r102.a();
        if (r103 == null) goto L31;
        if (r103.isPaidReplay() != true) goto L31;
        fq1.a r104 = fq1.b.a();
        if (r104 == null) goto L13;
        IMainEpisode r105 = r104.a();
        if (r105 == null) goto L13;
        PrivilegeInfo r106 = r105.subscribeReplayInfo();
    L14:
        if (r106 != null) goto L31;
        fq1.a r107 = fq1.b.a();
        if (r107 == null) goto L24;
        IMainEpisode r108 = r107.a();
        if (r108 == null) goto L24;
        ReplayPaidInfo r109 = r108.getReplayPaidInfo();
        if (r109 == null) goto L24;
        TicketData r110 = r109.getTicketData();
        if (r110 == null) goto L24;
        String r111 = String.valueOf(r110.getTicketId());
    L25:
        com.bytedance.android.livesdk.chatroom.vs_base.base.e r112 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.f.f117931a;
        if (r112 == null) goto L28;
        mq1.n r113 = (mq1.n) com.bytedance.android.scope.m.f163449e.d(r112, mq1.n.class);
    L29:
        if (r113 == null) goto L31;
        r113.c(r111);
        goto L31
    L28:
        r113 = null;
    L24:
        r111 = null;
    L13:
        r106 = null;
    L31:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r101).d("livesdk_replay_video_delete_show", null, new Object[0]);
    }
}
