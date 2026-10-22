package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/Agreements;", "Ljava/io/Serializable;", n.KEY_MAIN_TEXT, "", "termsOfServiceUrl", "privacyPolicyUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMainText", "()Ljava/lang/String;", "getTermsOfServiceUrl", "getPrivacyPolicyUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Agreements implements Serializable {

    @SerializedName("main_text")
    private final String mainText;

    @SerializedName("privacy_policy_url")
    private final String privacyPolicyUrl;

    @SerializedName("terms_of_service_url")
    private final String termsOfServiceUrl;

    public Agreements() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Agreements copy$default(Agreements r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.mainText;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.termsOfServiceUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.privacyPolicyUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.mainText;
    }

    public final String component2() {
        return this.termsOfServiceUrl;
    }

    public final String component3() {
        return this.privacyPolicyUrl;
    }

    public final Agreements copy(String r100, String r101, String r102) {
        return new Agreements(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Agreements) == true) goto L8;
        return false;
    L8:
        Agreements r101 = (Agreements) r100;
        if (Intrinsics.areEqual(this.mainText, r101.mainText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.termsOfServiceUrl, r101.termsOfServiceUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privacyPolicyUrl, r101.privacyPolicyUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.mainText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.termsOfServiceUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.privacyPolicyUrl;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Agreements(mainText=" + this.mainText + ", termsOfServiceUrl=" + this.termsOfServiceUrl + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ')';
    }

    public final String getMainText() {
        return this.mainText;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    public Agreements(String r100, String r101, String r102) {
        this.mainText = r100;
        this.termsOfServiceUrl = r101;
        this.privacyPolicyUrl = r102;
    }

    public /* synthetic */ Agreements(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
