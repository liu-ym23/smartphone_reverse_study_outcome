package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lstepai/aios/guiexecutor/api/QueryType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "USER_INFO", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ QueryType[] $VALUES;
    public static final QueryType USER_INFO = new QueryType("USER_INFO", 0);

    private static final /* synthetic */ QueryType[] $values() {
        return new QueryType[]{USER_INFO};
    }

    static {
        QueryType[] queryTypeArr$values = $values();
        $VALUES = queryTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(queryTypeArr$values);
    }

    private QueryType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static QueryType valueOf(String str) {
        return (QueryType) Enum.valueOf(QueryType.class, str);
    }

    public static QueryType[] values() {
        return (QueryType[]) $VALUES.clone();
    }
}
