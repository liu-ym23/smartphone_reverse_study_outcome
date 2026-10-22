package com.bytedance.android.livesdkapi.depend.model.gamecp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatBallDownloadData;", "", "downloadCount", "", "hasDownloadPermission", "", "notInstallCount", "hasInstallPermission", "showInstallTips", "(IZIZZ)V", "getDownloadCount", "()I", "getHasDownloadPermission", "()Z", "getHasInstallPermission", "getNotInstallCount", "getShowInstallTips", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorFloatBallDownloadData {
    private final int downloadCount;
    private final boolean hasDownloadPermission;
    private final boolean hasInstallPermission;
    private final int notInstallCount;
    private final boolean showInstallTips;

    public AnchorFloatBallDownloadData() {
        this(0, false, 0, false, false, 31, null);
    }

    public static /* synthetic */ AnchorFloatBallDownloadData copy$default(AnchorFloatBallDownloadData r100, int r101, boolean r102, int r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.downloadCount;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.hasDownloadPermission;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.notInstallCount;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hasInstallPermission;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.showInstallTips;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.downloadCount;
    }

    public final boolean component2() {
        return this.hasDownloadPermission;
    }

    public final int component3() {
        return this.notInstallCount;
    }

    public final boolean component4() {
        return this.hasInstallPermission;
    }

    public final boolean component5() {
        return this.showInstallTips;
    }

    public final AnchorFloatBallDownloadData copy(int r100, boolean r101, int r110, boolean r111, boolean r112) {
        return new AnchorFloatBallDownloadData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorFloatBallDownloadData) == false) goto L16;
        AnchorFloatBallDownloadData r101 = (AnchorFloatBallDownloadData) r100;
        if (this.downloadCount == r101.downloadCount) goto L8;
        return false;
    L8:
        if (this.hasDownloadPermission == r101.hasDownloadPermission) goto L10;
        return false;
    L10:
        if (this.notInstallCount == r101.notInstallCount) goto L12;
        return false;
    L12:
        if (this.hasInstallPermission == r101.hasInstallPermission) goto L14;
        return false;
    L14:
        if (this.showInstallTips == r101.showInstallTips) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = this.downloadCount * 31;
        boolean r101 = this.hasDownloadPermission;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (((r100 + r103) * 31) + this.notInstallCount) * 31;
        boolean r105 = this.hasInstallPermission;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.showInstallTips;
        if (r108 == true) goto L13;
        r102 = r108;
    L13:
        return r107 + r102;
    }

    public String toString() {
        return "AnchorFloatBallDownloadData(downloadCount=" + this.downloadCount + ", hasDownloadPermission=" + this.hasDownloadPermission + ", notInstallCount=" + this.notInstallCount + ", hasInstallPermission=" + this.hasInstallPermission + ", showInstallTips=" + this.showInstallTips + ')';
    }

    public final int getDownloadCount() {
        return this.downloadCount;
    }

    public final boolean getHasDownloadPermission() {
        return this.hasDownloadPermission;
    }

    public final boolean getHasInstallPermission() {
        return this.hasInstallPermission;
    }

    public final int getNotInstallCount() {
        return this.notInstallCount;
    }

    public final boolean getShowInstallTips() {
        return this.showInstallTips;
    }

    public AnchorFloatBallDownloadData(int r100, boolean r101, int r102, boolean r103, boolean r104) {
        this.downloadCount = r100;
        this.hasDownloadPermission = r101;
        this.notInstallCount = r102;
        this.hasInstallPermission = r103;
        this.showInstallTips = r104;
    }

    public /* synthetic */ AnchorFloatBallDownloadData(int r100, boolean r101, int r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r113 = false;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
