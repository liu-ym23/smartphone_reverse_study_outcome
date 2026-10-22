package com.bytedance.android.gamecp.business.gamedetail.view.intro;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/intro/GameIntroVideoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroVideoVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f55926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f55927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f55928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55929d;

    public static final class a {
    }

    static {
    }

    public GameIntroVideoVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f55926a = r100;
        this.f55927b = (ImageView) r100.findViewById(R.id.iv_play_icon);
    }
}
