package fi.iki.elonen;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class NanoHTTPD$Method {

    /* renamed from: a, reason: collision with root package name */
    public static final NanoHTTPD$Method f4449a;
    public static final NanoHTTPD$Method b;
    public static final NanoHTTPD$Method c;
    public static final /* synthetic */ NanoHTTPD$Method[] d;

    /* JADX INFO: Fake field, exist only in values array */
    NanoHTTPD$Method EF1;

    static {
        NanoHTTPD$Method nanoHTTPD$Method = new NanoHTTPD$Method("GET", 0);
        NanoHTTPD$Method nanoHTTPD$Method2 = new NanoHTTPD$Method("PUT", 1);
        f4449a = nanoHTTPD$Method2;
        NanoHTTPD$Method nanoHTTPD$Method3 = new NanoHTTPD$Method("POST", 2);
        b = nanoHTTPD$Method3;
        NanoHTTPD$Method nanoHTTPD$Method4 = new NanoHTTPD$Method("DELETE", 3);
        NanoHTTPD$Method nanoHTTPD$Method5 = new NanoHTTPD$Method("HEAD", 4);
        c = nanoHTTPD$Method5;
        d = new NanoHTTPD$Method[]{nanoHTTPD$Method, nanoHTTPD$Method2, nanoHTTPD$Method3, nanoHTTPD$Method4, nanoHTTPD$Method5, new NanoHTTPD$Method("OPTIONS", 5), new NanoHTTPD$Method("TRACE", 6), new NanoHTTPD$Method("CONNECT", 7), new NanoHTTPD$Method("PATCH", 8), new NanoHTTPD$Method("PROPFIND", 9), new NanoHTTPD$Method("PROPPATCH", 10), new NanoHTTPD$Method("MKCOL", 11), new NanoHTTPD$Method("MOVE", 12), new NanoHTTPD$Method("COPY", 13), new NanoHTTPD$Method("LOCK", 14), new NanoHTTPD$Method("UNLOCK", 15)};
    }

    public static NanoHTTPD$Method a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static NanoHTTPD$Method valueOf(String str) {
        return (NanoHTTPD$Method) Enum.valueOf(NanoHTTPD$Method.class, str);
    }

    public static NanoHTTPD$Method[] values() {
        return (NanoHTTPD$Method[]) d.clone();
    }
}
