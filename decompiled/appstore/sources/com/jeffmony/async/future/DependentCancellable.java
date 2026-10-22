package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public interface DependentCancellable extends Cancellable {
    boolean setParent(Cancellable r10);
}
