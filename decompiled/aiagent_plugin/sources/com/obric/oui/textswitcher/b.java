package com.obric.oui.textswitcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f36478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f36479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f36480c;

    public b() {
        this(null, null, null, 7, null);
    }

    public String toString() {
        return "TextSpec(textColor=" + this.f36478a + ", textSizeDp=" + this.f36479b + ", paddingDp=" + Arrays.toString(this.f36480c) + ')';
    }

    public b(Integer r2, Float r3, int[] r4) {
        o.e(r4, "paddingDp");
        this.f36478a = r2;
        this.f36479b = r3;
        this.f36480c = r4;
    }

    public final Integer a() {
        return this.f36478a;
    }

    public final Float b() {
        return this.f36479b;
    }

    public /* synthetic */ b(Integer r2, Float r3, int[] r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new int[]{0, 0, 0, 0};
    L11:
        this(r2, r3, r4);
    }

    public final int[] c() {
        return this.f36480c;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.textswitcher.TextSpec");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36478a, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36478a) == true) goto L16;
        return false;
    L16:
        if (o.a(this.f36479b, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36479b) == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f36480c, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36480c) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        Integer r0 = this.f36478a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Float r4 = this.f36479b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Arrays.hashCode(this.f36480c);
    L5:
        r2 = r0.intValue();
        goto L6
    }
}
