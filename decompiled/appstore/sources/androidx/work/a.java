package androidx.work;

import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0056a f5392i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f5393j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkType f5394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f5401h;

    /* JADX INFO: renamed from: androidx.work.a$a, reason: collision with other inner class name */
    public static final class C0056a {
        public /* synthetic */ C0056a(DefaultConstructorMarker r10) {
            this();
        }

        public C0056a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5403b;

        public b(Uri r10, boolean r11) {
            q.g(r10, "uri");
            this.f5402a = r10;
            this.f5403b = r11;
        }

        public final Uri a() {
            return this.f5402a;
        }

        public final boolean b() {
            return this.f5403b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            if (r10 == null) goto L7;
            Class<?> r11 = r10.getClass();
        L9:
            if (q.b(b.class, r11) == true) goto L11;
            return false;
        L11:
            q.e(r10, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            b r12 = (b) r10;
            if (q.b(this.f5402a, r12.f5402a) == true) goto L15;
            return false;
        L15:
            if (this.f5403b == r12.f5403b) goto L17;
            return false;
        L17:
            return true;
        L7:
            r11 = null;
            goto L9
        }

        public int hashCode() {
            return (this.f5402a.hashCode() * 31) + Boolean.hashCode(this.f5403b);
        }
    }

    static {
        f5392i = new C0056a(null);
        NetworkType r10 = null;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        boolean r14 = false;
        long r15 = 0;
        long r16 = 0;
        Set r17 = null;
        f5393j = new a(r10, r11, r12, r13, r14, r15, r16, r17, PrivateKeyType.INVALID, null);
    }

    public a(NetworkType r10, boolean r11, boolean r12, boolean r13, boolean r14, long r15, long r16, Set r17) {
        q.g(r10, "requiredNetworkType");
        q.g(r17, "contentUriTriggers");
        this.f5394a = r10;
        this.f5395b = r11;
        this.f5396c = r12;
        this.f5397d = r13;
        this.f5398e = r14;
        this.f5399f = r15;
        this.f5400g = r16;
        this.f5401h = r17;
    }

    public final long a() {
        return this.f5400g;
    }

    public final long b() {
        return this.f5399f;
    }

    public final Set c() {
        return this.f5401h;
    }

    public final NetworkType d() {
        return this.f5394a;
    }

    public final boolean e() {
        return !this.f5401h.isEmpty();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (q.b(a.class, r10.getClass()) == false) goto L34;
        a r11 = (a) r10;
        if (this.f5395b == r11.f5395b) goto L14;
        return false;
    L14:
        if (this.f5396c == r11.f5396c) goto L17;
        return false;
    L17:
        if (this.f5397d == r11.f5397d) goto L20;
        return false;
    L20:
        if (this.f5398e == r11.f5398e) goto L23;
        return false;
    L23:
        if (this.f5399f == r11.f5399f) goto L26;
        return false;
    L26:
        if (this.f5400g == r11.f5400g) goto L29;
        return false;
    L29:
        if (this.f5394a == r11.f5394a) goto L32;
        return false;
    L32:
        return q.b(this.f5401h, r11.f5401h);
    L34:
        return false;
    }

    public final boolean f() {
        return this.f5397d;
    }

    public final boolean g() {
        return this.f5395b;
    }

    public final boolean h() {
        return this.f5396c;
    }

    public int hashCode() {
        int r10 = ((((((((this.f5394a.hashCode() * 31) + (this.f5395b ? 1 : 0)) * 31) + (this.f5396c ? 1 : 0)) * 31) + (this.f5397d ? 1 : 0)) * 31) + (this.f5398e ? 1 : 0)) * 31;
        long r11 = this.f5399f;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.f5400g;
        return ((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.f5401h.hashCode();
    }

    public final boolean i() {
        return this.f5398e;
    }

    public /* synthetic */ a(NetworkType r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17, long r19, Set r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        NetworkType r10 = NetworkType.NOT_REQUIRED;
    L6:
        boolean r11 = false;
        if ((r22 & 2) == 0) goto L9;
        boolean r18 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r20 = false;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r24 = false;
    L19:
        if ((r22 & 16) != 0) goto L22;
        r11 = r16;
    L22:
        long r25 = -1;
        if ((r22 & 32) == 0) goto L25;
        long r26 = -1;
    L27:
        if ((r22 & 64) != 0) goto L31;
        r25 = r19;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Set r27 = r0.e();
    L34:
        this(r10, r18, r20, r24, r11, r26, r25, r27);
        return;
    L33:
        r27 = r21;
        goto L34
    L25:
        r26 = r17;
        goto L27
    L17:
        r24 = r15;
        goto L19
    L13:
        r20 = r14;
        goto L15
    L9:
        r18 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L6
    }

    public a(a r13) {
        q.g(r13, AppInfo.SEARCH_SOURCE_EXTENAL);
        boolean r10 = r13.f5395b;
        boolean r11 = r13.f5396c;
        NetworkType r12 = r13.f5394a;
        boolean r14 = r13.f5397d;
        boolean r15 = r13.f5398e;
        Set r16 = r13.f5401h;
        this(r12, r10, r11, r14, r15, r13.f5399f, r13.f5400g, r16);
    }
}
