package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.base.model.rank.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/RankItemComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/live/base/model/rank/a;", "<init>", "()V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class RankItemComparator extends DiffUtil.ItemCallback<a> {
    public RankItemComparator() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(a r100, a r101) {
        a r102 = r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.c() != null) goto L5;
    L16:
        return false;
    L5:
        if (r103.c() == null) goto L16;
        c r104 = r102.c();
        Long r105 = null;
        if (r104 == null) goto L9;
        Long r106 = r104.b();
    L10:
        c r107 = r103.c();
        if (r107 == null) goto L14;
        r105 = r107.b();
    L14:
        if (Intrinsics.areEqual(r106, r105) == false) goto L16;
        return true;
    L9:
        r106 = null;
        goto L10
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(a r100, a r101) {
        a r102 = r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.c() != null) goto L5;
    L16:
        return false;
    L5:
        if (r103.c() == null) goto L16;
        c r104 = r102.c();
        Long r105 = null;
        if (r104 == null) goto L9;
        Long r106 = r104.b();
    L10:
        c r107 = r103.c();
        if (r107 == null) goto L14;
        r105 = r107.b();
    L14:
        if (Intrinsics.areEqual(r106, r105) == false) goto L16;
        return true;
    L9:
        r106 = null;
        goto L10
    }
}
