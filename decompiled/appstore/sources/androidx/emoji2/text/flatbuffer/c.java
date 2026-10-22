package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f3077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Utf8 f3080e;

    public c() {
        this.f3080e = Utf8.a();
    }

    public int a(int r10) {
        return r10 + this.f3077b.getInt(r10);
    }

    public int b(int r10) {
        if (r10 < this.f3079d) goto L7;
        return 0;
    L7:
        return this.f3077b.getShort(this.f3078c + r10);
    }

    public void c(int r10, ByteBuffer r11) {
        this.f3077b = r11;
        if (r11 == null) goto L5;
        this.f3076a = r10;
        int r12 = r10 - r11.getInt(r10);
        this.f3078c = r12;
        this.f3079d = this.f3077b.getShort(r12);
        return;
    L5:
        this.f3076a = 0;
        this.f3078c = 0;
        this.f3079d = 0;
    }

    public int d(int r10) {
        int r11 = r10 + this.f3076a;
        return (r11 + this.f3077b.getInt(r11)) + 4;
    }

    public int e(int r10) {
        int r11 = r10 + this.f3076a;
        int r12 = r11 + this.f3077b.getInt(r11);
        return this.f3077b.getInt(r12);
    }
}
