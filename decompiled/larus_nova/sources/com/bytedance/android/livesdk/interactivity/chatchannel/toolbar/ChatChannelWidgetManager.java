package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.fk;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n62.h;
import n62.i;
import s22.g;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/toolbar/ChatChannelWidgetManager;", "Ls22/g;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelWidgetManager implements g, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoomContext f134377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f134378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s22.e f134379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f134380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f134381e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomContext f134382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f134383b;

        public a(RoomContext r100, DataCenter r101) {
            this.f134382a = r100;
            this.f134383b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (e5.f(((Integer) r100).intValue()) == true) goto L22;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r101 = ChatChannelUtils.g(this.f134382a);
            if (r101 == null) goto L11;
            m<com.bytedance.android.livesdk.interactivity.api.base.d> r102 = r101.getState();
            if (r102 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.api.base.d r103 = r102.getValue();
            if (r103 == null) goto L11;
            PublicScreenAreaPageType r104 = r103.f132904a;
        L13:
            if (r104 != PublicScreenAreaPageType.ChatChannel) goto L15;
            boolean r105 = true;
        L16:
            int r106 = q.f133008a;
            q.a(r105, this.f134383b, 5);
            if (r105 == false) goto L23;
            IGiftCoreService r107 = (IGiftCoreService) k.f(IGiftCoreService.class);
            if (r107 == null) goto L24;
            r107.setNeedShowGiftEffectSwitch(false);
            return;
        L24:
            return;
        L23:
            return;
        L15:
            r105 = false;
        L11:
            r104 = null;
            goto L13
        }
    }

    public ChatChannelWidgetManager() {
    }

    @Override // s22.g
    public final void a(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        DataCenter r101 = this.f134378b;
        if (r101 == null) goto L6;
        r101.put("cmd_room_channel_show_invite_dialog", new f62.b(false, null, r100));
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r110) {
        KVData r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "data");
        String r112 = r111.getKey();
        if (r112.hashCode() == (-1575056762)) goto L6;
        return;
    L6:
        if (r112.equals("cmd_p0_widget_loaded") == false) goto L70;
        Context r113 = this.f134380d;
        if (r113 == null) goto L74;
        DataCenter r100 = this.f134378b;
        if (r100 != null) goto L14;
    L24:
        DataCenter r101 = this.f134378b;
        if (r101 != null) goto L28;
    L49:
        DataCenter r102 = this.f134378b;
        if (r102 != null) goto L53;
        return;
    L53:
        if (z.m(r102, true) == false) goto L71;
        Boolean r103 = Boolean.FALSE;
        Boolean r104 = (Boolean) r102.get("data_pending_show_chat_channel_invite_panel", r103);
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L72;
        r102.put("data_pending_show_chat_channel_invite_panel", r103);
        RoomContext r106 = this.f134377a;
        if (r106 == null) goto L76;
        s22.e r107 = this.f134379c;
        if (r107 == null) goto L77;
        s22.a r108 = ChatChannelUtils.c(r106);
        if (r108 == null) goto L78;
        n62.e r114 = h.b(r113, r106, r102, r107);
        Intrinsics.checkNotNullParameter(r108, "channel");
        r114.e(r108, null);
        r102.put("match_scroll_to_chat_channel", r105);
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L72:
        return;
    L71:
        return;
    L28:
        if (z.m(r101, true) == false) goto L49;
        Boolean r109 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r101.get("data_pending_show_chat_channel_member_panel", r109), Boolean.TRUE) == false) goto L49;
        r101.put("data_pending_show_chat_channel_member_panel", r109);
        RoomContext r115 = this.f134377a;
        if (r115 == null) goto L49;
        m<Room> r116 = r115.getRoom();
        if (r116 == null) goto L49;
        Room r117 = r116.getValue();
        if (r117 == null) goto L49;
        long r118 = r117.getRoomId();
        s22.e r119 = this.f134379c;
        if (r119 == null) goto L49;
        s22.a r120 = ChatChannelUtils.c(this.f134377a);
        if (r120 == null) goto L49;
        ChannelMemberManagerDialog r121 = new ChannelMemberManagerDialog(r113, r101, r118, r120, r119);
        if (DialogLancet.shouldBlockDialogShow(r121) == false) goto L68;
        DialogLancet.handleBlockedDialogShow(r121);
    L48:
        r101.put("match_scroll_to_chat_channel", Boolean.TRUE);
        goto L49
    L68:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L67
    L47:
        DialogLancet.beforeDialogShow(r121);
        r121.show();
        DialogLancet.afterDialogShow(r121);
        goto L48
    L14:
        if (z.m(r100, true) == false) goto L24;
        Boolean r122 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r100.get("data_pending_show_create_chat_channel", r122), Boolean.TRUE) == false) goto L24;
        r100.put("data_pending_show_create_chat_channel", r122);
        RoomContext r123 = this.f134377a;
        if (r123 == null) goto L24;
        s22.e r124 = this.f134379c;
        if (r124 == null) goto L24;
        h.a(r113, r123, r100, r124, new i(true, 0, false, new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e("landscape"))).c(this.f134381e);
        goto L24
    L74:
        return;
    }

    public final void b(RoomContext r100, DataCenter r101, s22.e r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "manager");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f134377a = r100;
        this.f134378b = r101;
        this.f134379c = r102;
        this.f134380d = r103;
        this.f134381e = new CompositeDisposable();
        if (r102.getConfig().f540280a != ContainerType.MultiTab) goto L8;
        f r104 = new f(this);
        s22.e r105 = this.f134379c;
        if (r105 == null) goto L7;
        r105.addListener(r104);
    L7:
        RxUtilKt.c(Disposables.fromAction(new e(this, r104)), this.f134381e);
    L29:
        if (fk.f120210a.getValue().booleanValue() == false) goto L31;
        RxUtilKt.c(r100.getReportScreenOrientation().a().subscribe(new a(r100, r101)), this.f134381e);
    L31:
        r101.observe("cmd_p0_widget_loaded", this);
        return;
    L8:
        RoomContext r106 = this.f134377a;
        if (r106 == null) goto L29;
        final DataCenter r107 = this.f134378b;
        if (r107 == null) goto L29;
        s22.e r108 = this.f134379c;
        if (r108 == null) goto L29;
        s22.e.b r109 = r108.getConfig();
        if (r109 == null) goto L29;
        if (r109.f540284e != true) goto L29;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r110 = ChatChannelUtils.g(r106);
        if (r110 == null) goto L29;
        m<com.bytedance.android.livesdk.interactivity.api.base.d> r111 = r110.getState();
        if (r111 == null) goto L29;
        Disposable r112 = i80.a.a(r111, new ChatChannelWidgetManager$prepareForHideGiftAndEnterAnim$1(r107));
        if (r112 == null) goto L29;
        RxUtilKt.c(r112, this.f134381e);
        goto L29
    }
}
