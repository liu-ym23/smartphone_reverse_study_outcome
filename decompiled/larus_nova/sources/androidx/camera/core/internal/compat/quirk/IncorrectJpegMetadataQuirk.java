package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class IncorrectJpegMetadataQuirk implements Quirk {
    private static final Set<String> SAMSUNG_DEVICES = null;

    public IncorrectJpegMetadataQuirk() {
    }

    static {
        SAMSUNG_DEVICES = new HashSet(Arrays.asList(new String[]{"A24"}));
    }

    private static boolean isSamsungProblematicDevice() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(Locale.US)) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isSamsungProblematicDevice();
    }

    private boolean canParseSosMarker(byte[] r100) {
        int r101 = 2;
    L4:
        if ((r101 + 4) > r100.length) goto L14;
        byte r102 = r100[r101];
        if (r102 != (-1)) goto L21;
        if (r102 != (-1)) goto L13;
        if (r100[r101 + 1] != (-38)) goto L13;
        return true;
    L13:
        r101 = r101 + ((((r100[r101 + 2] & UByte.MAX_VALUE) << 8) | (r100[r101 + 3] & UByte.MAX_VALUE)) + 2);
        goto L4
    L21:
        return false;
    L14:
        return false;
    }

    private int findSecondFfd8Position(byte[] r100) {
        int r101 = 2;
    L3:
        int r102 = r101 + 1;
        if (r102 > r100.length) goto L5;
        if (r100[r101] != (-1)) goto L11;
        if (r100[r102] != (-40)) goto L11;
        return r101;
    L11:
        r101 = r102;
        goto L3
    L5:
        return -1;
    }

    public byte[] jpegImageToJpegByteArray(ImageProxy r100) {
        int r101 = 0;
        ByteBuffer r102 = r100.getPlanes()[0].getBuffer();
        byte[] r103 = new byte[r102.capacity()];
        r102.rewind();
        r102.get(r103);
        if (canParseSosMarker(r103) == true) goto L9;
        r101 = findSecondFfd8Position(r103);
        if (r101 != (-1)) goto L9;
        return r103;
    L9:
        return Arrays.copyOfRange(r103, r101, r102.limit());
    }
}
