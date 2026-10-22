package com.baidu.location;

import androidx.room.AbstractC0351g;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.awareness.AwarenessDataItem;

/* loaded from: classes.dex */
public class Jni {

    /* renamed from: a, reason: collision with root package name */
    private static int f5016a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static int f5017b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static int f5018c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static int f5019d = 11;

    /* renamed from: e, reason: collision with root package name */
    private static int f5020e = 12;

    /* renamed from: f, reason: collision with root package name */
    private static int f5021f = 13;

    /* renamed from: g, reason: collision with root package name */
    private static int f5022g = 14;

    /* renamed from: h, reason: collision with root package name */
    private static int f5023h = 15;

    /* renamed from: i, reason: collision with root package name */
    private static int f5024i = 1024;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f5025j = false;

    static {
        try {
            System.loadLibrary("locSDK8b");
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            f5025j = true;
        }
    }

    private static native String a(byte[] bArr, int i4);

    private static native String b(double d4, double d5, int i4, int i5);

    private static native String c(byte[] bArr, int i4);

    public static double[] coorEncrypt(double d4, double d5, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (f5025j) {
            return dArr;
        }
        int i4 = str.equals("bd09") ? f5016a : str.equals("bd09ll") ? f5017b : str.equals("gcj02") ? f5018c : str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02) ? f5019d : str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02) ? f5020e : str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02) ? f5021f : str.equals("wgs842mc") ? f5023h : -1;
        if (str.equals("gcj2wgs")) {
            i4 = 16;
        }
        try {
            String[] strArrSplit = b(d4, d5, i4, 132456).split(AwarenessDataItem.USERID_SPLITTER);
            dArr[0] = Double.parseDouble(strArrSplit[0]);
            dArr[1] = Double.parseDouble(strArrSplit[1]);
        } catch (Throwable unused) {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    private static native String ee(String str, int i4);

    public static String en1(String str) {
        if (f5025j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f5024i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            byte b4 = bytes[i5];
            if (b4 != 0) {
                bArr[i4] = b4;
                i4++;
            }
        }
        try {
            return a(bArr, 132456);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        if (f5025j) {
            return "err!";
        }
        return en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        if (f5025j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        try {
            return c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            return "err!";
        }
    }

    public static Long encode3(String str) {
        String str2;
        if (f5025j) {
            return null;
        }
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8_CODE);
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static native String encodeNotLimit(String str, int i4);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        String strEncodeNotLimit = "err!";
        if (f5025j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8_CODE);
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            strEncodeNotLimit = encodeNotLimit(str2, 132456);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
        }
        return AbstractC0351g.p(strEncodeNotLimit, "|tp=3");
    }

    public static String encodeTp4(String str) {
        String str2;
        String strEe = "err!";
        if (f5025j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8_CODE);
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            strEe = ee(str2, 132456);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
        }
        return AbstractC0351g.p(strEe, "|tp=4");
    }

    public static String encodeTp4NoTag(String str) {
        String str2;
        if (f5025j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8_CODE);
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return ee(str2, 132456);
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            return "err!";
        }
    }

    public static double getGpsSwiftRadius(float f4, double d4, double d5) {
        if (f5025j) {
            return 0.0d;
        }
        try {
            return gsr(f4, d4, d5);
        } catch (UnsatisfiedLinkError unused) {
            return 0.0d;
        }
    }

    public static String getldkaiv() {
        if (f5025j) {
            return null;
        }
        try {
            return ldkaiv();
        } catch (UnsatisfiedLinkError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static native double gsr(float f4, double d4, double d5);

    private static native String ldkaiv();

    private static native long murmur(String str);
}
