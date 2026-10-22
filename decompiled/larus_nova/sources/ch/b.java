package ch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23712a = null;

    static {
        f23712a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
