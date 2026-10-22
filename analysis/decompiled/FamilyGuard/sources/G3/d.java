package G3;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public interface d<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
