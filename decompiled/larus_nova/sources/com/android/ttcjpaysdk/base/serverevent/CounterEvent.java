package com.android.ttcjpaysdk.base.serverevent;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CounterEvent;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLOSEDESK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CounterEvent extends Enum<CounterEvent> {
    private static final /* synthetic */ CounterEvent[] $VALUES = null;
    public static final CounterEvent CLOSEDESK = null;
    private final String value;

    private static final /* synthetic */ CounterEvent[] $values() {
        return new CounterEvent[]{CLOSEDESK};
    }

    public static CounterEvent valueOf(String r100) {
        return (CounterEvent) a.a(CounterEvent.class, r100);
    }

    public static CounterEvent[] values() {
        return (CounterEvent[]) $VALUES.clone();
    }

    static {
        CLOSEDESK = new CounterEvent("CLOSEDESK", 0, "close_cashdesk");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private CounterEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
