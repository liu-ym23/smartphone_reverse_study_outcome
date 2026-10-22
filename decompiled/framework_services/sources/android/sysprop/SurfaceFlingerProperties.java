package android.sysprop;

import android.os.SystemProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceFlingerProperties {

    public static final enum primary_display_orientation_values extends Enum<primary_display_orientation_values> {
        private static final /* synthetic */ primary_display_orientation_values[] $VALUES = null;
        public static final primary_display_orientation_values ORIENTATION_0 = null;
        public static final primary_display_orientation_values ORIENTATION_180 = null;
        public static final primary_display_orientation_values ORIENTATION_270 = null;
        public static final primary_display_orientation_values ORIENTATION_90 = null;
        private final String propValue;

        private static /* synthetic */ primary_display_orientation_values[] $values() {
            return new primary_display_orientation_values[]{ORIENTATION_0, ORIENTATION_90, ORIENTATION_180, ORIENTATION_270};
        }

        public static primary_display_orientation_values valueOf(String name) {
            return (primary_display_orientation_values) Enum.valueOf(primary_display_orientation_values.class, name);
        }

        public static primary_display_orientation_values[] values() {
            return (primary_display_orientation_values[]) $VALUES.clone();
        }

        static {
            ORIENTATION_0 = new primary_display_orientation_values("ORIENTATION_0", 0, "ORIENTATION_0");
            ORIENTATION_90 = new primary_display_orientation_values("ORIENTATION_90", 1, "ORIENTATION_90");
            ORIENTATION_180 = new primary_display_orientation_values("ORIENTATION_180", 2, "ORIENTATION_180");
            ORIENTATION_270 = new primary_display_orientation_values("ORIENTATION_270", 3, "ORIENTATION_270");
            $VALUES = $values();
        }

        private primary_display_orientation_values(String r1, int r2, String propValue) {
            super(r1, r2);
            this.propValue = propValue;
        }

        public String getPropValue() {
            return this.propValue;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5Ij-g79p5Y_SsPJljzV4_9Qu7tk, reason: not valid java name */
    public static /* synthetic */ Double m43$r8$lambda$5Ijg79p5Y_SsPJljzV4_9Qu7tk(String r0) {
        return lambda$display_primary_red$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Cz-nwsTkIUm0tLLsxF5iJBqHVqs, reason: not valid java name */
    public static /* synthetic */ Double m44$r8$lambda$CznwsTkIUm0tLLsxF5iJBqHVqs(String r0) {
        return lambda$display_primary_blue$2(r0);
    }

    public static /* synthetic */ Double $r8$lambda$h4hnPeO06oKFauElh26kvCHdZv0(String r0) {
        return lambda$display_primary_green$1(r0);
    }

    public static /* synthetic */ Double $r8$lambda$lqGoLNPMjGpVIhPtx9J_15s24_w(String r0) {
        return lambda$display_primary_white$3(r0);
    }

    private SurfaceFlingerProperties() {
    }

    private static Boolean tryParseBoolean(String str) {
        if (str != null) goto L5;
        return null;
    L5:
        String r1 = str.toLowerCase(Locale.US);
        switch(r1.hashCode()) {
            case 48: goto L18;
            case 49: goto L15;
            case 3569038: goto L12;
            case 97196323: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        return null;
    L24:
        return Boolean.FALSE;
    L26:
        return Boolean.TRUE;
    L9:
        if (r1.equals("false") == false) goto L20;
        r2 = 3;
        goto L21
    L12:
        if (r1.equals("true") == false) goto L20;
        r2 = 1;
        goto L21
    L15:
        if (r1.equals("1") == false) goto L20;
        r2 = 0;
        goto L21
    L18:
        if (r1.equals("0") == false) goto L20;
        r2 = 2;
        goto L21
    }

    private static Integer tryParseInteger(String str) {
        return Integer.valueOf(str);
    L5:
        return null;
    }

    private static Integer tryParseUInt(String str) {
        return Integer.valueOf(Integer.parseUnsignedInt(str));
    L5:
        return null;
    }

    private static Long tryParseLong(String str) {
        return Long.valueOf(str);
    L5:
        return null;
    }

    private static Long tryParseULong(String str) {
        return Long.valueOf(Long.parseUnsignedLong(str));
    L5:
        return null;
    }

    private static Double tryParseDouble(String str) {
        return Double.valueOf(str);
    L5:
        return null;
    }

    private static String tryParseString(String str) {
        if ("".equals(str) == false) goto L6;
        return null;
    L6:
        return str;
    }

    private static <T extends Enum<T>> T tryParseEnum(Class<T> r2, String r3) {
        return (T) Enum.valueOf(r2, r3.toUpperCase(Locale.US));
    L5:
        return null;
    }

    private static <T> List<T> tryParseList(Function<String, T> elementParser, String str) {
        if ("".equals(str) == true) goto L5;
        List<T> ret = new ArrayList();
        int p = 0;
    L7:
        StringBuilder sb = new StringBuilder();
    L9:
        if (p >= str.length()) goto L19;
        if (str.charAt(p) == ',') goto L19;
        if (str.charAt(p) != '\\') goto L16;
        p = p + 1;
    L16:
        if (p == str.length()) goto L19;
        int p2 = p + 1;
        sb.append(str.charAt(p));
        p = p2;
    L19:
        ret.add(elementParser.apply(sb.toString()));
        if (p == str.length()) goto L21;
        p = p + 1;
        goto L7
    L21:
        return ret;
    L5:
        return new ArrayList();
    }

    private static <T extends Enum<T>> List<T> tryParseEnumList(Class<T> enumType, String str) {
        if ("".equals(str) == true) goto L5;
        ArrayList r0 = new ArrayList();
        String[] r1 = str.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        String element = r1[r3];
        r0.add(tryParseEnum(enumType, element));
        r3 = r3 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return new ArrayList();
    }

    private static String escape(String str) {
        return str.replaceAll("([\\\\,])", "\\\\$1");
    }

    private static <T> String formatList(List<T> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<T> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(element.toString());
        goto L9
    L11:
        return joiner.toString();
    }

    private static String formatUIntList(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<Integer> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Integer element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(Integer.toUnsignedString(element.intValue()));
        goto L9
    L11:
        return joiner.toString();
    }

    private static String formatULongList(List<Long> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<Long> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Long element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(Long.toUnsignedString(element.longValue()));
        goto L9
    L11:
        return joiner.toString();
    }

    private static <T extends Enum<T>> String formatEnumList(List<T> list, Function<T, String> elementFormatter) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<T> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = elementFormatter.apply(element);
        goto L9
    L11:
        return joiner.toString();
    }

    public static Optional<Long> vsync_event_phase_offset_ns() {
        String value = SystemProperties.get("ro.surface_flinger.vsync_event_phase_offset_ns");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Long> vsync_sf_event_phase_offset_ns() {
        String value = SystemProperties.get("ro.surface_flinger.vsync_sf_event_phase_offset_ns");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Boolean> use_context_priority() {
        String value = SystemProperties.get("ro.surface_flinger.use_context_priority");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Long> max_frame_buffer_acquired_buffers() {
        String value = SystemProperties.get("ro.surface_flinger.max_frame_buffer_acquired_buffers");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Integer> max_graphics_width() {
        String value = SystemProperties.get("ro.surface_flinger.max_graphics_width");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Integer> max_graphics_height() {
        String value = SystemProperties.get("ro.surface_flinger.max_graphics_height");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Boolean> has_wide_color_display() {
        String value = SystemProperties.get("ro.surface_flinger.has_wide_color_display");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> running_without_sync_framework() {
        String value = SystemProperties.get("ro.surface_flinger.running_without_sync_framework");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> has_HDR_display() {
        String value = SystemProperties.get("ro.surface_flinger.has_HDR_display");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Long> present_time_offset_from_vsync_ns() {
        String value = SystemProperties.get("ro.surface_flinger.present_time_offset_from_vsync_ns");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Boolean> force_hwc_copy_for_virtual_displays() {
        String value = SystemProperties.get("ro.surface_flinger.force_hwc_copy_for_virtual_displays");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Long> max_virtual_display_dimension() {
        String value = SystemProperties.get("ro.surface_flinger.max_virtual_display_dimension");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Boolean> use_vr_flinger() {
        String value = SystemProperties.get("ro.surface_flinger.use_vr_flinger");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> start_graphics_allocator_service() {
        String value = SystemProperties.get("ro.surface_flinger.start_graphics_allocator_service");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<primary_display_orientation_values> primary_display_orientation() {
        String value = SystemProperties.get("ro.surface_flinger.primary_display_orientation");
        return Optional.ofNullable((primary_display_orientation_values) tryParseEnum(primary_display_orientation_values.class, value));
    }

    public static Optional<Boolean> use_color_management() {
        String value = SystemProperties.get("ro.surface_flinger.use_color_management");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Long> default_composition_dataspace() {
        String value = SystemProperties.get("ro.surface_flinger.default_composition_dataspace");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Integer> default_composition_pixel_format() {
        String value = SystemProperties.get("ro.surface_flinger.default_composition_pixel_format");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Long> wcg_composition_dataspace() {
        String value = SystemProperties.get("ro.surface_flinger.wcg_composition_dataspace");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Integer> wcg_composition_pixel_format() {
        String value = SystemProperties.get("ro.surface_flinger.wcg_composition_pixel_format");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Long> color_space_agnostic_dataspace() {
        String value = SystemProperties.get("ro.surface_flinger.color_space_agnostic_dataspace");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static List<Double> display_primary_red() {
        String value = SystemProperties.get("ro.surface_flinger.display_primary_red");
        return tryParseList(new SurfaceFlingerProperties$$ExternalSyntheticLambda3(), value);
    }

    private static /* synthetic */ Double lambda$display_primary_red$0(String v) {
        return tryParseDouble(v);
    }

    public static List<Double> display_primary_green() {
        String value = SystemProperties.get("ro.surface_flinger.display_primary_green");
        return tryParseList(new SurfaceFlingerProperties$$ExternalSyntheticLambda2(), value);
    }

    private static /* synthetic */ Double lambda$display_primary_green$1(String v) {
        return tryParseDouble(v);
    }

    public static List<Double> display_primary_blue() {
        String value = SystemProperties.get("ro.surface_flinger.display_primary_blue");
        return tryParseList(new SurfaceFlingerProperties$$ExternalSyntheticLambda0(), value);
    }

    private static /* synthetic */ Double lambda$display_primary_blue$2(String v) {
        return tryParseDouble(v);
    }

    public static List<Double> display_primary_white() {
        String value = SystemProperties.get("ro.surface_flinger.display_primary_white");
        return tryParseList(new SurfaceFlingerProperties$$ExternalSyntheticLambda1(), value);
    }

    private static /* synthetic */ Double lambda$display_primary_white$3(String v) {
        return tryParseDouble(v);
    }

    @Deprecated
    public static Optional<Boolean> refresh_rate_switching() {
        String value = SystemProperties.get("ro.surface_flinger.refresh_rate_switching");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Integer> set_idle_timer_ms() {
        String value = SystemProperties.get("ro.surface_flinger.set_idle_timer_ms");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Integer> set_touch_timer_ms() {
        String value = SystemProperties.get("ro.surface_flinger.set_touch_timer_ms");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Integer> set_display_power_timer_ms() {
        String value = SystemProperties.get("ro.surface_flinger.set_display_power_timer_ms");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Boolean> use_content_detection_for_refresh_rate() {
        String value = SystemProperties.get("ro.surface_flinger.use_content_detection_for_refresh_rate");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    @Deprecated
    public static Optional<Boolean> use_smart_90_for_video() {
        String value = SystemProperties.get("ro.surface_flinger.use_smart_90_for_video");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> enable_protected_contents() {
        String value = SystemProperties.get("ro.surface_flinger.protected_contents");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> support_kernel_idle_timer() {
        String value = SystemProperties.get("ro.surface_flinger.support_kernel_idle_timer");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> supports_background_blur() {
        String value = SystemProperties.get("ro.surface_flinger.supports_background_blur");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Integer> display_update_imminent_timeout_ms() {
        String value = SystemProperties.get("ro.surface_flinger.display_update_imminent_timeout_ms");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Boolean> update_device_product_info_on_hotplug_reconnect() {
        String value = SystemProperties.get("ro.surface_flinger.update_device_product_info_on_hotplug_reconnect");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> enable_frame_rate_override() {
        String value = SystemProperties.get("ro.surface_flinger.enable_frame_rate_override");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> enable_layer_caching() {
        String value = SystemProperties.get("ro.surface_flinger.enable_layer_caching");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> enable_sdr_dimming() {
        String value = SystemProperties.get("ro.surface_flinger.enable_sdr_dimming");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Boolean> ignore_hdr_camera_layers() {
        String value = SystemProperties.get("ro.surface_flinger.ignore_hdr_camera_layers");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Long> min_acquired_buffers() {
        String value = SystemProperties.get("ro.surface_flinger.min_acquired_buffers");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Long> max_acquired_buffers() {
        String value = SystemProperties.get("ro.surface_flinger.max_acquired_buffers");
        return Optional.ofNullable(tryParseLong(value));
    }

    public static Optional<Boolean> clear_slots_with_set_layer_buffer() {
        String value = SystemProperties.get("ro.surface_flinger.clear_slots_with_set_layer_buffer");
        return Optional.ofNullable(tryParseBoolean(value));
    }

    public static Optional<Integer> game_default_frame_rate_override() {
        String value = SystemProperties.get("ro.surface_flinger.game_default_frame_rate_override");
        return Optional.ofNullable(tryParseInteger(value));
    }
}
