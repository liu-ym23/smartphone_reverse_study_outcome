package com.android.ttcjpaysdk.base.ui.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/EventType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISPLAY_ON_UNFOCUSED", "DISPLAY_ON_UNFOCUSED_PAY_AND_X", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;
    public static final EventType DISPLAY_ON_UNFOCUSED = null;
    public static final EventType DISPLAY_ON_UNFOCUSED_PAY_AND_X = null;
    private final String value;

    private static final /* synthetic */ EventType[] $values() {
        return new EventType[]{DISPLAY_ON_UNFOCUSED, DISPLAY_ON_UNFOCUSED_PAY_AND_X};
    }

    public static EventType valueOf(String r100) {
        return (EventType) a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    static {
        DISPLAY_ON_UNFOCUSED = new EventType("DISPLAY_ON_UNFOCUSED", 0, "display_on_unfocused");
        DISPLAY_ON_UNFOCUSED_PAY_AND_X = new EventType("DISPLAY_ON_UNFOCUSED_PAY_AND_X", 1, "display_on_unfocused_pay_and_x");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private EventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
