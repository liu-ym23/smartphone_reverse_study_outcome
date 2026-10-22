package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f28154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f28155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28157e;
    private final boolean f;
    private final Integer g;

    public e() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    public static /* synthetic */ e a(e r8, String r9, List r10, j r11, String r12, String r13, boolean r14, Integer r15, int r16, Object r17) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 1) == 0) goto L5;
        String r2 = r8.f28153a;
    L7:
        if ((r16 & 2) == 0) goto L10;
        r1 = r8.f28154b;
    L10:
        if ((r16 & 4) == 0) goto L12;
        j r3 = r8.f28155c;
    L14:
        if ((r16 & 8) == 0) goto L16;
        String r4 = r8.f28156d;
    L18:
        if ((r16 & 16) == 0) goto L20;
        String r5 = r8.f28157e;
    L22:
        if ((r16 & 32) == 0) goto L24;
        boolean r6 = r8.f;
    L26:
        if ((r16 & 64) == 0) goto L28;
        Integer r7 = r8.g;
    L30:
        return r8.a(r2, r1, r3, r4, r5, r6, r7);
    L28:
        r7 = r15;
        goto L30
    L24:
        r6 = r14;
        goto L26
    L20:
        r5 = r13;
        goto L22
    L16:
        r4 = r12;
        goto L18
    L12:
        r3 = r11;
        goto L14
    L5:
        r2 = r9;
        goto L7
    }

    public final e a(String r9, List<String> r10, j r11, String r12, String r13, boolean r14, Integer r15) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "tags");
        return new e(r9, r2, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28153a, r6.f28153a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28154b, r6.f28154b) == true) goto L15;
        return false;
    L15:
        if (this.f28155c == r6.f28155c) goto L18;
        return false;
    L18:
        if (o.a(this.f28156d, r6.f28156d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28157e, r6.f28157e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.f28153a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.f28154b.hashCode()) * 31;
        j r4 = this.f28155c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f28156d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f28157e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + Boolean.hashCode(this.f)) * 31;
        Integer r13 = this.g;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "DataFeedbackUploadFeedbackInfo(content=" + this.f28153a + ", tags=" + this.f28154b + ", source=" + this.f28155c + ", type=" + this.f28156d + ", score=" + this.f28157e + ", needUploadImage=" + this.f + ", amount=" + this.g + ')';
    }

    public e(String r3, List<String> r4, j r5, String r6, String r7, boolean r8, Integer r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "tags");
        this.f28153a = r3;
        this.f28154b = r10;
        this.f28155c = r5;
        this.f28156d = r6;
        this.f28157e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final String a() {
        return this.f28153a;
    }

    public /* synthetic */ e(String r9, List r10, j r11, String r12, String r13, boolean r14, Integer r15, int r16, d.h.b.h r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Integer r2 = null;
        if ((r16 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r16 & 2) == 0) goto L10;
        r0 = p.b();
    L10:
        if ((r16 & 4) == 0) goto L12;
        j r3 = null;
    L14:
        if ((r16 & 8) == 0) goto L16;
        String r4 = null;
    L18:
        if ((r16 & 16) == 0) goto L20;
        String r5 = null;
    L22:
        if ((r16 & 32) == 0) goto L24;
        boolean r6 = true;
    L26:
        if ((r16 & 64) != 0) goto L29;
        r2 = r15;
    L29:
        this(r1, r0, r3, r4, r5, r6, r2);
        return;
    L24:
        r6 = r14;
        goto L26
    L20:
        r5 = r13;
        goto L22
    L16:
        r4 = r12;
        goto L18
    L12:
        r3 = r11;
        goto L14
    L5:
        r1 = r9;
        goto L7
    }

    public final List<String> b() {
        return this.f28154b;
    }

    public final j c() {
        return this.f28155c;
    }

    public final String getType() {
        return this.f28156d;
    }

    public final String d() {
        return this.f28157e;
    }

    public final boolean e() {
        return this.f;
    }

    public final Integer f() {
        return this.g;
    }

    public final boolean g() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f28153a, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (this.f28154b.isEmpty() == true) goto L13;
        return false;
    L13:
        if (this.f28155c != null) goto L38;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f28156d, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L39;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f28157e, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L25;
    L28:
        boolean r5 = true;
    L29:
        if (r5 == true) goto L31;
        return false;
    L31:
        if (this.f == true) goto L33;
        return false;
    L33:
        if (this.g == null) goto L35;
        return false;
    L35:
        return true;
    L25:
        if (d.o.o.d(r4) == true) goto L28;
        r5 = false;
        goto L29
    L39:
        return false;
    L17:
        if (d.o.o.d(r2) == true) goto L20;
        r3 = false;
        goto L21
    L38:
        return false;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ e a(e r0, j r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final e a(j r12, String r13) {
        o.e(r12, "defaultSource");
        j r0 = this.f28155c;
        if (r0 != null) goto L5;
        j r4 = r12;
    L6:
        String r14 = this.f28156d;
        if (r14 != null) goto L9;
        String r5 = r13;
    L11:
        return a(this, null, null, r4, r5, null, false, null, 115, null);
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r0;
        goto L6
    }
}
