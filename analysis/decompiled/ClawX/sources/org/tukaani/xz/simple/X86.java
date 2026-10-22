package org.tukaani.xz.simple;

import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class X86 implements SimpleFilter {
    private static final boolean[] MASK_TO_ALLOWED_STATUS = {true, true, true, false, true, false, false, false};
    private static final int[] MASK_TO_BIT_NUMBER = {0, 1, 2, 2, 3, 3, 3, 3};
    private final boolean isEncoder;
    private int pos;
    private int prevMask = 0;

    public X86(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8 + 5;
    }

    private static boolean test86MSByte(byte b9) {
        int i8 = b9 & 255;
        return i8 == 0 || i8 == 255;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10;
        int i11 = i8 - 1;
        int i12 = (i9 + i8) - 5;
        int i13 = i8;
        while (true) {
            if (i13 > i12) {
                break;
            }
            if ((bArr[i13] & 254) == 232) {
                int i14 = i13 - i11;
                if ((i14 & (-4)) != 0) {
                    this.prevMask = 0;
                } else {
                    int i15 = (this.prevMask << (i14 - 1)) & 7;
                    this.prevMask = i15;
                    if (i15 != 0 && (!MASK_TO_ALLOWED_STATUS[i15] || test86MSByte(bArr[(i13 + 4) - MASK_TO_BIT_NUMBER[i15]]))) {
                        this.prevMask = (this.prevMask << 1) | 1;
                    }
                    i11 = i13;
                }
                int i16 = i13 + 4;
                if (test86MSByte(bArr[i16])) {
                    int i17 = i13 + 1;
                    int intLE = ByteArrayView.getIntLE(bArr, i17);
                    while (true) {
                        i10 = this.isEncoder ? ((this.pos + i13) - i8) + intLE : intLE - ((this.pos + i13) - i8);
                        int i18 = this.prevMask;
                        if (i18 == 0) {
                            break;
                        }
                        int i19 = MASK_TO_BIT_NUMBER[i18] * 8;
                        if (!test86MSByte((byte) (i10 >>> (24 - i19)))) {
                            break;
                        }
                        intLE = ((1 << (32 - i19)) - 1) ^ i10;
                    }
                    ByteArrayView.setIntLE(bArr, i17, (i10 << 7) >> 7);
                    int i20 = i13;
                    i13 = i16;
                    i11 = i20;
                } else {
                    this.prevMask = (this.prevMask << 1) | 1;
                    i11 = i13;
                }
            }
            i13++;
        }
        int i21 = i13 - i11;
        this.prevMask = (i21 & (-4)) == 0 ? this.prevMask << (i21 - 1) : 0;
        int i22 = i13 - i8;
        this.pos += i22;
        return i22;
    }
}
