package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.x0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f70540e;

    public static final class a {
    }

    static {
    }

    public final HSImageView T3() {
        return (HSImageView) this.f70538c.getValue();
    }

    public TuningEffectViewHolder(final View r100, final cc0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "tuningEffectInnerCallback");
        super(r100);
        this.f70536a = LazyKt.lazy(new TuningEffectViewHolder$tuningCoverContainer$2(r100));
        Lazy r102 = LazyKt.lazy(new TuningEffectViewHolder$selectedBorder$2(r100));
        this.f70537b = r102;
        this.f70538c = LazyKt.lazy(new TuningEffectViewHolder$cover$2(r100));
        Lazy r103 = LazyKt.lazy(new TuningEffectViewHolder$title$2(r100));
        this.f70539d = r103;
        HSImageView r104 = T3();
        if (r104 == null) goto L5;
        r104.setOnClickListener(x0.a(new AnonymousClass1(this, r101)));
    L5:
        TextView r105 = (TextView) r103.getValue();
        if (r105 == null) goto L8;
        KtvOrderSongThemeManager.d(r105, 10);
    L8:
        View r106 = (View) r102.getValue();
        if (r106 == null) goto L12;
        KtvOrderSongThemeManager.c(r106, KtvOrderSongThemeManager.f70215x);
        return;
    }
}
