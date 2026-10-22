package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarViewHolder;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonStackAvatarAdapter extends RecyclerView.Adapter<KtvCommonStackAvatarViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f144135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f144136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<py.k> f144137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f144138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f144139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f144140f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f144137c).size();
    }

    public KtvCommonStackAvatarAdapter() {
        this.f144135a = "scene_ktv_component";
        this.f144136b = s1.f(3.0f);
        this.f144137c = new ArrayList();
        this.f144139e = "0";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (Intrinsics.areEqual(this.f144135a, "scene_video_chorus_top_control") == true) goto L18;
        if (Intrinsics.areEqual(this.f144135a, "scene_video_chorus_ordered_list") == true) goto L18;
        int r101 = this.f144138d;
        int r102 = this.f144140f;
        if (r101 >= r102) goto L11;
    L9:
        return 0;
    L11:
        if (r100 != (r102 - 1)) goto L14;
        return 2;
    L14:
        if (r100 != (r102 - 2)) goto L9;
        return 1;
    L18:
        if (r100 == (this.f144140f - 1)) goto L24;
        return 0;
    L24:
        return 2;
    }

    public static void y2(View r100, int r101) {
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r102).setMargins(r101, 0, 0, 0);
        r100.requestLayout();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        KtvCommonStackAvatarViewHolder r101 = (KtvCommonStackAvatarViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        int r102 = ((ArrayList) this.f144137c).size();
        if (r110 < 0) goto L45;
        if (r102 <= r110) goto L42;
        py.k r103 = (py.k) ListProtector.get(this.f144137c, r110);
        int r104 = this.f144138d;
        String r105 = this.f144139e;
        String r106 = this.f144135a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r105, "totalCountStr");
        Intrinsics.checkNotNullParameter(r106, "scene");
        r101.f144145c = r103;
        HSImageView r107 = (HSImageView) r101.f144143a.getValue();
        if (r107 == null) goto L10;
        ImageUtil.loadRoundImage(r107, r103);
    L10:
        if (Intrinsics.areEqual(r106, "scene_video_chorus_top_control") == false) goto L12;
    L15:
        int r108 = R.string.ttlive_ktv_video_chorus_total_count_tips;
    L17:
        if (Intrinsics.areEqual(r106, "scene_video_chorus_top_control") == false) goto L19;
    L24:
        TextView r109 = (TextView) r101.f144144b.getValue();
        if (r109 == null) goto L28;
        r109.setText(s1.C(r108, new Object[]{r105}));
    L28:
        if (Intrinsics.areEqual(r106, "scene_video_chorus_ordered_list") == false) goto L32;
        TextView r111 = (TextView) r101.f144144b.getValue();
        if (r111 == null) goto L35;
        r111.setTextColor(ColorProtector.parseColor("#898A8F"));
    L35:
        if (r110 != 0) goto L38;
        y2(r101.itemView, 0);
        return;
    L38:
        if (r110 != (this.f144140f - 1)) goto L40;
        y2(r101.itemView, this.f144136b);
        return;
    L40:
        y2(r101.itemView, -this.f144136b);
        return;
    L32:
        TextView r112 = (TextView) r101.f144144b.getValue();
        if (r112 == null) goto L35;
        r112.setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L35
    L19:
        if (Intrinsics.areEqual(r106, "scene_video_chorus_ordered_list") == true) goto L24;
        TextView r113 = (TextView) r101.f144144b.getValue();
        if (r113 == null) goto L28;
        r113.setText(s1.C(r108, new Object[]{Integer.valueOf(r104)}));
        goto L28
    L12:
        if (Intrinsics.areEqual(r106, "scene_video_chorus_ordered_list") == true) goto L15;
        r108 = R.string.ttlive_ktv_multi_chorus_total_count_tips;
        goto L17
    L42:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 0) goto L6;
        int r103 = R.layout.ttlive_ktv_user_avatar_item_content;
    L13:
        return new KtvCommonStackAvatarViewHolder(r102.inflate(r103, r100, false));
    L6:
        if (r101 != 1) goto L9;
        r103 = R.layout.ttlive_ktv_user_avatar_item_more;
        goto L13
    L9:
        if (r101 != 2) goto L11;
        r103 = R.layout.ttlive_ktv_user_avatar_item_tail;
        goto L13
    L11:
        r103 = 0;
        goto L13
    }
}
