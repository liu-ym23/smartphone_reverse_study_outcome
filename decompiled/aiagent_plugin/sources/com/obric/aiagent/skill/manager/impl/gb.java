package com.obric.aiagent.skill.manager.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gb implements cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19972a = null;
    private static final d.o.k f = null;
    private static final X500Principal g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f19974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Gson f19975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Gson f19976e;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.gb$1, reason: invalid class name */
    /* JADX INFO: compiled from: SkillSignatureVerifier.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f19977a = null;

        static {
            f19977a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: SkillSignatureVerifier.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public gb() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public gb(String r3, d.h.a.a<Long> r4) {
        d.h.a.a<Long> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "trustAnchorPem");
        d.h.b.o.e(r5, "verificationTimeMillis");
        this.f19973b = r3;
        this.f19974c = r5;
        this.f19975d = new GsonBuilder().create();
        this.f19976e = new GsonBuilder().disableHtmlEscaping().create();
    }

    public /* synthetic */ gb(String r2, d.h.a.a r3, int r4, d.h.b.h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = "-----BEGIN CERTIFICATE-----\nMIIChDCCAgugAwIBAgIUGCf2KtXCv2wJLJDhPWmqC4NogUcwCgYIKoZIzj0EAwMw\nWzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSQwIgYDVQQDExtCeXRlRGFuY2UgU21hcnQgRGV2aWNlIFJvb3QwHhcN\nMjUwMjI3MDQxNzI0WhcNNDUxMjMxMTYwMDAwWjBXMRIwEAYDVQQKEwlCeXRlRGFu\nY2UxHzAdBgNVBAsTFkJ5dGVEYW5jZSBTbWFydCBEZXZpY2UxIDAeBgNVBAMTF0J5\ndGVEYW5jZSBTbWFydCBTSUdOIENBMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE\nqEY1tOqjueVxviuVOIBdV+g2BqMOKTRYmTSx0vC9M2fKGCcJeFE32VqtYPtvyDgB\nmVZbvZYxnwdo6dx0MD6RtKOBsDCBrTAOBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/\nBAUwAwEB/zAdBgNVHQ4EFgQUYCEn27oKiFHtO+Q1xHonw5OL4QEwHwYDVR0jBBgw\nFoAU7K7HzdlIzACUAX0TGkAcXyFk6yQwSgYIKwYBBQUHAQEEPjA8MDoGCCsGAQUF\nBzABhi5odHRwOi8vbmV4dXMtcHJvZHVjdGlvbi5ieXRlZGFuY2UubmV0L3BjYS9v\nY3NwMAoGCCqGSM49BAMDA2cAMGQCMEafgMxo9+h04fWDCdF46K2II1RrOC9BUrRS\n50o7HM4wRjYNXTsF11J2enOaTzixzwIwL9l+Hq3OlSYLvRTOnIRD+DmpeSeTsbaV\nrMdjGbg1eRm2P59lkfFFES1BssyzQ5xd\n-----END CERTIFICATE-----";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f19977a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L8:
        this(r2, r6);
    }

    static /* synthetic */ fz a(gb r0, ah r1, fw r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = null;
    L6:
        return a(r0, r1, r2);
    }

    private static final fz a(gb r0, ah r1, fw r2) {
        return r0.a(r1, r2);
    }

    @Override // com.obric.aiagent.skill.manager.impl.cz
    public fz a(fy r15) {
        d.h.b.o.e(r15, "input");
        JsonElement r1 = r15.f();
        Object r3 = null;
        if (r1 == null) goto L206;
        JsonObject r2 = a(r1);
        if (r2 == null) goto L206;
        JsonObject r4 = a(r2, "payload");
        if (r4 == null) goto L10;
        JsonObject r5 = a(r2, "signature");
        if (r5 == null) goto L14;
        String r6 = b(r5, "sig");
        if (r6 == null) goto L18;
        String r7 = b(r5, "certificate");
        if (r7 == null) goto L22;
        JsonObject r8 = a(r5, "metadata");
        if (r8 == null) goto L26;
        String r9 = c(r8, "sign_version");
        if (r9 == null) goto L204;
        Integer r10 = d.o.o.d(r9);
        if (r10 == null) goto L204;
        int r11 = r10.intValue();
        if (r11 > 1) goto L202;
        if (r11 <= 0) goto L202;
        X509Certificate r12 = a(this.f19973b);
        if (r12 == null) goto L38;
        ah r13 = a(r12);
        if (r13 != null) goto L46;
        X509Certificate r14 = a(r7);
        if (r14 == null) goto L50;
        ah r16 = a(r12, r14);
        if (r16 != null) goto L54;
        byte[] r17 = b(r6);
        if (r17 == null) goto L58;
        String r18 = r15.g();
        if (r18 != null) goto L62;
    L64:
        r18 = null;
    L65:
        if (r18 == null) goto L79;
        fw r19 = fw.f19927a;
        byte[] r20 = c(r18);
        if (r20 != null) goto L71;
        return a(this, ah.o, r19);
    L71:
        if (a(r14, r20, r17) == false) goto L73;
        JsonObject r21 = a(r20);
        if (r21 == null) goto L77;
        d.m r22 = d.s.a(r21, r19);
    L94:
        JsonObject r23 = (JsonObject) ZeusTransformUtils.preCheckCast(r22.a(), JsonObject.class, "com.obric.aiagent.plugin");
        fw r24 = (fw) ZeusTransformUtils.preCheckCast(r22.b(), fw.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(b(r23, "manifest_version"), "1.0") == false) goto L97;
        JsonObject r25 = a(r23, DownloadHelper.IDENTITY);
        if (r25 == null) goto L101;
        JsonObject r26 = a(r23, "client_context");
        if (r26 == null) goto L105;
        String r27 = b(r25, "manifest_id");
        if (r27 == null) goto L109;
        String r28 = b(r25, "skill_hash");
        if (r28 == null) goto L113;
        String r29 = b(r26, "localSlug");
        if (r29 == null) goto L117;
        String r110 = b(r26, "localVersionId");
        if (r110 == null) goto L121;
        String r111 = b(r26, "packageSha256");
        if (r111 == null) goto L125;
        String r112 = b(r26, "metadataSha256");
        if (r112 == null) goto L129;
        String r30 = b(r26, "metadataBase64");
        if (r30 != null) goto L135;
        return a(this, ah.f19471c, r24);
    L135:
        if (d.h.b.o.a(r27, r15.a()) == true) goto L139;
        return a(this, ah.x, r24);
    L139:
        if (d.h.b.o.a(r29, r15.b()) == true) goto L143;
        return a(this, ah.y, r24);
    L143:
        if (d.h.b.o.a(r110, String.valueOf(r15.c())) == false) goto L145;
        byte[] r31 = a(r15.d(), false);
        if (r31 == null) goto L149;
        byte[] r32 = a(r28, true);
        if (r32 == null) goto L153;
        byte[] r33 = a(r111, false);
        if (r33 != null) goto L159;
        return a(this, ah.r, r24);
    L159:
        if (MessageDigest.isEqual(r31, r32) == false) goto L194;
        if (MessageDigest.isEqual(r31, r33) == false) goto L194;
        byte[] r113 = a(r15.e(), false);
        if (r113 == null) goto L166;
        byte[] r34 = a(r112, false);
        if (r34 == null) goto L170;
        d.n.a r35 = d.n.f38560a;     // Catch: Throwable -> L173
        gb r36 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L173
        Object r37 = d.n.f(Base64.getDecoder().decode(r30));     // Catch: Throwable -> L173
    L176:
        if (d.n.b(r37) == true) goto L179;
        r3 = r37;
    L179:
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L184;
        return a(this, ah.u, r24);
    L184:
        if (MessageDigest.isEqual(MessageDigest.getInstance("SHA-256").digest(r0), r34) == true) goto L188;
        return a(this, ah.v, r24);
    L188:
        if (MessageDigest.isEqual(r113, r34) == true) goto L192;
        return a(this, ah.w, r24);
    L192:
        return new fz(ga.f19968a, ah.f19469a, r24);
    L173:
        th = move-exception;
        d.n.a r38 = d.n.f38560a;
        r37 = d.n.f(d.o.a(th));
        goto L176
    L170:
        return a(this, ah.t, r24);
    L166:
        return a(this, ah.t, r24);
    L194:
        return a(this, ah.s, r24);
    L153:
        return a(this, ah.r, r24);
    L149:
        return a(this, ah.r, r24);
    L145:
        return a(this, ah.z, r24);
    L129:
        return a(this, ah.f19471c, r24);
    L125:
        return a(this, ah.f19471c, r24);
    L121:
        return a(this, ah.f19471c, r24);
    L117:
        return a(this, ah.f19471c, r24);
    L113:
        return a(this, ah.f19471c, r24);
    L109:
        return a(this, ah.f19471c, r24);
    L105:
        return a(this, ah.f19471c, r24);
    L101:
        return a(this, ah.f19471c, r24);
    L97:
        return a(this, ah.f19472d, r24);
    L77:
        return a(this, ah.p, r19);
    L73:
        return a(this, ah.q, r19);
    L79:
        String r39 = this.f19975d.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r39, "toJson(...)");
        Charset r114 = StandardCharsets.UTF_8;
        d.h.b.o.c(r114, "UTF_8");
        byte[] r40 = r39.getBytes(r114);
        d.h.b.o.c(r40, "getBytes(...)");
        String r115 = this.f19976e.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r115, "toJson(...)");
        Charset r41 = StandardCharsets.UTF_8;
        d.h.b.o.c(r41, "UTF_8");
        byte[] r42 = r115.getBytes(r41);
        d.h.b.o.c(r42, "getBytes(...)");
        List r116 = d.a.p.c(new d.m[]{d.s.a(fw.f19928b, r40)});
        if (Arrays.equals(r40, r42) == true) goto L82;
        ((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.aiagent.plugin")).add(d.s.a(fw.f19929c, r42));
    L82:
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L84:
        if (r43.hasNext() == false) goto L88;
        Object r44 = r43.next();
        if (a(r14, (byte[]) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r44, d.m.class, "com.obric.aiagent.plugin")).d(), byte[].class, "com.obric.aiagent.plugin"), r17) == false) goto L84;
    L89:
        d.m r45 = (d.m) ZeusTransformUtils.preCheckCast(r44, d.m.class, "com.obric.aiagent.plugin");
        if (r45 == null) goto L195;
        fw r46 = (fw) ZeusTransformUtils.preCheckCast(r45.a(), fw.class, "com.obric.aiagent.plugin");
        if (r46 == null) goto L195;
        r22 = d.s.a(r4, r46);
    L195:
        ah r117 = ah.q;
        if (r116.size() != 1) goto L198;
        fw r47 = fw.f19928b;
    L200:
        return a(this, r117, r47);
    L198:
        r47 = fw.f19930d;
        goto L200
    L88:
        r44 = null;
        goto L89
    L62:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L64;
    L58:
        return a(this, ah.n, null, 4, null);
    L54:
        return a(this, r16, null, 4, null);
    L50:
        return a(this, ah.h, null, 4, null);
    L46:
        return a(this, r13, null, 4, null);
    L38:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(this.f19973b, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("-----BEGIN CERTIFICATE-----", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L40;
        ah r118 = ah.g;
    L42:
        return a(this, r118, null, 4, null);
    L40:
        r118 = ah.f;
    L202:
        return a(this, ah.f19473e, null, 4, null);
    L204:
        return a(this, ah.f19471c, null, 4, null);
    L26:
        return a(this, ah.f19471c, null, 4, null);
    L22:
        return a(this, ah.f19471c, null, 4, null);
    L18:
        return a(this, ah.f19471c, null, 4, null);
    L14:
        return a(this, ah.f19470b, null, 4, null);
    L10:
        return a(this, ah.f19470b, null, 4, null);
    L206:
        return a(this, ah.f19470b, null, 4, null);
    }

    private final boolean a(X509Certificate r3, byte[] r4, byte[] r5) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        gb r2 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Signature r6 = Signature.getInstance("SHA256withECDSA");     // Catch: Throwable -> L5
        r6.initVerify(r3.getPublicKey());     // Catch: Throwable -> L5
        r6.update(r4);     // Catch: Throwable -> L5
        Object r7 = d.n.f(Boolean.valueOf(r6.verify(r5)));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r7) == false) goto L11;
        r7 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L8
    }

    private final ah a(X509Certificate r2) {
        ah r1 = b(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r2.getBasicConstraints() < 0) goto L8;
        boolean[] r3 = r2.getKeyUsage();
        if (r3 == null) goto L19;
        if (r3.length <= 5) goto L19;
        if (r3[5] == false) goto L19;
        return null;
    L19:
        return ah.g;
    L8:
        return ah.g;
    }

    private final ah a(X509Certificate r5, X509Certificate r6) {
        ah r0 = b(r6);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r6.getBasicConstraints() >= 0) goto L8;
        boolean[] r1 = r6.getKeyUsage();
        if (r1 == null) goto L21;
        if (r1.length != 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L19;
        if (r1[0] == true) goto L21;
    L19:
        return ah.h;
    L14:
        r2 = false;
    L21:
        if (d.h.b.o.a(r6.getSubjectX500Principal(), g) == false) goto L23;
        PublicKey r3 = r6.getPublicKey();
        if (ZeusTransformUtils.instanceOf(r3, ECPublicKey.class) == false) goto L27;
        ECPublicKey r4 = (ECPublicKey) ZeusTransformUtils.preCheckCast(r3, ECPublicKey.class, "com.obric.aiagent.plugin");
    L28:
        if (r4 != null) goto L32;
        return ah.m;
    L32:
        if (r4.getParams().getCurve().getField().getFieldSize() == 256) goto L36;
        return ah.m;
    L36:
        if (d.h.b.o.a(r6.getIssuerX500Principal(), r5.getSubjectX500Principal()) == false) goto L38;
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L41
        gb r8 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        r6.verify(r5.getPublicKey());     // Catch: Throwable -> L41
        Object r9 = d.n.f(null);     // Catch: Throwable -> L41
    L44:
        if (d.n.c(r9) == null) goto L48;
        r9 = ah.k;
    L48:
        return (ah) ZeusTransformUtils.preCheckCast(r9, ah.class, "com.obric.aiagent.plugin");
    L41:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L44
    L38:
        return ah.k;
    L27:
        r4 = null;
        goto L28
    L23:
        return ah.l;
    L8:
        return ah.h;
    }

    private final ah b(X509Certificate r4) {
        r4.checkValidity(new Date(((Number) ZeusTransformUtils.preCheckCast(this.f19974c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: CertificateNotYetValidException -> L4 CertificateExpiredException -> L5
        return null;
    L6:
        return ah.i;
    L10:
        return ah.j;
    }

    private final X509Certificate a(String r7) {
        Object r5 = null;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("-----BEGIN CERTIFICATE-----", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L15;
        return null;
    L15:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        gb r6 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        CertificateFactory r8 = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L7
        Charset r2 = StandardCharsets.US_ASCII;     // Catch: Throwable -> L7
        d.h.b.o.c(r2, "US_ASCII");     // Catch: Throwable -> L7
        byte[] r9 = r7.getBytes(r2);     // Catch: Throwable -> L7
        d.h.b.o.c(r9, "getBytes(...)");     // Catch: Throwable -> L7
        Certificate r10 = r8.generateCertificate((InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r9), InputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        d.h.b.o.a(r10, "null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L7
        Object r11 = d.n.f((X509Certificate) ZeusTransformUtils.preCheckCast(r10, X509Certificate.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r11) == true) goto L14;
        r5 = r11;
    L14:
        return (X509Certificate) ZeusTransformUtils.preCheckCast(r5, X509Certificate.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L10
    }

    private final byte[] b(String r3) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        gb r2 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = d.n.f(Base64.getUrlDecoder().decode(r3));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r4) == false) goto L10;
        r4 = null;
    L10:
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
        return null;
    L13:
        if (r5.length != 0) goto L15;
        boolean r6 = true;
    L17:
        if ((!r6) == true) goto L19;
        return null;
    L19:
        return r5;
    L15:
        r6 = false;
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    private final byte[] c(String r3) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        gb r2 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = d.n.f(Base64.getDecoder().decode(r3));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r4) == false) goto L10;
        r4 = null;
    L10:
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
        return null;
    L13:
        if (r5.length != 0) goto L15;
        boolean r6 = true;
    L17:
        if ((!r6) == true) goto L19;
        return null;
    L19:
        return r5;
    L15:
        r6 = false;
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    private final JsonObject a(byte[] r5) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        gb r3 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = d.n.f(StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r5)).toString());     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r6) == false) goto L10;
        r6 = null;
    L10:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L29;
        return null;
    L29:
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
        gb r8 = (gb) ZeusTransformUtils.preCheckCast(this, gb.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Object r9 = d.n.f(JsonParser.parseString(r7));     // Catch: Throwable -> L15
    L18:
        if (d.n.b(r9) == false) goto L20;
        r9 = null;
    L20:
        JsonElement r10 = (JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L23;
        return null;
    L23:
        if (r10.isJsonObject() == true) goto L26;
        r10 = null;
    L26:
        if (r10 != null) goto L28;
        return null;
    L28:
        return r10.getAsJsonObject();
    L15:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
    L5:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L8
    }

    private final byte[] a(String r5, boolean r6) {
        int r0 = 0;
        if (d.o.o.b(r5, "sha256:", false, 2, null) == false) goto L5;
        r5 = d.o.o.a(r5, (CharSequence) ZeusTransformUtils.preCheckCast("sha256:", CharSequence.class, "com.obric.aiagent.plugin"));
    L8:
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L10;
        return null;
    L10:
        byte[] r7 = new byte[32];
    L11:
        if (r0 >= 32) goto L13;
        int r1 = r0 * 2;
        String r2 = r5.substring(r1, r1 + 2);
        d.h.b.o.c(r2, "substring(...)");
        r7[r0] = (byte) Integer.parseInt(r2, d.o.a.a(16));
        r0 = r0 + 1;
        goto L11
    L13:
        return r7;
    L5:
        if (r6 == false) goto L8;
        return null;
    }

    private final fz a(ah r2, fw r3) {
        return new fz(ga.f19969b, r2, r3);
    }

    private final JsonObject a(JsonElement r2) {
        if (r2.isJsonObject() == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.getAsJsonObject();
    }

    private final JsonObject a(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isJsonObject() == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getAsJsonObject();
    }

    private final String b(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isJsonPrimitive() == true) goto L8;
    L12:
        return null;
    L8:
        if (r0.getAsJsonPrimitive().isString() == false) goto L12;
        return r0.getAsString();
    }

    private final String c(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        JsonPrimitive r3 = r0.getAsJsonPrimitive();
        if (r3.isString() == false) goto L12;
        return r3.getAsString();
    L12:
        if (r3.isNumber() == true) goto L14;
        return null;
    L14:
        return r3.getAsNumber().toString();
    }

    static {
        f19972a = new a(null);
        f = new d.o.k("[0-9a-fA-F]{64}");
        g = new X500Principal("CN=ByteDance Smart Sign Cert ocean_skill_hub,OU=ByteDance Smart Device,O=ByteDance");
    }
}
