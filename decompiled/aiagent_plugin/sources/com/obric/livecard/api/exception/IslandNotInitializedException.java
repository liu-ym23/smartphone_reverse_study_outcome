package com.obric.livecard.api.exception;

/* JADX INFO: compiled from: IslandNotInitializedException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandNotInitializedException extends RuntimeException {
    public IslandNotInitializedException() {
        super("This method must be called only after ILiveCard.inst.init has been invoked");
    }
}
