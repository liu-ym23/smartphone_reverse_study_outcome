package com.android.server.permission.access;

import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.pm.pkg.PackageState;
import java.util.List;

/* JADX INFO: compiled from: AccessPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SchemePolicy {
    public abstract String getObjectScheme();

    public abstract String getSubjectScheme();

    public SchemePolicy() {
    }

    public void onStateMutated(GetStateScope $this$onStateMutated) {
    }

    public void onUserAdded(MutateStateScope $this$onUserAdded, int userId) {
    }

    public void onUserRemoved(MutateStateScope $this$onUserRemoved, int userId) {
    }

    public void onAppIdAdded(MutateStateScope $this$onAppIdAdded, int appId) {
    }

    public void onAppIdRemoved(MutateStateScope $this$onAppIdRemoved, int appId) {
    }

    public void onStorageVolumeMounted(MutateStateScope $this$onStorageVolumeMounted, String volumeUuid, List<String> r3, boolean isSystemUpdated) {
    }

    public void onPackageAdded(MutateStateScope $this$onPackageAdded, PackageState packageState) {
    }

    public void onPackageRemoved(MutateStateScope $this$onPackageRemoved, String packageName, int appId) {
    }

    public void onPackageInstalled(MutateStateScope $this$onPackageInstalled, PackageState packageState, int userId) {
    }

    public void onPackageUninstalled(MutateStateScope $this$onPackageUninstalled, String packageName, int appId, int userId) {
    }

    public void onSystemReady(MutateStateScope $this$onSystemReady) {
    }

    public void migrateSystemState(MutableAccessState state) {
    }

    public void migrateUserState(MutableAccessState state, int userId) {
    }

    public void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
    }

    public void parseSystemState(BinaryXmlPullParser $this$parseSystemState, MutableAccessState state) {
    }

    public void serializeSystemState(BinaryXmlSerializer $this$serializeSystemState, AccessState state) {
    }

    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
    }

    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
    }
}
