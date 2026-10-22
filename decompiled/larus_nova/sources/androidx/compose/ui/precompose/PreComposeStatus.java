package androidx.compose.ui.precompose;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/precompose/PreComposeStatus;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "PRECOMPOSED", "USED", "DISPOSED", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PreComposeStatus extends Enum<PreComposeStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PreComposeStatus[] $VALUES = null;
    public static final PreComposeStatus DISPOSED = null;
    public static final PreComposeStatus INIT = null;
    public static final PreComposeStatus PRECOMPOSED = null;
    public static final PreComposeStatus USED = null;

    private static final /* synthetic */ PreComposeStatus[] $values() {
        return new PreComposeStatus[]{INIT, PRECOMPOSED, USED, DISPOSED};
    }

    public static EnumEntries<PreComposeStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        INIT = new PreComposeStatus(ErrorCode.INIT, 0);
        PRECOMPOSED = new PreComposeStatus("PRECOMPOSED", 1);
        USED = new PreComposeStatus("USED", 2);
        DISPOSED = new PreComposeStatus("DISPOSED", 3);
        PreComposeStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static PreComposeStatus[] values() {
        return (PreComposeStatus[]) $VALUES.clone();
    }

    public static PreComposeStatus valueOf(String r100) {
        return (PreComposeStatus) r27.a.a(PreComposeStatus.class, r100);
    }

    private PreComposeStatus(String r100, int r101) {
        super(r100, r101);
    }
}
