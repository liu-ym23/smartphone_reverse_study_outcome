package androidx.constraintlayout.core.widgets;

/* loaded from: classes2.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f1911x;
    public int y;

    public boolean contains(int i, int i6) {
        int i10;
        int i11 = this.f1911x;
        return i >= i11 && i < i11 + this.width && i6 >= (i10 = this.y) && i6 < i10 + this.height;
    }

    public int getCenterX() {
        return (this.f1911x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void grow(int i, int i6) {
        this.f1911x -= i;
        this.y -= i6;
        this.width = (i * 2) + this.width;
        this.height = (i6 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i6;
        int i10 = this.f1911x;
        int i11 = rectangle.f1911x;
        return i10 >= i11 && i10 < i11 + rectangle.width && (i = this.y) >= (i6 = rectangle.y) && i < i6 + rectangle.height;
    }

    public void setBounds(int i, int i6, int i10, int i11) {
        this.f1911x = i;
        this.y = i6;
        this.width = i10;
        this.height = i11;
    }
}
