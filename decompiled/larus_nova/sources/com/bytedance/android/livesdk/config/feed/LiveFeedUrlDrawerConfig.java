package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedUrlDrawerConfig;", "", "drawerHot", "", "drawerHotTask", "(Ljava/lang/String;Ljava/lang/String;)V", "getDrawerHot", "()Ljava/lang/String;", "setDrawerHot", "(Ljava/lang/String;)V", "getDrawerHotTask", "setDrawerHotTask", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedUrlDrawerConfig {

    @SerializedName("drawer_hot")
    private String drawerHot;

    @SerializedName("drawer_hot_task")
    private String drawerHotTask;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveFeedUrlDrawerConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LiveFeedUrlDrawerConfig copy$default(LiveFeedUrlDrawerConfig r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.drawerHot;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.drawerHotTask;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.drawerHot;
    }

    public final String component2() {
        return this.drawerHotTask;
    }

    public final LiveFeedUrlDrawerConfig copy(String r100, String r101) {
        return new LiveFeedUrlDrawerConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedUrlDrawerConfig) == false) goto L10;
        LiveFeedUrlDrawerConfig r101 = (LiveFeedUrlDrawerConfig) r100;
        if (Intrinsics.areEqual(this.drawerHot, r101.drawerHot) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.drawerHotTask, r101.drawerHotTask) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.drawerHot;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.drawerHotTask;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedUrlDrawerConfig(drawerHot=" + this.drawerHot + ", drawerHotTask=" + this.drawerHotTask + ")";
    }

    public final String getDrawerHot() {
        return this.drawerHot;
    }

    public final String getDrawerHotTask() {
        return this.drawerHotTask;
    }

    public final void setDrawerHot(String r100) {
        this.drawerHot = r100;
    }

    public final void setDrawerHotTask(String r100) {
        this.drawerHotTask = r100;
    }

    public LiveFeedUrlDrawerConfig(String r100, String r101) {
        this.drawerHot = r100;
        this.drawerHotTask = r101;
    }

    public /* synthetic */ LiveFeedUrlDrawerConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
