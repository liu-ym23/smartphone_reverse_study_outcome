package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AnchorV4LoadMoreRecyclerView f168804f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4LoadMoreRecyclerView f168807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f168808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f168809e;

    public static final class a {
    }

    static {
    }

    public c(View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "headView");
        this.f168808d = r100;
        this.f168809e = r101;
    }

    public final AnchorV4LoadMoreRecyclerView a(final ScrollMoreText r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scrollMoreText");
        final AnchorV4LoadMoreRecyclerView r102 = new AnchorV4LoadMoreRecyclerView(this.f168808d.getContext(), null, 6, 0);
        f168804f = r102;
        r102.setScrollState(r101);
        r102.setAdapter(new AnchorV4HeadLoadMoreAdapter(this.f168808d, r100, this.f168809e));
        final Context r103 = r102.getContext();
        LinearLayoutManager r104 = new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$1(r103, r101);
        r104.setOrientation(0);
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutManager(r104);
        r102.setScrollToEndCallback(new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$2(r102, this, r101, r100));
        r102.addOnScrollListener(new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$3(this));
        this.f168807c = r102;
        return r102;
    }
}
