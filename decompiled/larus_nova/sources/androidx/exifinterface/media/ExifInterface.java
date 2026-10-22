package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import f06.b;
import f06.d;
import g06.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII = null;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = null;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = null;
    public static final int[] BITS_PER_SAMPLE_RGB = null;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final boolean DEBUG = false;
    static final byte[] EXIF_ASCII_PREFIX = null;
    private static final ExifTag[] EXIF_POINTER_TAGS = null;
    static final ExifTag[][] EXIF_TAGS = null;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = null;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final byte[] HEIF_BRAND_HEIC = null;
    private static final byte[] HEIF_BRAND_MIF1 = null;
    private static final byte[] HEIF_TYPE_FTYP = null;
    static final byte[] IDENTIFIER_EXIF_APP1 = null;
    private static final byte[] IDENTIFIER_XMP_APP1 = null;
    private static final ExifTag[] IFD_EXIF_TAGS = null;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = null;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = null;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS = null;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = null;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS = null;
    private static final ExifTag[] IFD_TIFF_TAGS = null;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_HEIF = 12;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = null;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = null;
    static final byte[] JPEG_SIGNATURE = null;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = null;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = null;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = null;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = null;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS = null;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS = null;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int RAF_INFO_SIZE = 160;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = null;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = null;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final int WHITEBALANCE_AUTO = 0;
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = null;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading = null;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting = null;
    private static SimpleDateFormat sFormatter;
    private static final Pattern sGpsTimestampPattern = null;
    private static final Pattern sNonZeroTimePattern = null;
    private static final HashSet<String> sTagSetForCompatibility = null;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private int mExifOffset;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private boolean mModified;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = null;
        private static final ByteOrder LITTLE_ENDIAN = null;
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        static {
            LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int r100 = this.mPosition + 1;
            this.mPosition = r100;
            if (r100 > this.mLength) goto L11;
            int r101 = this.mDataInputStream.read();
            if (r101 < 0) goto L9;
            return (byte) r101;
        L9:
            throw new EOFException();
        L11:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int r100 = this.mPosition + 4;
            this.mPosition = r100;
            if (r100 > this.mLength) goto L19;
            int r101 = this.mDataInputStream.read();
            int r102 = this.mDataInputStream.read();
            int r103 = this.mDataInputStream.read();
            int r104 = this.mDataInputStream.read();
            if ((((r101 | r102) | r103) | r104) < 0) goto L17;
            ByteOrder r105 = this.mByteOrder;
            if (r105 != LITTLE_ENDIAN) goto L11;
            return (((r104 << 24) + (r103 << 16)) + (r102 << 8)) + r101;
        L11:
            if (r105 != BIG_ENDIAN) goto L15;
            return (((r101 << 24) + (r102 << 16)) + (r103 << 8)) + r104;
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int r100 = this.mPosition + 8;
            this.mPosition = r100;
            if (r100 > this.mLength) goto L19;
            int r101 = this.mDataInputStream.read();
            int r102 = this.mDataInputStream.read();
            int r103 = this.mDataInputStream.read();
            int r104 = this.mDataInputStream.read();
            int r105 = this.mDataInputStream.read();
            int r106 = this.mDataInputStream.read();
            int r107 = this.mDataInputStream.read();
            int r108 = this.mDataInputStream.read();
            if ((((((((r101 | r102) | r103) | r104) | r105) | r106) | r107) | r108) < 0) goto L17;
            ByteOrder r110 = this.mByteOrder;
            if (r110 != LITTLE_ENDIAN) goto L11;
            return (((((((((long) r108) << 56) + (((long) r107) << 48)) + (((long) r106) << 40)) + (((long) r105) << 32)) + (((long) r104) << 24)) + (((long) r103) << 16)) + (((long) r102) << 8)) + ((long) r101);
        L11:
            if (r110 != BIG_ENDIAN) goto L15;
            return (((((((((long) r101) << 56) + (((long) r102) << 48)) + (((long) r103) << 40)) + (((long) r104) << 32)) + (((long) r105) << 24)) + (((long) r106) << 16)) + (((long) r107) << 8)) + ((long) r108);
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int r100 = this.mPosition + 2;
            this.mPosition = r100;
            if (r100 > this.mLength) goto L19;
            int r101 = this.mDataInputStream.read();
            int r102 = this.mDataInputStream.read();
            if ((r101 | r102) < 0) goto L17;
            ByteOrder r103 = this.mByteOrder;
            if (r103 != LITTLE_ENDIAN) goto L11;
            return (short) ((r102 << 8) + r101);
        L11:
            if (r103 != BIG_ENDIAN) goto L15;
            return (short) ((r101 << 8) + r102);
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int r100 = this.mPosition + 2;
            this.mPosition = r100;
            if (r100 > this.mLength) goto L19;
            int r101 = this.mDataInputStream.read();
            int r102 = this.mDataInputStream.read();
            if ((r101 | r102) < 0) goto L17;
            ByteOrder r103 = this.mByteOrder;
            if (r103 != LITTLE_ENDIAN) goto L11;
            return (r102 << 8) + r101;
        L11:
            if (r103 != BIG_ENDIAN) goto L15;
            return (r101 << 8) + r102;
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & BodyPartID.bodyIdMax;
        }

        public int getLength() {
            return this.mLength;
        }

        public int peek() {
            return this.mPosition;
        }

        public ByteOrderedDataInputStream(InputStream r100) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream r101 = new DataInputStream(r100);
            this.mDataInputStream = r101;
            int r102 = r101.available();
            this.mLength = r102;
            this.mPosition = 0;
            this.mDataInputStream.mark(r102);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r100) throws IOException {
            int r101 = this.mPosition + r100.length;
            this.mPosition = r101;
            if (r101 > this.mLength) goto L10;
            if (this.mDataInputStream.read(r100, 0, r100.length) != r100.length) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        public void seek(long r100) throws IOException {
            int r101 = this.mPosition;
            if (r101 <= r100) goto L5;
            this.mPosition = 0;
            this.mDataInputStream.reset();
            this.mDataInputStream.mark(this.mLength);
        L6:
            int r102 = (int) r100;
            if (skipBytes(r102) != r102) goto L10;
            return;
        L10:
            throw new IOException("Couldn't seek up to the byteCount");
        L5:
            r100 = r100 - ((long) r101);
            goto L6
        }

        public void setByteOrder(ByteOrder r100) {
            this.mByteOrder = r100;
        }

        @Override // java.io.DataInput
        public int skipBytes(int r100) throws IOException {
            int r101 = Math.min(r100, this.mLength - this.mPosition);
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r102 = r102 + this.mDataInputStream.skipBytes(r101 - r102);
            goto L3
        L5:
            this.mPosition += r102;
            return r102;
        }

        public ByteOrderedDataInputStream(byte[] r100) throws IOException {
            this(new ByteArrayInputStream(r100));
        }

        @Override // java.io.InputStream
        public int read(byte[] r100, int r101, int r102) throws IOException {
            int r103 = this.mDataInputStream.read(r100, r101, r102);
            this.mPosition += r103;
            return r103;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r100, int r101, int r102) throws IOException {
            int r103 = this.mPosition + r102;
            this.mPosition = r103;
            if (r103 > this.mLength) goto L10;
            if (this.mDataInputStream.read(r100, r101, r102) != r102) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }
    }

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        private final OutputStream mOutputStream;

        public void setByteOrder(ByteOrder r100) {
            this.mByteOrder = r100;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r100) throws IOException {
            this.mOutputStream.write(r100);
        }

        public void writeByte(int r100) throws IOException {
            this.mOutputStream.write(r100);
        }

        public void writeInt(int r100) throws IOException {
            ByteOrder r101 = this.mByteOrder;
            if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write((r100 >>> 0) & 255);
            this.mOutputStream.write((r100 >>> 8) & 255);
            this.mOutputStream.write((r100 >>> 16) & 255);
            this.mOutputStream.write((r100 >>> 24) & 255);
            return;
        L6:
            if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r100 >>> 24) & 255);
            this.mOutputStream.write((r100 >>> 16) & 255);
            this.mOutputStream.write((r100 >>> 8) & 255);
            this.mOutputStream.write((r100 >>> 0) & 255);
            return;
        }

        public void writeShort(short r100) throws IOException {
            ByteOrder r101 = this.mByteOrder;
            if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write((r100 >>> 0) & 255);
            this.mOutputStream.write((r100 >>> 8) & 255);
            return;
        L6:
            if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r100 >>> 8) & 255);
            this.mOutputStream.write((r100 >>> 0) & 255);
            return;
        }

        public void writeUnsignedInt(long r100) throws IOException {
            writeInt((int) r100);
        }

        public void writeUnsignedShort(int r100) throws IOException {
            writeShort((short) r100);
        }

        public ByteOrderedDataOutputStream(OutputStream r100, ByteOrder r101) {
            super(r100);
            this.mOutputStream = r100;
            this.mByteOrder = r101;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r100, int r101, int r102) throws IOException {
            this.mOutputStream.write(r100, r101, r102);
        }
    }

    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public static ExifAttribute createByte(String r100) {
            if (r100.length() == 1) goto L5;
        L10:
            byte[] r101 = r100.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(1, r101.length, r101);
        L5:
            if (r100.charAt(0) < '0') goto L10;
            if (r100.charAt(0) > '1') goto L10;
            return new ExifAttribute(1, 1, new byte[]{(byte) (r100.charAt(0) - '0')});
        }

        public static ExifAttribute createString(String r100) {
            byte[] r101 = (r100 + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, r101.length, r101);
        }

        public double getDoubleValue(ByteOrder r100) {
            Object r101 = getValue(r100);
            if (r101 == null) goto L43;
            if ((r101 instanceof String) == false) goto L9;
            return CastDoubleProtector.parseDouble((String) r101);
        L9:
            if ((r101 instanceof long[]) == false) goto L17;
            long[] r102 = (long[]) r101;
            if (r102.length != 1) goto L15;
            return r102[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r101 instanceof int[]) == false) goto L25;
            int[] r103 = (int[]) r101;
            if (r103.length != 1) goto L23;
            return r103[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r101 instanceof double[]) == false) goto L33;
            double[] r104 = (double[]) r101;
            if (r104.length != 1) goto L31;
            return r104[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r101 instanceof Rational[]) == false) goto L41;
            Rational[] r105 = (Rational[]) r101;
            if (r105.length != 1) goto L39;
            return r105[0].calculate();
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder r100) {
            Object r101 = getValue(r100);
            if (r101 == null) goto L27;
            if ((r101 instanceof String) == false) goto L9;
            return CastIntegerProtector.parseInt((String) r101);
        L9:
            if ((r101 instanceof long[]) == false) goto L17;
            long[] r102 = (long[]) r101;
            if (r102.length != 1) goto L15;
            return (int) r102[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r101 instanceof int[]) == false) goto L25;
            int[] r103 = (int[]) r101;
            if (r103.length != 1) goto L23;
            return r103[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder r100) {
            Object r101 = getValue(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            if ((r101 instanceof String) == true) goto L8;
            StringBuilder r102 = new StringBuilder();
            int r103 = 0;
            if ((r101 instanceof long[]) == false) goto L20;
            long[] r104 = (long[]) r101;
        L13:
            if (r103 >= r104.length) goto L18;
            r102.append(r104[r103]);
            r103 = r103 + 1;
            if (r103 == r104.length) goto L13;
            r102.append(",");
            goto L13
        L18:
            return r102.toString();
        L20:
            if ((r101 instanceof int[]) == false) goto L30;
            int[] r105 = (int[]) r101;
        L23:
            if (r103 >= r105.length) goto L28;
            r102.append(r105[r103]);
            r103 = r103 + 1;
            if (r103 == r105.length) goto L23;
            r102.append(",");
            goto L23
        L28:
            return r102.toString();
        L30:
            if ((r101 instanceof double[]) == false) goto L40;
            double[] r106 = (double[]) r101;
        L33:
            if (r103 >= r106.length) goto L38;
            r102.append(r106[r103]);
            r103 = r103 + 1;
            if (r103 == r106.length) goto L33;
            r102.append(",");
            goto L33
        L38:
            return r102.toString();
        L40:
            if ((r101 instanceof Rational[]) == false) goto L49;
            Rational[] r107 = (Rational[]) r101;
        L43:
            if (r103 >= r107.length) goto L48;
            r102.append(r107[r103].numerator);
            r102.append('/');
            r102.append(r107[r103].denominator);
            r103 = r103 + 1;
            if (r103 == r107.length) goto L43;
            r102.append(",");
            goto L43
        L48:
            return r102.toString();
        L49:
            return null;
        L8:
            return (String) r101;
        }

        public Object getValue(ByteOrder r100) {
            ByteOrderedDataInputStream r101 = null;
            ByteOrderedDataInputStream r102 = new ByteOrderedDataInputStream(this.bytes);     // Catch: Throwable -> L103 IOException -> L107
            r102.setByteOrder(r100);     // Catch: Throwable -> L101 IOException -> L124
            int r103 = 0;
            boolean r104 = true;
            switch(this.format) {
                case 1: goto L88;
                case 2: goto L64;
                case 3: goto L56;
                case 4: goto L49;
                case 5: goto L42;
                case 6: goto L88;
                case 7: goto L64;
                case 8: goto L35;
                case 9: goto L28;
                case 10: goto L21;
                case 11: goto L14;
                case 12: goto L7;
                default: goto L144;
            };     // Catch: Throwable -> L101 IOException -> L124
        L7:
            double[] r105 = new double[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L9:
            if (r103 >= this.numberOfComponents) goto L140;
            r105[r103] = r102.readDouble();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L9
        L140:
            r102.close();     // Catch: IOException -> L112
        L13:
            return r105;
        L14:
            double[] r106 = new double[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L16:
            if (r103 >= this.numberOfComponents) goto L148;
            r106[r103] = r102.readFloat();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L16
        L148:
            r102.close();     // Catch: IOException -> L113
        L20:
            return r106;
        L21:
            Rational[] r107 = new Rational[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L23:
            if (r103 >= this.numberOfComponents) goto L146;
            r107[r103] = new Rational(r102.readInt(), r102.readInt());     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L23
        L146:
            r102.close();     // Catch: IOException -> L114
        L27:
            return r107;
        L28:
            int[] r108 = new int[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L30:
            if (r103 >= this.numberOfComponents) goto L128;
            r108[r103] = r102.readInt();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L30
        L128:
            r102.close();     // Catch: IOException -> L115
        L34:
            return r108;
        L35:
            int[] r109 = new int[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L37:
            if (r103 >= this.numberOfComponents) goto L138;
            r109[r103] = r102.readShort();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L37
        L138:
            r102.close();     // Catch: IOException -> L116
        L41:
            return r109;
        L42:
            Rational[] r110 = new Rational[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L44:
            if (r103 >= this.numberOfComponents) goto L142;
            r110[r103] = new Rational(r102.readUnsignedInt(), r102.readUnsignedInt());     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L44
        L142:
            r102.close();     // Catch: IOException -> L117
        L48:
            return r110;
        L49:
            long[] r111 = new long[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L51:
            if (r103 >= this.numberOfComponents) goto L150;
            r111[r103] = r102.readUnsignedInt();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L51
        L150:
            r102.close();     // Catch: IOException -> L118
        L55:
            return r111;
        L56:
            int[] r112 = new int[this.numberOfComponents];     // Catch: Throwable -> L101 IOException -> L124
        L58:
            if (r103 >= this.numberOfComponents) goto L134;
            r112[r103] = r102.readUnsignedShort();     // Catch: Throwable -> L101 IOException -> L124
            r103 = r103 + 1;
            goto L58
        L134:
            r102.close();     // Catch: IOException -> L119
        L62:
            return r112;
        L88:
            byte[] r113 = this.bytes;     // Catch: Throwable -> L101 IOException -> L124
            if (r113.length != 1) goto L96;
            byte r114 = r113[0];     // Catch: Throwable -> L101 IOException -> L124
            if (r114 < 0) goto L96;
            if (r114 > 1) goto L96;
            String r115 = new String(new char[]{(char) (r114 + 48)});     // Catch: Throwable -> L101 IOException -> L124
            r102.close();     // Catch: IOException -> L121
        L95:
            return r115;
        L96:
            String r116 = new String(r113, ExifInterface.ASCII);     // Catch: Throwable -> L101 IOException -> L124
            r102.close();     // Catch: IOException -> L122
        L98:
            return r116;
        L144:
            r102.close();     // Catch: IOException -> L111
        L100:
            return null;
        L64:
            if (this.numberOfComponents < ExifInterface.EXIF_ASCII_PREFIX.length) goto L74;
            int r117 = 0;
        L66:
            byte[] r118 = ExifInterface.EXIF_ASCII_PREFIX;     // Catch: Throwable -> L101 IOException -> L124
            if (r117 >= r118.length) goto L72;
            if (this.bytes[r117] != r118[r117]) goto L70;
            r117 = r117 + 1;     // Catch: Throwable -> L101 IOException -> L124
            goto L66
        L70:
            r104 = false;
        L72:
            if (r104 == false) goto L74;
            r103 = r118.length;     // Catch: Throwable -> L101 IOException -> L124
        L74:
            StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L101 IOException -> L124
        L76:
            if (r103 >= this.numberOfComponents) goto L85;
            byte r120 = this.bytes[r103];     // Catch: Throwable -> L101 IOException -> L124
            if (r120 == 0) goto L85;
            if (r120 < 32) goto L83;
            r119.append((char) r120);     // Catch: Throwable -> L101 IOException -> L124
        L84:
            r103 = r103 + 1;     // Catch: Throwable -> L101 IOException -> L124
            goto L76
        L83:
            r119.append('?');     // Catch: Throwable -> L101 IOException -> L124
        L85:
            String r121 = r119.toString();     // Catch: Throwable -> L101 IOException -> L124
            r102.close();     // Catch: IOException -> L120
        L87:
            return r121;
        L101:
            th = th;
            r101 = r102;
        L104:
            if (r101 != null) goto L136;
        L106:
            throw th;
        L136:
            r101.close();     // Catch: IOException -> L123
        L108:
            if (r102 != null) goto L130;
        L110:
            return null;
        L130:
            r102.close();     // Catch: IOException -> L125
            goto L110
        L107:
            r102 = null;
        L103:
            th = th;
            goto L104
        }

        public static ExifAttribute createDouble(double[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putDouble(r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(12, r100.length, r102.array());
        }

        public static ExifAttribute createSLong(int[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putInt(r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(9, r100.length, r102.array());
        }

        public static ExifAttribute createSRational(Rational[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            Rational r105 = r100[r104];
            r102.putInt((int) r105.numerator);
            r102.putInt((int) r105.denominator);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(10, r100.length, r102.array());
        }

        public static ExifAttribute createULong(long[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putInt((int) r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(4, r100.length, r102.array());
        }

        public static ExifAttribute createURational(Rational[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            Rational r105 = r100[r104];
            r102.putInt((int) r105.numerator);
            r102.putInt((int) r105.denominator);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(5, r100.length, r102.array());
        }

        public static ExifAttribute createUShort(int[] r100, ByteOrder r101) {
            ByteBuffer r102 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * r100.length]);
            r102.order(r101);
            int r103 = r100.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L6;
            r102.putShort((short) r100[r104]);
            r104 = r104 + 1;
            goto L3
        L6:
            return new ExifAttribute(3, r100.length, r102.array());
        }

        public static ExifAttribute createDouble(double r100, ByteOrder r101) {
            return createDouble(new double[]{r100}, r101);
        }

        public static ExifAttribute createSLong(int r100, ByteOrder r101) {
            return createSLong(new int[]{r100}, r101);
        }

        public static ExifAttribute createSRational(Rational r100, ByteOrder r101) {
            return createSRational(new Rational[]{r100}, r101);
        }

        public static ExifAttribute createULong(long r100, ByteOrder r101) {
            return createULong(new long[]{r100}, r101);
        }

        public static ExifAttribute createURational(Rational r100, ByteOrder r101) {
            return createURational(new Rational[]{r100}, r101);
        }

        public static ExifAttribute createUShort(int r100, ByteOrder r101) {
            return createUShort(new int[]{r100}, r101);
        }

        public ExifAttribute(int r100, int r101, byte[] r102) {
            this(r100, r101, -1, r102);
        }

        public ExifAttribute(int r100, int r101, long r102, byte[] r103) {
            this.format = r100;
            this.numberOfComponents = r101;
            this.bytesOffset = r102;
            this.bytes = r103;
        }
    }

    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public boolean isFormatCompatible(int r100) {
            int r101 = this.primaryFormat;
            if (r101 == 7) goto L30;
            if (r100 == 7) goto L30;
            if (r101 == r100) goto L30;
            int r102 = this.secondaryFormat;
            if (r102 == r100) goto L30;
            if (r101 == 4) goto L14;
            if (r102 == 4) goto L14;
        L17:
            if (r101 == 9) goto L20;
            if (r102 == 9) goto L20;
        L23:
            if (r101 == 12) goto L26;
            if (r102 == 12) goto L26;
            return false;
        L26:
            if (r100 != 11) goto L31;
            return true;
        L31:
            return false;
        L20:
            if (r100 != 8) goto L23;
            return true;
        L14:
            if (r100 != 3) goto L17;
            return true;
        L30:
            return true;
        }

        public ExifTag(String r100, int r101, int r102) {
            this.name = r100;
            this.number = r101;
            this.primaryFormat = r102;
            this.secondaryFormat = -1;
        }

        public ExifTag(String r100, int r101, int r102, int r103) {
            this.name = r100;
            this.number = r101;
            this.primaryFormat = r102;
            this.secondaryFormat = r103;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + HTTP.URL_DEFAULT + this.denominator;
        }

        public Rational(double r100) {
            this((long) (r100 * 10000.0d), 10000);
        }

        public Rational(long r100, long r101) {
            if (r101 != 0) goto L6;
            this.numerator = 0;
            this.denominator = 1;
            return;
        L6:
            this.numerator = r100;
            this.denominator = r101;
        }
    }

    private void printAttributes() {
        int r100 = 0;
    L3:
        HashMap<String, ExifAttribute>[] r101 = this.mAttributes;
        if (r100 >= r101.length) goto L10;
        r101[r100].size();
        Iterator<Map.Entry<String, ExifAttribute>> r102 = this.mAttributes[r100].entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, ExifAttribute> r103 = r102.next();
        ExifAttribute r104 = r103.getValue();
        String r105 = r103.getKey();
        r104.toString();
        r104.getStringValue(this.mExifByteOrder);
        goto L7
    L9:
        r100 = r100 + 1;
        goto L3
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
        FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_1 = new int[]{4};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, MARKER_SOI, -1};
        HEIF_TYPE_FTYP = new byte[]{102, 116, 121, 112};
        HEIF_BRAND_MIF1 = new byte[]{109, 105, 102, 49};
        HEIF_BRAND_HEIC = new byte[]{104, 101, 105, 99};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        ExifTag[] r100 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new ExifTag(TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new ExifTag(TAG_ROWS_PER_STRIP, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new ExifTag(TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new ExifTag(TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new ExifTag(TAG_RESOLUTION_UNIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = r100;
        ExifTag[] r101 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, UnixStat.LINK_FLAG, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ANRENDER_REFRESH_SURFACE, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = r101;
        ExifTag[] r102 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
        IFD_GPS_TAGS = r102;
        ExifTag[] r103 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = r103;
        ExifTag[] r110 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new ExifTag(TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new ExifTag(TAG_ROWS_PER_STRIP, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new ExifTag(TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new ExifTag(TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new ExifTag(TAG_RESOLUTION_UNIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = r110;
        TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
        ExifTag[] r104 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, AVMDLDataLoader.KeyIsEnableSpeedEngine, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = r104;
        ExifTag[] r105 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = r105;
        ExifTag[] r106 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = r106;
        ExifTag[] r111 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = r111;
        ExifTag[][] r112 = {r100, r101, r102, r103, r110, r100, r104, r105, r106, r111};
        EXIF_TAGS = r112;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, AVMDLDataLoader.KeyIsEnableSpeedEngine, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        sExifTagMapsForReading = new HashMap[r112.length];
        sExifTagMapsForWriting = new HashMap[r112.length];
        sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
        sExifPointerTagMap = new HashMap();
        Charset r107 = Charset.forName("US-ASCII");
        ASCII = r107;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(r107);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(r107);
        SimpleDateFormat r108 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = r108;
        r108.setTimeZone(TimeZone.getTimeZone("UTC"));
        int r113 = 0;
    L3:
        ExifTag[][] r109 = EXIF_TAGS;
        if (r113 >= r109.length) goto L9;
        sExifTagMapsForReading[r113] = new HashMap();
        sExifTagMapsForWriting[r113] = new HashMap();
        ExifTag[] r114 = r109[r113];
        int r115 = r114.length;
        int r116 = 0;
    L6:
        if (r116 >= r115) goto L8;
        ExifTag r117 = r114[r116];
        sExifTagMapsForReading[r113].put(Integer.valueOf(r117.number), r117);
        sExifTagMapsForWriting[r113].put(r117.name, r117);
        r116 = r116 + 1;
        goto L6
    L8:
        r113 = r113 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r118 = sExifPointerTagMap;
        ExifTag[] r119 = EXIF_POINTER_TAGS;
        r118.put(Integer.valueOf(r119[0].number), 5);
        r118.put(Integer.valueOf(r119[1].number), 1);
        r118.put(Integer.valueOf(r119[2].number), 2);
        r118.put(Integer.valueOf(r119[3].number), 3);
        r118.put(Integer.valueOf(r119[4].number), 7);
        r118.put(Integer.valueOf(r119[5].number), 8);
        sNonZeroTimePattern = PatternProtector.compile(".*[1-9].*");
        sGpsTimestampPattern = PatternProtector.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    private void addDefaultValuesForCompatibility() {
        String r100 = getAttribute(TAG_DATETIME_ORIGINAL);
        if (r100 == null) goto L8;
        if (getAttribute(TAG_DATETIME) != null) goto L8;
        this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(r100));
    L8:
        if (getAttribute(TAG_IMAGE_WIDTH) != null) goto L11;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
    L11:
        if (getAttribute(TAG_IMAGE_LENGTH) != null) goto L14;
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
    L14:
        if (getAttribute(TAG_ORIENTATION) != null) goto L17;
        this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
    L17:
        if (getAttribute(TAG_LIGHT_SOURCE) != null) goto L20;
        this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        return;
    }

    public void flipHorizontally() {
        int r100 = 1;
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        r100 = 0;
        goto L12
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
        r100 = 2;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r100));
    }

    public void flipVertically() {
        int r100 = 1;
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L12;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        r100 = 0;
        goto L12
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
        r100 = 2;
        goto L12
    L10:
        r100 = 3;
        goto L12
    L11:
        r100 = 4;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r100));
    }

    public long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME));
    }

    public long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED));
    }

    public long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL));
    }

    public long getGpsDateTime() {
        String r100 = getAttribute(TAG_GPS_DATESTAMP);
        String r101 = getAttribute(TAG_GPS_TIMESTAMP);
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        Pattern r102 = sNonZeroTimePattern;
        if (r102.matcher(r100).matches() == true) goto L18;
        if (r102.matcher(r101).matches() == false) goto L16;
    L18:
        Date r103 = sFormatter.parse(r100 + ' ' + r101, new ParsePosition(0));     // Catch: IllegalArgumentException -> L17
        if (r103 != null) goto L14;
        return -1;
    L14:
        return r103.getTime();
    L16:
        return -1;
    }

    public double[] getLatLong() {
        String r100 = getAttribute(TAG_GPS_LATITUDE);
        String r101 = getAttribute(TAG_GPS_LATITUDE_REF);
        String r102 = getAttribute(TAG_GPS_LONGITUDE);
        String r103 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (r100 == null) goto L15;
        if (r101 == null) goto L16;
        if (r102 == null) goto L17;
        if (r103 != null) goto L13;
        return null;
    L13:
        return new double[]{convertRationalLatLonToDouble(r100, r101), convertRationalLatLonToDouble(r102, r103)};
    L10:
        String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{r100, r101, r102, r103});
        return null;
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public int getRotationDegrees() {
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L8;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 90;
    L8:
        return 270;
    L10:
        return 180;
    }

    public byte[] getThumbnail() {
        int r100 = this.mThumbnailCompression;
        if (r100 == 6) goto L10;
        if (r100 == 7) goto L10;
        return null;
    L10:
        return getThumbnailBytes();
    }

    public Bitmap getThumbnailBitmap() {
        if (this.mHasThumbnail == true) goto L6;
        return null;
    L6:
        if (this.mThumbnailBytes != null) goto L8;
        this.mThumbnailBytes = getThumbnailBytes();
    L8:
        int r100 = this.mThumbnailCompression;
        if (r100 == 6) goto L25;
        if (r100 == 7) goto L25;
        if (r100 != 1) goto L23;
        int r101 = this.mThumbnailBytes.length / 3;
        int[] r102 = new int[r101];
        int r103 = 0;
    L16:
        if (r103 >= r101) goto L18;
        byte[] r104 = this.mThumbnailBytes;
        int r105 = r103 * 3;
        r102[r103] = (((r104[r105] << 16) + 0) + (r104[r105 + 1] << 8)) + r104[r105 + 2];
        r103 = r103 + 1;
        goto L16
    L18:
        ExifAttribute r106 = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
        ExifAttribute r107 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
        if (r106 == null) goto L23;
        if (r107 == null) goto L23;
        int r108 = r106.getIntValue(this.mExifByteOrder);
        return Bitmap.createBitmap(r102, r107.getIntValue(this.mExifByteOrder), r108, Bitmap.Config.ARGB_8888);
    L23:
        return null;
    L25:
        return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
    }

    public byte[] getThumbnailBytes() {
        InputStream r100 = null;
        if (this.mHasThumbnail == true) goto L5;
        return null;
    L5:
        byte[] r101 = this.mThumbnailBytes;
        if (r101 == null) goto L65;
        return r101;
    L65:
        InputStream r102 = this.mAssetInputStream;     // Catch: Throwable -> L51 Exception -> L57
        if (r102 == null) goto L20;
    L18:
        FileDescriptor r103 = null;
    L58:
        closeQuietly(r102);
        if (r103 == null) goto L61;
        closeFileDescriptor(r103);
    L61:
        return null;
    L16:
        th = move-exception;
        r100 = r102;
        Throwable r104 = th;
        r103 = null;
    L53:
        closeQuietly(r100);
        if (r103 == null) goto L69;
        closeFileDescriptor(r103);
        throw r104;
    L69:
        throw r104;
    L11:
        if (r102.markSupported() == false) goto L14;
        r102.reset();     // Catch: Throwable -> L16 Exception -> L18
    L13:
        r103 = null;
    L66:
        if (r102 == null) goto L50;
        if (r102.skip(this.mThumbnailOffset) != this.mThumbnailOffset) goto L45;
        byte[] r105 = new byte[this.mThumbnailLength];     // Catch: Throwable -> L46 Exception -> L62
        if (r102.read(r105) != this.mThumbnailLength) goto L43;
        this.mThumbnailBytes = r105;     // Catch: Throwable -> L46 Exception -> L62
        closeQuietly(r102);
        if (r103 == null) goto L41;
        closeFileDescriptor(r103);
    L41:
        return r105;
    L43:
        throw new IOException("Corrupted image");     // Catch: Throwable -> L46 Exception -> L62
    L45:
        throw new IOException("Corrupted image");     // Catch: Throwable -> L46 Exception -> L62
    L50:
        throw new FileNotFoundException();     // Catch: Throwable -> L46 Exception -> L62
    L46:
        th = move-exception;
        Throwable r106 = th;
        r100 = r102;
    L48:
        r104 = r106;
        goto L53
    L14:
        closeQuietly(r102);
        return null;
    L20:
        if (this.mFilename == null) goto L22;
        r102 = new FileInputStream(this.mFilename);     // Catch: Throwable -> L51 Exception -> L57
        goto L13
    L22:
        FileDescriptor r107 = this.mSeekableFileDescriptor;     // Catch: Throwable -> L51 Exception -> L57
        if (r107 == null) goto L30;
        FileDescriptor r108 = Os.dup(r107);     // Catch: Throwable -> L51 Exception -> L57
        Os.lseek(r108, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L27 Exception -> L29
        r103 = r108;
        r102 = new FileInputStream(r108);     // Catch: Throwable -> L27 Exception -> L29
        goto L66
    L29:
        r103 = r108;
        r102 = null;
    L27:
        th = move-exception;
        r106 = th;
        r103 = r108;
        goto L48
    L30:
        r102 = null;
        r103 = null;
    L57:
        r102 = null;
        r103 = null;
    L51:
        th = move-exception;
        r104 = th;
        r103 = null;
        goto L53
    }

    public long[] getThumbnailRange() {
        if (this.mModified == true) goto L11;
        if (this.mHasThumbnail == true) goto L7;
        return null;
    L7:
        return new long[]{this.mThumbnailOffset, this.mThumbnailLength};
    L11:
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    }

    public boolean isFlipped() {
        int r100 = getAttributeInt(TAG_ORIENTATION, 1);
        if (r100 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 7) goto L12;
        if (r100 == 4) goto L12;
        if (r100 == 5) goto L12;
        return false;
    }

    public boolean isThumbnailCompressed() {
        if (this.mHasThumbnail == true) goto L5;
        return false;
    L5:
        int r100 = this.mThumbnailCompression;
        if (r100 != 6) goto L8;
        return true;
    L8:
        if (r100 == 7) goto L13;
        return false;
    L13:
        return true;
    }

    public void saveAttributes() throws IOException {
        if (this.mIsSupportedFile == false) goto L89;
        if (this.mMimeType != 4) goto L89;
        if (this.mSeekableFileDescriptor == null) goto L9;
    L13:
        this.mModified = true;
        this.mThumbnailBytes = getThumbnail();
        InputStream r100 = null;
        if (this.mFilename == null) goto L16;
        File r101 = new File(this.mFilename);
    L99:
    L81:
        e = e;
        FileOutputStream r102 = null;
    L90:
    L85:
        th = th;
    L86:
        closeQuietly(r100);
        closeQuietly(r102);
        throw th;
    L84:
        throw new IOException("Failed to copy original file to temp file", e);     // Catch: Throwable -> L85
    L79:
        th = th;
        r102 = null;
        goto L86
    L18:
        if (this.mFilename == null) goto L25;
        File r103 = new File(this.mFilename + DefaultDiskStorage.FileType.TEMP);     // Catch: Throwable -> L79 Exception -> L81
        if (r101.renameTo(r103) == false) goto L23;
        FileInputStream r104 = null;
        r102 = null;
    L41:
        closeQuietly(r104);
        closeQuietly(r102);
        FileInputStream r105 = new FileInputStream(r103);     // Catch: Throwable -> L64 Exception -> L66
        if (this.mFilename == null) goto L45;
        FileOutputStream r106 = new FileOutputStream(this.mFilename);     // Catch: Throwable -> L64 Exception -> L66
    L49:
        BufferedInputStream r107 = new BufferedInputStream(r105);     // Catch: Throwable -> L64 Exception -> L66
        BufferedOutputStream r108 = new BufferedOutputStream(r106);     // Catch: Throwable -> L58 Exception -> L61
        saveJpegAttributes(r107, r108);     // Catch: Throwable -> L54 Exception -> L56
        closeQuietly(r107);
        closeQuietly(r108);
        r103.delete();
        this.mThumbnailBytes = null;
        return;
    L56:
        e = move-exception;
        BufferedOutputStream r109 = r108;
        e = e;
    L63:
        r100 = r107;
    L92:
    L76:
        th = th;
    L77:
        closeQuietly(r100);
        closeQuietly(r109);
        r103.delete();
        throw th;
    L69:
        if (this.mFilename == null) goto L75;
        if (r103.renameTo(r101) == true) goto L75;
        throw new IOException("Couldn't restore original file: " + r101.getAbsolutePath());     // Catch: Throwable -> L76
    L75:
        throw new IOException("Failed to save new file", e);     // Catch: Throwable -> L76
    L54:
        th = move-exception;
        r109 = r108;
        th = th;
    L60:
        r100 = r107;
        goto L77
    L61:
        e = e;
        r109 = null;
    L58:
        th = th;
        r109 = null;
        goto L60
    L45:
        FileDescriptor r110 = this.mSeekableFileDescriptor;     // Catch: Throwable -> L64 Exception -> L66
        if (r110 == null) goto L48;
        Os.lseek(r110, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L64 Exception -> L66
        r106 = new FileOutputStream(this.mSeekableFileDescriptor);     // Catch: Throwable -> L64 Exception -> L66
        goto L49
    L48:
        r106 = null;
    L66:
        e = e;
        r109 = null;
    L64:
        th = th;
        r109 = null;
        goto L77
    L23:
        throw new IOException("Couldn't rename to " + r103.getAbsolutePath());     // Catch: Throwable -> L79 Exception -> L81
    L25:
        if (this.mSeekableFileDescriptor == null) goto L40;
        r103 = File.createTempFile("temp", "jpg");     // Catch: Throwable -> L79 Exception -> L81
        Os.lseek(this.mSeekableFileDescriptor, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L79 Exception -> L81
        r104 = new FileInputStream(this.mSeekableFileDescriptor);     // Catch: Throwable -> L79 Exception -> L81
        r102 = new FileOutputStream(r103);     // Catch: Throwable -> L34 Exception -> L37
        copy(r104, r102);     // Catch: Throwable -> L30 Exception -> L32
    L32:
        e = e;
    L39:
        r100 = r104;
        e = e;
    L30:
        th = th;
    L36:
        r100 = r104;
        th = th;
        goto L86
    L37:
        e = e;
        r102 = null;
    L34:
        th = th;
        r102 = null;
        goto L36
    L40:
        r104 = null;
        r103 = null;
        r102 = null;
        goto L41
    L16:
        r101 = null;
        goto L99
    L9:
        if (this.mFilename != null) goto L13;
        throw new IOException("ExifInterface does not support saving attributes for the current input.");
    L89:
        throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public ExifInterface(FileDescriptor r100) throws IOException {
        ExifTag[][] r101 = EXIF_TAGS;
        this.mAttributes = new HashMap[r101.length];
        this.mAttributesOffsets = new HashSet(r101.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L28;
        this.mAssetInputStream = null;
        this.mFilename = null;
        if (isSeekableFD(r100) == false) goto L12;
        this.mSeekableFileDescriptor = r100;
        r100 = Os.dup(r100);     // Catch: Exception -> L9
        boolean r102 = true;
    L33:
        FileInputStream r103 = new FileInputStream(r100);     // Catch: Throwable -> L21
        loadAttributes(r103);     // Catch: Throwable -> L19
        closeQuietly(r103);
        if (r102 == false) goto L35;
        closeFileDescriptor(r100);
        return;
    L35:
        return;
    L19:
        Throwable th10 = th;
    L23:
        closeQuietly(r103);
        if (r102 == false) goto L26;
        closeFileDescriptor(r100);
    L26:
        throw th10;
    L21:
        th = move-exception;
        r103 = null;
        th10 = th;
    L9:
        e = move-exception;
        throw new IOException("Failed to duplicate file descriptor", e);
    L12:
        this.mSeekableFileDescriptor = null;
        r102 = false;
        goto L33
    L28:
        throw new NullPointerException("fileDescriptor cannot be null");
    }

    private static void closeFileDescriptor(FileDescriptor r100) {
        Os.close(r100);     // Catch: Exception -> L4
        return;
    }

    private static void closeQuietly(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    private String convertDecimalDegree(double r100) {
        long r101 = (long) r100;
        double r102 = r100 - r101;
        long r103 = (long) (r102 * 60.0d);
        return r101 + "/1," + r103 + "/1," + Math.round(((r102 - (r103 / 60.0d)) * 3600.0d) * 1.0E7d) + "/10000000";
    }

    private static long[] convertToLongArray(Object r100) {
        if ((r100 instanceof int[]) == false) goto L10;
        int[] r101 = (int[]) r100;
        long[] r102 = new long[r101.length];
        int r103 = 0;
    L6:
        if (r103 >= r101.length) goto L8;
        r102[r103] = r101[r103];
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    L10:
        if ((r100 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) r100;
    }

    private ExifAttribute getExifAttribute(String r100) {
        if (r100 == null) goto L16;
        if (TAG_ISO_SPEED_RATINGS.equals(r100) == false) goto L6;
        r100 = TAG_PHOTOGRAPHIC_SENSITIVITY;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= EXIF_TAGS.length) goto L13;
        ExifAttribute r102 = this.mAttributes[r101].get(r100);
        if (r102 != null) goto L11;
        r101 = r101 + 1;
        goto L8
    L11:
        return r102;
    L13:
        return null;
    L16:
        throw new NullPointerException("tag shouldn't be null");
    }

    private void getHeifAttributes(final ByteOrderedDataInputStream r110) throws IOException {
        MediaMetadataRetriever r100 = new MediaMetadataRetriever();
    L63:
        th = move-exception;
        r100.release();
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r100.setDataSource(new AnonymousClass1(this, r110));     // Catch: Throwable -> L63
    L12:
        String r101 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 33);     // Catch: Throwable -> L63
        String r102 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 34);     // Catch: Throwable -> L63
        String r103 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 26);     // Catch: Throwable -> L63
        String r104 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 17);     // Catch: Throwable -> L63
        if (BdpAppEventConstant.YES.equals(r103) == false) goto L16;
        String r105 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 29);     // Catch: Throwable -> L63
        String r106 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 30);     // Catch: Throwable -> L63
        String r107 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 31);     // Catch: Throwable -> L63
    L20:
        if (r105 == null) goto L22;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createUShort(Integer.parseInt(r105), this.mExifByteOrder));     // Catch: Throwable -> L63
    L22:
        if (r106 == null) goto L25;
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createUShort(Integer.parseInt(r106), this.mExifByteOrder));     // Catch: Throwable -> L63
    L25:
        if (r107 == null) goto L37;
        int r108 = Integer.parseInt(r107);     // Catch: Throwable -> L63
        if (r108 != 90) goto L29;
        int r109 = 6;
    L36:
        this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createUShort(r109, this.mExifByteOrder));     // Catch: Throwable -> L63
        goto L37
    L29:
        if (r108 != 180) goto L31;
        r109 = 3;
        goto L36
    L31:
        if (r108 == 270) goto L33;
        r109 = 1;
        goto L36
    L33:
        r109 = 8;
    L37:
        if (r101 == null) goto L57;
        if (r102 == null) goto L57;
        int r111 = Integer.parseInt(r101);     // Catch: Throwable -> L63
        int r112 = Integer.parseInt(r102);     // Catch: Throwable -> L63
        if (r112 <= 6) goto L55;
        r110.seek(r111);     // Catch: Throwable -> L63
        byte[] r113 = new byte[6];     // Catch: Throwable -> L63
        if (r110.read(r113) != 6) goto L53;
        int r114 = r112 - 6;     // Catch: Throwable -> L63
        if (Arrays.equals(r113, IDENTIFIER_EXIF_APP1) == false) goto L51;
        byte[] r115 = new byte[r114];     // Catch: Throwable -> L63
        if (r110.read(r115) != r114) goto L49;
        readExifSegment(r115, 0);     // Catch: Throwable -> L63
        goto L57
    L49:
        throw new IOException("Can't read exif");     // Catch: Throwable -> L63
    L51:
        throw new IOException("Invalid identifier");     // Catch: Throwable -> L63
    L53:
        throw new IOException("Can't read identifier");     // Catch: Throwable -> L63
    L55:
        throw new IOException("Invalid exif length");     // Catch: Throwable -> L63
    L57:
        if (DEBUG == true) goto L59;
    L59:
        r100.release();
        return;
    L16:
        if (BdpAppEventConstant.YES.equals(r104) == false) goto L18;
        r105 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 18);     // Catch: Throwable -> L63
        r106 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 19);     // Catch: Throwable -> L63
        r107 = androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(r100, 24);     // Catch: Throwable -> L63
        goto L20
    L18:
        r105 = null;
        r106 = null;
        r107 = null;
        goto L20
    L6:
        FileDescriptor r116 = this.mSeekableFileDescriptor;     // Catch: Throwable -> L63
        if (r116 == null) goto L9;
        r100.setDataSource(r116);     // Catch: Throwable -> L63
        goto L12
    L9:
        String r117 = this.mFilename;     // Catch: Throwable -> L63
        if (r117 == null) goto L61;
        r100.setDataSource(r117);     // Catch: Throwable -> L63
        goto L12
    L61:
        r100.release();
    }

    private int getMimeType(BufferedInputStream r100) throws IOException {
        r100.mark(5000);
        byte[] r101 = new byte[5000];
        r100.read(r101);
        r100.reset();
        if (isJpegFormat(r101) == false) goto L7;
        return 4;
    L7:
        if (isRafFormat(r101) == false) goto L11;
        return 9;
    L11:
        if (isHeifFormat(r101) == false) goto L15;
        return 12;
    L15:
        if (isOrfFormat(r101) == false) goto L19;
        return 7;
    L19:
        if (isRw2Format(r101) == false) goto L22;
        return 10;
    L22:
        return 0;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream r100) throws IOException {
        getRawAttributes(r100);
        ExifAttribute r101 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r101 == null) goto L31;
        ByteOrderedDataInputStream r102 = new ByteOrderedDataInputStream(r101.bytes);
        r102.setByteOrder(this.mExifByteOrder);
        byte[] r103 = ORF_MAKER_NOTE_HEADER_1;
        byte[] r104 = new byte[r103.length];
        r102.readFully(r104);
        r102.seek(0);
        byte[] r105 = ORF_MAKER_NOTE_HEADER_2;
        byte[] r106 = new byte[r105.length];
        r102.readFully(r106);
        if (Arrays.equals(r104, r103) == false) goto L8;
        r102.seek(8);
    L10:
        readImageFileDirectory(r102, 6);
        ExifAttribute r107 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
        ExifAttribute r108 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
        if (r107 == null) goto L14;
        if (r108 == null) goto L14;
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, r107);
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r108);
    L14:
        ExifAttribute r109 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
        if (r109 == null) goto L32;
        int[] r110 = (int[]) r109.getValue(this.mExifByteOrder);
        if (r110 != null) goto L19;
    L29:
        Arrays.toString(r110);
        return;
    L19:
        if (r110.length != 4) goto L29;
        int r111 = r110[2];
        int r112 = r110[0];
        if (r111 <= r112) goto L33;
        int r113 = r110[3];
        int r114 = r110[1];
        if (r113 <= r114) goto L34;
        int r115 = (r111 - r112) + 1;
        int r116 = (r113 - r114) + 1;
        if (r115 >= r116) goto L28;
        int r117 = r115 + r116;
        r116 = r117 - r116;
        r115 = r117 - r116;
    L28:
        ExifAttribute r118 = ExifAttribute.createUShort(r115, this.mExifByteOrder);
        ExifAttribute r119 = ExifAttribute.createUShort(r116, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r118);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r119);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r106, r105) == false) goto L10;
        r102.seek(12);
        goto L10
    }

    private void getRafAttributes(ByteOrderedDataInputStream r100) throws IOException {
        r100.skipBytes(84);
        byte[] r101 = new byte[4];
        byte[] r102 = new byte[4];
        r100.read(r101);
        r100.skipBytes(4);
        r100.read(r102);
        int r103 = ByteBuffer.wrap(r101).getInt();
        int r104 = ByteBuffer.wrap(r102).getInt();
        getJpegAttributes(r100, r103, 5);
        r100.seek(r104);
        r100.setByteOrder(ByteOrder.BIG_ENDIAN);
        int r105 = r100.readInt();
        if (DEBUG == true) goto L5;
    L5:
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L14;
        int r107 = r100.readUnsignedShort();
        int r108 = r100.readUnsignedShort();
        if (r107 == TAG_RAF_IMAGE_SIZE.number) goto L9;
        r100.skipBytes(r108);
        r106 = r106 + 1;
        goto L6
    L9:
        short r109 = r100.readShort();
        short r110 = r100.readShort();
        ExifAttribute r111 = ExifAttribute.createUShort(r109, this.mExifByteOrder);
        ExifAttribute r112 = ExifAttribute.createUShort(r110, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r111);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r112);
        if (DEBUG == true) goto L12;
        return;
    L12:
        return;
    }

    private void getRawAttributes(ByteOrderedDataInputStream r100) throws IOException {
        parseTiffHeaders(r100, r100.available());
        readImageFileDirectory(r100, 0);
        updateImageSizeValues(r100, 0);
        updateImageSizeValues(r100, 5);
        updateImageSizeValues(r100, 4);
        validateImages(r100);
        if (this.mMimeType != 8) goto L10;
        ExifAttribute r101 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r101 == null) goto L11;
        ByteOrderedDataInputStream r102 = new ByteOrderedDataInputStream(r101.bytes);
        r102.setByteOrder(this.mExifByteOrder);
        r102.seek(6);
        readImageFileDirectory(r102, 9);
        ExifAttribute r103 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (r103 == null) goto L12;
        this.mAttributes[1].put(TAG_COLOR_SPACE, r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void getRw2Attributes(ByteOrderedDataInputStream r100) throws IOException {
        getRawAttributes(r100);
        if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) == null) goto L5;
        getJpegAttributes(r100, this.mRw2JpgFromRawOffset, 5);
    L5:
        ExifAttribute r101 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute r102 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (r101 == null) goto L10;
        if (r102 != null) goto L11;
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, r101);
        return;
    L11:
        return;
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
        long r105 = (long) CastDoubleProtector.parseDouble(r112[0]);     // Catch: NumberFormatException -> L72
        long r106 = (long) CastDoubleProtector.parseDouble(r112[1]);     // Catch: NumberFormatException -> L72
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
        Long r107 = Long.valueOf(CastLongProtector.parseLong(r110));     // Catch: NumberFormatException -> L68
        if (r107.longValue() < 0) goto L63;
        if (r107.longValue() > 65535) goto L63;
        return new Pair(3, 4);
    L63:
        if (r107.longValue() >= 0) goto L67;
        return new Pair(9, -1);
    L67:
        return new Pair(4, -1);
    L68:
        CastDoubleProtector.parseDouble(r110);     // Catch: NumberFormatException -> L70
        return new Pair(12, -1);
    L71:
        return new Pair(2, -1);
    }

    private void initForFilename(String r100) throws IOException {
        if (r100 == null) goto L18;
        FileInputStream r101 = null;
        this.mAssetInputStream = null;
        this.mFilename = r100;
        FileInputStream r102 = new FileInputStream(r100);     // Catch: Throwable -> L14
    L12:
        th = th;
        r101 = r102;
    L15:
        closeQuietly(r101);
        throw th;
    L6:
        if (isSeekableFD(r102.getFD()) == false) goto L8;
        this.mSeekableFileDescriptor = r102.getFD();     // Catch: Throwable -> L12
    L9:
        loadAttributes(r102);     // Catch: Throwable -> L12
        closeQuietly(r102);
        return;
    L8:
        this.mSeekableFileDescriptor = null;     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L15
    L18:
        throw new NullPointerException("filename cannot be null");
    }

    private boolean isHeifFormat(byte[] r110) throws IOException {
        ByteOrderedDataInputStream r100 = null;
        ByteOrderedDataInputStream r101 = new ByteOrderedDataInputStream(r110);     // Catch: Throwable -> L49 Exception -> L58
        r101.setByteOrder(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L46 Exception -> L48
        long r102 = r101.readInt();     // Catch: Throwable -> L46 Exception -> L48
        byte[] r103 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        r101.read(r103);     // Catch: Throwable -> L46 Exception -> L48
        if (Arrays.equals(r103, HEIF_TYPE_FTYP) == true) goto L9;
        r101.close();
        return false;
    L9:
        if (r102 != 1) goto L15;
        r102 = r101.readLong();     // Catch: Throwable -> L46 Exception -> L48
        long r104 = 16;
        if (r102 >= 16) goto L17;
        r101.close();
        return false;
    L17:
        if (r102 > r110.length) goto L19;
    L20:
        long r105 = r102 - r104;
        if (r105 >= 8) goto L24;
        r101.close();
        return false;
    L24:
        byte[] r111 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        long r106 = 0;
        boolean r107 = false;
        boolean r112 = false;
    L25:
        if (r106 >= (r105 / 4)) goto L45;
        if (r101.read(r111) != 4) goto L29;
        if (r106 == 1) goto L44;
        if (Arrays.equals(r111, HEIF_BRAND_MIF1) == false) goto L38;
        r107 = true;
    L40:
        if (r107 == false) goto L44;
        if (r112 == false) goto L44;
        r101.close();
        return true;
    L38:
        if (Arrays.equals(r111, HEIF_BRAND_HEIC) == false) goto L40;
        r112 = true;
    L44:
        r106 = r106 + 1;
        goto L25
    L29:
        r101.close();
        return false;
    L45:
        r101.close();
    L54:
        return false;
    L19:
        r102 = r110.length;     // Catch: Throwable -> L46 Exception -> L48
        goto L20
    L15:
        r104 = 8;
    L48:
        r100 = r101;
    L46:
        th = th;
        r100 = r101;
    L55:
        if (r100 == null) goto L57;
        r100.close();
    L57:
        throw th;
    L49:
        th = th;
    L51:
        boolean r113 = DEBUG;     // Catch: Throwable -> L49
        if (r100 == null) goto L54;
        r100.close();
        goto L54
    }

    private static boolean isJpegFormat(byte[] r100) throws IOException {
        int r101 = 0;
    L3:
        byte[] r102 = JPEG_SIGNATURE;
        if (r101 >= r102.length) goto L9;
        if (r100[r101] != r102[r101]) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isOrfFormat(byte[] r100) throws IOException {
        ByteOrderedDataInputStream r101 = new ByteOrderedDataInputStream(r100);
        ByteOrder r102 = readByteOrder(r101);
        this.mExifByteOrder = r102;
        r101.setByteOrder(r102);
        short r103 = r101.readShort();
        r101.close();
        if (r103 != 20306) goto L5;
    L8:
        return true;
    L5:
        if (r103 == 21330) goto L8;
        return false;
    }

    private boolean isRafFormat(byte[] r100) throws IOException {
        byte[] r101 = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L9;
        if (r100[r102] != r101[r102]) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isRw2Format(byte[] r100) throws IOException {
        ByteOrderedDataInputStream r101 = new ByteOrderedDataInputStream(r100);
        ByteOrder r102 = readByteOrder(r101);
        this.mExifByteOrder = r102;
        r101.setByteOrder(r102);
        short r103 = r101.readShort();
        r101.close();
        if (r103 != 85) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isSeekableFD(FileDescriptor r100) throws IOException {
        Os.lseek(r100, 0, OsConstants.SEEK_CUR);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    private boolean isSupportedDataType(HashMap r100) throws IOException {
        ExifAttribute r101 = (ExifAttribute) r100.get(TAG_BITS_PER_SAMPLE);
        if (r101 == null) goto L20;
        int[] r102 = (int[]) r101.getValue(this.mExifByteOrder);
        int[] r103 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(r103, r102) == false) goto L8;
        return true;
    L8:
        if (this.mMimeType != 3) goto L22;
        ExifAttribute r104 = (ExifAttribute) r100.get(TAG_PHOTOMETRIC_INTERPRETATION);
        if (r104 == null) goto L23;
        int r105 = r104.getIntValue(this.mExifByteOrder);
        if (r105 != 1) goto L16;
        if (Arrays.equals(r102, BITS_PER_SAMPLE_GREYSCALE_2) == false) goto L16;
    L19:
        return true;
    L16:
        if (r105 == 6) goto L18;
        return false;
    L18:
        if (Arrays.equals(r102, r103) == true) goto L19;
        return false;
    L23:
        return false;
    L22:
        return false;
    L20:
        return false;
    }

    private boolean isThumbnail(HashMap r100) throws IOException {
        ExifAttribute r101 = (ExifAttribute) r100.get(TAG_IMAGE_LENGTH);
        ExifAttribute r102 = (ExifAttribute) r100.get(TAG_IMAGE_WIDTH);
        if (r101 == null) goto L10;
        if (r102 == null) goto L12;
        int r103 = r101.getIntValue(this.mExifByteOrder);
        int r104 = r102.getIntValue(this.mExifByteOrder);
        if (r103 > 512) goto L13;
        if (r104 > 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private void loadAttributes(InputStream r100) throws IOException {
        if (r100 == null) goto L32;
        int r101 = 0;
    L33:
    L20:
        th = move-exception;
        addDefaultValuesForCompatibility();
        if (DEBUG == false) goto L30;
        printAttributes();
    L30:
        throw th;
    L22:
        this.mIsSupportedFile = false;     // Catch: Throwable -> L20
        boolean r102 = DEBUG;     // Catch: Throwable -> L20
        addDefaultValuesForCompatibility();
        if (r102 == false) goto L37;
    L25:
        printAttributes();
        return;
    L37:
        return;
    L5:
        if (r101 >= EXIF_TAGS.length) goto L7;
        this.mAttributes[r101] = new HashMap();     // Catch: Throwable -> L20 IOException -> L22
        r101 = r101 + 1;     // Catch: Throwable -> L20 IOException -> L22
        goto L33
    L7:
        BufferedInputStream r103 = new BufferedInputStream(r100, 5000);     // Catch: Throwable -> L20 IOException -> L22
        this.mMimeType = getMimeType(r103);     // Catch: Throwable -> L20 IOException -> L22
        ByteOrderedDataInputStream r104 = new ByteOrderedDataInputStream(r103);     // Catch: Throwable -> L20 IOException -> L22
        switch(this.mMimeType) {
            case 0: goto L15;
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L15;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L15;
            case 12: goto L10;
            default: goto L16;
        };     // Catch: Throwable -> L20 IOException -> L22
    L10:
        getHeifAttributes(r104);     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L11:
        getRw2Attributes(r104);     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L12:
        getRafAttributes(r104);     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L13:
        getOrfAttributes(r104);     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L14:
        getJpegAttributes(r104, 0, 0);     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L15:
        getRawAttributes(r104);     // Catch: Throwable -> L20 IOException -> L22
    L16:
        setThumbnailData(r104);     // Catch: Throwable -> L20 IOException -> L22
        this.mIsSupportedFile = true;     // Catch: Throwable -> L20 IOException -> L22
        addDefaultValuesForCompatibility();
        if (DEBUG == true) goto L25;
        return;
    L32:
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream r100) throws IOException {
        short r101 = r100.readShort();
        if (r101 == 18761) goto L11;
        if (r101 != 19789) goto L9;
        return ByteOrder.BIG_ENDIAN;
    L9:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r101));
    L11:
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void removeAttribute(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= EXIF_TAGS.length) goto L6;
        this.mAttributes[r101].remove(r100);
        r101 = r101 + 1;
        goto L4
    }

    private void setThumbnailData(ByteOrderedDataInputStream r100) throws IOException {
        HashMap<String, ExifAttribute> r101 = this.mAttributes[4];
        ExifAttribute r102 = r101.get(TAG_COMPRESSION);
        if (r102 == null) goto L14;
        int r103 = r102.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = r103;
        if (r103 == 1) goto L12;
        if (r103 != 6) goto L8;
        handleThumbnailFromJfif(r100, r101);
        return;
    L8:
        if (r103 == 7) goto L12;
        return;
    L12:
        if (isSupportedDataType(r101) == false) goto L17;
        handleThumbnailFromStrips(r100, r101);
        return;
    L17:
        return;
    L14:
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(r100, r101);
    }

    private void validateImages(InputStream r100) throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute r101 = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute r102 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (r101 == null) goto L7;
        if (r102 == null) goto L7;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r101);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r102);
    L7:
        if (this.mAttributes[4].isEmpty() == true) goto L9;
    L11:
        isThumbnail(this.mAttributes[4]);
        return;
    L9:
        if (isThumbnail(this.mAttributes[5]) == false) goto L11;
        HashMap<String, ExifAttribute>[] r103 = this.mAttributes;
        r103[4] = r103[5];
        r103[5] = new HashMap();
        goto L11
    }

    public double getAltitude(double r100) {
        double r101 = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int r102 = -1;
        int r103 = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        if (r103 < 0) goto L11;
        if (r103 == 1) goto L10;
        r102 = 1;
    L10:
        return r101 * ((double) r102);
    L11:
        return r100;
    }

    public String getAttribute(String r100) {
        if (r100 == null) goto L30;
        ExifAttribute r101 = getExifAttribute(r100);
        if (r101 != null) goto L6;
    L28:
        return null;
    L6:
        if (sTagSetForCompatibility.contains(r100) == true) goto L10;
        return r101.getStringValue(this.mExifByteOrder);
    L10:
        if (r100.equals(TAG_GPS_TIMESTAMP) == false) goto L32;
        int r102 = r101.format;
        if (r102 != 5) goto L14;
    L17:
        Rational[] r103 = (Rational[]) r101.getValue(this.mExifByteOrder);
        if (r103 != null) goto L20;
    L24:
        Arrays.toString(r103);
        return null;
    L20:
        if (r103.length != 3) goto L24;
        Rational r104 = r103[0];
        Rational r105 = r103[1];
        Rational r106 = r103[2];
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r104.numerator / r104.denominator)), Integer.valueOf((int) (r105.numerator / r105.denominator)), Integer.valueOf((int) (r106.numerator / r106.denominator))});
    L14:
        if (r102 == 10) goto L17;
        return null;
    L32:
        return Double.toString(r101.getDoubleValue(this.mExifByteOrder));
    L30:
        throw new NullPointerException("tag shouldn't be null");
    }

    public byte[] getAttributeBytes(String r100) {
        if (r100 == null) goto L10;
        ExifAttribute r101 = getExifAttribute(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.bytes;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    public long[] getAttributeRange(String r100) {
        if (r100 == null) goto L14;
        if (this.mModified == true) goto L12;
        ExifAttribute r101 = getExifAttribute(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return new long[]{r101.bytesOffset, r101.bytes.length};
    L12:
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    L14:
        throw new NullPointerException("tag shouldn't be null");
    }

    public boolean getLatLong(float[] r100) {
        double[] r101 = getLatLong();
        if (r101 != null) goto L5;
        return false;
    L5:
        r100[0] = (float) r101[0];
        r100[1] = (float) r101[1];
        return true;
    }

    public boolean hasAttribute(String r100) {
        if (getExifAttribute(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void rotate(int r100) {
        if ((r100 % 90) != 0) goto L19;
        int r101 = getAttributeInt(TAG_ORIENTATION, 1);
        List<Integer> r102 = ROTATION_ORDER;
        int r103 = 0;
        if (r102.contains(Integer.valueOf(r101)) == false) goto L10;
        int r104 = (r102.indexOf(Integer.valueOf(r101)) + (r100 / 90)) % 4;
        if (r104 >= 0) goto L9;
        r103 = 4;
    L9:
        r103 = ((Integer) ListProtector.get(r102, r104 + r103)).intValue();
    L16:
        setAttribute(TAG_ORIENTATION, Integer.toString(r103));
        return;
    L10:
        List<Integer> r105 = FLIPPED_ROTATION_ORDER;
        if (r105.contains(Integer.valueOf(r101)) == false) goto L16;
        int r106 = (r105.indexOf(Integer.valueOf(r101)) + (r100 / 90)) % 4;
        if (r106 >= 0) goto L15;
        r103 = 4;
    L15:
        r103 = ((Integer) ListProtector.get(r105, r106 + r103)).intValue();
        goto L16
    L19:
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void setAltitude(double r100) {
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        String r101 = "0";
    L6:
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(r100)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, r101);
        return;
    L5:
        r101 = "1";
        goto L6
    }

    public void setDateTime(long r100) {
        long r101 = r100 % 1000;
        setAttribute(TAG_DATETIME, sFormatter.format(new Date(r100)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(r101));
    }

    public void setGpsInfo(Location r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setAttribute(TAG_GPS_PROCESSING_METHOD, r100.getProvider());
        setLatLong(r100.getLatitude(), r100.getLongitude());
        setAltitude(r100.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((r100.getSpeed() * TimeUnit.HOURS.toSeconds(1)) / 1000.0f).toString());
        String[] r101 = sFormatter.format(new Date(r100.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, r101[0]);
        setAttribute(TAG_GPS_TIMESTAMP, r101[1]);
    }

    public ExifInterface(InputStream r100) throws IOException {
        ExifTag[][] r101 = EXIF_TAGS;
        this.mAttributes = new HashMap[r101.length];
        this.mAttributesOffsets = new HashSet(r101.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L16;
        this.mFilename = null;
        if ((r100 instanceof AssetManager.AssetInputStream) == false) goto L8;
        this.mAssetInputStream = (AssetManager.AssetInputStream) r100;
        this.mSeekableFileDescriptor = null;
    L13:
        loadAttributes(r100);
        return;
    L8:
        if ((r100 instanceof FileInputStream) == false) goto L12;
        FileInputStream r102 = (FileInputStream) r100;
        if (isSeekableFD(r102.getFD()) == false) goto L12;
        this.mAssetInputStream = null;
        this.mSeekableFileDescriptor = r102.getFD();
    L12:
        this.mAssetInputStream = null;
        this.mSeekableFileDescriptor = null;
        goto L13
    L16:
        throw new NullPointerException("inputStream cannot be null");
    }

    public ExifInterface(File r100) throws IOException {
        ExifTag[][] r101 = EXIF_TAGS;
        this.mAttributes = new HashMap[r101.length];
        this.mAttributesOffsets = new HashSet(r101.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L7;
        initForFilename(r100.getAbsolutePath());
        return;
    L7:
        throw new NullPointerException("file cannot be null");
    }

    public ExifInterface(String r100) throws IOException {
        ExifTag[][] r101 = EXIF_TAGS;
        this.mAttributes = new HashMap[r101.length];
        this.mAttributesOffsets = new HashSet(r101.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r100 == null) goto L7;
        initForFilename(r100);
        return;
    L7:
        throw new NullPointerException("filename cannot be null");
    }

    private static String androidx_exifinterface_media_ExifInterface_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r110, int r111) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static double convertRationalLatLonToDouble(String r110, String r111) {
        String[] r112 = r110.split(",", -1);     // Catch: Throwable -> L18
        String[] r100 = r112[0].split(HTTP.URL_DEFAULT, -1);     // Catch: Throwable -> L18
        double r101 = CastDoubleProtector.parseDouble(r100[0].trim()) / CastDoubleProtector.parseDouble(r100[1].trim());     // Catch: Throwable -> L18
        String[] r102 = r112[1].split(HTTP.URL_DEFAULT, -1);     // Catch: Throwable -> L18
        double r103 = CastDoubleProtector.parseDouble(r102[0].trim()) / CastDoubleProtector.parseDouble(r102[1].trim());     // Catch: Throwable -> L18
        String[] r113 = r112[2].split(HTTP.URL_DEFAULT, -1);     // Catch: Throwable -> L18
        double r104 = (r101 + (r103 / 60.0d)) + ((CastDoubleProtector.parseDouble(r113[0].trim()) / CastDoubleProtector.parseDouble(r113[1].trim())) / 3600.0d);     // Catch: Throwable -> L18
        if (r111.equals(LATITUDE_SOUTH) == true) goto L17;
        if (r111.equals(LONGITUDE_WEST) == true) goto L17;
        if (r111.equals("N") == false) goto L11;
    L15:
        return r104;
    L11:
        if (r111.equals(LONGITUDE_EAST) == true) goto L15;
        throw new IllegalArgumentException();     // Catch: Throwable -> L18
    L17:
        return -r104;
    L19:
        throw new IllegalArgumentException();
    }

    private static int copy(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[8192];
        int r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if (r104 == (-1)) goto L6;
        r103 = r103 + r104;
        r101.write(r102, 0, r104);
        goto L3
    L6:
        return r103;
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream r100, HashMap r101) throws IOException {
        ExifAttribute r102 = (ExifAttribute) r101.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute r103 = (ExifAttribute) r101.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r102 == null) goto L30;
        if (r103 == null) goto L31;
        int r104 = r102.getIntValue(this.mExifByteOrder);
        int r105 = Math.min(r103.getIntValue(this.mExifByteOrder), r100.getLength() - r104);
        int r106 = this.mMimeType;
        if (r106 != 4) goto L8;
    L15:
        int r107 = this.mExifOffset;
    L16:
        r104 = r104 + r107;
    L18:
        if (DEBUG == true) goto L20;
    L20:
        if (r104 <= 0) goto L32;
        if (r105 <= 0) goto L33;
        this.mHasThumbnail = true;
        this.mThumbnailOffset = r104;
        this.mThumbnailLength = r105;
        if (this.mFilename == null) goto L25;
        return;
    L25:
        if (this.mAssetInputStream == null) goto L27;
        return;
    L27:
        if (this.mSeekableFileDescriptor != null) goto L36;
        byte[] r108 = new byte[r105];
        r100.seek(r104);
        r100.readFully(r108);
        this.mThumbnailBytes = r108;
        return;
    L36:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (r106 == 9) goto L15;
        if (r106 == 10) goto L15;
        if (r106 != 7) goto L18;
        r107 = this.mOrfMakerNoteOffset;
        goto L16
    L31:
        return;
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream r110, HashMap r111) throws IOException {
        ExifAttribute r100 = (ExifAttribute) r111.get(TAG_STRIP_OFFSETS);
        ExifAttribute r112 = (ExifAttribute) r111.get(TAG_STRIP_BYTE_COUNTS);
        if (r100 == null) goto L21;
        if (r112 == null) goto L22;
        long[] r101 = convertToLongArray(r100.getValue(this.mExifByteOrder));
        long[] r113 = convertToLongArray(r112.getValue(this.mExifByteOrder));
        if (r101 != null) goto L8;
        return;
    L8:
        if (r113 != null) goto L10;
        return;
    L10:
        int r102 = r113.length;
        long r103 = 0;
        int r104 = 0;
    L11:
        if (r104 >= r102) goto L13;
        r103 = r103 + r113[r104];
        r104 = r104 + 1;
        goto L11
    L13:
        int r105 = (int) r103;
        byte[] r106 = new byte[r105];
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L15:
        if (r107 >= r101.length) goto L17;
        int r114 = (int) r101[r107];
        int r115 = (int) r113[r107];
        int r116 = r114 - r108;
        r110.seek(r116);
        int r117 = r108 + r116;
        byte[] r118 = new byte[r115];
        r110.read(r118);
        r108 = r117 + r115;
        System.arraycopy(r118, 0, r106, r109, r115);
        r109 = r109 + r115;
        r107 = r107 + 1;
        goto L15
    L17:
        this.mHasThumbnail = true;
        this.mThumbnailBytes = r106;
        this.mThumbnailLength = r105;
        return;
    L22:
        return;
    }

    private static long parseDateTime(String r100, String r101) {
        if (r100 != null) goto L5;
    L20:
        return -1;
    L5:
        if (sNonZeroTimePattern.matcher(r100).matches() == false) goto L20;
        ParsePosition r102 = new ParsePosition(0);
        Date r103 = sFormatter.parse(r100, r102);     // Catch: IllegalArgumentException -> L22
        if (r103 != null) goto L11;
        return -1;
    L11:
        long r104 = r103.getTime();     // Catch: IllegalArgumentException -> L22
        if (r101 == null) goto L28;
        long r105 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L21 IllegalArgumentException -> L22
    L15:
        if (r105 <= 1000) goto L19;
        r105 = r105 / 10;     // Catch: NumberFormatException -> L21 IllegalArgumentException -> L22
    L19:
        return r104 + r105;
    L29:
        return r104;
    L28:
        return r104;
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream r100, int r101) throws IOException {
        ByteOrder r102 = readByteOrder(r100);
        this.mExifByteOrder = r102;
        r100.setByteOrder(r102);
        int r103 = r100.readUnsignedShort();
        int r104 = this.mMimeType;
        if (r104 != 7) goto L5;
    L11:
        int r105 = r100.readInt();
        if (r105 < 8) goto L23;
        if (r105 >= r101) goto L23;
        int r106 = r105 - 8;
        if (r106 > 0) goto L17;
        return;
    L17:
        if (r100.skipBytes(r106) != r106) goto L20;
        return;
    L20:
        throw new IOException("Couldn't jump to first Ifd: " + r106);
    L23:
        throw new IOException("Invalid first Ifd offset: " + r105);
    L5:
        if (r104 == 10) goto L11;
        if (r103 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r103));
    }

    private void readExifSegment(byte[] r100, int r101) throws IOException {
        ByteOrderedDataInputStream r102 = new ByteOrderedDataInputStream(r100);
        parseTiffHeaders(r102, r100.length);
        readImageFileDirectory(r102, r101);
    }

    private void readImageFileDirectory(ByteOrderedDataInputStream r210, int r310) throws IOException {
        this.mAttributesOffsets.add(Integer.valueOf(r210.mPosition));
        if ((r210.mPosition + 2) <= r210.mLength) goto L5;
        return;
    L5:
        short r100 = r210.readShort();
        if (DEBUG == true) goto L9;
    L9:
        if ((r210.mPosition + (r100 * 12)) > r210.mLength) goto L161;
        if (r100 <= 0) goto L169;
        char r101 = 0;
        short r102 = 0;
    L14:
        if (r102 >= r100) goto L135;
        int r110 = r210.readUnsignedShort();
        int r111 = r210.readUnsignedShort();
        int r112 = r210.readInt();
        long r103 = ((long) r210.peek()) + 4;
        ExifTag r113 = sExifTagMapsForReading[r310].get(Integer.valueOf(r110));
        boolean r114 = DEBUG;
        if (r114 == false) goto L23;
        Object[] r104 = new Object[5];
        r104[r101] = Integer.valueOf(r310);
        r104[1] = Integer.valueOf(r110);
        if (r113 == null) goto L20;
        String r115 = r113.name;
    L21:
        r104[2] = r115;
        r104[3] = Integer.valueOf(r111);
        r104[4] = Integer.valueOf(r112);
        String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", r104);
        goto L23
    L20:
        r115 = null;
    L23:
        if (r113 != null) goto L27;
        if (r114 == true) goto L26;
    L26:
        long r211 = r103;
    L48:
        long r105 = 0;
    L49:
        boolean r106 = false;
    L50:
        if (r106 == true) goto L53;
        r210.seek(r211);
        short r212 = r100;
        short r213 = r102;
    L133:
        r102 = (short) (r213 + 1);
        r100 = r212;
        r101 = 0;
        goto L14
    L53:
        long r107 = r211;
        if (r105 <= 4) goto L80;
        int r108 = r210.readInt();
        if (r114 == true) goto L58;
    L58:
        r212 = r100;
        int r109 = this.mMimeType;
        r213 = r102;
        if (r109 == 7) goto L61;
        int r116 = r110;
        int r117 = r111;
        int r214 = r112;
        if (r109 == 10) goto L72;
    L74:
        long r118 = r108;
        if ((r118 + r105) > r210.mLength) goto L77;
        r210.seek(r118);
    L81:
        Integer r119 = sExifPointerTagMap.get(Integer.valueOf(r116));
        if (r114 == true) goto L85;
    L85:
        if (r119 == null) goto L116;
        int r120 = r117;
        if (r120 != 3) goto L89;
        int r121 = r210.readUnsignedShort();
    L100:
        long r122 = r121;
    L102:
        if (r114 == false) goto L105;
        String.format("Offset: %d, tagName: %s", new Object[]{Long.valueOf(r122), r113.name});
    L105:
        if (r122 > 0) goto L107;
    L113:
        if (r114 == true) goto L115;
    L115:
        r210.seek(r107);
        goto L133
    L107:
        if (r122 >= r210.mLength) goto L113;
        if (this.mAttributesOffsets.contains(Integer.valueOf((int) r122)) == true) goto L111;
        r210.seek(r122);
        readImageFileDirectory(r210, r119.intValue());
        goto L115
    L111:
        if (r114 == false) goto L115;
        goto L115
    L89:
        if (r120 == 4) goto L98;
        if (r120 != 8) goto L92;
        r121 = r210.readShort();
        goto L100
    L92:
        if (r120 != 9) goto L94;
    L96:
        r121 = r210.readInt();
        goto L100
    L94:
        if (r120 == 13) goto L96;
        r122 = -1;
        goto L102
    L98:
        r122 = r210.readUnsignedInt();
        goto L102
    L116:
        int r123 = r210.peek();
        byte[] r124 = new byte[(int) r105];
        r210.readFully(r124);
        ExifAttribute r125 = new ExifAttribute(r117, r214, r123, r124);
        this.mAttributes[r310].put(r113.name, r125);
        if (TAG_DNG_VERSION.equals(r113.name) == false) goto L120;
        this.mMimeType = 3;
    L120:
        if (TAG_MAKE.equals(r113.name) == true) goto L124;
        if (TAG_MODEL.equals(r113.name) == true) goto L124;
    L126:
        if (TAG_COMPRESSION.equals(r113.name) == false) goto L131;
        if (r125.getIntValue(this.mExifByteOrder) != 65535) goto L131;
    L129:
        this.mMimeType = 8;
    L131:
        if (r210.peek() == r107) goto L133;
        r210.seek(r107);
    L124:
        if (r125.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE) == true) goto L129;
    L77:
        if (r114 == true) goto L79;
    L79:
        r210.seek(r107);
        goto L133
    L72:
        if (TAG_RW2_JPG_FROM_RAW.equals(r113.name) == false) goto L74;
        this.mRw2JpgFromRawOffset = r108;
        goto L74
    L61:
        if (TAG_MAKER_NOTE.equals(r113.name) == false) goto L64;
        this.mOrfMakerNoteOffset = r108;
    L68:
        r116 = r110;
        r117 = r111;
        r214 = r112;
        goto L74
    L64:
        if (r310 != 6) goto L68;
        if (TAG_ORF_THUMBNAIL_IMAGE.equals(r113.name) == false) goto L68;
        this.mOrfThumbnailOffset = r108;
        this.mOrfThumbnailLength = r112;
        ExifAttribute r126 = ExifAttribute.createUShort(6, this.mExifByteOrder);
        r116 = r110;
        r117 = r111;
        ExifAttribute r127 = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
        r214 = r112;
        ExifAttribute r128 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
        this.mAttributes[4].put(TAG_COMPRESSION, r126);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, r127);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r128);
        goto L74
    L80:
        r212 = r100;
        r213 = r102;
        r116 = r110;
        r117 = r111;
        r214 = r112;
        goto L81
    L27:
        if (r111 <= 0) goto L45;
        int[] r129 = IFD_FORMAT_BYTES_PER_FORMAT;
        if (r111 >= r129.length) goto L45;
        if (r113.isFormatCompatible(r111) == true) goto L35;
        if (r114 == false) goto L26;
        String r130 = IFD_FORMAT_NAMES[r111];
        goto L26
    L35:
        if (r111 != 7) goto L37;
        r111 = r113.primaryFormat;
    L37:
        r211 = r103;
        r105 = ((long) r112) * ((long) r129[r111]);
        if (r105 >= 0) goto L40;
    L43:
        if (r114 == false) goto L49;
        goto L49
    L40:
        if (r105 > SieveCacheKt.NodeLinkMask) goto L43;
        r106 = true;
    L45:
        r211 = r103;
        if (r114 == false) goto L48;
        goto L48
    L135:
        if ((r210.peek() + 4) > r210.mLength) goto L162;
        int r131 = r210.readInt();
        boolean r132 = DEBUG;
        if (r132 == false) goto L139;
        String.format("nextIfdOffset: %d", new Object[]{Integer.valueOf(r131)});
    L139:
        long r133 = r131;
        if (r133 > 0) goto L142;
    L153:
        if (r132 == true) goto L155;
        return;
    L155:
        return;
    L142:
        if (r131 >= r210.mLength) goto L153;
        if (this.mAttributesOffsets.contains(Integer.valueOf(r131)) == true) goto L151;
        r210.seek(r133);
        if (this.mAttributes[4].isEmpty() == false) goto L149;
        readImageFileDirectory(r210, 4);
        return;
    L149:
        if (this.mAttributes[5].isEmpty() == false) goto L164;
        readImageFileDirectory(r210, 5);
        return;
    L164:
        return;
    L151:
        if (r132 == true) goto L167;
        return;
    L167:
        return;
    L162:
        return;
    L169:
        return;
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream r100, int r101) throws IOException {
        ExifAttribute r102 = this.mAttributes[r101].get(TAG_IMAGE_LENGTH);
        ExifAttribute r103 = this.mAttributes[r101].get(TAG_IMAGE_WIDTH);
        if (r102 == null) goto L5;
        if (r103 == null) goto L5;
        return;
    L5:
        ExifAttribute r104 = this.mAttributes[r101].get(TAG_JPEG_INTERCHANGE_FORMAT);
        if (r104 == null) goto L10;
        getJpegAttributes(r100, r104.getIntValue(this.mExifByteOrder), r101);
        return;
    }

    private void saveJpegAttributes(InputStream r110, OutputStream r111) throws IOException {
        if (DEBUG == false) goto L5;
        Objects.toString(r110);
        Objects.toString(r111);
    L5:
        DataInputStream r100 = new DataInputStream(r110);
        ByteOrderedDataOutputStream r112 = new ByteOrderedDataOutputStream(r111, ByteOrder.BIG_ENDIAN);
        if (r100.readByte() != (-1)) goto L57;
        r112.writeByte(-1);
        if (r100.readByte() != (-40)) goto L55;
        r112.writeByte(-40);
        r112.writeByte(-1);
        r112.writeByte(-31);
        writeExifSegment(r112, 6);
        byte[] r101 = new byte[4096];
    L11:
        if (r100.readByte() != (-1)) goto L53;
        byte r102 = r100.readByte();
        if (r102 == (-39)) goto L50;
        if (r102 == (-38)) goto L50;
        if (r102 != (-31)) goto L18;
        int r103 = r100.readUnsignedShort() - 2;
        if (r103 < 0) goto L49;
        byte[] r113 = new byte[6];
        if (r103 < 6) goto L41;
        if (r100.read(r113) != 6) goto L40;
        if (Arrays.equals(r113, IDENTIFIER_EXIF_APP1) == false) goto L41;
        int r104 = r103 - 6;
        if (r100.skipBytes(r104) == r104) goto L11;
        throw new IOException("Invalid length");
    L40:
        throw new IOException("Invalid exif");
    L41:
        r112.writeByte(-1);
        r112.writeByte(r102);
        r112.writeUnsignedShort(r103 + 2);
        if (r103 < 6) goto L44;
        r103 = r103 - 6;
        r112.write(r113);
    L44:
        if (r103 <= 0) goto L11;
        int r105 = r100.read(r101, 0, Math.min(r103, 4096));
        if (r105 < 0) goto L11;
        r112.write(r101, 0, r105);
        r103 = r103 - r105;
        goto L44
    L49:
        throw new IOException("Invalid length");
    L18:
        r112.writeByte(-1);
        r112.writeByte(r102);
        int r106 = r100.readUnsignedShort();
        r112.writeUnsignedShort(r106);
        int r107 = r106 - 2;
        if (r107 < 0) goto L25;
    L20:
        if (r107 <= 0) goto L11;
        int r108 = r100.read(r101, 0, Math.min(r107, 4096));
        if (r108 < 0) goto L11;
        r112.write(r101, 0, r108);
        r107 = r107 - r108;
        goto L20
    L25:
        throw new IOException("Invalid length");
    L50:
        r112.writeByte(-1);
        r112.writeByte(r102);
        copy(r100, r112);
        return;
    L53:
        throw new IOException("Invalid marker");
    L55:
        throw new IOException("Invalid marker");
    L57:
        throw new IOException("Invalid marker");
    }

    private static boolean startsWith(byte[] r100, byte[] r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.length >= r101.length) goto L9;
        return false;
    L9:
        int r102 = 0;
    L11:
        if (r102 >= r101.length) goto L16;
        if (r100[r102] != r101[r102]) goto L14;
        r102 = r102 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    private void swapBasedOnImageSize(int r100, int r101) throws IOException {
        if (this.mAttributes[r100].isEmpty() == false) goto L5;
        return;
    L5:
        if (this.mAttributes[r101].isEmpty() == true) goto L24;
        ExifAttribute r102 = this.mAttributes[r100].get(TAG_IMAGE_LENGTH);
        ExifAttribute r103 = this.mAttributes[r100].get(TAG_IMAGE_WIDTH);
        ExifAttribute r104 = this.mAttributes[r101].get(TAG_IMAGE_LENGTH);
        ExifAttribute r105 = this.mAttributes[r101].get(TAG_IMAGE_WIDTH);
        if (r102 == null) goto L20;
        if (r103 == null) goto L25;
        if (r104 == null) goto L21;
        if (r105 == null) goto L26;
        int r106 = r102.getIntValue(this.mExifByteOrder);
        int r107 = r103.getIntValue(this.mExifByteOrder);
        int r108 = r104.getIntValue(this.mExifByteOrder);
        int r109 = r105.getIntValue(this.mExifByteOrder);
        if (r106 >= r108) goto L22;
        if (r107 >= r109) goto L23;
        HashMap<String, ExifAttribute>[] r110 = this.mAttributes;
        HashMap<String, ExifAttribute> r111 = r110[r100];
        r110[r100] = r110[r101];
        r110[r101] = r111;
        return;
    L23:
        return;
    L22:
        return;
    L26:
        return;
    L21:
        return;
    L25:
        return;
    L20:
        return;
    }

    private boolean updateAttribute(String r100, ExifAttribute r101) {
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 >= EXIF_TAGS.length) goto L9;
        if (this.mAttributes[r102].containsKey(r100) == false) goto L8;
        this.mAttributes[r102].put(r100, r101);
        r103 = true;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r103;
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream r100, int r101) throws IOException {
        ExifAttribute r102 = this.mAttributes[r101].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute r103 = this.mAttributes[r101].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute r104 = this.mAttributes[r101].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute r105 = this.mAttributes[r101].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute r106 = this.mAttributes[r101].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (r102 != null) goto L5;
        if (r103 == null) goto L31;
        if (r104 == null) goto L31;
        if (r105 == null) goto L31;
        if (r106 == null) goto L31;
        int r107 = r103.getIntValue(this.mExifByteOrder);
        int r108 = r105.getIntValue(this.mExifByteOrder);
        int r109 = r106.getIntValue(this.mExifByteOrder);
        int r110 = r104.getIntValue(this.mExifByteOrder);
        if (r108 <= r107) goto L34;
        if (r109 <= r110) goto L35;
        ExifAttribute r111 = ExifAttribute.createUShort(r108 - r107, this.mExifByteOrder);
        ExifAttribute r112 = ExifAttribute.createUShort(r109 - r110, this.mExifByteOrder);
        this.mAttributes[r101].put(TAG_IMAGE_LENGTH, r111);
        this.mAttributes[r101].put(TAG_IMAGE_WIDTH, r112);
        return;
    L35:
        return;
    L34:
        return;
    L31:
        retrieveJpegImageSize(r100, r101);
        return;
    L5:
        if (r102.format != 5) goto L14;
        Rational[] r113 = (Rational[]) r102.getValue(this.mExifByteOrder);
        if (r113 != null) goto L9;
    L12:
        Arrays.toString(r113);
        return;
    L9:
        if (r113.length != 2) goto L12;
        ExifAttribute r114 = ExifAttribute.createURational(r113[0], this.mExifByteOrder);
        ExifAttribute r115 = ExifAttribute.createURational(r113[1], this.mExifByteOrder);
    L20:
        this.mAttributes[r101].put(TAG_IMAGE_WIDTH, r114);
        this.mAttributes[r101].put(TAG_IMAGE_LENGTH, r115);
        return;
    L14:
        int[] r116 = (int[]) r102.getValue(this.mExifByteOrder);
        if (r116 != null) goto L17;
    L21:
        Arrays.toString(r116);
        return;
    L17:
        if (r116.length != 2) goto L21;
        r114 = ExifAttribute.createUShort(r116[0], this.mExifByteOrder);
        r115 = ExifAttribute.createUShort(r116[1], this.mExifByteOrder);
        goto L20
    }

    private int writeExifSegment(ByteOrderedDataOutputStream r110, int r111) throws IOException {
        ExifTag[][] r100 = EXIF_TAGS;
        int[] r101 = new int[r100.length];
        int[] r102 = new int[r100.length];
        ExifTag[] r103 = EXIF_POINTER_TAGS;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        removeAttribute(r103[r105].name);
        r105 = r105 + 1;
        goto L3
    L5:
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        int r106 = 0;
    L7:
        if (r106 >= EXIF_TAGS.length) goto L16;
        Object[] r107 = this.mAttributes[r106].entrySet().toArray();
        int r108 = r107.length;
        int r109 = 0;
    L9:
        if (r109 >= r108) goto L14;
        Map.Entry r112 = (Map.Entry) r107[r109];
        if (r112.getValue() != null) goto L13;
        this.mAttributes[r106].remove(r112.getKey());
    L13:
        r109 = r109 + 1;
        goto L9
    L14:
        r106 = r106 + 1;
        goto L7
    L16:
        if (this.mAttributes[1].isEmpty() == true) goto L19;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L19:
        if (this.mAttributes[2].isEmpty() == true) goto L22;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L22:
        if (this.mAttributes[3].isEmpty() == true) goto L25;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L25:
        if (this.mHasThumbnail == false) goto L27;
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, this.mExifByteOrder));
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
    L27:
        int r113 = 0;
    L29:
        if (r113 >= EXIF_TAGS.length) goto L37;
        Iterator<Map.Entry<String, ExifAttribute>> r114 = this.mAttributes[r113].entrySet().iterator();
        int r115 = 0;
    L32:
        if (r114.hasNext() == false) goto L36;
        int r116 = r114.next().getValue().size();
        if (r116 <= 4) goto L32;
        r115 = r115 + r116;
        goto L32
    L36:
        r102[r113] = r102[r113] + r115;
        r113 = r113 + 1;
        goto L29
    L37:
        int r117 = 0;
        int r118 = 8;
    L39:
        if (r117 >= EXIF_TAGS.length) goto L45;
        if (this.mAttributes[r117].isEmpty() == true) goto L43;
        r101[r117] = r118;
        r118 = r118 + ((((this.mAttributes[r117].size() * 12) + 2) + 4) + r102[r117]);
    L43:
        r117 = r117 + 1;
        goto L39
    L45:
        if (this.mHasThumbnail == false) goto L47;
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(r118, this.mExifByteOrder));
        this.mThumbnailOffset = r111 + r118;
        r118 = r118 + this.mThumbnailLength;
    L47:
        int r119 = r118 + 8;
        if (DEBUG == false) goto L54;
        int r120 = 0;
    L51:
        if (r120 >= EXIF_TAGS.length) goto L54;
        String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d", new Object[]{Integer.valueOf(r120), Integer.valueOf(r101[r120]), Integer.valueOf(this.mAttributes[r120].size()), Integer.valueOf(r102[r120])});
        r120 = r120 + 1;
    L54:
        if (this.mAttributes[1].isEmpty() == true) goto L57;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(r101[1], this.mExifByteOrder));
    L57:
        if (this.mAttributes[2].isEmpty() == true) goto L60;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(r101[2], this.mExifByteOrder));
    L60:
        if (this.mAttributes[3].isEmpty() == true) goto L62;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(r101[3], this.mExifByteOrder));
    L62:
        r110.writeUnsignedShort(r119);
        r110.write(IDENTIFIER_EXIF_APP1);
        if (this.mExifByteOrder != ByteOrder.BIG_ENDIAN) goto L65;
        short r121 = BYTE_ALIGN_MM;
    L66:
        r110.writeShort(r121);
        r110.setByteOrder(this.mExifByteOrder);
        r110.writeUnsignedShort(42);
        r110.writeUnsignedInt(8);
        int r122 = 0;
    L68:
        if (r122 >= EXIF_TAGS.length) goto L95;
        if (this.mAttributes[r122].isEmpty() == true) goto L93;
        r110.writeUnsignedShort(this.mAttributes[r122].size());
        int r123 = ((r101[r122] + 2) + (this.mAttributes[r122].size() * 12)) + 4;
        Iterator<Map.Entry<String, ExifAttribute>> r124 = this.mAttributes[r122].entrySet().iterator();
    L73:
        if (r124.hasNext() == false) goto L81;
        Map.Entry<String, ExifAttribute> r125 = r124.next();
        int r126 = sExifTagMapsForWriting[r122].get(r125.getKey()).number;
        ExifAttribute r127 = r125.getValue();
        int r128 = r127.size();
        r110.writeUnsignedShort(r126);
        r110.writeUnsignedShort(r127.format);
        r110.writeInt(r127.numberOfComponents);
        if (r128 > 4) goto L76;
        r110.write(r127.bytes);
        if (r128 >= 4) goto L73;
    L79:
        if (r128 >= 4) goto L73;
        r110.writeByte(0);
        r128 = r128 + 1;
        goto L79
    L76:
        r110.writeUnsignedInt(r123);
        r123 = r123 + r128;
        goto L73
    L81:
        if (r122 == 0) goto L83;
    L85:
        r110.writeUnsignedInt(0);
    L86:
        Iterator<Map.Entry<String, ExifAttribute>> r129 = this.mAttributes[r122].entrySet().iterator();
    L88:
        if (r129.hasNext() == false) goto L93;
        byte[] r130 = r129.next().getValue().bytes;
        if (r130.length <= 4) goto L88;
        r110.write(r130, 0, r130.length);
        goto L88
    L83:
        if (this.mAttributes[4].isEmpty() == true) goto L85;
        r110.writeUnsignedInt(r101[4]);
    L93:
        r122 = r122 + 1;
        goto L68
    L95:
        if (this.mHasThumbnail == false) goto L97;
        r110.write(getThumbnailBytes());
    L97:
        r110.setByteOrder(ByteOrder.BIG_ENDIAN);
        return r119;
    L65:
        r121 = BYTE_ALIGN_II;
        goto L66
    }

    public double getAttributeDouble(String r100, double r101) {
        if (r100 == null) goto L10;
        ExifAttribute r102 = getExifAttribute(r100);
        if (r102 != null) goto L11;
        return r101;
    L11:
        return r102.getDoubleValue(this.mExifByteOrder);
    L8:
        return r101;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    public int getAttributeInt(String r100, int r101) {
        if (r100 == null) goto L10;
        ExifAttribute r102 = getExifAttribute(r100);
        if (r102 != null) goto L11;
        return r101;
    L11:
        return r102.getIntValue(this.mExifByteOrder);
    L8:
        return r101;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    public void setAttribute(String r110, String r111) {
        String r100 = r110;
        String r101 = r111;
        if (r100 == null) goto L104;
        if (TAG_ISO_SPEED_RATINGS.equals(r100) == false) goto L7;
        r100 = TAG_PHOTOGRAPHIC_SENSITIVITY;
    L7:
        int r102 = 2;
        int r103 = 1;
        if (r101 != null) goto L10;
    L22:
        int r104 = 0;
    L24:
        if (r104 >= EXIF_TAGS.length) goto L102;
        if (r104 == 4) goto L28;
    L30:
        ExifTag r105 = sExifTagMapsForWriting[r104].get(r100);
        if (r105 == null) goto L101;
        if (r101 != null) goto L34;
        this.mAttributes[r104].remove(r100);
        goto L101
    L34:
        Pair<Integer, Integer> r106 = guessDataFormat(r101);
        if (r105.primaryFormat != ((Integer) r106.first).intValue()) goto L37;
    L63:
        int r107 = r105.primaryFormat;
    L65:
        switch(r107) {
            case 1: goto L100;
            case 2: goto L99;
            case 3: goto L94;
            case 4: goto L89;
            case 5: goto L84;
            case 6: goto L67;
            case 7: goto L99;
            case 8: goto L67;
            case 9: goto L79;
            case 10: goto L74;
            case 11: goto L67;
            case 12: goto L69;
            default: goto L67;
        };
    L69:
        String[] r108 = r101.split(",", -1);
        double[] r109 = new double[r108.length];
        int r112 = 0;
    L71:
        if (r112 >= r108.length) goto L73;
        r109[r112] = CastDoubleProtector.parseDouble(r108[r112]);
        r112 = r112 + 1;
        goto L71
    L73:
        this.mAttributes[r104].put(r100, ExifAttribute.createDouble(r109, this.mExifByteOrder));
        goto L101
    L74:
        String[] r113 = r101.split(",", -1);
        Rational[] r114 = new Rational[r113.length];
        int r115 = 0;
    L76:
        if (r115 >= r113.length) goto L78;
        String[] r116 = r113[r115].split(HTTP.URL_DEFAULT, -1);
        r114[r115] = new Rational((long) CastDoubleProtector.parseDouble(r116[0]), (long) CastDoubleProtector.parseDouble(r116[r103]));
        r115 = r115 + 1;
        r103 = 1;
        goto L76
    L78:
        this.mAttributes[r104].put(r100, ExifAttribute.createSRational(r114, this.mExifByteOrder));
        goto L101
    L79:
        String[] r117 = r101.split(",", -1);
        int[] r118 = new int[r117.length];
        int r119 = 0;
    L81:
        if (r119 >= r117.length) goto L83;
        r118[r119] = CastIntegerProtector.parseInt(r117[r119]);
        r119 = r119 + 1;
        goto L81
    L83:
        this.mAttributes[r104].put(r100, ExifAttribute.createSLong(r118, this.mExifByteOrder));
        goto L101
    L84:
        String[] r120 = r101.split(",", -1);
        Rational[] r121 = new Rational[r120.length];
        int r122 = 0;
    L86:
        if (r122 >= r120.length) goto L88;
        String[] r123 = r120[r122].split(HTTP.URL_DEFAULT, -1);
        r121[r122] = new Rational((long) CastDoubleProtector.parseDouble(r123[0]), (long) CastDoubleProtector.parseDouble(r123[1]));
        r122 = r122 + 1;
        goto L86
    L88:
        this.mAttributes[r104].put(r100, ExifAttribute.createURational(r121, this.mExifByteOrder));
        goto L101
    L89:
        String[] r124 = r101.split(",", -1);
        long[] r125 = new long[r124.length];
        int r126 = 0;
    L91:
        if (r126 >= r124.length) goto L93;
        r125[r126] = CastLongProtector.parseLong(r124[r126]);
        r126 = r126 + 1;
        goto L91
    L93:
        this.mAttributes[r104].put(r100, ExifAttribute.createULong(r125, this.mExifByteOrder));
        goto L101
    L94:
        String[] r127 = r101.split(",", -1);
        int[] r128 = new int[r127.length];
        int r129 = 0;
    L96:
        if (r129 >= r127.length) goto L98;
        r128[r129] = CastIntegerProtector.parseInt(r127[r129]);
        r129 = r129 + 1;
        goto L96
    L98:
        this.mAttributes[r104].put(r100, ExifAttribute.createUShort(r128, this.mExifByteOrder));
        goto L101
    L99:
        this.mAttributes[r104].put(r100, ExifAttribute.createString(r101));
        goto L101
    L100:
        this.mAttributes[r104].put(r100, ExifAttribute.createByte(r101));
        goto L101
    L67:
        if (DEBUG == false) goto L101;
        goto L101
    L37:
        if (r105.primaryFormat == ((Integer) r106.second).intValue()) goto L63;
        int r130 = r105.secondaryFormat;
        if (r130 != (-1)) goto L42;
    L46:
        int r131 = r105.primaryFormat;
        if (r131 != r103) goto L49;
    L62:
        r107 = r131;
        goto L65
    L49:
        if (r131 == 7) goto L62;
        if (r131 == r102) goto L62;
        if (DEBUG == false) goto L101;
        String[] r132 = IFD_FORMAT_NAMES;
        String r133 = r132[r131];
        if (r105.secondaryFormat == (-1)) goto L58;
        new StringBuilder(", ").append(r132[r105.secondaryFormat]);
    L58:
        String r134 = r132[((Integer) r106.first).intValue()];
        if (((Integer) r106.second).intValue() == (-1)) goto L101;
        new StringBuilder(", ").append(r132[((Integer) r106.second).intValue()]);
        goto L101
    L42:
        if (r130 != ((Integer) r106.first).intValue()) goto L44;
    L45:
        r107 = r105.secondaryFormat;
        goto L65
    L44:
        if (r105.secondaryFormat != ((Integer) r106.second).intValue()) goto L46;
    L101:
        r104 = r104 + 1;
        r102 = 2;
        r103 = 1;
        goto L24
    L28:
        if (this.mHasThumbnail == true) goto L30;
    L102:
        return;
    L10:
        if (sTagSetForCompatibility.contains(r100) == false) goto L22;
        if (r100.equals(TAG_GPS_TIMESTAMP) == false) goto L105;
        Matcher r135 = sGpsTimestampPattern.matcher(r101);
        if (r135.find() == false) goto L16;
        r101 = CastIntegerProtector.parseInt(r135.group(1)) + "/1," + CastIntegerProtector.parseInt(r135.group(2)) + "/1," + CastIntegerProtector.parseInt(r135.group(3)) + "/1";
        goto L22
    L16:
        return;
    L105:
        r101 = new Rational(CastDoubleProtector.parseDouble(r111)).toString();     // Catch: NumberFormatException -> L20
    L21:
        return;
    L104:
        throw new NullPointerException("tag shouldn't be null");
    }

    public void setLatLong(double r100, double r101) {
        if (r100 < (-90.0d)) goto L27;
        if (r100 > 90.0d) goto L27;
        if (Double.isNaN(r100) == true) goto L27;
        if (r101 < (-180.0d)) goto L25;
        if (r101 > 180.0d) goto L25;
        if (Double.isNaN(r101) == true) goto L25;
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
        String r102 = "N";
    L18:
        setAttribute(TAG_GPS_LATITUDE_REF, r102);
        setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(r100)));
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        String r103 = LONGITUDE_EAST;
    L22:
        setAttribute(TAG_GPS_LONGITUDE_REF, r103);
        setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(r101)));
        return;
    L21:
        r103 = LONGITUDE_WEST;
        goto L22
    L17:
        r102 = LATITUDE_SOUTH;
    L25:
        throw new IllegalArgumentException("Longitude value " + r101 + " is not valid.");
    L27:
        throw new IllegalArgumentException("Latitude value " + r100 + " is not valid.");
    }

    private void getJpegAttributes(ByteOrderedDataInputStream r210, int r211, int r212) throws IOException {
        if (DEBUG == false) goto L5;
        Objects.toString(r210);
    L5:
        r210.setByteOrder(ByteOrder.BIG_ENDIAN);
        r210.seek(r211);
        byte r100 = r210.readByte();
        if (r100 != (-1)) goto L73;
        int r101 = r211 + 1;
        if (r210.readByte() != (-40)) goto L71;
        int r102 = r101 + 1;
    L10:
        byte r103 = r210.readByte();
        if (r103 != (-1)) goto L69;
        int r104 = r102 + 1;
        byte r105 = r210.readByte();
        boolean r106 = DEBUG;
        if (r106 == false) goto L15;
        Integer.toHexString(r105 & 255);
    L15:
        int r107 = r104 + 1;
        if (r105 == (-39)) goto L66;
        if (r105 == (-38)) goto L66;
        int r108 = r210.readUnsignedShort() - 2;
        int r109 = r107 + 2;
        if (r106 == false) goto L24;
        Integer.toHexString(r105 & 255);
    L24:
        if (r108 < 0) goto L65;
        if (r105 != (-31)) goto L28;
        byte[] r110 = new byte[r108];
        r210.readFully(r110);
        int r111 = r109 + r108;
        byte[] r112 = IDENTIFIER_EXIF_APP1;
        if (startsWith(r110, r112) == false) goto L42;
        long r113 = r109 + r112.length;
        readExifSegment(Arrays.copyOfRange(r110, r112.length, r108), r212);
        this.mExifOffset = (int) r113;
    L47:
        r109 = r111;
        r108 = 0;
    L48:
        byte[] r114 = new byte[r108];
        if (r210.read(r114) != r108) goto L63;
        if (getAttribute(TAG_USER_COMMENT) != null) goto L53;
        this.mAttributes[1].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(r114, ASCII)));
    L53:
        r108 = 0;
    L54:
        if (r108 < 0) goto L61;
        if (r210.skipBytes(r108) != r108) goto L59;
        r102 = r109 + r108;
        goto L10
    L59:
        throw new IOException("Invalid JPEG segment");
    L61:
        throw new IOException("Invalid length");
    L63:
        throw new IOException("Invalid exif");
    L42:
        byte[] r115 = IDENTIFIER_XMP_APP1;
        if (startsWith(r110, r115) == false) goto L47;
        long r116 = r109 + r115.length;
        byte[] r117 = Arrays.copyOfRange(r110, r115.length, r108);
        if (getAttribute(TAG_XMP) != null) goto L47;
        this.mAttributes[0].put(TAG_XMP, new ExifAttribute(1, r117.length, r116, r117));
        goto L47
    L28:
        if (r105 == (-2)) goto L48;
        switch(r105) {
            case -64: goto L35;
            case -63: goto L35;
            case -62: goto L35;
            case -61: goto L35;
            default: goto L30;
        };
    L30:
        switch(r105) {
            case -59: goto L35;
            case -58: goto L35;
            case -57: goto L35;
            default: goto L31;
        };
    L31:
        switch(r105) {
            case -55: goto L35;
            case -54: goto L35;
            case -53: goto L35;
            default: goto L32;
        };
    L32:
        switch(r105) {
            case -51: goto L35;
            case -50: goto L35;
            case -49: goto L35;
            default: goto L54;
        };
    L35:
        if (r210.skipBytes(1) != 1) goto L38;
        this.mAttributes[r212].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(r210.readUnsignedShort(), this.mExifByteOrder));
        this.mAttributes[r212].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(r210.readUnsignedShort(), this.mExifByteOrder));
        r108 = r108 - 5;
        goto L54
    L38:
        throw new IOException("Invalid SOFx");
    L65:
        throw new IOException("Invalid length");
    L66:
        r210.setByteOrder(this.mExifByteOrder);
        return;
    L69:
        throw new IOException("Invalid marker:" + Integer.toHexString(r103 & 255));
    L71:
        throw new IOException("Invalid marker: " + Integer.toHexString(r100 & 255));
    L73:
        throw new IOException("Invalid marker: " + Integer.toHexString(r100 & 255));
    }
}
