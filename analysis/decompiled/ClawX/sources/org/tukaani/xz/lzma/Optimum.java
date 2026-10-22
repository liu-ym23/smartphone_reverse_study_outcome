package org.tukaani.xz.lzma;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class Optimum {
    private static final int INFINITY_PRICE = 1073741824;
    int backPrev;
    int backPrev2;
    boolean hasPrev2;
    int optPrev;
    int optPrev2;
    boolean prev1IsLiteral;
    int price;
    final State state = new State();
    final int[] reps = new int[4];

    public void reset() {
        this.price = INFINITY_PRICE;
    }

    public void set1(int i8, int i9, int i10) {
        this.price = i8;
        this.optPrev = i9;
        this.backPrev = i10;
        this.prev1IsLiteral = false;
    }

    public void set2(int i8, int i9, int i10) {
        this.price = i8;
        this.optPrev = i9 + 1;
        this.backPrev = i10;
        this.prev1IsLiteral = true;
        this.hasPrev2 = false;
    }

    public void set3(int i8, int i9, int i10, int i11, int i12) {
        this.price = i8;
        this.optPrev = i11 + i9 + 1;
        this.backPrev = i12;
        this.prev1IsLiteral = true;
        this.hasPrev2 = true;
        this.optPrev2 = i9;
        this.backPrev2 = i10;
    }
}
