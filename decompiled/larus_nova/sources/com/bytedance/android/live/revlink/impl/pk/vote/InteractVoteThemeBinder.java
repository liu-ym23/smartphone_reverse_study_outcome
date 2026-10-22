package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.j;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class InteractVoteThemeBinder extends me.drakeet.multitype.b<a, InteractVoteThemeHolder> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeBinder$InteractVoteThemeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class InteractVoteThemeHolder extends RecyclerView.ViewHolder implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f97333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f97334b;

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
        public final String G() {
            return String.valueOf(this.f97333a);
        }

        public InteractVoteThemeHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f97334b = "";
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
        public final void N(String r100) {
            Intrinsics.checkNotNullParameter(r100, "panelType");
            HashMap r101 = new HashMap();
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L5;
            String r102 = "2";
        L14:
            r101.put("anchor_connect_status", r102);
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L17;
            String r103 = "pk_participate";
        L18:
            r101.put("source", r103);
            r101.put("theme", this.f97334b);
            int r104 = UserListInviteType.f70864a;
            LinkCrossRoomDataHolder r105 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r105 == null) goto L21;
            int r106 = r105.f();
        L22:
            r101.put("invitee_list", UserListInviteType.a(r106, null));
            n r107 = new n();
            Map<String, String> r108 = r107.f516447a;
            Intrinsics.checkNotNullParameter(r108, "map");
            Intrinsics.checkNotNullParameter(r101, "map");
            r108.putAll(r101);
            m r109 = new m();
            LinkCrossRoomDataHolder.a r110 = LinkCrossRoomDataHolder.f92004c;
            com.bytedance.android.live.revlink.impl.a.b(r109);
            r109.b(LogCommon.ROOM);
            List<Object> r111 = r107.f516448b;
            ArrayList r112 = (ArrayList) r111;
            r112.addAll(r109.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r113 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r114);
            ((mz0.i) ((f80.a) r114)).w3("livesdk_vote_theme_show", r107.f516447a, r107.f516448b);
            return;
        L21:
            r106 = 0;
            goto L22
        L17:
            r103 = "link_participate";
            goto L18
        L5:
            com.bytedance.android.live.revlink.impl.multianchor.service.d r115 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r115 == null) goto L13;
            i11.b r116 = r115.getLinkUserCenter();
            if (r116 == null) goto L13;
            List<p> r117 = r116.getOnlineUserList();
            if (r117 == null) goto L13;
            r102 = String.valueOf(r117.size());
            if (r102 != null) goto L14;
        L13:
            r102 = "";
            goto L14
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f97335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f97336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f97337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f97338d;

        public a() {
            this(0, null, false, null);
        }

        public a(long r100, String r101, boolean r102, b r103) {
            this.f97335a = r100;
            this.f97336b = r101;
            this.f97337c = r102;
            this.f97338d = r103;
        }
    }

    public interface b {
        void s80(InteractVoteStartDialog.b r100);
    }

    public InteractVoteThemeBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        InteractVoteThemeHolder r102 = (InteractVoteThemeHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f97333a = r103.f97335a;
        String r104 = r103.f97336b;
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r102.f97334b = r104;
        TextView r106 = (TextView) r102.itemView.findViewById(R.id.tv_theme);
        String r107 = r103.f97336b;
        if (r107 == null) goto L8;
        r105 = r107;
    L8:
        r106.setText(r105);
        ImageView r108 = (ImageView) r102.itemView.findViewById(R.id.iv_select);
        if (r103.f97337c == false) goto L11;
        int r109 = 0;
    L12:
        r108.setVisibility(r109);
        r102.itemView.setOnClickListener(new g(r103));
        return;
    L11:
        r109 = 8;
        goto L12
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new InteractVoteThemeHolder(r100.inflate(R.layout.ttlive_item_interact_vote_theme, r101, false));
    }
}
