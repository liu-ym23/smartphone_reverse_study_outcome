package com.baidu.platform.comjni;

/* JADX INFO: loaded from: classes39.dex */
public abstract class NativeComponent extends JNIBaseApi implements AutoCloseable {
    protected volatile long mNativePointer;

    public abstract long create();

    public abstract int dispose();

    public NativeComponent() {
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        dispose();
    }
}
