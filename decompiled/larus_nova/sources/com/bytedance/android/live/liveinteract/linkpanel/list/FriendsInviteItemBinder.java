package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class FriendsInviteItemBinder extends me.drakeet.multitype.b<ILinkPlayerInfoBridge, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f74865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ILinkPlayerInfoBridge, Unit> f74866c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsInviteItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FrameLayout f74867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VHeadView f74868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final VHeadView f74869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f74870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f74871e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final HSImageView f74872f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HSImageView f74873g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final LinearLayout f74874h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f74875i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TextView f74876j;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f74867a = (FrameLayout) r100.findViewById(R.id.img_avatar_panel);
            this.f74868b = (VHeadView) r100.findViewById(R.id.inviter_avatar);
            this.f74869c = (VHeadView) r100.findViewById(R.id.inviter_gender_view);
            this.f74870d = (TextView) r100.findViewById(R.id.btn_invite);
            this.f74871e = (TextView) r100.findViewById(R.id.tv_user_name);
            this.f74872f = (HSImageView) r100.findViewById(R.id.img_rank_top);
            this.f74873g = (HSImageView) r100.findViewById(R.id.img_honor_badge);
            this.f74874h = (LinearLayout) r100.findViewById(R.id.img_fans_panel);
            this.f74875i = (TextView) r100.findViewById(R.id.img_fans_content);
            this.f74876j = (TextView) r100.findViewById(R.id.tv_dou_money);
        }
    }

    public static boolean h(ILinkPlayerInfoBridge r100) {
        int r101 = vm2.d.i();
        if (r100.getLastInvitedTimeMillis() >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r100.getLastInvitedTimeMillis()) > (r101 * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsInviteItemBinder(boolean r100, Function1<? super ILinkPlayerInfoBridge, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onInvite");
        this.f74865b = r100;
        this.f74866c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r110, ILinkPlayerInfoBridge r111) {
        ViewHolder r100 = (ViewHolder) r110;
        final ILinkPlayerInfoBridge r101 = r111;
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "info");
        VHeadView r102 = r100.f74868b;
        IBaseUser r103 = r101.getUser();
        if (r103 == null) goto L5;
        py.k r104 = r103.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r102, r104);
        r100.f74867a.setOnClickListener(x0.a(new FriendsInviteItemBinder$onBindViewHolder$$inlined$apply$lambda$1(this, r101)));
        IBaseUser r105 = r101.getUser();
        if (r105 != null) goto L9;
    L11:
        IBaseUser r106 = r101.getUser();
        if (r106 != null) goto L14;
    L16:
        r100.f74869c.setVisibility(8);
    L17:
        TextView r107 = r100.f74871e;
        IBaseUser r108 = r101.getUser();
        if (r108 == null) goto L20;
        String r109 = r108.getRealNickName();
    L21:
        r107.setText(r109);
        VHeadView r112 = r100.f74869c;
        StringBuilder r113 = new StringBuilder();
        r113.append(s1.B(R.string.ttlive_gender));
        IBaseUser r114 = r101.getUser();
        if (r114 != null) goto L24;
    L26:
        int r115 = R.string.ttlive_gender_female;
    L27:
        r113.append(s1.B(r115));
        r3.a(r112, r113.toString());
        TextView r116 = r100.f74870d;
        if (h(r101) == false) goto L30;
        r116.setText(s1.B(R.string.ttlive_live_interact_invite));
        r116.setBackgroundResource(R.drawable.ttlive_friend_invite_enable);
        r116.setOnClickListener(new h(this, r101));
    L31:
        TextView r117 = r100.f74876j;
        com.bytedance.android.live.liveinteract.plantform.model.i r118 = r101.getInviteListUserInfo();
        if (r118 == null) goto L34;
        String r119 = r118.getLast7DaysGiftCountTxt();
    L35:
        r117.setText(r119);
        IBaseUser r120 = r101.getUser();
        if (r120 == null) goto L40;
        List<py.k> r121 = r120.getBadgeImageListV2();
        if (r121 == null) goto L40;
        List r122 = CollectionsKt.toMutableList(r121);
    L41:
        List r123 = r122;
        if (r123 != null) goto L44;
    L47:
        boolean r124 = true;
    L49:
        if (r124 == false) goto L51;
        LinkedHashMap r125 = new LinkedHashMap();
    L153:
        if (r125.containsKey(23) == false) goto L155;
        ImageUtil.loadImage(r100.f74872f, (py.k) r125.get(23), 0);
        r100.f74872f.setVisibility(0);
        float r126 = 27 + 0.0f;
    L157:
        if (r125.containsKey(1) == false) goto L159;
        ImageUtil.loadImage(r100.f74873g, (py.k) r125.get(1), 0);
        r100.f74873g.setVisibility(0);
        r126 = r126 + 35;
    L161:
        if (r125.containsKey(53) == false) goto L164;
        py.k r127 = (py.k) r125.get(53);
        LinearLayout r128 = r100.f74874h;
        TextView r129 = r100.f74875i;
        r128.setVisibility(0);
        int r130 = a3.f114402d;
        a3.a.a(r128, r127, new g(r129, r127), 0.0f);
        int r131 = 61;
    L169:
        r126 = r126 + r131;
    L172:
        if (r126 <= 0) goto L174;
        r100.f74871e.setMaxWidth(s1.y() - s1.f(162 + r126));
    L174:
        IBaseUser r132 = r101.getUser();
        if (r132 == null) goto L207;
        boolean r133 = !this.f74865b;
        String r134 = r132.getIdString();
        boolean r135 = r101.isActive();
        boolean r136 = h(r101);
        IBaseUser r137 = r101.getUser();
        Intrinsics.checkNotNull(r137);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r133, r134, r135, r136, r137.isSubscriber(), "mutual");
        return;
    L207:
        return;
    L164:
        if (r125.containsKey(52) == false) goto L167;
        py.k r138 = (py.k) r125.get(52);
        LinearLayout r139 = r100.f74874h;
        TextView r140 = r100.f74875i;
        r139.setVisibility(0);
        int r141 = a3.f114402d;
        a3.a.a(r139, r138, new g(r140, r138), 0.0f);
        r131 = 59;
        goto L169
    L167:
        if (r125.containsKey(51) == false) goto L170;
        py.k r142 = (py.k) r125.get(51);
        LinearLayout r143 = r100.f74874h;
        TextView r144 = r100.f74875i;
        r143.setVisibility(0);
        int r145 = a3.f114402d;
        a3.a.a(r143, r142, new g(r144, r142), 0.0f);
        r131 = 50;
        goto L169
    L170:
        r100.f74874h.setVisibility(8);
        goto L172
    L159:
        r100.f74873g.setVisibility(8);
        goto L161
    L155:
        r100.f74872f.setVisibility(8);
        r126 = 0.0f;
        goto L157
    L51:
        List r146 = r122;
        ArrayList r147 = new ArrayList();
        Iterator r148 = r146.iterator();
    L53:
        if (r148.hasNext() == false) goto L67;
        Object r149 = r148.next();
        Integer r150 = ((py.k) r149).getImageType();
        Intrinsics.checkNotNull(r150);
        int r151 = r150.intValue();
        if (r151 == 1) goto L62;
        if (r151 == 23) goto L62;
        if (r151 == 51) goto L62;
        if (r151 == 52) goto L62;
        if (r151 == 53) goto L62;
        boolean r152 = false;
    L64:
        if ((!r152) == false) goto L53;
        r147.add(r149);
    L62:
        r152 = true;
        goto L64
    L67:
        Iterator r153 = r147.iterator();
    L69:
        if (r153.hasNext() == false) goto L71;
        r122.remove((py.k) r153.next());
        goto L69
    L71:
        Iterator r154 = r146.iterator();
    L73:
        if (r154.hasNext() == false) goto L83;
        Object r155 = r154.next();
        Integer r156 = ((py.k) r155).getImageType();
        if (r156 != null) goto L78;
    L80:
        boolean r157 = false;
    L81:
        if (r157 == false) goto L73;
    L85:
        if (r155 == null) goto L106;
        Iterator r158 = r146.iterator();
    L88:
        if (r158.hasNext() == false) goto L98;
        Object r159 = r158.next();
        Integer r160 = ((py.k) r159).getImageType();
        if (r160 != null) goto L93;
    L95:
        boolean r161 = false;
    L96:
        if (r161 == false) goto L88;
    L99:
        py.k r162 = (py.k) r159;
        if (r162 != null) goto L102;
        r162 = null;
    L102:
        if (r123 == null) goto L105;
        TypeIntrinsics.asMutableCollection(r123).remove(r162);
        goto L106
    L105:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L93:
        if (r160.intValue() != 51) goto L95;
        r161 = true;
        goto L96
    L98:
        r159 = null;
    L106:
        Iterator r163 = r146.iterator();
    L108:
        if (r163.hasNext() == false) goto L118;
        Object r164 = r163.next();
        Integer r165 = ((py.k) r164).getImageType();
        if (r165 != null) goto L113;
    L115:
        boolean r166 = false;
    L116:
        if (r166 == false) goto L108;
    L119:
        if (r164 == null) goto L140;
        Iterator r167 = r146.iterator();
    L122:
        if (r167.hasNext() == false) goto L132;
        Object r168 = r167.next();
        Integer r169 = ((py.k) r168).getImageType();
        if (r169 != null) goto L127;
    L129:
        boolean r170 = false;
    L130:
        if (r170 == false) goto L122;
    L133:
        py.k r171 = (py.k) r168;
        if (r171 != null) goto L136;
        r171 = null;
    L136:
        if (r123 == null) goto L139;
        TypeIntrinsics.asMutableCollection(r123).remove(r171);
        goto L140
    L139:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L127:
        if (r169.intValue() != 52) goto L129;
        r170 = true;
        goto L130
    L132:
        r168 = null;
    L140:
        r125 = new LinkedHashMap();
        Iterator r172 = r146.iterator();
    L142:
        if (r172.hasNext() == false) goto L153;
        py.k r173 = (py.k) r172.next();
        List<String> r174 = r173.getUrls();
        if (r174 != null) goto L146;
    L149:
        boolean r175 = true;
    L150:
        if (r175 == true) goto L142;
        Integer r176 = r173.getImageType();
        Intrinsics.checkNotNull(r176);
        r125.put(r176, r173);
        goto L142
    L146:
        if (r174.isEmpty() == true) goto L149;
        r175 = false;
        goto L150
    L113:
        if (r165.intValue() != 53) goto L115;
        r166 = true;
        goto L116
    L118:
        r164 = null;
        goto L119
    L78:
        if (r156.intValue() != 52) goto L80;
        r157 = true;
        goto L81
    L83:
        r155 = null;
        goto L85
    L44:
        if (r123.isEmpty() == true) goto L47;
        r124 = false;
    L40:
        r122 = null;
        goto L41
    L34:
        r119 = null;
        goto L35
    L30:
        r116.setOnClickListener(null);
        r116.setText(s1.B(R.string.ttlive_live_interact_invite_ready));
        r116.setBackgroundResource(R.drawable.ttlive_friend_invite_disable);
        goto L31
    L24:
        if (r114.getGender() != 1) goto L26;
        r115 = R.string.ttlive_gender_male;
        goto L27
    L20:
        r109 = null;
        goto L21
    L14:
        if (r106.getGender() != 2) goto L16;
        r100.f74869c.setImageResource(R.drawable.ttlive_gender_female_icon);
        r100.f74869c.setVisibility(0);
        goto L17
    L9:
        if (r105.getGender() != 1) goto L11;
        r100.f74869c.setImageResource(R.drawable.ttlive_gender_male_icon);
        r100.f74869c.setVisibility(0);
        goto L17
    L5:
        r104 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_talk_invite_friend_item, r101, false));
    }
}
