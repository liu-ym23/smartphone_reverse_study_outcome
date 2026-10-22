package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum fw extends Enum<fw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fw f19927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final fw f19928b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final fw f19929c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final fw f19930d = null;
    private static final /* synthetic */ fw[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19931e;

    private static final /* synthetic */ fw[] b() {
        return new fw[]{f19927a, f19928b, f19929c, f19930d};
    }

    private fw(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19931e = r3;
    }

    public final String a() {
        return this.f19931e;
    }

    static {
        f19927a = new fw("SERVER_EXACT_BYTES_BASE64", 0, "server_exact_bytes_base64");
        f19928b = new fw("SERVER_HTML_ESCAPED", 1, "server_html_escaped");
        f19929c = new fw("LEGACY_UNESCAPED", 2, "legacy_unescaped");
        f19930d = new fw("SERVER_AND_LEGACY_UNMATCHED", 3, "server_html_escaped+legacy_unescaped_unmatched");
        fw[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static fw valueOf(String r2) {
        return (fw) ZeusTransformUtils.preCheckCast(Enum.valueOf(fw.class, r2), fw.class, "com.obric.aiagent.plugin");
    }

    public static fw[] values() {
        return (fw[]) ZeusTransformUtils.preCheckCast(f.clone(), fw[].class, "com.obric.aiagent.plugin");
    }
}
