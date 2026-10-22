package bo2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f19809a = null;

    static {
        f19809a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
