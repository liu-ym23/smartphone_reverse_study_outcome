package com.bytedance.android.live.ktv.common.music.download;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f70080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f70082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f70083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f70084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f70085f;

    public m() {
        this(false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L18;
        m r101 = (m) r100;
        if (this.f70080a == r101.f70080a) goto L8;
        return false;
    L8:
        if (this.f70081b == r101.f70081b) goto L10;
        return false;
    L10:
        if (this.f70082c == r101.f70082c) goto L12;
        return false;
    L12:
        if (this.f70083d == r101.f70083d) goto L14;
        return false;
    L14:
        if (this.f70084e == r101.f70084e) goto L16;
        return false;
    L16:
        if (this.f70085f == r101.f70085f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f70080a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f70081b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f70082c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f70083d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f70084e;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f70085f;
        if (r116 == true) goto L22;
        r101 = r116;
    L22:
        return r115 + r101;
    }

    public final String toString() {
        return "KtvMusicDownloadConfig(skipProcessingIfDownloaded=" + this.f70080a + ", needDownloadFullTrack=" + this.f70081b + ", needDownloadAccompanimentTrack=" + this.f70082c + ", needDownloadLyric=" + this.f70083d + ", needDownloadMidi=" + this.f70084e + ", needDownloadVocal=" + this.f70085f + ")";
    }

    public m(boolean r100, boolean r101, int r102) {
        boolean r103 = false;
        boolean r104 = true;
        if ((r102 & 1) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = true;
    L10:
        if ((r102 & 4) == 0) goto L13;
        r101 = true;
    L13:
        if ((r102 & 8) == 0) goto L15;
        boolean r106 = true;
    L17:
        if ((r102 & 16) != 0) goto L21;
        r104 = false;
    L21:
        if ((r102 & 32) == 0) goto L23;
        r103 = vm2.h.d();
    L23:
        this.f70080a = r105;
        this.f70081b = r100;
        this.f70082c = r101;
        this.f70083d = r106;
        this.f70084e = r104;
        this.f70085f = r103;
        return;
    L15:
        r106 = false;
        goto L17
    L5:
        r105 = false;
        goto L7
    }
}
