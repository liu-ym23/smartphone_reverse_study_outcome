package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/InteractGameItemIntensifyConfig;", "", "validTime", "", "isClicked", "", "lastShowTime", "", "alreadyShowCount", "", "(Ljava/lang/String;ZJI)V", "getAlreadyShowCount", "()I", "setAlreadyShowCount", "(I)V", "()Z", "setClicked", "(Z)V", "getLastShowTime", "()J", "setLastShowTime", "(J)V", "getValidTime", "()Ljava/lang/String;", "setValidTime", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameItemIntensifyConfig {
    private int alreadyShowCount;
    private boolean isClicked;
    private long lastShowTime;
    private String validTime;

    public InteractGameItemIntensifyConfig() {
        this(null, false, 0, 0, 15, null);
    }

    public static /* synthetic */ InteractGameItemIntensifyConfig copy$default(InteractGameItemIntensifyConfig r100, String r101, boolean r102, long r103, int r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.validTime;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.isClicked;
    L8:
        boolean r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.lastShowTime;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.alreadyShowCount;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.validTime;
    }

    public final boolean component2() {
        return this.isClicked;
    }

    public final long component3() {
        return this.lastShowTime;
    }

    public final int component4() {
        return this.alreadyShowCount;
    }

    public final InteractGameItemIntensifyConfig copy(String r100, boolean r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "validTime");
        return new InteractGameItemIntensifyConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InteractGameItemIntensifyConfig) == false) goto L14;
        InteractGameItemIntensifyConfig r101 = (InteractGameItemIntensifyConfig) r100;
        if (Intrinsics.areEqual(this.validTime, r101.validTime) == true) goto L8;
        return false;
    L8:
        if (this.isClicked == r101.isClicked) goto L10;
        return false;
    L10:
        if (this.lastShowTime == r101.lastShowTime) goto L12;
        return false;
    L12:
        if (this.alreadyShowCount == r101.alreadyShowCount) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.validTime;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.isClicked;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.lastShowTime;
        return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.alreadyShowCount;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "InteractGameItemIntensifyConfig(validTime=" + this.validTime + ", isClicked=" + this.isClicked + ", lastShowTime=" + this.lastShowTime + ", alreadyShowCount=" + this.alreadyShowCount + ")";
    }

    public final int getAlreadyShowCount() {
        return this.alreadyShowCount;
    }

    public final long getLastShowTime() {
        return this.lastShowTime;
    }

    public final String getValidTime() {
        return this.validTime;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setAlreadyShowCount(int r100) {
        this.alreadyShowCount = r100;
    }

    public final void setClicked(boolean r100) {
        this.isClicked = r100;
    }

    public final void setLastShowTime(long r100) {
        this.lastShowTime = r100;
    }

    public final void setValidTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.validTime = r100;
    }

    public InteractGameItemIntensifyConfig(String r100, boolean r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "validTime");
        this.validTime = r100;
        this.isClicked = r101;
        this.lastShowTime = r102;
        this.alreadyShowCount = r103;
    }

    public /* synthetic */ InteractGameItemIntensifyConfig(String r100, boolean r101, long r102, int r103, int r104, DefaultConstructorMarker r110) {
        if ((r104 & 1) == 0) goto L5;
        r100 = "";
    L5:
        int r105 = 0;
        if ((r104 & 2) == 0) goto L8;
        boolean r111 = false;
    L10:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        long r106 = r102;
        if ((r104 & 8) != 0) goto L16;
        r105 = r103;
    L16:
        this(r100, r111, r106, r105);
        return;
    L8:
        r111 = r101;
        goto L10
    }
}
