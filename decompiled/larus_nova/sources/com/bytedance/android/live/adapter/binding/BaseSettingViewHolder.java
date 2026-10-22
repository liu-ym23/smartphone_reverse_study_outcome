package com.bytedance.android.live.adapter.binding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.nc;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mx.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/adapter/binding/BaseSettingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSettingViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f58542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f58543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f58544c;

    public BaseSettingViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f58542a = (TextView) r100.findViewById(R.id.tv_switch_title);
        this.f58543b = (TextView) r100.findViewById(R.id.tv_switch_description);
        this.f58544c = (ImageView) r100.findViewById(R.id.red_dot);
    }

    public final void T3(a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f58542a.setText(r100.f516129e);
        this.f58543b.setText(r100.f516130f);
        TextView r101 = this.f58543b;
        int r102 = 0;
        if (r100.f516130f.length() <= 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        int r104 = 0;
    L10:
        r101.setVisibility(r104);
        if (nc.f120820a.getValue().booleanValue() == false) goto L19;
        Long r105 = r100.f516135k;
        if (r105 == null) goto L15;
        long r106 = r105.longValue();
    L17:
        if (((int) r106) != 3) goto L19;
        this.f58544c.getLayoutParams().height = s1.f(12.0f);
        this.f58544c.getLayoutParams().width = s1.f(12.0f);
        this.f58544c.setImageDrawable(null);
        this.f58544c.setBackgroundResource(R.drawable.ttlive_ic_preview_new_badge);
        this.f58544c.setTranslationY(-s1.f(3.0f));
    L20:
        ImageView r107 = this.f58544c;
        if (r100.f516132h == true) goto L24;
        r102 = 8;
    L24:
        r107.setVisibility(r102);
        return;
    L15:
        r106 = 0;
    L19:
        this.f58544c.getLayoutParams().height = s1.f(6.0f);
        this.f58544c.getLayoutParams().width = s1.f(6.0f);
        this.f58544c.setBackgroundResource(0);
        this.f58544c.setImageResource(R.drawable.ttlive_ic_red_dot_on_white_bg);
        this.f58544c.setTranslationY(0.0f);
        goto L20
    L9:
        r104 = 8;
        goto L10
    L5:
        r103 = false;
        goto L7
    }
}
