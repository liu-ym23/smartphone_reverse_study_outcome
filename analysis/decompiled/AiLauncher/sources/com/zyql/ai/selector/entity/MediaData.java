package com.zyql.ai.selector.entity;

import java.util.List;

/* loaded from: classes4.dex */
public class MediaData {
    public List<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean z10, List<LocalMedia> list) {
        this.isHasNextMore = z10;
        this.data = list;
    }
}
