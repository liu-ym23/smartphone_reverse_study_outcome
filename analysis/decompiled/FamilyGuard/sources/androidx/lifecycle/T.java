package androidx.lifecycle;

import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    private final X.i f10840a;

    public T() {
        this.f10840a = new X.i();
    }

    public final void G(String str, AutoCloseable autoCloseable) {
        j4.k.g(str, "key");
        j4.k.g(autoCloseable, "closeable");
        X.i iVar = this.f10840a;
        if (iVar != null) {
            iVar.d(str, autoCloseable);
        }
    }

    public final void H() {
        X.i iVar = this.f10840a;
        if (iVar != null) {
            iVar.e();
        }
        J();
    }

    public final <T extends AutoCloseable> T I(String str) {
        j4.k.g(str, "key");
        X.i iVar = this.f10840a;
        if (iVar != null) {
            return (T) iVar.g(str);
        }
        return null;
    }

    protected void J() {
    }

    public T(s4.I i5) {
        j4.k.g(i5, "viewModelScope");
        this.f10840a = new X.i(i5);
    }

    public T(AutoCloseable... autoCloseableArr) {
        j4.k.g(autoCloseableArr, "closeables");
        this.f10840a = new X.i((AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public T(s4.I i5, AutoCloseable... autoCloseableArr) {
        j4.k.g(i5, "viewModelScope");
        j4.k.g(autoCloseableArr, "closeables");
        this.f10840a = new X.i(i5, (AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public /* synthetic */ T(Closeable... closeableArr) {
        j4.k.g(closeableArr, "closeables");
        this.f10840a = new X.i((AutoCloseable[]) Arrays.copyOf(closeableArr, closeableArr.length));
    }
}
