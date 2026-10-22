package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.locallife.live.view.LiveLifeAtmosphereAnimView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/SimpleGuestApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SimpleGuestApplyViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f75148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f75149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f75150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f75151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f75152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f75153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f75154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n0 f75155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> f75156i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleGuestApplyViewHolder(View r100, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "badgeTypeMap");
        super(r100);
        this.f75156i = r101;
        this.f75148a = (TextView) this.itemView.findViewById(R.id.tv_num);
        this.f75149b = (HSImageView) this.itemView.findViewById(R.id.iv_head);
        this.f75150c = (TextView) this.itemView.findViewById(R.id.tv_name);
        this.f75151d = (TextView) this.itemView.findViewById(R.id.tv_desc);
        this.f75152e = (ConstraintLayout) this.itemView.findViewById(R.id.name_container);
        this.f75153f = (LinearLayout) this.itemView.findViewById(R.id.tag_container);
        this.f75154g = this.itemView.findViewById(R.id.fade_view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.android.live.liveinteract.linkpanel.util.a[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58, types: [com.bytedance.android.live.liveinteract.linkpanel.viewholder.b, java.lang.Object] */
    public final void T3(final n0 r110, final Function1<? super n0, Integer> r210) {
        Intrinsics.checkNotNullParameter(r210, "getItemPosition");
        this.f75155h = r110;
        if (h.U().i() == false) goto L10;
        Integer r100 = b6.B.getValue();
        if (r100 == null) goto L10;
        if (r100.intValue() != 42) goto L10;
        this.f75152e.getViewTreeObserver().addOnPreDrawListener(new c(this));
    L10:
        if (r110 == null) goto L135;
        final IBaseUser r101 = r110.getUserFlex();
        if (r101 == null) goto L136;
        ImageUtil.loadRoundImage(this.f75149b, r101.getAvatarThumbKt());
        int r102 = r210.invoke(r110).intValue();
        TextView r103 = this.f75148a;
        if (r102 < 1000) goto L16;
        String r104 = LiveLifeAtmosphereAnimView.TV_MAX_NUM_FLAMES;
    L19:
        r103.setText(r104);
        this.f75150c.setText(r101.getNickName());
        this.f75153f.removeAllViews();
        g0 r105 = r110.getMicPosTagFlex();
        if (r105 != null) goto L23;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r106 = HighScoreSongBadgeProvider.f75016d;
    L33:
        ?? r111 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[4];
        y r112 = y.f75071c;
        r112.f(r101);
        IRoom r113 = null;
        if (r112.e() == true) goto L37;
        r112 = null;
    L37:
        r111[0] = r112;
        com.bytedance.android.live.liveinteract.linkpanel.util.e r114 = com.bytedance.android.live.liveinteract.linkpanel.util.e.f75034c;
        r114.g(r101);
        if (r114.f() == true) goto L41;
        r114 = null;
    L41:
        r111[1] = r114;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r115 = com.bytedance.android.live.liveinteract.linkpanel.util.d.f75029c;
        r115.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r101, null));
        if (r115.f() == true) goto L45;
        r115 = null;
    L45:
        r111[2] = r115;
        if ((r106 instanceof b) == false) goto L62;
        ?? r107 = (b) r106;
        r107.getClass();
        WeakReference<n0> r116 = new WeakReference(r110);
        b.f75179a = r116;
        n0 r117 = r116.get();
        if (r117 == null) goto L58;
        g0 r118 = r117.getMicPosTagFlex();
        if (r118 == null) goto L58;
        if (r118.getTagType() <= 0) goto L58;
        if (r2.a(r118.getPositionTagName()) == false) goto L58;
        boolean r119 = true;
    L59:
        if (r119 == true) goto L67;
    L66:
        r107 = 0;
    L67:
        r111[3] = r107;
        List r108 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r111));
        int r120 = com.bytedance.android.live.liveinteract.linkpanel.util.b.f75019a;
        Iterator r109 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r108, o.u()).iterator();
    L69:
        if (r109.hasNext() == false) goto L78;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r121 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r109.next();
        View r122 = this.f75156i.get(r121.b());
        if (r122 == null) goto L69;
        if ((r121 instanceof b) == false) goto L76;
        r121.d(r122, new SimpleGuestApplyViewHolder$bindView$$inlined$let$lambda$1(this, r110, r210));
    L77:
        this.f75153f.addView(r122);
        goto L69
    L76:
        r121.d(r122, null);
        goto L77
    L78:
        o.z();
        if (o.z() == false) goto L81;
    L83:
        m<IRoom> r123 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r123 == null) goto L86;
        r113 = r123.getValue();
    L86:
        String r124 = "0";
        if (o.x(r113) == true) goto L89;
    L113:
        Integer r125 = b6.B.getValue();
        if (r125 != null) goto L117;
    L122:
        if (r125 != null) goto L125;
    L127:
        long r126 = 1000;
        this.f75151d.setText(TimeUtils.getTimeDescription(s1.getContext(), r110.getModifyTime() * r126, tc0.c.h().Q * r126));
    L128:
        this.itemView.setOnClickListener(x0.a(new SimpleGuestApplyViewHolder$bindView$$inlined$let$lambda$2(r101, this, r110, r210)));
        return;
    L125:
        if (r125.intValue() != 42) goto L127;
        TextView r127 = this.f75151d;
        StringBuilder r128 = new StringBuilder();
        long r129 = 1000;
        r128.append(TimeUtils.getTimeDescription(s1.getContext(), r110.getModifyTime() * r129, tc0.c.h().Q * r129));
        r128.append(" | ");
        r128.append(r110.getFanTicket());
        r127.setText(r128.toString());
        goto L128
    L117:
        if (r125.intValue() != 41) goto L122;
        TextView r130 = this.f75151d;
        String r131 = r110.getFanTicket();
        if (r131 == null) goto L121;
        r124 = r131;
    L121:
        r130.setText(r124);
        goto L128
    L89:
        if (o.y() == false) goto L113;
        if (r110.isAddPrice() == false) goto L93;
        this.f75151d.setText(o.f(s1.getContext(), r110.getAddPriceTime(), tc0.c.h().Q * ((long) 1000)));
        goto L128
    L93:
        Integer r132 = b6.B.getValue();
        if (r132 != null) goto L97;
    L102:
        TextView r133 = this.f75151d;
        Context r134 = s1.getContext();
        long r135 = 1000;
        long r136 = r110.getModifyTime() * r135;
        long r137 = tc0.c.h().Q * r135;
        Intrinsics.checkNotNullParameter(r134, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r138 = r137 - r136;
        long r139 = 60000;
        if (r138 > r139) goto L105;
        String r140 = r134.getString(R.string.ttlive_paid_just_now);
    L112:
        r133.setText(r140);
        goto L128
    L105:
        long r141 = BaseConstants.Time.HOUR;
        if (r138 > r141) goto L109;
        int r142 = (int) (r138 / r139);
        r140 = r134.getResources().getQuantityString(R.plurals.ttlive_paid_minute, r142, new Object[]{Integer.valueOf(r142)});
        goto L112
    L109:
        if (r138 > 86400000) goto L111;
        int r143 = (int) (r138 / r141);
        r140 = r134.getResources().getQuantityString(R.plurals.ttlive_paid_hour, r143, new Object[]{Integer.valueOf(r143)});
        goto L112
    L111:
        r140 = o.f75051a.format(new Date(r136));
        goto L112
    L97:
        if (r132.intValue() != 41) goto L102;
        TextView r144 = this.f75151d;
        String r145 = r110.getFanTicket();
        if (r145 == null) goto L101;
        r124 = r145;
    L101:
        r144.setText(r124);
        goto L128
    L81:
        if (r110.getPaidAmount() <= 0) goto L83;
        this.f75151d.setText(s1.C(R.string.increase_price_count, new Object[]{Long.valueOf(r110.getPaidAmount())}));
    L58:
        r119 = false;
        goto L59
    L62:
        if ((r106 instanceof HighScoreSongBadgeProvider) == false) goto L66;
        r107 = (HighScoreSongBadgeProvider) r106;
        fc r146 = r110.getUserHighScoreSongTagFlex();
        r107.getClass();
        HighScoreSongBadgeProvider.f75014b = new WeakReference(r146);
        if (r107.e() == false) goto L66;
    L23:
        if (r105.getTagType() <= 0) goto L32;
        String r147 = r105.getPositionTagName();
        if (r147 == null) goto L32;
        if (r147.length() <= 0) goto L29;
        boolean r148 = true;
    L30:
        if (r148 != true) goto L32;
        r106 = b.f75180b;
        goto L33
    L29:
        r148 = false;
    L32:
        r106 = HighScoreSongBadgeProvider.f75016d;
        goto L33
    L16:
        if (r102 != 0) goto L18;
        r104 = "-";
        goto L19
    L18:
        r104 = String.valueOf(r102);
        goto L19
    L136:
        return;
    }
}
