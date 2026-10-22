package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import am2.x;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.api.f;
import com.bytedance.android.livesdk.interactivity.api.g;
import com.bytedance.android.livesdk.interactivity.chatchannel.config.RoomChannelWidgetConfigProvider;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdk.interactivity.service.messagelist.m;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import i62.h;
import i62.i;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelWidgetV2;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/e;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelPresenter$IView;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChatChannelWidgetV2 extends RoomRecyclableWidget implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e, ChatChannelPresenter.IView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f134446v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.chatchannel.config.a f134447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f134448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f134449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f134450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f134451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f134452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f134453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NoMoreSpaceTextView f134454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f134455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f134456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f134457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiTypeAdapter f134458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f134459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f134460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ChannelTrayListViewV2 f134461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompositeDisposable f134462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CompositeDisposable f134463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f134464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ChatChannelPresenter f134465s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f134466t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f134467u;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelWidgetV2 f134468a;

        public b(ChatChannelWidgetV2 r100) {
            this.f134468a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMessageListManager.a r101 = (IMessageListManager.a) r100;
            if (r101.getType() != IMessageListManager.MessageChangeType.INSERT_BOTTOM) goto L10;
            MultiTypeAdapter r102 = this.f134468a.f134458l;
            if (r102 == null) goto L15;
            r102.notifyItemInserted(r101.f140854b);
            int r103 = r102.getItemCount();
            RecyclerView r104 = this.f134468a.f134456j;
            if (r104 == null) goto L16;
            r104.smoothScrollToPosition(r103);
            return;
        L16:
            return;
        L15:
            return;
        L10:
            if (r101.getType() != IMessageListManager.MessageChangeType.REMOVE_RANGE) goto L18;
            MultiTypeAdapter r105 = this.f134468a.f134458l;
            if (r105 == null) goto L19;
            r105.notifyItemRangeRemoved(r101.f140855c, r101.f140856d);
            return;
        L19:
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelWidgetV2 f134469a;

        public c(ChatChannelWidgetV2 r100) {
            this.f134469a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f134469a.f134450d;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            UtilityKotlinExtentionsKt.w(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.ttlive_chat_channel_widget_v2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void l2() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void z5() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        k.b("ChatChannelWidget unload");
        MainThreadPostUtils.d(this.f134466t);
        this.f134462p.dispose();
        Disposable r100 = this.f134464r;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f134463q.clear();
        ChatChannelPresenter r101 = this.f134465s;
        if (r101 == null) goto L9;
        r101.detachView();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void uS() {
        MainThreadPostUtils.d(this.f134466t);
        RecyclerView r100 = this.f134450d;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.u(r100);
    L5:
        MainThreadPostUtils.c(this.f134466t, 50);
    }

    public ChatChannelWidgetV2() {
        this.f134462p = new CompositeDisposable();
        this.f134463q = new CompositeDisposable();
        this.f134466t = new c(this);
        if (PadConfigUtils.c() == false) goto L5;
        int r100 = 0;
    L6:
        this.f134467u = r100;
        return;
    L5:
        r100 = 20;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final int supportClearScene() {
        if (isScreenPortrait() == true) goto L7;
        return 0;
    L7:
        return this.f134467u;
    }

    public final s22.e yq() {
        RoomContext r100 = getRoomContext();
        if (r100 == null) goto L9;
        f r101 = g.a(r100);
        if (r101 == null) goto L9;
        j<s22.e> r102 = r101.getChatChannelManager();
        if (r102 == null) goto L9;
        return r102.getValue();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void QU(DiffUtil.DiffResult r100) {
        Intrinsics.checkNotNullParameter(r100, "diff");
        ChannelTrayListViewV2 r101 = this.f134461o;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "res");
        r100.dispatchUpdatesTo(r101.f134413b);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void WP(int r100) {
        ChannelTrayListViewV2 r101 = this.f134461o;
        if (r101 == null) goto L6;
        r101.f134413b.notifyItemRemoved(r100);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onEnterClear(int r100) {
        if ((this.f134467u & r100) == 0) goto L8;
        k.b("onEnterClear scene=" + r100);
        UtilityKotlinExtentionsKt.t(this.contentView);
        m r101 = this.f134448b;
        if (r101 == null) goto L9;
        r101.f140904b.f140871j = false;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onExitClear(int r100) {
        if ((this.f134467u & r100) == 0) goto L8;
        k.b("onExitClear scene=" + r100);
        UtilityKotlinExtentionsKt.w(this.contentView);
        m r101 = this.f134448b;
        if (r101 == null) goto L9;
        r101.f140904b.f140871j = true;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r100) {
        k.b("ChatChannelWidget init");
        this.f134461o = (ChannelTrayListViewV2) this.contentView.findViewById(R.id.channel_avatar_view);
        this.f134449c = (RelativeLayout) this.contentView.findViewById(R.id.room_channel_valid_view);
        this.f134450d = (RecyclerView) this.contentView.findViewById(R.id.room_channel_message_view);
        this.f134451e = (ViewGroup) this.contentView.findViewById(R.id.room_channel_message_hint_layout);
        this.f134452f = (TextView) this.contentView.findViewById(R.id.room_channel_message_hint_text);
        this.f134453g = (LinearLayout) this.contentView.findViewById(R.id.room_channel_invalid_view);
        this.f134454h = (NoMoreSpaceTextView) this.contentView.findViewById(R.id.room_channel_invalid_tv);
        this.f134455i = (RelativeLayout) this.contentView.findViewById(R.id.room_channel_guide_container);
        this.f134456j = (RecyclerView) this.contentView.findViewById(R.id.encrypt_message_view);
        this.f134457k = (TextView) this.contentView.findViewById(R.id.room_channel_guide_tv);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        this.f134466t.run();
        k.b("ChatChannelWidget load");
        this.f134462p = new CompositeDisposable();
        s22.e r101 = yq();
        if (r101 == null) goto L6;
        ChatChannelPresenter r102 = new ChatChannelPresenter(r101, this.f134462p, getRoomContext(), this.dataCenter);
        this.f134465s = r102;
        r102.i0(this);
    L6:
        if (this.contentView.getVisibility() == 0) goto L8;
        UtilityKotlinExtentionsKt.w(this.contentView);
    L8:
        RoomContext r103 = getRoomContext();
        int r104 = RoomChannelWidgetConfigProvider.f134157a;
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.chatchannel.config.a r105 = new RoomChannelWidgetConfigProvider.PublicScreenSyncConfig(r103);
    L12:
        this.f134447a = r105;
        RoomContext r106 = getRoomContext();
        if (r106 == null) goto L19;
        com.bytedance.live.datacontext.m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L19;
        Room r108 = r107.getValue();
        if (r108 == null) goto L19;
        final long r109 = r108.f162599id;
    L20:
        final s22.e r110 = yq();
        if (r110 == null) goto L29;
        Function1<p62.a, Unit> r111 = new ChatChannelWidgetV2$initChannelLinkListView$trayClickCallback$1(this, r110, r109);
        ChannelTrayListViewV2 r112 = this.f134461o;
        if (r112 == null) goto L26;
        r112.setTrayClickCallback(r111);
    L26:
        ChannelTrayListViewV2 r113 = this.f134461o;
        if (r113 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r113);
    L29:
        com.bytedance.android.livesdk.interactivity.chatchannel.config.a r114 = this.f134447a;
        if (r114 == null) goto L50;
        RecyclerView r115 = this.f134450d;
        if (r115 == null) goto L50;
        ViewGroup r116 = this.f134451e;
        if (r116 == null) goto L50;
        TextView r117 = this.f134452f;
        if (r117 == null) goto L50;
        r116.setMinimumHeight(r114.b());
        r116.setBackgroundResource(r114.d());
        r117.setTextColor(r114.c());
        r117.setTextSize(0, r114.e());
        m r118 = new m(r115, r116, r117, s1.f(8.0f), com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f132996o);
        r118.b(i.class, new i.b());
        r118.b(i62.b.class, new i62.b.C6233b());
        r118.b(i62.c.class, new i62.c.b());
        r118.b(i62.d.class, new i62.d.b());
        r118.b(i62.f.class, new i62.f.b());
        r118.b(h.class, new h.b());
        r118.b(i62.e.class, new i62.e.b(r114.a()));
        r118.b(hb2.a.class, new i62.g());
        r118.f140904b.getClass();
        Unit r119 = Unit.INSTANCE;
        this.f134448b = r118;
        s22.e r120 = yq();
        if (r120 == null) goto L48;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r121 = r120.getCurrentChannel();
        if (r121 == null) goto L48;
        Disposable r122 = p.a(r121, new ChatChannelWidgetV2$initChatChannelMessageList$2(this));
        if (r122 == null) goto L48;
        RxUtilKt.c(r122, this.f134462p);
    L48:
        RxUtilKt.c(Disposables.fromAction(new com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.b(this)), this.f134462p);
    L50:
        if (ChatChannelUtils.a(getRoomContext()) == ContainerType.PublicScreen) goto L52;
    L54:
        float r123 = s1.e(8.0f);
    L55:
        int r124 = (int) r123;
        ChannelTrayListViewV2 r125 = this.f134461o;
        ViewGroup.LayoutParams r126 = null;
        if (r125 == null) goto L58;
        ViewGroup.LayoutParams r127 = r125.getLayoutParams();
    L60:
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        r126 = r127;
    L63:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r126;
        if (r128 == null) goto L68;
        r128.topMargin = r124;
        ChannelTrayListViewV2 r129 = this.f134461o;
        if (r129 == null) goto L68;
        r129.setLayoutParams(r128);
    L68:
        RxUtilKt.c(ChatChannelUtils.l(this.dataCenter, new ChatChannelWidgetV2$observeChannelPageShowStateChanged$1(this)), this.f134462p);
        return;
    L58:
        r127 = null;
        goto L60
    L52:
        if (ChatChannelUtils.j(getRoomContext()) == false) goto L54;
        r123 = s1.e(2.0f);
    L19:
        r109 = 0;
        goto L20
    L11:
        r105 = RoomChannelWidgetConfigProvider.a.f134161b;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void xi(List<p62.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ChannelTrayListViewV2 r101 = this.f134461o;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "list");
        MultiTypeAdapter r102 = r101.f134413b;
        r102.f513437a = r100;
        r102.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void ie(int r100, int r101) {
        ChannelTrayListViewV2 r102 = this.f134461o;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 != 5) goto L8;
        r102.f134413b.notifyItemChanged(r100);
        return;
    L8:
        if (r100 != 0) goto L27;
        RecyclerView.ViewHolder r103 = r102.f134412a.findViewHolderForAdapterPosition(0);
        Long r104 = null;
        if ((r103 instanceof ChannelTrayListViewBinder.ItemViewHolder) == true) goto L12;
        r103 = null;
    L12:
        ChannelTrayListViewBinder.ItemViewHolder r105 = (ChannelTrayListViewBinder.ItemViewHolder) r103;
        if (r105 != null) goto L15;
        r102.f134413b.notifyItemChanged(r100);
        return;
    L15:
        if (r101 != 2) goto L23;
        TextView r106 = r105.f134406f;
        Object r107 = ListProtector.get(r102.f134413b.f513437a, r100);
        if ((r107 instanceof p62.a) == true) goto L19;
        r107 = null;
    L19:
        p62.a r108 = (p62.a) r107;
        if (r108 == null) goto L22;
        r104 = Long.valueOf(r108.f527873h);
    L22:
        r106.setText(String.valueOf(r104));
        return;
    L23:
        if (r101 == 6) goto L36;
        r102.f134413b.notifyItemChanged(0);
        return;
    L36:
        return;
    L27:
        if (r101 == 3) goto L31;
        if (r101 == 6) goto L31;
        if (r101 == 7) goto L31;
        return;
    L31:
        r102.f134413b.notifyItemChanged(r100);
    }

    public final void xq(s22.a r100, boolean r101, IMessageListManager r102) {
        ALogger.i("ChatChannelWidgetV2", "changeEncryptMessageSubscribeStatus:" + r101);
        if (r102 == null) goto L29;
        if (r101 == true) goto L7;
        Disposable r103 = this.f134459m;
        if (r103 == null) goto L28;
        this.f134462p.remove(r103);
        return;
    L28:
        return;
    L7:
        if (r100.x() == true) goto L9;
        return;
    L9:
        int r104 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.f133002a;
        Intrinsics.checkNotNullParameter(r100, "chatChannel");
        HashMap r105 = new HashMap();
        r105.put("msg_show_type", "chat_channel_qualify_guide");
        r105.put("create_type", String.valueOf(r100.y()));
        FansChannelCreateInfo r106 = r100.C();
        if (r106 == null) goto L12;
        Long r107 = Long.valueOf(r106.getFansChannelType());
    L13:
        r105.put("sub_create_type", String.valueOf(r107));
        r105.put("channel_id", String.valueOf(r100.getChannelId()));
        r105.put("create_app_id", String.valueOf(r100.f()));
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_chat_channel_system_msg_show", r105);
        MultiTypeAdapter r108 = this.f134458l;
        if (r108 == null) goto L16;
        r108.f513437a = r102.getMessageList();
    L16:
        MultiTypeAdapter r109 = this.f134458l;
        if (r109 == null) goto L19;
        r109.notifyDataSetChanged();
    L19:
        Disposable r110 = this.f134459m;
        if (r110 == null) goto L22;
        this.f134462p.remove(r110);
    L22:
        Disposable r111 = r102.a().subscribe(new b(this));
        RxUtilKt.c(r111, this.f134462p);
        this.f134459m = r111;
        return;
    L12:
        r107 = null;
        goto L13
    }

    public void zq(Context r100, long r110, s22.a r111, s22.e r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "chatChannel");
        Intrinsics.checkNotNullParameter(r112, "chatManager");
        ChannelMemberManagerDialog r101 = new ChannelMemberManagerDialog(r100, this.dataCenter, r110, r111, r112);
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }

    public static final void wq(ChatChannelWidgetV2 r100, boolean r101, boolean r102, String r103, boolean r104, String r105, String r110, boolean r111) {
        r100.getClass();
        if (r101 == false) goto L5;
        String r106 = "manage";
    L6:
        j0 r107 = j0.l();
        Pair[] r108 = new Pair[7];
        r108[0] = TuplesKt.to("click_result", r106);
        String r109 = "1";
        if (r102 == false) goto L9;
        Object r112 = "1";
    L10:
        r108[1] = TuplesKt.to("is_red", r112);
        r108[2] = TuplesKt.to("create_type", r103);
        if (r104 == false) goto L13;
        Object r113 = "1";
    L14:
        r108[3] = TuplesKt.to("is_creator", r113);
        r108[4] = TuplesKt.to("channel_id", r105);
        r108[5] = TuplesKt.to("create_app_id", r110);
        if (r111 == true) goto L18;
        r109 = "0";
    L18:
        r108[6] = TuplesKt.to("is_valid_click", r109);
        r107.sendLog("livesdk_live_message_private_chat_tab_click", MapsKt.mapOf(r108), new Object[]{x.class, IRoom.class});
        return;
    L13:
        r113 = "0";
        goto L14
    L9:
        r112 = "0";
        goto L10
    L5:
        r106 = "switch";
        goto L6
    }
}
