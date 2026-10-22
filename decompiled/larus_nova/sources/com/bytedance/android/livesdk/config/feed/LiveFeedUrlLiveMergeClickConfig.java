package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedUrlLiveMergeClickConfig;", "", "iconUrl", "", "liveFeedUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getLiveFeedUrl", "setLiveFeedUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedUrlLiveMergeClickConfig {

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("live_feed_url")
    private String liveFeedUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveFeedUrlLiveMergeClickConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LiveFeedUrlLiveMergeClickConfig copy$default(LiveFeedUrlLiveMergeClickConfig r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.iconUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.liveFeedUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.liveFeedUrl;
    }

    public final LiveFeedUrlLiveMergeClickConfig copy(String r100, String r101) {
        return new LiveFeedUrlLiveMergeClickConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedUrlLiveMergeClickConfig) == false) goto L10;
        LiveFeedUrlLiveMergeClickConfig r101 = (LiveFeedUrlLiveMergeClickConfig) r100;
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveFeedUrl, r101.liveFeedUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.iconUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveFeedUrl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedUrlLiveMergeClickConfig(iconUrl=" + this.iconUrl + ", liveFeedUrl=" + this.liveFeedUrl + ")";
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getLiveFeedUrl() {
        return this.liveFeedUrl;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setLiveFeedUrl(String r100) {
        this.liveFeedUrl = r100;
    }

    public LiveFeedUrlLiveMergeClickConfig(String r100, String r101) {
        this.iconUrl = r100;
        this.liveFeedUrl = r101;
    }

    public /* synthetic */ LiveFeedUrlLiveMergeClickConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
