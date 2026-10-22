package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/SimplePkGuestApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimplePkGuestApplyViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f82080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f82081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f82082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f82083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<dl0.c, View> f82084e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimplePkGuestApplyViewHolder(View r100, Map<dl0.c, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "badgeTypeMap");
        super(r100);
        this.f82084e = r101;
        this.f82080a = (TextView) this.itemView.findViewById(R.id.tv_num);
        this.f82081b = (HSImageView) this.itemView.findViewById(R.id.iv_head);
        this.f82082c = (TextView) this.itemView.findViewById(R.id.tv_name);
        this.f82083d = (LinearLayout) this.itemView.findViewById(R.id.name_container);
    }
}
