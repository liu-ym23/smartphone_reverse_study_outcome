package cbc;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes38.dex */
public interface d {
    void cancel();

    Object f(Continuation<? super Result<Unit>> r100);

    void start();

    void stop();
}
