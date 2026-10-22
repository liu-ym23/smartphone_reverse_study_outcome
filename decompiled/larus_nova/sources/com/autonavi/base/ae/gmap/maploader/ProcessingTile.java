package com.autonavi.base.ae.gmap.maploader;

/* JADX INFO: loaded from: classes39.dex */
public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = null;
    public long mCreateTime;
    public String mKeyName;

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0;
        M_POOL.release(this);
    }

    static {
        M_POOL = new Pools.SynchronizedPool(30);
    }

    public ProcessingTile(String r100) {
        this.mCreateTime = 0;
        setParams(r100);
    }

    public static ProcessingTile obtain(String r100) {
        ProcessingTile r101 = M_POOL.acquire();
        if (r101 == null) goto L6;
        r101.setParams(r100);
        return r101;
    L6:
        return new ProcessingTile(r100);
    }

    private void setParams(String r100) {
        this.mKeyName = r100;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }
}
