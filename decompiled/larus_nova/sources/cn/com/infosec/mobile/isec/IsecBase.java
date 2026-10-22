package cn.com.infosec.mobile.isec;

/* JADX INFO: loaded from: classes28.dex */
public class IsecBase {
    private long ctx;

    private native boolean createContextNative();

    private native void destroyContextNative();

    private native void resetNative();

    public boolean isValid() {
        if (this.ctx == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public IsecBase() {
        createContext();
    }

    public boolean createContext() {
        return createContextNative();
    }

    public void destroyContext() {
        destroyContextNative();
    }

    public void finalize() {
        destroyContext();
    }

    public long getContext() {
        return this.ctx;
    }

    public void reset() {
        resetNative();
    }
}
