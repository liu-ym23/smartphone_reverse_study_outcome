package t1;

import java.text.CharacterIterator;

/* loaded from: classes.dex */
public final class a implements CharacterIterator {

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f9669f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9670g;

    /* renamed from: h, reason: collision with root package name */
    public int f9671h = 0;

    public a(CharSequence charSequence, int i2) {
        this.f9669f = charSequence;
        this.f9670g = i2;
    }

    @Override // java.text.CharacterIterator
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public final char current() {
        int i2 = this.f9671h;
        if (i2 == this.f9670g) {
            return (char) 65535;
        }
        return this.f9669f.charAt(i2);
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.f9671h = 0;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.f9670g;
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.f9671h;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        int i2 = this.f9670g;
        if (i2 == 0) {
            this.f9671h = i2;
            return (char) 65535;
        }
        int i10 = i2 - 1;
        this.f9671h = i10;
        return this.f9669f.charAt(i10);
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        int i2 = this.f9671h + 1;
        this.f9671h = i2;
        int i10 = this.f9670g;
        if (i2 < i10) {
            return this.f9669f.charAt(i2);
        }
        this.f9671h = i10;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        int i2 = this.f9671h;
        if (i2 <= 0) {
            return (char) 65535;
        }
        int i10 = i2 - 1;
        this.f9671h = i10;
        return this.f9669f.charAt(i10);
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int i2) {
        if (i2 > this.f9670g || i2 < 0) {
            throw new IllegalArgumentException("invalid position");
        }
        this.f9671h = i2;
        return current();
    }
}
