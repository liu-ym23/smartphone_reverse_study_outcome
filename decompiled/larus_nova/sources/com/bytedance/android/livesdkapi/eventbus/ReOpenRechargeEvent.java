package com.bytedance.android.livesdkapi.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/ReOpenRechargeEvent;", "", "extra", "(Ljava/lang/Object;)V", "getExtra", "()Ljava/lang/Object;", "setExtra", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ReOpenRechargeEvent {
    public static final Companion Companion = null;
    private static final ReOpenRechargeEvent INVALID_EVENT = null;
    private Object extra;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/ReOpenRechargeEvent$Companion;", "", "()V", "INVALID_EVENT", "Lcom/bytedance/android/livesdkapi/eventbus/ReOpenRechargeEvent;", "getINVALID_EVENT", "()Lcom/bytedance/android/livesdkapi/eventbus/ReOpenRechargeEvent;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final ReOpenRechargeEvent getINVALID_EVENT() {
            return ReOpenRechargeEvent.access$getINVALID_EVENT$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public ReOpenRechargeEvent() {
        DefaultConstructorMarker r100 = null;
        this(r100, 1, r100);
    }

    static {
        Companion = new Companion(null);
        INVALID_EVENT = new ReOpenRechargeEvent(null);
    }

    public static final /* synthetic */ ReOpenRechargeEvent access$getINVALID_EVENT$cp() {
        return INVALID_EVENT;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public ReOpenRechargeEvent(Object r100) {
        this.extra = r100;
    }

    public final void setExtra(Object r100) {
        this.extra = r100;
    }

    public /* synthetic */ ReOpenRechargeEvent(Object r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
