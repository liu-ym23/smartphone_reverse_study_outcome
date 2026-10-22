package com.stepos.stepclaw.bridge.spi;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001b¨\u0006,"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/DeviceNotificationEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "packageName", "title", "text", "subText", "category", "channelId", "postTimeMs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isOngoing", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isClearable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZ)V", "getKey", "()Ljava/lang/String;", "getPackageName", "getTitle", "getText", "getSubText", "getCategory", "getChannelId", "getPostTimeMs", "()J", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeviceNotificationEntry {
    private final String category;
    private final String channelId;
    private final boolean isClearable;
    private final boolean isOngoing;
    private final String key;
    private final String packageName;
    private final long postTimeMs;
    private final String subText;
    private final String text;
    private final String title;

    public DeviceNotificationEntry(String key, String packageName, String str, String str2, String str3, String str4, String str5, long j4, boolean z, boolean z2) {
        p.e(key, "key");
        p.e(packageName, "packageName");
        this.key = key;
        this.packageName = packageName;
        this.title = str;
        this.text = str2;
        this.subText = str3;
        this.category = str4;
        this.channelId = str5;
        this.postTimeMs = j4;
        this.isOngoing = z;
        this.isClearable = z2;
    }

    public static /* synthetic */ DeviceNotificationEntry copy$default(DeviceNotificationEntry deviceNotificationEntry, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j4, boolean z, boolean z2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = deviceNotificationEntry.key;
        }
        if ((i8 & 2) != 0) {
            str2 = deviceNotificationEntry.packageName;
        }
        if ((i8 & 4) != 0) {
            str3 = deviceNotificationEntry.title;
        }
        if ((i8 & 8) != 0) {
            str4 = deviceNotificationEntry.text;
        }
        if ((i8 & 16) != 0) {
            str5 = deviceNotificationEntry.subText;
        }
        if ((i8 & 32) != 0) {
            str6 = deviceNotificationEntry.category;
        }
        if ((i8 & 64) != 0) {
            str7 = deviceNotificationEntry.channelId;
        }
        if ((i8 & 128) != 0) {
            j4 = deviceNotificationEntry.postTimeMs;
        }
        if ((i8 & 256) != 0) {
            z = deviceNotificationEntry.isOngoing;
        }
        if ((i8 & 512) != 0) {
            z2 = deviceNotificationEntry.isClearable;
        }
        long j8 = j4;
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        String str12 = str3;
        return deviceNotificationEntry.copy(str, str2, str12, str10, str11, str8, str9, j8, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsClearable() {
        return this.isClearable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubText() {
        return this.subText;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component7, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component8, reason: from getter */
    public final long getPostTimeMs() {
        return this.postTimeMs;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsOngoing() {
        return this.isOngoing;
    }

    public final DeviceNotificationEntry copy(String key, String packageName, String title, String text, String subText, String category, String channelId, long postTimeMs, boolean isOngoing, boolean isClearable) {
        p.e(key, "key");
        p.e(packageName, "packageName");
        return new DeviceNotificationEntry(key, packageName, title, text, subText, category, channelId, postTimeMs, isOngoing, isClearable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceNotificationEntry)) {
            return false;
        }
        DeviceNotificationEntry deviceNotificationEntry = (DeviceNotificationEntry) other;
        return p.a(this.key, deviceNotificationEntry.key) && p.a(this.packageName, deviceNotificationEntry.packageName) && p.a(this.title, deviceNotificationEntry.title) && p.a(this.text, deviceNotificationEntry.text) && p.a(this.subText, deviceNotificationEntry.subText) && p.a(this.category, deviceNotificationEntry.category) && p.a(this.channelId, deviceNotificationEntry.channelId) && this.postTimeMs == deviceNotificationEntry.postTimeMs && this.isOngoing == deviceNotificationEntry.isOngoing && this.isClearable == deviceNotificationEntry.isClearable;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getPostTimeMs() {
        return this.postTimeMs;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iF = b.f(this.key.hashCode() * 31, 31, this.packageName);
        String str = this.title;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.category;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.channelId;
        return Boolean.hashCode(this.isClearable) + b.g(b.e((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31, 31, this.postTimeMs), 31, this.isOngoing);
    }

    public final boolean isClearable() {
        return this.isClearable;
    }

    public final boolean isOngoing() {
        return this.isOngoing;
    }

    public String toString() {
        String str = this.key;
        String str2 = this.packageName;
        String str3 = this.title;
        String str4 = this.text;
        String str5 = this.subText;
        String str6 = this.category;
        String str7 = this.channelId;
        long j4 = this.postTimeMs;
        boolean z = this.isOngoing;
        boolean z2 = this.isClearable;
        StringBuilder sbV = b.v("DeviceNotificationEntry(key=", str, ", packageName=", str2, ", title=");
        b.A(sbV, str3, ", text=", str4, ", subText=");
        b.A(sbV, str5, ", category=", str6, ", channelId=");
        sbV.append(str7);
        sbV.append(", postTimeMs=");
        sbV.append(j4);
        sbV.append(", isOngoing=");
        sbV.append(z);
        sbV.append(", isClearable=");
        sbV.append(z2);
        sbV.append(")");
        return sbV.toString();
    }
}
