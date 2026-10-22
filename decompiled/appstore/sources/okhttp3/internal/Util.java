package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: loaded from: classes4.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final RequestBody EMPTY_REQUEST = null;
    public static final ResponseBody EMPTY_RESPONSE = null;
    public static final String[] EMPTY_STRING_ARRAY = null;
    public static final Charset ISO_8859_1 = null;
    public static final Comparator<String> NATURAL_ORDER = null;
    public static final TimeZone UTC = null;
    private static final Charset UTF_16_BE = null;
    private static final ByteString UTF_16_BE_BOM = null;
    private static final Charset UTF_16_LE = null;
    private static final ByteString UTF_16_LE_BOM = null;
    private static final Charset UTF_32_BE = null;
    private static final ByteString UTF_32_BE_BOM = null;
    private static final Charset UTF_32_LE = null;
    private static final ByteString UTF_32_LE_BOM = null;
    public static final Charset UTF_8 = null;
    private static final ByteString UTF_8_BOM = null;
    private static final Pattern VERIFY_AS_IP_ADDRESS = null;

    static {
        byte[] r10 = new byte[0];
        EMPTY_BYTE_ARRAY = r10;
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_RESPONSE = ResponseBody.create(null, r10);
        EMPTY_REQUEST = RequestBody.e(null, r10);
        UTF_8_BOM = ByteString.decodeHex("efbbbf");
        UTF_16_BE_BOM = ByteString.decodeHex("feff");
        UTF_16_LE_BOM = ByteString.decodeHex("fffe");
        UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
        UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        UTF_16_BE = Charset.forName("UTF-16BE");
        UTF_16_LE = Charset.forName("UTF-16LE");
        UTF_32_BE = Charset.forName("UTF-32BE");
        UTF_32_LE = Charset.forName("UTF-32LE");
        UTC = TimeZone.getTimeZone("GMT");
        NATURAL_ORDER = new AnonymousClass1();
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private Util() {
    }

    public static AssertionError assertionError(String r10, Exception r11) {
        AssertionError r12 = new AssertionError(r10);
        r12.initCause(r11);     // Catch: IllegalStateException -> L5
    L4:
        return r12;
    }

    public static Charset bomAwareCharset(BufferedSource r10, Charset r11) throws IOException {
        ByteString r12 = UTF_8_BOM;
        if (r10.rangeEquals(0, r12) == false) goto L6;
        r10.skip(r12.size());
        return UTF_8;
    L6:
        ByteString r13 = UTF_16_BE_BOM;
        if (r10.rangeEquals(0, r13) == false) goto L10;
        r10.skip(r13.size());
        return UTF_16_BE;
    L10:
        ByteString r14 = UTF_16_LE_BOM;
        if (r10.rangeEquals(0, r14) == false) goto L14;
        r10.skip(r14.size());
        return UTF_16_LE;
    L14:
        ByteString r15 = UTF_32_BE_BOM;
        if (r10.rangeEquals(0, r15) == false) goto L18;
        r10.skip(r15.size());
        return UTF_32_BE;
    L18:
        ByteString r16 = UTF_32_LE_BOM;
        if (r10.rangeEquals(0, r16) == false) goto L22;
        r10.skip(r16.size());
        return UTF_32_LE;
    L22:
        return r11;
    }

    public static String canonicalizeHost(String r10) {
        if (r10.contains(":") == true) goto L5;
        String r11 = IDN.toASCII(r10).toLowerCase(Locale.US);     // Catch: IllegalArgumentException -> L25
        if (r11.isEmpty() == false) goto L21;
        return null;
    L21:
        if (containsInvalidHostnameAsciiCodes(r11) == false) goto L24;
        return null;
    L24:
        return r11;
    L25:
        return null;
    L5:
        if (r10.startsWith("[") == true) goto L7;
    L9:
        InetAddress r12 = decodeIpv6(r10, 0, r10.length());
    L10:
        if (r12 != null) goto L12;
        return null;
    L12:
        byte[] r13 = r12.getAddress();
        if (r13.length != 16) goto L17;
        return inet6AddressToAscii(r13);
    L17:
        throw new AssertionError("Invalid IPv6 address: '" + r10 + "'");
    L7:
        if (r10.endsWith("]") == false) goto L9;
        r12 = decodeIpv6(r10, 1, r10.length() - 1);
        goto L10
    }

    public static int checkDuration(String r10, long r11, TimeUnit r12) {
        if (r11 < 0) goto L20;
        if (r12 == null) goto L18;
        long r13 = r12.toMillis(r11);
        if (r13 > 2147483647L) goto L16;
        if (r13 != 0) goto L14;
        if (r11 <= 0) goto L14;
        throw new IllegalArgumentException(r10 + " too small.");
    L14:
        return (int) r13;
    L16:
        throw new IllegalArgumentException(r10 + " too large.");
    L18:
        throw new NullPointerException("unit == null");
    L20:
        throw new IllegalArgumentException(r10 + " < 0");
    }

    public static void checkOffsetAndCount(long r10, long r11, long r12) {
        if ((r11 | r12) < 0) goto L10;
        if (r11 > r10) goto L10;
        if ((r10 - r11) < r12) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void closeQuietly(Closeable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: RuntimeException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static String[] concat(String[] r10, String r11) {
        int r12 = r10.length;
        String[] r13 = new String[r12 + 1];
        System.arraycopy(r10, 0, r13, 0, r10.length);
        r13[r12] = r11;
        return r13;
    }

    private static boolean containsInvalidHostnameAsciiCodes(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L15;
        char r12 = r10.charAt(r11);
        if (r12 <= 31) goto L14;
        if (r12 >= 127) goto L14;
        if (" #%/:?@[\\]".indexOf(r12) != (-1)) goto L12;
        r11 = r11 + 1;
        goto L4
    L12:
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    public static int decodeHexDigit(char r10) {
        if (r10 < '0') goto L9;
        if (r10 > '9') goto L9;
        return r10 - '0';
    L9:
        if (r10 < 'a') goto L15;
        if (r10 > 'f') goto L15;
        return r10 - 'W';
    L15:
        if (r10 >= 'A') goto L17;
        return -1;
    L17:
        if (r10 <= 'F') goto L19;
        return -1;
    L19:
        return r10 - '7';
    }

    private static boolean decodeIpv4Suffix(String r10, int r11, int r12, byte[] r13, int r14) {
        int r15 = r14;
    L4:
        if (r11 >= r12) goto L32;
        if (r15 == r13.length) goto L7;
        if (r15 != r14) goto L10;
    L13:
        int r16 = r11;
        int r17 = 0;
    L14:
        if (r16 >= r12) goto L28;
        char r18 = r10.charAt(r16);
        if (r18 < '0') goto L28;
        if (r18 > '9') goto L28;
        if (r17 != 0) goto L23;
        if (r11 == r16) goto L23;
        return false;
    L23:
        r17 = ((r17 * 10) + r18) - 48;
        if (r17 > 255) goto L25;
        r16 = r16 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r16 - r11) == 0) goto L29;
        r13[r15] = (byte) r17;
        r15 = r15 + 1;
        r11 = r16;
        goto L4
    L29:
        return false;
    L10:
        if (r10.charAt(r11) != '.') goto L11;
        r11 = r11 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r15 == (r14 + 4)) goto L34;
        return false;
    L34:
        return true;
    }

    @Nullable
    private static InetAddress decodeIpv6(String r12, int r13, int r14) {
        byte[] r10 = new byte[16];
        int r11 = 0;
        int r15 = -1;
        int r16 = -1;
    L4:
        if (r13 >= r14) goto L42;
        if (r11 == 16) goto L6;
        int r17 = r13 + 2;
        if (r17 <= r14) goto L10;
    L17:
        if (r11 != 0) goto L19;
    L21:
        r16 = r13;
    L29:
        int r18 = 0;
        r13 = r16;
    L30:
        if (r13 >= r14) goto L35;
        int r19 = decodeHexDigit(r12.charAt(r13));
        if (r19 == (-1)) goto L35;
        r18 = (r18 << 4) + r19;
        r13 = r13 + 1;
    L35:
        int r110 = r13 - r16;
        if (r110 == 0) goto L41;
        if (r110 > 4) goto L41;
        int r20 = r11 + 1;
        r10[r11] = (byte) ((r18 >>> 8) & PrivateKeyType.INVALID);
        r11 = r11 + 2;
        r10[r20] = (byte) (r18 & PrivateKeyType.INVALID);
    L41:
        return null;
    L19:
        if (r12.regionMatches(r13, ":", 0, 1) == false) goto L23;
        r13 = r13 + 1;
        goto L21
    L23:
        if (r12.regionMatches(r13, LibrarianImpl.Constants.DOT, 0, 1) == true) goto L25;
        return null;
    L25:
        if (decodeIpv4Suffix(r12, r16, r14, r10, r11 - 2) == true) goto L27;
        return null;
    L27:
        r11 = r11 + 2;
        goto L42
    L10:
        if (r12.regionMatches(r13, "::", 0, 2) == false) goto L17;
        if (r15 != (-1)) goto L12;
        r11 = r11 + 2;
        r15 = r11;
        if (r17 == r14) goto L42;
        r16 = r17;
        goto L29
    L12:
        return null;
    L6:
        return null;
    L42:
        if (r11 == 16) goto L50;
        if (r15 != (-1)) goto L45;
        return null;
    L45:
        int r111 = r11 - r15;
        System.arraycopy(r10, r15, r10, 16 - r111, r111);
        Arrays.fill(r10, r15, (16 - r11) + r15, (byte) 0);
    L50:
        return InetAddress.getByAddress(r10);
    L49:
        throw new AssertionError();
    }

    public static int delimiterOffset(String r10, int r11, int r12, String r13) {
    L2:
        if (r11 >= r12) goto L7;
        if (r13.indexOf(r10.charAt(r11)) != (-1)) goto L5;
        r11 = r11 + 1;
        goto L2
    L5:
        return r11;
    L7:
        return r12;
    }

    public static boolean discard(Source r10, int r11, TimeUnit r12) {
        return skipAll(r10, r11, r12);
    L4:
        return false;
    }

    public static boolean equal(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static String format(String r10, Object... r11) {
        return String.format(Locale.US, r10, r11);
    }

    public static String hostHeader(HttpUrl r10, boolean r11) {
        if (r10.m().contains(":") == false) goto L5;
        String r12 = "[" + r10.m() + "]";
    L6:
        if (r11 == true) goto L10;
        if (r10.z() != HttpUrl.e(r10.G())) goto L10;
        return r12;
    L10:
        return r12 + ":" + r10.z();
    L5:
        r12 = r10.m();
        goto L6
    }

    public static <T> List<T> immutableList(List<T> r10) {
        return Collections.unmodifiableList(new ArrayList(r10));
    }

    public static int indexOf(Comparator<String> r10, String[] r11, String r12) {
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        if (r10.compare(r11[r14], r12) == 0) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return -1;
    }

    public static int indexOfControlOrNonAscii(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        char r13 = r10.charAt(r12);
        if (r13 <= 31) goto L10;
        if (r13 >= 127) goto L10;
        r12 = r12 + 1;
    L10:
        return r12;
    L11:
        return -1;
    }

    private static String inet6AddressToAscii(byte[] r10) {
        int r11 = -1;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length) goto L18;
        int r15 = r13;
    L6:
        if (r15 >= 16) goto L12;
        if (r10[r15] != 0) goto L12;
        if (r10[r15 + 1] != 0) goto L12;
        r15 = r15 + 2;
    L12:
        int r16 = r15 - r13;
        if (r16 <= r14) goto L17;
        if (r16 < 4) goto L17;
        r11 = r13;
        r14 = r16;
    L17:
        r13 = r15 + 2;
        goto L4
    L18:
        Buffer r17 = new Buffer();
    L20:
        if (r12 >= r10.length) goto L30;
        if (r12 == r11) goto L23;
        if (r12 <= 0) goto L28;
        r17.t(58);
    L28:
        r17.v(((r10[r12] & UnsignedBytes.MAX_VALUE) << 8) | (r10[r12 + 1] & UnsignedBytes.MAX_VALUE));
        r12 = r12 + 2;
        goto L20
    L23:
        r17.t(58);
        r12 = r12 + r14;
        if (r12 != 16) goto L20;
        r17.t(58);
        goto L20
    L30:
        return r17.readUtf8();
    }

    public static String[] intersect(Comparator<? super String> r10, String[] r11, String[] r12) {
        ArrayList r13 = new ArrayList();
        int r14 = r11.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L12;
        String r16 = r11[r15];
        int r17 = r12.length;
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L10;
        if (r10.compare(r16, r12[r18]) == 0) goto L8;
        r18 = r18 + 1;
        goto L5
    L8:
        r13.add(r16);
    L10:
        r15 = r15 + 1;
        goto L3
    L12:
        return (String[]) r13.toArray(new String[r13.size()]);
    }

    public static boolean isAndroidGetsocknameError(AssertionError r10) {
        if (r10.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.getMessage() == null) goto L9;
        if (r10.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }

    public static boolean nonEmptyIntersection(Comparator<String> r10, String[] r11, String[] r12) {
        if (r11 == null) goto L20;
        if (r12 == null) goto L20;
        if (r11.length == 0) goto L20;
        if (r12.length == 0) goto L20;
        int r13 = r11.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L20;
        String r15 = r11[r14];
        int r16 = r12.length;
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L19;
        if (r10.compare(r15, r12[r17]) == 0) goto L16;
        r17 = r17 + 1;
        goto L13
    L16:
        return true;
    L19:
        r14 = r14 + 1;
    L20:
        return false;
    }

    public static boolean skipAll(Source r11, int r12, TimeUnit r13) throws IOException {
        long r10 = System.nanoTime();
        if (r11.timeout().hasDeadline() == false) goto L5;
        long r14 = r11.timeout().deadlineNanoTime() - r10;
    L6:
        r11.timeout().deadlineNanoTime(Math.min(r14, r13.toNanos(r12)) + r10);
        Buffer r15 = new Buffer();     // Catch: Throwable -> L12 InterruptedIOException -> L25
    L9:
        if (r11.read(r15, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L15;
        r15.a();     // Catch: Throwable -> L12 InterruptedIOException -> L25
        goto L26
    L15:
        if (r14 != Long.MAX_VALUE) goto L17;
        r11.timeout().clearDeadline();
        return true;
    L17:
        r11.timeout().deadlineNanoTime(r10 + r14);
        return true;
    L12:
        th = move-exception;
        if (r14 != Long.MAX_VALUE) goto L23;
        r11.timeout().clearDeadline();
    L24:
        throw th;
    L23:
        r11.timeout().deadlineNanoTime(r10 + r14);
    L26:
        if (r14 != Long.MAX_VALUE) goto L28;
        r11.timeout().clearDeadline();
        return false;
    L28:
        r11.timeout().deadlineNanoTime(r10 + r14);
        return false;
    L5:
        r14 = Long.MAX_VALUE;
        goto L6
    }

    public static int skipLeadingAsciiWhitespace(String r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L15;
        char r13 = r10.charAt(r11);
        if (r13 == '\t') goto L14;
        if (r13 == '\n') goto L14;
        if (r13 == '\f') goto L14;
        if (r13 == '\r') goto L14;
        if (r13 == ' ') goto L14;
        return r11;
    L14:
        r11 = r11 + 1;
        goto L2
    L15:
        return r12;
    }

    public static int skipTrailingAsciiWhitespace(String r10, int r11, int r12) {
        int r13 = r12 - 1;
    L3:
        if (r13 < r11) goto L17;
        char r14 = r10.charAt(r13);
        if (r14 == '\t') goto L16;
        if (r14 == '\n') goto L16;
        if (r14 == '\f') goto L16;
        if (r14 == '\r') goto L16;
        if (r14 == ' ') goto L16;
        return r13 + 1;
    L16:
        r13 = r13 - 1;
        goto L3
    L17:
        return r11;
    }

    public static ThreadFactory threadFactory(final String r10, final boolean r11) {
        return new AnonymousClass2(r10, r11);
    }

    public static String trimSubstring(String r10, int r11, int r12) {
        int r13 = skipLeadingAsciiWhitespace(r10, r11, r12);
        return r10.substring(r13, skipTrailingAsciiWhitespace(r10, r13, r12));
    }

    public static boolean verifyAsIpAddress(String r10) {
        return VERIFY_AS_IP_ADDRESS.matcher(r10).matches();
    }

    public static int delimiterOffset(String r10, int r11, int r12, char r13) {
    L2:
        if (r11 >= r12) goto L7;
        if (r10.charAt(r11) == r13) goto L5;
        r11 = r11 + 1;
        goto L2
    L5:
        return r11;
    L7:
        return r12;
    }

    public static <T> List<T> immutableList(T... r10) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) r10.clone()));
    }

    public static void closeQuietly(Socket r10) {
        if (r10 != null) goto L14;
        return;
    L14:
        r10.close();     // Catch: RuntimeException -> L5 AssertionError -> L7 Throwable -> L13
        goto L18
    L16:
        return;
    L7:
        e = move-exception;
        if (isAndroidGetsocknameError(e) == true) goto L17;
        throw e;
    L17:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void closeQuietly(ServerSocket r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: RuntimeException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }
}
