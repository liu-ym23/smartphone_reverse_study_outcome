package x3;

import java.net.IDN;
import java.text.Normalizer;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.function.BiPredicate;

/* loaded from: classes3.dex */
public final class g implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6877a;

    @Override // x3.d
    public final String a() {
        switch (this.f6877a) {
            case 0:
                return "format.idn-hostname";
            default:
                return "format.date";
        }
    }

    @Override // x3.d
    public final String getName() {
        switch (this.f6877a) {
            case 0:
                return "idn-hostname";
            default:
                return "date";
        }
    }

    @Override // x3.d
    public final boolean matches(String str) {
        int year;
        int type;
        BiPredicate biPredicateAnd;
        switch (this.f6877a) {
            case 0:
                if (str == null) {
                    return true;
                }
                String str2 = E3.e.h;
                BiPredicate biPredicate = E3.e.g;
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
                                    biPredicateAnd = biPredicate.and(E3.e.e);
                                } else if (directionality == 1 || directionality == 2) {
                                    biPredicateAnd = biPredicate.and(E3.e.f);
                                } else if (directionality == 3 || directionality == 13) {
                                    biPredicateAnd = biPredicate;
                                }
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        try {
                                            if (63 < IDN.toASCII(str3, 2).length()) {
                                            }
                                        } catch (IllegalArgumentException e) {
                                            Throwable cause = e.getCause();
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
