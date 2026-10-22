package com.bytedance.android.live.liveinteract.linkpanel.list;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class InviteMoreItemBinder extends me.drakeet.multitype.b<l, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f74893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f74894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f74895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f74896e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/InviteMoreItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, l r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (this.f74894c != 4) goto L5;
        View r103 = r102.itemView;
        r103.setPadding(r103.getPaddingLeft(), UtilityKotlinExtentionsKt.i(10), r103.getPaddingRight(), r103.getPaddingBottom());
        HashMap r104 = new HashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r104);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r104, null, 6);
        r104.put("request_page", "invite");
        Pair<String, String> r105 = com.bytedance.android.live.liveinteract.linkpanel.util.m.e();
        r104.put(r105.getFirst(), r105.getSecond());
        j0.l().sendLog("livesdk_anchor_invite_user_button_show", r104, new Object[]{IRoom.class, x.class});
    L5:
        boolean r106 = this.f74895d;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.m.h() == true) goto L12;
        HashMap r107 = new HashMap();
        if (r106 == false) goto L10;
        String r108 = "voice_live";
    L11:
        r107.put("live_type", r108);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r107, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.H(r107, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.L("livesdk_audience_invite_user_button_show", r107, new Object[0]);
        goto L12
    L10:
        r108 = "video_live";
    L12:
        r102.itemView.setOnClickListener(new n(this));
        if (this.f74893b == true) goto L16;
        this.f74893b = true;
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_item_talk_invite_more_friends, r101, false));
    }

    public InviteMoreItemBinder(int r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f74894c = r100;
        this.f74895d = r101;
        this.f74896e = r102;
    }
}
