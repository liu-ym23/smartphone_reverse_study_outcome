package com.bytedance.android.livesdk.livecommerce.base.paging;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/base/paging/PageListLoadStatus;", "", "Initialize", "InitializeSuccess", "InitializeError", "InitializeEmpty", "LoadMoreIn", "LoadMoreSuccess", "LoadMoreError", "LoadMoreEnd", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageListLoadStatus extends Enum<PageListLoadStatus> {
    public static final PageListLoadStatus Initialize = null;
    public static final PageListLoadStatus InitializeEmpty = null;
    public static final PageListLoadStatus InitializeError = null;
    public static final PageListLoadStatus InitializeSuccess = null;
    public static final PageListLoadStatus LoadMoreEnd = null;
    public static final PageListLoadStatus LoadMoreError = null;
    public static final PageListLoadStatus LoadMoreIn = null;
    public static final PageListLoadStatus LoadMoreSuccess = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageListLoadStatus[] f147653a = null;

    static {
        PageListLoadStatus r100 = new PageListLoadStatus("Initialize", 0);
        Initialize = r100;
        PageListLoadStatus r101 = new PageListLoadStatus("InitializeSuccess", 1);
        InitializeSuccess = r101;
        PageListLoadStatus r102 = new PageListLoadStatus("InitializeError", 2);
        InitializeError = r102;
        PageListLoadStatus r103 = new PageListLoadStatus("InitializeEmpty", 3);
        InitializeEmpty = r103;
        PageListLoadStatus r104 = new PageListLoadStatus("LoadMoreIn", 4);
        LoadMoreIn = r104;
        PageListLoadStatus r105 = new PageListLoadStatus("LoadMoreSuccess", 5);
        LoadMoreSuccess = r105;
        PageListLoadStatus r106 = new PageListLoadStatus("LoadMoreError", 6);
        LoadMoreError = r106;
        PageListLoadStatus r107 = new PageListLoadStatus("LoadMoreEnd", 7);
        LoadMoreEnd = r107;
        f147653a = new PageListLoadStatus[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static PageListLoadStatus valueOf(String r100) {
        return (PageListLoadStatus) a.a(PageListLoadStatus.class, r100);
    }

    public static PageListLoadStatus[] values() {
        return (PageListLoadStatus[]) f147653a.clone();
    }

    public PageListLoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
