package com.stepos.core.ota.display;

import android.content.Context;
import com.stepos.core.ota.display.DisplayResourcePolicy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDisplayLookup {
    public static final ModelDisplayLookup INSTANCE = new ModelDisplayLookup();

    private ModelDisplayLookup() {
    }

    public static /* synthetic */ String resolveDir$default(ModelDisplayLookup modelDisplayLookup, Context context, String str, String str2, DisplayResourcePolicy.Use use, boolean z, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z = false;
        }
        return modelDisplayLookup.resolveDir(context, str, str2, use, z);
    }

    public final String readDir(Context context, String otaId, String bucketDir) {
        g.f(context, "context");
        g.f(otaId, "otaId");
        g.f(bucketDir, "bucketDir");
        return resolveDir$default(this, context, otaId, bucketDir, readUse(context, otaId), false, 16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ota.display.DisplayResourcePolicy.Use readUse(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r10 = "context"
            kotlin.jvm.internal.g.f(r11, r10)
            java.lang.String r10 = "otaId"
            kotlin.jvm.internal.g.f(r12, r10)
            com.stepos.core.ota.OtaEngine r10 = com.stepos.core.ota.OtaEngine.INSTANCE
            java.util.Set r10 = r10.getAbilityIdsForOta(r12)
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L1c
            java.util.Set r10 = mb.y.M(r12)
        L1c:
            java.util.Set r10 = (java.util.Set) r10
            com.stepos.core.ota.install.OtaBucketLegacy r0 = com.stepos.core.ota.install.OtaBucketLegacy.INSTANCE
            int r4 = r0.effectiveVersion(r12)
            com.stepos.core.ota.storage.UserUninstallStore r0 = com.stepos.core.ota.storage.UserUninstallStore.INSTANCE
            boolean r0 = r0.contains(r12)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L5a
            if (r4 <= 0) goto L5a
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            boolean r0 = r10 instanceof java.util.Collection
            if (r0 == 0) goto L40
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L40
            goto L5a
        L40:
            java.util.Iterator r10 = r10.iterator()
        L44:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L5a
            java.lang.Object r0 = r10.next()
            java.lang.String r0 = (java.lang.String) r0
            com.stepos.core.ota.install.InstalledPathResolver r3 = com.stepos.core.ota.install.InstalledPathResolver.INSTANCE
            boolean r0 = r3.isUsable(r0, r12, r2)
            if (r0 == 0) goto L44
            r3 = r1
            goto L5b
        L5a:
            r3 = r2
        L5b:
            com.stepos.core.ota.data.OtaRemoteModel r10 = com.stepos.core.ota.remote.RemoteModelsRepository.get(r12)
            r0 = r1
            com.stepos.core.ota.display.DisplayResourcePolicy r1 = com.stepos.core.ota.display.DisplayResourcePolicy.INSTANCE
            com.stepos.core.ota.install.PreInstallModels r5 = com.stepos.core.ota.install.PreInstallModels.INSTANCE
            boolean r5 = r5.isPreset(r12)
            if (r10 == 0) goto L6f
            r9 = r5
            r5 = r0
            r0 = r2
            r2 = r9
            goto L72
        L6f:
            r0 = r2
            r2 = r5
            r5 = r0
        L72:
            if (r10 == 0) goto L79
            java.lang.String r6 = r10.getResource_url()
            goto L7a
        L79:
            r6 = 0
        L7a:
            if (r10 == 0) goto L82
            int r10 = r10.getVersion_code()
            r7 = r10
            goto L83
        L82:
            r7 = r0
        L83:
            com.stepos.core.common.storage.InstalledModelMetaStore r10 = com.stepos.core.common.storage.InstalledModelMetaStore.INSTANCE
            java.lang.String r8 = r10.getDisplayKey(r11, r12)
            com.stepos.core.ota.display.DisplayResourcePolicy$Decision r10 = r1.decide(r2, r3, r4, r5, r6, r7, r8)
            com.stepos.core.ota.display.DisplayResourcePolicy$Use r10 = r10.getUse()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.display.ModelDisplayLookup.readUse(android.content.Context, java.lang.String):com.stepos.core.ota.display.DisplayResourcePolicy$Use");
    }

    public final String resolveDir(Context context, String otaId, String bucketDir, DisplayResourcePolicy.Use use, boolean z) {
        g.f(context, "context");
        g.f(otaId, "otaId");
        g.f(bucketDir, "bucketDir");
        g.f(use, "use");
        if (use.equals(DisplayResourcePolicy.Use.None.INSTANCE)) {
            if (z) {
                ModelDisplayResourceStore.purgeForeign$default(ModelDisplayResourceStore.INSTANCE, context, otaId, bucketDir, null, 8, null);
            }
            return "";
        }
        if (use.equals(DisplayResourcePolicy.Use.Lenient.INSTANCE)) {
            String strExistingDisplayDir$default = ModelDisplayResourceStore.existingDisplayDir$default(ModelDisplayResourceStore.INSTANCE, context, otaId, bucketDir, null, 8, null);
            return strExistingDisplayDir$default == null ? "" : strExistingDisplayDir$default;
        }
        if (!(use instanceof DisplayResourcePolicy.Use.Keyed)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            ModelDisplayResourceStore.INSTANCE.purgeForeign(context, otaId, bucketDir, ((DisplayResourcePolicy.Use.Keyed) use).getKey());
        }
        String strExistingDisplayDir = ModelDisplayResourceStore.INSTANCE.existingDisplayDir(context, otaId, bucketDir, ((DisplayResourcePolicy.Use.Keyed) use).getKey());
        return strExistingDisplayDir == null ? "" : strExistingDisplayDir;
    }
}
