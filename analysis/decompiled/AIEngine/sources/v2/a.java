package v2;

import com.fasterxml.jackson.core.Base64Variant;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Base64Variant f13371a;

    /* renamed from: b, reason: collision with root package name */
    public static final Base64Variant f13372b;

    /* renamed from: c, reason: collision with root package name */
    public static final Base64Variant f13373c;

    /* renamed from: d, reason: collision with root package name */
    public static final Base64Variant f13374d;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f13371a = base64Variant;
        f13372b = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", true, '=', base64Variant.f3511k, Integer.MAX_VALUE);
        f13373c = new Base64Variant(base64Variant, "PEM", true, '=', base64Variant.f3511k, 64);
        StringBuilder sb2 = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb2.setCharAt(sb2.indexOf("+"), '-');
        sb2.setCharAt(sb2.indexOf("/"), '_');
        f13374d = new Base64Variant("MODIFIED-FOR-URL", sb2.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
