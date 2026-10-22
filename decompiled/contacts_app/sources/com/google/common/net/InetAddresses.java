package com.google.common.net;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
public final class InetAddresses {
    private static final Inet4Address ANY4 = null;
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Inet4Address LOOPBACK4 = null;

    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@Nullable Inet4Address r7, @Nullable Inet4Address r8, int r9, int r10) {
            if (r9 < 0) goto L6;
            if (r9 > 65535) goto L6;
            boolean r3 = true;
        L7:
            Preconditions.checkArgument(r3, "port '%s' is out of range (0 <= port <= 0xffff)", new Object[]{Integer.valueOf(r9)});
            if (r10 < 0) goto L11;
            if (r10 > 65535) goto L11;
            boolean r0 = true;
        L12:
            Preconditions.checkArgument(r0, "flags '%s' is out of range (0 <= flags <= 0xffff)", new Object[]{Integer.valueOf(r10)});
            this.server = (Inet4Address) MoreObjects.firstNonNull(r7, InetAddresses.access$000());
            this.client = (Inet4Address) MoreObjects.firstNonNull(r8, InetAddresses.access$000());
            this.port = r9;
            this.flags = r10;
            return;
        L11:
            r0 = false;
        L6:
            r3 = false;
            goto L7
        }

        public Inet4Address getServer() {
            return this.server;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getPort() {
            return this.port;
        }

        public int getFlags() {
            return this.flags;
        }
    }

    static /* synthetic */ Inet4Address access$000() {
        return ANY4;
    }

    static {
        LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
        ANY4 = (Inet4Address) forString("0.0.0.0");
    }

    private InetAddresses() {
    }

    private static Inet4Address getInet4Address(byte[] r4) {
        if (r4.length != 4) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Byte array has invalid length for an IPv4 address: %s != 4.", new Object[]{Integer.valueOf(r4.length)});
        return (Inet4Address) bytesToInetAddress(r4);
    L5:
        r0 = false;
        goto L6
    }

    public static InetAddress forString(String r3) {
        byte[] r0 = ipStringToBytes(r3);
        if (r0 == null) goto L7;
        return bytesToInetAddress(r0);
    L7:
        throw new IllegalArgumentException(String.format("'%s' is not an IP string literal.", new Object[]{r3}));
    }

    public static boolean isInetAddress(String r0) {
        if (ipStringToBytes(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static byte[] ipStringToBytes(String r7) {
        int r0 = 0;
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0 >= r7.length()) goto L17;
        char r3 = r7.charAt(r0);
        if (r3 != '.') goto L9;
        r2 = true;
    L16:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r3 != ':') goto L14;
        if (r2 == true) goto L11;
        r1 = true;
        goto L16
    L11:
        return null;
    L14:
        if (Character.digit(r3, 16) != (-1)) goto L16;
        return null;
    L17:
        if (r1 == false) goto L24;
        if (r2 == false) goto L23;
        r7 = convertDottedQuadToHex(r7);
        if (r7 != null) goto L23;
        return null;
    L23:
        return textToNumericFormatV6(r7);
    L24:
        if (r2 == true) goto L26;
        return null;
    L26:
        return textToNumericFormatV4(r7);
    }

    private static byte[] textToNumericFormatV4(String r5) {
        String[] r6 = r5.split("\\.", 5);
        if (r6.length == 4) goto L5;
        return null;
    L5:
        byte[] r0 = new byte[4];
        int r3 = 0;
    L6:
        if (r3 >= 4) goto L10;
        r0[r3] = parseOctet(r6[r3]);     // Catch: NumberFormatException -> L9
        r3 = r3 + 1;
    L9:
        return null;
    L10:
        return r0;
    }

    private static byte[] textToNumericFormatV6(String r8) {
        String[] r9 = r8.split(SimContactsConstants.ANR_SEP, 10);
        if (r9.length >= 3) goto L5;
    L48:
        return null;
    L5:
        if (r9.length > 9) goto L48;
        int r0 = -1;
        int r3 = 1;
    L9:
        if (r3 >= (r9.length - 1)) goto L17;
        if (r9[r3].length() != 0) goto L15;
        if (r0 >= 0) goto L13;
        r0 = r3;
        goto L15
    L13:
        return null;
    L15:
        r3 = r3 + 1;
        goto L9
    L17:
        if (r0 < 0) goto L29;
        int r4 = (r9.length - r0) - 1;
        if (r9[0].length() != 0) goto L23;
        int r5 = r0 - 1;
        if (r5 == 0) goto L25;
        return null;
    L25:
        if (r9[r9.length - 1].length() != 0) goto L30;
        r4 = r4 - 1;
        if (r4 == 0) goto L30;
        return null;
    L30:
        int r6 = 8 - (r5 + r4);
        if (r0 < 0) goto L34;
        if (r6 >= 1) goto L36;
    L35:
        return null;
    L36:
        ByteBuffer r1 = ByteBuffer.allocate(16);
        int r2 = 0;
    L37:
        if (r2 >= r5) goto L39;
        r1.putShort(parseHextet(r9[r2]));     // Catch: NumberFormatException -> L45
        r2 = r2 + 1;     // Catch: NumberFormatException -> L45
    L45:
        return null;
    L39:
        int r7 = 0;
    L40:
        if (r7 >= r6) goto L42;
        r1.putShort(0);     // Catch: NumberFormatException -> L45
        r7 = r7 + 1;     // Catch: NumberFormatException -> L45
    L42:
        if (r4 <= 0) goto L47;
        r1.putShort(parseHextet(r9[r9.length - r4]));     // Catch: NumberFormatException -> L45
        r4 = r4 - 1;
        goto L42
    L47:
        return r1.array();
    L34:
        if (r6 == 0) goto L36;
    L23:
        r5 = r0;
        goto L25
    L29:
        r5 = r9.length;
        r4 = 0;
        goto L30
    }

    private static String convertDottedQuadToHex(String r4) {
        int r0 = r4.lastIndexOf(58) + 1;
        String r3 = r4.substring(0, r0);
        byte[] r5 = textToNumericFormatV4(r4.substring(r0));
        if (r5 != null) goto L7;
        return null;
    L7:
        return r3 + Integer.toHexString(((r5[0] & 255) << 8) | (r5[1] & 255)) + SimContactsConstants.ANR_SEP + Integer.toHexString((r5[3] & 255) | ((r5[2] & 255) << 8));
    }

    private static byte parseOctet(String r2) {
        int r0 = Integer.parseInt(r2);
        if (r0 > 255) goto L11;
        if (r2.startsWith("0") == false) goto L9;
        if (r2.length() > 1) goto L11;
    L9:
        return (byte) r0;
    L11:
        throw new NumberFormatException();
    }

    private static short parseHextet(String r1) {
        int r2 = Integer.parseInt(r1, 16);
        if (r2 > 65535) goto L7;
        return (short) r2;
    L7:
        throw new NumberFormatException();
    }

    private static InetAddress bytesToInetAddress(byte[] r1) {
        return InetAddress.getByAddress(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static String toAddrString(InetAddress r6) {
        Preconditions.checkNotNull(r6);
        if ((r6 instanceof Inet4Address) == true) goto L5;
        Preconditions.checkArgument(r6 instanceof Inet6Address);
        byte[] r7 = r6.getAddress();
        int[] r1 = new int[8];
        int r3 = 0;
    L7:
        if (r3 >= 8) goto L9;
        int r4 = r3 * 2;
        r1[r3] = Ints.fromBytes((byte) 0, (byte) 0, r7[r4], r7[r4 + 1]);
        r3 = r3 + 1;
        goto L7
    L9:
        compressLongestRunOfZeroes(r1);
        return hextetsToIPv6String(r1);
    L5:
        return r6.getHostAddress();
    }

    private static void compressLongestRunOfZeroes(int[] r6) {
        int r1 = 0;
        int r2 = -1;
        int r3 = -1;
        int r4 = -1;
    L4:
        if (r1 >= (r6.length + 1)) goto L18;
        if (r1 < r6.length) goto L8;
    L11:
        if (r4 < 0) goto L16;
        int r5 = r1 - r4;
        if (r5 <= r2) goto L15;
        r3 = r4;
        r2 = r5;
    L15:
        r4 = -1;
    L16:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6[r1] != 0) goto L11;
        if (r4 >= 0) goto L16;
        r4 = r1;
        goto L16
    L18:
        if (r2 < 2) goto L26;
        Arrays.fill(r6, r3, r2 + r3, -1);
        return;
    }

    private static String hextetsToIPv6String(int[] r5) {
        StringBuilder r0 = new StringBuilder(39);
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r5.length) goto L18;
        if (r5[r2] < 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        if (r3 == false) goto L12;
        r0.append(':');
    L12:
        r0.append(Integer.toHexString(r5[r2]));
    L16:
        r2 = r2 + 1;
        r3 = r4;
        goto L4
    L13:
        if (r2 == 0) goto L15;
        if (r3 == false) goto L16;
    L15:
        r0.append("::");
        goto L16
    L8:
        r4 = false;
        goto L9
    L18:
        return r0.toString();
    }

    public static String toUriString(InetAddress r2) {
        if ((r2 instanceof Inet6Address) == false) goto L7;
        return "[" + toAddrString(r2) + "]";
    L7:
        return toAddrString(r2);
    }

    public static InetAddress forUriString(String r4) {
        Preconditions.checkNotNull(r4);
        if (r4.startsWith("[") == true) goto L5;
    L7:
        int r2 = 4;
        String r0 = r4;
    L8:
        byte[] r1 = ipStringToBytes(r0);
        if (r1 == null) goto L15;
        if (r1.length != r2) goto L15;
        return bytesToInetAddress(r1);
    L15:
        throw new IllegalArgumentException(String.format("Not a valid URI IP literal: '%s'", new Object[]{r4}));
    L5:
        if (r4.endsWith("]") == false) goto L7;
        r0 = r4.substring(1, r4.length() - 1);
        r2 = 16;
        goto L8
    }

    public static boolean isUriInetAddress(String r0) {
        forUriString(r0);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    public static boolean isCompatIPv4Address(Inet6Address r3) {
        if (r3.isIPv4CompatibleAddress() == true) goto L5;
        return false;
    L5:
        byte[] r4 = r3.getAddress();
        if (r4[12] == 0) goto L8;
    L15:
        return true;
    L8:
        if (r4[13] != 0) goto L15;
        if (r4[14] != 0) goto L15;
        byte r5 = r4[15];
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L15;
    L14:
        return false;
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address r4) {
        Preconditions.checkArgument(isCompatIPv4Address(r4), "Address '%s' is not IPv4-compatible.", new Object[]{toAddrString(r4)});
        return getInet4Address(Arrays.copyOfRange(r4.getAddress(), 12, 16));
    }

    public static boolean is6to4Address(Inet6Address r3) {
        byte[] r4 = r3.getAddress();
        if (r4[0] == 32) goto L5;
        return false;
    L5:
        if (r4[1] == 2) goto L7;
        return false;
    L7:
        return true;
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address r4) {
        Preconditions.checkArgument(is6to4Address(r4), "Address '%s' is not a 6to4 address.", new Object[]{toAddrString(r4)});
        return getInet4Address(Arrays.copyOfRange(r4.getAddress(), 2, 6));
    }

    public static boolean isTeredoAddress(Inet6Address r3) {
        byte[] r4 = r3.getAddress();
        if (r4[0] == 32) goto L5;
        return false;
    L5:
        if (r4[1] == 1) goto L7;
        return false;
    L7:
        if (r4[2] == 0) goto L9;
        return false;
    L9:
        if (r4[3] == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public static TeredoInfo getTeredoInfo(Inet6Address r6) {
        int r3 = 0;
        Preconditions.checkArgument(isTeredoAddress(r6), "Address '%s' is not a Teredo address.", new Object[]{toAddrString(r6)});
        byte[] r7 = r6.getAddress();
        Inet4Address r0 = getInet4Address(Arrays.copyOfRange(r7, 4, 8));
        int r1 = ByteStreams.newDataInput(r7, 8).readShort() & UShort.MAX_VALUE;
        int r2 = 65535 & (~ByteStreams.newDataInput(r7, 10).readShort());
        byte[] r8 = Arrays.copyOfRange(r7, 12, 16);
    L4:
        if (r3 >= r8.length) goto L7;
        r8[r3] = (byte) (~r8[r3]);
        r3 = r3 + 1;
        goto L4
    L7:
        return new TeredoInfo(r0, getInet4Address(r8), r2, r1);
    }

    public static boolean isIsatapAddress(Inet6Address r3) {
        if (isTeredoAddress(r3) == false) goto L5;
        return false;
    L5:
        byte[] r4 = r3.getAddress();
        if ((r4[8] | 3) == 3) goto L9;
        return false;
    L9:
        if (r4[9] == 0) goto L11;
        return false;
    L11:
        if (r4[10] == 94) goto L13;
        return false;
    L13:
        if (r4[11] != (-2)) goto L18;
        return true;
    L18:
        return false;
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address r4) {
        Preconditions.checkArgument(isIsatapAddress(r4), "Address '%s' is not an ISATAP address.", new Object[]{toAddrString(r4)});
        return getInet4Address(Arrays.copyOfRange(r4.getAddress(), 12, 16));
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address r1) {
        if (isCompatIPv4Address(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (is6to4Address(r1) == true) goto L10;
        if (isTeredoAddress(r1) == true) goto L10;
        return false;
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address r3) {
        if (isCompatIPv4Address(r3) == false) goto L7;
        return getCompatIPv4Address(r3);
    L7:
        if (is6to4Address(r3) == false) goto L11;
        return get6to4IPv4Address(r3);
    L11:
        if (isTeredoAddress(r3) == false) goto L15;
        return getTeredoInfo(r3).getClient();
    L15:
        throw new IllegalArgumentException(String.format("'%s' has no embedded IPv4 address.", new Object[]{toAddrString(r3)}));
    }

    public static boolean isMappedIPv4Address(String r4) {
        byte[] r5 = ipStringToBytes(r4);
        if (r5 != null) goto L5;
    L21:
        return false;
    L5:
        if (r5.length != 16) goto L21;
        int r1 = 0;
    L7:
        int r2 = 10;
        if (r1 >= 10) goto L14;
        if (r5[r1] != 0) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        return false;
    L14:
        if (r2 >= 12) goto L19;
        if (r5[r2] != (-1)) goto L17;
        r2 = r2 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress r6) {
        if ((r6 instanceof Inet4Address) == true) goto L5;
        byte[] r0 = r6.getAddress();
        int r2 = 0;
    L8:
        if (r2 >= 15) goto L13;
        if (r0[r2] != 0) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
    L19:
        if (r3 == true) goto L21;
    L24:
        Inet6Address r7 = (Inet6Address) r6;
        if (hasEmbeddedIPv4ClientAddress(r7) == false) goto L27;
        long r1 = getEmbeddedIPv4ClientAddress(r7).hashCode();
    L28:
        int r8 = Hashing.murmur3_32().hashLong(r1).asInt() | SlardarConfigConsts.MONITOR_RUN_MODE_MASK;
        if (r8 != (-1)) goto L32;
        r8 = -2;
    L32:
        return getInet4Address(Ints.toByteArray(r8));
    L27:
        r1 = ByteBuffer.wrap(r7.getAddress(), 0, 8).getLong();
        goto L28
    L21:
        if (r0[15] != 0) goto L24;
        return ANY4;
    L16:
        if (r0[15] != 1) goto L19;
        return LOOPBACK4;
    L13:
        r3 = true;
        goto L14
    L5:
        return (Inet4Address) r6;
    }

    public static int coerceToInteger(InetAddress r0) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(r0).getAddress()).readInt();
    }

    public static Inet4Address fromInteger(int r0) {
        return getInet4Address(Ints.toByteArray(r0));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] r3) throws UnknownHostException {
        byte[] r0 = new byte[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L7;
        r0[r1] = r3[(r3.length - r1) - 1];
        r1 = r1 + 1;
        goto L4
    L7:
        return InetAddress.getByAddress(r0);
    }

    public static InetAddress decrement(InetAddress r6) {
        byte[] r0 = r6.getAddress();
        int r1 = r0.length - 1;
    L3:
        if (r1 < 0) goto L8;
        if (r0[r1] != 0) goto L8;
        r0[r1] = -1;
        r1 = r1 - 1;
    L8:
        if (r1 < 0) goto L10;
        boolean r4 = true;
    L11:
        Preconditions.checkArgument(r4, "Decrementing %s would wrap.", new Object[]{r6});
        r0[r1] = (byte) (r0[r1] - 1);
        return bytesToInetAddress(r0);
    L10:
        r4 = false;
        goto L11
    }

    public static InetAddress increment(InetAddress r6) {
        byte[] r0 = r6.getAddress();
        int r1 = r0.length - 1;
    L4:
        if (r1 < 0) goto L8;
        if (r0[r1] != (-1)) goto L8;
        r0[r1] = 0;
        r1 = r1 - 1;
    L8:
        if (r1 < 0) goto L10;
        boolean r4 = true;
    L11:
        Preconditions.checkArgument(r4, "Incrementing %s would wrap.", new Object[]{r6});
        r0[r1] = (byte) (r0[r1] + 1);
        return bytesToInetAddress(r0);
    L10:
        r4 = false;
        goto L11
    }

    public static boolean isMaximum(InetAddress r4) {
        byte[] r5 = r4.getAddress();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L9;
        if (r5[r1] != (-1)) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }
}
