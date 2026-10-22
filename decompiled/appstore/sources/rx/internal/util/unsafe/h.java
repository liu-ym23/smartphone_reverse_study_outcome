package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static int a(int r10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r10 - 1));
    }
}
