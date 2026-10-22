package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidJpegDataParser {
    private final LargeJpegImageQuirk mQuirk;

    public InvalidJpegDataParser() {
        this.mQuirk = (LargeJpegImageQuirk) DeviceQuirks.get(LargeJpegImageQuirk.class);
    }

    public static int getJfifEoiMarkEndPosition(byte[] r100) {
        int r101 = 2;
    L4:
        if ((r101 + 4) > r100.length) goto L22;
        byte r102 = r100[r101];
        if (r102 != (-1)) goto L22;
        int r103 = r101 + 2;
        int r104 = ((r100[r103] & UByte.MAX_VALUE) << 8) | (r100[r101 + 3] & UByte.MAX_VALUE);
        if (r102 != (-1)) goto L21;
        if (r100[r101 + 1] != (-38)) goto L21;
    L12:
        int r105 = r103 + 2;
        if (r105 > r100.length) goto L14;
        if (r100[r103] != (-1)) goto L20;
        if (r100[r103 + 1] != (-39)) goto L20;
        return r105;
    L20:
        r103 = r103 + 1;
        goto L12
    L14:
        return -1;
    L21:
        r101 = r101 + (r104 + 2);
    L22:
        return -1;
    }

    public int getValidDataLength(byte[] r100) {
        LargeJpegImageQuirk r101 = this.mQuirk;
        if (r101 == null) goto L13;
        if (r101.shouldCheckInvalidJpegData(r100) == false) goto L13;
        int r102 = getJfifEoiMarkEndPosition(r100);
        if (r102 == (-1)) goto L11;
        return r102;
    L11:
        return r100.length;
    L13:
        return r100.length;
    }
}
