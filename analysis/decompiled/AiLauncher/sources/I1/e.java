package I1;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;

/* loaded from: classes.dex */
public class e {
    public static String a(int i10) {
        switch (i10) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case 8:
                return "null";
            case 9:
                return Const.STR_NEW;
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return Const.STR_MART_JSON_BEGIN;
            case 13:
                return "}";
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return Const.STR_MART_COMMA;
            case 17:
                return ServerSentEventKt.COLON;
            case 18:
                return "ident";
            case 19:
            default:
                return "Unknown";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
        }
    }
}
