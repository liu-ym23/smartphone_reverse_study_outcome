package androidx.camera.core.impl.utils;

/* JADX INFO: loaded from: classes2.dex */
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public boolean isFormatCompatible(int r100) {
        int r101 = this.primaryFormat;
        if (r101 == 7) goto L30;
        if (r100 == 7) goto L32;
        if (r101 == r100) goto L31;
        int r102 = this.secondaryFormat;
        if (r102 != r100) goto L11;
        return true;
    L11:
        if (r101 == 4) goto L14;
        if (r102 == 4) goto L14;
    L17:
        if (r101 == 9) goto L20;
        if (r102 == 9) goto L20;
    L23:
        if (r101 == 12) goto L26;
        if (r102 == 12) goto L26;
    L28:
        return false;
    L26:
        if (r100 != 11) goto L28;
        return true;
    L20:
        if (r100 != 8) goto L23;
        return true;
    L14:
        if (r100 != 3) goto L17;
        return true;
    L31:
        return true;
    L32:
        return true;
    L30:
        return true;
    }

    public ExifTag(String r100, int r101, int r102) {
        this.name = r100;
        this.number = r101;
        this.primaryFormat = r102;
        this.secondaryFormat = -1;
    }

    public ExifTag(String r100, int r101, int r102, int r103) {
        this.name = r100;
        this.number = r101;
        this.primaryFormat = r102;
        this.secondaryFormat = r103;
    }
}
