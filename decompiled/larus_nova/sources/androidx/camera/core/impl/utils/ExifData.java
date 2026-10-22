package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.collection.SieveCacheKt;
import androidx.core.util.Preconditions;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttm.player.MediaPlayer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class ExifData {
    private static final boolean DEBUG = false;
    static final ExifTag[] EXIF_POINTER_TAGS = null;
    static final ExifTag[][] EXIF_TAGS = null;
    private static final ExifTag[] IFD_EXIF_TAGS = null;
    static final String[] IFD_FORMAT_NAMES = null;
    private static final ExifTag[] IFD_GPS_TAGS = null;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = null;
    private static final ExifTag[] IFD_TIFF_TAGS = null;
    static final int IFD_TYPE_EXIF = 1;
    static final int IFD_TYPE_GPS = 2;
    static final int IFD_TYPE_INTEROPERABILITY = 3;
    static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    static final HashSet<String> sTagSetForCompatibility = null;
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    /* JADX INFO: renamed from: androidx.camera.core.impl.utils.ExifData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = null;

        static {
            int[] r100 = new int[CameraCaptureMetaData.FlashState.values().length];
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = r100;
            r100[CameraCaptureMetaData.FlashState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.FIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class Builder {
        private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = null;
        private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = null;
        private static final int DATETIME_VALUE_STRING_LENGTH = 19;
        private static final Pattern GPS_TIMESTAMP_PATTERN = null;
        static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting = null;
        final List<Map<String, ExifAttribute>> mAttributes;
        private final ByteOrder mByteOrder;

        static {
            GPS_TIMESTAMP_PATTERN = PatternProtector.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
            DATETIME_PRIMARY_FORMAT_PATTERN = PatternProtector.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
            DATETIME_SECONDARY_FORMAT_PATTERN = PatternProtector.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
            sExifTagMapsForWriting = Collections.list(new AnonymousClass1());
        }

        public ExifData build() {
            ArrayList r100 = Collections.list(new AnonymousClass3(this));
            if (((Map) ListProtector.get(r100, 1)).isEmpty() == true) goto L6;
            setAttributeIfMissing(ExifInterface.TAG_EXPOSURE_PROGRAM, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_EXIF_VERSION, "0230", r100);
            setAttributeIfMissing(ExifInterface.TAG_COMPONENTS_CONFIGURATION, "1,2,3,0", r100);
            setAttributeIfMissing(ExifInterface.TAG_METERING_MODE, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_FLASHPIX_VERSION, AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON, r100);
            setAttributeIfMissing(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, String.valueOf(2), r100);
            setAttributeIfMissing(ExifInterface.TAG_FILE_SOURCE, String.valueOf(3), r100);
            setAttributeIfMissing(ExifInterface.TAG_SCENE_TYPE, String.valueOf(1), r100);
            setAttributeIfMissing(ExifInterface.TAG_CUSTOM_RENDERED, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_SCENE_CAPTURE_TYPE, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_CONTRAST, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_SATURATION, String.valueOf(0), r100);
            setAttributeIfMissing(ExifInterface.TAG_SHARPNESS, String.valueOf(0), r100);
        L6:
            if (((Map) ListProtector.get(r100, 2)).isEmpty() == true) goto L9;
            setAttributeIfMissing(ExifInterface.TAG_GPS_VERSION_ID, "2300", r100);
            setAttributeIfMissing(ExifInterface.TAG_GPS_SPEED_REF, "K", r100);
            setAttributeIfMissing(ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.GPS_DIRECTION_TRUE, r100);
            setAttributeIfMissing(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.GPS_DIRECTION_TRUE, r100);
            setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.GPS_DIRECTION_TRUE, r100);
            setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "K", r100);
        L9:
            return new ExifData(this.mByteOrder, r100);
        }

        public Builder(ByteOrder r100) {
            this.mAttributes = Collections.list(new AnonymousClass2(this));
            this.mByteOrder = r100;
        }

        private static Pair<Integer, Integer> guessDataFormat(String r110) {
            int r100 = 1;
            if (r110.contains(",") == false) goto L35;
            String[] r111 = r110.split(",", -1);
            Pair<Integer, Integer> r101 = guessDataFormat(r111[0]);
            if (((Integer) r101.first).intValue() != 2) goto L8;
            return r101;
        L8:
            if (r100 >= r111.length) goto L33;
            Pair<Integer, Integer> r102 = guessDataFormat(r111[r100]);
            if (((Integer) r102.first).equals(r101.first) == false) goto L12;
        L15:
            int r103 = ((Integer) r101.first).intValue();
        L17:
            if (((Integer) r101.second).intValue() != (-1)) goto L19;
        L23:
            int r104 = -1;
        L24:
            if (r103 != (-1)) goto L28;
            if (r104 != (-1)) goto L28;
            return new Pair(2, -1);
        L28:
            if (r103 != (-1)) goto L30;
            r101 = new Pair(Integer.valueOf(r104), -1);
        L32:
            r100 = r100 + 1;
            goto L8
        L30:
            if (r104 != (-1)) goto L32;
            r101 = new Pair(Integer.valueOf(r103), -1);
            goto L32
        L19:
            if (((Integer) r102.first).equals(r101.second) == false) goto L21;
        L22:
            r104 = ((Integer) r101.second).intValue();
            goto L24
        L21:
            if (((Integer) r102.second).equals(r101.second) == false) goto L23;
        L12:
            if (((Integer) r102.second).equals(r101.first) == true) goto L15;
            r103 = -1;
            goto L17
        L33:
            return r101;
        L35:
            if (r110.contains(HTTP.URL_DEFAULT) == false) goto L73;
            String[] r112 = r110.split(HTTP.URL_DEFAULT, -1);
            if (r112.length != 2) goto L55;
            long r105 = (long) CastDoubleProtector.parseDouble(r112[0]);     // Catch: NumberFormatException -> L71
            long r106 = (long) CastDoubleProtector.parseDouble(r112[1]);     // Catch: NumberFormatException -> L71
            if (r105 < 0) goto L53;
            if (r106 < 0) goto L53;
            if (r105 > SieveCacheKt.NodeLinkMask) goto L51;
            if (r106 > SieveCacheKt.NodeLinkMask) goto L51;
            return new Pair(10, 5);
        L51:
            return new Pair(5, -1);
        L53:
            return new Pair(10, -1);
        L55:
            return new Pair(2, -1);
        L73:
            long r107 = CastLongProtector.parseLong(r110);     // Catch: NumberFormatException -> L67
            if (r107 >= 0) goto L59;
        L62:
            if (r107 >= 0) goto L66;
            return new Pair(9, -1);
        L66:
            return new Pair(4, -1);
        L59:
            if (r107 > 65535) goto L62;
            return new Pair(3, 4);
        L67:
            CastDoubleProtector.parseDouble(r110);     // Catch: NumberFormatException -> L69
            return new Pair(12, -1);
        L70:
            return new Pair(2, -1);
        }

        public Builder removeAttribute(String r100) {
            setAttributeInternal(r100, null, this.mAttributes);
            return this;
        }

        public Builder setExposureTimeNanos(long r100) {
            return setAttribute(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(r100 / TimeUnit.SECONDS.toNanos(1)));
        }

        public Builder setFlashState(CameraCaptureMetaData.FlashState r100) {
            if (r100 != CameraCaptureMetaData.FlashState.UNKNOWN) goto L5;
            return this;
        L5:
            int r101 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[r100.ordinal()];
            if (r101 != 1) goto L8;
            int r102 = 0;
        L17:
            if ((r102 & 1) != 1) goto L20;
            setAttribute(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(4));
        L20:
            return setAttribute(ExifInterface.TAG_FLASH, String.valueOf(r102));
        L8:
            if (r101 != 2) goto L10;
            r102 = 32;
            goto L17
        L10:
            if (r101 == 3) goto L13;
            Logger.w(ExifData.TAG, "Unknown flash state: " + r100);
            return this;
        L13:
            r102 = 1;
            goto L17
        }

        public Builder setFocalLength(float r100) {
            return setAttribute(ExifInterface.TAG_FOCAL_LENGTH, new LongRational((long) (r100 * 1000.0f), 1000).toString());
        }

        public Builder setImageHeight(int r100) {
            return setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(r100));
        }

        public Builder setImageWidth(int r100) {
            return setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(r100));
        }

        public Builder setIso(int r100) {
            return setAttribute(ExifInterface.TAG_SENSITIVITY_TYPE, String.valueOf(3)).setAttribute(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, String.valueOf(Math.min(65535, r100)));
        }

        public Builder setLensFNumber(float r100) {
            return setAttribute(ExifInterface.TAG_F_NUMBER, String.valueOf(r100));
        }

        public Builder setOrientationDegrees(int r100) {
            if (r100 != 0) goto L4;
            int r101 = 1;
        L15:
            return setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(r101));
        L4:
            if (r100 != 90) goto L6;
            r101 = 6;
            goto L15
        L6:
            if (r100 != 180) goto L8;
            r101 = 3;
            goto L15
        L8:
            if (r100 == 270) goto L10;
            Logger.w(ExifData.TAG, "Unexpected orientation value: " + r100 + ". Must be one of 0, 90, 180, 270.");
            r101 = 0;
            goto L15
        L10:
            r101 = 8;
            goto L15
        }

        public Builder setWhiteBalanceMode(WhiteBalanceMode r100) {
            int r101 = r100.ordinal();
            if (r101 != 0) goto L5;
            String r102 = String.valueOf(0);
        L10:
            return setAttribute(ExifInterface.TAG_WHITE_BALANCE, r102);
        L5:
            if (r101 == 1) goto L7;
            r102 = null;
            goto L10
        L7:
            r102 = String.valueOf(1);
            goto L10
        }

        public Builder setAttribute(String r100, String r101) {
            setAttributeInternal(r100, r101, this.mAttributes);
            return this;
        }

        private void setAttributeIfMissing(String r100, String r101, List<Map<String, ExifAttribute>> r102) {
            Iterator<Map<String, ExifAttribute>> r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            if (r103.next().containsKey(r100) == false) goto L4;
            return;
        L8:
            setAttributeInternal(r100, r101, r102);
        }

        private void setAttributeInternal(String r110, String r111, List<Map<String, ExifAttribute>> r210) {
            Builder r100 = this;
            String r101 = r110;
            String r102 = r111;
            if (ExifInterface.TAG_DATETIME.equals(r101) == false) goto L5;
        L8:
            if (r102 == null) goto L19;
            boolean r103 = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(r102).find();
            boolean r104 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(r102).find();
            if (r111.length() != 19) goto L16;
            if (r103 == true) goto L14;
            if (r104 == false) goto L16;
        L14:
            if (r104 == false) goto L19;
            r102 = r102.replaceAll("-", ":");
        L16:
            Logger.w(ExifData.TAG, "Invalid value for " + r101 + " : " + r102);
            return;
        L19:
            if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(r101) == false) goto L21;
            r101 = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        L21:
            String r105 = r101;
            int r106 = 2;
            int r107 = 1;
            if (r102 != null) goto L24;
        L37:
            char r108 = 0;
            int r109 = 0;
        L39:
            if (r109 >= ExifData.EXIF_TAGS.length) goto L100;
            ExifTag r112 = (ExifTag) ((HashMap) ListProtector.get(sExifTagMapsForWriting, r109)).get(r105);
            if (r112 == null) goto L98;
            if (r102 != null) goto L44;
            ((Map) ListProtector.get(r210, r109)).remove(r105);
            goto L98
        L44:
            Pair<Integer, Integer> r113 = guessDataFormat(r102);
            if (r112.primaryFormat != ((Integer) r113.first).intValue()) goto L47;
        L62:
            int r114 = r112.primaryFormat;
        L63:
            String r115 = HTTP.URL_DEFAULT;
            switch(r114) {
                case 1: goto L97;
                case 2: goto L96;
                case 3: goto L91;
                case 4: goto L86;
                case 5: goto L81;
                case 6: goto L98;
                case 7: goto L96;
                case 8: goto L98;
                case 9: goto L76;
                case 10: goto L71;
                case 11: goto L98;
                case 12: goto L66;
                default: goto L98;
            };
        L66:
            String[] r116 = r102.split(",", -1);
            double[] r117 = new double[r116.length];
            int r118 = 0;
        L68:
            if (r118 >= r116.length) goto L70;
            r117[r118] = CastDoubleProtector.parseDouble(r116[r118]);
            r118 = r118 + 1;
            goto L68
        L70:
            ((Map) ListProtector.get(r210, r109)).put(r105, ExifAttribute.createDouble(r117, r100.mByteOrder));
            goto L98
        L71:
            String[] r119 = r102.split(",", -1);
            LongRational[] r120 = new LongRational[r119.length];
            int r121 = 0;
        L73:
            if (r121 >= r119.length) goto L75;
            String[] r122 = r119[r121].split(r115, -1);
            r120[r121] = new LongRational((long) CastDoubleProtector.parseDouble(r122[r108]), (long) CastDoubleProtector.parseDouble(r122[r107]));
            r121 = r121 + 1;
            r115 = r115;
            r107 = 1;
            goto L73
        L75:
            r100 = this;
            ((Map) ListProtector.get(r210, r109)).put(r105, ExifAttribute.createSRational(r120, r100.mByteOrder));
            goto L98
        L76:
            String[] r123 = r102.split(",", -1);
            int[] r124 = new int[r123.length];
            int r125 = 0;
        L78:
            if (r125 >= r123.length) goto L80;
            r124[r125] = CastIntegerProtector.parseInt(r123[r125]);
            r125 = r125 + 1;
            goto L78
        L80:
            ((Map) ListProtector.get(r210, r109)).put(r105, ExifAttribute.createSLong(r124, r100.mByteOrder));
            goto L98
        L81:
            String r126 = HTTP.URL_DEFAULT;
            String[] r127 = r102.split(",", -1);
            LongRational[] r128 = new LongRational[r127.length];
            int r129 = 0;
        L83:
            if (r129 >= r127.length) goto L85;
            String r130 = r126;
            String[] r131 = r127[r129].split(r130, -1);
            r128[r129] = new LongRational((long) CastDoubleProtector.parseDouble(r131[r108]), (long) CastDoubleProtector.parseDouble(r131[1]));
            r129 = r129 + 1;
            r126 = r130;
            r109 = r109;
            r108 = 0;
            goto L83
        L85:
            int r132 = r109;
            ((Map) ListProtector.get(r210, r132)).put(r105, ExifAttribute.createURational(r128, r100.mByteOrder));
        L99:
            r109 = r132 + 1;
            r106 = 2;
            r108 = 0;
            r107 = 1;
            goto L39
        L86:
            r132 = r109;
            String[] r133 = r102.split(",", -1);
            long[] r134 = new long[r133.length];
            int r135 = 0;
        L88:
            if (r135 >= r133.length) goto L90;
            r134[r135] = CastLongProtector.parseLong(r133[r135]);
            r135 = r135 + 1;
            goto L88
        L90:
            ((Map) ListProtector.get(r210, r132)).put(r105, ExifAttribute.createULong(r134, r100.mByteOrder));
            goto L99
        L91:
            r132 = r109;
            String[] r136 = r102.split(",", -1);
            int[] r137 = new int[r136.length];
            int r138 = 0;
        L93:
            if (r138 >= r136.length) goto L95;
            r137[r138] = CastIntegerProtector.parseInt(r136[r138]);
            r138 = r138 + 1;
            goto L93
        L95:
            ((Map) ListProtector.get(r210, r132)).put(r105, ExifAttribute.createUShort(r137, r100.mByteOrder));
            goto L99
        L96:
            r132 = r109;
            ((Map) ListProtector.get(r210, r132)).put(r105, ExifAttribute.createString(r102));
            goto L99
        L97:
            r132 = r109;
            ((Map) ListProtector.get(r210, r132)).put(r105, ExifAttribute.createByte(r102));
            goto L99
        L47:
            if (r112.primaryFormat == ((Integer) r113.second).intValue()) goto L62;
            int r139 = r112.secondaryFormat;
            if (r139 != (-1)) goto L52;
        L56:
            r114 = r112.primaryFormat;
            if (r114 == r107) goto L63;
            if (r114 == 7) goto L63;
            if (r114 != r106) goto L98;
        L52:
            if (r139 != ((Integer) r113.first).intValue()) goto L54;
        L55:
            r114 = r112.secondaryFormat;
            goto L63
        L54:
            if (r112.secondaryFormat != ((Integer) r113.second).intValue()) goto L56;
        L98:
            r132 = r109;
            goto L99
        L100:
            return;
        L24:
            if (ExifData.sTagSetForCompatibility.contains(r105) == false) goto L37;
            if (r105.equals(ExifInterface.TAG_GPS_TIMESTAMP) == false) goto L101;
            Matcher r140 = GPS_TIMESTAMP_PATTERN.matcher(r102);
            if (r140.find() == true) goto L31;
            Logger.w(ExifData.TAG, "Invalid value for " + r105 + " : " + r102);
            return;
        L31:
            r102 = CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r140.group(1))) + "/1," + CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r140.group(2))) + "/1," + CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r140.group(3))) + "/1";
            goto L37
        L101:
            r102 = new LongRational(CastDoubleProtector.parseDouble(r102)).toString();     // Catch: NumberFormatException -> L34
        L34:
            e = move-exception;
            Logger.w(ExifData.TAG, "Invalid value for " + r105 + " : " + r102, e);
            return;
        L5:
            if (ExifInterface.TAG_DATETIME_ORIGINAL.equals(r101) == true) goto L8;
            if (ExifInterface.TAG_DATETIME_DIGITIZED.equals(r101) == false) goto L19;
            goto L8
        }
    }

    public static final enum WhiteBalanceMode extends Enum<WhiteBalanceMode> {
        private static final /* synthetic */ WhiteBalanceMode[] $VALUES = null;
        public static final WhiteBalanceMode AUTO = null;
        public static final WhiteBalanceMode MANUAL = null;

        private static /* synthetic */ WhiteBalanceMode[] $values() {
            return new WhiteBalanceMode[]{AUTO, MANUAL};
        }

        static {
            AUTO = new WhiteBalanceMode("AUTO", 0);
            MANUAL = new WhiteBalanceMode("MANUAL", 1);
            $VALUES = $values();
        }

        public static WhiteBalanceMode[] values() {
            return (WhiteBalanceMode[]) $VALUES.clone();
        }

        public static WhiteBalanceMode valueOf(String r100) {
            return (WhiteBalanceMode) r27.a.a(WhiteBalanceMode.class, r100);
        }

        private WhiteBalanceMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        ExifTag[] r100 = {new ExifTag(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(ExifInterface.TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new ExifTag(ExifInterface.TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new ExifTag(ExifInterface.TAG_ORIENTATION, 274, 3), new ExifTag(ExifInterface.TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new ExifTag(ExifInterface.TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new ExifTag(ExifInterface.TAG_RESOLUTION_UNIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new ExifTag(ExifInterface.TAG_SOFTWARE, 305, 2), new ExifTag(ExifInterface.TAG_DATETIME, 306, 2), new ExifTag(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = r100;
        ExifTag[] r101 = {new ExifTag(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(ExifInterface.TAG_F_NUMBER, 33437, 5), new ExifTag(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new ExifTag(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new ExifTag(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(ExifInterface.TAG_METERING_MODE, 37383, 3), new ExifTag(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(ExifInterface.TAG_FLASH, 37385, 3), new ExifTag(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(ExifInterface.TAG_FLASHPIX_VERSION, UnixStat.LINK_FLAG, 7), new ExifTag(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new ExifTag(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new ExifTag(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new ExifTag(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new ExifTag(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new ExifTag(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(ExifInterface.TAG_CONTRAST, 41992, 3), new ExifTag(ExifInterface.TAG_SATURATION, 41993, 3), new ExifTag(ExifInterface.TAG_SHARPNESS, 41994, 3)};
        IFD_EXIF_TAGS = r101;
        ExifTag[] r102 = {new ExifTag(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new ExifTag(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new ExifTag(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new ExifTag(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new ExifTag(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2)};
        IFD_GPS_TAGS = r102;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4)};
        ExifTag[] r103 = {new ExifTag(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = r103;
        EXIF_TAGS = new ExifTag[][]{r100, r101, r102, r103};
        sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_GPS_TIMESTAMP}));
    }

    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(1)).setAttribute(ExifInterface.TAG_X_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_Y_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_RESOLUTION_UNIT, String.valueOf(2)).setAttribute(ExifInterface.TAG_Y_CB_CR_POSITIONING, String.valueOf(1)).setAttribute(ExifInterface.TAG_MAKE, Build.MANUFACTURER).setAttribute(ExifInterface.TAG_MODEL, Build.MODEL);
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    private ExifAttribute getExifAttribute(String r100) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(r100) == false) goto L5;
        r100 = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= EXIF_TAGS.length) goto L12;
        ExifAttribute r102 = (ExifAttribute) ((Map) ListProtector.get(this.mAttributes, r101)).get(r100);
        if (r102 != null) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return r102;
    L12:
        return null;
    }

    public String getAttribute(String r100) {
        ExifAttribute r101 = getExifAttribute(r100);
        if (r101 != null) goto L5;
    L27:
        return null;
    L5:
        if (sTagSetForCompatibility.contains(r100) == true) goto L9;
        return r101.getStringValue(this.mByteOrder);
    L9:
        if (r100.equals(ExifInterface.TAG_GPS_TIMESTAMP) == false) goto L29;
        int r102 = r101.format;
        if (r102 != 5) goto L13;
    L16:
        LongRational[] r103 = (LongRational[]) r101.getValue(this.mByteOrder);
        if (r103 != null) goto L19;
    L23:
        Logger.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(r103));
        return null;
    L19:
        if (r103.length != 3) goto L23;
        return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r103[0].getNumerator() / r103[0].getDenominator())), Integer.valueOf((int) (r103[1].getNumerator() / r103[1].getDenominator())), Integer.valueOf((int) (r103[2].getNumerator() / r103[2].getDenominator()))});
    L13:
        if (r102 == 10) goto L16;
        Logger.w(TAG, "GPS Timestamp format is not rational. format=" + r101.format);
        return null;
    L29:
        return Double.toString(r101.getDoubleValue(this.mByteOrder));
    }

    public Map<String, ExifAttribute> getAttributes(int r100) {
        Preconditions.checkArgumentInRange(r100, 0, EXIF_TAGS.length, "Invalid IFD index: " + r100 + ". Index should be between [0, EXIF_TAGS.length] ");
        return (Map) ListProtector.get(this.mAttributes, r100);
    }

    public ExifData(ByteOrder r100, List<Map<String, ExifAttribute>> r101) {
        if (r101.size() != EXIF_TAGS.length) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = r100;
        this.mAttributes = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static ExifData create(ImageProxy r100, int r101) {
        Builder r102 = builderForDevice();
        if (r100.getImageInfo() == null) goto L5;
        r100.getImageInfo().populateExifData(r102);
    L5:
        r102.setOrientationDegrees(r101);
        return r102.setImageWidth(r100.getWidth()).setImageHeight(r100.getHeight()).build();
    }
}
