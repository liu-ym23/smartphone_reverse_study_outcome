package com.android.server.om;

import android.content.om.OverlayInfo;
import android.content.om.OverlayableInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OverlayActorEnforcer {
    private final PackageManagerHelper mPackageManager;

    public static final enum ActorState extends Enum<ActorState> {
        private static final /* synthetic */ ActorState[] $VALUES = null;
        public static final ActorState ACTOR_NOT_FOUND = null;
        public static final ActorState ACTOR_NOT_PREINSTALLED = null;
        public static final ActorState ALLOWED = null;
        public static final ActorState ERROR_READING_OVERLAYABLE = null;
        public static final ActorState INVALID_ACTOR = null;
        public static final ActorState INVALID_OVERLAYABLE_ACTOR_NAME = null;
        public static final ActorState MISSING_ACTOR_NAME = null;
        public static final ActorState MISSING_LEGACY_PERMISSION = null;
        public static final ActorState MISSING_NAMESPACE = null;
        public static final ActorState MISSING_OVERLAYABLE = null;
        public static final ActorState MISSING_TARGET_OVERLAYABLE_NAME = null;
        public static final ActorState NO_NAMED_ACTORS = null;
        public static final ActorState NO_PACKAGES_FOR_UID = null;
        public static final ActorState TARGET_NOT_FOUND = null;
        public static final ActorState UNABLE_TO_GET_TARGET_OVERLAYABLE = null;

        private static /* synthetic */ ActorState[] $values() {
            return new ActorState[]{TARGET_NOT_FOUND, NO_PACKAGES_FOR_UID, MISSING_TARGET_OVERLAYABLE_NAME, MISSING_LEGACY_PERMISSION, ERROR_READING_OVERLAYABLE, UNABLE_TO_GET_TARGET_OVERLAYABLE, MISSING_OVERLAYABLE, INVALID_OVERLAYABLE_ACTOR_NAME, NO_NAMED_ACTORS, MISSING_NAMESPACE, MISSING_ACTOR_NAME, ACTOR_NOT_FOUND, ACTOR_NOT_PREINSTALLED, INVALID_ACTOR, ALLOWED};
        }

        private ActorState(String r1, int r2) {
            super(r1, r2);
        }

        public static ActorState valueOf(String name) {
            return (ActorState) Enum.valueOf(ActorState.class, name);
        }

        public static ActorState[] values() {
            return (ActorState[]) $VALUES.clone();
        }

        static {
            TARGET_NOT_FOUND = new ActorState("TARGET_NOT_FOUND", 0);
            NO_PACKAGES_FOR_UID = new ActorState("NO_PACKAGES_FOR_UID", 1);
            MISSING_TARGET_OVERLAYABLE_NAME = new ActorState("MISSING_TARGET_OVERLAYABLE_NAME", 2);
            MISSING_LEGACY_PERMISSION = new ActorState("MISSING_LEGACY_PERMISSION", 3);
            ERROR_READING_OVERLAYABLE = new ActorState("ERROR_READING_OVERLAYABLE", 4);
            UNABLE_TO_GET_TARGET_OVERLAYABLE = new ActorState("UNABLE_TO_GET_TARGET_OVERLAYABLE", 5);
            MISSING_OVERLAYABLE = new ActorState("MISSING_OVERLAYABLE", 6);
            INVALID_OVERLAYABLE_ACTOR_NAME = new ActorState("INVALID_OVERLAYABLE_ACTOR_NAME", 7);
            NO_NAMED_ACTORS = new ActorState("NO_NAMED_ACTORS", 8);
            MISSING_NAMESPACE = new ActorState("MISSING_NAMESPACE", 9);
            MISSING_ACTOR_NAME = new ActorState("MISSING_ACTOR_NAME", 10);
            ACTOR_NOT_FOUND = new ActorState("ACTOR_NOT_FOUND", 11);
            ACTOR_NOT_PREINSTALLED = new ActorState("ACTOR_NOT_PREINSTALLED", 12);
            INVALID_ACTOR = new ActorState("INVALID_ACTOR", 13);
            ALLOWED = new ActorState("ALLOWED", 14);
            $VALUES = $values();
        }
    }

    static Pair<String, ActorState> getPackageNameForActor(String actorUriString, Map<String, Map<String, String>> namedActors) {
        if (namedActors.isEmpty() == true) goto L5;
        Uri actorUri = Uri.parse(actorUriString);
        String actorScheme = actorUri.getScheme();
        List<String> actorPathSegments = actorUri.getPathSegments();
        if ("overlay".equals(actorScheme) == false) goto L22;
        if (CollectionUtils.size(actorPathSegments) != 1) goto L22;
        String actorNamespace = actorUri.getAuthority();
        Map<String, String> namespace = namedActors.get(actorNamespace);
        if (ArrayUtils.isEmpty(namespace) == true) goto L14;
        String actorName = actorPathSegments.get(0);
        String packageName = namespace.get(actorName);
        if (TextUtils.isEmpty(packageName) == false) goto L20;
        return Pair.create(null, ActorState.MISSING_ACTOR_NAME);
    L20:
        return Pair.create(packageName, ActorState.ALLOWED);
    L14:
        return Pair.create(null, ActorState.MISSING_NAMESPACE);
    L22:
        return Pair.create(null, ActorState.INVALID_OVERLAYABLE_ACTOR_NAME);
    L5:
        return Pair.create(null, ActorState.NO_NAMED_ACTORS);
    }

    public OverlayActorEnforcer(PackageManagerHelper packageManager) {
        this.mPackageManager = packageManager;
    }

    void enforceActor(OverlayInfo overlayInfo, String methodName, int callingUid, int userId) throws SecurityException {
        ActorState actorState = isAllowedActor(methodName, overlayInfo, callingUid, userId);
        if (actorState != ActorState.ALLOWED) goto L5;
        return;
    L5:
        String targetOverlayableName = overlayInfo.targetOverlayableName;
        StringBuilder r2 = new StringBuilder();
        r2.append("UID");
        r2.append(callingUid);
        r2.append(" is not allowed to call ");
        r2.append(methodName);
        r2.append(" for ");
        if (TextUtils.isEmpty(targetOverlayableName) == false) goto L8;
        String r3 = "";
    L9:
        r2.append(r3);
        r2.append(overlayInfo.targetPackageName);
        r2.append(" for user ");
        r2.append(userId);
        String errorMessage = r2.toString();
        Slog.w("OverlayManager", errorMessage + " because " + actorState);
        throw new SecurityException(errorMessage);
    L8:
        r3 = targetOverlayableName + " in ";
        goto L9
    }

    public ActorState isAllowedActor(String methodName, OverlayInfo overlayInfo, int callingUid, int userId) {
        switch(callingUid) {
            case 0: goto L75;
            case 1000: goto L75;
            default: goto L4;
        };
    L4:
        String targetPackageName = overlayInfo.targetPackageName;
        PackageState targetPkgState = this.mPackageManager.getPackageStateForUser(targetPackageName, userId);
        if (targetPkgState != null) goto L7;
        AndroidPackage r0 = null;
    L8:
        AndroidPackage targetPkg = r0;
        if (targetPkg != null) goto L13;
        return ActorState.TARGET_NOT_FOUND;
    L13:
        if (targetPkg.isDebuggable() == true) goto L15;
        String[] callingPackageNames = this.mPackageManager.getPackagesForUid(callingUid);
        if (ArrayUtils.isEmpty(callingPackageNames) == false) goto L21;
        return ActorState.NO_PACKAGES_FOR_UID;
    L21:
        if (ArrayUtils.contains(callingPackageNames, targetPackageName) == true) goto L23;
        String targetOverlayableName = overlayInfo.targetOverlayableName;
        if (TextUtils.isEmpty(targetOverlayableName) == false) goto L81;
        if (this.mPackageManager.doesTargetDefineOverlayable(targetPackageName, userId) == true) goto L29;
        this.mPackageManager.enforcePermission("android.permission.CHANGE_OVERLAY_PACKAGES", methodName);     // Catch: IOException -> L30 SecurityException -> L34
        return ActorState.ALLOWED;
    L36:
        return ActorState.MISSING_LEGACY_PERMISSION;
    L29:
        return ActorState.MISSING_TARGET_OVERLAYABLE_NAME;
    L38:
        return ActorState.ERROR_READING_OVERLAYABLE;
    L81:
        OverlayableInfo targetOverlayable = this.mPackageManager.getOverlayableForTarget(targetPackageName, targetOverlayableName, userId);     // Catch: IOException -> L71
        if (targetOverlayable == null) goto L43;
        String actor = targetOverlayable.actor;
        if (TextUtils.isEmpty(actor) == true) goto L79;
        Map<String, Map<String, String>> namedActors = this.mPackageManager.getNamedActors();
        Pair<String, ActorState> actorUriPair = getPackageNameForActor(actor, namedActors);
        ActorState actorUriState = (ActorState) actorUriPair.second;
        if (actorUriState == ActorState.ALLOWED) goto L54;
        return actorUriState;
    L54:
        String actorPackageName = (String) actorUriPair.first;
        PackageState actorPackageState = this.mPackageManager.getPackageStateForUser(actorPackageName, userId);
        if (actorPackageState == null) goto L70;
        if (actorPackageState.getAndroidPackage() == null) goto L70;
        if (actorPackageState.isSystem() == true) goto L64;
        return ActorState.ACTOR_NOT_PREINSTALLED;
    L64:
        if (ArrayUtils.contains(callingPackageNames, actorPackageName) == false) goto L68;
        return ActorState.ALLOWED;
    L68:
        return ActorState.INVALID_ACTOR;
    L70:
        return ActorState.ACTOR_NOT_FOUND;
    L79:
        this.mPackageManager.enforcePermission("android.permission.CHANGE_OVERLAY_PACKAGES", methodName);     // Catch: SecurityException -> L48
        return ActorState.ALLOWED;
    L50:
        return ActorState.MISSING_LEGACY_PERMISSION;
    L43:
        return ActorState.MISSING_OVERLAYABLE;
    L73:
        return ActorState.UNABLE_TO_GET_TARGET_OVERLAYABLE;
    L23:
        return ActorState.ALLOWED;
    L15:
        return ActorState.ALLOWED;
    L7:
        r0 = targetPkgState.getAndroidPackage();
        goto L8
    L75:
        return ActorState.ALLOWED;
    }
}
