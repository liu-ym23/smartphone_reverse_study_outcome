package io.reactivex.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static void a(Throwable r10) {
        if ((r10 instanceof VirtualMachineError) == true) goto L14;
        if ((r10 instanceof ThreadDeath) == true) goto L12;
        if ((r10 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r10);
    L12:
        throw ((ThreadDeath) r10);
    L14:
        throw ((VirtualMachineError) r10);
    }
}
