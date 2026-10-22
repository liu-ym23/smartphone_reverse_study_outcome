package com.bytedance.android.livesdk.config.feed;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/InnerFeedDeduplicationConfig;", "", "enable", "", "enterSource", "", "", "maxCount", "", "(ZLjava/util/List;I)V", "getEnable", "()Z", "getEnterSource", "()Ljava/util/List;", "getMaxCount", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedDeduplicationConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(a.KEY_ENTER_SOURCE)
    private final List<String> enterSource;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private final int maxCount;

    public InnerFeedDeduplicationConfig() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InnerFeedDeduplicationConfig copy$default(InnerFeedDeduplicationConfig r100, boolean r101, List r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enterSource;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.maxCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.enterSource;
    }

    public final int component3() {
        return this.maxCount;
    }

    public final InnerFeedDeduplicationConfig copy(boolean r100, List<String> r101, int r102) {
        return new InnerFeedDeduplicationConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InnerFeedDeduplicationConfig) == false) goto L12;
        InnerFeedDeduplicationConfig r101 = (InnerFeedDeduplicationConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterSource, r101.enterSource) == true) goto L10;
        return false;
    L10:
        if (this.maxCount == r101.maxCount) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.enterSource;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return ((r102 + r104) * 31) + this.maxCount;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "InnerFeedDeduplicationConfig(enable=" + this.enable + ", enterSource=" + this.enterSource + ", maxCount=" + this.maxCount + ")";
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getEnterSource() {
        return this.enterSource;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public InnerFeedDeduplicationConfig(boolean r100, List<String> r101, int r102) {
        this.enable = r100;
        this.enterSource = r101;
        this.maxCount = r102;
    }

    public /* synthetic */ InnerFeedDeduplicationConfig(boolean r100, List r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 60;
    L11:
        this(r100, r101, r102);
    }
}
