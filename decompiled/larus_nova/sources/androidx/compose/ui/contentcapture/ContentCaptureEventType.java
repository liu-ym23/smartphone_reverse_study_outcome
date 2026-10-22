package androidx.compose.ui.contentcapture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_APPEAR", "VIEW_DISAPPEAR", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum ContentCaptureEventType extends Enum<ContentCaptureEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContentCaptureEventType[] $VALUES = null;
    public static final ContentCaptureEventType VIEW_APPEAR = null;
    public static final ContentCaptureEventType VIEW_DISAPPEAR = null;

    private static final /* synthetic */ ContentCaptureEventType[] $values() {
        return new ContentCaptureEventType[]{VIEW_APPEAR, VIEW_DISAPPEAR};
    }

    public static EnumEntries<ContentCaptureEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        VIEW_APPEAR = new ContentCaptureEventType("VIEW_APPEAR", 0);
        VIEW_DISAPPEAR = new ContentCaptureEventType("VIEW_DISAPPEAR", 1);
        ContentCaptureEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ContentCaptureEventType[] values() {
        return (ContentCaptureEventType[]) $VALUES.clone();
    }

    public static ContentCaptureEventType valueOf(String r100) {
        return (ContentCaptureEventType) r27.a.a(ContentCaptureEventType.class, r100);
    }

    private ContentCaptureEventType(String r100, int r101) {
        super(r100, r101);
    }
}
