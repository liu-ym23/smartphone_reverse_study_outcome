package com.bytedance.android.livesdk.drawer;

import am2.x;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import df6.q;
import df6.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMergeDrawerAdapter extends RecyclerView.Adapter<LiveMergeDrawerViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f122354i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Room> f122355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f122356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f122357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f122358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f122359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f122360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CenterScrollLayoutManager f122361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MergeDrawerViewModel f122362h;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f122355a).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        LiveMergeDrawerViewHolder r101 = (LiveMergeDrawerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.getClass();
        o r102 = u.l().c(x.class);
        String r103 = "";
        if (r102 == null) goto L8;
        Map<String, String> r104 = r102.getMap();
        if (r104 == null) goto L8;
        String r105 = r104.get("enter_from_merge");
        if (r105 == null) goto L8;
    L10:
        if (r102 == null) goto L15;
        Map<String, String> r106 = r102.getMap();
        if (r106 == null) goto L15;
        String r107 = r106.get("enter_method");
        if (r107 == null) goto L15;
    L16:
        LinkedHashMap r108 = new LinkedHashMap();
        Room r109 = r101.f122384f;
        if (r109 == null) goto L22;
        User r110 = r109.mo8271getOwner();
        if (r110 == null) goto L22;
        String r111 = r110.getIdString();
        if (r111 == null) goto L22;
    L23:
        r108.put("anchor_id", r111);
        Room r112 = r101.f122384f;
        if (r112 == null) goto L27;
        String r113 = r112.getIdStr();
        if (r113 == null) goto L27;
    L28:
        r108.put("room_id", r113);
        r108.put("enter_from_merge", r105);
        r108.put("enter_method", r107);
        MergeDrawerViewModel r114 = r101.f122385g;
        if (r114 != null) goto L31;
    L33:
        r108.put("action_type", "click");
        Room r115 = r101.f122384f;
        if (r115 == null) goto L38;
        String r116 = r115.getRequestId();
        if (r116 == null) goto L38;
    L39:
        r108.put("request_id", r116);
        Room r117 = r101.f122384f;
        if (r117 == null) goto L45;
        String r118 = r117.getLog_pb();
        if (r118 == null) goto L45;
        r103 = r118;
    L45:
        r108.put("log_pb", r103);
        u.l().sendLog("livesdk_live_show", r108, new Object[0]);
        u.l().sendLog("livesdk_live_cover_info", r108, new Object[0]);
        return;
    L38:
        r116 = "";
        goto L39
    L31:
        if (r114.isSimilarRoom() != true) goto L33;
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR, "1");
    L27:
        r113 = "";
    L22:
        r111 = "";
    L15:
        r107 = "";
    L8:
        r105 = "";
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        LiveMergeDrawerViewHolder r102 = (LiveMergeDrawerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Room r103 = (Room) ListProtector.get(this.f122355a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "room");
        r102.f122384f = r103;
        q.b(new r(new r.a(s1.getContext())));
        r102.f122382d.setText(r103.getTitle());
        TextView r104 = r102.f122383e;
        StringBuilder r105 = new StringBuilder("@");
        User r106 = r103.mo8271getOwner();
        List<String> r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.getRemarkNameOrRealNickName();
    L6:
        r105.append(r108);
        r104.setText(r105.toString());
        r102.f122380b.setVisibility(8);
        k r109 = r103.getCover();
        if (r109 == null) goto L9;
        r107 = r109.getUrls();
    L9:
        df6.u r110 = q.c(new ef6.a(r107));
        r110.f468294t = r102.f122379a;
        r110.c();
        UtilityKotlinExtentionsKt.t(r102.f122381c);
        UtilityKotlinExtentionsKt.t(r102.f122380b);
        r102.f122381c.pauseAnimation();
        r102.f122385g = this.f122362h;
        if (r101 != this.f122356b) goto L13;
        r102.T3();
        return;
    L13:
        return;
    L5:
        r108 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = LiveMergeDrawerViewHolder.f122378h;
        Intrinsics.checkNotNullParameter(r100, "parent");
        LiveMergeDrawerViewHolder r103 = new LiveMergeDrawerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_dialog_merge_drawer_viewholder, r100, false));
        r103.f122379a.setOnClickListener(new ut1.o(r103, this));
        return r103;
    }

    public LiveMergeDrawerAdapter(FadingEdgeRecyclerview r100, CenterScrollLayoutManager r101, MergeDrawerViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "layoutManager");
        this.f122360f = r100;
        this.f122361g = r101;
        this.f122362h = r102;
        this.f122355a = new ArrayList();
        this.f122356b = -1;
        this.f122357c = -1;
        this.f122358d = 135.0f;
    }
}
