package com.baidu.sec.privacy.f;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f33530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f33531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f33532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f33533d = null;

    public static int a(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    static {
        f33530a = a(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
        f33531b = new byte[]{34, 120, 93, 28, 86, 125, 58, -72, 104, -79, 40, 125, 82, -26, -85, 124, -100, -25, 25, 17, 88, -127, -116, -8, 0, 33, 70, -4, -1, -110, -69, -85, 5, 81, -70, -27, -98, -7, 42, 124, -74, 47, -120, 124, 20, -14, 74, -107, -69, 116, -101, -8, -89, -71, 99, -124, 9, 55, 107, -18, -114, 5, -79, 58, 64, -110, -51, 78, -29, 69, -51, 63, -77, -73, 106, 43, 10, -95, -98, -112, -50, -87, -98, -91, -61, -39, 57, -75, -31, -85, 80, 89, 42, -25, 45, -119, -18, -90, -56, -101, -23, 59, -91, -52, 124, 83, Base64.padSymbol, -20, 119, -105, -74, 102, -27, 86, 17, -15, -110, 75, -59, 123, -24, 42, 117, 48, 11, 11, -127, 9, 12, -57, 93, -92, -30, -47, -4, 109, -67, 101, 38, -91, -73, -75, -25, 66, -41, -43, -28, -84, -50, 33, -65, 10, -94, 5, -49, -36, 64, -101, 87, -12, 78, 35, -44, 94, -53, -28, 115, 107, 117, -81, -6, 51, 86, 40, -108, -80, 110, -71, -30, -9, 49, -49, 100, 50, -41, 20, -97, 32, -34, -14, 60, -25, 53, -97, 35, -37, -122, -122, -80, 41, 54, 0, -9, -111, 55, 90, 17, 41, 82, -49, -73, 51, 9, 56, 92, 97, -126, 85, 4, -114, -48, 109, -57, 96, -31, -102, -71, -87, -76, -77, -52, 58, 107, 66, -103, 35, 5, 47, -112, 39, -58, 101, 77, -21, 4, -59, 41, -3, 35, -36, 44, 109, 40, -111, 115, 23};
        f33532c = new byte[]{0, -70, 42, -20, -46, -12, -1, -114, 74, -47, 126, -90, 23, -7, -79, -117, -90, 82, 94, 22, -56, 34, -71, -22, 52, 103, -86, -90, -58, -3, 60, -16, 92, 55, 73, -24, 47, -125, 16, 17, -96, -42, 96, 93, Base64.padSymbol, -90, 43, -72, -47, 68, 59, -106, -59, 67, 103, 34, 69, -88, -92, -19, -15, -112, 58, 17, 94, 38, -48, 35, -62, 23, -56, -65, -2, 43, 65, -119, -50, -59, -90, -119, 17, -66, -99, 90, -71, -111, -64, 10, -30, -64, 70, 52, 97, 33, 114, -15, 63, 71, -54, -54, -76, -6, 79, -53, 24, 79, -81, 24, -48, 1, 23, -63, 89, -86, -83, -121, -1, 42, ByteCompanionObject.MAX_VALUE, -46, 93, 3, 77, -39, -81, 123, 114, 20, 89};
        f33533d = new byte[]{0, -113, 121, 53, -39, -71, -86, -23, -65, -85, -19, -120, 122, -49, 73, 81, -74, -13, 46, -59, -98, 59, -81, 55, 24, -24, -22, -60, -106, 31, 62, -3, 54, 6, -25, 67, 81, -87, -60, 24, 51, 57, -72, 9, -25, -62, -82, 28, 83, -101, -89, 71, 91, -123, -48, 17, -83, -72, -76, 121, -121, 117, 73, -124, 105, 92, -84, 14, -113, 20, -77, 54, 8, 40, -94, 47, -6, 39, 17, 10, Base64.padSymbol, 98, -87, -109, 69, 52, 9, -96, -2, 105, 108, 70, 88, -8, 75, -35, 32, -127, -100, 55, 9, -96, 16, 87, -79, -107, -83, -51, 0, 35, Base64.padSymbol, -70, 84, -124, -74, 41, 31, -99, 100, -114, -8, -125, 68, -122, 119, -105, -100, -20, 4, -76, 52, -90, -84, 46, 117, -23, -104, 93, -30, Base64.padSymbol, -80, 41, 47, -63, 17, -116, -97, -6, -99, -127, -127, -25, 51, -115, -73, -110, -73, 48, -41, -71, -29, 73, 89, 47, 104, 9, -104, 114, 21, 57, 21, -22, Base64.padSymbol, 107, -117, 70, 83, -58, 51, 69, -113, ByteCompanionObject.MIN_VALUE, 59, 50, -92, -62, -32, -14, 114, -112, 37, 110, 78, 63, -118, 59, 8, 56, -95, -60, 80, -28, -31, -116, 26, 41, -93, 125, -33, 94, -95, 67, -34, 75, 102, -1, 4, -112, 62, -43, -49, 22, 35, -31, 88, -44, -121, -58, 8, -23, ByteCompanionObject.MAX_VALUE, 33, 28, -40, 29, -54, 35, -53, 110, 56, 7, 101, -8, 34, -29, 66, -66, 72, 76, 5, 118, 57, 57, 96, 28, -42, 103};
    }

    public static byte[] a() {
        return new BigInteger(f33531b).modPow(new BigInteger(f33532c), new BigInteger(f33533d)).toByteArray();
    }

    public static String a(Context r100) {
        PolarisFileInputStreamWrapper r101 = null;
        File r102 = com.baidu.sec.privacy.b.b.a(r100).a(r100.getFilesDir().getParent() + "/.helios/ids/aid/aid.dat");     // Catch: Throwable -> L20
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L18
        byte[] r105 = new byte[32];     // Catch: Throwable -> L16
    L7:
        int r106 = r104.read(r105);     // Catch: Throwable -> L16
        if (r106 <= 0) goto L10;
        r103.write(r105, 0, r106);     // Catch: Throwable -> L16
        goto L7
    L10:
        String r107 = new String(a(ByteBuffer.wrap(r103.toByteArray())), "UTF-8");     // Catch: Throwable -> L16
        r104.close();     // Catch: Throwable -> L13
        r103.close();     // Catch: Throwable -> L13
    L15:
        return r107;
    L13:
        th = move-exception;
        c.a(th);
    L16:
        th = th;
        r101 = r104;
    L45:
        c.a(th);     // Catch: Throwable -> L33
        if (r101 != null) goto L47;
    L27:
        if (r103 == null) goto L58;
        r103.close();     // Catch: Throwable -> L25
        return "";
    L25:
        th = move-exception;
        c.a(th);
        return "";
    L58:
        return "";
    L47:
        r101.close();     // Catch: Throwable -> L25
    L33:
        th = move-exception;
        if (r101 != null) goto L53;
    L38:
        if (r103 == null) goto L42;
        r103.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        c.a(th);
    L42:
        throw th;
    L53:
        r101.close();     // Catch: Throwable -> L36
    L18:
        th = th;
    L20:
        th = th;
        r103 = null;
        goto L45
    }

    public static String b(Context r100) {
        Uri r101 = Uri.parse("content://" + r100.getPackageName() + ".helios.ipc.default");     // Catch: Throwable -> L11
        IBinder r102 = r100.getContentResolver().call(r101, "_method_get_bridge", "", new Bundle()).getBinder("bridge_binder");     // Catch: Throwable -> L11
        Parcel r103 = Parcel.obtain();     // Catch: Throwable -> L11
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L11
        r103.writeInterfaceToken("com.baidu.helios.bridge.multiprocess.IMultiProcessBridge");     // Catch: Throwable -> L11
        r103.writeString("aid");     // Catch: Throwable -> L11
        INVOKEINTERFACE_com_baidu_sec_privacy_f_b_com_obric_assistant_interaction_impl_BinderLancet_transact(r102, 1, r103, r104, 0);     // Catch: Throwable -> L11
        r104.readException();     // Catch: Throwable -> L11
        if (r104.readInt() == 0) goto L13;
        return ((Bundle) Bundle.CREATOR.createFromParcel(r104)).getString("id");
    L13:
        return "";
    L11:
        th = move-exception;
        c.a(th);
        goto L13
    }

    public static void a(int[] r110) {
        int r100 = 0;
    L4:
        if (r100 >= 10) goto L6;
        a(r110, 0, 4, 8, 12);
        a(r110, 1, 5, 9, 13);
        a(r110, 2, 6, 10, 14);
        a(r110, 3, 7, 11, 15);
        a(r110, 0, 5, 10, 15);
        a(r110, 1, 6, 11, 12);
        a(r110, 2, 7, 8, 13);
        a(r110, 3, 4, 9, 14);
        r100 = r100 + 1;
        goto L4
    }

    public static byte[] a(ByteBuffer r100) throws GeneralSecurityException {
        if (r100.remaining() < 12) goto L7;
        byte[] r101 = new byte[12];
        r100.get(r101);
        ByteBuffer r102 = ByteBuffer.allocate(r100.remaining());
        a(r101, a(), r102, r100);
        return r102.array();
    L7:
        throw new GeneralSecurityException("data too short");
    }

    public static int[] a(byte[] r100) {
        IntBuffer r101 = ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] r102 = new int[r101.remaining()];
        r101.get(r102);
        return r102;
    }

    public static void a(int[] r100, int[] r101) {
        int[] r102 = f33530a;
        System.arraycopy(r102, 0, r100, 0, r102.length);
        System.arraycopy(r101, 0, r100, r102.length, 8);
    }

    public static ByteBuffer a(byte[] r100, byte[] r101, int r102) {
        int[] r103 = a(a(r100), a(r101), r102);
        int[] r104 = (int[]) r103.clone();
        a(r104);
        int r105 = 0;
    L4:
        if (r105 >= r103.length) goto L6;
        r103[r105] = r103[r105] + r104[r105];
        r105 = r105 + 1;
        goto L4
    L6:
        ByteBuffer r106 = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        r106.asIntBuffer().put(r103, 0, 16);
        return r106;
    }

    public static int[] a(int[] r100, int[] r101, int r102) {
        if (r100.length != 3) goto L7;
        int[] r103 = new int[16];
        a(r103, r101);
        r103[12] = r102;
        System.arraycopy(r100, 0, r103, 13, r100.length);
        return r103;
    L7:
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", new Object[]{Integer.valueOf(r100.length * 32)}));
    }

    public static void a(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102, int r103) {
        if (r103 < 0) goto L14;
        if (r101.remaining() < r103) goto L14;
        if (r102.remaining() < r103) goto L14;
        if (r100.remaining() < r103) goto L14;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        r100.put((byte) (r101.get() ^ r102.get()));
        r104 = r104 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static void a(byte[] r100, byte[] r101, ByteBuffer r102, ByteBuffer r103) {
        int r104 = r103.remaining();
        int r105 = (r104 / 64) + 1;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        ByteBuffer r107 = a(r100, r101, r106 + 32);
        if (r106 != (r105 - 1)) goto L7;
        a(r102, r103, r107, r104 % 64);
    L8:
        r106 = r106 + 1;
        goto L3
    L7:
        a(r102, r103, r107, 64);
        goto L8
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_baidu_sec_privacy_f_b_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }

    public static void a(int[] r100, int r101, int r102, int r103, int r104) {
        int r105 = r100[r101] + r100[r102];
        r100[r101] = r105;
        int r106 = a(r105 ^ r100[r104], 16);
        r100[r104] = r106;
        int r107 = r100[r103] + r106;
        r100[r103] = r107;
        int r108 = a(r100[r102] ^ r107, 12);
        r100[r102] = r108;
        int r109 = r100[r101] + r108;
        r100[r101] = r109;
        int r110 = a(r100[r104] ^ r109, 8);
        r100[r104] = r110;
        int r111 = r100[r103] + r110;
        r100[r103] = r111;
        r100[r102] = a(r100[r102] ^ r111, 7);
    }
}
