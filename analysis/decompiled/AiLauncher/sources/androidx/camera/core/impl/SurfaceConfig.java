package androidx.camera.core.impl;

import K.C0;
import Z8.C1174w;
import Z8.Q;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0004\u001b)*+B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010(\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010\u0018¨\u0006,"}, d2 = {"Landroidx/camera/core/impl/SurfaceConfig;", "", "Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "configType", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "configSize", "Landroidx/camera/core/impl/StreamUseCase;", "streamUseCase", "<init>", "(Landroidx/camera/core/impl/SurfaceConfig$ConfigType;Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;Landroidx/camera/core/impl/StreamUseCase;)V", "other", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/SurfaceConfig;)Z", "LK/C0;", "definition", "Landroid/util/Size;", "e", "(LK/C0;)Landroid/util/Size;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "getConfigType", "()Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "c", "()Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "Landroidx/camera/core/impl/StreamUseCase;", "f", "()Landroidx/camera/core/impl/StreamUseCase;", Const.INTENT_KEY_UMID, "I", "imageFormat", "ConfigType", "ConfigSource", "ConfigSize", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurfaceConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final StreamUseCase f11362f = StreamUseCase.DEFAULT;

    /* renamed from: g, reason: collision with root package name */
    public static final ConfigSize[] f11363g = {ConfigSize.S720P_16_9, ConfigSize.S1080P_4_3, ConfigSize.S1080P_16_9, ConfigSize.S1440P_16_9, ConfigSize.UHD, ConfigSize.X_VGA};

    /* renamed from: h, reason: collision with root package name */
    public static final Map<ConfigType, Integer> f11364h;

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Integer, ConfigType> f11365i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ConfigType configType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ConfigSize configSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final StreamUseCase streamUseCase;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int imageFormat;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "", "id", "", "relatedFixedSize", "Landroid/util/Size;", "<init>", "(Ljava/lang/String;IILandroid/util/Size;)V", "getId", "()I", "getRelatedFixedSize", "()Landroid/util/Size;", "VGA", "X_VGA", "S720P_16_9", "PREVIEW", "S1080P_4_3", "S1080P_16_9", "S1440P_4_3", "S1440P_16_9", "UHD", "RECORD", "MAXIMUM", "MAXIMUM_4_3", "MAXIMUM_16_9", "ULTRA_MAXIMUM", "NOT_SUPPORT", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigSize {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ConfigSize[] $VALUES;
        public static final ConfigSize PREVIEW;
        public static final ConfigSize RECORD;
        private final int id;
        private final Size relatedFixedSize;
        public static final ConfigSize VGA = new ConfigSize("VGA", 0, 0, new Size(640, 480));
        public static final ConfigSize X_VGA = new ConfigSize("X_VGA", 1, 1, new Size(1024, 768));
        public static final ConfigSize S720P_16_9 = new ConfigSize("S720P_16_9", 2, 2, new Size(1280, 720));
        public static final ConfigSize S1080P_4_3 = new ConfigSize("S1080P_4_3", 4, 4, new Size(1440, 1080));
        public static final ConfigSize S1080P_16_9 = new ConfigSize("S1080P_16_9", 5, 5, new Size(1920, 1080));
        public static final ConfigSize S1440P_4_3 = new ConfigSize("S1440P_4_3", 6, 6, new Size(1920, 1440));
        public static final ConfigSize S1440P_16_9 = new ConfigSize("S1440P_16_9", 7, 7, new Size(2560, 1440));
        public static final ConfigSize UHD = new ConfigSize("UHD", 8, 8, new Size(3840, 2160));
        public static final ConfigSize MAXIMUM = new ConfigSize("MAXIMUM", 10, 10, null, 2, null);
        public static final ConfigSize MAXIMUM_4_3 = new ConfigSize("MAXIMUM_4_3", 11, 11, null, 2, null);
        public static final ConfigSize MAXIMUM_16_9 = new ConfigSize("MAXIMUM_16_9", 12, 12, null, 2, null);
        public static final ConfigSize ULTRA_MAXIMUM = new ConfigSize("ULTRA_MAXIMUM", 13, 13, null, 2, null);
        public static final ConfigSize NOT_SUPPORT = new ConfigSize("NOT_SUPPORT", 14, 14, null, 2, null);

        private static final /* synthetic */ ConfigSize[] $values() {
            return new ConfigSize[]{VGA, X_VGA, S720P_16_9, PREVIEW, S1080P_4_3, S1080P_16_9, S1440P_4_3, S1440P_16_9, UHD, RECORD, MAXIMUM, MAXIMUM_4_3, MAXIMUM_16_9, ULTRA_MAXIMUM, NOT_SUPPORT};
        }

        static {
            int i10 = 2;
            kotlin.jvm.internal.i iVar = null;
            Size size = null;
            PREVIEW = new ConfigSize("PREVIEW", 3, 3, size, i10, iVar);
            RECORD = new ConfigSize("RECORD", 9, 9, size, i10, iVar);
            ConfigSize[] configSizeArr$values = $values();
            $VALUES = configSizeArr$values;
            $ENTRIES = kotlin.enums.a.a(configSizeArr$values);
        }

        private ConfigSize(String str, int i10, int i11, Size size) {
            this.id = i11;
            this.relatedFixedSize = size;
        }

        public static InterfaceC4149a<ConfigSize> getEntries() {
            return $ENTRIES;
        }

        public static ConfigSize valueOf(String str) {
            return (ConfigSize) Enum.valueOf(ConfigSize.class, str);
        }

        public static ConfigSize[] values() {
            return (ConfigSize[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }

        public final Size getRelatedFixedSize() {
            return this.relatedFixedSize;
        }

        public /* synthetic */ ConfigSize(String str, int i10, int i11, Size size, int i12, kotlin.jvm.internal.i iVar) {
            this(str, i10, i11, (i12 & 2) != 0 ? null : size);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/core/impl/SurfaceConfig$ConfigSource;", "", "<init>", "(Ljava/lang/String;I)V", "FEATURE_COMBINATION_TABLE", "CAPTURE_SESSION_TABLES", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigSource {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ConfigSource[] $VALUES;
        public static final ConfigSource FEATURE_COMBINATION_TABLE = new ConfigSource("FEATURE_COMBINATION_TABLE", 0);
        public static final ConfigSource CAPTURE_SESSION_TABLES = new ConfigSource("CAPTURE_SESSION_TABLES", 1);

        private static final /* synthetic */ ConfigSource[] $values() {
            return new ConfigSource[]{FEATURE_COMBINATION_TABLE, CAPTURE_SESSION_TABLES};
        }

        static {
            ConfigSource[] configSourceArr$values = $values();
            $VALUES = configSourceArr$values;
            $ENTRIES = kotlin.enums.a.a(configSourceArr$values);
        }

        private ConfigSource(String str, int i10) {
        }

        public static InterfaceC4149a<ConfigSource> getEntries() {
            return $ENTRIES;
        }

        public static ConfigSource valueOf(String str) {
            return (ConfigSource) Enum.valueOf(ConfigSource.class, str);
        }

        public static ConfigSource[] values() {
            return (ConfigSource[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIV", "YUV", "JPEG", "JPEG_R", "RAW", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigType {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ConfigType[] $VALUES;
        public static final ConfigType PRIV = new ConfigType("PRIV", 0);
        public static final ConfigType YUV = new ConfigType("YUV", 1);
        public static final ConfigType JPEG = new ConfigType("JPEG", 2);
        public static final ConfigType JPEG_R = new ConfigType("JPEG_R", 3);
        public static final ConfigType RAW = new ConfigType("RAW", 4);

        private static final /* synthetic */ ConfigType[] $values() {
            return new ConfigType[]{PRIV, YUV, JPEG, JPEG_R, RAW};
        }

        static {
            ConfigType[] configTypeArr$values = $values();
            $VALUES = configTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(configTypeArr$values);
        }

        private ConfigType(String str, int i10) {
        }

        public static InterfaceC4149a<ConfigType> getEntries() {
            return $ENTRIES;
        }

        public static ConfigType valueOf(String str) {
            return (ConfigType) Enum.valueOf(ConfigType.class, str);
        }

        public static ConfigType[] values() {
            return (ConfigType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JE\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Landroidx/camera/core/impl/SurfaceConfig$a;", "", "<init>", "()V", "Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "type", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", ContentDisposition.Parameters.Size, "Landroidx/camera/core/impl/StreamUseCase;", "streamUseCase", "Landroidx/camera/core/impl/SurfaceConfig;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SurfaceConfig$ConfigType;Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;Landroidx/camera/core/impl/StreamUseCase;)Landroidx/camera/core/impl/SurfaceConfig;", "", "imageFormat", "c", "(I)Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "Landroid/util/Size;", "LK/C0;", "surfaceSizeDefinition", "cameraMode", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSource;", "configSource", Const.INTENT_KEY_UMID, "(ILandroid/util/Size;LK/C0;ILandroidx/camera/core/impl/SurfaceConfig$ConfigSource;Landroidx/camera/core/impl/StreamUseCase;)Landroidx/camera/core/impl/SurfaceConfig;", "DEFAULT_STREAM_USE_CASE", "Landroidx/camera/core/impl/StreamUseCase;", "", "FEATURE_COMBO_QUERY_SUPPORTED_SIZES", "[Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "", "IMAGE_FORMATS_BY_CONFIG_TYPE", "Ljava/util/Map;", "CONFIG_TYPES_BY_IMAGE_FORMAT", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.impl.SurfaceConfig$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ SurfaceConfig b(Companion companion, ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                streamUseCase = SurfaceConfig.f11362f;
            }
            return companion.a(configType, configSize, streamUseCase);
        }

        public static /* synthetic */ SurfaceConfig e(Companion companion, int i10, Size size, C0 c02, int i11, ConfigSource configSource, StreamUseCase streamUseCase, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                i11 = 0;
            }
            int i13 = i11;
            if ((i12 & 16) != 0) {
                configSource = ConfigSource.CAPTURE_SESSION_TABLES;
            }
            ConfigSource configSource2 = configSource;
            if ((i12 & 32) != 0) {
                streamUseCase = SurfaceConfig.f11362f;
            }
            return companion.d(i10, size, c02, i13, configSource2, streamUseCase);
        }

        public final SurfaceConfig a(ConfigType type, ConfigSize size, StreamUseCase streamUseCase) {
            kotlin.jvm.internal.p.i(type, "type");
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(streamUseCase, "streamUseCase");
            return new SurfaceConfig(type, size, streamUseCase);
        }

        public final ConfigType c(int imageFormat) {
            ConfigType configType = (ConfigType) SurfaceConfig.f11365i.get(Integer.valueOf(imageFormat));
            return configType == null ? ConfigType.PRIV : configType;
        }

        public final SurfaceConfig d(int imageFormat, Size size, C0 surfaceSizeDefinition, int cameraMode, ConfigSource configSource, StreamUseCase streamUseCase) {
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(surfaceSizeDefinition, "surfaceSizeDefinition");
            kotlin.jvm.internal.p.i(configSource, "configSource");
            kotlin.jvm.internal.p.i(streamUseCase, "streamUseCase");
            ConfigType configTypeC = c(imageFormat);
            ConfigSize configSize = ConfigSize.NOT_SUPPORT;
            int iB = T.c.b(size);
            if (cameraMode == 1) {
                if (iB <= T.c.b(surfaceSizeDefinition.m(imageFormat))) {
                    configSize = ConfigSize.S720P_16_9;
                } else if (iB <= T.c.b(surfaceSizeDefinition.k(imageFormat))) {
                    configSize = ConfigSize.S1440P_4_3;
                }
            } else if (configSource == ConfigSource.FEATURE_COMBINATION_TABLE) {
                Size sizeG = surfaceSizeDefinition.g(imageFormat);
                ConfigSize[] configSizeArr = SurfaceConfig.f11363g;
                int length = configSizeArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    ConfigSize configSize2 = configSizeArr[i10];
                    if (kotlin.jvm.internal.p.d(size, configSize2.getRelatedFixedSize())) {
                        configSize = configSize2;
                        break;
                    }
                    i10++;
                }
                if (configSize == ConfigSize.NOT_SUPPORT && kotlin.jvm.internal.p.d(size, sizeG)) {
                    configSize = ConfigSize.MAXIMUM;
                }
            } else if (iB <= T.c.b(surfaceSizeDefinition.b())) {
                configSize = ConfigSize.VGA;
            } else if (iB <= T.c.b(surfaceSizeDefinition.i())) {
                configSize = ConfigSize.PREVIEW;
            } else if (iB <= T.c.b(surfaceSizeDefinition.j())) {
                configSize = ConfigSize.RECORD;
            } else {
                Size sizeG2 = surfaceSizeDefinition.g(imageFormat);
                Size sizeO = surfaceSizeDefinition.o(imageFormat);
                if ((sizeG2 == null || iB <= T.c.b(sizeG2)) && cameraMode != 2) {
                    configSize = ConfigSize.MAXIMUM;
                } else if (sizeO != null && iB <= T.c.b(sizeO)) {
                    configSize = ConfigSize.ULTRA_MAXIMUM;
                }
            }
            return a(configTypeC, configSize, streamUseCase);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11370a;

        static {
            int[] iArr = new int[ConfigSize.values().length];
            try {
                iArr[ConfigSize.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigSize.RECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfigSize.MAXIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfigSize.MAXIMUM_4_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConfigSize.MAXIMUM_16_9.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConfigSize.ULTRA_MAXIMUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConfigSize.NOT_SUPPORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f11370a = iArr;
        }
    }

    static {
        Map<ConfigType, Integer> mapM = kotlin.collections.a.m(Y8.j.a(ConfigType.YUV, 35), Y8.j.a(ConfigType.JPEG, 256), Y8.j.a(ConfigType.JPEG_R, 4101), Y8.j.a(ConfigType.RAW, 32), Y8.j.a(ConfigType.PRIV, 34));
        f11364h = mapM;
        Set<Map.Entry<ConfigType, Integer>> setEntrySet = mapM.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (ConfigType) entry.getKey());
        }
        f11365i = linkedHashMap;
    }

    public SurfaceConfig(ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase) {
        kotlin.jvm.internal.p.i(configType, "configType");
        kotlin.jvm.internal.p.i(configSize, "configSize");
        kotlin.jvm.internal.p.i(streamUseCase, "streamUseCase");
        this.configType = configType;
        this.configSize = configSize;
        this.streamUseCase = streamUseCase;
        Integer num = f11364h.get(configType);
        this.imageFormat = num != null ? num.intValue() : 0;
    }

    /* renamed from: c, reason: from getter */
    public final ConfigSize getConfigSize() {
        return this.configSize;
    }

    /* renamed from: d, reason: from getter */
    public final int getImageFormat() {
        return this.imageFormat;
    }

    public final Size e(C0 definition) {
        Size sizeI;
        kotlin.jvm.internal.p.i(definition, "definition");
        switch (b.f11370a[this.configSize.ordinal()]) {
            case 1:
                sizeI = definition.i();
                break;
            case 2:
                sizeI = definition.j();
                break;
            case 3:
                sizeI = definition.g(this.imageFormat);
                break;
            case 4:
                sizeI = definition.e(this.imageFormat);
                break;
            case 5:
                sizeI = definition.c(this.imageFormat);
                break;
            case 6:
                sizeI = definition.o(this.imageFormat);
                break;
            case 7:
                throw new IllegalStateException("Not supported config size");
            default:
                sizeI = this.configSize.getRelatedFixedSize();
                break;
        }
        kotlin.jvm.internal.p.f(sizeI);
        return sizeI;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) other;
        return this.configType == surfaceConfig.configType && this.configSize == surfaceConfig.configSize && this.streamUseCase == surfaceConfig.streamUseCase;
    }

    /* renamed from: f, reason: from getter */
    public final StreamUseCase getStreamUseCase() {
        return this.streamUseCase;
    }

    public final boolean g(SurfaceConfig other) {
        StreamUseCase streamUseCase;
        kotlin.jvm.internal.p.i(other, "other");
        if (other.configSize.getId() > this.configSize.getId() || other.configType != this.configType) {
            return false;
        }
        StreamUseCase streamUseCase2 = this.streamUseCase;
        StreamUseCase streamUseCase3 = StreamUseCase.DEFAULT;
        return streamUseCase2 == streamUseCase3 || (streamUseCase = other.streamUseCase) == streamUseCase3 || streamUseCase == streamUseCase2;
    }

    public int hashCode() {
        return (((this.configType.hashCode() * 31) + this.configSize.hashCode()) * 31) + this.streamUseCase.hashCode();
    }

    public String toString() {
        return "SurfaceConfig(configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + ')';
    }
}
