package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundCopyTextResponseBody;", "", "promptText", "", "(Ljava/lang/String;)V", "getPromptText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundCopyTextResponseBody {

    @SerializedName("text")
    private final String promptText;

    public static /* synthetic */ SoundCopyTextResponseBody copy$default(SoundCopyTextResponseBody r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.promptText;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.promptText;
    }

    public final SoundCopyTextResponseBody copy(String r1) {
        return new SoundCopyTextResponseBody(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SoundCopyTextResponseBody) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.promptText, ((SoundCopyTextResponseBody) r4).promptText) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.promptText;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SoundCopyTextResponseBody(promptText=" + this.promptText + ')';
    }

    public SoundCopyTextResponseBody(String r1) {
        this.promptText = r1;
    }

    public final String getPromptText() {
        return this.promptText;
    }
}
