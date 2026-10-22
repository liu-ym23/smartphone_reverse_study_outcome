package com.stepos.backend.qnn;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TTSInput {
    private final String speakerId;
    private final String systemPrompt;
    private final String text;

    public TTSInput(String text, String str, String str2) {
        kotlin.jvm.internal.g.f(text, "text");
        this.text = text;
        this.speakerId = str;
        this.systemPrompt = str2;
    }

    public static /* synthetic */ TTSInput copy$default(TTSInput tTSInput, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tTSInput.text;
        }
        if ((i10 & 2) != 0) {
            str2 = tTSInput.speakerId;
        }
        if ((i10 & 4) != 0) {
            str3 = tTSInput.systemPrompt;
        }
        return tTSInput.copy(str, str2, str3);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.speakerId;
    }

    public final String component3() {
        return this.systemPrompt;
    }

    public final TTSInput copy(String text, String str, String str2) {
        kotlin.jvm.internal.g.f(text, "text");
        return new TTSInput(text, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TTSInput)) {
            return false;
        }
        TTSInput tTSInput = (TTSInput) obj;
        return kotlin.jvm.internal.g.b(this.text, tTSInput.text) && kotlin.jvm.internal.g.b(this.speakerId, tTSInput.speakerId) && kotlin.jvm.internal.g.b(this.systemPrompt, tTSInput.systemPrompt);
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        String str = this.speakerId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.systemPrompt;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        String str2 = this.speakerId;
        return ai.onnxruntime.a.o(ai.onnxruntime.a.s("TTSInput(text=", str, ", speakerId=", str2, ", systemPrompt="), this.systemPrompt, ")");
    }

    public /* synthetic */ TTSInput(String str, String str2, String str3, int i10, kotlin.jvm.internal.e eVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
