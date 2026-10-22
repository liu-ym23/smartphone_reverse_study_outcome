package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/ApplyUserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ApplyUserItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f142639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f142640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f142641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f142642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f142643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f142644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f142645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f142646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f142647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f142648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f142649k;

    public static final class a {
    }

    static {
    }

    public static String T3(com.bytedance.android.live.ktv.common.model.bean.d r100) {
        int r101 = (int) r100.e();
        String r102 = r100.a();
        String r103 = "";
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r101 <= 1) goto L12;
        String r104 = r100.c();
        if (r104.length() <= 7) goto L11;
        r104 = r104.substring(0, 7) + "...";
    L11:
        return s1.C(R.string.ttlive_ktv_component_apply_list_more_than_one, new Object[]{r104, Integer.valueOf(r101), r102});
    L12:
        if (r101 != 1) goto L15;
        r103 = r100.c();
    L15:
        if (r103.length() <= 7) goto L18;
        r103 = r103.substring(0, 6) + "...";
    L18:
        return s1.C(R.string.ttlive_ktv_component_apply_list_one, new Object[]{r103, r102});
    }

    public ApplyUserItemViewHolder(final View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f142649k = r101;
        this.f142639a = LazyKt.lazy(new ApplyUserItemViewHolder$avatarView$2(r100));
        this.f142640b = LazyKt.lazy(new ApplyUserItemViewHolder$genderView$2(r100));
        Lazy r102 = LazyKt.lazy(new ApplyUserItemViewHolder$nickNameView$2(r100));
        this.f142641c = r102;
        this.f142642d = LazyKt.lazy(new ApplyUserItemViewHolder$highScoreLayout$2(r100));
        this.f142643e = LazyKt.lazy(new ApplyUserItemViewHolder$ivHighScoreIcon$2(r100));
        this.f142644f = LazyKt.lazy(new ApplyUserItemViewHolder$tvHighScore$2(r100));
        Lazy r103 = LazyKt.lazy(new ApplyUserItemViewHolder$microphoneIcon$2(r100));
        this.f142645g = r103;
        Lazy r104 = LazyKt.lazy(new ApplyUserItemViewHolder$musicAndApplyTimeTv$2(r100));
        this.f142646h = r104;
        this.f142647i = LazyKt.lazy(new ApplyUserItemViewHolder$btnAccept$2(r100));
        Lazy r105 = LazyKt.lazy(new ApplyUserItemViewHolder$removeBtn$2(r100));
        this.f142648j = r105;
        TextView r106 = (TextView) r102.getValue();
        if (r106 == null) goto L5;
        KtvOrderSongThemeManager.d(r106, KtvOrderSongThemeManager.G);
    L5:
        TextView r107 = (TextView) r104.getValue();
        if (r107 == null) goto L8;
        KtvOrderSongThemeManager.d(r107, KtvOrderSongThemeManager.H);
    L8:
        ImageView r108 = (ImageView) r103.getValue();
        if (r108 == null) goto L11;
        KtvOrderSongThemeManager.c(r108, KtvOrderSongThemeManager.I);
    L11:
        ImageView r109 = (ImageView) r105.getValue();
        if (r109 == null) goto L15;
        KtvOrderSongThemeManager.c(r109, KtvOrderSongThemeManager.f70191J);
        return;
    }
}
