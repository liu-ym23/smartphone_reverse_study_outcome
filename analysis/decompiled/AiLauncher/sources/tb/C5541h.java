package tb;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.sse.ServerSentEventKt;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import okio.ByteString;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0003(!\u000fB#\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ltb/h;", "", "", "Ltb/h$c;", "pins", "LIb/c;", "certificateChainCleaner", "<init>", "(Ljava/util/Set;LIb/c;)V", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/a;)V", "e", "(Ljava/lang/String;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LIb/c;)Ltb/h;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "LIb/c;", "f", "()LIb/c;", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5541h {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final C5541h f42190d = new a().b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Set<c> pins;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Ib.c certificateChainCleaner;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltb/h$a;", "", "<init>", "()V", "", "pattern", "", "pins", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;[Ljava/lang/String;)Ltb/h$a;", "Ltb/h;", Const.INTENT_KEY_PKGNAME, "()Ltb/h;", "", "Ltb/h$c;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<c> pins = new ArrayList();

        public final a a(String pattern, String... pins) {
            kotlin.jvm.internal.p.i(pattern, "pattern");
            kotlin.jvm.internal.p.i(pins, "pins");
            for (String str : pins) {
                this.pins.add(new c(pattern, str));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C5541h b() {
            return new C5541h(Z8.F.r1(this.pins), null, 2, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltb/h$b;", "", "<init>", "()V", "Ljava/security/cert/X509Certificate;", "Lokio/ByteString;", Const.INTENT_KEY_PKGNAME, "(Ljava/security/cert/X509Certificate;)Lokio/ByteString;", "c", "Ljava/security/cert/Certificate;", "certificate", "", Const.INTENT_KEY_APIKEY, "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Ltb/h;", "DEFAULT", "Ltb/h;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.h$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(Certificate certificate) {
            kotlin.jvm.internal.p.i(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + c((X509Certificate) certificate).a();
        }

        public final ByteString b(X509Certificate x509Certificate) {
            kotlin.jvm.internal.p.i(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.p.h(encoded, "getEncoded(...)");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, null).H();
        }

        public final ByteString c(X509Certificate x509Certificate) {
            kotlin.jvm.internal.p.i(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.p.h(encoded, "getEncoded(...)");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, null).J();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a¨\u0006\u001c"}, d2 = {"Ltb/h$c;", "", "", "pattern", com.stepos.ailauncher.chat.trace.f.ACTION_PIN, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "hostname", "", "c", "(Ljava/lang/String;)Z", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getPattern", Const.INTENT_KEY_PKGNAME, "hashAlgorithm", "Lokio/ByteString;", "Lokio/ByteString;", "()Lokio/ByteString;", "hash", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.h$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String pattern;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String hashAlgorithm;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final ByteString hash;

        /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(java.lang.String r12, java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.C5541h.c.<init>(java.lang.String, java.lang.String):void");
        }

        /* renamed from: a, reason: from getter */
        public final ByteString getHash() {
            return this.hash;
        }

        /* renamed from: b, reason: from getter */
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final boolean c(String hostname) {
            kotlin.jvm.internal.p.i(hostname, "hostname");
            if (La.D.X(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                return La.D.O(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null) && (length2 == 0 || hostname.charAt(length2 - 1) == '.');
            }
            if (!La.D.X(this.pattern, "*.", false, 2, null)) {
                return kotlin.jvm.internal.p.d(hostname, this.pattern);
            }
            int length3 = this.pattern.length() - 1;
            return La.D.O(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) && H.A0(hostname, '.', (hostname.length() - length3) + (-1), false, 4, null) == -1;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return kotlin.jvm.internal.p.d(this.pattern, cVar.pattern) && kotlin.jvm.internal.p.d(this.hashAlgorithm, cVar.hashAlgorithm) && kotlin.jvm.internal.p.d(this.hash, cVar.hash);
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + JsonPointer.SEPARATOR + this.hash.a();
        }
    }

    public C5541h(Set<c> pins, Ib.c cVar) {
        kotlin.jvm.internal.p.i(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = cVar;
    }

    public static final List c(C5541h c5541h, List list, String str) {
        List<Certificate> listA;
        Ib.c cVar = c5541h.certificateChainCleaner;
        if (cVar != null && (listA = cVar.a(list, str)) != null) {
            list = listA;
        }
        List<Certificate> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (Certificate certificate : list2) {
            kotlin.jvm.internal.p.g(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    public final void b(final String hostname, final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.p.i(hostname, "hostname");
        kotlin.jvm.internal.p.i(peerCertificates, "peerCertificates");
        d(hostname, new InterfaceC5063a() { // from class: tb.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5541h.c(this.f42186a, peerCertificates, hostname);
            }
        });
    }

    public final void d(String hostname, InterfaceC5063a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.p.i(hostname, "hostname");
        kotlin.jvm.internal.p.i(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> listE = e(hostname);
        if (listE.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ByteString byteStringC = null;
            ByteString byteStringB = null;
            for (c cVar : listE) {
                String hashAlgorithm = cVar.getHashAlgorithm();
                if (kotlin.jvm.internal.p.d(hashAlgorithm, "sha256")) {
                    if (byteStringC == null) {
                        byteStringC = INSTANCE.c(x509Certificate);
                    }
                    if (kotlin.jvm.internal.p.d(cVar.getHash(), byteStringC)) {
                        return;
                    }
                } else {
                    if (!kotlin.jvm.internal.p.d(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.getHashAlgorithm());
                    }
                    if (byteStringB == null) {
                        byteStringB = INSTANCE.b(x509Certificate);
                    }
                    if (kotlin.jvm.internal.p.d(cVar.getHash(), byteStringB)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb2.append("\n    ");
            sb2.append(INSTANCE.a(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(hostname);
        sb2.append(ServerSentEventKt.COLON);
        for (c cVar2 : listE) {
            sb2.append("\n    ");
            sb2.append(cVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public final List<c> e(String hostname) {
        kotlin.jvm.internal.p.i(hostname, "hostname");
        Set<c> set = this.pins;
        List<c> listM = C1173v.m();
        for (Object obj : set) {
            if (((c) obj).c(hostname)) {
                if (listM.isEmpty()) {
                    listM = new ArrayList<>();
                }
                kotlin.jvm.internal.p.g(listM, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                kotlin.jvm.internal.z.c(listM).add(obj);
            }
        }
        return listM;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5541h)) {
            return false;
        }
        C5541h c5541h = (C5541h) other;
        return kotlin.jvm.internal.p.d(c5541h.pins, this.pins) && kotlin.jvm.internal.p.d(c5541h.certificateChainCleaner, this.certificateChainCleaner);
    }

    /* renamed from: f, reason: from getter */
    public final Ib.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final C5541h g(Ib.c certificateChainCleaner) {
        kotlin.jvm.internal.p.i(certificateChainCleaner, "certificateChainCleaner");
        return kotlin.jvm.internal.p.d(this.certificateChainCleaner, certificateChainCleaner) ? this : new C5541h(this.pins, certificateChainCleaner);
    }

    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        Ib.c cVar = this.certificateChainCleaner;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public /* synthetic */ C5541h(Set set, Ib.c cVar, int i10, kotlin.jvm.internal.i iVar) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}
