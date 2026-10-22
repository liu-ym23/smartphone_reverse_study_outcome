package com.google.common.hash;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractCompositeHashFunction extends AbstractStreamingHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    abstract HashCode makeHash(Hasher[] r1);

    AbstractCompositeHashFunction(HashFunction... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Preconditions.checkNotNull(r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        this.functions = r4;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int r0 = this.functions.length;
        final Hasher[] r1 = new Hasher[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = this.functions[r2].newHasher();
        r2 = r2 + 1;
        goto L3
    L6:
        return new AnonymousClass1(this, r1);
    }
}
