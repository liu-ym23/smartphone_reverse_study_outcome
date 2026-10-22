package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyData;", "Ljava/io/Serializable;", "privacyAgreed", "", "privacyCard", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "<init>", "(ZLcom/bytedance/ai/bridge/remote/model/PrivacyCard;)V", "getPrivacyAgreed", "()Z", "getPrivacyCard", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyData implements Serializable {

    @SerializedName("PrivacyAgreed")
    private final boolean privacyAgreed;

    @SerializedName("privacyCard")
    private final PrivacyCard privacyCard;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyData() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PrivacyData copy$default(PrivacyData r100, boolean r101, PrivacyCard r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.privacyAgreed;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.privacyCard;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.privacyAgreed;
    }

    public final PrivacyCard component2() {
        return this.privacyCard;
    }

    public final PrivacyData copy(boolean r100, PrivacyCard r101) {
        return new PrivacyData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrivacyData) == true) goto L8;
        return false;
    L8:
        PrivacyData r101 = (PrivacyData) r100;
        if (this.privacyAgreed == r101.privacyAgreed) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.privacyCard, r101.privacyCard) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.privacyAgreed == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        PrivacyCard r102 = this.privacyCard;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "PrivacyData(privacyAgreed=" + this.privacyAgreed + ", privacyCard=" + this.privacyCard + ')';
    }

    public final boolean getPrivacyAgreed() {
        return this.privacyAgreed;
    }

    public final PrivacyCard getPrivacyCard() {
        return this.privacyCard;
    }

    public PrivacyData(boolean r100, PrivacyCard r101) {
        this.privacyAgreed = r100;
        this.privacyCard = r101;
    }

    public /* synthetic */ PrivacyData(boolean r100, PrivacyCard r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
