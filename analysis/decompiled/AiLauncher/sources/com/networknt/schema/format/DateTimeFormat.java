package com.networknt.schema.format;

import com.ethlo.time.LeapSecondException;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.format.DateTimeFormat;
import com.networknt.schema.utils.Classes;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.function.Predicate;
import vc.e;

/* loaded from: classes2.dex */
public class DateTimeFormat implements Format {
    private static final boolean ETHLO_PRESENT;
    private static final Predicate<String> VALIDATE;
    private static final vc.c logger = e.l(DateTimeFormat.class);

    public static class Ethlo {
        public static boolean isValid(String str) {
            try {
                X1.c.a(str);
                return true;
            } catch (LeapSecondException e10) {
                return e10.a();
            }
        }
    }

    public static class JavaTimeOffsetDateTime {
        public static boolean isValid(String str) {
            try {
                OffsetDateTime.parse(str);
                return true;
            } catch (DateTimeParseException unused) {
                return false;
            }
        }
    }

    static {
        boolean zIsPresent = Classes.isPresent("com.ethlo.time.ITU", DateTimeFormat.class.getClassLoader());
        ETHLO_PRESENT = zIsPresent;
        VALIDATE = zIsPresent ? new Predicate() { // from class: com.networknt.schema.format.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DateTimeFormat.Ethlo.isValid((String) obj);
            }
        } : new Predicate() { // from class: com.networknt.schema.format.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DateTimeFormat.JavaTimeOffsetDateTime.isValid((String) obj);
            }
        };
    }

    private static boolean isValid(String str) {
        try {
            return VALIDATE.test(str);
        } catch (Exception e10) {
            logger.a("Invalid {}: {}", "date-time", e10.getMessage());
            return false;
        }
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.date-time";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "date-time";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        return isValid(str);
    }
}
