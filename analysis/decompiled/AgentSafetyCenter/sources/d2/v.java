package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3179a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.f3179a == ((v) obj).f3179a;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + (Boolean.hashCode(this.f3179a) * 31);
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f3179a + ", emojiSupportMatch=EmojiSupportMatch.Default)";
    }
}
