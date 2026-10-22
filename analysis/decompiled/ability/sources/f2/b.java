package f2;

import androidx.compose.runtime.ComposerKt;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f4434a;
    public final byte[] b;

    public b() {
        this.f4434a = 0;
    }

    public boolean a() {
        return this.f4434a != 207;
    }

    public b(int i) {
        this.f4434a = i;
    }

    public b(int i, Throwable th) {
        this.f4434a = i;
        th.getMessage();
    }

    public b(byte[] bArr) {
        this.f4434a = ComposerKt.providerMapsKey;
        this.b = bArr;
    }

    public b(int i, byte[] bArr) {
        this.f4434a = i;
        this.b = bArr;
    }
}
