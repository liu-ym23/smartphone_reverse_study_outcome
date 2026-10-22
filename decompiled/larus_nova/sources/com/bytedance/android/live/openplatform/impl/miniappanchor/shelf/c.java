package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import com.bytedance.android.livesdk.config.ee0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/c;", "", "", "isMounted", "Z", "()Z", "", "mountedPageNum", "I", "getMountedPageNum", "()I", "isModify", "maxPageNum", "getMaxPageNum", "", "roomId", "J", "getRoomId", "()J", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("isModify")
    private final boolean isModify;

    @SerializedName("isMounted")
    private final boolean isMounted;

    @SerializedName("maxPageNum")
    private final int maxPageNum;

    @SerializedName("mountedPageNum")
    private final int mountedPageNum;

    @SerializedName("roomId")
    private final long roomId;

    public c() {
        this(false, 0, false, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.isMounted == r101.isMounted) goto L8;
        return false;
    L8:
        if (this.mountedPageNum == r101.mountedPageNum) goto L10;
        return false;
    L10:
        if (this.isModify == r101.isModify) goto L12;
        return false;
    L12:
        if (this.maxPageNum == r101.maxPageNum) goto L14;
        return false;
    L14:
        if (this.roomId == r101.roomId) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        boolean r100 = this.isMounted;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.mountedPageNum) * 31;
        boolean r104 = this.isModify;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (((r103 + r101) * 31) + this.maxPageNum) * 31;
        long r106 = this.roomId;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "PageConfig(isMounted=" + this.isMounted + ", mountedPageNum=" + this.mountedPageNum + ", isModify=" + this.isModify + ", maxPageNum=" + this.maxPageNum + ", roomId=" + this.roomId + ")";
    }

    public c(boolean r100, int r101, boolean r102, long r103, int r104) {
        int r105 = 0;
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r105 = ee0.f120119a.getValue().o();
    L15:
        if ((r104 & 16) == 0) goto L17;
        r103 = 0;
    L17:
        this.isMounted = r100;
        this.mountedPageNum = r101;
        this.isModify = r102;
        this.maxPageNum = r105;
        this.roomId = r103;
    }
}
