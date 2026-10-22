package com.obric.aiagent.skill.manager.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19987d;

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public static /* synthetic */ CharSequence lambda$6g4TuYNRUdwY7Q9nMJVq4KG1VcY(byte r0) {
            return a(r0);
        }

        private a() {
        }

        public final gg a(com.obric.aiagent.skill.manager.api.e r11, da r12, Gson r13) {
            d.h.b.o.e(r11, "skill");
            d.h.b.o.e(r12, "document");
            d.h.b.o.e(r13, "gson");
            JsonObject r10 = new JsonObject();
            r10.addProperty("slug", r11.a());
            r10.addProperty("displayName", r12.e());
            r10.addProperty("description", r12.b());
            r10.addProperty("version", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(hj.f20114a.b(r11.j())), Number.class, "com.obric.aiagent.plugin"));
            String r14 = r13.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
            d.h.b.o.a(r14);
            Charset r15 = StandardCharsets.UTF_8;
            d.h.b.o.c(r15, "UTF_8");
            byte[] r16 = r14.getBytes(r15);
            d.h.b.o.c(r16, "getBytes(...)");
            byte[] r1 = MessageDigest.getInstance("SHA-256").digest(r16);
            String r17 = Base64.getEncoder().encodeToString(r16);
            d.h.b.o.c(r17, "encodeToString(...)");
            d.h.b.o.a(r1);
            return new gg(r14, r17, d.a.i.a(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$gg$a$6g4TuYNRUdwY7Q9nMJVq4KG1VcY.INSTANCE, 30, null));
        }

        private static final CharSequence a(byte r3) {
            String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
            d.h.b.o.c(r4, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f19984a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gg.class) == true) goto L8;
        return false;
    L8:
        gg r6 = (gg) ZeusTransformUtils.preCheckCast(r5, gg.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19985b, r6.f19985b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19986c, r6.f19986c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19987d, r6.f19987d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f19985b.hashCode() * 31) + this.f19986c.hashCode()) * 31) + this.f19987d.hashCode();
    }

    public String toString() {
        return "SkillSigningMetadataSnapshot(json=" + this.f19985b + ", base64=" + this.f19986c + ", sha256=" + this.f19987d + ')';
    }

    public gg(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "json");
        d.h.b.o.e(r3, "base64");
        d.h.b.o.e(r4, "sha256");
        this.f19985b = r2;
        this.f19986c = r3;
        this.f19987d = r4;
    }

    public final String a() {
        return this.f19986c;
    }

    public final String b() {
        return this.f19987d;
    }
}
