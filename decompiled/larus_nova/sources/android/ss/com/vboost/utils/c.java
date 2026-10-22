package android.ss.com.vboost.utils;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> {
    private volatile boolean hasInitialized;
    private volatile boolean hasSetInitialValue;
    private volatile T value;

    public c() {
        this.hasInitialized = false;
        this.hasSetInitialValue = false;
    }

    private T setInitialValue() {
        if (this.hasSetInitialValue == true) goto L5;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.hasSetInitialValue == false) goto L12;
        T r100 = this.value;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r100;
    L12:
        this.value = initialValue();     // Catch: Throwable -> L15
        this.hasSetInitialValue = true;     // Catch: Throwable -> L15
        T r101 = this.value;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r101;
    L5:
        return this.value;
    }

    public T get() {
        if (this.value == null) goto L7;
        return this.value;
    L7:
        return setInitialValue();
    }

    public boolean hasInitialized() {
        return this.hasInitialized;
    }

    public T initialValue() {
        throw null;
    }

    public void set(T r100) {
        this.value = r100;
        this.hasInitialized = true;
    }
}
