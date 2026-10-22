package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayQuickBindJumpCardBinEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "eventCode", "", "(I)V", "getEventCode", "()I", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayQuickBindJumpCardBinEvent extends BaseEvent {
    private static final int BIND_CARD_PAGE = 0;
    public static final Companion Companion = null;
    private static final int MY_BANK_CARD_PAGE = 0;
    private final int eventCode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayQuickBindJumpCardBinEvent$Companion;", "", "()V", "BIND_CARD_PAGE", "", "getBIND_CARD_PAGE", "()I", "MY_BANK_CARD_PAGE", "getMY_BANK_CARD_PAGE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int getBIND_CARD_PAGE() {
            return CJPayQuickBindJumpCardBinEvent.access$getBIND_CARD_PAGE$cp();
        }

        public final int getMY_BANK_CARD_PAGE() {
            return CJPayQuickBindJumpCardBinEvent.access$getMY_BANK_CARD_PAGE$cp();
        }
    }

    static {
        Companion = new Companion(null);
        MY_BANK_CARD_PAGE = 1000;
        BIND_CARD_PAGE = 1001;
    }

    public static final /* synthetic */ int access$getBIND_CARD_PAGE$cp() {
        return BIND_CARD_PAGE;
    }

    public static final /* synthetic */ int access$getMY_BANK_CARD_PAGE$cp() {
        return MY_BANK_CARD_PAGE;
    }

    public final int getEventCode() {
        return this.eventCode;
    }

    public CJPayQuickBindJumpCardBinEvent(int r100) {
        this.eventCode = r100;
    }
}
