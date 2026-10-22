package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.net.InetAddress;
import java.text.ParseException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class HostSpecifier {
    private final String canonicalForm;

    private HostSpecifier(String r10) {
        this.canonicalForm = r10;
    }

    public static HostSpecifier from(String r10) throws ParseException {
        return fromValid(r10);
    L4:
        e = move-exception;
        ParseException r11 = new ParseException("Invalid host specifier: " + r10, 0);
        r11.initCause(e);
        throw r11;
    }

    public static HostSpecifier fromValid(String r10) {
        HostAndPort r11 = HostAndPort.fromString(r10);
        Preconditions.checkArgument(!r11.hasPort());
        String r12 = r11.getHost();
        InetAddress r13 = InetAddresses.forString(r12);     // Catch: IllegalArgumentException -> L5
    L6:
        if (r13 != null) goto L8;
        InternetDomainName r14 = InternetDomainName.from(r12);
        if (r14.hasPublicSuffix() == false) goto L14;
        return new HostSpecifier(r14.toString());
    L14:
        throw new IllegalArgumentException("Domain name does not have a recognized public suffix: " + r12);
    L8:
        return new HostSpecifier(InetAddresses.toUriString(r13));
    L5:
        r13 = null;
        goto L6
    }

    public static boolean isValid(String r10) {
        fromValid(r10);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HostSpecifier) == true) goto L8;
        return false;
    L8:
        return this.canonicalForm.equals(((HostSpecifier) r10).canonicalForm);
    }

    public int hashCode() {
        return this.canonicalForm.hashCode();
    }

    public String toString() {
        return this.canonicalForm;
    }
}
