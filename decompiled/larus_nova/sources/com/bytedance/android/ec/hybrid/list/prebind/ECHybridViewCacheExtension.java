package com.bytedance.android.ec.hybrid.list.prebind;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/prebind/ECHybridViewCacheExtension;", "Landroidx/recyclerview/widget/RecyclerView$ViewCacheExtension;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridViewCacheExtension extends RecyclerView.ViewCacheExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECHybridRecyclerViewPreBindHelper f47272a;

    public ECHybridViewCacheExtension(ECHybridRecyclerViewPreBindHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "preBindHelper");
        this.f47272a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
    public final View getViewForPositionAndType(RecyclerView.Recycler r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        HashMap r103 = (HashMap) this.f47272a.f47254a;
        RecyclerView.ViewHolder r104 = (RecyclerView.ViewHolder) r103.remove(Integer.valueOf(r101));
        if (r104 == null) goto L5;
        View r105 = r104.itemView;
    L6:
        Logger.d("NaMallPreBind", "#preBind#: after ExtendViewCache remove, size = " + r103.size());
        if (r105 == null) goto L9;
        Logger.d("NaMallPreBind", "#preBind#: get vh from MallExtendViewCache, position = " + r101 + ", type = " + r102);
    L9:
        return r105;
    L5:
        r105 = null;
        goto L6
    }
}
