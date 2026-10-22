package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes17.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15333x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f15334y;

    public Rectangle() {
    }

    public int getCenterX() {
        return (this.f15333x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f15334y + this.height) / 2;
    }

    public boolean intersects(Rectangle r100) {
        int r101 = this.f15333x;
        int r102 = r100.f15333x;
        if (r101 >= r102) goto L5;
    L11:
        return false;
    L5:
        if (r101 >= (r102 + r100.width)) goto L11;
        int r103 = this.f15334y;
        int r104 = r100.f15334y;
        if (r103 < r104) goto L11;
        if (r103 >= (r104 + r100.height)) goto L11;
        return true;
    }

    public boolean contains(int r100, int r101) {
        int r102 = this.f15333x;
        if (r100 >= r102) goto L5;
    L11:
        return false;
    L5:
        if (r100 >= (r102 + this.width)) goto L11;
        int r103 = this.f15334y;
        if (r101 < r103) goto L11;
        if (r101 >= (r103 + this.height)) goto L11;
        return true;
    }

    public void grow(int r100, int r101) {
        this.f15333x -= r100;
        this.f15334y -= r101;
        this.width += r100 * 2;
        this.height += r101 * 2;
    }

    public void setBounds(int r100, int r101, int r102, int r103) {
        this.f15333x = r100;
        this.f15334y = r101;
        this.width = r102;
        this.height = r103;
    }
}
