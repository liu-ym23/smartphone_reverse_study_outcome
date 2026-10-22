package com.bytedanceos.common.ui.recycler.viewholder;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class MultiBaseViewHolder extends BaseViewHolder implements ViewPropertyHolder {
    private String page;

    public MultiBaseViewHolder(View r10) {
        super(r10);
    }

    @Override // com.bytedanceos.common.ui.recycler.viewholder.ViewPropertyHolder
    public String getId() {
        return "";
    }

    @Override // com.bytedanceos.common.ui.recycler.viewholder.ViewPropertyHolder
    public String getPage() {
        return this.page;
    }

    public MultiBaseViewHolder setPage(String r10) {
        this.page = r10;
        return this;
    }
}
