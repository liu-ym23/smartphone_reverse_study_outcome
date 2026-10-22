package com.google.zxing.client.result;

import com.bytedance.common.utility.date.DateDef;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarParsedResult extends ParsedResult {
    private static final Pattern DATE_TIME = null;
    private static final Pattern RFC2445_DURATION = null;
    private static final long[] RFC2445_DURATION_FIELD_UNITS = null;
    private final String[] attendees;
    private final String description;
    private final Date end;
    private final boolean endAllDay;
    private final double latitude;
    private final String location;
    private final double longitude;
    private final String organizer;
    private final Date start;
    private final boolean startAllDay;
    private final String summary;

    static {
        RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
        RFC2445_DURATION_FIELD_UNITS = new long[]{DateDef.WEEK, 86400000, DateDef.HOUR, 60000, 1000};
        DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    }

    public CalendarParsedResult(String r8, String r9, String r10, String r11, String r12, String r13, String[] r14, String r15, double r16, double r18) {
        super(ParsedResultType.CALENDAR);
        this.summary = r8;
        Date r1 = parseDate(r9);     // Catch: ParseException -> L26
        this.start = r1;     // Catch: ParseException -> L26
        if (r10 != null) goto L29;
        long r2 = parseDurationMS(r11);
        if (r2 >= 0) goto L8;
        Date r3 = null;
    L9:
        this.end = r3;
    L11:
        boolean r4 = true;
        if (r9.length() != 8) goto L14;
        boolean r5 = true;
    L15:
        this.startAllDay = r5;
        if (r10 != null) goto L18;
    L20:
        r4 = false;
    L21:
        this.endAllDay = r4;
        this.location = r12;
        this.organizer = r13;
        this.attendees = r14;
        this.description = r15;
        this.latitude = r16;
        this.longitude = r18;
        return;
    L18:
        if (r10.length() != 8) goto L20;
    L14:
        r5 = false;
        goto L15
    L8:
        r3 = new Date(r1.getTime() + r2);
        goto L9
    L29:
        this.end = parseDate(r10);     // Catch: ParseException -> L23
    L23:
        e = move-exception;
        throw new IllegalArgumentException(e.toString());
    L26:
        e = move-exception;
        throw new IllegalArgumentException(e.toString());
    }

    public String getSummary() {
        return this.summary;
    }

    public Date getStart() {
        return this.start;
    }

    public boolean isStartAllDay() {
        return this.startAllDay;
    }

    public Date getEnd() {
        return this.end;
    }

    public boolean isEndAllDay() {
        return this.endAllDay;
    }

    public String getLocation() {
        return this.location;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public String[] getAttendees() {
        return this.attendees;
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(100);
        maybeAppend(this.summary, r0);
        maybeAppend(format(this.startAllDay, this.start), r0);
        maybeAppend(format(this.endAllDay, this.end), r0);
        maybeAppend(this.location, r0);
        maybeAppend(this.organizer, r0);
        maybeAppend(this.attendees, r0);
        maybeAppend(this.description, r0);
        return r0.toString();
    }

    private static Date parseDate(String r7) throws ParseException {
        if (DATE_TIME.matcher(r7).matches() == false) goto L16;
        if (r7.length() != 8) goto L9;
        return buildDateFormat().parse(r7);
    L9:
        if (r7.length() != 16) goto L14;
        if (r7.charAt(15) != 'Z') goto L14;
        Date r8 = buildDateTimeFormat().parse(r7.substring(0, 15));
        GregorianCalendar r1 = new GregorianCalendar();
        long r3 = r8.getTime() + ((long) r1.get(15));
        r1.setTime(new Date(r3));
        return new Date(r3 + ((long) r1.get(16)));
    L14:
        return buildDateTimeFormat().parse(r7);
    L16:
        throw new ParseException(r7, 0);
    }

    private static String format(boolean r1, Date r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r1 == false) goto L8;
        DateFormat r3 = DateFormat.getDateInstance(2);
    L10:
        return r3.format(r2);
    L8:
        r3 = DateFormat.getDateTimeInstance(2, 2);
        goto L10
    }

    private static long parseDurationMS(CharSequence r7) {
        if (r7 != null) goto L5;
        return -1;
    L5:
        Matcher r8 = RFC2445_DURATION.matcher(r7);
        if (r8.matches() == true) goto L8;
        return -1;
    L8:
        long r0 = 0;
        int r2 = 0;
    L9:
        long[] r3 = RFC2445_DURATION_FIELD_UNITS;
        if (r2 >= r3.length) goto L15;
        int r4 = r2 + 1;
        String r5 = r8.group(r4);
        if (r5 == null) goto L14;
        r0 = r0 + (r3[r2] * ((long) Integer.parseInt(r5)));
    L14:
        r2 = r4;
        goto L9
    L15:
        return r0;
    }

    private static DateFormat buildDateFormat() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        r0.setTimeZone(TimeZone.getTimeZone("GMT"));
        return r0;
    }

    private static DateFormat buildDateTimeFormat() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }
}
