package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = null;
    private final List<DateFormat> dateFormats;

    static {
        FACTORY = new AnonymousClass1();
    }

    public DateTypeAdapter() {
        ArrayList r10 = new ArrayList();
        this.dateFormats = r10;
        Locale r11 = Locale.US;
        r10.add(DateFormat.getDateTimeInstance(2, 2, r11));
        if (Locale.getDefault().equals(r11) == true) goto L6;
        r10.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r10.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        return;
    }

    private synchronized Date deserializeToDate(String r10) {
        monitor-enter(this);
        Iterator<DateFormat> r11 = this.dateFormats.iterator();     // Catch: Throwable -> L10
    L5:
        if (r11.hasNext() == true) goto L23;
        Date r12 = ISO8601Utils.parse(r10, new ParsePosition(0));     // Catch: Throwable -> L10 ParseException -> L15
        monitor-exit(this);
        return r12;
    L15:
        e = move-exception;
        throw new JsonSyntaxException(r10, e);     // Catch: Throwable -> L10
    L23:
        Date r13 = r11.next().parse(r10);     // Catch: ParseException -> L20 Throwable -> L10
        monitor-exit(this);
        return r13;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r10) throws IOException {
        return read2(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r10, Date r11) throws IOException {
        write2(r10, r11);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r10) throws IOException {
        if (r10.peek() != JsonToken.NULL) goto L7;
        r10.nextNull();
        return null;
    L7:
        return deserializeToDate(r10.nextString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public synchronized void write2(JsonWriter r10, Date r11) throws IOException {
        monitor-enter(this);
        if (r11 != null) goto L9;
        r10.nullValue();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        r10.value(this.dateFormats.get(0).format(r11));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
