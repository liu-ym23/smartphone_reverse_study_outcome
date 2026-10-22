package com.stepos.core.ability.speech;

import com.tonyodev.fetch2core.server.FileResponse;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AsrSseEvent {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_DELTA = "transcript.text.delta";
    public static final String TYPE_DONE = "transcript.text.done";
    public static final String TYPE_ERROR = "error";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final AsrSseEvent fromEventData(JSONObject json) {
            Usage usage;
            kotlin.jvm.internal.g.f(json, "json");
            String strOptString = json.optString(FileResponse.FIELD_TYPE);
            if (strOptString != null) {
                int iHashCode = strOptString.hashCode();
                if (iHashCode != -1504384149) {
                    if (iHashCode != 96784904) {
                        if (iHashCode == 608432367 && strOptString.equals(AsrSseEvent.TYPE_DELTA)) {
                            String strOptString2 = json.optString("delta", "");
                            kotlin.jvm.internal.g.e(strOptString2, "optString(...)");
                            String strOptString3 = json.optString("item_id", "");
                            kotlin.jvm.internal.g.e(strOptString3, "optString(...)");
                            return new Delta(strOptString2, strOptString3, json.optInt("content_index", 0), json.optLong("start_time", 0L), json.optLong("end_time", 0L));
                        }
                    } else if (strOptString.equals(AsrSseEvent.TYPE_ERROR)) {
                        String strOptString4 = json.optString("message", "Unknown SSE error");
                        kotlin.jvm.internal.g.e(strOptString4, "optString(...)");
                        return new Error(strOptString4);
                    }
                } else if (strOptString.equals(AsrSseEvent.TYPE_DONE)) {
                    String strOptString5 = json.optString("text", "");
                    kotlin.jvm.internal.g.e(strOptString5, "optString(...)");
                    JSONObject jSONObjectOptJSONObject = json.optJSONObject("usage");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString6 = jSONObjectOptJSONObject.optString(FileResponse.FIELD_TYPE, "");
                        kotlin.jvm.internal.g.e(strOptString6, "optString(...)");
                        usage = new Usage(strOptString6, jSONObjectOptJSONObject.optInt("input_tokens", 0), jSONObjectOptJSONObject.optInt("output_tokens", 0), jSONObjectOptJSONObject.optInt("total_tokens", 0));
                    } else {
                        usage = null;
                    }
                    return new Done(strOptString5, usage);
                }
            }
            return new Error(ai.onnxruntime.a.k("Unknown SSE event type: ", json.optString(FileResponse.FIELD_TYPE)));
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Done extends AsrSseEvent {
        private final String text;
        private final Usage usage;

        public /* synthetic */ Done(String str, Usage usage, int i10, kotlin.jvm.internal.e eVar) {
            this(str, (i10 & 2) != 0 ? null : usage);
        }

        public static /* synthetic */ Done copy$default(Done done, String str, Usage usage, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = done.text;
            }
            if ((i10 & 2) != 0) {
                usage = done.usage;
            }
            return done.copy(str, usage);
        }

        public final String component1() {
            return this.text;
        }

        public final Usage component2() {
            return this.usage;
        }

        public final Done copy(String text, Usage usage) {
            kotlin.jvm.internal.g.f(text, "text");
            return new Done(text, usage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Done)) {
                return false;
            }
            Done done = (Done) obj;
            return kotlin.jvm.internal.g.b(this.text, done.text) && kotlin.jvm.internal.g.b(this.usage, done.usage);
        }

        public final String getText() {
            return this.text;
        }

        public final Usage getUsage() {
            return this.usage;
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            Usage usage = this.usage;
            return iHashCode + (usage == null ? 0 : usage.hashCode());
        }

        public String toString() {
            return "Done(text=" + this.text + ", usage=" + this.usage + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Done(String text, Usage usage) {
            super(null);
            kotlin.jvm.internal.g.f(text, "text");
            this.text = text;
            this.usage = usage;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Error extends AsrSseEvent {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message) {
            super(null);
            kotlin.jvm.internal.g.f(message, "message");
            this.message = message;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Error copy(String message) {
            kotlin.jvm.internal.g.f(message, "message");
            return new Error(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && kotlin.jvm.internal.g.b(this.message, ((Error) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return a0.a.k("Error(message=", this.message, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Usage {
        private final int inputTokens;
        private final int outputTokens;
        private final int totalTokens;
        private final String type;

        public Usage() {
            this(null, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ Usage copy$default(Usage usage, String str, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = usage.type;
            }
            if ((i13 & 2) != 0) {
                i10 = usage.inputTokens;
            }
            if ((i13 & 4) != 0) {
                i11 = usage.outputTokens;
            }
            if ((i13 & 8) != 0) {
                i12 = usage.totalTokens;
            }
            return usage.copy(str, i10, i11, i12);
        }

        public final String component1() {
            return this.type;
        }

        public final int component2() {
            return this.inputTokens;
        }

        public final int component3() {
            return this.outputTokens;
        }

        public final int component4() {
            return this.totalTokens;
        }

        public final Usage copy(String type, int i10, int i11, int i12) {
            kotlin.jvm.internal.g.f(type, "type");
            return new Usage(type, i10, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Usage)) {
                return false;
            }
            Usage usage = (Usage) obj;
            return kotlin.jvm.internal.g.b(this.type, usage.type) && this.inputTokens == usage.inputTokens && this.outputTokens == usage.outputTokens && this.totalTokens == usage.totalTokens;
        }

        public final int getInputTokens() {
            return this.inputTokens;
        }

        public final int getOutputTokens() {
            return this.outputTokens;
        }

        public final int getTotalTokens() {
            return this.totalTokens;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return Integer.hashCode(this.totalTokens) + ai.onnxruntime.a.d(this.outputTokens, ai.onnxruntime.a.d(this.inputTokens, this.type.hashCode() * 31, 31), 31);
        }

        public String toString() {
            String str = this.type;
            int i10 = this.inputTokens;
            int i11 = this.outputTokens;
            int i12 = this.totalTokens;
            StringBuilder sbF = h0.e.f("Usage(type=", str, ", inputTokens=", i10, ", outputTokens=");
            sbF.append(i11);
            sbF.append(", totalTokens=");
            sbF.append(i12);
            sbF.append(")");
            return sbF.toString();
        }

        public Usage(String type, int i10, int i11, int i12) {
            kotlin.jvm.internal.g.f(type, "type");
            this.type = type;
            this.inputTokens = i10;
            this.outputTokens = i11;
            this.totalTokens = i12;
        }

        public /* synthetic */ Usage(String str, int i10, int i11, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? 0 : i10, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
        }
    }

    public /* synthetic */ AsrSseEvent(kotlin.jvm.internal.e eVar) {
        this();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Delta extends AsrSseEvent {
        private final int contentIndex;
        private final long endTimeMs;
        private final String itemId;
        private final long startTimeMs;
        private final String text;

        public /* synthetic */ Delta(String str, String str2, int i10, long j10, long j11, int i11, kotlin.jvm.internal.e eVar) {
            this(str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? 0L : j11);
        }

        public static /* synthetic */ Delta copy$default(Delta delta, String str, String str2, int i10, long j10, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = delta.text;
            }
            if ((i11 & 2) != 0) {
                str2 = delta.itemId;
            }
            if ((i11 & 4) != 0) {
                i10 = delta.contentIndex;
            }
            if ((i11 & 8) != 0) {
                j10 = delta.startTimeMs;
            }
            if ((i11 & 16) != 0) {
                j11 = delta.endTimeMs;
            }
            long j12 = j11;
            int i12 = i10;
            return delta.copy(str, str2, i12, j10, j12);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.itemId;
        }

        public final int component3() {
            return this.contentIndex;
        }

        public final long component4() {
            return this.startTimeMs;
        }

        public final long component5() {
            return this.endTimeMs;
        }

        public final Delta copy(String text, String itemId, int i10, long j10, long j11) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(itemId, "itemId");
            return new Delta(text, itemId, i10, j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Delta)) {
                return false;
            }
            Delta delta = (Delta) obj;
            return kotlin.jvm.internal.g.b(this.text, delta.text) && kotlin.jvm.internal.g.b(this.itemId, delta.itemId) && this.contentIndex == delta.contentIndex && this.startTimeMs == delta.startTimeMs && this.endTimeMs == delta.endTimeMs;
        }

        public final int getContentIndex() {
            return this.contentIndex;
        }

        public final long getEndTimeMs() {
            return this.endTimeMs;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Long.hashCode(this.endTimeMs) + a0.a.c(ai.onnxruntime.a.d(this.contentIndex, v1.d.a(this.text.hashCode() * 31, 31, this.itemId), 31), this.startTimeMs, 31);
        }

        public String toString() {
            String str = this.text;
            String str2 = this.itemId;
            int i10 = this.contentIndex;
            long j10 = this.startTimeMs;
            long j11 = this.endTimeMs;
            StringBuilder sbS = ai.onnxruntime.a.s("Delta(text=", str, ", itemId=", str2, ", contentIndex=");
            com.stepos.core.ota.d.s(sbS, i10, ", startTimeMs=", j10);
            return a0.a.d(j11, ", endTimeMs=", ")", sbS);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Delta(String text, String itemId, int i10, long j10, long j11) {
            super(null);
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(itemId, "itemId");
            this.text = text;
            this.itemId = itemId;
            this.contentIndex = i10;
            this.startTimeMs = j10;
            this.endTimeMs = j11;
        }
    }

    private AsrSseEvent() {
    }
}
