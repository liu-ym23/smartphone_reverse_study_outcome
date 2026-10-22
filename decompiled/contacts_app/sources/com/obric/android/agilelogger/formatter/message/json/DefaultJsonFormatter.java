package com.obric.android.agilelogger.formatter.message.json;

import com.obric.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultJsonFormatter implements JsonFormatter {
    private static final int JSON_INDENT = 4;

    public DefaultJsonFormatter() {
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(String r4) {
        if (r4 == null) goto L19;
        if (r4.trim().length() == 0) goto L19;
    L15:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:" + r4, e);
    L7:
        if (r4.startsWith("{") == false) goto L10;
        return new JSONObject(r4).toString(4);
    L10:
        if (r4.startsWith("[") == false) goto L14;
        return new JSONArray(r4).toString(4);
    L14:
        throw new FormatException("JSON should start with { or [, but found " + r4);     // Catch: Exception -> L15
    L19:
        throw new FormatException("JSON empty.");
    }
}
