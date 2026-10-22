package com.google.gson.internal.bind;

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

/* JADX INFO: loaded from: classes3.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    static {
        FACTORY = new AnonymousClass1();
    }

    public TimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time read(JsonReader r10) throws IOException {
        return read2(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r10, Time r11) throws IOException {
        write2(r10, r11);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public synchronized Time read2(JsonReader r10) throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r10.peek() != JsonToken.NULL) goto L19;
        r10.nextNull();     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L19:
        Time r11 = new Time(this.format.parse(r10.nextString()).getTime());     // Catch: Throwable -> L9 ParseException -> L14
        monitor-exit(this);
        return r11;
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L9
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public synchronized void write2(JsonWriter r10, Time r11) throws IOException {
        monitor-enter(this);
        if (r11 != null) goto L12;
        String r12 = null;
    L6:
        r10.value(r12);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r12 = this.format.format(r11);     // Catch: Throwable -> L9
        goto L6
    }
}
