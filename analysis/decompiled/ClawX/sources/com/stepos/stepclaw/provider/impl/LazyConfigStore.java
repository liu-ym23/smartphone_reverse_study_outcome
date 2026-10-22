package com.stepos.stepclaw.provider.impl;

import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.ConfigData;
import com.stepos.stepclaw.provider.backend.IConfigStore;
import d6.b;
import f5.c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/provider/impl/LazyConfigStore;", "Lcom/stepos/stepclaw/provider/backend/IConfigStore;", "Lkotlin/Function0;", "Landroid/content/Context;", "contextSupplier", "<init>", "(Lp5/a;)V", "Lcom/stepos/stepclaw/provider/impl/DataStoreConfigStore;", "getDelegate", "()Lcom/stepos/stepclaw/provider/impl/DataStoreConfigStore;", "Lcom/stepos/stepclaw/provider/backend/ConfigData;", "config", "Lb5/a0;", "save", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;Lf5/c;)Ljava/lang/Object;", "syncToRootfs", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "restoreFromBackup", "(Lf5/c;)Ljava/lang/Object;", "restoreWorkspaceFiles", "Lp5/a;", "delegate", "Lcom/stepos/stepclaw/provider/impl/DataStoreConfigStore;", "Ld6/b;", "getConfigFlow", "()Ld6/b;", "configFlow", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyConfigStore implements IConfigStore {
    private final a contextSupplier;
    private volatile DataStoreConfigStore delegate;

    public LazyConfigStore(a contextSupplier) {
        p.e(contextSupplier, "contextSupplier");
        this.contextSupplier = contextSupplier;
    }

    private final DataStoreConfigStore getDelegate() {
        DataStoreConfigStore dataStoreConfigStore;
        DataStoreConfigStore dataStoreConfigStore2 = this.delegate;
        if (dataStoreConfigStore2 != null) {
            return dataStoreConfigStore2;
        }
        synchronized (this) {
            dataStoreConfigStore = this.delegate;
            if (dataStoreConfigStore == null) {
                Context applicationContext = ((Context) this.contextSupplier.invoke()).getApplicationContext();
                p.d(applicationContext, "getApplicationContext(...)");
                dataStoreConfigStore = new DataStoreConfigStore(applicationContext);
                this.delegate = dataStoreConfigStore;
            }
        }
        return dataStoreConfigStore;
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public b getConfigFlow() {
        return getDelegate().getConfigFlow();
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object restoreFromBackup(c cVar) {
        return getDelegate().restoreFromBackup(cVar);
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object restoreWorkspaceFiles(c cVar) {
        return getDelegate().restoreWorkspaceFiles(cVar);
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object save(ConfigData configData, c cVar) {
        Object objSave = getDelegate().save(configData, cVar);
        return objSave == g5.a.f2984a ? objSave : a0.f883a;
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public void syncToRootfs(ConfigData config) {
        p.e(config, "config");
        getDelegate().syncToRootfs(config);
    }
}
