package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R)\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018¨\u0006)"}, d2 = {"Lcom/bytedance/android/gamecp/business/DownloadDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "downloadingGameId", "Ljava/util/Set;", "getDownloadingGameId", "()Ljava/util/Set;", "downloadedGameId", "getDownloadedGameId", "installedGameId", "getInstalledGameId", "", "", "Lcom/bytedance/android/gamecp/base/core/service/depend/PlatformSupportPkg;", "searchPageGameChannelPkgMap", "Ljava/util/Map;", "getSearchPageGameChannelPkgMap", "()Ljava/util/Map;", "Lcom/bytedance/live/datacontext/m;", "", "hasDownloadedGame$delegate", "Lcom/bytedance/live/datacontext/p;", "getHasDownloadedGame", "()Lcom/bytedance/live/datacontext/m;", "hasDownloadedGame", "downloadedGameIconUri$delegate", "getDownloadedGameIconUri", "downloadedGameIconUri", "hasDownloadingGame$delegate", "getHasDownloadingGame", "hasDownloadingGame", "isAutoDownload$delegate", "isAutoDownload", "manualPauseGame$delegate", "getManualPauseGame", "manualPauseGame", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DownloadDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static volatile DownloadDataContext sharedDownloadDataContext;
    private final com.bytedance.live.datacontext.p downloadedGameIconUri$delegate;
    private final Set<String> downloadedGameId;
    private final Set<String> downloadingGameId;
    private final com.bytedance.live.datacontext.p hasDownloadedGame$delegate;
    private final com.bytedance.live.datacontext.p hasDownloadingGame$delegate;
    private final Set<String> installedGameId;
    private final com.bytedance.live.datacontext.p isAutoDownload$delegate;
    private final com.bytedance.live.datacontext.p manualPauseGame$delegate;
    private final Map<String, List<PlatformSupportPkg>> searchPageGameChannelPkgMap;

    public static final class a {
        public final DownloadDataContext a() {
            DownloadDataContext r100 = DownloadDataContext.access$getSharedDownloadDataContext$cp();
            if (r100 == null) goto L5;
            return r100;
        L5:
            monitor-enter(this);
            DownloadDataContext r101 = DownloadDataContext.access$getSharedDownloadDataContext$cp();     // Catch: Throwable -> L11
            if (r101 != null) goto L9;
            r101 = new DownloadDataContext();     // Catch: Throwable -> L11
            com.bytedance.live.datacontext.b.a(r101, DownloadDataContext.class);     // Catch: Throwable -> L11
            DownloadDataContext.access$setSharedDownloadDataContext$cp(r101);     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DownloadDataContext.class, "hasDownloadedGame", "getHasDownloadedGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DownloadDataContext.class, "downloadedGameIconUri", "getDownloadedGameIconUri()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DownloadDataContext.class, "hasDownloadingGame", "getHasDownloadingGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DownloadDataContext.class, "isAutoDownload", "isAutoDownload()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DownloadDataContext.class, "manualPauseGame", "getManualPauseGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.m<String> getDownloadedGameIconUri() {
        return (com.bytedance.live.datacontext.m) this.downloadedGameIconUri$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getHasDownloadedGame() {
        return (com.bytedance.live.datacontext.m) this.hasDownloadedGame$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getHasDownloadingGame() {
        return (com.bytedance.live.datacontext.m) this.hasDownloadingGame$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<String> getManualPauseGame() {
        return (com.bytedance.live.datacontext.m) this.manualPauseGame$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isAutoDownload() {
        return (com.bytedance.live.datacontext.m) this.isAutoDownload$delegate.a(this, $$delegatedProperties[3]);
    }

    public DownloadDataContext() {
        this.downloadingGameId = new LinkedHashSet();
        this.downloadedGameId = new LinkedHashSet();
        this.installedGameId = new LinkedHashSet();
        this.searchPageGameChannelPkgMap = new LinkedHashMap();
        Boolean r100 = Boolean.FALSE;
        this.hasDownloadedGame$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.downloadedGameIconUri$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.hasDownloadingGame$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.isAutoDownload$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.manualPauseGame$delegate = com.bytedance.live.datacontext.q.d(this, "");
    }

    public static final /* synthetic */ DownloadDataContext access$getSharedDownloadDataContext$cp() {
        return sharedDownloadDataContext;
    }

    public final Set<String> getDownloadedGameId() {
        return this.downloadedGameId;
    }

    public final Set<String> getDownloadingGameId() {
        return this.downloadingGameId;
    }

    public final Set<String> getInstalledGameId() {
        return this.installedGameId;
    }

    public final Map<String, List<PlatformSupportPkg>> getSearchPageGameChannelPkgMap() {
        return this.searchPageGameChannelPkgMap;
    }

    public static final /* synthetic */ void access$setSharedDownloadDataContext$cp(DownloadDataContext r100) {
        sharedDownloadDataContext = r100;
    }
}
