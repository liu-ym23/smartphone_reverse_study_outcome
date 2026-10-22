package com.bytedance.security.zenmobile.detect.anchor.scanner;

import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.calendar.ODatePickerView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class YYYYPattern extends Pattern {
    public YYYYPattern() {
        this.name = "yyyy";
    }

    @Override // com.bytedance.security.zenmobile.detect.anchor.scanner.Pattern
    public List<String> generateWords() {
        ArrayList r0 = new ArrayList(ApWakeEvent.ACCELERATING_START);
        LocalDate r1 = LocalDate.of(ODatePickerView.YEAR_FROM, 1, 1);
        LocalDate r2 = LocalDate.now();
        DateTimeFormatter r5 = DateTimeFormatter.ofPattern(this.name);
    L4:
        if (r1.isBefore(r2) == false) goto L6;
        r0.add(r1.format(r5));
        r1 = r1.plusYears(1);
        goto L4
    L6:
        return r0;
    }
}
