package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12954d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlendMode f12957c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12954d = new a(null);
    }

    public j0(float r10, int r11, BlendMode r12) {
        kotlin.jvm.internal.q.g(r12, "blendMode");
        this.f12955a = r10;
        this.f12956b = r11;
        this.f12957c = r12;
    }

    public final BlendMode a() {
        return this.f12957c;
    }

    public final int b() {
        return this.f12956b;
    }

    public final float c() {
        return this.f12955a;
    }

    public final k0 d() {
        return new k0(this.f12955a, this.f12956b, this.f12957c);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r11 = (j0) r10;
        if (kotlin.jvm.internal.q.b(Float.valueOf(this.f12955a), Float.valueOf(r11.f12955a)) == true) goto L12;
        return false;
    L12:
        if (this.f12956b == r11.f12956b) goto L15;
        return false;
    L15:
        if (this.f12957c == r11.f12957c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f12955a) * 31) + Integer.hashCode(this.f12956b)) * 31) + this.f12957c.hashCode();
    }

    public String toString() {
        return "StrokeConfig(width=" + this.f12955a + ", color=" + this.f12956b + ", blendMode=" + this.f12957c + ')';
    }
}
