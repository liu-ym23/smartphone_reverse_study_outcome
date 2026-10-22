package com.autonavi.jni.location.security;

import com.amap.location.support.bean.gnss.AmapGnssClock;
import com.amap.location.support.bean.location.AmapLocation;
import com.amap.location.support.security.gnssrtk.GnssObservation;
import com.amap.location.support.security.gnssrtk.LinkInfo;
import com.amap.location.support.security.gnssrtk.RtkSolM;
import java.util.List;

/* loaded from: classes.dex */
public class NativeCore {
    private static final String TAG = "nativecore";

    static {
        System.loadLibrary("apssdk");
    }

    public static native int cd(int i10);

    public static native String ce(double d10, int i10);

    public static native void destroy3DMA();

    public static native long encMac(String str);

    public static native String gcl(int i10, int i11, int i12);

    public static native int get3DMA(GnssObservation gnssObservation, long j10, int[] iArr, double[] dArr);

    public static native int get3DMA1(GnssObservation gnssObservation, long j10, List<Object> list, long j11, AmapLocation amapLocation, long j12, int[] iArr, double[] dArr);

    public static native void getIod(List<Object> list, long j10, int[] iArr, boolean z10);

    public static native void getIodByRgm(List<Object> list, AmapGnssClock amapGnssClock, long j10, double d10, double d11, double d12, int[] iArr, boolean z10);

    public static native int getPcd(int i10);

    public static native String gwl(String str, int i10, int i11, String str2, int i12);

    public static native int init3DMA(String str);

    public static native int initIod(String str, double[] dArr);

    public static native void initPcd(String[] strArr);

    public static native int initState();

    public static native void inset_iod_2_hmm(long j10, int i10, int i11);

    public static native int rtkNativeInit();

    public static native void rtkNativeUnInit();

    public static native int rtknchip(GnssObservation gnssObservation, long j10, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3, RtkSolM rtkSolM, LinkInfo linkInfo);

    public static native String saos(String str, String str2, String str3);

    public static native int sendChipGps(long j10, long j11, double d10, double d11, double d12, float f10, float f11, float f12);

    public static native void sendChipGps(long j10, double d10, double d11, float f10, List<String> list);

    public static native int sendGnssStatus(List<Object> list, long j10);

    public static native int setupRTKnav(String str);

    public static native byte[] xxt(byte[] bArr, int i10);

    public static native String xxtAos(String str, String str2, int i10);
}
