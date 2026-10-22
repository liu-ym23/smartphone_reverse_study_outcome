package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f3897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f3898d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f3899e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f3900f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f3901g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f3902h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f3903i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f3904j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f3905k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n f3906l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n f3907m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n f3908n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3910b;

    public static final class a extends n {
        public a() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "boolean[]";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (boolean[]) r12);
        }

        public boolean[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (boolean[]) r10.get(r11);
        }

        public boolean[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void i(Bundle r10, String r11, boolean[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putBooleanArray(r11, r12);
        }
    }

    public static final class b extends n {
        public b() {
            super(false);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "boolean";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, ((Boolean) r12).booleanValue());
        }

        public Boolean g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (Boolean) r10.get(r11);
        }

        public Boolean h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            if (kotlin.jvm.internal.q.b(r10, "true") == false) goto L6;
            boolean r11 = true;
        L9:
            return Boolean.valueOf(r11);
        L6:
            if (kotlin.jvm.internal.q.b(r10, "false") == false) goto L11;
            r11 = false;
            goto L9
        L11:
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        public void i(Bundle r10, String r11, boolean r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putBoolean(r11, r12);
        }
    }

    public static final class c extends n {
        public c() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "float[]";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (float[]) r12);
        }

        public float[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (float[]) r10.get(r11);
        }

        public float[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void i(Bundle r10, String r11, float[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putFloatArray(r11, r12);
        }
    }

    public static final class d extends n {
        public d() {
            super(false);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "float";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, ((Number) r12).floatValue());
        }

        public Float g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            Object r12 = r10.get(r11);
            if (r12 == null) goto L7;
            return (Float) r12;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }

        public Float h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            return Float.valueOf(Float.parseFloat(r10));
        }

        public void i(Bundle r10, String r11, float r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putFloat(r11, r12);
        }
    }

    public static final class e extends n {
        public e() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "integer[]";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (int[]) r12);
        }

        public int[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (int[]) r10.get(r11);
        }

        public int[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void i(Bundle r10, String r11, int[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putIntArray(r11, r12);
        }
    }

    public static final class f extends n {
        public f() {
            super(false);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "integer";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, ((Number) r12).intValue());
        }

        public Integer g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            Object r12 = r10.get(r11);
            if (r12 == null) goto L7;
            return (Integer) r12;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public Integer h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            if (kotlin.text.o.B(r10, "0x", false, 2, null) == false) goto L5;
            String r11 = r10.substring(2);
            kotlin.jvm.internal.q.f(r11, "this as java.lang.String).substring(startIndex)");
            int r12 = Integer.parseInt(r11, kotlin.text.a.a(16));
        L7:
            return Integer.valueOf(r12);
        L5:
            r12 = Integer.parseInt(r10);
            goto L7
        }

        public void i(Bundle r10, String r11, int r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putInt(r11, r12);
        }
    }

    public static final class g extends n {
        public g() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "long[]";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (long[]) r12);
        }

        public long[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (long[]) r10.get(r11);
        }

        public long[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void i(Bundle r10, String r11, long[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putLongArray(r11, r12);
        }
    }

    public static final class h extends n {
        public h() {
            super(false);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "long";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, ((Number) r12).longValue());
        }

        public Long g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            Object r12 = r10.get(r11);
            if (r12 == null) goto L7;
            return (Long) r12;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }

        public Long h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            if (kotlin.text.o.o(r10, "L", false, 2, null) == false) goto L5;
            String r11 = r10.substring(0, r10.length() - 1);
            kotlin.jvm.internal.q.f(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        L7:
            if (kotlin.text.o.B(r10, "0x", false, 2, null) == false) goto L9;
            String r12 = r11.substring(2);
            kotlin.jvm.internal.q.f(r12, "this as java.lang.String).substring(startIndex)");
            long r13 = Long.parseLong(r12, kotlin.text.a.a(16));
        L11:
            return Long.valueOf(r13);
        L9:
            r13 = Long.parseLong(r11);
            goto L11
        L5:
            r11 = r10;
            goto L7
        }

        public void i(Bundle r10, String r11, long r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putLong(r11, r12);
        }
    }

    public static final class i extends n {
        public i() {
            super(false);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return TypedValues.Custom.S_REFERENCE;
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, ((Number) r12).intValue());
        }

        public Integer g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            Object r12 = r10.get(r11);
            if (r12 == null) goto L7;
            return (Integer) r12;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public Integer h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            if (kotlin.text.o.B(r10, "0x", false, 2, null) == false) goto L5;
            String r11 = r10.substring(2);
            kotlin.jvm.internal.q.f(r11, "this as java.lang.String).substring(startIndex)");
            int r12 = Integer.parseInt(r11, kotlin.text.a.a(16));
        L7:
            return Integer.valueOf(r12);
        L5:
            r12 = Integer.parseInt(r10);
            goto L7
        }

        public void i(Bundle r10, String r11, int r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putInt(r11, r12);
        }
    }

    public static final class j extends n {
        public j() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "string[]";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (String[]) r12);
        }

        public String[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (String[]) r10.get(r11);
        }

        public String[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void i(Bundle r10, String r11, String[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putStringArray(r11, r12);
        }
    }

    public static final class k extends n {
        public k() {
            super(true);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            return "string";
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (String) r12);
        }

        public String g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (String) r10.get(r11);
        }

        public String h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            return r10;
        }

        public void i(Bundle r10, String r11, String r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            r10.putString(r11, r12);
        }
    }

    public static final class l {
        public /* synthetic */ l(DefaultConstructorMarker r10) {
            this();
        }

        public n a(String r10, String r11) {
            n r12 = n.f3898d;
            if (kotlin.jvm.internal.q.b(r12.b(), r10) == false) goto L5;
            return r12;
        L5:
            n r13 = n.f3900f;
            if (kotlin.jvm.internal.q.b(r13.b(), r10) == false) goto L8;
            return r13;
        L8:
            n r14 = n.f3901g;
            if (kotlin.jvm.internal.q.b(r14.b(), r10) == false) goto L11;
            return r14;
        L11:
            n r15 = n.f3902h;
            if (kotlin.jvm.internal.q.b(r15.b(), r10) == false) goto L14;
            return r15;
        L14:
            n r16 = n.f3905k;
            if (kotlin.jvm.internal.q.b(r16.b(), r10) == false) goto L17;
            return r16;
        L17:
            n r17 = n.f3906l;
            if (kotlin.jvm.internal.q.b(r17.b(), r10) == false) goto L20;
            return r17;
        L20:
            n r18 = n.f3907m;
            if (kotlin.jvm.internal.q.b(r18.b(), r10) == false) goto L23;
            return r18;
        L23:
            n r19 = n.f3908n;
            if (kotlin.jvm.internal.q.b(r19.b(), r10) == false) goto L26;
            return r19;
        L26:
            n r20 = n.f3903i;
            if (kotlin.jvm.internal.q.b(r20.b(), r10) == false) goto L29;
            return r20;
        L29:
            n r21 = n.f3904j;
            if (kotlin.jvm.internal.q.b(r21.b(), r10) == false) goto L32;
            return r21;
        L32:
            n r22 = n.f3899e;
            if (kotlin.jvm.internal.q.b(r22.b(), r10) == false) goto L35;
            return r22;
        L35:
            if (r10 != null) goto L37;
        L73:
            return r18;
        L37:
            if (r10.length() == 0) goto L73;
        L43:
            e = move-exception;
            throw new RuntimeException(e);
        L40:
            if (kotlin.text.o.B(r10, LibrarianImpl.Constants.DOT, false, 2, null) == false) goto L45;
            if (r11 == null) goto L45;
            String r23 = r11 + r10;     // Catch: ClassNotFoundException -> L43
        L48:
            if (kotlin.text.o.o(r10, "[]", false, 2, null) == false) goto L57;
            r23 = r23.substring(0, r23.length() - 2);     // Catch: ClassNotFoundException -> L43
            kotlin.jvm.internal.q.f(r23, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: ClassNotFoundException -> L43
            Class<?> r24 = Class.forName(r23);     // Catch: ClassNotFoundException -> L43
            if (Parcelable.class.isAssignableFrom(r24) == false) goto L54;
            return new C0038n(r24);
        L54:
            if (Serializable.class.isAssignableFrom(r24) == false) goto L70;
            return new p(r24);
        L70:
            throw new IllegalArgumentException(r23 + " is not Serializable or Parcelable.");     // Catch: ClassNotFoundException -> L43
        L57:
            Class<?> r25 = Class.forName(r23);     // Catch: ClassNotFoundException -> L43
            if (Parcelable.class.isAssignableFrom(r25) == false) goto L62;
            return new o(r25);
        L62:
            if (Enum.class.isAssignableFrom(r25) == false) goto L66;
            return new m(r25);
        L66:
            if (Serializable.class.isAssignableFrom(r25) == false) goto L70;
            return new q(r25);
        L45:
            r23 = r10;
            goto L48
        }

        public final n b(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            n r11 = n.f3898d;     // Catch: IllegalArgumentException -> L5
            r11.e(r10);     // Catch: IllegalArgumentException -> L5
            return r11;
        L5:
            n r12 = n.f3901g;     // Catch: IllegalArgumentException -> L7
            r12.e(r10);     // Catch: IllegalArgumentException -> L7
            return r12;
        L7:
            n r13 = n.f3903i;     // Catch: IllegalArgumentException -> L9
            r13.e(r10);     // Catch: IllegalArgumentException -> L9
            return r13;
        L9:
            n r14 = n.f3905k;     // Catch: IllegalArgumentException -> L11
            r14.e(r10);     // Catch: IllegalArgumentException -> L11
            return r14;
        L12:
            return n.f3907m;
        }

        public final n c(Object r10) {
            if ((r10 instanceof Integer) == false) goto L6;
            return n.f3898d;
        L6:
            if ((r10 instanceof int[]) == false) goto L9;
            return n.f3900f;
        L9:
            if ((r10 instanceof Long) == false) goto L12;
            return n.f3901g;
        L12:
            if ((r10 instanceof long[]) == false) goto L15;
            return n.f3902h;
        L15:
            if ((r10 instanceof Float) == false) goto L18;
            return n.f3903i;
        L18:
            if ((r10 instanceof float[]) == false) goto L21;
            return n.f3904j;
        L21:
            if ((r10 instanceof Boolean) == false) goto L24;
            return n.f3905k;
        L24:
            if ((r10 instanceof boolean[]) == false) goto L27;
            return n.f3906l;
        L27:
            if ((r10 instanceof String) == true) goto L65;
            if (r10 == null) goto L65;
            if ((r10 instanceof Object[]) == false) goto L36;
            if ((((Object[]) r10) instanceof String[]) == false) goto L36;
            return n.f3908n;
        L36:
            if (r10.getClass().isArray() == false) goto L45;
            Class<?> r11 = r10.getClass().getComponentType();
            kotlin.jvm.internal.q.d(r11);
            if (Parcelable.class.isAssignableFrom(r11) == false) goto L45;
            Class<?> r12 = r10.getClass().getComponentType();
            if (r12 == null) goto L43;
            return new C0038n(r12);
        L43:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
        L45:
            if (r10.getClass().isArray() == false) goto L54;
            Class<?> r13 = r10.getClass().getComponentType();
            kotlin.jvm.internal.q.d(r13);
            if (Serializable.class.isAssignableFrom(r13) == false) goto L54;
            Class<?> r14 = r10.getClass().getComponentType();
            if (r14 == null) goto L52;
            return new p(r14);
        L52:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
        L54:
            if ((r10 instanceof Parcelable) == false) goto L57;
            return new o(r10.getClass());
        L57:
            if ((r10 instanceof Enum) == false) goto L60;
            return new m(r10.getClass());
        L60:
            if ((r10 instanceof Serializable) == false) goto L63;
            return new q(r10.getClass());
        L63:
            throw new IllegalArgumentException("Object of type " + r10.getClass().getName() + " is not supported for navigation arguments.");
        L65:
            return n.f3907m;
        }

        public l() {
        }
    }

    public static final class m extends q {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Class f3911p;

        public m(Class r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            super(false, r10);
            if (r10.isEnum() == false) goto L7;
            this.f3911p = r10;
            return;
        L7:
            throw new IllegalArgumentException((r10 + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.n.q, androidx.navigation.n
        public String b() {
            String r10 = this.f3911p.getName();
            kotlin.jvm.internal.q.f(r10, "type.name");
            return r10;
        }

        @Override // androidx.navigation.n.q, androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return j(r10);
        }

        @Override // androidx.navigation.n.q
        public /* bridge */ /* synthetic */ Serializable h(String r10) {
            return j(r10);
        }

        public Enum j(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            Object[] r11 = this.f3911p.getEnumConstants();
            kotlin.jvm.internal.q.f(r11, "type.enumConstants");
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L8;
            Object r14 = r11[r13];
            if (kotlin.text.o.p(((Enum) r14).name(), r10, true) == true) goto L9;
            r13 = r13 + 1;
        L9:
            Enum r15 = (Enum) r14;
            if (r15 == null) goto L13;
            return r15;
        L13:
            throw new IllegalArgumentException("Enum value " + r10 + " not found for type " + this.f3911p.getName() + '.');
        L8:
            r14 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.n$n, reason: collision with other inner class name */
    public static final class C0038n extends n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class f3912o;

        public C0038n(Class r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            super(true);
            if (Parcelable.class.isAssignableFrom(r10) == false) goto L11;
            this.f3912o = Class.forName("[L" + r10.getName() + ';');
            return;
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L11:
            throw new IllegalArgumentException((r10 + " does not implement Parcelable.").toString());
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            String r10 = this.f3912o.getName();
            kotlin.jvm.internal.q.f(r10, "arrayType.name");
            return r10;
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            if (r10 != null) goto L7;
            return false;
        L7:
            if (kotlin.jvm.internal.q.b(C0038n.class, r10.getClass()) == true) goto L10;
            return false;
        L10:
            return kotlin.jvm.internal.q.b(this.f3912o, ((C0038n) r10).f3912o);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (Parcelable[]) r12);
        }

        public Parcelable[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (Parcelable[]) r10.get(r11);
        }

        public Parcelable[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f3912o.hashCode();
        }

        public void i(Bundle r10, String r11, Parcelable[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            this.f3912o.cast(r12);
            r10.putParcelableArray(r11, r12);
        }
    }

    public static final class o extends n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class f3913o;

        public o(Class r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            super(true);
            if (Parcelable.class.isAssignableFrom(r10) == false) goto L5;
        L9:
            this.f3913o = r10;
            return;
        L5:
            if (Serializable.class.isAssignableFrom(r10) == true) goto L9;
            throw new IllegalArgumentException((r10 + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.n
        public Object a(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return r10.get(r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            String r10 = this.f3913o.getName();
            kotlin.jvm.internal.q.f(r10, "type.name");
            return r10;
        }

        @Override // androidx.navigation.n
        public Object e(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            if (r10 != null) goto L7;
            return false;
        L7:
            if (kotlin.jvm.internal.q.b(o.class, r10.getClass()) == true) goto L10;
            return false;
        L10:
            return kotlin.jvm.internal.q.b(this.f3913o, ((o) r10).f3913o);
        }

        @Override // androidx.navigation.n
        public void f(Bundle r10, String r11, Object r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            this.f3913o.cast(r12);
            if (r12 != null) goto L5;
        L10:
            r10.putParcelable(r11, (Parcelable) r12);
            return;
        L5:
            if ((r12 instanceof Parcelable) == true) goto L10;
            if ((r12 instanceof Serializable) == false) goto L12;
            r10.putSerializable(r11, (Serializable) r12);
            return;
        }

        public int hashCode() {
            return this.f3913o.hashCode();
        }
    }

    public static final class p extends n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class f3914o;

        public p(Class r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            super(true);
            if (Serializable.class.isAssignableFrom(r10) == false) goto L11;
            this.f3914o = Class.forName("[L" + r10.getName() + ';');
            return;
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L11:
            throw new IllegalArgumentException((r10 + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            String r10 = this.f3914o.getName();
            kotlin.jvm.internal.q.f(r10, "arrayType.name");
            return r10;
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            if (r10 != null) goto L7;
            return false;
        L7:
            if (kotlin.jvm.internal.q.b(p.class, r10.getClass()) == true) goto L10;
            return false;
        L10:
            return kotlin.jvm.internal.q.b(this.f3914o, ((p) r10).f3914o);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (Serializable[]) r12);
        }

        public Serializable[] g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (Serializable[]) r10.get(r11);
        }

        public Serializable[] h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f3914o.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void i(Bundle r10, String r11, Serializable[] r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            this.f3914o.cast(r12);
            r10.putSerializable(r11, r12);
        }
    }

    public static class q extends n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class f3915o;

        public q(Class r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            super(true);
            if (Serializable.class.isAssignableFrom(r10) == false) goto L11;
            if (r10.isEnum() == true) goto L9;
            this.f3915o = r10;
            return;
        L9:
            throw new IllegalArgumentException((r10 + " is an Enum. You should use EnumType instead.").toString());
        L11:
            throw new IllegalArgumentException((r10 + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object a(Bundle r10, String r11) {
            return g(r10, r11);
        }

        @Override // androidx.navigation.n
        public String b() {
            String r10 = this.f3915o.getName();
            kotlin.jvm.internal.q.f(r10, "type.name");
            return r10;
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ Object e(String r10) {
            return h(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof q) == true) goto L10;
            return false;
        L10:
            return kotlin.jvm.internal.q.b(this.f3915o, ((q) r10).f3915o);
        }

        @Override // androidx.navigation.n
        public /* bridge */ /* synthetic */ void f(Bundle r10, String r11, Object r12) {
            i(r10, r11, (Serializable) r12);
        }

        public Serializable g(Bundle r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            return (Serializable) r10.get(r11);
        }

        public Serializable h(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.f3915o.hashCode();
        }

        public void i(Bundle r10, String r11, Serializable r12) {
            kotlin.jvm.internal.q.g(r10, "bundle");
            kotlin.jvm.internal.q.g(r11, "key");
            kotlin.jvm.internal.q.g(r12, CommonKey.KEY_VALUE);
            this.f3915o.cast(r12);
            r10.putSerializable(r11, r12);
        }

        public q(boolean r10, Class r11) {
            kotlin.jvm.internal.q.g(r11, "type");
            super(r10);
            if (Serializable.class.isAssignableFrom(r11) == false) goto L7;
            this.f3915o = r11;
            return;
        L7:
            throw new IllegalArgumentException((r11 + " does not implement Serializable.").toString());
        }
    }

    static {
        f3897c = new l(null);
        f3898d = new f();
        f3899e = new i();
        f3900f = new e();
        f3901g = new h();
        f3902h = new g();
        f3903i = new d();
        f3904j = new c();
        f3905k = new b();
        f3906l = new a();
        f3907m = new k();
        f3908n = new j();
    }

    public n(boolean r10) {
        this.f3909a = r10;
        this.f3910b = "nav_type";
    }

    public abstract Object a(Bundle r10, String r11);

    public abstract String b();

    public boolean c() {
        return this.f3909a;
    }

    public final Object d(Bundle r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "bundle");
        kotlin.jvm.internal.q.g(r11, "key");
        kotlin.jvm.internal.q.g(r12, CommonKey.KEY_VALUE);
        Object r13 = e(r12);
        f(r10, r11, r13);
        return r13;
    }

    public abstract Object e(String r10);

    public abstract void f(Bundle r10, String r11, Object r12);

    public String toString() {
        return b();
    }
}
