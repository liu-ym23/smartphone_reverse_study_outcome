package com.stepos.ailauncher.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0010\u0010%\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b*\u0010)J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001fJ\u0010\u0010,\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b,\u0010)J\u0010\u0010-\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b-\u0010)J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001fJ\u009c\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u001fJ\u0010\u00102\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b2\u0010\u0017J\u001a\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b9\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00107\u001a\u0004\b:\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b;\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b<\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b=\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\b?\u0010&R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b@\u0010\u001fR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010A\u001a\u0004\bB\u0010)R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010A\u001a\u0004\bC\u0010)R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\bD\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010A\u001a\u0004\bE\u0010)R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\bF\u0010)R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\bG\u0010\u001f¨\u0006H"}, d2 = {"Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "Landroid/os/Parcelable;", "", "assetId", "reversionId", "version", "name", "description", "developer", "", "downloadCount", "installVersion", "", "needUpdate", "installed", "iconUrl", "testing", "expired", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZLjava/lang/String;ZZLjava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "()J", "component8", "component9", "()Z", "component10", "component11", "component12", "component13", "component14", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZLjava/lang/String;ZZLjava/lang/String;)Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", "getReversionId", "getVersion", "getName", "getDescription", "getDeveloper", "J", "getDownloadCount", "getInstallVersion", "Z", "getNeedUpdate", "getInstalled", "getIconUrl", "getTesting", "getExpired", "getEnv", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketAgentBrief implements Parcelable {
    public static final Parcelable.Creator<MarketAgentBrief> CREATOR = new Creator();
    private final String assetId;
    private final String description;
    private final String developer;
    private final long downloadCount;
    private final String env;
    private final boolean expired;
    private final String iconUrl;
    private final String installVersion;
    private final boolean installed;
    private final String name;
    private final boolean needUpdate;
    private final String reversionId;
    private final boolean testing;
    private final String version;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MarketAgentBrief> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketAgentBrief createFromParcel(Parcel parcel) {
            boolean z10;
            boolean z11;
            boolean z12;
            String str;
            boolean z13;
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            long j10 = parcel.readLong();
            String string7 = parcel.readString();
            boolean z14 = false;
            boolean z15 = true;
            if (parcel.readInt() != 0) {
                z10 = false;
                z14 = true;
            } else {
                z10 = false;
            }
            if (parcel.readInt() != 0) {
                z11 = true;
            } else {
                z11 = true;
                z15 = z10;
            }
            String string8 = parcel.readString();
            if (parcel.readInt() != 0) {
                z12 = z11;
                str = string8;
                z13 = z12;
            } else {
                z12 = z11;
                str = string8;
                z13 = z10;
            }
            if (parcel.readInt() == 0) {
                z12 = z10;
            }
            return new MarketAgentBrief(string, string2, string3, string4, string5, string6, j10, string7, z14, z15, str, z13, z12, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketAgentBrief[] newArray(int i10) {
            return new MarketAgentBrief[i10];
        }
    }

    public MarketAgentBrief(String assetId, String reversionId, String version, String name, String description, String developer, long j10, String installVersion, boolean z10, boolean z11, String iconUrl, boolean z12, boolean z13, String env) {
        p.i(assetId, "assetId");
        p.i(reversionId, "reversionId");
        p.i(version, "version");
        p.i(name, "name");
        p.i(description, "description");
        p.i(developer, "developer");
        p.i(installVersion, "installVersion");
        p.i(iconUrl, "iconUrl");
        p.i(env, "env");
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.version = version;
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.downloadCount = j10;
        this.installVersion = installVersion;
        this.needUpdate = z10;
        this.installed = z11;
        this.iconUrl = iconUrl;
        this.testing = z12;
        this.expired = z13;
        this.env = env;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getInstalled() {
        return this.installed;
    }

    /* renamed from: component11, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getTesting() {
        return this.testing;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getExpired() {
        return this.expired;
    }

    /* renamed from: component14, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReversionId() {
        return this.reversionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    /* renamed from: component7, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final MarketAgentBrief copy(String assetId, String reversionId, String version, String name, String description, String developer, long downloadCount, String installVersion, boolean needUpdate, boolean installed, String iconUrl, boolean testing, boolean expired, String env) {
        p.i(assetId, "assetId");
        p.i(reversionId, "reversionId");
        p.i(version, "version");
        p.i(name, "name");
        p.i(description, "description");
        p.i(developer, "developer");
        p.i(installVersion, "installVersion");
        p.i(iconUrl, "iconUrl");
        p.i(env, "env");
        return new MarketAgentBrief(assetId, reversionId, version, name, description, developer, downloadCount, installVersion, needUpdate, installed, iconUrl, testing, expired, env);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketAgentBrief)) {
            return false;
        }
        MarketAgentBrief marketAgentBrief = (MarketAgentBrief) other;
        return p.d(this.assetId, marketAgentBrief.assetId) && p.d(this.reversionId, marketAgentBrief.reversionId) && p.d(this.version, marketAgentBrief.version) && p.d(this.name, marketAgentBrief.name) && p.d(this.description, marketAgentBrief.description) && p.d(this.developer, marketAgentBrief.developer) && this.downloadCount == marketAgentBrief.downloadCount && p.d(this.installVersion, marketAgentBrief.installVersion) && this.needUpdate == marketAgentBrief.needUpdate && this.installed == marketAgentBrief.installed && p.d(this.iconUrl, marketAgentBrief.iconUrl) && this.testing == marketAgentBrief.testing && this.expired == marketAgentBrief.expired && p.d(this.env, marketAgentBrief.env);
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final String getEnv() {
        return this.env;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getInstallVersion() {
        return this.installVersion;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getReversionId() {
        return this.reversionId;
    }

    public final boolean getTesting() {
        return this.testing;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.assetId.hashCode() * 31) + this.reversionId.hashCode()) * 31) + this.version.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.developer.hashCode()) * 31) + Long.hashCode(this.downloadCount)) * 31) + this.installVersion.hashCode()) * 31) + Boolean.hashCode(this.needUpdate)) * 31) + Boolean.hashCode(this.installed)) * 31) + this.iconUrl.hashCode()) * 31) + Boolean.hashCode(this.testing)) * 31) + Boolean.hashCode(this.expired)) * 31) + this.env.hashCode();
    }

    public String toString() {
        return "MarketAgentBrief(assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", version=" + this.version + ", name=" + this.name + ", description=" + this.description + ", developer=" + this.developer + ", downloadCount=" + this.downloadCount + ", installVersion=" + this.installVersion + ", needUpdate=" + this.needUpdate + ", installed=" + this.installed + ", iconUrl=" + this.iconUrl + ", testing=" + this.testing + ", expired=" + this.expired + ", env=" + this.env + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.assetId);
        dest.writeString(this.reversionId);
        dest.writeString(this.version);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.developer);
        dest.writeLong(this.downloadCount);
        dest.writeString(this.installVersion);
        dest.writeInt(this.needUpdate ? 1 : 0);
        dest.writeInt(this.installed ? 1 : 0);
        dest.writeString(this.iconUrl);
        dest.writeInt(this.testing ? 1 : 0);
        dest.writeInt(this.expired ? 1 : 0);
        dest.writeString(this.env);
    }

    public /* synthetic */ MarketAgentBrief(String str, String str2, String str3, String str4, String str5, String str6, long j10, String str7, boolean z10, boolean z11, String str8, boolean z12, boolean z13, String str9, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, str4, str5, (i10 & 32) != 0 ? "" : str6, (i10 & 64) != 0 ? 0L : j10, (i10 & 128) != 0 ? "" : str7, (i10 & 256) != 0 ? false : z10, z11, (i10 & 1024) != 0 ? "" : str8, (i10 & 2048) != 0 ? false : z12, (i10 & 4096) != 0 ? false : z13, (i10 & b.THRESHOLD) != 0 ? "" : str9);
    }
}
