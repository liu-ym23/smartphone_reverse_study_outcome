package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.w0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseBusinessToolItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f84700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f84701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f84702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f84703d;

    public interface a {
        void E(bq0.a r100);

        void g1(bq0.a r100);
    }

    public void T3(final bq0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f84700a.setText(r100.c());
        this.f84701b.setText(r100.f20011a);
        this.f84702c.setImageResource(r100.a());
        this.f84703d.E(r100);
        this.itemView.setOnClickListener(new w0(new BaseBusinessToolItemViewHolder$onBindViewHolder$1(this, r100), 500));
    }

    public BaseBusinessToolItemViewHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "businessToolItemListener");
        super(r100);
        this.f84703d = r101;
        this.f84700a = (TextView) r100.findViewById(R.id.business_tool_title);
        this.f84701b = (TextView) r100.findViewById(R.id.business_tool_description);
        this.f84702c = (ImageView) r100.findViewById(R.id.business_tool_icon);
    }
}
