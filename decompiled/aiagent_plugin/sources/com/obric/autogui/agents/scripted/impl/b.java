package com.obric.autogui.agents.scripted.impl;

import com.google.gson.annotations.SerializedName;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JSBounds.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("left")
    private final Integer f26974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("top")
    private final Integer f26975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("screenLeft")
    private final Integer f26976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("screenTop")
    private final Integer f26977e;

    @SerializedName("width")
    private final Integer f;

    @SerializedName("height")
    private final Integer g;

    /* JADX INFO: compiled from: JSBounds.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final b a(VHNode.Bounds r8) {
            d.h.b.o.e(r8, "bounds");
            return new b(Integer.valueOf(r8.getLeft()), Integer.valueOf(r8.getTop()), Integer.valueOf(r8.getScreenLeft()), Integer.valueOf(r8.getScreenTop()), Integer.valueOf(r8.getWidth()), Integer.valueOf(r8.getHeight()));
        }
    }

    static {
        f26973a = new a(null);
    }

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26974b, r6.f26974b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26975c, r6.f26975c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26976d, r6.f26976d) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26977e, r6.f26977e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f26974b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f26975c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.f26976d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.f26977e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.g;
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
        return "JSBounds(left=" + this.f26974b + ", top=" + this.f26975c + ", screenLeft=" + this.f26976d + ", screenTop=" + this.f26977e + ", width=" + this.f + ", height=" + this.g + ')';
    }

    public b(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6) {
        this.f26974b = r1;
        this.f26975c = r2;
        this.f26976d = r3;
        this.f26977e = r4;
        this.f = r5;
        this.g = r6;
    }

    public /* synthetic */ b(Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }
}
