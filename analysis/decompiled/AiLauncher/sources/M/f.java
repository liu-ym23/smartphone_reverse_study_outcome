package M;

import D.C0761b0;
import android.location.Location;
import androidx.exifinterface.media.ExifInterface;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final String f4466c = "f";

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f4467d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f4468e = new b();

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f4469f = new c();

    /* renamed from: g, reason: collision with root package name */
    public static final List<String> f4470g = n();

    /* renamed from: h, reason: collision with root package name */
    public static final List<String> f4471h = Arrays.asList(ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, ExifInterface.TAG_THUMBNAIL_ORIENTATION);

    /* renamed from: a, reason: collision with root package name */
    public final ExifInterface f4472a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4473b = false;

    public class a extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    }

    public class b extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    }

    public class c extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    }

    public static final class d {

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final double f4474a;

            public a(double d10) {
                this.f4474a = d10;
            }

            public double a() {
                return this.f4474a / 2.23694d;
            }
        }

        public static a a(double d10) {
            return new a(d10 * 0.621371d);
        }

        public static a b(double d10) {
            return new a(d10 * 1.15078d);
        }

        public static a c(double d10) {
            return new a(d10);
        }
    }

    public f(ExifInterface exifInterface) {
        this.f4472a = exifInterface;
    }

    public static Date c(String str) throws ParseException {
        return f4467d.get().parse(str);
    }

    public static Date d(String str) throws ParseException {
        return f4469f.get().parse(str);
    }

    public static Date e(String str) throws ParseException {
        return f4468e.get().parse(str);
    }

    public static String f(long j10) {
        return f4469f.get().format(new Date(j10));
    }

    public static f h(File file) throws IOException {
        return i(file.toString());
    }

    public static f i(String str) throws IOException {
        return new f(new ExifInterface(str));
    }

    public static f j(androidx.camera.core.i iVar) throws IOException {
        ByteBuffer byteBufferA = iVar.w0()[0].a();
        byteBufferA.rewind();
        byte[] bArr = new byte[byteBufferA.capacity()];
        byteBufferA.get(bArr);
        return k(new ByteArrayInputStream(bArr));
    }

    public static f k(InputStream inputStream) throws IOException {
        return new f(new ExifInterface(inputStream));
    }

    public static List<String> n() {
        return Arrays.asList(ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_SAMPLES_PER_PIXEL, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, ExifInterface.TAG_Y_CB_CR_POSITIONING, ExifInterface.TAG_X_RESOLUTION, ExifInterface.TAG_Y_RESOLUTION, ExifInterface.TAG_RESOLUTION_UNIT, ExifInterface.TAG_STRIP_OFFSETS, ExifInterface.TAG_ROWS_PER_STRIP, ExifInterface.TAG_STRIP_BYTE_COUNTS, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_TRANSFER_FUNCTION, ExifInterface.TAG_WHITE_POINT, ExifInterface.TAG_PRIMARY_CHROMATICITIES, ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, ExifInterface.TAG_REFERENCE_BLACK_WHITE, ExifInterface.TAG_DATETIME, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_FLASHPIX_VERSION, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_GAMMA, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPONENTS_CONFIGURATION, ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_RELATED_SOUND_FILE, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_OFFSET_TIME, ExifInterface.TAG_OFFSET_TIME_ORIGINAL, ExifInterface.TAG_OFFSET_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_SPECTRAL_SENSITIVITY, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_OECF, ExifInterface.TAG_SENSITIVITY_TYPE, ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_FLASH, ExifInterface.TAG_SUBJECT_AREA, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_SENSING_METHOD, ExifInterface.TAG_FILE_SOURCE, ExifInterface.TAG_SCENE_TYPE, ExifInterface.TAG_CFA_PATTERN, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_SCENE_CAPTURE_TYPE, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_IMAGE_UNIQUE_ID, "CameraOwnerName", ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_H_POSITIONING_ERROR, ExifInterface.TAG_INTEROPERABILITY_INDEX, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, ExifInterface.TAG_THUMBNAIL_ORIENTATION, ExifInterface.TAG_DNG_VERSION, ExifInterface.TAG_DEFAULT_CROP_SIZE, ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, ExifInterface.TAG_ORF_ASPECT_FRAME, ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, ExifInterface.TAG_RW2_ISO, ExifInterface.TAG_RW2_JPG_FROM_RAW, ExifInterface.TAG_XMP, ExifInterface.TAG_NEW_SUBFILE_TYPE, ExifInterface.TAG_SUBFILE_TYPE);
    }

    public void A() throws Throwable {
        if (!this.f4473b) {
            a();
        }
        this.f4472a.saveAttributes();
    }

    public final void a() throws NumberFormatException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strF = f(jCurrentTimeMillis);
        this.f4472a.setAttribute(ExifInterface.TAG_DATETIME, strF);
        try {
            this.f4472a.setAttribute(ExifInterface.TAG_SUBSEC_TIME, Long.toString(jCurrentTimeMillis - d(strF).getTime()));
        } catch (ParseException unused) {
        }
    }

    public void b(Location location) throws NumberFormatException {
        this.f4472a.setGpsInfo(location);
    }

    public void g(f fVar) throws NumberFormatException {
        ArrayList<String> arrayList = new ArrayList(f4470g);
        arrayList.removeAll(f4471h);
        for (String str : arrayList) {
            String attribute = this.f4472a.getAttribute(str);
            String attribute2 = fVar.f4472a.getAttribute(str);
            if (attribute != null && !attribute.equals(attribute2)) {
                fVar.f4472a.setAttribute(str, attribute);
            }
        }
    }

    public void l() throws NumberFormatException {
        int i10;
        switch (r()) {
            case 2:
                i10 = 1;
                break;
            case 3:
                i10 = 4;
                break;
            case 4:
                i10 = 3;
                break;
            case 5:
                i10 = 6;
                break;
            case 6:
                i10 = 5;
                break;
            case 7:
                i10 = 8;
                break;
            case 8:
                i10 = 7;
                break;
            default:
                i10 = 2;
                break;
        }
        this.f4472a.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i10));
    }

    public void m() throws NumberFormatException {
        int i10;
        switch (r()) {
            case 2:
                i10 = 3;
                break;
            case 3:
                i10 = 2;
                break;
            case 4:
                i10 = 1;
                break;
            case 5:
                i10 = 8;
                break;
            case 6:
                i10 = 7;
                break;
            case 7:
                i10 = 6;
                break;
            case 8:
                i10 = 5;
                break;
            default:
                i10 = 4;
                break;
        }
        this.f4472a.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i10));
    }

    public String o() {
        return this.f4472a.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
    }

    public int p() {
        return this.f4472a.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.location.Location q() {
        /*
            r15 = this;
            androidx.exifinterface.media.ExifInterface r0 = r15.f4472a
            java.lang.String r1 = "GPSProcessingMethod"
            java.lang.String r0 = r0.getAttribute(r1)
            androidx.exifinterface.media.ExifInterface r1 = r15.f4472a
            double[] r1 = r1.getLatLong()
            androidx.exifinterface.media.ExifInterface r2 = r15.f4472a
            r3 = 0
            double r5 = r2.getAltitude(r3)
            androidx.exifinterface.media.ExifInterface r2 = r15.f4472a
            java.lang.String r7 = "GPSSpeed"
            double r7 = r2.getAttributeDouble(r7, r3)
            androidx.exifinterface.media.ExifInterface r2 = r15.f4472a
            java.lang.String r9 = "GPSSpeedRef"
            java.lang.String r2 = r2.getAttribute(r9)
            java.lang.String r9 = "K"
            if (r2 != 0) goto L2b
            r2 = r9
        L2b:
            androidx.exifinterface.media.ExifInterface r10 = r15.f4472a
            java.lang.String r11 = "GPSDateStamp"
            java.lang.String r10 = r10.getAttribute(r11)
            androidx.exifinterface.media.ExifInterface r11 = r15.f4472a
            java.lang.String r12 = "GPSTimeStamp"
            java.lang.String r11 = r11.getAttribute(r12)
            long r10 = r15.y(r10, r11)
            if (r1 != 0) goto L43
            r15 = 0
            return r15
        L43:
            if (r0 != 0) goto L47
            java.lang.String r0 = M.f.f4466c
        L47:
            android.location.Location r15 = new android.location.Location
            r15.<init>(r0)
            r0 = 0
            r12 = r1[r0]
            r15.setLatitude(r12)
            r12 = 1
            r13 = r1[r12]
            r15.setLongitude(r13)
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L5f
            r15.setAltitude(r5)
        L5f:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto Lb2
            int r1 = r2.hashCode()
            r3 = 75
            if (r1 == r3) goto L87
            r3 = 77
            if (r1 == r3) goto L7e
            r0 = 78
            if (r1 == r0) goto L74
            goto L8f
        L74:
            java.lang.String r0 = "N"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L8f
            r0 = r12
            goto L90
        L7e:
            java.lang.String r1 = "M"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L8f
            goto L90
        L87:
            boolean r0 = r2.equals(r9)
            if (r0 == 0) goto L8f
            r0 = 2
            goto L90
        L8f:
            r0 = -1
        L90:
            if (r0 == 0) goto La6
            if (r0 == r12) goto L9d
            M.f$d$a r0 = M.f.d.a(r7)
            double r0 = r0.a()
            goto Lae
        L9d:
            M.f$d$a r0 = M.f.d.b(r7)
            double r0 = r0.a()
            goto Lae
        La6:
            M.f$d$a r0 = M.f.d.c(r7)
            double r0 = r0.a()
        Lae:
            float r0 = (float) r0
            r15.setSpeed(r0)
        Lb2:
            r0 = -1
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 == 0) goto Lbb
            r15.setTime(r10)
        Lbb:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: M.f.q():android.location.Location");
    }

    public int r() {
        return this.f4472a.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
    }

    public int s() {
        switch (r()) {
            case 3:
            case 4:
                return 180;
            case 5:
                return SubsamplingScaleImageView.ORIENTATION_270;
            case 6:
            case 7:
                return 90;
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    public long t() throws NumberFormatException {
        long jX = x(this.f4472a.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (jX == -1) {
            return -1L;
        }
        String attribute = this.f4472a.getAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
        if (attribute == null) {
            return jX;
        }
        try {
            long j10 = Long.parseLong(attribute);
            while (j10 > 1000) {
                j10 /= 10;
            }
            return jX + j10;
        } catch (NumberFormatException unused) {
            return jX;
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(u()), Integer.valueOf(p()), Integer.valueOf(s()), Boolean.valueOf(w()), Boolean.valueOf(v()), q(), Long.valueOf(t()), o());
    }

    public int u() {
        return this.f4472a.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
    }

    public boolean v() {
        return r() == 2;
    }

    public boolean w() {
        int iR = r();
        return iR == 4 || iR == 5 || iR == 7;
    }

    public final long x(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return d(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public final long y(String str, String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return c(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (str == null) {
            try {
                return e(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return x(str + " " + str2);
    }

    public void z(int i10) throws NumberFormatException {
        if (i10 % 90 != 0) {
            C0761b0.o(f4466c, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i10)));
            this.f4472a.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(0));
            return;
        }
        int i11 = i10 % 360;
        int iR = r();
        while (i11 < 0) {
            i11 += 90;
            switch (iR) {
                case 2:
                    iR = 5;
                    break;
                case 3:
                case 8:
                    iR = 6;
                    break;
                case 4:
                    iR = 7;
                    break;
                case 5:
                    iR = 4;
                    break;
                case 6:
                    iR = 1;
                    break;
                case 7:
                    iR = 2;
                    break;
                default:
                    iR = 8;
                    break;
            }
        }
        while (i11 > 0) {
            i11 -= 90;
            switch (iR) {
                case 2:
                    iR = 7;
                    break;
                case 3:
                    iR = 8;
                    break;
                case 4:
                    iR = 5;
                    break;
                case 5:
                    iR = 2;
                    break;
                case 6:
                    iR = 3;
                    break;
                case 7:
                    iR = 4;
                    break;
                case 8:
                    iR = 1;
                    break;
                default:
                    iR = 6;
                    break;
            }
        }
        this.f4472a.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(iR));
    }
}
