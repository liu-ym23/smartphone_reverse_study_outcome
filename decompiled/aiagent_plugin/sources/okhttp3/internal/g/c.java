package okhttp3.internal.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39968a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e.h f39969e = null;
    public static final e.h f = null;
    public static final e.h g = null;
    public static final e.h h = null;
    public static final e.h i = null;
    public static final e.h j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.h f39970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.h f39971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f39972d;

    /* JADX INFO: compiled from: Header.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public final e.h a() {
        return this.f39970b;
    }

    public final e.h b() {
        return this.f39971c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f39970b, r6.f39970b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f39971c, r6.f39971c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f39970b.hashCode() * 31) + this.f39971c.hashCode();
    }

    public c(e.h r2, e.h r3) {
        o.e(r2, "name");
        o.e(r3, "value");
        this.f39970b = r2;
        this.f39971c = r3;
        this.f39972d = (r2.k() + 32) + r3.k();
    }

    public c(String r2, String r3) {
        o.e(r2, "name");
        o.e(r3, "value");
        this(e.h.f38722a.a(r2), e.h.f38722a.a(r3));
    }

    public c(e.h r2, String r3) {
        o.e(r2, "name");
        o.e(r3, "value");
        this(r2, e.h.f38722a.a(r3));
    }

    public String toString() {
        return this.f39970b.d() + ": " + this.f39971c.d();
    }

    static {
        f39968a = new a(null);
        f39969e = e.h.f38722a.a(":");
        f = e.h.f38722a.a(":status");
        g = e.h.f38722a.a(":method");
        h = e.h.f38722a.a(":path");
        i = e.h.f38722a.a(":scheme");
        j = e.h.f38722a.a(":authority");
    }
}
