package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }

    private FocusMeteringResult(boolean r100) {
        this.mIsFocusSuccessful = r100;
    }

    public static FocusMeteringResult create(boolean r100) {
        return new FocusMeteringResult(r100);
    }
}
