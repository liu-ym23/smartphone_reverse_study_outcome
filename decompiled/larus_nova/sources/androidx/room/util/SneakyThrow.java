package androidx.room.util;

/* JADX INFO: loaded from: classes17.dex */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(Exception r100) {
        sneakyThrow(r100);
    }

    private static <E extends Throwable> void sneakyThrow(Throwable r100) throws Throwable {
        throw r100;
    }
}
