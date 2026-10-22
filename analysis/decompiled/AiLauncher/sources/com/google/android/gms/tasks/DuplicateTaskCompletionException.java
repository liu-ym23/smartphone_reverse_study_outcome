package com.google.android.gms.tasks;

import D2.i;

/* loaded from: classes2.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(i<?> iVar) {
        if (!iVar.k()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excH = iVar.h();
        return new DuplicateTaskCompletionException("Complete with: ".concat(excH != null ? "failure" : iVar.l() ? "result ".concat(String.valueOf(iVar.i())) : iVar.j() ? "cancellation" : "unknown issue"), excH);
    }
}
