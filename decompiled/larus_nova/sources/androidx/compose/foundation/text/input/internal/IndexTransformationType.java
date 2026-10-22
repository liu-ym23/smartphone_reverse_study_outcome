package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "", "<init>", "(Ljava/lang/String;I)V", "Untransformed", "Insertion", "Replacement", "Deletion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IndexTransformationType extends Enum<IndexTransformationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IndexTransformationType[] $VALUES = null;
    public static final IndexTransformationType Deletion = null;
    public static final IndexTransformationType Insertion = null;
    public static final IndexTransformationType Replacement = null;
    public static final IndexTransformationType Untransformed = null;

    private static final /* synthetic */ IndexTransformationType[] $values() {
        return new IndexTransformationType[]{Untransformed, Insertion, Replacement, Deletion};
    }

    public static EnumEntries<IndexTransformationType> getEntries() {
        return $ENTRIES;
    }

    static {
        Untransformed = new IndexTransformationType("Untransformed", 0);
        Insertion = new IndexTransformationType("Insertion", 1);
        Replacement = new IndexTransformationType("Replacement", 2);
        Deletion = new IndexTransformationType("Deletion", 3);
        IndexTransformationType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IndexTransformationType[] values() {
        return (IndexTransformationType[]) $VALUES.clone();
    }

    public static IndexTransformationType valueOf(String r100) {
        return (IndexTransformationType) r27.a.a(IndexTransformationType.class, r100);
    }

    private IndexTransformationType(String r100, int r101) {
        super(r100, r101);
    }
}
