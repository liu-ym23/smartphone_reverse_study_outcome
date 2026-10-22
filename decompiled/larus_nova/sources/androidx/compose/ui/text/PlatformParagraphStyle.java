package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\bB\u0013\b\u0016\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\n\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "includeFontPadding", "", "<init>", "(Z)V", "emojiSupportMatch", "Landroidx/compose/ui/text/EmojiSupportMatch;", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "()V", "getIncludeFontPadding$annotations", "getIncludeFontPadding", "()Z", "getEmojiSupportMatch-_3YsG6Y", "()I", "I", "equals", "other", "hashCode", "", "toString", "", "merge", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformParagraphStyle {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final PlatformParagraphStyle Default = null;
    private final int emojiSupportMatch;
    private final boolean includeFontPadding;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.access$getDefault$cp();
        }
    }

    public /* synthetic */ PlatformParagraphStyle(int r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public /* synthetic */ PlatformParagraphStyle(int r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static /* synthetic */ void getIncludeFontPadding$annotations() {
    }

    public final PlatformParagraphStyle merge(PlatformParagraphStyle r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        return r100;
    }

    static {
        Companion = new Companion(null);
        Default = new PlatformParagraphStyle();
    }

    public PlatformParagraphStyle() {
        this(EmojiSupportMatch.Companion.m6853getDefault_3YsG6Y(), false, null);
    }

    public int hashCode() {
        if (this.includeFontPadding == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + EmojiSupportMatch.m6849hashCodeimpl(this.emojiSupportMatch);
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + EmojiSupportMatch.m6850toStringimpl(this.emojiSupportMatch) + ')';
    }

    public static final /* synthetic */ PlatformParagraphStyle access$getDefault$cp() {
        return Default;
    }

    /* JADX INFO: renamed from: getEmojiSupportMatch-_3YsG6Y, reason: not valid java name */
    public final int m6926getEmojiSupportMatch_3YsG6Y() {
        return this.emojiSupportMatch;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public PlatformParagraphStyle(boolean r100) {
        this.includeFontPadding = r100;
        this.emojiSupportMatch = EmojiSupportMatch.Companion.m6853getDefault_3YsG6Y();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PlatformParagraphStyle) == true) goto L8;
        return false;
    L8:
        PlatformParagraphStyle r101 = (PlatformParagraphStyle) r100;
        if (this.includeFontPadding == r101.includeFontPadding) goto L12;
        return false;
    L12:
        if (EmojiSupportMatch.m6848equalsimpl0(this.emojiSupportMatch, r101.emojiSupportMatch) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private PlatformParagraphStyle(int r100) {
        this.includeFontPadding = false;
        this.emojiSupportMatch = r100;
    }

    private PlatformParagraphStyle(int r100, boolean r101) {
        this.includeFontPadding = r101;
        this.emojiSupportMatch = r100;
    }

    public /* synthetic */ PlatformParagraphStyle(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = EmojiSupportMatch.Companion.m6853getDefault_3YsG6Y();
    L5:
        this(r100, null);
    }

    public /* synthetic */ PlatformParagraphStyle(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }

    public /* synthetic */ PlatformParagraphStyle(int r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = EmojiSupportMatch.Companion.m6853getDefault_3YsG6Y();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101, null);
    }
}
