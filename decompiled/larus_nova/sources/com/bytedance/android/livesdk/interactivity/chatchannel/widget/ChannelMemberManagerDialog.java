package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.LoadMoreLayout;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.config.xj;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.ChannelMemberManageUserDiffCallback;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListFooterViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListHeaderViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberSubTitleViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.l0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.service.ICleanScreenManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import r52.d4;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChannelMemberManagerDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelMemberManagerDialog extends CommonStandardBottomDialog {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f134497k0 = 0;
    public final int B;
    public MultiTypeAdapter C;
    public final List<Object> D;
    public boolean E;
    public List<ChannelLinkUserInfo> F;
    public List<ChannelLinkUserInfo> G;
    public List<ChannelLinkUserInfo> H;
    public final Set<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f134498J;
    public final CompositeDisposable K;
    public final CompositeDisposable L;
    public final CompositeDisposable M;
    public yo2.e N;
    public yo2.e O;
    public View P;
    public boolean Q;
    public final String R;
    public final String S;
    public final a T;
    public final e U;
    public final b V;
    public final DataCenter W;
    public final long X;
    public final s22.a Y;
    public final s22.e Z;

    public static final class a extends s22.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelMemberManagerDialog f134499a;

        @Override // s22.e.a
        public final void a(s22.a r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatChannel");
        }

        public a(ChannelMemberManagerDialog r100) {
            this.f134499a = r100;
        }

        @Override // s22.e.a
        public final void b(long r100) {
            if (this.f134499a.Y.getChannelId() != r100) goto L21;
            ChannelMemberManagerDialog r101 = this.f134499a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        }
    }

    public static final class b implements ChannelMemberListItemViewBinder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelMemberManagerDialog f134500a;

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void d(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void g() {
            User r100 = (User) this.f134500a.Y.getOwner().f64752a;
            this.f134500a.getClass();
        }

        public b(ChannelMemberManagerDialog r100) {
            this.f134500a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void a(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            if (((Boolean) this.f134500a.Y.v().f64752a).booleanValue() == false) goto L6;
            this.f134500a.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void b(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            int r101 = e62.d.f471125a;
            User r102 = r100.f134346a;
            Intrinsics.checkNotNullParameter(r102, "user");
            UserProfileEvent r103 = new UserProfileEvent(r102);
            r103.mSource = UserProfileEvent.SOURCE_ROOM_CHANNEL;
            r103.setForceSecret(!e62.d.a(r102));
            r103.fromRoomChannelType = 1;
            r103.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
            xs2.b.a().post(r103);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void c(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            ChannelMemberManagerDialog r101 = this.f134500a;
            int r102 = ChannelMemberManagerDialog.f134497k0;
            r101.getClass();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void e(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            ChannelMemberManagerDialog r101 = this.f134500a;
            int r102 = ChannelMemberManagerDialog.f134497k0;
            r101.getClass();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void f(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            if (Intrinsics.areEqual(r100.f134346a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b())) == false) goto L6;
            ChannelMemberManagerDialog r101 = this.f134500a;
            int r102 = ChannelMemberManagerDialog.f134497k0;
            r101.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void i(ChannelLinkUserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "channelLinkUser");
            if (Intrinsics.areEqual(r100.f134346a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b())) == false) goto L6;
            ChannelMemberManagerDialog r101 = this.f134500a;
            int r102 = ChannelMemberManagerDialog.f134497k0;
            r101.getClass();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void h(ChannelLinkUserInfo r100, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "targetLinkUser");
            boolean r111 = !(!r110);
            if (Intrinsics.areEqual(r100.f134346a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b())) == false) goto L21;
            RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.n<Long> r102 = r101.getCurTabId();
            if (r102 == null) goto L11;
            Long r103 = r102.getValue();
            if (r103 == null) goto L11;
            long r104 = r103.longValue();
        L12:
            int r105 = o62.a.f522167a;
            Intrinsics.checkNotNullParameter("panel", "location");
            HashMap r106 = new HashMap();
            String r107 = "0";
            if (r111 == false) goto L15;
            Object r108 = "0";
        L16:
            r106.put("previous_state", r108);
            r106.put("is_levitation_ball", "0");
            MultiTabType.Companion.getClass();
            r106.put("tab_type", MultiTabType.a.a(r104).getLogParam());
            if (r111 == true) goto L20;
            r107 = "1";
        L20:
            r106.put("micro_state", r107);
            r106.put("location", "panel");
            o62.a.a("livesdk_match_chat_voice_button_click", r106);
            goto L21
        L15:
            r108 = "1";
        L11:
            r104 = -1;
        L21:
            ChannelMemberManagerDialog r109 = this.f134500a;
            int r112 = ChannelMemberManagerDialog.f134497k0;
            r109.getClass();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListItemViewBinder.a
        public final void j(HSImageView r110, final ChannelLinkUserInfo r111) {
            Intrinsics.checkNotNullParameter(r110, "anchorView");
            Intrinsics.checkNotNullParameter(r111, "data");
            if (Intrinsics.areEqual(r111.f134346a.getCastSecUid(), com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b())) == false) goto L6;
            final ChannelMemberManagerDialog r100 = this.f134500a;
            int r101 = ChannelMemberManagerDialog.f134497k0;
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_dialog_room_channel_member_panel_manage_self, null);
            r102.findViewById(R.id.leave_link_view).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showSelfMoreDialog$1(r100)));
            yo2.e r112 = new yo2.e(r100.getContext());
            r112.f568642d = r102;
            r112.f568643e = 0;
            r112.f568648j = R.style.ttlive_chat_channel_manage_popup_view_style;
            r112.f568651m = 0;
            r112.f568650l = true;
            ChannelMemberManagerDialog.W0(r112, r110);
            r112.a();
            r100.N = r112;
            r112.i(r110, 4, 1, 0, s1.f(20.0f));
            return;
        L6:
            if (((Boolean) this.f134500a.Y.v().f64752a).booleanValue() == false) goto L13;
            final ChannelMemberManagerDialog r103 = this.f134500a;
            View r104 = LayoutInflater.from(r103.getContext()).inflate(R.layout.ttlive_dialog_room_channel_member_panel_manage_others, null);
            if (r111.f134347b.f134350a != ChannelLinkUserInfo.ChannelUserRole.Audience) goto L10;
            UtilityKotlinExtentionsKt.w(r104.findViewById(R.id.kick_out_link_view));
            UtilityKotlinExtentionsKt.w(r104.findViewById(R.id.kick_out_link_guide_line));
            r104.findViewById(R.id.kick_out_link_view).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showOthersMoreDialog$1(r103, r111)));
        L10:
            r104.findViewById(R.id.kick_out_channel_view).setOnClickListener(x0.a(new ChannelMemberManagerDialog$showOthersMoreDialog$2(r103, r111)));
            yo2.e r113 = new yo2.e(r103.getContext());
            r113.f568642d = r104;
            r113.f568643e = 0;
            r113.f568648j = R.style.ttlive_chat_channel_manage_popup_view_style;
            r113.f568651m = 0;
            r113.f568650l = true;
            ChannelMemberManagerDialog.W0(r113, r110);
            r113.a();
            r103.O = r113;
            r113.i(r110, 4, 1, 0, s1.f(20.0f));
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelMemberManagerDialog f134501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f134502b;

        public c(ChannelMemberManagerDialog r100, boolean r101) {
            this.f134501a = r100;
            this.f134502b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Response r111 = (Response) r110;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h r100 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) r111.data;
            if (r100 == null) goto L77;
            List<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a> r101 = r100.b();
            if (r101 != null) goto L7;
            return;
        L7:
            if (this.f134502b == false) goto L22;
            ChannelMemberManagerDialog r102 = this.f134501a;
            int r103 = ChannelMemberManagerDialog.f134497k0;
            r102.getClass();
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r101.iterator();
        L10:
            if (r105.hasNext() == false) goto L21;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r106 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r105.next();
            User r107 = r106.b();
            if (r107 == null) goto L10;
            Intrinsics.checkNotNullParameter(r106, "userInfo");
            if (r106.a() == false) goto L17;
            ChannelLinkUserInfo.ChannelUserRole r108 = ChannelLinkUserInfo.ChannelUserRole.GuestApplicant;
        L20:
            r104.add(new ChannelLinkUserInfo(r107, new ChannelLinkUserInfo.a(r108, r102.E)));
            String r109 = r107.getCastSecUid();
            r102.I.add(r109);
            goto L10
        L17:
            if (r106.c() == false) goto L19;
            r108 = ChannelLinkUserInfo.ChannelUserRole.Manager;
            goto L20
        L19:
            r108 = ChannelLinkUserInfo.ChannelUserRole.Guest;
            goto L20
        L21:
            r102.f134498J = r102.I.size();
            r102.c1(r102.F, r102.G, r104);
        L57:
            ChannelMemberManagerDialog r112 = this.f134501a;
            r112.Q = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) r111.data).a();
            if (((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h) r111.data).a() == true) goto L60;
            ChannelMemberManagerDialog r113 = this.f134501a;
            r113.P = r113.findViewById(R.id.no_more_tips);
            ((LoadMoreLayout) this.f134501a.findViewById(R.id.load_more_container)).setFootView(this.f134501a.findViewById(R.id.no_more_tips));
            ((LinearLayout) this.f134501a.findViewById(R.id.loading_container)).setVisibility(8);
            ((TextView) this.f134501a.findViewById(R.id.no_more_tips)).setVisibility(0);
        L60:
            ((LoadMoreLayout) this.f134501a.findViewById(R.id.load_more_container)).setEnableLoadMore(true);
            return;
        L22:
            ChannelMemberManagerDialog r114 = this.f134501a;
            int r115 = ChannelMemberManagerDialog.f134497k0;
            r114.getClass();
            ArrayList r116 = new ArrayList();
            r116.addAll(r114.H);
            ArrayList r117 = new ArrayList();
            Iterator<T> r118 = r101.iterator();
        L24:
            if (r118.hasNext() == false) goto L39;
            T r119 = r118.next();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r120 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r119;
            User r121 = r120.b();
            if (r121 != null) goto L28;
        L36:
            boolean r122 = false;
        L37:
            if (r122 == false) goto L24;
            r117.add(r119);
            goto L24
        L28:
            if (r121.getCastSecUid() == null) goto L36;
            if (r114.I.contains(r121.getCastSecUid()) == true) goto L36;
            if (((Boolean) r114.Y.v().f64752a).booleanValue() == false) goto L34;
        L35:
            r122 = true;
            goto L37
        L34:
            if (r120.a() == true) goto L36;
        L39:
            Iterator r123 = r117.iterator();
        L41:
            if (r123.hasNext() == false) goto L52;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a r124 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h.a) r123.next();
            User r125 = r124.b();
            if (r125 == null) goto L41;
            Intrinsics.checkNotNullParameter(r124, "userInfo");
            if (r124.a() == false) goto L48;
            ChannelLinkUserInfo.ChannelUserRole r126 = ChannelLinkUserInfo.ChannelUserRole.GuestApplicant;
        L51:
            r116.add(new ChannelLinkUserInfo(r125, new ChannelLinkUserInfo.a(r126, r114.E)));
            r114.I.add(r125.getCastSecUid());
            goto L41
        L48:
            if (r124.c() == false) goto L50;
            r126 = ChannelLinkUserInfo.ChannelUserRole.Manager;
            goto L51
        L50:
            r126 = ChannelLinkUserInfo.ChannelUserRole.Guest;
            goto L51
        L52:
            r114.f134498J = r114.I.size();
            r114.c1(r114.F, r114.G, r116);
            LoadMoreLayout r127 = (LoadMoreLayout) this.f134501a.findViewById(R.id.load_more_container);
            r127.f112407h = false;
            View r128 = r127.f112402c;
            if (r128 == null) goto L57;
            if (r127.f112404e == false) goto L57;
            r127.a(0, -r128.getMeasuredHeight());
            goto L57
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelMemberManagerDialog f134503a;

        public d(ChannelMemberManagerDialog r100) {
            this.f134503a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ((LoadMoreLayout) this.f134503a.findViewById(R.id.load_more_container)).setEnableLoadMore(true);
        }
    }

    public static final class e implements ChannelMemberTitleViewBinder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelMemberManagerDialog f134504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f134505b;

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void a() {
            if (this.f134504a.Y.k() == false) goto L29;
            ChannelMemberManagerDialog r100 = this.f134504a;
            String r101 = r100.S;
            if (r101 == null) goto L42;
            int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.f133000a;
            long r103 = r100.Y.getChannelId();
            Intrinsics.checkNotNullParameter(r101, "schema");
            Uri r104 = UriProtector.parse(r101);
            Uri.Builder r105 = r104.buildUpon();
            Set<String> r106 = r104.getQueryParameterNames();     // Catch: Exception -> L21 Throwable -> L31
            Uri.Builder r107 = r104.buildUpon().clearQuery();     // Catch: Exception -> L21 Throwable -> L31
            Iterator<String> r108 = r106.iterator();     // Catch: Exception -> L21 Throwable -> L31
        L9:
            if (r108.hasNext() == false) goto L20;
            String r109 = r108.next();     // Catch: Exception -> L21 Throwable -> L31
            if (Intrinsics.areEqual(r109, "url") == false) goto L17;
            String r110 = r104.getQueryParameter(r109);     // Catch: Exception -> L21 Throwable -> L31
            if (r110 == null) goto L16;
            int r111 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.f133000a;     // Catch: Exception -> L21 Throwable -> L31
            String r112 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.b(r110, "channel_id", String.valueOf(r103));     // Catch: Exception -> L21 Throwable -> L31
        L18:
            r107.appendQueryParameter(r109, r112);     // Catch: Exception -> L21 Throwable -> L31
            goto L9
        L16:
            r112 = null;
            goto L18
        L17:
            r112 = r104.getQueryParameter(r109);     // Catch: Exception -> L21 Throwable -> L31
            goto L18
        L20:
            Uri r113 = r107.build();
        L24:
            String r114 = r113.toString();
            if (r114 == null) goto L39;
            IBaseLiveActionHandler r115 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
            if (r115 == null) goto L40;
            r115.handle(r100.getContext(), r114);
            return;
        L40:
            return;
        L39:
            return;
        L21:
            e = move-exception;
            SafetyGuard.a(null, e, "origin schema is " + r101);     // Catch: Throwable -> L31
        L23:
            r113 = r105.build();
            goto L24
        L42:
            return;
        L29:
            f2.b(R.string.ttlive_chat_channel_member_notice_disable, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void b() {
            if (((Boolean) this.f134504a.Y.v().f64752a).booleanValue() == false) goto L10;
            Context r100 = this.f134505b;
            ChannelMemberManagerDialog r101 = this.f134504a;
            ChatChannelOwnerSettingDialog r102 = new ChatChannelOwnerSettingDialog(r100, r101.X, r101.Y);
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r102);
        L9:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_channel_set_icon_click", null);
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
        L8:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            goto L9
        L10:
            Context r103 = this.f134505b;
            ChannelMemberManagerDialog r104 = this.f134504a;
            ChatChannelMemberSettingDialog r105 = new ChatChannelMemberSettingDialog(r103, r104.X, r104.Y);
            if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r105);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L14:
            DialogLancet.beforeDialogShow(r105);
            r105.show();
            DialogLancet.afterDialogShow(r105);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder.a
        public final void c() {
            if (this.f134504a.Y.w() == false) goto L5;
            this.f134504a.Z.getWidgetManager().a(this.f134504a.Y);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.g("member_panel");
            return;
        L5:
            f2.b(R.string.ttlive_chat_channel_member_invite_disable, 0);
        }

        public e(ChannelMemberManagerDialog r100, Context r101) {
            this.f134504a = r100;
            this.f134505b = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final boolean V0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_room_channel_member_manage_dialog;
    }

    public final void X0() {
        yo2.e r100 = this.O;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.h() != true) goto L11;
        yo2.e r101 = this.O;
        if (r101 == null) goto L12;
        r101.d();
        return;
    L12:
        return;
    }

    public final void Y0() {
        yo2.e r100 = this.N;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.h() != true) goto L11;
        yo2.e r101 = this.N;
        if (r101 == null) goto L12;
        r101.d();
        return;
    L12:
        return;
    }

    public final void a1() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.W, 0, 2);
        if (r100 != null) goto L6;
        return;
    L6:
        if (ChatChannelUtils.a(r100) == ContainerType.PublicScreen) goto L8;
        return;
    L8:
        if (ChatChannelUtils.j(r100) == false) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r101 = ChatChannelUtils.g(r100);
        if (r101 == null) goto L15;
        r101.tryChangePage(PublicScreenAreaPageType.ChatChannel, this.Y.getChannelId(), PublicScreenAreaPageChangeSource.ManageDialog);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, android.app.Dialog
    public final void show() {
        if (this.Y.s() == true) goto L7;
        f2.c(this.Y.r().f64752a, 0);
        a1();
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(this);
    L11:
        s22.e r100 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.X, 1));
        if (r100 == null) goto L14;
        r100.addListener(this.T);
    L14:
        int r101 = l0.f159046a;
        ICleanScreenManager r102 = (ICleanScreenManager) jc1.k.f(ICleanScreenManager.class);
        if (r102 == null) goto L21;
        r102.enterCleanScreen(3);
        return;
    L21:
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L10:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.W.put("data_chat_channel_member_panel_close_event", Boolean.TRUE);
        s22.e r101 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.X, 1));
        if (r101 == null) goto L20;
        r101.removeListener(this.T);
    L20:
        this.M.clear();
        this.K.clear();
        this.L.clear();
        this.Z.recordChatChannelDialog(this.R, null);
        Y0();
        X0();
        int r102 = l0.f159046a;
        ICleanScreenManager r103 = (ICleanScreenManager) jc1.k.f(ICleanScreenManager.class);
        if (r103 == null) goto L29;
        r103.exitCleanScreen(3);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void Z0(boolean r100) {
        if (this.Q == true) goto L10;
        LoadMoreLayout r101 = (LoadMoreLayout) findViewById(R.id.load_more_container);
        r101.f112407h = false;
        View r102 = r101.f112402c;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r101.f112404e == false) goto L13;
        r101.a(0, -r102.getMeasuredHeight());
        return;
    L13:
        return;
    L10:
        ((LoadMoreLayout) findViewById(R.id.load_more_container)).setEnableLoadMore(false);
        Disposable r103 = this.Z.getChannelUserList(this.Y.getChannelId(), this.f134498J, this.B).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r100), new d(this));
        this.K.add(r103);
    }

    public final void b1(boolean r100) {
        xj r101 = xj.f121609a;
        Integer r102 = r101.getValue();
        boolean r103 = false;
        if (r102 != null) goto L6;
    L7:
        Integer r104 = r101.getValue();
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L18;
        if (r100 == false) goto L18;
        r103 = true;
    L18:
        this.E = r103;
        return;
    L11:
        if (r104.intValue() != 1) goto L13;
    L14:
        r105 = true;
        goto L15
    L6:
        if (r102.intValue() == 0) goto L14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        int r111 = e62.a.f471117a;
        Window r112 = getWindow();
        View r100 = findViewById(R.id.container);
        RoomContext.a r101 = RoomContext.Companion;
        e62.a.a(r112, r100, RoomContext.a.c(r101, null, 0, 3));
        MultiTypeAdapter r113 = new MultiTypeAdapter(this.D);
        this.C = r113;
        r113.z2(ChannelMemberTitleViewBinder.b.class, new ChannelMemberTitleViewBinder(this.U));
        MultiTypeAdapter r114 = this.C;
        if (r114 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r114.z2(ChannelMemberListHeaderViewBinder.a.class, new ChannelMemberListHeaderViewBinder());
        MultiTypeAdapter r115 = this.C;
        if (r115 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        r115.z2(ChannelMemberSubTitleViewBinder.a.class, new ChannelMemberSubTitleViewBinder());
        MultiTypeAdapter r116 = this.C;
        if (r116 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        r116.z2(ChannelLinkUserInfo.class, new ChannelMemberListItemViewBinder(this.Y, this.V));
        MultiTypeAdapter r117 = this.C;
        if (r117 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L14:
        r117.z2(ChannelMemberListFooterViewBinder.a.class, new ChannelMemberListFooterViewBinder());
        RecyclerView r102 = (RecyclerView) findViewById(R.id.member_panel_rv);
        MultiTypeAdapter r103 = this.C;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r102.setAdapter(r103);
        SSLinearLayoutManager r104 = new SSLinearLayoutManager(getContext());
        r104.setOrientation(1);
        ((RecyclerView) findViewById(R.id.member_panel_rv)).setLayoutManager(r104);
        ((RecyclerView) findViewById(R.id.member_panel_rv)).setItemAnimator(null);
        ((LoadMoreLayout) findViewById(R.id.load_more_container)).setLoadMoreCallback(new f(this));
        this.P = findViewById(R.id.loading_container);
        ((LoadMoreLayout) findViewById(R.id.load_more_container)).setFootView(findViewById(R.id.loading_container));
        b1(((Boolean) this.Y.d().f64752a).booleanValue());
        Disposable r118 = RxUtilKt.h(this.Y.d()).subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.e(this));
        this.M.add(r118);
        ArrayList r119 = new ArrayList();
        c1(this.F, this.G, r119);
        Z0(true);
        RxUtilKt.c(RxUtilKt.h(xs2.b.a().b(u22.m.class)).subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.c(this)), this.M);
        RxUtilKt.c(this.Y.z().subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.widget.d(this)), this.M);
        if (PadConfigUtils.c() == false) goto L23;
        RoomContext r120 = RoomContext.a.c(r101, null, 0, 3);
        if (r120 == null) goto L23;
        RxUtilKt.c(r120.getPadOrientation().a().subscribe(new g(this)), this.M);
    L23:
        a1();
        int r121 = o62.a.f522167a;
        long r105 = ((Number) this.Y.d0().f64752a).longValue();
        Intrinsics.checkNotNullParameter("[]", "voiceFriendList");
        HashMap r122 = new HashMap();
        r122.put("member_number", String.valueOf(r105));
        r122.put("voice_number", String.valueOf(0));
        r122.put("friend_list", "[]");
        o62.a.a("livesdk_match_chat_member_panel_show", r122);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.h("member_panel");
        this.Z.recordChatChannelDialog(this.R, this);
    }

    public static void W0(yo2.e r100, HSImageView r101) {
        View r102 = new View(r101.getContext());
        r102.setFocusable(true);
        r102.setClickable(true);
        r3.c(r102, "关闭", true);
        HashMap r103 = new HashMap();
        r100.f568662x = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.a(r101, r103, r102);
        r100.f568649k = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.b(r101, r102, r103);
        r100.f568644f = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c1(List<ChannelLinkUserInfo> r110, List<ChannelLinkUserInfo> r111, List<ChannelLinkUserInfo> r112) {
        this.F = r110;
        this.G = r111;
        this.H = r112;
        ArrayList r113 = new ArrayList();
        r113.add(new ChannelMemberTitleViewBinder.b((String) this.Y.getChannelName().f64752a, ((Number) this.Y.d0().f64752a).longValue(), this.Y.getMaxMemberCount(), this.Y.w(), this.Y.k(), ((Boolean) this.Y.v().f64752a).booleanValue()));
        r113.add(new ChannelMemberListHeaderViewBinder.a());
        if ((!this.F.isEmpty()) == true) goto L7;
        if ((!this.G.isEmpty()) == true) goto L7;
    L9:
        int r114 = -1;
    L11:
        if ((!this.F.isEmpty()) == false) goto L16;
        if (this.E == false) goto L16;
        r113.addAll(this.F);
    L16:
        if ((!this.G.isEmpty()) == false) goto L56;
        if (this.E == false) goto L56;
        List<ChannelLinkUserInfo> r100 = this.G;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L21:
        if (r102.hasNext() == false) goto L45;
        Object r103 = r102.next();
        ChannelLinkUserInfo r104 = (ChannelLinkUserInfo) r103;
        Iterator r105 = r113.iterator();
    L24:
        if (r105.hasNext() == false) goto L38;
        Object r106 = r105.next();
        if ((r106 instanceof ChannelLinkUserInfo) == true) goto L28;
        Object r107 = null;
    L29:
        ChannelLinkUserInfo r108 = (ChannelLinkUserInfo) r107;
        if (r108 == null) goto L34;
        User r109 = r108.f134346a;
        if (r109 == null) goto L34;
        String r115 = r109.getCastSecUid();
    L36:
        if (Intrinsics.areEqual(r115, r104.f134346a.getCastSecUid()) == false) goto L24;
    L39:
        if (r106 != null) goto L41;
        boolean r116 = true;
    L42:
        if (r116 == false) goto L21;
        r101.add(r103);
        goto L21
    L41:
        r116 = false;
    L34:
        r115 = null;
        goto L36
    L28:
        r107 = r106;
        goto L29
    L38:
        r106 = null;
        goto L39
    L45:
        if ((!r101.isEmpty()) == false) goto L56;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r118 = r101.iterator();
    L48:
        if (r118.hasNext() == false) goto L56;
        ChannelLinkUserInfo r119 = (ChannelLinkUserInfo) r118.next();
        if (r119.f134347b.f134350a != ChannelLinkUserInfo.ChannelUserRole.Manager) goto L53;
        if (r114 < 0) goto L53;
        ListProtector.add(r113, r114, r119);
        Object r120 = Unit.INSTANCE;
    L54:
        r117.add(r120);
    L53:
        r120 = Boolean.valueOf(r113.add(r119));
    L56:
        if ((!this.H.isEmpty()) == false) goto L85;
        List<ChannelLinkUserInfo> r121 = this.H;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L59:
        if (r123.hasNext() == false) goto L83;
        Object r124 = r123.next();
        ChannelLinkUserInfo r125 = (ChannelLinkUserInfo) r124;
        Iterator r126 = r113.iterator();
    L62:
        if (r126.hasNext() == false) goto L76;
        Object r127 = r126.next();
        if ((r127 instanceof ChannelLinkUserInfo) == true) goto L66;
        Object r128 = null;
    L67:
        ChannelLinkUserInfo r129 = (ChannelLinkUserInfo) r128;
        if (r129 == null) goto L72;
        User r130 = r129.f134346a;
        if (r130 == null) goto L72;
        String r131 = r130.getCastSecUid();
    L74:
        if (Intrinsics.areEqual(r131, r125.f134346a.getCastSecUid()) == false) goto L62;
    L77:
        if (r127 != null) goto L79;
        boolean r132 = true;
    L80:
        if (r132 == false) goto L59;
        r122.add(r124);
        goto L59
    L79:
        r132 = false;
    L72:
        r131 = null;
        goto L74
    L66:
        r128 = r127;
        goto L67
    L76:
        r127 = null;
        goto L77
    L83:
        if ((!r122.isEmpty()) == false) goto L85;
        r113.add(new ChannelMemberSubTitleViewBinder.a(s1.B(R.string.ttlive_room_channel_member_manage_tab_channel)));
        r113.addAll(r122);
    L85:
        r113.add(new ChannelMemberListFooterViewBinder.a());
        DiffUtil.DiffResult r133 = DiffUtil.calculateDiff(new ChannelMemberManageUserDiffCallback(CollectionsKt.toList(this.D), r113));
        ((ArrayList) this.D).clear();
        ((ArrayList) this.D).addAll(r113);
        MultiTypeAdapter r134 = this.C;
        if (r134 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L88:
        r133.dispatchUpdatesTo(r134);
        return;
    L7:
        if (this.E == false) goto L9;
        r113.add(new ChannelMemberSubTitleViewBinder.a(s1.B(R.string.ttlive_room_channel_member_manage_tab_link)));
        r114 = r113.size();
        goto L11
    }

    public ChannelMemberManagerDialog(Context r100, DataCenter r101, long r102, s22.a r103, s22.e r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "chatChannel");
        Intrinsics.checkNotNullParameter(r104, "chatChannelManager");
        super(r100, false);
        this.W = r101;
        this.X = r102;
        this.Y = r103;
        this.Z = r104;
        this.B = 10;
        this.D = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new LinkedHashSet();
        this.K = new CompositeDisposable();
        this.L = new CompositeDisposable();
        this.M = new CompositeDisposable();
        this.Q = true;
        this.R = "ChannelMemberManagerDialog";
        this.S = d4.f536168a.getValue().d();
        this.T = new a(this);
        this.U = new e(this, r100);
        this.V = new b(this);
    }
}
