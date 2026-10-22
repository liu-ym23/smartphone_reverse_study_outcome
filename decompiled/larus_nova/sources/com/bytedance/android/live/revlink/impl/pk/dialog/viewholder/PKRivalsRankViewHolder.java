package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKRivalsRankViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsRankViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VHeadView f96222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VHeadView f96223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Button f96227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f96229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f96230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f96231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f96232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PkTagsContainerView f96233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m2 f96234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IRoom f96235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f96236o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a f96237p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.service.b f96238q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<String, String> f96239r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f96240s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SearchSourceFlag f96241t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f96242u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x31.h f96243v;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        IRoom r100 = this.f96235n;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100.getIdStr();
    L5:
        return "";
    }

    public static final com.bytedance.android.live.revenuelink.connect.n T3(PKRivalsRankViewHolder r100) {
        r100.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r101 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r102 = false;
        if (r101 == null) goto L5;
        int r103 = r101.getCurrentMode();
    L7:
        if (v.a(r103, 64) == false) goto L9;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r104 = r100.f96237p;
        if (r104 == null) goto L22;
        com.bytedance.android.live.revenuelink.connect.n r105 = r104.getLinkOutManagerFn();
    L23:
        if (r105 != null) goto L25;
        return null;
    L25:
        return r100.f96237p.getLinkOutManagerFn();
    L22:
        r105 = null;
        goto L23
    L9:
        if (r100.f96241t != SearchSourceFlag.MAIN_LINK) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.b r106 = r100.f96238q;
        if (r106 == null) goto L16;
        com.bytedance.android.live.revenuelink.connect.n r107 = r106.getLinkOutManagerFn();
    L17:
        if (r107 != null) goto L27;
        return null;
    L27:
        return r100.f96238q.getLinkOutManagerFn();
    L16:
        r107 = null;
        goto L17
    L5:
        r103 = 0;
        goto L7
    }

    public static final int U3(PKRivalsRankViewHolder r100) {
        r100.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r101 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r102 = false;
        if (r101 == null) goto L5;
        int r103 = r101.getCurrentMode();
    L7:
        if (v.a(r103, 64) == false) goto L9;
    L12:
        return 7;
    L9:
        if (r100.f96241t != SearchSourceFlag.MAIN_LINK) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L12;
        return 1;
    L5:
        r103 = 0;
        goto L7
    }

    public static boolean Y3(IRoom r100) {
        if (r100.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getLinkMap().containsKey(String.valueOf(1)) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        m2 r101 = this.f96234m;
        if (r101 == null) goto L42;
        Intrinsics.checkNotNull(r101);
        if (r101.getRoom() == null) goto L43;
        m2 r102 = this.f96234m;
        Intrinsics.checkNotNull(r102);
        IRoom r103 = r102.getRoom();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("right_user_id", String.valueOf(r103.getAnchorId()));
        r104.put("right_room_id", r103.getIdStr());
        r104.put("connection_type", "manual_pk");
        int r105 = UserListInviteType.f70864a;
        r104.put("list_type", UserListInviteType.a(this.f96232k, null));
        if (Y3(r103) == false) goto L10;
    L15:
        r104.put("right_user_status", "1");
    L16:
        String r106 = "";
        if (com.bytedance.android.live.revlink.impl.global.b.f() == null) goto L22;
        com.bytedance.android.live.revlink.impl.control.d r107 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r107 == null) goto L21;
        String r108 = r107.getRequestId();
    L23:
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        r104.put("request_id", r108);
        r104.put("enter_from", r100);
        d31.d r109 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r109 == null) goto L28;
        String r110 = r109.f();
    L29:
        r104.put("invite_mode", r110);
        d31.d r111 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r111 == null) goto L32;
        String r112 = r111.d();
    L33:
        r104.put("battle_mode", r112);
        r104.put("invitee_list", UserListInviteType.a(this.f96232k, null));
        r104.put("list_num", String.valueOf(this.f96242u + 1));
        r104.putAll(this.f96239r);
        d31.d r113 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r113 == null) goto L36;
        String r114 = r113.s();
    L37:
        r104.put("room_status", r114);
        d31.d r115 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r115 == null) goto L40;
        r106 = r115.b();
    L40:
        r104.put("connection_sub_type", r106);
        mz0.n r116 = new mz0.n();
        Map<String, String> r117 = r116.f516447a;
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r104, "map");
        r117.putAll(r104);
        mz0.m r118 = new mz0.m();
        r118.b(LogCommon.ROOM);
        ((ArrayList) r116.f516448b).addAll(r118.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r119 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_connectioninvite_anchoricon_show", r116.f516447a, r116.f516448b);
        return;
    L36:
        r114 = "";
        goto L37
    L32:
        r112 = "";
        goto L33
    L28:
        r110 = "";
        goto L29
    L21:
        r108 = null;
        goto L23
    L22:
        r108 = "";
        goto L23
    L10:
        if (Z3(r103) == true) goto L15;
        if (X3(r103) == true) goto L15;
        r104.put("right_user_status", "2");
        goto L16
    L43:
        return;
    }

    public final boolean V3(IBaseUser r100) {
        i11.b r101 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r101 == null) goto L12;
        if (r100 == null) goto L17;
        Iterator<IBaseUser> r102 = r101.n().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        if (TextUtils.equals(iz.a.a(r102.next()), iz.a.a(r100)) == false) goto L7;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        return false;
    }

    public final boolean W3(IBaseUser r100) {
        i11.b r101 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r101 == null) goto L12;
        if (r100 == null) goto L17;
        Iterator<IBaseUser> r102 = r101.getInviteeList().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        if (TextUtils.equals(iz.a.a(r102.next()), iz.a.a(r100)) == false) goto L7;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        return false;
    }

    public final boolean X3(IRoom r100) {
        if (r100.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getLinkMap().containsKey(String.valueOf(7)) == false) goto L7;
        return true;
    }

    public final boolean Z3(IRoom r100) {
        if (r100.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getLinkMap().containsKey(String.valueOf(8)) == false) goto L7;
        return true;
    }

    public PKRivalsRankViewHolder(View r100, x31.h r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "mListener");
        Intrinsics.checkNotNullParameter(r102, "mDataCenter");
        super(r100);
        this.f96243v = r101;
        this.f96222a = (VHeadView) r100.findViewById(R.id.head_view);
        this.f96223b = (VHeadView) r100.findViewById(R.id.gender_view);
        this.f96224c = (TextView) r100.findViewById(R.id.tv_nick_name);
        this.f96225d = (TextView) r100.findViewById(R.id.tv_fire_number);
        this.f96226e = (TextView) r100.findViewById(R.id.ttlive_audience_number);
        this.f96227f = (Button) r100.findViewById(R.id.bt_invite);
        this.f96228g = (TextView) r100.findViewById(R.id.tv_unaccept_invite);
        this.f96229h = r100.findViewById(R.id.ttlive_location_icon);
        this.f96230i = r100.findViewById(R.id.iv_audience);
        this.f96231j = r100.findViewById(R.id.iv_fire_wave);
        this.f96233l = (PkTagsContainerView) r100.findViewById(R.id.tags_container);
        this.f96236o = r100.getContext();
        this.f96237p = com.bytedance.android.live.revlink.impl.global.b.t();
        this.f96238q = com.bytedance.android.live.revlink.impl.global.b.N();
        this.f96239r = new HashMap();
    }
}
