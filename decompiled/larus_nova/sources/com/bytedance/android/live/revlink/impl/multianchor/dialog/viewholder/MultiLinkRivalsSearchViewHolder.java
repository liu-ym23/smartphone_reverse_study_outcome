package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/MultiLinkRivalsSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRivalsSearchViewHolder extends RecyclerView.ViewHolder implements Observer<KVData>, com.bytedance.android.live.revlink.impl.pk.ui.j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f93783w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VHeadView f93784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VHeadView f93785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VHeadView f93786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f93787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f93788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f93789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f93790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f93791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HSImageView f93792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f93793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f93794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f93795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SearchSourceFlag f93796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PkTagsContainerView f93797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnchorLinkInfoView f93798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f93799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a f93800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.service.b f93801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public x8 f93802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f93803t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f93804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x31.g f93805v;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        x8 r100 = this.f93802s;
        if (r100 == null) goto L8;
        String r101 = r100.getSecUid();
        if (r101 == null) goto L10;
        return r101;
    L10:
        return "";
    L8:
        return "";
    }

    public static final com.bytedance.android.live.revenuelink.connect.n T3(MultiLinkRivalsSearchViewHolder r100) {
        r100.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r101 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r102 = false;
        if (r101 == null) goto L5;
        int r103 = r101.getCurrentMode();
    L7:
        if (v.a(r103, 64) == false) goto L9;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r104 = r100.f93800q;
        if (r104 == null) goto L22;
        com.bytedance.android.live.revenuelink.connect.n r105 = r104.getLinkOutManagerFn();
    L23:
        if (r105 != null) goto L25;
        return null;
    L25:
        return r100.f93800q.getLinkOutManagerFn();
    L22:
        r105 = null;
        goto L23
    L9:
        if (r100.f93796m != SearchSourceFlag.MAIN_LINK) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.b r106 = r100.f93801r;
        if (r106 == null) goto L16;
        com.bytedance.android.live.revenuelink.connect.n r107 = r106.getLinkOutManagerFn();
    L17:
        if (r107 != null) goto L27;
        return null;
    L27:
        return r100.f93801r.getLinkOutManagerFn();
    L16:
        r107 = null;
        goto L17
    L5:
        r103 = 0;
        goto L7
    }

    public static final int U3(MultiLinkRivalsSearchViewHolder r100) {
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
        if (r100.f93796m != SearchSourceFlag.MAIN_LINK) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L12;
        return 1;
    L5:
        r103 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        x8 r101 = this.f93802s;
        if (r101 == null) goto L49;
        Intrinsics.checkNotNull(r101);
        if (r101.getRoom() == null) goto L50;
        x8 r102 = this.f93802s;
        Intrinsics.checkNotNull(r102);
        if (r102.getRoomId() == 0) goto L51;
        x8 r103 = this.f93802s;
        Intrinsics.checkNotNull(r103);
        IRoom r104 = r103.getRoom();
        LinkedHashMap r105 = new LinkedHashMap();
        String r106 = iz.a.a(r104.getOwner());
        String r107 = "";
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        r105.put("right_user_id", r106);
        r105.put("right_room_id", r104.getIdStr());
        int r108 = UserListInviteType.f70864a;
        r105.put("list_type", UserListInviteType.a(this.f93795l, null));
        r105.put("right_user_status", String.valueOf(this.f93803t));
        r105.put("invitee_list", "search");
        r105.put("list_num", String.valueOf(this.f93804u + 1));
        if (com.bytedance.android.live.revlink.impl.global.b.f() == null) goto L18;
        com.bytedance.android.live.revlink.impl.control.d r109 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r109 == null) goto L18;
        String r110 = r109.getRequestId();
        if (r110 == null) goto L18;
    L19:
        r105.put("request_id", r110);
        r105.put("enter_from", r100);
        SearchSourceFlag r111 = this.f93796m;
        if (r111 != null) goto L23;
    L24:
        String r112 = "link_banner";
    L30:
        r105.put("source", r112);
        d31.d r113 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r113 == null) goto L33;
        String r114 = r113.f();
    L34:
        r105.put("invite_mode", r114);
        d31.d r115 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r115 == null) goto L37;
        String r116 = r115.d();
    L38:
        r105.put("battle_mode", r116);
        d31.d r117 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r117 == null) goto L42;
        r117.r(r105);
    L42:
        if (y.b() == true) goto L44;
        r105.put("connection_type", "manual_link");
    L44:
        d31.d r118 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r118 == null) goto L47;
        r107 = r118.s();
    L47:
        r105.put("room_status", r107);
        mz0.n r119 = new mz0.n();
        Map<String, String> r120 = r119.f516447a;
        Intrinsics.checkNotNullParameter(r120, "map");
        Intrinsics.checkNotNullParameter(r105, "map");
        r120.putAll(r105);
        mz0.m r121 = new mz0.m();
        r121.b(LogCommon.ROOM);
        List<Object> r122 = r119.f516448b;
        ArrayList r123 = (ArrayList) r122;
        r123.addAll(r121.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r124 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r125 = com.bytedance.android.scope.m.b(r124).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r125);
        ((mz0.i) ((f80.a) r125)).w3("livesdk_connectioninvite_anchoricon_show", r119.f516447a, r119.f516448b);
        return;
    L37:
        r116 = "";
        goto L38
    L33:
        r114 = "";
        goto L34
    L23:
        if (g.f93835a[r111.ordinal()] != 1) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r126 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r126 == null) goto L29;
        r112 = r126.f93591a;
        if (r112 != null) goto L30;
    L29:
        r112 = "";
    L18:
        r110 = "";
        goto L19
    L51:
        return;
    L50:
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

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
    }

    public MultiLinkRivalsSearchViewHolder(View r100, x31.g r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "mListener");
        Intrinsics.checkNotNullParameter(r102, "mDataCenter");
        super(r100);
        this.f93805v = r101;
        this.f93784a = (VHeadView) r100.findViewById(R.id.head_view);
        this.f93785b = (VHeadView) r100.findViewById(R.id.verify_view);
        this.f93786c = (VHeadView) r100.findViewById(R.id.iv_gender);
        this.f93787d = (ImageView) r100.findViewById(R.id.living_view);
        this.f93788e = (TextView) r100.findViewById(R.id.tv_nick_name);
        this.f93789f = (TextView) r100.findViewById(R.id.tv_short_id);
        this.f93790g = (TextView) r100.findViewById(R.id.tv_fans_num);
        this.f93791h = r100.findViewById(R.id.invite_container);
        this.f93792i = (HSImageView) r100.findViewById(R.id.iv_invite);
        this.f93793j = (TextView) r100.findViewById(R.id.tv_invite);
        this.f93794k = (TextView) r100.findViewById(R.id.tv_unaccept_invite);
        this.f93797n = (PkTagsContainerView) r100.findViewById(R.id.tags_container);
        this.f93798o = (AnchorLinkInfoView) r100.findViewById(R.id.view_link_info);
        this.f93799p = r100.getContext();
        this.f93800q = com.bytedance.android.live.revlink.impl.global.b.t();
        this.f93801r = com.bytedance.android.live.revlink.impl.global.b.N();
    }
}
