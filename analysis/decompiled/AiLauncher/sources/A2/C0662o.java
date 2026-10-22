package A2;

import com.google.firebase.encoders.EncodingException;
import j3.C4765c;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: A2.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0662o implements j3.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f814a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f815b = false;

    /* renamed from: c, reason: collision with root package name */
    public C4765c f816c;

    /* renamed from: d, reason: collision with root package name */
    public final C0638k f817d;

    public C0662o(C0638k c0638k) {
        this.f817d = c0638k;
    }

    private final void b() {
        if (this.f814a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f814a = true;
    }

    public final void a(C4765c c4765c, boolean z10) {
        this.f814a = false;
        this.f816c = c4765c;
        this.f815b = z10;
    }

    @Override // j3.g
    public final j3.g c(String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b();
        this.f817d.e(this.f816c, str, this.f815b);
        return this;
    }

    @Override // j3.g
    public final j3.g d(boolean z10) throws IOException {
        b();
        this.f817d.f(this.f816c, z10 ? 1 : 0, this.f815b);
        return this;
    }
}
