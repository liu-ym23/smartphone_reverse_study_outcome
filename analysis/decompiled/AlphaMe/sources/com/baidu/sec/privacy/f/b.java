package com.baidu.sec.privacy.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.stepos.activeview.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9441a = a(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f9442b = {34, 120, 93, 28, 86, 125, 58, -72, 104, -79, 40, 125, 82, -26, -85, 124, -100, -25, 25, 17, 88, -127, -116, -8, 0, 33, 70, -4, -1, -110, -69, -85, 5, 81, -70, -27, -98, -7, 42, 124, -74, 47, -120, 124, 20, -14, 74, -107, -69, 116, -101, -8, -89, -71, 99, -124, 9, 55, 107, -18, -114, 5, -79, 58, 64, -110, -51, 78, -29, 69, -51, 63, -77, -73, 106, 43, 10, -95, -98, -112, -50, -87, -98, -91, -61, -39, 57, -75, -31, -85, 80, 89, 42, -25, 45, -119, -18, -90, -56, -101, -23, 59, -91, -52, 124, 83, Base64.padSymbol, -20, 119, -105, -74, 102, -27, 86, 17, -15, -110, 75, -59, 123, -24, 42, 117, 48, 11, 11, -127, 9, 12, -57, 93, -92, -30, -47, -4, 109, -67, 101, 38, -91, -73, -75, -25, 66, -41, -43, -28, -84, -50, 33, -65, 10, -94, 5, -49, -36, 64, -101, 87, -12, 78, 35, -44, 94, -53, -28, 115, 107, 117, -81, -6, 51, 86, 40, -108, -80, 110, -71, -30, -9, 49, -49, 100, 50, -41, 20, -97, 32, -34, -14, 60, -25, 53, -97, 35, -37, -122, -122, -80, 41, 54, 0, -9, -111, 55, 90, 17, 41, 82, -49, -73, 51, 9, 56, 92, 97, -126, 85, 4, -114, -48, 109, -57, 96, -31, -102, -71, -87, -76, -77, -52, 58, 107, 66, -103, 35, 5, 47, -112, 39, -58, 101, 77, -21, 4, -59, 41, -3, 35, -36, 44, 109, 40, -111, 115, 23};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f9443c = {0, -70, 42, -20, -46, -12, -1, -114, 74, -47, 126, -90, 23, -7, -79, -117, -90, 82, 94, 22, -56, 34, -71, -22, 52, 103, -86, -90, -58, -3, 60, -16, 92, 55, 73, -24, 47, -125, 16, 17, -96, -42, 96, 93, Base64.padSymbol, -90, 43, -72, -47, 68, 59, -106, -59, 67, 103, 34, 69, -88, -92, -19, -15, -112, 58, 17, 94, 38, -48, 35, -62, 23, -56, -65, -2, 43, 65, -119, -50, -59, -90, -119, 17, -66, -99, 90, -71, -111, -64, 10, -30, -64, 70, 52, 97, 33, 114, -15, 63, 71, -54, -54, -76, -6, 79, -53, 24, 79, -81, 24, -48, 1, 23, -63, 89, -86, -83, -121, -1, 42, ByteCompanionObject.MAX_VALUE, -46, 93, 3, 77, -39, -81, 123, 114, 20, 89};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f9444d = {0, -113, 121, 53, -39, -71, -86, -23, -65, -85, -19, -120, 122, -49, 73, 81, -74, -13, 46, -59, -98, 59, -81, 55, 24, -24, -22, -60, -106, 31, 62, -3, 54, 6, -25, 67, 81, -87, -60, 24, 51, 57, -72, 9, -25, -62, -82, 28, 83, -101, -89, 71, 91, -123, -48, 17, -83, -72, -76, 121, -121, 117, 73, -124, 105, 92, -84, 14, -113, 20, -77, 54, 8, 40, -94, 47, -6, 39, 17, 10, Base64.padSymbol, 98, -87, -109, 69, 52, 9, -96, -2, 105, 108, 70, 88, -8, 75, -35, 32, -127, -100, 55, 9, -96, 16, 87, -79, -107, -83, -51, 0, 35, Base64.padSymbol, -70, 84, -124, -74, 41, 31, -99, 100, -114, -8, -125, 68, -122, 119, -105, -100, -20, 4, -76, 52, -90, -84, 46, 117, -23, -104, 93, -30, Base64.padSymbol, -80, 41, 47, -63, 17, -116, -97, -6, -99, -127, -127, -25, 51, -115, -73, -110, -73, 48, -41, -71, -29, 73, 89, 47, 104, 9, -104, 114, 21, 57, 21, -22, Base64.padSymbol, 107, -117, 70, 83, -58, 51, 69, -113, ByteCompanionObject.MIN_VALUE, 59, 50, -92, -62, -32, -14, 114, -112, 37, 110, 78, 63, -118, 59, 8, 56, -95, -60, 80, -28, -31, -116, 26, 41, -93, 125, -33, 94, -95, 67, -34, 75, 102, -1, 4, -112, 62, -43, -49, 22, 35, -31, 88, -44, -121, -58, 8, -23, ByteCompanionObject.MAX_VALUE, 33, 28, -40, 29, -54, 35, -53, 110, 56, 7, 101, -8, 34, -29, 66, -66, 72, 76, 5, 118, 57, 57, 96, 28, -42, 103};

    public static int a(int i4, int i5) {
        return (i4 >>> (-i5)) | (i4 << i5);
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context) {
        try {
            IBinder binder = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".helios.ipc.default"), "_method_get_bridge", "", new Bundle()).getBinder("bridge_binder");
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain.writeInterfaceToken("com.baidu.helios.bridge.multiprocess.IMultiProcessBridge");
            parcelObtain.writeString("aid");
            binder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                return ((Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2)).getString("id");
            }
        } catch (Throwable th) {
            c.a(th);
        }
        return "";
    }

    public static String a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        try {
            File fileA = com.baidu.sec.privacy.b.b.a(context).a(context.getFilesDir().getParent() + "/.helios/ids/aid/aid.dat");
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileA);
                try {
                    byte[] bArr = new byte[32];
                    while (true) {
                        int i4 = fileInputStream2.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i4);
                    }
                    String str = new String(a(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())), Constants.UTF_8_CODE);
                    try {
                        fileInputStream2.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        c.a(th);
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    try {
                        c.a(th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                c.a(th3);
                                return "";
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            return "";
                        }
                        byteArrayOutputStream.close();
                        return "";
                    } catch (Throwable th4) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th5) {
                                c.a(th5);
                                throw th4;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= 12) {
            byte[] bArr = new byte[12];
            byteBuffer.get(bArr);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            a(bArr, a(), byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i4) {
        if (i4 < 0 || byteBuffer2.remaining() < i4 || byteBuffer3.remaining() < i4 || byteBuffer.remaining() < i4) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iRemaining = byteBuffer2.remaining();
        int i4 = iRemaining / 64;
        int i5 = i4 + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            ByteBuffer byteBufferA = a(bArr, bArr2, i6 + 32);
            if (i6 == i4) {
                a(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                a(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    public static ByteBuffer a(byte[] bArr, byte[] bArr2, int i4) {
        int[] iArrA = a(a(bArr), a(bArr2), i4);
        int[] iArr = (int[]) iArrA.clone();
        a(iArr);
        for (int i5 = 0; i5 < iArrA.length; i5++) {
            iArrA[i5] = iArrA[i5] + iArr[i5];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrA, 0, 16);
        return byteBufferOrder;
    }

    public static void a(int[] iArr) {
        for (int i4 = 0; i4 < 10; i4++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    public static void a(int[] iArr, int i4, int i5, int i6, int i7) {
        int i8 = iArr[i4] + iArr[i5];
        iArr[i4] = i8;
        int iA = a(i8 ^ iArr[i7], 16);
        iArr[i7] = iA;
        int i9 = iArr[i6] + iA;
        iArr[i6] = i9;
        int iA2 = a(iArr[i5] ^ i9, 12);
        iArr[i5] = iA2;
        int i10 = iArr[i4] + iA2;
        iArr[i4] = i10;
        int iA3 = a(iArr[i7] ^ i10, 8);
        iArr[i7] = iA3;
        int i11 = iArr[i6] + iA3;
        iArr[i6] = i11;
        iArr[i5] = a(iArr[i5] ^ i11, 7);
    }

    public static byte[] a() {
        return new BigInteger(f9442b).modPow(new BigInteger(f9443c), new BigInteger(f9444d)).toByteArray();
    }

    public static int[] a(int[] iArr, int[] iArr2, int i4) {
        if (iArr.length == 3) {
            int[] iArr3 = new int[16];
            a(iArr3, iArr2);
            iArr3[12] = i4;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
    }

    public static int[] a(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f9441a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }
}
