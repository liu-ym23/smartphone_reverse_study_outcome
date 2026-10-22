package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

/* renamed from: com.amap.api.col.jmsl.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1570k {

    /* renamed from: a, reason: collision with root package name */
    public static long f16699a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, Long> f16700b = new HashMap<>();

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        int length = 0;
        for (int i10 = 0; i10 < iMin; i10++) {
            length = strArrSplit[i10].length() - strArrSplit2[i10].length();
            if (length != 0 || (length = strArrSplit[i10].compareTo(strArrSplit2[i10])) != 0) {
                break;
            }
        }
        return length != 0 ? length : strArrSplit.length - strArrSplit2.length;
    }

    public static Bitmap b(View view) {
        try {
            u(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static C1569j2 c() {
        try {
            if (C1623x1.f17032c == null) {
                C1623x1.f17032c = new C1569j2.a("3dmap-lite", "1.2.0", C1623x1.f17031b).c(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("1.2.0").d();
            }
            return C1623x1.f17032c;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String e(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (String str : strArr) {
            sb2.append(str);
            if (i10 != strArr.length - 1) {
                sb2.append(Const.STR_MART_COMMA);
            }
            i10++;
        }
        return sb2.toString();
    }

    public static void f(Bitmap bitmap) {
    }

    public static void g(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void h(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void i(String str) {
        Log.e("mapcore-time", str.trim() + " cost " + (System.currentTimeMillis() - f16699a));
    }

    public static void j(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void k(List<LatLng> list, LatLng latLng, double d10) {
        if (latLng == null || list == null) {
            return;
        }
        double d11 = d10 >= 0.0d ? d10 : 0.0d;
        double d12 = 6.283185307179586d / 360;
        for (int i10 = 0; i10 < 360; i10++) {
            double d13 = i10 * d12;
            list.add(new LatLng(latLng.latitude + ((Math.sin(d13) * d11) / 111194.94043265983d), latLng.longitude + ((Math.cos(d13) * d11) / (((6371000.79d * Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d)) * 3.141592653589793d) / 180.0d))));
        }
    }

    public static boolean l(double d10, double d11, double d12, double d13, double d14, double d15) {
        return Math.abs(((d12 - d10) * (d15 - d11)) - ((d14 - d10) * (d13 - d11))) < 1.0E-9d && (d10 - d12) * (d10 - d14) <= 0.0d && (d11 - d13) * (d11 - d15) <= 0.0d;
    }

    public static boolean m(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d12 - d10;
        double d19 = d17 - d15;
        double d20 = d13 - d11;
        double d21 = d16 - d14;
        double d22 = (d18 * d19) - (d20 * d21);
        if (d22 == 0.0d) {
            return false;
        }
        double d23 = d11 - d15;
        double d24 = d10 - d14;
        double d25 = ((d21 * d23) - (d19 * d24)) / d22;
        double d26 = ((d23 * d18) - (d24 * d20)) / d22;
        return d25 >= 0.0d && d25 <= 1.0d && d26 >= 0.0d && d26 <= 1.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
    
        if (r4 > r12) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(com.amap.api.maps.model.LatLng r29, java.util.List<com.amap.api.maps.model.LatLng> r30) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1570k.n(com.amap.api.maps.model.LatLng, java.util.List):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean o(com.amap.api.maps.model.PolygonOptions r6, com.amap.api.maps.model.LatLng r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.util.List r1 = r6.getHoleOptions()     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L56
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L3c
            if (r2 <= 0) goto L56
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L3c
        L14:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L56
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L3c
            com.amap.api.maps.model.BaseHoleOptions r2 = (com.amap.api.maps.model.BaseHoleOptions) r2     // Catch: java.lang.Throwable -> L3c
            boolean r3 = r2 instanceof com.amap.api.maps.model.CircleHoleOptions     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            com.amap.api.maps.model.CircleHoleOptions r2 = (com.amap.api.maps.model.CircleHoleOptions) r2     // Catch: java.lang.Throwable -> L3c
            com.amap.api.maps.model.LatLng r3 = r2.getCenter()     // Catch: java.lang.Throwable -> L3c
            double r4 = r2.getRadius()     // Catch: java.lang.Throwable -> L3c
            if (r3 != 0) goto L31
            goto L52
        L31:
            float r2 = com.amap.api.maps.AMapUtils.calculateLineDistance(r3, r7)     // Catch: java.lang.Throwable -> L3c
            double r2 = (double) r2     // Catch: java.lang.Throwable -> L3c
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L52
            r2 = 1
            goto L53
        L3c:
            r6 = move-exception
            goto L5f
        L3e:
            com.amap.api.maps.model.PolygonHoleOptions r2 = (com.amap.api.maps.model.PolygonHoleOptions) r2     // Catch: java.lang.Throwable -> L3c
            java.util.List r2 = r2.getPoints()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L52
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L3c
            if (r3 != 0) goto L4d
            goto L52
        L4d:
            boolean r2 = n(r7, r2)     // Catch: java.lang.Throwable -> L3c
            goto L53
        L52:
            r2 = r0
        L53:
            if (r2 == 0) goto L14
            return r0
        L56:
            java.util.List r6 = r6.getPoints()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = n(r7, r6)     // Catch: java.lang.Throwable -> L3c
            return r6
        L5f:
            r6.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1570k.o(com.amap.api.maps.model.PolygonOptions, com.amap.api.maps.model.LatLng):boolean");
    }

    public static byte[] p(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
        } catch (IOException unused) {
            inputStreamOpen = null;
        } catch (OutOfMemoryError unused2) {
            inputStreamOpen = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            int iAvailable = inputStreamOpen.available();
            if (iAvailable == 0) {
                g(inputStreamOpen);
                return null;
            }
            byte[] bArr = new byte[iAvailable];
            for (int i10 = 0; i10 < iAvailable; i10 += inputStreamOpen.read(bArr, i10, iAvailable - i10)) {
            }
            g(inputStreamOpen);
            return bArr;
        } catch (IOException unused3) {
            g(inputStreamOpen);
            return null;
        } catch (OutOfMemoryError unused4) {
            g(inputStreamOpen);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpen;
            g(inputStream);
            throw th;
        }
    }

    public static String q(View view) {
        StringBuilder sb2 = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb2 = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        String strQ = q(((ViewGroup) view).getChildAt(i10));
                        if (!TextUtils.isEmpty(strQ)) {
                            sb2.append("--");
                            sb2.append(strQ);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb2.toString();
    }

    public static void r() {
        System.currentTimeMillis();
        f16699a = System.currentTimeMillis();
    }

    public static byte[] s(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                h(null);
                g(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            C1541c2.b(th, "FileUtil", "readFileContents");
                            j(th);
                            return null;
                        } finally {
                            h(byteArrayOutputStream);
                            g(fileInputStream);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static long t(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l10 = f16700b.get(str);
        if (l10 != null) {
            return jCurrentTimeMillis - l10.longValue();
        }
        return 0L;
    }

    public static void u(View view) {
        int i10 = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i10 >= viewGroup.getChildCount()) {
                    return;
                }
                u(viewGroup.getChildAt(i10));
                i10++;
            }
        }
    }

    public static void v(String str) {
        f16700b.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
