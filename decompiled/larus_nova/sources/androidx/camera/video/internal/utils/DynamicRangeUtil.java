package androidx.camera.video.internal.utils;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRangeUtil {
    public static final Map<Integer, Set<Integer>> DR_TO_VP_BIT_DEPTH_MAP = null;
    public static final Map<Integer, Set<Integer>> DR_TO_VP_FORMAT_MAP = null;
    private static final Map<String, Map<DynamicRange, Integer>> MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = null;
    public static final Map<Integer, Integer> VP_TO_DR_BIT_DEPTH = null;
    public static final Map<Integer, Integer> VP_TO_DR_FORMAT_MAP = null;

    static {
        HashMap r100 = new HashMap();
        DR_TO_VP_BIT_DEPTH_MAP = r100;
        HashMap r101 = new HashMap();
        DR_TO_VP_FORMAT_MAP = r101;
        HashMap r102 = new HashMap();
        VP_TO_DR_BIT_DEPTH = r102;
        HashMap r103 = new HashMap();
        VP_TO_DR_FORMAT_MAP = r103;
        HashMap r104 = new HashMap();
        MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = r104;
        r100.put(8, new HashSet(Collections.singletonList(8)));
        r100.put(10, new HashSet(Collections.singletonList(10)));
        r100.put(0, new HashSet(Arrays.asList(new Integer[]{8, 10})));
        r101.put(0, new HashSet(Arrays.asList(new Integer[]{0, 1, 2, 3, 4})));
        r101.put(1, new HashSet(Collections.singletonList(0)));
        r101.put(2, new HashSet(Arrays.asList(new Integer[]{1, 2, 3, 4})));
        r101.put(3, new HashSet(Collections.singletonList(1)));
        r101.put(4, new HashSet(Collections.singletonList(2)));
        r101.put(5, new HashSet(Collections.singletonList(3)));
        r101.put(6, new HashSet(Collections.singletonList(4)));
        r102.put(8, 8);
        r102.put(10, 10);
        r103.put(0, 1);
        r103.put(1, 3);
        r103.put(2, 4);
        r103.put(3, 5);
        r103.put(4, 6);
        HashMap r105 = new HashMap();
        DynamicRange r106 = DynamicRange.SDR;
        r105.put(r106, 1);
        DynamicRange r107 = DynamicRange.HLG_10_BIT;
        r105.put(r107, 2);
        DynamicRange r108 = DynamicRange.HDR10_10_BIT;
        r105.put(r108, 4096);
        DynamicRange r109 = DynamicRange.HDR10_PLUS_10_BIT;
        r105.put(r109, 8192);
        HashMap r110 = new HashMap();
        r110.put(r106, 1);
        r110.put(r107, 2);
        r110.put(r108, 4096);
        r110.put(r109, 8192);
        HashMap r111 = new HashMap();
        r111.put(r106, 1);
        r111.put(r107, 4);
        r111.put(r108, 4096);
        r111.put(r109, 16384);
        HashMap r112 = new HashMap();
        r112.put(DynamicRange.DOLBY_VISION_10_BIT, 256);
        r112.put(DynamicRange.DOLBY_VISION_8_BIT, 512);
        r104.put("video/hevc", r105);
        r104.put("video/av01", r110);
        r104.put("video/x-vnd.on2.vp9", r111);
        r104.put("video/dolby-vision", r112);
    }

    private DynamicRangeUtil() {
    }

    public static Set<Integer> dynamicRangeToVideoProfileBitDepth(DynamicRange r100) {
        Set<Integer> r101 = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(r100.getBitDepth()));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Collections.emptySet();
    }

    public static Set<Integer> dynamicRangeToVideoProfileHdrFormats(DynamicRange r100) {
        Set<Integer> r101 = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(r100.getEncoding()));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Collections.emptySet();
    }

    public static int videoProfileBitDepthToDynamicRangeBitDepth(int r100) {
        Map<Integer, Integer> r101 = VP_TO_DR_BIT_DEPTH;
        Preconditions.checkArgument(r101.containsKey(Integer.valueOf(r100)));
        Integer r102 = r101.get(Integer.valueOf(r100));
        Objects.requireNonNull(r102);
        return r102.intValue();
    }

    public static int videoProfileHdrFormatsToDynamicRangeEncoding(int r100) {
        Map<Integer, Integer> r101 = VP_TO_DR_FORMAT_MAP;
        Preconditions.checkArgument(r101.containsKey(Integer.valueOf(r100)));
        Integer r102 = r101.get(Integer.valueOf(r100));
        Objects.requireNonNull(r102);
        return r102.intValue();
    }

    public static int dynamicRangeToCodecProfileLevelForMime(String r100, DynamicRange r101) {
        Map<DynamicRange, Integer> r102 = MIME_TO_DEFAULT_PROFILE_LEVEL_MAP.get(r100);
        if (r102 == null) goto L8;
        Integer r103 = r102.get(r101);
        if (r103 != null) goto L7;
        return -1;
    L7:
        return r103.intValue();
    L8:
        return -1;
    }

    private static boolean isBitDepthMatched(int r100, DynamicRange r101) {
        Set<Integer> r102 = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(r101.getBitDepth()));
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.contains(Integer.valueOf(r100)) == false) goto L7;
        return true;
    }

    private static boolean isHdrEncodingMatched(int r100, DynamicRange r101) {
        Set<Integer> r102 = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(r101.getEncoding()));
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.contains(Integer.valueOf(r100)) == false) goto L7;
        return true;
    }

    public static boolean isHdrSettingsMatched(EncoderProfilesProxy.VideoProfileProxy r100, DynamicRange r101) {
        if (isBitDepthMatched(r100.getBitDepth(), r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (isHdrEncodingMatched(r100.getHdrFormat(), r101) == false) goto L7;
        return true;
    }
}
