package com.android.server.om;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class OverlayReferenceMapper {
    private static final String TAG = "OverlayReferenceMapper";
    private final ArrayMap<String, Set<String>> mActorPkgToPkgs;
    private final ArrayMap<String, ArrayMap<String, ArraySet<String>>> mActorToTargetToOverlays;
    private boolean mDeferRebuild;
    private final Object mLock;
    private final Provider mProvider;

    public interface Provider {
        String getActorPkg(String r1);

        Pair<String, String> getTargetToOverlayables(AndroidPackage r1);
    }

    public OverlayReferenceMapper(boolean deferRebuild, Provider provider) {
        this.mLock = new Object();
        this.mActorToTargetToOverlays = new ArrayMap();
        this.mActorPkgToPkgs = new ArrayMap();
        this.mDeferRebuild = deferRebuild;
        if (provider == null) goto L5;
        Provider r0 = provider;
    L6:
        this.mProvider = r0;
        return;
    L5:
        r0 = new AnonymousClass1(this);
        goto L6
    }

    public Map<String, Set<String>> getActorPkgToPkgs() {
        return this.mActorPkgToPkgs;
    }

    public boolean isValidActor(String targetName, String actorPackageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ensureMapBuilt();     // Catch: Throwable -> L9
        Set<String> validSet = this.mActorPkgToPkgs.get(actorPackageName);     // Catch: Throwable -> L9
        if (validSet != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (validSet.contains(targetName) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public ArraySet<String> addPkg(AndroidPackage pkg, Map<String, AndroidPackage> otherPkgs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<String> changed = new ArraySet();     // Catch: Throwable -> L7
        if (pkg.getOverlayables().isEmpty() == true) goto L10;
        addTarget(pkg, otherPkgs, changed);     // Catch: Throwable -> L7
    L10:
        if (this.mProvider.getTargetToOverlayables(pkg) == null) goto L13;
        addOverlay(pkg, otherPkgs, changed);     // Catch: Throwable -> L7
    L13:
        if (this.mDeferRebuild == true) goto L15;
        rebuild();     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return changed;
    L7:
        th = move-exception;
        throw th;
    }

    public ArraySet<String> removePkg(String pkgName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<String> changedPackages = new ArraySet();     // Catch: Throwable -> L7
        removeTarget(pkgName, changedPackages);     // Catch: Throwable -> L7
        removeOverlay(pkgName, changedPackages);     // Catch: Throwable -> L7
        if (this.mDeferRebuild == true) goto L9;
        rebuild();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return changedPackages;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeTarget(String target, Collection<String> changedPackages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mActorToTargetToOverlays.size();     // Catch: Throwable -> L11
        int index = size - 1;     // Catch: Throwable -> L11
    L5:
        if (index < 0) goto L15;
        ArrayMap<String, ArraySet<String>> targetToOverlays = this.mActorToTargetToOverlays.valueAt(index);     // Catch: Throwable -> L11
        if (targetToOverlays.containsKey(target) == false) goto L13;
        targetToOverlays.remove(target);     // Catch: Throwable -> L11
        String actor = this.mActorToTargetToOverlays.keyAt(index);     // Catch: Throwable -> L11
        changedPackages.add(this.mProvider.getActorPkg(actor));     // Catch: Throwable -> L11
        if (targetToOverlays.isEmpty() == false) goto L13;
        this.mActorToTargetToOverlays.removeAt(index);     // Catch: Throwable -> L11
    L13:
        index = index - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void addTarget(AndroidPackage targetPkg, Map<String, AndroidPackage> otherPkgs, Collection<String> changedPackages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String target = targetPkg.getPackageName();     // Catch: Throwable -> L17
        removeTarget(target, changedPackages);     // Catch: Throwable -> L17
        Map<String, String> overlayablesToActors = targetPkg.getOverlayables();     // Catch: Throwable -> L17
        Iterator<Map.Entry<String, String>> r3 = overlayablesToActors.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r3.hasNext() == false) goto L21;
        Map.Entry<String, String> entry = r3.next();     // Catch: Throwable -> L17
        String overlayable = entry.getKey();     // Catch: Throwable -> L17
        String actor = entry.getValue();     // Catch: Throwable -> L17
        addTargetToMap(actor, target, changedPackages);     // Catch: Throwable -> L17
        Iterator<AndroidPackage> r7 = otherPkgs.values().iterator();     // Catch: Throwable -> L17
    L9:
        if (r7.hasNext() == false) goto L6;
        AndroidPackage overlayPkg = r7.next();     // Catch: Throwable -> L17
        Pair<String, String> targetToOverlayables = this.mProvider.getTargetToOverlayables(overlayPkg);     // Catch: Throwable -> L17
        if (targetToOverlayables == null) goto L9;
        if (((String) targetToOverlayables.first).equals(target) == false) goto L9;
        if (Objects.equals(targetToOverlayables.second, overlayable) == false) goto L9;
        String overlay = overlayPkg.getPackageName();     // Catch: Throwable -> L17
        addOverlayToMap(actor, target, overlay, changedPackages);     // Catch: Throwable -> L17
        goto L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void removeOverlay(String overlay, Collection<String> changedPackages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int actorsSize = this.mActorToTargetToOverlays.size();     // Catch: Throwable -> L11
        int actorIndex = actorsSize - 1;     // Catch: Throwable -> L11
    L5:
        if (actorIndex < 0) goto L19;
        ArrayMap<String, ArraySet<String>> targetToOverlays = this.mActorToTargetToOverlays.valueAt(actorIndex);     // Catch: Throwable -> L11
        int targetsSize = targetToOverlays.size();     // Catch: Throwable -> L11
        int targetIndex = targetsSize - 1;     // Catch: Throwable -> L11
    L7:
        if (targetIndex < 0) goto L15;
        Set<String> overlays = targetToOverlays.valueAt(targetIndex);     // Catch: Throwable -> L11
        if (overlays.remove(overlay) == false) goto L13;
        String actor = this.mActorToTargetToOverlays.keyAt(actorIndex);     // Catch: Throwable -> L11
        changedPackages.add(this.mProvider.getActorPkg(actor));     // Catch: Throwable -> L11
    L13:
        targetIndex = targetIndex - 1;     // Catch: Throwable -> L11
        goto L7
    L15:
        if (targetToOverlays.isEmpty() == false) goto L17;
        this.mActorToTargetToOverlays.removeAt(actorIndex);     // Catch: Throwable -> L11
    L17:
        actorIndex = actorIndex - 1;     // Catch: Throwable -> L11
        goto L5
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void addOverlay(AndroidPackage overlayPkg, Map<String, AndroidPackage> otherPkgs, Collection<String> changedPackages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String overlay = overlayPkg.getPackageName();     // Catch: Throwable -> L10
        removeOverlay(overlay, changedPackages);     // Catch: Throwable -> L10
        Pair<String, String> targetToOverlayables = this.mProvider.getTargetToOverlayables(overlayPkg);     // Catch: Throwable -> L10
        if (targetToOverlayables == null) goto L17;
        String target = (String) targetToOverlayables.first;     // Catch: Throwable -> L10
        AndroidPackage targetPkg = otherPkgs.get(target);     // Catch: Throwable -> L10
        if (targetPkg != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        String targetPkgName = targetPkg.getPackageName();     // Catch: Throwable -> L10
        Map<String, String> overlayableToActor = targetPkg.getOverlayables();     // Catch: Throwable -> L10
        String overlayable = (String) targetToOverlayables.second;     // Catch: Throwable -> L10
        String actor = overlayableToActor.get(overlayable);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(actor) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L16:
        addOverlayToMap(actor, targetPkgName, overlay, changedPackages);     // Catch: Throwable -> L10
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void rebuildIfDeferred() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeferRebuild == false) goto L9;
        rebuild();     // Catch: Throwable -> L7
        this.mDeferRebuild = false;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void ensureMapBuilt() {
        if (this.mDeferRebuild == false) goto L6;
        rebuildIfDeferred();
        Slog.w(TAG, "The actor map was queried before the system was ready, which mayresult in decreased performance.");
        return;
    }

    private void rebuild() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActorPkgToPkgs.clear();     // Catch: Throwable -> L14
        Iterator<String> r1 = this.mActorToTargetToOverlays.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L17;
        String actor = r1.next();     // Catch: Throwable -> L14
        String actorPkg = this.mProvider.getActorPkg(actor);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(actorPkg) == true) goto L6;
        ArrayMap<String, ArraySet<String>> targetToOverlays = this.mActorToTargetToOverlays.get(actor);     // Catch: Throwable -> L14
        Set<String> pkgs = new HashSet();     // Catch: Throwable -> L14
        Iterator<String> r6 = targetToOverlays.keySet().iterator();     // Catch: Throwable -> L14
    L12:
        if (r6.hasNext() == false) goto L16;
        String target = r6.next();     // Catch: Throwable -> L14
        Set<String> overlays = targetToOverlays.get(target);     // Catch: Throwable -> L14
        pkgs.add(target);     // Catch: Throwable -> L14
        pkgs.addAll(overlays);     // Catch: Throwable -> L14
        goto L12
    L16:
        this.mActorPkgToPkgs.put(actorPkg, pkgs);     // Catch: Throwable -> L14
        goto L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void addTargetToMap(String actor, String target, Collection<String> changedPackages) {
        ArrayMap<String, ArraySet<String>> targetToOverlays = this.mActorToTargetToOverlays.get(actor);
        if (targetToOverlays != null) goto L5;
        targetToOverlays = new ArrayMap();
        this.mActorToTargetToOverlays.put(actor, targetToOverlays);
    L5:
        ArraySet<String> overlays = targetToOverlays.get(target);
        if (overlays != null) goto L8;
        ArraySet<String> overlays2 = new ArraySet();
        targetToOverlays.put(target, overlays2);
    L8:
        changedPackages.add(this.mProvider.getActorPkg(actor));
    }

    private void addOverlayToMap(String actor, String target, String overlay, Collection<String> changedPackages) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArraySet<String>> targetToOverlays = this.mActorToTargetToOverlays.get(actor);     // Catch: Throwable -> L7
        if (targetToOverlays != null) goto L9;
        targetToOverlays = new ArrayMap();     // Catch: Throwable -> L7
        this.mActorToTargetToOverlays.put(actor, targetToOverlays);     // Catch: Throwable -> L7
    L9:
        ArraySet<String> overlays = targetToOverlays.get(target);     // Catch: Throwable -> L7
        if (overlays != null) goto L12;
        overlays = new ArraySet();     // Catch: Throwable -> L7
        targetToOverlays.put(target, overlays);     // Catch: Throwable -> L7
    L12:
        overlays.add(overlay);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        changedPackages.add(this.mProvider.getActorPkg(actor));
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
