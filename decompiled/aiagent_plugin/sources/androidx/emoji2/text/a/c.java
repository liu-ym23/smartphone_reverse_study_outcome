package androidx.emoji2.text.a;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Table.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f1608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f1609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f1610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1612e;

    public c() {
        this.f1610c = d.a();
    }

    public int b(int r2) {
        if (r2 < this.f1612e) goto L7;
        return 0;
    L7:
        return this.f1609b.getShort(this.f1611d + r2);
    }

    public int c(int r1) {
        return r1 + this.f1609b.getInt(r1);
    }

    public int d(int r2) {
        int r3 = r2 + this.f1608a;
        int r4 = r3 + this.f1609b.getInt(r3);
        return this.f1609b.getInt(r4);
    }

    public int e(int r2) {
        int r3 = r2 + this.f1608a;
        return (r3 + this.f1609b.getInt(r3)) + 4;
    }

    public void c(int r1, ByteBuffer r2) {
        this.f1609b = r2;
        if (r2 == null) goto L5;
        this.f1608a = r1;
        int r3 = r1 - r2.getInt(r1);
        this.f1611d = r3;
        this.f1612e = this.f1609b.getShort(r3);
        return;
    L5:
        this.f1608a = 0;
        this.f1611d = 0;
        this.f1612e = 0;
    }
}
