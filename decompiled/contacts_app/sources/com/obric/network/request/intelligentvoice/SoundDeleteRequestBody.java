package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundDeleteRequestBody;", "", "speakerId", "", "deleteAll", "", "(Ljava/lang/String;Z)V", "getDeleteAll", "()Z", "getSpeakerId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundDeleteRequestBody {

    @SerializedName("delete_all")
    private final boolean deleteAll;

    @SerializedName("speaker_id")
    private final String speakerId;

    public static /* synthetic */ SoundDeleteRequestBody copy$default(SoundDeleteRequestBody r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.speakerId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deleteAll;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.speakerId;
    }

    public final boolean component2() {
        return this.deleteAll;
    }

    public final SoundDeleteRequestBody copy(String r1, boolean r2) {
        return new SoundDeleteRequestBody(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SoundDeleteRequestBody) == true) goto L8;
        return false;
    L8:
        SoundDeleteRequestBody r6 = (SoundDeleteRequestBody) r5;
        if (Intrinsics.areEqual(this.speakerId, r6.speakerId) == true) goto L12;
        return false;
    L12:
        if (this.deleteAll == r6.deleteAll) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        String r0 = this.speakerId;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.deleteAll;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SoundDeleteRequestBody(speakerId=" + this.speakerId + ", deleteAll=" + this.deleteAll + ')';
    }

    public SoundDeleteRequestBody(String r1, boolean r2) {
        this.speakerId = r1;
        this.deleteAll = r2;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final boolean getDeleteAll() {
        return this.deleteAll;
    }
}
