package androidx.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: classes17.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    public int hashCode() {
        return this.mToken.hashCode();
    }

    public WindowIdApi14(IBinder r100) {
        this.mToken = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof WindowIdApi14) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi14) r100).mToken.equals(this.mToken) == false) goto L7;
        return true;
    }
}
