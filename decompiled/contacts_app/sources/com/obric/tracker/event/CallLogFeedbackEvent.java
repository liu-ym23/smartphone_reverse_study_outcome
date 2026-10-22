package com.obric.tracker.event;

import com.obric.tracker.intf.event.ITeaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallLogFeedbackEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/obric/tracker/event/CallLogFeedbackEvent;", "", "()V", "CallLogFeedbackEventBad", "CallLogFeedbackEventCancel", "CallLogFeedbackEventGood", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogFeedbackEvent {
    public static final CallLogFeedbackEvent INSTANCE = null;

    /* JADX INFO: compiled from: CallLogFeedbackEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/tracker/event/CallLogFeedbackEvent$CallLogFeedbackEventBad;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "badReason", "", "(Ljava/lang/String;)V", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CallLogFeedbackEventBad implements ITeaEvent {
        private final String badReason;

        @Override // com.obric.tracker.intf.event.ITeaEvent
        public String getEventName() {
            return EventNameConstantsKt.CALL_LOG_FEEDBACK_BAD_EVENT;
        }

        public CallLogFeedbackEventBad(String r2) {
            Intrinsics.checkNotNullParameter(r2, "badReason");
            this.badReason = r2;
        }

        @Override // com.obric.tracker.intf.event.ITeaEvent
        public JSONObject getEventParams() {
            JSONObject r0 = new JSONObject();
            r0.put("bad_type", this.badReason);
            return r0;
        }
    }

    /* JADX INFO: compiled from: CallLogFeedbackEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/tracker/event/CallLogFeedbackEvent$CallLogFeedbackEventCancel;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "()V", "getEventName", "", "getEventParams", "Lorg/json/JSONObject;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CallLogFeedbackEventCancel implements ITeaEvent {
        @Override // com.obric.tracker.intf.event.ITeaEvent
        public String getEventName() {
            return EventNameConstantsKt.CALL_LOG_FEEDBACK_CANCEL_EVENT;
        }

        public CallLogFeedbackEventCancel() {
        }

        @Override // com.obric.tracker.intf.event.ITeaEvent
        public JSONObject getEventParams() {
            return new JSONObject();
        }
    }

    /* JADX INFO: compiled from: CallLogFeedbackEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/tracker/event/CallLogFeedbackEvent$CallLogFeedbackEventGood;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "()V", "getEventName", "", "getEventParams", "Lorg/json/JSONObject;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CallLogFeedbackEventGood implements ITeaEvent {
        @Override // com.obric.tracker.intf.event.ITeaEvent
        public String getEventName() {
            return EventNameConstantsKt.CALL_LOG_FEEDBACK_GOOD_EVENT;
        }

        public CallLogFeedbackEventGood() {
        }

        @Override // com.obric.tracker.intf.event.ITeaEvent
        public JSONObject getEventParams() {
            return new JSONObject();
        }
    }

    static {
        INSTANCE = new CallLogFeedbackEvent();
    }

    private CallLogFeedbackEvent() {
    }
}
