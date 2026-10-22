package com.stepos.core.ota.domain.port;

import com.stepos.core.ota.domain.model.ModelManifest;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ManifestSource {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        /* renamed from: planUpdates-BWLJW6A$default, reason: not valid java name */
        public static /* synthetic */ Object m139planUpdatesBWLJW6A$default(ManifestSource manifestSource, String str, Set set, boolean z, b bVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: planUpdates-BWLJW6A");
            }
            if ((i10 & 4) != 0) {
                z = false;
            }
            return manifestSource.mo114planUpdatesBWLJW6A(str, set, z, bVar);
        }
    }

    ModelManifest cached(String str);

    /* renamed from: fetch-gIAlu-s */
    Object mo113fetchgIAlus(List<String> list, b<? super Result<? extends List<ModelManifest>>> bVar);

    /* renamed from: planUpdates-BWLJW6A */
    Object mo114planUpdatesBWLJW6A(String str, Set<String> set, boolean z, b<? super Result<? extends List<ModelManifest>>> bVar);
}
