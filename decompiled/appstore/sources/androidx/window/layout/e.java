package androidx.window.layout;

import android.graphics.Rect;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class e implements FoldingFeature {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5307d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.window.core.b f5308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f5309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FoldingFeature.c f5310c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(androidx.window.core.b r10) {
            q.g(r10, "bounds");
            if (r10.d() != 0) goto L10;
            if (r10.a() != 0) goto L10;
            throw new IllegalArgumentException("Bounds must be non zero");
        L10:
            if (r10.b() != 0) goto L12;
            return;
        L12:
            if (r10.c() != 0) goto L15;
            return;
        L15:
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5311b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f5312c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f5313d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5314a;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final b a() {
                return b.a();
            }

            public final b b() {
                return b.b();
            }

            public a() {
            }
        }

        static {
            f5311b = new a(null);
            f5312c = new b("FOLD");
            f5313d = new b("HINGE");
        }

        public b(String r10) {
            this.f5314a = r10;
        }

        public static final /* synthetic */ b a() {
            return f5312c;
        }

        public static final /* synthetic */ b b() {
            return f5313d;
        }

        public String toString() {
            return this.f5314a;
        }
    }

    static {
        f5307d = new a(null);
    }

    public e(androidx.window.core.b r10, b r11, FoldingFeature.c r12) {
        q.g(r10, "featureBounds");
        q.g(r11, "type");
        q.g(r12, WsConstants.KEY_CONNECTION_STATE);
        this.f5308a = r10;
        this.f5309b = r11;
        this.f5310c = r12;
        f5307d.a(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (q.b(e.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L23;
        e r12 = (e) r10;
        if (q.b(this.f5308a, r12.f5308a) == true) goto L16;
        return false;
    L16:
        if (q.b(this.f5309b, r12.f5309b) == true) goto L19;
        return false;
    L19:
        if (q.b(getState(), r12.getState()) == true) goto L21;
        return false;
    L21:
        return true;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    @Override // androidx.window.layout.DisplayFeature
    public Rect getBounds() {
        return this.f5308a.f();
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.a getOcclusionType() {
        if (this.f5308a.d() == 0) goto L9;
        if (this.f5308a.a() == 0) goto L9;
        return FoldingFeature.a.f5253d;
    L9:
        return FoldingFeature.a.f5252c;
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.b getOrientation() {
        if (this.f5308a.d() <= this.f5308a.a()) goto L6;
        return FoldingFeature.b.f5257d;
    L6:
        return FoldingFeature.b.f5256c;
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.c getState() {
        return this.f5310c;
    }

    public int hashCode() {
        return (((this.f5308a.hashCode() * 31) + this.f5309b.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        b r10 = this.f5309b;
        b.a r11 = b.f5311b;
        if (q.b(r10, r11.b()) == false) goto L6;
        return true;
    L6:
        if (q.b(this.f5309b, r11.a()) == true) goto L8;
    L10:
        return false;
    L8:
        if (q.b(getState(), FoldingFeature.c.f5261d) == false) goto L10;
        return true;
    }

    public String toString() {
        return e.class.getSimpleName() + " { " + this.f5308a + ", type=" + this.f5309b + ", state=" + getState() + " }";
    }
}
