package org.tensorflow.lite.support.c;

/* JADX INFO: compiled from: TensorBufferFloat.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final org.tensorflow.lite.a f40612e = null;

    static {
        f40612e = org.tensorflow.lite.a.f40579a;
    }

    b() {
    }

    @Override // org.tensorflow.lite.support.c.a
    public org.tensorflow.lite.a b() {
        return f40612e;
    }

    @Override // org.tensorflow.lite.support.c.a
    public int c() {
        return f40612e.a();
    }

    @Override // org.tensorflow.lite.support.c.a
    public void a(float[] r3, int[] r4) {
        org.tensorflow.lite.support.a.a.a.a(r3, "The array to be loaded cannot be null.");
        if (r3.length != a(r4)) goto L5;
        boolean r0 = true;
    L6:
        org.tensorflow.lite.support.a.a.a.a(r0, "The size of the array to be loaded does not match the specified shape.");
        d();
        b(r4);
        this.f40607a.rewind();
        this.f40607a.asFloatBuffer().put(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
