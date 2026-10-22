package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.larus.nova.R;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarQuickLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f116039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f116040b = null;

    static {
        f116039a = SetsKt.setOf(new Integer[]{1, 5, 7});
        f116040b = LazyKt.lazy(ToolbarQuickLoader$preloadViewTag$2.INSTANCE);
    }

    public static View a(ViewGroup r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "data");
        int r102 = r101.f116191a;
        if (r102 != 1) goto L6;
        ImageView r103 = new ImageView(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r103.setImageResource(R.drawable.live_toolbar_ic_v2_ecommerce_static);
    L12:
        if (r103 == null) goto L14;
        r103.setTag(Integer.valueOf(((Number) f116040b.getValue()).intValue()));
        r100.addView(r103);
    L14:
        return r103;
    L6:
        if (r102 != 5) goto L9;
        r103 = new ImageView(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r103.setImageResource(R.drawable.ttlive_ic_game_promote_new);
        goto L12
    L9:
        if (r102 != 7) goto L11;
        r103 = new ImageView(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r103.setImageResource(R.drawable.live_toolbar_ic_v2_locallife_static);
        goto L12
    L11:
        r103 = null;
        goto L12
    }
}
