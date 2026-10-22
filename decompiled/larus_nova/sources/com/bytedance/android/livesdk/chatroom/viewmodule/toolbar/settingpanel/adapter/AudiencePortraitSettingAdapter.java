package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.BaseSettingHolder;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.SettingNormalHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import np1.b;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/adapter/AudiencePortraitSettingAdapter;", "Lnp1/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/holder/BaseSettingHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitSettingAdapter<T extends b> extends RecyclerView.Adapter<BaseSettingHolder<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends T> f116714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f116715b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f116714a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((b) ListProtector.get(this.f116714a, r100)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BaseSettingHolder r101 = (BaseSettingHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.U3();
    }

    public AudiencePortraitSettingAdapter(List<? extends T> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        this.f116714a = r100;
        this.f116715b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseSettingHolder r102 = (BaseSettingHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((b) ListProtector.get(this.f116714a, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L5;
        SettingNormalHolder r102 = new SettingNormalHolder(r100);
    L6:
        View r103 = r102.itemView;
        if (this.f116715b == false) goto L9;
        r103.setBackgroundResource(R.drawable.ttlive_bg_play_opt_item_new);
        a1.m(r103, (int) UtilityKotlinExtentionsKt.h(16.0f));
        a1.n(r103, UtilityKotlinExtentionsKt.i(16));
    L10:
        return r102;
    L9:
        r103.setBackgroundColor(0);
        goto L10
    L5:
        r102 = new SettingNormalHolder(r100);
        goto L6
    }
}
