package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OnPageChangeListenerHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35398a;

    /* JADX INFO: compiled from: OnPageChangeListenerHelper.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f35401c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f35399a == r6.f35399a) goto L12;
            return false;
        L12:
            if (this.f35400b == r6.f35400b) goto L15;
            return false;
        L15:
            if (o.a(Float.valueOf(this.f35401c), Float.valueOf(r6.f35401c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f35399a) * 31) + Integer.hashCode(this.f35400b)) * 31) + Float.hashCode(this.f35401c);
        }

        public String toString() {
            return "ScrollState(selectedPosition=" + this.f35399a + ", nextPosition=" + this.f35400b + ", positionOffset=" + this.f35401c + ')';
        }

        public a(int r1, int r2, float r3) {
            this.f35399a = r1;
            this.f35400b = r2;
            this.f35401c = r3;
        }

        public final int a() {
            return this.f35399a;
        }

        public final int b() {
            return this.f35400b;
        }

        public final float c() {
            return this.f35401c;
        }
    }

    public abstract int a();

    public abstract void a(int r1, int r2, float r3);

    public j() {
        this.f35398a = "OnPageChangeHelper";
    }

    public final void a(int r3, float r4) {
        a r5 = b(r3, r4);
        if (r5 != null) goto L13;
        return;
    L13:
        a(r5.a(), r5.b(), r5.c());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, IndexOutOfBoundsException.class) == false) goto L11;
        com.obric.oui.common.util.e.f34568a.c(this.f35398a, o.a("OIndicator: ", e.getMessage()));
        return;
    L11:
        com.obric.oui.common.util.e.f34568a.a(this.f35398a, "抓住了一个Exception并ignore", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final a b(int r7, float r8) {
        int r0 = a();
        if (r0 > 0) goto L6;
        com.obric.oui.common.util.e.f34568a.c(this.f35398a, o.a("Ignore onPageScrolled because pageCount=", Integer.valueOf(r0)));
        return null;
    L6:
        boolean r3 = true;
        if (r0 == 1) goto L9;
        int r5 = r0 - 1;
        if (r7 < 0) goto L14;
        if (r7 > r5) goto L14;
    L15:
        if (r3 == true) goto L18;
        com.obric.oui.common.util.e.f34568a.c(this.f35398a, "Ignore onPageScrolled because position=" + r7 + ", pageCount=" + r0);
        return null;
    L18:
        if (r7 == r5) goto L20;
    L22:
        if (r7 != r5) goto L25;
        return new a(r5, r5, 0.0f);
    L25:
        return new a(r7, r7 + 1, r8);
    L20:
        if (r8 <= 0.0f) goto L22;
        return new a(r5, 0, r8);
    L14:
        r3 = false;
        goto L15
    L9:
        return new a(0, 0, 0.0f);
    }
}
