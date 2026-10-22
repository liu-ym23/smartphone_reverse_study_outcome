package com.stepos.ailauncher.storage.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/storage/entity/InstalledSkillEntity;", "", "slug", "", "displayName", c.a.COL_SUMMARY, "iconUrl", "downloadCount", "", "installKind", "installSource", d.EXTRA_ENABLED, "", "installedAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZJJ)V", "getSlug", "()Ljava/lang/String;", "getDisplayName", "getSummary", "getIconUrl", "getDownloadCount", "()J", "getInstallKind", "getInstallSource", "getEnabled", "()Z", "getInstalledAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "Companion", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InstalledSkillEntity {
    public static final String TABLE_NAME = "installed_skill";
    private final String displayName;
    private final long downloadCount;
    private final boolean enabled;
    private final String iconUrl;
    private final String installKind;
    private final String installSource;
    private final long installedAt;
    private final String slug;
    private final String summary;
    private final long updatedAt;

    public InstalledSkillEntity(String slug, String displayName, String summary, String str, long j10, String installKind, String installSource, boolean z10, long j11, long j12) {
        p.i(slug, "slug");
        p.i(displayName, "displayName");
        p.i(summary, "summary");
        p.i(installKind, "installKind");
        p.i(installSource, "installSource");
        this.slug = slug;
        this.displayName = displayName;
        this.summary = summary;
        this.iconUrl = str;
        this.downloadCount = j10;
        this.installKind = installKind;
        this.installSource = installSource;
        this.enabled = z10;
        this.installedAt = j11;
        this.updatedAt = j12;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* renamed from: component10, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component4, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getInstallKind() {
        return this.installKind;
    }

    /* renamed from: component7, reason: from getter */
    public final String getInstallSource() {
        return this.installSource;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component9, reason: from getter */
    public final long getInstalledAt() {
        return this.installedAt;
    }

    public final InstalledSkillEntity copy(String slug, String displayName, String summary, String iconUrl, long downloadCount, String installKind, String installSource, boolean enabled, long installedAt, long updatedAt) {
        p.i(slug, "slug");
        p.i(displayName, "displayName");
        p.i(summary, "summary");
        p.i(installKind, "installKind");
        p.i(installSource, "installSource");
        return new InstalledSkillEntity(slug, displayName, summary, iconUrl, downloadCount, installKind, installSource, enabled, installedAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledSkillEntity)) {
            return false;
        }
        InstalledSkillEntity installedSkillEntity = (InstalledSkillEntity) other;
        return p.d(this.slug, installedSkillEntity.slug) && p.d(this.displayName, installedSkillEntity.displayName) && p.d(this.summary, installedSkillEntity.summary) && p.d(this.iconUrl, installedSkillEntity.iconUrl) && this.downloadCount == installedSkillEntity.downloadCount && p.d(this.installKind, installedSkillEntity.installKind) && p.d(this.installSource, installedSkillEntity.installSource) && this.enabled == installedSkillEntity.enabled && this.installedAt == installedSkillEntity.installedAt && this.updatedAt == installedSkillEntity.updatedAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getInstallKind() {
        return this.installKind;
    }

    public final String getInstallSource() {
        return this.installSource;
    }

    public final long getInstalledAt() {
        return this.installedAt;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = ((((this.slug.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.summary.hashCode()) * 31;
        String str = this.iconUrl;
        return ((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.downloadCount)) * 31) + this.installKind.hashCode()) * 31) + this.installSource.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Long.hashCode(this.installedAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "InstalledSkillEntity(slug=" + this.slug + ", displayName=" + this.displayName + ", summary=" + this.summary + ", iconUrl=" + this.iconUrl + ", downloadCount=" + this.downloadCount + ", installKind=" + this.installKind + ", installSource=" + this.installSource + ", enabled=" + this.enabled + ", installedAt=" + this.installedAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public /* synthetic */ InstalledSkillEntity(String str, String str2, String str3, String str4, long j10, String str5, String str6, boolean z10, long j11, long j12, int i10, i iVar) {
        this(str, str2, str3, str4, (i10 & 16) != 0 ? 0L : j10, str5, str6, (i10 & 128) != 0 ? true : z10, j11, j12);
    }
}
