package e2;

import java.text.CharacterIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements CharacterIterator {

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f3415c;

    /* renamed from: f, reason: collision with root package name */
    public int f3416f;

    /* renamed from: g, reason: collision with root package name */
    public int f3417g;

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
        int i = this.f3417g;
        if (i == this.f3416f) {
            return (char) 65535;
        }
        return this.f3415c.charAt(i);
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.f3417g = 0;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.f3416f;
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.f3417g;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        int i = this.f3416f;
        if (i == 0) {
            this.f3417g = i;
            return (char) 65535;
        }
        int i3 = i - 1;
        this.f3417g = i3;
        return this.f3415c.charAt(i3);
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        int i = this.f3417g + 1;
        this.f3417g = i;
        int i3 = this.f3416f;
        if (i < i3) {
            return this.f3415c.charAt(i);
        }
        this.f3417g = i3;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        int i = this.f3417g;
        if (i <= 0) {
            return (char) 65535;
        }
        int i3 = i - 1;
        this.f3417g = i3;
        return this.f3415c.charAt(i3);
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int i) {
        if (i > this.f3416f || i < 0) {
            g5.f.s("invalid position");
            return (char) 0;
        }
        this.f3417g = i;
        return current();
    }
}
