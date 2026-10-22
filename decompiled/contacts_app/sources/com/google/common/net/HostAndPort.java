package com.google.common.net;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private static boolean isValidPort(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 65535) goto L6;
        return true;
    }

    private HostAndPort(String r1, int r2, boolean r3) {
        this.host = r1;
        this.port = r2;
        this.hasBracketlessColons = r3;
    }

    public String getHostText() {
        return this.host;
    }

    public boolean hasPort() {
        if (this.port < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int r2) {
        if (hasPort() == true) goto L5;
        return r2;
    L5:
        return this.port;
    }

    public static HostAndPort fromParts(String r5, int r6) {
        Preconditions.checkArgument(isValidPort(r6), "Port out of range: %s", new Object[]{Integer.valueOf(r6)});
        HostAndPort r0 = fromString(r5);
        Preconditions.checkArgument(!r0.hasPort(), "Host has a port: %s", new Object[]{r5});
        return new HostAndPort(r0.host, r6, r0.hasBracketlessColons);
    }

    public static HostAndPort fromHost(String r4) {
        HostAndPort r0 = fromString(r4);
        Preconditions.checkArgument(!r0.hasPort(), "Host has a port: %s", new Object[]{r4});
        return r0;
    }

    public static HostAndPort fromString(String r9) {
        Preconditions.checkNotNull(r9);
        int r1 = -1;
        if (r9.startsWith("[") == false) goto L6;
        String[] r0 = getHostAndPortFromBracketedHost(r9);
        String r4 = r0[0];
        String r2 = r0[1];
    L5:
        String r5 = r4;
        boolean r6 = false;
    L16:
        if (Strings.isNullOrEmpty(r2) == true) goto L23;
        Preconditions.checkArgument(!r2.startsWith("+"), "Unparseable port number: %s", new Object[]{r9});
        r1 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L20
        Preconditions.checkArgument(isValidPort(r1), "Port number out of range: %s", new Object[]{r9});
    L21:
        throw new IllegalArgumentException("Unparseable port number: " + r9);
    L23:
        return new HostAndPort(r5, r1, r6);
    L6:
        int r7 = r9.indexOf(58);
        if (r7 < 0) goto L11;
        int r8 = r7 + 1;
        if (r9.indexOf(58, r8) != (-1)) goto L11;
        r4 = r9.substring(0, r7);
        r2 = r9.substring(r8);
    L11:
        if (r7 < 0) goto L13;
        boolean r3 = true;
    L14:
        r5 = r9;
        r6 = r3;
        r2 = null;
        goto L16
    L13:
        r3 = false;
        goto L14
    }

    private static String[] getHostAndPortFromBracketedHost(String r9) {
        if (r9.charAt(0) != '[') goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Bracketed host-port string must start with a bracket: %s", new Object[]{r9});
        int r2 = r9.indexOf(58);
        int r4 = r9.lastIndexOf(93);
        if (r2 <= (-1)) goto L10;
        if (r4 <= r2) goto L10;
        boolean r3 = true;
    L11:
        Preconditions.checkArgument(r3, "Invalid bracketed host/port: %s", new Object[]{r9});
        String r5 = r9.substring(1, r4);
        int r6 = r4 + 1;
        if (r6 != r9.length()) goto L16;
        return new String[]{r5, ""};
    L16:
        if (r9.charAt(r6) != ':') goto L18;
        boolean r7 = true;
    L19:
        Preconditions.checkArgument(r7, "Only a colon may follow a close bracket: %s", new Object[]{r9});
        int r8 = r4 + 2;
        int r10 = r8;
    L21:
        if (r10 >= r9.length()) goto L24;
        Preconditions.checkArgument(Character.isDigit(r9.charAt(r10)), "Port must be numeric: %s", new Object[]{r9});
        r10 = r10 + 1;
        goto L21
    L24:
        return new String[]{r5, r9.substring(r8)};
    L18:
        r7 = false;
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public HostAndPort withDefaultPort(int r3) {
        Preconditions.checkArgument(isValidPort(r3));
        if (hasPort() == false) goto L5;
    L9:
        return this;
    L5:
        if (this.port == r3) goto L9;
        return new HostAndPort(this.host, r3, this.hasBracketlessColons);
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", new Object[]{this.host});
        return this;
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HostAndPort) == false) goto L16;
        HostAndPort r6 = (HostAndPort) r5;
        if (Objects.equal(this.host, r6.host) == false) goto L15;
        if (this.port != r6.port) goto L15;
        if (this.hasBracketlessColons != r6.hasBracketlessColons) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.host, Integer.valueOf(this.port), Boolean.valueOf(this.hasBracketlessColons)});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r0.append(DefaultContactListAdapter.SNIPPET_START_MATCH).append(this.host).append(DefaultContactListAdapter.SNIPPET_END_MATCH);
    L7:
        if (hasPort() == false) goto L10;
        r0.append(':').append(this.port);
    L10:
        return r0.toString();
    L5:
        r0.append(this.host);
        goto L7
    }
}
