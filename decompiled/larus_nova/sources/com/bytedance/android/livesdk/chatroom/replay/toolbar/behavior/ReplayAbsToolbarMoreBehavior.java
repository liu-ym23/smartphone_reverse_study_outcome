package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.toolbar.ReplayToolbarStatisticsLog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.e0;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/behavior/ReplayAbsToolbarMoreBehavior;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lmq1/e0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ReplayAbsToolbarMoreBehavior implements c0.b, Observer<KVData>, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ToolbarButton> f109970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ToolbarButton> f109971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Dialog f109972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f109973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f109974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f109975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRoom f109976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mq1.v f109977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f109978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DataCenter f109979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f109980k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // mq1.e0
    public final void qj() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void b() {
        if (this.f109980k == false) goto L5;
        Boolean r100 = nq1.d.f520106o.getValue();
    L7:
        if (r100.booleanValue() == true) goto L12;
        View r101 = this.f109973d;
        if (r101 == null) goto L18;
        r101.setVisibility(0);
        return;
    L18:
        return;
    L12:
        View r102 = this.f109973d;
        if (r102 == null) goto L19;
        r102.setVisibility(8);
        return;
    L19:
        return;
    L5:
        r100 = nq1.d.f520107p.getValue();
        goto L7
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // mq1.e0
    public final void FY(tq1.g r100) {
        List<ToolbarButton> r101 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.a(this.f109979j, this.f109978i);
        ((ArrayList) this.f109970a).clear();
        ((ArrayList) this.f109970a).addAll(r101);
        List r102 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.b(this.f109979j, this.f109978i);
        ((ArrayList) this.f109971b).clear();
        ((ArrayList) this.f109971b).addAll(r102);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("cmd_toolbar_click_filter", r101.getKey()) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual("data_has_interact_more", r101.getKey()) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual("data_interact_dot_show", r101.getKey()) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual("cmd_dismiss_dialog_end", r101.getKey()) == false) goto L13;
    L33:
        Dialog r102 = this.f109972c;
        if (r102 == null) goto L49;
        Intrinsics.checkNotNull(r102);
        a(r102);
        return;
    L49:
        return;
    L13:
        if (Intrinsics.areEqual("cmd_dismiss_anchor_more_dialog", r101.getKey()) == true) goto L33;
        if (Intrinsics.areEqual("data_hide_screen", r101.getKey()) == false) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual("DATA_AUDIENCE_COMMERCE_MORE_SHOW", r101.getKey()) == false) goto L26;
        Object r103 = r101.getData(Boolean.FALSE);
        Intrinsics.checkNotNull(r103);
        if (((Boolean) r103).booleanValue() == false) goto L24;
        List<ToolbarButton> r104 = this.f109970a;
        ToolbarButton r105 = ToolbarButton.COMMERCE_MORE;
        if (((ArrayList) r104).contains(r105) == true) goto L42;
        ListProtector.add(this.f109970a, 0, r105);
        return;
    L42:
        return;
    L24:
        List<ToolbarButton> r106 = this.f109970a;
        ArrayList r107 = (ArrayList) r106;
        r107.remove(ToolbarButton.COMMERCE_MORE);
        return;
    L26:
        if (Intrinsics.areEqual("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", r101.getKey()) == false) goto L45;
        Object r108 = r101.getData(Boolean.FALSE);
        Intrinsics.checkNotNull(r108);
        if (((Boolean) r108).booleanValue() == false) goto L32;
        List<ToolbarButton> r109 = this.f109970a;
        ToolbarButton r110 = ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE;
        if (((ArrayList) r109).contains(r110) == true) goto L46;
        ListProtector.add(this.f109970a, 0, r110);
        return;
    L46:
        return;
    L32:
        List<ToolbarButton> r111 = this.f109970a;
        ArrayList r112 = (ArrayList) r111;
        r112.remove(ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (Lists.isEmpty(this.f109970a) == true) goto L11;
        Dialog r101 = this.f109972c;
        if (r101 == null) goto L11;
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r101);
        goto L11
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L10:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    L11:
        HashMap r102 = new HashMap();
        DataCenter r103 = this.f109979j;
        int r104 = ReplayToolbarStatisticsLog.f109967a;
        if (r103 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r103).d("more_icon_click", r102, new Object[0]);
    L16:
        if (this.f109980k == false) goto L18;
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r105 = nq1.d.f520092a;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r106 = nq1.d.f520106o;
        Boolean r107 = Boolean.TRUE;
        r106.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r106, r107);
    L19:
        b();
        return;
    L18:
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r108 = nq1.d.f520092a;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r109 = nq1.d.f520107p;
        Boolean r110 = Boolean.TRUE;
        r109.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r109, r110);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Dialog r102 = this.f109972c;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        a(r102);
    L5:
        r101.removeObserver(this);
        this.f109975f.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v18, types: [yr1.r] */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void p4(View r110, final DataCenter r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        this.f109979j = r111;
        this.f109974e = r110;
        this.f109973d = r110.findViewById(R.id.view_red_dot);
        this.f109979j = r111;
        this.f109976g = (IRoom) r111.get("data_room", null);
        Iterator r112 = CollectionsKt.listOf(new String[]{"cmd_toolbar_click_filter", "cmd_dismiss_anchor_more_dialog", "cmd_show_aud_backtrack_finished_popup", "data_hide_screen", "data_has_interact_more", "data_interact_dot_show", "data_user_in_room", "data_backtrack_progress_changed", "data_backtrack_state_changed", "cmd_anchor_backtrack_tip", "DATA_AUDIENCE_COMMERCE_MORE_SHOW", "DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW"}).iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        r111.observe((String) r112.next(), this);
        goto L4
    L6:
        Iterator r113 = CollectionsKt.listOf("data_live_mini_app_commerce_status").iterator();
    L8:
        if (r113.hasNext() == false) goto L10;
        r111.observe((String) r113.next(), this, true);
        goto L8
    L10:
        List<ToolbarButton> r114 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.a(r111, this.f109978i);
        ((ArrayList) this.f109970a).clear();
        ((ArrayList) this.f109970a).addAll(r114);
        List r115 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.b(this.f109979j, this.f109978i);
        ((ArrayList) this.f109971b).clear();
        ((ArrayList) this.f109971b).addAll(r115);
        this.f109979j.observe("data_is_portrait", this);
        ?? r116 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.y();
        if ((((ArrayList) this.f109970a).size() + ((ArrayList) this.f109971b).size()) <= 0) goto L20;
        ?? r100 = new ArrayList(((ArrayList) this.f109970a).size() + ((ArrayList) this.f109971b).size());
        Iterator r101 = ((ArrayList) this.f109970a).iterator();
    L14:
        if (r101.hasNext() == false) goto L16;
        r100.add(((ToolbarButton) r101.next()).name());
        goto L14
    L16:
        Iterator r102 = ((ArrayList) this.f109971b).iterator();
    L18:
        if (r102.hasNext() == false) goto L21;
        r100.add(((ToolbarButton) r102.next()).name());
    L21:
        r116.j(r100);
        b();
        ReplayToolbarStatisticsLog.a(r111);
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r117 = ReplayDataContext.a.b(r111);
        if (r117 == null) goto L26;
        com.bytedance.live.datacontext.m<Boolean> r118 = r117.getInteractionRefreshEnd();
        if (r118 == null) goto L26;
        i80.a.a(r118, new ReplayAbsToolbarMoreBehavior$onLoad$3(this, r111));
    L26:
        this.f109977h = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e().provideVSPlayerViewControlService(r111);
        return;
    L20:
        r100 = CollectionsKt.emptyList();
        goto L21
    }

    public ReplayAbsToolbarMoreBehavior(Context r100, DataCenter r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mDataCenter");
        this.f109978i = r100;
        this.f109979j = r101;
        this.f109980k = r102;
        this.f109970a = new ArrayList();
        this.f109971b = new ArrayList();
        this.f109975f = new CompositeDisposable();
    }
}
