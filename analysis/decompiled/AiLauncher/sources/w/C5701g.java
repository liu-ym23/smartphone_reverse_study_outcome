package w;

import android.graphics.ColorSpace;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\r"}, d2 = {"Lw/g;", "", "", "colorSpaceName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/graphics/ColorSpace$Named;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Landroid/graphics/ColorSpace$Named;", "e", "", "c", "(Ljava/lang/String;)I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5701g {

    /* renamed from: b, reason: collision with root package name */
    public static final String f42980b = a("UNKNOWN");

    /* renamed from: c, reason: collision with root package name */
    public static final String f42981c = a("SRGB");

    /* renamed from: d, reason: collision with root package name */
    public static final String f42982d = a("LINEAR_SRGB");

    /* renamed from: e, reason: collision with root package name */
    public static final String f42983e = a("EXTENDED_SRGB");

    /* renamed from: f, reason: collision with root package name */
    public static final String f42984f = a("LINEAR_EXTENDED_SRGB");

    /* renamed from: g, reason: collision with root package name */
    public static final String f42985g = a("BT709");

    /* renamed from: h, reason: collision with root package name */
    public static final String f42986h = a("BT2020");

    /* renamed from: i, reason: collision with root package name */
    public static final String f42987i = a("DCI_P3");

    /* renamed from: j, reason: collision with root package name */
    public static final String f42988j = a("DISPLAY_P3");

    /* renamed from: k, reason: collision with root package name */
    public static final String f42989k = a("NTSC_1953");

    /* renamed from: l, reason: collision with root package name */
    public static final String f42990l = a("SMPTE_C");

    /* renamed from: m, reason: collision with root package name */
    public static final String f42991m = a("ADOBE_RGB");

    /* renamed from: n, reason: collision with root package name */
    public static final String f42992n = a("PRO_PHOTO_RGB");

    /* renamed from: o, reason: collision with root package name */
    public static final String f42993o = a("ACES");

    /* renamed from: p, reason: collision with root package name */
    public static final String f42994p = a("ACESCG");

    /* renamed from: q, reason: collision with root package name */
    public static final String f42995q = a("CIE_XYZ");

    /* renamed from: r, reason: collision with root package name */
    public static final String f42996r = a("CIE_LAB");

    /* renamed from: s, reason: collision with root package name */
    public static final String f42997s = a("BT2020_HLG");

    /* renamed from: t, reason: collision with root package name */
    public static final String f42998t = a("BT2020_PQ");

    public static String a(String str) {
        return str;
    }

    public static final boolean b(String str, String str2) {
        return kotlin.jvm.internal.p.d(str, str2);
    }

    public static int c(String str) {
        return str.hashCode();
    }

    public static final ColorSpace.Named d(String str) {
        if (b(str, f42980b)) {
            return null;
        }
        if (b(str, f42981c)) {
            return ColorSpace.Named.SRGB;
        }
        if (b(str, f42982d)) {
            return ColorSpace.Named.LINEAR_SRGB;
        }
        if (b(str, f42983e)) {
            return ColorSpace.Named.EXTENDED_SRGB;
        }
        if (b(str, f42984f)) {
            return ColorSpace.Named.LINEAR_EXTENDED_SRGB;
        }
        if (b(str, f42985g)) {
            return ColorSpace.Named.BT709;
        }
        if (b(str, f42986h)) {
            return ColorSpace.Named.BT2020;
        }
        if (b(str, f42987i)) {
            return ColorSpace.Named.DCI_P3;
        }
        if (b(str, f42988j)) {
            return ColorSpace.Named.DISPLAY_P3;
        }
        if (b(str, f42989k)) {
            return ColorSpace.Named.NTSC_1953;
        }
        if (b(str, f42990l)) {
            return ColorSpace.Named.SMPTE_C;
        }
        if (b(str, f42991m)) {
            return ColorSpace.Named.ADOBE_RGB;
        }
        if (b(str, f42992n)) {
            return ColorSpace.Named.PRO_PHOTO_RGB;
        }
        if (b(str, f42993o)) {
            return ColorSpace.Named.ACES;
        }
        if (b(str, f42994p)) {
            return ColorSpace.Named.ACESCG;
        }
        if (b(str, f42995q)) {
            return ColorSpace.Named.CIE_XYZ;
        }
        if (b(str, f42996r)) {
            return ColorSpace.Named.CIE_LAB;
        }
        if (b(str, f42997s)) {
            return ColorSpace.Named.BT2020_HLG;
        }
        if (b(str, f42998t)) {
            return ColorSpace.Named.BT2020_PQ;
        }
        return null;
    }

    public static String e(String str) {
        return "CameraColorSpace(colorSpaceName=" + str + ')';
    }
}
