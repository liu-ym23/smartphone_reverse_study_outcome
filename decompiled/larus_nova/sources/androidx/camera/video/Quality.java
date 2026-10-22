package androidx.camera.video;

import android.util.Size;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ttvecamera.TECameraUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Quality {
    public static final Quality FHD = null;
    public static final Quality HD = null;
    public static final Quality HIGHEST = null;
    public static final Quality LOWEST = null;
    static final Quality NONE = null;
    private static final Set<Quality> QUALITIES = null;
    private static final List<Quality> QUALITIES_ORDER_BY_SIZE = null;
    public static final Quality SD = null;
    public static final Quality UHD = null;

    /* JADX INFO: renamed from: androidx.camera.video.Quality$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class ConstantQuality extends Quality {
        public ConstantQuality() {
            super(null);
        }

        public abstract String getName();

        public abstract List<Size> getTypicalSizes();

        public abstract int getValue();

        public static ConstantQuality of(int r100, String r101, List<Size> r102) {
            return new AutoValue_Quality_ConstantQuality(r100, r101, r102);
        }
    }

    static {
        ConstantQuality r100 = ConstantQuality.of(4, "SD", Collections.unmodifiableList(Arrays.asList(new Size[]{new Size(720, 480), new Size(640, 480)})));
        SD = r100;
        ConstantQuality r101 = ConstantQuality.of(5, "HD", Collections.singletonList(new Size(1280, 720)));
        HD = r101;
        ConstantQuality r102 = ConstantQuality.of(6, "FHD", Collections.singletonList(new Size(TECameraUtils.CAPTURE_NORMAL, 1080)));
        FHD = r102;
        ConstantQuality r103 = ConstantQuality.of(8, "UHD", Collections.singletonList(new Size(3840, 2160)));
        UHD = r103;
        ConstantQuality r110 = ConstantQuality.of(0, "LOWEST", Collections.emptyList());
        LOWEST = r110;
        ConstantQuality r111 = ConstantQuality.of(1, "HIGHEST", Collections.emptyList());
        HIGHEST = r111;
        NONE = ConstantQuality.of(-1, UserProfileEvent.POSITION_NONE, Collections.emptyList());
        QUALITIES = new HashSet(Arrays.asList(new Quality[]{r110, r111, r100, r101, r102, r103}));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(new Quality[]{r103, r102, r101, r100});
    }

    public static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }

    private Quality() {
    }

    public /* synthetic */ Quality(AnonymousClass1 r100) {
        this();
    }

    public static boolean containsQuality(Quality r100) {
        return QUALITIES.contains(r100);
    }
}
