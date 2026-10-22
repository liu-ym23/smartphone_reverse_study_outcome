package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: CallbackException.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends RuntimeException {
    b(Throwable r2) {
        super("Unexpected exception thrown by non-Glide code", r2);
    }
}
