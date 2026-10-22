package com.stepos.stepclaw.provider.backend;

import com.stepos.stepclaw.SecurePrefs;
import d6.b;
import f5.c;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH¦@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH¦@¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/provider/backend/IConfigStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/provider/backend/ConfigData;", "config", "Lb5/a0;", "save", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;Lf5/c;)Ljava/lang/Object;", "syncToRootfs", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "restoreFromBackup", "(Lf5/c;)Ljava/lang/Object;", "restoreWorkspaceFiles", "Ld6/b;", "getConfigFlow", "()Ld6/b;", "configFlow", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IConfigStore {
    b getConfigFlow();

    Object restoreFromBackup(c cVar);

    Object restoreWorkspaceFiles(c cVar);

    Object save(ConfigData configData, c cVar);

    void syncToRootfs(ConfigData config);
}
