package com.obric.aiagent.llm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("index")
    private final int f18707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("message")
    private final e f18708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("finish_reason")
    private final String f18709c;

    public d() {
        this(0, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f18707a == r6.f18707a) goto L12;
        return false;
    L12:
        if (o.a(this.f18708b, r6.f18708b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18709c, r6.f18709c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f18707a) * 31;
        e r1 = this.f18708b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f18709c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Choice(index=" + this.f18707a + ", message=" + this.f18708b + ", finishReason=" + this.f18709c + ')';
    }

    public d(int r1, e r2, String r3) {
        this.f18707a = r1;
        this.f18708b = r2;
        this.f18709c = r3;
    }

    public /* synthetic */ d(int r2, e r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final e a() {
        return this.f18708b;
    }
}
