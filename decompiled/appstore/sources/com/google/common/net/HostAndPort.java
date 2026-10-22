package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
@GwtCompatible
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String r10, int r11, boolean r12) {
        this.host = r10;
        this.port = r11;
        this.hasBracketlessColons = r12;
    }

    public static HostAndPort fromHost(String r10) {
        HostAndPort r11 = fromString(r10);
        Preconditions.checkArgument(!r11.hasPort(), "Host has a port: %s", r10);
        return r11;
    }

    public static HostAndPort fromParts(String r10, int r11) {
        Preconditions.checkArgument(isValidPort(r11), "Port out of range: %s", r11);
        HostAndPort r12 = fromString(r10);
        Preconditions.checkArgument(!r12.hasPort(), "Host has a port: %s", r10);
        return new HostAndPort(r12.host, r11, r12.hasBracketlessColons);
    }

    public static HostAndPort fromString(String r10) {
        Preconditions.checkNotNull(r10);
        int r11 = -1;
        boolean r12 = false;
        if (r10.startsWith("[") == false) goto L5;
        String[] r13 = getHostAndPortFromBracketedHost(r10);
        String r14 = r13[0];
        String r15 = r13[1];
    L14:
        if (Strings.isNullOrEmpty(r15) == true) goto L21;
        Preconditions.checkArgument(!r15.startsWith("+"), "Unparseable port number: %s", r10);
        r11 = Integer.parseInt(r15);     // Catch: NumberFormatException -> L18
        Preconditions.checkArgument(isValidPort(r11), "Port number out of range: %s", r10);
    L19:
        throw new IllegalArgumentException("Unparseable port number: " + r10);
    L21:
        return new HostAndPort(r14, r11, r12);
    L5:
        int r16 = r10.indexOf(58);
        if (r16 < 0) goto L10;
        int r17 = r16 + 1;
        if (r10.indexOf(58, r17) != (-1)) goto L10;
        r14 = r10.substring(0, r16);
        r15 = r10.substring(r17);
    L10:
        if (r16 < 0) goto L12;
        r12 = true;
    L12:
        r15 = null;
        r14 = r10;
        goto L14
    }

    private static String[] getHostAndPortFromBracketedHost(String r10) {
        boolean r11 = false;
        if (r10.charAt(0) != '[') goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Bracketed host-port string must start with a bracket: %s", r10);
        int r13 = r10.indexOf(58);
        int r14 = r10.lastIndexOf(93);
        if (r13 <= (-1)) goto L10;
        if (r14 <= r13) goto L10;
        boolean r15 = true;
    L11:
        Preconditions.checkArgument(r15, "Invalid bracketed host/port: %s", r10);
        String r16 = r10.substring(1, r14);
        int r17 = r14 + 1;
        if (r17 != r10.length()) goto L16;
        return new String[]{r16, ""};
    L16:
        if (r10.charAt(r17) != ':') goto L18;
        r11 = true;
    L18:
        Preconditions.checkArgument(r11, "Only a colon may follow a close bracket: %s", r10);
        int r18 = r14 + 2;
        int r19 = r18;
    L20:
        if (r19 >= r10.length()) goto L23;
        Preconditions.checkArgument(Character.isDigit(r10.charAt(r19)), "Port must be numeric: %s", r10);
        r19 = r19 + 1;
        goto L20
    L23:
        return new String[]{r16, r10.substring(r18)};
    L10:
        r15 = false;
        goto L11
    L5:
        r12 = false;
        goto L6
    }

    private static boolean isValidPort(int r10) {
        if (r10 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r10 > 65535) goto L6;
        return true;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HostAndPort) == false) goto L14;
        HostAndPort r11 = (HostAndPort) r10;
        if (Objects.equal(this.host, r11.host) == false) goto L13;
        if (this.port != r11.port) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int r10) {
        if (hasPort() == true) goto L5;
        return r10;
    L5:
        return this.port;
    }

    public boolean hasPort() {
        if (this.port < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r10.append('[');
        r10.append(this.host);
        r10.append(']');
    L7:
        if (hasPort() == false) goto L10;
        r10.append(':');
        r10.append(this.port);
    L10:
        return r10.toString();
    L5:
        r10.append(this.host);
        goto L7
    }

    public HostAndPort withDefaultPort(int r10) {
        Preconditions.checkArgument(isValidPort(r10));
        if (hasPort() == false) goto L6;
        return this;
    L6:
        return new HostAndPort(this.host, r10, this.hasBracketlessColons);
    }
}
