package com.stepos.taskrobot.appwhitelist.remote.dto;

import D7.w;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.model.WhitelistManifest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J9\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "", "version", "", "updatedAt", "", "ttlSeconds", "apps", "", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/AppEntryDto;", AppAgent.CONSTRUCT, "(ILjava/lang/String;ILjava/util/List;)V", "getVersion", "()I", "getUpdatedAt", "()Ljava/lang/String;", "getTtlSeconds", "getApps", "()Ljava/util/List;", "toManifest", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "fetchedAt", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistManifestDto {
    private final List<AppEntryDto> apps;
    private final int ttlSeconds;
    private final String updatedAt;
    private final int version;

    public WhitelistManifestDto(int i, String updatedAt, int i6, List<AppEntryDto> list) {
        k.f(updatedAt, "updatedAt");
        this.version = i;
        this.updatedAt = updatedAt;
        this.ttlSeconds = i6;
        this.apps = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistManifestDto copy$default(WhitelistManifestDto whitelistManifestDto, int i, String str, int i6, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = whitelistManifestDto.version;
        }
        if ((i10 & 2) != 0) {
            str = whitelistManifestDto.updatedAt;
        }
        if ((i10 & 4) != 0) {
            i6 = whitelistManifestDto.ttlSeconds;
        }
        if ((i10 & 8) != 0) {
            list = whitelistManifestDto.apps;
        }
        return whitelistManifestDto.copy(i, str, i6, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTtlSeconds() {
        return this.ttlSeconds;
    }

    public final List<AppEntryDto> component4() {
        return this.apps;
    }

    public final WhitelistManifestDto copy(int version, String updatedAt, int ttlSeconds, List<AppEntryDto> apps) {
        k.f(updatedAt, "updatedAt");
        return new WhitelistManifestDto(version, updatedAt, ttlSeconds, apps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistManifestDto)) {
            return false;
        }
        WhitelistManifestDto whitelistManifestDto = (WhitelistManifestDto) other;
        return this.version == whitelistManifestDto.version && k.b(this.updatedAt, whitelistManifestDto.updatedAt) && this.ttlSeconds == whitelistManifestDto.ttlSeconds && k.b(this.apps, whitelistManifestDto.apps);
    }

    public final List<AppEntryDto> getApps() {
        return this.apps;
    }

    public final int getTtlSeconds() {
        return this.ttlSeconds;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iA = a.a(this.ttlSeconds, B7.a.c(Integer.hashCode(this.version) * 31, 31, this.updatedAt), 31);
        List<AppEntryDto> list = this.apps;
        return iA + (list == null ? 0 : list.hashCode());
    }

    public final WhitelistManifest toManifest(long fetchedAt) {
        int i = this.version;
        String str = this.updatedAt;
        int i6 = this.ttlSeconds;
        Iterable iterable = this.apps;
        if (iterable == null) {
            iterable = EmptyList.f4893a;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(w.c0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppEntryDto) it.next()).toModel());
        }
        return new WhitelistManifest(i, str, i6, arrayList, fetchedAt);
    }

    public String toString() {
        int i = this.version;
        String str = this.updatedAt;
        int i6 = this.ttlSeconds;
        List<AppEntryDto> list = this.apps;
        StringBuilder sbK = a.k(i, "WhitelistManifestDto(version=", ", updatedAt=", str, ", ttlSeconds=");
        sbK.append(i6);
        sbK.append(", apps=");
        sbK.append(list);
        sbK.append(")");
        return sbK.toString();
    }

    public /* synthetic */ WhitelistManifestDto(int i, String str, int i6, List list, int i10, e eVar) {
        this(i, str, i6, (i10 & 8) != 0 ? null : list);
    }
}
