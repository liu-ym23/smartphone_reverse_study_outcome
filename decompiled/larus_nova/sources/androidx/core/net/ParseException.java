package androidx.core.net;

/* JADX INFO: loaded from: classes17.dex */
public class ParseException extends RuntimeException {
    public final String response;

    public ParseException(String r100) {
        super(r100);
        this.response = r100;
    }
}
