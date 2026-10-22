package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    public AbstractCompositeHashFunction(HashFunction... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Preconditions.checkNotNull(r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        this.functions = r10;
    }

    private Hasher fromHashers(final Hasher[] r10) {
        return new AnonymousClass1(this, r10);
    }

    public abstract HashCode makeHash(Hasher[] r10);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int r10 = this.functions.length;
        Hasher[] r11 = new Hasher[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L6;
        r11[r12] = this.functions[r12].newHasher();
        r12 = r12 + 1;
        goto L3
    L6:
        return fromHashers(r11);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int r10) {
        int r11 = 0;
        if (r10 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = this.functions.length;
        Hasher[] r14 = new Hasher[r13];
    L7:
        if (r11 >= r13) goto L10;
        r14[r11] = this.functions[r11].newHasher(r10);
        r11 = r11 + 1;
        goto L7
    L10:
        return fromHashers(r14);
    L5:
        r12 = false;
        goto L6
    }
}
