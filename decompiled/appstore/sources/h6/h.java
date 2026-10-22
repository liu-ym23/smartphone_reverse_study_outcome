package h6;

/* JADX INFO: loaded from: classes.dex */
public class h extends f {
    public h(String r10) {
        super("text/plain; charset=UTF-8", c(r10), new String[0]);
    }

    public static byte[] c(String r10) {
        return r10.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // h6.f
    public String toString() {
        return "TypedString[" + new String(b(), "UTF-8") + "]";
    L5:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
