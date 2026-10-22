package fg;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final void a(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        kotlin.jvm.internal.q.h(r10, "src");
        kotlin.jvm.internal.q.h(r12, "dest");
        System.arraycopy(r10, r11, r12, r13, r14);
    }

    public static final byte[] b(String r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        byte[] r11 = r10.getBytes(kotlin.text.c.f21252b);
        kotlin.jvm.internal.q.c(r11, "(this as java.lang.String).getBytes(charset)");
        return r11;
    }

    public static final String c(byte[] r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return new String(r10, kotlin.text.c.f21252b);
    }
}
