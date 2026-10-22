package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public class MutableStateObservable<T> extends StateObservable<T> {
    public static <T> MutableStateObservable<T> withInitialError(Throwable r100) {
        return new MutableStateObservable(r100, true);
    }

    public static <T> MutableStateObservable<T> withInitialState(T r100) {
        return new MutableStateObservable(r100, false);
    }

    public void setError(Throwable r100) {
        updateStateAsError(r100);
    }

    public void setState(T r100) {
        updateState(r100);
    }

    private MutableStateObservable(Object r100, boolean r101) {
        super(r100, r101);
    }
}
