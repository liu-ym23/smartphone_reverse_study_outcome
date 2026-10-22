package com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/SaasCommentLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasCommentLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(RecyclerView.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (getOrientation() != 0) goto L5;
        throw null;
    L5:
        throw null;
    }
}
