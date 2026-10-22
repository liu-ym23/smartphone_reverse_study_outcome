package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Utf8 f3075a;

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
        }
    }

    public Utf8() {
    }

    public static Utf8 a() {
        if (f3075a != null) goto L6;
        f3075a = new Utf8Safe();
    L6:
        return f3075a;
    }
}
