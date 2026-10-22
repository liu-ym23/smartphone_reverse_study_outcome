package androidx.recyclerview.base;

import bg.h;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0040a f4006a = null;

    /* JADX INFO: renamed from: androidx.recyclerview.base.a$a, reason: collision with other inner class name */
    public static final class C0040a {
        public /* synthetic */ C0040a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a(float r10, float r11) {
            if (r10 >= 0.0f) goto L5;
        L9:
            return 0.0f;
        L5:
            if (r11 <= 0.0f) goto L9;
            float r12 = h.f(r10, r11 - 1.0E-5f);
            return ((r11 * r12) / (r11 - r12)) / 0.55f;
        }

        public final float b(float r10, float r11) {
            if (r10 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r11 > 0.0f) goto L8;
            return 0.0f;
        L8:
            return (1.0f - (1.0f / (((r10 / r11) * 0.55f) + 1.0f))) * r11;
        }

        public C0040a() {
        }
    }

    static {
        f4006a = new C0040a(null);
    }
}
