package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/SelectPairRankAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "SelectPairRankItemViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectPairRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.rank.model.c.a> f81011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f81012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectPairRankItemViewHolder.a f81013c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/SelectPairRankAdapter$SelectPairRankItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SelectPairRankItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int f81014j = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f81015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f81016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f81017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f81018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f81019e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f81020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f81021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final HSImageView f81022h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final a f81023i;

        public interface a {
            void a0(IBaseUser r100);
        }

        public static final class b {
        }

        static {
        }

        public SelectPairRankItemViewHolder(View r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "callback");
            super(r100);
            this.f81023i = r101;
            this.f81015a = (TextView) r100.findViewById(R.id.rank_num);
            this.f81016b = (ImageView) r100.findViewById(R.id.user_avatar);
            this.f81017c = (TextView) r100.findViewById(R.id.user_name);
            this.f81018d = (ImageView) r100.findViewById(R.id.honor);
            this.f81019e = (LinearLayout) r100.findViewById(R.id.fans_icon);
            this.f81020f = (TextView) r100.findViewById(R.id.fans_group_name);
            this.f81021g = (TextView) r100.findViewById(R.id.ticket_count);
            this.f81022h = (HSImageView) r100.findViewById(R.id.iv_avatar_border);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f81011a.size();
    }

    public final Context getContext() {
        return this.f81012b;
    }

    public SelectPairRankAdapter(Context r100, SelectPairRankItemViewHolder.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f81012b = r100;
        this.f81013c = r101;
        this.f81011a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "viewHolder");
        if ((r110 instanceof SelectPairRankItemViewHolder) == false) goto L134;
        SelectPairRankItemViewHolder r112 = (SelectPairRankItemViewHolder) r110;
        com.bytedance.android.livesdk.rank.model.c.a r113 = (com.bytedance.android.livesdk.rank.model.c.a) ListProtector.get(this.f81011a, r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        IBaseUser r100 = r113.user;
        TextView r101 = r112.f81015a;
        boolean r102 = true;
        if (r101 == null) goto L18;
        int r103 = r113.rank;
        if (r103 != 1) goto L9;
        int r104 = r112.itemView.getResources().getColor(R.color.ttlive_daily_pair_rank_top_1);
    L16:
        r101.setTextColor(r104);
        r101.setText(String.valueOf(r113.rank));
        goto L18
    L9:
        if (r103 != 2) goto L11;
        r104 = r112.itemView.getResources().getColor(R.color.ttlive_daily_pair_rank_top_2);
        goto L16
    L11:
        if (r103 == 3) goto L13;
        r104 = r112.itemView.getResources().getColor(R.color.ttlive_daily_pair_rank_top_default);
        goto L16
    L13:
        r104 = r112.itemView.getResources().getColor(R.color.ttlive_daily_pair_rank_top_3);
    L18:
        if (r100 == null) goto L20;
        boolean r105 = r100.isFollowing();
    L21:
        String r106 = "";
        if (r105 == true) goto L37;
        if (r100 == null) goto L26;
        String r107 = r100.getIdString();
        if (r107 == null) goto L26;
    L27:
        IMiddlewareUserService r108 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r108 == null) goto L33;
        com.bytedance.android.livesdk.user.e r109 = r108.user();
        if (r109 == null) goto L33;
        String r114 = r109.n();
        if (r114 == null) goto L33;
    L35:
        if ((!Intrinsics.areEqual(r107, r114)) == false) goto L37;
        boolean r115 = true;
    L38:
        ImageView r116 = r112.f81016b;
        py.k r117 = null;
        if (r116 == null) goto L44;
        if (r100 == null) goto L42;
        py.k r118 = r100.getAvatarThumbKt();
    L43:
        a1.x(r116, r118, r116.getWidth(), r116.getHeight(), R.drawable.ttlive_ic_withdraw_default_avatar);
        r116.setVisibility(0);
        r116.setOnClickListener(new y(r112, r100, r115));
        goto L44
    L42:
        r118 = null;
    L44:
        zt0.e r119 = yt0.c.a();
        if (r100 == null) goto L49;
        py.f r120 = r100.getBorder();
        if (r120 == null) goto L49;
        String r121 = r120.getDressId();
    L50:
        com.bytedance.android.live.profit.dress.a r122 = (com.bytedance.android.live.profit.dress.a) r119.getDressData(r121, 1, "SelectPairRankAdapter: bind");
        if (r122 == null) goto L54;
        py.k r123 = r122.f87077a;
        if (r123 == null) goto L54;
    L60:
        if (r123 == null) goto L64;
        HSImageView r124 = r112.f81022h;
        if (r124 == null) goto L67;
        r124.setVisibility(0);
        ImageLoader.bindImage(r124, r123);
    L67:
        TextView r125 = r112.f81017c;
        if (r125 == null) goto L74;
        if (r100 == null) goto L73;
        String r126 = r100.getNickName();
        if (r126 == null) goto L73;
        r106 = r126;
    L73:
        r125.setText(r106);
    L74:
        if (r100 == null) goto L129;
        ImageView r127 = r112.f81018d;
        if (r127 == null) goto L89;
        if (r100.getUserHonor() == null) goto L82;
        py.d r128 = r100.getUserHonor();
        if (r128 == null) goto L82;
        py.k r129 = r128.getNewImIconWithLevel();
    L83:
        if (r129 != null) goto L85;
    L87:
        r127.setVisibility(8);
        goto L89
    L85:
        if (CollectionUtils.isEmpty(r129.getUrls()) == true) goto L87;
        ImageUtil.loadImage(r112.f81018d, r129, new b0(r127));
        r127.setVisibility(0);
    L82:
        r129 = null;
    L89:
        if (r100.getFansClub() != null) goto L96;
        LinearLayout r130 = r112.f81019e;
        if (r130 == null) goto L93;
        r130.setVisibility(8);
    L93:
        TextView r131 = r112.f81020f;
        if (r131 == null) goto L129;
        r131.setVisibility(8);
        goto L129
    L96:
        com.bytedance.android.live.base.model.user.t r132 = r100.getFansClub();
        if (r132 == null) goto L99;
        py.h r133 = r132.getData();
    L100:
        if (r133 == null) goto L104;
        py.u r134 = r133.getBadge();
        if (r134 == null) goto L104;
        r117 = r134.getToShowIcon();
    L104:
        py.h.Companion.getClass();
        if (r133 == null) goto L114;
        String r135 = r133.getClubName();
        if (r135 == null) goto L114;
        if (r135.length() <= 0) goto L111;
        boolean r136 = true;
    L112:
        if (r136 != true) goto L114;
    L115:
        if (r102 == false) goto L123;
        if (r117 == null) goto L123;
        int r137 = a3.f114402d;
        a3.a.a(r112.f81019e, r117, new a0(r112, r133), 0.0f);
        LinearLayout r138 = r112.f81019e;
        if (r138 == null) goto L120;
        r138.setVisibility(0);
    L120:
        TextView r139 = r112.f81020f;
        if (r139 == null) goto L129;
        r139.setVisibility(0);
    L123:
        LinearLayout r140 = r112.f81019e;
        if (r140 == null) goto L126;
        r140.setVisibility(8);
    L126:
        TextView r141 = r112.f81020f;
        if (r141 == null) goto L129;
        r141.setVisibility(8);
        goto L129
    L111:
        r136 = false;
    L114:
        r102 = false;
        goto L115
    L99:
        r133 = null;
    L129:
        TextView r142 = r112.f81021g;
        if (r142 == null) goto L132;
        r142.setText(com.bytedance.android.live.core.utils.x.c(r113.score));
    L132:
        r112.itemView.setOnClickListener(new z(r112, r100));
        return;
    L64:
        HSImageView r143 = r112.f81022h;
        if (r143 == null) goto L67;
        r143.setVisibility(8);
    L54:
        if (r100 == null) goto L58;
        py.f r144 = r100.getBorder();
        if (r144 == null) goto L58;
        r123 = r144.getIcon();
    L58:
        r123 = null;
    L49:
        r121 = null;
    L33:
        r114 = "";
    L26:
        r107 = "";
    L37:
        r115 = false;
        goto L38
    L20:
        r105 = false;
        goto L21
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new SelectPairRankItemViewHolder(LayoutInflater.from(this.f81012b).inflate(R.layout.ttlive_item_video_firend_select_pair_ranklist, r100, false), this.f81013c);
    }
}
