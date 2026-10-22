package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    public DefaultDateTypeAdapter(Class<? extends Date> r10) {
        ArrayList r11 = new ArrayList();
        this.dateFormats = r11;
        this.dateType = verifyDateType(r10);
        Locale r12 = Locale.US;
        r11.add(DateFormat.getDateTimeInstance(2, 2, r12));
        if (Locale.getDefault().equals(r12) == true) goto L6;
        r11.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r11.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        return;
    }

    private Date deserializeToDate(String r10) {
        List<DateFormat> r11 = this.dateFormats;
        monitor-enter(r11);
        Iterator<DateFormat> r12 = this.dateFormats.iterator();     // Catch: Throwable -> L11
    L6:
        if (r12.hasNext() == true) goto L24;
        Date r13 = ISO8601Utils.parse(r10, new ParsePosition(0));     // Catch: Throwable -> L11 ParseException -> L16
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r13;
    L16:
        e = move-exception;
        throw new JsonSyntaxException(r10, e);     // Catch: Throwable -> L11
    L24:
        Date r14 = r12.next().parse(r10);     // Catch: ParseException -> L21 Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r14;
    L11:
        th = move-exception;
        throw th;
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> r10) {
        if (r10 != Date.class) goto L5;
    L11:
        return r10;
    L5:
        if (r10 == java.sql.Date.class) goto L11;
        if (r10 == Timestamp.class) goto L11;
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + r10);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r10) throws IOException {
        return read2(r10);
    }

    public String toString() {
        DateFormat r10 = this.dateFormats.get(0);
        if ((r10 instanceof SimpleDateFormat) == false) goto L7;
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) r10).toPattern() + ')';
    L7:
        return "DefaultDateTypeAdapter(" + r10.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r10, Date r11) throws IOException {
        write2(r10, r11);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r10) throws IOException {
        if (r10.peek() != JsonToken.NULL) goto L6;
        r10.nextNull();
        return null;
    L6:
        Date r11 = deserializeToDate(r10.nextString());
        Class<? extends Date> r12 = this.dateType;
        if (r12 != Date.class) goto L10;
        return r11;
    L10:
        if (r12 != Timestamp.class) goto L14;
        return new Timestamp(r11.getTime());
    L14:
        if (r12 != java.sql.Date.class) goto L18;
        return new java.sql.Date(r11.getTime());
    L18:
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r10, Date r11) throws IOException {
        if (r11 != null) goto L5;
        r10.nullValue();
        return;
    L5:
        List<DateFormat> r12 = this.dateFormats;
        monitor-enter(r12);
        r10.value(this.dateFormats.get(0).format(r11));     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public DefaultDateTypeAdapter(Class<? extends Date> r10, String r11) {
        ArrayList r12 = new ArrayList();
        this.dateFormats = r12;
        this.dateType = verifyDateType(r10);
        Locale r13 = Locale.US;
        r12.add(new SimpleDateFormat(r11, r13));
        if (Locale.getDefault().equals(r13) == true) goto L6;
        r12.add(new SimpleDateFormat(r11));
        return;
    }

    public DefaultDateTypeAdapter(Class<? extends Date> r10, int r11) {
        ArrayList r12 = new ArrayList();
        this.dateFormats = r12;
        this.dateType = verifyDateType(r10);
        Locale r13 = Locale.US;
        r12.add(DateFormat.getDateInstance(r11, r13));
        if (Locale.getDefault().equals(r13) == true) goto L6;
        r12.add(DateFormat.getDateInstance(r11));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r12.add(PreJava9DateFormatProvider.getUSDateFormat(r11));
        return;
    }

    public DefaultDateTypeAdapter(int r10, int r11) {
        this(Date.class, r10, r11);
    }

    public DefaultDateTypeAdapter(Class<? extends Date> r10, int r11, int r12) {
        ArrayList r13 = new ArrayList();
        this.dateFormats = r13;
        this.dateType = verifyDateType(r10);
        Locale r14 = Locale.US;
        r13.add(DateFormat.getDateTimeInstance(r11, r12, r14));
        if (Locale.getDefault().equals(r14) == true) goto L6;
        r13.add(DateFormat.getDateTimeInstance(r11, r12));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r13.add(PreJava9DateFormatProvider.getUSDateTimeFormat(r11, r12));
        return;
    }
}
