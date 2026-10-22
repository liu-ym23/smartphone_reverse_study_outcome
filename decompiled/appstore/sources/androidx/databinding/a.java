package androidx.databinding;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Observable {
    private transient h mCallbacks;

    public a() {
    }

    @Override // androidx.databinding.Observable
    public void addOnPropertyChangedCallback(@NonNull Observable.a r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mCallbacks != null) goto L8;
        this.mCallbacks = new h();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.mCallbacks.a(r10);
    }

    public void notifyChange() {
        monitor-enter(this);
        h r10 = this.mCallbacks;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        r10.d(this, 0, null);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyPropertyChanged(int r10) {
        monitor-enter(this);
        h r11 = this.mCallbacks;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        r11.d(this, r10, null);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.databinding.Observable
    public void removeOnPropertyChangedCallback(@NonNull Observable.a r10) {
        monitor-enter(this);
        h r11 = this.mCallbacks;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        r11.i(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
