package bl4;

import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends a {
    public final String toString() {
        return "DoraGetApListEvent";
    }

    public c() {
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        return n.u(new byte[]{-127, (byte) r101.length}, r101);
    }
}
