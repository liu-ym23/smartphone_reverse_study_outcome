package com.stepos.core.ota.domain;

import com.stepos.core.ota.domain.model.ModelManifest;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadPlanFallback {
    public static final DownloadPlanFallback INSTANCE = new DownloadPlanFallback();

    private DownloadPlanFallback() {
    }

    public final boolean hasUsableUrl(List<ModelManifest> plan) {
        g.f(plan, "plan");
        if (plan.isEmpty()) {
            return false;
        }
        Iterator<T> it = plan.iterator();
        while (it.hasNext()) {
            if (!q.t0(((ModelManifest) it.next()).getUrl())) {
                return true;
            }
        }
        return false;
    }

    public final <T> T pickLatestOrCached(T t8, String str, T t10, String str2) {
        return ((t8 != null && str != null && !q.t0(str)) || t10 == null || str2 == null || q.t0(str2)) ? t8 : t10;
    }

    public final List<ModelManifest> resolve(List<ModelManifest> fresh, List<ModelManifest>... fallbacks) {
        g.f(fresh, "fresh");
        g.f(fallbacks, "fallbacks");
        List<ModelManifest> listUsable = usable(fresh);
        if (listUsable.isEmpty()) {
            for (List<ModelManifest> list : fallbacks) {
                List<ModelManifest> listUsable2 = usable(list);
                if (!listUsable2.isEmpty()) {
                    return listUsable2;
                }
            }
        }
        return listUsable;
    }

    public final List<ModelManifest> usable(List<ModelManifest> plan) {
        g.f(plan, "plan");
        ArrayList arrayList = new ArrayList();
        for (Object obj : plan) {
            if (!q.t0(((ModelManifest) obj).getUrl())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
