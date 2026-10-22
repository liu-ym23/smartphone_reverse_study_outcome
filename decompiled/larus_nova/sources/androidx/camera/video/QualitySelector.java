package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class QualitySelector {
    private static final String TAG = "QualitySelector";
    private final FallbackStrategy mFallbackStrategy;
    private final List<Quality> mPreferredQualityList;

    public String toString() {
        return "QualitySelector{preferredQualities=" + this.mPreferredQualityList + ", fallbackStrategy=" + this.mFallbackStrategy + com.alipay.sdk.m.u.i.f25855d;
    }

    private static void checkQualityConstantsOrThrow(List<Quality> r100) {
        Iterator<Quality> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Quality r102 = r101.next();
        Preconditions.checkArgument(Quality.containsQuality(r102), "qualities contain invalid quality: " + r102);
        goto L4
    }

    public static QualitySelector from(Quality r100) {
        return from(r100, FallbackStrategy.NONE);
    }

    public static QualitySelector fromOrderedList(List<Quality> r100) {
        return fromOrderedList(r100, FallbackStrategy.NONE);
    }

    private static Size getProfileVideoSize(VideoValidatedEncoderProfilesProxy r100) {
        EncoderProfilesProxy.VideoProfileProxy r101 = r100.getDefaultVideoProfile();
        return new Size(r101.getWidth(), r101.getHeight());
    }

    public static List<Quality> getSupportedQualities(CameraInfo r100) {
        return Recorder.getVideoCapabilities(r100).getSupportedQualities(DynamicRange.SDR);
    }

    public List<Quality> getPrioritizedQualities(List<Quality> r100) {
        if (r100.isEmpty() == false) goto L6;
        Logger.w(TAG, "No supported quality on the device.");
        return new ArrayList();
    L6:
        Logger.d(TAG, "supportedQualities = " + r100);
        Set<Quality> r101 = new LinkedHashSet();
        Iterator<Quality> r102 = this.mPreferredQualityList.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        Quality r103 = r102.next();
        if (r103 == Quality.HIGHEST) goto L11;
        if (r103 == Quality.LOWEST) goto L14;
        if (r100.contains(r103) == true) goto L17;
        Logger.w(TAG, "quality is not supported and will be ignored: " + r103);
        goto L8
    L17:
        r101.add(r103);
        goto L8
    L14:
        ArrayList r104 = new ArrayList(r100);
        Collections.reverse(r104);
        r101.addAll(r104);
        goto L19
    L11:
        r101.addAll(r100);
    L19:
        addByFallbackStrategy(r100, r101);
        return new ArrayList(r101);
    }

    private static void checkQualityConstantsOrThrow(Quality r100) {
        Preconditions.checkArgument(Quality.containsQuality(r100), "Invalid quality: " + r100);
    }

    public QualitySelector(List<Quality> r100, FallbackStrategy r101) {
        if (r100.isEmpty() == true) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Preconditions.checkArgument(r102, "No preferred quality and fallback strategy.");
        this.mPreferredQualityList = Collections.unmodifiableList(new ArrayList(r100));
        this.mFallbackStrategy = r101;
        return;
    L5:
        if (r101 != FallbackStrategy.NONE) goto L8;
        r102 = false;
        goto L9
    }

    private void addByFallbackStrategy(List<Quality> r110, Set<Quality> r111) {
        if (r110.isEmpty() == false) goto L6;
        return;
    L6:
        if (r111.containsAll(r110) == false) goto L8;
        return;
    L8:
        Logger.d(TAG, "Select quality by fallbackStrategy = " + this.mFallbackStrategy);
        FallbackStrategy r100 = this.mFallbackStrategy;
        if (r100 != FallbackStrategy.NONE) goto L11;
        return;
    L11:
        Preconditions.checkState(r100 instanceof FallbackStrategy.RuleStrategy, "Currently only support type RuleStrategy");
        FallbackStrategy.RuleStrategy r101 = (FallbackStrategy.RuleStrategy) this.mFallbackStrategy;
        List<Quality> r102 = Quality.getSortedQualities();
        boolean r103 = false;
        if (r101.getFallbackQuality() != Quality.HIGHEST) goto L15;
        Quality r104 = (Quality) ListProtector.get(r102, 0);
    L18:
        int r105 = r102.indexOf(r104);
        if (r105 == (-1)) goto L21;
        r103 = true;
    L21:
        Preconditions.checkState(r103);
        ArrayList r106 = new ArrayList();
        int r107 = r105 - 1;
    L22:
        if (r107 < 0) goto L27;
        Quality r108 = (Quality) ListProtector.get(r102, r107);
        if (r110.contains(r108) == false) goto L26;
        r106.add(r108);
    L26:
        r107 = r107 - 1;
        goto L22
    L27:
        ArrayList r109 = new ArrayList();
        int r112 = r105 + 1;
    L29:
        if (r112 >= r102.size()) goto L34;
        Quality r113 = (Quality) ListProtector.get(r102, r112);
        if (r110.contains(r113) == false) goto L33;
        r109.add(r113);
    L33:
        r112 = r112 + 1;
        goto L29
    L34:
        Logger.d(TAG, "sizeSortedQualities = " + r102 + ", fallback quality = " + r104 + ", largerQualities = " + r106 + ", smallerQualities = " + r109);
        int r114 = r101.getFallbackRule();
        if (r114 == 0) goto L56;
        if (r114 != 1) goto L38;
        r111.addAll(r106);
        r111.addAll(r109);
        return;
    L38:
        if (r114 != 2) goto L40;
        r111.addAll(r106);
        return;
    L40:
        if (r114 != 3) goto L42;
        r111.addAll(r109);
        r111.addAll(r106);
        return;
    L42:
        if (r114 != 4) goto L45;
        r111.addAll(r109);
        return;
    L45:
        throw new AssertionError("Unhandled fallback strategy: " + this.mFallbackStrategy);
    L56:
        return;
    L15:
        if (r101.getFallbackQuality() != Quality.LOWEST) goto L17;
        r104 = (Quality) ListProtector.get(r102, r102.size() - 1);
        goto L18
    L17:
        r104 = r101.getFallbackQuality();
        goto L18
    }

    public static QualitySelector from(Quality r100, FallbackStrategy r101) {
        Preconditions.checkNotNull(r100, "quality cannot be null");
        Preconditions.checkNotNull(r101, "fallbackStrategy cannot be null");
        checkQualityConstantsOrThrow(r100);
        return new QualitySelector(Collections.singletonList(r100), r101);
    }

    public static QualitySelector fromOrderedList(List<Quality> r100, FallbackStrategy r101) {
        Preconditions.checkNotNull(r100, "qualities cannot be null");
        Preconditions.checkNotNull(r101, "fallbackStrategy cannot be null");
        Preconditions.checkArgument(!r100.isEmpty(), "qualities cannot be empty");
        checkQualityConstantsOrThrow(r100);
        return new QualitySelector(r100, r101);
    }

    public static Map<Quality, Size> getQualityToResolutionMap(VideoCapabilities r100, DynamicRange r101) {
        HashMap r102 = new HashMap();
        Iterator<Quality> r103 = r100.getSupportedQualities(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Quality r104 = r103.next();
        VideoValidatedEncoderProfilesProxy r105 = r100.getProfiles(r104, r101);
        Objects.requireNonNull(r105);
        r102.put(r104, getProfileVideoSize(r105));
        goto L4
    L6:
        return r102;
    }

    public static Size getResolution(CameraInfo r100, Quality r101) {
        checkQualityConstantsOrThrow(r101);
        VideoValidatedEncoderProfilesProxy r102 = Recorder.getVideoCapabilities(r100).getProfiles(r101, DynamicRange.SDR);
        if (r102 != null) goto L7;
        return null;
    L7:
        return getProfileVideoSize(r102);
    }

    public static boolean isQualitySupported(CameraInfo r100, Quality r101) {
        return Recorder.getVideoCapabilities(r100).isQualitySupported(r101, DynamicRange.SDR);
    }
}
