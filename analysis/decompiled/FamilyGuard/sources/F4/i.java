package F4;

import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private IOException f1811a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f1812b;

    i(IOException iOException) {
        super(iOException);
        this.f1811a = iOException;
        this.f1812b = iOException;
    }

    void a(IOException iOException) {
        D4.e.b(this.f1811a, iOException);
        this.f1812b = iOException;
    }

    public IOException b() {
        return this.f1811a;
    }

    public IOException c() {
        return this.f1812b;
    }
}
