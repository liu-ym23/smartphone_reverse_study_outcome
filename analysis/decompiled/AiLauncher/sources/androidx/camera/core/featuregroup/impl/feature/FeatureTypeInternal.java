package androidx.camera.core.featuregroup.impl.feature;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "", "<init>", "(Ljava/lang/String;I)V", "DYNAMIC_RANGE", "FPS_RANGE", "VIDEO_STABILIZATION", "IMAGE_FORMAT", "RECORDING_QUALITY", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureTypeInternal {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FeatureTypeInternal[] $VALUES;
    public static final FeatureTypeInternal DYNAMIC_RANGE = new FeatureTypeInternal("DYNAMIC_RANGE", 0);
    public static final FeatureTypeInternal FPS_RANGE = new FeatureTypeInternal("FPS_RANGE", 1);
    public static final FeatureTypeInternal VIDEO_STABILIZATION = new FeatureTypeInternal("VIDEO_STABILIZATION", 2);
    public static final FeatureTypeInternal IMAGE_FORMAT = new FeatureTypeInternal("IMAGE_FORMAT", 3);
    public static final FeatureTypeInternal RECORDING_QUALITY = new FeatureTypeInternal("RECORDING_QUALITY", 4);

    private static final /* synthetic */ FeatureTypeInternal[] $values() {
        return new FeatureTypeInternal[]{DYNAMIC_RANGE, FPS_RANGE, VIDEO_STABILIZATION, IMAGE_FORMAT, RECORDING_QUALITY};
    }

    static {
        FeatureTypeInternal[] featureTypeInternalArr$values = $values();
        $VALUES = featureTypeInternalArr$values;
        $ENTRIES = a.a(featureTypeInternalArr$values);
    }

    private FeatureTypeInternal(String str, int i10) {
    }

    public static InterfaceC4149a<FeatureTypeInternal> getEntries() {
        return $ENTRIES;
    }

    public static FeatureTypeInternal valueOf(String str) {
        return (FeatureTypeInternal) Enum.valueOf(FeatureTypeInternal.class, str);
    }

    public static FeatureTypeInternal[] values() {
        return (FeatureTypeInternal[]) $VALUES.clone();
    }
}
