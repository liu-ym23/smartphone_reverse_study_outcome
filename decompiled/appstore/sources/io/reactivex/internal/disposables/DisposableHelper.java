package io.reactivex.internal.disposables;

import androidx.lifecycle.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements Disposable {
    private static final /* synthetic */ DisposableHelper[] $VALUES = null;
    public static final DisposableHelper DISPOSED = null;

    static {
        DisposableHelper r10 = new DisposableHelper("DISPOSED", 0);
        DISPOSED = r10;
        $VALUES = new DisposableHelper[]{r10};
    }

    private DisposableHelper(String r10, int r11) {
        super(r10, r11);
    }

    public static boolean replace(AtomicReference<Disposable> r10, Disposable r11) {
    L2:
        Disposable r12 = r10.get();
        if (r12 == DISPOSED) goto L4;
        if (p.a(r10, r12, r11) == false) goto L2;
        return true;
    L4:
        if (r11 == null) goto L15;
        r11.dispose();
        return false;
    L15:
        return false;
    }

    public static void reportDisposableSet() {
        a.e(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<Disposable> r10, Disposable r11) {
    L2:
        Disposable r12 = r10.get();
        if (r12 == DISPOSED) goto L4;
        if (p.a(r10, r12, r11) == false) goto L2;
        if (r12 == null) goto L18;
        r12.dispose();
        return true;
    L18:
        return true;
    L4:
        if (r11 == null) goto L17;
        r11.dispose();
        return false;
    L17:
        return false;
    }

    public static boolean setOnce(AtomicReference<Disposable> r10, Disposable r11) {
        io.reactivex.internal.functions.a.b(r11, "d is null");
        if (p.a(r10, null, r11) == true) goto L9;
        r11.dispose();
        if (r10.get() == DISPOSED) goto L11;
        reportDisposableSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean trySet(AtomicReference<Disposable> r10, Disposable r11) {
        if (p.a(r10, null, r11) == false) goto L5;
        return true;
    L5:
        if (r10.get() != DISPOSED) goto L11;
        r11.dispose();
        return false;
    L11:
        return false;
    }

    public static boolean validate(Disposable r10, Disposable r11) {
        if (r11 != null) goto L6;
        a.e(new NullPointerException("next is null"));
        return false;
    L6:
        if (r10 == null) goto L9;
        r11.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }

    public static DisposableHelper valueOf(String r10) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, r10);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) $VALUES.clone();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> r10) {
        Disposable r11 = r10.get();
        DisposableHelper r12 = DISPOSED;
        if (r11 == r12) goto L10;
        Disposable r13 = r10.getAndSet(r12);
        if (r13 == r12) goto L13;
        if (r13 == null) goto L12;
        r13.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isDisposed(Disposable r10) {
        if (r10 != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }
}
