package com.stepos.taskrobot.appwhitelist.model;

import D7.C;
import M.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.tencent.mmkv.MMKV;
import f6.AbstractC1436a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "", "version", "", "updatedAt", "", "ttlSeconds", "apps", "", "Lcom/stepos/taskrobot/appwhitelist/model/AppEntry;", "fetchedAt", "", AppAgent.CONSTRUCT, "(ILjava/lang/String;ILjava/util/List;J)V", "getVersion", "()I", "getUpdatedAt", "()Ljava/lang/String;", "getTtlSeconds", "getApps", "()Ljava/util/List;", "getFetchedAt", "()J", "appsIndex", "", "getAppsIndex", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistManifest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WhitelistManifest EMPTY = new WhitelistManifest(-1, "", MMKV.ExpireInHour, EmptyList.f4893a, 0);
    private static final String TAG = "WhitelistManifest";
    private final List<AppEntry> apps;
    private final Map<String, AppEntry> appsIndex;
    private final long fetchedAt;
    private final int ttlSeconds;
    private final String updatedAt;
    private final int version;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "EMPTY", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "getEMPTY", "()Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "buildAppsIndex", "", "Lcom/stepos/taskrobot/appwhitelist/model/AppEntry;", "apps", "", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, AppEntry> buildAppsIndex(List<AppEntry> apps) {
            final List<AppEntry> list = apps;
            Map mapQ = a.Q(new C() { // from class: com.stepos.taskrobot.appwhitelist.model.WhitelistManifest$Companion$buildAppsIndex$$inlined$groupingBy$1
                @Override // D7.C
                public String keyOf(AppEntry element) {
                    return element.getAppName();
                }

                @Override // D7.C
                public Iterator<AppEntry> sourceIterator() {
                    return list.iterator();
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapQ.entrySet()) {
                if (((Number) entry.getValue()).intValue() > 1) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (!linkedHashMap.isEmpty()) {
                AbstractC1436a.e(WhitelistManifest.TAG, "duplicate appName in manifest, keeping first: " + linkedHashMap.keySet(), true);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(apps.size());
            for (AppEntry appEntry : apps) {
                if (!linkedHashMap2.containsKey(appEntry.getAppName())) {
                    linkedHashMap2.put(appEntry.getAppName(), appEntry);
                }
            }
            return linkedHashMap2;
        }

        public final WhitelistManifest getEMPTY() {
            return WhitelistManifest.EMPTY;
        }

        private Companion() {
        }
    }

    public WhitelistManifest(int i, String updatedAt, int i6, List<AppEntry> apps, long j5) {
        k.f(updatedAt, "updatedAt");
        k.f(apps, "apps");
        this.version = i;
        this.updatedAt = updatedAt;
        this.ttlSeconds = i6;
        this.apps = apps;
        this.fetchedAt = j5;
        this.appsIndex = INSTANCE.buildAppsIndex(apps);
    }

    public static /* synthetic */ WhitelistManifest copy$default(WhitelistManifest whitelistManifest, int i, String str, int i6, List list, long j5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = whitelistManifest.version;
        }
        if ((i10 & 2) != 0) {
            str = whitelistManifest.updatedAt;
        }
        if ((i10 & 4) != 0) {
            i6 = whitelistManifest.ttlSeconds;
        }
        if ((i10 & 8) != 0) {
            list = whitelistManifest.apps;
        }
        if ((i10 & 16) != 0) {
            j5 = whitelistManifest.fetchedAt;
        }
        long j6 = j5;
        return whitelistManifest.copy(i, str, i6, list, j6);
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

    public final List<AppEntry> component4() {
        return this.apps;
    }

    /* renamed from: component5, reason: from getter */
    public final long getFetchedAt() {
        return this.fetchedAt;
    }

    public final WhitelistManifest copy(int version, String updatedAt, int ttlSeconds, List<AppEntry> apps, long fetchedAt) {
        k.f(updatedAt, "updatedAt");
        k.f(apps, "apps");
        return new WhitelistManifest(version, updatedAt, ttlSeconds, apps, fetchedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistManifest)) {
            return false;
        }
        WhitelistManifest whitelistManifest = (WhitelistManifest) other;
        return this.version == whitelistManifest.version && k.b(this.updatedAt, whitelistManifest.updatedAt) && this.ttlSeconds == whitelistManifest.ttlSeconds && k.b(this.apps, whitelistManifest.apps) && this.fetchedAt == whitelistManifest.fetchedAt;
    }

    public final List<AppEntry> getApps() {
        return this.apps;
    }

    public final Map<String, AppEntry> getAppsIndex() {
        return this.appsIndex;
    }

    public final long getFetchedAt() {
        return this.fetchedAt;
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
        return Long.hashCode(this.fetchedAt) + androidx.appfunctions.metadata.a.e(this.apps, androidx.constraintlayout.core.dsl.a.a(this.ttlSeconds, B7.a.c(Integer.hashCode(this.version) * 31, 31, this.updatedAt), 31), 31);
    }

    public String toString() {
        int i = this.version;
        String str = this.updatedAt;
        int i6 = this.ttlSeconds;
        List<AppEntry> list = this.apps;
        long j5 = this.fetchedAt;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "WhitelistManifest(version=", ", updatedAt=", str, ", ttlSeconds=");
        sbK.append(i6);
        sbK.append(", apps=");
        sbK.append(list);
        sbK.append(", fetchedAt=");
        return androidx.constraintlayout.core.dsl.a.e(j5, ")", sbK);
    }
}
