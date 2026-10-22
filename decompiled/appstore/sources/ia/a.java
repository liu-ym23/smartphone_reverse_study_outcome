package ia;

import com.obric.android.agilelogger.formatter.FormatException;
import com.obric.android.agilelogger.formatter.message.json.JsonFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a implements JsonFormatter {
    public a() {
    }

    public String a(String r10) {
        if (r10 == null) goto L19;
        if (r10.trim().length() == 0) goto L19;
    L8:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:" + r10, e);
    L6:
        if (r10.startsWith("{") == false) goto L11;
        return new JSONObject(r10).toString(4);
    L11:
        if (r10.startsWith("[") == false) goto L15;
        return new JSONArray(r10).toString(4);
    L15:
        throw new FormatException("JSON should start with { or [, but found " + r10);     // Catch: Exception -> L8
    L19:
        throw new FormatException("JSON empty.");
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String r10) {
        return a(r10);
    }
}
