package com.stepos.core.ota.install;

import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.storage.ModelsVersionStore;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.g;
import mb.l;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaBucketLegacy {
    public static final OtaBucketLegacy INSTANCE = new OtaBucketLegacy();

    private OtaBucketLegacy() {
    }

    public final LinkedHashSet<String> allBucketIds(String canonicalOtaId) {
        g.f(canonicalOtaId, "canonicalOtaId");
        String[] strArr = {canonicalOtaId};
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(v.a0(1));
        l.n0(strArr, linkedHashSet);
        return linkedHashSet;
    }

    public final void clearAllVersions(String canonicalOtaId) {
        g.f(canonicalOtaId, "canonicalOtaId");
        ModelsVersionStore modelsVersionStore = ModelsVersionStore.INSTANCE;
        modelsVersionStore.setVersionCode(canonicalOtaId, 0);
        modelsVersionStore.clearPluginsFor(canonicalOtaId);
    }

    public final int effectiveVersion(String canonicalOtaId) {
        g.f(canonicalOtaId, "canonicalOtaId");
        return ModelsVersionStore.INSTANCE.getVersionCode(canonicalOtaId);
    }

    public final String fetchNamesFor(String canonicalOtaId) {
        g.f(canonicalOtaId, "canonicalOtaId");
        return canonicalOtaId;
    }

    public final OtaRemoteModel resolveRemote(Map<String, OtaRemoteModel> results, String canonicalOtaId) {
        g.f(results, "results");
        g.f(canonicalOtaId, "canonicalOtaId");
        return results.get(canonicalOtaId);
    }
}
