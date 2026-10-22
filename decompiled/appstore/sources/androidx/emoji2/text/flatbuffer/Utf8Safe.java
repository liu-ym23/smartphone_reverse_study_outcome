package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
        }
    }

    public Utf8Safe() {
    }
}
