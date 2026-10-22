package com.obric.oui.color;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StrokeConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34503a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f34504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.oui.a.a f34506d;

    /* JADX INFO: compiled from: StrokeConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f34503a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(this.f34504b), Float.valueOf(r6.f34504b)) == true) goto L12;
        return false;
    L12:
        if (this.f34505c == r6.f34505c) goto L15;
        return false;
    L15:
        if (this.f34506d == r6.f34506d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f34504b) * 31) + Integer.hashCode(this.f34505c)) * 31) + this.f34506d.hashCode();
    }

    public String toString() {
        return "StrokeConfig(width=" + this.f34504b + ", color=" + this.f34505c + ", blendMode=" + this.f34506d + ')';
    }

    public e(float r2, int r3, com.obric.oui.a.a r4) {
        o.e(r4, "blendMode");
        this.f34504b = r2;
        this.f34505c = r3;
        this.f34506d = r4;
    }

    public final float a() {
        return this.f34504b;
    }

    public final int b() {
        return this.f34505c;
    }

    public final com.obric.oui.a.a c() {
        return this.f34506d;
    }

    public final f d() {
        return new f(this.f34504b, this.f34505c, this.f34506d);
    }
}
