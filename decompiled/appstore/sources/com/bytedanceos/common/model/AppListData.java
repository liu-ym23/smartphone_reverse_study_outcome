package com.bytedanceos.common.model;

import java.util.Objects;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class AppListData {
    private boolean mHasCardLineForLastCard;
    private boolean mHasDivideLineForLastCard;
    private boolean mHasMore;
    private JSONArray mListData;

    public AppListData(boolean r10, JSONArray r11) {
        this.mHasDivideLineForLastCard = false;
        this.mHasCardLineForLastCard = false;
        this.mHasMore = r10;
        this.mListData = r11;
        Objects.requireNonNull(r11);
        if (r11.length() <= 0) goto L6;
        this.mHasDivideLineForLastCard = b9.a.b(r11.optJSONObject(r11.length() - 1));
        this.mHasDivideLineForLastCard = b9.a.a(r11.optJSONObject(r11.length() - 1));
        return;
    }

    public JSONArray getListData() {
        return this.mListData;
    }

    public boolean hasCardLineAtLast() {
        return this.mHasCardLineForLastCard;
    }

    public boolean hasDivideLineAtLast() {
        return this.mHasDivideLineForLastCard;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }
}
