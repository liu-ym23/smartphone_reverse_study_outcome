package com.fasterxml.jackson.core;

import com.google.crypto.tink.shaded.protobuf.Reader;
import g5.f;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Base64Variants {
    public static final Base64Variant MIME;
    public static final Base64Variant MIME_NO_LINEFEEDS;
    public static final Base64Variant MODIFIED_FOR_URL;
    public static final Base64Variant PEM;
    static final String STD_BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", STD_BASE64_ALPHABET, true, '=', 76);
        MIME = base64Variant;
        MIME_NO_LINEFEEDS = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", Reader.READ_DONE);
        PEM = new Base64Variant(base64Variant, "PEM", true, '=', 64);
        StringBuilder sb2 = new StringBuilder(STD_BASE64_ALPHABET);
        sb2.setCharAt(sb2.indexOf("+"), '-');
        sb2.setCharAt(sb2.indexOf("/"), '_');
        MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", sb2.toString(), false, (char) 0, Reader.READ_DONE);
    }

    public static Base64Variant getDefaultVariant() {
        return MIME_NO_LINEFEEDS;
    }

    public static Base64Variant valueOf(String str) {
        Base64Variant base64Variant = MIME;
        if (base64Variant._name.equals(str)) {
            return base64Variant;
        }
        Base64Variant base64Variant2 = MIME_NO_LINEFEEDS;
        if (base64Variant2._name.equals(str)) {
            return base64Variant2;
        }
        Base64Variant base64Variant3 = PEM;
        if (base64Variant3._name.equals(str)) {
            return base64Variant3;
        }
        Base64Variant base64Variant4 = MODIFIED_FOR_URL;
        if (base64Variant4._name.equals(str)) {
            return base64Variant4;
        }
        f.s("No Base64Variant with name ".concat(str == null ? "<null>" : a.C("'", str, "'")));
        return null;
    }
}
