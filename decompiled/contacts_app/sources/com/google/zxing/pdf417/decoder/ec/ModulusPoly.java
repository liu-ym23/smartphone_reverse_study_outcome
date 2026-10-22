package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: loaded from: classes3.dex */
final class ModulusPoly {
    private final int[] coefficients;
    private final ModulusGF field;

    ModulusPoly(ModulusGF r5, int[] r6) {
        if (r6.length == 0) goto L21;
        this.field = r5;
        int r7 = r6.length;
        if (r7 > 1) goto L7;
    L18:
        this.coefficients = r6;
        return;
    L7:
        if (r6[0] != 0) goto L18;
        int r2 = 1;
    L9:
        if (r2 >= r7) goto L13;
        if (r6[r2] != 0) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 != r7) goto L16;
        this.coefficients = new int[]{0};
        return;
    L16:
        int[] r8 = new int[r7 - r2];
        this.coefficients = r8;
        System.arraycopy(r6, r2, r8, 0, r8.length);
        return;
    L21:
        throw new IllegalArgumentException();
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    int getDegree() {
        return this.coefficients.length - 1;
    }

    boolean isZero() {
        if (this.coefficients[0] != 0) goto L6;
        return true;
    L6:
        return false;
    }

    int getCoefficient(int r2) {
        int[] r1 = this.coefficients;
        return r1[(r1.length - 1) - r2];
    }

    int evaluateAt(int r6) {
        int r0 = 0;
        if (r6 == 0) goto L5;
        int r1 = 1;
        if (r6 != 1) goto L12;
        int[] r7 = this.coefficients;
        int r2 = r7.length;
        int r3 = 0;
    L9:
        if (r0 >= r2) goto L11;
        r3 = this.field.add(r3, r7[r0]);
        r0 = r0 + 1;
        goto L9
    L11:
        return r3;
    L12:
        int[] r4 = this.coefficients;
        int r5 = r4[0];
        int r8 = r4.length;
    L13:
        if (r1 >= r8) goto L15;
        ModulusGF r9 = this.field;
        r5 = r9.add(r9.multiply(r6, r5), this.coefficients[r1]);
        r1 = r1 + 1;
        goto L13
    L15:
        return r5;
    L5:
        return getCoefficient(0);
    }

    ModulusPoly add(ModulusPoly r9) {
        if (this.field.equals(r9.field) == false) goto L21;
        if (isZero() == false) goto L8;
        return r9;
    L8:
        if (r9.isZero() == false) goto L10;
        return this;
    L10:
        int[] r0 = this.coefficients;
        int[] r10 = r9.coefficients;
        if (r0.length > r10.length) goto L14;
        r0 = r10;
        r10 = r0;
    L14:
        int[] r1 = new int[r0.length];
        int r2 = r0.length - r10.length;
        System.arraycopy(r0, 0, r1, 0, r2);
        int r3 = r2;
    L16:
        if (r3 >= r0.length) goto L19;
        r1[r3] = this.field.add(r10[r3 - r2], r0[r3]);
        r3 = r3 + 1;
        goto L16
    L19:
        return new ModulusPoly(this.field, r1);
    L21:
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    ModulusPoly subtract(ModulusPoly r3) {
        if (this.field.equals(r3.field) == false) goto L10;
        if (r3.isZero() == false) goto L8;
        return this;
    L8:
        return add(r3.negative());
    L10:
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    ModulusPoly multiply(ModulusPoly r13) {
        if (this.field.equals(r13.field) == false) goto L20;
        if (isZero() == true) goto L18;
        if (r13.isZero() == true) goto L18;
        int[] r0 = this.coefficients;
        int r1 = r0.length;
        int[] r14 = r13.coefficients;
        int r2 = r14.length;
        int[] r3 = new int[(r1 + r2) - 1];
        int r5 = 0;
    L10:
        if (r5 >= r1) goto L16;
        int r6 = r0[r5];
        int r7 = 0;
    L12:
        if (r7 >= r2) goto L14;
        int r8 = r5 + r7;
        ModulusGF r9 = this.field;
        r3[r8] = r9.add(r3[r8], r9.multiply(r6, r14[r7]));
        r7 = r7 + 1;
        goto L12
    L14:
        r5 = r5 + 1;
        goto L10
    L16:
        return new ModulusPoly(this.field, r3);
    L18:
        return this.field.getZero();
    L20:
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    ModulusPoly negative() {
        int r0 = this.coefficients.length;
        int[] r1 = new int[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.field.subtract(0, this.coefficients[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        return new ModulusPoly(this.field, r1);
    }

    ModulusPoly multiply(int r6) {
        if (r6 != 0) goto L6;
        return this.field.getZero();
    L6:
        if (r6 != 1) goto L8;
        return this;
    L8:
        int r0 = this.coefficients.length;
        int[] r1 = new int[r0];
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L12;
        r1[r2] = this.field.multiply(this.coefficients[r2], r6);
        r2 = r2 + 1;
        goto L9
    L12:
        return new ModulusPoly(this.field, r1);
    }

    ModulusPoly multiplyByMonomial(int r5, int r6) {
        if (r5 < 0) goto L12;
        if (r6 == 0) goto L5;
        int r0 = this.coefficients.length;
        int[] r7 = new int[r5 + r0];
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        r7[r1] = this.field.multiply(this.coefficients[r1], r6);
        r1 = r1 + 1;
        goto L7
    L10:
        return new ModulusPoly(this.field, r7);
    L5:
        return this.field.getZero();
    L12:
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(getDegree() * 8);
        int r1 = getDegree();
    L3:
        if (r1 < 0) goto L21;
        int r2 = getCoefficient(r1);
        if (r2 == 0) goto L19;
        if (r2 >= 0) goto L9;
        r0.append(" - ");
        r2 = -r2;
    L12:
        if (r1 == 0) goto L14;
        if (r2 != 1) goto L14;
    L15:
        if (r1 == 0) goto L19;
        if (r1 != 1) goto L18;
        r0.append('x');
        goto L19
    L18:
        r0.append("x^");
        r0.append(r1);
    L14:
        r0.append(r2);
        goto L15
    L9:
        if (r0.length() <= 0) goto L12;
        r0.append(" + ");
    L19:
        r1 = r1 - 1;
        goto L3
    L21:
        return r0.toString();
    }
}
