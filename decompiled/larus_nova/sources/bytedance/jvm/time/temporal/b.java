package bytedance.jvm.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends d {
    boolean isSupported(m r100);

    b minus(long r100, m r101);

    b plus(long r100, m r101);

    @Override // bytedance.jvm.time.temporal.d
    /* bridge */ /* synthetic */ Object query(l r100);

    long until(b r100, m r101);

    b with(e r100);

    b with(j r100, long r101);
}
