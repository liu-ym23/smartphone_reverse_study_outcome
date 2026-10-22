package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ah extends Enum<ah> {
    private static final /* synthetic */ ah[] A = null;
    private static final /* synthetic */ d.d.a B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah f19469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ah f19470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ah f19471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ah f19472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ah f19473e = null;
    public static final ah f = null;
    public static final ah g = null;
    public static final ah h = null;
    public static final ah i = null;
    public static final ah j = null;
    public static final ah k = null;
    public static final ah l = null;
    public static final ah m = null;
    public static final ah n = null;
    public static final ah o = null;
    public static final ah p = null;
    public static final ah q = null;
    public static final ah r = null;
    public static final ah s = null;
    public static final ah t = null;
    public static final ah u = null;
    public static final ah v = null;
    public static final ah w = null;
    public static final ah x = null;
    public static final ah y = null;
    public static final ah z = null;

    public static d.d.a<ah> a() {
        return B;
    }

    private static final /* synthetic */ ah[] b() {
        return new ah[]{f19469a, f19470b, f19471c, f19472d, f19473e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
    }

    private ah(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19469a = new ah("OK", 0);
        f19470b = new ah("MISSING_ENVELOPE", 1);
        f19471c = new ah("MISSING_SIGNED_FIELD", 2);
        f19472d = new ah("UNSUPPORTED_MANIFEST_VERSION", 3);
        f19473e = new ah("UNSUPPORTED_SIGNATURE_VERSION", 4);
        f = new ah("MISSING_TRUST_ANCHOR", 5);
        g = new ah("INVALID_TRUST_ANCHOR", 6);
        h = new ah("INVALID_CERTIFICATE", 7);
        i = new ah("CERTIFICATE_EXPIRED", 8);
        j = new ah("CERTIFICATE_NOT_YET_VALID", 9);
        k = new ah("UNTRUSTED_CERTIFICATE", 10);
        l = new ah("UNEXPECTED_CERTIFICATE_IDENTITY", 11);
        m = new ah("UNSUPPORTED_PUBLIC_KEY", 12);
        n = new ah("INVALID_SIGNATURE_ENCODING", 13);
        o = new ah("INVALID_SIGNING_PAYLOAD_ENCODING", 14);
        p = new ah("INVALID_SIGNING_PAYLOAD_JSON", 15);
        q = new ah("SIGNATURE_MISMATCH", 16);
        r = new ah("INVALID_PACKAGE_HASH", 17);
        s = new ah("PACKAGE_HASH_MISMATCH", 18);
        t = new ah("INVALID_METADATA_HASH", 19);
        u = new ah("INVALID_METADATA_ENCODING", 20);
        v = new ah("SIGNED_METADATA_HASH_MISMATCH", 21);
        w = new ah("METADATA_HASH_MISMATCH", 22);
        x = new ah("MANIFEST_ID_MISMATCH", 23);
        y = new ah("SKILL_ID_MISMATCH", 24);
        z = new ah("SKILL_VERSION_MISMATCH", 25);
        ah[] r0 = b();
        A = r0;
        B = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ah valueOf(String r2) {
        return (ah) ZeusTransformUtils.preCheckCast(Enum.valueOf(ah.class, r2), ah.class, "com.obric.aiagent.plugin");
    }

    public static ah[] values() {
        return (ah[]) ZeusTransformUtils.preCheckCast(A.clone(), ah[].class, "com.obric.aiagent.plugin");
    }
}
