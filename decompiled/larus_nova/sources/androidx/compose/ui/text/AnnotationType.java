package androidx.compose.ui.text;

import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/AnnotationType;", "", "<init>", "(Ljava/lang/String;I)V", "Paragraph", "Span", "VerbatimTts", "Url", ComposerHelper.CONFIG_LINK, "Clickable", "String", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum AnnotationType extends Enum<AnnotationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnnotationType[] $VALUES = null;
    public static final AnnotationType Clickable = null;
    public static final AnnotationType Link = null;
    public static final AnnotationType Paragraph = null;
    public static final AnnotationType Span = null;
    public static final AnnotationType String = null;
    public static final AnnotationType Url = null;
    public static final AnnotationType VerbatimTts = null;

    private static final /* synthetic */ AnnotationType[] $values() {
        return new AnnotationType[]{Paragraph, Span, VerbatimTts, Url, Link, Clickable, String};
    }

    public static EnumEntries<AnnotationType> getEntries() {
        return $ENTRIES;
    }

    static {
        Paragraph = new AnnotationType("Paragraph", 0);
        Span = new AnnotationType("Span", 1);
        VerbatimTts = new AnnotationType("VerbatimTts", 2);
        Url = new AnnotationType("Url", 3);
        Link = new AnnotationType(ComposerHelper.CONFIG_LINK, 4);
        Clickable = new AnnotationType("Clickable", 5);
        String = new AnnotationType("String", 6);
        AnnotationType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AnnotationType[] values() {
        return (AnnotationType[]) $VALUES.clone();
    }

    public static AnnotationType valueOf(String r100) {
        return (AnnotationType) r27.a.a(AnnotationType.class, r100);
    }

    private AnnotationType(String r100, int r101) {
        super(r100, r101);
    }
}
