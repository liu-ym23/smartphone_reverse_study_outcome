package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class Exif {
    private static final List<String> ALL_EXIF_TAGS = null;
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = null;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = null;
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = null;
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = null;
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = null;
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp;

    public static final class Speed {

        public static final class Converter {
            final double mMph;

            public double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }

            public Converter(double r100) {
                this.mMph = r100;
            }
        }

        private Speed() {
        }

        public static Converter fromKilometersPerHour(double r100) {
            return new Converter(r100 * 0.621371d);
        }

        public static Converter fromKnots(double r100) {
            return new Converter(r100 * 1.15078d);
        }

        public static Converter fromMilesPerHour(double r100) {
            return new Converter(r100);
        }
    }

    static {
        TAG = "Exif";
        DATE_FORMAT = new AnonymousClass1();
        TIME_FORMAT = new AnonymousClass2();
        DATETIME_FORMAT = new AnonymousClass3();
        ALL_EXIF_TAGS = getAllExifTags();
        DO_NOT_COPY_EXIF_TAGS = Arrays.asList(new String[]{ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, "ThumbnailOrientation"});
    }

    public static List<String> getAllExifTags() {
        return Arrays.asList(new String[]{ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_SAMPLES_PER_PIXEL, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, ExifInterface.TAG_Y_CB_CR_POSITIONING, ExifInterface.TAG_X_RESOLUTION, ExifInterface.TAG_Y_RESOLUTION, ExifInterface.TAG_RESOLUTION_UNIT, ExifInterface.TAG_STRIP_OFFSETS, ExifInterface.TAG_ROWS_PER_STRIP, ExifInterface.TAG_STRIP_BYTE_COUNTS, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_TRANSFER_FUNCTION, ExifInterface.TAG_WHITE_POINT, ExifInterface.TAG_PRIMARY_CHROMATICITIES, ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, ExifInterface.TAG_REFERENCE_BLACK_WHITE, ExifInterface.TAG_DATETIME, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_FLASHPIX_VERSION, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_GAMMA, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_COMPONENTS_CONFIGURATION, ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_RELATED_SOUND_FILE, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_SPECTRAL_SENSITIVITY, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_OECF, ExifInterface.TAG_SENSITIVITY_TYPE, ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_FLASH, ExifInterface.TAG_SUBJECT_AREA, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_SENSING_METHOD, ExifInterface.TAG_FILE_SOURCE, ExifInterface.TAG_SCENE_TYPE, ExifInterface.TAG_CFA_PATTERN, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_SCENE_CAPTURE_TYPE, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_IMAGE_UNIQUE_ID, "CameraOwnerName", ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_H_POSITIONING_ERROR, ExifInterface.TAG_INTEROPERABILITY_INDEX, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, "ThumbnailOrientation", ExifInterface.TAG_DNG_VERSION, ExifInterface.TAG_DEFAULT_CROP_SIZE, ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, ExifInterface.TAG_ORF_ASPECT_FRAME, ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, ExifInterface.TAG_RW2_ISO, ExifInterface.TAG_RW2_JPG_FROM_RAW, ExifInterface.TAG_XMP, ExifInterface.TAG_NEW_SUBFILE_TYPE, ExifInterface.TAG_SUBFILE_TYPE});
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
    }

    public long getLastModifiedTimestamp() {
        long r100 = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME));
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        String r101 = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME);
        if (r101 == null) goto L19;
        long r102 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L14
    L9:
        if (r102 <= 1000) goto L13;
        r102 = r102 / 10;     // Catch: NumberFormatException -> L14
    L13:
        return r100 + r102;
    L20:
        return r100;
    L19:
        return r100;
    }

    public Location getLocation() {
        String r100 = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD);
        double[] r101 = this.mExifInterface.getLatLong();
        double r102 = this.mExifInterface.getAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        double r103 = this.mExifInterface.getAttributeDouble(ExifInterface.TAG_GPS_SPEED, AudioStats.AUDIO_AMPLITUDE_NONE);
        String r104 = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_SPEED_REF);
        if (r104 != null) goto L5;
        r104 = "K";
    L5:
        long r110 = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_DATESTAMP), this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP));
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r100 != null) goto L11;
        r100 = TAG;
    L11:
        Location r111 = new Location(r100);
        r111.setLatitude(r101[0]);
        r111.setLongitude(r101[1]);
        if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r111.setAltitude(r102);
    L15:
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        int r105 = r104.hashCode();
        if (r105 == 75) goto L30;
        if (r105 == 77) goto L27;
        if (r105 == 78) goto L24;
    L32:
        byte r106 = -1;
    L33:
        if (r106 == 0) goto L37;
        if (r106 == 1) goto L36;
        double r107 = Speed.fromKilometersPerHour(r103).toMetersPerSecond();
    L38:
        r111.setSpeed((float) r107);
        goto L40
    L36:
        r107 = Speed.fromKnots(r103).toMetersPerSecond();
        goto L38
    L37:
        r107 = Speed.fromMilesPerHour(r103).toMetersPerSecond();
        goto L38
    L24:
        if (r104.equals("N") == false) goto L32;
        r106 = 1;
        goto L33
    L27:
        if (r104.equals("M") == false) goto L32;
        r106 = 0;
        goto L33
    L30:
        if (r104.equals("K") == false) goto L32;
        r106 = 2;
    L40:
        if (r110 == (-1)) goto L42;
        r111.setTime(r110);
    L42:
        return r111;
    }

    public String getMetadata() {
        return this.mExifInterface.getAttribute(ExifInterface.TAG_XMP);
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
    }

    public long getTimestamp() {
        long r100 = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        String r101 = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
        if (r101 == null) goto L19;
        long r102 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L14
    L9:
        if (r102 <= 1000) goto L13;
        r102 = r102 / 10;     // Catch: NumberFormatException -> L14
    L13:
        return r100 + r102;
    L20:
        return r100;
    L19:
        return r100;
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_DATESTAMP, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_TIMESTAMP, null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, null);
        this.mRemoveTimestamp = true;
    }

    public void save() throws IOException {
        if (this.mRemoveTimestamp == true) goto L5;
        attachLastModifiedTimestamp();
    L5:
        this.mExifInterface.saveAttributes();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription()});
    }

    private void attachLastModifiedTimestamp() {
        long r100 = System.currentTimeMillis();
        String r101 = convertToExifDateTime(r100);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, r101);
        String r102 = Long.toString(r100 - convertFromExifDateTime(r101).getTime());     // Catch: ParseException -> L5
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, r102);     // Catch: ParseException -> L5
        return;
    }

    public void attachTimestamp() {
        long r100 = System.currentTimeMillis();
        String r101 = convertToExifDateTime(r100);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, r101);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, r101);
        String r102 = Long.toString(r100 - convertFromExifDateTime(r101).getTime());     // Catch: ParseException -> L6
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, r102);     // Catch: ParseException -> L6
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, r102);     // Catch: ParseException -> L6
    L4:
        this.mRemoveTimestamp = false;
    }

    public void flipHorizontally() {
        switch(getOrientation()) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        int r100 = 2;
    L12:
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(r100));
        return;
    L5:
        r100 = 7;
        goto L12
    L6:
        r100 = 8;
        goto L12
    L7:
        r100 = 5;
        goto L12
    L8:
        r100 = 6;
        goto L12
    L9:
        r100 = 3;
        goto L12
    L10:
        r100 = 4;
        goto L12
    L11:
        r100 = 1;
        goto L12
    }

    public void flipVertically() {
        switch(getOrientation()) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        int r100 = 4;
    L12:
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(r100));
        return;
    L5:
        r100 = 5;
        goto L12
    L6:
        r100 = 6;
        goto L12
    L7:
        r100 = 7;
        goto L12
    L8:
        r100 = 8;
        goto L12
    L9:
        r100 = 1;
        goto L12
    L10:
        r100 = 2;
        goto L12
    L11:
        r100 = 3;
        goto L12
    }

    public int getRotation() {
        switch(getOrientation()) {
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 270;
    L7:
        return 90;
    L8:
        return 270;
    L9:
        return 180;
    }

    public boolean isFlippedHorizontally() {
        if (getOrientation() == 2) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean isFlippedVertically() {
        int r100 = getOrientation();
        if (r100 != 4) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 5) goto L10;
        if (r100 == 7) goto L10;
        return false;
    }

    public ExifInterface getExifInterface() {
        return this.mExifInterface;
    }

    private Exif(ExifInterface r100) {
        this.mRemoveTimestamp = false;
        this.mExifInterface = r100;
    }

    private static Date convertFromExifDate(String r100) throws ParseException {
        return DATE_FORMAT.get().parse(r100);
    }

    private static Date convertFromExifDateTime(String r100) throws ParseException {
        return DATETIME_FORMAT.get().parse(r100);
    }

    private static Date convertFromExifTime(String r100) throws ParseException {
        return TIME_FORMAT.get().parse(r100);
    }

    private static String convertToExifDateTime(long r100) {
        return DATETIME_FORMAT.get().format(new Date(r100));
    }

    public static Exif createFromFile(File r100) throws IOException {
        return createFromFileString(r100.toString());
    }

    public static Exif createFromFileString(String r100) throws IOException {
        return new Exif(new ExifInterface(r100));
    }

    public static Exif createFromImageProxy(ImageProxy r100) throws IOException {
        ByteBuffer r101 = r100.getPlanes()[0].getBuffer();
        r101.rewind();
        byte[] r102 = new byte[r101.capacity()];
        r101.get(r102);
        return createFromInputStream(new ByteArrayInputStream(r102));
    }

    public static Exif createFromInputStream(InputStream r100) throws IOException {
        return new Exif(new ExifInterface(r100));
    }

    private long parseTimestamp(String r100) {
        if (r100 != null) goto L8;
        return -1;
    L8:
        return convertFromExifDateTime(r100).getTime();
    L10:
        return -1;
    }

    public void attachLocation(Location r100) {
        this.mExifInterface.setGpsInfo(r100);
    }

    public void copyToCroppedImage(Exif r100) {
        ArrayList r101 = new ArrayList(ALL_EXIF_TAGS);
        r101.removeAll(DO_NOT_COPY_EXIF_TAGS);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();
        String r104 = this.mExifInterface.getAttribute(r103);
        String r105 = r100.mExifInterface.getAttribute(r103);
        if (r104 == null) goto L4;
        if (r104.equals(r105) == true) goto L4;
        r100.mExifInterface.setAttribute(r103, r104);
        goto L4
    }

    public void rotate(int r110) {
        if ((r110 % 90) == 0) goto L6;
        Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", new Object[]{Integer.valueOf(r110)}));
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(0));
        return;
    L6:
        int r111 = r110 % 360;
        int r100 = getOrientation();
    L8:
        if (r111 >= 0) goto L18;
        r111 = r111 + 90;
        switch(r100) {
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L16;
            default: goto L11;
        };
    L12:
        r100 = 2;
        goto L8
    L13:
        r100 = 1;
        goto L8
    L14:
        r100 = 4;
        goto L8
    L15:
        r100 = 7;
        goto L8
    L16:
        r100 = 6;
        goto L8
    L17:
        r100 = 5;
        goto L8
    L11:
        r100 = 8;
    L18:
        if (r111 <= 0) goto L29;
        r111 = r111 - 90;
        switch(r100) {
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            default: goto L21;
        };
    L22:
        r100 = 1;
        goto L18
    L23:
        r100 = 4;
        goto L18
    L24:
        r100 = 3;
        goto L18
    L25:
        r100 = 2;
        goto L18
    L26:
        r100 = 5;
        goto L18
    L27:
        r100 = 8;
        goto L18
    L28:
        r100 = 7;
        goto L18
    L21:
        r100 = 6;
        goto L18
    L29:
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(r100));
    }

    public void setDescription(String r100) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION, r100);
    }

    public void setOrientation(int r100) {
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(r100));
    }

    private long parseTimestamp(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r101 == null) goto L16;
        if (r100 != null) goto L15;
        return convertFromExifTime(r101).getTime();
    L13:
        return -1;
    L15:
        return parseTimestamp(r100 + " " + r101);
    L16:
        return convertFromExifDate(r100).getTime();
    L9:
        return -1;
    }
}
