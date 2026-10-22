package com.bytedance.android.livesdk.config.feed;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedDynamic;", "", "enterSource", "", "liveFeedUrl", "canDraw", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCanDraw", "()Z", "getEnterSource", "()Ljava/lang/String;", "getLiveFeedUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedDynamic {

    @SerializedName("can_draw")
    private final boolean canDraw;

    @SerializedName(a.KEY_ENTER_SOURCE)
    private final String enterSource;

    @SerializedName("live_feed_url")
    private final String liveFeedUrl;

    public LiveFeedDynamic() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ LiveFeedDynamic copy$default(LiveFeedDynamic r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enterSource;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.liveFeedUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.canDraw;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.enterSource;
    }

    public final String component2() {
        return this.liveFeedUrl;
    }

    public final boolean component3() {
        return this.canDraw;
    }

    public final LiveFeedDynamic copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "liveFeedUrl");
        return new LiveFeedDynamic(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedDynamic) == false) goto L12;
        LiveFeedDynamic r101 = (LiveFeedDynamic) r100;
        if (Intrinsics.areEqual(this.enterSource, r101.enterSource) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveFeedUrl, r101.liveFeedUrl) == true) goto L10;
        return false;
    L10:
        if (this.canDraw == r101.canDraw) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.enterSource;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveFeedUrl;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.canDraw;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedDynamic(enterSource=" + this.enterSource + ", liveFeedUrl=" + this.liveFeedUrl + ", canDraw=" + this.canDraw + ")";
    }

    public final boolean getCanDraw() {
        return this.canDraw;
    }

    public final String getEnterSource() {
        return this.enterSource;
    }

    public final String getLiveFeedUrl() {
        return this.liveFeedUrl;
    }

    public LiveFeedDynamic(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "liveFeedUrl");
        this.enterSource = r100;
        this.liveFeedUrl = r101;
        this.canDraw = r102;
    }

    public /* synthetic */ LiveFeedDynamic(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
