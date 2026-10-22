package com.android.internal.chooser.widget;

import com.android.internal.chooser.widget.DiffUtil;
import java.util.List;

/* loaded from: classes.dex */
public class DiffCallback extends DiffUtil.Callback {
    private List mNewData;
    private List mOldData;

    public DiffCallback(List oldData, List newData) {
        this.mOldData = oldData;
        this.mNewData = newData;
    }

    @Override // com.android.internal.chooser.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.mOldData.size();
    }

    @Override // com.android.internal.chooser.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.mNewData.size();
    }

    @Override // com.android.internal.chooser.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.mOldData.get(oldItemPosition).equals(this.mNewData.get(newItemPosition));
    }

    @Override // com.android.internal.chooser.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return this.mOldData.get(oldItemPosition).equals(this.mNewData.get(newItemPosition));
    }
}
