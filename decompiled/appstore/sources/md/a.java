package md;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0316a f22269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f22270b = 0.0f;

    /* JADX INFO: renamed from: md.a$a, reason: collision with other inner class name */
    public static final class C0316a {
        public /* synthetic */ C0316a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a(float r10, float r11, float r12, float r13) {
            if (r12 != r13) goto L6;
        L7:
            return r12;
        L6:
            if (r12 == r11) goto L7;
            if (r10 >= r11) goto L14;
            if (r13 >= r10) goto L14;
            return r13;
        L14:
            if (r10 > r11) goto L16;
        L18:
            float r14 = r11 - r10;
            float r15 = a.a();
            float r16 = ((r15 * (r13 - r10)) / r14) + 1.0f;
            if (r16 != 0.0f) goto L22;
            return 0.0f;
        L22:
            return r10 + ((1.0f - (1.0f / r16)) * r14);
        L16:
            if (r13 <= r10) goto L18;
            return r13;
        }

        public C0316a() {
        }
    }

    static {
        f22269a = new C0316a(null);
        f22270b = 1.0f;
    }

    public static final /* synthetic */ float a() {
        return f22270b;
    }
}
