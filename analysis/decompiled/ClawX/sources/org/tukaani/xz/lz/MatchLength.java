package org.tukaani.xz.lz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class MatchLength {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int EXTRA_SIZE = 0;

    public static int getLen(byte[] bArr, int i8, int i9, int i10, int i11) {
        int i12 = i11 + i8;
        int i13 = i10 + i8;
        while (i13 < i12 && bArr[i13] == bArr[i13 - i9]) {
            i13++;
        }
        return i13 - i8;
    }
}
