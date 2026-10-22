package com.bytedance.android.ec.hybrid.api.card;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/api/card/IECHybridCardService;", "", "Lcom/bytedance/android/ec/hybrid/list/ability/a;", "abilityManager", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "generateMitaCardViewHolder", "", "isReady", "ec-hybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECHybridCardService {
    RecyclerView.ViewHolder generateMitaCardViewHolder(a r100, ViewGroup r101);

    boolean isReady();
}
