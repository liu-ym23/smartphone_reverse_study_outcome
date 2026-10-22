package com.bytedanceos.common.ui.utils;

import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SpaceUtil {
    protected RecyclerViewEngine mEngine;
    protected TopicListAdapter.TopicItem mItem;

    public SpaceUtil(RecyclerViewEngine r10) {
        Objects.requireNonNull(r10);
        this.mEngine = r10;
    }

    public void addSpace(int r10) {
        this.mItem = new TopicListAdapter.TopicItem(109, Integer.valueOf(r10));
        RecyclerViewEngine r11 = this.mEngine;
        r11.appendData(r11.getAdapter().getItemCount() - 1, this.mItem);
    }

    public void removeSpace() {
        this.mEngine.getAdapter().removeData(this.mItem);
    }
}
