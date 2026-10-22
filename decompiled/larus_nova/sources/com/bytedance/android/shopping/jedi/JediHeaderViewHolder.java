package com.bytedance.android.shopping.jedi;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/jedi/JediHeaderViewHolder;", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JediHeaderViewHolder extends MultiTypeViewHolder<Unit> {
    public JediHeaderViewHolder() {
        Intrinsics.checkNotNullParameter(null, "view");
        super(null);
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void bind(Unit r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }
}
