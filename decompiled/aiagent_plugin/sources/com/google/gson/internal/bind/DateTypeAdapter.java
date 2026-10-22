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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = null;
    private final List<DateFormat> dateFormats;

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r1) {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Date r4) {
        write2(r3, (Date) ZeusTransformUtils.preCheckCast(r4, Date.class, "com.obric.aiagent.plugin"));
    }

    static {
        FACTORY = new AnonymousClass1();
    }

    public DateTypeAdapter() {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        r0.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        return;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r3) {
        if (r3.peek() != JsonToken.NULL) goto L7;
        r3.nextNull();
        return null;
    L7:
        return deserializeToDate(r3);
    }

    private Date deserializeToDate(JsonReader r6) {
        String r0 = r6.nextString();
        List<DateFormat> r1 = this.dateFormats;
        monitor-enter(r1);
        Iterator<DateFormat> r5 = this.dateFormats.iterator();     // Catch: Throwable -> L17
    L6:
        if (r5.hasNext() == false) goto L11;
        Date r7 = ((DateFormat) ZeusTransformUtils.preCheckCast(r5.next(), DateFormat.class, "com.obric.aiagent.plugin")).parse(r0);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return ISO8601Utils.parse(r0, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r0 + "' as Date; at path " + r6.getPreviousPath(), e);
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r4, Date r5) {
        if (r5 != null) goto L5;
        r4.nullValue();
        return;
    L5:
        DateFormat r0 = (DateFormat) ZeusTransformUtils.preCheckCast(this.dateFormats.get(0), DateFormat.class, "com.obric.aiagent.plugin");
        List<DateFormat> r3 = this.dateFormats;
        monitor-enter(r3);
        String r6 = r0.format(r5);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        r4.value(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
