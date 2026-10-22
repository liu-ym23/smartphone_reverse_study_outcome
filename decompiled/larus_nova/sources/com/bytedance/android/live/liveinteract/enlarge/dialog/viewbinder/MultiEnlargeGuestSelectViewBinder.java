package com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiEnlargeGuestSelectViewBinder extends me.drakeet.multitype.b<b, ItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f72782c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/viewbinder/MultiEnlargeGuestSelectViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f72783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HSImageView f72784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f72785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f72786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f72787e;

        public ItemViewHolder(View r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "selectedListener");
            super(r100);
            this.f72787e = r101;
            this.f72784b = (HSImageView) r100.findViewById(R.id.enlarge_avatar_iv);
            this.f72785c = (TextView) r100.findViewById(R.id.enlarge_nickname_tv);
            this.f72786d = r100.findViewById(R.id.selected_flag);
            r100.setOnClickListener(x0.a(new AnonymousClass1(this)));
        }
    }

    public interface a {
        void onSelected(String r100, boolean r101);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f72788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ILinkPlayerInfoBridge f72789b;

        public b(boolean r100, ILinkPlayerInfoBridge r101) {
            Intrinsics.checkNotNullParameter(r101, "playerInfo");
            this.f72788a = r100;
            this.f72789b = r101;
        }
    }

    public MultiEnlargeGuestSelectViewBinder(a r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedListener");
        this.f72781b = 4;
        this.f72782c = r100;
    }

    public static void h(ItemViewHolder r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.f72783a = r101;
        HSImageView r102 = r100.f72784b;
        IBaseUser r103 = r101.f72789b.getUser();
        if (r103 == null) goto L5;
        k r104 = r103.getAvatarMedium();
    L6:
        ImageUtil.loadRoundImage(r102, r104);
        TextView r105 = r100.f72785c;
        IBaseUser r106 = r101.f72789b.getUser();
        if (r106 == null) goto L10;
        String r107 = r106.getNickName();
        if (r107 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r107, "content");
        int r108 = 0;
        if (r107.length() <= 4) goto L14;
        r107 = r107.substring(0, 4) + "...";
    L14:
        r105.setText(r107);
        View r109 = r100.f72786d;
        if (r101.f72788a == true) goto L18;
        r108 = 8;
    L18:
        r109.setVisibility(r108);
        return;
    L10:
        r107 = "";
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, b r101) {
        h((ItemViewHolder) r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        ItemViewHolder r102 = new ItemViewHolder(r100.inflate(R.layout.ttlive_dialog_multi_enlarge_select_item_view_s40, r101, false), this.f72782c);
        int r103 = (s1.y() - s1.f(32.0f)) / this.f72781b;
        int r104 = s1.f(96.0f);
        r102.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, r104));
        return r102;
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, b r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        b r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.size() != 0) goto L5;
        h(r103, r104);
        return;
    L5:
        Iterator r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L52;
        Object r106 = r105.next();
        if ((r106 instanceof Bundle) == true) goto L11;
        r106 = null;
    L11:
        Bundle r107 = (Bundle) r106;
        if (r107 == null) goto L7;
        if (r107.size() == 0) goto L15;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r107, WsConstants.KEY_PAYLOAD);
        r103.f72783a = r104;
        Iterator<String> r108 = r107.keySet().iterator();
    L18:
        if (r108.hasNext() == false) goto L7;
        String r109 = r108.next();
        if (r109 == null) goto L18;
        if (r109.hashCode() != 1486694307) goto L18;
        if (r109.equals("payload_key_guest_selected_state_update") == false) goto L18;
        boolean r110 = r107.getBoolean(r109);
        b r111 = r103.f72783a;
        if (r111 == null) goto L30;
        r111.f72788a = r110;
    L30:
        View r112 = r103.f72786d;
        if (r110 == false) goto L33;
        int r113 = 0;
    L34:
        r112.setVisibility(r113);
        goto L18
    L33:
        r113 = 8;
        goto L34
    L15:
        h(r103, r104);
        goto L7
    }
}
