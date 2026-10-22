package F1;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final C0065a f431a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f432b;

    static {
        C0065a c0065a = new C0065a();
        f431a = c0065a;
        f432b = new h[]{c0065a, new h() { // from class: F1.b
            @Override // F1.i
            public final String a(Field field) {
                return h.c(field.getName());
            }
        }, new h() { // from class: F1.c
            @Override // F1.i
            public final String a(Field field) {
                return h.c(h.b(field.getName(), ' '));
            }
        }, new h() { // from class: F1.d
            @Override // F1.i
            public final String a(Field field) {
                return h.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new h() { // from class: F1.e
            @Override // F1.i
            public final String a(Field field) {
                return h.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new h() { // from class: F1.f
            @Override // F1.i
            public final String a(Field field) {
                return h.b(field.getName(), CoreConstants.DASH_CHAR).toLowerCase(Locale.ENGLISH);
            }
        }, new h() { // from class: F1.g
            @Override // F1.i
            public final String a(Field field) {
                return h.b(field.getName(), CoreConstants.DOT).toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String b(String str, char c4) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c4);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i4 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i4) + upperCase + str.substring(i4 + 1);
            }
        }
        return str;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f432b.clone();
    }
}
