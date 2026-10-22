package u4;

import a4.u;
import java.util.Locale;
import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ b[] $VALUES;
    public static final b CHANNEL_RECV = new b("CHANNEL_RECV", 0);
    public static final b DISPATCH = new b("DISPATCH", 1);
    public static final b GATEWAY_SEND = new b("GATEWAY_SEND", 2);
    public static final b GATEWAY_RECV = new b("GATEWAY_RECV", 3);
    public static final b CHANNEL_SEND = new b("CHANNEL_SEND", 4);
    public static final b NODE_INVOKE_SEND = new b("NODE_INVOKE_SEND", 5);
    public static final b NODE_INVOKE_RECV = new b("NODE_INVOKE_RECV", 6);

    private static final /* synthetic */ b[] $values() {
        return new b[]{CHANNEL_RECV, DISPATCH, GATEWAY_SEND, GATEWAY_RECV, CHANNEL_SEND, NODE_INVOKE_SEND, NODE_INVOKE_RECV};
    }

    static {
        b[] bVarArr$values = $values();
        $VALUES = bVarArr$values;
        $ENTRIES = e0.s(bVarArr$values);
    }

    private b(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    public final String getDir() {
        switch (a.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "IN";
            case 4:
            case 5:
            case 6:
                return "OUT";
            case 7:
                return "-";
            default:
                throw new u();
        }
    }

    public final String getLabel() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
