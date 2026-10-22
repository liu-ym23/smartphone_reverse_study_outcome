package org.tensorflow.lite.support.c;

/* JADX INFO: compiled from: TensorBufferUint8.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final org.tensorflow.lite.a f40613e = null;

    static {
        f40613e = org.tensorflow.lite.a.f40581c;
    }

    c() {
    }

    @Override // org.tensorflow.lite.support.c.a
    public org.tensorflow.lite.a b() {
        return f40613e;
    }

    @Override // org.tensorflow.lite.support.c.a
    public int c() {
        return f40613e.a();
    }

    @Override // org.tensorflow.lite.support.c.a
    public void a(float[] r10, int[] r11) {
        org.tensorflow.lite.support.a.a.a.a(r10, "The array to be loaded cannot be null.");
        int r2 = 0;
        if (r10.length != a(r11)) goto L5;
        boolean r0 = true;
    L6:
        org.tensorflow.lite.support.a.a.a.a(r0, "The size of the array to be loaded does not match the specified shape.");
        d();
        b(r11);
        this.f40607a.rewind();
        byte[] r12 = new byte[r10.length];
        int r1 = r10.length;
        int r3 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r12[r3] = (byte) Math.max(Math.min(r10[r2], 255.0d), 0.0d);
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L7
    L9:
        this.f40607a.put(r12);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
