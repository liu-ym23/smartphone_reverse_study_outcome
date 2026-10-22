package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/* loaded from: classes2.dex */
public class DateFormat implements Format {
    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.date";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "date";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        try {
            int year = LocalDate.parse(str).getYear();
            return year >= 0 && year <= 9999;
        } catch (DateTimeParseException unused) {
            return false;
        }
    }
}
