package androidx.camera.core.impl.stabilization;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/camera/core/impl/stabilization/VideoStabilization;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", Const.INTENT_KEY_APIKEY, "UNSPECIFIED", "OFF", "ON", "PREVIEW", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VideoStabilization {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ VideoStabilization[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final VideoStabilization UNSPECIFIED = new VideoStabilization("UNSPECIFIED", 0);
    public static final VideoStabilization OFF = new VideoStabilization("OFF", 1);
    public static final VideoStabilization ON = new VideoStabilization("ON", 2);
    public static final VideoStabilization PREVIEW = new VideoStabilization("PREVIEW", 3);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/core/impl/stabilization/VideoStabilization$a;", "", "<init>", "()V", "", "previewStabilizationMode", "videoStabilizationMode", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", Const.INTENT_KEY_APIKEY, "(II)Landroidx/camera/core/impl/stabilization/VideoStabilization;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.impl.stabilization.VideoStabilization$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final VideoStabilization a(int previewStabilizationMode, int videoStabilizationMode) {
            return (previewStabilizationMode == 1 || videoStabilizationMode == 1) ? VideoStabilization.OFF : previewStabilizationMode == 2 ? VideoStabilization.PREVIEW : videoStabilizationMode == 2 ? VideoStabilization.ON : VideoStabilization.UNSPECIFIED;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ VideoStabilization[] $values() {
        return new VideoStabilization[]{UNSPECIFIED, OFF, ON, PREVIEW};
    }

    static {
        VideoStabilization[] videoStabilizationArr$values = $values();
        $VALUES = videoStabilizationArr$values;
        $ENTRIES = a.a(videoStabilizationArr$values);
        INSTANCE = new Companion(null);
    }

    private VideoStabilization(String str, int i10) {
    }

    public static InterfaceC4149a<VideoStabilization> getEntries() {
        return $ENTRIES;
    }

    public static VideoStabilization valueOf(String str) {
        return (VideoStabilization) Enum.valueOf(VideoStabilization.class, str);
    }

    public static VideoStabilization[] values() {
        return (VideoStabilization[]) $VALUES.clone();
    }
}
