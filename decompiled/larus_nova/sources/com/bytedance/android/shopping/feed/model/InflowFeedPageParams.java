package com.bytedance.android.shopping.feed.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sc3.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/InflowFeedPageParams;", "Ljava/io/Serializable;", "", "tag", "Ljava/lang/Long;", "getTag", "()Ljava/lang/Long;", "", "isFromGuessULike", "Z", "()Z", "Lsc3/a;", "addCartListener", "Lsc3/a;", "getAddCartListener", "()Lsc3/a;", "", "transitionTrackerData", "Ljava/lang/String;", "getTransitionTrackerData", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Long;ZLsc3/a;Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedPageParams implements Serializable {
    private final a addCartListener;
    private final boolean isFromGuessULike;
    private final Long tag;
    private final String transitionTrackerData;

    public InflowFeedPageParams() {
        this(null, false, null, null, 15, null);
    }

    public final a getAddCartListener() {
        return this.addCartListener;
    }

    public final Long getTag() {
        return this.tag;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final boolean isFromGuessULike() {
        return this.isFromGuessULike;
    }

    public InflowFeedPageParams(Long r100, boolean r101, a r102, String r103) {
        this.tag = r100;
        this.isFromGuessULike = r101;
        this.addCartListener = r102;
        this.transitionTrackerData = r103;
    }

    public /* synthetic */ InflowFeedPageParams(Long r100, boolean r101, a r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
