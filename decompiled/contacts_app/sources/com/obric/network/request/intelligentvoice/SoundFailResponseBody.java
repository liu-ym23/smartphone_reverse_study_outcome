package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundFailResponseBody;", "", "fileUrl", "", "(Ljava/lang/String;)V", "getFileUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundFailResponseBody {

    @SerializedName("file_url")
    private final String fileUrl;

    public static /* synthetic */ SoundFailResponseBody copy$default(SoundFailResponseBody r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.fileUrl;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.fileUrl;
    }

    public final SoundFailResponseBody copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fileUrl");
        return new SoundFailResponseBody(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SoundFailResponseBody) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fileUrl, ((SoundFailResponseBody) r4).fileUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fileUrl.hashCode();
    }

    public String toString() {
        return "SoundFailResponseBody(fileUrl=" + this.fileUrl + ')';
    }

    public SoundFailResponseBody(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileUrl");
        this.fileUrl = r2;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }
}
