package okhttp3.internal.http2;

import com.android.contacts.common.SimContactsConstants;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class Header {
    public static final ByteString PSEUDO_PREFIX = null;
    public static final ByteString RESPONSE_STATUS = null;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY = null;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD = null;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH = null;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME = null;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    interface Listener {
        void onHeaders(Headers r1);
    }

    static {
        PSEUDO_PREFIX = ByteString.encodeUtf8(SimContactsConstants.ANR_SEP);
        RESPONSE_STATUS = ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = ByteString.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = ByteString.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(String r1, String r2) {
        this(ByteString.encodeUtf8(r1), ByteString.encodeUtf8(r2));
    }

    public Header(ByteString r1, String r2) {
        this(r1, ByteString.encodeUtf8(r2));
    }

    public Header(ByteString r1, ByteString r2) {
        this.name = r1;
        this.value = r2;
        this.hpackSize = (r1.size() + 32) + r2.size();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Header) == false) goto L10;
        Header r5 = (Header) r4;
        if (this.name.equals(r5.name) == true) goto L7;
        return false;
    L7:
        if (this.value.equals(r5.value) == false) goto L12;
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
}
