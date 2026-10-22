package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/e;", "", "", "name", "label", "masked", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.e, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class CredentialField {

    @SerializedName("label")
    private final String label;

    @SerializedName("masked")
    private final String masked;

    @SerializedName("name")
    private final String name;

    public CredentialField() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: b, reason: from getter */
    public final String getMasked() {
        return this.masked;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CredentialField)) {
            return false;
        }
        CredentialField credentialField = (CredentialField) other;
        return kotlin.jvm.internal.p.d(this.name, credentialField.name) && kotlin.jvm.internal.p.d(this.label, credentialField.label) && kotlin.jvm.internal.p.d(this.masked, credentialField.masked);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.label.hashCode()) * 31;
        String str = this.masked;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CredentialField(name=" + this.name + ", label=" + this.label + ", masked=" + this.masked + ")";
    }

    public CredentialField(String name, String label, String str) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(label, "label");
        this.name = name;
        this.label = label;
        this.masked = str;
    }

    public /* synthetic */ CredentialField(String str, String str2, String str3, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : str3);
    }
}
