package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "", "", "name", "label", "helpUrl", "helpText", "", "secret", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Z", "e", "()Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.r, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppAutherField {

    @SerializedName("helpText")
    private final String helpText;

    @SerializedName("helpUrl")
    private final String helpUrl;

    @SerializedName("label")
    private final String label;

    @SerializedName("name")
    private final String name;

    @SerializedName("secret")
    private final boolean secret;

    public AppAutherField() {
        this(null, null, null, null, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getHelpText() {
        return this.helpText;
    }

    /* renamed from: b, reason: from getter */
    public final String getHelpUrl() {
        return this.helpUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getSecret() {
        return this.secret;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAutherField)) {
            return false;
        }
        AppAutherField appAutherField = (AppAutherField) other;
        return kotlin.jvm.internal.p.d(this.name, appAutherField.name) && kotlin.jvm.internal.p.d(this.label, appAutherField.label) && kotlin.jvm.internal.p.d(this.helpUrl, appAutherField.helpUrl) && kotlin.jvm.internal.p.d(this.helpText, appAutherField.helpText) && this.secret == appAutherField.secret;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.helpUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.helpText;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.secret);
    }

    public String toString() {
        return "AppAutherField(name=" + this.name + ", label=" + this.label + ", helpUrl=" + this.helpUrl + ", helpText=" + this.helpText + ", secret=" + this.secret + ")";
    }

    public AppAutherField(String str, String str2, String str3, String str4, boolean z10) {
        this.name = str;
        this.label = str2;
        this.helpUrl = str3;
        this.helpText = str4;
        this.secret = z10;
    }

    public /* synthetic */ AppAutherField(String str, String str2, String str3, String str4, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? true : z10);
    }
}
