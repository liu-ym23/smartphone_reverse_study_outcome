package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\b\u0080\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b#\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b%\u0010\"R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b&\u0010\"R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b'\u0010\u0018R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b(\u0010\u0018R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u0010\u001aR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\b1\u0010\u001aR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b2\u0010.¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "", "", "pkg", "", "gatesAuthOnInstall", "integrationId", "pollsOrderStatus", "checksAuthStatus", "checksCredentialStatus", "credentialVendorId", "credentialIntegrationId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiPollSource;", "pollSource", "", "", "", "pollIntervalsMs", "fallbackIconRes", "highlightColorRes", "productCategoryNames", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiPollSource;Ljava/util/Map;IILjava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Z", "f", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "l", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiPollSource;", "k", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiPollSource;", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Map;", "I", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "m", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.p0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaxiVendorSpec {
    private final boolean checksAuthStatus;
    private final boolean checksCredentialStatus;
    private final String credentialIntegrationId;
    private final String credentialVendorId;
    private final int fallbackIconRes;
    private final boolean gatesAuthOnInstall;
    private final int highlightColorRes;
    private final String integrationId;
    private final String pkg;
    private final Map<Integer, Long> pollIntervalsMs;
    private final TaxiPollSource pollSource;
    private final boolean pollsOrderStatus;
    private final Map<String, String> productCategoryNames;

    public TaxiVendorSpec(String pkg, boolean z10, String str, boolean z11, boolean z12, boolean z13, String str2, String str3, TaxiPollSource pollSource, Map<Integer, Long> pollIntervalsMs, int i10, int i11, Map<String, String> productCategoryNames) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        kotlin.jvm.internal.p.i(pollSource, "pollSource");
        kotlin.jvm.internal.p.i(pollIntervalsMs, "pollIntervalsMs");
        kotlin.jvm.internal.p.i(productCategoryNames, "productCategoryNames");
        this.pkg = pkg;
        this.gatesAuthOnInstall = z10;
        this.integrationId = str;
        this.pollsOrderStatus = z11;
        this.checksAuthStatus = z12;
        this.checksCredentialStatus = z13;
        this.credentialVendorId = str2;
        this.credentialIntegrationId = str3;
        this.pollSource = pollSource;
        this.pollIntervalsMs = pollIntervalsMs;
        this.fallbackIconRes = i10;
        this.highlightColorRes = i11;
        this.productCategoryNames = productCategoryNames;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getChecksAuthStatus() {
        return this.checksAuthStatus;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getChecksCredentialStatus() {
        return this.checksCredentialStatus;
    }

    /* renamed from: c, reason: from getter */
    public final String getCredentialIntegrationId() {
        return this.credentialIntegrationId;
    }

    /* renamed from: d, reason: from getter */
    public final String getCredentialVendorId() {
        return this.credentialVendorId;
    }

    /* renamed from: e, reason: from getter */
    public final int getFallbackIconRes() {
        return this.fallbackIconRes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaxiVendorSpec)) {
            return false;
        }
        TaxiVendorSpec taxiVendorSpec = (TaxiVendorSpec) other;
        return kotlin.jvm.internal.p.d(this.pkg, taxiVendorSpec.pkg) && this.gatesAuthOnInstall == taxiVendorSpec.gatesAuthOnInstall && kotlin.jvm.internal.p.d(this.integrationId, taxiVendorSpec.integrationId) && this.pollsOrderStatus == taxiVendorSpec.pollsOrderStatus && this.checksAuthStatus == taxiVendorSpec.checksAuthStatus && this.checksCredentialStatus == taxiVendorSpec.checksCredentialStatus && kotlin.jvm.internal.p.d(this.credentialVendorId, taxiVendorSpec.credentialVendorId) && kotlin.jvm.internal.p.d(this.credentialIntegrationId, taxiVendorSpec.credentialIntegrationId) && this.pollSource == taxiVendorSpec.pollSource && kotlin.jvm.internal.p.d(this.pollIntervalsMs, taxiVendorSpec.pollIntervalsMs) && this.fallbackIconRes == taxiVendorSpec.fallbackIconRes && this.highlightColorRes == taxiVendorSpec.highlightColorRes && kotlin.jvm.internal.p.d(this.productCategoryNames, taxiVendorSpec.productCategoryNames);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getGatesAuthOnInstall() {
        return this.gatesAuthOnInstall;
    }

    /* renamed from: g, reason: from getter */
    public final int getHighlightColorRes() {
        return this.highlightColorRes;
    }

    /* renamed from: h, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    public int hashCode() {
        int iHashCode = ((this.pkg.hashCode() * 31) + Boolean.hashCode(this.gatesAuthOnInstall)) * 31;
        String str = this.integrationId;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.pollsOrderStatus)) * 31) + Boolean.hashCode(this.checksAuthStatus)) * 31) + Boolean.hashCode(this.checksCredentialStatus)) * 31;
        String str2 = this.credentialVendorId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.credentialIntegrationId;
        return ((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.pollSource.hashCode()) * 31) + this.pollIntervalsMs.hashCode()) * 31) + Integer.hashCode(this.fallbackIconRes)) * 31) + Integer.hashCode(this.highlightColorRes)) * 31) + this.productCategoryNames.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    public final Map<Integer, Long> j() {
        return this.pollIntervalsMs;
    }

    /* renamed from: k, reason: from getter */
    public final TaxiPollSource getPollSource() {
        return this.pollSource;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getPollsOrderStatus() {
        return this.pollsOrderStatus;
    }

    public final Map<String, String> m() {
        return this.productCategoryNames;
    }

    public String toString() {
        return "TaxiVendorSpec(pkg=" + this.pkg + ", gatesAuthOnInstall=" + this.gatesAuthOnInstall + ", integrationId=" + this.integrationId + ", pollsOrderStatus=" + this.pollsOrderStatus + ", checksAuthStatus=" + this.checksAuthStatus + ", checksCredentialStatus=" + this.checksCredentialStatus + ", credentialVendorId=" + this.credentialVendorId + ", credentialIntegrationId=" + this.credentialIntegrationId + ", pollSource=" + this.pollSource + ", pollIntervalsMs=" + this.pollIntervalsMs + ", fallbackIconRes=" + this.fallbackIconRes + ", highlightColorRes=" + this.highlightColorRes + ", productCategoryNames=" + this.productCategoryNames + ")";
    }

    public /* synthetic */ TaxiVendorSpec(String str, boolean z10, String str2, boolean z11, boolean z12, boolean z13, String str3, String str4, TaxiPollSource taxiPollSource, Map map, int i10, int i11, Map map2, int i12, kotlin.jvm.internal.i iVar) {
        this(str, (i12 & 2) != 0 ? true : z10, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? false : z12, (i12 & 32) != 0 ? false : z13, (i12 & 64) != 0 ? null : str3, (i12 & 128) != 0 ? null : str4, (i12 & 256) != 0 ? TaxiPollSource.MCP_GATEWAY : taxiPollSource, (i12 & 512) != 0 ? kotlin.collections.a.i() : map, i10, i11, map2);
    }
}
