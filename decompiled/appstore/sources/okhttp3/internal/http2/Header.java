package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Header {
    public static final ByteString PSEUDO_PREFIX = null;
    public static final ByteString RESPONSE_STATUS = null;
    public static final ByteString TARGET_AUTHORITY = null;
    public static final ByteString TARGET_METHOD = null;
    public static final ByteString TARGET_PATH = null;
    public static final ByteString TARGET_SCHEME = null;
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    static {
        PSEUDO_PREFIX = ByteString.encodeUtf8(":");
        RESPONSE_STATUS = ByteString.encodeUtf8(":status");
        TARGET_METHOD = ByteString.encodeUtf8(":method");
        TARGET_PATH = ByteString.encodeUtf8(":path");
        TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
        TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
    }

    public Header(String r10, String r11) {
        this(ByteString.encodeUtf8(r10), ByteString.encodeUtf8(r11));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Header) == false) goto L10;
        Header r11 = (Header) r10;
        if (this.name.equals(r11.name) == true) goto L7;
        return false;
    L7:
        if (this.value.equals(r11.value) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", new Object[]{this.name.utf8(), this.value.utf8()});
    }

    public Header(ByteString r10, String r11) {
        this(r10, ByteString.encodeUtf8(r11));
    }

    public Header(ByteString r10, ByteString r11) {
        this.name = r10;
        this.value = r11;
        this.hpackSize = (r10.size() + 32) + r11.size();
    }
}
