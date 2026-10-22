package bytedance.jvm.time.chrono;

/* JADX INFO: loaded from: classes28.dex */
public interface l extends bytedance.jvm.time.temporal.d, bytedance.jvm.time.temporal.e {
    int getValue();

    @Override // bytedance.jvm.time.temporal.d
    <R> R query(bytedance.jvm.time.temporal.l<R> r100);
}
