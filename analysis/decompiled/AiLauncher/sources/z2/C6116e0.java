package z2;

import com.google.firebase.encoders.EncodingException;
import j3.C4765c;
import java.io.IOException;

/* renamed from: z2.e0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6116e0 implements j3.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f44989a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f44990b = false;

    /* renamed from: c, reason: collision with root package name */
    public C4765c f44991c;

    /* renamed from: d, reason: collision with root package name */
    public final C6076a0 f44992d;

    public C6116e0(C6076a0 c6076a0) {
        this.f44992d = c6076a0;
    }

    public final void a(C4765c c4765c, boolean z10) {
        this.f44989a = false;
        this.f44991c = c4765c;
        this.f44990b = z10;
    }

    public final void b() {
        if (this.f44989a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f44989a = true;
    }

    @Override // j3.g
    public final j3.g c(String str) throws IOException {
        b();
        this.f44992d.e(this.f44991c, str, this.f44990b);
        return this;
    }

    @Override // j3.g
    public final j3.g d(boolean z10) throws IOException {
        b();
        this.f44992d.f(this.f44991c, z10 ? 1 : 0, this.f44990b);
        return this;
    }
}
