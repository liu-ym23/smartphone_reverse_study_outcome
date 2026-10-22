package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SurfaceConfig {
    public static final long DEFAULT_STREAM_USE_CASE_VALUE = 0;

    public static final enum ConfigSize extends Enum<ConfigSize> {
        private static final /* synthetic */ ConfigSize[] $VALUES = null;
        public static final ConfigSize MAXIMUM = null;
        public static final ConfigSize NOT_SUPPORT = null;
        public static final ConfigSize PREVIEW = null;
        public static final ConfigSize RECORD = null;
        public static final ConfigSize ULTRA_MAXIMUM = null;
        public static final ConfigSize VGA = null;
        public static final ConfigSize s1440p = null;
        public static final ConfigSize s720p = null;
        final int mId;

        private static /* synthetic */ ConfigSize[] $values() {
            return new ConfigSize[]{VGA, s720p, PREVIEW, s1440p, RECORD, MAXIMUM, ULTRA_MAXIMUM, NOT_SUPPORT};
        }

        static {
            VGA = new ConfigSize("VGA", 0, 0);
            s720p = new ConfigSize("s720p", 1, 1);
            PREVIEW = new ConfigSize("PREVIEW", 2, 2);
            s1440p = new ConfigSize("s1440p", 3, 3);
            RECORD = new ConfigSize("RECORD", 4, 4);
            MAXIMUM = new ConfigSize("MAXIMUM", 5, 5);
            ULTRA_MAXIMUM = new ConfigSize("ULTRA_MAXIMUM", 6, 6);
            NOT_SUPPORT = new ConfigSize("NOT_SUPPORT", 7, 7);
            $VALUES = $values();
        }

        public static ConfigSize[] values() {
            return (ConfigSize[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ConfigSize valueOf(String r100) {
            return (ConfigSize) r27.a.a(ConfigSize.class, r100);
        }

        private ConfigSize(String r100, int r101, int r102) {
            super(r100, r101);
            this.mId = r102;
        }
    }

    public static final enum ConfigType extends Enum<ConfigType> {
        private static final /* synthetic */ ConfigType[] $VALUES = null;
        public static final ConfigType JPEG = null;
        public static final ConfigType JPEG_R = null;
        public static final ConfigType PRIV = null;
        public static final ConfigType RAW = null;
        public static final ConfigType YUV = null;

        private static /* synthetic */ ConfigType[] $values() {
            return new ConfigType[]{PRIV, YUV, JPEG, JPEG_R, RAW};
        }

        static {
            PRIV = new ConfigType("PRIV", 0);
            YUV = new ConfigType("YUV", 1);
            JPEG = new ConfigType("JPEG", 2);
            JPEG_R = new ConfigType("JPEG_R", 3);
            RAW = new ConfigType("RAW", 4);
            $VALUES = $values();
        }

        public static ConfigType[] values() {
            return (ConfigType[]) $VALUES.clone();
        }

        public static ConfigType valueOf(String r100) {
            return (ConfigType) r27.a.a(ConfigType.class, r100);
        }

        private ConfigType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract ConfigSize getConfigSize();

    public abstract ConfigType getConfigType();

    public abstract long getStreamUseCase();

    public SurfaceConfig() {
    }

    public static ConfigType getConfigType(int r100) {
        if (r100 != 35) goto L7;
        return ConfigType.YUV;
    L7:
        if (r100 != 256) goto L11;
        return ConfigType.JPEG;
    L11:
        if (r100 != 4101) goto L15;
        return ConfigType.JPEG_R;
    L15:
        if (r100 != 32) goto L19;
        return ConfigType.RAW;
    L19:
        return ConfigType.PRIV;
    }

    public final boolean isSupported(SurfaceConfig r100) {
        ConfigType r101 = r100.getConfigType();
        if (r100.getConfigSize().getId() <= getConfigSize().getId()) goto L5;
    L7:
        return false;
    L5:
        if (r101 != getConfigType()) goto L7;
        return true;
    }

    public static SurfaceConfig create(ConfigType r100, ConfigSize r101) {
        return new AutoValue_SurfaceConfig(r100, r101, 0);
    }

    public static SurfaceConfig create(ConfigType r100, ConfigSize r101, long r102) {
        return new AutoValue_SurfaceConfig(r100, r101, r102);
    }

    public static SurfaceConfig transformSurfaceConfig(int r100, int r101, Size r102, SurfaceSizeDefinition r103) {
        ConfigType r104 = getConfigType(r101);
        ConfigSize r105 = ConfigSize.NOT_SUPPORT;
        int r106 = SizeUtil.getArea(r102);
        if (r100 != 1) goto L11;
        if (r106 > SizeUtil.getArea(r103.getS720pSize(r101))) goto L8;
        r105 = ConfigSize.s720p;
    L28:
        return create(r104, r105);
    L8:
        if (r106 > SizeUtil.getArea(r103.getS1440pSize(r101))) goto L28;
        r105 = ConfigSize.s1440p;
        goto L28
    L11:
        if (r106 > SizeUtil.getArea(r103.getAnalysisSize())) goto L14;
        r105 = ConfigSize.VGA;
        goto L28
    L14:
        if (r106 > SizeUtil.getArea(r103.getPreviewSize())) goto L17;
        r105 = ConfigSize.PREVIEW;
        goto L28
    L17:
        if (r106 > SizeUtil.getArea(r103.getRecordSize())) goto L20;
        r105 = ConfigSize.RECORD;
        goto L28
    L20:
        if (r106 > SizeUtil.getArea(r103.getMaximumSize(r101))) goto L22;
        r105 = ConfigSize.MAXIMUM;
        goto L28
    L22:
        Size r107 = r103.getUltraMaximumSize(r101);
        if (r107 == null) goto L28;
        if (r106 > SizeUtil.getArea(r107)) goto L28;
        r105 = ConfigSize.ULTRA_MAXIMUM;
        goto L28
    }
}
