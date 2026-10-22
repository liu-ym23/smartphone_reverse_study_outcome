package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH ¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract enum SelectionMode extends Enum<SelectionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SelectionMode[] $VALUES = null;
    public static final SelectionMode Horizontal = null;
    public static final SelectionMode Vertical = null;

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Vertical, Horizontal};
    }

    public /* synthetic */ SelectionMode(String r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static EnumEntries<SelectionMode> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo1490compare3MmeM6k$foundation_release(long r100, Rect r101);

    static {
        final String r100 = "Vertical";
        final int r101 = 0;
        Vertical = new Vertical(r100, r101);
        final String r102 = "Horizontal";
        final int r103 = 1;
        Horizontal = new Horizontal(r102, r103);
        SelectionMode[] r104 = $values();
        $VALUES = r104;
        $ENTRIES = EnumEntriesKt.enumEntries(r104);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }

    public static SelectionMode valueOf(String r100) {
        return (SelectionMode) r27.a.a(SelectionMode.class, r100);
    }

    private SelectionMode(String r100, int r101) {
        super(r100, r101);
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    private final boolean m1489containsInclusiveUv8p0NA(Rect r100, long r101) {
        float r102 = r100.getLeft();
        float r103 = r100.getRight();
        float r104 = Float.intBitsToFloat((int) (r101 >> 32));
        if (r102 <= r104) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L17;
        float r106 = r100.getTop();
        float r107 = r100.getBottom();
        float r108 = Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        if (r106 <= r108) goto L12;
    L14:
        boolean r109 = false;
    L15:
        if (r109 == false) goto L17;
        return true;
    L12:
        if (r108 > r107) goto L14;
        r109 = true;
    L17:
        return false;
    L5:
        if (r104 > r103) goto L7;
        r105 = true;
        goto L8
    }

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m1491isSelected2x9bVx0$foundation_release(Rect r100, long r101, long r102) {
        boolean r103 = true;
        if (m1489containsInclusiveUv8p0NA(r100, r101) == false) goto L5;
    L16:
        return true;
    L5:
        if (m1489containsInclusiveUv8p0NA(r100, r102) == true) goto L16;
        int r104 = mo1490compare3MmeM6k$foundation_release(r101, r100);
        int r105 = mo1490compare3MmeM6k$foundation_release(r102, r100);
        if (r104 <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r105 > 0) goto L15;
        r103 = false;
    L15:
        return r106 ^ r103;
    L10:
        r106 = false;
        goto L11
    }
}
