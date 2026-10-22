package com.chad.library.adapter.base.loadmore;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "", "(Ljava/lang/String;I)V", "Complete", "Loading", "Fail", "End", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final enum LoadMoreStatus extends Enum<LoadMoreStatus> {
    private static final /* synthetic */ LoadMoreStatus[] $VALUES = null;
    public static final LoadMoreStatus Complete = null;
    public static final LoadMoreStatus End = null;
    public static final LoadMoreStatus Fail = null;
    public static final LoadMoreStatus Loading = null;

    static {
        LoadMoreStatus r10 = new LoadMoreStatus("Complete", 0);
        Complete = r10;
        LoadMoreStatus r11 = new LoadMoreStatus("Loading", 1);
        Loading = r11;
        LoadMoreStatus r12 = new LoadMoreStatus("Fail", 2);
        Fail = r12;
        LoadMoreStatus r13 = new LoadMoreStatus("End", 3);
        End = r13;
        $VALUES = new LoadMoreStatus[]{r10, r11, r12, r13};
    }

    private LoadMoreStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static LoadMoreStatus valueOf(String r10) {
        return (LoadMoreStatus) Enum.valueOf(LoadMoreStatus.class, r10);
    }

    public static LoadMoreStatus[] values() {
        return (LoadMoreStatus[]) $VALUES.clone();
    }
}
