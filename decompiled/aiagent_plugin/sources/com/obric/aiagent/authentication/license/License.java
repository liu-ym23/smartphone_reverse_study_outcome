package com.obric.aiagent.authentication.license;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: License.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class License {

    @SerializedName("content")
    private final JsonObject content;

    @SerializedName("signature")
    private final String signature;

    @SerializedName("version")
    private final int version;

    public static /* synthetic */ License copy$default(License r0, int r1, JsonObject r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.version;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.signature;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.version;
    }

    public final JsonObject component2() {
        return this.content;
    }

    public final String component3() {
        return this.signature;
    }

    public final License copy(int r1, JsonObject r2, String r3) {
        o.e(r2, "content");
        o.e(r3, "signature");
        return new License(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, License.class) == true) goto L8;
        return false;
    L8:
        License r6 = (License) ZeusTransformUtils.preCheckCast(r5, License.class, "com.obric.aiagent.plugin");
        if (this.version == r6.version) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.signature, r6.signature) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.version) * 31) + this.content.hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "License(version=" + this.version + ", content=" + this.content + ", signature=" + this.signature + ')';
    }

    public License(int r2, JsonObject r3, String r4) {
        o.e(r3, "content");
        o.e(r4, "signature");
        this.version = r2;
        this.content = r3;
        this.signature = r4;
    }

    public final int getVersion() {
        return this.version;
    }

    public final JsonObject getContent() {
        return this.content;
    }

    public final String getSignature() {
        return this.signature;
    }
}
