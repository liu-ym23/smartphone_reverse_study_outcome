package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import h5.i;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import p5.l;
import p5.p;
import x5.m;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a1\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "params", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/a0;", "onStore", "Lcom/stepos/stepclaw/gateway/GatewayTlsConfig;", "buildGatewayTlsConfig", "(Lcom/stepos/stepclaw/gateway/GatewayTlsParams;Lp5/l;)Lcom/stepos/stepclaw/gateway/GatewayTlsConfig;", "host", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, "timeoutMs", "probeGatewayTlsFingerprint", "(Ljava/lang/String;IILf5/c;)Ljava/lang/Object;", "Ljavax/net/ssl/X509TrustManager;", "defaultTrustManager", "()Ljavax/net/ssl/X509TrustManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "data", "sha256Hex", "([B)Ljava/lang/String;", "raw", "normalizeFingerprint", "(Ljava/lang/String;)Ljava/lang/String;", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayTlsKt {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2", f = "GatewayTls.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ int $port;
        final /* synthetic */ int $timeoutMs;
        final /* synthetic */ String $trimmedHost;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i8, String str, int i9, f5.c cVar) {
            super(2, cVar);
            this.$timeoutMs = i8;
            this.$trimmedHost = str;
            this.$port = i9;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass2(this.$timeoutMs, this.$trimmedHost, this.$port, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
        
            r1 = new javax.net.ssl.SSLParameters();
            r1.setServerNames(a.a.S(new javax.net.ssl.SNIHostName(r5.$trimmedHost)));
            r6.setSSLParameters(r1);
         */
        /* JADX WARN: Type inference failed for: r6v2, types: [com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2$trustAll$1] */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyManagementException {
            /*
                r5 = this;
                g5.a r0 = g5.a.f2984a
                int r0 = r5.label
                if (r0 != 0) goto Lab
                a.a.c0(r6)
                com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2$trustAll$1 r6 = new com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2$trustAll$1
                r6.<init>()
                java.lang.String r0 = "TLS"
                javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)
                com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2$trustAll$1[] r6 = new com.stepos.stepclaw.gateway.GatewayTlsKt$probeGatewayTlsFingerprint$2$trustAll$1[]{r6}
                javax.net.ssl.TrustManager[] r6 = (javax.net.ssl.TrustManager[]) r6
                java.security.SecureRandom r1 = new java.security.SecureRandom
                r1.<init>()
                r2 = 0
                r0.init(r2, r6, r1)
                javax.net.ssl.SSLSocketFactory r6 = r0.getSocketFactory()
                java.net.Socket r6 = r6.createSocket()
                java.lang.String r0 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
                kotlin.jvm.internal.p.c(r6, r0)
                javax.net.ssl.SSLSocket r6 = (javax.net.ssl.SSLSocket) r6
                int r0 = r5.$timeoutMs     // Catch: java.lang.Throwable -> La7
                r6.setSoTimeout(r0)     // Catch: java.lang.Throwable -> La7
                java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> La7
                java.lang.String r1 = r5.$trimmedHost     // Catch: java.lang.Throwable -> La7
                int r3 = r5.$port     // Catch: java.lang.Throwable -> La7
                r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> La7
                int r1 = r5.$timeoutMs     // Catch: java.lang.Throwable -> La7
                r6.connect(r0, r1)     // Catch: java.lang.Throwable -> La7
                r0 = 0
                java.lang.String r1 = r5.$trimmedHost     // Catch: java.lang.Throwable -> L75
                r3 = r0
            L49:
                int r4 = r1.length()     // Catch: java.lang.Throwable -> L75
                if (r3 >= r4) goto L75
                char r4 = r1.charAt(r3)     // Catch: java.lang.Throwable -> L75
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                boolean r4 = java.lang.Character.isLetter(r4)     // Catch: java.lang.Throwable -> L75
                if (r4 == 0) goto L72
                javax.net.ssl.SSLParameters r1 = new javax.net.ssl.SSLParameters     // Catch: java.lang.Throwable -> L75
                r1.<init>()     // Catch: java.lang.Throwable -> L75
                javax.net.ssl.SNIHostName r3 = new javax.net.ssl.SNIHostName     // Catch: java.lang.Throwable -> L75
                java.lang.String r5 = r5.$trimmedHost     // Catch: java.lang.Throwable -> L75
                r3.<init>(r5)     // Catch: java.lang.Throwable -> L75
                java.util.List r5 = a.a.S(r3)     // Catch: java.lang.Throwable -> L75
                r1.setServerNames(r5)     // Catch: java.lang.Throwable -> L75
                r6.setSSLParameters(r1)     // Catch: java.lang.Throwable -> L75
                goto L75
            L72:
                int r3 = r3 + 1
                goto L49
            L75:
                r6.startHandshake()     // Catch: java.lang.Throwable -> La7
                javax.net.ssl.SSLSession r5 = r6.getSession()     // Catch: java.lang.Throwable -> La7
                java.security.cert.Certificate[] r5 = r5.getPeerCertificates()     // Catch: java.lang.Throwable -> La7
                java.lang.String r1 = "getPeerCertificates(...)"
                kotlin.jvm.internal.p.d(r5, r1)     // Catch: java.lang.Throwable -> La7
                int r1 = r5.length     // Catch: java.lang.Throwable -> La7
                if (r1 != 0) goto L8a
                r5 = r2
                goto L8c
            L8a:
                r5 = r5[r0]     // Catch: java.lang.Throwable -> La7
            L8c:
                boolean r0 = r5 instanceof java.security.cert.X509Certificate     // Catch: java.lang.Throwable -> La7
                if (r0 == 0) goto L93
                java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch: java.lang.Throwable -> La7
                goto L94
            L93:
                r5 = r2
            L94:
                if (r5 != 0) goto L9a
                r6.close()     // Catch: java.lang.Throwable -> L99
            L99:
                return r2
            L9a:
                byte[] r5 = r5.getEncoded()     // Catch: java.lang.Throwable -> La7
                java.lang.String r0 = "getEncoded(...)"
                kotlin.jvm.internal.p.d(r5, r0)     // Catch: java.lang.Throwable -> La7
                java.lang.String r2 = com.stepos.stepclaw.gateway.GatewayTlsKt.access$sha256Hex(r5)     // Catch: java.lang.Throwable -> La7
            La7:
                r6.close()     // Catch: java.lang.Throwable -> Laa
            Laa:
                return r2
            Lab:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayTlsKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.stepos.stepclaw.gateway.GatewayTlsKt$buildGatewayTlsConfig$trustManager$1, javax.net.ssl.X509TrustManager] */
    public static final GatewayTlsConfig buildGatewayTlsConfig(final GatewayTlsParams gatewayTlsParams, final l lVar) {
        if (gatewayTlsParams == null) {
            return null;
        }
        String expectedFingerprint = gatewayTlsParams.getExpectedFingerprint();
        final String strNormalizeFingerprint = expectedFingerprint != null ? normalizeFingerprint(expectedFingerprint) : null;
        final X509TrustManager x509TrustManagerDefaultTrustManager = defaultTrustManager();
        ?? r3 = new X509TrustManager() { // from class: com.stepos.stepclaw.gateway.GatewayTlsKt$buildGatewayTlsConfig$trustManager$1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                kotlin.jvm.internal.p.e(chain, "chain");
                kotlin.jvm.internal.p.e(authType, "authType");
                x509TrustManagerDefaultTrustManager.checkClientTrusted(chain, authType);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                kotlin.jvm.internal.p.e(chain, "chain");
                kotlin.jvm.internal.p.e(authType, "authType");
                if (chain.length == 0) {
                    throw new CertificateException("empty certificate chain");
                }
                byte[] encoded = chain[0].getEncoded();
                kotlin.jvm.internal.p.d(encoded, "getEncoded(...)");
                String strSha256Hex = GatewayTlsKt.sha256Hex(encoded);
                String str = strNormalizeFingerprint;
                if (str != null) {
                    if (!kotlin.jvm.internal.p.a(strSha256Hex, str)) {
                        throw new CertificateException("gateway TLS fingerprint mismatch");
                    }
                } else {
                    if (!gatewayTlsParams.getAllowTOFU()) {
                        x509TrustManagerDefaultTrustManager.checkServerTrusted(chain, authType);
                        return;
                    }
                    l lVar2 = lVar;
                    if (lVar2 != null) {
                        lVar2.invoke(strSha256Hex);
                    }
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] acceptedIssuers = x509TrustManagerDefaultTrustManager.getAcceptedIssuers();
                kotlin.jvm.internal.p.d(acceptedIssuers, "getAcceptedIssuers(...)");
                return acceptedIssuers;
            }
        };
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new GatewayTlsKt$buildGatewayTlsConfig$trustManager$1[]{r3}, new SecureRandom());
        HostnameVerifier fVar = (strNormalizeFingerprint != null || gatewayTlsParams.getAllowTOFU()) ? new f() : HttpsURLConnection.getDefaultHostnameVerifier();
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        kotlin.jvm.internal.p.d(socketFactory, "getSocketFactory(...)");
        kotlin.jvm.internal.p.b(fVar);
        return new GatewayTlsConfig(socketFactory, r3, fVar);
    }

    public static /* synthetic */ GatewayTlsConfig buildGatewayTlsConfig$default(GatewayTlsParams gatewayTlsParams, l lVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            lVar = null;
        }
        return buildGatewayTlsConfig(gatewayTlsParams, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean buildGatewayTlsConfig$lambda$0(String str, SSLSession sSLSession) {
        return true;
    }

    private static final X509TrustManager defaultTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManager trustManager;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        kotlin.jvm.internal.p.d(trustManagers, "getTrustManagers(...)");
        int length = trustManagers.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                trustManager = null;
                break;
            }
            trustManager = trustManagers[i8];
            if (trustManager instanceof X509TrustManager) {
                break;
            }
            i8++;
        }
        X509TrustManager x509TrustManager = trustManager instanceof X509TrustManager ? (X509TrustManager) trustManager : null;
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        throw new IllegalStateException("No default X509TrustManager found");
    }

    private static final String normalizeFingerprint(String str) {
        String input = n.T1(str).toString();
        m mVar = m.f6302b;
        Pattern patternCompile = Pattern.compile("^sha-?256\\s*:?\\s*", 66);
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        kotlin.jvm.internal.p.e(input, "input");
        String strReplaceAll = patternCompile.matcher(input).replaceAll(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        kotlin.jvm.internal.p.d(strReplaceAll, "replaceAll(...)");
        Locale US = Locale.US;
        kotlin.jvm.internal.p.d(US, "US");
        String lowerCase = strReplaceAll.toLowerCase(US);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        StringBuilder sb = new StringBuilder();
        int length = lowerCase.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = lowerCase.charAt(i8);
            if (('0' <= cCharAt && cCharAt < ':') || ('a' <= cCharAt && cCharAt < 'g')) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static final Object probeGatewayTlsFingerprint(String str, int i8, int i9, f5.c cVar) {
        String string = n.T1(str).toString();
        if (string.length() == 0 || 1 > i8 || i8 >= 65536) {
            return null;
        }
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new AnonymousClass2(i9, string, i8, null), cVar);
    }

    public static /* synthetic */ Object probeGatewayTlsFingerprint$default(String str, int i8, int i9, f5.c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i9 = 3000;
        }
        return probeGatewayTlsFingerprint(str, i8, i9, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sha256Hex(byte[] bArr) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        for (byte b9 : bArrDigest) {
            sb.append(String.format(Locale.US, "%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1)));
        }
        String string = sb.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }
}
