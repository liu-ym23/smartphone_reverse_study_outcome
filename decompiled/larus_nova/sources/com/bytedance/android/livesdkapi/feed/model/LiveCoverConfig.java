package com.bytedance.android.livesdkapi.feed.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/LiveCoverConfig;", "", "enableOperationLabel", "", "enableContentLabel", "enableCategoryLabel", "(ZZZ)V", "getEnableCategoryLabel", "()Z", "getEnableContentLabel", "getEnableOperationLabel", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveCoverConfig {
    private final boolean enableCategoryLabel;
    private final boolean enableContentLabel;
    private final boolean enableOperationLabel;

    public LiveCoverConfig() {
        this(false, false, false, 7, null);
    }

    public boolean getEnableCategoryLabel() {
        return this.enableCategoryLabel;
    }

    public boolean getEnableContentLabel() {
        return this.enableContentLabel;
    }

    public boolean getEnableOperationLabel() {
        return this.enableOperationLabel;
    }

    public LiveCoverConfig(boolean r100, boolean r101, boolean r102) {
        this.enableOperationLabel = r100;
        this.enableContentLabel = r101;
        this.enableCategoryLabel = r102;
    }

    public /* synthetic */ LiveCoverConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
