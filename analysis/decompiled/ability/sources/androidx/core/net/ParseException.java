package androidx.core.net;

/* loaded from: classes2.dex */
public class ParseException extends RuntimeException {
    public final String response;

    public ParseException(String str) {
        super(str);
        this.response = str;
    }
}
