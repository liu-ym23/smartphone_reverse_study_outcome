package m0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f10462a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<b, SparseArray<a>> f10463b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f10464c = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f10465a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f10466b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10467c;

        public a(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f10465a = colorStateList;
            this.f10466b = configuration;
            this.f10467c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f10468a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f10469b;

        public b(Resources resources, Resources.Theme theme) {
            this.f10468a = resources;
            this.f10469b = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f10468a.equals(bVar.f10468a) && Objects.equals(this.f10469b, bVar.f10469b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.f10468a, this.f10469b);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {
        public final void a(int i10) {
            new Handler(Looper.getMainLooper()).post(new com.stepos.core.common.telemetry.scene.a(i10, 2, this));
        }

        public abstract void b(int i10);

        public abstract void c(Typeface typeface);
    }

    public static Drawable a(Resources resources, int i10, Resources.Theme theme) {
        return resources.getDrawable(i10, theme);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r12, int r13, android.util.TypedValue r14, int r15, m0.f.c r16, boolean r17, boolean r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.f.b(android.content.Context, int, android.util.TypedValue, int, m0.f$c, boolean, boolean):android.graphics.Typeface");
    }
}
