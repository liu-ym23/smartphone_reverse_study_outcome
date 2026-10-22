package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bq0.a;
import bq0.c;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/PrivateMsgItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivateMsgItemViewHolder extends BaseBusinessToolItemViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f84704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f84705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f84706g;

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder
    public final void T3(a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.T3(r100);
        if ((r100 instanceof c) == false) goto L9;
        this.f84704e.setVisibility(0);
        if (((c) r100).f20019f == false) goto L7;
        this.f84705f.setImageResource(R.drawable.ttlive_mini_app_business_tool_enable_icon);
        this.f84706g.setText(s1.B(R.string.ttlive_mini_app_business_tool_enable));
        return;
    L7:
        this.f84705f.setImageResource(R.drawable.ttlive_mini_app_business_tool_disable_icon);
        this.f84706g.setText(s1.B(R.string.ttlive_mini_app_business_tool_disable));
        return;
    }

    public PrivateMsgItemViewHolder(View r100, BaseBusinessToolItemViewHolder.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "businessToolItemListener");
        super(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.business_tool_enable_status_container);
        this.f84704e = r102;
        this.f84705f = (ImageView) r102.findViewById(R.id.business_tool_enable_status_icon);
        this.f84706g = (TextView) r102.findViewById(R.id.business_tool_enable_status_text);
    }
}
