package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.base.model.message.guestlink.LinkmicGuestLinkUserRole;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.liveinteract.revenue.guestlink.ui.GiftMarqueeContainer;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/BaseGuestLinkMainPageDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseGuestLinkMainPageDialog extends LiveDialogFragment {
    public vi0.a A;
    public final Map<String, Boolean> B;
    public com.bytedance.android.live.base.model.message.guestlink.a C;
    public lb6.g D;
    public final CompositeDisposable E;
    public com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c F;
    public final ui0.b G;
    public final com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.c H;
    public final j1 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final DataCenter f78419J;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f78420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f78421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f78422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f78423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f78424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f78425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f78426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSImageView f78427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f78428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f78429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f78430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f78431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f78432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Button f78433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f78434r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f78435s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f78436t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f78437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f78438v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HSImageView f78439w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HSImageView f78440x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j22.c f78441y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public j22.c f78442z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGuestLinkMainPageDialog f78443a;

        public b(BaseGuestLinkMainPageDialog r100) {
            this.f78443a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.d("BaseGuestLinkMainPageDialog", "renderChannelInfo");
            BaseGuestLinkMainPageDialog r101 = this.f78443a;
            r101.Z90((com.bytedance.android.live.base.model.message.guestlink.a) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f78444a = null;

        static {
            f78444a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("BaseGuestLinkMainPageDialog", "renderChannelInfo", (Throwable) r100);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGuestLinkMainPageDialog f78445a;

        public d(BaseGuestLinkMainPageDialog r100) {
            this.f78445a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick ll_audience_container");
            com.bytedance.android.live.base.model.message.guestlink.a r101 = this.f78445a.T90();
            if (r101 == null) goto L13;
            ALogger.i("BaseGuestLinkMainPageDialog", "openByStanderListPanel, channelId: " + r101.getChannelId());
            int r102 = tb6.a.f545265a;
            tb6.a.e(this.f78445a instanceof GuestLinkMainPageDialogForLinker, r101, "watchingpage", null);
            int r103 = com.bytedance.android.live.liveinteract.revenue.guestlink.a.f78416a;
            Context r104 = this.f78445a.requireContext();
            HashMap r105 = new HashMap();
            r105.put("channel_id", String.valueOf(r101.getChannelId()));
            Unit r106 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r107 = vm2.i.e().getBystanderListSchema();
            String r108 = "";
            if (r107 != null) goto L7;
            r107 = "";
        L7:
            String r109 = vm2.i.e().getBystanderListUrl();
            if (r109 == null) goto L11;
            r108 = r109;
        L11:
            com.bytedance.android.live.liveinteract.revenue.guestlink.a.a(r104, r107, r108, r105);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGuestLinkMainPageDialog f78446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f78447b;

        public e(BaseGuestLinkMainPageDialog r100, IBaseUser r101) {
            this.f78446a = r100;
            this.f78447b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick Avatar");
            BaseGuestLinkMainPageDialog.S90(this.f78446a, this.f78447b);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGuestLinkMainPageDialog f78448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f78449b;

        public f(BaseGuestLinkMainPageDialog r100, IBaseUser r101) {
            this.f78448a = r100;
            this.f78449b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick Avatar");
            BaseGuestLinkMainPageDialog.S90(this.f78448a, this.f78449b);
        }
    }

    static {
    }

    public void X90(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    public void Y90(String[] r100, boolean[] r101, int[] r102) {
    }

    public final com.bytedance.android.live.base.model.message.guestlink.a T90() {
        lb6.g r100 = this.D;
        if (r100 == null) goto L11;
        sb6.a r101 = r100.getLinkState();
        if (r101 == null) goto L12;
        com.bytedance.android.live.base.model.message.guestlink.a r102 = r101.f541257f;
        if ((r102 instanceof pb6.a) == false) goto L10;
        return null;
    L10:
        return r102;
    L12:
        return null;
    L11:
        return null;
    }

    public void ca0() {
        View r100 = this.f78423g;
        if (r100 == null) goto L6;
        r100.setVisibility(4);
        return;
    }

    public void initView() {
        View r100 = this.f78420d;
        HSImageView r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.findViewById(R.id.ll_user_info_container);
    L6:
        this.f78421e = r102;
        View r103 = this.f78420d;
        if (r103 == null) goto L9;
        View r104 = r103.findViewById(R.id.player_container);
    L10:
        this.f78422f = r104;
        View r105 = this.f78420d;
        if (r105 == null) goto L13;
        View r106 = r105.findViewById(R.id.user_info_container_line);
    L14:
        this.f78423g = r106;
        View r107 = this.f78420d;
        if (r107 == null) goto L17;
        TextView r108 = (TextView) r107.findViewById(R.id.tv_timer);
    L18:
        this.f78424h = r108;
        View r109 = this.f78420d;
        if (r109 == null) goto L21;
        HSImageView r110 = (HSImageView) r109.findViewById(R.id.iv_audience_1);
    L22:
        this.f78425i = r110;
        View r111 = this.f78420d;
        if (r111 == null) goto L25;
        HSImageView r112 = (HSImageView) r111.findViewById(R.id.iv_audience_2);
    L26:
        this.f78426j = r112;
        View r113 = this.f78420d;
        if (r113 == null) goto L29;
        HSImageView r114 = (HSImageView) r113.findViewById(R.id.iv_audience_3);
    L30:
        this.f78427k = r114;
        View r115 = this.f78420d;
        if (r115 == null) goto L33;
        View r116 = r115.findViewById(R.id.iv_back_press_arrow);
    L34:
        this.f78435s = r116;
        View r117 = this.f78420d;
        if (r117 == null) goto L37;
        View r118 = r117.findViewById(R.id.button_finish_channel);
    L38:
        this.f78428l = r118;
        View r119 = this.f78420d;
        if (r119 == null) goto L41;
        TextView r120 = (TextView) r119.findViewById(R.id.tv_title);
    L42:
        this.f78436t = r120;
        View r121 = this.f78420d;
        if (r121 == null) goto L45;
        TextView r122 = (TextView) r121.findViewById(R.id.button_report);
    L46:
        this.f78429m = r122;
        View r123 = this.f78420d;
        if (r123 == null) goto L49;
        TextView r124 = (TextView) r123.findViewById(R.id.button_suspend);
    L50:
        this.f78430n = r124;
        View r125 = this.f78420d;
        if (r125 == null) goto L53;
        View r126 = r125.findViewById(R.id.button_divider);
    L54:
        this.f78431o = r126;
        View r127 = this.f78420d;
        if (r127 == null) goto L57;
        HSImageView r128 = (HSImageView) r127.findViewById(R.id.button_help);
    L58:
        this.f78432p = r128;
        View r129 = this.f78420d;
        if (r129 == null) goto L61;
        Button r130 = (Button) r129.findViewById(R.id.button_1);
    L62:
        this.f78433q = r130;
        View r131 = this.f78420d;
        if (r131 == null) goto L65;
        Button r132 = (Button) r131.findViewById(R.id.button_2);
    L66:
        this.f78434r = r132;
        View r133 = this.f78420d;
        if (r133 == null) goto L71;
        View r134 = r133.findViewById(R.id.container_user_1_audio);
        if (r134 == null) goto L71;
        HSImageView r135 = (HSImageView) r134.findViewById(R.id.ttlive_volume_Anim);
    L72:
        this.f78439w = r135;
        View r136 = this.f78420d;
        if (r136 == null) goto L77;
        View r137 = r136.findViewById(R.id.container_user_2_audio);
        if (r137 == null) goto L77;
        r101 = (HSImageView) r137.findViewById(R.id.ttlive_volume_Anim);
    L77:
        this.f78440x = r101;
        this.f78441y = new j22.c(this.f78439w);
        this.f78442z = new j22.c(this.f78440x);
        return;
    L71:
        r135 = null;
        goto L72
    L65:
        r132 = null;
        goto L66
    L61:
        r130 = null;
        goto L62
    L57:
        r128 = null;
        goto L58
    L53:
        r126 = null;
        goto L54
    L49:
        r124 = null;
        goto L50
    L45:
        r122 = null;
        goto L46
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ui0.b r100 = this.G;
        r100.getClass();
        ALogger.i("LiveRoomAudioManger", LiveCommonConstants.REASON_ON_DEDTROY);
        if (je0.d.r() == false) goto L8;
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: anchor");
        rj0.k.f537953m2.getClass();
        rj0.k r101 = rj0.k.a.a();
        if (r101 == null) goto L12;
        r101.lm(false);
    L12:
        if (r100.f550123a == false) goto L14;
        r100.a(false, "LiveRoomAudioManger#onDestroy");
    L14:
        vi0.b.b();
        ui0.a r102 = r100.f550124b;
        if (r102 == null) goto L24;
        r102.f550118a = false;
        ALogger.i("LivePlayerMediaManager", LiveCommonConstants.REASON_ON_DEDTROY);
        ILivePlayerClient r103 = r102.f550119b;
        if (r103 == null) goto L23;
        IRoomEventHub r104 = r103.getEventHub();
        if (r104 == null) goto L23;
        MutableLiveData<Boolean> r105 = r104.getPlayerMute();
        if (r105 == null) goto L23;
        ALogger.i("LivePlayerMediaManager", "remove playerMuteObserver");
        r105.removeObserver(r102.f550120c);
    L23:
        r102.f550119b = null;
    L24:
        r100.f550124b = null;
        ALogger.i("BaseGuestLinkMainPageDialog", "sendHidePageEventToLynx");
        ih0.b r106 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.f78419J);
        if (r106 == null) goto L28;
        JsonObject r107 = new JsonObject();
        r107.addProperty("type", "guest_link_call_page_hide");
        Unit r108 = Unit.INSTANCE;
        r106.Dk(UserProfileEvent.POSITION_GUEST_LINK, "guest_link_event", r107, false);
        return;
    L28:
        return;
    L8:
        if (hd0.c.f().h() == true) goto L10;
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: audience");
        goto L12
    L10:
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: guest");
        goto L12
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.E.clear();
        lb6.g r100 = this.D;
        if (r100 == null) goto L5;
        r100.b(this.H);
    L5:
        com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c r101 = this.F;
        if (r101 == null) goto L8;
        r101.c();
    L8:
        this.F = null;
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k U90(com.bytedance.android.live.base.model.message.guestlink.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channelInfo");
        List<com.bytedance.android.live.base.model.message.guestlink.k> r101 = r100.getLinkedUsers();
        Object r102 = null;
        if (r101 == null) goto L23;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        com.bytedance.android.live.base.model.message.guestlink.k r105 = (com.bytedance.android.live.base.model.message.guestlink.k) r104;
        if (r105.getUserRole() != LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_Inviter.getValue()) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L6;
        r102 = r104;
        goto L17
    L10:
        if (r105.getUserRole() == LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_MatchMaking.getValue()) goto L13;
        r106 = false;
    L17:
        return (com.bytedance.android.live.base.model.message.guestlink.k) r102;
    L23:
        return null;
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k V90(com.bytedance.android.live.base.model.message.guestlink.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channelInfo");
        List<com.bytedance.android.live.base.model.message.guestlink.k> r101 = r100.getLinkedUsers();
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L7:
        if (r102 >= 2) goto L9;
        return null;
    L9:
        List<com.bytedance.android.live.base.model.message.guestlink.k> r103 = r100.getLinkedUsers();
        if (r103 != null) goto L12;
        return null;
    L12:
        return (com.bytedance.android.live.base.model.message.guestlink.k) ListProtector.get(r103, 1);
    L5:
        r102 = 0;
        goto L7
    }

    public static boolean W90(com.bytedance.android.live.base.model.message.guestlink.k r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getLinkType() != 1) goto L8;
        if (r100.isBackground() == 1) goto L8;
        return true;
    }

    public void Z90(com.bytedance.android.live.base.model.message.guestlink.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channelInfo");
        com.bytedance.android.live.base.model.message.guestlink.a r101 = T90();
        if (r101 == null) goto L7;
        List<com.bytedance.android.live.base.model.message.guestlink.k> r102 = r101.getLinkedUsers();
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L8:
        List<com.bytedance.android.live.base.model.message.guestlink.k> r104 = r100.getLinkedUsers();
        if (r104 == null) goto L11;
        int r105 = r104.size();
    L12:
        if (r105 >= r103) goto L15;
        return;
    L15:
        if ((r100 instanceof pb6.a) == false) goto L17;
        return;
    L17:
        da0(r100.getChannelBackground());
        ALogger.d("BaseGuestLinkMainPageDialog", "renderChannelInfo: channelInfo: " + r100);
        View r106 = null;
        if (W90(U90(r100)) == false) goto L29;
        View r107 = this.f78420d;
        if (r107 == null) goto L22;
        View r108 = r107.findViewById(R.id.container_user_1_video);
    L23:
        this.f78437u = r108;
        View r109 = this.f78420d;
        if (r109 == null) goto L28;
        View r110 = r109.findViewById(R.id.container_user_1_audio);
        if (r110 == null) goto L28;
        r110.setVisibility(8);
    L28:
        ca0();
    L39:
        if (W90(V90(r100)) == false) goto L49;
        View r111 = this.f78420d;
        if (r111 == null) goto L43;
        r106 = r111.findViewById(R.id.container_user_2_video);
    L43:
        this.f78438v = r106;
        View r112 = this.f78420d;
        if (r112 == null) goto L48;
        View r113 = r112.findViewById(R.id.container_user_2_audio);
        if (r113 == null) goto L48;
        r113.setVisibility(8);
    L48:
        ca0();
    L57:
        View r114 = this.f78437u;
        if (r114 == null) goto L60;
        r114.setVisibility(0);
    L60:
        View r115 = this.f78438v;
        if (r115 == null) goto L63;
        r115.setVisibility(0);
    L63:
        View r116 = this.f78420d;
        if (r116 == null) goto L68;
        TextView r117 = (TextView) r116.findViewById(R.id.tv_audience_info);
        if (r117 == null) goto L68;
        r117.setText(s1.C(R.string.ttlive_guest_link_channel_info, new Object[]{Long.valueOf(r100.getChannelUserCount())}));
    L68:
        List<IBaseUser> r118 = r100.getChannelUsers();
        View r119 = this.f78420d;
        if (r119 == null) goto L73;
        View r120 = r119.findViewById(R.id.ll_audience_container);
        if (r120 == null) goto L73;
        r120.setVisibility(0);
    L73:
        HSImageView r121 = this.f78425i;
        if (r121 == null) goto L76;
        r121.setVisibility(8);
    L76:
        HSImageView r122 = this.f78426j;
        if (r122 == null) goto L79;
        r122.setVisibility(8);
    L79:
        HSImageView r123 = this.f78427k;
        if (r123 == null) goto L82;
        r123.setVisibility(8);
    L82:
        if (r118 == null) goto L92;
        IBaseUser r124 = (IBaseUser) CollectionsKt.getOrNull(r118, 0);
        if (r124 == null) goto L92;
        HSImageView r125 = this.f78425i;
        if (r125 == null) goto L88;
        r125.setVisibility(0);
    L88:
        HSImageView r126 = this.f78425i;
        py.k r127 = r124.getAvatarMedium();
        Intrinsics.checkNotNull(r127);
        r124.getIdString();
        if (r126 == null) goto L92;
        ImageUtil.loadRoundImage(r126, r127);
    L92:
        if (r118 == null) goto L102;
        IBaseUser r128 = (IBaseUser) CollectionsKt.getOrNull(r118, 1);
        if (r128 == null) goto L102;
        HSImageView r129 = this.f78426j;
        if (r129 == null) goto L98;
        r129.setVisibility(0);
    L98:
        HSImageView r130 = this.f78426j;
        py.k r131 = r128.getAvatarMedium();
        Intrinsics.checkNotNull(r131);
        r128.getIdString();
        if (r130 == null) goto L102;
        ImageUtil.loadRoundImage(r130, r131);
    L102:
        if (r118 == null) goto L112;
        IBaseUser r132 = (IBaseUser) CollectionsKt.getOrNull(r118, 2);
        if (r132 == null) goto L112;
        HSImageView r133 = this.f78427k;
        if (r133 == null) goto L108;
        r133.setVisibility(0);
    L108:
        HSImageView r134 = this.f78427k;
        py.k r135 = r132.getAvatarMedium();
        Intrinsics.checkNotNull(r135);
        r132.getIdString();
        if (r134 == null) goto L112;
        ImageUtil.loadRoundImage(r134, r135);
    L112:
        com.bytedance.android.live.base.model.message.guestlink.k r136 = U90(r100);
        View r137 = this.f78437u;
        if (r137 == null) goto L121;
        ba0(r136, (ViewGroup) r137, R.drawable.ttlive_bg_guest_link_main_page_user_info_1, W90(r136));
        com.bytedance.android.live.base.model.message.guestlink.k r138 = V90(r100);
        View r139 = this.f78438v;
        if (r139 == null) goto L119;
        ba0(r138, (ViewGroup) r139, R.drawable.ttlive_bg_guest_link_main_page_user_info_2, W90(r138));
        return;
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L121:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L49:
        View r140 = this.f78420d;
        if (r140 == null) goto L52;
        r106 = r140.findViewById(R.id.container_user_2_audio);
    L52:
        this.f78438v = r106;
        View r141 = this.f78420d;
        if (r141 == null) goto L57;
        View r142 = r141.findViewById(R.id.container_user_2_video);
        if (r142 == null) goto L57;
        r142.setVisibility(8);
        goto L57
    L22:
        r108 = null;
        goto L23
    L29:
        View r143 = this.f78420d;
        if (r143 == null) goto L32;
        View r144 = r143.findViewById(R.id.container_user_1_audio);
    L33:
        this.f78437u = r144;
        View r145 = this.f78420d;
        if (r145 == null) goto L39;
        View r146 = r145.findViewById(R.id.container_user_1_video);
        if (r146 == null) goto L39;
        r146.setVisibility(8);
        goto L39
    L32:
        r144 = null;
        goto L33
    L11:
        r105 = 0;
    L7:
        r103 = 0;
        goto L8
    }

    public final void aa0(long r110) {
        if (r110 >= 0) goto L14;
        TextView r111 = this.f78424h;
        if (r111 == null) goto L7;
        r111.setText(s1.B(R.string.ttlive_guest_link_no_time_limit));
    L7:
        TextView r112 = this.f78424h;
        if (r112 == null) goto L10;
        r112.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
    L10:
        TextView r113 = this.f78424h;
        if (r113 == null) goto L29;
        r113.setTextSize(11.0f);
        return;
    L29:
        return;
    L14:
        TextView r100 = this.f78424h;
        if (r100 == null) goto L17;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        long r102 = 60;
        r100.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r110 / r102), Long.valueOf(r110 % r102)}, 2)));
    L17:
        TextView r103 = this.f78424h;
        if (r103 == null) goto L21;
        r103.setTextSize(14.0f);
    L21:
        if (r110 >= 60) goto L25;
        TextView r114 = this.f78424h;
        if (r114 == null) goto L30;
        r114.setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        return;
    L30:
        return;
    L25:
        TextView r115 = this.f78424h;
        if (r115 == null) goto L32;
        r115.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        return;
    }

    public final void da0(IVoiceLiveTheme r100) {
        View r101 = this.f78420d;
        if (r101 == null) goto L5;
        HSImageView r102 = (HSImageView) r101.findViewById(R.id.main_page_bg);
    L6:
        if (r102 == null) goto L8;
        r102.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.d(this, r102));
    L8:
        if (r100 != null) goto L14;
        if (r102 == null) goto L11;
        r102.setController(null);
    L11:
        if (r102 == null) goto L22;
        r102.setBackground(s1.m(R.drawable.ttlive_bg_guest_link_main_page));
        return;
    L22:
        return;
    L14:
        if (r102 == null) goto L16;
        r102.setController(null);
    L16:
        py.k r103 = r100.getSingleStaticBackground();
        if (r103 != null) goto L19;
        r103 = (py.k) vh7.f.c(py.k.class);
    L19:
        if (r102 == null) goto L23;
        r102.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r103, -1)).setOldController(r102.getController()).build());
        return;
    L23:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        ui0.b r101 = this.G;
        r101.getClass();
        ALogger.i("LiveRoomAudioManger", WidgetCostModule.TYPE_ON_CREATE);
        if (je0.d.r() == false) goto L8;
        ALogger.i("LiveRoomAudioManger", "onCreate, user: anchor");
        rj0.k.f537953m2.getClass();
        rj0.k r102 = rj0.k.a.a();
        if (r102 == null) goto L11;
        r102.lm(true);
    L11:
        vi0.b.b();
        return;
    L8:
        if (hd0.c.f().h() == true) goto L10;
        ALogger.i("LiveRoomAudioManger", "onCreate, user: audience");
        r101.a(true, WidgetCostModule.TYPE_ON_CREATE);
        goto L11
    L10:
        ALogger.i("LiveRoomAudioManger", "onCreate, user: guest");
        goto L11
    }

    public BaseGuestLinkMainPageDialog(GuestLinkWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "outerScopeProvider");
        this.I = r100;
        this.f78419J = r101;
        this.B = new LinkedHashMap();
        this.E = new CompositeDisposable();
        this.G = new ui0.b(this);
        this.H = new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.c(this);
    }

    public static final void S90(BaseGuestLinkMainPageDialog r100, IBaseUser r101) {
        r100.getClass();
        if (Intrinsics.areEqual(r101.getIdString(), gh0.a.c()) == true) goto L7;
        ALogger.i("BaseGuestLinkMainPageDialog", "showProfile");
        xs2.b.a().post(new UserProfileEvent(r101).setClickUserPosition(UserProfileEvent.POSITION_GUEST_LINK).setReportSource(UserProfileEvent.POSITION_GUEST_LINK).setReportType(UserProfileEvent.DATA_TYPE_CARD_GUEST_LINK));
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        initView();
        Map<String, Integer> r102 = vm2.i.e().getSeatRatioConfig();
        if (r102 == null) goto L7;
        Integer r103 = r102.get("width");
        if (r103 == null) goto L7;
        float r104 = r103.intValue();
    L8:
        if (r102 == null) goto L12;
        Integer r105 = r102.get("height");
        if (r105 == null) goto L12;
        float r106 = r105.intValue();
    L13:
        Ref.FloatRef r107 = new Ref.FloatRef();
        r107.element = 0.75f;
        if (r106 != 0.0f) goto L16;
    L18:
        View r108 = this.f78421e;
        if (r108 == null) goto L21;
        r108.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.b(this, r107));
    L21:
        View r109 = this.f78422f;
        if (r109 == null) goto L24;
        r109.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.a(r109, this, r107));
    L24:
        com.bytedance.android.live.base.model.message.guestlink.a r110 = T90();
        if (r110 == null) goto L27;
        Z90(r110);
    L27:
        lb6.g r111 = this.D;
        if (r111 == null) goto L36;
        sb6.a r112 = r111.getLinkState();
        if (r112 == null) goto L36;
        PublishSubject r113 = r112.f541256e;
        if (r113 == null) goto L36;
        Disposable r114 = r113.subscribe(new b(this), c.f78444a);
        if (r114 == null) goto L36;
        RxUtilKt.c(r114, this.E);
    L36:
        lb6.g r115 = this.D;
        if (r115 == null) goto L39;
        r115.d(this.H, false);
    L39:
        View r116 = this.f78420d;
        if (r116 == null) goto L44;
        View r117 = r116.findViewById(R.id.ll_audience_container);
        if (r117 == null) goto L44;
        r117.setOnClickListener(new d(this));
    L44:
        View r118 = this.f78420d;
        if (r118 == null) goto L50;
        GiftMarqueeContainer r119 = (GiftMarqueeContainer) r118.findViewById(R.id.gift_marquee_container);
        if (r119 == null) goto L51;
        com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c r120 = new com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c(r119, this.I);
        this.F = r120;
        r120.b();
        return;
    L51:
        return;
    L50:
        return;
    L16:
        if (r104 == 0.0f) goto L18;
        r107.element = (r104 * 2) / r106;
    L12:
        r106 = 480.0f;
    L7:
        r104 = 360.0f;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_fragment_guest_link_main_page, r101, false);
        this.f78420d = r103;
        return r103;
    }

    public final void ba0(com.bytedance.android.live.base.model.message.guestlink.k r100, ViewGroup r101, int r102, boolean r110) {
        if (r100 == null) goto L37;
        IBaseUser r103 = r100.getUser();
        if (r103 == null) goto L50;
        if (r110 == false) goto L8;
        r101.setOnClickListener(new f(this, r103));
    L11:
        TextView r111 = (TextView) r101.findViewById(R.id.tv_user_name);
        if (r111 == null) goto L14;
        r111.setText(r103.getNickName());
    L14:
        ViewGroup r104 = (ViewGroup) r101.findViewById(R.id.ll_personal_score_container);
        boolean r112 = true;
        int r105 = 0;
        if (r104 == null) goto L29;
        r104.setVisibility(0);
        String r106 = r100.getScoreStr();
        if (r106 != null) goto L19;
    L26:
        TextView r107 = (TextView) r101.findViewById(R.id.tv_personal_score);
        if (r107 == null) goto L29;
        r107.setText(r100.getScoreStr());
        goto L29
    L19:
        if (r106.length() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 != true) goto L26;
        TextView r109 = (TextView) r101.findViewById(R.id.tv_personal_score);
        if (r109 == null) goto L29;
        r109.setText("0");
        goto L29
    L21:
        r108 = false;
    L29:
        TextView r113 = (TextView) r101.findViewById(R.id.tv_user_role);
        Intrinsics.checkNotNullParameter(r100, "$this$isInviter");
        if (r100.getUserRole() == LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_Inviter.getValue()) goto L33;
        r112 = false;
    L33:
        if (r112 == true) goto L36;
        r105 = 8;
    L36:
        r113.setVisibility(r105);
        r101.setBackground(null);
        return;
    L8:
        HSImageView r114 = (HSImageView) r101.findViewById(R.id.iv_user_portrait);
        if (r114 == null) goto L11;
        py.k r115 = r103.getAvatarMedium();
        Intrinsics.checkNotNull(r115);
        r103.getIdString();
        ImageUtil.loadRoundImage(r114, r115);
        r114.setOnClickListener(new e(this, r103));
        goto L11
    L50:
        return;
    L37:
        HSImageView r116 = (HSImageView) r101.findViewById(R.id.iv_user_portrait);
        if (r116 == null) goto L40;
        r116.setTag(null);
        a1.m(r116, R.drawable.ttlive_guest_link_default_head);
    L40:
        TextView r117 = (TextView) r101.findViewById(R.id.tv_user_name);
        if (r117 == null) goto L43;
        r117.setText(s1.B(R.string.ttlive_guest_link_waiting));
    L43:
        ViewGroup r118 = (ViewGroup) r101.findViewById(R.id.ll_personal_score_container);
        if (r118 == null) goto L48;
        r118.setVisibility(4);
        TextView r119 = (TextView) r101.findViewById(R.id.tv_personal_score);
        if (r119 == null) goto L48;
        r119.setText("0");
    L48:
        r101.setBackgroundResource(r102);
    }

    public final void ea0(com.bytedance.android.live.base.model.message.guestlink.k r100, j22.c r101, HSImageView r102, int r110) {
        if (W90(r100) == false) goto L6;
        return;
    L6:
        if (j22.c.c(r110, true) <= 0) goto L8;
        boolean r111 = true;
    L9:
        Boolean r103 = Boolean.valueOf(r111);
        Map<String, Boolean> r104 = this.B;
        if (r100 == null) goto L12;
        String r105 = r100.getLinkmicIdStr();
    L13:
        Intrinsics.checkNotNull(r105);
        if (Intrinsics.areEqual(r103, (Boolean) ((LinkedHashMap) r104).get(r105)) == false) goto L16;
        return;
    L16:
        if (r111 == false) goto L22;
        if (r102 == null) goto L19;
        r102.setVisibility(0);
    L19:
        String r106 = vm2.d.a0().unkownMediaAnim;
        if (r101 == null) goto L28;
        r101.d(r106);
    L28:
        Map<String, Boolean> r107 = this.B;
        String r108 = r100.getLinkmicIdStr();
        Intrinsics.checkNotNull(r108);
        r107.put(r108, Boolean.valueOf(r111));
        return;
    L22:
        if (r101 == null) goto L24;
        r101.f496963d = true;
    L24:
        if (r102 == null) goto L28;
        if (r102.isAnimating() == true) goto L28;
        r102.setController(null);
        r102.setVisibility(4);
        goto L28
    L12:
        r105 = null;
        goto L13
    L8:
        r111 = false;
        goto L9
    }
}
