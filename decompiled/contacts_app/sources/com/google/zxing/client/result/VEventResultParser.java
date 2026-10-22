package com.google.zxing.client.result;

import androidx.core.net.MailTo;
import com.google.zxing.Result;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VEventResultParser extends ResultParser {
    public VEventResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public CalendarParsedResult parse(Result r18) {
        String r0 = getMassagedText(r18);
        if (r0.indexOf("BEGIN:VEVENT") >= 0) goto L5;
        return null;
    L5:
        String r5 = matchSingleVCardPrefixedField("SUMMARY", r0, true);
        String r6 = matchSingleVCardPrefixedField("DTSTART", r0, true);
        if (r6 != null) goto L8;
        return null;
    L8:
        String r7 = matchSingleVCardPrefixedField("DTEND", r0, true);
        String r8 = matchSingleVCardPrefixedField("DURATION", r0, true);
        String r9 = matchSingleVCardPrefixedField("LOCATION", r0, true);
        String r10 = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", r0, true));
        String[] r11 = matchVCardPrefixedField("ATTENDEE", r0, true);
        if (r11 == null) goto L14;
        int r4 = 0;
    L12:
        if (r4 >= r11.length) goto L14;
        r11[r4] = stripMailto(r11[r4]);
        r4 = r4 + 1;
    L14:
        String r12 = matchSingleVCardPrefixedField("DESCRIPTION", r0, true);
        String r1 = matchSingleVCardPrefixedField("GEO", r0, true);
        if (r1 != null) goto L17;
        double r13 = Double.NaN;
        double r15 = Double.NaN;
    L23:
        return new CalendarParsedResult(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15);
    L17:
        int r14 = r1.indexOf(59);
        if (r14 >= 0) goto L25;
        return null;
    L25:
        r13 = Double.parseDouble(r1.substring(0, r14));     // Catch: Throwable -> L24
        r15 = Double.parseDouble(r1.substring(r14 + 1));     // Catch: Throwable -> L24
    L24:
        return null;
    }

    private static String matchSingleVCardPrefixedField(CharSequence r1, String r2, boolean r3) {
        List<String> r4 = VCardResultParser.matchSingleVCardPrefixedField(r1, r2, r3, false);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return null;
    L8:
        return r4.get(0);
    }

    private static String[] matchVCardPrefixedField(CharSequence r3, String r4, boolean r5) {
        List<List<String>> r6 = VCardResultParser.matchVCardPrefixedField(r3, r4, r5, false);
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isEmpty() == true) goto L14;
        int r7 = r6.size();
        String[] r8 = new String[r7];
        int r1 = 0;
    L8:
        if (r1 >= r7) goto L10;
        r8[r1] = r6.get(r1).get(0);
        r1 = r1 + 1;
        goto L8
    L10:
        return r8;
    L14:
        return null;
    }

    private static String stripMailto(String r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.startsWith(MailTo.MAILTO_SCHEME) == true) goto L8;
        if (r1.startsWith("MAILTO:") == true) goto L8;
        return r1;
    L8:
        return r1.substring(7);
    }
}
