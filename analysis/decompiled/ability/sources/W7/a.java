package W7;

import java.util.Random;

/* loaded from: classes3.dex */
public abstract class a extends c {
    @Override // W7.c
    public final int a(int i) {
        return (f().nextInt() >>> (32 - i)) & ((-i) >> 31);
    }

    @Override // W7.c
    public final int b() {
        return f().nextInt();
    }

    @Override // W7.c
    public final long d() {
        return f().nextLong();
    }

    public abstract Random f();
}
