package bytedance.jvm.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public interface d {
    int get(j r100);

    long getLong(j r100);

    boolean isSupported(j r100);

    <R> R query(l<R> r100);

    ValueRange range(j r100);
}
