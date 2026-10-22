package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.MicPanelType;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/adapter/AdjustGuestPositionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/videotalk/adapter/AdjustGuestPositionViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdjustGuestPositionListAdapter extends RecyclerView.Adapter<AdjustGuestPositionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f79042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<c0> f79043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f79045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c0 f79046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<c0> f79047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79048h;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79043c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AdjustGuestPositionViewHolder r102 = (AdjustGuestPositionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "vh");
        c0 r103 = (c0) ListProtector.get(this.f79043c, r101);
        boolean r104 = false;
        ViewGroup.LayoutParams r105 = null;
        if (r103.getEnable() == true) goto L22;
        ArrayList<c0> r106 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
        if (this.f79041a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L10;
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_common_prohibited_icon);
        r102.f79049a.setBackgroundResource(R.drawable.ttlive_adjust_position_common_prohibit_bg);
    L11:
        Integer r107 = je0.d.h();
        if (r107 != null) goto L15;
    L49:
        r102.f79050b.setOnClickListener(new a(this, r101));
        return;
    L15:
        if (r107.intValue() != 28) goto L49;
        if (r101 != 0) goto L49;
        r102.f79049a.setBackgroundResource(R.drawable.ttlive_adjust_position_common_prohibit_bg);
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_audio_hamlet_avatar_prohibited_bg);
        ImageView r108 = r102.f79050b;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L20;
        r109.width = UtilityKotlinExtentionsKt.i(36);
        r109.height = UtilityKotlinExtentionsKt.i(36);
        Unit r110 = Unit.INSTANCE;
        r105 = r109;
    L20:
        r108.setLayoutParams(r105);
        goto L49
    L10:
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_audio_prohibited_bg);
        goto L11
    L22:
        if (this.f79044d != r101) goto L30;
        ArrayList<c0> r111 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
        if (this.f79041a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L26;
        r104 = true;
    L26:
        if (r104 == false) goto L28;
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_common_online_icon);
        r102.f79049a.setBackgroundResource(R.drawable.ttlive_adjust_position_common_online_bg);
    L37:
        Integer r112 = je0.d.h();
        if (r112 == null) goto L49;
        if (r112.intValue() != 28) goto L49;
        ImageView r113 = r102.f79050b;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof ConstraintLayout.LayoutParams) == true) goto L45;
        r114 = null;
    L45:
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        if (r115 == null) goto L48;
        r115.matchConstraintPercentWidth = 1.0f;
        r115.matchConstraintPercentHeight = 1.0f;
        Unit r116 = Unit.INSTANCE;
        r105 = r115;
    L48:
        r113.setLayoutParams(r105);
        goto L49
    L28:
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_audio_online_bg);
        goto L37
    L30:
        if (r103.getEnable() != true) goto L37;
        ArrayList<c0> r117 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
        if (this.f79041a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L34;
        r104 = true;
    L34:
        if (r104 == false) goto L36;
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_common_offline_icon);
        r102.f79049a.setBackgroundResource(R.drawable.ttlive_adjust_position_common_offline_bg);
        goto L37
    L36:
        r102.f79050b.setImageResource(R.drawable.ttlive_adjust_position_audio_offline_bg);
        goto L37
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ArrayList<c0> r102 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
        if (this.f79041a != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return new AdjustGuestPositionViewHolder(this.f79042b.inflate(R.layout.ttlive_live_video_common_adjust_position_panel_item, r100, false));
    L9:
        if (this.f79048h != 30) goto L12;
        return new AdjustGuestPositionViewHolder(this.f79042b.inflate(R.layout.ttlive_live_audio_stage_enlarge_adjust_position_panel_item, r100, false));
    L12:
        return new AdjustGuestPositionViewHolder(this.f79042b.inflate(R.layout.ttlive_live_audio_common_adjust_position_panel_item, r100, false));
    L5:
        r103 = false;
        goto L6
    }

    public AdjustGuestPositionListAdapter(Context r100, int r101, ArrayList<c0> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "list");
        this.f79047g = r102;
        this.f79048h = r103;
        this.f79041a = r101;
        this.f79042b = LayoutInflater.from(r100);
        this.f79043c = r102;
    }
}
