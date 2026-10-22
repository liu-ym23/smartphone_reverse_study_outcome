package com.stepos.core.ability.speech;

import com.stepos.base.ability.ApplyScope;
import com.stepos.core.common.util.AsrParamKeys;
import com.stepos.core.data.ContentParams;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSegmentationResolver {
    public static final AsrSegmentationResolver INSTANCE = new AsrSegmentationResolver();

    private AsrSegmentationResolver() {
    }

    public final int maxCharsFor(p6.i iVar, String str, ContentParams contentParams, ApplyScope scope) {
        kotlin.jvm.internal.g.f(scope, "scope");
        p6.i iVarResolve = resolve(iVar, str, contentParams);
        iVarResolve.getClass();
        int i10 = iVarResolve.f11443a;
        if (i10 <= 0) {
            return 0;
        }
        ApplyScope applyScope = iVarResolve.f11445c;
        if (applyScope == ApplyScope.f6189b || applyScope == scope) {
            return i10;
        }
        return 0;
    }

    public final p6.i resolve(p6.i iVar, String str, ContentParams contentParams) {
        p6.i iVar2;
        if (iVar == null) {
            iVar = p6.i.f11442e;
        }
        iVar.getClass();
        if (str != null) {
            if (gc.q.t0(str) || str.equals("unknown")) {
                str = null;
            }
            if (str != null && (iVar2 = iVar.f11446d.get(str)) != null) {
                iVar = iVar2;
            }
        }
        int i10 = iVar.f11444b;
        int i11 = iVar.f11443a;
        if (contentParams == null) {
            return iVar;
        }
        if (contentParams.containsKey(AsrParamKeys.REALTIME_SEGMENTATION_MAX_CHARS)) {
            i11 = contentParams.getInt(AsrParamKeys.REALTIME_SEGMENTATION_MAX_CHARS, i11);
        }
        if (contentParams.containsKey(AsrParamKeys.REALTIME_SEGMENTATION_PUNCT_WINDOW)) {
            i10 = contentParams.getInt(AsrParamKeys.REALTIME_SEGMENTATION_PUNCT_WINDOW, i10);
        }
        return p6.i.a(iVar, i11, i10, null, 12);
    }
}
