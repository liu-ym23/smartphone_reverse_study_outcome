package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Ascii;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
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
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = null;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = null;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
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
    private static final Pattern GPS_TIMESTAMP_PATTERN = null;
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
    static final int IMAGE_TYPE_ARW = 1;
    static final int IMAGE_TYPE_CR2 = 2;
    static final int IMAGE_TYPE_DNG = 3;
    static final int IMAGE_TYPE_HEIF = 12;
    static final int IMAGE_TYPE_JPEG = 4;
    static final int IMAGE_TYPE_NEF = 5;
    static final int IMAGE_TYPE_NRW = 6;
    static final int IMAGE_TYPE_ORF = 7;
    static final int IMAGE_TYPE_PEF = 8;
    static final int IMAGE_TYPE_PNG = 13;
    static final int IMAGE_TYPE_RAF = 9;
    static final int IMAGE_TYPE_RW2 = 10;
    static final int IMAGE_TYPE_SRW = 11;
    static final int IMAGE_TYPE_UNKNOWN = 0;
    static final int IMAGE_TYPE_WEBP = 14;
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
    private static final Pattern NON_ZERO_TIME_PATTERN = null;
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
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF = null;
    private static final byte[] PNG_CHUNK_TYPE_IEND = null;
    private static final byte[] PNG_CHUNK_TYPE_IHDR = null;
    private static final byte[] PNG_SIGNATURE = null;
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
    private static final int SKIP_BUFFER_SIZE = 8192;
    static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
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

    @Deprecated
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
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
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
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
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
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
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
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = null;
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = null;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = null;
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = null;
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = null;
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = null;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1 = null;
    private static final byte[] WEBP_SIGNATURE_2 = null;
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE = null;

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = null;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading = null;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting = null;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility = null;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = null;
        private static final ByteOrder LITTLE_ENDIAN = null;
        private ByteOrder mByteOrder;
        final DataInputStream mDataInputStream;
        int mPosition;
        private byte[] mSkipBuffer;

        static {
            LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        }

        ByteOrderedDataInputStream(byte[] r2) throws IOException {
            this(new ByteArrayInputStream(r2), ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream r2) throws IOException {
            this(r2, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream r2, ByteOrder r3) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream r0 = new DataInputStream(r2);
            this.mDataInputStream = r0;
            r0.mark(0);
            this.mPosition = 0;
            this.mByteOrder = r3;
        }

        public void setByteOrder(ByteOrder r1) {
            this.mByteOrder = r1;
        }

        public int position() {
            return this.mPosition;
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

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) throws IOException {
            int r5 = this.mDataInputStream.read(r2, r3, r4);
            this.mPosition += r5;
            return r5;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r2, int r3, int r4) throws IOException {
            this.mPosition += r4;
            this.mDataInputStream.readFully(r2, r3, r4);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r3) throws IOException {
            this.mPosition += r3.length;
            this.mDataInputStream.readFully(r3);
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.mPosition++;
            int r1 = this.mDataInputStream.read();
            if (r1 < 0) goto L7;
            return (byte) r1;
        L7:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.mPosition += 2;
            int r0 = this.mDataInputStream.read();
            int r1 = this.mDataInputStream.read();
            if ((r0 | r1) < 0) goto L15;
            ByteOrder r2 = this.mByteOrder;
            if (r2 != LITTLE_ENDIAN) goto L10;
            int r4 = (r1 << 8) + r0;
        L8:
            return (short) r4;
        L10:
            if (r2 != BIG_ENDIAN) goto L13;
            r4 = (r0 << 8) + r1;
            goto L8
        L13:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L15:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.mPosition += 4;
            int r0 = this.mDataInputStream.read();
            int r1 = this.mDataInputStream.read();
            int r2 = this.mDataInputStream.read();
            int r3 = this.mDataInputStream.read();
            if ((((r0 | r1) | r2) | r3) < 0) goto L15;
            ByteOrder r4 = this.mByteOrder;
            if (r4 != LITTLE_ENDIAN) goto L9;
            return (((r3 << 24) + (r2 << 16)) + (r1 << 8)) + r0;
        L9:
            if (r4 != BIG_ENDIAN) goto L13;
            return (((r0 << 24) + (r1 << 16)) + (r2 << 8)) + r3;
        L13:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L15:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int r1) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int r7) throws IOException {
            int r1 = 0;
        L3:
            if (r1 >= r7) goto L15;
            int r3 = r7 - r1;
            int r2 = (int) this.mDataInputStream.skip(r3);
            if (r2 > 0) goto L14;
            if (this.mSkipBuffer != null) goto L9;
            this.mSkipBuffer = new byte[8192];
        L9:
            r2 = this.mDataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, r3));
            if (r2 != (-1)) goto L14;
            throw new EOFException("Reached EOF while skipping " + r7 + " bytes.");
        L14:
            r1 = r1 + r2;
            goto L3
        L15:
            this.mPosition += r1;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            int r0 = this.mDataInputStream.read();
            int r1 = this.mDataInputStream.read();
            if ((r0 | r1) < 0) goto L15;
            ByteOrder r2 = this.mByteOrder;
            if (r2 != LITTLE_ENDIAN) goto L9;
            return (r1 << 8) + r0;
        L9:
            if (r2 != BIG_ENDIAN) goto L13;
            return (r0 << 8) + r1;
        L13:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L15:
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.mPosition += 8;
            int r1 = this.mDataInputStream.read();
            int r3 = this.mDataInputStream.read();
            int r4 = this.mDataInputStream.read();
            int r5 = this.mDataInputStream.read();
            int r6 = this.mDataInputStream.read();
            int r7 = this.mDataInputStream.read();
            int r8 = this.mDataInputStream.read();
            int r9 = this.mDataInputStream.read();
            if ((((((((r1 | r3) | r4) | r5) | r6) | r7) | r8) | r9) < 0) goto L15;
            ByteOrder r10 = this.mByteOrder;
            if (r10 != LITTLE_ENDIAN) goto L9;
            return (((((((((long) r9) << 56) + (((long) r8) << 48)) + (((long) r7) << 40)) + (((long) r6) << 32)) + (((long) r5) << 24)) + (((long) r4) << 16)) + (((long) r3) << 8)) + ((long) r1);
        L9:
            if (r10 != BIG_ENDIAN) goto L13;
            return (((((((((long) r1) << 56) + (((long) r3) << 48)) + (((long) r4) << 40)) + (((long) r5) << 32)) + (((long) r6) << 24)) + (((long) r7) << 16)) + (((long) r8) << 8)) + ((long) r9);
        L13:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L15:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.InputStream
        public void mark(int r1) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }
    }

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream r1, ByteOrder r2) {
            super(r1);
            this.mOutputStream = r1;
            this.mByteOrder = r2;
        }

        public void setByteOrder(ByteOrder r1) {
            this.mByteOrder = r1;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r1) throws IOException {
            this.mOutputStream.write(r1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r1, int r2, int r3) throws IOException {
            this.mOutputStream.write(r1, r2, r3);
        }

        public void writeByte(int r1) throws IOException {
            this.mOutputStream.write(r1);
        }

        public void writeShort(short r3) throws IOException {
            if (this.mByteOrder != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write((r3 >>> 0) & 255);
            this.mOutputStream.write((r3 >>> 8) & 255);
            return;
        L6:
            if (this.mByteOrder != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r3 >>> 8) & 255);
            this.mOutputStream.write((r3 >>> 0) & 255);
            return;
        }

        public void writeInt(int r3) throws IOException {
            if (this.mByteOrder != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write((r3 >>> 0) & 255);
            this.mOutputStream.write((r3 >>> 8) & 255);
            this.mOutputStream.write((r3 >>> 16) & 255);
            this.mOutputStream.write((r3 >>> 24) & 255);
            return;
        L6:
            if (this.mByteOrder != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r3 >>> 24) & 255);
            this.mOutputStream.write((r3 >>> 16) & 255);
            this.mOutputStream.write((r3 >>> 8) & 255);
            this.mOutputStream.write((r3 >>> 0) & 255);
            return;
        }

        public void writeUnsignedShort(int r1) throws IOException {
            writeShort((short) r1);
        }

        public void writeUnsignedInt(long r1) throws IOException {
            writeInt((int) r1);
        }
    }

    private static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int r7, int r8, byte[] r9) {
            this(r7, r8, -1, r9);
        }

        ExifAttribute(int r1, int r2, long r3, byte[] r5) {
            this.format = r1;
            this.numberOfComponents = r2;
            this.bytesOffset = r3;
            this.bytes = r5;
        }

        public static ExifAttribute createUShort(int[] r4, ByteOrder r5) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * r4.length]);
            r0.order(r5);
            int r6 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L6;
            r0.putShort((short) r4[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(3, r4.length, r0.array());
        }

        public static ExifAttribute createUShort(int r2, ByteOrder r3) {
            return createUShort(new int[]{r2}, r3);
        }

        public static ExifAttribute createULong(long[] r5, ByteOrder r6) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * r5.length]);
            r0.order(r6);
            int r7 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L6;
            r0.putInt((int) r5[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(4, r5.length, r0.array());
        }

        public static ExifAttribute createULong(long r2, ByteOrder r4) {
            return createULong(new long[]{r2}, r4);
        }

        public static ExifAttribute createSLong(int[] r4, ByteOrder r5) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * r4.length]);
            r0.order(r5);
            int r6 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L6;
            r0.putInt(r4[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(9, r4.length, r0.array());
        }

        public static ExifAttribute createSLong(int r2, ByteOrder r3) {
            return createSLong(new int[]{r2}, r3);
        }

        public static ExifAttribute createByte(String r5) {
            if (r5.length() == 1) goto L5;
        L10:
            byte[] r6 = r5.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(1, r6.length, r6);
        L5:
            if (r5.charAt(0) < '0') goto L10;
            if (r5.charAt(0) > '1') goto L10;
            return new ExifAttribute(1, 1, new byte[]{(byte) (r5.charAt(0) - '0')});
        }

        public static ExifAttribute createString(String r3) {
            byte[] r4 = (r3 + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, r4.length, r4);
        }

        public static ExifAttribute createURational(Rational[] r6, ByteOrder r7) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * r6.length]);
            r0.order(r7);
            int r8 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r8) goto L6;
            Rational r3 = r6[r2];
            r0.putInt((int) r3.numerator);
            r0.putInt((int) r3.denominator);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(5, r6.length, r0.array());
        }

        public static ExifAttribute createURational(Rational r2, ByteOrder r3) {
            return createURational(new Rational[]{r2}, r3);
        }

        public static ExifAttribute createSRational(Rational[] r6, ByteOrder r7) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * r6.length]);
            r0.order(r7);
            int r8 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r8) goto L6;
            Rational r3 = r6[r2];
            r0.putInt((int) r3.numerator);
            r0.putInt((int) r3.denominator);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(10, r6.length, r0.array());
        }

        public static ExifAttribute createSRational(Rational r2, ByteOrder r3) {
            return createSRational(new Rational[]{r2}, r3);
        }

        public static ExifAttribute createDouble(double[] r5, ByteOrder r6) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * r5.length]);
            r0.order(r6);
            int r7 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L6;
            r0.putDouble(r5[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new ExifAttribute(12, r5.length, r0.array());
        }

        public static ExifAttribute createDouble(double r2, ByteOrder r4) {
            return createDouble(new double[]{r2}, r4);
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:151:0x01a2 */
        Object getValue(ByteOrder r11) {
            ByteOrderedDataInputStream r2 = null;
            ByteOrderedDataInputStream r3 = new ByteOrderedDataInputStream(this.bytes);     // Catch: Throwable -> L139 IOException -> L141
            r3.setByteOrder(r11);     // Catch: IOException -> L137 Throwable -> L150
            boolean r4 = true;
            int r5 = 0;
            switch(this.format) {
                case 1: goto L115;
                case 2: goto L88;
                case 3: goto L77;
                case 4: goto L67;
                case 5: goto L57;
                case 6: goto L115;
                case 7: goto L88;
                case 8: goto L47;
                case 9: goto L37;
                case 10: goto L27;
                case 11: goto L17;
                case 12: goto L7;
                default: goto L176;
            };     // Catch: IOException -> L137 Throwable -> L150
        L7:
            double[] r12 = new double[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L9:
            if (r5 >= this.numberOfComponents) goto L163;
            r12[r5] = r3.readDouble();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L9
        L163:
            r3.close();     // Catch: IOException -> L14
        L16:
            return r12;
        L14:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L16
        L17:
            double[] r13 = new double[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L19:
            if (r5 >= this.numberOfComponents) goto L174;
            r13[r5] = r3.readFloat();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L19
        L174:
            r3.close();     // Catch: IOException -> L24
        L26:
            return r13;
        L24:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L26
        L27:
            Rational[] r14 = new Rational[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L29:
            if (r5 >= this.numberOfComponents) goto L161;
            r14[r5] = new Rational(r3.readInt(), r3.readInt());     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L29
        L161:
            r3.close();     // Catch: IOException -> L34
        L36:
            return r14;
        L34:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L36
        L37:
            int[] r15 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L39:
            if (r5 >= this.numberOfComponents) goto L172;
            r15[r5] = r3.readInt();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L39
        L172:
            r3.close();     // Catch: IOException -> L44
        L46:
            return r15;
        L44:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L46
        L47:
            int[] r16 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L49:
            if (r5 >= this.numberOfComponents) goto L180;
            r16[r5] = r3.readShort();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L49
        L180:
            r3.close();     // Catch: IOException -> L54
        L56:
            return r16;
        L54:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L56
        L57:
            Rational[] r17 = new Rational[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L59:
            if (r5 >= this.numberOfComponents) goto L178;
            r17[r5] = new Rational(r3.readUnsignedInt(), r3.readUnsignedInt());     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L59
        L178:
            r3.close();     // Catch: IOException -> L64
        L66:
            return r17;
        L64:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L66
        L67:
            long[] r18 = new long[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L69:
            if (r5 >= this.numberOfComponents) goto L184;
            r18[r5] = r3.readUnsignedInt();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L69
        L184:
            r3.close();     // Catch: IOException -> L74
        L76:
            return r18;
        L74:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L76
        L77:
            int[] r19 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
        L79:
            if (r5 >= this.numberOfComponents) goto L159;
            r19[r5] = r3.readUnsignedShort();     // Catch: IOException -> L137 Throwable -> L150
            r5 = r5 + 1;
            goto L79
        L159:
            r3.close();     // Catch: IOException -> L84
        L86:
            return r19;
        L84:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L86
        L115:
            byte[] r110 = this.bytes;     // Catch: IOException -> L137 Throwable -> L150
            if (r110.length != 1) goto L126;
            byte r111 = r110[0];     // Catch: IOException -> L137 Throwable -> L150
            if (r111 < 0) goto L126;
            if (r111 > 1) goto L126;
            String r112 = new String(new char[]{(char) (this.bytes[0] + 48)});     // Catch: IOException -> L137 Throwable -> L150
            r3.close();     // Catch: IOException -> L123
        L125:
            return r112;
        L123:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L126:
            String r113 = new String(this.bytes, ExifInterface.ASCII);     // Catch: IOException -> L137 Throwable -> L150
            r3.close();     // Catch: IOException -> L129
        L131:
            return r113;
        L129:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L131
        L176:
            r3.close();     // Catch: IOException -> L134
        L136:
            return null;
        L134:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L136
        L88:
            if (this.numberOfComponents < ExifInterface.EXIF_ASCII_PREFIX.length) goto L98;
            int r114 = 0;
        L91:
            if (r114 >= ExifInterface.EXIF_ASCII_PREFIX.length) goto L96;
            if (this.bytes[r114] != ExifInterface.EXIF_ASCII_PREFIX[r114]) goto L94;
            r114 = r114 + 1;     // Catch: IOException -> L137 Throwable -> L150
            goto L91
        L94:
            r4 = false;
        L96:
            if (r4 == false) goto L98;
            r5 = ExifInterface.EXIF_ASCII_PREFIX.length;     // Catch: IOException -> L137 Throwable -> L150
        L98:
            StringBuilder r115 = new StringBuilder();     // Catch: IOException -> L137 Throwable -> L150
        L100:
            if (r5 >= this.numberOfComponents) goto L109;
            byte r6 = this.bytes[r5];     // Catch: IOException -> L137 Throwable -> L150
            if (r6 == 0) goto L109;
            if (r6 < 32) goto L107;
            r115.append((char) r6);     // Catch: IOException -> L137 Throwable -> L150
        L108:
            r5 = r5 + 1;     // Catch: IOException -> L137 Throwable -> L150
            goto L100
        L107:
            r115.append('?');     // Catch: IOException -> L137 Throwable -> L150
        L109:
            String r10 = r115.toString();     // Catch: IOException -> L137 Throwable -> L150
            r3.close();     // Catch: IOException -> L112
        L114:
            return r10;
        L112:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L137:
            e = e;
        L143:
            Log.w(ExifInterface.TAG, "IOException occurred during reading a value", e);     // Catch: Throwable -> L150
            if (r3 != null) goto L186;
        L149:
            return null;
        L186:
            r3.close();     // Catch: IOException -> L147
        L147:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L149
        L150:
            th = th;
            r2 = r3;
        L152:
            if (r2 != null) goto L168;
        L157:
            throw th;
        L168:
            r2.close();     // Catch: IOException -> L155
        L155:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L141:
            e = e;
            r3 = null;
        L139:
            th = th;
            goto L152
        }

        public double getDoubleValue(ByteOrder r4) {
            Object r3 = getValue(r4);
            if (r3 == null) goto L43;
            if ((r3 instanceof String) == false) goto L9;
            return Double.parseDouble((String) r3);
        L9:
            if ((r3 instanceof long[]) == false) goto L17;
            long[] r5 = (long[]) r3;
            if (r5.length != 1) goto L15;
            return r5[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r3 instanceof int[]) == false) goto L25;
            int[] r6 = (int[]) r3;
            if (r6.length != 1) goto L23;
            return r6[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r3 instanceof double[]) == false) goto L33;
            double[] r7 = (double[]) r3;
            if (r7.length != 1) goto L31;
            return r7[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r3 instanceof Rational[]) == false) goto L41;
            Rational[] r8 = (Rational[]) r3;
            if (r8.length != 1) goto L39;
            return r8[0].calculate();
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder r4) {
            Object r3 = getValue(r4);
            if (r3 == null) goto L27;
            if ((r3 instanceof String) == false) goto L9;
            return Integer.parseInt((String) r3);
        L9:
            if ((r3 instanceof long[]) == false) goto L17;
            long[] r5 = (long[]) r3;
            if (r5.length != 1) goto L15;
            return (int) r5[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r3 instanceof int[]) == false) goto L25;
            int[] r6 = (int[]) r3;
            if (r6.length != 1) goto L23;
            return r6[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder r7) {
            Object r6 = getValue(r7);
            if (r6 != null) goto L6;
            return null;
        L6:
            if ((r6 instanceof String) == true) goto L8;
            StringBuilder r0 = new StringBuilder();
            int r3 = 0;
            if ((r6 instanceof long[]) == false) goto L20;
            long[] r8 = (long[]) r6;
        L13:
            if (r3 >= r8.length) goto L18;
            r0.append(r8[r3]);
            r3 = r3 + 1;
            if (r3 == r8.length) goto L13;
            r0.append(SimContactsConstants.EMAIL_SEP);
            goto L13
        L18:
            return r0.toString();
        L20:
            if ((r6 instanceof int[]) == false) goto L30;
            int[] r9 = (int[]) r6;
        L23:
            if (r3 >= r9.length) goto L28;
            r0.append(r9[r3]);
            r3 = r3 + 1;
            if (r3 == r9.length) goto L23;
            r0.append(SimContactsConstants.EMAIL_SEP);
            goto L23
        L28:
            return r0.toString();
        L30:
            if ((r6 instanceof double[]) == false) goto L40;
            double[] r10 = (double[]) r6;
        L33:
            if (r3 >= r10.length) goto L38;
            r0.append(r10[r3]);
            r3 = r3 + 1;
            if (r3 == r10.length) goto L33;
            r0.append(SimContactsConstants.EMAIL_SEP);
            goto L33
        L38:
            return r0.toString();
        L40:
            if ((r6 instanceof Rational[]) == false) goto L49;
            Rational[] r11 = (Rational[]) r6;
        L43:
            if (r3 >= r11.length) goto L48;
            r0.append(r11[r3].numerator);
            r0.append('/');
            r0.append(r11[r3].denominator);
            r3 = r3 + 1;
            if (r3 == r11.length) goto L43;
            r0.append(SimContactsConstants.EMAIL_SEP);
            goto L43
        L48:
            return r0.toString();
        L49:
            return null;
        L8:
            return (String) r6;
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String r1, int r2, int r3) {
            this.name = r1;
            this.number = r2;
            this.primaryFormat = r3;
            this.secondaryFormat = -1;
        }

        ExifTag(String r1, int r2, int r3, int r4) {
            this.name = r1;
            this.number = r2;
            this.primaryFormat = r3;
            this.secondaryFormat = r4;
        }

        boolean isFormatCompatible(int r4) {
            int r0 = this.primaryFormat;
            if (r0 == 7) goto L30;
            if (r4 == 7) goto L30;
            if (r0 == r4) goto L30;
            int r3 = this.secondaryFormat;
            if (r3 == r4) goto L30;
            if (r0 == 4) goto L14;
            if (r3 == 4) goto L14;
        L17:
            if (r0 == 9) goto L20;
            if (r3 == 9) goto L20;
        L23:
            if (r0 == 12) goto L26;
            if (r3 == 12) goto L26;
            return false;
        L26:
            if (r4 != 11) goto L31;
            return true;
        L31:
            return false;
        L20:
            if (r4 != 8) goto L23;
            return true;
        L14:
            if (r4 != 3) goto L17;
            return true;
        L30:
            return true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double r3) {
            this((long) (r3 * 10000.0d), 10000);
        }

        Rational(long r4, long r6) {
            if (r6 != 0) goto L6;
            this.numerator = 0;
            this.denominator = 1;
            return;
        L6:
            this.numerator = r4;
            this.denominator = r6;
        }

        public String toString() {
            return this.numerator + LibrarianImpl.Constants.SEPARATOR + this.denominator;
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }
    }

    private static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] r1) throws IOException {
            super(r1);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        SeekableByteOrderedDataInputStream(InputStream r1) throws IOException {
            super(r1);
            if (r1.markSupported() == false) goto L7;
            this.mDataInputStream.mark(Integer.MAX_VALUE);
            return;
        L7:
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }

        public void seek(long r3) throws IOException {
            if (this.mPosition <= r3) goto L5;
            this.mPosition = 0;
            this.mDataInputStream.reset();
        L6:
            skipFully((int) r3);
            return;
        L5:
            r3 = r3 - ((long) this.mPosition);
            goto L6
        }
    }

    private static boolean isSupportedFormatForSavingAttributes(int r1) {
        if (r1 != 4) goto L5;
        return true;
    L5:
        if (r1 != 13) goto L7;
        return true;
    L7:
        if (r1 != 14) goto L9;
        return true;
    L9:
        if (r1 == 3) goto L18;
        if (r1 == 0) goto L19;
        return false;
    L19:
        return true;
    L18:
        return true;
    }

    private static boolean shouldSupportSeek(int r1) {
        if (r1 != 4) goto L5;
        return false;
    L5:
        if (r1 != 9) goto L7;
        return false;
    L7:
        if (r1 != 13) goto L9;
        return false;
    L9:
        if (r1 == 14) goto L17;
        return true;
    L17:
        return false;
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
        PNG_SIGNATURE = new byte[]{-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
        PNG_CHUNK_TYPE_EXIF = new byte[]{101, 88, 73, 102};
        PNG_CHUNK_TYPE_IHDR = new byte[]{73, 72, 68, 82};
        PNG_CHUNK_TYPE_IEND = new byte[]{73, 69, 78, 68};
        WEBP_SIGNATURE_1 = new byte[]{82, 73, 70, 70};
        WEBP_SIGNATURE_2 = new byte[]{87, 69, 66, 80};
        WEBP_CHUNK_TYPE_EXIF = new byte[]{69, 88, 73, 70};
        WEBP_VP8_SIGNATURE = new byte[]{-99, 1, START_CODE};
        WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        ExifTag[] r12 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = r12;
        ExifTag[] r3 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = r3;
        ExifTag[] r4 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = r4;
        ExifTag[] r6 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = r6;
        ExifTag[] r7 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_XMP, 700, 1), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = r7;
        TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
        ExifTag[] r0 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = r0;
        ExifTag[] r1 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = r1;
        ExifTag[] r8 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = r8;
        ExifTag[] r14 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = r14;
        ExifTag[][] r10 = {r12, r3, r4, r6, r7, r12, r0, r1, r8, r14};
        EXIF_TAGS = r10;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        sExifTagMapsForReading = new HashMap[r10.length];
        sExifTagMapsForWriting = new HashMap[r10.length];
        sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
        sExifPointerTagMap = new HashMap();
        Charset r2 = Charset.forName("US-ASCII");
        ASCII = r2;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(r2);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(r2);
        SimpleDateFormat r5 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        sFormatterPrimary = r5;
        r5.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat r9 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        sFormatterSecondary = r9;
        r9.setTimeZone(TimeZone.getTimeZone("UTC"));
        int r11 = 0;
    L3:
        ExifTag[][] r13 = EXIF_TAGS;
        if (r11 >= r13.length) goto L9;
        sExifTagMapsForReading[r11] = new HashMap();
        sExifTagMapsForWriting[r11] = new HashMap();
        ExifTag[] r15 = r13[r11];
        int r16 = r15.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        ExifTag r18 = r15[r17];
        sExifTagMapsForReading[r11].put(Integer.valueOf(r18.number), r18);
        sExifTagMapsForWriting[r11].put(r18.name, r18);
        r17 = r17 + 1;
        goto L6
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r19 = sExifPointerTagMap;
        ExifTag[] r20 = EXIF_POINTER_TAGS;
        r19.put(Integer.valueOf(r20[0].number), 5);
        r19.put(Integer.valueOf(r20[1].number), 1);
        r19.put(Integer.valueOf(r20[2].number), 2);
        r19.put(Integer.valueOf(r20[3].number), 3);
        r19.put(Integer.valueOf(r20[4].number), 7);
        r19.put(Integer.valueOf(r20[5].number), 8);
        NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
        GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public ExifInterface(File r3) throws IOException {
        ExifTag[][] r0 = EXIF_TAGS;
        this.mAttributes = new HashMap[r0.length];
        this.mAttributesOffsets = new HashSet(r0.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r3 == null) goto L7;
        initForFilename(r3.getAbsolutePath());
        return;
    L7:
        throw new NullPointerException("file cannot be null");
    }

    public ExifInterface(String r3) throws IOException {
        ExifTag[][] r0 = EXIF_TAGS;
        this.mAttributes = new HashMap[r0.length];
        this.mAttributesOffsets = new HashSet(r0.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r3 == null) goto L7;
        initForFilename(r3);
        return;
    L7:
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface(FileDescriptor r4) throws IOException {
        ExifTag[][] r0 = EXIF_TAGS;
        this.mAttributes = new HashMap[r0.length];
        this.mAttributesOffsets = new HashSet(r0.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r4 == null) goto L27;
        FileInputStream r1 = null;
        this.mAssetInputStream = null;
        this.mFilename = null;
        if (isSeekableFD(r4) == false) goto L12;
        this.mSeekableFileDescriptor = r4;
        r4 = ExifInterfaceUtils.Api21Impl.dup(r4);     // Catch: Exception -> L9
        boolean r2 = true;
    L32:
        FileInputStream r3 = new FileInputStream(r4);     // Catch: Throwable -> L21
        loadAttributes(r3);     // Catch: Throwable -> L19
        ExifInterfaceUtils.closeQuietly(r3);
        if (r2 == false) goto L34;
        ExifInterfaceUtils.closeFileDescriptor(r4);
        return;
    L34:
        return;
    L19:
        th = th;
        r1 = r3;
    L22:
        ExifInterfaceUtils.closeQuietly(r1);
        if (r2 == false) goto L25;
        ExifInterfaceUtils.closeFileDescriptor(r4);
    L25:
        throw th;
    L21:
        th = th;
    L9:
        e = move-exception;
        throw new IOException("Failed to duplicate file descriptor", e);
    L12:
        this.mSeekableFileDescriptor = null;
        r2 = false;
        goto L32
    L27:
        throw new NullPointerException("fileDescriptor cannot be null");
    }

    public ExifInterface(InputStream r2) throws IOException {
        this(r2, 0);
    }

    public ExifInterface(InputStream r4, int r5) throws IOException {
        ExifTag[][] r0 = EXIF_TAGS;
        this.mAttributes = new HashMap[r0.length];
        this.mAttributesOffsets = new HashSet(r0.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r4 == null) goto L26;
        this.mFilename = null;
        if (r5 != 1) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L15;
        BufferedInputStream r7 = new BufferedInputStream(r4, IDENTIFIER_EXIF_APP1.length);
        if (isExifDataOnly(r7) == true) goto L13;
        Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
        return;
    L13:
        this.mIsExifDataOnly = true;
        this.mAssetInputStream = null;
        this.mSeekableFileDescriptor = null;
        r4 = r7;
    L23:
        loadAttributes(r4);
        return;
    L15:
        if ((r4 instanceof AssetManager.AssetInputStream) == false) goto L18;
        this.mAssetInputStream = (AssetManager.AssetInputStream) r4;
        this.mSeekableFileDescriptor = null;
        goto L23
    L18:
        if ((r4 instanceof FileInputStream) == false) goto L22;
        FileInputStream r8 = (FileInputStream) r4;
        if (isSeekableFD(r8.getFD()) == false) goto L22;
        this.mAssetInputStream = null;
        this.mSeekableFileDescriptor = r8.getFD();
    L22:
        this.mAssetInputStream = null;
        this.mSeekableFileDescriptor = null;
        goto L23
    L7:
        r6 = false;
        goto L8
    L26:
        throw new NullPointerException("inputStream cannot be null");
    }

    public static boolean isSupportedMimeType(String r4) {
        if (r4 == null) goto L70;
        String r5 = r4.toLowerCase(Locale.ROOT);
        r5.hashCode();
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -1875291391: goto L63;
            case -1635437028: goto L59;
            case -1594371159: goto L55;
            case -1487464693: goto L51;
            case -1487464690: goto L47;
            case -1487394660: goto L43;
            case -1487018032: goto L39;
            case -1423313290: goto L35;
            case -985160897: goto L31;
            case -879258763: goto L27;
            case -332763809: goto L23;
            case 1378106698: goto L19;
            case 2099152104: goto L15;
            case 2099152524: goto L11;
            case 2111234748: goto L7;
            default: goto L66;
        };
    L66:
        switch(r3) {
            case 0: goto L68;
            case 1: goto L68;
            case 2: goto L68;
            case 3: goto L68;
            case 4: goto L68;
            case 5: goto L68;
            case 6: goto L68;
            case 7: goto L68;
            case 8: goto L68;
            case 9: goto L68;
            case 10: goto L68;
            case 11: goto L68;
            case 12: goto L68;
            case 13: goto L68;
            case 14: goto L68;
            default: goto L67;
        };
    L67:
        return false;
    L68:
        return true;
    L7:
        if (r5.equals("image/x-canon-cr2") == false) goto L66;
        r3 = Ascii.SO;
        goto L66
    L11:
        if (r5.equals("image/x-nikon-nrw") == false) goto L66;
        r3 = Ascii.CR;
        goto L66
    L15:
        if (r5.equals("image/x-nikon-nef") == false) goto L66;
        r3 = Ascii.FF;
        goto L66
    L19:
        if (r5.equals("image/x-olympus-orf") == false) goto L66;
        r3 = Ascii.VT;
        goto L66
    L23:
        if (r5.equals("image/x-pentax-pef") == false) goto L66;
        r3 = 10;
        goto L66
    L27:
        if (r5.equals("image/png") == false) goto L66;
        r3 = 9;
        goto L66
    L31:
        if (r5.equals("image/x-panasonic-rw2") == false) goto L66;
        r3 = 8;
        goto L66
    L35:
        if (r5.equals("image/x-adobe-dng") == false) goto L66;
        r3 = 7;
        goto L66
    L39:
        if (r5.equals("image/webp") == false) goto L66;
        r3 = 6;
        goto L66
    L43:
        if (r5.equals("image/jpeg") == false) goto L66;
        r3 = 5;
        goto L66
    L47:
        if (r5.equals("image/heif") == false) goto L66;
        r3 = 4;
        goto L66
    L51:
        if (r5.equals("image/heic") == false) goto L66;
        r3 = 3;
        goto L66
    L55:
        if (r5.equals("image/x-sony-arw") == false) goto L66;
        r3 = 2;
        goto L66
    L59:
        if (r5.equals("image/x-samsung-srw") == false) goto L66;
        r3 = 1;
        goto L66
    L63:
        if (r5.equals("image/x-fuji-raf") == false) goto L66;
        r3 = 0;
        goto L66
    L70:
        throw new NullPointerException("mimeType shouldn't be null");
    }

    private ExifAttribute getExifAttribute(String r3) {
        if (r3 == null) goto L19;
        if (TAG_ISO_SPEED_RATINGS.equals(r3) == true) goto L6;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= EXIF_TAGS.length) goto L16;
        ExifAttribute r1 = this.mAttributes[r0].get(r3);
        if (r1 != null) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return r1;
    L16:
        return null;
    L6:
        if (DEBUG == false) goto L8;
        Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L8:
        r3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        goto L9
    L19:
        throw new NullPointerException("tag shouldn't be null");
    }

    public String getAttribute(String r5) {
        if (r5 == null) goto L30;
        ExifAttribute r0 = getExifAttribute(r5);
        if (r0 != null) goto L6;
    L28:
        return null;
    L6:
        if (sTagSetForCompatibility.contains(r5) == true) goto L10;
        return r0.getStringValue(this.mExifByteOrder);
    L10:
        if (r5.equals(TAG_GPS_TIMESTAMP) == true) goto L12;
        return Double.toString(r0.getDoubleValue(this.mExifByteOrder));
    L12:
        if (r0.format != 5) goto L14;
    L17:
        Rational[] r4 = (Rational[]) r0.getValue(this.mExifByteOrder);
        if (r4 != null) goto L20;
    L24:
        Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(r4));
        return null;
    L20:
        if (r4.length != 3) goto L24;
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r4[0].numerator / r4[0].denominator)), Integer.valueOf((int) (r4[1].numerator / r4[1].denominator)), Integer.valueOf((int) (r4[2].numerator / r4[2].denominator))});
    L14:
        if (r0.format == 10) goto L17;
        Log.w(TAG, "GPS Timestamp format is not rational. format=" + r0.format);
        return null;
    L30:
        throw new NullPointerException("tag shouldn't be null");
    }

    public int getAttributeInt(String r1, int r2) {
        if (r1 == null) goto L10;
        ExifAttribute r3 = getExifAttribute(r1);
        if (r3 != null) goto L11;
        return r2;
    L11:
        return r3.getIntValue(this.mExifByteOrder);
    L8:
        return r2;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(String r1, double r2) {
        if (r1 == null) goto L10;
        ExifAttribute r3 = getExifAttribute(r1);
        if (r3 != null) goto L11;
        return r2;
    L11:
        return r3.getDoubleValue(this.mExifByteOrder);
    L8:
        return r2;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    public void setAttribute(String r18, String r19) {
        String r1 = r18;
        String r2 = r19;
        if (r1 == null) goto L127;
        if (TAG_DATETIME.equals(r1) == false) goto L7;
    L10:
        if (r2 == null) goto L21;
        boolean r3 = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(r2).find();
        boolean r7 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(r2).find();
        if (r19.length() != 19) goto L18;
        if (r3 == true) goto L16;
        if (r7 == false) goto L18;
    L16:
        if (r7 == false) goto L21;
        r2 = r2.replaceAll("-", SimContactsConstants.ANR_SEP);
    L18:
        Log.w(TAG, "Invalid value for " + r1 + " : " + r2);
        return;
    L21:
        if (TAG_ISO_SPEED_RATINGS.equals(r1) == true) goto L23;
    L26:
        int r4 = 2;
        int r8 = 1;
        if (r2 != null) goto L29;
    L41:
        int r5 = 0;
        int r6 = 0;
    L43:
        if (r6 >= EXIF_TAGS.length) goto L125;
        if (r6 == 4) goto L47;
    L49:
        ExifTag r9 = sExifTagMapsForWriting[r6].get(r1);
        if (r9 == null) goto L123;
        if (r2 != null) goto L53;
        this.mAttributes[r6].remove(r1);
        goto L123
    L53:
        Pair<Integer, Integer> r10 = guessDataFormat(r2);
        int r12 = -1;
        if (r9.primaryFormat != ((Integer) r10.first).intValue()) goto L56;
    L84:
        int r11 = r9.primaryFormat;
    L86:
        switch(r11) {
            case 1: goto L122;
            case 2: goto L121;
            case 3: goto L116;
            case 4: goto L111;
            case 5: goto L106;
            case 6: goto L87;
            case 7: goto L121;
            case 8: goto L87;
            case 9: goto L100;
            case 10: goto L95;
            case 11: goto L87;
            case 12: goto L90;
            default: goto L87;
        };
    L87:
        int r15 = r8;
        if (DEBUG == false) goto L124;
        Log.d(TAG, "Data format isn't one of expected formats: " + r11);
    L124:
        r6 = r6 + 1;
        r8 = r15;
        r4 = 2;
        r5 = 0;
        goto L43
    L90:
        String[] r13 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        double[] r14 = new double[r13.length];
        int r16 = r5;
    L92:
        if (r16 >= r13.length) goto L94;
        r14[r16] = Double.parseDouble(r13[r16]);
        r16 = r16 + 1;
        goto L92
    L94:
        this.mAttributes[r6].put(r1, ExifAttribute.createDouble(r14, this.mExifByteOrder));
        goto L123
    L95:
        String[] r17 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        Rational[] r110 = new Rational[r17.length];
        int r111 = r5;
    L97:
        if (r111 >= r17.length) goto L99;
        String[] r112 = r17[r111].split(LibrarianImpl.Constants.SEPARATOR, -1);
        r110[r111] = new Rational((long) Double.parseDouble(r112[r5]), (long) Double.parseDouble(r112[r8]));
        r111 = r111 + 1;
        r17 = r17;
        r5 = 0;
        r8 = 1;
        goto L97
    L99:
        this.mAttributes[r6].put(r1, ExifAttribute.createSRational(r110, this.mExifByteOrder));
    L105:
        r15 = 1;
        goto L124
    L100:
        String[] r20 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        int[] r21 = new int[r20.length];
        int r22 = 0;
    L102:
        if (r22 >= r20.length) goto L104;
        r21[r22] = Integer.parseInt(r20[r22]);
        r22 = r22 + 1;
        goto L102
    L104:
        this.mAttributes[r6].put(r1, ExifAttribute.createSLong(r21, this.mExifByteOrder));
        goto L105
    L106:
        String[] r23 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        Rational[] r24 = new Rational[r23.length];
        int r25 = 0;
    L108:
        if (r25 >= r23.length) goto L110;
        String[] r26 = r23[r25].split(LibrarianImpl.Constants.SEPARATOR, r12);
        r24[r25] = new Rational((long) Double.parseDouble(r26[0]), (long) Double.parseDouble(r26[1]));
        r25 = r25 + 1;
        r12 = -1;
        goto L108
    L110:
        r15 = 1;
        this.mAttributes[r6].put(r1, ExifAttribute.createURational(r24, this.mExifByteOrder));
        goto L124
    L111:
        r15 = r8;
        String[] r27 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        long[] r28 = new long[r27.length];
        int r29 = 0;
    L113:
        if (r29 >= r27.length) goto L115;
        r28[r29] = Long.parseLong(r27[r29]);
        r29 = r29 + 1;
        goto L113
    L115:
        this.mAttributes[r6].put(r1, ExifAttribute.createULong(r28, this.mExifByteOrder));
        goto L124
    L116:
        r15 = r8;
        String[] r30 = r2.split(SimContactsConstants.EMAIL_SEP, -1);
        int[] r31 = new int[r30.length];
        int r32 = 0;
    L118:
        if (r32 >= r30.length) goto L120;
        r31[r32] = Integer.parseInt(r30[r32]);
        r32 = r32 + 1;
        goto L118
    L120:
        this.mAttributes[r6].put(r1, ExifAttribute.createUShort(r31, this.mExifByteOrder));
        goto L124
    L121:
        r15 = r8;
        this.mAttributes[r6].put(r1, ExifAttribute.createString(r2));
        goto L124
    L122:
        r15 = r8;
        this.mAttributes[r6].put(r1, ExifAttribute.createByte(r2));
        goto L124
    L56:
        if (r9.primaryFormat == ((Integer) r10.second).intValue()) goto L84;
        if (r9.secondaryFormat == (-1)) goto L66;
        if (r9.secondaryFormat != ((Integer) r10.first).intValue()) goto L63;
    L64:
        r11 = r9.secondaryFormat;
        goto L86
    L63:
        if (r9.secondaryFormat == ((Integer) r10.second).intValue()) goto L64;
    L66:
        if (r9.primaryFormat != r8) goto L68;
    L83:
        r11 = r9.primaryFormat;
        goto L86
    L68:
        if (r9.primaryFormat == 7) goto L83;
        if (r9.primaryFormat == r4) goto L83;
        if (DEBUG == false) goto L123;
        StringBuilder r113 = new StringBuilder("Given tag (").append(r1).append(") value didn't match with one of expected formats: ");
        String[] r114 = IFD_FORMAT_NAMES;
        StringBuilder r115 = r113.append(r114[r9.primaryFormat]);
        String r116 = "";
        if (r9.secondaryFormat != (-1)) goto L77;
        String r33 = "";
    L78:
        StringBuilder r34 = r115.append(r33).append(" (guess: ").append(r114[((Integer) r10.first).intValue()]);
        if (((Integer) r10.second).intValue() == (-1)) goto L82;
        r116 = ", " + r114[((Integer) r10.second).intValue()];
    L82:
        Log.d(TAG, r34.append(r116).append(")").toString());
        goto L123
    L77:
        r33 = ", " + r114[r9.secondaryFormat];
    L123:
        r15 = r8;
        goto L124
    L47:
        if (this.mHasThumbnail == true) goto L49;
    L125:
        return;
    L29:
        if (sTagSetForCompatibility.contains(r1) == false) goto L41;
        if (r1.equals(TAG_GPS_TIMESTAMP) == false) goto L128;
        Matcher r35 = GPS_TIMESTAMP_PATTERN.matcher(r2);
        if (r35.find() == true) goto L36;
        Log.w(TAG, "Invalid value for " + r1 + " : " + r2);
        return;
    L36:
        r2 = Integer.parseInt(r35.group(1)) + "/1," + Integer.parseInt(r35.group(2)) + "/1," + Integer.parseInt(r35.group(3)) + "/1";
        goto L41
    L128:
        r2 = new Rational(Double.parseDouble(r2)).toString();     // Catch: NumberFormatException -> L39
    L39:
        Log.w(TAG, "Invalid value for " + r1 + " : " + r2);
        return;
    L23:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L25:
        r1 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        goto L26
    L7:
        if (TAG_DATETIME_ORIGINAL.equals(r1) == true) goto L10;
        if (TAG_DATETIME_DIGITIZED.equals(r1) == false) goto L21;
    L127:
        throw new NullPointerException("tag shouldn't be null");
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int r7) {
        if ((r7 % 90) != 0) goto L19;
        int r0 = getAttributeInt(TAG_ORIENTATION, 1);
        List<Integer> r2 = ROTATION_ORDER;
        int r4 = 0;
        if (r2.contains(Integer.valueOf(r0)) == false) goto L10;
        int r1 = (r2.indexOf(Integer.valueOf(r0)) + (r7 / 90)) % 4;
        if (r1 >= 0) goto L9;
        r4 = 4;
    L9:
        r4 = r2.get(r1 + r4).intValue();
    L16:
        setAttribute(TAG_ORIENTATION, Integer.toString(r4));
        return;
    L10:
        List<Integer> r3 = FLIPPED_ROTATION_ORDER;
        if (r3.contains(Integer.valueOf(r0)) == false) goto L16;
        int r5 = (r3.indexOf(Integer.valueOf(r0)) + (r7 / 90)) % 4;
        if (r5 >= 0) goto L15;
        r4 = 4;
    L15:
        r4 = r3.get(r5 + r4).intValue();
        goto L16
    L19:
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void flipVertically() {
        int r1 = 1;
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
        r1 = 0;
        goto L12
    L5:
        r1 = 5;
        goto L12
    L6:
        r1 = 6;
        goto L12
    L7:
        r1 = 7;
        goto L12
    L8:
        r1 = 8;
        goto L12
    L9:
        r1 = 2;
        goto L12
    L10:
        r1 = 3;
        goto L12
    L11:
        r1 = 4;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r1));
    }

    public void flipHorizontally() {
        int r1 = 1;
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
        r1 = 0;
        goto L12
    L5:
        r1 = 7;
        goto L12
    L6:
        r1 = 8;
        goto L12
    L7:
        r1 = 5;
        goto L12
    L8:
        r1 = 6;
        goto L12
    L9:
        r1 = 3;
        goto L12
    L10:
        r1 = 4;
        goto L12
    L11:
        r1 = 2;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r1));
    }

    public boolean isFlipped() {
        int r2 = getAttributeInt(TAG_ORIENTATION, 1);
        if (r2 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r2 == 7) goto L12;
        if (r2 == 4) goto L12;
        if (r2 == 5) goto L12;
        return false;
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

    private void removeAttribute(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= EXIF_TAGS.length) goto L6;
        this.mAttributes[r0].remove(r3);
        r0 = r0 + 1;
        goto L4
    }

    private void loadAttributes(InputStream r5) {
        if (r5 == null) goto L56;
        int r1 = 0;
    L57:
    L41:
        th = move-exception;
        addDefaultValuesForCompatibility();
        if (DEBUG == false) goto L54;
        printAttributes();
    L54:
        throw th;
    L43:
        e = move-exception;
        boolean r0 = DEBUG;     // Catch: Throwable -> L41
        if (r0 == false) goto L47;
        Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);     // Catch: Throwable -> L41
    L47:
        addDefaultValuesForCompatibility();
        if (r0 == false) goto L60;
    L49:
        printAttributes();
        return;
    L60:
        return;
    L5:
        if (r1 >= EXIF_TAGS.length) goto L8;
        this.mAttributes[r1] = new HashMap();     // Catch: Throwable -> L41 Throwable -> L43
        r1 = r1 + 1;     // Catch: Throwable -> L41 Throwable -> L43
        goto L57
    L8:
        if (this.mIsExifDataOnly == true) goto L11;
        BufferedInputStream r2 = new BufferedInputStream(r5, 5000);     // Catch: Throwable -> L41 Throwable -> L43
        BufferedInputStream r6 = r2;     // Catch: Throwable -> L41 Throwable -> L43
        this.mMimeType = getMimeType(r2);     // Catch: Throwable -> L41 Throwable -> L43
        r5 = r2;
    L11:
        if (shouldSupportSeek(this.mMimeType) == false) goto L26;
        SeekableByteOrderedDataInputStream r3 = new SeekableByteOrderedDataInputStream(r5);     // Catch: Throwable -> L41 Throwable -> L43
        if (this.mIsExifDataOnly == false) goto L15;
        getStandaloneAttributes(r3);     // Catch: Throwable -> L41 Throwable -> L43
    L25:
        r3.seek(this.mOffsetToExifData);     // Catch: Throwable -> L41 Throwable -> L43
        setThumbnailData(r3);     // Catch: Throwable -> L41 Throwable -> L43
    L38:
        addDefaultValuesForCompatibility();
        if (DEBUG == true) goto L49;
        return;
    L15:
        int r7 = this.mMimeType;     // Catch: Throwable -> L41 Throwable -> L43
        if (r7 != 12) goto L19;
        getHeifAttributes(r3);     // Catch: Throwable -> L41 Throwable -> L43
        goto L25
    L19:
        if (r7 != 7) goto L22;
        getOrfAttributes(r3);     // Catch: Throwable -> L41 Throwable -> L43
        goto L25
    L22:
        if (r7 != 10) goto L24;
        getRw2Attributes(r3);     // Catch: Throwable -> L41 Throwable -> L43
        goto L25
    L24:
        getRawAttributes(r3);     // Catch: Throwable -> L41 Throwable -> L43
        goto L25
    L26:
        ByteOrderedDataInputStream r4 = new ByteOrderedDataInputStream(r5);     // Catch: Throwable -> L41 Throwable -> L43
        int r8 = this.mMimeType;     // Catch: Throwable -> L41 Throwable -> L43
        if (r8 != 4) goto L30;
        getJpegAttributes(r4, 0, 0);     // Catch: Throwable -> L41 Throwable -> L43
        goto L38
    L30:
        if (r8 != 13) goto L33;
        getPngAttributes(r4);     // Catch: Throwable -> L41 Throwable -> L43
        goto L38
    L33:
        if (r8 != 9) goto L36;
        getRafAttributes(r4);     // Catch: Throwable -> L41 Throwable -> L43
        goto L38
    L36:
        if (r8 != 14) goto L38;
        getWebpAttributes(r4);     // Catch: Throwable -> L41 Throwable -> L43
        goto L38
    L56:
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private static boolean isSeekableFD(FileDescriptor r3) {
        ExifInterfaceUtils.Api21Impl.lseek(r3, 0, OsConstants.SEEK_CUR);     // Catch: Exception -> L5
        return true;
    L6:
        if (DEBUG == false) goto L12;
        Log.d(TAG, "The file descriptor for the given input is not seekable");
        return false;
    L12:
        return false;
    }

    private void printAttributes() {
        int r0 = 0;
    L4:
        if (r0 >= this.mAttributes.length) goto L10;
        Log.d(TAG, "The size of tag group[" + r0 + "]: " + this.mAttributes[r0].size());
        Iterator<Map.Entry<String, ExifAttribute>> r1 = this.mAttributes[r0].entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, ExifAttribute> r3 = r1.next();
        ExifAttribute r4 = r3.getValue();
        Log.d(TAG, "tagName: " + r3.getKey() + ", tagType: " + r4.toString() + ", tagValue: '" + r4.getStringValue(this.mExifByteOrder) + "'");
        goto L7
    L9:
        r0 = r0 + 1;
        goto L4
    }

    public void saveAttributes() throws IOException {
        if (isSupportedFormatForSavingAttributes(this.mMimeType) == false) goto L114;
        if (this.mSeekableFileDescriptor != null) goto L12;
        if (this.mFilename != null) goto L12;
        throw new IOException("ExifInterface does not support saving attributes for the current input.");
    L12:
        if (this.mHasThumbnail == true) goto L14;
    L20:
        boolean r1 = true;
        this.mModified = true;
        this.mThumbnailBytes = getThumbnail();
        InputStream r2 = null;
        File r3 = File.createTempFile("temp", "tmp");     // Catch: Throwable -> L104 Exception -> L106
        if (this.mFilename == null) goto L24;
        FileInputStream r4 = new FileInputStream(this.mFilename);     // Catch: Throwable -> L104 Exception -> L106
    L128:
        FileOutputStream r7 = new FileOutputStream(r3);     // Catch: Throwable -> L98 Exception -> L101
    L137:
        ExifInterfaceUtils.copy(r4, r7);     // Catch: Throwable -> L94 Exception -> L96
        ExifInterfaceUtils.closeQuietly(r4);
        ExifInterfaceUtils.closeQuietly(r7);
        boolean r5 = false;
        FileInputStream r8 = new FileInputStream(r3);     // Catch: Throwable -> L62 Exception -> L64
    L60:
        e = e;
        BufferedInputStream r9 = null;
        BufferedOutputStream r10 = null;
        r2 = r8;
    L66:
        Exception r11 = e;
        OutputStream r12 = r10;
    L132:
        FileInputStream r13 = new FileInputStream(r3);     // Catch: Throwable -> L79 Exception -> L81
    L77:
        e = e;
        r2 = r13;
    L118:
    L84:
        th = th;
    L122:
        ExifInterfaceUtils.closeQuietly(r2);     // Catch: Throwable -> L87
        ExifInterfaceUtils.closeQuietly(r12);     // Catch: Throwable -> L87
        throw th;     // Catch: Throwable -> L87
    L87:
        th = th;
        r5 = r1;
    L89:
        r2 = r9;
    L90:
        ExifInterfaceUtils.closeQuietly(r2);
        ExifInterfaceUtils.closeQuietly(r10);
        if (r5 == true) goto L93;
        r3.delete();
    L93:
        throw th;
    L83:
        throw new IOException("Failed to save new file. Original file is stored in " + r3.getAbsolutePath(), e);     // Catch: Throwable -> L84
    L75:
        th = th;
        r1 = false;
        r2 = r13;
        goto L122
    L69:
        if (this.mFilename != null) goto L71;
        ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L75 Exception -> L77
        FileOutputStream r6 = new FileOutputStream(this.mSeekableFileDescriptor);     // Catch: Throwable -> L75 Exception -> L77
    L72:
        r12 = r6;
        ExifInterfaceUtils.copy(r13, r12);     // Catch: Throwable -> L75 Exception -> L77
        ExifInterfaceUtils.closeQuietly(r13);     // Catch: Throwable -> L50
        ExifInterfaceUtils.closeQuietly(r12);     // Catch: Throwable -> L50
        throw new IOException("Failed to save new file", r11);     // Catch: Throwable -> L50
    L71:
        r6 = new FileOutputStream(this.mFilename);     // Catch: Throwable -> L75 Exception -> L77
        goto L72
    L81:
        e = e;
    L79:
        th = th;
        r1 = false;
        goto L122
    L30:
        if (this.mFilename == null) goto L32;
        r12 = new FileOutputStream(this.mFilename);     // Catch: Exception -> L60 Throwable -> L62
    L124:
        r9 = new BufferedInputStream(r8);     // Catch: Exception -> L58 Throwable -> L62
    L135:
        r10 = new BufferedOutputStream(r12);     // Catch: Throwable -> L54 Exception -> L56
        int r14 = this.mMimeType;     // Catch: Throwable -> L50 Exception -> L52
        if (r14 != 4) goto L39;
        saveJpegAttributes(r9, r10);     // Catch: Throwable -> L50 Exception -> L52
    L48:
        ExifInterfaceUtils.closeQuietly(r9);
        ExifInterfaceUtils.closeQuietly(r10);
        r3.delete();
        this.mThumbnailBytes = null;
        return;
    L39:
        if (r14 != 13) goto L42;
        savePngAttributes(r9, r10);     // Catch: Throwable -> L50 Exception -> L52
        goto L48
    L42:
        if (r14 != 14) goto L45;
        saveWebpAttributes(r9, r10);     // Catch: Throwable -> L50 Exception -> L52
        goto L48
    L45:
        if (r14 == 3) goto L47;
        if (r14 != 0) goto L48;
    L47:
        writeExifSegment(new ByteOrderedDataOutputStream(r10, ByteOrder.BIG_ENDIAN));     // Catch: Throwable -> L50 Exception -> L52
    L52:
        e = move-exception;
        r11 = e;
        r2 = r8;
        goto L132
    L56:
        e = move-exception;
        r10 = null;
        r2 = r8;
        r11 = e;
    L54:
        th = th;
        r10 = null;
    L58:
        e = move-exception;
        r10 = null;
        r2 = r8;
        r11 = e;
        r9 = null;
        goto L132
    L32:
        ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0, OsConstants.SEEK_SET);     // Catch: Exception -> L60 Throwable -> L62
        r12 = new FileOutputStream(this.mSeekableFileDescriptor);     // Catch: Exception -> L60 Throwable -> L62
    L64:
        e = e;
        r9 = null;
        r10 = null;
    L62:
        th = th;
        r10 = null;
    L50:
        th = th;
        goto L89
    L96:
        e = e;
    L103:
        r2 = r4;
    L125:
    L110:
        th = th;
    L111:
        ExifInterfaceUtils.closeQuietly(r2);
        ExifInterfaceUtils.closeQuietly(r7);
        throw th;
    L109:
        throw new IOException("Failed to copy original file to temp file", e);     // Catch: Throwable -> L110
    L94:
        th = th;
    L100:
        r2 = r4;
    L101:
        e = e;
        r7 = null;
    L98:
        th = th;
        r7 = null;
        goto L100
    L24:
        ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L104 Exception -> L106
        r4 = new FileInputStream(this.mSeekableFileDescriptor);     // Catch: Throwable -> L104 Exception -> L106
    L106:
        e = e;
        r7 = null;
    L104:
        th = th;
        r7 = null;
        goto L111
    L14:
        if (this.mHasThumbnailStrips == false) goto L20;
        if (this.mAreThumbnailStripsConsecutive == true) goto L20;
        throw new IOException("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
    L114:
        throw new IOException("ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats.");
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean hasAttribute(String r1) {
        if (getExifAttribute(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] getThumbnail() {
        int r0 = this.mThumbnailCompression;
        if (r0 == 6) goto L10;
        if (r0 == 7) goto L10;
        return null;
    L10:
        return getThumbnailBytes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public byte[] getThumbnailBytes() {
        ?? r2 = 0;
        r2 = 0;
        if (this.mHasThumbnail == true) goto L5;
        return null;
    L5:
        ?? r1 = this.mThumbnailBytes;
        if (r1 == 0) goto L70;
        return r1;
    L70:
        r1 = this.mAssetInputStream;     // Catch: Throwable -> L50 Exception -> L52
        if (r1 == 0) goto L22;
    L19:
        e = e;
        FileDescriptor r3 = null;
        ?? r4 = r1;
    L54:
        Log.d(TAG, "Encountered exception while getting thumbnail", e);     // Catch: Throwable -> L59
        ExifInterfaceUtils.closeQuietly(r4);
        if (r3 == null) goto L58;
        ExifInterfaceUtils.closeFileDescriptor(r3);
    L58:
        return null;
    L17:
        th = th;
        FileDescriptor r5 = null;
    L60:
        r2 = r1;
    L61:
        ExifInterfaceUtils.closeQuietly(r2);
        if (r5 == null) goto L64;
        ExifInterfaceUtils.closeFileDescriptor(r5);
    L64:
        throw th;
    L11:
        if (r1.markSupported() == false) goto L14;
        r1.reset();     // Catch: Throwable -> L17 Exception -> L19
        ?? r6 = r1;
    L13:
        r3 = null;
        ?? r7 = r6;
    L65:
        if (r7 == 0) goto L45;
        if (r7.skip(this.mThumbnailOffset + this.mOffsetToExifData) != (this.mThumbnailOffset + this.mOffsetToExifData)) goto L41;
        byte[] r8 = new byte[this.mThumbnailLength];     // Catch: Exception -> L42 Throwable -> L59
        if (r7.read(r8) != this.mThumbnailLength) goto L39;
        this.mThumbnailBytes = r8;     // Catch: Exception -> L42 Throwable -> L59
        ExifInterfaceUtils.closeQuietly(r7);
        if (r3 == null) goto L37;
        ExifInterfaceUtils.closeFileDescriptor(r3);
    L37:
        return r8;
    L39:
        throw new IOException("Corrupted image");     // Catch: Exception -> L42 Throwable -> L59
    L41:
        throw new IOException("Corrupted image");     // Catch: Exception -> L42 Throwable -> L59
    L45:
        throw new FileNotFoundException();     // Catch: Exception -> L42 Throwable -> L59
    L42:
        e = e;
        r4 = r7;
        goto L54
    L14:
        Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");     // Catch: Throwable -> L17 Exception -> L19
        ExifInterfaceUtils.closeQuietly(r1);
        return null;
    L22:
        if (this.mFilename == null) goto L24;
        r6 = new FileInputStream(this.mFilename);     // Catch: Throwable -> L50 Exception -> L52
        goto L13
    L24:
        FileDescriptor r9 = ExifInterfaceUtils.Api21Impl.dup(this.mSeekableFileDescriptor);     // Catch: Throwable -> L50 Exception -> L52
        ExifInterfaceUtils.Api21Impl.lseek(r9, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L46 Exception -> L48
        r3 = r9;
        r7 = new FileInputStream(r9);     // Catch: Throwable -> L46 Exception -> L48
        goto L65
    L48:
        e = e;
        r3 = r9;
        r4 = 0;
    L46:
        th = th;
        r5 = r9;
    L52:
        e = e;
        r4 = 0;
        r3 = null;
    L50:
        th = th;
        r5 = null;
    L59:
        th = th;
        goto L60
    }

    public Bitmap getThumbnailBitmap() {
        if (this.mHasThumbnail == true) goto L6;
        return null;
    L6:
        if (this.mThumbnailBytes != null) goto L8;
        this.mThumbnailBytes = getThumbnailBytes();
    L8:
        int r0 = this.mThumbnailCompression;
        if (r0 == 6) goto L25;
        if (r0 == 7) goto L25;
        if (r0 != 1) goto L23;
        int r1 = this.mThumbnailBytes.length / 3;
        int[] r2 = new int[r1];
        int r4 = 0;
    L16:
        if (r4 >= r1) goto L18;
        byte[] r5 = this.mThumbnailBytes;
        int r6 = r4 * 3;
        r2[r4] = (((r5[r6] << Ascii.DLE) + 0) + (r5[r6 + 1] << 8)) + r5[r6 + 2];
        r4 = r4 + 1;
        goto L16
    L18:
        ExifAttribute r3 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
        ExifAttribute r7 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
        if (r3 == null) goto L23;
        if (r7 == null) goto L23;
        return Bitmap.createBitmap(r2, r7.getIntValue(this.mExifByteOrder), r3.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
    L23:
        return null;
    L25:
        return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
    }

    public boolean isThumbnailCompressed() {
        if (this.mHasThumbnail == true) goto L5;
        return false;
    L5:
        int r2 = this.mThumbnailCompression;
        if (r2 != 6) goto L8;
        return true;
    L8:
        if (r2 == 7) goto L13;
        return false;
    L13:
        return true;
    }

    public long[] getThumbnailRange() {
        if (this.mModified == true) goto L15;
        if (this.mHasThumbnail == true) goto L7;
        return null;
    L7:
        if (this.mHasThumbnailStrips == false) goto L12;
        if (this.mAreThumbnailStripsConsecutive == true) goto L12;
        return null;
    L12:
        return new long[]{this.mThumbnailOffset + this.mOffsetToExifData, this.mThumbnailLength};
    L15:
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    }

    public long[] getAttributeRange(String r4) {
        if (r4 == null) goto L14;
        if (this.mModified == true) goto L12;
        ExifAttribute r3 = getExifAttribute(r4);
        if (r3 != null) goto L8;
        return null;
    L8:
        return new long[]{r3.bytesOffset, r3.bytes.length};
    L12:
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    L14:
        throw new NullPointerException("tag shouldn't be null");
    }

    public byte[] getAttributeBytes(String r1) {
        if (r1 == null) goto L10;
        ExifAttribute r0 = getExifAttribute(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.bytes;
    L10:
        throw new NullPointerException("tag shouldn't be null");
    }

    @Deprecated
    public boolean getLatLong(float[] r4) {
        double[] r3 = getLatLong();
        if (r3 != null) goto L5;
        return false;
    L5:
        r4[0] = (float) r3[0];
        r4[1] = (float) r3[1];
        return true;
    }

    public double[] getLatLong() {
        String r0 = getAttribute(TAG_GPS_LATITUDE);
        String r1 = getAttribute(TAG_GPS_LATITUDE_REF);
        String r2 = getAttribute(TAG_GPS_LONGITUDE);
        String r11 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (r0 == null) goto L15;
        if (r1 == null) goto L16;
        if (r2 == null) goto L17;
        if (r11 != null) goto L13;
        return null;
    L13:
        return new double[]{convertRationalLatLonToDouble(r0, r1), convertRationalLatLonToDouble(r2, r11)};
    L10:
        Log.w(TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{r0, r1, r2, r11}));
        return null;
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public void setGpsInfo(Location r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        setAttribute(TAG_GPS_PROCESSING_METHOD, r6.getProvider());
        setLatLong(r6.getLatitude(), r6.getLongitude());
        setAltitude(r6.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((r6.getSpeed() * TimeUnit.HOURS.toSeconds(1)) / 1000.0f).toString());
        String[] r7 = sFormatterPrimary.format(new Date(r6.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, r7[0]);
        setAttribute(TAG_GPS_TIMESTAMP, r7[1]);
    }

    public void setLatLong(double r5, double r7) {
        if (r5 < (-90.0d)) goto L27;
        if (r5 > 90.0d) goto L27;
        if (Double.isNaN(r5) == true) goto L27;
        if (r7 < (-180.0d)) goto L25;
        if (r7 > 180.0d) goto L25;
        if (Double.isNaN(r7) == true) goto L25;
        if (r5 < 0.0d) goto L17;
        String r2 = "N";
    L18:
        setAttribute(TAG_GPS_LATITUDE_REF, r2);
        setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(r5)));
        if (r7 < 0.0d) goto L21;
        String r6 = LONGITUDE_EAST;
    L22:
        setAttribute(TAG_GPS_LONGITUDE_REF, r6);
        setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(r7)));
        return;
    L21:
        r6 = LONGITUDE_WEST;
        goto L22
    L17:
        r2 = LATITUDE_SOUTH;
    L25:
        throw new IllegalArgumentException("Longitude value " + r7 + " is not valid.");
    L27:
        throw new IllegalArgumentException("Latitude value " + r5 + " is not valid.");
    }

    public double getAltitude(double r7) {
        double r0 = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int r3 = -1;
        int r6 = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (r0 < 0.0d) goto L11;
        if (r6 < 0) goto L11;
        if (r6 == 1) goto L10;
        r3 = 1;
    L10:
        return r0 * ((double) r3);
    L11:
        return r7;
    }

    public void setAltitude(double r3) {
        if (r3 < 0.0d) goto L5;
        String r0 = "0";
    L6:
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(r3)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, r0);
        return;
    L5:
        r0 = "1";
        goto L6
    }

    public void setDateTime(Long r6) {
        if (r6 == null) goto L14;
        if (r6.longValue() < 0) goto L12;
        String r0 = Long.toString(r6.longValue() % 1000);
        int r1 = r0.length();
    L7:
        if (r1 >= 3) goto L9;
        r0 = "0" + r0;
        r1 = r1 + 1;
        goto L7
    L9:
        setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(r6.longValue())));
        setAttribute(TAG_SUBSEC_TIME, r0);
        return;
    L12:
        throw new IllegalArgumentException("Timestamp should a positive value.");
    L14:
        throw new NullPointerException("Timestamp should not be null.");
    }

    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    private static Long parseDateTime(String r10, String r11, String r12) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (NON_ZERO_TIME_PATTERN.matcher(r10).matches() == false) goto L33;
        ParsePosition r1 = new ParsePosition(0);
        Date r3 = sFormatterPrimary.parse(r10, r1);     // Catch: IllegalArgumentException -> L34
        if (r3 != null) goto L13;
        r3 = sFormatterSecondary.parse(r10, r1);     // Catch: IllegalArgumentException -> L34
        if (r3 != null) goto L13;
        return null;
    L13:
        long r4 = r3.getTime();     // Catch: IllegalArgumentException -> L34
        if (r12 == null) goto L29;
        int r13 = 1;
        String r2 = r12.substring(0, 1);     // Catch: IllegalArgumentException -> L34
        int r5 = Integer.parseInt(r12.substring(1, 3));     // Catch: IllegalArgumentException -> L34
        int r6 = Integer.parseInt(r12.substring(4, 6));     // Catch: IllegalArgumentException -> L34
        if ("+".equals(r2) == true) goto L21;
        if ("-".equals(r2) == false) goto L29;
    L21:
        if (SimContactsConstants.ANR_SEP.equals(r12.substring(3, 4)) == false) goto L29;
        if (r5 > 14) goto L29;
        int r7 = (((r5 * 60) + r6) * 60) * 1000;     // Catch: IllegalArgumentException -> L34
        if ("-".equals(r2) == true) goto L28;
        r13 = -1;
    L28:
        r4 = r4 + ((long) (r7 * r13));     // Catch: IllegalArgumentException -> L34
    L29:
        if (r11 == null) goto L31;
        r4 = r4 + ExifInterfaceUtils.parseSubSeconds(r11);     // Catch: IllegalArgumentException -> L34
    L31:
        return Long.valueOf(r4);
    }

    public Long getGpsDateTime() {
        String r0 = getAttribute(TAG_GPS_DATESTAMP);
        String r4 = getAttribute(TAG_GPS_TIMESTAMP);
        if (r0 == null) goto L18;
        if (r4 == null) goto L18;
        Pattern r2 = NON_ZERO_TIME_PATTERN;
        if (r2.matcher(r0).matches() == false) goto L8;
    L10:
        String r5 = r0 + ' ' + r4;
        ParsePosition r1 = new ParsePosition(0);
        Date r3 = sFormatterPrimary.parse(r5, r1);     // Catch: IllegalArgumentException -> L19
        if (r3 != null) goto L16;
        r3 = sFormatterSecondary.parse(r5, r1);     // Catch: IllegalArgumentException -> L19
        if (r3 != null) goto L16;
        return null;
    L16:
        return Long.valueOf(r3.getTime());
    L8:
        if (r2.matcher(r4).matches() == true) goto L10;
    L18:
        return null;
    }

    private void initForFilename(String r3) throws IOException {
        if (r3 == null) goto L18;
        FileInputStream r0 = null;
        this.mAssetInputStream = null;
        this.mFilename = r3;
        FileInputStream r1 = new FileInputStream(r3);     // Catch: Throwable -> L14
    L12:
        th = th;
        r0 = r1;
    L15:
        ExifInterfaceUtils.closeQuietly(r0);
        throw th;
    L6:
        if (isSeekableFD(r1.getFD()) == false) goto L8;
        this.mSeekableFileDescriptor = r1.getFD();     // Catch: Throwable -> L12
    L9:
        loadAttributes(r1);     // Catch: Throwable -> L12
        ExifInterfaceUtils.closeQuietly(r1);
        return;
    L8:
        this.mSeekableFileDescriptor = null;     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L15
    L18:
        throw new NullPointerException("filename cannot be null");
    }

    private static double convertRationalLatLonToDouble(String r11, String r12) {
        String[] r13 = r11.split(SimContactsConstants.EMAIL_SEP, -1);     // Catch: Throwable -> L18
        String[] r3 = r13[0].split(LibrarianImpl.Constants.SEPARATOR, -1);     // Catch: Throwable -> L18
        double r4 = Double.parseDouble(r3[0].trim()) / Double.parseDouble(r3[1].trim());     // Catch: Throwable -> L18
        String[] r5 = r13[1].split(LibrarianImpl.Constants.SEPARATOR, -1);     // Catch: Throwable -> L18
        double r7 = Double.parseDouble(r5[0].trim()) / Double.parseDouble(r5[1].trim());     // Catch: Throwable -> L18
        String[] r14 = r13[2].split(LibrarianImpl.Constants.SEPARATOR, -1);     // Catch: Throwable -> L18
        double r6 = (r4 + (r7 / 60.0d)) + ((Double.parseDouble(r14[0].trim()) / Double.parseDouble(r14[1].trim())) / 3600.0d);     // Catch: Throwable -> L18
        if (r12.equals(LATITUDE_SOUTH) == true) goto L17;
        if (r12.equals(LONGITUDE_WEST) == true) goto L17;
        if (r12.equals("N") == false) goto L11;
    L15:
        return r6;
    L11:
        if (r12.equals(LONGITUDE_EAST) == true) goto L15;
        throw new IllegalArgumentException();     // Catch: Throwable -> L18
    L17:
        return -r6;
    L19:
        throw new IllegalArgumentException();
    }

    private String convertDecimalDegree(double r9) {
        long r0 = (long) r9;
        double r10 = r9 - r0;
        long r4 = (long) (r10 * 60.0d);
        return r0 + "/1," + r4 + "/1," + Math.round(((r10 - (r4 / 60.0d)) * 3600.0d) * 1.0E7d) + "/10000000";
    }

    private int getMimeType(BufferedInputStream r2) throws IOException {
        r2.mark(5000);
        byte[] r0 = new byte[5000];
        r2.read(r0);
        r2.reset();
        if (isJpegFormat(r0) == false) goto L7;
        return 4;
    L7:
        if (isRafFormat(r0) == false) goto L11;
        return 9;
    L11:
        if (isHeifFormat(r0) == false) goto L15;
        return 12;
    L15:
        if (isOrfFormat(r0) == false) goto L19;
        return 7;
    L19:
        if (isRw2Format(r0) == false) goto L23;
        return 10;
    L23:
        if (isPngFormat(r0) == false) goto L27;
        return 13;
    L27:
        if (isWebpFormat(r0) == false) goto L30;
        return 14;
    L30:
        return 0;
    }

    private static boolean isJpegFormat(byte[] r4) throws IOException {
        int r1 = 0;
    L3:
        byte[] r2 = JPEG_SIGNATURE;
        if (r1 >= r2.length) goto L9;
        if (r4[r1] != r2[r1]) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isRafFormat(byte[] r5) throws IOException {
        byte[] r4 = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L9;
        if (r5[r1] != r4[r1]) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isHeifFormat(byte[] r14) throws IOException {
        ByteOrderedDataInputStream r0 = null;
        ByteOrderedDataInputStream r1 = new ByteOrderedDataInputStream(r14);     // Catch: Throwable -> L50 Exception -> L52
        long r2 = r1.readInt();     // Catch: Throwable -> L46 Exception -> L48
        byte[] r4 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        r1.read(r4);     // Catch: Throwable -> L46 Exception -> L48
        if (Arrays.equals(r4, HEIF_TYPE_FTYP) == true) goto L9;
        r1.close();
        return false;
    L9:
        if (r2 != 1) goto L15;
        r2 = r1.readLong();     // Catch: Throwable -> L46 Exception -> L48
        long r9 = 16;
        if (r2 >= 16) goto L17;
        r1.close();
        return false;
    L17:
        if (r2 > r14.length) goto L19;
    L20:
        long r3 = r2 - r9;
        if (r3 >= 8) goto L24;
        r1.close();
        return false;
    L24:
        byte[] r15 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        long r6 = 0;
        boolean r8 = false;
        boolean r10 = false;
    L25:
        if (r6 >= (r3 / 4)) goto L45;
        if (r1.read(r15) != 4) goto L29;
        if (r6 == 1) goto L44;
        if (Arrays.equals(r15, HEIF_BRAND_MIF1) == false) goto L38;
        r8 = true;
    L40:
        if (r8 == false) goto L44;
        if (r10 == false) goto L44;
        r1.close();
        return true;
    L38:
        if (Arrays.equals(r15, HEIF_BRAND_HEIC) == false) goto L40;
        r10 = true;
    L44:
        r6 = r6 + 1;
        goto L25
    L29:
        r1.close();
        return false;
    L45:
        r1.close();
    L58:
        return false;
    L19:
        r2 = r14.length;     // Catch: Throwable -> L46 Exception -> L48
        goto L20
    L15:
        r9 = 8;
    L48:
        e = e;
        r0 = r1;
    L54:
        if (DEBUG == false) goto L56;
        Log.d(TAG, "Exception parsing HEIF file type box.", e);     // Catch: Throwable -> L50
    L56:
        if (r0 == null) goto L58;
        r0.close();
    L46:
        th = th;
        r0 = r1;
    L59:
        if (r0 == null) goto L61;
        r0.close();
    L61:
        throw th;
    L52:
        e = e;
    L50:
        th = th;
        goto L59
    }

    private boolean isOrfFormat(byte[] r4) throws IOException {
        boolean r0 = false;
        ByteOrderedDataInputStream r1 = null;
        ByteOrderedDataInputStream r2 = new ByteOrderedDataInputStream(r4);     // Catch: Throwable -> L15 Exception -> L22
        ByteOrder r5 = readByteOrder(r2);     // Catch: Throwable -> L12 Exception -> L14
        this.mExifByteOrder = r5;     // Catch: Throwable -> L12 Exception -> L14
        r2.setByteOrder(r5);     // Catch: Throwable -> L12 Exception -> L14
        short r3 = r2.readShort();     // Catch: Throwable -> L12 Exception -> L14
    L6:
        if (r3 != 20306) goto L8;
    L9:
        r0 = true;
    L10:
        r2.close();
        return r0;
    L8:
        if (r3 != 21330) goto L10;
    L14:
        r1 = r2;
    L12:
        th = th;
        r1 = r2;
    L16:
        if (r1 == null) goto L18;
        r1.close();
    L18:
        throw th;
    L15:
        th = th;
    L19:
        if (r1 == null) goto L21;
        r1.close();
    L21:
        return false;
    }

    private boolean isRw2Format(byte[] r4) throws IOException {
        boolean r0 = false;
        ByteOrderedDataInputStream r1 = null;
        ByteOrderedDataInputStream r2 = new ByteOrderedDataInputStream(r4);     // Catch: Throwable -> L13 Exception -> L20
        ByteOrder r5 = readByteOrder(r2);     // Catch: Throwable -> L10 Exception -> L12
        this.mExifByteOrder = r5;     // Catch: Throwable -> L10 Exception -> L12
        r2.setByteOrder(r5);     // Catch: Throwable -> L10 Exception -> L12
    L6:
        if (r2.readShort() != 85) goto L8;
        r0 = true;
    L8:
        r2.close();
        return r0;
    L12:
        r1 = r2;
    L10:
        th = th;
        r1 = r2;
    L14:
        if (r1 == null) goto L16;
        r1.close();
    L16:
        throw th;
    L13:
        th = th;
    L17:
        if (r1 == null) goto L19;
        r1.close();
    L19:
        return false;
    }

    private boolean isPngFormat(byte[] r4) throws IOException {
        int r0 = 0;
    L3:
        byte[] r1 = PNG_SIGNATURE;
        if (r0 >= r1.length) goto L9;
        if (r4[r0] != r1[r0]) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isWebpFormat(byte[] r4) throws IOException {
        int r0 = 0;
    L3:
        byte[] r1 = WEBP_SIGNATURE_1;
        if (r0 >= r1.length) goto L9;
        if (r4[r0] != r1[r0]) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return false;
    L9:
        int r2 = 0;
    L10:
        byte[] r3 = WEBP_SIGNATURE_2;
        if (r2 >= r3.length) goto L16;
        if (r4[(WEBP_SIGNATURE_1.length + r2) + 4] != r3[r2]) goto L14;
        r2 = r2 + 1;
        goto L10
    L14:
        return false;
    L16:
        return true;
    }

    private static boolean isExifDataOnly(BufferedInputStream r4) throws IOException {
        byte[] r0 = IDENTIFIER_EXIF_APP1;
        r4.mark(r0.length);
        byte[] r1 = new byte[r0.length];
        r4.read(r1);
        r4.reset();
        int r2 = 0;
    L3:
        byte[] r3 = IDENTIFIER_EXIF_APP1;
        if (r2 >= r3.length) goto L9;
        if (r1[r2] != r3[r2]) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private void getJpegAttributes(ByteOrderedDataInputStream r22, int r23, int r24) throws IOException {
        boolean r3 = DEBUG;
        String r4 = TAG;
        if (r3 == false) goto L5;
        Log.d(TAG, "getJpegAttributes starting with: " + r22);
    L5:
        r22.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte r5 = r22.readByte();
        byte r6 = -1;
        if (r5 != (-1)) goto L75;
        if (r22.readByte() != (-40)) goto L73;
        int r7 = 2;
        int r8 = 2;
    L10:
        byte r9 = r22.readByte();
        if (r9 != r6) goto L71;
        int r10 = r8 + 1;
        byte r11 = r22.readByte();
        boolean r12 = DEBUG;
        if (r12 == false) goto L15;
        Log.d(r4, "Found JPEG segment indicator: " + Integer.toHexString(r11 & 255));
    L15:
        int r13 = r10 + 1;
        if (r11 == (-39)) goto L68;
        if (r11 == (-38)) goto L68;
        int r14 = r22.readUnsignedShort() - r7;
        int r15 = r13 + r7;
        if (r12 == false) goto L24;
        Log.d(r4, "JPEG segment: " + Integer.toHexString(r11 & 255) + " (length: " + (r14 + 2) + ")");
    L24:
        if (r14 < 0) goto L67;
        if (r11 != (-31)) goto L28;
        byte[] r16 = new byte[r14];
        r22.readFully(r16);
        int r17 = r15 + r14;
        byte[] r18 = IDENTIFIER_EXIF_APP1;
        if (ExifInterfaceUtils.startsWith(r16, r18) == false) goto L54;
        byte[] r19 = Arrays.copyOfRange(r16, r18.length, r14);
        this.mOffsetToExifData = (r23 + r15) + r18.length;
        readExifSegment(r19, r24);
        setThumbnailData(new ByteOrderedDataInputStream(r19));
    L60:
        r15 = r17;
    L61:
        r14 = 0;
    L62:
        if (r14 < 0) goto L65;
        r22.skipFully(r14);
        r8 = r15 + r14;
        r4 = r4;
        r7 = 2;
        r6 = -1;
        goto L10
    L65:
        throw new IOException("Invalid length");
    L54:
        byte[] r110 = IDENTIFIER_XMP_APP1;
        if (ExifInterfaceUtils.startsWith(r16, r110) == false) goto L60;
        int r20 = r15 + r110.length;
        byte[] r21 = Arrays.copyOfRange(r16, r110.length, r14);
        if (getAttribute(TAG_XMP) != null) goto L60;
        this.mAttributes[0].put(TAG_XMP, new ExifAttribute(1, r21.length, r20, r21));
        this.mXmpIsFromSeparateMarker = true;
        goto L60
    L28:
        if (r11 == (-2)) goto L43;
        switch(r11) {
            case -64: goto L34;
            case -63: goto L34;
            case -62: goto L34;
            case -61: goto L34;
            default: goto L30;
        };
    L30:
        switch(r11) {
            case -59: goto L34;
            case -58: goto L34;
            case -57: goto L34;
            default: goto L31;
        };
    L31:
        switch(r11) {
            case -55: goto L34;
            case -54: goto L34;
            case -53: goto L34;
            default: goto L32;
        };
    L32:
        switch(r11) {
            case -51: goto L34;
            case -50: goto L34;
            case -49: goto L34;
            default: goto L33;
        };
    L33:
        r4 = r4;
    L34:
        r22.skipFully(1);
        HashMap<String, ExifAttribute> r25 = this.mAttributes[r24];
        if (r24 == 4) goto L37;
        String r111 = TAG_IMAGE_LENGTH;
    L38:
        r25.put(r111, ExifAttribute.createULong(r22.readUnsignedShort(), this.mExifByteOrder));
        HashMap<String, ExifAttribute> r26 = this.mAttributes[r24];
        if (r24 == 4) goto L41;
        String r27 = TAG_IMAGE_WIDTH;
    L42:
        r26.put(r27, ExifAttribute.createULong(r22.readUnsignedShort(), this.mExifByteOrder));
        r14 = r14 - 5;
        goto L33
    L41:
        r27 = TAG_THUMBNAIL_IMAGE_WIDTH;
        goto L42
    L37:
        r111 = TAG_THUMBNAIL_IMAGE_LENGTH;
        goto L38
    L43:
        byte[] r28 = new byte[r14];
        if (r22.read(r28) != r14) goto L50;
        if (getAttribute(TAG_USER_COMMENT) != null) goto L48;
        this.mAttributes[1].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(r28, ASCII)));
    L48:
        r4 = r4;
        goto L61
    L50:
        throw new IOException("Invalid exif");
    L67:
        throw new IOException("Invalid length");
    L68:
        r22.setByteOrder(this.mExifByteOrder);
        return;
    L71:
        throw new IOException("Invalid marker:" + Integer.toHexString(r9 & 255));
    L73:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    L75:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    }

    private void getRawAttributes(SeekableByteOrderedDataInputStream r3) throws IOException {
        parseTiffHeaders(r3);
        readImageFileDirectory(r3, 0);
        updateImageSizeValues(r3, 0);
        updateImageSizeValues(r3, 5);
        updateImageSizeValues(r3, 4);
        validateImages();
        if (this.mMimeType != 8) goto L10;
        ExifAttribute r4 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r4 == null) goto L11;
        SeekableByteOrderedDataInputStream r1 = new SeekableByteOrderedDataInputStream(r4.bytes);
        r1.setByteOrder(this.mExifByteOrder);
        r1.skipFully(6);
        readImageFileDirectory(r1, 9);
        ExifAttribute r5 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (r5 == null) goto L12;
        this.mAttributes[1].put(TAG_COLOR_SPACE, r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void getRafAttributes(ByteOrderedDataInputStream r8) throws IOException {
        boolean r0 = DEBUG;
        if (r0 == false) goto L5;
        Log.d(TAG, "getRafAttributes starting with: " + r8);
    L5:
        r8.skipFully(84);
        byte[] r3 = new byte[4];
        byte[] r4 = new byte[4];
        byte[] r2 = new byte[4];
        r8.read(r3);
        r8.read(r4);
        r8.read(r2);
        int r5 = ByteBuffer.wrap(r3).getInt();
        int r6 = ByteBuffer.wrap(r4).getInt();
        int r7 = ByteBuffer.wrap(r2).getInt();
        byte[] r9 = new byte[r6];
        r8.skipFully(r5 - r8.position());
        r8.read(r9);
        getJpegAttributes(new ByteOrderedDataInputStream(r9), r5, 5);
        r8.skipFully(r7 - r8.position());
        r8.setByteOrder(ByteOrder.BIG_ENDIAN);
        int r10 = r8.readInt();
        if (r0 == false) goto L8;
        Log.d(TAG, "numberOfDirectoryEntry: " + r10);
    L8:
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L17;
        int r12 = r8.readUnsignedShort();
        int r13 = r8.readUnsignedShort();
        if (r12 == TAG_RAF_IMAGE_SIZE.number) goto L12;
        r8.skipFully(r13);
        r11 = r11 + 1;
        goto L9
    L12:
        short r14 = r8.readShort();
        short r15 = r8.readShort();
        ExifAttribute r16 = ExifAttribute.createUShort(r14, this.mExifByteOrder);
        ExifAttribute r17 = ExifAttribute.createUShort(r15, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r16);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r17);
        if (DEBUG == false) goto L20;
        Log.d(TAG, "Updated to length: " + r14 + ", width: " + r15);
        return;
    L20:
        return;
    }

    private void getHeifAttributes(final SeekableByteOrderedDataInputStream r14) throws IOException {
        MediaMetadataRetriever r2 = new MediaMetadataRetriever();
        ExifInterfaceUtils.Api23Impl.setDataSource(r2, new AnonymousClass1(this, r14));     // Catch: Throwable -> L52 RuntimeException -> L54
        String r3 = r2.extractMetadata(33);     // Catch: Throwable -> L52 RuntimeException -> L54
        String r4 = r2.extractMetadata(34);     // Catch: Throwable -> L52 RuntimeException -> L54
        String r5 = r2.extractMetadata(26);     // Catch: Throwable -> L52 RuntimeException -> L54
        String r6 = r2.extractMetadata(17);     // Catch: Throwable -> L52 RuntimeException -> L54
        if ("yes".equals(r5) == false) goto L7;
        String r0 = r2.extractMetadata(29);     // Catch: Throwable -> L52 RuntimeException -> L54
        String r7 = r2.extractMetadata(30);     // Catch: Throwable -> L52 RuntimeException -> L54
        String r8 = r2.extractMetadata(31);     // Catch: Throwable -> L52 RuntimeException -> L54
    L11:
        if (r0 == null) goto L13;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createUShort(Integer.parseInt(r0), this.mExifByteOrder));     // Catch: Throwable -> L52 RuntimeException -> L54
    L13:
        if (r7 == null) goto L16;
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createUShort(Integer.parseInt(r7), this.mExifByteOrder));     // Catch: Throwable -> L52 RuntimeException -> L54
    L16:
        if (r8 == null) goto L28;
        int r9 = Integer.parseInt(r8);     // Catch: Throwable -> L52 RuntimeException -> L54
        if (r9 != 90) goto L20;
        int r10 = 6;
    L27:
        this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createUShort(r10, this.mExifByteOrder));     // Catch: Throwable -> L52 RuntimeException -> L54
        goto L28
    L20:
        if (r9 != 180) goto L22;
        r10 = 3;
        goto L27
    L22:
        if (r9 == 270) goto L24;
        r10 = 1;
        goto L27
    L24:
        r10 = 8;
    L28:
        if (r3 == null) goto L48;
        if (r4 == null) goto L48;
        int r11 = Integer.parseInt(r3);     // Catch: Throwable -> L52 RuntimeException -> L54
        int r12 = Integer.parseInt(r4);     // Catch: Throwable -> L52 RuntimeException -> L54
        if (r12 <= 6) goto L46;
        r14.seek(r11);     // Catch: Throwable -> L52 RuntimeException -> L54
        byte[] r13 = new byte[6];     // Catch: Throwable -> L52 RuntimeException -> L54
        if (r14.read(r13) != 6) goto L44;
        int r15 = r11 + 6;     // Catch: Throwable -> L52 RuntimeException -> L54
        int r16 = r12 - 6;     // Catch: Throwable -> L52 RuntimeException -> L54
        if (Arrays.equals(r13, IDENTIFIER_EXIF_APP1) == false) goto L42;
        byte[] r17 = new byte[r16];     // Catch: Throwable -> L52 RuntimeException -> L54
        if (r14.read(r17) != r16) goto L40;
        this.mOffsetToExifData = r15;     // Catch: Throwable -> L52 RuntimeException -> L54
        readExifSegment(r17, 0);     // Catch: Throwable -> L52 RuntimeException -> L54
        goto L48
    L40:
        throw new IOException("Can't read exif");     // Catch: Throwable -> L52 RuntimeException -> L54
    L42:
        throw new IOException("Invalid identifier");     // Catch: Throwable -> L52 RuntimeException -> L54
    L44:
        throw new IOException("Can't read identifier");     // Catch: Throwable -> L52 RuntimeException -> L54
    L46:
        throw new IOException("Invalid exif length");     // Catch: Throwable -> L52 RuntimeException -> L54
    L48:
        if (DEBUG == false) goto L50;
        Log.d(TAG, "Heif meta: " + r0 + MaterialConfigFormatNames.X + r7 + ", rotation " + r8);     // Catch: Throwable -> L52 RuntimeException -> L54
    L50:
        r2.release();
        return;
    L7:
        if ("yes".equals(r6) == false) goto L9;
        r0 = r2.extractMetadata(18);     // Catch: Throwable -> L52 RuntimeException -> L54
        r7 = r2.extractMetadata(19);     // Catch: Throwable -> L52 RuntimeException -> L54
        r8 = r2.extractMetadata(24);     // Catch: Throwable -> L52 RuntimeException -> L54
        goto L11
    L9:
        r0 = null;
        r7 = null;
        r8 = null;
        goto L11
    L55:
        throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r2.release();
        throw th;
    }

    private void getStandaloneAttributes(SeekableByteOrderedDataInputStream r3) throws IOException {
        byte[] r0 = IDENTIFIER_EXIF_APP1;
        r3.skipFully(r0.length);
        byte[] r1 = new byte[r3.available()];
        r3.readFully(r1);
        this.mOffsetToExifData = r0.length;
        readExifSegment(r1, 0);
    }

    private void getOrfAttributes(SeekableByteOrderedDataInputStream r6) throws IOException {
        getRawAttributes(r6);
        ExifAttribute r7 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r7 == null) goto L31;
        SeekableByteOrderedDataInputStream r1 = new SeekableByteOrderedDataInputStream(r7.bytes);
        r1.setByteOrder(this.mExifByteOrder);
        byte[] r8 = ORF_MAKER_NOTE_HEADER_1;
        byte[] r2 = new byte[r8.length];
        r1.readFully(r2);
        r1.seek(0);
        byte[] r3 = ORF_MAKER_NOTE_HEADER_2;
        byte[] r4 = new byte[r3.length];
        r1.readFully(r4);
        if (Arrays.equals(r2, r8) == false) goto L8;
        r1.seek(8);
    L10:
        readImageFileDirectory(r1, 6);
        ExifAttribute r9 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
        ExifAttribute r5 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
        if (r9 == null) goto L14;
        if (r5 == null) goto L14;
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, r9);
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r5);
    L14:
        ExifAttribute r10 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
        if (r10 == null) goto L32;
        int[] r11 = (int[]) r10.getValue(this.mExifByteOrder);
        if (r11 != null) goto L19;
    L29:
        Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(r11));
        return;
    L19:
        if (r11.length != 4) goto L29;
        int r12 = r11[2];
        int r13 = r11[0];
        if (r12 <= r13) goto L33;
        int r14 = r11[3];
        int r15 = r11[1];
        if (r14 <= r15) goto L34;
        int r16 = (r12 - r13) + 1;
        int r17 = (r14 - r15) + 1;
        if (r16 >= r17) goto L28;
        int r18 = r16 + r17;
        r17 = r18 - r17;
        r16 = r18 - r17;
    L28:
        ExifAttribute r19 = ExifAttribute.createUShort(r16, this.mExifByteOrder);
        ExifAttribute r0 = ExifAttribute.createUShort(r17, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r19);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r0);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r4, r3) == false) goto L10;
        r1.seek(12);
        goto L10
    }

    private void getRw2Attributes(SeekableByteOrderedDataInputStream r5) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "getRw2Attributes starting with: " + r5);
    L5:
        getRawAttributes(r5);
        ExifAttribute r6 = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (r6 == null) goto L8;
        getJpegAttributes(new ByteOrderedDataInputStream(r6.bytes), (int) r6.bytesOffset, 5);
    L8:
        ExifAttribute r7 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute r0 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (r7 == null) goto L13;
        if (r0 != null) goto L14;
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, r7);
        return;
    L14:
        return;
    }

    private void getPngAttributes(ByteOrderedDataInputStream r7) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "getPngAttributes starting with: " + r7);
    L5:
        r7.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] r0 = PNG_SIGNATURE;
        r7.skipFully(r0.length);
        int r1 = r0.length + 0;
    L35:
        int r2 = r7.readInt();     // Catch: EOFException -> L33
        int r3 = r1 + 4;     // Catch: EOFException -> L33
        byte[] r4 = new byte[4];     // Catch: EOFException -> L33
        if (r7.read(r4) != 4) goto L32;
        int r5 = r3 + 4;     // Catch: EOFException -> L33
        if (r5 != 16) goto L16;
        if (Arrays.equals(r4, PNG_CHUNK_TYPE_IHDR) == true) goto L16;
        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");     // Catch: EOFException -> L33
    L16:
        if (Arrays.equals(r4, PNG_CHUNK_TYPE_IEND) == true) goto L40;
        if (Arrays.equals(r4, PNG_CHUNK_TYPE_EXIF) == true) goto L20;
        int r6 = r2 + 4;     // Catch: EOFException -> L33
        r7.skipFully(r6);     // Catch: EOFException -> L33
        r1 = r5 + r6;     // Catch: EOFException -> L33
        goto L35
    L20:
        byte[] r8 = new byte[r2];     // Catch: EOFException -> L33
        if (r7.read(r8) != r2) goto L29;
        int r9 = r7.readInt();     // Catch: EOFException -> L33
        CRC32 r10 = new CRC32();     // Catch: EOFException -> L33
        r10.update(r4);     // Catch: EOFException -> L33
        r10.update(r8);     // Catch: EOFException -> L33
        if (((int) r10.getValue()) != r9) goto L27;
        this.mOffsetToExifData = r5;     // Catch: EOFException -> L33
        readExifSegment(r8, 0);     // Catch: EOFException -> L33
        validateImages();     // Catch: EOFException -> L33
        setThumbnailData(new ByteOrderedDataInputStream(r8));     // Catch: EOFException -> L33
        return;
    L27:
        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + r9 + ", calculated CRC value: " + r10.getValue());     // Catch: EOFException -> L33
    L29:
        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(r4));     // Catch: EOFException -> L33
    L40:
        return;
    L32:
        throw new IOException("Encountered invalid length while parsing PNG chunktype");     // Catch: EOFException -> L33
    L34:
        throw new IOException("Encountered corrupt PNG file.");
    }

    private void getWebpAttributes(ByteOrderedDataInputStream r6) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "getWebpAttributes starting with: " + r6);
    L5:
        r6.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        r6.skipFully(WEBP_SIGNATURE_1.length);
        int r0 = r6.readInt() + 8;
        byte[] r1 = WEBP_SIGNATURE_2;
        r6.skipFully(r1.length);
        int r2 = r1.length + 8;
    L30:
        byte[] r3 = new byte[4];     // Catch: EOFException -> L28
        if (r6.read(r3) != 4) goto L27;
        int r4 = r6.readInt();     // Catch: EOFException -> L28
        int r5 = (r2 + 4) + 4;     // Catch: EOFException -> L28
        if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, r3) == true) goto L11;
        if ((r4 % 2) != 1) goto L19;
        r4 = r4 + 1;     // Catch: EOFException -> L28
    L19:
        r2 = r5 + r4;     // Catch: EOFException -> L28
        if (r2 == r0) goto L35;
        if (r2 > r0) goto L25;
        r6.skipFully(r4);     // Catch: EOFException -> L28
        goto L30
    L25:
        throw new IOException("Encountered WebP file with invalid chunk size");     // Catch: EOFException -> L28
    L35:
        return;
    L11:
        byte[] r7 = new byte[r4];     // Catch: EOFException -> L28
        if (r6.read(r7) != r4) goto L15;
        this.mOffsetToExifData = r5;     // Catch: EOFException -> L28
        readExifSegment(r7, 0);     // Catch: EOFException -> L28
        setThumbnailData(new ByteOrderedDataInputStream(r7));     // Catch: EOFException -> L28
        return;
    L15:
        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(r3));     // Catch: EOFException -> L28
    L27:
        throw new IOException("Encountered invalid length while parsing WebP chunktype");     // Catch: EOFException -> L28
    L29:
        throw new IOException("Encountered corrupt WebP file.");
    }

    private void saveJpegAttributes(InputStream r11, OutputStream r12) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + r11 + ", outputStream: " + r12 + ")");
    L5:
        ByteOrderedDataInputStream r0 = new ByteOrderedDataInputStream(r11);
        ByteOrderedDataOutputStream r13 = new ByteOrderedDataOutputStream(r12, ByteOrder.BIG_ENDIAN);
        if (r0.readByte() != (-1)) goto L62;
        r13.writeByte(-1);
        if (r0.readByte() != (-40)) goto L60;
        r13.writeByte(-40);
        if (getAttribute(TAG_XMP) != null) goto L12;
    L14:
        ExifAttribute r3 = null;
    L15:
        r13.writeByte(-1);
        r13.writeByte(-31);
        writeExifSegment(r13);
        if (r3 == null) goto L18;
        this.mAttributes[0].put(TAG_XMP, r3);
    L18:
        byte[] r14 = new byte[4096];
    L20:
        if (r0.readByte() != (-1)) goto L58;
        byte r4 = r0.readByte();
        if (r4 == (-39)) goto L55;
        if (r4 == (-38)) goto L55;
        if (r4 != (-31)) goto L27;
        int r7 = r0.readUnsignedShort() - 2;
        if (r7 < 0) goto L54;
        byte[] r8 = new byte[6];
        if (r7 < 6) goto L46;
        if (r0.read(r8) != 6) goto L45;
        if (Arrays.equals(r8, IDENTIFIER_EXIF_APP1) == false) goto L46;
        r0.skipFully(r7 - 6);
        goto L20
    L45:
        throw new IOException("Invalid exif");
    L46:
        r13.writeByte(-1);
        r13.writeByte(r4);
        r13.writeUnsignedShort(r7 + 2);
        if (r7 < 6) goto L49;
        r7 = r7 - 6;
        r13.write(r8);
    L49:
        if (r7 <= 0) goto L20;
        int r5 = r0.read(r14, 0, Math.min(r7, 4096));
        if (r5 < 0) goto L20;
        r13.write(r14, 0, r5);
        r7 = r7 - r5;
        goto L49
    L54:
        throw new IOException("Invalid length");
    L27:
        r13.writeByte(-1);
        r13.writeByte(r4);
        int r6 = r0.readUnsignedShort();
        r13.writeUnsignedShort(r6);
        int r9 = r6 - 2;
        if (r9 < 0) goto L34;
    L29:
        if (r9 <= 0) goto L20;
        int r10 = r0.read(r14, 0, Math.min(r9, 4096));
        if (r10 < 0) goto L20;
        r13.write(r14, 0, r10);
        r9 = r9 - r10;
        goto L29
    L34:
        throw new IOException("Invalid length");
    L55:
        r13.writeByte(-1);
        r13.writeByte(r4);
        ExifInterfaceUtils.copy(r0, r13);
        return;
    L58:
        throw new IOException("Invalid marker");
    L12:
        if (this.mXmpIsFromSeparateMarker == false) goto L14;
        r3 = this.mAttributes[0].remove(TAG_XMP);
        goto L15
    L60:
        throw new IOException("Invalid marker");
    L62:
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream r5, OutputStream r6) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "savePngAttributes starting with (inputStream: " + r5 + ", outputStream: " + r6 + ")");
    L5:
        ByteOrderedDataInputStream r0 = new ByteOrderedDataInputStream(r5);
        ByteOrderedDataOutputStream r7 = new ByteOrderedDataOutputStream(r6, ByteOrder.BIG_ENDIAN);
        byte[] r8 = PNG_SIGNATURE;
        ExifInterfaceUtils.copy(r0, r7, r8.length);
        int r1 = this.mOffsetToExifData;
        if (r1 != 0) goto L8;
        int r9 = r0.readInt();
        r7.writeInt(r9);
        ExifInterfaceUtils.copy(r0, r7, (r9 + 4) + 4);
    L9:
        ByteArrayOutputStream r10 = null;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
        ByteOrderedDataOutputStream r11 = new ByteOrderedDataOutputStream(r2, ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L14
        writeExifSegment(r11);     // Catch: Throwable -> L14
        byte[] r4 = ((ByteArrayOutputStream) r11.mOutputStream).toByteArray();     // Catch: Throwable -> L14
        r7.write(r4);     // Catch: Throwable -> L14
        CRC32 r12 = new CRC32();     // Catch: Throwable -> L14
        r12.update(r4, 4, r4.length - 4);     // Catch: Throwable -> L14
        r7.writeInt((int) r12.getValue());     // Catch: Throwable -> L14
        ExifInterfaceUtils.closeQuietly(r2);
        ExifInterfaceUtils.copy(r0, r7);
        return;
    L14:
        th = th;
        r10 = r2;
    L17:
        ExifInterfaceUtils.closeQuietly(r10);
        throw th;
    L16:
        th = th;
        goto L17
    L8:
        ExifInterfaceUtils.copy(r0, r7, ((r1 - r8.length) - 4) - 4);
        r0.skipFully((r0.readInt() + 4) + 4);
        goto L9
    }

    private void saveWebpAttributes(InputStream r21, OutputStream r22) throws IOException {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + r21 + ", outputStream: " + r22 + ")");
    L5:
        ByteOrderedDataInputStream r3 = new ByteOrderedDataInputStream(r21, ByteOrder.LITTLE_ENDIAN);
        ByteOrderedDataOutputStream r4 = new ByteOrderedDataOutputStream(r22, ByteOrder.LITTLE_ENDIAN);
        byte[] r2 = WEBP_SIGNATURE_1;
        ExifInterfaceUtils.copy(r3, r4, r2.length);
        byte[] r5 = WEBP_SIGNATURE_2;
        r3.skipFully(r5.length + 4);
        ByteArrayOutputStream r6 = null;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();     // Catch: Throwable -> L70 Exception -> L72
        ByteOrderedDataOutputStream r9 = new ByteOrderedDataOutputStream(r8, ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L66 Exception -> L68
        int r10 = this.mOffsetToExifData;     // Catch: Throwable -> L66 Exception -> L68
        if (r10 == 0) goto L10;
        ExifInterfaceUtils.copy(r3, r9, ((r10 - ((r2.length + 4) + r5.length)) - 4) - 4);     // Catch: Throwable -> L66 Exception -> L68
        r3.skipFully(4);     // Catch: Throwable -> L66 Exception -> L68
        r3.skipFully(r3.readInt());     // Catch: Throwable -> L66 Exception -> L68
        writeExifSegment(r9);     // Catch: Throwable -> L66 Exception -> L68
    L61:
        ExifInterfaceUtils.copy(r3, r9);     // Catch: Throwable -> L66 Exception -> L68
        int r0 = r8.size();     // Catch: Throwable -> L66 Exception -> L68
        byte[] r1 = WEBP_SIGNATURE_2;     // Catch: Throwable -> L66 Exception -> L68
        r4.writeInt(r0 + r1.length);     // Catch: Throwable -> L66 Exception -> L68
        r4.write(r1);     // Catch: Throwable -> L66 Exception -> L68
        r8.writeTo(r4);     // Catch: Throwable -> L66 Exception -> L68
        ExifInterfaceUtils.closeQuietly(r8);
        return;
    L10:
        byte[] r7 = new byte[4];     // Catch: Throwable -> L66 Exception -> L68
        if (r3.read(r7) != 4) goto L65;
        byte[] r11 = WEBP_CHUNK_TYPE_VP8X;     // Catch: Throwable -> L66 Exception -> L68
        boolean r12 = false;
        if (Arrays.equals(r7, r11) == false) goto L29;
        int r13 = r3.readInt();     // Catch: Throwable -> L66 Exception -> L68
        if ((r13 % 2) != 1) goto L17;
        int r14 = r13 + 1;     // Catch: Throwable -> L66 Exception -> L68
    L18:
        byte[] r15 = new byte[r14];     // Catch: Throwable -> L66 Exception -> L68
        r3.read(r15);     // Catch: Throwable -> L66 Exception -> L68
        byte r16 = (byte) (8 | r15[0]);     // Catch: Throwable -> L66 Exception -> L68
        r15[0] = r16;     // Catch: Throwable -> L66 Exception -> L68
        if (((r16 >> 1) & 1) != 1) goto L21;
        r12 = true;
    L21:
        r9.write(r11);     // Catch: Throwable -> L66 Exception -> L68
        r9.writeInt(r13);     // Catch: Throwable -> L66 Exception -> L68
        r9.write(r15);     // Catch: Throwable -> L66 Exception -> L68
        if (r12 == false) goto L28;
        copyChunksUpToGivenChunkType(r3, r9, WEBP_CHUNK_TYPE_ANIM, null);     // Catch: Throwable -> L66 Exception -> L68
    L24:
        byte[] r17 = new byte[4];     // Catch: Throwable -> L66 Exception -> L68
        r21.read(r17);     // Catch: Throwable -> L66 Exception -> L68
        if (Arrays.equals(r17, WEBP_CHUNK_TYPE_ANMF) == false) goto L26;
        copyWebPChunk(r3, r9, r17);     // Catch: Throwable -> L66 Exception -> L68
        goto L24
    L26:
        writeExifSegment(r9);     // Catch: Throwable -> L66 Exception -> L68
        goto L61
    L28:
        copyChunksUpToGivenChunkType(r3, r9, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);     // Catch: Throwable -> L66 Exception -> L68
        writeExifSegment(r9);     // Catch: Throwable -> L66 Exception -> L68
        goto L61
    L17:
        r14 = r13;
        goto L18
    L29:
        byte[] r18 = WEBP_CHUNK_TYPE_VP8;     // Catch: Throwable -> L66 Exception -> L68
        if (Arrays.equals(r7, r18) == false) goto L32;
    L33:
        int r19 = r3.readInt();     // Catch: Throwable -> L66 Exception -> L68
        if ((r19 % 2) != 1) goto L36;
        int r110 = r19 + 1;     // Catch: Throwable -> L66 Exception -> L68
    L37:
        byte[] r111 = new byte[3];     // Catch: Throwable -> L66 Exception -> L68
        if (Arrays.equals(r7, r18) == false) goto L47;
        r3.read(r111);     // Catch: Throwable -> L66 Exception -> L68
        byte[] r112 = new byte[3];     // Catch: Throwable -> L66 Exception -> L68
        if (r3.read(r112) != 3) goto L45;
        if (Arrays.equals(WEBP_VP8_SIGNATURE, r112) == false) goto L45;
        int r113 = r3.readInt();     // Catch: Throwable -> L66 Exception -> L68
        int r114 = (r113 << 18) >> 18;     // Catch: Throwable -> L66 Exception -> L68
        int r115 = (r113 << 2) >> 18;     // Catch: Throwable -> L66 Exception -> L68
        r110 = r110 - 10;     // Catch: Throwable -> L66 Exception -> L68
        int r116 = 0;
    L54:
        r9.write(r11);     // Catch: Throwable -> L66 Exception -> L68
        r9.writeInt(10);     // Catch: Throwable -> L66 Exception -> L68
        byte[] r20 = new byte[10];     // Catch: Throwable -> L66 Exception -> L68
        byte r23 = (byte) (r20[0] | 8);     // Catch: Throwable -> L66 Exception -> L68
        r20[0] = r23;     // Catch: Throwable -> L66 Exception -> L68
        r20[0] = (byte) (r23 | (r116 << 4));     // Catch: Throwable -> L66 Exception -> L68
        int r117 = r114 - 1;     // Catch: Throwable -> L66 Exception -> L68
        int r118 = r115 - 1;     // Catch: Throwable -> L66 Exception -> L68
        r20[4] = (byte) r117;     // Catch: Throwable -> L66 Exception -> L68
        r20[5] = (byte) (r117 >> 8);     // Catch: Throwable -> L66 Exception -> L68
        r20[6] = (byte) (r117 >> 16);     // Catch: Throwable -> L66 Exception -> L68
        r20[7] = (byte) r118;     // Catch: Throwable -> L66 Exception -> L68
        r20[8] = (byte) (r118 >> 8);     // Catch: Throwable -> L66 Exception -> L68
        r20[9] = (byte) (r118 >> 16);     // Catch: Throwable -> L66 Exception -> L68
        r9.write(r20);     // Catch: Throwable -> L66 Exception -> L68
        r9.write(r7);     // Catch: Throwable -> L66 Exception -> L68
        r9.writeInt(r19);     // Catch: Throwable -> L66 Exception -> L68
        if (Arrays.equals(r7, r18) == false) goto L58;
        r9.write(r111);     // Catch: Throwable -> L66 Exception -> L68
        r9.write(WEBP_VP8_SIGNATURE);     // Catch: Throwable -> L66 Exception -> L68
        r9.writeInt(r113);     // Catch: Throwable -> L66 Exception -> L68
    L60:
        ExifInterfaceUtils.copy(r3, r9, r110);     // Catch: Throwable -> L66 Exception -> L68
        writeExifSegment(r9);     // Catch: Throwable -> L66 Exception -> L68
        goto L61
    L58:
        if (Arrays.equals(r7, WEBP_CHUNK_TYPE_VP8L) == false) goto L60;
        r9.write(47);     // Catch: Throwable -> L66 Exception -> L68
        r9.writeInt(r113);     // Catch: Throwable -> L66 Exception -> L68
    L45:
        throw new IOException("Encountered error while checking VP8 signature");     // Catch: Throwable -> L66 Exception -> L68
    L47:
        if (Arrays.equals(r7, WEBP_CHUNK_TYPE_VP8L) == true) goto L49;
        r113 = 0;
        r114 = 0;
        r115 = 0;
        r116 = 0;
        goto L54
    L49:
        if (r3.readByte() != 47) goto L52;
        r113 = r3.readInt();     // Catch: Throwable -> L66 Exception -> L68
        r116 = r113 & 8;     // Catch: Throwable -> L66 Exception -> L68
        r110 = r110 - 5;     // Catch: Throwable -> L66 Exception -> L68
        r115 = ((r113 << 4) >> 18) + 1;     // Catch: Throwable -> L66 Exception -> L68
        r114 = ((r113 << 18) >> 18) + 1;     // Catch: Throwable -> L66 Exception -> L68
        goto L54
    L52:
        throw new IOException("Encountered error while checking VP8L signature");     // Catch: Throwable -> L66 Exception -> L68
    L36:
        r110 = r19;
        goto L37
    L32:
        if (Arrays.equals(r7, WEBP_CHUNK_TYPE_VP8L) == false) goto L61;
    L65:
        throw new IOException("Encountered invalid length while parsing WebP chunk type");     // Catch: Throwable -> L66 Exception -> L68
    L68:
        e = e;
    L74:
        throw new IOException("Failed to save WebP file", e);     // Catch: Throwable -> L70
    L66:
        th = th;
        r6 = r8;
    L75:
        ExifInterfaceUtils.closeQuietly(r6);
        throw th;
    L70:
        th = th;
    L72:
        e = e;
        goto L74
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream r4, ByteOrderedDataOutputStream r5, byte[] r6, byte[] r7) throws IOException {
    L2:
        byte[] r1 = new byte[4];
        if (r4.read(r1) != 4) goto L4;
        copyWebPChunk(r4, r5, r1);
        if (Arrays.equals(r1, r6) == true) goto L15;
        if (r7 == null) goto L2;
        if (Arrays.equals(r1, r7) == false) goto L2;
        return;
    L15:
        return;
    L4:
        StringBuilder r8 = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
        Charset r0 = ASCII;
        StringBuilder r9 = r8.append(new String(r6, r0));
        if (r7 != null) goto L7;
        String r10 = "";
    L9:
        throw new IOException(r9.append(r10).toString());
    L7:
        r10 = " or ".concat(new String(r7, r0));
        goto L9
    }

    private void copyWebPChunk(ByteOrderedDataInputStream r2, ByteOrderedDataOutputStream r3, byte[] r4) throws IOException {
        int r1 = r2.readInt();
        r3.write(r4);
        r3.writeInt(r1);
        if ((r1 % 2) != 1) goto L5;
        r1 = r1 + 1;
    L5:
        ExifInterfaceUtils.copy(r2, r3, r1);
    }

    private void readExifSegment(byte[] r2, int r3) throws IOException {
        SeekableByteOrderedDataInputStream r0 = new SeekableByteOrderedDataInputStream(r2);
        parseTiffHeaders(r0);
        readImageFileDirectory(r0, r3);
    }

    private void addDefaultValuesForCompatibility() {
        String r0 = getAttribute(TAG_DATETIME_ORIGINAL);
        if (r0 == null) goto L8;
        if (getAttribute(TAG_DATETIME) != null) goto L8;
        this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(r0));
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

    private ByteOrder readByteOrder(ByteOrderedDataInputStream r3) throws IOException {
        short r2 = r3.readShort();
        if (r2 == 18761) goto L14;
        if (r2 != 19789) goto L12;
        if (DEBUG == false) goto L10;
        Log.d(TAG, "readExifSegment: Byte Align MM");
    L10:
        return ByteOrder.BIG_ENDIAN;
    L12:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r2));
    L14:
        if (DEBUG == false) goto L17;
        Log.d(TAG, "readExifSegment: Byte Align II");
    L17:
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream r3) throws IOException {
        ByteOrder r0 = readByteOrder(r3);
        this.mExifByteOrder = r0;
        r3.setByteOrder(r0);
        int r1 = r3.readUnsignedShort();
        int r2 = this.mMimeType;
        if (r2 != 7) goto L5;
    L11:
        int r4 = r3.readInt();
        if (r4 < 8) goto L18;
        int r5 = r4 - 8;
        if (r5 <= 0) goto L19;
        r3.skipFully(r5);
        return;
    L19:
        return;
    L18:
        throw new IOException("Invalid first Ifd offset: " + r4);
    L5:
        if (r2 == 10) goto L11;
        if (r1 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r1));
    }

    private void readImageFileDirectory(SeekableByteOrderedDataInputStream r30, int r31) throws IOException {
        this.mAttributesOffsets.add(Integer.valueOf(r30.mPosition));
        short r3 = r30.readShort();
        boolean r4 = DEBUG;
        String r5 = TAG;
        if (r4 == false) goto L5;
        Log.d(TAG, "numberOfDirectoryEntry: " + r3);
    L5:
        if (r3 > 0) goto L7;
        return;
    L7:
        char r6 = 0;
        short r7 = 0;
    L9:
        if (r7 >= r3) goto L117;
        int r12 = r30.readUnsignedShort();
        int r13 = r30.readUnsignedShort();
        int r15 = r30.readInt();
        long r8 = ((long) r30.position()) + 4;
        ExifTag r11 = sExifTagMapsForReading[r31].get(Integer.valueOf(r12));
        boolean r14 = DEBUG;
        if (r14 == false) goto L18;
        Object[] r9 = new Object[5];
        r9[r6] = Integer.valueOf(r31);
        r9[1] = Integer.valueOf(r12);
        if (r11 == null) goto L15;
        String r10 = r11.name;
    L16:
        r9[2] = r10;
        r9[3] = Integer.valueOf(r13);
        r9[4] = Integer.valueOf(r15);
        Log.d(r5, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", r9));
        goto L18
    L15:
        r10 = null;
    L18:
        if (r11 != null) goto L22;
        if (r14 == false) goto L21;
        Log.d(r5, "Skip the tag entry since tag number is not defined: " + r12);
    L21:
        String r16 = r5;
        short r25 = r7;
    L43:
        long r17 = 0;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == true) goto L48;
        r30.seek(r8);
        r3 = r3;
        String r19 = r16;
    L116:
        r7 = (short) (r25 + 1);
        r5 = r19;
        r3 = r3;
        r6 = 0;
        goto L9
    L48:
        if (r17 <= 4) goto L65;
        int r20 = r30.readInt();
        if (r14 == false) goto L54;
        Log.d(r16, "seek to data offset: " + r20);
    L54:
        if (this.mMimeType != 7) goto L64;
        if (TAG_MAKER_NOTE.equals(r11.name) == false) goto L59;
        this.mOrfMakerNoteOffset = r20;
        goto L64
    L59:
        if (r31 != 6) goto L64;
        if (TAG_ORF_THUMBNAIL_IMAGE.equals(r11.name) == false) goto L64;
        this.mOrfThumbnailOffset = r20;
        this.mOrfThumbnailLength = r15;
        ExifAttribute r21 = ExifAttribute.createUShort(6, this.mExifByteOrder);
        ExifAttribute r22 = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
        ExifAttribute r23 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
        this.mAttributes[4].put(TAG_COMPRESSION, r21);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, r22);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r23);
    L64:
        r30.seek(r20);
    L66:
        Integer r24 = sExifPointerTagMap.get(Integer.valueOf(r12));
        if (r14 == false) goto L69;
        r19 = r16;
        Log.d(r19, "nextIfdType: " + r24 + " byteCount: " + r17);
    L71:
        if (r24 != null) goto L73;
        long r26 = r8;
        int r27 = r30.position() + this.mOffsetToExifData;
        byte[] r28 = new byte[(int) r17];
        r30.readFully(r28);
        ExifAttribute r29 = new ExifAttribute(r13, r15, r27, r28);
        this.mAttributes[r31].put(r11.name, r29);
        if (TAG_DNG_VERSION.equals(r11.name) == false) goto L103;
        this.mMimeType = 3;
    L103:
        if (TAG_MAKE.equals(r11.name) == true) goto L107;
        if (TAG_MODEL.equals(r11.name) == true) goto L107;
    L109:
        if (TAG_COMPRESSION.equals(r11.name) == false) goto L114;
        if (r29.getIntValue(this.mExifByteOrder) != 65535) goto L114;
    L112:
        this.mMimeType = 8;
    L114:
        if (r30.position() == r26) goto L116;
        r30.seek(r26);
    L107:
        if (r29.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE) == true) goto L112;
    L73:
        if (r13 != 3) goto L75;
        int r32 = r30.readUnsignedShort();
    L86:
        long r33 = r32;
    L87:
        if (r14 == false) goto L90;
        Log.d(r19, String.format("Offset: %d, tagName: %s", new Object[]{Long.valueOf(r33), r11.name}));
    L90:
        if (r33 > 0) goto L92;
        if (r14 == false) goto L98;
        Log.d(r19, "Skip jump into the IFD since its offset is invalid: " + r33);
    L98:
        r30.seek(r8);
        goto L116
    L92:
        if (this.mAttributesOffsets.contains(Integer.valueOf((int) r33)) == true) goto L94;
        r30.seek(r33);
        readImageFileDirectory(r30, r24.intValue());
        goto L98
    L94:
        if (r14 == false) goto L98;
        Log.d(r19, "Skip jump into the IFD since it has already been read: IfdType " + r24 + " (at " + r33 + ")");
        goto L98
    L75:
        if (r13 == 4) goto L84;
        if (r13 != 8) goto L78;
        r32 = r30.readShort();
        goto L86
    L78:
        if (r13 != 9) goto L80;
    L82:
        r32 = r30.readInt();
        goto L86
    L80:
        if (r13 == 13) goto L82;
        r33 = -1;
        goto L87
    L84:
        r33 = r30.readUnsignedInt();
        goto L87
    L69:
        r19 = r16;
        goto L71
    L65:
        r8 = r8;
        r16 = r16;
        r15 = r15;
        goto L66
    L22:
        if (r13 <= 0) goto L40;
        int[] r34 = IFD_FORMAT_BYTES_PER_FORMAT;
        if (r13 >= r34.length) goto L40;
        if (r11.isFormatCompatible(r13) == true) goto L30;
        if (r14 == false) goto L21;
        Log.d(r5, "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[r13] + ") is unexpected for tag: " + r11.name);
        goto L21
    L30:
        if (r13 != 7) goto L32;
        r13 = r11.primaryFormat;
    L32:
        r16 = r5;
        r25 = r7;
        r17 = ((long) r15) * ((long) r34[r13]);
        if (r17 >= 0) goto L35;
    L38:
        if (r14 == false) goto L44;
        Log.d(r16, "Skip the tag entry since the number of components is invalid: " + r15);
        goto L44
    L35:
        if (r17 > 2147483647L) goto L38;
        r18 = true;
    L40:
        r16 = r5;
        r25 = r7;
        if (r14 == false) goto L43;
        Log.d(r16, "Skip the tag entry since data format is invalid: " + r13);
        goto L43
    L117:
        String r35 = r5;
        int r2 = r30.readInt();
        boolean r36 = DEBUG;
        if (r36 == false) goto L120;
        Log.d(r35, String.format("nextIfdOffset: %d", new Object[]{Integer.valueOf(r2)}));
    L120:
        long r37 = r2;
        if (r37 > 0) goto L123;
        if (r36 == false) goto L145;
        Log.d(r35, "Stop reading file since a wrong offset may cause an infinite loop: " + r2);
        return;
    L145:
        return;
    L123:
        if (this.mAttributesOffsets.contains(Integer.valueOf(r2)) == true) goto L130;
        r30.seek(r37);
        if (this.mAttributes[4].isEmpty() == false) goto L128;
        readImageFileDirectory(r30, 4);
        return;
    L128:
        if (this.mAttributes[5].isEmpty() == false) goto L141;
        readImageFileDirectory(r30, 5);
        return;
    L141:
        return;
    L130:
        if (r36 == false) goto L143;
        Log.d(r35, "Stop reading file since re-reading an IFD may cause an infinite loop: " + r2);
        return;
    }

    private void retrieveJpegImageSize(SeekableByteOrderedDataInputStream r5, int r6) throws IOException {
        ExifAttribute r0 = this.mAttributes[r6].get(TAG_IMAGE_LENGTH);
        ExifAttribute r1 = this.mAttributes[r6].get(TAG_IMAGE_WIDTH);
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return;
    L5:
        ExifAttribute r2 = this.mAttributes[r6].get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute r3 = this.mAttributes[r6].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r2 == null) goto L11;
        if (r3 == null) goto L12;
        int r4 = r2.getIntValue(this.mExifByteOrder);
        int r7 = r2.getIntValue(this.mExifByteOrder);
        r5.seek(r4);
        byte[] r8 = new byte[r7];
        r5.read(r8);
        getJpegAttributes(new ByteOrderedDataInputStream(r8), r4, r6);
        return;
    L12:
        return;
    }

    private void setThumbnailData(ByteOrderedDataInputStream r5) throws IOException {
        HashMap<String, ExifAttribute> r0 = this.mAttributes[4];
        ExifAttribute r1 = r0.get(TAG_COMPRESSION);
        if (r1 == null) goto L14;
        int r2 = r1.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = r2;
        if (r2 == 1) goto L12;
        if (r2 != 6) goto L8;
        handleThumbnailFromJfif(r5, r0);
        return;
    L8:
        if (r2 == 7) goto L12;
        return;
    L12:
        if (isSupportedDataType(r0) == false) goto L17;
        handleThumbnailFromStrips(r5, r0);
        return;
    L17:
        return;
    L14:
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(r5, r0);
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream r5, HashMap r6) throws IOException {
        ExifAttribute r0 = (ExifAttribute) r6.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute r7 = (ExifAttribute) r6.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r0 == null) goto L22;
        if (r7 == null) goto L23;
        int r1 = r0.getIntValue(this.mExifByteOrder);
        int r8 = r7.getIntValue(this.mExifByteOrder);
        if (this.mMimeType != 7) goto L8;
        r1 = r1 + this.mOrfMakerNoteOffset;
    L8:
        if (r1 <= 0) goto L19;
        if (r8 <= 0) goto L19;
        this.mHasThumbnail = true;
        if (this.mFilename == null) goto L13;
    L17:
        this.mThumbnailOffset = r1;
        this.mThumbnailLength = r8;
        goto L19
    L13:
        if (this.mAssetInputStream != null) goto L17;
        if (this.mSeekableFileDescriptor != null) goto L17;
        byte[] r2 = new byte[r8];
        r5.skip(r1);
        r5.read(r2);
        this.mThumbnailBytes = r2;
    L19:
        if (DEBUG == false) goto L24;
        Log.d(TAG, "Setting thumbnail attributes with offset: " + r1 + ", length: " + r8);
        return;
    L24:
        return;
    L23:
        return;
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream r19, HashMap r20) throws IOException {
        ExifAttribute r3 = (ExifAttribute) r20.get(TAG_STRIP_OFFSETS);
        ExifAttribute r2 = (ExifAttribute) r20.get(TAG_STRIP_BYTE_COUNTS);
        if (r3 == null) goto L54;
        if (r2 == null) goto L55;
        long[] r4 = ExifInterfaceUtils.convertToLongArray(r3.getValue(this.mExifByteOrder));
        long[] r5 = ExifInterfaceUtils.convertToLongArray(r2.getValue(this.mExifByteOrder));
        if (r4 != null) goto L8;
    L47:
        Log.w(TAG, "stripOffsets should not be null or have zero length.");
        return;
    L8:
        if (r4.length == 0) goto L47;
        if (r5 != null) goto L12;
    L45:
        Log.w(TAG, "stripByteCounts should not be null or have zero length.");
        return;
    L12:
        if (r5.length == 0) goto L45;
        if (r4.length == r5.length) goto L18;
        Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
        return;
    L18:
        int r6 = r5.length;
        long r7 = 0;
        int r9 = 0;
    L19:
        if (r9 >= r6) goto L21;
        r7 = r7 + r5[r9];
        r9 = r9 + 1;
        goto L19
    L21:
        int r8 = (int) r7;
        byte[] r10 = new byte[r8];
        this.mAreThumbnailStripsConsecutive = true;
        this.mHasThumbnailStrips = true;
        this.mHasThumbnail = true;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L23:
        if (r11 >= r4.length) goto L42;
        int r14 = (int) r4[r11];
        int r15 = (int) r5[r11];
        if (r11 < (r4.length - 1)) goto L27;
    L29:
        int r16 = r14 - r12;
        if (r16 < 0) goto L31;
        long r17 = r16;
        if (r19.skip(r17) != r17) goto L35;
        int r18 = r12 + r16;
        byte[] r110 = new byte[r15];
        if (r19.read(r110) != r15) goto L39;
        r12 = r18 + r15;
        System.arraycopy(r110, 0, r10, r13, r15);
        r13 = r13 + r15;
        r11 = r11 + 1;
        goto L23
    L39:
        Log.d(TAG, "Failed to read " + r15 + " bytes.");
        return;
    L35:
        Log.d(TAG, "Failed to skip " + r16 + " bytes.");
        return;
    L31:
        Log.d(TAG, "Invalid strip offset value");
        return;
    L27:
        if ((r14 + r15) == r4[r11 + 1]) goto L29;
        this.mAreThumbnailStripsConsecutive = false;
        goto L29
    L42:
        this.mThumbnailBytes = r10;
        if (this.mAreThumbnailStripsConsecutive == false) goto L56;
        this.mThumbnailOffset = (int) r4[0];
        this.mThumbnailLength = r8;
        return;
    L56:
        return;
    L55:
        return;
    }

    private boolean isSupportedDataType(HashMap r6) throws IOException {
        ExifAttribute r0 = (ExifAttribute) r6.get(TAG_BITS_PER_SAMPLE);
        if (r0 == null) goto L21;
        int[] r1 = (int[]) r0.getValue(this.mExifByteOrder);
        int[] r2 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(r2, r1) == false) goto L8;
        return true;
    L8:
        if (this.mMimeType != 3) goto L21;
        ExifAttribute r7 = (ExifAttribute) r6.get(TAG_PHOTOMETRIC_INTERPRETATION);
        if (r7 == null) goto L21;
        int r5 = r7.getIntValue(this.mExifByteOrder);
        if (r5 != 1) goto L16;
        if (Arrays.equals(r1, BITS_PER_SAMPLE_GREYSCALE_2) == false) goto L16;
    L19:
        return true;
    L16:
        if (r5 != 6) goto L21;
        if (Arrays.equals(r1, r2) == true) goto L19;
    L21:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "Unsupported data type value");
        return false;
    L25:
        return false;
    }

    private boolean isThumbnail(HashMap r3) throws IOException {
        ExifAttribute r0 = (ExifAttribute) r3.get(TAG_IMAGE_LENGTH);
        ExifAttribute r4 = (ExifAttribute) r3.get(TAG_IMAGE_WIDTH);
        if (r0 == null) goto L10;
        if (r4 == null) goto L12;
        int r1 = r0.getIntValue(this.mExifByteOrder);
        int r2 = r4.getIntValue(this.mExifByteOrder);
        if (r1 > 512) goto L13;
        if (r2 > 512) goto L14;
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

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute r3 = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute r4 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r3);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r4);
    L7:
        if (this.mAttributes[4].isEmpty() == false) goto L12;
        if (isThumbnail(this.mAttributes[5]) == false) goto L12;
        HashMap<String, ExifAttribute>[] r5 = this.mAttributes;
        r5[4] = r5[5];
        r5[5] = new HashMap();
    L12:
        if (isThumbnail(this.mAttributes[4]) == true) goto L14;
        Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
    L14:
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private void updateImageSizeValues(SeekableByteOrderedDataInputStream r10, int r11) throws IOException {
        ExifAttribute r0 = this.mAttributes[r11].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute r1 = this.mAttributes[r11].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute r2 = this.mAttributes[r11].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute r3 = this.mAttributes[r11].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute r4 = this.mAttributes[r11].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (r0 != null) goto L5;
        if (r1 == null) goto L31;
        if (r2 == null) goto L31;
        if (r3 == null) goto L31;
        if (r4 == null) goto L31;
        int r12 = r1.getIntValue(this.mExifByteOrder);
        int r5 = r3.getIntValue(this.mExifByteOrder);
        int r6 = r4.getIntValue(this.mExifByteOrder);
        int r7 = r2.getIntValue(this.mExifByteOrder);
        if (r5 <= r12) goto L34;
        if (r6 <= r7) goto L35;
        ExifAttribute r13 = ExifAttribute.createUShort(r5 - r12, this.mExifByteOrder);
        ExifAttribute r8 = ExifAttribute.createUShort(r6 - r7, this.mExifByteOrder);
        this.mAttributes[r11].put(TAG_IMAGE_LENGTH, r13);
        this.mAttributes[r11].put(TAG_IMAGE_WIDTH, r8);
        return;
    L35:
        return;
    L34:
        return;
    L31:
        retrieveJpegImageSize(r10, r11);
        return;
    L5:
        if (r0.format != 5) goto L14;
        Rational[] r14 = (Rational[]) r0.getValue(this.mExifByteOrder);
        if (r14 != null) goto L9;
    L12:
        Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r14));
        return;
    L9:
        if (r14.length != 2) goto L12;
        ExifAttribute r9 = ExifAttribute.createURational(r14[0], this.mExifByteOrder);
        ExifAttribute r15 = ExifAttribute.createURational(r14[1], this.mExifByteOrder);
    L20:
        this.mAttributes[r11].put(TAG_IMAGE_WIDTH, r9);
        this.mAttributes[r11].put(TAG_IMAGE_LENGTH, r15);
        return;
    L14:
        int[] r16 = (int[]) r0.getValue(this.mExifByteOrder);
        if (r16 != null) goto L17;
    L21:
        Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r16));
        return;
    L17:
        if (r16.length != 2) goto L21;
        r9 = ExifAttribute.createUShort(r16[0], this.mExifByteOrder);
        r15 = ExifAttribute.createUShort(r16[1], this.mExifByteOrder);
        goto L20
    }

    private int writeExifSegment(ByteOrderedDataOutputStream r17) throws IOException {
        ExifTag[][] r2 = EXIF_TAGS;
        int[] r3 = new int[r2.length];
        int[] r4 = new int[r2.length];
        ExifTag[] r5 = EXIF_POINTER_TAGS;
        int r6 = r5.length;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L6;
        removeAttribute(r5[r7].name);
        r7 = r7 + 1;
        goto L3
    L6:
        if (this.mHasThumbnail == true) goto L8;
    L11:
        int r8 = 0;
    L13:
        if (r8 >= EXIF_TAGS.length) goto L22;
        Object[] r10 = this.mAttributes[r8].entrySet().toArray();
        int r11 = r10.length;
        int r12 = 0;
    L15:
        if (r12 >= r11) goto L20;
        Map.Entry r13 = (Map.Entry) r10[r12];
        if (r13.getValue() != null) goto L19;
        this.mAttributes[r8].remove(r13.getKey());
    L19:
        r12 = r12 + 1;
        goto L15
    L20:
        r8 = r8 + 1;
        goto L13
    L22:
        if (this.mAttributes[1].isEmpty() == true) goto L25;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L25:
        if (this.mAttributes[2].isEmpty() == true) goto L28;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L28:
        if (this.mAttributes[3].isEmpty() == true) goto L31;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L31:
        if (this.mHasThumbnail == true) goto L33;
    L36:
        int r9 = 0;
    L38:
        if (r9 >= EXIF_TAGS.length) goto L46;
        Iterator<Map.Entry<String, ExifAttribute>> r14 = this.mAttributes[r9].entrySet().iterator();
        int r15 = 0;
    L41:
        if (r14.hasNext() == false) goto L45;
        int r16 = r14.next().getValue().size();
        if (r16 <= 4) goto L41;
        r15 = r15 + r16;
        goto L41
    L45:
        r4[r9] = r4[r9] + r15;
        r9 = r9 + 1;
        goto L38
    L46:
        int r18 = 8;
        int r19 = 0;
    L48:
        if (r19 >= EXIF_TAGS.length) goto L54;
        if (this.mAttributes[r19].isEmpty() == true) goto L52;
        r3[r19] = r18;
        r18 = r18 + ((((this.mAttributes[r19].size() * 12) + 2) + 4) + r4[r19]);
    L52:
        r19 = r19 + 1;
        goto L48
    L54:
        if (this.mHasThumbnail == false) goto L61;
        if (this.mHasThumbnailStrips == false) goto L58;
        this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(r18, this.mExifByteOrder));
    L59:
        this.mThumbnailOffset = r18;
        r18 = r18 + this.mThumbnailLength;
        goto L61
    L58:
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong(r18, this.mExifByteOrder));
    L61:
        if (this.mMimeType != 4) goto L64;
        r18 = r18 + 8;
    L64:
        if (DEBUG == false) goto L70;
        int r20 = 0;
    L67:
        if (r20 >= EXIF_TAGS.length) goto L70;
        Log.d(TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(r20), Integer.valueOf(r3[r20]), Integer.valueOf(this.mAttributes[r20].size()), Integer.valueOf(r4[r20]), Integer.valueOf(r18)}));
        r20 = r20 + 1;
    L70:
        if (this.mAttributes[1].isEmpty() == true) goto L73;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(r3[1], this.mExifByteOrder));
    L73:
        if (this.mAttributes[2].isEmpty() == true) goto L76;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(r3[2], this.mExifByteOrder));
    L76:
        if (this.mAttributes[3].isEmpty() == true) goto L78;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(r3[3], this.mExifByteOrder));
    L78:
        int r21 = this.mMimeType;
        if (r21 != 4) goto L81;
        r17.writeUnsignedShort(r18);
        r17.write(IDENTIFIER_EXIF_APP1);
    L88:
        if (this.mExifByteOrder != ByteOrder.BIG_ENDIAN) goto L90;
        short r22 = BYTE_ALIGN_MM;
    L91:
        r17.writeShort(r22);
        r17.setByteOrder(this.mExifByteOrder);
        r17.writeUnsignedShort(42);
        r17.writeUnsignedInt(8);
        int r23 = 0;
    L93:
        if (r23 >= EXIF_TAGS.length) goto L121;
        if (this.mAttributes[r23].isEmpty() == true) goto L119;
        r17.writeUnsignedShort(this.mAttributes[r23].size());
        int r24 = ((r3[r23] + 2) + (this.mAttributes[r23].size() * 12)) + 4;
        Iterator<Map.Entry<String, ExifAttribute>> r25 = this.mAttributes[r23].entrySet().iterator();
    L98:
        if (r25.hasNext() == false) goto L107;
        Map.Entry<String, ExifAttribute> r26 = r25.next();
        int r110 = sExifTagMapsForWriting[r23].get(r26.getKey()).number;
        ExifAttribute r27 = r26.getValue();
        int r111 = r27.size();
        r17.writeUnsignedShort(r110);
        r17.writeUnsignedShort(r27.format);
        r17.writeInt(r27.numberOfComponents);
        if (r111 <= 4) goto L102;
        r17.writeUnsignedInt(r24);
        r24 = r24 + r111;
        goto L98
    L102:
        r17.write(r27.bytes);
        if (r111 >= 4) goto L98;
    L104:
        if (r111 >= 4) goto L98;
        r17.writeByte(0);
        r111 = r111 + 1;
        goto L104
    L107:
        if (r23 == 0) goto L109;
    L111:
        r17.writeUnsignedInt(0);
    L112:
        Iterator<Map.Entry<String, ExifAttribute>> r28 = this.mAttributes[r23].entrySet().iterator();
    L114:
        if (r28.hasNext() == false) goto L119;
        ExifAttribute r112 = r28.next().getValue();
        if (r112.bytes.length <= 4) goto L114;
        r17.write(r112.bytes, 0, r112.bytes.length);
        goto L114
    L109:
        if (this.mAttributes[4].isEmpty() == true) goto L111;
        r17.writeUnsignedInt(r3[4]);
    L119:
        r23 = r23 + 1;
        goto L93
    L121:
        if (this.mHasThumbnail == false) goto L124;
        r17.write(getThumbnailBytes());
    L124:
        if (this.mMimeType == 14) goto L126;
    L128:
        r17.setByteOrder(ByteOrder.BIG_ENDIAN);
        return r18;
    L126:
        if ((r18 % 2) != 1) goto L128;
        r17.writeByte(0);
        goto L128
    L90:
        r22 = BYTE_ALIGN_II;
        goto L91
    L81:
        if (r21 == 13) goto L85;
        if (r21 != 14) goto L88;
        r17.write(WEBP_CHUNK_TYPE_EXIF);
        r17.writeInt(r18);
        goto L88
    L85:
        r17.writeInt(r18);
        r17.write(PNG_CHUNK_TYPE_EXIF);
        goto L88
    L33:
        if (this.mHasThumbnailStrips == false) goto L35;
        this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(0, this.mExifByteOrder));
        this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
        goto L36
    L35:
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong(0, this.mExifByteOrder));
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
        goto L36
    L8:
        if (this.mHasThumbnailStrips == false) goto L10;
        removeAttribute(TAG_STRIP_OFFSETS);
        removeAttribute(TAG_STRIP_BYTE_COUNTS);
        goto L11
    L10:
        removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
        removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        goto L11
    }

    private static Pair<Integer, Integer> guessDataFormat(String r12) {
        int r3 = 1;
        if (r12.contains(SimContactsConstants.EMAIL_SEP) == false) goto L35;
        String[] r13 = r12.split(SimContactsConstants.EMAIL_SEP, -1);
        Pair<Integer, Integer> r0 = guessDataFormat(r13[0]);
        if (((Integer) r0.first).intValue() != 2) goto L8;
        return r0;
    L8:
        if (r3 >= r13.length) goto L33;
        Pair<Integer, Integer> r1 = guessDataFormat(r13[r3]);
        if (((Integer) r1.first).equals(r0.first) == false) goto L12;
    L15:
        int r2 = ((Integer) r0.first).intValue();
    L17:
        if (((Integer) r0.second).intValue() != (-1)) goto L19;
    L23:
        int r4 = -1;
    L24:
        if (r2 != (-1)) goto L28;
        if (r4 != (-1)) goto L28;
        return new Pair(2, -1);
    L28:
        if (r2 != (-1)) goto L30;
        r0 = new Pair(Integer.valueOf(r4), -1);
    L32:
        r3 = r3 + 1;
        goto L8
    L30:
        if (r4 != (-1)) goto L32;
        r0 = new Pair(Integer.valueOf(r2), -1);
        goto L32
    L19:
        if (((Integer) r1.first).equals(r0.second) == false) goto L21;
    L22:
        r4 = ((Integer) r0.second).intValue();
        goto L24
    L21:
        if (((Integer) r1.second).equals(r0.second) == false) goto L23;
    L12:
        if (((Integer) r1.second).equals(r0.first) == true) goto L15;
        r2 = -1;
        goto L17
    L33:
        return r0;
    L35:
        if (r12.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L73;
        String[] r14 = r12.split(LibrarianImpl.Constants.SEPARATOR, -1);
        if (r14.length != 2) goto L55;
        long r5 = (long) Double.parseDouble(r14[0]);     // Catch: NumberFormatException -> L72
        long r6 = (long) Double.parseDouble(r14[1]);     // Catch: NumberFormatException -> L72
        if (r5 < 0) goto L53;
        if (r6 < 0) goto L53;
        if (r5 > 2147483647L) goto L51;
        if (r6 > 2147483647L) goto L51;
        return new Pair(10, 5);
    L51:
        return new Pair(5, -1);
    L53:
        return new Pair(10, -1);
    L55:
        return new Pair(2, -1);
    L73:
        Long r7 = Long.valueOf(Long.parseLong(r12));     // Catch: NumberFormatException -> L68
        if (r7.longValue() < 0) goto L63;
        if (r7.longValue() > 65535) goto L63;
        return new Pair(3, 4);
    L63:
        if (r7.longValue() >= 0) goto L67;
        return new Pair(9, -1);
    L67:
        return new Pair(4, -1);
    L68:
        Double.parseDouble(r12);     // Catch: NumberFormatException -> L70
        return new Pair(12, -1);
    L71:
        return new Pair(2, -1);
    }

    private void swapBasedOnImageSize(int r7, int r8) throws IOException {
        if (this.mAttributes[r7].isEmpty() == true) goto L26;
        if (this.mAttributes[r8].isEmpty() == true) goto L26;
        ExifAttribute r0 = this.mAttributes[r7].get(TAG_IMAGE_LENGTH);
        ExifAttribute r3 = this.mAttributes[r7].get(TAG_IMAGE_WIDTH);
        ExifAttribute r2 = this.mAttributes[r8].get(TAG_IMAGE_LENGTH);
        ExifAttribute r4 = this.mAttributes[r8].get(TAG_IMAGE_WIDTH);
        if (r0 == null) goto L22;
        if (r3 == null) goto L22;
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r1 = r0.getIntValue(this.mExifByteOrder);
        int r5 = r3.getIntValue(this.mExifByteOrder);
        int r6 = r2.getIntValue(this.mExifByteOrder);
        int r9 = r4.getIntValue(this.mExifByteOrder);
        if (r1 >= r6) goto L29;
        if (r5 >= r9) goto L30;
        HashMap<String, ExifAttribute>[] r10 = this.mAttributes;
        HashMap<String, ExifAttribute> r11 = r10[r7];
        r10[r7] = r10[r8];
        r10[r8] = r11;
        return;
    L30:
        return;
    L29:
        return;
    L19:
        if (DEBUG == false) goto L32;
        Log.d(TAG, "Second image does not contain valid size information");
        return;
    L32:
        return;
    L22:
        if (DEBUG == false) goto L34;
        Log.d(TAG, "First image does not contain valid size information");
        return;
    L34:
        return;
    L26:
        if (DEBUG == false) goto L35;
        Log.d(TAG, "Cannot perform swap since only one image data exists");
        return;
    }

    private void replaceInvalidTags(int r3, String r4, String r5) {
        if (this.mAttributes[r3].isEmpty() == false) goto L5;
        return;
    L5:
        if (this.mAttributes[r3].get(r4) == null) goto L9;
        HashMap<String, ExifAttribute> r0 = this.mAttributes[r3];
        r0.put(r5, r0.get(r4));
        this.mAttributes[r3].remove(r4);
        return;
    }
}
