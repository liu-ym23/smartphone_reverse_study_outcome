package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.floatwindow.ReplayFloatWindowManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.t;
import mq1.u;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/widget/ReplayScheduleCloseWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayScheduleCloseWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f110217d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f110218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f110219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f110220c;

    public static final class a {
    }

    public static final class b implements jm1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayScheduleCloseWidget f110221a;

        @Override // jm1.c
        public final void C5() {
        }

        @Override // jm1.c
        public final void P1() {
        }

        @Override // jm1.c
        public final void Pc(float r100, boolean r101, long r102) {
        }

        @Override // jm1.c
        public final void Xa(boolean r100) {
        }

        @Override // jm1.c
        public final void g5() {
        }

        @Override // jm1.c
        public final void k2() {
        }

        @Override // jm1.c
        public final void l3() {
        }

        @Override // jm1.c
        public final void onRenderStart() {
        }

        @Override // jm1.c
        public final void z() {
            if (ReplayScheduleCloseWidget.wq(this.f110221a) == false) goto L10;
            t r100 = s.e();
            if (r100 == null) goto L11;
            IReplayInnerProgressService r101 = r100.provideVSProgressService(this.f110221a.dataCenter);
            if (r101 == null) goto L12;
            r101.pause();
            return;
        L12:
            return;
        L11:
            return;
        }

        public b(ReplayScheduleCloseWidget r100) {
            this.f110221a = r100;
        }

        @Override // jm1.c
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }
    }

    public static final class c implements com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayScheduleCloseWidget f110222a;

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a
        public final void c() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a
        public final void b() {
            ReplayScheduleCloseWidget r100 = this.f110222a;
            int r101 = ReplayScheduleCloseWidget.f110217d;
            r100.getClass();
            t r102 = s.e();
            if (r102 == null) goto L7;
            IReplayInnerProgressService r103 = r102.provideVSProgressService(r100.dataCenter);
            if (r103 == null) goto L7;
            r103.pause();
        L7:
            m<Boolean> r104 = r.b().castScreenMode(r100.dataCenter);
            if (r104 == null) goto L13;
            if (r104.getValue().booleanValue() != true) goto L13;
            r.b().pause();
        L13:
            if (r100.context == null) goto L19;
            k r105 = new k(r100.context);
            if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L22;
            DialogLancet.handleBlockedDialogShow(r105);
            goto L19
        L22:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
        L18:
            DialogLancet.beforeDialogShow(r105);
            r105.show();
            DialogLancet.afterDialogShow(r105);
        L19:
            com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a();
            Map<String, com.bytedance.android.livesdk.chatroom.replay.floatwindow.m> r106 = ReplayFloatWindowManager.f108617j;
            ReplayFloatWindowManager.c.a().b();
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a
        public final void d() {
            ReplayScheduleCloseWidget.wq(this.f110222a);
        }

        public c(ReplayScheduleCloseWidget r100) {
            this.f110222a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.dataCenter.removeObserver(this);
        Disposable r100 = this.f110220c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        List<com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a> r101 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118159a;
        c r102 = this.f110218a;
        Intrinsics.checkNotNullParameter(r102, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118159a).remove(r102);
        yq();
        Disposable r103 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118161c;
        if (r103 == null) goto L8;
        r103.dispose();
    L8:
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118165g = "not_start";
        t r104 = s.e();
        if (r104 == null) goto L14;
        u r105 = r104.provideVSPlayerTipService(this.dataCenter);
        if (r105 == null) goto L15;
        r105.hidePlayerTip("schedule_close");
        return;
    L15:
        return;
    }

    public ReplayScheduleCloseWidget() {
        this.f110218a = new c(this);
        this.f110219b = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        boolean r100 = wq1.b.f560683a;
        if (wq1.b.b(this.context) == true) goto L9;
        Disposable r101 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118161c;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118165g = "not_start";
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d <= 1) goto L8;
        long r100 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118163e;
        if (r100 <= 0) goto L8;
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.b(r100);
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d == 1) goto L10;
        return;
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118163e != (-1)) goto L19;
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d = 1;
        t r101 = s.e();
        if (r101 == null) goto L20;
        IReplayInnerProgressService r102 = r101.provideVSProgressService(this.dataCenter);
        if (r102 == null) goto L21;
        r102.addProgressChangeListener(this.f110219b);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void yq() {
        t r100 = s.e();
        if (r100 == null) goto L8;
        IReplayInnerProgressService r101 = r100.provideVSProgressService(this.dataCenter);
        if (r101 == null) goto L9;
        r101.removeProgressChangeListener(this.f110219b);
        return;
    L9:
        return;
    }

    public static final boolean wq(ReplayScheduleCloseWidget r100) {
        r100.getClass();
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118160b == true) goto L12;
        Context r101 = r100.context;
        if (r101 == null) goto L11;
        k r102 = new k(r101);
        r102.setOnDismissListener(g.f110230a);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r102);
        goto L11
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L10:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    L11:
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a();
        return true;
    L12:
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r111 = (KVData) r110;
        if (r111 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r111.getKey(), "cmd_show_schedule_close_action_sheet") == false) goto L50;
        Boolean r100 = Boolean.TRUE;
        Boolean r112 = (Boolean) r111.getData(r100);
        if (r112 != null) goto L9;
        return;
    L9:
        if (this.isViewValid == false) goto L52;
        boolean r113 = r112.booleanValue();
        boolean r101 = true;
        ReplayActionSheet r102 = new ReplayActionSheet(1);
        r102.f118238k = this.dataCenter;
        r102.f118223e = r113;
        ReplayActionSheet.d[] r103 = new ReplayActionSheet.d[4];
        ReplayActionSheet.d r104 = new ReplayActionSheet.d();
        r104.f118250a = s1.B(R.string.ttlive_replay_schedule_close_disable);
        r104.f118251b = 0;
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d != 0) goto L13;
        boolean r105 = true;
    L14:
        r104.f118252c = r105;
        Unit r106 = Unit.INSTANCE;
        r103[0] = r104;
        ReplayActionSheet.d r107 = new ReplayActionSheet.d();
        r107.f118250a = s1.B(R.string.ttlive_vs_schedule_close_until_now);
        r107.f118251b = 1;
        if (1 != com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d) goto L17;
        boolean r108 = true;
    L18:
        r107.f118252c = r108;
        r103[1] = r107;
        ReplayActionSheet.d r109 = new ReplayActionSheet.d();
        r109.f118250a = s1.C(R.string.ttlive_replay_schedule_close_minutes, new Object[]{30});
        r109.f118251b = 2;
        if (2 != com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d) goto L21;
        boolean r114 = true;
    L22:
        r109.f118252c = r114;
        r103[2] = r109;
        ReplayActionSheet.d r115 = new ReplayActionSheet.d();
        r115.f118250a = s1.C(R.string.ttlive_replay_schedule_close_minutes, new Object[]{60});
        r115.f118251b = 3;
        if (3 != com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d) goto L25;
        boolean r116 = true;
    L26:
        r115.f118252c = r116;
        r103[3] = r115;
        List<? extends ReplayActionSheet.d> r117 = CollectionsKt.mutableListOf(r103);
        if (Intrinsics.areEqual(ReplayConfigSettingKeys.REPLAY_SCHEDULE_CLOSE_TEST.getValue(), r100) == false) goto L33;
        ReplayActionSheet.d r118 = new ReplayActionSheet.d();
        r118.f118250a = "1分钟(测试)";
        r118.f118251b = 4;
        if (4 == com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118162d) goto L32;
        r101 = false;
    L32:
        r118.f118252c = r101;
        r117.add(r118);
    L33:
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r102.f118235h = r117;
        r102.f118234g = new h(this);
        r102.f118233f = new i(this);
        Context r119 = this.context;
        if ((r119 instanceof FragmentActivity) == true) goto L36;
        r119 = null;
    L36:
        FragmentActivity r120 = (FragmentActivity) r119;
        if (r120 == null) goto L53;
        FragmentManager r121 = r120.getSupportFragmentManager();
        if (r121 == null) goto L54;
        LandscapeRestrictionOperation r122 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, "ActionSheet", r122);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r121, r102, r122) == true) goto L55;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L44:
        r102.show(r121, "ActionSheet");
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L25:
        r116 = false;
        goto L26
    L21:
        r114 = false;
        goto L22
    L17:
        r108 = false;
        goto L18
    L13:
        r105 = false;
        goto L14
    L52:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.dataCenter.observe("cmd_show_schedule_close_action_sheet", this, false);
        List<com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a> r101 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118159a;
        c r102 = this.f110218a;
        Intrinsics.checkNotNullParameter(r102, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118159a).add(r102);
    }

    public static final void xq(ReplayScheduleCloseWidget r100, String r101) {
        r100.getClass();
        String r102 = s1.C(R.string.ttlive_replay_schedule_close_active_toast, new Object[]{r101});
        DataCenter r103 = r100.dataCenter;
        if (r103 != null) goto L5;
    L7:
        t r104 = s.e();
        if (r104 == null) goto L14;
        u r105 = r104.provideVSPlayerTipService(r100.dataCenter);
        if (r105 == null) goto L15;
        r105.showPlayerTip("schedule_close", r102, true);
        r100.f110220c = Observable.timer(2500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r105));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r103, true) != true) goto L7;
        String r106 = rm3.c.f538539a;
        rm3.c.g(r100.context, r102, 0, false, 28);
    }
}
