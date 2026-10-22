package com.stepos.ailauncher.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0018J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0018Jj\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b$\u0010\u0010J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b,\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b-\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b.\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b/\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b0\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b1\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b2\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b3\u0010\u0018¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "Landroid/os/Parcelable;", "", "appId", "name", "description", "version", "appType", "packageName", "h5Url", "iconUrl", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppId", "getName", "getDescription", "getVersion", "getAppType", "getPackageName", "getH5Url", "getIconUrl", "getEnv", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketAppBrief implements Parcelable {
    public static final Parcelable.Creator<MarketAppBrief> CREATOR = new Creator();
    private final String appId;
    private final String appType;
    private final String description;
    private final String env;
    private final String h5Url;
    private final String iconUrl;
    private final String name;
    private final String packageName;
    private final String version;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MarketAppBrief> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketAppBrief createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new MarketAppBrief(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MarketAppBrief[] newArray(int i10) {
            return new MarketAppBrief[i10];
        }
    }

    public MarketAppBrief(String appId, String name, String description, String version, String appType, String packageName, String h5Url, String iconUrl, String env) {
        p.i(appId, "appId");
        p.i(name, "name");
        p.i(description, "description");
        p.i(version, "version");
        p.i(appType, "appType");
        p.i(packageName, "packageName");
        p.i(h5Url, "h5Url");
        p.i(iconUrl, "iconUrl");
        p.i(env, "env");
        this.appId = appId;
        this.name = name;
        this.description = description;
        this.version = version;
        this.appType = appType;
        this.packageName = packageName;
        this.h5Url = h5Url;
        this.iconUrl = iconUrl;
        this.env = env;
    }

    public static /* synthetic */ MarketAppBrief copy$default(MarketAppBrief marketAppBrief, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = marketAppBrief.appId;
        }
        if ((i10 & 2) != 0) {
            str2 = marketAppBrief.name;
        }
        if ((i10 & 4) != 0) {
            str3 = marketAppBrief.description;
        }
        if ((i10 & 8) != 0) {
            str4 = marketAppBrief.version;
        }
        if ((i10 & 16) != 0) {
            str5 = marketAppBrief.appType;
        }
        if ((i10 & 32) != 0) {
            str6 = marketAppBrief.packageName;
        }
        if ((i10 & 64) != 0) {
            str7 = marketAppBrief.h5Url;
        }
        if ((i10 & 128) != 0) {
            str8 = marketAppBrief.iconUrl;
        }
        if ((i10 & 256) != 0) {
            str9 = marketAppBrief.env;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return marketAppBrief.copy(str, str2, str15, str4, str14, str12, str13, str10, str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    /* renamed from: component8, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    public final MarketAppBrief copy(String appId, String name, String description, String version, String appType, String packageName, String h5Url, String iconUrl, String env) {
        p.i(appId, "appId");
        p.i(name, "name");
        p.i(description, "description");
        p.i(version, "version");
        p.i(appType, "appType");
        p.i(packageName, "packageName");
        p.i(h5Url, "h5Url");
        p.i(iconUrl, "iconUrl");
        p.i(env, "env");
        return new MarketAppBrief(appId, name, description, version, appType, packageName, h5Url, iconUrl, env);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketAppBrief)) {
            return false;
        }
        MarketAppBrief marketAppBrief = (MarketAppBrief) other;
        return p.d(this.appId, marketAppBrief.appId) && p.d(this.name, marketAppBrief.name) && p.d(this.description, marketAppBrief.description) && p.d(this.version, marketAppBrief.version) && p.d(this.appType, marketAppBrief.appType) && p.d(this.packageName, marketAppBrief.packageName) && p.d(this.h5Url, marketAppBrief.h5Url) && p.d(this.iconUrl, marketAppBrief.iconUrl) && p.d(this.env, marketAppBrief.env);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((this.appId.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.version.hashCode()) * 31) + this.appType.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.h5Url.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.env.hashCode();
    }

    public String toString() {
        return "MarketAppBrief(appId=" + this.appId + ", name=" + this.name + ", description=" + this.description + ", version=" + this.version + ", appType=" + this.appType + ", packageName=" + this.packageName + ", h5Url=" + this.h5Url + ", iconUrl=" + this.iconUrl + ", env=" + this.env + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.appId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.version);
        dest.writeString(this.appType);
        dest.writeString(this.packageName);
        dest.writeString(this.h5Url);
        dest.writeString(this.iconUrl);
        dest.writeString(this.env);
    }

    public /* synthetic */ MarketAppBrief(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? "" : str6, (i10 & 64) != 0 ? "" : str7, (i10 & 128) != 0 ? "" : str8, (i10 & 256) != 0 ? "" : str9);
    }
}
