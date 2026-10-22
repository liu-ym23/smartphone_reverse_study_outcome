package kotlin.io.path;

import com.bytedance.applog.log.LogUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import stepos.com.android.os.StatsLogEnums;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: OnErrorResult.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/path/OnErrorResult;", "", "(Ljava/lang/String;I)V", "SKIP_SUBTREE", LogUtils.EVENT_TYPE_TERMINATE, "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG_VALUE)
/* loaded from: classes.dex */
public final class OnErrorResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnErrorResult[] $VALUES;
    public static final OnErrorResult SKIP_SUBTREE = new OnErrorResult("SKIP_SUBTREE", 0);
    public static final OnErrorResult TERMINATE = new OnErrorResult(LogUtils.EVENT_TYPE_TERMINATE, 1);

    private static final /* synthetic */ OnErrorResult[] $values() {
        return new OnErrorResult[]{SKIP_SUBTREE, TERMINATE};
    }

    public static EnumEntries<OnErrorResult> getEntries() {
        return $ENTRIES;
    }

    public static OnErrorResult valueOf(String str) {
        return (OnErrorResult) Enum.valueOf(OnErrorResult.class, str);
    }

    public static OnErrorResult[] values() {
        return (OnErrorResult[]) $VALUES.clone();
    }

    private OnErrorResult(String str, int i) {
    }

    static {
        OnErrorResult[] onErrorResultArr$values = $values();
        $VALUES = onErrorResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(onErrorResultArr$values);
    }
}
