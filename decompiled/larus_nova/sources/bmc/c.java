package bmc;

import tlc.d;

/* JADX INFO: loaded from: classes36.dex */
public abstract class c<T extends d> implements a {
    public c() {
    }

    public abstract void b(T r100);

    @Override // vlc.l
    public final void onMessage(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getIntType() != dB()) goto L8;
        b(r100);
        return;
    }
}
