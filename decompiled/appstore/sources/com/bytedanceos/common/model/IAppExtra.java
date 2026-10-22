package com.bytedanceos.common.model;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppExtra {
    public static final int ITEM_TYPE_APP_WITH_IMAGES = 7;
    public static final int ITEM_TYPE_NONE = 0;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_NORMAL_SUPPOSE_APP = 5;
    public static final int ITEM_TYPE_RELATED_APP = 4;
    public static final int ITEM_TYPE_RESERVE_GAME = 6;
    public static final int ITEM_TYPE_SPLIT = 2;
    public static final int ITEM_TYPE_TOP_AD = 3;
    public static final int MAX_ITEM_TYPE_SIZE = 8;

    int getItemType();
}
