package com.bytedance.android.livesdk.dynamic.util;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dynamic/util/OffsetLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffsetLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, Integer> f123022a;

    public OffsetLinearLayoutManager(FragmentActivity r100) {
        super(r100);
        this.f123022a = new HashMap();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = 0;
        if (getChildCount() != 0) goto L16;
        return 0;
    L16:
        int r102 = findFirstVisibleItemPosition();     // Catch: Exception -> L15
        View r103 = findViewByPosition(r102);     // Catch: Exception -> L15
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r102) goto L11;
        Integer r106 = this.f123022a.get(Integer.valueOf(r104));     // Catch: Exception -> L15
        if (r106 != null) goto L10;
        r106 = 0;     // Catch: Exception -> L15
    L10:
        r105 = r105 + r106.intValue();     // Catch: Exception -> L15
        r104 = r104 + 1;     // Catch: Exception -> L15
        goto L6
    L11:
        if (r103 == null) goto L14;
        r101 = r103.getTop();     // Catch: Exception -> L15
    L14:
        return r105 - r101;
    L21:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        int r101 = findFirstVisibleItemPosition();
        int r102 = findLastVisibleItemPosition();
        if (r101 < 0) goto L11;
        if (r102 < 0) goto L15;
        if (r102 < r101) goto L16;
    L6:
        if (r101 >= r102) goto L17;
        View r103 = getChildAt(r101);
        if (r103 == null) goto L10;
        this.f123022a.put(Integer.valueOf(r101), Integer.valueOf(r103.getHeight()));
    L10:
        r101 = r101 + 1;
        goto L6
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
