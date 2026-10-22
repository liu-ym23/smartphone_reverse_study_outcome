package com.obric.aiagent.llm;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f18702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("object")
    private final String f18703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("created")
    private final long f18704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("model")
    private final String f18705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("choices")
    private final List<d> f18706e;

    @SerializedName("usage")
    private final i f;

    @SerializedName("prompt_version")
    private final String g;

    @SerializedName("SpanContext")
    private final h h;

    public c() {
        this(null, null, 0, null, null, null, null, null, 255, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18702a, r10.f18702a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18703b, r10.f18703b) == true) goto L15;
        return false;
    L15:
        if (this.f18704c == r10.f18704c) goto L18;
        return false;
    L18:
        if (o.a(this.f18705d, r10.f18705d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f18706e, r10.f18706e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.f18702a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f18703b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Long.hashCode(this.f18704c)) * 31;
        String r7 = this.f18705d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f18706e.hashCode()) * 31;
        i r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        h r16 = this.h;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatCompletionResponse(id=" + this.f18702a + ", objectValue=" + this.f18703b + ", created=" + this.f18704c + ", model=" + this.f18705d + ", choices=" + this.f18706e + ", usage=" + this.f + ", promptVersion=" + this.g + ", spanContext=" + this.h + ')';
    }

    public c(String r3, String r4, long r5, String r7, List<d> r8, i r9, String r10, h r11) {
        List<d> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "choices");
        this.f18702a = r3;
        this.f18703b = r4;
        this.f18704c = r5;
        this.f18705d = r7;
        this.f18706e = r12;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }

    public final List<d> a() {
        return this.f18706e;
    }

    public /* synthetic */ c(String r11, String r12, long r13, String r15, List r16, i r17, String r18, h r19, int r20, d.h.b.h r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        h r3 = null;
        if ((r20 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r5 = 0;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r20 & 16) == 0) goto L22;
        r1 = p.b();
    L22:
        if ((r20 & 32) == 0) goto L24;
        i r8 = null;
    L26:
        if ((r20 & 64) == 0) goto L28;
        String r9 = null;
    L30:
        if ((r20 & 128) != 0) goto L33;
        r3 = r19;
    L33:
        this(r2, r4, r5, r7, r1, r8, r9, r3);
        return;
    L28:
        r9 = r18;
        goto L30
    L24:
        r8 = r17;
        goto L26
    L17:
        r7 = r15;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }
}
