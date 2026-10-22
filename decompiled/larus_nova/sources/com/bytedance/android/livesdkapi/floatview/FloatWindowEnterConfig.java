package com.bytedance.android.livesdkapi.floatview;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/FloatWindowEnterConfig;", "", "drawUrl", "", "roomIds", "", "isFromXTab", "", "multiTabEvent", "(Ljava/lang/String;[JZLjava/lang/String;)V", "getDrawUrl", "()Ljava/lang/String;", "()Z", "getMultiTabEvent", "getRoomIds", "()[J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowEnterConfig {
    private final String drawUrl;
    private final boolean isFromXTab;
    private final String multiTabEvent;
    private final long[] roomIds;

    public static /* synthetic */ FloatWindowEnterConfig copy$default(FloatWindowEnterConfig r100, String r101, long[] r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.drawUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.roomIds;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isFromXTab;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.multiTabEvent;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.drawUrl;
    }

    public final long[] component2() {
        return this.roomIds;
    }

    public final boolean component3() {
        return this.isFromXTab;
    }

    public final String component4() {
        return this.multiTabEvent;
    }

    public final FloatWindowEnterConfig copy(String r100, long[] r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "drawUrl");
        Intrinsics.checkNotNullParameter(r103, "multiTabEvent");
        return new FloatWindowEnterConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FloatWindowEnterConfig) == false) goto L14;
        FloatWindowEnterConfig r101 = (FloatWindowEnterConfig) r100;
        if (Intrinsics.areEqual(this.drawUrl, r101.drawUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomIds, r101.roomIds) == true) goto L10;
        return false;
    L10:
        if (this.isFromXTab == r101.isFromXTab) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.multiTabEvent, r101.multiTabEvent) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String r100 = this.drawUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        long[] r104 = this.roomIds;
        if (r104 == null) goto L9;
        int r105 = Arrays.hashCode(r104);
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.isFromXTab;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.multiTabEvent;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FloatWindowEnterConfig(drawUrl=" + this.drawUrl + ", roomIds=" + Arrays.toString(this.roomIds) + ", isFromXTab=" + this.isFromXTab + ", multiTabEvent=" + this.multiTabEvent + ")";
    }

    public final String getDrawUrl() {
        return this.drawUrl;
    }

    public final String getMultiTabEvent() {
        return this.multiTabEvent;
    }

    public final long[] getRoomIds() {
        return this.roomIds;
    }

    public final boolean isFromXTab() {
        return this.isFromXTab;
    }

    public FloatWindowEnterConfig(String r100, long[] r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "drawUrl");
        Intrinsics.checkNotNullParameter(r103, "multiTabEvent");
        this.drawUrl = r100;
        this.roomIds = r101;
        this.isFromXTab = r102;
        this.multiTabEvent = r103;
    }

    public /* synthetic */ FloatWindowEnterConfig(String r100, long[] r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        this(r100, r101, r102, r103);
    }
}
