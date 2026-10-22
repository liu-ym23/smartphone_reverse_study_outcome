package androidx.camera.core.impl.utils;

import D.C0761b0;
import M.g;
import M.h;
import M.i;
import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.ai.selector.camera.CustomCameraView;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ExifData {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11497c = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: d, reason: collision with root package name */
    public static final h[] f11498d;

    /* renamed from: e, reason: collision with root package name */
    public static final h[] f11499e;

    /* renamed from: f, reason: collision with root package name */
    public static final h[] f11500f;

    /* renamed from: g, reason: collision with root package name */
    public static final h[] f11501g;

    /* renamed from: h, reason: collision with root package name */
    public static final h[] f11502h;

    /* renamed from: i, reason: collision with root package name */
    public static final h[][] f11503i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashSet<String> f11504j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f11505k;

    /* renamed from: a, reason: collision with root package name */
    public final List<Map<String, g>> f11506a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteOrder f11507b;

    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11508a;

        static {
            int[] iArr = new int[CameraCaptureMetaData$FlashState.values().length];
            f11508a = iArr;
            try {
                iArr[CameraCaptureMetaData$FlashState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11508a[CameraCaptureMetaData$FlashState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11508a[CameraCaptureMetaData$FlashState.FIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f11509c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: d, reason: collision with root package name */
        public static final Pattern f11510d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: e, reason: collision with root package name */
        public static final Pattern f11511e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: f, reason: collision with root package name */
        public static final List<HashMap<String, h>> f11512f = Collections.list(new a());

        /* renamed from: a, reason: collision with root package name */
        public final List<Map<String, g>> f11513a = Collections.list(new C0149b());

        /* renamed from: b, reason: collision with root package name */
        public final ByteOrder f11514b;

        public class a implements Enumeration<HashMap<String, h>> {

            /* renamed from: a, reason: collision with root package name */
            public int f11515a = 0;

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, h> nextElement() {
                HashMap<String, h> map = new HashMap<>();
                for (h hVar : ExifData.f11503i[this.f11515a]) {
                    map.put(hVar.f4484b, hVar);
                }
                this.f11515a++;
                return map;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f11515a < ExifData.f11503i.length;
            }
        }

        /* renamed from: androidx.camera.core.impl.utils.ExifData$b$b, reason: collision with other inner class name */
        public class C0149b implements Enumeration<Map<String, g>> {

            /* renamed from: a, reason: collision with root package name */
            public int f11516a = 0;

            public C0149b() {
            }

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<String, g> nextElement() {
                this.f11516a++;
                return new HashMap();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f11516a < ExifData.f11503i.length;
            }
        }

        public class c implements Enumeration<Map<String, g>> {

            /* renamed from: a, reason: collision with root package name */
            public final Enumeration<Map<String, g>> f11518a;

            public c() {
                this.f11518a = Collections.enumeration(b.this.f11513a);
            }

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<String, g> nextElement() {
                return new HashMap(this.f11518a.nextElement());
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f11518a.hasMoreElements();
            }
        }

        public b(ByteOrder byteOrder) {
            this.f11514b = byteOrder;
        }

        public static Pair<Integer, Integer> b(String str) throws NumberFormatException {
            if (str.contains(Const.STR_MART_COMMA)) {
                String[] strArrSplit = str.split(Const.STR_MART_COMMA, -1);
                Pair<Integer, Integer> pairB = b(strArrSplit[0]);
                if (((Integer) pairB.first).intValue() == 2) {
                    return pairB;
                }
                for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                    Pair<Integer, Integer> pairB2 = b(strArrSplit[i10]);
                    int iIntValue = (((Integer) pairB2.first).equals(pairB.first) || ((Integer) pairB2.second).equals(pairB.first)) ? ((Integer) pairB.first).intValue() : -1;
                    int iIntValue2 = (((Integer) pairB.second).intValue() == -1 || !(((Integer) pairB2.first).equals(pairB.second) || ((Integer) pairB2.second).equals(pairB.second))) ? -1 : ((Integer) pairB.second).intValue();
                    if (iIntValue == -1 && iIntValue2 == -1) {
                        return new Pair<>(2, -1);
                    }
                    if (iIntValue == -1) {
                        pairB = new Pair<>(Integer.valueOf(iIntValue2), -1);
                    } else if (iIntValue2 == -1) {
                        pairB = new Pair<>(Integer.valueOf(iIntValue), -1);
                    }
                }
                return pairB;
            }
            if (!str.contains("/")) {
                try {
                    try {
                        long j10 = Long.parseLong(str);
                        return (j10 < 0 || j10 > 65535) ? j10 < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                    } catch (NumberFormatException unused) {
                        return new Pair<>(2, -1);
                    }
                } catch (NumberFormatException unused2) {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                }
            }
            String[] strArrSplit2 = str.split("/", -1);
            if (strArrSplit2.length == 2) {
                try {
                    long j11 = (long) Double.parseDouble(strArrSplit2[0]);
                    long j12 = (long) Double.parseDouble(strArrSplit2[1]);
                    if (j11 >= 0 && j12 >= 0) {
                        if (j11 <= 2147483647L && j12 <= 2147483647L) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused3) {
                }
            }
            return new Pair<>(2, -1);
        }

        public ExifData a() throws NumberFormatException {
            ArrayList list = Collections.list(new c());
            if (!list.get(1).isEmpty()) {
                d(ExifInterface.TAG_EXPOSURE_PROGRAM, String.valueOf(0), list);
                d(ExifInterface.TAG_EXIF_VERSION, "0230", list);
                d(ExifInterface.TAG_COMPONENTS_CONFIGURATION, ExifData.f11505k, list);
                d(ExifInterface.TAG_METERING_MODE, String.valueOf(0), list);
                d(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(0), list);
                d(ExifInterface.TAG_FLASHPIX_VERSION, "0100", list);
                d(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, String.valueOf(2), list);
                d(ExifInterface.TAG_FILE_SOURCE, String.valueOf(3), list);
                d(ExifInterface.TAG_SCENE_TYPE, String.valueOf(1), list);
                d(ExifInterface.TAG_CUSTOM_RENDERED, String.valueOf(0), list);
                d(ExifInterface.TAG_SCENE_CAPTURE_TYPE, String.valueOf(0), list);
                d(ExifInterface.TAG_CONTRAST, String.valueOf(0), list);
                d(ExifInterface.TAG_SATURATION, String.valueOf(0), list);
                d(ExifInterface.TAG_SHARPNESS, String.valueOf(0), list);
            }
            if (!list.get(2).isEmpty()) {
                d(ExifInterface.TAG_GPS_VERSION_ID, "2300", list);
                d(ExifInterface.TAG_GPS_SPEED_REF, "K", list);
                d(ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                d(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                d(ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                d(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "K", list);
            }
            return new ExifData(this.f11514b, list);
        }

        public b c(String str, String str2) throws NumberFormatException {
            e(str, str2, this.f11513a);
            return this;
        }

        public final void d(String str, String str2, List<Map<String, g>> list) throws NumberFormatException {
            Iterator<Map<String, g>> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().containsKey(str)) {
                    return;
                }
            }
            e(str, str2, list);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        public final void e(java.lang.String r18, java.lang.String r19, java.util.List<java.util.Map<java.lang.String, M.g>> r20) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 784
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.b.e(java.lang.String, java.lang.String, java.util.List):void");
        }

        public b f(long j10) {
            return c(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(j10 / TimeUnit.SECONDS.toNanos(1L)));
        }

        public b g(CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState) throws NumberFormatException {
            int i10;
            if (cameraCaptureMetaData$FlashState == CameraCaptureMetaData$FlashState.UNKNOWN) {
                return this;
            }
            int i11 = a.f11508a[cameraCaptureMetaData$FlashState.ordinal()];
            if (i11 == 1) {
                i10 = 0;
            } else if (i11 == 2) {
                i10 = 32;
            } else {
                if (i11 != 3) {
                    C0761b0.o("ExifData", "Unknown flash state: " + cameraCaptureMetaData$FlashState);
                    return this;
                }
                i10 = 1;
            }
            if ((i10 & 1) == 1) {
                c(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(4));
            }
            return c(ExifInterface.TAG_FLASH, String.valueOf(i10));
        }

        public b h(float f10) {
            return c(ExifInterface.TAG_FOCAL_LENGTH, new i((long) (f10 * 1000.0f), 1000L).toString());
        }

        public b i(int i10) {
            return c(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i10));
        }

        public b j(int i10) {
            return c(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i10));
        }

        public b k(int i10) {
            return c(ExifInterface.TAG_SENSITIVITY_TYPE, String.valueOf(3)).c(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, String.valueOf(Math.min(65535, i10)));
        }

        public b l(float f10) {
            return c(ExifInterface.TAG_F_NUMBER, String.valueOf(f10));
        }

        public b m(int i10) {
            int i11;
            if (i10 == 0) {
                i11 = 1;
            } else if (i10 == 90) {
                i11 = 6;
            } else if (i10 == 180) {
                i11 = 3;
            } else if (i10 != 270) {
                C0761b0.o("ExifData", "Unexpected orientation value: " + i10 + ". Must be one of 0, 90, 180, 270.");
                i11 = 0;
            } else {
                i11 = 8;
            }
            return c(ExifInterface.TAG_ORIENTATION, String.valueOf(i11));
        }

        public b n(WhiteBalanceMode whiteBalanceMode) {
            int iOrdinal = whiteBalanceMode.ordinal();
            return c(ExifInterface.TAG_WHITE_BALANCE, iOrdinal != 0 ? iOrdinal != 1 ? null : String.valueOf(1) : String.valueOf(0));
        }
    }

    static {
        h[] hVarArr = {new h(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new h(ExifInterface.TAG_IMAGE_LENGTH, CustomCameraView.BUTTON_STATE_ONLY_CAPTURE, 3, 4), new h(ExifInterface.TAG_MAKE, 271, 2), new h(ExifInterface.TAG_MODEL, 272, 2), new h(ExifInterface.TAG_ORIENTATION, 274, 3), new h(ExifInterface.TAG_X_RESOLUTION, 282, 5), new h(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new h(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new h(ExifInterface.TAG_SOFTWARE, 305, 2), new h(ExifInterface.TAG_DATETIME, 306, 2), new h(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new h("SubIFDPointer", 330, 4), new h("ExifIFDPointer", 34665, 4), new h("GPSInfoIFDPointer", 34853, 4)};
        f11498d = hVarArr;
        h[] hVarArr2 = {new h(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new h(ExifInterface.TAG_F_NUMBER, 33437, 5), new h(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new h(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new h(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new h(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new h(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new h(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new h(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new h(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new h(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new h(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new h(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new h(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new h(ExifInterface.TAG_METERING_MODE, 37383, 3), new h(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new h(ExifInterface.TAG_FLASH, 37385, 3), new h(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new h(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new h(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new h(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new h(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new h(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new h(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new h(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new h("InteroperabilityIFDPointer", 40965, 4), new h(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new h(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new h(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new h(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new h(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new h(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new h(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new h(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new h(ExifInterface.TAG_CONTRAST, 41992, 3), new h(ExifInterface.TAG_SATURATION, 41993, 3), new h(ExifInterface.TAG_SHARPNESS, 41994, 3)};
        f11499e = hVarArr2;
        h[] hVarArr3 = {new h(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new h(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new h(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10), new h(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new h(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10), new h(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new h(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new h(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new h(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new h(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new h(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new h(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new h(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2)};
        f11500f = hVarArr3;
        f11501g = new h[]{new h("SubIFDPointer", 330, 4), new h("ExifIFDPointer", 34665, 4), new h("GPSInfoIFDPointer", 34853, 4), new h("InteroperabilityIFDPointer", 40965, 4)};
        h[] hVarArr4 = {new h(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        f11502h = hVarArr4;
        f11503i = new h[][]{hVarArr, hVarArr2, hVarArr3, hVarArr4};
        f11504j = new HashSet<>(Arrays.asList(ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_GPS_TIMESTAMP));
        f11505k = new String(new byte[]{1, 2, 3, 0}, StandardCharsets.UTF_8);
    }

    public ExifData(ByteOrder byteOrder, List<Map<String, g>> list) {
        B0.h.i(list.size() == f11503i.length, "Malformed attributes list. Number of IFDs mismatch.");
        this.f11507b = byteOrder;
        this.f11506a = list;
    }

    public static b b() {
        return new b(ByteOrder.BIG_ENDIAN).c(ExifInterface.TAG_ORIENTATION, String.valueOf(1)).c(ExifInterface.TAG_X_RESOLUTION, "72/1").c(ExifInterface.TAG_Y_RESOLUTION, "72/1").c(ExifInterface.TAG_RESOLUTION_UNIT, String.valueOf(2)).c(ExifInterface.TAG_Y_CB_CR_POSITIONING, String.valueOf(1)).c(ExifInterface.TAG_MAKE, Build.MANUFACTURER).c(ExifInterface.TAG_MODEL, Build.MODEL);
    }

    public static ExifData c(androidx.camera.core.i iVar, int i10) {
        b bVarB = b();
        if (iVar.Z0() != null) {
            iVar.Z0().c(bVarB);
        }
        bVarB.m(i10);
        return bVarB.j(iVar.getWidth()).i(iVar.getHeight()).a();
    }

    public Map<String, g> d(int i10) {
        B0.h.c(i10, 0, f11503i.length, "Invalid IFD index: " + i10 + ". Index should be between [0, EXIF_TAGS.length] ");
        return this.f11506a.get(i10);
    }

    public ByteOrder e() {
        return this.f11507b;
    }
}
