package com.google.gson.internal.sql;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time read(JsonReader r1) throws IOException {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Time r2) throws IOException {
        write2(r1, r2);
    }

    /* synthetic */ SqlTimeTypeAdapter(AnonymousClass1 r1) {
        this();
    }

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Time read2(JsonReader r8) throws IOException {
        if (r8.peek() != JsonToken.NULL) goto L6;
        r8.nextNull();
        return null;
    L6:
        String r1 = r8.nextString();
        monitor-enter(this);
        TimeZone r2 = this.format.getTimeZone();     // Catch: Throwable -> L20
        Time r4 = new Time(this.format.parse(r1).getTime());     // Catch: Throwable -> L13 ParseException -> L15
        this.format.setTimeZone(r2);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r4;
    L13:
        th = move-exception;
        this.format.setTimeZone(r2);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L15:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r1 + "' as SQL Time; at path " + r8.getPreviousPath(), e);     // Catch: Throwable -> L13
    L20:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r2, Time r3) throws IOException {
        if (r3 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        monitor-enter(this);
        String r4 = this.format.format(r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r2.value(r4);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
