package com.bytedance.android.gamecp.business.gamedetail.view.intro;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/intro/GameIntroImageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroImageVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f55894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f55895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f55896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f55897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f55898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f55899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f55900g;

    public static final class a {
    }

    static {
    }

    public GameIntroImageVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f55894a = LazyKt.lazy(GameIntroImageVH$MIN_HEIGHT$2.INSTANCE);
        this.f55895b = LazyKt.lazy(GameIntroImageVH$MAX_HEIGHT$2.INSTANCE);
        this.f55896c = LazyKt.lazy(GameIntroImageVH$MIN_WIDTH_HORIZONTAL$2.INSTANCE);
        this.f55897d = LazyKt.lazy(GameIntroImageVH$MIN_WIDTH_VERTICAL$2.INSTANCE);
        this.f55898e = LazyKt.lazy(GameIntroImageVH$MAXIMAL_HEIGHT$2.INSTANCE);
        this.f55899f = r100;
        this.f55900g = (HSImageView) r100.findViewById(R.id.game_image);
    }
}
