package w;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6801a = 0;

    static {
        try {
            Class.forName("com.bytedance.applog.et_verify.EventVerify").getMethod("inst", null).invoke(null, null);
        } catch (Exception unused) {
        } catch (Throwable th) {
            h.a("can't find event verify, should compile with ET", null);
            throw th;
        }
        h.a("can't find event verify, should compile with ET", null);
    }
}
