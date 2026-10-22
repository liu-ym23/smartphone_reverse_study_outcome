package d.k;

import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends c {
    public abstract Random a();

    public a() {
    }

    @Override // d.k.c
    public int a(int r1) {
        return d.a(a().nextInt(), r1);
    }

    @Override // d.k.c
    public int b() {
        return a().nextInt();
    }

    @Override // d.k.c
    public long c() {
        return a().nextLong();
    }
}
