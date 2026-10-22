package A1;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class c implements A1.d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f29a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f30b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f31c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f32d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f33e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f34f;

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ c[] f35g;

    enum a extends c {
        a(String str, int i5) {
            super(str, i5, null);
        }

        @Override // A1.d
        public String b(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f29a = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: A1.c.b
            {
                a aVar2 = null;
            }

            @Override // A1.d
            public String b(Field field) {
                return c.g(field.getName());
            }
        };
        f30b = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: A1.c.c
            {
                a aVar2 = null;
            }

            @Override // A1.d
            public String b(Field field) {
                return c.g(c.e(field.getName(), " "));
            }
        };
        f31c = cVar2;
        c cVar3 = new c("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: A1.c.d
            {
                a aVar2 = null;
            }

            @Override // A1.d
            public String b(Field field) {
                return c.e(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f32d = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_DASHES", 4) { // from class: A1.c.e
            {
                a aVar2 = null;
            }

            @Override // A1.d
            public String b(Field field) {
                return c.e(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f33e = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DOTS", 5) { // from class: A1.c.f
            {
                a aVar2 = null;
            }

            @Override // A1.d
            public String b(Field field) {
                return c.e(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        f34f = cVar5;
        f35g = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5};
    }

    private c(String str, int i5) {
    }

    private static String d(char c6, String str, int i5) {
        if (i5 >= str.length()) {
            return String.valueOf(c6);
        }
        return c6 + str.substring(i5);
    }

    static String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String g(String str) {
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        char cCharAt = str.charAt(0);
        int length = str.length();
        while (i5 < length - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i5++;
            cCharAt = str.charAt(i5);
        }
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        sb.append(d(Character.toUpperCase(cCharAt), str, i5 + 1));
        return sb.toString();
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f35g.clone();
    }

    /* synthetic */ c(String str, int i5, a aVar) {
        this(str, i5);
    }
}
