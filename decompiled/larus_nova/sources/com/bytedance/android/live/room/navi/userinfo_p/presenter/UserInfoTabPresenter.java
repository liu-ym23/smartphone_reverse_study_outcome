package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import am2.x;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.RoomOwner;
import com.bytedance.android.live.base.model.user.f0;
import com.bytedance.android.live.base.model.user.z;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.p4;
import com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController;
import com.bytedance.android.live.room.navi.userinfo.model.AnchorTabType;
import com.bytedance.android.live.room.navi.userinfo.model.TabLabelType;
import com.bytedance.android.live.room.navi.userinfo.util.LiveRoomUserInfoUtils;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.qm;
import com.bytedance.android.livesdk.message.model.yd;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.ProfileViewData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.alog.middleware.ALogService;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.m;
import r52.b4;
import u32.n;
import vlc.l;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoTabPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoTabPresenter extends BaseElementPresenter {
    public final a A;
    public int B;
    public final ViewGroup C;
    public final TextView D;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f100101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f100102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f100103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f100104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f100105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f100106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f100107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u32.d f100108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.live.room.navi.userinfo.cert.d<?> f100109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f100110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f100111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f100112q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f100113r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x f100114s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f100115t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public qm f100116u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public yd f100117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Disposable f100118w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Disposable f100119x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f100120y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d f100121z;

    public static final class a implements com.ss.ugc.live.sdk.platform.bytelink.dispatch.c {
        public a(UserInfoTabPresenter r100) {
        }
    }

    public static final class b implements u32.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoTabPresenter f100122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f100123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f100124c;

        @Override // u32.d.a
        public final View a() {
            UserInfoTabPresenter r100 = this.f100122a;
            if (r100.B != 11) goto L7;
            ViewGroup r101 = r100.f100106k;
            if (r101 == null) goto L7;
            return r101;
        L7:
            return null;
        }

        @Override // u32.d.a
        public final View b() {
            if (this.f100122a.g() == false) goto L10;
            TextView r100 = this.f100122a.f100103h;
            if (r100 == null) goto L10;
            if (r100 == null) goto L10;
            if (r100.getVisibility() != 0) goto L10;
            return this.f100122a.f100103h;
        L10:
            return null;
        }

        @Override // u32.d.a
        public final List<Pair<String, String>> d() {
            UserInfoTabPresenter r100 = this.f100122a;
            if (r100.B != 10) goto L20;
            Pair[] r101 = new Pair[2];
            Context r102 = r100.f100070e.getContext();
            String r103 = "";
            if (r102 == null) goto L8;
            String r104 = r102.getString(R.string.live_room_current_room_online_count_label);
            if (r104 == null) goto L8;
        L9:
            this.f100122a.getClass();
            r101[0] = new Pair(r104, "");
            Context r105 = this.f100122a.f100070e.getContext();
            if (r105 == null) goto L13;
            String r106 = r105.getString(R.string.live_room_current_room_ticket_label);
            if (r106 == null) goto L13;
        L14:
            String r107 = this.f100122a.f100112q;
            if (r107 == null) goto L18;
            r103 = r107;
        L18:
            r101[1] = new Pair(r106, r103);
            return CollectionsKt.mutableListOf(r101);
        L13:
            r106 = "";
        L8:
            r104 = "";
            goto L9
        L20:
            return null;
        }

        @Override // u32.d.a
        public final View f() {
            if (this.f100122a.g() == false) goto L5;
            return null;
        L5:
            UserInfoTabPresenter r100 = this.f100122a;
            if (r100.B != 9) goto L13;
            ViewGroup r101 = r100.f100106k;
            if (r101 == null) goto L21;
            if (r101 != null) goto L11;
            return null;
        L11:
            if (r101.getVisibility() == 0) goto L24;
            return null;
        L24:
            return this.f100122a.f100106k;
        L21:
            return null;
        L13:
            View r102 = r100.f100102g;
            if (r102 == null) goto L20;
            if (r102 == null) goto L20;
            if (r102.getVisibility() != 0) goto L20;
            return this.f100122a.f100102g;
        L20:
            return this.f100122a.f100105j;
        }

        @Override // u32.d.a
        public final View g() {
            if (this.f100122a.g() == false) goto L10;
            TextView r100 = this.f100122a.f100104i;
            if (r100 == null) goto L10;
            if (r100 == null) goto L10;
            if (r100.getVisibility() != 0) goto L10;
            return this.f100122a.f100104i;
        L10:
            return null;
        }

        @Override // u32.d.a
        public final String c() {
            return this.f100123b;
        }

        @Override // u32.d.a
        public final n e() {
            return this.f100124c;
        }

        @Override // u32.d.a
        public final void setContentDescription(String r100) {
            Intrinsics.checkNotNullParameter(r100, "contentDescription");
            IRoom r101 = this.f100122a.f100070e.getRoom();
            if (r101 == null) goto L8;
            IBaseUser r102 = r101.getOwner();
            if (r102 == null) goto L8;
            String r103 = r102.getNickName();
            if (r103 == null) goto L8;
        L9:
            this.f100122a.getClass();
            UserInfoTabPresenter.x(r103 + r100);
            return;
        L8:
            r103 = "";
            goto L9
        }

        public b(UserInfoTabPresenter r100, String r101, com.bytedance.android.live.room.navi.userinfo_p.presenter.d r102) {
            this.f100122a = r100;
            this.f100123b = r101;
            this.f100124c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f100125a = null;

        static {
            f100125a = new c();
        }

        public c() {
        }

        public static void a() {
            HashMap r100 = new HashMap();
            r100.put("tag_order", "1");
            r100.put(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, "live_wave");
            j0.l().sendLog("livesdk_tag_show", r100, new Object[]{x.class, IRoom.class});
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoTabPresenter f100126a;

        public d(UserInfoTabPresenter r100) {
            this.f100126a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if ((r100 instanceof o0) == true) goto L5;
            tlc.d r101 = null;
        L6:
            o0 r102 = (o0) r101;
            if (r102 != null) goto L10;
            return;
        L10:
            if (this.f100126a.f100068c == true) goto L12;
            return;
        L12:
            if (b4.f536156a.getValue().a() == false) goto L32;
            String r103 = r102.getMessageMethod();
            if (r103 != null) goto L18;
            return;
        L18:
            if (r103.hashCode() == (-414786051)) goto L21;
            return;
        L21:
            if (r103.equals("WebcastLikeMessage") == false) goto L30;
            yd r104 = (yd) r100;
            if (r104 != null) goto L25;
            return;
        L25:
            u32.d r105 = this.f100126a.f100108m;
            if (r105 == null) goto L31;
            r105.g(r104.getTotal());
            return;
        L31:
            return;
        L30:
            return;
        L32:
            return;
        L5:
            r101 = r100;
            goto L6
        }
    }

    public final com.bytedance.android.live.room.navi.userinfo_p.presenter.d l() {
        Context r100 = this.C.getContext();
        if (r100 != null) goto L5;
        return null;
    L5:
        IRoom r101 = b();
        boolean r102 = false;
        if (r101 == null) goto L24;
        RoomAvator r103 = gb2.b.c(r101);
        if (r103 == null) goto L24;
        List<ProfileViewData> r104 = r103.getProfileViewData();
        if (r104 == null) goto L24;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L22;
        Object r106 = r105.next();
        ProfileViewData r107 = (ProfileViewData) r106;
        if (r107 != null) goto L17;
    L19:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L13;
    L23:
        ProfileViewData r109 = (ProfileViewData) r106;
    L25:
        int r110 = n81.a.f518242a;
        StringBuilder r111 = new StringBuilder("load widget appointment data is null: ");
        if (r109 != null) goto L28;
        r102 = true;
    L28:
        r111.append(r102);
        n81.a.b(r111.toString());
        TextView r112 = new TextView(r100);
        r112.setVisibility(8);
        r112.setTextSize(1, 8.0f);
        r112.setTextColor(-1);
        r112.setMaxLines(1);
        r112.setSingleLine(true);
        if (r109 == null) goto L31;
        Text r113 = r109.getSubTitle();
    L32:
        if (r113 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        r.f141035g.d(r113, null, new y(0.0f), new com.bytedance.android.live.room.navi.userinfo_p.presenter.c(this, r112));
    L35:
        return new com.bytedance.android.live.room.navi.userinfo_p.presenter.d(this, r112, r109);
    L31:
        r113 = null;
        goto L32
    L17:
        if (r107.getSource() != 2) goto L19;
        r108 = true;
        goto L20
    L22:
        r106 = null;
    L24:
        r109 = null;
        goto L25
    }

    public final boolean o() {
        return !((ArrayList) AnchorTabType.f99806b).contains(Integer.valueOf(this.B));
    }

    public final void r() {
        UserInfoVM.Companion.getClass();
        aa1.a r100 = UserInfoVM.b.b();
        if (r100 == null) goto L10;
        ElementMiddleVM r101 = r100.getMiddleVm();
        if (r101 == null) goto L11;
        k<Unit> r102 = r101.getRenderEmpty();
        if (r102 == null) goto L12;
        r102.post(Unit.INSTANCE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void t() {
        StringBuilder r100 = new StringBuilder("renderTicket: ");
        DataCenter r101 = a();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        r100.append(r102);
        ALogger.i("renderTicket", r100.toString());
        DataCenter r103 = a();
        if (r103 == null) goto L9;
        r103.observeForever("data_current_room_ticket_count", this);
    L9:
        IRoom r104 = b();
        String r105 = null;
        Long r106 = null;
        r106 = null;
        r106 = null;
        String r107 = null;
        if (r104 == null) goto L12;
        IRoomStats r108 = r104.getStats();
    L13:
        String r109 = "";
        if (r108 != null) goto L67;
        Spm.Companion.getClass();
        Spm r110 = Spm.a.a("a100.c100.d100");
        IRoom r111 = b();
        if (r111 == null) goto L48;
        r105 = r111.getOwnerUserIdString();
    L48:
        Spm r112 = r110.anchorId(String.valueOf(r105));
        IRoom r113 = b();
        if (r113 == null) goto L54;
        String r114 = r113.getIdStr();
        if (r114 == null) goto L54;
        r109 = r114;
    L54:
        sw2.a.b(r112.roomId(r109).aliasAppend("render_ticket_failed").reason("room or datacenter is null").i(), this.f100101f);
    L56:
        if (c() == false) goto L63;
        View r115 = this.f100102g;
        if (r115 == null) goto L60;
        r115.setTag(R.id.ttlive_tag_user_info_tab_type, "live_wave");
    L60:
        TextView r116 = this.f100103h;
        if (r116 == null) goto L68;
        r116.setTag(R.id.ttlive_tag_user_info_tab_type, "live_wave");
        return;
    L68:
        return;
    L63:
        TextView r117 = this.f100105j;
        if (r117 == null) goto L70;
        r117.setTag(R.id.ttlive_tag_user_info_tab_type, "live_wave");
        return;
    L70:
        return;
    L67:
        DataCenter r118 = a();     // Catch: Exception -> L30
        if (r118 == null) goto L19;
        Object r119 = r118.get("data_current_room_ticket_count");     // Catch: Exception -> L30
    L20:
        if (r119 == null) goto L24;
        DataCenter r120 = a();     // Catch: Exception -> L30
        if (r120 == null) goto L44;
        r106 = (Long) r120.get("data_current_room_ticket_count", 0L);     // Catch: Exception -> L30
    L44:
        y(r106);
        goto L56
    L24:
        IRoom r121 = b();     // Catch: Exception -> L30
        if (r121 == null) goto L44;
        IRoomStats r122 = r121.getStats();     // Catch: Exception -> L30
        if (r122 == null) goto L44;
        r106 = Long.valueOf(r122.getTicket());     // Catch: Exception -> L30
        goto L44
    L19:
        r119 = null;
    L30:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r123 = Spm.a.a("a100.c100.d100");
        IRoom r124 = b();
        if (r124 == null) goto L34;
        r107 = r124.getOwnerUserIdString();
    L34:
        Spm r125 = r123.anchorId(String.valueOf(r107));
        IRoom r126 = b();
        if (r126 == null) goto L38;
        String r127 = r126.getIdStr();
        if (r127 == null) goto L38;
    L39:
        Spm r128 = r125.roomId(r127).aliasAppend("render_ticket_failed");
        String r129 = e.getMessage();
        if (r129 == null) goto L43;
        r109 = r129;
    L43:
        sw2.a.b(r128.reason(r109).i(), this.f100101f);
        r106 = 0L;
    L38:
        r127 = "";
        goto L39
    L12:
        r108 = null;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final void u() {
        String r100 = this.f100101f;
        StringBuilder r101 = new StringBuilder("reportTicketShow:");
        DataCenter r102 = a();
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        r101.append(r103);
        ALogger.i(r100, r101.toString());
        int r104 = com.bytedance.android.live.room.y.f100451a;
        com.bytedance.android.live.room.y.a(a(), this.f100066a, "reportTicketShow", c.f100125a);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
        this.f100111p = 0;
        this.f100110o = 0;
        Disposable r100 = this.f100115t;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f100115t = null;
        Disposable r101 = this.f100118w;
        if (r101 != null) goto L8;
    L12:
        this.f100118w = null;
        Disposable r102 = this.f100119x;
        if (r102 != null) goto L15;
    L19:
        this.f100119x = null;
        this.f100116u = null;
        this.f100117v = null;
        this.f100120y = false;
        return;
    L15:
        if (r102.isDisposed() == true) goto L19;
        Disposable r103 = this.f100119x;
        if (r103 == null) goto L19;
        r103.dispose();
        goto L19
    L8:
        if (r101.isDisposed() == true) goto L12;
        Disposable r104 = this.f100118w;
        if (r104 == null) goto L12;
        r104.dispose();
        goto L12
    }

    public final void n() {
        if (o() == false) goto L6;
    L9:
        u32.d r100 = this.f100108m;
        if (r100 == null) goto L13;
        r100.g(-1);
        return;
    L13:
        return;
    L6:
        if (this.f100070e.a() == false) goto L9;
        v(-1);
        goto L9
    }

    public static final void h(UserInfoTabPresenter r100) {
        if (r100.f100070e.a() == false) goto L45;
        IRoom r101 = r100.b();
        f0 r102 = null;
        if (r101 == null) goto L14;
        IBaseUser r103 = r101.getOwner();
        if (r103 == null) goto L14;
        com.bytedance.android.live.base.model.user.x r104 = r103.getIndustryCertification();
        if (r104 == null) goto L14;
        z r105 = r104.getRoom();
        if (r105 == null) goto L14;
        f0 r106 = r105.getMRoomOwner();
    L16:
        if ((r106 instanceof RoomOwner) == false) goto L19;
        r102 = r106;
    L19:
        RoomOwner r107 = (RoomOwner) r102;
        if (r107 != null) goto L22;
        return;
    L22:
        if (r107.getType() != 106) goto L46;
        o r108 = j0.l().c(x.class);
        if ((r108 instanceof t) == false) goto L44;
        t r109 = (t) r108;
        String r110 = r109.getMap().get("enter_from_merge");
        String r111 = r109.getMap().get("enter_method");
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        if (r111 != null) goto L31;
        r111 = "";
    L31:
        HashMap r112 = new HashMap();
        IRoom r113 = r100.b();
        if (r113 == null) goto L35;
        String r114 = String.valueOf(r113.getId());
        if (r114 == null) goto L35;
    L36:
        r112.put("room_id", r114);
        r112.put("EVENT_ORIGIN_FEATUR", com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r112.put("enter_from_merge", r110);
        r112.put("enter_method", r111);
        IRoom r115 = r100.b();
        if (r115 == null) goto L40;
        String r116 = r115.getOwnerUserIdString();
        if (r116 == null) goto L40;
    L41:
        r112.put("anchor_id", r116);
        r112.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        r112.put("action_type", r100.f100070e.getDataCenter().get("log_action_type", ""));
        r112.put("is_flagship_room", "1");
        r112.put("is_flash", "0");
        j0.l().sendLog("livesdk_flagship_label_show", r112, new Object[0]);
        return;
    L40:
        r116 = "";
    L35:
        r114 = "";
        goto L36
    L44:
        return;
    L46:
        return;
    L14:
        r106 = null;
        goto L16
    }

    public static void x(String r100) {
        UserInfoVM.Companion.getClass();
        aa1.a r101 = UserInfoVM.b.b();
        if (r101 == null) goto L10;
        ElementBasicVM r102 = r101.getBasicVm();
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.n<String> r103 = r102.getContainerContentDescription();
        if (r103 == null) goto L12;
        r103.setValue(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(View r100) {
        if (r100 == null) goto L22;
        IRoom r101 = b();
        if (r101 == null) goto L6;
        AnchorTabLabel r102 = r101.getAnchorTabLabel();
    L7:
        if (r102 == null) goto L23;
        int r103 = r102.getType();
        if (r103 != TabLabelType.POI.value) goto L11;
        String r104 = AppletNaviType.POI;
    L13:
        if (r103 != TabLabelType.QualityGeek.value) goto L15;
        r100.setTag(R.id.ttlive_tag_user_info_ecom_flag, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
    L15:
        r100.setTag(R.id.ttlive_tag_user_info_tab_type, r104);
        r100.setTag(R.id.ttlive_tag_user_info_tab_label_type, Integer.valueOf(r103));
        String r105 = r102.getContent();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r100.setTag(R.id.ttlive_tag_user_info_label_text, r105);
        Map<String, String> r106 = r102.getTrackParams();
        if (r106 == null) goto L24;
        r100.setTag(R.id.ttlive_tag_user_info_track_params, r106);
        return;
    L24:
        return;
    L11:
        r104 = "brand_flagship";
        goto L13
    L23:
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final int k(Integer r100) {
        int r101 = 1;
        if (r100 == null) goto L92;
        r100.intValue();
        if (r100.intValue() != 4) goto L11;
        if (this.f100068c == false) goto L11;
        ALogService.wSafely(this.f100101f, "filter server anchor tab type; current user is anchor, but type is " + r100);
        return 1;
    L11:
        if (((ArrayList) AnchorTabType.f99805a).contains(r100) == false) goto L24;
        IRoom r102 = b();
        if (r102 == null) goto L24;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L24;
        if (r103.getEnableDigg() == true) goto L24;
        ALogService.wSafely(this.f100101f, "filter server anchor tab type; current room does't support dig");
        if (this.f100068c == true) goto L96;
        return 4;
    L96:
        return 1;
    L24:
        if (((ArrayList) AnchorTabType.f99807c).contains(r100) == false) goto L30;
        if (this.f100068c == false) goto L97;
        return 5;
    L97:
        return 3;
    L30:
        if (r100.intValue() != (-1)) goto L37;
        ALogger.i(this.f100101f, "filter server anchor tab type; current room is using local_fallback strategy");
        if (this.f100068c == true) goto L98;
        return 3;
    L98:
        return 1;
    L37:
        if (r100.intValue() == 0) goto L39;
        Integer r104 = g81.f.f480373a.getValue();
        if (r100.intValue() == 8) goto L47;
        if (r100.intValue() == 9) goto L47;
    L80:
        if (r100.intValue() > 11) goto L86;
        if (r100.intValue() < 0) goto L86;
        return r100.intValue();
    L86:
        if (this.f100068c == true) goto L90;
        r101 = 3;
    L90:
        return r101;
    L47:
        if (this.f100068c == false) goto L54;
        ALogService.wSafely(this.f100101f, "filter server anchor tab type; the room doesn't has certification info");
        if (this.f100068c == true) goto L100;
        return 3;
    L100:
        return 1;
    L54:
        if (r100.intValue() != 8) goto L63;
        if (r104 == null) goto L63;
        if (r104.intValue() != 0) goto L63;
        if (this.f100068c == false) goto L101;
        return 5;
    L101:
        return 3;
    L63:
        if (r104 != null) goto L66;
    L67:
        IRoom r105 = b();
        if (r105 != null) goto L70;
    L72:
        boolean r106 = false;
    L73:
        if (r106 == true) goto L80;
        if (this.f100068c == true) goto L102;
        return 3;
    L102:
        return 1;
    L70:
        if (r105.getAnchorTabLabel() == null) goto L72;
        r106 = true;
        goto L73
    L66:
        if (r104.intValue() == 0) goto L80;
    L39:
        if (this.f100068c == false) goto L99;
        return 5;
    L99:
        return 3;
    L92:
        if (this.f100068c == true) goto L104;
        return 3;
    L104:
        return 1;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter, vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof o0) == true) goto L5;
        tlc.d r101 = null;
    L6:
        o0 r102 = (o0) r101;
        if (r102 != null) goto L9;
        return;
    L9:
        m r103 = r102.getMessageType();
        if (r103 != MessageType.UPDATE_FAN_TICKET_MESSAGE) goto L23;
        if (r100 == null) goto L21;
        qm r104 = (qm) r100;
        this.f100116u = r104;
        if (this.f100120y == true) goto L15;
    L19:
        z(r104);
        return;
    L15:
        if (this.f100068c == false) goto L19;
        if (b4.f536156a.getValue().a() == false) goto L19;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.UpdateFanTicketMessage");
    L23:
        if (r103 == MessageType.LIKE_MESSAGE) goto L25;
        return;
    L25:
        if (com.bytedance.android.live.misc.e.f83227a.getValue().booleanValue() == false) goto L41;
        if (r100 == null) goto L38;
        yd r105 = (yd) r100;
        this.f100117v = r105;
        if (this.f100120y == true) goto L30;
    L34:
        u32.d r106 = this.f100108m;
        if (r106 == null) goto L42;
        r106.g(r105.getTotal());
        return;
    L42:
        return;
    L30:
        if (this.f100068c == false) goto L34;
        if (b4.f536156a.getValue().a() == false) goto L34;
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LikeMessage");
    L41:
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public final void p(Integer r110) {
        if (r110 == null) goto L134;
        r110.intValue();
        Spm.Companion.getClass();
        Spm r100 = Spm.a.a("a100.c100.d100");
        IRoom r101 = b();
        String r102 = "";
        if (r101 == null) goto L7;
        String r103 = r101.getOwnerUserIdString();
        if (r103 == null) goto L7;
    L8:
        Spm r104 = r100.anchorId(r103);
        IRoom r105 = b();
        if (r105 == null) goto L12;
        String r106 = r105.getIdStr();
        if (r106 == null) goto L12;
    L13:
        sw2.a.b(r104.roomId(r106).aliasAppend("render_anchor_tab").addArg("type", r110).i(), this.f100101f);
        this.B = r110.intValue();
        ALogger.d(this.f100101f, " renderAnchorTabType  current type : " + this.B);
        IRoom r107 = b();
        if (r107 == null) goto L23;
        RoomAvator r108 = gb2.b.c(r107);
        if (r108 == null) goto L23;
        List<Long> r109 = r108.getSecondLabel();
        if (r109 == null) goto L23;
        List<Long> r111 = r109;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r113 = r111.iterator();
    L21:
        if (r113.hasNext() == false) goto L24;
        r112.add(Integer.valueOf((int) ((Number) r113.next()).longValue()));
    L24:
        com.bytedance.android.livesdk.chatroom.o r114 = z51.a.h(a(), 2);
        if (r114 == null) goto L31;
        com.bytedance.live.datacontext.n<z70.b> r115 = r114.getTemplateContext();
        if (r115 == null) goto L31;
        z70.b r116 = r115.getValue();
        if (r116 == null) goto L31;
        boolean r117 = r116.j("anchor_avatar");
    L33:
        if (r117 == false) goto L63;
        if (r112.contains(4) != true) goto L50;
        if (r112.contains(3) != true) goto L40;
        t();
        m("flip", false);
        return;
    L40:
        if (r112.contains(5) != true) goto L45;
        int r118 = n81.a.f518242a;
        if (n81.a.a(a()) == false) goto L44;
        n81.a.b("appointment、cert、digg flip");
        s(true);
        return;
    L44:
        n81.a.b("cert、digg flip");
        s(false);
        return;
    L45:
        int r119 = n81.a.f518242a;
        if (n81.a.a(a()) == false) goto L48;
        n81.a.b("appointment、digg flip");
        q(true);
        return;
    L48:
        n81.a.b("digg flip");
        q(false);
        return;
    L50:
        if (r112.contains(3) != true) goto L53;
        t();
        u();
        return;
    L53:
        if (r112.contains(0) != true) goto L56;
        r();
        return;
    L56:
        if (r112.contains(5) != true) goto L61;
        int r120 = n81.a.f518242a;
        if (n81.a.a(a()) == false) goto L60;
        n81.a.b("appointment、cert、digg flip");
        s(true);
        return;
    L60:
        n81.a.b("cert、digg flip");
        s(false);
        return;
    L61:
        r();
        return;
    L63:
        if (r110.intValue() != 0) goto L66;
        return;
    L66:
        if (r110.intValue() != 1) goto L69;
        t();
        u();
        return;
    L69:
        if (r110.intValue() != 3) goto L72;
        q(false);
        return;
    L72:
        if (r110.intValue() != 4) goto L75;
        r();
        return;
    L75:
        if (r110.intValue() != 5) goto L78;
        t();
        m("flip", false);
        return;
    L78:
        if (r110.intValue() != 8) goto L129;
        Integer r121 = g81.f.f480373a.getValue();
        if (r121 != null) goto L83;
        return;
    L83:
        if (r121.intValue() == 1) goto L85;
        return;
    L85:
        if (this.f100068c == false) goto L87;
    L116:
        Spm.Companion.getClass();
        Spm r122 = Spm.a.a("a100.c100.d100");
        IRoom r123 = b();
        if (r123 == null) goto L120;
        String r124 = r123.getOwnerUserIdString();
        if (r124 == null) goto L120;
    L121:
        Spm r125 = r122.anchorId(r124);
        IRoom r126 = b();
        if (r126 == null) goto L127;
        String r127 = r126.getIdStr();
        if (r127 == null) goto L127;
        r102 = r127;
    L127:
        sw2.a.b(r125.roomId(r102).aliasAppend("render_cert_failed").result(-1).addArg(IPerformanceManager.Params.is_anchor, Boolean.valueOf(this.f100068c)).addArg(IPerformanceManager.Params.is_portrait, Boolean.valueOf(this.f100069d)).reason("anchor or portrait is not compliance with rules").w(), this.f100101f);
        return;
    L120:
        r124 = "";
        goto L121
    L87:
        if (this.f100069d == false) goto L116;
        IRoom r128 = b();
        if (r128 == null) goto L94;
        AnchorTabLabel r129 = r128.getAnchorTabLabel();
        if (r129 == null) goto L94;
        py.k r130 = r129.getLabel();
    L95:
        IRoom r131 = b();
        if (r131 == null) goto L98;
        com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r131);
    L98:
        if (r130 != null) goto L111;
        Spm.Companion.getClass();
        Spm r132 = Spm.a.a("a100.c100.d100");
        IRoom r133 = b();
        if (r133 == null) goto L103;
        String r134 = r133.getOwnerUserIdString();
        if (r134 == null) goto L103;
    L104:
        Spm r135 = r132.anchorId(r134);
        IRoom r136 = b();
        if (r136 == null) goto L110;
        String r137 = r136.getIdStr();
        if (r137 == null) goto L110;
        r102 = r137;
    L110:
        sw2.a.b(r135.roomId(r102).aliasAppend("render_cert_failed").result(-1).reason("cert info is null").w(), this.f100101f);
        return;
    L103:
        r134 = "";
        goto L104
    L111:
        RoomImageLayoutController r138 = new RoomImageLayoutController(new i(this));
        this.f100109n = r138;
        r138.d();
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r139 = this.f100109n;
        if (r139 == null) goto L115;
        ((RoomImageLayoutController) r139).e(r130);
        j(this.f100106k);
        return;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController");
    L94:
        r130 = null;
        goto L95
    L129:
        if (r110.intValue() != 9) goto L131;
        s(false);
        return;
    L131:
        r();
        return;
    L31:
        r117 = false;
    L23:
        r112 = new ArrayList();
    L12:
        r106 = "";
    L7:
        r103 = "";
        goto L8
    }

    public final void q(boolean r100) {
        if (r100 == false) goto L4;
        m("flip_appointment_digg", r100);
        return;
    L4:
        m("new", false);
    }

    public final void s(boolean r100) {
        IRoom r101 = b();
        com.bytedance.android.live.room.navi.userinfo_p.presenter.d r102 = null;
        if (r101 == null) goto L5;
        AnchorTabLabel r103 = r101.getAnchorTabLabel();
    L6:
        com.bytedance.android.livesdk.chatroom.o r104 = z51.a.h(a(), 2);
        if (r104 == null) goto L13;
        com.bytedance.live.datacontext.n<z70.b> r105 = r104.getTemplateContext();
        if (r105 == null) goto L13;
        z70.b r106 = r105.getValue();
        if (r106 == null) goto L13;
        boolean r107 = r106.j("anchor_avatar");
    L14:
        if (r107 == false) goto L21;
        IRoom r108 = b();
        if (r108 == null) goto L20;
        RoomAvator r109 = gb2.b.c(r108);
        if (r109 == null) goto L20;
        r103 = r109.getSecondTabLabel();
    L20:
        r103 = null;
    L21:
        if (r103 == null) goto L29;
        h r110 = new h(this);
        j(this.f100106k);
        e91.a r111 = new f91.a().a(this.f100070e, Integer.valueOf(r103.getStyle()), r110);
        this.f100109n = r111;
        if (r111 == null) goto L26;
        r111.c();
    L26:
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r112 = this.f100109n;
        if (r112 == null) goto L29;
        r112.a(r103);
    L29:
        String r113 = "flip_active";
        if (r107 == false) goto L43;
        if (r100 == false) goto L33;
        r113 = "flip_appointment_cert_digg";
    L33:
        if (r100 == false) goto L35;
        r102 = l();
    L35:
        this.f100108m = ((IBaseDiggService) jc1.k.n(IBaseDiggService.class)).provideDiggCountFlipperLayoutController(new e(this, r113, r102));
        DataCenter r114 = a();
        if (r114 == null) goto L45;
        u32.d r115 = this.f100108m;
        if (r115 == null) goto L40;
        r115.a(r114);
    L40:
        u32.d r116 = this.f100108m;
        if (r116 == null) goto L46;
        r116.b();
        return;
    L46:
        return;
    L45:
        return;
    L43:
        m("flip_active", false);
        return;
    L13:
        r107 = false;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    public final void v(long r100) {
        String r101 = null;
        if (c() == false) goto L30;
        CharSequence r102 = "";
        if (this.B != 10) goto L7;
        this.f100112q = com.bytedance.android.live.core.utils.x.a(r100);
    L11:
        IRoom r103 = this.f100070e.getRoom();
        if (r103 == null) goto L17;
        IBaseUser r104 = r103.getOwner();
        if (r104 == null) goto L17;
        String r105 = r104.getNickName();
        if (r105 == null) goto L17;
    L18:
        TextView r106 = this.f100104i;
        if (r106 == null) goto L22;
        CharSequence r107 = r106.getText();
        if (r107 == null) goto L22;
    L23:
        TextView r108 = this.f100103h;
        if (r108 == null) goto L29;
        CharSequence r109 = r108.getText();
        if (r109 == null) goto L29;
        r102 = r109;
    L29:
        x(r105 + r107 + r102);
        return;
    L22:
        r107 = "";
    L17:
        r105 = "";
        goto L18
    L7:
        UIUtils.setText(this.f100103h, com.bytedance.android.live.core.utils.x.a(r100));
        TextView r110 = this.f100104i;
        Context r111 = this.f100070e.getContext();
        if (r111 == null) goto L10;
        r101 = r111.getString(R.string.live_room_current_room_ticket_label, new Object[]{""});
    L10:
        UIUtils.setText(r110, r101);
        goto L11
    L30:
        TextView r112 = this.f100105j;
        if (r112 == null) goto L38;
        Context r113 = this.f100070e.getContext();
        if (r113 == null) goto L35;
        r101 = r113.getString(R.string.live_room_current_room_ticket_label, new Object[]{com.bytedance.android.live.core.utils.x.a(r100)});
    L35:
        r112.setText(r101);
        return;
    }

    public final void y(Long r100) {
        if (r100 == null) goto L8;
        r100.longValue();
        if (this.f100111p <= r100.longValue()) goto L6;
        return;
    L6:
        this.f100111p = r100.longValue();
        v(r100.longValue());
        return;
    }

    public final void z(qm r100) {
        if (o() == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f100070e.a() == true) goto L11;
        return;
    L11:
        if (r100.E() == false) goto L20;
        Long r101 = r100.getCount();
        long r102 = 0;
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
    L16:
        this.f100111p = r103;
        Long r104 = r100.getCount();
        if (r104 == null) goto L19;
        r102 = r104.longValue();
    L19:
        v(r102);
        return;
    L15:
        r103 = 0;
        goto L16
    L20:
        y(r100.getCount());
    }

    public final void m(String r100, boolean r101) {
        if (r101 == false) goto L4;
        com.bytedance.android.live.room.navi.userinfo_p.presenter.d r102 = l();
    L5:
        this.f100108m = ((IBaseDiggService) jc1.k.n(IBaseDiggService.class)).provideDiggCountFlipperLayoutController(new b(this, r100, r102));
        DataCenter r103 = a();
        if (r103 == null) goto L14;
        u32.d r104 = this.f100108m;
        if (r104 == null) goto L10;
        r104.a(r103);
    L10:
        u32.d r105 = this.f100108m;
        if (r105 == null) goto L15;
        r105.b();
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r102 = null;
        goto L5
    }

    public UserInfoTabPresenter(m91.c r100, ViewGroup r101, TextView r102) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r101, "mUserNameLayout");
        Intrinsics.checkNotNullParameter(r102, "mNameAreaTempAnimSubTitleView");
        super(r100);
        this.C = r101;
        this.D = r102;
        this.f100101f = "UserInfoMiddlePresenter";
        this.f100113r = 500;
        this.f100114s = new x();
        this.f100121z = new d(this);
        this.A = new a(this);
    }

    public static final void i(final UserInfoTabPresenter r100, TextView r101, SpannableString r102) {
        r100.getClass();
        int r103 = n81.a.f518242a;
        n81.a.b("onAppointmentTextLoad, text = " + r102);
        if (p4.f65383a.getValue().booleanValue() == true) goto L6;
        n81.a.b("no change width");
        return;
    L6:
        if (r100.f100115t == null) goto L8;
        n81.a.b("onAppointmentTextLoadSuccess appointmentHideAction != null");
        return;
    L8:
        TextPaint r104 = r101.getPaint();
        int r105 = 0;
        if (r104 == null) goto L12;
        r105 = (int) r104.measureText(r102, 0, r102.length());
    L12:
        final int r106 = r100.f100070e.b().getMiddleVm().getUserNameLayoutMaxWidthPx().getValue().intValue();
        final int r107 = r100.f100070e.b().getMiddleVm().getUserNameLayoutCurWidthPx().getValue().intValue();
        n81.a.b("textLength = " + r105 + ", oldMiddleMaxWidth = " + r106 + ", oldMiddleWidth = " + r107);
        if (r105 <= r107) goto L15;
        n81.a.b("change middle width");
        r100.f100070e.b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf(r105));
        r100.f100070e.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r105));
        int r108 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        r100.f100115t = com.bytedance.revenue.platform.api.core.rx.h.a(new UserInfoTabPresenter$onAppointmentTextLoadSuccess$1(r100, r106, r107));
        return;
    L15:
        int r109 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        r100.f100115t = com.bytedance.revenue.platform.api.core.rx.h.a(UserInfoTabPresenter$onAppointmentTextLoadSuccess$2.INSTANCE);
    }

    public final Disposable w(String r100, int r101, long r102) {
        TextView r103 = this.D;
        if (r103 != null) goto L5;
        return null;
    L5:
        r103.setText(r100);
        r103.setTextColor(r101);
        if (this.f100068c == false) goto L8;
        r103.setTextSize(10.0f);
    L9:
        u32.d r104 = this.f100108m;
        if (r104 == null) goto L12;
        View r105 = r104.d();
    L13:
        if (r105 == null) goto L17;
        u32.d r106 = this.f100108m;
        if (r106 == null) goto L23;
        View r107 = r106.d();
    L24:
        if (r107 != null) goto L27;
        return null;
    L27:
        return LiveRoomUserInfoUtils.a(r103, r107, r102, new UserInfoTabPresenter$showTempSubTitleAnim$1(this));
    L23:
        r107 = null;
        goto L24
    L17:
        r107 = this.f100102g;
        if (r107 != null) goto L24;
        r107 = this.f100105j;
        if (r107 == null) goto L23;
    L12:
        r105 = null;
        goto L13
    L8:
        r103.setTextSize(8.0f);
        goto L9
    }
}
