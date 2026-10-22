package bl4;

import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends a {
    public final String toString() {
        return "DoraGetWifiListEvent";
    }

    public d() {
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        return n.u(new byte[]{-125, (byte) r101.length}, r101);
    }
}
