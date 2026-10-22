package com.google.common.net;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class InetAddresses {
    private static final Inet4Address ANY4 = null;
    private static final int IPV4_PART_COUNT = 4;
    private static final Splitter IPV4_SPLITTER = null;
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV6_SPLITTER = null;
    private static final Inet4Address LOOPBACK4 = null;

    @Beta
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@NullableDecl Inet4Address r10, @NullableDecl Inet4Address r11, int r12, int r13) {
            boolean r14 = false;
            if (r12 < 0) goto L6;
            if (r12 > 65535) goto L6;
            boolean r15 = true;
        L7:
            Preconditions.checkArgument(r15, "port '%s' is out of range (0 <= port <= 0xffff)", r12);
            if (r13 < 0) goto L11;
            if (r13 > 65535) goto L11;
            r14 = true;
        L11:
            Preconditions.checkArgument(r14, "flags '%s' is out of range (0 <= flags <= 0xffff)", r13);
            this.server = (Inet4Address) MoreObjects.firstNonNull(r10, InetAddresses.access$000());
            this.client = (Inet4Address) MoreObjects.firstNonNull(r11, InetAddresses.access$000());
            this.port = r12;
            this.flags = r13;
            return;
        L6:
            r15 = false;
            goto L7
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }
    }

    static {
        IPV4_SPLITTER = Splitter.on('.').limit(4);
        IPV6_SPLITTER = Splitter.on(':').limit(10);
        LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
        ANY4 = (Inet4Address) forString("0.0.0.0");
    }

    private InetAddresses() {
    }

    public static /* synthetic */ Inet4Address access$000() {
        return ANY4;
    }

    private static InetAddress bytesToInetAddress(byte[] r10) {
        return InetAddress.getByAddress(r10);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static int coerceToInteger(InetAddress r10) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(r10).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] r10) {
        int r11 = 0;
        int r12 = -1;
        int r13 = -1;
        int r14 = -1;
    L4:
        if (r11 >= (r10.length + 1)) goto L18;
        if (r11 < r10.length) goto L8;
    L11:
        if (r14 < 0) goto L16;
        int r15 = r11 - r14;
        if (r15 <= r12) goto L15;
        r13 = r14;
        r12 = r15;
    L15:
        r14 = -1;
    L16:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r10[r11] != 0) goto L11;
        if (r14 >= 0) goto L16;
        r14 = r11;
        goto L16
    L18:
        if (r12 < 2) goto L26;
        Arrays.fill(r10, r13, r12 + r13, -1);
        return;
    }

    @NullableDecl
    private static String convertDottedQuadToHex(String r10) {
        int r11 = r10.lastIndexOf(58) + 1;
        String r12 = r10.substring(0, r11);
        byte[] r13 = textToNumericFormatV4(r10.substring(r11));
        if (r13 != null) goto L7;
        return null;
    L7:
        return r12 + Integer.toHexString(((r13[0] & UnsignedBytes.MAX_VALUE) << 8) | (r13[1] & UnsignedBytes.MAX_VALUE)) + ":" + Integer.toHexString((r13[3] & UnsignedBytes.MAX_VALUE) | ((r13[2] & UnsignedBytes.MAX_VALUE) << 8));
    }

    public static InetAddress decrement(InetAddress r10) {
        byte[] r11 = r10.getAddress();
        int r12 = r11.length - 1;
    L3:
        if (r12 < 0) goto L7;
        if (r11[r12] != 0) goto L7;
        r11[r12] = -1;
        r12 = r12 - 1;
    L7:
        if (r12 < 0) goto L9;
        boolean r13 = true;
    L10:
        Preconditions.checkArgument(r13, "Decrementing %s would wrap.", r10);
        r11[r12] = (byte) (r11[r12] - 1);
        return bytesToInetAddress(r11);
    L9:
        r13 = false;
        goto L10
    }

    public static InetAddress forString(String r10) {
        byte[] r11 = ipStringToBytes(r10);
        if (r11 == null) goto L7;
        return bytesToInetAddress(r11);
    L7:
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", new Object[]{r10});
    }

    public static InetAddress forUriString(String r10) {
        InetAddress r11 = forUriStringNoThrow(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", new Object[]{r10});
    }

    @NullableDecl
    private static InetAddress forUriStringNoThrow(String r10) {
        Preconditions.checkNotNull(r10);
        if (r10.startsWith("[") == true) goto L5;
    L7:
        int r11 = 4;
    L8:
        byte[] r12 = ipStringToBytes(r10);
        if (r12 != null) goto L11;
        return null;
    L11:
        if (r12.length == r11) goto L14;
        return null;
    L14:
        return bytesToInetAddress(r12);
    L5:
        if (r10.endsWith("]") == false) goto L7;
        r10 = r10.substring(1, r10.length() - 1);
        r11 = 16;
        goto L8
    }

    private static IllegalArgumentException formatIllegalArgumentException(String r10, Object... r11) {
        return new IllegalArgumentException(String.format(Locale.ROOT, r10, r11));
    }

    public static Inet4Address fromInteger(int r10) {
        return getInet4Address(Ints.toByteArray(r10));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] r10) throws UnknownHostException {
        byte[] r11 = new byte[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        r11[r12] = r10[(r10.length - r12) - 1];
        r12 = r12 + 1;
        goto L4
    L7:
        return InetAddress.getByAddress(r11);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address r10) {
        Preconditions.checkArgument(is6to4Address(r10), "Address '%s' is not a 6to4 address.", toAddrString(r10));
        return getInet4Address(Arrays.copyOfRange(r10.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress r10) {
        if ((r10 instanceof Inet4Address) == true) goto L5;
        byte[] r11 = r10.getAddress();
        int r12 = 0;
    L8:
        if (r12 >= 15) goto L13;
        if (r11[r12] != 0) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        boolean r13 = false;
    L14:
        if (r13 == true) goto L16;
    L19:
        if (r13 == true) goto L21;
    L24:
        Inet6Address r14 = (Inet6Address) r10;
        if (hasEmbeddedIPv4ClientAddress(r14) == false) goto L27;
        long r15 = getEmbeddedIPv4ClientAddress(r14).hashCode();
    L28:
        int r16 = Hashing.murmur3_32().hashLong(r15).asInt() | SlardarConfigConsts.MONITOR_RUN_MODE_MASK;
        if (r16 != (-1)) goto L32;
        r16 = -2;
    L32:
        return getInet4Address(Ints.toByteArray(r16));
    L27:
        r15 = ByteBuffer.wrap(r14.getAddress(), 0, 8).getLong();
        goto L28
    L21:
        if (r11[15] != 0) goto L24;
        return ANY4;
    L16:
        if (r11[15] != 1) goto L19;
        return LOOPBACK4;
    L13:
        r13 = true;
        goto L14
    L5:
        return (Inet4Address) r10;
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address r10) {
        Preconditions.checkArgument(isCompatIPv4Address(r10), "Address '%s' is not IPv4-compatible.", toAddrString(r10));
        return getInet4Address(Arrays.copyOfRange(r10.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address r10) {
        if (isCompatIPv4Address(r10) == false) goto L7;
        return getCompatIPv4Address(r10);
    L7:
        if (is6to4Address(r10) == false) goto L11;
        return get6to4IPv4Address(r10);
    L11:
        if (isTeredoAddress(r10) == false) goto L15;
        return getTeredoInfo(r10).getClient();
    L15:
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", new Object[]{toAddrString(r10)});
    }

    private static Inet4Address getInet4Address(byte[] r10) {
        if (r10.length != 4) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Byte array has invalid length for an IPv4 address: %s != 4.", r10.length);
        return (Inet4Address) bytesToInetAddress(r10);
    L5:
        r11 = false;
        goto L6
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address r10) {
        Preconditions.checkArgument(isIsatapAddress(r10), "Address '%s' is not an ISATAP address.", toAddrString(r10));
        return getInet4Address(Arrays.copyOfRange(r10.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address r10) {
        Preconditions.checkArgument(isTeredoAddress(r10), "Address '%s' is not a Teredo address.", toAddrString(r10));
        byte[] r11 = r10.getAddress();
        Inet4Address r12 = getInet4Address(Arrays.copyOfRange(r11, 4, 8));
        int r13 = ByteStreams.newDataInput(r11, 8).readShort() & 65535;
        int r14 = 65535 & (~ByteStreams.newDataInput(r11, 10).readShort());
        byte[] r15 = Arrays.copyOfRange(r11, 12, 16);
        int r16 = 0;
    L4:
        if (r16 >= r15.length) goto L7;
        r15[r16] = (byte) (~r15[r16]);
        r16 = r16 + 1;
        goto L4
    L7:
        return new TeredoInfo(r12, getInet4Address(r15), r14, r13);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address r10) {
        if (isCompatIPv4Address(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (is6to4Address(r10) == true) goto L10;
        if (isTeredoAddress(r10) == true) goto L10;
        return false;
    }

    private static String hextetsToIPv6String(int[] r10) {
        StringBuilder r11 = new StringBuilder(39);
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r12 >= r10.length) goto L18;
        if (r10[r12] < 0) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L13;
        if (r13 == false) goto L12;
        r11.append(':');
    L12:
        r11.append(Integer.toHexString(r10[r12]));
    L16:
        r12 = r12 + 1;
        r13 = r14;
        goto L4
    L13:
        if (r12 == 0) goto L15;
        if (r13 == false) goto L16;
    L15:
        r11.append("::");
        goto L16
    L8:
        r14 = false;
        goto L9
    L18:
        return r11.toString();
    }

    public static InetAddress increment(InetAddress r10) {
        byte[] r11 = r10.getAddress();
        int r12 = r11.length - 1;
    L3:
        boolean r13 = false;
        if (r12 < 0) goto L8;
        if (r11[r12] != (-1)) goto L8;
        r11[r12] = 0;
        r12 = r12 - 1;
    L8:
        if (r12 < 0) goto L10;
        r13 = true;
    L10:
        Preconditions.checkArgument(r13, "Incrementing %s would wrap.", r10);
        r11[r12] = (byte) (r11[r12] + 1);
        return bytesToInetAddress(r11);
    }

    @NullableDecl
    private static byte[] ipStringToBytes(String r10) {
        int r11 = 0;
        boolean r12 = false;
        boolean r13 = false;
    L4:
        if (r11 >= r10.length()) goto L17;
        char r14 = r10.charAt(r11);
        if (r14 != '.') goto L9;
        r13 = true;
    L16:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r14 != ':') goto L14;
        if (r13 == true) goto L11;
        r12 = true;
        goto L16
    L11:
        return null;
    L14:
        if (Character.digit(r14, 16) != (-1)) goto L16;
        return null;
    L17:
        if (r12 == false) goto L24;
        if (r13 == false) goto L23;
        r10 = convertDottedQuadToHex(r10);
        if (r10 != null) goto L23;
        return null;
    L23:
        return textToNumericFormatV6(r10);
    L24:
        if (r13 == true) goto L26;
        return null;
    L26:
        return textToNumericFormatV4(r10);
    }

    public static boolean is6to4Address(Inet6Address r10) {
        byte[] r11 = r10.getAddress();
        if (r11[0] == 32) goto L5;
        return false;
    L5:
        if (r11[1] == 2) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isCompatIPv4Address(Inet6Address r10) {
        if (r10.isIPv4CompatibleAddress() == true) goto L5;
        return false;
    L5:
        byte[] r11 = r10.getAddress();
        if (r11[12] == 0) goto L8;
    L15:
        return true;
    L8:
        if (r11[13] != 0) goto L15;
        if (r11[14] != 0) goto L15;
        byte r12 = r11[15];
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L15;
    L14:
        return false;
    }

    public static boolean isInetAddress(String r10) {
        if (ipStringToBytes(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isIsatapAddress(Inet6Address r10) {
        if (isTeredoAddress(r10) == false) goto L5;
        return false;
    L5:
        byte[] r11 = r10.getAddress();
        if ((r11[8] | 3) == 3) goto L9;
        return false;
    L9:
        if (r11[9] == 0) goto L11;
        return false;
    L11:
        if (r11[10] == 94) goto L13;
        return false;
    L13:
        if (r11[11] != (-2)) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean isMappedIPv4Address(String r10) {
        byte[] r11 = ipStringToBytes(r10);
        if (r11 != null) goto L5;
    L21:
        return false;
    L5:
        if (r11.length != 16) goto L21;
        int r12 = 0;
    L7:
        int r13 = 10;
        if (r12 >= 10) goto L14;
        if (r11[r12] != 0) goto L11;
        r12 = r12 + 1;
        goto L7
    L11:
        return false;
    L14:
        if (r13 >= 12) goto L19;
        if (r11[r13] != (-1)) goto L17;
        r13 = r13 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public static boolean isMaximum(InetAddress r10) {
        byte[] r11 = r10.getAddress();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        if (r11[r12] != (-1)) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address r10) {
        byte[] r11 = r10.getAddress();
        if (r11[0] == 32) goto L5;
        return false;
    L5:
        if (r11[1] == 1) goto L7;
        return false;
    L7:
        if (r11[2] == 0) goto L9;
        return false;
    L9:
        if (r11[3] == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isUriInetAddress(String r10) {
        if (forUriStringNoThrow(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static short parseHextet(String r10) {
        int r11 = Integer.parseInt(r10, 16);
        if (r11 > 65535) goto L7;
        return (short) r11;
    L7:
        throw new NumberFormatException();
    }

    private static byte parseOctet(String r10) {
        int r11 = Integer.parseInt(r10);
        if (r11 > 255) goto L11;
        if (r10.startsWith(AdReportParam.ClickPosType.SKIP) == false) goto L9;
        if (r10.length() > 1) goto L11;
    L9:
        return (byte) r11;
    L11:
        throw new NumberFormatException();
    }

    @NullableDecl
    private static byte[] textToNumericFormatV4(String r10) {
        byte[] r11 = new byte[4];
        Iterator<String> r12 = IPV4_SPLITTER.split(r10).iterator();     // Catch: NumberFormatException -> L12
        int r13 = 0;
    L5:
        if (r12.hasNext() == false) goto L8;
        int r14 = r13 + 1;     // Catch: NumberFormatException -> L12
        r11[r13] = parseOctet(r12.next());     // Catch: NumberFormatException -> L12
        r13 = r14;
        goto L5
    L8:
        if (r13 != 4) goto L11;
        return r11;
    L11:
        return null;
    L12:
        return null;
    }

    @NullableDecl
    private static byte[] textToNumericFormatV6(String r10) {
        List<String> r11 = IPV6_SPLITTER.splitToList(r10);
        if (r11.size() >= 3) goto L5;
    L48:
        return null;
    L5:
        if (r11.size() > 9) goto L48;
        int r12 = -1;
        int r13 = 1;
    L9:
        if (r13 >= (r11.size() - 1)) goto L17;
        if (r11.get(r13).length() != 0) goto L15;
        if (r12 >= 0) goto L13;
        r12 = r13;
        goto L15
    L13:
        return null;
    L15:
        r13 = r13 + 1;
        goto L9
    L17:
        if (r12 < 0) goto L29;
        int r14 = r11.size() - r12;
        int r15 = r14 - 1;
        if (r11.get(0).length() != 0) goto L23;
        int r16 = r12 - 1;
        if (r16 == 0) goto L25;
        return null;
    L25:
        if (((String) Iterables.getLast(r11)).length() != 0) goto L30;
        r15 = r14 - 2;
        if (r15 == 0) goto L30;
        return null;
    L30:
        int r17 = 8 - (r16 + r15);
        if (r12 < 0) goto L34;
        if (r17 >= 1) goto L36;
    L35:
        return null;
    L36:
        ByteBuffer r18 = ByteBuffer.allocate(16);
        int r19 = 0;
    L37:
        if (r19 >= r16) goto L39;
        r18.putShort(parseHextet(r11.get(r19)));     // Catch: NumberFormatException -> L45
        r19 = r19 + 1;     // Catch: NumberFormatException -> L45
    L45:
        return null;
    L39:
        int r20 = 0;
    L40:
        if (r20 >= r17) goto L42;
        r18.putShort(0);     // Catch: NumberFormatException -> L45
        r20 = r20 + 1;     // Catch: NumberFormatException -> L45
    L42:
        if (r15 <= 0) goto L47;
        r18.putShort(parseHextet(r11.get(r11.size() - r15)));     // Catch: NumberFormatException -> L45
        r15 = r15 - 1;
        goto L42
    L47:
        return r18.array();
    L34:
        if (r17 == 0) goto L36;
    L23:
        r16 = r12;
        goto L25
    L29:
        r16 = r11.size();
        r15 = 0;
        goto L30
    }

    public static String toAddrString(InetAddress r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof Inet4Address) == true) goto L5;
        Preconditions.checkArgument(r10 instanceof Inet6Address);
        byte[] r11 = r10.getAddress();
        int[] r12 = new int[8];
        int r13 = 0;
    L7:
        if (r13 >= 8) goto L9;
        int r14 = r13 * 2;
        r12[r13] = Ints.fromBytes((byte) 0, (byte) 0, r11[r14], r11[r14 + 1]);
        r13 = r13 + 1;
        goto L7
    L9:
        compressLongestRunOfZeroes(r12);
        return hextetsToIPv6String(r12);
    L5:
        return r10.getHostAddress();
    }

    public static String toUriString(InetAddress r10) {
        if ((r10 instanceof Inet6Address) == false) goto L7;
        return "[" + toAddrString(r10) + "]";
    L7:
        return toAddrString(r10);
    }
}
