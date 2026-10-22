package androidx.camera.core.internal.compat.quirk;

import K.s0;
import android.os.Build;
import androidx.camera.core.i;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class IncorrectJpegMetadataQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f11597b = new HashSet(Arrays.asList("A24", "BEYOND0", "BEYOND2"));

    public static boolean e() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && f11597b.contains(Build.DEVICE.toUpperCase(Locale.US));
    }

    public static boolean g() {
        return e();
    }

    public final boolean c(byte[] bArr) {
        byte b10;
        int i10 = 2;
        while (i10 + 4 <= bArr.length && (b10 = bArr[i10]) == -1) {
            if (b10 == -1 && bArr[i10 + 1] == -38) {
                return true;
            }
            i10 += (((bArr[i10 + 2] & 255) << 8) | (bArr[i10 + 3] & 255)) + 2;
        }
        return false;
    }

    public final int d(byte[] bArr) {
        int i10 = 2;
        while (true) {
            int i11 = i10 + 1;
            if (i11 > bArr.length) {
                return -1;
            }
            if (bArr[i10] == -1 && bArr[i11] == -40) {
                return i10;
            }
            i10 = i11;
        }
    }

    public byte[] f(i iVar) {
        int iD = 0;
        ByteBuffer byteBufferA = iVar.w0()[0].a();
        byte[] bArr = new byte[byteBufferA.capacity()];
        byteBufferA.rewind();
        byteBufferA.get(bArr);
        return (c(bArr) || (iD = d(bArr)) != -1) ? Arrays.copyOfRange(bArr, iD, byteBufferA.limit()) : bArr;
    }
}
