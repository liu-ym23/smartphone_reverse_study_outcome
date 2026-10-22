package com.obric.oui.window.c;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: Bounds.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f36881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f36882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f36883d;

    public b(int r1, int r2, int r3, int r4) {
        this.f36880a = r1;
        this.f36881b = r2;
        this.f36882c = r3;
        this.f36883d = r4;
    }

    public b(Rect r4) {
        o.e(r4, "rect");
        this(r4.left, r4.top, r4.right, r4.bottom);
    }

    public final Rect a() {
        return new Rect(this.f36880a, this.f36881b, this.f36882c, this.f36883d);
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f36880a + ',' + this.f36881b + ',' + this.f36882c + ',' + this.f36883d + "] }";
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
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if (this.f36880a == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36880a) goto L16;
        return false;
    L16:
        if (this.f36881b == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36881b) goto L19;
        return false;
    L19:
        if (this.f36882c == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36882c) goto L22;
        return false;
    L22:
        if (this.f36883d == ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin")).f36883d) goto L24;
        return false;
    L24:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        return (((((this.f36880a * 31) + this.f36881b) * 31) + this.f36882c) * 31) + this.f36883d;
    }
}
