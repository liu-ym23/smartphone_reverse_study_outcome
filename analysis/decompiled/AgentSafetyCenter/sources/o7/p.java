package o7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements CharSequence {

    /* renamed from: c, reason: collision with root package name */
    public char[] f9281c;

    /* renamed from: f, reason: collision with root package name */
    public String f9282f;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f9281c[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f9281c.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        return new String(this.f9281c, i, i3 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f9282f == null) {
            this.f9282f = new String(this.f9281c);
        }
        return this.f9282f;
    }
}
