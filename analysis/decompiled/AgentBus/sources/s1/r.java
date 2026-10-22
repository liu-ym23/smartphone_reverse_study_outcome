package s1;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9304a;

    public r() {
        this.f9304a = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.f9304a == ((r) obj).f9304a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + (Boolean.hashCode(this.f9304a) * 31);
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f9304a + ", emojiSupportMatch=EmojiSupportMatch.Default)";
    }

    public r(boolean z4) {
        this.f9304a = z4;
    }
}
