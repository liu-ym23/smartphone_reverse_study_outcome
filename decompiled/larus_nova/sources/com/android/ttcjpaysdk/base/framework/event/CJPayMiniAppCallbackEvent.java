package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u00012\u00020\u0002:\u0001\u0007B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayMiniAppCallbackEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "eventCode", "", "data", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMiniAppCallbackEvent extends BaseEvent implements CJPayObject {
    public static final Companion Companion = null;
    private static final String HAS_CARD = null;
    private static final String NONE_CARD = null;
    public String data;
    public String eventCode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayMiniAppCallbackEvent$Companion;", "", "()V", "HAS_CARD", "", "getHAS_CARD", "()Ljava/lang/String;", "NONE_CARD", "getNONE_CARD", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getHAS_CARD() {
            return CJPayMiniAppCallbackEvent.access$getHAS_CARD$cp();
        }

        public final String getNONE_CARD() {
            return CJPayMiniAppCallbackEvent.access$getNONE_CARD$cp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayMiniAppCallbackEvent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        HAS_CARD = "has_card";
        NONE_CARD = "none_card";
    }

    public static final /* synthetic */ String access$getHAS_CARD$cp() {
        return HAS_CARD;
    }

    public static final /* synthetic */ String access$getNONE_CARD$cp() {
        return NONE_CARD;
    }

    public CJPayMiniAppCallbackEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventCode");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.eventCode = r100;
        this.data = r101;
    }

    public /* synthetic */ CJPayMiniAppCallbackEvent(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
