package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class KeyboardCapitalization {
    private static final int Characters = 0;
    public static final Companion Companion = null;
    private static final int None = 0;
    private static final int Sentences = 0;
    private static final int Unspecified = 0;
    private static final int Words = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getUnspecified-IUNYP9k$annotations", "getUnspecified-IUNYP9k", "()I", "I", "None", "getNone-IUNYP9k$annotations", "getNone-IUNYP9k", "Characters", "getCharacters-IUNYP9k$annotations", "getCharacters-IUNYP9k", "Words", "getWords-IUNYP9k$annotations", "getWords-IUNYP9k", "Sentences", "getSentences-IUNYP9k$annotations", "getSentences-IUNYP9k", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getCharacters-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7207getCharactersIUNYP9k$annotations() {
        }

        /* JADX INFO: renamed from: getNone-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7208getNoneIUNYP9k$annotations() {
        }

        /* JADX INFO: renamed from: getSentences-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7209getSentencesIUNYP9k$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7210getUnspecifiedIUNYP9k$annotations() {
        }

        /* JADX INFO: renamed from: getWords-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7211getWordsIUNYP9k$annotations() {
        }

        /* JADX INFO: renamed from: getCharacters-IUNYP9k, reason: not valid java name */
        public final int m7212getCharactersIUNYP9k() {
            return KeyboardCapitalization.access$getCharacters$cp();
        }

        /* JADX INFO: renamed from: getNone-IUNYP9k, reason: not valid java name */
        public final int m7213getNoneIUNYP9k() {
            return KeyboardCapitalization.access$getNone$cp();
        }

        /* JADX INFO: renamed from: getSentences-IUNYP9k, reason: not valid java name */
        public final int m7214getSentencesIUNYP9k() {
            return KeyboardCapitalization.access$getSentences$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-IUNYP9k, reason: not valid java name */
        public final int m7215getUnspecifiedIUNYP9k() {
            return KeyboardCapitalization.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getWords-IUNYP9k, reason: not valid java name */
        public final int m7216getWordsIUNYP9k() {
            return KeyboardCapitalization.access$getWords$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardCapitalization m7200boximpl(int r100) {
        return new KeyboardCapitalization(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m7201constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7202equalsimpl(int r100, Object r101) {
        if ((r101 instanceof KeyboardCapitalization) == true) goto L6;
        return false;
    L6:
        if (r100 == ((KeyboardCapitalization) r101).m7206unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7203equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7204hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7202equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7204hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7206unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Unspecified = m7201constructorimpl(-1);
        None = m7201constructorimpl(0);
        Characters = m7201constructorimpl(1);
        Words = m7201constructorimpl(2);
        Sentences = m7201constructorimpl(3);
    }

    public String toString() {
        return m7205toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getCharacters$cp() {
        return Characters;
    }

    public static final /* synthetic */ int access$getNone$cp() {
        return None;
    }

    public static final /* synthetic */ int access$getSentences$cp() {
        return Sentences;
    }

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    public static final /* synthetic */ int access$getWords$cp() {
        return Words;
    }

    private /* synthetic */ KeyboardCapitalization(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7205toStringimpl(int r100) {
        if (m7203equalsimpl0(r100, Unspecified) == false) goto L6;
        return "Unspecified";
    L6:
        if (m7203equalsimpl0(r100, None) == false) goto L9;
        return "None";
    L9:
        if (m7203equalsimpl0(r100, Characters) == false) goto L12;
        return "Characters";
    L12:
        if (m7203equalsimpl0(r100, Words) == false) goto L15;
        return "Words";
    L15:
        if (m7203equalsimpl0(r100, Sentences) == false) goto L17;
        return "Sentences";
    L17:
        return "Invalid";
    }
}
