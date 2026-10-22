package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes9.dex */
public final class ChannelTrayListViewBinder extends b<p62.a, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f134400b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChannelTrayListViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatChannelAvatarView f134401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f134402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FrameLayout f134403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f134404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f134405e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f134406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ChatChannelAvatarView f134407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RoundCornerImageView f134408h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f134409i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final a f134410j;

        public ItemViewHolder(View r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "clickListener");
            super(r100);
            this.f134410j = r101;
            this.f134401a = (ChatChannelAvatarView) r100.findViewById(R.id.selected_avatar);
            this.f134402b = (LinearLayout) r100.findViewById(R.id.current_channel_tray_selected);
            this.f134403c = (FrameLayout) r100.findViewById(R.id.tray_unselected);
            this.f134404d = (TextView) r100.findViewById(R.id.channel_title);
            this.f134405e = (LinearLayout) r100.findViewById(R.id.total_count_container);
            this.f134406f = (TextView) r100.findViewById(R.id.total_count_number);
            this.f134407g = (ChatChannelAvatarView) r100.findViewById(R.id.unselected_avatar);
            this.f134408h = (RoundCornerImageView) r100.findViewById(R.id.red_dot);
            IUserService r102 = (IUserService) k.f(IUserService.class);
            if (r102 == null) goto L7;
            f r103 = r102.user();
            if (r103 == null) goto L7;
            String r104 = r103.n();
        L8:
            this.f134409i = r104;
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public interface a {
        void a(p62.a r100);
    }

    public ChannelTrayListViewBinder(r62.a r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.f134400b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, p62.a r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        p62.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        Intrinsics.checkNotNullParameter(r103, "chatChannelTrayInfo");
        boolean r104 = r103.f527876k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "trayInfo");
        r102.f134402b.setImportantForAccessibility(4);
        r102.itemView.setOnClickListener(new com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.a(r102, r103));
        ArrayList r105 = new ArrayList();
        StringBuilder r106 = new StringBuilder("trayInfo.channelName = ");
        r106.append(r103.f527871f);
        r106.append("  trayInfo.channelAvatarThumb.size = ");
        List<? extends py.k> r107 = r103.f527872g;
        ImageModel r108 = null;
        if (r107 == null) goto L5;
        Integer r109 = Integer.valueOf(r107.size());
    L6:
        r106.append(r109);
        ALogger.i("ChannelTrayListViewBinder", r106.toString());
        if (r103.f527866a == false) goto L26;
        SecretChatInfo r110 = r103.f527867b;
        if (r110 != null) goto L11;
    L17:
        if (r108 == null) goto L19;
        r105.add(r108);
    L40:
        if (r104 == false) goto L46;
        r102.f134404d.setText(r103.f527871f);
        r102.f134401a.setAvatarData(r105);
        if (r103.f527866a == false) goto L44;
        UtilityKotlinExtentionsKt.t(r102.f134405e);
    L45:
        UtilityKotlinExtentionsKt.w(r102.f134402b);
        UtilityKotlinExtentionsKt.t(r102.f134403c);
    L50:
        TextView r111 = r102.f134404d;
        if (r111 == null) goto L53;
        r111.requestFocus();
    L53:
        TextView r112 = r102.f134404d;
        if (r112 == null) goto L67;
        r112.setSelected(true);
        return;
    L67:
        return;
    L44:
        UtilityKotlinExtentionsKt.w(r102.f134405e);
        r102.f134406f.setText(String.valueOf(r103.f527873h));
        goto L45
    L46:
        r102.f134407g.setAvatarData(r105);
        UtilityKotlinExtentionsKt.t(r102.f134402b);
        UtilityKotlinExtentionsKt.w(r102.f134403c);
        if (r103.f527877l == false) goto L49;
        UtilityKotlinExtentionsKt.w(r102.f134408h);
        goto L50
    L49:
        UtilityKotlinExtentionsKt.t(r102.f134408h);
        goto L50
    L19:
        List r113 = CollectionsKt.take(r103.f527869d, 2);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L21:
        if (r115.hasNext() == false) goto L25;
        ImageModel r116 = ((User) r115.next()).getAvatarThumb();
        if (r116 == null) goto L21;
        r114.add(r116);
        goto L21
    L25:
        r105.addAll(r114);
        goto L40
    L11:
        if (Intrinsics.areEqual(String.valueOf(r110.getOwnerUid()), r102.f134409i) == false) goto L13;
        long r117 = r110.getGuestUid();
    L14:
        Map<Long, ImageModel> r118 = r110.getUserAvatarList();
        if (r118 == null) goto L17;
        r108 = r118.get(Long.valueOf(r117));
        goto L17
    L13:
        r117 = r110.getOwnerUid();
        goto L14
    L26:
        List<? extends py.k> r119 = r103.f527872g;
        if (r119 == null) goto L33;
        Intrinsics.checkNotNull(r119);
        if (r119.size() <= 0) goto L33;
        List<? extends py.k> r120 = r103.f527872g;
        if (r120 == null) goto L40;
        r105.addAll(r120);
    L33:
        List r121 = CollectionsKt.take(r103.f527869d, 2);
        ArrayList r122 = new ArrayList();
        Iterator r123 = r121.iterator();
    L35:
        if (r123.hasNext() == false) goto L39;
        ImageModel r124 = ((User) r123.next()).getAvatarThumb();
        if (r124 == null) goto L35;
        r122.add(r124);
        goto L35
    L39:
        r105.addAll(r122);
        goto L40
    L5:
        r109 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ItemViewHolder(r100.inflate(R.layout.ttlive_chat_channel_item_v2, r101, false), this.f134400b);
    }
}
