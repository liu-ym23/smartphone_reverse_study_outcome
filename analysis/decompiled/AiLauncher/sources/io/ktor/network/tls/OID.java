package io.ktor.network.tls;

import La.H;
import Z8.C1174w;
import Z8.F;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/ktor/network/tls/OID;", "", "", "identifier", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lio/ktor/network/tls/OID;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getIdentifier", "", "asArray", "[I", "getAsArray", "()[I", "Companion", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OID {
    private final int[] asArray;
    private final String identifier;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OID OrganizationName = new OID("2.5.4.10");
    private static final OID OrganizationalUnitName = new OID("2.5.4.11");
    private static final OID CountryName = new OID("2.5.4.6");
    private static final OID CommonName = new OID("2.5.4.3");
    private static final OID SubjectAltName = new OID("2.5.29.17");
    private static final OID BasicConstraints = new OID("2.5.29.19");
    private static final OID KeyUsage = new OID("2.5.29.15");
    private static final OID ExtKeyUsage = new OID("2.5.29.37");
    private static final OID ServerAuth = new OID("1.3.6.1.5.5.7.3.1");
    private static final OID ClientAuth = new OID("1.3.6.1.5.5.7.3.2");
    private static final OID RSAEncryption = new OID("1 2 840 113549 1 1 1");
    private static final OID ECEncryption = new OID("1.2.840.10045.2.1");
    private static final OID ECDSAwithSHA384Encryption = new OID("1.2.840.10045.4.3.3");
    private static final OID ECDSAwithSHA256Encryption = new OID("1.2.840.10045.4.3.2");
    private static final OID RSAwithSHA512Encryption = new OID("1.2.840.113549.1.1.13");
    private static final OID RSAwithSHA384Encryption = new OID("1.2.840.113549.1.1.12");
    private static final OID RSAwithSHA256Encryption = new OID("1.2.840.113549.1.1.11");
    private static final OID RSAwithSHA1Encryption = new OID("1.2.840.113549.1.1.5");
    private static final OID secp256r1 = new OID("1.2.840.10045.3.1.7");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\u0017\u0010!\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u0017\u0010#\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR\u0017\u0010%\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b&\u0010\fR\u0017\u0010'\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b(\u0010\fR\u0017\u0010)\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\fR\u0017\u0010+\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\fR\u0017\u0010-\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\fR\u0017\u0010/\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\f¨\u00061"}, d2 = {"Lio/ktor/network/tls/OID$Companion;", "", "<init>", "()V", "", "algorithm", "Lio/ktor/network/tls/OID;", "fromAlgorithm", "(Ljava/lang/String;)Lio/ktor/network/tls/OID;", "OrganizationName", "Lio/ktor/network/tls/OID;", "getOrganizationName", "()Lio/ktor/network/tls/OID;", "OrganizationalUnitName", "getOrganizationalUnitName", "CountryName", "getCountryName", "CommonName", "getCommonName", "SubjectAltName", "getSubjectAltName", "BasicConstraints", "getBasicConstraints", "KeyUsage", "getKeyUsage", "ExtKeyUsage", "getExtKeyUsage", "ServerAuth", "getServerAuth", "ClientAuth", "getClientAuth", "RSAEncryption", "getRSAEncryption", "ECEncryption", "getECEncryption", "ECDSAwithSHA384Encryption", "getECDSAwithSHA384Encryption", "ECDSAwithSHA256Encryption", "getECDSAwithSHA256Encryption", "RSAwithSHA512Encryption", "getRSAwithSHA512Encryption", "RSAwithSHA384Encryption", "getRSAwithSHA384Encryption", "RSAwithSHA256Encryption", "getRSAwithSHA256Encryption", "RSAwithSHA1Encryption", "getRSAwithSHA1Encryption", "secp256r1", "getSecp256r1", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        public final OID fromAlgorithm(String algorithm) {
            p.i(algorithm, "algorithm");
            switch (algorithm.hashCode()) {
                case -794853417:
                    if (algorithm.equals("SHA384withRSA")) {
                        return getRSAwithSHA384Encryption();
                    }
                    break;
                case -754115883:
                    if (algorithm.equals("SHA1withRSA")) {
                        return getRSAwithSHA1Encryption();
                    }
                    break;
                case -280290445:
                    if (algorithm.equals("SHA256withRSA")) {
                        return getRSAwithSHA256Encryption();
                    }
                    break;
                case 637568043:
                    if (algorithm.equals("SHA384withECDSA")) {
                        return getECDSAwithSHA384Encryption();
                    }
                    break;
                case 1211345095:
                    if (algorithm.equals("SHA256withECDSA")) {
                        return getECDSAwithSHA256Encryption();
                    }
                    break;
            }
            throw new IllegalStateException(("Could't find OID for " + algorithm).toString());
        }

        public final OID getBasicConstraints() {
            return OID.BasicConstraints;
        }

        public final OID getClientAuth() {
            return OID.ClientAuth;
        }

        public final OID getCommonName() {
            return OID.CommonName;
        }

        public final OID getCountryName() {
            return OID.CountryName;
        }

        public final OID getECDSAwithSHA256Encryption() {
            return OID.ECDSAwithSHA256Encryption;
        }

        public final OID getECDSAwithSHA384Encryption() {
            return OID.ECDSAwithSHA384Encryption;
        }

        public final OID getECEncryption() {
            return OID.ECEncryption;
        }

        public final OID getExtKeyUsage() {
            return OID.ExtKeyUsage;
        }

        public final OID getKeyUsage() {
            return OID.KeyUsage;
        }

        public final OID getOrganizationName() {
            return OID.OrganizationName;
        }

        public final OID getOrganizationalUnitName() {
            return OID.OrganizationalUnitName;
        }

        public final OID getRSAEncryption() {
            return OID.RSAEncryption;
        }

        public final OID getRSAwithSHA1Encryption() {
            return OID.RSAwithSHA1Encryption;
        }

        public final OID getRSAwithSHA256Encryption() {
            return OID.RSAwithSHA256Encryption;
        }

        public final OID getRSAwithSHA384Encryption() {
            return OID.RSAwithSHA384Encryption;
        }

        public final OID getRSAwithSHA512Encryption() {
            return OID.RSAwithSHA512Encryption;
        }

        public final OID getSecp256r1() {
            return OID.secp256r1;
        }

        public final OID getServerAuth() {
            return OID.ServerAuth;
        }

        public final OID getSubjectAltName() {
            return OID.SubjectAltName;
        }

        private Companion() {
        }
    }

    public OID(String identifier) {
        p.i(identifier, "identifier");
        this.identifier = identifier;
        List listB1 = H.b1(identifier, new String[]{".", " "}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(C1174w.x(listB1, 10));
        Iterator it = listB1.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(H.D1((String) it.next()).toString())));
        }
        this.asArray = F.l1(arrayList);
    }

    public static /* synthetic */ OID copy$default(OID oid, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = oid.identifier;
        }
        return oid.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    public final OID copy(String identifier) {
        p.i(identifier, "identifier");
        return new OID(identifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OID) && p.d(this.identifier, ((OID) other).identifier);
    }

    public final int[] getAsArray() {
        return this.asArray;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return "OID(identifier=" + this.identifier + ')';
    }
}
