package z7;

import java.net.IDN;
import java.text.Normalizer;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.function.BiPredicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16476a;

    @Override // z7.d
    public final String a() {
        switch (this.f16476a) {
            case 0:
                return "format.idn-hostname";
            default:
                return "format.date";
        }
    }

    @Override // z7.d
    public final String getName() {
        switch (this.f16476a) {
            case 0:
                return "idn-hostname";
            default:
                return "date";
        }
    }

    @Override // z7.d
    public final boolean matches(String str) {
        int year;
        int type;
        BiPredicate biPredicateAnd;
        switch (this.f16476a) {
            case 0:
                if (str == null) {
                    return true;
                }
                String str2 = g8.d.f4378h;
                BiPredicate biPredicate = g8.d.f4377g;
                if (!"".equals(str) && (str.length() != 1 || !str.matches(str2))) {
                    for (String str3 : str.split(str2)) {
                        if (!str3.isEmpty()) {
                            if (4 <= str3.length() && "xn--".equalsIgnoreCase(str3.substring(0, 4))) {
                                String unicode = IDN.toUnicode(str3, 2);
                                if (!unicode.equalsIgnoreCase(str3)) {
                                    str3 = unicode;
                                }
                            }
                            int length = str3.length();
                            if (Normalizer.isNormalized(str3, Normalizer.Form.NFC) && '-' != str3.charAt(0) && 45 != str3.codePointBefore(length) && ((4 > length || 45 != str3.codePointAt(2) || 45 != str3.codePointAt(3)) && (type = Character.getType(str3.codePointAt(0))) != 6 && type != 7 && type != 8)) {
                                byte directionality = Character.getDirectionality(str3.codePointAt(0));
                                if (directionality == 0) {
                                    biPredicateAnd = biPredicate.and(g8.d.f4375e);
                                } else if (directionality == 1 || directionality == 2) {
                                    biPredicateAnd = biPredicate.and(g8.d.f4376f);
                                } else if (directionality == 3 || directionality == 13) {
                                    biPredicateAnd = biPredicate;
                                }
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        try {
                                            if (63 < IDN.toASCII(str3, 2).length()) {
                                            }
                                        } catch (IllegalArgumentException e10) {
                                            Throwable cause = e10.getCause();
                                            if (cause instanceof ParseException) {
                                                return cause.getMessage().startsWith("The input does not conform to the rules for BiDi code points");
                                            }
                                        }
                                    } else if (biPredicateAnd.test(str3, Integer.valueOf(i))) {
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
                return false;
            default:
                try {
                    year = LocalDate.parse(str).getYear();
                } catch (DateTimeParseException unused) {
                }
                return year >= 0 && year <= 9999;
        }
    }
}
