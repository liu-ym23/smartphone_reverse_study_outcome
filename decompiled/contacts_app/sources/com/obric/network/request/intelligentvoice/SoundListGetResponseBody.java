package com.obric.network.request.intelligentvoice;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentVoiceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/network/request/intelligentvoice/SoundListGetResponseBody;", "", "systemSound", "", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "customSound", "(Ljava/util/List;Ljava/util/List;)V", "getCustomSound", "()Ljava/util/List;", "getSystemSound", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SoundListGetResponseBody {

    @SerializedName("custom_sound")
    private final List<SoundListGetResponseDetail> customSound;

    @SerializedName("system_sound")
    private final List<SoundListGetResponseDetail> systemSound;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SoundListGetResponseBody copy$default(SoundListGetResponseBody r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.systemSound;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.customSound;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<SoundListGetResponseDetail> component1() {
        return this.systemSound;
    }

    public final List<SoundListGetResponseDetail> component2() {
        return this.customSound;
    }

    public final SoundListGetResponseBody copy(List<SoundListGetResponseDetail> r1, List<SoundListGetResponseDetail> r2) {
        Intrinsics.checkNotNullParameter(r1, "systemSound");
        Intrinsics.checkNotNullParameter(r2, "customSound");
        return new SoundListGetResponseBody(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SoundListGetResponseBody) == true) goto L8;
        return false;
    L8:
        SoundListGetResponseBody r6 = (SoundListGetResponseBody) r5;
        if (Intrinsics.areEqual(this.systemSound, r6.systemSound) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customSound, r6.customSound) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.systemSound.hashCode() * 31) + this.customSound.hashCode();
    }

    public String toString() {
        return "SoundListGetResponseBody(systemSound=" + this.systemSound + ", customSound=" + this.customSound + ')';
    }

    public SoundListGetResponseBody(List<SoundListGetResponseDetail> r2, List<SoundListGetResponseDetail> r3) {
        Intrinsics.checkNotNullParameter(r2, "systemSound");
        Intrinsics.checkNotNullParameter(r3, "customSound");
        this.systemSound = r2;
        this.customSound = r3;
    }

    public final List<SoundListGetResponseDetail> getSystemSound() {
        return this.systemSound;
    }

    public final List<SoundListGetResponseDetail> getCustomSound() {
        return this.customSound;
    }
}
